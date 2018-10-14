package com.riane.router;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 在ARouter外再包一层，方便以后替换
 * Created by zhengxiaobo on 2018/8/25.
 */

public class RouterUtils {

    public static ARouter getInstance(){
        return ARouter.getInstance();
    }
}
