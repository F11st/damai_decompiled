package tb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class kr1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_SETTING_REQUEST = 2168;
    private static final String a;

    static {
        String manufacturer = Build.getMANUFACTURER();
        b41.h(manufacturer, "Build.MANUFACTURER");
        Objects.requireNonNull(manufacturer, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = manufacturer.toLowerCase();
        b41.h(lowerCase, "(this as java.lang.String).toLowerCase()");
        a = lowerCase;
    }

    private static final Intent a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634408381")) {
            return (Intent) ipChange.ipc$dispatch("-1634408381", new Object[]{context});
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    @NotNull
    public static final String b(@NotNull String str) {
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1365730473")) {
            return (String) ipChange.ipc$dispatch("-1365730473", new Object[]{str});
        }
        b41.i(str, "propName");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                Process exec = runtime.exec("getprop " + str);
                b41.h(exec, "p");
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                str = bufferedReader.readLine();
                b41.h(str, "input.readLine()");
                bufferedReader.close();
            } catch (IOException unused2) {
                bufferedReader2 = bufferedReader;
                str = "";
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (IOException unused4) {
        }
        return str;
    }

    private static final Intent c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-87480975")) {
            return (Intent) ipChange.ipc$dispatch("-87480975", new Object[]{context});
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    private static final Intent d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-722272370")) {
            return (Intent) ipChange.ipc$dispatch("-722272370", new Object[]{context});
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return a(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    public static final boolean e(@NotNull String[] strArr, @NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1340114095")) {
            return ((Boolean) ipChange.ipc$dispatch("-1340114095", new Object[]{strArr, context})).booleanValue();
        }
        b41.i(strArr, "permissions");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (b41.d(strArr[0], "")) {
            return false;
        }
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return true;
            }
        }
        return false;
    }

    public static final void f(@Nullable Activity activity) {
        boolean K;
        boolean K2;
        boolean K3;
        boolean K4;
        boolean K5;
        Intent a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222841354")) {
            ipChange.ipc$dispatch("1222841354", new Object[]{activity});
        } else if (activity == null) {
        } else {
            String str = a;
            K = StringsKt__StringsKt.K(str, "huawei", false, 2, null);
            if (K) {
                a2 = c(activity);
            } else {
                K2 = StringsKt__StringsKt.K(str, "xiaomi", false, 2, null);
                if (K2) {
                    a2 = g(activity);
                } else {
                    K3 = StringsKt__StringsKt.K(str, "oppo", false, 2, null);
                    if (K3) {
                        a2 = a(activity);
                    } else {
                        K4 = StringsKt__StringsKt.K(str, "vivo", false, 2, null);
                        if (K4) {
                            a2 = a(activity);
                        } else {
                            K5 = StringsKt__StringsKt.K(str, "meizu", false, 2, null);
                            if (K5) {
                                a2 = d(activity);
                            } else {
                                a2 = a(activity);
                            }
                        }
                    }
                }
            }
            try {
                activity.startActivityForResult(a2, 2168);
            } catch (Exception unused) {
                try {
                    activity.startActivityForResult(a(activity), 2168);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static final Intent g(Context context) {
        boolean K;
        boolean K2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1871876421")) {
            return (Intent) ipChange.ipc$dispatch("1871876421", new Object[]{context});
        }
        String b = b("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(b)) {
            K = StringsKt__StringsKt.K(b, "7", false, 2, null);
            if (!K) {
                K2 = StringsKt__StringsKt.K(b, "8", false, 2, null);
                if (!K2) {
                    return a(context);
                }
            }
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }
}
