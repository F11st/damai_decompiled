package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitAusDelegate;
import me.ele.altriax.launcher.biz.impl.base.DelegateTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitAusTask extends DelegateTask<DMInitAusDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.Task
    public void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        DMInitAusDelegate delegate = getDelegate(application);
        if (delegate != null) {
            delegate.initAus();
        }
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    public String getName() {
        return "DMInitAusTask";
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitAusDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitAusDelegate;
    }
}
