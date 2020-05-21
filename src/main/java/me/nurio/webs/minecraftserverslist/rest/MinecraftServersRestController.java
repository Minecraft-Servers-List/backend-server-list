package me.nurio.webs.minecraftserverslist.rest;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftIcon;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftIconService;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftPingService;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftServerService;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftPingResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerDetailsResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servers")
public class MinecraftServersRestController {

    @Autowired private MinecraftServerService serverService;
    @Autowired private MinecraftIconService iconService;
    @Autowired private MinecraftPingService pingService;

    @GetMapping("/{serverDomain:[\\w.-]+[.][\\w]+}")
    public MinecraftServerResponse getServer(@PathVariable String serverDomain) {
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        return new MinecraftServerResponse(mcServer);
    }

    @GetMapping("/{serverId:[\\d]+}")
    public MinecraftServerResponse getServerById(@PathVariable Integer serverId) {
        MinecraftServer mcServer = serverService.findByServerId(serverId);
        return new MinecraftServerResponse(mcServer);
    }

    @GetMapping("/{serverDomain:[\\w.-]+[.][\\w]+}/statistics")
    public List<MinecraftPingResponse> getServerPings(@PathVariable String serverDomain) {
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        List<MinecraftPing> mcPingList = pingService.findAllByServerId(mcServer.getServerId());

        List<MinecraftPingResponse> pingList = new ArrayList<>();
        mcPingList.forEach((mcPing) -> pingList.add(new MinecraftPingResponse(mcPing)));
        return pingList;
    }

    @GetMapping("/{serverId:[\\d]+}/statistics")
    public List<MinecraftPingResponse> getServerPingsById(@PathVariable Integer serverId) {
        List<MinecraftPing> mcPingList = pingService.findAllByServerId(serverId);

        List<MinecraftPingResponse> pingList = new ArrayList<>();
        mcPingList.forEach((mcPing) -> pingList.add(new MinecraftPingResponse(mcPing)));
        return pingList;
    }

    @GetMapping("/{serverDomain:[\\w.-]+[.][\\w]+}/details")
    public MinecraftServerDetailsResponse getServerDetails(@PathVariable String serverDomain) {
        MinecraftServer mcServer = serverService.findByServerDomain(serverDomain);
        return new MinecraftServerDetailsResponse(mcServer);
    }

    @GetMapping("/{serverId:[\\d]+}/details")
    public MinecraftServerDetailsResponse getServerDetailsById(@PathVariable Integer serverId) {
        MinecraftServer mcServer = serverService.findByServerId(serverId);
        return new MinecraftServerDetailsResponse(mcServer);
    }

    @GetMapping("/{serverId:[\\d]+}/icon.jpg")
    public HttpEntity<byte[]> getServerIconByServerId(@PathVariable Integer serverId) {
        MinecraftServer mcServer = serverService.findByServerId(serverId);
        int iconId = (mcServer != null && mcServer.getServerIconId() != null) ? mcServer.getServerIconId() : 0;
        MinecraftIcon icon = iconService.findByIconId(iconId);
        if (icon == null || icon.getBase64().length() <= 30) icon = iconService.findByIconId(0);

        byte[] image = Base64.decodeBase64(icon.getBase64().substring(22));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return new HttpEntity<>(image, headers);
    }

}