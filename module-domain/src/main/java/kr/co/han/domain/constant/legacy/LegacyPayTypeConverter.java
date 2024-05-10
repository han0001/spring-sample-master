package kr.co.han.domain.constant.legacy;

import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class LegacyPayTypeConverter extends AbstractLegacyEnumAttributeConverter<LegacyPayType>{
    public static final String ENUM_NAME = "레거시결제타입";

    public LegacyPayTypeConverter(){
        super(LegacyPayType.class ,false, ENUM_NAME);
    }
}
