package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface PlatformView {
    void dispose();

    View getView();

    @SuppressLint({"NewApi"})
    void onFlutterViewAttached(@NonNull View view);

    @SuppressLint({"NewApi"})
    void onFlutterViewDetached();

    @SuppressLint({"NewApi"})
    @Deprecated
    void onInputConnectionLocked();

    @SuppressLint({"NewApi"})
    @Deprecated
    void onInputConnectionUnlocked();
}
