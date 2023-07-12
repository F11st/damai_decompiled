package tb;

import android.widget.LinearLayout;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.ultron.utils.DmUltronRequestErrorUtils;
import cn.damai.ultron.view.activity.DmOrderActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class pa0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private DmUltronRequestErrorUtils.BizType a;
    private int b;
    private LinearLayout c;
    private DmOrderActivity d;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1863510047")) {
                ipChange.ipc$dispatch("1863510047", new Object[]{this, Integer.valueOf(i)});
            } else if (pa0.this.a != null) {
                if (DmUltronRequestErrorUtils.BizType.BUILD == pa0.this.a) {
                    if (pa0.this.d == null || pa0.this.d.getPresenter() == null) {
                        return;
                    }
                    pa0.this.d.getPresenter().buildPage();
                } else if (DmUltronRequestErrorUtils.BizType.ADJUEST == pa0.this.a) {
                    if (pa0.this.d == null || pa0.this.d.getPresenter() == null || pa0.this.d.getPresenter().getDataManager() == null) {
                        return;
                    }
                    pa0.this.d.getPresenter().getDataManager().respondToLinkage();
                } else {
                    pa0.this.d.finish();
                }
            } else {
                pa0.this.d.finish();
            }
        }
    }

    private void c(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981165877")) {
            ipChange.ipc$dispatch("-1981165877", new Object[]{this, str, str2, str3});
            return;
        }
        int i = this.b;
        if (i != 0 && i != 5) {
            ResponseErrorPage responseErrorPage = new ResponseErrorPage(this.d, this.b, str, str2, str3);
            responseErrorPage.hideTitle();
            responseErrorPage.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.c.addView(responseErrorPage, 0);
            return;
        }
        ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(this.d, this.b, str, str2, str3);
        responseErrorPage2.hideTitle();
        responseErrorPage2.setVisibility(0);
        if (this.b == 5) {
            responseErrorPage2.updateRefreshBtn(true, "努力刷新");
        }
        responseErrorPage2.setRefreshListener(new a());
        responseErrorPage2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.c.addView(responseErrorPage2, 0);
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361328182")) {
            ipChange.ipc$dispatch("-361328182", new Object[]{this});
        } else {
            this.c.setVisibility(8);
        }
    }

    public void e(LinearLayout linearLayout, DmOrderActivity dmOrderActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597688446")) {
            ipChange.ipc$dispatch("1597688446", new Object[]{this, linearLayout, dmOrderActivity});
            return;
        }
        this.c = linearLayout;
        this.d = dmOrderActivity;
    }

    public void f(DmUltronRequestErrorUtils.BizType bizType, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "97665026")) {
            ipChange.ipc$dispatch("97665026", new Object[]{this, bizType, Integer.valueOf(i), str, str2, str3});
            return;
        }
        this.b = i;
        this.a = bizType;
        c(str, str2, str3);
        this.c.setVisibility(0);
        mb0.f().k(this.d, str3, str, str2, false);
    }
}
