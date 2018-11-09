package com.riane.basiclib.base.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.riane.basicres.R;

/**
 * Created by zhengxiaobo on 2018/11/8.
 */

public class CustomEmptyView extends FrameLayout{

    private ImageView mEmptyImg;
    private TextView mEmptyText;

    public CustomEmptyView(@NonNull Context context) {
        this(context, null);
        init();
    }

    public CustomEmptyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public CustomEmptyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_empty_page, this);
        mEmptyImg = view.findViewById(R.id.img_page_empty);
        mEmptyText = view.findViewById(R.id.tv_page_empty);
    }

    public void setEmptyImage(int imgRes) {
        mEmptyImg.setImageResource(imgRes);
    }

    public void setEmptyText(String text) {
        mEmptyText.setText(text);
    }

}
