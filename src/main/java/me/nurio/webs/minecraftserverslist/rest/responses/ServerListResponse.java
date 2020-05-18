package me.nurio.webs.minecraftserverslist.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
public class ServerListResponse {

    private PageListInfo info;
    private List<MinecraftServerResponse> results;

    public ServerListResponse(int currentPage, int totalPages, List<MinecraftServerResponse> serverList) {
        this(new PageListInfo(serverList.size(), currentPage, totalPages), serverList);
    }

    public ServerListResponse(Page<MinecraftServerResponse> mcServers, List<MinecraftServerResponse> serverList) {
        this(mcServers.getPageable().getPageNumber() + 1, mcServers.getTotalPages(), serverList);
    }

    @AllArgsConstructor
    @Data
    public static class PageListInfo {
        int pageEntries;
        int currentPage;
        int totalPages;
    }

}