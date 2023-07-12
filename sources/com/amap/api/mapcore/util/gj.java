package com.amap.api.mapcore.util;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class gj extends ii {
    @Override // com.amap.api.mapcore.util.ii
    public String getIPV6URL() {
        if (TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        String url = getURL();
        Uri parse = Uri.parse(url);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }

    @Override // com.amap.api.mapcore.util.ii
    public boolean isSupportIPV6() {
        return true;
    }
}
