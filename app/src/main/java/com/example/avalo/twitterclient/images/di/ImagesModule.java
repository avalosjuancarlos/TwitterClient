package com.example.avalo.twitterclient.images.di;

import com.example.avalo.twitterclient.api.CustomTwitterApiClient;
import com.example.avalo.twitterclient.entities.Image;
import com.example.avalo.twitterclient.images.ImagesInteractor;
import com.example.avalo.twitterclient.images.ImagesInteractorImpl;
import com.example.avalo.twitterclient.images.ImagesPresenter;
import com.example.avalo.twitterclient.images.ImagesPresenterImpl;
import com.example.avalo.twitterclient.images.ImagesRepository;
import com.example.avalo.twitterclient.images.ImagesRepositoryImpl;
import com.example.avalo.twitterclient.images.ui.ImagesView;
import com.example.avalo.twitterclient.images.ui.adapters.ImagesAdapter;
import com.example.avalo.twitterclient.images.ui.adapters.OnItemClickListener;
import com.example.avalo.twitterclient.lib.base.EventBus;
import com.example.avalo.twitterclient.lib.base.ImageLoader;
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
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemsList(){
        return new ArrayList<>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenterImpl(view, eventBus, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImagesView(){
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
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
