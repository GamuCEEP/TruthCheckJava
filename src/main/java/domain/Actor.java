

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
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
  @NamedQuery(name = "Actor.findById", query = "SELECT a FROM Actor a WHERE a.id = :id"),
  @NamedQuery(name = "Actor.findByName", query = "SELECT a FROM Actor a WHERE a.name = :name"),
  @NamedQuery(name = "Actor.findByDescription", query = "SELECT a FROM Actor a WHERE a.description = :description")})
public class Actor implements Serializable {

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
  @JoinTable(name = "_equipment", joinColumns = {
    @JoinColumn(name = "actor_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "item_id", referencedColumnName = "id")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<Item> itemList;
  @JoinTable(name = "_user_has_actor", joinColumns = {
    @JoinColumn(name = "actor_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "user_id", referencedColumnName = "id")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<User> userList;
  @JoinColumn(name = "stage_id", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Stage stageId;
  @JoinColumn(name = "author", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private User author;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "actor", fetch = FetchType.EAGER)
  private List<Stats> statsList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "actor", fetch = FetchType.EAGER)
  private List<Inventory> inventoryList;

  public Actor() {
  }

  public Actor(Integer id) {
    this.id = id;
  }

  public Actor(Integer id, String name, String description) {
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
  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  @XmlTransient
  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public Stage getStageId() {
    return stageId;
  }

  public void setStageId(Stage stageId) {
    this.stageId = stageId;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @XmlTransient
  public List<Stats> getStatsList() {
    return statsList;
  }

  public void setStatsList(List<Stats> statsList) {
    this.statsList = statsList;
  }

  @XmlTransient
  public List<Inventory> getInventoryList() {
    return inventoryList;
  }

  public void setInventoryList(List<Inventory> inventoryList) {
    this.inventoryList = inventoryList;
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
    if (!(object instanceof Actor)) {
      return false;
    }
    Actor other = (Actor) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Actor[ id=" + id + " ]";
  }

}
