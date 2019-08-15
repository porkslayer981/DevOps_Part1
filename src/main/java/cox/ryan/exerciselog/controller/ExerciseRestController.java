package cox.ryan.exerciselog.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cox.ryan.exerciselog.exceptions.NoSuchEntityException;
import cox.ryan.exerciselog.model.Exercise;
import cox.ryan.exerciselog.model.repositories.ExerciseJpaRepository;

@RestController
@RequestMapping("/exercises")
public class ExerciseRestController {
	
	@Autowired
	private ExerciseJpaRepository exerciseJpaRepository;

	@RequestMapping(path="", method=RequestMethod.POST)
	@Transactional
	public Integer createExercise(
			@RequestBody Exercise exercise) {
		exerciseJpaRepository.saveAndFlush(exercise);
		return exercise.getId();
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Exercise> getAllExercises() {
		return exerciseJpaRepository.findAll();
	}

	@RequestMapping(method=RequestMethod.GET, path="/{exerciseId}")
	public Exercise getById(
			@PathVariable int exerciseId) {
		Optional<Exercise> result = exerciseJpaRepository.findById(exerciseId);
		return result.orElseThrow(() -> 
				new NoSuchEntityException(exerciseId, Exercise.class));
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="/{exerciseId}")
	public void deleteExercise(int exerciseId) {
		exerciseJpaRepository.deleteById(exerciseId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="/{exerciseId}")
	@Transactional
	public void updateExercise(
			@PathVariable int exerciseId,
			@RequestBody Exercise newValues) {
		Exercise existingExercise = getById(exerciseId);
		existingExercise.copy(newValues);
		exerciseJpaRepository.saveAndFlush(existingExercise);
	}
	
	@RequestMapping(method=RequestMethod.PATCH, path="/{exerciseId}")
	@Transactional
	public void updateExerciseProperties(
			@PathVariable int exerciseId,
			@RequestBody Map<String, Object> newValues) {
		Exercise exercise = getById(exerciseId);
		exercise.setName((String)newValues.get("name"));
		exerciseJpaRepository.saveAndFlush(exercise);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/searchByName")
	public List<Exercise> searchExercisesByName(
			@RequestParam(name="name", required=true) String searchName) {
		
		return exerciseJpaRepository.findByNameLike("%" + searchName + "%");
	}
}









