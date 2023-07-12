package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class fm {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int COMMONTYPE = 1;
    public static final int DXTYPE = 3;
    public static final int PUBUTYPE = 2;
    public int a;
    public int b;

    public fm(String str) {
        this.a = gh1.a.get(str).intValue();
        a();
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214309910")) {
            ipChange.ipc$dispatch("1214309910", new Object[]{this});
        } else if (gh1.b.contains(Integer.valueOf(this.a))) {
            this.b = 1;
        } else if (gh1.c.contains(Integer.valueOf(this.a))) {
            this.b = 2;
        } else if (gh1.d.contains(Integer.valueOf(this.a))) {
            this.b = 3;
        }
    }
}
