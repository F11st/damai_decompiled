package tb;

import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class fe0 implements RequestListener<ImageData, l11> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    /* renamed from: a */
    public void onSuccess(kn1<l11> kn1Var, ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2091406236")) {
            ipChange.ipc$dispatch("-2091406236", new Object[]{this, kn1Var, imageData});
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kn1<l11> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420561734")) {
            ipChange.ipc$dispatch("-1420561734", new Object[]{this, kn1Var, str, str2});
        }
    }
}
