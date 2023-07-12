package io.flutter.embedding.engine.plugins.contentprovider;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ContentProviderAware {
    void onAttachedToContentProvider(@NonNull ContentProviderPluginBinding contentProviderPluginBinding);

    void onDetachedFromContentProvider();
}
