package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "_stats", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Stats.findAll", query = "SELECT s FROM Stats s"),
  @NamedQuery(name = "Stats.findByStatkey", query = "SELECT s FROM Stats s WHERE s.statsPK.statkey = :statkey"),
  @NamedQuery(name = "Stats.findByValue", query = "SELECT s FROM Stats s WHERE s.value = :value"),
  @NamedQuery(name = "Stats.findByActorId", query = "SELECT s FROM Stats s WHERE s.statsPK.actorId = :actorId")})
public class Stats implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected StatsPK statsPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 40)
  @Column(name = "value")
  private String value;
  @JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Actor actor;

  public Stats() {
  }

  public Stats(StatsPK statsPK) {
    this.statsPK = statsPK;
  }

  public Stats(StatsPK statsPK, String value) {
    this.statsPK = statsPK;
    this.value = value;
  }

  public Stats(String statkey, int actorId) {
    this.statsPK = new StatsPK(statkey, actorId);
  }

  public StatsPK getStatsPK() {
    return statsPK;
  }

  public void setStatsPK(StatsPK statsPK) {
    this.statsPK = statsPK;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Actor getActor() {
    return actor;
  }

  public void setActor(Actor actor) {
    this.actor = actor;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (statsPK != null ? statsPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Stats)) {
      return false;
    }
    Stats other = (Stats) object;
    if ((this.statsPK == null && other.statsPK != null) || (this.statsPK != null && !this.statsPK.equals(other.statsPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Stats[ statsPK=" + statsPK + " ]";
  }

}
