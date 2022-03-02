

package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "_trigger")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Trigger.findAll", query = "SELECT t FROM Trigger t"),
  @NamedQuery(name = "Trigger.findByInteractionId", query = "SELECT t FROM Trigger t WHERE t.interactionId = :interactionId")})
public class Trigger implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "interaction_id")
  private Integer interactionId;
  @JoinColumn(name = "interaction_id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false, fetch = FetchType.EAGER)
  private Interaction interaction;
  @JoinColumn(name = "item_id", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Item itemId;

  public Trigger() {
  }

  public Trigger(Integer interactionId) {
    this.interactionId = interactionId;
  }

  public Integer getInteractionId() {
    return interactionId;
  }

  public void setInteractionId(Integer interactionId) {
    this.interactionId = interactionId;
  }

  public Interaction getInteraction() {
    return interaction;
  }

  public void setInteraction(Interaction interaction) {
    this.interaction = interaction;
  }

  public Item getItemId() {
    return itemId;
  }

  public void setItemId(Item itemId) {
    this.itemId = itemId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (interactionId != null ? interactionId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Trigger)) {
      return false;
    }
    Trigger other = (Trigger) object;
    if ((this.interactionId == null && other.interactionId != null) || (this.interactionId != null && !this.interactionId.equals(other.interactionId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Trigger[ interactionId=" + interactionId + " ]";
  }

}
