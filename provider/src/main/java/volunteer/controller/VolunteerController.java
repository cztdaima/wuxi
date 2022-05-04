package volunteer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import volunteer.param.request.*;
import volunteer.param.response.ResponseDto;
import volunteer.service.VolunteerService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @PostMapping(value = "/save_volunteer_info")
    public ResponseDto saveVolunteerInfo(HttpServletRequest httpServletRequest, @RequestBody SaveVolunteerRequestDto saveVolunteerRequestDto) {
        return volunteerService.saveVolunteer(saveVolunteerRequestDto);
    }

    @PostMapping(value = "/get_volunteer_info")
    public ResponseDto getVolunteerInfo(HttpServletRequest httpServletRequest, @RequestBody GetVolunteerRequestDto getVolunteerRequestDto) throws Exception {
        return volunteerService.getVolunteer(getVolunteerRequestDto);
    }

    @PostMapping(value = "/volunteer_apply")
    public ResponseDto volunteerApply(HttpServletRequest httpServletRequest, @RequestBody VolunteerApplyRequestDto volunteerApplyRequestDto) {
        return volunteerService.volunteerApply(volunteerApplyRequestDto);
    }

    @PostMapping(value = "/volunteer_approve")
    public ResponseDto volunteerApprove(HttpServletRequest httpServletRequest, @RequestBody VolunteerApplyRequestDto volunteerApplyRequestDto) {
        return volunteerService.volunteerApprove(volunteerApplyRequestDto);
    }

    @PostMapping(value = "/volunteer_info_list")
    public ResponseDto volunteerInfoList(HttpServletRequest httpServletRequest, @RequestBody VolunteerInfoListRequestDto volunteerInfoListRequestDto) throws Exception {
        return volunteerService.volunteerInfoList(volunteerInfoListRequestDto);
    }

    @PostMapping(value = "/owner_volunteer_info_list")
    public ResponseDto ownerVolunteerInfoList(HttpServletRequest httpServletRequest, @RequestBody OwnerVolunteerRequestDto ownerVolunteerRequestDto) throws Exception {
        return volunteerService.ownerVolunteerInfoList(ownerVolunteerRequestDto);
    }

    @PostMapping(value = "/volunteer_approval_pending")
    public ResponseDto volunteerApprovalPending(HttpServletRequest httpServletRequest, @RequestBody VolunteerApprovalPending volunteerApprovalPending) throws Exception {
        return volunteerService.volunteerApprovalPending(volunteerApprovalPending);
    }

}
