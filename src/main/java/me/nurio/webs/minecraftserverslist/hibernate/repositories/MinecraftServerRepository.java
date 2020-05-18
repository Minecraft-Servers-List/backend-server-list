package me.nurio.webs.minecraftserverslist.hibernate.repositories;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinecraftServerRepository extends JpaRepository<MinecraftServer, Integer> {

    MinecraftServer findByServerDomain(String serverDomain);
    MinecraftServer findByServerId(int serverId);
    Page<MinecraftServer> findAll(Pageable pageable);
    Page<MinecraftServer> findAllByOrderByServerScoreDesc(Pageable pageable);


}
