package cn.damai.commonbusiness.wannasee.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.commonbusiness.wannasee.listener.OnErrClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;
import tb.r92;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class NestScrollErrResView extends NestedScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATE_CUSTOM_EMPTY = 5;
    public static final int STATE_HIDE = 1;
    public static final int STATE_SHOWING_EMPTY = 3;
    public static final int STATE_SHOWING_ERR = 4;
    public static final int STATE_SHOWING_LOGIN = 2;
    private Activity mActivity;
    private FrameLayout mPageContainer;
    private int paddingTop;
    public int state;
    private int width;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.wannasee.view.NestScrollErrResView$a */
    /* loaded from: classes.dex */
    public class C0985a implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnErrClickListener a;

        C0985a(NestScrollErrResView nestScrollErrResView, OnErrClickListener onErrClickListener) {
            this.a = onErrClickListener;
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1310538816")) {
                ipChange.ipc$dispatch("-1310538816", new Object[]{this, Integer.valueOf(i)});
            } else if (r92.c()) {
            } else {
                this.a.onClick();
            }
        }
    }

    public NestScrollErrResView(@NonNull Activity activity) {
        this(activity, null);
        this.mActivity = activity;
    }

    private void addResView(ResponseErrorPage responseErrorPage, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987236684")) {
            ipChange.ipc$dispatch("987236684", new Object[]{this, responseErrorPage, onErrClickListener});
        } else if (responseErrorPage != null) {
            responseErrorPage.hideTitle();
            if (onErrClickListener != null) {
                responseErrorPage.setRefreshListener(new C0985a(this, onErrClickListener));
            }
            this.mPageContainer.removeAllViews();
            responseErrorPage.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mPageContainer.addView(responseErrorPage);
        }
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164757064")) {
            ipChange.ipc$dispatch("-164757064", new Object[]{this});
            return;
        }
        this.state = 1;
        this.mPageContainer.removeAllViews();
        setVisibility(8);
    }

    public boolean isShowLoginView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "97471501") ? ((Boolean) ipChange.ipc$dispatch("97471501", new Object[]{this})).booleanValue() : this.state == 2;
    }

    public void showCustomEmptyView(String str, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309341950")) {
            ipChange.ipc$dispatch("309341950", new Object[]{this, str, onErrClickListener});
            return;
        }
        this.state = 5;
        addResView(new ResponseErrorPage(this.mActivity, 10, (String) null, str, (String) null), onErrClickListener);
        setVisibility(0);
    }

    public void showEmptyView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1859103707")) {
            ipChange.ipc$dispatch("-1859103707", new Object[]{this, str});
            return;
        }
        this.state = 3;
        addResView(new ResponseErrorPage(this.mActivity, 3, (String) null, str, (String) null), null);
        setVisibility(0);
    }

    public void showErrorView(String str, String str2, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356279196")) {
            ipChange.ipc$dispatch("356279196", new Object[]{this, str, str2, onErrClickListener});
            return;
        }
        this.state = 4;
        addResView(new ResponseErrorPage(this.mActivity, 1, str, str2, (String) null), onErrClickListener);
        setVisibility(0);
    }

    public void showLoginView(OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1391839033")) {
            ipChange.ipc$dispatch("-1391839033", new Object[]{this, onErrClickListener});
            return;
        }
        this.state = 2;
        addResView(new ResponseErrorPage(this.mActivity, 7, (String) null, (String) null, (String) null), onErrClickListener);
        setVisibility(0);
    }

    public void showSmallEmptyView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1209530084")) {
            ipChange.ipc$dispatch("-1209530084", new Object[]{this, str});
            return;
        }
        this.state = 3;
        ResponseErrorPage responseErrorPage = new ResponseErrorPage(this.mActivity, 3, (String) null, str, (String) null);
        int i = this.width;
        responseErrorPage.setErrorImageSize(i, i);
        responseErrorPage.updatePageGravity(48, this.paddingTop);
        addResView(responseErrorPage, null);
        setVisibility(0);
    }

    public void showSmallErrorView(String str, String str2, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1686236525")) {
            ipChange.ipc$dispatch("-1686236525", new Object[]{this, str, str2, onErrClickListener});
            return;
        }
        this.state = 4;
        ResponseErrorPage responseErrorPage = new ResponseErrorPage(this.mActivity, 1, str, str2, (String) null);
        int i = this.width;
        responseErrorPage.setErrorImageSize(i, i);
        responseErrorPage.updatePageGravity(48, this.paddingTop);
        addResView(responseErrorPage, onErrClickListener);
        setVisibility(0);
    }

    public void showSmallLoginView(OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "387946302")) {
            ipChange.ipc$dispatch("387946302", new Object[]{this, onErrClickListener});
            return;
        }
        this.state = 2;
        ResponseErrorPage responseErrorPage = new ResponseErrorPage(this.mActivity, 7, (String) null, (String) null, (String) null);
        int i = this.width;
        responseErrorPage.setErrorImageSize(i, i);
        responseErrorPage.updatePageGravity(48, this.paddingTop);
        addResView(responseErrorPage, onErrClickListener);
        setVisibility(0);
    }

    public NestScrollErrResView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestScrollErrResView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFillViewport(true);
        setClickable(true);
        setBackgroundColor(-1);
        this.width = l62.a(context, 180.0f);
        this.paddingTop = l62.a(context, 40.0f);
        FrameLayout frameLayout = new FrameLayout(context);
        this.mPageContainer = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mPageContainer);
    }
}
