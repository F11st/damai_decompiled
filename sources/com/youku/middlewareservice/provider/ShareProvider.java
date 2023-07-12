package com.youku.middlewareservice.provider;

import android.app.Activity;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public interface ShareProvider {
    public static final String SHARE_FORWARD_URL = "forwardUrl";
    public static final String SHARE_FROM = "share_from";
    public static final String SHARE_FROM_DETAIL = "detail";
    public static final String SHARE_IMAGE = "image";
    public static final String SHARE_SID = "sid";
    public static final String SHARE_TEXT = "text";
    public static final String SHARE_TITLE = "title";
    public static final String SHARE_UID = "uid";
    public static final String SHARE_URL = "url";

    void show(Activity activity, Map<String, String> map);
}
