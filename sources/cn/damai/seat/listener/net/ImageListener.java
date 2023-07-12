package cn.damai.seat.listener.net;

import android.text.TextUtils;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kn1;
import tb.l11;
import tb.t82;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class ImageListener implements RequestListener<ImageData, l11> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long itemId;
    private long performId;

    public ImageListener(long j, long j2) {
        this.itemId = j;
        this.performId = j2;
    }

    private void sunFire(kn1<l11> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "156266826")) {
            ipChange.ipc$dispatch("156266826", new Object[]{this, kn1Var, str, str2});
            return;
        }
        String d = kn1Var.d();
        if (kn1Var.a().c()) {
            if (TextUtils.equals(str, ImageData.CODE_SVG_BUILD_FAIL)) {
                t82.l(d, "unknown", str, this.itemId + "", this.performId + "");
                return;
            }
            t82.j(d, str2, str, this.itemId + "", this.performId + "");
            return;
        }
        t82.i(d, "unknown", str, this.itemId + "", this.performId + "");
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onFail(kn1<l11> kn1Var, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "299361475")) {
            ipChange.ipc$dispatch("299361475", new Object[]{this, kn1Var, str, str2});
            return;
        }
        if (kn1Var != null && kn1Var.a() != null) {
            sunFire(kn1Var, str, str2);
        }
        onNetFail(kn1Var, str, str2);
    }

    public abstract void onNetFail(kn1<l11> kn1Var, String str, String str2);

    public abstract void onNetSuccess(kn1<l11> kn1Var, ImageData imageData);

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
    public void onSuccess(kn1<l11> kn1Var, ImageData imageData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1580550867")) {
            ipChange.ipc$dispatch("-1580550867", new Object[]{this, kn1Var, imageData});
            return;
        }
        if (imageData.isSvg() && !imageData.isHasFloorId()) {
            t82.k(kn1Var.d(), "unknown", ImageData.CODE_SVG_NONE_FLOOR, this.itemId + "", this.performId + "");
        }
        onNetSuccess(kn1Var, imageData);
    }
}
