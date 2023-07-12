package com.google.vr.ndk.base;

import android.app.PendingIntent;
import android.view.View;
import com.google.vr.vrcore.library.api.IGvrLayout;
import com.google.vr.vrcore.library.api.IGvrUiLayout;
import com.google.vr.vrcore.library.api.IObjectWrapper;
import com.google.vr.vrcore.library.api.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GvrLayoutImplWrapper extends IGvrLayout.Stub {
    private final GvrLayoutImpl impl;

    public GvrLayoutImplWrapper(GvrLayoutImpl gvrLayoutImpl) {
        this.impl = gvrLayoutImpl;
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public boolean enableAsyncReprojection(int i) {
        return this.impl.enableAsyncReprojection(i);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public boolean enableCardboardTriggerEmulation(IObjectWrapper iObjectWrapper) {
        return this.impl.enableCardboardTriggerEmulation((Runnable) ObjectWrapper.unwrap(iObjectWrapper, Runnable.class));
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public long getNativeGvrContext() {
        return this.impl.getGvrApi().getNativeGvrContext();
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public IObjectWrapper getRootView() {
        return ObjectWrapper.wrap(this.impl);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public IGvrUiLayout getUiLayout() {
        return this.impl.getUiLayoutImpl();
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public void onBackPressed() {
        this.impl.onBackPressed();
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public void onPause() {
        this.impl.onPause();
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public void onResume() {
        this.impl.onResume();
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public void setPresentationView(IObjectWrapper iObjectWrapper) {
        this.impl.setPresentationView((View) ObjectWrapper.unwrap(iObjectWrapper, View.class));
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public void setReentryIntent(IObjectWrapper iObjectWrapper) {
        this.impl.setReentryIntent((PendingIntent) ObjectWrapper.unwrap(iObjectWrapper, PendingIntent.class));
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public void setStereoModeEnabled(boolean z) {
        this.impl.setStereoModeEnabled(z);
    }

    @Override // com.google.vr.vrcore.library.api.IGvrLayout
    public void shutdown() {
        this.impl.shutdown();
    }
}
