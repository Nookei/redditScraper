package com.ndh.masterthesis.redditScraper.adapter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
public class PostJsonWrapDTO {

    Collection<PostDTO> data;
}
