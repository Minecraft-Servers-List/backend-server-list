package me.nurio.webs.minecraftserverslist.hibernate.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "server_icons")
@Data
@NoArgsConstructor
public class MinecraftIcon {

    @Id
    @Column(name = "icon_id")
    private int iconId;

    @Column(name = "icon_base64")
    private String base64;

}