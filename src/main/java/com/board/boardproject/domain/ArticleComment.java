package com.board.boardproject.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private long id;
    private Article article;
    private String content;

    private LocalDateTime createAt;
    private String creataBy;
    private LocalDateTime modifedAt;
    private String modifedBy;
}
