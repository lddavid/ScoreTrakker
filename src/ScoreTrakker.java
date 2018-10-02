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
	
	void loadDataFromFile(String infile) throws FileNotFoundException {
		students = new ArrayList<Student>();
		FileReader reader = new FileReader(infile);
		Scanner in = new Scanner(reader);
		while( in.hasNext() ) {
			String name = "";
			String word = in.next();
			name += word + " ";
			word = in.next();
			name += word;
			String score = in.next();
			
			students.add( new Student(name, Integer.parseInt(score) ));
		}
		in.close();
		
	}
	
	void printInOrder() {
		students.sort(null);
		for(Student s:students) {
			System.out.println(s);
		}
	}
	
	void processFiles() throws FileNotFoundException {
		loadDataFromFile("test.txt");
		printInOrder();
	}
	
	public static void main(String args[]) throws FileNotFoundException {
		ScoreTrakker trakker = new ScoreTrakker();
		trakker.processFiles();
	}
}
