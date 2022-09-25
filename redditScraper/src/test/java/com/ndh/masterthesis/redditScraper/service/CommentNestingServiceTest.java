package com.ndh.masterthesis.redditScraper.service;

import com.ndh.masterthesis.redditScraper.service.comment.bo.Comment;
import com.ndh.masterthesis.redditScraper.service.comment.bo.CommentId;
import com.ndh.masterthesis.redditScraper.service.export.CommentNestingService;
import com.ndh.masterthesis.redditScraper.service.post.bo.Post;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CommentNestingServiceTest {

    private final CommentNestingService commentNestingService = new CommentNestingService();

    @Test
    void nestCommentsForPost() {
        // Arrange
        Post post = setupTestData();
        // Act
        Post post1 = commentNestingService.nestCommentsForPost(post);

        // Assert
        post.getId();
    }


    private Post setupTestData() {

        Comment comment = Comment.builder()
                .id("iptx84s")
                .parentId(new CommentId("t3_xnk3pd"))
                .linkId("t3_xnk3pd")
                .text("1.0")
                .build();

        Comment comment1 = Comment.builder()
                .id("iptzuiy")
                .parentId(new CommentId("t1_iptx84s"))
                .linkId("t3_xnk3pd")
                .text("2.1")
                .build();

        Comment comment2 = Comment.builder()
                .id("ipaaaa")
                .parentId(new CommentId("t1_iptx84s"))
                .linkId("t3_xnk3pd")
                .text("2.2")
                .build();

        Comment comment4 = Comment.builder()
                .id("ipu00kj")
                .parentId(new CommentId("t1_iptzuiy"))
                .linkId("t3_xnk3pd")
                .text("4.1")
                .build();

        Comment comment3 = Comment.builder()
                .id("iptzwaq")
                .parentId(new CommentId("t1_ipu00kj"))
                .linkId("t3_xnk3pd")
                .text("5.1")
                .build();


        return Post.builder().id("12345").comments(Arrays.asList(comment, comment1, comment2, comment3, comment4)).build();
    }

}