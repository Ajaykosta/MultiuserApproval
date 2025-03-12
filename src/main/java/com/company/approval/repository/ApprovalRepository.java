package com.company.approval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.approval.entity.Approval;
import com.company.approval.entity.Task;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
	long countByTask(Task task);
}
