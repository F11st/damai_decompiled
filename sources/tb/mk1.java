package tb;

import androidx.collection.LongSparseArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class mk1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static mk1 b;
    private LongSparseArray<lk1> a = new LongSparseArray<>();

    private mk1() {
    }

    public static mk1 a() {
        mk1 mk1Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305954299")) {
            return (mk1) ipChange.ipc$dispatch("1305954299", new Object[0]);
        }
        mk1 mk1Var2 = b;
        if (mk1Var2 != null) {
            return mk1Var2;
        }
        synchronized (fr1.class) {
            if (b == null) {
                b = new mk1();
            }
            mk1Var = b;
        }
        return mk1Var;
    }

    public lk1 b(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871884612")) {
            return (lk1) ipChange.ipc$dispatch("871884612", new Object[]{this, Long.valueOf(j)});
        }
        lk1 lk1Var = this.a.get(j);
        if (lk1Var == null) {
            lk1 lk1Var2 = new lk1();
            this.a.put(j, lk1Var2);
            return lk1Var2;
        }
        return lk1Var;
    }

    public void c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "866891887")) {
            ipChange.ipc$dispatch("866891887", new Object[]{this, Long.valueOf(j)});
        } else {
            this.a.remove(j);
        }
    }
}
