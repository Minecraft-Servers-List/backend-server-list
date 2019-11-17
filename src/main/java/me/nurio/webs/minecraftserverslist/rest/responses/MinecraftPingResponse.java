package me.nurio.webs.minecraftserverslist.rest.responses;

import lombok.Data;

@Data
public class MinecraftPingResponse {

    private int pingId;

    private int serverId;
    private String imageUrl;
    private int motdId;

    private int onlinePlayers;
    private int maxPlayers;
    private int latency;

    private long timeMillis;

}