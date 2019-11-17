package me.nurio.webs.minecraftserverslist.rest.responses;

import lombok.Data;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;

@Data
public class MinecraftPingResponse {

    public MinecraftPingResponse(MinecraftPing mcPing) {
        this.setPingId(mcPing.getPingId());

        this.setTimeMillis(mcPing.getPingTimeMillis());
        this.setOnlinePlayers(mcPing.getOnlinePlayers());
        this.setMaxPlayers(mcPing.getMaxPlayers());

        this.setLatency(mcPing.getLatency());
    }

    private int pingId;

    private String imageURL;
    private int motdId;

    private int onlinePlayers;
    private int maxPlayers;
    private int latency;

    private long timeMillis;

}