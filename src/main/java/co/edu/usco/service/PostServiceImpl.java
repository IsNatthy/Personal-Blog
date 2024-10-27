package co.edu.usco.service;

import co.edu.usco.entity.PostEntity;
import co.edu.usco.repository.PostReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostReporitory postReporitory;

    /**
     * Retrieves all posts.
     *
     * @return a list of all post entities
     */
    @Override
    public List<PostEntity> getAllPosts() {
        return postReporitory.findAll();
    }

    /**
     * Retrieves a post by its ID.
     *
     * @param id the ID of the post to be retrieved
     * @return an Optional containing the found post entity, or empty if not found
     */
    @Override
    public Optional<PostEntity> getPostById(Long id) {
        return postReporitory.findById(id);
    }

    /**
     * Retrieves posts by user ID.
     *
     * @param userId the ID of the user whose posts are to be retrieved
     * @return a list of post entities belonging to the specified user
     */
    @Override
    public List<PostEntity> getPostsByUserId(Long userId) {
        return postReporitory.findByUserId(userId);
    }

    /**
     * Creates a new post.
     *
     * @param post the post entity to be created
     */
    @Override
    public void createPost(PostEntity post) {
        postReporitory.save(post);
    }

    /**
     * Updates an existing post.
     *
     * @param id the ID of the post to be updated
     * @param post the post entity with updated information
     * @throws InvalidParameterException if the post with the given ID is not found
     */
    @Override
    public void updatePost(Long id, PostEntity post) {
        PostEntity postDB = getPostById(id).orElseThrow(() -> new InvalidParameterException("Invalid post id"));
        postDB.setTitle(post.getTitle());
        postDB.setContent(post.getContent());
        postReporitory.save(postDB);
    }

    /**
     * Deletes a post by its ID.
     *
     * @param id the ID of the post to be deleted
     */
    @Override
    public void deletePostById(Long id) {
        postReporitory.deleteById(id);
    }

    /**
     * Searches for posts by title.
     *
     * @param title the title to search for
     * @return a list of post entities matching the specified title
     */
    @Override
    public List<PostEntity> searchPostByTitle(String title) {
        return postReporitory.findByTitleContainingIgnoreCase(title);
    }
}
