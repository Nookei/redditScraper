package com.ndh.masterthesis.redditScraper.service.post.bo;

import com.ndh.masterthesis.redditScraper.adapter.dto.post.PostDTO;
import com.ndh.masterthesis.redditScraper.service.comment.bo.Comment;
import com.ndh.masterthesis.redditScraper.service.export.NestedComment;
import lombok.*;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Builder
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Post {

    String id;
    String author;
    String title;
    LocalDateTime createdAtInUtc;
    String postText;
    String subreddit;
    String subredditId;
    String fullLink;
    int score;

    List<Comment> comments;
    List<NestedComment> nestedComments;

    public boolean hasComments(){
        return comments != null && comments.size() != 0;
    }


    public Post(PostDTO postDTO) {
        id = postDTO.getId();
        author = postDTO.getAuthor();
        title = postDTO.getTitle();
        postText = postDTO.getSelftext();
        subreddit = postDTO.getSubreddit();
        subredditId = postDTO.getSubreddit_id();
        fullLink = postDTO.getFull_link();
        score = postDTO.getScore();

        if(!StringUtils.isEmpty(postDTO.getCreated_utc())) {
            createdAtInUtc = LocalDateTime.ofEpochSecond(postDTO.getCreated_utc(),0, ZoneOffset.UTC);
        }
    }
}
