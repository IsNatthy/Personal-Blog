package co.edu.usco.repository;

import co.edu.usco.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostReporitory extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByUserId(Long userId);
    List<PostEntity> findByTitleContainingIgnoreCase(String title);

}
