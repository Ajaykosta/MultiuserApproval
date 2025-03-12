package com.company.approval.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.company.approval.entity.Task;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	public void sendTaskCreationEmails(List<Long> approverIds) {
		// Fetch emails and send notifications
	}

	public void notifyTaskCreator(String creatorEmail) {
		sendEmail(creatorEmail, "Task Approval Update", "Someone approved your task!");
	}

	public void sendFinalApprovalNotification(Task task) {
		sendEmail(task.getCreatedBy().getEmail(), "Task Fully Approved", "Your task is now approved by 3 users.");
	}

	private void sendEmail(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);
	}
}