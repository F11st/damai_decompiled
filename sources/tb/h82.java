package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.C0822c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class h82 extends oa<SeatBox, i82> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static h82 d;

    private h82() {
    }

    public static synchronized h82 r() {
        synchronized (h82.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1932832123")) {
                return (h82) ipChange.ipc$dispatch("1932832123", new Object[0]);
            }
            if (d == null) {
                d = new h82();
            }
            return d;
        }
    }

    @Override // tb.oa
    public AbstractC0818a<SeatBox, i82> e(@NonNull kn1<i82> kn1Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2105157778") ? (AbstractC0818a) ipChange.ipc$dispatch("-2105157778", new Object[]{this, kn1Var}) : new C0822c(kn1Var);
    }
}
