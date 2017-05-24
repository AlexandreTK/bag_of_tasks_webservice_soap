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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			//System.out.println(list);
			//System.out.println(listSize);
			double sum = 0;
			for ( Double item : list) {
				sum += item;
			}
			list.clear();
			list.add(sum);
			//list.add((double) listSize);
			
			repository.pairIn("RESULT_"+Integer.toString(slaveID), list);
		}

	}
	
	
}
