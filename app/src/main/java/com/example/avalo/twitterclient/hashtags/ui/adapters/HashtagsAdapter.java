package com.example.avalo.twitterclient.hashtags.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.avalo.twitterclient.R;
import com.example.avalo.twitterclient.entities.Hashtag;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by avalo.
 */
public class HashtagsAdapter extends RecyclerView.Adapter<HashtagsAdapter.ViewHolder> {
    private List<Hashtag> items;
    private OnItemClickListener clickListener;

    public HashtagsAdapter(List<Hashtag> items, OnItemClickListener clickListener) {
        this.items = items;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_hashtag, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hashtag tweet = items.get(position);
        holder.setOnItemClickListener(tweet,clickListener);
        holder.txtView.setText(tweet.getTweetText());
        holder.setItems(tweet.getHashtags());
    }

    public void  setItems(List<Hashtag> newItems){
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtTweet)
        TextView txtView;
        @Bind(R.id.recyclerView)
        RecyclerView recyclerView;

        private HashtagListAdapter adapter;
        private List<String> items;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            items = new ArrayList<>();
            adapter = new HashtagListAdapter(items);

            CustomGridLayoutManager layoutManager = new CustomGridLayoutManager(context, 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

        public void setItems(List<String> newItems){
            items.clear();
            items.addAll(newItems);
            adapter.notifyDataSetChanged();
        }

        public void setOnItemClickListener(final Hashtag tweet, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(tweet);
                }
            });
        }
    }
}
