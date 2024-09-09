package com.davidcip.taskbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	private TaskRepository tRepo;
	
	@GetMapping("/tasksGetList")
	public List<Task> test() {
		return tRepo.findAll();
	}
	
	@GetMapping("/taskAdd/{id}")
	public Task taskAdd(@PathVariable("id") String id) {
		Task taskToSave = new Task();
		taskToSave.setFinalized(false);
		taskToSave.setTaskName(id);
		return tRepo.save(taskToSave);
	}
	
	@GetMapping("/taskRemoveByName/{id}")
	public void taskRemoveByName(@PathVariable("id") String id) {
		tRepo.deleteByName(id);
	}
	
	@GetMapping("/taskRemoveAll")
	public void taskRemoveAll() {
		tRepo.deleteAll();
	}
	
	@GetMapping("/taskSwitchFinalized/{id}")
	public Task taskSwitchFinalized(@PathVariable("id") String id) {
		Optional<Task> toSwitch = tRepo.findTaskByTaskName(id);
		
        if(toSwitch.isEmpty())
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        Task taskToSwitch = toSwitch.get();
        taskToSwitch.setFinalized(!taskToSwitch.getFinalized());
        return tRepo.save(taskToSwitch);
	}
}
