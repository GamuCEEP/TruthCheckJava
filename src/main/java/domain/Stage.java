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
@Table(name = "stage", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Stage.findAll", query = "SELECT s FROM Stage s"),
  @NamedQuery(name = "Stage.findById", query = "SELECT s FROM Stage s WHERE s.id = :id"),
  @NamedQuery(name = "Stage.findByName", query = "SELECT s FROM Stage s WHERE s.name = :name"),
  @NamedQuery(name = "Stage.findByDescription", query = "SELECT s FROM Stage s WHERE s.description = :description")})
public class Stage implements Serializable {

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
  @JoinTable(name = "_user_has_stage", joinColumns = {
    @JoinColumn(name = "stage_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser")})
  @ManyToMany(fetch = FetchType.EAGER)
  private List<User> userList;
  @ManyToMany(mappedBy = "stageList", fetch = FetchType.EAGER)
  private List<Map> mapList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageId", fetch = FetchType.EAGER)
  private List<Actor> actorList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "stage", fetch = FetchType.EAGER)
  private List<StageEvent> stageEventList;

  public Stage() {
  }

  public Stage(Integer id) {
    this.id = id;
  }

  public Stage(Integer id, String name, String description) {
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
  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  @XmlTransient
  public List<Map> getMapList() {
    return mapList;
  }

  public void setMapList(List<Map> mapList) {
    this.mapList = mapList;
  }

  @XmlTransient
  public List<Actor> getActorList() {
    return actorList;
  }

  public void setActorList(List<Actor> actorList) {
    this.actorList = actorList;
  }

  @XmlTransient
  public List<StageEvent> getStageEventList() {
    return stageEventList;
  }

  public void setStageEventList(List<StageEvent> stageEventList) {
    this.stageEventList = stageEventList;
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
    if (!(object instanceof Stage)) {
      return false;
    }
    Stage other = (Stage) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Stage[ id=" + id + " ]";
  }

}
