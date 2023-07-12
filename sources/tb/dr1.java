package tb;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class dr1 implements Comparable<dr1> {
    private static transient /* synthetic */ IpChange $ipChange;
    public final int a;
    public final byte[] b;

    public dr1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull dr1 dr1Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1821374983") ? ((Integer) ipChange.ipc$dispatch("1821374983", new Object[]{this, dr1Var})).intValue() : this.a - dr1Var.a;
    }
}
