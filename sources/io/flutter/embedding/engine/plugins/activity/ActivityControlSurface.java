package io.flutter.embedding.engine.plugins.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.android.ExclusiveAppComponent;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ActivityControlSurface {
    @Deprecated
    void attachToActivity(@NonNull Activity activity, @NonNull Lifecycle lifecycle);

    void attachToActivity(@NonNull ExclusiveAppComponent<Activity> exclusiveAppComponent, @NonNull Lifecycle lifecycle);

    void detachFromActivity();

    void detachFromActivityForConfigChanges();

    boolean onActivityResult(int i, int i2, @Nullable Intent intent);

    void onNewIntent(@NonNull Intent intent);

    boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    void onRestoreInstanceState(@Nullable Bundle bundle);

    void onSaveInstanceState(@NonNull Bundle bundle);

    void onUserLeaveHint();
}
