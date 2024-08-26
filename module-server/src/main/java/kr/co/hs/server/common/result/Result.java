package kr.co.hs.server.common.result;


import org.springframework.http.HttpStatus;

/**
 * API Result 레코드 클래스
 *
 * @param success 성공여부
 * @param status  HttpStatus Code
 * @param body    결과값
 * @param message 성공 및 실패 메세지
 * @param <T>     generic(주로 view에 해당하는 DTO 클래스)
 * @author hyoyoung-jung
 * @version 2.1
 * @see Result#successWithoutBody()
 * @see Result#success(Object)
 * @see Result#failure(String, int)
 * @see Result#failure(String)
 * @see Result#failure()
 * @see Result#get(Result)
 */
public record Result<T>(
        boolean success,
        int status,
        T body,
        String message) {
    /**
     * body, message 없이 success(true)만 담아 Result 리턴
     *
     * @param <T> generic
     * @return Result
     */
    public static <T> Result<T> successWithoutBody() {
        return new Result<>(true, HttpStatus.OK.value(), null, null);
    }

    /**
     * message 없이 success(true)와 body를 담아 Result 리턴
     *
     * @param body 결과값
     * @param <T>  generic
     * @return Result
     */
    public static <T> Result<T> success(T body) {
        return new Result<>(true, HttpStatus.OK.value(), body, null);
    }

    /**
     * body 없이 success(false)와 message를 담아 Result 리턴
     * 기본 실패 status 400(BAD_REQUEST)
     *
     * @param message 실패 관련 message
     * @param <T>     generic
     * @return Result
     */
    public static <T> Result<T> failure(String message) {
        return new Result<>(false, HttpStatus.BAD_REQUEST.value(), null, message);
    }

    /**
     * body 없이 success(false)와 message, HttpsStatus Code를 담아 Result 리턴
     *
     * @param message 실패 관련 message
     * @param status  HttpStatus Code
     * @param <T>     generic
     * @return Result
     */
    public static <T> Result<T> failure(String message, int status) {
        return new Result<>(false, status, null, message);
    }

    /**
     * 실패에 대한 boolean값 리턴
     *
     * @return boolean(false)
     */
    public boolean failure() {
        return !success;
    }

    /**
     * body를 리턴
     *
     * @return body
     * @throws IllegalStateException failure() 즉, 실패 상태일 경우
     */
    public T get() {
        if (failure()) {
            throw new IllegalStateException(message);
        }
        return body;
    }
}
