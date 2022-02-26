package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
  @NamedQuery(name = "User.findByIduser", query = "SELECT u FROM User u WHERE u.iduser = :iduser"),
  @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
  @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "iduser")
  private Integer iduser;
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

  public User() {
  }

  public User(Integer iduser) {
    this.iduser = iduser;
  }

  public User(Integer iduser, String name, String password) {
    this.iduser = iduser;
    this.name = name;
    this.password = password;
  }

  public Integer getIduser() {
    return iduser;
  }

  public void setIduser(Integer iduser) {
    this.iduser = iduser;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (iduser != null ? iduser.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof User)) {
      return false;
    }
    User other = (User) object;
    if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.User[ iduser=" + iduser + " ]";
  }

}
