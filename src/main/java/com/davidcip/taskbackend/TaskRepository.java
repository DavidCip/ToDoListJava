package com.davidcip.taskbackend;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {	
	@Query( value = "{'taskName' : ?0}", delete = true)
	public void deleteByName(String taskName);
	
    @Query("{ 'taskName' : ?0 }")
    Optional<Task> findTaskByTaskName(String taskName);
}
