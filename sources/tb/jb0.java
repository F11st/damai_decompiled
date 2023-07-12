package tb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.ultron.view.activity.DmOrderActivity;
import cn.damai.ultron.view.bean.DmUltronPayResultBean;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class jb0 extends ib {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.jb0$a */
    /* loaded from: classes9.dex */
    public class DialogInterface$OnClickListenerC9305a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        DialogInterface$OnClickListenerC9305a(jb0 jb0Var, DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2145354713")) {
                ipChange.ipc$dispatch("2145354713", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DmOrderActivity dmOrderActivity = this.a;
            if (dmOrderActivity != null) {
                dmOrderActivity.finish();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.jb0$b */
    /* loaded from: classes9.dex */
    public class DialogInterface$OnClickListenerC9306b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmOrderActivity a;

        DialogInterface$OnClickListenerC9306b(DmOrderActivity dmOrderActivity) {
            this.a = dmOrderActivity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1180031560")) {
                ipChange.ipc$dispatch("-1180031560", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            DMNav.from(jb0.this.b).withExtras(new Bundle()).toUri(NavUri.b("my_showorder"));
            this.a.finish();
        }
    }

    @Override // tb.ib
    protected void h(np2 np2Var) {
        JSONObject dataJsonObject;
        DmUltronPayResultBean dmUltronPayResultBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2054421716")) {
            ipChange.ipc$dispatch("2054421716", new Object[]{this, np2Var});
        } else if (np2Var == null) {
        } else {
            try {
                MtopResponse mtopResponse = (MtopResponse) np2Var.c();
                if (mtopResponse == null || (dataJsonObject = mtopResponse.getDataJsonObject()) == null || (dmUltronPayResultBean = (DmUltronPayResultBean) JSON.parseObject(dataJsonObject.toString(), DmUltronPayResultBean.class)) == null) {
                    return;
                }
                Context context = this.b;
                DmOrderActivity dmOrderActivity = context instanceof Activity ? (DmOrderActivity) context : null;
                if (dmOrderActivity == null) {
                    return;
                }
                if (dmUltronPayResultBean.getPartSuccess()) {
                    DmOrderActivity dmOrderActivity2 = (DmOrderActivity) this.b;
                    DMDialog dMDialog = new DMDialog(this.b);
                    dMDialog.v("部分宝贝购买成功");
                    dMDialog.q("请尽快付款来抢下，未成功宝贝已放回购物车。");
                    dMDialog.n("确定", new DialogInterface$OnClickListenerC9306b(dmOrderActivity2)).i("取消", new DialogInterface$OnClickListenerC9305a(this, dmOrderActivity2));
                    return;
                }
                lb0.c(dmOrderActivity, dmUltronPayResultBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
