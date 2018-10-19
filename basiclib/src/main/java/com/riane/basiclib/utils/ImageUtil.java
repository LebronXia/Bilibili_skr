package com.riane.basiclib.utils;

import android.content.Context;
import android.widget.ImageView;

import com.riane.basiclib.R;
import com.riane.basiclib.imageloader.glide.GlideImageConfig;

/**
 * Created by zhengxiaobo on 2018/10/16.
 */

public class ImageUtil {
    public static void load(Context context, String url, ImageView imageView){
        Utils.getAppComponent().imageLoder()
                .loadImage(context,
                        GlideImageConfig
                                .builder()
                                .url(url)
                                .placeholder( R.drawable.bili_default_image_tv) //加载成功前显示的图片
                                .imagerView(imageView)
                                .build());
    }

    public static void loadWidthAndHeight(Context context, String url, ImageView imageView, int width, int height){
        Utils.getAppComponent().imageLoder()
                .loadImage(context,
                        GlideImageConfig
                                .builder()
                                .url(url)
                                .placeholder( R.drawable.bili_default_image_tv) //加载成功前显示的图片
                                .override(width, height)
                                .imagerView(imageView)
                                .build());
    }
}
