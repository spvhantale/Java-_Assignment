package com.problem5;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<Student> ls=new ArrayList<>();

ls.add(new Student(101, "Swapnil",450, "spvhantle@gmail.com", "123456", new Address("Maha", "Latur", "412410")));
ls.add(new Student(102, "Ranjit",450, "spvhantle@gmail.com", "789456", new Address("Maha", "Jalna", "412410")));
ls.add(new Student(103, "Kunal",450, "spvhantle@gmail.com", "789621", new Address("Maha", "Pune", "412410")));
ls.add(new Student(104, "Vhantale",450, "spvhantle@gmail.com", "754563421", new Address("Maha", "Mumbai", "412410")));
ls.add(new Student(105, "Hole",450, "spvhantle@gmail.com", "87541875", new Address("Maha", "Nagpur", "412410")));
ls.add(new Student(106, "Sawant",450, "spvhantle@gmail.com", "78547854", new Address("Maha", "Solapur", "412410")));

try {
	FileOutputStream file=new FileOutputStream("studentdata.txt");
		ObjectOutputStream output=new ObjectOutputStream(file);
		output.writeObject(ls);
		output.close();
		System.out.println("Done");

} catch (Exception e) {
	// TODO Auto-generated catch block
System.out.println("Wrong Entry");
}


	}

}