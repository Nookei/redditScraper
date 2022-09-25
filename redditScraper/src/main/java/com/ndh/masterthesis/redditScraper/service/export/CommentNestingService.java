package com.ndh.masterthesis.redditScraper.service.export;

import com.ndh.masterthesis.redditScraper.adapter.dto.comment.CommentDTO;
import com.ndh.masterthesis.redditScraper.adapter.dto.comment.CommentJsonWrapDTO;
import com.ndh.masterthesis.redditScraper.service.comment.bo.Comment;
import com.ndh.masterthesis.redditScraper.service.post.bo.Post;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentNestingService {


    public Post nestCommentsForPost(Post post) throws FeignException {

        if (!post.hasComments()) {
            log.info("post {} has no comments",post.getId());
            return post;
        } else {
            int i = 0;
        }

        log.info("nesting comments for post {}",post.getId());

        List<NestedComment> topLevelComments =  new ArrayList<>();

        for (Comment comment : post.getComments()) {

            if (comment.getParentId().getFullId().equals(comment.getLinkId())) {
                // wo parent id = link id == nest level 0 ( comment auf post)
                topLevelComments.add(new NestedComment(comment,1));
            }

        }

        log.info("found {} topLevel-comments for post {}", topLevelComments.size(), post.getId());


        for (NestedComment nestedComment : topLevelComments) {

            String topLevelId = nestedComment.getComment().getId();

            List<Comment> secondLevelComments = post.getComments()
                                                     .stream()
                                                     .filter(comment -> comment.getParentId().getId().equals(topLevelId))
                                                     .collect(Collectors.toList());

            log.info("found {} secondLevel-comments for topLevel-comment {}", secondLevelComments.size(), topLevelId);

            for (Comment comment : secondLevelComments) {
                nestedComment.addNestedCommentsToComment(new NestedComment(comment,2));
            }


        }

        for (NestedComment nestedComment : topLevelComments) {
            for (NestedComment secondNestLevelComment : nestedComment.getNestedCommentsForComment()) {
                String aSecondLevelId = secondNestLevelComment.getComment().getId();

                List<Comment> secondLevelComments = post.getComments()
                                                        .stream()
                                                        .filter(comment -> comment.getParentId().getId().equals(aSecondLevelId))
                                                        .collect(Collectors.toList());

                log.info("found {} thirdLevel-comments for secondLevel-comment {}", secondLevelComments.size(), aSecondLevelId);


                for (Comment comment : secondLevelComments) {
                    secondNestLevelComment.addNestedCommentsToComment(new NestedComment(comment,3));
                }
            }

        }

        if (topLevelComments.size() > 0){
            post.setNestedComments(topLevelComments);
        }

        return post;
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
