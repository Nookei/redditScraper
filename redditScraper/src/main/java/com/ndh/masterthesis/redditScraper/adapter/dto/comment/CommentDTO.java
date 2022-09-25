package com.ndh.masterthesis.redditScraper.adapter.dto.comment;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO {

    private String id;
    private String parent_id;
    private String link_id;
    private int created_utc;

    private String author;
    private String body;
}
