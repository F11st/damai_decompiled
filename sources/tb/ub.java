package tb;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.seat.helper.C1667b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ub {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LongSparseArray<C1667b> a = new LongSparseArray<>();

    @NonNull
    public static C1667b a(long j, TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362090378")) {
            return (C1667b) ipChange.ipc$dispatch("-362090378", new Object[]{Long.valueOf(j), tbParams});
        }
        C1667b c1667b = a.get(j);
        return c1667b == null ? b(tbParams) : c1667b;
    }

    public static C1667b b(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75841770")) {
            return (C1667b) ipChange.ipc$dispatch("75841770", new Object[]{tbParams});
        }
        C1667b c1667b = new C1667b(tbParams);
        a.put(c1667b.b, c1667b);
        return c1667b;
    }
}
