package tb;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ub {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final LongSparseArray<cn.damai.seat.helper.b> a = new LongSparseArray<>();

    @NonNull
    public static cn.damai.seat.helper.b a(long j, TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362090378")) {
            return (cn.damai.seat.helper.b) ipChange.ipc$dispatch("-362090378", new Object[]{Long.valueOf(j), tbParams});
        }
        cn.damai.seat.helper.b bVar = a.get(j);
        return bVar == null ? b(tbParams) : bVar;
    }

    public static cn.damai.seat.helper.b b(TbParams tbParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "75841770")) {
            return (cn.damai.seat.helper.b) ipChange.ipc$dispatch("75841770", new Object[]{tbParams});
        }
        cn.damai.seat.helper.b bVar = new cn.damai.seat.helper.b(tbParams);
        a.put(bVar.b, bVar);
        return bVar;
    }
}
