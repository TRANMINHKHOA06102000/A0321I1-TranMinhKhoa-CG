package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class RestBlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("listCategory")
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories= categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    
    @GetMapping("listBlog")
    public ResponseEntity<List<Blog>> listAllBlog() {
        List<Blog> blogs= blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

    @GetMapping(value = "viewBlogCategory/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> viewBlogCategory(@PathVariable("id") Integer id){
        System.out.println("Fetching Category with id " + id);
        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping(value = "viewBlog/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> viewBlog(@PathVariable("id") Integer id) {
        System.out.println("Fetching Blog with id " + id);
        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("creatingBlog")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Blog " + blog.getAuthor());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blogs/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PostMapping("editingBlog/{id}")
    public ResponseEntity<Blog> editingBlog(@PathVariable("id") Integer id, @RequestBody Blog blog) {
        System.out.println("Updating Blog " + id);

        Blog currentBlog = blogService.findById(id);

        if (currentBlog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setTitle(blog.getTitle());
        currentBlog.setContent(blog.getContent());
        currentBlog.setAuthor(blog.getAuthor());
        currentBlog.setCreateDate(blog.getCreateDate());
        currentBlog.setCategory(blog.getCategory());
        currentBlog.setId(blog.getId());

        blogService.save(currentBlog);
        return new ResponseEntity<>(currentBlog, HttpStatus.OK);
    }

    @GetMapping("deletingBlog/{id}")
    public ResponseEntity<Blog> deleteCustomer(@PathVariable("id") Integer id) {
        System.out.println("Fetching & Deleting Blog with id " + id);

        Blog customer = blogService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
