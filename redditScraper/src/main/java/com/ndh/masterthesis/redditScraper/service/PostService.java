package com.ndh.masterthesis.redditScraper.service;

import com.ndh.masterthesis.redditScraper.adapter.PostAdapter;
import com.ndh.masterthesis.redditScraper.adapter.dto.PostDTO;
import com.ndh.masterthesis.redditScraper.adapter.dto.PostJsonWrapDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostAdapter postAdapter;

    public PostJsonWrapDTO getPostsBySubreddit() {
        PostJsonWrapDTO posts = postAdapter.getPostsBySubreddit();


        log.info("fetched {} posts",posts.getData().size());


        return posts;
    }
}
