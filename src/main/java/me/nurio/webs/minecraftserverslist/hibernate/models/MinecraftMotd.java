package me.nurio.webs.minecraftserverslist.hibernate.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servers_motd")
@Data
@NoArgsConstructor
public class MinecraftMotd {

    @Id
    @Column(name = "motd_id")
    private int motdId;
    @Column(name = "server_motd")
    private String motd;
    @Column(name = "added")
    private long addedMillis;

}