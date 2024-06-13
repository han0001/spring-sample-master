package kr.co.hs.server.sample.controller.model.view;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.co.hs.domain.modules.sample.domain.model.Sample;

@Schema(name = "샘플 View")
public record SampleView(
        @Schema(description = "이름") String name,
        @Schema(description = "레거시결제타입") String legacyPayType
) {

    public static SampleView fromEntity(Sample sample){
        return new SampleView(sample.getName(), sample.getLegacyPayType().getName());
    }
}