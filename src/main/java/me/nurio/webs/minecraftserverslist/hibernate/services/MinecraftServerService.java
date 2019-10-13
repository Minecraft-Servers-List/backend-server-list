package me.nurio.webs.minecraftserverslist.hibernate.services;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.repositories.MinecraftServerRepository;
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
        return this.mcRepository.findAll();
    }

}
