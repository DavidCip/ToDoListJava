package com.davidcip.taskbackend;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.*;

import javax.validation.constraints.NotBlank;

@Document(collection="tasks")
public class Task {
	@Id
	private String id;
	
	@NotBlank(message = "taskName is mandatory")
	private String taskName;
	
	private Boolean Finalized;

	public Boolean getFinalized() {
		return Finalized;
	}
	public void setFinalized(Boolean finalized) {
		Finalized = finalized;
	}
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName; 
	}
	
	public String getId() {
		return this.id;
	}

}