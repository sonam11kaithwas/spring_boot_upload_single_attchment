package com.example_attchment_utills_pkg;

import java.nio.file.Path;
import java.nio.file.Paths;

final public class AttchmentUtills {
	private  AttchmentUtills() {
	    // restrict instantiation

	}
	
	public static final String folderPath =  "addnewattchment-files//";
	  public static final Path filePath = Paths.get(folderPath);
}
