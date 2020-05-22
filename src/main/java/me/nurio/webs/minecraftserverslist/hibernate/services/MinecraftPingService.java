package me.nurio.webs.minecraftserverslist.hibernate.services;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftPing;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.repositories.MinecraftPingRepository;
import me.nurio.webs.minecraftserverslist.hibernate.repositories.MinecraftServerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinecraftPingService {

    private final MinecraftPingRepository pingRepository;

    public MinecraftPingService(MinecraftPingRepository pingRepository) {
        this.pingRepository = pingRepository;
    }

    public List<MinecraftPing> findAllByServerId(int serverId) {
        return pingRepository.findAllByServerId(serverId);
    }

    public List<MinecraftPing> findAll() {
        return this.pingRepository.findAll();
    }

}
