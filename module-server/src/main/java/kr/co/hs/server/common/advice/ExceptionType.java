package kr.co.hs.server.common.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Exception Message Enum Class
 *
 * @author hyoyoung-jung
 * @version 2.1
 */
@AllArgsConstructor
@Getter
public enum ExceptionType {
    /**
     * 서버 에러
     */
    SERVER("서버 에러가 발생하였습니다."),
    /**
     * 키 값이 중복되었을 경우
     */
    DUPLICATE_KEY("이미 등록된 값입니다."),
    /**
     * 지원하지 않는 미디어 포맷 에러
     */
    UNSUPPORTED_MEDIA_TYPE("지원하지 않는 미디어 포맷입니다."),
    /**
     * 통신 불안정
     */
    API_UNSTABLE("통신이 불안정합니다. 잠시 후 다시 시도해주세요"),
    /**
     * 통신 결과 불안정
     */
    API_UNSTABLE_RESULT("통신 결과가 불안정합니다. 잠시 후 다시 시도해주세요"),
    /**
     * 암호화 에러 발생
     */
    ENCRYPTION("암호화 도중 에러가 발생하였습니다."),
    /**
     * 암/복호화 에러 발생
     */
    CRYPTOGRAPHY("암/복호화 도중 에러가 발생하였습니다."),
    /**
     * 잘못된 값 에러 발생
     */
    INVALID_VALUE("잘못된 값이 입력되었습니다."),
    /**
     * 값이 존재하지 않음
     */
    NO_VALUE("값이 존재하지 않습니다.");

    private final String message;
}
