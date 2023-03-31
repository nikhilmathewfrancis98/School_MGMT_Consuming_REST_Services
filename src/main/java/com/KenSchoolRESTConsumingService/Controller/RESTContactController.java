package com.KenSchoolRESTConsumingService.Controller;

import com.KenSchoolRESTConsumingService.Model.Contact;
import com.KenSchoolRESTConsumingService.Proxy.ContactProxy;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RESTContactController {

    @Autowired
    ContactProxy contactProxy;

    @GetMapping(path = "/invokegetMessage")
    public ResponseEntity<List<Contact>> getMsgs(@RequestParam("status") String status){
       List<Contact> result= contactProxy.getMessagesUsingFeign(status);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

//    We are doing this method inorder to get the details of a person and to see whether we are getting the Alias name for json field
    @GetMapping(path = "/getMyMessageDetails")
    public List<Contact> getAllOpenMessages(@RequestBody Contact contact){
        log.info(contact.getStatus());
      List<Contact> result=  contactProxy.getAllMessagesDetails(contact);
//        log.info(result.get(0).getName()+" "+result.get(0).getStatus());
        return  result;
    }

}
