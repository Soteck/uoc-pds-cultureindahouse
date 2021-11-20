package org.uoc.pds.alpha.cultureindahouse.ejb.bean;


import org.uoc.pds.alpha.cultureindahouse.ejb.entity.Profile;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.ProfileVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.repository.ProfileRepositoryInterface;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProfileBean implements ProfileLocal, ProfileRemote {

	@EJB
	private ProfileRepositoryInterface profileRepositoryInterface;

	@Override
	public ProfileVO login(String email, String password) {
		Profile profile = profileRepositoryInterface.get(email);
		if (profile.getPassword().equals(password)) {
			return entityToVO(profile);
		}
		return null;
	}

	@Override
	public ProfileVO registerUser(ProfileVO profile) {
		return entityToVO(profileRepositoryInterface.add(voToEntity(profile)));
	}

	@Override
	public ProfileVO updateUser(ProfileVO profile) {
		return entityToVO(profileRepositoryInterface.update(profile.getEmail(), voToEntity(profile)));
	}

	@Override
	public ProfileVO showUser(String email) {
		return entityToVO(profileRepositoryInterface.get(email));
	}

	private Profile voToEntity(ProfileVO profileVO) {
		Profile ret = new Profile();
		ret.setEmail(profileVO.getEmail());
		ret.setName(profileVO.getName());
		ret.setPassword(profileVO.getPassword());
		ret.setSurnames(profileVO.getSurnames());
		ret.setNif(profileVO.getNif());
		ret.setPreferedLanguage(profileVO.getPreferedLanguage());
		ret.setAddress(profileVO.getAddress());
		return ret;
	}

	private ProfileVO entityToVO(Profile profile) {
		ProfileVO ret = new ProfileVO();
		ret.setEmail(profile.getEmail());
		ret.setName(profile.getName());
		ret.setPassword(profile.getPassword());
		ret.setSurnames(profile.getSurnames());
		ret.setNif(profile.getNif());
		ret.setPreferedLanguage(profile.getPreferedLanguage());
		ret.setAddress(profile.getAddress());
		return ret;
	}

	private List<ProfileVO> entityToVO(List<Profile> profiles) {
		List<ProfileVO> ret = new ArrayList<>();
		for (Profile profile : profiles) {
			ret.add(this.entityToVO(profile));
		}
		return ret;
	}

}
