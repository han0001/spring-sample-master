package kr.co.hs.util.date;

import java.time.format.DateTimeFormatter;

/**
 * Date 관련 Util
 * <p/>
 *
 * @author      sangwon-han
 * @version     0.0.1
 *
 * */
public final class DateUtil {

    /** date formatter - yyyyMM ex) 202327 */
    public static final DateTimeFormatter YEAR_MONTH =  DateTimeFormatter.ofPattern("yyyyMM");
    /** date formatter - yyyyMMdd ex) 20230727 */
    public static final DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyyMMdd");
    /** time formatter - HHmmss ex) 151101 */
    public static final DateTimeFormatter TIME = DateTimeFormatter.ofPattern("HHmmss");
    /** datetime formatter - yyyyMMddHHmmss ex) 20230727151101 */
    public static final DateTimeFormatter DATETIME = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    /** date formatter with dash - yyyy-MM-dd ex) 2023-07-27 */
    public static final DateTimeFormatter DATE_DASH = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /** time formatter with colon - HH:mm:ss ex) 15:11:01 */
    public static final DateTimeFormatter TIME_COLON = DateTimeFormatter.ofPattern("HH:mm:ss");
    /** datetime formatter with default pattern - yyyy-MM-dd HH:mm:ss ex) 2023-07-27 15:11:01 */
    public static final DateTimeFormatter DATETIME_DEFAULT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


}
