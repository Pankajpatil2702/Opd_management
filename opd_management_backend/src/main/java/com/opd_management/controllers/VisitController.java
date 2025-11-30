package com.opd_management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.opd_management.dtos.VisitDto;
import com.opd_management.entities.Doctor;
import com.opd_management.entities.Patient;
import com.opd_management.entities.Visit;
import com.opd_management.services.DoctorService;
import com.opd_management.services.PatientService;
import com.opd_management.services.VisitService;

@RestController
@RequestMapping("/visit")
public class VisitController {
	
	@Autowired
	private VisitService visitService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	
	/**
	 * @param visitDto
	 * @return
	 */
	
	// Insert Data Into Visit Table ..
	@PostMapping("/")
	public ResponseEntity<Visit> saveVisitEntity(@RequestBody VisitDto visitDto){
		
		Visit visit = new Visit();
		
		visit.setVisit_date(visitDto.getVisit_date());
		visit.setComplaints(visitDto.getComplaints());
		visit.setDiagnosis(visitDto.getDiagnosis());
		visit.setAdvice(visitDto.getAdvice());
		visit.setBp(visitDto.getBp());
		visit.setPulse(visitDto.getPulse());
		visit.setSaturation(visitDto.getSaturation());
		visit.setTemperature(visitDto.getTemperature());
		visit.setRespiration(visitDto.getRespiration());
		visit.setSugar(visitDto.getSugar());
		visit.setFasting_sugar(visitDto.getFasting_sugar());
		visit.setPp_sugar(visitDto.getPp_sugar());
		visit.setRandom_sugar(visitDto.getRandom_sugar());
		visit.setUrea_creatinine(visitDto.getUrea_creatinine());
		visit.setPast_history(visitDto.getPast_history());
		visit.setCurrent_medication(visitDto.getCurrent_medication());
		visit.setAdditional_notes(visitDto.getAdditional_notes());
		visit.setWeight(visitDto.getWeight());
		visit.setEdema(visitDto.getEdema());
		visit.setPallor(visitDto.getPallor());
		visit.setJaundice(visitDto.getJaundice());
		visit.setCvs(visitDto.getCvs());
		visit.setRs(visitDto.getRs());
		visit.setPa(visitDto.getPa());
		visit.setCns(visitDto.getCns());
		visit.setHb(visitDto.getHb());
		visit.setEcg(visitDto.getEcg());
		visit.setFollowup_date(visitDto.getFollowup_date());
		visit.setCreated_at(visitDto.getCreated_at());
		visit.setUpdates_at(visitDto.getUpdates_at());
		
		// Patient Id / Info Using Patient Class and methods
		Patient patient = patientService.getPatientById(visitDto.getDoctorid());
		
		// Doctor Id / Info Using Doctor Class and methods
		Doctor doctor = doctorService.getDoctorById(visitDto.getPatientid());
		
		visit.setPatientid(patient);
		visit.setDoctorid(doctor);
		
		Visit saveVisit = visitService.saveVisit(visit);
		
		return new ResponseEntity<>(saveVisit, HttpStatus.CREATED);
		
	}
	
	// Get All Data From Visit Table
	@GetMapping("/")
	public ResponseEntity<List<Visit>> getAllVisitData(){
		
		List<Visit> visit = visitService.getAllVisit();
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.FOUND);
		}
		
		return new ResponseEntity<>(visit, HttpStatus.FOUND);
				
	}
	
	// Get Specific Id From Visit Table
	@GetMapping("/{id}")
	public ResponseEntity<Visit> getVisitByIdFromTable(@PathVariable("id") int id){
		
		Visit visit = visitService.getVisitByID(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(visit, HttpStatus.FOUND);
		
	}
	
	// update Specific Visit id From Table 
	@PutMapping("/{id}")
	public ResponseEntity<Visit>  upateVisitId(@PathVariable("id") int id,  @RequestBody VisitDto visitDto){
		
		Visit visit = visitService.getVisitByID(id);
		
		visit.setVisit_date(visitDto.getVisit_date());
		visit.setComplaints(visitDto.getComplaints());
		visit.setDiagnosis(visitDto.getDiagnosis());
		visit.setAdvice(visitDto.getAdvice());
		visit.setBp(visitDto.getBp());
		visit.setPulse(visitDto.getPulse());
		visit.setSaturation(visitDto.getSaturation());
		visit.setTemperature(visitDto.getTemperature());
		visit.setRespiration(visitDto.getRespiration());
		visit.setSugar(visitDto.getSugar());
		visit.setFasting_sugar(visitDto.getFasting_sugar());
		visit.setPp_sugar(visitDto.getPp_sugar());
		visit.setRandom_sugar(visitDto.getRandom_sugar());
		visit.setUrea_creatinine(visitDto.getUrea_creatinine());
		visit.setPast_history(visitDto.getPast_history());
		visit.setCurrent_medication(visitDto.getCurrent_medication());
		visit.setAdditional_notes(visitDto.getAdditional_notes());
		visit.setWeight(visitDto.getWeight());
		visit.setEdema(visitDto.getEdema());
		visit.setPallor(visitDto.getPallor());
		visit.setJaundice(visitDto.getJaundice());
		visit.setCvs(visitDto.getCvs());
		visit.setRs(visitDto.getRs());
		visit.setPa(visitDto.getPa());
		visit.setCns(visitDto.getCns());
		visit.setHb(visitDto.getHb());
		visit.setEcg(visitDto.getEcg());
		visit.setFollowup_date(visitDto.getFollowup_date());
		visit.setCreated_at(visitDto.getCreated_at());
		visit.setUpdates_at(visitDto.getUpdates_at());
		
		// to get patient id for show data
		Patient patient = patientService.getPatientById(visitDto.getDoctorid());
		
		Doctor doctor = doctorService.getDoctorById(visitDto.getDoctorid());
		
		visit.setPatientid(patient);
		visit.setDoctorid(doctor);
		
		Visit updateVisit = visitService.saveVisit(visit);
		
		return new ResponseEntity<>(updateVisit, HttpStatus.OK);
		
		
	}
	
	
	// Delete Specific Visit Id From Table
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSpecificVisitId(@PathVariable("id") int id){
		
		Visit visit = visitService.getVisitByID(id);
		
		if(visit == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		visitService.deleteVisiteId(id);
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
}
