package volunteer.param.response.dataBody;

import lombok.Data;

@Data
public class GetVolunteerResponse {
    private String title;
    private String content;
    private String pictureUrlAddress;
    private Long promulgatorId;
    private String entityName;
    private String numberOfNeed;
    private String address;
    private String time;
    private String status;
    private String award;

}
