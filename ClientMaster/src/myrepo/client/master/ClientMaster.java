package myrepo.client.master;

import java.util.LinkedList;
import java.util.List;

import myrepo.server.repository.TaskRepository;
import myrepo.server.repository.TaskRepositoryService;

public class ClientMaster {
	
	public static void main(String[] args) {
		
		TaskRepositoryService service = new TaskRepositoryService();
		
		TaskRepository repository = service.getTaskRepositoryPort();
		

		List<Double> sentTask = new LinkedList<>();
		sentTask.add(5.0); sentTask.add(4.0); sentTask.add(3.0); sentTask.add(2.0);
		// [5.0, 4.0]*[3.0, 2.0]
		repository.pairIn("TaskTest1", sentTask);
		
		
		sentTask.add(6.0); sentTask.add(1.0);
		// [5.0, 4.0, 3.0]*[2.0, 6.0, 1.0]
		repository.pairIn("TaskTest2", sentTask);

		sentTask.add(6.0); sentTask.add(1.0);
		// [5.0, 4.0, 3.0, 2.0]*[6.0, 1.0, 6.0, 1.0]
		repository.pairIn("TaskTest3", sentTask);
		
		List<Double> receivedTask;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		receivedTask = repository.pairOut("DONE_TaskTest2");
		System.out.println("Task 2:" + receivedTask);
	
		receivedTask = repository.pairOut("DONE_TaskTest1");
		System.out.println("Task 1:" + receivedTask);
		
		receivedTask = repository.pairOut("DONE_TaskTest3");
		System.out.println("Task 3:" + receivedTask);
	
	}
}
