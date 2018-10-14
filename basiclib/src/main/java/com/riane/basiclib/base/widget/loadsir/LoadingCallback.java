package com.riane.basiclib.base.widget.loadsir;

import android.content.Context;
import android.view.View;

import com.kingja.loadsir.callback.Callback;
import com.riane.basiclib.R;

public class LoadingCallback extends Callback {

  @Override
  protected int onCreateView() {
    return R.layout.view_loading_page;
  }

  @Override
  protected boolean onReloadEvent(Context context, View view) {
    return true;
  }
}
