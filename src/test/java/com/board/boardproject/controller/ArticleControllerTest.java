package com.board.boardproject.controller;


import com.board.boardproject.config.SecurityConfig;

import com.board.boardproject.dto.ArticleWithCommentsDto;
import com.board.boardproject.dto.UserAccountDto;
import com.board.boardproject.service.ArticleService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;


@WebMvcTest
@Import(SecurityConfig.class)
@DisplayName("View 컨트롤러 - 게시글")
class ArticleControllerTest {
    private final MockMvc mockMvc;

    @MockBean private ArticleService articleService;

    public ArticleControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("[GET] view - 게시글 리스트 (게시판) 페이 - 정상 호출")
    public void givenNothing_whenRequestArticlesView_thenReturnArticlesView() throws Exception {
        // Given
        given(articleService.searchArticles(eq(null), eq(null), any(Pageable.class))).willReturn(Page.empty());

        // When & Then
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("articles"));

        then(articleService).should().searchArticles(eq(null), eq(null), any(Pageable.class));
    }

    @DisplayName("[GET] view - 게시글 상세 페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestingArticleView_thenReturnsArticleView() throws Exception {
        // Given
        Long articleId = 1L;
        given(articleService.getArticle(articleId)).willReturn(createArticleWithCommentsDto());

        // When & Then
        mockMvc.perform(get("/articles/" + articleId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));
        then(articleService).should().getArticle(articleId);
    }

    @DisplayName("[GET] view - 게시글 검색 전용 페이지 - 정상 호출")
    @Test
    @Disabled("미구현")
    public void givenNothing_whenRequestingArticleSearchView_thenReturnsArticleSearchView() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));
    }

    @DisplayName("[GET] view - 게시글 해시태그 검색 페이지 - 정상 호출")
    @Test
    @Disabled("미구현")
    public void givenNothing_whenRequestingArticleHashtagSearchView_thenReturnsArticleHashtagSearchView() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag"));
    }


    private ArticleWithCommentsDto createArticleWithCommentsDto() {
        return ArticleWithCommentsDto.of(
                1L,
                createUserAccountDto(),
                Set.of(),
                "title",
                "content",
                "#java",
                LocalDateTime.now(),
                "baek",
                LocalDateTime.now(),
                "baek"
        );
    }

    private UserAccountDto createUserAccountDto() {
        return UserAccountDto.of(1L,
                "baek",
                "pw",
                "baek@mail.com",
                "Baek",
                "memo",
                LocalDateTime.now(),
                "baek",
                LocalDateTime.now(),
                "baek"
        );
    }
}