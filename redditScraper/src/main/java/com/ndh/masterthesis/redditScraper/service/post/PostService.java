package com.ndh.masterthesis.redditScraper.service.post;

import com.ndh.masterthesis.redditScraper.adapter.PostAdapter;
import com.ndh.masterthesis.redditScraper.adapter.dto.post.PostDTO;
import com.ndh.masterthesis.redditScraper.adapter.dto.post.PostJsonWrapDTO;
import com.ndh.masterthesis.redditScraper.service.post.bo.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostAdapter postAdapter;

    public List<Post> getPostsBySubreddit() {
        PostJsonWrapDTO postDtos = postAdapter.getPostsBySubreddit();

        List<Post> posts = mapToListOfPost(postDtos);

        log.info("fetched {} posts",posts.size());


        return posts;
    }

    public List<Post> mapToListOfPost(PostJsonWrapDTO postJsonWrapDTO) {
        List<Post> listOfPosts = new ArrayList<>();

        for (PostDTO postDTO: postJsonWrapDTO.getData()) {
            log.info(postDTO.toString());
            listOfPosts.add(new Post(postDTO));
        }

        return listOfPosts;
    }
}
