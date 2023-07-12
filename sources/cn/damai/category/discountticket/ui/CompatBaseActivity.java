package cn.damai.category.discountticket.ui;

import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kg2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class CompatBaseActivity<P extends a, M extends BaseModel> extends DamaiBaseActivity<P, M> implements IBaseCompatView {
    private static transient /* synthetic */ IpChange $ipChange;

    protected void adjustStatusBar() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "78397042")) {
            ipChange.ipc$dispatch("78397042", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        View findViewById = findViewById(R$id.title_bar_space);
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
        } else {
            kg2.f(this, false, R$color.black);
        }
        if (findViewById != null) {
            if (i >= 23) {
                findViewById.getLayoutParams().height = kg2.a(this);
                findViewById.setVisibility(0);
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417472690")) {
            ipChange.ipc$dispatch("-417472690", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-660887265")) {
            ipChange.ipc$dispatch("-660887265", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2033222183")) {
            ipChange.ipc$dispatch("-2033222183", new Object[]{this});
            return;
        }
        ViewGroup mainView = getMainView();
        if (mainView != null) {
            onResponseSuccess(mainView);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989067825")) {
            ipChange.ipc$dispatch("989067825", new Object[]{this});
        } else {
            adjustStatusBar();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1423364272")) {
            return (String) ipChange.ipc$dispatch("-1423364272", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showDialog(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "856406200")) {
            ipChange.ipc$dispatch("856406200", new Object[]{this, str, str2, onClickListener});
        } else if (isFinishing()) {
        } else {
            new DMDialog(this).o(false).q(str).n(str2, onClickListener).show();
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showDialogLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-107928889")) {
            ipChange.ipc$dispatch("-107928889", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            startProgressDialog();
        } else {
            stopProgressDialog();
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showErrorTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859614304")) {
            ipChange.ipc$dispatch("859614304", new Object[]{this, str});
        } else if (isFinishing() || TextUtils.isEmpty(str)) {
        } else {
            ToastUtil.a().e(this, str);
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showErrorView(String str, String str2, String str3, OnErrorClickListener onErrorClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2087961407")) {
            ipChange.ipc$dispatch("2087961407", new Object[]{this, str, str2, str3, onErrorClickListener});
            return;
        }
        ViewGroup mainView = getMainView();
        if (mainView != null) {
            onResponseError(str2, str, str3, mainView, true);
            ResponseErrorPage responseErrorPage = this.mErrorPage;
            if (responseErrorPage != null) {
                responseErrorPage.setRefreshListener(onErrorClickListener);
            }
        }
    }
}
