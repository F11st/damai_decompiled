package com.alibaba.android.bindingx.plugin.android;

import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.PlatformManager;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public interface INativeViewUpdater {
    void update(@NonNull View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map);
}
