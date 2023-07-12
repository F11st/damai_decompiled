package com.alibaba.security.common.d.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.youku.arch.v3.data.Constants;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
@TargetApi(19)
/* renamed from: com.alibaba.security.common.d.a.a */
/* loaded from: classes8.dex */
public final class C3802a {
    private static final String a = "statusBarView";
    private static final String b = "marginAdded";

    C3802a() {
    }

    private static void a(Activity activity, int i) {
        Window window = activity.getWindow();
        window.addFlags(ConfigReporter.BIT_GETTER_IMP);
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        int a2 = a((Context) activity);
        a(activity);
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a2);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i);
        view.setTag(a);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
        if (childAt != null && !b.equals(childAt.getTag())) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams2.topMargin += a2;
            childAt.setLayoutParams(layoutParams2);
            childAt.setTag(b);
        }
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
        }
    }

    private static void b(Activity activity) {
        activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        a(activity);
        int a2 = a((Context) activity);
        if (childAt != null && b.equals(childAt.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin -= a2;
            childAt.setLayoutParams(layoutParams);
            childAt.setTag(null);
        }
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
        }
    }

    private static void b(View view, int i) {
        if (view != null && b.equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin -= i;
            view.setLayoutParams(layoutParams);
            view.setTag(null);
        }
    }

    public static void a(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag(a);
        if (findViewWithTag != null) {
            viewGroup.removeView(findViewWithTag);
        }
    }

    private static View a(Activity activity, int i, int i2) {
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i2);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i);
        view.setTag(a);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
        return view;
    }

    private static void a(View view, int i) {
        if (view == null || b.equals(view.getTag())) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin += i;
        view.setLayoutParams(layoutParams);
        view.setTag(b);
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }
}
