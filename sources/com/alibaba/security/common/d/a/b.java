package com.alibaba.security.common.d.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.youku.arch.v3.data.Constants;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes8.dex */
final class b {
    b() {
    }

    private static void a(Activity activity, int i) {
        Window window = activity.getWindow();
        window.clearFlags(ConfigReporter.BIT_GETTER_IMP);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
        window.getDecorView().setSystemUiVisibility(0);
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
            ViewCompat.requestApplyInsets(childAt);
        }
    }

    private static void a(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.addFlags(ConfigReporter.BIT_GETTER_IMP);
        window.getDecorView().setSystemUiVisibility(0);
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
            ViewCompat.requestApplyInsets(childAt);
        }
    }

    private static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }
}
