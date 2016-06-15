package com.example.avalo.twitterclient.images;

import com.example.avalo.twitterclient.images.events.ImagesEvent;

/**
 * Created by avalo.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
