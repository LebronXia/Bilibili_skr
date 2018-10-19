package com.riane.homepage.mvp.ui.support;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.riane.homepage.R;
import com.riane.homepage.mvp.model.entity.Item;

/**
 * Created by zhengxiaobo on 2018/10/18.
 */

public class BangumiIntemDecoration extends RecyclerView.ItemDecoration{

    /**
     * https://blog.csdn.net/briblue/article/details/70161917
     * outRect 是一个全为 0 的 Rect。view 指 RecyclerView 中的 Item。parent 就是 RecyclerView 本身，state 就是一个状态。
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int position = parent.getChildAdapterPosition(view);
        //GridLayoutManager.SpanSizeLookup spanSizeLookup = ((GridLayoutManager)parent.getLayoutManager()).getSpanSizeLookup();
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        //获取每个item所占的span
        int spanSize = layoutParams.getSpanSize();

        if (spanSize == 3){
            if (position == 0){
                outRect.bottom = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
            }
            if (position >= 1 && position < state.getItemCount() - 2) {
                if (!(view.getTag() instanceof Item)) {
                    outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                    outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                }
                outRect.bottom = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
            } else if (position == state.getItemCount() - 2) {//Bnaugmi有加载更多，特殊处理
                outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
            }
        } else {
            //同行之间的比较 按顺序排列。同行中间的两个间隔和左右离屏幕间隔保持一致
            int spanIndex = layoutParams.getSpanIndex();
            switch (spanIndex) {
                case 0:
                    outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                    outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_min);
                    break;
                case 1:
                    outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_7);
                    outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_7);
                    break;
                case 2:
                    outRect.left = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_min);
                    outRect.right = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_medium);
                    break;
            }
            outRect.bottom = view.getContext().getResources().getDimensionPixelSize(R.dimen.margin_15);

        }

    }
}
