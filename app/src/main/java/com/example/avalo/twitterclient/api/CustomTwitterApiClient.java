package com.example.avalo.twitterclient.api;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;

/**
 * Created by avalo.
 */
public class CustomTwitterApiClient extends TwitterApiClient {
    public CustomTwitterApiClient(Session session) {
        super(session);
    }

    public TimelineService getTimelineService(){
        return getService(TimelineService.class);
    }
}
