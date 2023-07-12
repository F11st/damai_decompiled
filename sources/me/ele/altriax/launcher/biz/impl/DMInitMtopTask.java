package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitMtopDelegate;
import me.ele.altriax.launcher.biz.impl.base.DelegateTask;
import me.ele.altriax.launcher.biz.impl.utils.DelegateUtil;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitMtopTask extends DelegateTask<DMInitMtopDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.Task
    public void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        DelegateUtil.init(getDelegate(application));
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    public String getName() {
        return "DMInitMtopTask";
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitMtopDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitMtopDelegate;
    }
}
