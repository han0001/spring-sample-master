package kr.co.hs.domain.constant.legacy;

import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumSet;


/**
 * {@link LegacyCommonType} enum을 String으로 변환하는 유틸
 * */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LegacyEnumValueConvertUtils {
    public static <T extends Enum<T> & LegacyCommonType> T ofLegacyCode(Class<T> enumClass, String legacyCode){
        if(StringUtils.isBlank(legacyCode)){
            return null;
        }
        return EnumSet.allOf(enumClass).stream()
                .filter(v -> v.getLegacyCode().equals(legacyCode))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("%enum=[%s], legacyCode=[%s]가 존재하지 않습니다.", enumClass.getName(), legacyCode)));
    }

    public static <T extends Enum<T> & LegacyCommonType> String toLegacyCode(T enumValue){
        if (enumValue == null){
            return "";
        }
        return enumValue.getLegacyCode();
    }
}
