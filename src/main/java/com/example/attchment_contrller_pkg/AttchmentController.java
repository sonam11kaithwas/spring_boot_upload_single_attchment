package com.example.attchment_contrller_pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.attchment_services_pkg.AttchmentServices;


@RestController
@RequestMapping("/attchments/")
public class AttchmentController {
	
	@Autowired
	private AttchmentServices attchmentServices; 

	@PostMapping("upload_attchment")
	public ResponseEntity<Object> uploadAttchment(@RequestParam("file") MultipartFile file)
	{
		return attchmentServices.uploadAttchment(file);
	}

	@GetMapping("attchment_start")
	public ResponseEntity<Object> attchmentApi()
	{
		return attchmentServices.attchmentApi();
	}
	@GetMapping("all_attchment_list")
	public ResponseEntity<Object> getListFiles()
	{
		return attchmentServices.getListFiles();
	}


}
