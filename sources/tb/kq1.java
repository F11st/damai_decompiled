package tb;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.android.launcher.common.Constants;
import com.taobao.android.speed.TBSpeed;
import com.taobao.monitor.impl.common.PageVisibleAlgorithm;
import java.util.HashMap;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kq1 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.kq1$b */
    /* loaded from: classes11.dex */
    public static class C9372b {
        private static final kq1 a = new kq1();
    }

    public static kq1 a() {
        return C9372b.a;
    }

    private void b(Application application, SharedPreferences sharedPreferences, HashMap<String, Object> hashMap) {
        if (nq1.a(hashMap.get(rj2.k), true)) {
            boolean z = sharedPreferences.getBoolean("isApm", true);
            a7.b().c("isApm", z);
            a7.b().c("isApmSpeed", TBSpeed.isSpeedEdition(application, xu1.DEFAULT_SAVE_DIR) & z);
        }
    }

    private void c(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            Object obj = hashMap.get(Constants.PARAMETER_SPEED_DESC);
            if (obj instanceof String) {
                hw0.r = (String) obj;
            } else {
                hw0.r = "normal";
            }
        }
    }

    private void d(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(m6.SPECIAL_PAGE_SAMPLE, "");
        try {
            if (TextUtils.isEmpty(string)) {
                return;
            }
            float nextFloat = new Random(System.currentTimeMillis()).nextFloat();
            e30.a("ParamCache", "computeRandomSample", Float.valueOf(nextFloat));
            String[] split = string.split(",");
            if (split.length > 0) {
                for (String str : split) {
                    String[] split2 = str.split(":");
                    if (split2.length == 2 && nextFloat < Float.parseFloat(split2[1])) {
                        x52.c(split2[0]);
                        e30.a("ParamCache", m6.SPECIAL_PAGE_SAMPLE, split2[0]);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void e(SharedPreferences sharedPreferences, HashMap<String, Object> hashMap) {
        boolean z = sharedPreferences.getBoolean(m6.GLOBAL_SAMPLE, true);
        e30.a("ParamCache", m6.GLOBAL_SAMPLE, Boolean.valueOf(z));
        boolean z2 = sharedPreferences.getBoolean(m6.UT_NETWORK_SAMPLE, rj2.d);
        rj2.d = z2;
        e30.a("ParamCache", m6.UT_NETWORK_SAMPLE, Boolean.valueOf(z2));
        boolean z3 = sharedPreferences.getBoolean(m6.NEED_ACTIVITY_PAGE, true);
        jd0.a = z3;
        e30.a("ParamCache", m6.NEED_ACTIVITY_PAGE, Boolean.valueOf(z3));
        boolean z4 = z && sharedPreferences.getBoolean(m6.PAGE_LOAD_SAMPLE, jd0.b);
        jd0.b = z4;
        e30.a("ParamCache", m6.PAGE_LOAD_SAMPLE, Boolean.valueOf(z4));
        boolean z5 = z && sharedPreferences.getBoolean(m6.FRAGMENT_PAGE_LOAD_SAMPLE, jd0.j);
        jd0.j = z5;
        e30.a("ParamCache", m6.FRAGMENT_PAGE_LOAD_SAMPLE, Boolean.valueOf(z5));
        boolean z6 = z && sharedPreferences.getBoolean(m6.CUSTOM_PAGE_SAMPLE, jd0.g);
        jd0.g = z6;
        e30.a("ParamCache", m6.CUSTOM_PAGE_SAMPLE, Boolean.valueOf(z6));
        su1.a = z && sharedPreferences.getBoolean(m6.NEED_PROCEDURE_PARAM_MAP_COPY, false);
        if (rj2.h) {
            c30.a = su1.a;
        }
        e30.a("ParamCache", m6.NEED_PROCEDURE_PARAM_MAP_COPY, Boolean.valueOf(su1.a));
        PageVisibleAlgorithm valueOf = PageVisibleAlgorithm.valueOf(sharedPreferences.getInt(m6.DEFAULT_ALGORITHM, rj2.i.ordinal()));
        jd0.n = valueOf;
        e30.a("ParamCache", m6.DEFAULT_ALGORITHM, valueOf);
        jd0.h = z && sharedPreferences.getBoolean(m6.OPEN_BAD_TOKEN_HOOK, true);
        boolean z7 = z && sharedPreferences.getBoolean(m6.NEED_CANVAS_ALGORITHM, jd0.q);
        jd0.q = z7;
        e30.a("ParamCache", m6.NEED_CANVAS_ALGORITHM, Boolean.valueOf(z7));
        boolean z8 = z && sharedPreferences.getBoolean(m6.NEED_SPECIFIC_VIEW_AREA_ALGORITHM, jd0.o);
        jd0.o = z8;
        e30.a("ParamCache", m6.NEED_SPECIFIC_VIEW_AREA_ALGORITHM, Boolean.valueOf(z8));
        boolean z9 = z && sharedPreferences.getBoolean(m6.NEED_SHADOW_ALGORITHM, jd0.p);
        jd0.p = z9;
        e30.a("ParamCache", m6.NEED_SHADOW_ALGORITHM, Boolean.valueOf(z9));
        boolean z10 = z && sharedPreferences.getBoolean(m6.NEED_FPS, jd0.w);
        jd0.w = z10;
        e30.a("ParamCache", m6.NEED_FPS, Boolean.valueOf(z10));
        boolean z11 = z && sharedPreferences.getBoolean(m6.BLOCK_WATCHER_SAMPLE, jd0.x);
        jd0.x = z11;
        e30.a("ParamCache", m6.BLOCK_WATCHER_SAMPLE, Boolean.valueOf(z11));
        boolean z12 = z && sharedPreferences.getBoolean(m6.LOOPER_MONITOR_SAMPLE, jd0.y);
        jd0.y = z12;
        e30.a("ParamCache", m6.LOOPER_MONITOR_SAMPLE, Boolean.valueOf(z12));
        boolean z13 = !z || sharedPreferences.getBoolean(m6.NEED_WEEX_PROCEDURE_PARENT, false);
        jd0.s = z13;
        e30.a("ParamCache", m6.NEED_WEEX_PROCEDURE_PARENT, Boolean.valueOf(z13));
        boolean z14 = !z || sharedPreferences.getBoolean(m6.END_WEEX_PROCEDURE_F2B, false);
        jd0.t = z14;
        e30.a("ParamCache", m6.END_WEEX_PROCEDURE_F2B, Boolean.valueOf(z14));
        boolean z15 = !z || sharedPreferences.getBoolean(m6.SUPPORT_MASTER_VIEW, false);
        jd0.u = z15;
        e30.a("ParamCache", m6.SUPPORT_MASTER_VIEW, Boolean.valueOf(z15));
        boolean z16 = z && sharedPreferences.getBoolean(m6.NEED_DISPATCH_RENDER_STANDARD, true);
        jd0.v = z16;
        e30.a("ParamCache", m6.NEED_DISPATCH_RENDER_STANDARD, Boolean.valueOf(z16));
        boolean z17 = z && sharedPreferences.getBoolean(m6.NEED_FRAME_METRICS, jd0.A);
        jd0.A = z17;
        e30.a("ParamCache", m6.NEED_FRAME_METRICS, Boolean.valueOf(z17));
        boolean z18 = !z || sharedPreferences.getBoolean(m6.NEED_ROLLBACK_FPS, jd0.B);
        jd0.B = z18;
        e30.a("ParamCache", m6.NEED_ROLLBACK_FPS, Boolean.valueOf(z18));
        boolean z19 = z && sharedPreferences.getBoolean(m6.NEED_FIX_WINDOW_HOOK_ERROR, jd0.C);
        jd0.C = z19;
        e30.a("ParamCache", m6.NEED_FIX_WINDOW_HOOK_ERROR, Boolean.valueOf(z19));
        boolean z20 = z && sharedPreferences.getBoolean(m6.NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE, rj2.j);
        rj2.j = z20;
        e30.a("ParamCache", m6.NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE, Boolean.valueOf(z20));
        boolean z21 = z && sharedPreferences.getBoolean(m6.NEED_FIRST_FRAME, jd0.D);
        jd0.D = z21;
        e30.a("ParamCache", m6.NEED_FIRST_FRAME, Boolean.valueOf(z21));
        boolean z22 = z && sharedPreferences.getBoolean(m6.NEXT_LAUNCH_UPLOAD_SAMPLE, jd0.E);
        jd0.E = z22;
        e30.a("ParamCache", m6.NEXT_LAUNCH_UPLOAD_SAMPLE, Boolean.valueOf(z22));
    }

    public void f(Application application, HashMap<String, Object> hashMap) {
        c(hashMap);
        SharedPreferences sharedPreferences = application.getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0);
        b(application, sharedPreferences, hashMap);
        e(sharedPreferences, hashMap);
        d(sharedPreferences);
    }

    private kq1() {
    }
}
