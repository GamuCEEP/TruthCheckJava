

package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "map")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Map.findAll", query = "SELECT m FROM Map m"),
  @NamedQuery(name = "Map.findById", query = "SELECT m FROM Map m WHERE m.id = :id"),
  @NamedQuery(name = "Map.findByName", query = "SELECT m FROM Map m WHERE m.name = :name"),
  @NamedQuery(name = "Map.findByDescription", query = "SELECT m FROM Map m WHERE m.description = :description")})
public class Map implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Size(max = 40)
  @Column(name = "name")
  private String name;
  @Size(max = 400)
  @Column(name = "description")
  private String description;
  @JoinTable(name = "_user_has_map", joinColumns = {
    @JoinColumn(name = "map_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "user_id", referencedColumnName = "id")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<User> userList;
  @JoinTable(name = "_map_has_stage", joinColumns = {
    @JoinColumn(name = "map_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "stage_id", referencedColumnName = "id")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<Stage> stageList;
  @JoinColumn(name = "author", referencedColumnName = "id")
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private User author;

  public Map() {
  }

  public Map(Integer id) {
    this.id = id;
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
  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  @XmlTransient
  public List<Stage> getStageList() {
    return stageList;
  }

  public void setStageList(List<Stage> stageList) {
    this.stageList = stageList;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
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
    if (!(object instanceof Map)) {
      return false;
    }
    Map other = (Map) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Map[ id=" + id + " ]";
  }

}
