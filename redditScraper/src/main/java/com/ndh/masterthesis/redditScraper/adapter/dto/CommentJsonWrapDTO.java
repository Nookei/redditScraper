package com.ndh.masterthesis.redditScraper.adapter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
public class CommentJsonWrapDTO {

    Collection<CommentDTO> data;
}
