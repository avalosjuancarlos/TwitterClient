package com.example.avalo.twitterclient.hashtags.events;

import com.example.avalo.twitterclient.entities.Hashtag;
import com.example.avalo.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by avalo.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }
}
