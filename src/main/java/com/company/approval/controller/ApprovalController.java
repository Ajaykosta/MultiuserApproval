package com.company.approval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.approval.service.IApprovalService;

@RestController
@RequestMapping("/approvals")
public class ApprovalController {
	@Autowired
	private IApprovalService approvalService;

	@PostMapping("/approve")
	public ResponseEntity<String> approveTask(@RequestParam Long taskId, @RequestParam Long userId,
			@RequestParam String comment) {
		return ResponseEntity.ok(approvalService.approveTask(taskId, userId, comment));
	}
}