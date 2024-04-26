package kr.co.han.domain.constant.legacy;

public class LegacyPayTypeConverter extends AbstractLegacyEnumAttributeConverter<LegacyPayType>{
    public static final String ENUM_NAME = "레거시 결제 타입";

    public LegacyPayTypeConverter(){
        super(false, ENUM_NAME);
    }
}
