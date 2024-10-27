package co.edu.usco.repository;

import co.edu.usco.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReporitory extends JpaRepository<PostEntity, Long> {
}
