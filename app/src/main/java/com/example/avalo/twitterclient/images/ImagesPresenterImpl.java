package com.example.avalo.twitterclient.images;

import com.example.avalo.twitterclient.images.events.ImagesEvent;
import com.example.avalo.twitterclient.images.ui.ImagesView;
import com.example.avalo.twitterclient.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by avalo.
 */
public class ImagesPresenterImpl implements ImagesPresenter {
    private ImagesView view;
    private EventBus eventBus;
    private ImagesInteractor interactor;

    public ImagesPresenterImpl(ImagesView view, EventBus eventBus, ImagesInteractor interactor) {
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
    public void getImageTweets() {
        if(view != null){
            view.hideImages();
            view.showProgress();
        }
        interactor.execute();
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(ImagesEvent event) {
        String errorMsg = event.getError();
        if(view != null){
            view.showImages();
            view.hideProgress();
            if(errorMsg != null){
                view.onError(errorMsg);
            } else {
                view.setContent(event.getImages());
            }
        }
    }
}
