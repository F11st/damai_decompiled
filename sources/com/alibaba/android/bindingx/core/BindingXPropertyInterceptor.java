package com.alibaba.android.bindingx.core;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.PlatformManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BindingXPropertyInterceptor {
    private static BindingXPropertyInterceptor c = new BindingXPropertyInterceptor();
    private final Handler a = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList<IPropertyUpdateInterceptor> b = new CopyOnWriteArrayList<>();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface IPropertyUpdateInterceptor {
        boolean updateView(@Nullable View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map, Object... objArr);
    }

    private BindingXPropertyInterceptor() {
    }

    @NonNull
    public static BindingXPropertyInterceptor c() {
        return c;
    }

    public void b() {
        this.a.removeCallbacksAndMessages(null);
    }

    public void d(@Nullable final View view, @NonNull final String str, @NonNull final Object obj, @NonNull final PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull final Map<String, Object> map, final Object... objArr) {
        if (this.b.isEmpty()) {
            return;
        }
        this.a.post(new WeakRunnable(new Runnable() { // from class: com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = BindingXPropertyInterceptor.this.b.iterator();
                while (it.hasNext()) {
                    ((IPropertyUpdateInterceptor) it.next()).updateView(view, str, obj, iDeviceResolutionTranslator, map, objArr);
                }
            }
        }));
    }
}
