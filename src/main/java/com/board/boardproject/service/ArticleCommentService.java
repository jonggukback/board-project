package com.board.boardproject.service;

import com.board.boardproject.dto.ArticleCommentDto;
import com.board.boardproject.repository.ArticleCommentRepository;
import com.board.boardproject.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public List<ArticleCommentDto> searchArticleComment(Long id) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto dto){

    }

    public void deleteArticleComment(Long articleCommentId) {

    }
}
