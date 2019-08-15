package cox.ryan.exerciselog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cox.ryan.exerciselog.model.Exercise;
import cox.ryan.exerciselog.model.Set;
import cox.ryan.exerciselog.model.repositories.SetJpaRepository;

@RestController
@RequestMapping("/sets")
public class SetRestController {

	@Autowired
	private SetJpaRepository setJpaRepository;

	@Autowired
	private ExerciseRestController exerciseRestController;
	
	@RequestMapping(path="/exercise/{exerciseId}", method=RequestMethod.POST)
	@Transactional
	public Integer createSet(
			@PathVariable int exerciseId,
			@RequestBody Set set) {
		Exercise exercise = exerciseRestController.getById(exerciseId);
		set.setExercise(exercise);
		setJpaRepository.saveAndFlush(set);
		return set.getId();
	}
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<Set> getAllSets() {
		return setJpaRepository.findAll();
	}
}




