package com.myproject.reservation.customer.dao;

import com.myproject.reservation.customer.dto.CustomerDto;

public interface CustomerDao {
	public void insert(CustomerDto dto);
	public boolean isValid(CustomerDto dto);
	public CustomerDto getData(String id);
	public void delete(String id);
	public void update(CustomerDto dto);
	public boolean canUseId(String id);
	public void modifyPwd(CustomerDto dto);
}
