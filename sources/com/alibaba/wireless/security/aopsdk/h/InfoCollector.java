package com.alibaba.wireless.security.aopsdk.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.Invocation;
import com.alibaba.wireless.security.aopsdk.ReflectUtil;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.alibaba.wireless.security.aopsdk.i.LogUtils;
import com.alibaba.wireless.security.aopsdk.i.StringUtils;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.alipay.sdk.m.l.C4231b;
import com.uc.webview.export.internal.interfaces.IWaStat;
import java.util.HashMap;
import org.json.JSONObject;
import tb.jn1;

/* renamed from: com.alibaba.wireless.security.aopsdk.h.a */
/* loaded from: classes.dex */
public class InfoCollector {
    private static final String a = "InfoCollector";
    private static boolean b;
    private static String c;
    private static String d;
    private static boolean e;

    /* compiled from: InfoCollector.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.h.a$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C3982a {
        public static final /* synthetic */ int[] a;

        static {
            EnumC3983b.values();
            int[] iArr = new int[9];
            a = iArr;
            try {
                EnumC3983b enumC3983b = EnumC3983b.PROXY_NAME;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = a;
                EnumC3983b enumC3983b2 = EnumC3983b.STACK_TRACE;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = a;
                EnumC3983b enumC3983b3 = EnumC3983b.THIS;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = a;
                EnumC3983b enumC3983b4 = EnumC3983b.METHOD_PARAM;
                iArr4[3] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = a;
                EnumC3983b enumC3983b5 = EnumC3983b.PROCESS_ALIAS;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = a;
                EnumC3983b enumC3983b6 = EnumC3983b.APP_STATE;
                iArr6[6] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                int[] iArr7 = a;
                EnumC3983b enumC3983b7 = EnumC3983b.SNAPSHOT;
                iArr7[7] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                int[] iArr8 = a;
                EnumC3983b enumC3983b8 = EnumC3983b.VERSION_CODE;
                iArr8[8] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* compiled from: InfoCollector.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.h.a$b */
    /* loaded from: classes.dex */
    public enum EnumC3983b {
        PROXY_NAME(IRequestConst.PN),
        STACK_TRACE("st"),
        THIS("th"),
        METHOD_PARAM("mp"),
        PROCESS_ALIAS(C4231b.k),
        CALL_COUNT(IWaStat.KEY_CHECK_COMPRESS),
        APP_STATE("as"),
        SNAPSHOT("sn"),
        VERSION_CODE(IRequestConst.VC);
        
        private final String a;

        EnumC3983b(String str) {
            this.a = str;
        }

        public String a() {
            return this.a;
        }
    }

    public static String a(EnumC3983b enumC3983b, Invocation invocation) {
        switch (enumC3983b.ordinal()) {
            case 0:
                return d(invocation);
            case 1:
                return f(invocation);
            case 2:
                return g(invocation);
            case 3:
                return b(invocation);
            case 4:
                return c(invocation);
            case 5:
            default:
                return null;
            case 6:
                return a(invocation);
            case 7:
                return e(invocation);
            case 8:
                return h(invocation);
        }
    }

    private static String b(Invocation invocation) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        Object[] objArr = invocation.args;
        if (objArr != null) {
            for (Object obj : objArr) {
                sb.append(StringUtils.a(obj));
                sb.append("^^");
            }
            if (invocation.args.length > 0 && sb.length() >= 2) {
                sb.delete(sb.length() - 2, sb.length());
            }
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    private static String c(Invocation invocation) {
        return ReflectUtil.e(null);
    }

    private static String d(Invocation invocation) {
        return invocation.getProxyName();
    }

    private static String e(Invocation invocation) {
        String f;
        HashMap hashMap = new HashMap();
        if (e) {
            LogUtils.b(a, "Get snapshot by activity listener");
            f = c;
        } else {
            LogUtils.b(a, "Get snapshot by getRunningTasks");
            f = ReflectUtil.f(ConfigManager.getInstance().getContext());
        }
        hashMap.put("v", f);
        hashMap.put(IRequestConst.U, d);
        return new JSONObject(hashMap).toString();
    }

    private static String f(Invocation invocation) {
        return ReflectUtil.a(invocation);
    }

    private static String g(Invocation invocation) {
        return invocation.thiz.toString();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:13:0x0030). Please submit an issue!!! */
    private static String h(Invocation invocation) {
        Context context = ConfigManager.getInstance().getContext();
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        return null;
    }

    public static void b(boolean z) {
        e = z;
    }

    public static void b(String str) {
        LogUtils.b(a, "setLastPageUrl to " + str);
        d = str;
    }

    public static String a(String str, Invocation invocation) {
        EnumC3983b enumC3983b;
        EnumC3983b[] values = EnumC3983b.values();
        int i = 0;
        while (true) {
            if (i >= 9) {
                enumC3983b = null;
                break;
            }
            enumC3983b = values[i];
            if (TextUtils.equals(str, enumC3983b.a)) {
                break;
            }
            i++;
        }
        if (enumC3983b == null) {
            return null;
        }
        return a(enumC3983b, invocation);
    }

    private static String a(Invocation invocation) {
        if (e) {
            LogUtils.b(a, "Get appstate by activity listener");
            return Integer.toString(b ? 0 : 2);
        }
        LogUtils.b(a, "Get appstate by getRunningTasks");
        return Integer.toString(ReflectUtil.c(ConfigManager.getInstance().getContext()));
    }

    public static void a(boolean z) {
        LogUtils.b(a, "setForeground to " + z);
        b = z;
    }

    public static void a(String str) {
        LogUtils.b(a, "setCurrentView to " + str);
        c = str;
    }
}
