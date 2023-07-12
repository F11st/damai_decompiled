package cn.damai.baseview.abcpullrefresh.library;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import cn.damai.baseview.abcpullrefresh.library.listeners.HeaderViewListener;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import cn.damai.uikit.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.lw0;
import tb.pw2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PullToRefreshLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "PullToRefreshLayout";
    private PullToRefreshAttacher mPullToRefreshAttacher;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        private static transient /* synthetic */ IpChange $ipChange;
        private final String mViewDelegateClassName;

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PullToRefreshView);
            this.mViewDelegateClassName = obtainStyledAttributes.getString(R$styleable.PullToRefreshView_ptrViewDelegateClass);
            obtainStyledAttributes.recycle();
        }

        String getViewDelegateClassName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-670964314") ? (String) ipChange.ipc$dispatch("-670964314", new Object[]{this}) : this.mViewDelegateClassName;
        }
    }

    public PullToRefreshLayout(Context context) {
        this(context, null);
    }

    private void ensureAttacher() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1264051641")) {
            ipChange.ipc$dispatch("1264051641", new Object[]{this});
        } else if (this.mPullToRefreshAttacher == null) {
            throw new IllegalStateException("You need to setup the PullToRefreshLayout before using it");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAllChildrenAsPullable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1197632359")) {
            ipChange.ipc$dispatch("-1197632359", new Object[]{this});
            return;
        }
        ensureAttacher();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            addRefreshableView(getChildAt(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChildrenAsPullable(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317155138")) {
            ipChange.ipc$dispatch("-317155138", new Object[]{this, iArr});
            return;
        }
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (findViewById(iArr[i]) != null) {
                addRefreshableView(findViewById(iArr[i]));
            }
        }
    }

    void addRefreshableView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059814462")) {
            ipChange.ipc$dispatch("-1059814462", new Object[]{this, view});
            return;
        }
        PullToRefreshAttacher pullToRefreshAttacher = this.mPullToRefreshAttacher;
        if (pullToRefreshAttacher != null) {
            pullToRefreshAttacher.d(view, getViewDelegateFromLayoutParams(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PullToRefreshAttacher createPullToRefreshAttacher(Activity activity, d dVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1235859749")) {
            return (PullToRefreshAttacher) ipChange.ipc$dispatch("1235859749", new Object[]{this, activity, dVar});
        }
        if (dVar == null) {
            dVar = new d();
        }
        return new PullToRefreshAttacher(activity, dVar);
    }

    public lw0 getHeaderTransformer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1995524855")) {
            return (lw0) ipChange.ipc$dispatch("1995524855", new Object[]{this});
        }
        ensureAttacher();
        return this.mPullToRefreshAttacher.l();
    }

    public final View getHeaderView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485114075")) {
            return (View) ipChange.ipc$dispatch("485114075", new Object[]{this});
        }
        ensureAttacher();
        return this.mPullToRefreshAttacher.m();
    }

    ViewDelegate getViewDelegateFromLayoutParams(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "198057275")) {
            return (ViewDelegate) ipChange.ipc$dispatch("198057275", new Object[]{this, view});
        }
        if (view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return null;
        }
        String viewDelegateClassName = ((LayoutParams) view.getLayoutParams()).getViewDelegateClassName();
        if (TextUtils.isEmpty(viewDelegateClassName)) {
            return null;
        }
        int indexOf = viewDelegateClassName.indexOf(46);
        if (indexOf == -1) {
            viewDelegateClassName = getContext().getPackageName() + "." + viewDelegateClassName;
        } else if (indexOf == 0) {
            viewDelegateClassName = getContext().getPackageName() + viewDelegateClassName;
        }
        return (ViewDelegate) c.c(getContext(), viewDelegateClassName);
    }

    public final boolean isRefreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996664124")) {
            return ((Boolean) ipChange.ipc$dispatch("996664124", new Object[]{this})).booleanValue();
        }
        ensureAttacher();
        return this.mPullToRefreshAttacher.q();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292726052")) {
            ipChange.ipc$dispatch("292726052", new Object[]{this, configuration});
            return;
        }
        PullToRefreshAttacher pullToRefreshAttacher = this.mPullToRefreshAttacher;
        if (pullToRefreshAttacher != null) {
            pullToRefreshAttacher.t(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329850530")) {
            ipChange.ipc$dispatch("-1329850530", new Object[]{this});
            return;
        }
        PullToRefreshAttacher pullToRefreshAttacher = this.mPullToRefreshAttacher;
        if (pullToRefreshAttacher != null) {
            pullToRefreshAttacher.j();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353975396")) {
            return ((Boolean) ipChange.ipc$dispatch("-353975396", new Object[]{this, motionEvent})).booleanValue();
        }
        if (!isEnabled() || this.mPullToRefreshAttacher == null || getChildCount() <= 0) {
            return false;
        }
        return this.mPullToRefreshAttacher.u(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        PullToRefreshAttacher pullToRefreshAttacher;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "37141000")) {
            return ((Boolean) ipChange.ipc$dispatch("37141000", new Object[]{this, motionEvent})).booleanValue();
        }
        if (isEnabled() && (pullToRefreshAttacher = this.mPullToRefreshAttacher) != null) {
            return pullToRefreshAttacher.y(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setHeaderViewListener(HeaderViewListener headerViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1305135935")) {
            ipChange.ipc$dispatch("-1305135935", new Object[]{this, headerViewListener});
            return;
        }
        ensureAttacher();
        this.mPullToRefreshAttacher.C(headerViewListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPullToRefreshAttacher(PullToRefreshAttacher pullToRefreshAttacher) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "311285169")) {
            ipChange.ipc$dispatch("311285169", new Object[]{this, pullToRefreshAttacher});
            return;
        }
        PullToRefreshAttacher pullToRefreshAttacher2 = this.mPullToRefreshAttacher;
        if (pullToRefreshAttacher2 != null) {
            pullToRefreshAttacher2.j();
        }
        pw2.d("aa", "~~~destory");
        this.mPullToRefreshAttacher = pullToRefreshAttacher;
    }

    public final void setRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189675031")) {
            ipChange.ipc$dispatch("1189675031", new Object[]{this});
            return;
        }
        ensureAttacher();
        this.mPullToRefreshAttacher.F();
    }

    public final void setRefreshing(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468809988")) {
            ipChange.ipc$dispatch("-468809988", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ensureAttacher();
        this.mPullToRefreshAttacher.G(z);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1736484973") ? (FrameLayout.LayoutParams) ipChange.ipc$dispatch("-1736484973", new Object[]{this, attributeSet}) : new LayoutParams(getContext(), attributeSet);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChildrenAsPullable(View[] viewArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670576691")) {
            ipChange.ipc$dispatch("-1670576691", new Object[]{this, viewArr});
            return;
        }
        int length = viewArr.length;
        for (int i = 0; i < length; i++) {
            if (viewArr[i] != null) {
                addRefreshableView(viewArr[i]);
            }
        }
    }
}
