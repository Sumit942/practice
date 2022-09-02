package com.practice.designPatterns.proxy;
//https://refactoring.guru/design-patterns/chain-of-responsibility/java/example
public class Demo {

    public static void main(String[] args) {
        YoutubeDownloader nativeDownloader = new YoutubeDownloader(new YoutubeThirdPartyClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());

        long naive = test(nativeDownloader);
        System.out.println("\n--------------------SMART PROXY-------------------");
        long smart = test(smartDownloader);
        System.out.println("Time saved by caching proxy: "+(naive-smart)+"ms");
    }

    private static long test(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        //fetch popular videos from youtube
        downloader.rendorPopularVideo();
        downloader.rendorVideo("Venkat Subramanian Java 8");
        //fetch again
        downloader.rendorPopularVideo();
        downloader.rendorVideo("Venkat Subramanian Java 8");
        downloader.rendorVideo("Venkat Subramanian Java 9");
        //user is playing same video
        downloader.rendorVideo("Venkat Subramanian Java 8");
        downloader.rendorVideo("Venkat Subramanian Java 8");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
