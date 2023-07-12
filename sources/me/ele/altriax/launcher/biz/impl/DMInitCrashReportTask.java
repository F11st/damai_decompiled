package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitCrashReportDelegate;
import me.ele.altriax.launcher.biz.impl.base.DelegateTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitCrashReportTask extends DelegateTask<DMInitCrashReportDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.Task
    public void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        DMInitCrashReportDelegate delegate = getDelegate(application);
        if (delegate != null) {
            delegate.initCrashReport();
        }
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    public String getName() {
        return "DMInitCrashReportTask";
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitCrashReportDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitCrashReportDelegate;
    }
}
