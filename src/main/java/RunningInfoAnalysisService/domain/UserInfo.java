package RunningInfoAnalysisService.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "UserInfo")
public class UserInfo {
    @Id
    @GeneratedValue
    private long userId;

    @OneToOne(mappedBy = "userInfo")
    @JsonIgnore
    private RunningInfo runningInfo;
    //private long runningInfoId;
    private String username;
    private String address;

    public UserInfo() {
    }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
