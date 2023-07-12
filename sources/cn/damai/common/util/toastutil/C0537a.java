package cn.damai.common.util.toastutil;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import cn.damai.common.R$id;
import cn.damai.common.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang3.time.DateUtils;
import tb.mu0;

/* compiled from: Taobao */
/* renamed from: cn.damai.common.util.toastutil.a */
/* loaded from: classes13.dex */
public class C0537a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    public static final int LONG_DURATION_TIMEOUT = 3500;
    public static final int SHORT_DURATION_TIMEOUT = 2000;
    private static Field a;
    private static Field b;
    private static Toast c;
    private static Toast d;
    private static HandlerC0539b e;
    private static double f;
    static long g;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.common.util.toastutil.a$a */
    /* loaded from: classes13.dex */
    public static class HandlerC0538a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private Handler a;

        public HandlerC0538a(Handler handler) {
            this.a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1738560975")) {
                ipChange.ipc$dispatch("1738560975", new Object[]{this, message});
                return;
            }
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    Log.e("DMToastUtils", e.getMessage());
                } else {
                    Log.e("DMToastUtils", "toast 崩溃");
                }
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1189912579")) {
                ipChange.ipc$dispatch("-1189912579", new Object[]{this, message});
                return;
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            a = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
                Field declaredField2 = a.getType().getDeclaredField("mHandler");
                b = declaredField2;
                if (declaredField2 != null) {
                    declaredField2.setAccessible(true);
                }
            }
        } catch (Exception unused) {
        }
        g = 0L;
    }

    private static void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1466177090")) {
            ipChange.ipc$dispatch("-1466177090", new Object[0]);
        } else if (d == null) {
            d(mu0.a());
        }
    }

    public static View b(Context context, CharSequence charSequence, CharSequence charSequence2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1457849678")) {
            return (View) ipChange.ipc$dispatch("1457849678", new Object[]{context, charSequence, charSequence2});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_center_toast, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R$id.toast_title);
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        ((TextView) inflate.findViewById(R$id.toast_message)).setText(charSequence2);
        return inflate;
    }

    private static void c(Toast toast) {
        Handler handler;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "15092106")) {
            ipChange.ipc$dispatch("15092106", new Object[]{toast});
            return;
        }
        try {
            Field field = a;
            if (field != null) {
                Object obj = field.get(toast);
                Field field2 = b;
                if (field2 == null || (handler = (Handler) field2.get(obj)) == null) {
                    return;
                }
                b.set(obj, new HandlerC0538a(handler));
            }
        } catch (Exception unused) {
        }
    }

    public static void d(Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401645003")) {
            ipChange.ipc$dispatch("-1401645003", new Object[]{application});
        } else if (f(application) || d != null) {
        } else {
            d = new SupportToast(application);
            e = new HandlerC0539b(d);
        }
    }

    private static void e(Context context, CharSequence charSequence, int i, View view, int i2, int i3, int i4, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-920923077")) {
            ipChange.ipc$dispatch("-920923077", new Object[]{context, charSequence, Integer.valueOf(i), view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)});
            return;
        }
        d(mu0.a());
        if (d == null || e == null || charSequence == null || "".equals(charSequence.toString())) {
            return;
        }
        h(view);
        g(i2, i3, i4);
        if (1 == i) {
            e.b(3500);
        } else {
            e.b(2000);
        }
        if (z) {
            e.a(((Object) charSequence) + JSMethod.NOT_SET + f + JSMethod.NOT_SET + "showText");
        } else {
            e.a(((Object) charSequence) + JSMethod.NOT_SET + f + JSMethod.NOT_SET + "noShowText");
        }
        e.c();
        f += 1.0d;
    }

    private static boolean f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-110969464")) {
            return ((Boolean) ipChange.ipc$dispatch("-110969464", new Object[]{context})).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
        }
        if (i >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return true;
    }

    public static void g(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041850955")) {
            ipChange.ipc$dispatch("-1041850955", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        a();
        if (Build.VERSION.SDK_INT >= 17) {
            i = Gravity.getAbsoluteGravity(i, d.getView().getResources().getConfiguration().getLayoutDirection());
        }
        d.setGravity(i, i2, i3);
    }

    public static void h(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "142874089")) {
            ipChange.ipc$dispatch("142874089", new Object[]{view});
            return;
        }
        a();
        if (view != null) {
            Toast toast = d;
            if (toast != null) {
                toast.cancel();
                d.setView(view);
                Log.e("DMToastUtil", "setView_cancel");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Views cannot be empty");
    }

    public static void i(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-329684948")) {
            ipChange.ipc$dispatch("-329684948", new Object[]{context, str});
        } else if (str == null || "".equals(str)) {
        } else {
            if (!f(mu0.a())) {
                e(context, str, 0, k(context, str), 17, 0, 0, true);
                return;
            }
            Toast toast = c;
            if (toast == null) {
                Toast toast2 = new Toast(context);
                c = toast2;
                toast2.setView(b(context, null, str));
                c(c);
                c.show();
                return;
            }
            toast.setView(b(context, null, str));
            c.show();
            if (g == 0) {
                g = System.currentTimeMillis();
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - g;
            if (currentTimeMillis <= 2000 || currentTimeMillis >= DateUtils.MILLIS_PER_MINUTE) {
                return;
            }
            g = System.currentTimeMillis();
            c.cancel();
            c = null;
        }
    }

    public static void j(Context context, View view, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2002623232")) {
            ipChange.ipc$dispatch("-2002623232", new Object[]{context, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else if (view == null) {
        } else {
            if (!f(mu0.a())) {
                e(context, Integer.toHexString(view.hashCode()), i, view, i2, i3, i4, false);
                return;
            }
            Toast toast = new Toast(context);
            c(toast);
            toast.setView(view);
            toast.setDuration(i);
            toast.setGravity(i2, i3, i4);
            toast.show();
        }
    }

    private static View k(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1507753347") ? (View) ipChange.ipc$dispatch("-1507753347", new Object[]{context, str}) : b(context, null, str);
    }
}
