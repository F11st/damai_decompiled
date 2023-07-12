package me.ele.altriax.launcher.biz.impl;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.ele.altriax.launcher.biz.bridge.DelegateRuntime;
import me.ele.altriax.launcher.biz.bridge.delegate.DMInitOrangeDelegate;
import me.ele.altriax.launcher.biz.impl.base.DMDelegateTask;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DMInitOrangeTask extends DMDelegateTask<DMInitOrangeDelegate> {
    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    @Nullable
    public DMInitOrangeDelegate getDelegate(@NonNull Application application) {
        return DelegateRuntime.sDMInitOrangeDelegate;
    }
}
