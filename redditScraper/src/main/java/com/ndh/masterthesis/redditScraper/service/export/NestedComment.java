package com.ndh.masterthesis.redditScraper.service.export;

import com.ndh.masterthesis.redditScraper.service.comment.bo.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class NestedComment {

    private final Comment comment;

    private final int nestLevel;

    private List<NestedComment> nestedCommentsForComment;

    public void addNestedCommentsToComment(NestedComment comment) {
        if (nestedCommentsForComment == null) {
            nestedCommentsForComment = new ArrayList<>();
        }
        nestedCommentsForComment.add(comment);
    }

}
