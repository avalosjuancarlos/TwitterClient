package com.example.avalo.twitterclient.images;

/**
 * Created by avalo.
 */
public class ImagesInteractorImpl implements  ImagesInteractor {
    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}
