package me.nurio.webs.minecraftserverslist.hibernate.services;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftServer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MinecraftServerServiceTest {

    @Autowired
    private MinecraftServerService serverService;

    @Test
    public void minecraft_service_load_random_server_by_domain(){
        MinecraftServer mcServer = serverService.findByServerDomain("aemine.vn");
        Assert.assertEquals(406, mcServer.getServerId());
    }

}
