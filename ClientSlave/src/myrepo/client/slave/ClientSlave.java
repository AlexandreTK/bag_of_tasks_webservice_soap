package myrepo.client.slave;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import myrepo.server.repository.TaskRepository;
import myrepo.server.repository.TaskRepositoryService;

public class ClientSlave {


	public static void main(String[] args) {
		TaskRepositoryService service = new TaskRepositoryService();
		
		TaskRepository repository = service.getTaskRepositoryPort();
		
		List<Double> list = new ArrayList<Double>();
		int listSize;
		Random rand = new Random();
		
		while (true) {
			int slaveID = rand.nextInt();
			list = repository.pairOut("NEXT_"+Integer.toString(slaveID));
			listSize = list.size();
			if (listSize == 0) {	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			System.out.println(list);

			// Summing the elements
			/*
			double sum = 0;
			for ( Double item : list) {
				sum += item;
			}
			list.clear();
			list.add(sum);
			*/
			
			List<Double> row = list.subList(0, list.size()/2);
			List<Double> column = list.subList(list.size()/2, list.size());
			double sum = 0;
			for (int i=0;i<list.size()/2; i++) {
				sum += row.get(i).doubleValue() * column.get(i).doubleValue();
			}
			list.clear();
			list.add(sum);
			
			
			repository.pairIn("RESULT_"+Integer.toString(slaveID), list);
		}

	}
	
	
}
