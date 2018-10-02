import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.Scanner;
/**
 * @author Lake David
 * @author Kiersten Gaspar
 */
public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};
	
	public void loadDataFromFile(String infile) throws FileNotFoundException {
		FileReader reader = new FileReader(infile);
		Scanner in = new Scanner(reader);
		while( in.hasNext() ) {
			String firstName = in.next();
			String lastName = in.next();
			String score = in.next();
			try {
				int scoreInt = Integer.parseInt(score);
				students.add( new Student(firstName + " " + lastName, scoreInt ));
			} catch (NumberFormatException e) {
				System.out.println("Incorrect format for " + firstName + " " + lastName + " not a valid score: " + score);
			}
			
		}
		in.close();
		
	}
	
	public void printInOrder() {
		System.out.println("Student Score List");
		students.sort(null);
		for(Student s:students) {
			System.out.print(s);
		}
		System.out.println();
	}
	
	public void processFiles() throws FileNotFoundException {
		for (String file : files) {
			students = new ArrayList<Student>();
			try {
				loadDataFromFile(file);
				printInOrder();
			} catch (FileNotFoundException e){
				System.out.println("Can't open file: " + file);
				}
		}
		
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
