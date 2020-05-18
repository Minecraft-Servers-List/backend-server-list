package me.nurio.webs.minecraftserverslist.rest.responses;

import lombok.Data;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class MinecraftServerDetailsResponse {

    public MinecraftServerDetailsResponse(MinecraftServer mcServer) {
        this.setId(mcServer.getServerId());
        this.setScore(mcServer.getServerScore());

        this.setDomain(mcServer.getServerDomain());

        // TODO : Create image controller or use a CDN service.
        this.setImageURL(mcServer.getServerIconId() + "");

        this.setMaxPlayers(mcServer.getLastMaxPlayers());
        this.setOnlinePlayers(mcServer.getLastOnlinePlayers());
        this.setAveragePlayers(mcServer.getAveragePlayers());

        List<String> tags = new ArrayList<String>();
        tags.addAll(Arrays.asList(mcServer.getServerTags().split(";")));
        this.setTags(tags);

        List<String> badges = new ArrayList<String>();
        badges.addAll(Arrays.asList(mcServer.getServerBadges().split(";")));
        this.setBadges(badges);
    }

    private int id;
    private String domain;
    private String imageURL;

    private int score;

    private int maxPlayers;
    private int onlinePlayers;
    private int averagePlayers;

    private List<String> tags;
    private List<String> badges;

    private List<String> otherDomains;

}