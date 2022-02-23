package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class InventoryPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "actor_id")
  private int actorId;
  @Basic(optional = false)
  @NotNull
  @Column(name = "item_id")
  private int itemId;

  public InventoryPK() {
  }

  public InventoryPK(int actorId, int itemId) {
    this.actorId = actorId;
    this.itemId = itemId;
  }

  public int getActorId() {
    return actorId;
  }

  public void setActorId(int actorId) {
    this.actorId = actorId;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) actorId;
    hash += (int) itemId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof InventoryPK)) {
      return false;
    }
    InventoryPK other = (InventoryPK) object;
    if (this.actorId != other.actorId) {
      return false;
    }
    if (this.itemId != other.itemId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.InventoryPK[ actorId=" + actorId + ", itemId=" + itemId + " ]";
  }

}
