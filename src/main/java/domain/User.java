package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "user", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
  @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
  @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
  @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

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
  @Size(min = 1, max = 128)
  @Column(name = "password")
  private String password;
  @ManyToMany(mappedBy = "userCollection")
  private Collection<Interaction> interactionCollection;
  @ManyToMany(mappedBy = "userCollection")
  private Collection<Event> eventCollection;
  @ManyToMany(mappedBy = "userCollection")
  private Collection<Stage> stageCollection;
  @ManyToMany(mappedBy = "userCollection")
  private Collection<Actor> actorCollection;
  @ManyToMany(mappedBy = "userCollection")
  private Collection<Effect> effectCollection;
  @ManyToMany(mappedBy = "userCollection")
  private Collection<Item> itemCollection;
  @ManyToMany(mappedBy = "userCollection")
  private Collection<Map> mapCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Actor> createdActors;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Item> createdItems;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Stage> createdStages;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Effect> createdEffects;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Interaction> createdInteractions;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Event> createdEvents;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Map> createdMaps;

  public User() {
  }

  public User(Integer id) {
    this.id = id;
  }

  public User(Integer id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @XmlTransient
  public Collection<Interaction> getInteractionCollection() {
    return interactionCollection;
  }

  public void setInteractionCollection(Collection<Interaction> interactionCollection) {
    this.interactionCollection = interactionCollection;
  }

  @XmlTransient
  public Collection<Event> getEventCollection() {
    return eventCollection;
  }

  public void setEventCollection(Collection<Event> eventCollection) {
    this.eventCollection = eventCollection;
  }

  @XmlTransient
  public Collection<Stage> getStageCollection() {
    return stageCollection;
  }

  public void setStageCollection(Collection<Stage> stageCollection) {
    this.stageCollection = stageCollection;
  }

  @XmlTransient
  public Collection<Actor> getActorCollection() {
    return actorCollection;
  }

  public void setActorCollection(Collection<Actor> actorCollection) {
    this.actorCollection = actorCollection;
  }

  @XmlTransient
  public Collection<Effect> getEffectCollection() {
    return effectCollection;
  }

  public void setEffectCollection(Collection<Effect> effectCollection) {
    this.effectCollection = effectCollection;
  }

  @XmlTransient
  public Collection<Item> getItemCollection() {
    return itemCollection;
  }

  public void setItemCollection(Collection<Item> itemCollection) {
    this.itemCollection = itemCollection;
  }

  @XmlTransient
  public Collection<Map> getMapCollection() {
    return mapCollection;
  }

  public void setMapCollection(Collection<Map> mapCollection) {
    this.mapCollection = mapCollection;
  }

  @XmlTransient
  public Collection<Actor> getCreatedActors() {
    return createdActors;
  }

  public void setCreatedActors(Collection<Actor> createdActors) {
    this.createdActors = createdActors;
  }

  @XmlTransient
  public Collection<Item> getCreatedItems() {
    return createdItems;
  }

  public void setCreatedItems(Collection<Item> createdItems) {
    this.createdItems = createdItems;
  }

  @XmlTransient
  public Collection<Stage> getCreatedStages() {
    return createdStages;
  }

  public void setCreatedStages(Collection<Stage> createdStages) {
    this.createdStages = createdStages;
  }

  @XmlTransient
  public Collection<Effect> getCreatedEffects() {
    return createdEffects;
  }

  public void setCreatedEffects(Collection<Effect> createdEffects) {
    this.createdEffects = createdEffects;
  }

  @XmlTransient
  public Collection<Interaction> getCreatedInteractions() {
    return createdInteractions;
  }

  public void setCreatedInteractions(Collection<Interaction> createdInteractions) {
    this.createdInteractions = createdInteractions;
  }

  @XmlTransient
  public Collection<Event> getCreatedEvents() {
    return createdEvents;
  }

  public void setCreatedEvents(Collection<Event> createdEvents) {
    this.createdEvents = createdEvents;
  }

  @XmlTransient
  public Collection<Map> getCreatedMaps() {
    return createdMaps;
  }

  public void setCreatedMaps(Collection<Map> createdMaps) {
    this.createdMaps = createdMaps;
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
    if (!(object instanceof User)) {
      return false;
    }
    User other = (User) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.User[ id=" + id + " ]";
  }

}
