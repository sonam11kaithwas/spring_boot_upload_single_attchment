package com.example.attchment_services_pkg;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


public interface AttchmentServices {
	public ResponseEntity<Object> uploadAttchment(@RequestParam("file") MultipartFile file) ;
	public ResponseEntity<Object> attchmentApi();
	
	public ResponseEntity<Object> getListFiles() ;

}
