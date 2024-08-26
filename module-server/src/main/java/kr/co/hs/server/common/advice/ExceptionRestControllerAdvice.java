package kr.co.hs.server.common.advice;


import kr.co.hs.server.common.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.NoSuchFileException;

import static org.springframework.http.HttpStatus.*;

/**
 * Exception Rest Controller Advice
 * <p>
 * This class is a controller advice that handles exceptions thrown from controllers.
 * It provides methods to handle specific types of exceptions and return appropriate response.
 *
 * @author hyoyoung-jung
 * @author seokbin-yoon
 * @version 0.0.1
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionRestControllerAdvice {
    private final MultipartProperties multipartProperties;

    /**
     * Handles error exceptions and returns a Result object with a failure message and HTTP status code.
     *
     * @param e the exception that occurred
     * @return a Result object containing the failure message and HTTP status code
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({
            DuplicateKeyException.class,
            IllegalStateException.class,
            IllegalArgumentException.class,
            NoSuchFileException.class,
            IOException.class,
            UnknownHostException.class
    })
    public Result<?> errorBy(Exception e) {
        log.error(e.getMessage(), e);
        return Result.failure(e.getMessage(), BAD_REQUEST.value());
    }

    /**
     * Handles validation errors and returns a response with an error message.
     *
     * @param e The BindException containing the validation errors.
     * @return A Result object with the error message and HTTP status code.
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public Result<?> errorByValidation(BindException e) {
        log.error(e.getMessage(), e);
        return Result.failure(
                e.getBindingResult().getAllErrors().getFirst().getDefaultMessage(),
                BAD_REQUEST.value()
        );
    }

    /**
     * Handles the exception thrown when a request is missing a required parameter.
     *
     * @param e The exception object representing the missing parameter exception.
     * @return A Result object with the failure message and the HTTP status code.
     */
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<?> errorByMissingParameter(MissingServletRequestParameterException e) {
        log.error("[{}] 항목은 필수입니다.", e.getParameterName());
        return Result.failure(e.getMessage(), BAD_REQUEST.value());
    }

    /**
     * Handles the exception when the maximum upload size is exceeded.
     *
     * @param e The {@code MaxUploadSizeExceededException} that occurred.
     * @return The result of the error handling, containing a failure message indicating the maximum upload size.
     */
    @ResponseStatus(PAYLOAD_TOO_LARGE)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result<?> errorByMaxUploadSize(MaxUploadSizeExceededException e) {
        log.error(e.getMessage(), e);
        // tomcat에서 에러 발생 후, 최종적으로 스프링에서 MultipartException의 하위 타입인 MaxUploadSizeExceededException을 뱉는다.(ControllerAdvice에서 단독 처리 불가)
        if (e.getRootCause() instanceof FileSizeLimitExceededException) {
            return Result.failure("파일 당 업로드 할 수 있는 최대 용량은 " + multipartProperties.getMaxFileSize().toMegabytes() + "MB 입니다.", PAYLOAD_TOO_LARGE.value());
        }
        return Result.failure("업로드 할 수 있는 최대 용량은 " + multipartProperties.getMaxRequestSize().toMegabytes() + "MB 입니다.", PAYLOAD_TOO_LARGE.value());
    }

    /**
     * Handles the exception caused by unsupported media type.
     *
     * @param e The exception object representing the unsupported media type error.
     * @return The Result object containing the error message and status code.
     */
    @ResponseStatus(UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(UnsupportedMediaTypeStatusException.class)
    public Result<?> errorByUnsupportedMediaType(Exception e) {
        log.error(e.getMessage(), e);
        return Result.failure(ExceptionType.UNSUPPORTED_MEDIA_TYPE.getMessage(), UNSUPPORTED_MEDIA_TYPE.value());
    }

    /**
     * Handles and logs an exception, and returns a failure Result object with an internal server error status.
     *
     * @param e The exception that occurred
     * @return A Result object representing the failure with an internal server error status.
     */
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result<?> error(Exception e) {
        log.error(e.getMessage(), e);
        return Result.failure(ExceptionType.SERVER.getMessage(), INTERNAL_SERVER_ERROR.value());
    }
}
