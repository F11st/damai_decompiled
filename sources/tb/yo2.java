package tb;

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
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.util.toast.SupportToast;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.time.DateUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class yo2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final yo2 INSTANCE = new yo2();
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    public static final int LONG_DURATION_TIMEOUT = 3500;
    public static final int SHORT_DURATION_TIMEOUT = 2000;
    @Nullable
    private static Field a;
    @Nullable
    private static Field b;
    @Nullable
    private static Toast c;
    @Nullable
    private static Toast d;
    @Nullable
    private static wo2 e;
    private static double f;
    private static long g;

    /* compiled from: Taobao */
    /* renamed from: tb.yo2$a */
    /* loaded from: classes7.dex */
    public static final class HandlerC9993a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private final Handler a;

        public HandlerC9993a(@Nullable Handler handler) {
            this.a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NotNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1520850912")) {
                ipChange.ipc$dispatch("-1520850912", new Object[]{this, message});
                return;
            }
            b41.i(message, "msg");
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    String message2 = e.getMessage();
                    b41.f(message2);
                    Log.e("DMToastUtils", message2);
                } else {
                    Log.e("DMToastUtils", "toast 崩溃");
                }
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-17886578")) {
                ipChange.ipc$dispatch("-17886578", new Object[]{this, message});
                return;
            }
            b41.i(message, "msg");
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
                b41.f(declaredField);
                declaredField.setAccessible(true);
                Field field = a;
                b41.f(field);
                Field declaredField2 = field.getType().getDeclaredField("mHandler");
                b = declaredField2;
                if (declaredField2 != null) {
                    b41.f(declaredField2);
                    declaredField2.setAccessible(true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private yo2() {
    }

    private final void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891255731")) {
            ipChange.ipc$dispatch("-891255731", new Object[]{this});
        } else if (d == null) {
            Application application = AppInfoProviderProxy.getApplication();
            b41.h(application, "getApplication()");
            d(application);
        }
    }

    private final void c(Toast toast) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244082277")) {
            ipChange.ipc$dispatch("-1244082277", new Object[]{this, toast});
            return;
        }
        try {
            Field field = a;
            if (field != null) {
                b41.f(field);
                Object obj = field.get(toast);
                Field field2 = b;
                if (field2 != null) {
                    b41.f(field2);
                    Object obj2 = field2.get(obj);
                    b41.g(obj2, "null cannot be cast to non-null type android.os.Handler");
                    Field field3 = b;
                    b41.f(field3);
                    field3.set(obj, new HandlerC9993a((Handler) obj2));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void e(Context context, CharSequence charSequence, int i, View view, int i2, int i3, int i4, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355641612")) {
            ipChange.ipc$dispatch("1355641612", new Object[]{this, context, charSequence, Integer.valueOf(i), view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)});
            return;
        }
        Application application = AppInfoProviderProxy.getApplication();
        b41.h(application, "getApplication()");
        d(application);
        if (d == null || e == null || charSequence == null || b41.d("", charSequence.toString())) {
            return;
        }
        h(view);
        g(i2, i3, i4);
        if (1 == i) {
            wo2 wo2Var = e;
            b41.f(wo2Var);
            wo2Var.b(3500);
        } else {
            wo2 wo2Var2 = e;
            b41.f(wo2Var2);
            wo2Var2.b(2000);
        }
        if (z) {
            wo2 wo2Var3 = e;
            b41.f(wo2Var3);
            wo2Var3.a(((Object) charSequence) + '_' + f + "_showText");
        } else {
            wo2 wo2Var4 = e;
            b41.f(wo2Var4);
            wo2Var4.a(((Object) charSequence) + '_' + f + "_noShowText");
        }
        wo2 wo2Var5 = e;
        b41.f(wo2Var5);
        wo2Var5.c();
        f += 1.0d;
    }

    private final boolean f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1476488935")) {
            return ((Boolean) ipChange.ipc$dispatch("-1476488935", new Object[]{this, context})).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            Object systemService = context.getSystemService("notification");
            b41.g(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return ((NotificationManager) systemService).areNotificationsEnabled();
        } else if (i >= 19) {
            Object systemService2 = context.getSystemService("appops");
            b41.g(systemService2, "null cannot be cast to non-null type android.app.AppOpsManager");
            AppOpsManager appOpsManager = (AppOpsManager) systemService2;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Object obj = cls.getDeclaredField("OP_POST_NOTIFICATION").get(cls2);
                b41.g(obj, "null cannot be cast to non-null type kotlin.Int");
                Object invoke = method.invoke(appOpsManager, Integer.valueOf(((Integer) obj).intValue()), Integer.valueOf(i2), packageName);
                b41.g(invoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) invoke).intValue() == 0;
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return true;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return true;
            } catch (NoSuchFieldException e4) {
                e4.printStackTrace();
                return true;
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                return true;
            } catch (RuntimeException e6) {
                e6.printStackTrace();
                return true;
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
                return true;
            }
        } else {
            return true;
        }
    }

    private final View k(Context context, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-304921970") ? (View) ipChange.ipc$dispatch("-304921970", new Object[]{this, context, str}) : b(context, null, str);
    }

    @NotNull
    public final View b(@Nullable Context context, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526551843")) {
            return (View) ipChange.ipc$dispatch("-1526551843", new Object[]{this, context, charSequence, charSequence2});
        }
        View inflate = LayoutInflater.from(context).inflate(R$layout.bricks_layout_center_toast, (ViewGroup) null);
        View findViewById = inflate.findViewById(R$id.toast_title);
        b41.g(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        View findViewById2 = inflate.findViewById(R$id.toast_message);
        b41.g(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setText(charSequence2);
        b41.h(inflate, "v");
        return inflate;
    }

    public final void d(@NotNull Application application) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1221325692")) {
            ipChange.ipc$dispatch("-1221325692", new Object[]{this, application});
            return;
        }
        b41.i(application, "application");
        if (f(application) || d != null) {
            return;
        }
        d = new SupportToast(application);
        e = new wo2(d);
    }

    public final void g(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576622596")) {
            ipChange.ipc$dispatch("576622596", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        a();
        if (Build.VERSION.SDK_INT >= 17) {
            Toast toast = d;
            b41.f(toast);
            View view = toast.getView();
            b41.f(view);
            i = Gravity.getAbsoluteGravity(i, view.getResources().getConfiguration().getLayoutDirection());
        }
        Toast toast2 = d;
        b41.f(toast2);
        toast2.setGravity(i, i2, i3);
    }

    public final void h(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1116300294")) {
            ipChange.ipc$dispatch("-1116300294", new Object[]{this, view});
            return;
        }
        a();
        if (view != null) {
            Toast toast = d;
            if (toast != null) {
                b41.f(toast);
                toast.cancel();
                Toast toast2 = d;
                b41.f(toast2);
                toast2.setView(view);
                Log.e("DMToastUtil", "setView_cancel");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Views cannot be empty".toString());
    }

    public final void i(@NotNull Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1275950339")) {
            ipChange.ipc$dispatch("-1275950339", new Object[]{this, context, str});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (str == null || b41.d("", str)) {
            return;
        }
        if (!f(context)) {
            e(context, str, 0, k(context, str), 17, 0, 0, true);
            return;
        }
        Toast toast = c;
        if (toast == null) {
            Toast toast2 = new Toast(context);
            c = toast2;
            b41.f(toast2);
            toast2.setView(b(context, null, str));
            c(c);
            Toast toast3 = c;
            b41.f(toast3);
            toast3.show();
            return;
        }
        b41.f(toast);
        toast.setView(b(context, null, str));
        Toast toast4 = c;
        b41.f(toast4);
        toast4.show();
        if (g == 0) {
            g = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - g;
        if (currentTimeMillis <= 2000 || currentTimeMillis >= DateUtils.MILLIS_PER_MINUTE) {
            return;
        }
        g = System.currentTimeMillis();
        Toast toast5 = c;
        b41.f(toast5);
        toast5.cancel();
        c = null;
    }

    public final void j(@NotNull Context context, @Nullable View view, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762259887")) {
            ipChange.ipc$dispatch("-762259887", new Object[]{this, context, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (view == null) {
            return;
        }
        if (!f(context)) {
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
