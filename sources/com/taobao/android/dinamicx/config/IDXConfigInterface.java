package com.taobao.android.dinamicx.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXConfigInterface {
    void forceCheckUpdate();

    String getConfig(@NonNull String str, @NonNull String str2, @Nullable String str3);

    Map<String, String> getConfigs(@NonNull String str);

    String getCustomConfig(@NonNull String str, @Nullable String str2);

    void registerListener(@NonNull String[] strArr, @NonNull IConfigChangeListener iConfigChangeListener, boolean z);

    void unregisterListener(@NonNull String[] strArr);

    void unregisterListener(@NonNull String[] strArr, @NonNull IConfigChangeListener iConfigChangeListener);
}
