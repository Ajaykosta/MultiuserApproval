package com.company.approval.service;

import com.company.approval.entity.User;

public interface IAuthService {
	public String signup(User user);

	public String login(User user);
}
