package com.example.avalo.twitterclient.hashtags;

import com.example.avalo.twitterclient.hashtags.events.HashtagsEvent;
import com.example.avalo.twitterclient.hashtags.ui.HashtagsView;
import com.example.avalo.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by avalo.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter {
    private HashtagsView view;
    private EventBus eventBus;
    private HashtagsInteractor interactor;

    public HashtagsPresenterImpl(HashtagsView view, EventBus eventBus, HashtagsInteractor interactor) {
        this.view = view;
        this.eventBus = eventBus;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getHashtagsTweets() {
        if(view != null){
            view.hideImages();
            view.showProgress();
        }

        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if(view != null){
            view.showImages();
            view.hideProgress();
            if(errorMsg != null){
                view.onError(errorMsg);
            } else {
                view.setContent(event.getHashtags());
            }
        }
    }
}
