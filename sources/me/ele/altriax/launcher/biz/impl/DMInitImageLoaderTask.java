package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitImageLoaderDelegate;
import me.ele.altriax.launcher.biz.impl.base.DelegateTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitImageLoaderTask extends DelegateTask<DMInitImageLoaderDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.Task
    public void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        DMInitImageLoaderDelegate delegate = getDelegate(application);
        if (delegate != null) {
            delegate.initImageLoader();
        }
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    public String getName() {
        return "DMInitImageLoaderTask";
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitImageLoaderDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitImageLoaderDelegate;
    }
}
