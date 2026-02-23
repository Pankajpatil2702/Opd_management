package com.opd_management.controllers;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opd_management.dtos.Visit_ReportDto;
import com.opd_management.entities.Visit_Report;
import com.opd_management.security.FileStorageUtil;
import com.opd_management.services.VisitService;
import com.opd_management.services.Visit_ReportService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/visitreport")
public class Visit_ReportController {
	
	@Autowired
	private Visit_ReportService visit_ReportService;
	
	// added
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private FileStorageUtil fileStorageUtil;
	
	
	// insert data into visit_report table
	@PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Visit_Report> saveVisit_ReportEntity(@Valid @ModelAttribute Visit_ReportDto visit_ReportDto,
										@RequestPart("file_url") MultipartFile file){
		// valid file
		if(file == null || file.isEmpty()) {
			
			return ResponseEntity.badRequest().body(null);
		}
		
		// save file
		String fileUrl = fileStorageUtil.saveFile(file);
		String fileName = file.getOriginalFilename();
		String fileType = file.getContentType();
		
		// Build file 
		Visit_Report visit_Report = new Visit_Report();
		
		visit_Report.setVisitid(visitService.getVisitByID(visit_ReportDto.getVisitid()));
		visit_Report.setFile_url(fileUrl);
		visit_Report.setFile_name(fileName);
		visit_Report.setFile_type(fileType);
		visit_Report.setCreated_at(LocalDateTime.now());
		
		// save 
		Visit_Report saved = visit_ReportService.saveVisit_Report(visit_Report);
		
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
				
	}
	
	// get all data form visit_report 
	@GetMapping("/")
	public ResponseEntity<List<Visit_Report>> getAllDataFromVisit_Report(){
		
		List<Visit_Report> visit_Report = visit_ReportService.getAllVisit_Report();
		if(visit_Report == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(visit_Report, HttpStatus.OK);
	}
	
	
	// get specific data from visit_report using id
	@GetMapping("/{id}")
	public ResponseEntity<Visit_Report> getSpecificDataFromVisit_ReportUsingId(@PathVariable("id") int id){
		
		Visit_Report visit_Report = visit_ReportService.getVisit_ReportById(id);
		if(visit_Report == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
		}
		return new ResponseEntity<>(visit_Report, HttpStatus.OK);
	}
	
	// update specific id from visit_report table
	@PutMapping(value = "/{id}" , consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Visit_Report> upateSpecificDataFromVisit_ReportUsingId(@PathVariable("id")
										int id,@Valid  @RequestPart Visit_ReportDto visit_ReportDto,
										@RequestPart(value = "file_url", required = false) MultipartFile file){
		
		Visit_Report visit_Report = visit_ReportService.getVisit_ReportById(id);
		if(visit_Report == null) {
			
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
		// update file only id provided
		if(file != null && !file.isEmpty()) {
			
			String fileUrl = fileStorageUtil.saveFile(file);
			visit_Report.setFile_url(fileUrl);
			visit_Report.setFile_name(file.getOriginalFilename());
			visit_Report.setFile_type(file.getContentType());
				
		}
		visit_Report.setVisitid(visitService.getVisitByID(visit_ReportDto.getVisitid()));
		
		Visit_Report visitSaved = visit_ReportService.saveVisit_Report(visit_Report);
		
		return new ResponseEntity<>(visitSaved, HttpStatus.OK);
		
	}
	
	// delete specific id from visit_report table
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSpecificIdFromVisit_Report(@PathVariable("id") int id){
		
		Visit_Report visit_Report = visit_ReportService.getVisit_ReportById(id);
		if(visit_Report == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		visit_ReportService.deleteVisit_ReportId(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	
	
	// download visit report file 
	@GetMapping("/download/{visitid}")
	public ResponseEntity<Resource> downloadVisitReport(@PathVariable long visitid){
		
		// 1️. Fetch all reports for the given visit ID
		List<Visit_Report> reports = visit_ReportService.getVisitReportById(visitid);
		
		// 2️. If no reports found, return 404 Not Found
		if(reports == null || reports.isEmpty()) {
			
			return ResponseEntity.notFound().build();
		}
		
		// 3️. Take the first report (assuming only one per visit)
		Visit_Report report = reports.get(0);
		
		// 4️. Get the file path stored in the database
		String filePathStr = report.getFile_url();  // should match the path returned by saveFile()
		if(filePathStr == null || filePathStr.isBlank()) {
			System.out.println("File url is null  for visit id: " + visitid);
			
			return ResponseEntity.notFound().build();
		}
		
		// 5️. Convert file path string to Path object and normalize it
		Path filePath = Paths.get(filePathStr).normalize();
		
		// 6️. Check if the file exists and is not a directory
		if(!Files.exists(filePath) || Files.isDirectory(filePath)) {
			System.out.println("Files not found or is a directory: " + filePath);
			return ResponseEntity.notFound().build();
		}
		
		// 7️. Create a Resource object for the file
		Resource resource = new FileSystemResource(filePath);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM) // force download
	            .header(HttpHeaders.CONTENT_DISPOSITION,
	                    "attachment; filename=\"" + report.getFile_name() + "\"") // set original file name
	            .body(resource);
	}
	
	

}
