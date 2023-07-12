package com.youku.live.livesdk.constants;

import android.net.Uri;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SchemaConstants {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SCHEMA_LAIFENG_HTTP = "http://v.laifeng.com";
    public static final String SCHEMA_LAIFENG_HTTPS = "https://v.laifeng.com";
    public static final String SCHEMA_LAIFENG_LFROOM = "laifeng://room";
    public static final String SCHEMA_LAIFENG_LFSDKROOM = "lfsdk://room";
    public static final String SCHEMA_QUERY_DISPLAYGIFTTIPS = "displayGiftTips";
    public static final String SCHEMA_QUERY_ID = "id";
    public static final String SCHEMA_QUERY_ID_RECOMMEND = "recommend";
    public static final String SCHEMA_QUERY_INSTANCE_ID = "instance_id";
    public static final String SCHEMA_QUERY_LAYOUT = "layout";
    public static final String SCHEMA_QUERY_SDK_VERSION = "sdkversion";
    public static final String SCHEMA_QUERY_SPM = "spm";
    public static final String SCHEMA_QUERY_TPL_TAG = "ttag";
    public static final String SCHEMA_QUERY_WX_BUNDLE = "wxbundle";
    public static final String SCHEMA_QUERY_WX_URL = "wx_url";
    public static final String SCHEMA_YOUKULIVE_CAROUSEL_KEY = "type";
    public static final String SCHEMA_YOUKULIVE_CAROUSEL_VALUE = "carousel";
    public static final String SCHEMA_YOUKULIVE_DAMAI_LiveRoom = "damai://liveroom";
    public static final String SCHEMA_YOUKULIVE_HTTP = "http://vku.youku.com/live/ilproom";
    public static final String SCHEMA_YOUKULIVE_HTTPS = "https://vku.youku.com/live/ilproom";
    public static final String SCHEMA_YOUKULIVE_HTTPS_SEP = "https://vku.youku.com/live/ilproom/";
    public static final String SCHEMA_YOUKULIVE_HTTP_SEP = "http://vku.youku.com/live/ilproom/";
    public static final String SCHEMA_YOUKULIVE_YOUKU_ILPROOM = "youku://ilproom";
    public static final String SCHEMA_YOUKULIVE_YOUKU_ILPROOM_SEP = "youku://ilproom/";

    public static boolean isLaifengSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1058611134")) {
            return ((Boolean) ipChange.ipc$dispatch("-1058611134", new Object[]{str})).booleanValue();
        }
        String lowerCase = str != null ? str.toLowerCase() : null;
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        return lowerCase.startsWith(SCHEMA_LAIFENG_HTTP) || lowerCase.startsWith(SCHEMA_LAIFENG_HTTPS) || lowerCase.startsWith(SCHEMA_LAIFENG_LFROOM) || lowerCase.startsWith(SCHEMA_LAIFENG_LFSDKROOM);
    }

    public static boolean isYoukuLiveCarouselSchema(String str, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "727590614")) {
            return ((Boolean) ipChange.ipc$dispatch("727590614", new Object[]{str, uri})).booleanValue();
        }
        String lowerCase = str != null ? str.toLowerCase() : null;
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        return (lowerCase.startsWith(SCHEMA_YOUKULIVE_HTTP) || lowerCase.startsWith(SCHEMA_YOUKULIVE_HTTPS) || lowerCase.startsWith(SCHEMA_YOUKULIVE_YOUKU_ILPROOM)) && uri != null && SCHEMA_YOUKULIVE_CAROUSEL_VALUE.equals(uri.getQueryParameter("type"));
    }

    public static boolean isYoukuLiveSchema(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618711143")) {
            return ((Boolean) ipChange.ipc$dispatch("-618711143", new Object[]{str})).booleanValue();
        }
        String lowerCase = str != null ? str.toLowerCase() : null;
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        return lowerCase.startsWith(SCHEMA_YOUKULIVE_HTTP) || lowerCase.startsWith(SCHEMA_YOUKULIVE_HTTPS) || lowerCase.startsWith(SCHEMA_YOUKULIVE_YOUKU_ILPROOM) || lowerCase.startsWith(SCHEMA_YOUKULIVE_HTTP_SEP) || lowerCase.startsWith(SCHEMA_YOUKULIVE_HTTPS_SEP) || lowerCase.startsWith(SCHEMA_YOUKULIVE_YOUKU_ILPROOM_SEP) || lowerCase.startsWith(SCHEMA_YOUKULIVE_DAMAI_LiveRoom);
    }
}
