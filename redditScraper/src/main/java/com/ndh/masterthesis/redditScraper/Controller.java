package com.ndh.masterthesis.redditScraper;


import com.ndh.masterthesis.redditScraper.service.comment.CommentService;
import com.ndh.masterthesis.redditScraper.service.comment.bo.Comment;
import com.ndh.masterthesis.redditScraper.service.export.CommentNestingService;
import com.ndh.masterthesis.redditScraper.service.post.PostService;
import com.ndh.masterthesis.redditScraper.service.post.bo.Post;
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

    private final CommentNestingService commentNestingService;

    @GetMapping("/trigger")
    public void trigger() {

        List<Post> postsBySubreddit = postService.getPostsBySubreddit();

        Post post = postsBySubreddit.get(0);
        List<Comment> commentsForPost = commentService.getCommentsForPost(post.getId()); // catch feign exception because of too many requests
        post.setComments(commentsForPost);
        commentNestingService.nestCommentsForPost(post);


        Post post1 = postsBySubreddit.get(1);
        List<Comment> commentsForPost1 = commentService.getCommentsForPost(post1.getId()); // catch feign exception because of too many requests
        post1.setComments(commentsForPost1);
        commentNestingService.nestCommentsForPost(post1);

        Post post2 = postsBySubreddit.get(2);
        List<Comment> commentsForPost2 = commentService.getCommentsForPost(post2.getId()); // catch feign exception because of too many requests
        post2.setComments(commentsForPost2);
        commentNestingService.nestCommentsForPost(post2);

        Post post3 = postsBySubreddit.get(3);
        List<Comment> commentsForPost3 = commentService.getCommentsForPost(post3.getId()); // catch feign exception because of too many requests
        post3.setComments(commentsForPost3);
        commentNestingService.nestCommentsForPost(post3);


        int i = 0;

    }

}
