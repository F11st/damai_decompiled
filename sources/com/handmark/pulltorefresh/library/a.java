package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/* compiled from: Taobao */
@TargetApi(9)
/* loaded from: classes10.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        return view.getOverScrollMode() != 2;
    }

    public static void b(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, float f, boolean z) {
        PullToRefreshBase.Mode mode;
        if (!pullToRefreshBase.isPullToRefreshOverScrollEnabled() || (mode = pullToRefreshBase.getMode()) == PullToRefreshBase.Mode.DISABLED || z || i == 0) {
            return;
        }
        int i5 = i + i2;
        if (i5 < 0 - i4) {
            if (mode.canPullDown()) {
                pullToRefreshBase.setHeaderScroll((int) (f * (pullToRefreshBase.getScrollY() + i5)));
            }
        } else if (i5 > i3 + i4) {
            if (mode.canPullUp()) {
                pullToRefreshBase.setHeaderScroll((int) (f * ((pullToRefreshBase.getScrollY() + i5) - i3)));
            }
        } else if (Math.abs(i5) <= i4 || Math.abs(i5 - i3) <= i4) {
            pullToRefreshBase.smoothScrollToLonger(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, boolean z) {
        b(pullToRefreshBase, i, i2, i3, 0, 0.0f, z);
    }

    public static void d(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, boolean z) {
        c(pullToRefreshBase, i, i2, 0, z);
    }
}
