package com.example.avalo.twitterclient.hashtags;

import com.example.avalo.twitterclient.hashtags.events.HashtagsEvent;

/**
 * Created by avalo.
 */
public interface HashtagsPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getHashtagsTweets();
    void onEventMainThread(HashtagsEvent event);
}
