package com.ndh.masterthesis.redditScraper.adapter.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
public class PostJsonWrapDTO {

    Collection<PostDTO> data;
}
