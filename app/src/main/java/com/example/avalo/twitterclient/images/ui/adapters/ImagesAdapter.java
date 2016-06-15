package com.example.avalo.twitterclient.images.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avalo.twitterclient.R;
import com.example.avalo.twitterclient.entities.Image;
import com.example.avalo.twitterclient.lib.base.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by avalo.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
    private List<Image> dataset;
    private ImageLoader imageLoader;
    private OnItemClickListener clickListener;

    public ImagesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener) {
        this.dataset = dataset;
        this.imageLoader = imageLoader;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_images, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image imageTweet = dataset.get(position);
        holder.setOnClickListener(imageTweet, clickListener);
        holder.txtTweet.setText(imageTweet.getTweetText());
        holder.txtFavs.setText(String.valueOf(imageTweet.getFavoriteCount()));
        imageLoader.load(holder.imgMedia, imageTweet.getImageURL());
    }

    public void setItems(List<Image> newItems){
        dataset.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.txtTweet)
        TextView txtTweet;
        @Bind(R.id.txtFavs)
        TextView txtFavs;
        @Bind(R.id.imgMedia)
        ImageView imgMedia;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setOnClickListener(final Image image, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(image);
                }
            });
        }
    }
}
