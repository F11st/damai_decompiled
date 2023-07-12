package tb;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import cn.damai.common.app.widget.DMProgressDialogV2;
import cn.damai.common.util.ToastUtil;
import cn.damai.onearch.state.StateFailView;
import cn.damai.onearch.state.StateLoadingView;
import cn.damai.onearch.state.StateNoDataView;
import cn.damai.onearch.state.StateNoNetworkView;
import cn.damai.uikit.refresh.footer.SimpleFooter;
import cn.damai.uikit.refresh.footer.SimpleHeader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.State;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class hg2 implements StateViewManager.IStateViewDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private DMProgressDialogV2 a;

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateViewDelegate
    @Nullable
    public RefreshInternal createLoadingFooterView(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "959039168") ? (RefreshInternal) ipChange.ipc$dispatch("959039168", new Object[]{this, activity}) : new SimpleFooter(activity);
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateViewDelegate
    @Nullable
    public RefreshInternal createLoadingHeaderView(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "763051954") ? (RefreshInternal) ipChange.ipc$dispatch("763051954", new Object[]{this, activity}) : new SimpleHeader(activity);
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateViewDelegate
    @Nullable
    public IStateView createStateView(@NotNull Context context, @NotNull ViewGroup viewGroup, @NotNull State state, @Nullable StateViewManager.IStateViewListener iStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-136021917")) {
            return (IStateView) ipChange.ipc$dispatch("-136021917", new Object[]{this, context, viewGroup, state, iStateViewListener});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(viewGroup, "container");
        b41.i(state, "state");
        if (state == State.LOADING) {
            return new StateLoadingView(context);
        }
        if (state == State.FAILED) {
            StateFailView stateFailView = new StateFailView(context);
            stateFailView.setListener(iStateViewListener);
            return stateFailView;
        } else if (state == State.NO_NETWORK) {
            StateNoNetworkView stateNoNetworkView = new StateNoNetworkView(context);
            stateNoNetworkView.setListener(iStateViewListener);
            return stateNoNetworkView;
        } else if (state == State.NO_DATA) {
            return new StateNoDataView(context);
        } else {
            return null;
        }
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void hideErrorView(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626915309")) {
            ipChange.ipc$dispatch("626915309", new Object[]{this, activity});
        }
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void hideLoadingDialog(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "293950838")) {
            ipChange.ipc$dispatch("293950838", new Object[]{this, activity});
        } else if (activity == null || activity.isFinishing()) {
        } else {
            try {
                try {
                    DMProgressDialogV2 dMProgressDialogV2 = this.a;
                    if (dMProgressDialogV2 != null) {
                        dMProgressDialogV2.dismiss();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.a = null;
            }
        }
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showErrorView(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable StateViewManager.IStateViewListener iStateViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724779838")) {
            ipChange.ipc$dispatch("-724779838", new Object[]{this, activity, str, str2, iStateViewListener});
        }
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showLoadingDialog(@Nullable Activity activity, @Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1568169031")) {
            ipChange.ipc$dispatch("-1568169031", new Object[]{this, activity, str, Boolean.valueOf(z)});
        } else if (activity == null || activity.isFinishing()) {
        } else {
            try {
                if (this.a == null) {
                    this.a = new DMProgressDialogV2(activity).a();
                }
                DMProgressDialogV2 dMProgressDialogV2 = this.a;
                if (dMProgressDialogV2 != null) {
                    dMProgressDialogV2.setCancelable(z);
                    if (dMProgressDialogV2.isShowing() || activity.isFinishing()) {
                        return;
                    }
                    dMProgressDialogV2.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showToast(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171239354")) {
            ipChange.ipc$dispatch("-1171239354", new Object[]{this, str});
            return;
        }
        b41.i(str, "msg");
        ToastUtil.b(str, 0);
    }
}
