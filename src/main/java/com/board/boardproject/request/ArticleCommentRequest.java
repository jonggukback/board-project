package com.board.boardproject.request;

import com.board.boardproject.domain.ArticleComment;
import com.board.boardproject.dto.ArticleCommentDto;
import com.board.boardproject.dto.ArticleDto;
import com.board.boardproject.dto.UserAccountDto;

public record ArticleCommentRequest(
    Long articleId,
    String content

) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }

}
