package volunteer.param.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class RegisterRequestDto {

    @NotNull
    @JsonProperty("userName")
    private String userName;

    @NotNull
    @JsonProperty("weChatId")
    private String weChatId;

    @NotNull
    @JsonProperty("phoneNo")
    private String phoneNo;

    @NotNull
    @JsonProperty("pictureUrlAddress")
    private String pictureUrlAddress;

}
