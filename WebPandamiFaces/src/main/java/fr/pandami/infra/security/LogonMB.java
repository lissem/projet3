package fr.pandami.infra.security;

import com.github.adminfaces.template.session.AdminSession;

import fr.pandami.entity.User;
import fr.pandami.ibusiness.AccountIBusiness;

import org.omnifaces.util.Faces;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

import static fr.pandami.util.Utils.addDetailMessage;
import com.github.adminfaces.template.config.AdminConfig;
import javax.inject.Inject;

/**
 * Created by rmpestano on 12/20/14.
 *
 * This is just a login example.
 *
 * AdminSession uses isLoggedIn to determine if user must be redirect to login page or not.
 * By default AdminSession isLoggedIn always resolves to true so it will not try to redirect user.
 *
 * If you already have your authorization mechanism which controls when user must be redirect to initial page or logon
 * you can skip this class.
 */
@Named
@SessionScoped
@Specializes
public class LogonMB extends AdminSession implements Serializable {
	
	
    private String currentUser;
    private User user;
    private String email;
    private String password;
    private boolean remember;
    @Inject
    private AdminConfig adminConfig;
    @EJB
	private AccountIBusiness proxyCompteBu;


    public void login() throws IOException {
    	
    	user = proxyCompteBu.connexion(email, password);
    	
        if (user.getPassword()!=null) {
			addDetailMessage("Logged in successfully as <b>" + user.getFirstName() + "</b>");
        Faces.getExternalContext().getFlash().setKeepMessages(true);
        Faces.redirect(adminConfig.getIndexPage());
		}
        
    }

    @Override
    public boolean isLoggedIn() {

        return currentUser != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}
