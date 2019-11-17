package me.nurio.webs.minecraftserverslist.hibernate.services;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftMotd;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import me.nurio.webs.minecraftserverslist.hibernate.repositories.MinecraftMotdRepository;
import me.nurio.webs.minecraftserverslist.hibernate.repositories.MinecraftServerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinecraftMotdService {

    private final MinecraftMotdRepository motdRepository;

    public MinecraftMotdService(MinecraftMotdRepository motdRepository){
        this.motdRepository = motdRepository;
    }

    public MinecraftMotd findByServerDomain(int motdId){
        return motdRepository.findByMotdId(motdId);
    }

    public List<MinecraftMotd> findAll(){
        return this.motdRepository.findAll();
    }

}