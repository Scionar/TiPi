package tipi.dao;

/**
 * @author Lauri Soivi, Joona Viertola, Samuel Kontiomaa
 * @version 1.0
 * @since 18.12.2013
 */

import java.util.List;

import tipi.bean.UserCompany;
import tipi.bean.UserProfile;

public interface UserDAO {

	public abstract UserProfile getRegisteredUsersInformationWithEmailDAO(String userEmail, UserProfile userProfile);
	
	public abstract UserCompany getRegisteredUsersCompanyInformationDAO(int companyID, UserCompany userCompany);
	
	public abstract void registerNewCompanyDAO(UserCompany registerCompany);
	
	public abstract void registerNewUserDAO(UserProfile registerUser);
	
	public abstract List<UserCompany> getAllCompaniesDAO();
	
	public abstract void saveRegisteredUsersNewPassword(int usersId, String newPassword);
	
	public abstract UserProfile getUsersInformationWithIdDAO(int id, UserProfile userProfile);
	
	public abstract void updateCompanyInformationDAO(UserCompany company);
	
	public abstract void updateUserInformationDAO(UserProfile user);
	
	public abstract void changeUserIsActiveStatusDAO(UserProfile user);
	
	public abstract List<UserProfile> getUsersByRoleDAO(int role);
	
}
