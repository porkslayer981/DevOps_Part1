package cox.ryan.exerciselog.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cox.ryan.exerciselog.model.Exercise;

public interface ExerciseJpaRepository 
	extends JpaRepository<Exercise, Integer> {

	public List<Exercise> findByNameLike(String name);
	
}






