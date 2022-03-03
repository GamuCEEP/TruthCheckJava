package domain;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class StatsPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 40)
  @Column(name = "statkey")
  private String statkey;
  @Basic(optional = false)
  @NotNull
  @Column(name = "actor_id")
  private int actorId;

  public StatsPK() {
  }

  public StatsPK(String statkey, int actorId) {
    this.statkey = statkey;
    this.actorId = actorId;
  }

  public String getStatkey() {
    return statkey;
  }

  public void setStatkey(String statkey) {
    this.statkey = statkey;
  }

  public int getActorId() {
    return actorId;
  }

  public void setActorId(int actorId) {
    this.actorId = actorId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (statkey != null ? statkey.hashCode() : 0);
    hash += (int) actorId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof StatsPK)) {
      return false;
    }
    StatsPK other = (StatsPK) object;
    if ((this.statkey == null && other.statkey != null) || (this.statkey != null && !this.statkey.equals(other.statkey))) {
      return false;
    }
    if (this.actorId != other.actorId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.StatsPK[ statkey=" + statkey + ", actorId=" + actorId + " ]";
  }

}
