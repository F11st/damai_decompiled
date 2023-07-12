package cn.damai.common.soloader;

import cn.damai.common.soloader.SoFileInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.be2;

/* compiled from: Taobao */
/* renamed from: cn.damai.common.soloader.a */
/* loaded from: classes13.dex */
public class C0522a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static C0522a b;
    private SoFileInfo a;

    private C0522a() {
    }

    public static C0522a a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2140942117")) {
            return (C0522a) ipChange.ipc$dispatch("-2140942117", new Object[0]);
        }
        if (b == null) {
            synchronized (C0522a.class) {
                b = new C0522a();
            }
        }
        return b;
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170329265")) {
            return ((Boolean) ipChange.ipc$dispatch("-1170329265", new Object[]{this})).booleanValue();
        }
        if (this.a == null) {
            this.a = be2.a();
        }
        return this.a.getState() == SoFileInfo.SoFileState.LOADING;
    }
}
