package myrepo.server.repository;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import myrepo.server.business.*;




@WebService
public class TaskRepository {
	private 
	TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
	
	@WebMethod
	public void pairIn(String key, List<Double> values) {
		taskRepository.pairIn(key, values);
	}
	
	@WebMethod
	public List<Double> pairOut(String key) {
		return taskRepository.pairOut(key);
	}
	
	@WebMethod
	public List<Double> readPair(String key) {
		return taskRepository.readPair(key);
	}
	
}



/*
package myrepo.server.repository;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import myrepo.server.business.Task;
import myrepo.server.business.TaskRepositoryImpl;




@WebService
public class TaskRepository {
	private 
	TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
	
	@WebMethod
	public String pairIn(List<Double> values) {
		return taskRepository.pairIn(values);
	}
	
	@WebMethod
	public Task pairOut(String key) {
		return taskRepository.pairOut(key);
	}
	
	@WebMethod
	public Task readPair(String key) {
		return taskRepository.readPair(key);
	}
}
*/