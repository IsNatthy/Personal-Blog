package co.edu.usco.controller;

import co.edu.usco.entity.PostEntity;
import co.edu.usco.entity.UserEntity;
import co.edu.usco.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import co.edu.usco.service.PostService;
import org.springframework.ui.Model;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "/posts/home";
    }

    @GetMapping("/new")
    public String newPostPage() {
        return "/posts/create-post";
    }

    @PostMapping("/create")
    public String createPost(PostEntity post, HttpSession session) {
        post.setCreatedAt(LocalDateTime.now());

        UserEntity user = userService.getUserById(Long.parseLong(session.getAttribute("user_session_id").toString())).get();
        post.setUser(user);

        postService.createPost(post);
        return "redirect:/posts/home";
    }

}
