package com.company.approval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.approval.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
