package com.example.avalo.twitterclient.hashtags.ui;

import com.example.avalo.twitterclient.entities.Hashtag;

import java.util.List;

/**
 * Created by avalo.
 */
public interface HashtagsView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);
}
