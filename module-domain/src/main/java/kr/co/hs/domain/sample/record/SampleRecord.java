package kr.co.hs.domain.sample.record;

import kr.co.hs.domain.constant.legacy.LegacyPayType;

public record SampleRecord(
        
        Long id,
        String name,
        LegacyPayType legacyPayType) {}