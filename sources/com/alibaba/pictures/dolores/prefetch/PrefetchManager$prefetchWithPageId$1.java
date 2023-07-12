package com.alibaba.pictures.dolores.prefetch;

import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class PrefetchManager$prefetchWithPageId$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $pageId;
    final /* synthetic */ PrefetchManager this$0;

    PrefetchManager$prefetchWithPageId$1(PrefetchManager prefetchManager, String str, Bundle bundle) {
        this.this$0 = prefetchManager;
        this.$pageId = str;
        this.$bundle = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020734630")) {
            ipChange.ipc$dispatch("2020734630", new Object[]{this});
        } else {
            this.this$0.c(this.$pageId, this.$bundle);
        }
    }
}
