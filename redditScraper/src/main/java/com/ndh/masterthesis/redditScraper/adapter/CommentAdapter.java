package com.ndh.masterthesis.redditScraper.adapter;

import com.ndh.masterthesis.redditScraper.adapter.dto.CommentJsonWrapDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://api.pushshift.io", name = "CommentAdapter")
public interface CommentAdapter {


    String PATH = "/reddit/comment/search";


    String PATH_VARIABLES = "?subreddit=drogen";

    String FULL_PATH = PATH + PATH_VARIABLES;

    @GetMapping(path = PATH)
    CommentJsonWrapDTO getCommentsByPostId(@PathVariable("link_id") String link_id);

    //https://api.pushshift.io/reddit/comment/search?subreddit=drogen&nest_level=0&link_id=x7ante


    // "parent_id": "t1_inbksje", t1 = nest level 1 und inbksje ist
    //
    // "id": "inbksje", von dem parent comment

    // logik in service layer zum verknüpfen von kommentaren
    // api request auf nest level 1

    // wenn parentID == linkId ist comment auf post

    // wenn comment = "parent_id": "t1_inbhjqg",
    // dann id = inbhjqg comment auf den parentID t1_inbhjqg geantwortet hat

    //sort	Filter	All Endpoints	Sort direction of results ("asc" or "desc")
    //sort_type	Filter	All Endpoints	Parameter used for sort
    //after	Integer	All Endpoints	Restrict results to those made after this epoch time
    //before	Integer	All Endpoints	Restrict results to those made before this epoch time
    //after_id	Integer	All Endpoints	Restrict results to those with an id greater than this value.
    //before_id	Integer	All Endpoints	Restrict results to those with an id less than this value.
    //created_utc	Integer	All Endpoints	Restrict results based on the epoch value given or range of values.


}
