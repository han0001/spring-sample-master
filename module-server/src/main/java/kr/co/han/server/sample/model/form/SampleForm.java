package kr.co.han.server.sample.model.form;


import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.han.domain.constant.legacy.LegacyPayType;
import kr.co.han.domain.sample.entity.Sample;

@Schema(name = "샘플 Form")
public record SampleForm(
        @Schema(description = "이름") String name,
        @Schema(description = "레거시결제타입") LegacyPayType legacyPayType
) {
    public Sample toEntityForInsert(){
        return Sample.builder()
                .name(name)
                .legacyPayType(legacyPayType)
                .build();
    }
}
