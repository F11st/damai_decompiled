package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitFlutterDelegate;
import me.ele.altriax.launcher.biz.impl.base.DelegateTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitFlutterTask extends DelegateTask<DMInitFlutterDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.Task
    public void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        DMInitFlutterDelegate delegate = getDelegate(application);
        if (delegate != null) {
            delegate.initFlutter();
        }
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    public String getName() {
        return "DMInitFlutterTask";
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitFlutterDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitFlutterDelegate;
    }
}
