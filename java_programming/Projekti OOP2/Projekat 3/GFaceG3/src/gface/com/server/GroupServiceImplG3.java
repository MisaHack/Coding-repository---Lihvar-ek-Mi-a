package gface.com.server;

import gface.com.client.services.GroupServiceG3;
import gface.com.server.entity.GroupsG3;
import gface.com.server.entity.UserG3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GroupServiceImplG3 extends RemoteServiceServlet implements GroupServiceG3 {
	
	@Override
	public GroupsG3 createGroup(GroupsG3 group) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(group);
			et.commit();
			return group;
		} catch (Exception ex) {
			GWT.log("Neuspesno kreiranje grupe.", ex);
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
	public List<GroupsG3> findUserGroups(UserG3 user) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			TypedQuery<GroupsG3> q = em
					.createNamedQuery("GroupsG3.usersGroups", GroupsG3.class);
			q.setParameter("user", user);
			List<GroupsG3> groups = q.getResultList();
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
