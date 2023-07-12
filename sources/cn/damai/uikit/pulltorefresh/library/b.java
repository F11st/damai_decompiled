package cn.damai.uikit.pulltorefresh.library;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
@TargetApi(9)
/* loaded from: classes8.dex */
public final class b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Orientation.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-893550827") ? ((Boolean) ipChange.ipc$dispatch("-893550827", new Object[]{view})).booleanValue() : view.getOverScrollMode() != 2;
    }

    public static void b(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z) {
        int scrollX;
        int i7;
        int i8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738039765")) {
            ipChange.ipc$dispatch("-738039765", new Object[]{pullToRefreshBase, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f), Boolean.valueOf(z)});
            return;
        }
        if (a.a[pullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1) {
            scrollX = pullToRefreshBase.getScrollY();
            i7 = i3;
            i8 = i4;
        } else {
            scrollX = pullToRefreshBase.getScrollX();
            i7 = i;
            i8 = i2;
        }
        if (!pullToRefreshBase.isPullToRefreshOverScrollEnabled() || pullToRefreshBase.isRefreshing()) {
            return;
        }
        PullToRefreshBase.Mode mode = pullToRefreshBase.getMode();
        if (mode.permitsPullToRefresh() && !z && i7 != 0) {
            int i9 = i7 + i8;
            Log.d("OverscrollHelper", "OverScroll. DeltaX: " + i + ", ScrollX: " + i2 + ", DeltaY: " + i3 + ", ScrollY: " + i4 + ", NewY: " + i9 + ", ScrollRange: " + i5 + ", CurrentScroll: " + scrollX);
            if (i9 < 0 - i6) {
                if (mode.showHeaderLoadingLayout()) {
                    if (scrollX == 0) {
                        pullToRefreshBase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                    }
                    pullToRefreshBase.setHeaderScroll((int) (f * (scrollX + i9)));
                }
            } else if (i9 > i5 + i6) {
                if (mode.showFooterLoadingLayout()) {
                    if (scrollX == 0) {
                        pullToRefreshBase.setState(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                    }
                    pullToRefreshBase.setHeaderScroll((int) (f * ((scrollX + i9) - i5)));
                }
            } else if (Math.abs(i9) <= i6 || Math.abs(i9 - i5) <= i6) {
                pullToRefreshBase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
            }
        } else if (z && PullToRefreshBase.State.OVERSCROLLING == pullToRefreshBase.getState()) {
            pullToRefreshBase.setState(PullToRefreshBase.State.RESET, new boolean[0]);
        }
    }

    public static void c(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2074493272")) {
            ipChange.ipc$dispatch("-2074493272", new Object[]{pullToRefreshBase, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)});
        } else {
            b(pullToRefreshBase, i, i2, i3, i4, i5, 0, 1.0f, z);
        }
    }

    public static void d(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590924931")) {
            ipChange.ipc$dispatch("-1590924931", new Object[]{pullToRefreshBase, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)});
        } else {
            c(pullToRefreshBase, i, i2, i3, i4, 0, z);
        }
    }
}
