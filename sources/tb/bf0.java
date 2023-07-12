package tb;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import cn.damai.common.app.widget.DMProgressDialogV2;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.onearch.errpage.ErrClickListener;
import cn.damai.onearch.errpage.ErrorControlView;
import cn.damai.onearch.errpage.bean.ErrControlViewInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class bf0 implements ResponseErrorPage.ErrorRefreshListener, ErrorControlView {
    private static transient /* synthetic */ IpChange $ipChange;
    private ErrControlViewInfo a;
    private ResponseErrorPage b;
    private ErrorControlView c;
    private DMProgressDialogV2 d;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(bf0 bf0Var) {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1878964407")) {
                ipChange.ipc$dispatch("1878964407", new Object[]{this, dialogInterface});
            }
        }
    }

    public bf0(ErrorControlView errorControlView) {
        this.c = errorControlView;
    }

    private boolean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1438932952") ? ((Boolean) ipChange.ipc$dispatch("1438932952", new Object[]{this})).booleanValue() : (getErrContainer() == null || getErrContainerActivity() == null) ? false : true;
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public ViewGroup getErrContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1153408896")) {
            return (ViewGroup) ipChange.ipc$dispatch("1153408896", new Object[]{this});
        }
        ErrorControlView errorControlView = this.c;
        if (errorControlView != null) {
            return errorControlView.getErrContainer();
        }
        return null;
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public Activity getErrContainerActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1283832066")) {
            return (Activity) ipChange.ipc$dispatch("1283832066", new Object[]{this});
        }
        ErrorControlView errorControlView = this.c;
        if (errorControlView != null) {
            return errorControlView.getErrContainerActivity();
        }
        return null;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        ErrClickListener errClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708350044")) {
            ipChange.ipc$dispatch("708350044", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ErrControlViewInfo errControlViewInfo = this.a;
        if (errControlViewInfo == null || (errClickListener = errControlViewInfo.clickListener) == null) {
            return;
        }
        errClickListener.callBack(i);
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void hideErrView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307070783")) {
            ipChange.ipc$dispatch("1307070783", new Object[]{this});
        } else if (a()) {
            ViewGroup errContainer = getErrContainer();
            ResponseErrorPage responseErrorPage = this.b;
            if (responseErrorPage != null) {
                errContainer.removeView(responseErrorPage);
                this.b = null;
            }
        }
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public boolean isErrViewShown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088173046")) {
            return ((Boolean) ipChange.ipc$dispatch("1088173046", new Object[]{this})).booleanValue();
        }
        ResponseErrorPage responseErrorPage = this.b;
        return (responseErrorPage == null || responseErrorPage.getParent() == null || !this.b.isShown()) ? false : true;
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void showDialogLoading(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "8448068")) {
            ipChange.ipc$dispatch("8448068", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            Activity errContainerActivity = getErrContainerActivity();
            if (errContainerActivity != null && !errContainerActivity.isFinishing()) {
                if (z) {
                    if (this.d == null) {
                        DMProgressDialogV2 a2 = new DMProgressDialogV2(errContainerActivity).a();
                        this.d = a2;
                        a2.setOnDismissListener(new a(this));
                    }
                    if (this.d.isShowing()) {
                        return;
                    }
                    this.d.show();
                    return;
                }
                DMProgressDialogV2 dMProgressDialogV2 = this.d;
                if (dMProgressDialogV2 != null) {
                    dMProgressDialogV2.dismiss();
                    this.d = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // cn.damai.onearch.errpage.ErrorControlView
    public void showErrView(ErrControlViewInfo errControlViewInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2060037176")) {
            ipChange.ipc$dispatch("-2060037176", new Object[]{this, errControlViewInfo});
            return;
        }
        this.a = errControlViewInfo;
        if (errControlViewInfo == null || !a()) {
            return;
        }
        ViewGroup errContainer = getErrContainer();
        ResponseErrorPage responseErrorPage = this.b;
        if (responseErrorPage != null) {
            errContainer.removeView(responseErrorPage);
        }
        ResponseErrorPage responseErrorPage2 = new ResponseErrorPage(getErrContainerActivity(), errControlViewInfo.errorType, errControlViewInfo.errorCode, errControlViewInfo.errorMsg, errControlViewInfo.extra);
        this.b = responseErrorPage2;
        if (errControlViewInfo.hideTitle) {
            responseErrorPage2.hideTitle();
        }
        this.b.setRefreshListener(this);
        if (errContainer instanceof LinearLayout) {
            errContainer.addView(this.b, 0, new ViewGroup.LayoutParams(-1, -1));
        } else {
            errContainer.addView(this.b, -1, -1);
        }
    }
}
