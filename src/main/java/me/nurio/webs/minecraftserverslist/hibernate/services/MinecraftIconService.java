package me.nurio.webs.minecraftserverslist.hibernate.services;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftIcon;
import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftMotd;
import me.nurio.webs.minecraftserverslist.hibernate.repositories.MinecraftIconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MinecraftIconService {

    @Autowired private MinecraftIconRepository iconRepository;

    public MinecraftIcon findByIconId(int iconId) {
        return iconRepository.findByIconId(iconId);
    }

    public List<MinecraftIcon> findAll() {
        return this.iconRepository.findAll();
    }

}