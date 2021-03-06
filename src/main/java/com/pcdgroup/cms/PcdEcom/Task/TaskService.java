package com.pcdgroup.cms.PcdEcom.Task;

import java.util.List;

public interface TaskService {

	public String createTask(Taskmaster taskmaster);
	public Taskmaster getTask(Integer taskid);
	public List<Taskmaster> getAllTasks();
	public String deleteTask(Integer taskid);
	public String updateTask(Taskmaster taskmaster, Integer taskid);
	public List<?> getTaskByWorkingarea(String brand, String tasktype, Integer index);
	
}
