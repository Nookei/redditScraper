package com.ndh.masterthesis.redditScraper.service.comment.bo;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
@Getter
public class CommentId {

    private int nestingLevel;
    private String id;
    private String fullId;

    public CommentId(String commentId) {
        fullId = commentId;
        log.info("trying to parse commentID {}", commentId);
        if (commentId.length() == 10) {
            id = commentId.substring(3, 10);
        }
        if (commentId.length() == 9) {
            id = commentId.substring(3, 9);
        }
    }
}
