package RunningInfoAnalysisService.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"id", "latitude", "longitude", "runningDistance", "timestamp"})
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInfo {
    public enum HealthWarningLevel {
        LOW, NORMAL, HIGH;

        public static HealthWarningLevel getLevel(int heartRate) {
            if (heartRate <= 75) {
                return LOW;
            } else if (heartRate <= 120) {
                return NORMAL;
            } else {
                return HIGH;
            }
        }
    }

    @Id
    @GeneratedValue
    private long id;

    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate = 0;
    private Date timestamp = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserInfo userInfo;

    public RunningInfo() {
    }

    @JsonCreator
    public RunningInfo(@JsonProperty("username") String username, @JsonProperty("address") String address) {
        this.userInfo = new UserInfo(username, address);
    }

    public RunningInfo(UserInfo userinfo) {
        this.userInfo = userinfo;
    }

    @JsonIgnore
    public long getId() {
        return id;
    }

    @JsonIgnore
    public double getLatitude() {
        return latitude;
    }

    @JsonIgnore
    public double getLongitude() {
        return longitude;
    }

    @JsonIgnore
    public double getRunningDistance() {
        return runningDistance;
    }

    @JsonIgnore
    public Date getTimestamp() {
        return timestamp;
    }

    @JsonIgnore
    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    @JsonProperty
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public long getuserId() {
        return this.userInfo.getUserId();
    }

    public String getuserName() {
        return userInfo.getUsername();
    }

    public String getuserAddress() {
        return userInfo.getAddress();
    }

    public HealthWarningLevel gethealthWarningLevel() {
        return HealthWarningLevel.getLevel(heartRate);
    }

}
