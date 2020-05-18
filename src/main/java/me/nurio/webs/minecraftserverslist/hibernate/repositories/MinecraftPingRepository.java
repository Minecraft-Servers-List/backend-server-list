package me.nurio.webs.minecraftserverslist.hibernate.repositories;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MinecraftPingRepository extends JpaRepository<MinecraftPing, Integer> {

    List<MinecraftPing> findAllByServerId(int serverId);

}
