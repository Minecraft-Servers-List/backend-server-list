package me.nurio.webs.minecraftserverslist.rest.responses;

import lombok.Data;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class MinecraftServerResponse {

    public MinecraftServerResponse(MinecraftServer mcServer) {
        this.setId(mcServer.getServerId());
        this.setDomain(mcServer.getServerDomain());

        // TODO : Create image controller or use a CDN service.
        this.setImageURL(mcServer.getServerIconId() + "");

        this.setOnlinePlayers(mcServer.getLastOnlinePlayers());
        this.setMaxPlayers(mcServer.getLastMaxPlayers());

        List<String> tags = new ArrayList<>();
        tags.addAll(Arrays.asList(mcServer.getServerTags().split(";")));
        tags.addAll(Arrays.asList(mcServer.getServerBadges().split(";")));
        this.setTags(tags);
    }

    private int id;

    private String domain;
    private String imageURL;

    private int onlinePlayers;
    private int maxPlayers;

    private List<String> tags;

}
