package com.company.approval.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.approval.entity.Approval;
import com.company.approval.entity.Task;
import com.company.approval.entity.User;
import com.company.approval.exceptions.ResourceNotFoundException;
import com.company.approval.exceptions.UnauthorizedActionException;
import com.company.approval.repository.ApprovalRepository;
import com.company.approval.repository.TaskRepository;
import com.company.approval.repository.UserRepository;

@Service
public class ApprovalServiceImpl implements IApprovalService {
	@Autowired
	private ApprovalRepository approvalRepository;
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserRepository userRepository;

	public String approveTask(Long taskId, Long userId, String comment) {
		Task task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		if (!task.getApproverIds().contains(userId)) {
			throw new UnauthorizedActionException("User not assigned as an approver");
		}

		Approval approval = new Approval();
		approval.setTask(task);
		approval.setApprovedBy(user);
		approval.setComment(comment);
		approvalRepository.save(approval);

		long approvalCount = approvalRepository.countByTask(task);
		if (approvalCount >= 3) {
			task.setStatus("Approved");
			taskRepository.save(task);
			emailService.sendFinalApprovalNotification(task);
		} else {
			emailService.notifyTaskCreator(task.getCreatedBy().getEmail());
		}
		return "Task approved";
	}
}
