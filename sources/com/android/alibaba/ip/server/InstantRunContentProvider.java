package com.android.alibaba.ip.server;

import tb.q6;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class InstantRunContentProvider extends PreferencesProvider {
    @Override // com.android.alibaba.ip.server.PreferencesProvider
    public String getAuthorities() {
        return q6.a + "." + InstantRunContentProvider.class.getName();
    }

    @Override // com.android.alibaba.ip.server.PreferencesProvider, android.content.ContentProvider
    public boolean onCreate() {
        super.onCreate();
        InstantPatcher.create(getContext());
        return true;
    }
}
