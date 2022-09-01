package com.practice.designPatterns.proxy;

import com.practice.designPatterns.proxy.entity.Video;
import com.practice.designPatterns.proxy.lib.ThirdPartyYoutubeLib;

import java.util.HashMap;

public class YoutubeDownloader {
    private final ThirdPartyYoutubeLib api;

    public YoutubeDownloader(ThirdPartyYoutubeLib api) {
        this.api = api;
    }

    public void rendorVideo(String videoId) {
        Video video = api.getVideo(videoId);
        System.out.println("\n----rendorVideo-----\n"+video+"\n---------\n");
    }

    public void rendorPopularVideo() {
        HashMap<String, Video> list = api.popularVideos();
        System.out.println("\npopular videos rendorPopularVideos");
        list.forEach((k,v) -> System.out.println("ID: "+k+"-->/"+v));
    }
}
