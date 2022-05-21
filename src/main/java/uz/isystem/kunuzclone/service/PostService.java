package uz.isystem.kunuzclone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.isystem.kunuzclone.Enum.PostStatus;
import uz.isystem.kunuzclone.model.Category;
import uz.isystem.kunuzclone.model.Post;
import uz.isystem.kunuzclone.model.Region;
import uz.isystem.kunuzclone.model.User;
import uz.isystem.kunuzclone.repository.PostRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class






PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private CategoryService categoryService;


    public Post create(Post post) {
        User user = userService.get(post.getUserId());
        Region region = regionService.get(post.getRegionId());
        Category category = categoryService.get(post.getCategoryId());

        post.setToken(UUID.randomUUID().toString());
        post.setUser(user);
        post.setRegion(region);
        post.setCategory(category);
        post.setViewCount(0);
        post.setStatus(true);
        post.setCreatedAt(LocalDateTime.now());
        post.setPostStatus(PostStatus.CREATED);
        postRepository.save(post);
        return post;
    }

    public Post get(Integer id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();

    }

    public Post update(Integer id, Post post) {
        Post old = get(id);
        old.setStatus(true);
        old.setCreatedAt(post.getCreatedAt());
        old.setContent(post.getContent());
        old.setTitle(post.getTitle());
        old.setViewCount(post.getViewCount());
        old.setPublishedAt(post.getPublishedAt());
        old.setToken(post.getToken());
        postRepository.save(old);
        return old;
    }

    public boolean delete(Integer id) {
        Post post = get(id);
        postRepository.delete(post);
        return true;
    }

    public List<Post> getByCategory(Integer categoryId) {
        return postRepository.findAllByCategoryId(categoryId);
    }
    public List<Post> getByRegion(Integer regionId){
        return  postRepository.findAllByRegionId(regionId);

    }
    public boolean addView(Integer postId){
        Post view=get(postId);
        view.setViewCount(view.getViewCount()+1);
        postRepository.save(view);
        return true;
    }
    public boolean publishDate(Integer postId){
        Post addPost=get(postId);
        addPost.setPublishedAt(LocalDateTime.now());
        postRepository.save(addPost);
        return true;
    }

}
