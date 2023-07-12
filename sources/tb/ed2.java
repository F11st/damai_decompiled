package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ed2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Object[] a;
    private int b = -1;
    private int c;

    public ed2(int i) {
        this.c = i;
        this.a = new Object[i];
    }

    public Object a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-952345539")) {
            return ipChange.ipc$dispatch("-952345539", new Object[]{this});
        }
        int i = this.b;
        if (i >= 0) {
            Object[] objArr = this.a;
            if (i > objArr.length) {
                return null;
            }
            return objArr[i];
        }
        return null;
    }

    public Object b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567542665")) {
            return ipChange.ipc$dispatch("1567542665", new Object[]{this});
        }
        int i = this.b;
        if (i == -1) {
            jb1.a("simpleStack", "栈空异常");
            return null;
        }
        Object[] objArr = this.a;
        this.b = i - 1;
        return objArr[i];
    }

    public Object c(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377793632")) {
            return ipChange.ipc$dispatch("-1377793632", new Object[]{this, obj});
        }
        Object b = this.b == this.c - 1 ? b() : null;
        Object[] objArr = this.a;
        int i = this.b + 1;
        this.b = i;
        objArr[i] = obj;
        return b;
    }
}
