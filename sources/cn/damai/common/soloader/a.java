package cn.damai.common.soloader;

import cn.damai.common.soloader.SoFileInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.be2;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class a {
    private static transient /* synthetic */ IpChange $ipChange;
    private static a b;
    private SoFileInfo a;

    private a() {
    }

    public static a a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2140942117")) {
            return (a) ipChange.ipc$dispatch("-2140942117", new Object[0]);
        }
        if (b == null) {
            synchronized (a.class) {
                b = new a();
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
