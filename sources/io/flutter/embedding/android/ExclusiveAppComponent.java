package io.flutter.embedding.android;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ExclusiveAppComponent<T> {
    void detachFromFlutterEngine();

    @NonNull
    T getAppComponent();
}
