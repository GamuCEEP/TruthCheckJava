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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "map", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Map.findAll", query = "SELECT m FROM Map m"),
  @NamedQuery(name = "Map.findByIdmap", query = "SELECT m FROM Map m WHERE m.idmap = :idmap"),
  @NamedQuery(name = "Map.findByName", query = "SELECT m FROM Map m WHERE m.name = :name"),
  @NamedQuery(name = "Map.findByDescription", query = "SELECT m FROM Map m WHERE m.description = :description")})
public class Map implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "idmap")
  private Integer idmap;
  @Size(max = 40)
  @Column(name = "name")
  private String name;
  @Size(max = 400)
  @Column(name = "description")
  private String description;
  @JoinTable(name = "_user_has_map", joinColumns = {
    @JoinColumn(name = "map_idmap", referencedColumnName = "idmap")}, inverseJoinColumns = {
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<User> userList;
  @JoinTable(name = "_map_has_stage", joinColumns = {
    @JoinColumn(name = "map_idmap", referencedColumnName = "idmap")}, inverseJoinColumns = {
    @JoinColumn(name = "stage_id", referencedColumnName = "id")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<Stage> stageList;

  public Map() {
  }

  public Map(Integer idmap) {
    this.idmap = idmap;
  }

  public Integer getIdmap() {
    return idmap;
  }

  public void setIdmap(Integer idmap) {
    this.idmap = idmap;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idmap != null ? idmap.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Map)) {
      return false;
    }
    Map other = (Map) object;
    if ((this.idmap == null && other.idmap != null) || (this.idmap != null && !this.idmap.equals(other.idmap))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Map[ idmap=" + idmap + " ]";
  }

}
