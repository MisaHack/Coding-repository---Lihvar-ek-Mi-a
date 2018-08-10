package gface.com.server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Pomocni Entity Manager Factory objekat. Na App Engine-u ne funkcionise @PersistenceContext.
 *
 * @author <a href="mailto:mitrovic.dejan@gmail.com">Dejan Mitrovic</a>
 */
public class EMF {
	// kreiranje EntityManagerFactory objekta je jako sporo, te se preporucuje samo jedna instanca
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("transactions-optional");

	public static EntityManager get() {
		return emf.createEntityManager();
	}
}
