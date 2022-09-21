package com.ndh.masterthesis.redditScraper.service.bo;


import com.ndh.masterthesis.redditScraper.adapter.dto.CommentDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    String body;


    public Comment(CommentDTO commentDTO) {
        body = commentDTO.getBody();
        // TODO
    }
}
