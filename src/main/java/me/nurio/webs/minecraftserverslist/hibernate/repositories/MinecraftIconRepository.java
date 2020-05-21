package me.nurio.webs.minecraftserverslist.hibernate.repositories;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftIcon;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftMotd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinecraftIconRepository extends JpaRepository<MinecraftIcon, Integer> {

    MinecraftIcon findByIconId(int iconId);

}