package me.nurio.webs.minecraftserverslist.rest;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftPingService;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftServerService;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.ServerListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ServerListRestController {

    @Autowired private MinecraftServerService serverService;
    @Autowired private MinecraftPingService pingService;

    @GetMapping("")
    public List<MinecraftServerResponse> getAllServers() {
        List<MinecraftServer> mcServers = serverService.findAll();

        return mcServers.stream()
            .map(MinecraftServerResponse::new)
            .collect(Collectors.toList());
    }

    @GetMapping("/{page:[\\d]+}")
    public ServerListResponse getPage(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 25);
        Page<MinecraftServer> mcServers = serverService.findAllOrderByServerScoreDesc(pageable);

        List<MinecraftServerResponse> serverList = mcServers.getContent().stream()
            .map(MinecraftServerResponse::new).collect(Collectors.toList());

        return new ServerListResponse(
            mcServers.getPageable().getPageNumber() + 1,
            mcServers.getTotalPages(),
            serverList
        );
    }

}