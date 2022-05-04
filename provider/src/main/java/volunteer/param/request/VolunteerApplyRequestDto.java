package volunteer.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VolunteerApplyRequestDto {
    @NotNull
    @JsonProperty("weChatId")
    private String weChatId;

    @NotNull
    @JsonProperty("volunteerInfoId")
    private Long volunteerInfoId;

}
