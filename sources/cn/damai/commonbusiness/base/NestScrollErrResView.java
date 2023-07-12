package cn.damai.commonbusiness.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import cn.damai.commonbusiness.base.ResponseErrorPage;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.r92;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class NestScrollErrResView extends NestedScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int STATE_HIDE = 1;
    public static final int STATE_SHOWING_EMPTY = 3;
    public static final int STATE_SHOWING_ERR = 4;
    public static final int STATE_SHOWING_LOGIN = 2;
    private Activity mActivity;
    private FrameLayout mPageContainer;
    public int state;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.base.NestScrollErrResView$a */
    /* loaded from: classes4.dex */
    public class C0578a implements ResponseErrorPage.ErrorRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnErrClickListener a;

        C0578a(NestScrollErrResView nestScrollErrResView, OnErrClickListener onErrClickListener) {
            this.a = onErrClickListener;
        }

        @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
        public void handleError(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1789592573")) {
                ipChange.ipc$dispatch("1789592573", new Object[]{this, Integer.valueOf(i)});
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
        if (AndroidInstantRuntime.support(ipChange, "-1337887725")) {
            ipChange.ipc$dispatch("-1337887725", new Object[]{this, responseErrorPage, onErrClickListener});
        } else if (responseErrorPage != null) {
            responseErrorPage.hideTitle();
            if (onErrClickListener != null) {
                responseErrorPage.setRefreshListener(new C0578a(this, onErrClickListener));
            }
            this.mPageContainer.removeAllViews();
            responseErrorPage.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.mPageContainer.addView(responseErrorPage);
        }
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419835957")) {
            ipChange.ipc$dispatch("1419835957", new Object[]{this});
            return;
        }
        this.state = 1;
        this.mPageContainer.removeAllViews();
        setVisibility(8);
    }

    public boolean isShowLoginView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1712264048") ? ((Boolean) ipChange.ipc$dispatch("1712264048", new Object[]{this})).booleanValue() : this.state == 2;
    }

    public void showEmptyView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-793578104")) {
            ipChange.ipc$dispatch("-793578104", new Object[]{this, str});
            return;
        }
        this.state = 3;
        addResView(new ResponseErrorPage(this.mActivity, 3, (String) null, str, (String) null), null);
        setVisibility(0);
    }

    public void showErrorView(String str, String str2, OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733536995")) {
            ipChange.ipc$dispatch("-1733536995", new Object[]{this, str, str2, onErrClickListener});
            return;
        }
        this.state = 4;
        addResView(new ResponseErrorPage(this.mActivity, 1, str, str2, (String) null), onErrClickListener);
        setVisibility(0);
    }

    public void showLoginView(OnErrClickListener onErrClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165092654")) {
            ipChange.ipc$dispatch("-165092654", new Object[]{this, onErrClickListener});
            return;
        }
        this.state = 2;
        addResView(new ResponseErrorPage(this.mActivity, 7, (String) null, (String) null, (String) null), onErrClickListener);
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
        FrameLayout frameLayout = new FrameLayout(context);
        this.mPageContainer = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mPageContainer);
    }
}
