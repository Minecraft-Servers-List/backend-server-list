package me.nurio.webs.minecraftserverslist.rest.converters;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftPingResponse;
import me.nurio.webs.minecraftserverslist.rest.responses.MinecraftServerResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MinecraftResourceConverter {

    public MinecraftServerResponse convertResponse(MinecraftServer mcServer){
        MinecraftServerResponse response = new MinecraftServerResponse();

        response.setId(mcServer.getServerId());
        response.setDomain(mcServer.getServerDomain());

        // TODO : Create image controller or use a CDN service.
        response.setImageUrl(mcServer.getServerIconId()+"");

        response.setOnlinePlayers(mcServer.getLastOnlinePlayers());
        response.setMaxPlayers(mcServer.getLastMaxPlayers());

        return response;
    }

    public MinecraftPingResponse convertResponse(MinecraftPing mcPing){
        MinecraftPingResponse response = new MinecraftPingResponse();

        response.setPingId(mcPing.getPingId());
        response.setServerId(mcPing.getServerId());

        response.setTimeMillis(mcPing.getPingTimeMillis());
        response.setOnlinePlayers(mcPing.getOnlinePlayers());
        response.setMaxPlayers(mcPing.getMaxPlayers());

        response.setLatency(mcPing.getLatency());

        return response;
    }

    public List<MinecraftPingResponse> convertResponse(List<MinecraftPing> mcPingList){
        List<MinecraftPingResponse> pingList = new ArrayList<>();
        mcPingList.forEach( (mcPing) -> pingList.add(convertResponse(mcPing)) );
        return pingList;
    }

}