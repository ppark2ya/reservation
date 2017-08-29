package com.myproject.reservation.customer.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.reservation.customer.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SqlSession session;

	@Override
	public void insert(CustomerDto dto) {
		session.insert("customer.insert", dto);
	}

	@Override
	public boolean isValid(CustomerDto dto) {
		CustomerDto resultDto = session.selectOne("customer.isValid", dto);
		if(resultDto == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public CustomerDto getData(String id) {
		return session.selectOne("customer.getData", id);
	}

	@Override
	public void delete(String id) {
		session.delete("customer.delete", id);
	}

	@Override
	public void update(CustomerDto dto) {
		session.update("customer.update", dto);
	}

	@Override
	public boolean canUseId(String id) {
		String result = session.selectOne("customer.isExistId", id);
		System.out.println(result);
		if(result == null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void modifyPwd(CustomerDto dto) {
		session.update("customer.modifyPwd", dto);
	}

}
