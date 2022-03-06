package domain;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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

@Entity
@Table(name = "effect", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Effect.findAll", query = "SELECT e FROM Effect e"),
  @NamedQuery(name = "Effect.findById", query = "SELECT e FROM Effect e WHERE e.id = :id"),
  @NamedQuery(name = "Effect.findByCode", query = "SELECT e FROM Effect e WHERE e.code = :code"),
  @NamedQuery(name = "Effect.findByName", query = "SELECT e FROM Effect e WHERE e.name = :name"),
  @NamedQuery(name = "Effect.findByDescription", query = "SELECT e FROM Effect e WHERE e.description = :description")})
public class Effect implements Serializable, iResource {

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
    @JoinColumn(name = "user_id", referencedColumnName = "id")})
  @ManyToMany
  private Collection<User> userCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "effectId")
  private Collection<Item> itemCollection;
  @JoinColumn(name = "author", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private User author;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "effectId")
  private Collection<Event> eventCollection;

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

  @JsonbTransient
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

  @JsonbTransient
  public Collection<User> getUserCollection() {
    return userCollection;
  }

  public void setUserCollection(Collection<User> userCollection) {
    this.userCollection = userCollection;
  }

  @JsonbTransient
  public Collection<Item> getItemCollection() {
    return itemCollection;
  }

  public void setItemCollection(Collection<Item> itemCollection) {
    this.itemCollection = itemCollection;
  }

  @JsonbTransient
  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  @JsonbTransient
  public Collection<Event> getEventCollection() {
    return eventCollection;
  }

  public void setEventCollection(Collection<Event> eventCollection) {
    this.eventCollection = eventCollection;
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
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(
            other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Effect[ id=" + id + " ]";
  }

}
