package com.board.boardproject.service;

import com.board.boardproject.domain.Article;
import com.board.boardproject.domain.ArticleComment;
import com.board.boardproject.dto.ArticleCommentDto;
import com.board.boardproject.repository.ArticleCommentRepository;
import com.board.boardproject.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class )
@DisplayName("비즈니스 로직 - 댓글")
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @Test
    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleComments() {
        //given
        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title", "content", "#java"))
        );

        //when
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(1L);

        //then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }


    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void givenArticleCommentInfo_whenSavingArticleComment_thenSavesArticleComment() {
        // Given
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // When
        sut.saveArticleComment(ArticleCommentDto.of(LocalDateTime.now(), "Uno", LocalDateTime.now(), "Uno", "comment"));

        // Then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

}