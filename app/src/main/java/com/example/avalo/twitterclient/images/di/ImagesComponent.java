package com.example.avalo.twitterclient.images.di;

import com.example.avalo.twitterclient.images.ImagesPresenter;
import com.example.avalo.twitterclient.images.ui.ImagesFragment;
import com.example.avalo.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by avalo.
 */
@Singleton
@Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {
    void inject(ImagesFragment fragment);
    // ImagesPresenter getPresenter();
}
