

package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class StageEventPK implements Serializable {

  @Basic(optional = false)
  @NotNull
  @Column(name = "step")
  private int step;
  @Basic(optional = false)
  @NotNull
  @Column(name = "stage_id")
  private int stageId;
  @Basic(optional = false)
  @NotNull
  @Column(name = "event_id")
  private int eventId;

  public StageEventPK() {
  }

  public StageEventPK(int step, int stageId, int eventId) {
    this.step = step;
    this.stageId = stageId;
    this.eventId = eventId;
  }

  public int getStep() {
    return step;
  }

  public void setStep(int step) {
    this.step = step;
  }

  public int getStageId() {
    return stageId;
  }

  public void setStageId(int stageId) {
    this.stageId = stageId;
  }

  public int getEventId() {
    return eventId;
  }

  public void setEventId(int eventId) {
    this.eventId = eventId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) step;
    hash += (int) stageId;
    hash += (int) eventId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof StageEventPK)) {
      return false;
    }
    StageEventPK other = (StageEventPK) object;
    if (this.step != other.step) {
      return false;
    }
    if (this.stageId != other.stageId) {
      return false;
    }
    if (this.eventId != other.eventId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "domain.StageEventPK[ step=" + step + ", stageId=" + stageId + ", eventId=" + eventId + " ]";
  }

}
