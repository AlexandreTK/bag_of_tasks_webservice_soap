package myrepo.client.master;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import myrepo.server.repository.TaskRepository;
import myrepo.server.repository.TaskRepositoryService;

public class ClientMaster {
	
	public static void main(String[] args) {
		
		TaskRepositoryService service = new TaskRepositoryService();
		
		TaskRepository repository = service.getTaskRepositoryPort();
		

		List<Double> sentTask = new LinkedList<>();
		sentTask.add(5.0);
		sentTask.add(4.0);
		sentTask.add(3.0);
		
		repository.pairIn("TaskTest1", sentTask);
		
		sentTask.add(2.0);
		repository.pairIn("TaskTest2", sentTask);
		
		List<Double> receivedTask;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		receivedTask = repository.readPair("TaskTest1");
		
		System.out.println(receivedTask);
		
		receivedTask = repository.readPair("TaskTest2");
		
		System.out.println(receivedTask);
		
		
		
		
		receivedTask = repository.readPair("DONE_TaskTest2");
		System.out.println(receivedTask);
		

//		List<Double> list = new ArrayList<Double>();
//		list.add(10.3);
//		list.add(10.5);
//		list.add(10.7);
//		result = repository.pairIn("TASK", list);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(Integer.toString(result) +") Values received:");
//		System.out.println( "task:" + repository.readPair(Integer.toString(result) + "_TASK") );
//		System.out.println( "task:" + repository.readPair(Integer.toString(result) + "_TASK_1") );
//		System.out.println( "task:" + repository.readPair(Integer.toString(result) + "_TASK_2") );
//		System.out.println( "result:" + repository.readPair(Integer.toString(result) + "_RESULT") );
//			
//		
//		
//		list.clear();
//		list.add(11.3);
//		list.add(11.5);
//		list.add(11.7);
//		list.add(11.9);
//		list.add(12.1);
//		result = repository.pairIn("TASK", list);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(Integer.toString(result) +") Values received:");
//		System.out.println( "task:" + repository.readPair(Integer.toString(result) + "_TASK") );
//		System.out.println( "task:" + repository.readPair(Integer.toString(result) + "_TASK_1") );
//		System.out.println( "task:" + repository.readPair(Integer.toString(result) + "_TASK_2") );
//		System.out.println( "task:" + repository.readPair(Integer.toString(result) + "_TASK_3") );
//		System.out.println( "result:" + repository.readPair(Integer.toString(result) + "_RESULT") );

	
		
	}
}
