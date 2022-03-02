package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
  private Collection<Actor> actorCollection1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Item> itemCollection1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Stage> stageCollection1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Effect> effectCollection1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Interaction> interactionCollection1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Event> eventCollection1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
  private Collection<Map> mapCollection1;

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
  public Collection<Actor> getActorCollection1() {
    return actorCollection1;
  }

  public void setActorCollection1(Collection<Actor> actorCollection1) {
    this.actorCollection1 = actorCollection1;
  }

  @XmlTransient
  public Collection<Item> getItemCollection1() {
    return itemCollection1;
  }

  public void setItemCollection1(Collection<Item> itemCollection1) {
    this.itemCollection1 = itemCollection1;
  }

  @XmlTransient
  public Collection<Stage> getStageCollection1() {
    return stageCollection1;
  }

  public void setStageCollection1(Collection<Stage> stageCollection1) {
    this.stageCollection1 = stageCollection1;
  }

  @XmlTransient
  public Collection<Effect> getEffectCollection1() {
    return effectCollection1;
  }

  public void setEffectCollection1(Collection<Effect> effectCollection1) {
    this.effectCollection1 = effectCollection1;
  }

  @XmlTransient
  public Collection<Interaction> getInteractionCollection1() {
    return interactionCollection1;
  }

  public void setInteractionCollection1(Collection<Interaction> interactionCollection1) {
    this.interactionCollection1 = interactionCollection1;
  }

  @XmlTransient
  public Collection<Event> getEventCollection1() {
    return eventCollection1;
  }

  public void setEventCollection1(Collection<Event> eventCollection1) {
    this.eventCollection1 = eventCollection1;
  }

  @XmlTransient
  public Collection<Map> getMapCollection1() {
    return mapCollection1;
  }

  public void setMapCollection1(Collection<Map> mapCollection1) {
    this.mapCollection1 = mapCollection1;
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
