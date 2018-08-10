package gface.com.server;

import gface.com.client.services.UserService;
import gface.com.server.entity.UserG3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserServiceImpl extends RemoteServiceServlet implements UserService {
	private static final long serialVersionUID = 1L;

	@Override
	public UserG3 register(UserG3 user) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(user);
			et.commit();
			return user;
		} catch (Exception ex) {
			GWT.log("Neuspesno registrovanje.", ex);
			System.out.println("prslo sve");
			ex.printStackTrace();
			if (et.isActive()) {
				et.rollback();
			}
			return null;
		} finally {
			em.close();
		}
	}
	
	@Override
	public UserG3 login(String username, String password) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			System.out.println("Usao u login za username: " + username + " pass " + password);
			TypedQuery<UserG3> q = em
					.createNamedQuery("UserG3.login", UserG3.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			UserG3 user = q.getSingleResult();
			System.out.println(" korisnik " + user);
			return user;
		}catch (NoResultException nre) {
			System.out.println(" nema nista");
			return null;
		} catch (Exception ex) {
			GWT.log("Neuspesno logovanje.", ex);
			System.out.println(" greska");
			if (et.isActive()) {
				et.rollback();
			}
			return null;
		} finally {
			em.close();
		}
	}
	
	@Override
	public List<UserG3> findUsers(String user) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			TypedQuery<UserG3> q = em
					.createNamedQuery("UserG3.findUser", UserG3.class);
			q.setParameter("user", user);
			List<UserG3> users = q.getResultList();
			System.out.println(" korisnik " + user);
			return users;
		}catch (NoResultException nre) {
			System.out.println(" nema nista");
			return null;
		} catch (Exception ex) {
			GWT.log("Neuspesno logovanje.", ex);
			System.out.println(" greska");
			if (et.isActive()) {
				et.rollback();
			}
			return null;
		} finally {
			em.close();
		}
	}
	
}
