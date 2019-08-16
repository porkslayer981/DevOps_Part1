package cox.ryan.tests;

import org.junit.Assert;
import org.junit.Test;

import cox.ryan.exerciselog.model.Exercise;
import cox.ryan.exerciselog.model.Set;

public class ExercisUnitTests {

	@Test
	public void testSimpleExerciseSet() {
		Exercise e1 = new Exercise();
		e1.setName("Bench Press");
		
		Set set1 = new Set();
		set1.setCountReps(10);
		set1.setSecondsRestBetween(60);
		e1.getSets().add(set1);
		
		Set set2 = new Set();
		set2.setCountReps(10);
		set2.setSecondsRestBetween(60);
		e1.getSets().add(set2);
		
		Set set3 = new Set();
		set3.setCountReps(10);
		set3.setSecondsRestBetween(60);
		e1.getSets().add(set3);
		
		Assert.assertEquals("Bench Press", e1.getName());
		Assert.assertEquals(10, e1.getSets().get(0).getCountReps());
		Assert.assertEquals(60, e1.getSets().get(1).getSecondsRestBetween());
	}
}
