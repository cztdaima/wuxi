package volunteer.param.response.dataBody;

import lombok.Data;

@Data
public class LoginResponseData {
    private Long userId;

    private String userName;

    private String identity;

    private String pictureUrlAddress;
}
