package com.riane.basiclib.utils;

import android.util.Log;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;

import okhttp3.HttpUrl;

/**
 * Created by zhengxiaobo on 2018/9/30.
 */

public class SignUtil {
    private static final String TAG = SignUtil.class.getSimpleName();
    private static final String SECRET_KEY = "ea85624dfcf12d7cc7b2b3a94fac1f2c";
    public static final String PARAM_SIGN = "sign";

    public static String getSign(HttpUrl url) {
        //拼接参数(按顺序)+SecretKey
        Set<String> set = url.queryParameterNames();
        StringBuilder queryParams = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            queryParams.append(str);
            queryParams.append("=");
            queryParams.append(url.queryParameter(str));
            if (it.hasNext()) {
                queryParams.append("&");
            }
        }
        queryParams.append(SECRET_KEY);
        String orignSign = queryParams.toString();
        //进行MD5加密
        String sign = "";
        try {
            sign = MD5Utils.getMD5(orignSign).trim();
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "sign encryption failed : " + e.getMessage());
        }
        return sign;
    }
}
