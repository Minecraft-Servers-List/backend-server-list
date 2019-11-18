package me.nurio.webs.minecraftserverslist.rest;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftPingService;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftServerService;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftPingResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerDetailsResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servers")
public class MinecraftServersRestController {

    @Autowired(required = true)
    private MinecraftServerService serverService;
    @Autowired(required = true)
    private MinecraftPingService pingService;

    @GetMapping("/{serverDomain:[\\w\\d-.]+}")
    public MinecraftServerResponse getServer(@PathVariable String serverDomain) {
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        return new MinecraftServerResponse(mcServer);
    }

    @GetMapping("/{serverId:[\\d-.]+}")
    public MinecraftServerResponse getServer(@PathVariable Integer serverId) {
        MinecraftServer mcServer = serverService.findByServerId(serverId);
        return new MinecraftServerResponse(mcServer);
    }

    @GetMapping("/{serverDomain:[\\w\\d-.]+}/statistics")
    public List<MinecraftPingResponse> getServerPings(@PathVariable String serverDomain) {
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        List<MinecraftPing> mcPingList = pingService.findAllByServerId(mcServer.getServerId());

        List<MinecraftPingResponse> pingList = new ArrayList<>();
        mcPingList.forEach((mcPing) -> pingList.add(new MinecraftPingResponse(mcPing)));
        return pingList;
    }

    @GetMapping("/{serverDomain:[\\w\\d-.]+}/statistics")
    public List<MinecraftPingResponse> getServerPings(@PathVariable Integer serverId) {
        List<MinecraftPing> mcPingList = pingService.findAllByServerId(serverId);

        List<MinecraftPingResponse> pingList = new ArrayList<>();
        mcPingList.forEach((mcPing) -> pingList.add(new MinecraftPingResponse(mcPing)));
        return pingList;
    }

    @GetMapping("/{serverDomain:[\\w\\d-.]+}/details")
    public MinecraftServerDetailsResponse getServerDetails(@PathVariable String serverDomain) {
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        return new MinecraftServerDetailsResponse(mcServer);
    }

    @GetMapping("/{serverDomain:[\\w\\d-.]+}/details")
    public MinecraftServerDetailsResponse getServerDetails(@PathVariable Integer serverId) {
        MinecraftServer mcServer = serverService.findByServerId(serverId);
        return new MinecraftServerDetailsResponse(mcServer);
    }

}
