package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ho {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FLAG_NONE = -2;
    public static final int FLAG_UNDEFINE = -1;
    public int a;
    public int b;
    public int c;

    public ho(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155897734")) {
            return ((Boolean) ipChange.ipc$dispatch("-155897734", new Object[]{this, obj})).booleanValue();
        }
        ho hoVar = (ho) obj;
        if (this != obj) {
            return this.a == hoVar.a && this.b == hoVar.b && this.c == hoVar.c;
        }
        return true;
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "573813747")) {
            return (String) ipChange.ipc$dispatch("573813747", new Object[]{this});
        }
        return "pos@[" + this.a + AVFSCacheConstants.COMMA_SEP + this.b + AVFSCacheConstants.COMMA_SEP + this.c + jn1.ARRAY_END_STR;
    }
}
