package com.example.attchment_service_impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.attchment_repositry.AttchmentRepositry;
import com.example.attchment_services_pkg.AttchmentServices;
import com.example_attchment_utills_pkg.AttchmentUtills;


@Service
public class AtchmentServicesImple implements AttchmentServices {

	@Autowired
	AttchmentRepositry attchmentRepositry;
	
	
	@Override
	public ResponseEntity<Object> attchmentApi() {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Now you Upload Attchmnt!!!" );
        }

	@Override
	public ResponseEntity<Object> uploadAttchment(@RequestParam("file") MultipartFile file) {
		
		try {
            createDirIfNotExist();

            byte[] bytes = new byte[0];
            bytes = file.getBytes();
            Files.write(Paths.get(AttchmentUtills.folderPath + file.getOriginalFilename()), bytes);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Files uploaded successfully: " + file.getOriginalFilename());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body("Exception occurred for: " + file.getOriginalFilename() + "!");
        }
		
	}

	/**
     * Create directory to save files, if not exist
     */
    private void createDirIfNotExist() {
        //create directory to save the files
        File directory = new File(AttchmentUtills.folderPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

	@Override
	public ResponseEntity<Object> getListFiles() {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.OK)	.body(new File(AttchmentUtills.folderPath).list());}

    /**
     * Method to get the list of files from the file storage folder.
     *
     * @return file
     */
    
    
//    @GetMapping("/files")
//    public ResponseEntity<Object> getListFiles() {
//        return ResponseEntity.status(HttpStatus.OK)
//        		.body(new File(AttchmentUtills.folderPath).list());
//    }

}
