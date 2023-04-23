package com.board.boardproject.service;

import com.board.boardproject.domain.type.SearchType;
import com.board.boardproject.dto.ArticleDto;
import com.board.boardproject.dto.ArticleUpdateDto;
import com.board.boardproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType title, String searchKeyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(long l) {
        return ArticleDto.of(LocalDateTime.now(),"baek","새 글", "본문","#new_content");
    }

    public void saveArticle(ArticleDto of) {

    }

    public void updateArticle(long articleId, ArticleUpdateDto dto) {

    }

    public void deleteArticle(long articleId) {
    }

}
