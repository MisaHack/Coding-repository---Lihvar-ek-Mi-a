package gface.com.server;

import gface.com.client.services.PostServiceG3;
import gface.com.server.entity.PostG3;
import gface.com.server.entity.UserG3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PostServiceImplG3 extends RemoteServiceServlet implements PostServiceG3  {

	@Override
	public PostG3 createPost(PostG3 post) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(post);
			et.commit();
			return post;
		} catch (Exception ex) {
			GWT.log("Neuspesno kreiranje posta.", ex);
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
	public List<PostG3> findPostsCreatedForUser(UserG3 user) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			TypedQuery<PostG3> q = em
					.createNamedQuery("PostG3.findPostsCreatedForUser", PostG3.class);
			q.setParameter("user", user);
			List<PostG3> posts = q.getResultList();
			return posts;
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
	public List<PostG3> findPostsCreatedByUser(UserG3 user) {
		EntityManager em = EMF.get();
		EntityTransaction et = em.getTransaction();
		try {
			TypedQuery<PostG3> q = em
					.createNamedQuery("PostG3.findPostsCreatedByUser", PostG3.class);
			q.setParameter("user", user);
			List<PostG3> posts = q.getResultList();
			return posts;
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
