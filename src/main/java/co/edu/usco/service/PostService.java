package co.edu.usco.service;

import co.edu.usco.entity.PostEntity;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing posts.
 */
public interface PostService {

    /**
     * Retrieves all posts.
     *
     * @return a list of all post entities
     */
    List<PostEntity> getAllPosts();

    /**
     * Retrieves a post by its ID.
     *
     * @param id the ID of the post to be retrieved
     * @return an Optional containing the found post entity, or empty if not found
     */
    Optional<PostEntity> getPostById(Long id);

    /**
     * Retrieves posts by user ID.
     *
     * @param userId the ID of the user whose posts are to be retrieved
     * @return a list of post entities belonging to the specified user
     */
    List<PostEntity> getPostsByUserId(Long userId);

    /**
     * Creates a new post.
     *
     * @param post the post entity to be created
     */
    void createPost(PostEntity post);

    /**
     * Updates an existing post.
     *
     * @param id the ID of the post to be updated
     * @param post the post entity with updated information
     */
    void updatePost(Long id, PostEntity post);

    /**
     * Deletes a post by its ID.
     *
     * @param id the ID of the post to be deleted
     */
    void deletePostById(Long id);

    /**
     * Searches for posts by title.
     *
     * @param title the title to search for
     * @return a list of post entities matching the specified title
     */
    List<PostEntity> searchPostByTitle(String title);
}
