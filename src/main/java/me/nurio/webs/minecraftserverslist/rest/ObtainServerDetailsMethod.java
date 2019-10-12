package me.nurio.webs.minecraftserverslist.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servers")
public class ObtainServerDetailsMethod {

    @GetMapping("details/{serverDomain:[\\w\\d-.]+}")
    public String getSpecificServerDetails(@PathVariable String serverDomain){
        return "Works "+serverDomain;
    }

}
