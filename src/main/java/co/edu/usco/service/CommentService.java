package co.edu.usco.service;

import co.edu.usco.entity.CommentEntity;

import java.util.Optional;

/**
 * Service interface for managing comments.
 */
public interface CommentService {

    /**
     * Creates a new comment.
     *
     * @param comment the comment entity to be created
     */
    void createComment(CommentEntity comment);

    /**
     * Updates an existing comment.
     *
     * @param id the ID of the comment to be updated
     * @param comment the comment entity with updated information
     */
    void updateComment(Long id, CommentEntity comment);

    /**
     * Deletes a comment by its ID.
     *
     * @param id the ID of the comment to be deleted
     */
    void deleteComment(Long id);

    /**
     * Retrieves a comment by its ID.
     *
     * @param id the ID of the comment to be retrieved
     * @return an Optional containing the found comment entity, or empty if not found
     */
    Optional<CommentEntity> getCommentById(Long id);

}
