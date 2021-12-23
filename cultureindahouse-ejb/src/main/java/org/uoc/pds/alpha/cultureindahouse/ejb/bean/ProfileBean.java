package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.entity.User;
import org.uoc.pds.alpha.cultureindahouse.ejb.mapper.UserMapper;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.UserRepositoryInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class ProfileBean implements ProfileLocal, ProfileRemote {

	@EJB
	private UserRepositoryInterface userRepository;

	@Override
	public UserVO login(String email, String password) {
		User user = userRepository.get(email);
		if (user.getPassword().equals(password)) {
			return UserMapper.toVO(user);
		}
		return null;
	}

	@Override
	public UserVO registerUser(UserVO profile) {
		return UserMapper.toVO(userRepository.add(UserMapper.toEntity(profile)));
	}

	@Override
	public UserVO updateUser(UserVO profile) {
		return UserMapper.toVO(userRepository.update(profile.getEmail(), UserMapper.toEntity(profile)));
	}

	@Override
	public UserVO showUser(String email) {
		return UserMapper.toVO(userRepository.get(email));
	}





}
