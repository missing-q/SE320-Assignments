import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Problem1();
		Problem2();
		Problem3();
	}

	public static void Problem1() {
		System.out.println("Problem 1:");
		//setup
		LinkedHashSet<String> s1 = new LinkedHashSet<>();
		s1.add("George");
		s1.add("Jim");
		s1.add("John");
		s1.add("Blake");
		s1.add("Kevin");
		s1.add("Michael");

		LinkedHashSet<String> s2 = new LinkedHashSet<>();
		s2.add("George");
		s2.add("Katie");
		s2.add("Kevin");
		s2.add("Michelle");
		s2.add("Ryan");

		//union
		LinkedHashSet<String> u1 = (LinkedHashSet<String>)s1.clone();
		LinkedHashSet<String> u2 = (LinkedHashSet<String>)s2.clone();
		u1.addAll(u2);
		System.out.println("Union:");
		System.out.println(u1.toString());

		//intersection
		LinkedHashSet<String> i1 = (LinkedHashSet<String>)s1.clone();
		LinkedHashSet<String> i2 = (LinkedHashSet<String>)s2.clone();
		i1.retainAll(i2);
		System.out.println("Intersection:");
		System.out.println(i1.toString());

		//difference
		LinkedHashSet<String> d1 = (LinkedHashSet<String>)s1.clone();
		LinkedHashSet<String> d2 = (LinkedHashSet<String>)s2.clone();
		d1.removeAll(d2);
		System.out.println("Difference (d1-d2):");
		System.out.println(d1.toString());

		//difference2
		LinkedHashSet<String> d3 = (LinkedHashSet<String>)s1.clone();
		LinkedHashSet<String> d4 = (LinkedHashSet<String>)s2.clone();
		d4.removeAll(d3);
		System.out.println("Difference (d2-d1):");
		System.out.println(d4.toString());
	}

	public static void Problem2() {
		System.out.println("Problem 2:");
		TreeSet<String> container = new TreeSet<>();
		try {
			File in = new File("input.txt");
			Scanner s = new Scanner(in);
			while (s.hasNext()) {
				String t = s.next();
				//trim attached punctuation
				t = t.replace(",", "");
				t = t.replace(".", "");
				t = t.toLowerCase(); //capitals / lowercase makes ascending order weird
				container.add(t);
			}
			s.close();
			System.out.println(container.toString());
		} catch (FileNotFoundException e) { //just in case
			System.out.println("File not found.");
		}
	}
	public static void Problem3() {
		System.out.println("Problem 3:");
		//united kingdom locale
		double d = 12345.678;
		NumberFormat nf = NumberFormat.getInstance(Locale.UK);
		nf.setMaximumFractionDigits(2);
		System.out.println("UK Format w/ 2 decimal points: "+ nf.format(d));
		//us currency format
		NumberFormat nf2 = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("US Currency format: "+ nf2.format(d));
		//parse string into number
		String s = "12,345.678";
		NumberFormat nf3 = NumberFormat.getInstance();
		try {
			System.out.println("Parse into number: " + nf3.parse(s));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
