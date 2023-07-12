package me.ele.altriax.launcher.biz.impl.base;

import android.app.Application;
import androidx.annotation.NonNull;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.bridge.delegate.DMNormalInitDelegate;
import me.ele.altriax.launcher.biz.impl.utils.DelegateUtil;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class DMDelegateTask<D extends DMNormalInitDelegate> extends DelegateTask<D> {
    @Override // me.ele.altriax.launcher.biz.impl.base.Task
    public void delegateInit(@NonNull Application application, @NonNull HashMap<String, Object> hashMap) {
        DelegateUtil.init((DMNormalInitDelegate) getDelegate(application));
    }

    @Override // me.ele.altriax.launcher.biz.impl.base.DelegateTask
    public String getName() {
        return getClass().getSimpleName();
    }
}
