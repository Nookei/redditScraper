package com.ndh.masterthesis.redditScraper.adapter.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDTO {

    String author;

    String title;

    long created_utc;

    String id;

    String selftext;

    String subreddit;

    String subreddit_id;

    int score;

    int num_comments;
}
