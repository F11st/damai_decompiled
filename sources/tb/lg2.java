package tb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.Constants;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
@TargetApi(19)
/* loaded from: classes7.dex */
public class lg2 {
    private static transient /* synthetic */ IpChange $ipChange;

    private static View a(Activity activity, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909481248")) {
            return (View) ipChange.ipc$dispatch("-909481248", new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        View view = new View(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i2);
        layoutParams.gravity = 48;
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i);
        view.setTag("statusBarView");
        ((ViewGroup) activity.getWindow().getDecorView()).addView(view);
        return view;
    }

    private static void b(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "885767593")) {
            ipChange.ipc$dispatch("885767593", new Object[]{view, Integer.valueOf(i)});
        } else if (view == null || "marginAdded".equals(view.getTag())) {
        } else {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
            view.setTag("marginAdded");
        }
    }

    public static int c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-250049135")) {
            return ((Integer) ipChange.ipc$dispatch("-250049135", new Object[]{context})).intValue();
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelOffset(identifier);
        }
        return 0;
    }

    private static void d(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "226927777")) {
            ipChange.ipc$dispatch("226927777", new Object[]{activity});
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag("statusBarView");
        if (findViewWithTag != null) {
            viewGroup.removeView(findViewWithTag);
        }
    }

    private static void e(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954202242")) {
            ipChange.ipc$dispatch("1954202242", new Object[]{view, Integer.valueOf(i)});
        } else if (view != null && "marginAdded".equals(view.getTag())) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin -= i;
            view.setLayoutParams(layoutParams);
            view.setTag(null);
        }
    }

    static void f(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1892217095")) {
            ipChange.ipc$dispatch("1892217095", new Object[]{activity, Integer.valueOf(i)});
            return;
        }
        Window window = activity.getWindow();
        window.addFlags(ConfigReporter.BIT_GETTER_IMP);
        View childAt = ((ViewGroup) window.findViewById(16908290)).getChildAt(0);
        int c = c(activity);
        d(activity);
        a(activity, i, c);
        b(childAt, c);
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    static void g(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531256346")) {
            ipChange.ipc$dispatch("-1531256346", new Object[]{activity});
            return;
        }
        activity.getWindow().addFlags(ConfigReporter.BIT_GETTER_IMP);
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        d(activity);
        e(childAt, c(activity));
        if (childAt != null) {
            ViewCompat.setFitsSystemWindows(childAt, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Activity activity, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637882645")) {
            ipChange.ipc$dispatch("1637882645", new Object[]{activity, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (z) {
            g(activity);
        } else {
            f(activity, i);
        }
    }
}
