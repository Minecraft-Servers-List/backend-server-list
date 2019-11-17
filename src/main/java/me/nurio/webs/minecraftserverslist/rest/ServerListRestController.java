package me.nurio.webs.minecraftserverslist.rest;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftPingService;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftServerService;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftPingResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerDetailsResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/list")
public class ServerListRestController {

    @Autowired(required = true)
    private MinecraftServerService serverService;
    @Autowired(required = true)
    private MinecraftPingService pingService;

    @GetMapping("")
    public List<MinecraftServerResponse> getServer() {
        List<MinecraftServer> mcServers = serverService.findAll();

        List<MinecraftServerResponse> serverList = new ArrayList<>();
        mcServers.forEach((mcServer) -> serverList.add(new MinecraftServerResponse(mcServer)));
        return serverList;
    }

    @GetMapping("/{page:[\\d]+}")
    public List<MinecraftServerResponse> getServerPings(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 25);
        List<MinecraftServer> mcServers = serverService.findAllOrderByServerScoreDesc(pageable);

        List<MinecraftServerResponse> serverList = new ArrayList<>();
        mcServers.forEach((mcServer) -> serverList.add(new MinecraftServerResponse(mcServer)));
        return serverList;
    }

}
