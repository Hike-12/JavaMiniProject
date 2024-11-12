package org.endangered.miniproject.controller;

import org.endangered.miniproject.model.Comments;
import org.endangered.miniproject.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping
    public String getAllComments(Model model) {
        List<Comments> comments = commentsService.getAllComments();
        model.addAttribute("comments", comments);
        return "comments";
    }

    @GetMapping("/{id}")
    public String getCommentById(@PathVariable Long id, Model model) {
        return commentsService.getCommentById(id)
                .map(comment -> {
                    model.addAttribute("comment", comment);
                    return "comment";
                })
                .orElse("redirect:/comments");
    }

    @PostMapping
    public String addComment(@RequestParam String author, @RequestParam String content) {
        commentsService.addComment(author, content);
        return "redirect:/comments";
    }

    @GetMapping("/edit/{id}")
    public String editCommentForm(@PathVariable Long id, Model model) {
        commentsService.getCommentById(id).ifPresent(comment -> model.addAttribute("comment", comment));
        return "edit-comment";
    }

    @PostMapping("/edit/{id}")
    public String updateComment(@PathVariable Long id, @RequestParam String content) {
        commentsService.editComment(id, content);
        return "redirect:/comments";
    }

    @PostMapping("/delete/{id}")
    public String deleteComment(@PathVariable Long id) {
        commentsService.deleteComment(id);
        return "redirect:/comments";
    }
}
