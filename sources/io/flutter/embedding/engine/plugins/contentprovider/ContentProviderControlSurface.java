package io.flutter.embedding.engine.plugins.contentprovider;

import android.content.ContentProvider;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ContentProviderControlSurface {
    void attachToContentProvider(@NonNull ContentProvider contentProvider, @NonNull Lifecycle lifecycle);

    void detachFromContentProvider();
}
