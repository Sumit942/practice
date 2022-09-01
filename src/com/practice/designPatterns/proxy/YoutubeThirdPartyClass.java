package com.practice.designPatterns.proxy;

import com.practice.designPatterns.proxy.entity.Video;
import com.practice.designPatterns.proxy.lib.ThirdPartyYoutubeLib;

import java.util.HashMap;
import java.util.function.Supplier;

public class YoutubeThirdPartyClass implements ThirdPartyYoutubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("https://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("https://www.youtube.com");
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.
    private void connectToServer(String server) {
        System.out.println("Connecting to "+server+"... ");
        experienceNetworkLatency();
        System.out.println("Connected!!\n");
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(0,5);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.println("Downloading popular videos...");
        experienceNetworkLatency();
        HashMap<String, Video> popularVideo = new HashMap<>();
        popularVideo.put("Cats", new Video(String.valueOf(popularVideo.size()),"catzASDF","Catzz.avi"));
        popularVideo.put("DancingVideo", new Video(String.valueOf(popularVideo.size()),"danceASDF","Catzz.avi"));
        popularVideo.put("FootBall", new Video(String.valueOf(popularVideo.size()),"footballASDF","Barcelone vs RealM.mov"));
        popularVideo.put("Programs", new Video(String.valueOf(popularVideo.size()),"progASDF","Catzz.avi"));

        System.out.println("Done!!\n");
        return popularVideo;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency();
        Video video = new Video(videoId,"SomeASDF", "Some video title");

        System.out.print("Done!" + "\n");
        return video;
    }
}
