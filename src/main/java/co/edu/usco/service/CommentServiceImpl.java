package co.edu.usco.service;

import co.edu.usco.entity.CommentEntity;
import co.edu.usco.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * Retrieves a comment by its ID.
     *
     * @param id the ID of the comment to be retrieved
     * @return an Optional containing the found comment entity, or empty if not found
     */
    @Override
    public Optional<CommentEntity> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    /**
     * Creates a new comment.
     *
     * @param comment the comment entity to be created
     */
    @Override
    public void createComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    /**
     * Updates an existing comment.
     *
     * @param id the ID of the comment to be updated
     * @param comment the comment entity with updated information
     * @throws InvalidParameterException if the comment with the given ID is not found
     */
    @Override
    public void updateComment(Long id, CommentEntity comment) {
        CommentEntity commentDB = commentRepository.findById(id).orElseThrow(() -> new InvalidParameterException("Comment not found"));
        commentDB.setContent(comment.getContent());
        commentRepository.save(commentDB);
    }

    /**
     * Deletes a comment by its ID.
     *
     * @param id the ID of the comment to be deleted
     */
    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
