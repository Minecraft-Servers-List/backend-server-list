package me.nurio.webs.minecraftserverslist.hibernate.repositories;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinecraftServerRepository extends JpaRepository<MinecraftServer, Integer> {

    public MinecraftServer findByServerDomain(String serverDomain);

}
