package co.edu.usco.service;

import co.edu.usco.entity.UserEntity;

import java.util.Optional;

/**
 * Service interface for managing users.
 */
public interface UserService {

    /**
     * Creates a new user.
     *
     * @param user the user entity to be created
     */
    void createUser(UserEntity user);

    /**
     * Retrieves a user by their ID.
     *
     * @param id the ID of the user to be retrieved
     * @return an Optional containing the found user entity, or empty if not found
     */
    Optional<UserEntity> getUserById(Long id);

    /**
     * Retrieves a user by their username.
     *
     * @param email the email of the user to be retrieved
     * @return an Optional containing the found user entity, or empty if not found
     */
    Optional<UserEntity> getUserByUsername(String email);

}
