package com.company.approval.service;

import java.util.List;

import com.company.approval.entity.Task;

public interface ITaskService {
	public Task createTask(Task task, List<Long> approverIds);
}
