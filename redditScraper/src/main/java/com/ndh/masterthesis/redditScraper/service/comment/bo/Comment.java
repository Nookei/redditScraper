package com.ndh.masterthesis.redditScraper.service.comment.bo;


import com.ndh.masterthesis.redditScraper.adapter.dto.comment.CommentDTO;
import lombok.*;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Comment {

    private String id;
    private CommentId parentId; // references the id of post/comment to which is referred
    private String linkId;
    private LocalDateTime createdUtc;

    private String author;
    private String text;

    public Comment(CommentDTO commentDTO) {
        id = commentDTO.getId();
        linkId = commentDTO.getLink_id();
        parentId = new CommentId(commentDTO.getParent_id());
        author = commentDTO.getAuthor();
        text = commentDTO.getBody();

        if(!StringUtils.isEmpty(commentDTO.getCreated_utc())) {
            createdUtc = LocalDateTime.ofEpochSecond(commentDTO.getCreated_utc(),0, ZoneOffset.UTC);
        }
    }
}
