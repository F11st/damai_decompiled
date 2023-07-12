package cn.damai.mine.fragment;

import android.os.Bundle;
import android.taobao.windvane.webview.WVWebView;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.vf1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RealNameErrorDetailFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private WVWebView mWebView;

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "995202823")) {
            ipChange.ipc$dispatch("995202823", new Object[]{this});
            return;
        }
        WVWebView wVWebView = (WVWebView) this.rootView.findViewById(R$id.realname_error_wv);
        this.mWebView = wVWebView;
        wVWebView.loadUrl("https://sale.damai.cn/contents/4677/13571.html");
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-992426248") ? ((Integer) ipChange.ipc$dispatch("-992426248", new Object[]{this})).intValue() : R$layout.realname_error_detail;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1426429040")) {
            ipChange.ipc$dispatch("-1426429040", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101233819")) {
            ipChange.ipc$dispatch("101233819", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1789893922")) {
            ipChange.ipc$dispatch("1789893922", new Object[]{this});
        } else {
            init();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1433501048")) {
            ipChange.ipc$dispatch("-1433501048", new Object[]{this, view});
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566101032")) {
            ipChange.ipc$dispatch("-566101032", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(vf1.x().Y());
    }
}
