package com.example.avalo.twitterclient.hashtags.di;

import com.example.avalo.twitterclient.hashtags.ui.HashtagsFragment;
import com.example.avalo.twitterclient.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by avalo.
 */
@Singleton
@Component(modules = {LibsModule.class, HashtagsModule.class})
public interface HashtagsComponent {
    void inject(HashtagsFragment fragment);
    // ImagesPresenter getPresenter();
}
