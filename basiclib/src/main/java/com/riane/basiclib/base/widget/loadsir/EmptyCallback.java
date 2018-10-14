package com.riane.basiclib.base.widget.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.riane.basiclib.R;

public class EmptyCallback extends Callback {

  @Override
  protected int onCreateView() {
    return R.layout.view_empty_page;
  }
}
