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
    @JoinColumn(name = "user_id", referencedColumnName = "id")})
  @ManyToMany
  private Collection<User> userCollection;
  @ManyToMany(mappedBy = "stageCollection")
  private Collection<Map> mapCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "stageId")
  private Collection<Actor> actorCollection;
  @JoinColumn(name = "author", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private User author;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "stage")
  private Collection<StageEvent> stageEventCollection;

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
  public Collection<User> getUserCollection() {
    return userCollection;
  }

  public void setUserCollection(Collection<User> userCollection) {
    this.userCollection = userCollection;
  }

  @XmlTransient
  public Collection<Map> getMapCollection() {
    return mapCollection;
  }

  public void setMapCollection(Collection<Map> mapCollection) {
    this.mapCollection = mapCollection;
  }

  @XmlTransient
  public Collection<Actor> getActorCollection() {
    return actorCollection;
  }

  public void setActorCollection(Collection<Actor> actorCollection) {
    this.actorCollection = actorCollection;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @XmlTransient
  public Collection<StageEvent> getStageEventCollection() {
    return stageEventCollection;
  }

  public void setStageEventCollection(Collection<StageEvent> stageEventCollection) {
    this.stageEventCollection = stageEventCollection;
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
