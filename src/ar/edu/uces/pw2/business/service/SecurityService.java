package ar.edu.uces.pw2.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.uces.pw2.business.dao.AuthorityDao;
import ar.edu.uces.pw2.business.dao.UserDao;
import ar.edu.uces.pw2.business.domain.Authority;
import ar.edu.uces.pw2.business.domain.User;
import ar.edu.uces.pw2.util.MD5Encriptator;

@Service
public class SecurityService {

	private UserDao userDao;
	private AuthorityDao authorityDao;

	public SecurityService() {
		super();
	}

	@Autowired
	public SecurityService(UserDao userDao, AuthorityDao authorityDao) {
		super();

		this.userDao = userDao;
		this.authorityDao = authorityDao;
	}

	public List<User> findAllUsers(){
		return userDao.findAll();
	}

	public List<Authority> findAllAuthorities(){
		return authorityDao.findAll();
	}

	public User findUserByName(String name){
		return userDao.findByName(name);
	}

	public User findUserByEmail(String email){
		return userDao.findByEmail(email);
	}

	public List<Authority> findAuthoritiesByUser(String name){

		List<Authority> authorities = null;
		User user = userDao.findByName(name);

		if (user.getAuthorities() != null){
			authorities = user.getAuthorities();
		}

		return authorities;
	}
	
	public Authority findAuthoritiesByName(String authorityName){

		return authorityDao.findByName(authorityName);
	}

	public User saveUser(User userToSave){

		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(findAuthoritiesByName("ROLE_USER"));

		String passEncripted = MD5Encriptator.getMD5EncryptedValue(userToSave.getPassword());
		userToSave.setPassword(passEncripted);
		userToSave.setAuthorites(authorities);
		return userDao.save(userToSave);
	}

	public User updateUser(User userToUpdate){
		return userDao.update(userToUpdate);
	}

	public boolean validateCredentias(String userName, String userPass) {

		boolean isValidUser = false;
		User user = this.findUserByName(userName);

		if (user != null && user.getPassword().equals(userPass)){
			isValidUser = true;
		}

		return isValidUser;
	}

}
