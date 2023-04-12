package com.board.boardproject.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Rest DATA Test")
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class DataRestTest {

    private  final MockMvc mockMvc;

    public DataRestTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("API: 게시글 조회 테스트")
    void given_whenRequestingArticles_thenReturnsArticlesJsonResponse() throws Exception {
        //given

        //when & then
        mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
    @Test
    @DisplayName("API: 게시글 단건 조회 테스트")
    void given_whenRequestingArticle_thenReturnsArticleJsonResponse() throws Exception {
        //given

        //when & then
        mockMvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @Test
    @DisplayName("API: 게시글 -> 댓글 조회 테스트")
    void given_whenRequestingArticleCommentsFromArticle_thenReturnsArticleComentsJsonResponse() throws Exception {
        //given

        //when & then
        mockMvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @Test
    @DisplayName("API: 댓글 리스트 조회 테스트")
    void given_whenRequestingArticleComments_thenReturnsArticleComentsJsonResponse() throws Exception {
        //given

        //when & then
        mockMvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @Test
    @DisplayName("API: 댓글 단건 조회 테스트")
    void given_whenRequestingArticleComment_thenReturnsArticleComentsJsonResponse() throws Exception {
        //given

        //when & then
        mockMvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
}
