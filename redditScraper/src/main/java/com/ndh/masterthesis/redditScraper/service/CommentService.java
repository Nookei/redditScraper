package com.ndh.masterthesis.redditScraper.service;


import com.ndh.masterthesis.redditScraper.adapter.CommentAdapter;
import com.ndh.masterthesis.redditScraper.adapter.dto.CommentDTO;
import com.ndh.masterthesis.redditScraper.adapter.dto.CommentJsonWrapDTO;
import com.ndh.masterthesis.redditScraper.service.bo.Comment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentAdapter commentAdapter;

    public List<Comment> getCommentsForPost(String postId) {

        List<Comment> comments = mapJsonWrapDTO(commentAdapter.getCommentsByPostId(postId));

        log.info("fetched {} comments for postId {}",comments.size());

        return comments;
    }


    private List<Comment> mapJsonWrapDTO(CommentJsonWrapDTO jsonWrapDTO) {
        List<Comment> commentBOs = Collections.emptyList();
        for (CommentDTO commentDTO : jsonWrapDTO.getData()){
            commentBOs.add(new Comment(commentDTO));
        }
        return commentBOs;
    }
}
