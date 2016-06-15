package com.example.avalo.twitterclient.entities;

/**
 * Created by avalo.
 */
public class Image {
    private String id;
    private String imageURL;
    private String tweetText;
    private int favoriteCount;
    private static final String BASE_TWEET_URL = "https://twitter.com/null/status/";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public String getTweetUrl(){
        return BASE_TWEET_URL + this.id;
    }
}
