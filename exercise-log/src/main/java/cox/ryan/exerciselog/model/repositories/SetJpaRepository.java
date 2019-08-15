package cox.ryan.exerciselog.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cox.ryan.exerciselog.model.Set;

public interface SetJpaRepository extends JpaRepository<Set, Integer> {

}
