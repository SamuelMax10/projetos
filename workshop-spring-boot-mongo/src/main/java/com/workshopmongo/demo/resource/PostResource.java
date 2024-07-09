package com.workshopmongo.demo.resource;

import com.workshopmongo.demo.domain.Post;
import com.workshopmongo.demo.resource.util.Url;
import com.workshopmongo.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity <List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = Url.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate){
        text = Url.decodeParam(text);
        Date min = Url.convertDate(minDate, new Date(0L));
        Date max = Url.convertDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }
}
