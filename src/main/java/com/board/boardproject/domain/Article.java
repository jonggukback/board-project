package com.board.boardproject.domain;

import java.time.LocalDateTime;

public class Article {
    private long id;
    private String title;
    private String content;
    private String hashTag;

    private LocalDateTime createAt;
    private String creataBy;
    private LocalDateTime modifedAt;
    private String modifedBy;
}
