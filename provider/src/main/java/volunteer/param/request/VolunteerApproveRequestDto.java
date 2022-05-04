package volunteer.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VolunteerApproveRequestDto {
    @NotNull
    @JsonProperty("weChatId")
    private String weChatId;

    @NotNull
    @JsonProperty("volunteerInfoId")
    private Long volunteerInfoId;

    @NotNull
    @JsonProperty("volunteerApplicationId")
    private String volunteerApplicationId;

    @NotNull
    @JsonProperty("applicationStatus")
    private String applicationStatus;
}
