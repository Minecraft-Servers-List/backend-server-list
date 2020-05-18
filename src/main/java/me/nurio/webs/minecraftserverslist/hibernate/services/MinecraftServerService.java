package me.nurio.webs.minecraftserverslist.hibernate.services;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.repositories.MinecraftServerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinecraftServerService {

    private final MinecraftServerRepository mcRepository;

    public MinecraftServerService(MinecraftServerRepository mcRepository) {
        this.mcRepository = mcRepository;
    }

    public MinecraftServer findByServerDomain(String serverDomain) {
        return mcRepository.findByServerDomain(serverDomain);
    }

    public MinecraftServer findByServerId(int serverId) {
        return mcRepository.findByServerId(serverId);
    }

    public List<MinecraftServer> findAll() {
        return mcRepository.findAll();
    }

    public Page<MinecraftServer> findAll(Pageable pageable) {
        return mcRepository.findAll(pageable);
    }

    public Page<MinecraftServer> findOrderByServerScoreDesc(Pageable pageable) {
        return mcRepository.findAllByOrderByServerScoreDesc(pageable);
    }

    public Page<MinecraftServer> findAllOrderByServerScoreDesc(Pageable pageable) {
        return mcRepository.findAllByOrderByServerScoreDesc(pageable);
    }

}