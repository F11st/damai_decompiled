package tb;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;
import cn.damai.common.util.ACache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class qx2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236397284")) {
            ipChange.ipc$dispatch("-1236397284", new Object[]{view, viewGroup});
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
    }

    private static AppCompatActivity b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007773644")) {
            return (AppCompatActivity) ipChange.ipc$dispatch("2007773644", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        if (context instanceof ContextThemeWrapper) {
            return b(((ContextThemeWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "153211664") ? ((Integer) ipChange.ipc$dispatch("153211664", new Object[0])).intValue() : (d() * 9) / 16;
    }

    public static int d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-914513965") ? ((Integer) ipChange.ipc$dispatch("-914513965", new Object[0])).intValue() : e80.d();
    }

    public static void e(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113429667")) {
            ipChange.ipc$dispatch("113429667", new Object[]{context});
            return;
        }
        ActionBar supportActionBar = b(context).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.hide();
        }
        f(context).getWindow().setFlags(1024, 1024);
    }

    public static Activity f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1481685445")) {
            return (Activity) ipChange.ipc$dispatch("1481685445", new Object[]{context});
        }
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return f(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void g(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895506376")) {
            ipChange.ipc$dispatch("895506376", new Object[]{context});
            return;
        }
        ActionBar supportActionBar = b(context).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setShowHideAnimationEnabled(false);
            supportActionBar.show();
        }
        f(context).getWindow().clearFlags(1024);
    }

    public static String h(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "575424184")) {
            return (String) ipChange.ipc$dispatch("575424184", new Object[]{Integer.valueOf(i)});
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / ACache.TIME_HOUR;
        sb.setLength(0);
        return i5 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }
}
