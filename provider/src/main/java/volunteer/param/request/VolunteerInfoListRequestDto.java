package volunteer.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class VolunteerInfoListRequestDto {
    @NotNull
    @JsonProperty("weChatId")
    private String weChatId;

    @NotNull
    @JsonProperty("page")
    private Integer page;
}
