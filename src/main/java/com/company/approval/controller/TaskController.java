package com.company.approval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.approval.entity.Task;
import com.company.approval.service.ITaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private ITaskService taskService;

	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task, @RequestParam List<Long> approvers) {
		return ResponseEntity.ok(taskService.createTask(task, approvers));
	}
}
