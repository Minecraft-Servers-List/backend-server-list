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

    public MinecraftServerService(MinecraftServerRepository mcRepository){
        this.mcRepository = mcRepository;
    }

    public MinecraftServer findByServerDomain(String serverDomain){
        return mcRepository.findByServerDomain(serverDomain);
    }

    public List<MinecraftServer> findAll(){
        return mcRepository.findAll();
    }

    public List<MinecraftServer> findAll(Pageable pageable){
        Page<MinecraftServer> li = mcRepository.findAll(pageable);
        return li.getContent();
    }

    public List<MinecraftServer> findAllOrderByServerScoreDesc(Pageable pageable){
        Page<MinecraftServer> li = mcRepository.findAllByOrderByServerScoreDesc(pageable);
        return li.getContent();
    }

}
