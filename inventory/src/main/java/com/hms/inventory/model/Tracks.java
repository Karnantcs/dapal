package com.hms.inventory.model;

import org.springframework.stereotype.Component;

@Component
public class Tracks {

    private String albumName;
    private String trackName;
    private String trackUrl;


    public Tracks() {
    }

    public Tracks(String albumName, String trackName, String trackUrl) {
        this.albumName = albumName;
        this.trackName = trackName;
        this.trackUrl = trackUrl;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }
}
