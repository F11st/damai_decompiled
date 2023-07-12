package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class t71 {
    private static transient /* synthetic */ IpChange $ipChange;
    public final String a;
    public final Object b;

    public t71(String str, Object obj) {
        this.a = str;
        this.b = obj;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1351170659")) {
            return ((Boolean) ipChange.ipc$dispatch("1351170659", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || t71.class != obj.getClass()) {
            return false;
        }
        String str = this.a;
        String str2 = ((t71) obj).a;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "673469466")) {
            return ((Integer) ipChange.ipc$dispatch("673469466", new Object[]{this})).intValue();
        }
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "48293674")) {
            return (String) ipChange.ipc$dispatch("48293674", new Object[]{this});
        }
        return "KeyValue{key='" + this.a + "', value=" + this.b + '}';
    }
}
