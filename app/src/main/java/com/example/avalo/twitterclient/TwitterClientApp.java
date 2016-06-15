package com.example.avalo.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.avalo.twitterclient.hashtags.di.DaggerHashtagsComponent;
import com.example.avalo.twitterclient.hashtags.di.HashtagsComponent;
import com.example.avalo.twitterclient.hashtags.di.HashtagsModule;
import com.example.avalo.twitterclient.hashtags.ui.HashtagsView;
import com.example.avalo.twitterclient.images.di.DaggerImagesComponent;
import com.example.avalo.twitterclient.images.di.ImagesComponent;
import com.example.avalo.twitterclient.images.di.ImagesModule;
import com.example.avalo.twitterclient.images.ui.ImagesView;
import com.example.avalo.twitterclient.lib.di.LibsModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by avalo.
 */
public class TwitterClientApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view,
                                              com.example.avalo.twitterclient.images.ui.adapters.OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }

    public HashtagsComponent getHashtagsComponent(HashtagsView view,
                                                  com.example.avalo.twitterclient.hashtags.ui.adapters.OnItemClickListener clickListener){

        return DaggerHashtagsComponent
                .builder()
                .libsModule(new LibsModule(null))
                .hashtagsModule(new HashtagsModule(view, clickListener))
                .build();

    }
}
