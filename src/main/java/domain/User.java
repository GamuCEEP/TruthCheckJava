

package domain;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "user")
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
  @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
  private List<Interaction> interactionList;
  @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
  private List<Event> eventList;
  @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
  private List<Stage> stageList;
  @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
  private List<Actor> actorList;
  @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
  private List<Effect> effectList;
  @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
  private List<Item> itemList;
  @ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
  private List<Map> mapList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
  private List<Actor> actorList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
  private List<Item> itemList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
  private List<Stage> stageList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
  private List<Effect> effectList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.EAGER)
  private List<Interaction> interactionList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
  private List<Event> eventList1;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.EAGER)
  private List<Map> mapList1;

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
  public List<Interaction> getInteractionList() {
    return interactionList;
  }

  public void setInteractionList(List<Interaction> interactionList) {
    this.interactionList = interactionList;
  }

  @XmlTransient
  public List<Event> getEventList() {
    return eventList;
  }

  public void setEventList(List<Event> eventList) {
    this.eventList = eventList;
  }

  @XmlTransient
  public List<Stage> getStageList() {
    return stageList;
  }

  public void setStageList(List<Stage> stageList) {
    this.stageList = stageList;
  }

  @XmlTransient
  public List<Actor> getActorList() {
    return actorList;
  }

  public void setActorList(List<Actor> actorList) {
    this.actorList = actorList;
  }

  @XmlTransient
  public List<Effect> getEffectList() {
    return effectList;
  }

  public void setEffectList(List<Effect> effectList) {
    this.effectList = effectList;
  }

  @XmlTransient
  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  @XmlTransient
  public List<Map> getMapList() {
    return mapList;
  }

  public void setMapList(List<Map> mapList) {
    this.mapList = mapList;
  }

  @XmlTransient
  public List<Actor> getActorList1() {
    return actorList1;
  }

  public void setActorList1(List<Actor> actorList1) {
    this.actorList1 = actorList1;
  }

  @XmlTransient
  public List<Item> getItemList1() {
    return itemList1;
  }

  public void setItemList1(List<Item> itemList1) {
    this.itemList1 = itemList1;
  }

  @XmlTransient
  public List<Stage> getStageList1() {
    return stageList1;
  }

  public void setStageList1(List<Stage> stageList1) {
    this.stageList1 = stageList1;
  }

  @XmlTransient
  public List<Effect> getEffectList1() {
    return effectList1;
  }

  public void setEffectList1(List<Effect> effectList1) {
    this.effectList1 = effectList1;
  }

  @XmlTransient
  public List<Interaction> getInteractionList1() {
    return interactionList1;
  }

  public void setInteractionList1(List<Interaction> interactionList1) {
    this.interactionList1 = interactionList1;
  }

  @XmlTransient
  public List<Event> getEventList1() {
    return eventList1;
  }

  public void setEventList1(List<Event> eventList1) {
    this.eventList1 = eventList1;
  }

  @XmlTransient
  public List<Map> getMapList1() {
    return mapList1;
  }

  public void setMapList1(List<Map> mapList1) {
    this.mapList1 = mapList1;
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
