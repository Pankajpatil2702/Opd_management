package com.opd_management.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

//FrontEnd Data Temporary Store   
public class Visit_ReportDto {
//	
//	@NotBlank(message = "File name is required")
//    private String file_name;
//
//    @NotBlank(message = "File URL is required")
//    private String file_url;
//
//    @NotBlank(message = "File type is required")
//    private String file_type;
//
//    @NotBlank(message = "Created date is required")
//    // Format: 2025-12-11 OR 2025/12/11
//    @Pattern(
//        regexp = "^\\d{4}[-/]\\d{2}[-/]\\d{2}$",
//        message = "Date must be in format YYYY-MM-DD"
//    )
//    private String created_at;	
    
    @NotNull(message = "Id must be required")
	@Positive(message = "ID must be positive")
	private int visitid;

//	public String getFile_name() {
//		return file_name;
//	}
//
//	public void setFile_name(String file_name) {
//		this.file_name = file_name;
//	}
//
//	public String getFile_url() {
//		return file_url;
//	}
//
//	public void setFile_url(String file_url) {
//		this.file_url = file_url;
//	}
//
//	public String getFile_type() {
//		return file_type;
//	}
//
//	public void setFile_type(String file_type) {
//		this.file_type = file_type;
//	}
//
//	public String getCreated_at() {
//		return created_at;
//	}
//
//	public void setCreated_at(String created_at) {
//		this.created_at = created_at;
//	}
//
	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}
//
//	
}
