package com.example.avalo.twitterclient.hashtags.di;

import com.example.avalo.twitterclient.api.CustomTwitterApiClient;
import com.example.avalo.twitterclient.entities.Hashtag;
import com.example.avalo.twitterclient.hashtags.HashtagsInteractor;
import com.example.avalo.twitterclient.hashtags.HashtagsInteractorImpl;
import com.example.avalo.twitterclient.hashtags.HashtagsPresenter;
import com.example.avalo.twitterclient.hashtags.HashtagsPresenterImpl;
import com.example.avalo.twitterclient.hashtags.HashtagsRepository;
import com.example.avalo.twitterclient.hashtags.HashtagsRepositoryImpl;
import com.example.avalo.twitterclient.hashtags.ui.HashtagsView;
import com.example.avalo.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import com.example.avalo.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import com.example.avalo.twitterclient.lib.base.EventBus;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by avalo.
 */
@Module
public class HashtagsModule {
    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset, OnItemClickListener clickListener){
        return new HashtagsAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemsList(){
        return new ArrayList<>();
    }

    @Provides
    @Singleton
    HashtagsPresenter providesImagesPresenter(HashtagsView view, EventBus eventBus, HashtagsInteractor interactor){
        return new HashtagsPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesHashtagsView(){
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesHashtagsInteractor(HashtagsRepository repository){
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesHashtagsRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagsRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session sesion){
        return new CustomTwitterApiClient(sesion);
    }

    @Provides
    @Singleton
    Session providesTwitter(){
        return Twitter.getSessionManager().getActiveSession();
    }
}
