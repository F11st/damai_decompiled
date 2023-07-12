package cn.damai.mine.fragment;

import android.view.View;
import android.view.ViewGroup;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.mine.listener.OnErrClickListener;
import cn.damai.mine.view.NestScrollErrResView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class BaseFuncFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private NestScrollErrResView mResView;

    public abstract ViewGroup getMainView();

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060689657")) {
            ipChange.ipc$dispatch("1060689657", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void hideErrResView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "818099294")) {
            ipChange.ipc$dispatch("818099294", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-107497902")) {
            ipChange.ipc$dispatch("-107497902", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.common.app.base.BaseFragment
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-155835125")) {
            ipChange.ipc$dispatch("-155835125", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-750264911")) {
            return ((Boolean) ipChange.ipc$dispatch("-750264911", new Object[]{this})).booleanValue();
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
        if (AndroidInstantRuntime.support(ipChange, "-1967898063")) {
            ipChange.ipc$dispatch("-1967898063", new Object[]{this, view});
        }
    }

    public void showEmptyView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "269098015")) {
            ipChange.ipc$dispatch("269098015", new Object[]{this, str});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showEmptyView(str);
        }
    }

    public void showErrorView(String str, String str2, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1599337731")) {
            ipChange.ipc$dispatch("1599337731", new Object[]{this, str, str2, onErrClickListener});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showErrorView(str, str2, onErrClickListener);
        }
    }

    public void showLoginView(OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "128703672")) {
            ipChange.ipc$dispatch("128703672", new Object[]{this, onErrClickListener});
            return;
        }
        NestScrollErrResView nestScrollErrResView = this.mResView;
        if (nestScrollErrResView != null) {
            nestScrollErrResView.showLoginView(onErrClickListener);
        }
    }
}
