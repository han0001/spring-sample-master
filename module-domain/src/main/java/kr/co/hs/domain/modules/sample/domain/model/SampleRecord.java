package kr.co.hs.domain.modules.sample.domain.model;

import kr.co.hs.domain.constant.legacy.LegacyPayType;

public record SampleRecord(
        
        Long id,
        String name,
        LegacyPayType legacyPayType) {}