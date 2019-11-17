package me.nurio.webs.minecraftserverslist.hibernate.repositories;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftMotd;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinecraftMotdRepository extends JpaRepository<MinecraftMotd, Integer> {

    public MinecraftMotd findByMotdId(int motdId);

}
