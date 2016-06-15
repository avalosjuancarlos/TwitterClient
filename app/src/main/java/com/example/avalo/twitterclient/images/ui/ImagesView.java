package com.example.avalo.twitterclient.images.ui;

import com.example.avalo.twitterclient.entities.Image;

import java.util.List;

/**
 * Created by avalo.
 */
public interface ImagesView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String msg);
    void setContent(List<Image> items);
}
