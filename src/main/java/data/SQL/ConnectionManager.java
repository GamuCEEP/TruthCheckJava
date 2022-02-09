package data.SQL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class ConnectionManager {

  @PersistenceUnit(name = "TruthCheckJava")
  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(
          "TruthCheckJava");
  @PersistenceContext(unitName = "TruthCheckJava")
  private static EntityManager em = emf.createEntityManager();

  public static EntityManager getEM() {
    return em;
  }

}
