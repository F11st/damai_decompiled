package com.alibaba.security.realidentity.utils;

import android.app.Activity;
import cn.wh.auth.OnCallBack;
import com.alibaba.fastjson.JSONException;
import com.alibaba.security.biometrics.jni.VersionKey;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3811h;
import com.alibaba.security.common.track.a.C3829a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.C3839a;
import com.alibaba.security.realidentity.business.dynamic.model.CtidConfig;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import tb.dz2;
import tb.ez2;
import tb.h32;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.utils.c */
/* loaded from: classes8.dex */
public class C3925c {
    private static final String c = "c";
    public int a;
    public String b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.utils.c$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 implements OnCallBack {
        final /* synthetic */ String a;
        final /* synthetic */ Runnable b;

        public AnonymousClass1(String str, Runnable runnable) {
            this.a = str;
            this.b = runnable;
        }

        @Override // cn.wh.auth.OnCallBack
        public final void onResult(h32 h32Var) {
            String str = C3925c.c;
            C3800a.a(str, "CTID result: " + h32Var.a() + ", resultDesc: " + h32Var.c());
            C3925c.a(h32Var, this.a);
            C3925c.this.a = C3925c.a(h32Var.a());
            C3925c.this.b = h32Var.b().b();
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static boolean a() {
        return true;
    }

    private int c() {
        return this.a;
    }

    private String d() {
        return this.b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int b(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case 1874685069:
                if (str.equals(C3839a.q)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1989201674:
                if (str.equals(C3839a.x)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231465:
                if (str.equals(C3839a.C)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231467:
                if (str.equals(C3839a.D)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231468:
                if (str.equals(C3839a.E)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231473:
                if (str.equals(C3839a.z)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231495:
                if (str.equals(C3839a.A)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1989261256:
                if (str.equals(C3839a.B)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1989350629:
                if (str.equals(C3839a.y)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184778:
                if (str.equals(C3839a.r)) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184779:
                if (str.equals(C3839a.s)) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184780:
                if (str.equals(C3839a.t)) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184781:
                if (str.equals(C3839a.u)) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184782:
                if (str.equals(C3839a.v)) {
                    c2 = CharUtils.CR;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184783:
                if (str.equals(C3839a.w)) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return 0;
            case 1:
                return GlobalErrorCode.ERROR_CTID_APP_ERROR;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 4001;
            case '\b':
                return GlobalErrorCode.ERROR_CTID_DATA_ERROR;
            case '\t':
                return 4002;
            case '\n':
            default:
                return -1;
            case 11:
                return 4003;
            case '\f':
                return 4004;
            case '\r':
                return GlobalErrorCode.ERROR_CTID_NO_CERT;
            case 14:
                return GlobalErrorCode.ERROR_CTID_NOT_BINDING;
        }
    }

    private void a(CtidConfig ctidConfig, Activity activity, String str, Runnable runnable) {
        ez2 ez2Var = new ez2(ctidConfig.getOrgId(), ctidConfig.getAndroidAppId(), str, ctidConfig.getType());
        a(ctidConfig, str);
        new dz2(activity, ez2Var).getAuthResult(new AnonymousClass1(str, runnable));
    }

    private static void b(h32 h32Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("resultCode", h32Var.a());
        hashMap.put("idAuthData", h32Var.b().b());
        hashMap.put("resultMsg", h32Var.c());
        a(str, TrackLog.createCtidAppEndLog(C3811h.a((Map) hashMap)));
    }

    public static void a(CtidConfig ctidConfig, String str) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("orgId", ctidConfig.getOrgId());
            hashMap.put(ALBiometricsKeys.KEY_APP_ID, ctidConfig.getAndroidAppId());
            hashMap.put("bizSeq", str);
            hashMap.put("type", String.valueOf(ctidConfig.getType()));
        } catch (JSONException unused) {
            C3800a.b();
        }
        a(str, TrackLog.createCtidAppStartLog(C3811h.a((Map) hashMap)));
    }

    private static void a(String str, TrackLog trackLog) {
        trackLog.setVerifyToken(str);
        trackLog.addTag9(VersionKey.RP_SDK_VERSION + "/3.3.0");
        trackLog.addTag10("Android");
        C3829a.C3830a.a.a(trackLog);
    }

    static /* synthetic */ void a(h32 h32Var, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("resultCode", h32Var.a());
        hashMap.put("idAuthData", h32Var.b().b());
        hashMap.put("resultMsg", h32Var.c());
        a(str, TrackLog.createCtidAppEndLog(C3811h.a((Map) hashMap)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ int a(String str) {
        char c2;
        str.hashCode();
        switch (str.hashCode()) {
            case 1874685069:
                if (str.equals(C3839a.q)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1989201674:
                if (str.equals(C3839a.x)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231465:
                if (str.equals(C3839a.C)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231467:
                if (str.equals(C3839a.D)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231468:
                if (str.equals(C3839a.E)) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231473:
                if (str.equals(C3839a.z)) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1989231495:
                if (str.equals(C3839a.A)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1989261256:
                if (str.equals(C3839a.B)) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 1989350629:
                if (str.equals(C3839a.y)) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184778:
                if (str.equals(C3839a.r)) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184779:
                if (str.equals(C3839a.s)) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184780:
                if (str.equals(C3839a.t)) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184781:
                if (str.equals(C3839a.u)) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 1990184782:
                if (str.equals(C3839a.v)) {
                    c2 = CharUtils.CR;
                    break;
                }
                c2 = 65535;
                break;
            case 1990184783:
                if (str.equals(C3839a.w)) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return 0;
            case 1:
                return GlobalErrorCode.ERROR_CTID_APP_ERROR;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 4001;
            case '\b':
                return GlobalErrorCode.ERROR_CTID_DATA_ERROR;
            case '\t':
                return 4002;
            case '\n':
            default:
                return -1;
            case 11:
                return 4003;
            case '\f':
                return 4004;
            case '\r':
                return GlobalErrorCode.ERROR_CTID_NO_CERT;
            case 14:
                return GlobalErrorCode.ERROR_CTID_NOT_BINDING;
        }
    }
}
