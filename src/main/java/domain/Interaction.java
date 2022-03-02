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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "interaction", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Interaction.findAll", query = "SELECT i FROM Interaction i"),
  @NamedQuery(name = "Interaction.findById", query = "SELECT i FROM Interaction i WHERE i.id = :id"),
  @NamedQuery(name = "Interaction.findByName", query = "SELECT i FROM Interaction i WHERE i.name = :name"),
  @NamedQuery(name = "Interaction.findByDescription", query = "SELECT i FROM Interaction i WHERE i.description = :description")})
public class Interaction implements Serializable {

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
  @JoinTable(name = "_user_has_interaction", joinColumns = {
    @JoinColumn(name = "interaction_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "user_id", referencedColumnName = "id")})
  @ManyToMany
  private Collection<User> userCollection;
  @JoinTable(name = "_item_interaction", joinColumns = {
    @JoinColumn(name = "interaction_id", referencedColumnName = "id")}, inverseJoinColumns = {
    @JoinColumn(name = "item_id", referencedColumnName = "id")})
  @ManyToMany
  private Collection<Item> itemCollection;
  @JoinColumn(name = "author", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private User author;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "interaction")
  private Trigger trigger;

  public Interaction() {
  }

  public Interaction(Integer id) {
    this.id = id;
  }

  public Interaction(Integer id, String name, String description) {
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
  public Collection<Item> getItemCollection() {
    return itemCollection;
  }

  public void setItemCollection(Collection<Item> itemCollection) {
    this.itemCollection = itemCollection;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Trigger getTrigger() {
    return trigger;
  }

  public void setTrigger(Trigger trigger) {
    this.trigger = trigger;
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
    if (!(object instanceof Interaction)) {
      return false;
    }
    Interaction other = (Interaction) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.Interaction[ id=" + id + " ]";
  }

}
