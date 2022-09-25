package com.ndh.masterthesis.redditScraper.service.comment.bo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommentIdTest {

    @Test
    void getNestingLevel() {
        // Arrange
        CommentId commentId = new CommentId("t1_iptzwxq");
        // Act
        String id = commentId.getId();
        int nestLevel = commentId.getNestingLevel();

        // Assert
        assertEquals(1, nestLevel);
        assertEquals("iptzwxq", id);

    }
}