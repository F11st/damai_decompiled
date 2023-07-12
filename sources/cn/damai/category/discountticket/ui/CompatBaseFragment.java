package cn.damai.category.discountticket.ui;

import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.app.base.BaseModel;
import cn.damai.common.app.base.a;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.homepage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kg2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class CompatBaseFragment<P extends a, M extends BaseModel> extends DamaiBaseMvpFragment<P, M> implements IBaseCompatView {
    private static transient /* synthetic */ IpChange $ipChange;

    protected void adjustStatusBar() {
        View findViewById;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1220210223")) {
            ipChange.ipc$dispatch("-1220210223", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (findViewById = findViewById(R$id.title_bar_space)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(activity);
            findViewById.setVisibility(0);
            return;
        }
        findViewById.setVisibility(8);
    }

    public <T extends View> T findViewById(@IdRes int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1433787538") ? (T) ipChange.ipc$dispatch("-1433787538", new Object[]{this, Integer.valueOf(i)}) : (T) this.rootView.findViewById(i);
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117986784")) {
            ipChange.ipc$dispatch("-117986784", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void hideErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1911790840")) {
            ipChange.ipc$dispatch("1911790840", new Object[]{this});
            return;
        }
        ViewGroup mainView = getMainView();
        if (mainView != null) {
            onResponseSuccess(mainView);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1783454798")) {
            ipChange.ipc$dispatch("-1783454798", new Object[]{this});
        } else {
            adjustStatusBar();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-386726632")) {
            ipChange.ipc$dispatch("-386726632", new Object[]{this, view});
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showDialog(String str, String str2, DialogInterface.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1150121495")) {
            ipChange.ipc$dispatch("1150121495", new Object[]{this, str, str2, onClickListener});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        new DMDialog(activity).o(false).q(str).n(str2, onClickListener).show();
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showDialogLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146525432")) {
            ipChange.ipc$dispatch("-2146525432", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || !(activity instanceof BaseActivity)) {
            return;
        }
        if (z) {
            ((BaseActivity) activity).startProgressDialog();
        } else {
            ((BaseActivity) activity).stopProgressDialog();
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showErrorTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324743391")) {
            ipChange.ipc$dispatch("-324743391", new Object[]{this, str});
        } else if (!isAdded() || TextUtils.isEmpty(str)) {
        } else {
            ToastUtil.a().e(mu0.a(), str);
        }
    }

    @Override // cn.damai.category.discountticket.ui.IBaseCompatView
    public void showErrorView(String str, String str2, String str3, OnErrorClickListener onErrorClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416564830")) {
            ipChange.ipc$dispatch("1416564830", new Object[]{this, str, str2, str3, onErrorClickListener});
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
