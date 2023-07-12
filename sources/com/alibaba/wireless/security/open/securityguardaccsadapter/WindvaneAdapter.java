package com.alibaba.wireless.security.open.securityguardaccsadapter;

import android.content.Context;
import android.taobao.windvane.extra.uc.AliNetworkAdapter;
import com.alibaba.wireless.security.open.securityguardaccsadapter.WindvaneListener;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WindvaneAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindvaneAdapter";
    public static Context gContext;

    public static void registerWindVaneListener(Context context) {
        WindvaneListener.WLOG.d("start registerWindVaneListener");
        gContext = context;
        AliNetworkAdapter.addHttpRequestCallback(new WindvaneListener());
    }
}
