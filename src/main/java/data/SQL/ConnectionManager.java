package data.SQL;

import javax.persistence.*;

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
