package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "item", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
  @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
  @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
  @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description")})
public class Item implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 40)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 400)
  @Column(name = "description")
  private String description;
  @ManyToMany(mappedBy = "itemCollection")
  @JsonbTransient
  private Collection<Actor> actorCollection;
  @ManyToMany(mappedBy = "itemCollection")
  @JsonbTransient
  private Collection<Interaction> interactionCollection;
  @JoinTable(name = "_user_has_item", joinColumns = {
    @JoinColumn(name = "item_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "user_id", referencedColumnName = "id")})
  @ManyToMany
  @JsonbTransient
  private Collection<User> userCollection;
  @JoinColumn(name = "effect_id", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Effect effectId;
  @JoinColumn(name = "author", referencedColumnName = "id")
  @ManyToOne(optional = false)
  @JsonbTransient
  private User author;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
  @JsonbTransient
  private Collection<Trigger> triggerCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
  @JsonbTransient
  private Collection<Inventory> inventoryCollection;

  public Item() {
  }

  public Item(Integer id) {
    this.id = id;
  }

  public Item(Integer id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @XmlTransient
  public Collection<Actor> getActorCollection() {
    return actorCollection;
  }

  public void setActorCollection(Collection<Actor> actorCollection) {
    this.actorCollection = actorCollection;
  }

  @XmlTransient
  public Collection<Interaction> getInteractionCollection() {
    return interactionCollection;
  }

  public void setInteractionCollection(Collection<Interaction> interactionCollection) {
    this.interactionCollection = interactionCollection;
  }

  @XmlTransient
  public Collection<User> getUserCollection() {
    return userCollection;
  }

  public void setUserCollection(Collection<User> userCollection) {
    this.userCollection = userCollection;
  }

  public Effect getEffectId() {
    return effectId;
  }

  public void setEffectId(Effect effectId) {
    this.effectId = effectId;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @XmlTransient
  public Collection<Trigger> getTriggerCollection() {
    return triggerCollection;
  }

  public void setTriggerCollection(Collection<Trigger> triggerCollection) {
    this.triggerCollection = triggerCollection;
  }

  @XmlTransient
  public Collection<Inventory> getInventoryCollection() {
    return inventoryCollection;
  }

  public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
    this.inventoryCollection = inventoryCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Item)) {
      return false;
    }
    Item other = (Item) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Item[ id=" + id + " ]";
  }

}
