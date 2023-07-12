package tb;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ke0 implements RequestListener<SeatBox, e92> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    /* renamed from: a */
    public void onSuccess(kn1<e92> kn1Var, SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1039735911")) {
            ipChange.ipc$dispatch("-1039735911", new Object[]{this, kn1Var, seatBox});
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kn1<e92> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-772868816")) {
            ipChange.ipc$dispatch("-772868816", new Object[]{this, kn1Var, str, str2});
        }
    }
}
