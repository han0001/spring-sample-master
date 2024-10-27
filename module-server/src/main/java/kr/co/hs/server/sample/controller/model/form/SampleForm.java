package kr.co.hs.server.sample.controller.model.form;


import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.hs.domain.constant.legacy.LegacyPayType;
import kr.co.hs.domain.modules.sample.domain.model.Sample;
import lombok.Builder;

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
