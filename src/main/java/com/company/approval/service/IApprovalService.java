package com.company.approval.service;

public interface IApprovalService {
	public String approveTask(Long taskId, Long userId, String comment);
}