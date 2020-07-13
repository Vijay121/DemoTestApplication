package com.cogni.demotestapplication.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cogni.demotestapplication.R;

public class RowsItem{
	private String imageHref;
	private String description;
	private String title;

	public String getImageHref(){
		return imageHref;
	}

	public String getDescription(){
		return description;
	}

	public String getTitle(){
		return title;
	}

	// important code for loading image here
	@BindingAdapter({ "imageHref" })
	public static void loadImage(ImageView imageView, String imageURL) {
		Glide.with(imageView.getContext())
				.setDefaultRequestOptions(new RequestOptions()
						.circleCrop())
				.load(imageURL)
				.placeholder(R.mipmap.ic_launcher)
				.into(imageView);
	}
}
