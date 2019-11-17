package me.nurio.webs.minecraftserverslist.rest.responses;

import lombok.Data;

import java.util.List;

@Data
public class MinecraftServerResponse {

    private int id;

    private String domain;
    private String imageUrl;

    private int onlinePlayers;
    private int maxPlayers;

    private List<String> tags;

}
