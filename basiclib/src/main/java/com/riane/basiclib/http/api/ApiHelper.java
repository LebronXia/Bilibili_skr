package com.riane.basiclib.http.api;

import android.util.Log;

import com.riane.basiclib.utils.MD5Utils;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;

import okhttp3.HttpUrl;

/**
 * Created by zhengxiaobo on 2018/9/30.
 */

public class ApiHelper {

    public static final String APP_KEY = "27eb53fc9058f8c3";
    public static final String ACCESS_KRY = "a4596eb3bf145472ab1d4324bfb95325";
    public static final String ACTIONKEY = "appkey";
    public static final String AD_EXTRA = "4008EEE162AE27F7D00276B573E3A6F804C74063748680418088A2769B7B87CBDDD\n" +
            "3599F07193D7AD5C1A77CE57534EFE40BD977AA26570CF87871864404ADD69838D5AB9B885BAD0BC\n" +
            "9998FA25F7E470B93F830FDBD8CBD47EB775917708440861315DC92580D6BB1319598154C830CA3F\n" +
            "85EA6D831168B19246CEC21996BDF8E3DA25E7A19211BAE7880AF4A7EC36E2D0856A85508A841EE0\n" +
            "16F43A81E19D2772675534B9FB48905994A247F6885CCFD11451B4A0F0F2BC7639A87B082C1994CF\n" +
            "9ADA8EB55C15B40B39F9A2E54A352929062210A3919EB4A687CDC5E9230D598986087BD915517CD2\n" +
            "91C0CC613D38FDBB9F91626CE9827FA0C669DEB749129AE49089C27E32AD43826E2DD6305EA09CA9\n" +
            "5FA28B58C96F237A001ACC84FFF94851BC1CF9064CA4C7BB1724A57F2072278C5B64E4CBD2AF3864\n" +
            "E484C53B08C712241C0B2720FEF8D6381058D75AEC3B34C8A64DD66AD03007EAB09485AE0B77BE14\n" +
            "4565837395F412FF1E68F7AFDCA66B3C84DE1CE4F6D6D62CAC0DB517D14B1FD114BCB6D9B108CC82\n" +
            "D3B4523B18492A942E9533D7F9E79B8CEC2CC314C6A248926E2B6414B71212F1766702352E80652A\n" +
            "E50D68DCFF988A051EF476201102C4F74B6819B0E723650B917FD3ACA507E9505B0FC7BA97506BEE\n" +
            "6B212FAD480928590CD66CDA892459A780FC6E89BF6DE6F2739915CE8DF6B720DACAA63C53F88";
    public static final String BANNER_HASH = "";
    public static final String BUILD = "6570";
    public static final String DEVICE = "android";
    public static final String IDX = "1515863814";
    public static final int LOGIN_EVENT = 2;
    public static final String MOBI_APP = "android";
    public static final String NET_WORK = "wifi";
    public static final String PLATFORM = "android";
    public static final String QN = "80";
    public static final int STYLE = 2;
    public static final String TS = "1538276943";

}
