package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitDynamicXDelegate;
import me.ele.altriax.launcher.biz.impl.base.DelegateTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitDynamicXTask extends DelegateTask<DMInitDynamicXDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.Task
    public void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        DMInitDynamicXDelegate delegate = getDelegate(application);
        if (delegate != null) {
            delegate.initDynamicX();
        }
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    public String getName() {
        return "DMInitDynamicXTask";
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitDynamicXDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitDynamicXDelegate;
    }
}
