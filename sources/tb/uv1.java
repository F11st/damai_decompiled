package tb;

import cn.damai.common.user.C0525a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class uv1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static C0525a.C0527b a(long j, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-386106199") ? (C0525a.C0527b) ipChange.ipc$dispatch("-386106199", new Object[]{Long.valueOf(j), str}) : new C0525a.C0527b().d(String.valueOf(j)).i(str);
    }

    public static C0525a.C0527b b(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "661605445") ? (C0525a.C0527b) ipChange.ipc$dispatch("661605445", new Object[]{Long.valueOf(j)}) : a(j, pp2.PROJECT_TICKET_PAGE);
    }

    public static C0525a.C0527b c(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "967433141") ? (C0525a.C0527b) ipChange.ipc$dispatch("967433141", new Object[]{Long.valueOf(j)}) : a(j, pp2.PROJECT_PAGE_WARM_PROMPT);
    }
}
