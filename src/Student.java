/**
 * @author Lake David
 * @author Kiersten Gaspar
 */
public class Student implements Comparable<Student> {
	
	private String name;
	private int score;
	
	@Override
	public String toString() {
		return name + " " + score + "\n";
	}
	
	//compare by name
	@Override
	public int compareTo(Student s2) {
		return this.name.compareTo(s2.name);
	}
	
	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	
	
}