package com.practice.designPatterns.proxy.lib;

import com.practice.designPatterns.proxy.entity.Video;

import java.util.HashMap;

public interface ThirdPartyYoutubeLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
