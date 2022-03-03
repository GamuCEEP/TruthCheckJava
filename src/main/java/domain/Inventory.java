package domain;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "_inventory", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
  @NamedQuery(name = "Inventory.findByAmount", query = "SELECT i FROM Inventory i WHERE i.amount = :amount"),
  @NamedQuery(name = "Inventory.findByActorId", query = "SELECT i FROM Inventory i WHERE i.inventoryPK.actorId = :actorId"),
  @NamedQuery(name = "Inventory.findByItemId", query = "SELECT i FROM Inventory i WHERE i.inventoryPK.itemId = :itemId")})
public class Inventory implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected InventoryPK inventoryPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "amount")
  private float amount;
  @JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @JsonbTransient
  private Actor actor;
  @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Item item;

  public Inventory() {
  }

  public Inventory(InventoryPK inventoryPK) {
    this.inventoryPK = inventoryPK;
  }

  public Inventory(InventoryPK inventoryPK, float amount) {
    this.inventoryPK = inventoryPK;
    this.amount = amount;
  }

  public Inventory(int actorId, int itemId) {
    this.inventoryPK = new InventoryPK(actorId, itemId);
  }

  public InventoryPK getInventoryPK() {
    return inventoryPK;
  }

  public void setInventoryPK(InventoryPK inventoryPK) {
    this.inventoryPK = inventoryPK;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public Actor getActor() {
    return actor;
  }

  public void setActor(Actor actor) {
    this.actor = actor;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (inventoryPK != null ? inventoryPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Inventory)) {
      return false;
    }
    Inventory other = (Inventory) object;
    if ((this.inventoryPK == null && other.inventoryPK != null) || (this.inventoryPK != null && !this.inventoryPK.equals(other.inventoryPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Inventory[ inventoryPK=" + inventoryPK + " ]";
  }

}
