package com.ndh.masterthesis.redditScraper.adapter.dto.post;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDTO {

    private String id;
    private String author;
    private String title;
    private long created_utc;
    private String selftext;
    private String subreddit;
    private String subreddit_id;
    private String full_link;
    private int score;
    private int num_comments;
}
