package tb;

import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerform;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class fr1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static fr1 b;
    private LongSparseArray<gv0> a = new LongSparseArray<>();

    private fr1() {
        new LongSparseArray();
    }

    public static long a(long j) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "174605087") ? ((Long) ipChange.ipc$dispatch("174605087", new Object[]{Long.valueOf(j)})).longValue() : j ^ 2147483647L;
    }

    public static long b(SkuPerform skuPerform) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-15674050")) {
            return ((Long) ipChange.ipc$dispatch("-15674050", new Object[]{skuPerform})).longValue();
        }
        if (skuPerform != null) {
            return skuPerform.performId ^ 2147483647L;
        }
        return -1L;
    }

    public static fr1 d() {
        fr1 fr1Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033579653")) {
            return (fr1) ipChange.ipc$dispatch("-1033579653", new Object[0]);
        }
        fr1 fr1Var2 = b;
        if (fr1Var2 != null) {
            return fr1Var2;
        }
        synchronized (fr1.class) {
            if (b == null) {
                b = new fr1();
            }
            fr1Var = b;
        }
        return fr1Var;
    }

    public gv0 c(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38950862")) {
            return (gv0) ipChange.ipc$dispatch("-38950862", new Object[]{this, Long.valueOf(j)});
        }
        gv0 gv0Var = this.a.get(j);
        if (gv0Var == null) {
            gv0 gv0Var2 = new gv0();
            this.a.put(j, gv0Var2);
            return gv0Var2;
        }
        return gv0Var;
    }

    public void e(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-75825945")) {
            ipChange.ipc$dispatch("-75825945", new Object[]{this, Long.valueOf(j)});
        } else {
            this.a.remove(j);
        }
    }
}
