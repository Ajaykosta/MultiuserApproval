package com.company.approval.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.approval.entity.Task;
import com.company.approval.repository.TaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private EmailService emailService;

	public Task createTask(Task task, List<Long> approverIds) {
		task.setApproverIds(approverIds);
		Task savedTask = taskRepository.save(task);
		emailService.sendTaskCreationEmails(approverIds);
		return savedTask;
	}
}
