package me.nurio.webs.minecraftserverslist.hibernate.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "server_list")
@Data
@NoArgsConstructor
public class MinecraftServer {

    @Id
    @Column(name="server_id")
    private int serverId;
    @Column(name="server_link_id")
    private Integer serverLinkId;
    @Column(name="server_domain", unique = true)
    private String serverDomain;
    @Column(name="server_score")
    private int serverScore;
    @Column(name="last_ping")
    private long lastPingMillis;
    @Column(name="last_response")
    private long lastResponseMillis;
    @Column(name="added")
    public long addedMillis;
    @Column(name="avg_players")
    public int averagePlayers;
    @Column(name="sla")
    public double sla;
    @Column(name="server_icon_id")
    public int serverIconId;
    @Column(name="server_tags")
    public String serverTags;
    @Column(name="server_badges")
    public String serverBadges;
    @Column(name="owner")
    public int serverOwnerId;
    @Column(name="last_vote")
    public long lastVoteMillis;
    @Column(name="last_ping_id")
    public int lastPingId;
    @Column(name="players")
    public int lastOnlinePlayers;
    @Column(name="max_players")
    public int lastMaxPlayers;
    @Column(name="last_score_scan")
    public long lastScoreScanMillis;

}
