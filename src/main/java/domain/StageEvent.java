package domain;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "_stage_event", catalog = "truthchecksimplified", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "StageEvent.findAll", query = "SELECT s FROM StageEvent s"),
  @NamedQuery(name = "StageEvent.findByStep", query = "SELECT s FROM StageEvent s WHERE s.stageEventPK.step = :step"),
  @NamedQuery(name = "StageEvent.findByLayer", query = "SELECT s FROM StageEvent s WHERE s.layer = :layer"),
  @NamedQuery(name = "StageEvent.findByOdds", query = "SELECT s FROM StageEvent s WHERE s.odds = :odds"),
  @NamedQuery(name = "StageEvent.findByStageId", query = "SELECT s FROM StageEvent s WHERE s.stageEventPK.stageId = :stageId"),
  @NamedQuery(name = "StageEvent.findByEventId", query = "SELECT s FROM StageEvent s WHERE s.stageEventPK.eventId = :eventId")})
public class StageEvent implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected StageEventPK stageEventPK;
  @Basic(optional = false)
  @NotNull
  @Column(name = "layer")
  private int layer;
  @Basic(optional = false)
  @NotNull
  @Column(name = "odds")
  private int odds;
  @JoinColumn(name = "event_id", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Event event;
  @JoinColumn(name = "stage_id", referencedColumnName = "id", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @JsonbTransient
  private Stage stage;

  public StageEvent() {
  }

  public StageEvent(StageEventPK stageEventPK) {
    this.stageEventPK = stageEventPK;
  }

  public StageEvent(StageEventPK stageEventPK, int layer, int odds) {
    this.stageEventPK = stageEventPK;
    this.layer = layer;
    this.odds = odds;
  }

  public StageEvent(int step, int stageId, int eventId) {
    this.stageEventPK = new StageEventPK(step, stageId, eventId);
  }

  public StageEventPK getStageEventPK() {
    return stageEventPK;
  }

  public void setStageEventPK(StageEventPK stageEventPK) {
    this.stageEventPK = stageEventPK;
  }

  public int getLayer() {
    return layer;
  }

  public void setLayer(int layer) {
    this.layer = layer;
  }

  public int getOdds() {
    return odds;
  }

  public void setOdds(int odds) {
    this.odds = odds;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public Stage getStage() {
    return stage;
  }

  public void setStage(Stage stage) {
    this.stage = stage;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (stageEventPK != null ? stageEventPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof StageEvent)) {
      return false;
    }
    StageEvent other = (StageEvent) object;
    if ((this.stageEventPK == null && other.stageEventPK != null) || (this.stageEventPK != null && !this.stageEventPK.equals(other.stageEventPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.StageEvent[ stageEventPK=" + stageEventPK + " ]";
  }

}
