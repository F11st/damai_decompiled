package cn.damai.baseview.abcpullrefresh.actionbarcompat;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import cn.damai.baseview.abcpullrefresh.library.C0284d;
import cn.damai.baseview.abcpullrefresh.library.EnvironmentDelegate;
import cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.C9456n0;
import tb.lw0;

/* compiled from: Taobao */
/* renamed from: cn.damai.baseview.abcpullrefresh.actionbarcompat.a */
/* loaded from: classes.dex */
public class C0275a extends PullToRefreshAttacher {
    private static transient /* synthetic */ IpChange $ipChange;
    private FrameLayout A;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.baseview.abcpullrefresh.actionbarcompat.a$a */
    /* loaded from: classes.dex */
    public static class C0276a implements EnvironmentDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // cn.damai.baseview.abcpullrefresh.library.EnvironmentDelegate
        public Context getContextForInflater(Activity activity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2113609122")) {
                return (Context) ipChange.ipc$dispatch("2113609122", new Object[]{this, activity});
            }
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            Context themedContext = supportActionBar != null ? supportActionBar.getThemedContext() : null;
            return themedContext == null ? activity : themedContext;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C0275a(Activity activity, C0284d c0284d) {
        super(activity, c0284d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public void K(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363246943")) {
            ipChange.ipc$dispatch("-363246943", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 14) {
            super.K(view);
        } else {
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                super.K(frameLayout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-696876742")) {
            ipChange.ipc$dispatch("-696876742", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 14) {
            super.c(view);
        } else {
            FrameLayout frameLayout = new FrameLayout(k());
            this.A = frameLayout;
            frameLayout.addView(view);
            super.c(this.A);
        }
    }

    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    protected EnvironmentDelegate h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1567659588") ? (EnvironmentDelegate) ipChange.ipc$dispatch("-1567659588", new Object[]{this}) : new C0276a();
    }

    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    protected lw0 i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "621801020") ? (lw0) ipChange.ipc$dispatch("621801020", new Object[]{this}) : new C9456n0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.abcpullrefresh.library.PullToRefreshAttacher
    public void z(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569332")) {
            ipChange.ipc$dispatch("-569332", new Object[]{this, view});
        } else if (Build.VERSION.SDK_INT >= 14) {
            super.z(view);
        } else {
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                super.z(frameLayout);
                this.A = null;
            }
        }
    }
}
