package com.ndh.masterthesis.redditScraper;


import com.ndh.masterthesis.redditScraper.adapter.dto.PostDTO;
import com.ndh.masterthesis.redditScraper.adapter.dto.PostJsonWrapDTO;
import com.ndh.masterthesis.redditScraper.service.CommentService;
import com.ndh.masterthesis.redditScraper.service.PostService;
import com.ndh.masterthesis.redditScraper.service.bo.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class Controller {

    private final PostService postService;

    private final CommentService commentService;

    @GetMapping("/trigger")
    public void trigger() {

        PostJsonWrapDTO postsBySubreddit = postService.getPostsBySubreddit();


        // TODO: clean up mapping
        PostDTO post = postsBySubreddit.getData().stream().findFirst().get();

        log.info("first post id = {}", post.getId());


        List<Comment> commentsForPost = commentService.getCommentsForPost(post.getId());



        log.info("post:"+ post.getSelftext());
        log.info("post has {} comments",commentsForPost.size());

        for (Comment comment: commentsForPost){
            log.info("postID: {} comment: ",post.getId(),comment.getBody());
        }

    }

}
