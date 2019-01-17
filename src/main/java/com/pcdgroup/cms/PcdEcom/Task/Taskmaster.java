package com.pcdgroup.cms.PcdEcom.Task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taskmaster")
public class Taskmaster {

	@Id
	@Column(name="taskid")
	private Integer taskid;
	
	@Column(name="taskname")
	private String taskname;
	
	@Column(name="taskduraton")
	private String taskduraton;

	@Column(name="brand")
	private String brand;
	
	@Column(name="tasktype")
	private String tasktype;
	
	public Taskmaster() {
		super();
	}

	public Taskmaster(Integer taskid, String taskname, String taskduraton, String brand, String tasktype) {
		super();
		this.taskid = taskid;
		this.taskname = taskname;
		this.taskduraton = taskduraton;
		this.brand = brand;
		this.tasktype = tasktype;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskduraton() {
		return taskduraton;
	}

	public void setTaskduraton(String taskduraton) {
		this.taskduraton = taskduraton;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	
}
