package kr.co.hs.server.sample.controller;

import kr.co.hs.domain.constant.legacy.LegacyPayType;
import kr.co.hs.server.sample.model.form.SampleForm;
import kr.co.hs.support.ControllerTestSupport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

class SampleControllerTest extends ControllerTestSupport {

    @DisplayName("변경신청-사용자정보 변경을 위해 필요한 공통문서 목록을 조회한다")
    @Test
    void getCommentDocumentForCeoInfoChangeRequest() throws Exception {
        //given
        String json = objectMapper.writeValueAsString(
                SampleForm.builder()
                        .name("유재석")
                        .legacyPayType(LegacyPayType.BANK)
                        .build()
        );
        //expected
        mockMvc.perform(MockMvcRequestBuilders.post("/sample/one")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .with(csrf()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}  