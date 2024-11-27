package com.crm.crm.controller;

import com.crm.crm.entity.Comment;
import com.crm.crm.entity.Post;
import com.crm.crm.respository.CommentRepository;
import com.crm.crm.respository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository=postRepository;
        this.commentRepository=commentRepository;
    }

    @PostMapping
    public String createComment(@RequestBody Comment comment, @RequestParam long postId){

        System.out.println(1000);
        System.out.println(1000);

        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        commentRepository.save(comment);
        return "comment created successfully";
    }

}
