package me.nurio.webs.minecraftserverslist.hibernate.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "server_statistics")
@Data
@NoArgsConstructor
public class MinecraftPing {

    @Id
    @Column(name = "ping_id")
    private int pingId;
    @Column(name = "time")
    private long pingTimeMillis;
    @Column(name = "server_id")
    private int serverId;
    @Column(name = "ping_players")
    private int onlinePlayers;
    @Column(name = "ping_maxplayers")
    private int maxPlayers;
    @Column(name = "ping_motd_id")
    private int motdId;
    @Column(name = "ping_latency")
    private int latency;
    @Column(name = "ping_image_id")
    private String imageId;
    @Column(name = "protocol_version")
    private int protocolVersion;

}