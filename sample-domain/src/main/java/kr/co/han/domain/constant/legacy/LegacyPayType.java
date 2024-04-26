package kr.co.han.domain.constant.legacy;

import lombok.Getter;

@Getter
public enum LegacyPayType implements LegacyCommonType{

    BANK("은행", "01"),
    CARD("카드", "02"),

    MOBILE("휴대폰", "03");

    private String name;
    private String legacyCode;

    LegacyPayType(String name, String legacyCode){
        this.name = name;
        this.legacyCode = legacyCode;
    }
}
