package volunteer.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VolunteerApprovalPending {
    @NotNull
    @JsonProperty("weChatId")
    private String weChatId;


    @NotNull
    @JsonProperty("promulgatorId")
    private Long promulgatorId;

    @NotNull
    @JsonProperty("applicationStatus")
    private Integer applicationStatus;

    @NotNull
    @JsonProperty("page")
    private Integer page;

}
