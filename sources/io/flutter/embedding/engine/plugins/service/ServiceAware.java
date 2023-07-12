package io.flutter.embedding.engine.plugins.service;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ServiceAware {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnModeChangeListener {
        void onMoveToBackground();

        void onMoveToForeground();
    }

    void onAttachedToService(@NonNull ServicePluginBinding servicePluginBinding);

    void onDetachedFromService();
}
