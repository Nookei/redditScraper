package com.ndh.masterthesis.redditScraper.service.comment;


import com.ndh.masterthesis.redditScraper.adapter.CommentAdapter;
import com.ndh.masterthesis.redditScraper.adapter.dto.comment.CommentDTO;
import com.ndh.masterthesis.redditScraper.adapter.dto.comment.CommentJsonWrapDTO;
import com.ndh.masterthesis.redditScraper.service.comment.bo.Comment;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentAdapter commentAdapter;

    public List<Comment> getCommentsForPost(String postId) throws FeignException {

        log.info("fetching comments for post {}",postId);

        List<Comment> comments = new ArrayList<>();

        try {
            comments = mapJsonWrapDTO(commentAdapter.getCommentsByPostId(postId,0,"drogen"));
        } catch (FeignException feignException) {
            log.info(feignException.toString());
        }


        log.info("fetched {} comments",comments.size());

        return comments;
    }


    private List<Comment> mapJsonWrapDTO(CommentJsonWrapDTO jsonWrapDTO) {
        List<Comment> commentBOs = new ArrayList<>();
        for (CommentDTO commentDTO : jsonWrapDTO.getData()){
            commentBOs.add(new Comment(commentDTO));
        }
        return commentBOs;
    }
}

//https://api.pushshift.io/reddit/comment/search?subreddit=drogen&nest_level=0&link_id=x7ante


// "parent_id": "t1_inbksje", t1 = nest level 1 und inbksje ist
//
// "id": "inbksje", von dem parent comment

// logik in service layer zum verknüpfen von kommentaren
// api request auf nest level 1

// wenn parentID == linkId ist comment auf post

// wenn comment = "parent_id": "t1_inbhjqg",
// dann id = inbhjqg comment auf den parentID t1_inbhjqg geantwortet hat
