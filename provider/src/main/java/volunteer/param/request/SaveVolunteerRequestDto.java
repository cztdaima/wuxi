package volunteer.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SaveVolunteerRequestDto {
    @NotNull
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonProperty("content")
    private String content;

    @NotNull
    @JsonProperty("pictureUrlAddress")
    private String pictureUrlAddress;

    @NotNull
    @JsonProperty("promulgatorId")
    private String promulgatorId;

    @NotNull
    @JsonProperty("numberOfNeed")
    private String numberOfNeed;

    @NotNull
    @JsonProperty("address")
    private String address;

    @NotNull
    @JsonProperty("time")
    private String time;

    @NotNull
    @JsonProperty("status")
    private String status;

    @NotNull
    @JsonProperty("award")
    private String award;

}
