package me.nurio.webs.minecraftserverslist.rest;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftPingService;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftServerService;
import me.nurio.webs.minecraftserverslist.rest.converters.MinecraftResourceConverter;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftPingResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class MinecraftServersRestController {

    @Autowired(required = true)
    private MinecraftServerService serverService;
    @Autowired(required = true)
    private MinecraftPingService pingService;
    @Autowired(required = true)
    private MinecraftResourceConverter mcResourceService;

    @Autowired
    public MinecraftServersRestController(MinecraftServerService serverService, MinecraftPingService pingService){
        this.serverService = serverService;
        this.pingService = pingService;
    }

    @GetMapping("/{serverDomain:[\\w\\d-.]+}")
    public MinecraftServerResponse getSpecificServerDetails(@PathVariable String serverDomain){
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        return mcResourceService.convertResponse(mcServer);
    }

    @GetMapping("/{serverDomain:[\\w\\d-.]+}/statistics")
    public List<MinecraftPingResponse> getServersListDetails(@PathVariable String serverDomain){
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        List<MinecraftPing> pingList = pingService.findAllByServerId(mcServer.getServerId());
        return mcResourceService.convertResponse(pingList);
    }

}
