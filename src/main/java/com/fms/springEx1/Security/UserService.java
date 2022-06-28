package com.fms.springEx1.Security;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface UserService {
	public List<Uuser> readAll();
	public Uuser saveUuser(Uuser user);
	public Uuser findUuserByUserName(String userName);
	public Uuser readById(long id);
	public void deleteById(long id);
	
	/**
	 * 
	 * @return
	 */
	public long getUserId();
	public Page<Uuser> findByPageByPageAndUserName(String username, Pageable pageable);
	
	
	

}
