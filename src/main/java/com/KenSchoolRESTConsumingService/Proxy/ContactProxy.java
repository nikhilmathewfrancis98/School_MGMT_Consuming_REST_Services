package com.KenSchoolRESTConsumingService.Proxy;

import com.KenSchoolRESTConsumingService.Configuration.ProjectConfiguration;
import com.KenSchoolRESTConsumingService.Model.Contact;
import feign.Headers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ContactFeign",url = "http://localhost:8080/api/contact",configuration = ProjectConfiguration.class)
public interface ContactProxy {
    @RequestMapping(method = RequestMethod.GET, value = "/getMessages")
    @Headers(value  = "Content-Type: application/json")
    public List<Contact> getMessagesUsingFeign(@RequestParam("status") String Status);


    @RequestMapping(method = RequestMethod.GET, value = "/getAllMessagesWithOpenStat")
    @Headers(value  = "Content-Type: application/json")
    public List<Contact> getAllMessagesDetails(@RequestBody Contact contact);

    }
