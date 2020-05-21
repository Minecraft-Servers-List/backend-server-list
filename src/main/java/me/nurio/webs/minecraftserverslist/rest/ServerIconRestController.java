package me.nurio.webs.minecraftserverslist.rest;

import me.nurio.webs.minecraftserverslist.hibernate.models.MinecraftIcon;
import me.nurio.webs.minecraftserverslist.hibernate.services.MinecraftIconService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/icons")
public class ServerIconRestController {

    @Autowired private MinecraftIconService iconService;

    @GetMapping("/{iconId:[\\d]+}.jpg")
    public HttpEntity<byte[]> getIconById(@PathVariable Integer iconId) {
        MinecraftIcon icon = iconService.findByIconId(iconId);
        if (icon == null || icon.getBase64().length() <= 30) icon = iconService.findByIconId(0);

        byte[] image = Base64.decodeBase64(icon.getBase64().substring(22));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return new HttpEntity<>(image, headers);
    }

}