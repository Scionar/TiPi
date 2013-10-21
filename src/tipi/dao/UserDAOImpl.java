package tipi.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import tipi.bean.UserCompany;
import tipi.bean.UserCompany;
import tipi.bean.UserCompanyImpl;
import tipi.bean.UserProfile;
import tipi.bean.UserProfileImpl;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserProfile getRegisteredUsersInformationDAO(String userEmail,
			UserProfile userProfile) {

		String sql = "SELECT * FROM registeredUsers WHERE email=?;";

		userProfile = (UserProfile) getJdbcTemplate().queryForObject(sql,
				new Object[] { userEmail },
				new BeanPropertyRowMapper(UserProfileImpl.class));

		return userProfile;
	}
	
	@Override
	public UserCompany getRegisteredUsersCompanyInformationDAO(int companyID,
			UserCompany userCompany) {

		String sql = "SELECT * FROM companies WHERE company_id = ?;";

		userCompany = (UserCompany) getJdbcTemplate().queryForObject(sql,
				new Object[] { companyID },
				new BeanPropertyRowMapper(UserCompanyImpl.class));

		return userCompany;
	}
	
	@Override
	public void registerNewCompanyDAO(UserCompany registerCompany){
		
		String sql = "INSERT INTO companies (name, address, postalCode, city) VALUES (?,?,?,?);";
		  
		jdbcTemplate.update(sql, new Object[] { 
		registerCompany.getName(),
		registerCompany.getAddress(),
		registerCompany.getPostalCode(),
		registerCompany.getCity() });
	}
	
	@Override
	public void saveRegisteredUsersNewPassword(String email, String newPassword){		
		System.out.println("DAO: "+email+" "+newPassword);		
		String newPasswordQuery = "UPDATE registeredUsers SET password='"+newPassword+"' WHERE email='"+email+"';";
		System.out.println("Query:");
		System.out.println(newPasswordQuery);
		jdbcTemplate.update(newPasswordQuery);
		System.out.println("Accessed the database...");
	}

}
