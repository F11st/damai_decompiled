package com.amap.api.col.s;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class br extends df {
    @Override // com.amap.api.col.s.df
    public String a() {
        if (TextUtils.isEmpty(h())) {
            return h();
        }
        String h = h();
        Uri parse = Uri.parse(h);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return h;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }
}
