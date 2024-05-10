package kr.co.han.server.sample.model.view;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "샘플 View")
public record SampleView(
        @Schema(description = "이름") String name,
        @Schema(description = "레거시결제타입") String legacyPayType
) {
}