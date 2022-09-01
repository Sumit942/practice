package com.practice.designPatterns.proxy;

import com.practice.designPatterns.proxy.entity.Video;
import com.practice.designPatterns.proxy.lib.ThirdPartyYoutubeLib;

import java.util.HashMap;

public class YoutubeCacheProxy implements ThirdPartyYoutubeLib {
    private final ThirdPartyYoutubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<>();
    private final HashMap<String, Video> cacheAll = new HashMap<>();

    public YoutubeCacheProxy() {
        this.youtubeService = new YoutubeThirdPartyClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()){
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved the popularVideos from cache");
        }
        return cachePopular;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId,video);
        } else {
            System.out.println("Retrieved the video '"+videoId+"' from cache.");
        }
        return video;
    }

    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}
