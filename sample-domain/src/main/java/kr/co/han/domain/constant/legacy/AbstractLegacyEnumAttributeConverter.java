package kr.co.han.domain.constant.legacy;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.AttributeConverter;
import lombok.Getter;

@Getter
public class AbstractLegacyEnumAttributeConverter<E extends Enum<E> & LegacyCommonType> implements AttributeConverter<E, String> {

    /**
     * 대사 Enum 클래사의 {@link Class} 객체
     * */
    private Class<E> targetEnumClass;


    /**
     * null 허용 여부
     * */
    private boolean nullable;


    /**
     * 오류메세지를 위한 enumName 설정
     * */
    private String enumName;

    public AbstractLegacyEnumAttributeConverter(boolean nullable, String enumName) {
        this.nullable = nullable;
        this.enumName = enumName;
    }


    @Override
    public String convertToDatabaseColumn(E attribute) {
        if(!nullable && attribute == null){
            throw new IllegalArgumentException(String.format("%s(은)는 null로 저장할 수 없습니다.", enumName));
        }
        return LegacyEnumValueConvertUtils.toLegacyCode(attribute);
    }

    @Override
    public E convertToEntityAttribute(String dbData) {
        if(!nullable && StringUtils.isBlank(dbData)){
            throw new IllegalArgumentException(String.format("%s(은)는 DB에 NULL 혹은 Empty로 저장돼 있습니다.", enumName, dbData));
        }

        return LegacyEnumValueConvertUtils.ofLegacyCode(targetEnumClass, dbData);
    }
}
