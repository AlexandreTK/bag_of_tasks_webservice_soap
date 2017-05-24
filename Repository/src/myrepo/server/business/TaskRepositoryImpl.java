package myrepo.server.business;

import java.util.*;

//Map<String, List<Double>> tasks = Collections.synchronizedMap(new HashMap<String, List<Double>>());

public class TaskRepositoryImpl {
	
	// Hashtable <SlaveID, TaskID>
	Hashtable<String, String> slaveTask = new Hashtable();
	// Hashtable <TaskID, ResultValue(ie:[2])>
	Hashtable<String, List<Double>> doneTasks = new Hashtable();
	// LINKED LIST <TASKID : integer, <VALUES : list of double>>
	LinkedList<AbstractMap.SimpleEntry<String,List<Double>>> todoTasks = new LinkedList<AbstractMap.SimpleEntry<String,List<Double>>>();  
	
	
	// Keys used:
	//  * <TASKID-anything>
	//  * RESULT_<SLAVEID>
	//  * 
	// TODO: Return -1 if error...
	public void pairIn(String key, List<Double> value) {
		if (key.startsWith("RESULT_")) {

			String slaveID = key.substring(7);
			if (key.length() > 7) {
				String taskID = slaveTask.get(slaveID);
				String keyToSave = "DONE_" + taskID;
				doneTasks.put(keyToSave, value);
				// Remove slave from map
				slaveTask.remove(slaveID);
			}
		}
		else {
			AbstractMap.SimpleEntry<String,List<Double>> task = new AbstractMap.SimpleEntry(key, value);
			todoTasks.add(task);
		}

	}
	
	// Keys used:
	//	* <TASKID-anything>
	//  * DONE_<TASKID>
	//  * NEXT_<SLAVEID>
	public List<Double> pairOut(String key) {
		List<Double> returnTask = null;
		

		if (key.startsWith("DONE_")) {
			List<Double> task = doneTasks.get(key);
			doneTasks.remove(key);
			returnTask = task;
			
		}

		else if (key.startsWith("NEXT_")) {
			
			String slaveID = key.substring(5);
			if (!slaveTask.containsKey(slaveID)) {
				if (key.length() > 5) {
					if (!todoTasks.isEmpty()) {
						AbstractMap.SimpleEntry<String,List<Double>> nextTask = todoTasks.removeFirst();
						slaveTask.put(slaveID, nextTask.getKey());
						returnTask = nextTask.getValue();
					
					}
				}
			}
			
		}
		else {
			//todoTasks
			for(AbstractMap.SimpleEntry<String,List<Double>> todoTask : todoTasks) {
				if (todoTask.getKey().equals(key)) {
					returnTask = todoTask.getValue();
					todoTasks.remove(todoTask);
				}
			}
		}
		
		return returnTask;
	}
	
	public List<Double> readPair(String key) {
		List<Double> returnTask = null;
		if (key.startsWith("DONE_")) {
			
			List<Double> task = doneTasks.get(key);
			returnTask = task;
			
		}

		else if (key.startsWith("NEXT_")) {
			
			String slaveID = key.substring(5);
			if (!slaveTask.containsKey(slaveID)) {
				if (!(todoTasks.isEmpty())) {
					AbstractMap.SimpleEntry<String,List<Double>> nextTask = todoTasks.getFirst();
					returnTask = nextTask.getValue();
				}
			}
		}
		else {
			//todoTasks
			for(AbstractMap.SimpleEntry<String,List<Double>> todoTask : todoTasks) {
				if (todoTask.getKey().equals(key)) {
					returnTask = todoTask.getValue();
				}
			}
		}
		
		return returnTask;
	}
}

