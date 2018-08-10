package gface.com.server;

import java.util.List;

import gface.com.client.services.UserGroupServiceG3;
import gface.com.server.entity.GroupsG3;
import gface.com.server.entity.UserG3;
import gface.com.server.entity.UserGroupG3;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class UserGroupServiceImplG3 extends RemoteServiceServlet implements UserGroupServiceG3  {

	@Override
	public UserGroupG3 createUserGroup(UserGroupG3 group) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(group);
			et.commit();
			return group;
		} catch (Exception ex) {
			GWT.log("Neuspesno dodavanje folovera.", ex);
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
	public List<UserGroupG3> findFollowing(UserG3 user) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			TypedQuery<UserGroupG3> q = em
					.createNamedQuery("UserGroupG3.findFollowing", UserGroupG3.class);
			q.setParameter("user", user);
			List<UserGroupG3> groups = q.getResultList();
			return groups;
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
