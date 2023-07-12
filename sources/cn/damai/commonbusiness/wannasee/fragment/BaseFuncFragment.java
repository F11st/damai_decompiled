package cn.damai.commonbusiness.wannasee.fragment;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.wannasee.listener.OnErrClickListener;
import cn.damai.commonbusiness.wannasee.view.NestScrollErrResView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class BaseFuncFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private NestScrollErrResView mResView;

    public abstract ViewGroup getMainView();

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268503912")) {
            ipChange.ipc$dispatch("1268503912", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void hideErrResView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1335864563")) {
            ipChange.ipc$dispatch("-1335864563", new Object[]{this});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.hide();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2039776707")) {
            ipChange.ipc$dispatch("2039776707", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082150150")) {
            ipChange.ipc$dispatch("-1082150150", new Object[]{this});
            return;
        }
        ViewGroup mainView = getMainView();
        if (mainView != null) {
            NestScrollErrResView nestScrollErrResView = new NestScrollErrResView(getActivity());
            this.mResView = nestScrollErrResView;
            mainView.addView(nestScrollErrResView, -1, -1);
            this.mResView.setVisibility(8);
        }
    }

    public boolean isShowingLoginView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-322433824")) {
            return ((Boolean) ipChange.ipc$dispatch("-322433824", new Object[]{this})).booleanValue();
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            return nestScrollErrResView.isShowLoginView();
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316288416")) {
            ipChange.ipc$dispatch("-316288416", new Object[]{this, view});
        }
    }

    public void showEmptyView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773776560")) {
            ipChange.ipc$dispatch("-1773776560", new Object[]{this, str});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showEmptyView(str);
        }
    }

    public void showErrorView(String str, String str2, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-961424697")) {
            ipChange.ipc$dispatch("-961424697", new Object[]{this, str, str2, onErrClickListener});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showErrorView(str, str2, onErrClickListener);
        }
    }

    public void showLoginView(OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2530958")) {
            ipChange.ipc$dispatch("-2530958", new Object[]{this, onErrClickListener});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showLoginView(onErrClickListener);
        }
    }
}
