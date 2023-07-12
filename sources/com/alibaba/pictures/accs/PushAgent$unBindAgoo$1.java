package com.alibaba.pictures.accs;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.ICallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.r10;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/alibaba/pictures/accs/PushAgent$unBindAgoo$1", "Lcom/taobao/agoo/ICallback;", "Ltb/wt2;", "onSuccess", "", "s", "s1", "onFailure", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class PushAgent$unBindAgoo$1 extends ICallback {
    private static transient /* synthetic */ IpChange $ipChange;

    PushAgent$unBindAgoo$1() {
    }

    @Override // com.taobao.agoo.ICallback
    public void onFailure(@NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "261565816")) {
            ipChange.ipc$dispatch("261565816", new Object[]{this, str, str2});
            return;
        }
        b41.i(str, "s");
        b41.i(str2, "s1");
        String a = PushAgent.a(PushAgent.INSTANCE);
        ALog.e(a, "unBindAgoo onFailure" + str + r10.DIR + str2, new Object[0]);
    }

    @Override // com.taobao.agoo.ICallback
    public void onSuccess() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2067428021")) {
            ipChange.ipc$dispatch("-2067428021", new Object[]{this});
        } else {
            ALog.e(PushAgent.a(PushAgent.INSTANCE), "unBindAgoo onSuccess", new Object[0]);
        }
    }
}
