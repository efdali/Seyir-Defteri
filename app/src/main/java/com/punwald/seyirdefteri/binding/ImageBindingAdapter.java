package com.punwald.seyirdefteri.binding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.punwald.seyirdefteri.ui.main.home.HomeFragment;
import com.punwald.seyirdefteri.util.Constants;

public class ImageBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (!url.isEmpty()) {

            Glide.with(imageView.getContext())
                    .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W342 + url)
                    .into(imageView);

        }
    }

    @BindingAdapter("backgroundImageUrl")
    public static void loadBackgroundImage(final ViewGroup viewGroup, String url) {
            Glide.with(viewGroup.getContext())
                    .load(Constants.IMAGE_BASE_URL + Constants.IMAGE_W342 + url)
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            viewGroup.setBackgroundDrawable(resource);
                        }
                    });


    }

    @InverseBindingAdapter(attribute = "bind:pmtOpt",
            event = "bind:pmtOptAttrChanged")
    public static String getPmtOpt(final Spinner spinner) {
        return (String)spinner.getSelectedItem();
    }

}
