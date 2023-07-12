package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.seat.loader.request.Seat3DVrImageDowngradeRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.j82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class l82 extends oa<SeatBox, j82.a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile l82 d;

    private l82() {
    }

    public static synchronized l82 r() {
        synchronized (l82.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "255139419")) {
                return (l82) ipChange.ipc$dispatch("255139419", new Object[0]);
            }
            if (d == null) {
                d = new l82();
            }
            return d;
        }
    }

    @Override // tb.oa
    public cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<SeatBox, j82.a> e(@NonNull kn1<j82.a> kn1Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "632565679") ? (cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) ipChange.ipc$dispatch("632565679", new Object[]{this, kn1Var}) : new Seat3DVrImageDowngradeRequest(kn1Var);
    }
}
