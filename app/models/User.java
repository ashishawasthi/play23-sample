package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model {

	@Id
	private String id;
	@Required
	private String fullName;
	@Required
	private String email;
	private String preferredName;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreferredName() {
		return preferredName;
	}
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}
	public static User create(AuthUser authUser) {
		// TODO Auto-generated method stub
		return null;
	}
	public static User findByAuthUserIdentity(AuthUserIdentity identity) {
		// TODO Auto-generated method stub
		return null;
	}
	public static boolean existsByAuthUserIdentity(AuthUser authUser) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void addLinkedAccount(AuthUser oldUser, AuthUser newUser) {
		// TODO Auto-generated method stub
		
	}
	public static void merge(AuthUser oldUser, AuthUser newUser) {
		// TODO Auto-generated method stub
		
	}
}
