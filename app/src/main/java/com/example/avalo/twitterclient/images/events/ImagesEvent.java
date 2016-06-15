package com.example.avalo.twitterclient.images.events;

import com.example.avalo.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by avalo.
 */
public class ImagesEvent {
    private String error;
    private List<Image> images;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
