package cn.damai.commonbusiness.faceverify.manager;

import android.content.Context;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.faceverify.bean.FaceVerifyTokenBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DMFaceCertManager$1 extends DMMtopRequestListener<FaceVerifyTokenBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ a this$0;
    final /* synthetic */ Context val$context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DMFaceCertManager$1(a aVar, Class cls, Context context) {
        super(cls);
        this.val$context = context;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onFail(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989351926")) {
            ipChange.ipc$dispatch("-1989351926", new Object[]{this, str, str2});
        } else {
            a.c(this.this$0, str, str2);
        }
    }

    @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
    public void onSuccess(FaceVerifyTokenBean faceVerifyTokenBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1461210934")) {
            ipChange.ipc$dispatch("-1461210934", new Object[]{this, faceVerifyTokenBean});
            return;
        }
        a.a(this.this$0, faceVerifyTokenBean);
        a.b(this.this$0, this.val$context, faceVerifyTokenBean);
    }
}
