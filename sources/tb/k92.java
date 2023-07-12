package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class k92 extends oa<SeatBox, e92> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static k92 d;

    private k92() {
    }

    public static synchronized k92 r() {
        synchronized (k92.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1118502427")) {
                return (k92) ipChange.ipc$dispatch("1118502427", new Object[0]);
            }
            if (d == null) {
                d = new k92();
            }
            return d;
        }
    }

    @Override // tb.oa
    public cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<SeatBox, e92> e(@NonNull kn1<e92> kn1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2147343205")) {
            return (cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) ipChange.ipc$dispatch("2147343205", new Object[]{this, kn1Var});
        }
        if (kn1Var.a() != null) {
            if (!TextUtils.isEmpty(kn1Var.a().e) && kn1Var.a().a()) {
                return new cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.d(kn1Var);
            }
            return new cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.e(kn1Var);
        }
        return null;
    }
}
