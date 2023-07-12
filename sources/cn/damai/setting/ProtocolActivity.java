package cn.damai.setting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.au0;
import tb.cs;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ProtocolActivity extends DamaiBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.ProtocolActivity$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1747a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1747a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-449782116")) {
                ipChange.ipc$dispatch("-449782116", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://help.damai.cn/helpPageH5Context.htm?pageId=38");
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(cs.t));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.ProtocolActivity$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1748b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1748b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1661508253")) {
                ipChange.ipc$dispatch("1661508253", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://help.damai.cn/helpPageH5Context.htm?pageId=40");
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(cs.t));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.ProtocolActivity$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1749c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1749c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-522168674")) {
                ipChange.ipc$dispatch("-522168674", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", "https://help.damai.cn/helpPageH5Context.htm?pageId=112");
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(cs.t));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.setting.ProtocolActivity$d */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC1750d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1750d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1589121695")) {
                ipChange.ipc$dispatch("1589121695", new Object[]{this, view});
                return;
            }
            Bundle bundle = new Bundle();
            String a = au0.a("accountPerformServiceConfig");
            if (TextUtils.isEmpty(a)) {
                a = "https://m.piao.com.cn/tickets/dianying/pages/alfheim/content.html?id=2204793&displayType=plain&hidetitle=yes&hsb=yes&interact=no&hideAuthorInfo=yes";
            }
            bundle.putString("url", a);
            DMNav.from(ProtocolActivity.this).withExtras(bundle).toUri(NavUri.b(cs.t));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025052870")) {
            ipChange.ipc$dispatch("2025052870", new Object[]{this, Integer.valueOf(i)});
        } else {
            finish();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1872202908") ? ((Integer) ipChange.ipc$dispatch("-1872202908", new Object[]{this})).intValue() : R$layout.activity_protocol;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "229253271")) {
            ipChange.ipc$dispatch("229253271", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-112222092")) {
            ipChange.ipc$dispatch("-112222092", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1155994199")) {
            ipChange.ipc$dispatch("-1155994199", new Object[]{this});
            return;
        }
        findViewById(R$id.rl_protocol).setOnClickListener(new View$OnClickListenerC1747a());
        findViewById(R$id.rl_terms).setOnClickListener(new View$OnClickListenerC1748b());
        findViewById(R$id.rl_community).setOnClickListener(new View$OnClickListenerC1749c());
        findViewById(R$id.rl_perform_service).setOnClickListener(new View$OnClickListenerC1750d());
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471803846")) {
            ipChange.ipc$dispatch("1471803846", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1345145743")) {
            ipChange.ipc$dispatch("1345145743", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1786078504") ? (String) ipChange.ipc$dispatch("-1786078504", new Object[]{this}) : "协议规则";
    }
}
