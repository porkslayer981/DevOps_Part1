package cox.ryan.exerciselog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="exercise_set")
public class Set {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable=false)
	private int countReps;
	
	@Column(nullable=false)
	private int secondsRestBetween;
	
	@ManyToOne
	@JoinColumn(name="exercise_id", nullable=false)
	@JsonIgnore
	private Exercise exercise;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountReps() {
		return countReps;
	}

	public void setCountReps(int countReps) {
		this.countReps = countReps;
	}

	public int getSecondsRestBetween() {
		return secondsRestBetween;
	}

	public void setSecondsRestBetween(int secondsRestBetween) {
		this.secondsRestBetween = secondsRestBetween;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
}
