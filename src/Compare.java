import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Compare {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("./test10.txt");
		Scanner scan = new Scanner(file);
		
		//initialize values
		String normal = "";
		ArrayList<String> characters= new ArrayList<String>();
		
		makeList(scan, characters);
		long normalTime = normalAppend(normal, characters);
		long builderTime = stringBuilderAppend(normal, characters);
		
		System.out.println("normalAppend time - builderAppend time = " + (normalTime - builderTime)/1000 + " microseconds");
		scan.close();
		
		
	}
	
	static long stringBuilderAppend(String normal, ArrayList<String> characters) {
		StringBuilder build = new StringBuilder(normal);
		long startTime = System.nanoTime();
		for(String s: characters){
			build.append(s);
		}
		long endTime = System.nanoTime();
		
		System.out.println("Builder duration = " + (endTime - startTime)/1000 + " microseconds");

		
		return (endTime - startTime);
	}
	
	
	static long normalAppend(String normal, ArrayList<String> characters) {

		long startTime = System.nanoTime();
		for(String s: characters){
			normal += s;
		}
		long endTime = System.nanoTime();
		
		
		System.out.println("Append Duration = " + (endTime - startTime)/1000 + " microseconds");
		return (endTime - startTime);
	}
	
	static ArrayList<String> makeList(Scanner scan, ArrayList<String> characters) {
		while(scan.hasNext()){
			String temp = scan.next();
			for(int i = 0; i < temp.length(); i++) {
				characters.add(Character.toString(temp.charAt(i)));
			}
		}
		return characters;
		
	}
	
}

