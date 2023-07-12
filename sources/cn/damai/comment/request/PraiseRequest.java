package cn.damai.comment.request;

import cn.damai.comment.bean.CommentPraiseInfoBean;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class PraiseRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    PraiseRequestCallBack a;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface PraiseRequestCallBack {
        void notifyPraiseClick();
    }

    public void a(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "603291836")) {
            ipChange.ipc$dispatch("603291836", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        CommentPraiseRequest commentPraiseRequest = new CommentPraiseRequest();
        commentPraiseRequest.targetId = str;
        commentPraiseRequest.targetType = 1;
        commentPraiseRequest.operate = z ? 1 : 0;
        commentPraiseRequest.showLoginUI(false);
        commentPraiseRequest.request(new DMMtopRequestListener<CommentPraiseInfoBean>(CommentPraiseInfoBean.class) { // from class: cn.damai.comment.request.PraiseRequest.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "959557985")) {
                    ipChange2.ipc$dispatch("959557985", new Object[]{this, str2, str3});
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(CommentPraiseInfoBean commentPraiseInfoBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "227404128")) {
                    ipChange2.ipc$dispatch("227404128", new Object[]{this, commentPraiseInfoBean});
                    return;
                }
                PraiseRequestCallBack praiseRequestCallBack = PraiseRequest.this.a;
                if (praiseRequestCallBack != null) {
                    praiseRequestCallBack.notifyPraiseClick();
                }
            }
        });
    }

    public void b(PraiseRequestCallBack praiseRequestCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1462899463")) {
            ipChange.ipc$dispatch("-1462899463", new Object[]{this, praiseRequestCallBack});
        } else {
            this.a = praiseRequestCallBack;
        }
    }
}
