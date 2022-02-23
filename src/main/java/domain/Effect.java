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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "effect", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Effect.findAll", query = "SELECT e FROM Effect e"),
  @NamedQuery(name = "Effect.findById", query = "SELECT e FROM Effect e WHERE e.id = :id"),
  @NamedQuery(name = "Effect.findByCode", query = "SELECT e FROM Effect e WHERE e.code = :code"),
  @NamedQuery(name = "Effect.findByName", query = "SELECT e FROM Effect e WHERE e.name = :name"),
  @NamedQuery(name = "Effect.findByDescription", query = "SELECT e FROM Effect e WHERE e.description = :description")})
public class Effect implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1000)
  @Column(name = "code")
  private String code;
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
  @JoinTable(name = "_user_has_effect", joinColumns = {
    @JoinColumn(name = "effect_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<User> userList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "effectId", fetch = FetchType.EAGER)
  private List<Item> itemList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "effectId", fetch = FetchType.EAGER)
  private List<Interaction> interactionList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "effectId", fetch = FetchType.EAGER)
  private List<Event> eventList;

  public Effect() {
  }

  public Effect(Integer id) {
    this.id = id;
  }

  public Effect(Integer id, String code, String name, String description) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
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
  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  @XmlTransient
  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Effect)) {
      return false;
    }
    Effect other = (Effect) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Effect[ id=" + id + " ]";
  }

}
