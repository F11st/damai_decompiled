package com.alimm.xadsdk.request;

import androidx.annotation.NonNull;
import com.alimm.xadsdk.base.net.INetAdapter;
import com.alimm.xadsdk.base.utils.LogUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdRequestConfig {
    private static final String TAG = "AdRequestConfig";
    private INetAdapter mNetAdapter;

    public INetAdapter getNetAdapter() {
        return this.mNetAdapter;
    }

    public AdRequestConfig setNetAdapter(@NonNull INetAdapter iNetAdapter) {
        LogUtils.d(TAG, "setNetAdapter: netAdapter = " + iNetAdapter);
        this.mNetAdapter = iNetAdapter;
        return this;
    }
}
