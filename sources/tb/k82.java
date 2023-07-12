package tb;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a;
import cn.damai.seat.loader.request.C1674a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class k82 extends oa<ImageData, j82> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile k82 d;

    private k82() {
    }

    public static synchronized k82 r() {
        synchronized (k82.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1395363579")) {
                return (k82) ipChange.ipc$dispatch("1395363579", new Object[0]);
            }
            if (d == null) {
                d = new k82();
            }
            return d;
        }
    }

    @Override // tb.oa
    public AbstractC0818a<ImageData, j82> e(@NonNull kn1<j82> kn1Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "565657098") ? (AbstractC0818a) ipChange.ipc$dispatch("565657098", new Object[]{this, kn1Var}) : new C1674a(kn1Var);
    }
}
