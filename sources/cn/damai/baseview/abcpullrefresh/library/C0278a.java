package cn.damai.baseview.abcpullrefresh.library;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnRefreshListener;
import cn.damai.baseview.abcpullrefresh.library.viewdelegates.ViewDelegate;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: cn.damai.baseview.abcpullrefresh.library.a */
/* loaded from: classes.dex */
public class C0278a {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.baseview.abcpullrefresh.library.a$b */
    /* loaded from: classes.dex */
    public static final class C0280b {
        private static transient /* synthetic */ IpChange $ipChange;
        private final Activity a;
        private C0284d b;
        private int[] c;
        private View[] d;
        private OnRefreshListener e;
        private OnLoadMoreListener f;
        private ViewGroup g;
        private HashMap<Class, ViewDelegate> h;

        private static void a(ViewGroup viewGroup, PullToRefreshLayout pullToRefreshLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "466788637")) {
                ipChange.ipc$dispatch("466788637", new Object[]{viewGroup, pullToRefreshLayout});
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            while (childAt != null) {
                viewGroup.removeViewAt(0);
                pullToRefreshLayout.addView(childAt);
                childAt = viewGroup.getChildAt(0);
            }
            viewGroup.addView(pullToRefreshLayout, -1, -1);
        }

        public C0280b b(OnRefreshListener onRefreshListener) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1151192678")) {
                return (C0280b) ipChange.ipc$dispatch("-1151192678", new Object[]{this, onRefreshListener});
            }
            this.e = onRefreshListener;
            return this;
        }

        public void c(PullToRefreshLayout pullToRefreshLayout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1202234696")) {
                ipChange.ipc$dispatch("-1202234696", new Object[]{this, pullToRefreshLayout});
                return;
            }
            PullToRefreshAttacher createPullToRefreshAttacher = pullToRefreshLayout.createPullToRefreshAttacher(this.a, this.b);
            createPullToRefreshAttacher.E(this.e);
            createPullToRefreshAttacher.D(this.f);
            ViewGroup viewGroup = this.g;
            if (viewGroup != null) {
                a(viewGroup, pullToRefreshLayout);
            }
            pullToRefreshLayout.setPullToRefreshAttacher(createPullToRefreshAttacher);
            int[] iArr = this.c;
            if (iArr != null) {
                pullToRefreshLayout.addChildrenAsPullable(iArr);
            } else {
                View[] viewArr = this.d;
                if (viewArr != null) {
                    pullToRefreshLayout.addChildrenAsPullable(viewArr);
                } else {
                    pullToRefreshLayout.addAllChildrenAsPullable();
                }
            }
            HashMap<Class, ViewDelegate> hashMap = this.h;
            if (hashMap != null) {
                for (Map.Entry<Class, ViewDelegate> entry : hashMap.entrySet()) {
                    createPullToRefreshAttacher.L(entry.getKey(), entry.getValue());
                }
            }
        }

        public C0280b d(View... viewArr) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1057414470")) {
                return (C0280b) ipChange.ipc$dispatch("-1057414470", new Object[]{this, viewArr});
            }
            this.d = viewArr;
            this.c = null;
            return this;
        }

        private C0280b(Activity activity) {
            this.a = activity;
        }
    }

    public static C0280b a(Activity activity) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1928564302") ? (C0280b) ipChange.ipc$dispatch("-1928564302", new Object[]{activity}) : new C0280b(activity);
    }
}
