package tb;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.monitor.impl.common.PageVisibleAlgorithm;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m6 implements OConfigListener {
    public static final String BLOCK_WATCHER_SAMPLE = "block_sample";
    public static final String CUSTOM_PAGE_SAMPLE = "custom_page_sample";
    public static final String DEFAULT_ALGORITHM = "default_algorithm";
    public static final String END_WEEX_PROCEDURE_F2B = "end_weex_procedure_in_f2b";
    public static final String FRAGMENT_PAGE_LOAD_POP_SAMPLE = "fragment_page_load_pop_sample";
    public static final String FRAGMENT_PAGE_LOAD_SAMPLE = "fragment_page_load_sample";
    public static final String GLOBAL_SAMPLE = "global_sample";
    public static final String IMAGE_PROCESSOR_SAMPLE = "image_processor_sample";
    public static final String LAUNCHER_PROCESSOR_SAMPLE = "launcher_sample";
    public static final String LOOPER_MONITOR_SAMPLE = "looper_monitor_sample";
    public static final String NEED_ACTIVITY_PAGE = "need_activity_page";
    public static final String NEED_CANVAS_ALGORITHM = "need_canvas_algorithm";
    public static final String NEED_DISPATCH_RENDER_STANDARD = "need_dispatch_render_standard";
    public static final String NEED_FIRST_FRAME = "need_first_frame";
    public static final String NEED_FIX_WINDOW_HOOK_ERROR = "need_fix_window_hook_error";
    public static final String NEED_FPS = "need_fps";
    public static final String NEED_FRAME_METRICS = "need_frame_metrics";
    public static final String NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE = "need_launch_visible_calculate_change";
    public static final String NEED_PROCEDURE_PARAM_MAP_COPY = "need_procedure_param_map_copy";
    public static final String NEED_ROLLBACK_FPS = "need_rollback_fps";
    public static final String NEED_RUNTIME_INFO = "need_runtime_info";
    public static final String NEED_SHADOW_ALGORITHM = "need_shadow_algorithm";
    public static final String NEED_SPECIFIC_VIEW_AREA_ALGORITHM = "need_specific_view_area_algorithm";
    public static final String NEED_START_ACTIVITY_TRACE_SWITCH = "need_start_activity_trace_switch";
    public static final String NEED_WEEX_PROCEDURE_PARENT = "need_weex_procedure_parent";
    public static final String NETWORK_PROCESSOR_SAMPLE = "network_processor_sample";
    public static final String NETWORK_SAMPLE = "network_sample";
    public static final String NEXT_LAUNCH_UPLOAD_SAMPLE = "next_launch_upload_sample";
    public static final String OPEN_BAD_TOKEN_HOOK = "open_bad_token_hook";
    public static final String ORANGE_NAMESPACE = "applicationmonitor";
    public static final String PAGE_LOAD_POP_SAMPLE = "page_load_pop_sample";
    public static final String PAGE_LOAD_SAMPLE = "page_load_sample";
    public static final String SPECIAL_PAGE_SAMPLE = "special_page_sample";
    public static final String SUPPORT_MASTER_VIEW = "support_master_view";
    public static final String USE_NEW_APM_SAMPLE = "use_new_apm_sample";
    public static final String UT_NETWORK_SAMPLE = "ut_network_sample";
    public static final String WEEX_PROCESSOR_SAMPLE = "weex_processor_sample";

    @Deprecated
    private void A(Map<String, String> map, float f, boolean z, SharedPreferences.Editor editor) {
        boolean z2 = f < nq1.b(map.get(UT_NETWORK_SAMPLE), 1.0f) && z;
        rj2.d = z2;
        editor.putBoolean(UT_NETWORK_SAMPLE, z2);
        e30.a("ApmOrangeListener", UT_NETWORK_SAMPLE, Boolean.valueOf(rj2.d));
    }

    @Deprecated
    private void B(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.s = true;
            return;
        }
        if (map.containsKey(NEED_WEEX_PROCEDURE_PARENT)) {
            String str = map.get(NEED_WEEX_PROCEDURE_PARENT);
            if (!TextUtils.isEmpty(str)) {
                boolean equals = "true".equals(str);
                jd0.s = equals;
                editor.putBoolean(NEED_WEEX_PROCEDURE_PARENT, equals);
            }
        }
        e30.a("ApmOrangeListener", NEED_WEEX_PROCEDURE_PARENT, Boolean.valueOf(jd0.s));
    }

    @Deprecated
    private void C(Map<String, String> map, float f, boolean z) {
        boolean z2 = f < nq1.b(map.get(WEEX_PROCESSOR_SAMPLE), 1.0f) && z;
        jd0.f = z2;
        e30.a("ApmOrangeListener", WEEX_PROCESSOR_SAMPLE, Boolean.valueOf(z2));
    }

    private void D(float f, Map<String, String> map) {
        String str;
        try {
            str = new JSONObject(map).toString();
        } catch (Exception unused) {
            str = "";
        }
        e30.a("ApmOrangeListener", "orangeConfig", str);
    }

    @Deprecated
    private void E(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.v = true;
            return;
        }
        if (map.containsKey(NEED_DISPATCH_RENDER_STANDARD)) {
            String str = map.get(NEED_DISPATCH_RENDER_STANDARD);
            if (!TextUtils.isEmpty(str)) {
                boolean equals = "true".equals(str);
                jd0.v = equals;
                editor.putBoolean(NEED_DISPATCH_RENDER_STANDARD, equals);
            }
        }
        e30.a("ApmOrangeListener", NEED_DISPATCH_RENDER_STANDARD, Boolean.valueOf(jd0.v));
    }

    private void F(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.C = false;
            return;
        }
        if (map.containsKey(NEED_FIX_WINDOW_HOOK_ERROR)) {
            String str = map.get(NEED_FIX_WINDOW_HOOK_ERROR);
            if (!TextUtils.isEmpty(str)) {
                boolean equals = "true".equals(str);
                jd0.C = equals;
                editor.putBoolean(NEED_FIX_WINDOW_HOOK_ERROR, equals);
            }
        }
        e30.a("ApmOrangeListener", NEED_FIX_WINDOW_HOOK_ERROR, Boolean.valueOf(jd0.C));
    }

    private boolean G(Map<String, String> map, SharedPreferences.Editor editor, String str, boolean z) {
        if (map.containsKey(str)) {
            String str2 = map.get(str);
            if (TextUtils.isEmpty(str2)) {
                return z;
            }
            boolean equals = "true".equals(str2);
            editor.putBoolean(str, equals);
            return equals;
        }
        return z;
    }

    private boolean H(Map<String, String> map, float f, SharedPreferences.Editor editor, String str) {
        boolean z = f < nq1.b(map.get(str), 1.0f);
        editor.putBoolean(str, z);
        return z;
    }

    private boolean I(Map<String, String> map, float f, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z = sharedPreferences.getBoolean(GLOBAL_SAMPLE, true);
        boolean z2 = f < nq1.b(map.get(GLOBAL_SAMPLE), 1.0f);
        if (z2 != z) {
            editor.putBoolean(GLOBAL_SAMPLE, z2);
        }
        e30.a("ApmOrangeListener", GLOBAL_SAMPLE, Boolean.valueOf(z2));
        return z2;
    }

    @Deprecated
    private void J(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.u = true;
            return;
        }
        if (map.containsKey(SUPPORT_MASTER_VIEW)) {
            String str = map.get(SUPPORT_MASTER_VIEW);
            if (!TextUtils.isEmpty(str)) {
                boolean equals = "true".equals(str);
                jd0.u = equals;
                editor.putBoolean(SUPPORT_MASTER_VIEW, equals);
            }
        }
        e30.a("ApmOrangeListener", SUPPORT_MASTER_VIEW, Boolean.valueOf(jd0.u));
    }

    @Deprecated
    private void a(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.t = true;
            return;
        }
        if (map.containsKey(END_WEEX_PROCEDURE_F2B)) {
            String str = map.get(END_WEEX_PROCEDURE_F2B);
            if (!TextUtils.isEmpty(str)) {
                boolean equals = "true".equals(str);
                jd0.t = equals;
                editor.putBoolean(END_WEEX_PROCEDURE_F2B, equals);
            }
        }
        e30.a("ApmOrangeListener", END_WEEX_PROCEDURE_F2B, Boolean.valueOf(jd0.t));
    }

    private float b() {
        float nextFloat = new Random(System.currentTimeMillis()).nextFloat();
        e30.a("ApmOrangeListener", "computeRandomSample", Float.valueOf(nextFloat));
        return nextFloat;
    }

    @Deprecated
    private void c(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (map.containsKey(NEED_ACTIVITY_PAGE)) {
            boolean z2 = "true".equals(map.get(NEED_ACTIVITY_PAGE)) && z;
            jd0.a = z2;
            editor.putBoolean(NEED_ACTIVITY_PAGE, z2);
        }
        e30.a("ApmOrangeListener", NEED_ACTIVITY_PAGE, Boolean.valueOf(jd0.a));
    }

    @Deprecated
    private void d(Map<String, String> map, boolean z, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        String str = map.get("isApm");
        boolean z2 = TextUtils.isEmpty(str) || !str.equalsIgnoreCase("close");
        boolean z3 = sharedPreferences.getBoolean("isApm", true);
        if (z2 != z3) {
            editor.putBoolean("isApm", z2);
        }
        e30.a("ApmOrangeListener", "isApm", Boolean.valueOf(z3));
    }

    @Deprecated
    private void e(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.h = false;
            editor.putBoolean(OPEN_BAD_TOKEN_HOOK, false);
            return;
        }
        if (map.containsKey(OPEN_BAD_TOKEN_HOOK)) {
            String str = map.get(OPEN_BAD_TOKEN_HOOK);
            if (!TextUtils.isEmpty(str)) {
                boolean equals = "true".equals(str);
                jd0.h = equals;
                editor.putBoolean(OPEN_BAD_TOKEN_HOOK, equals);
            }
        }
        e30.a("ApmOrangeListener", OPEN_BAD_TOKEN_HOOK, Boolean.valueOf(jd0.h));
    }

    @Deprecated
    private void f(Map<String, String> map, float f, boolean z, SharedPreferences.Editor editor) {
        if (Build.VERSION.SDK_INT >= 16) {
            String str = map.get(BLOCK_WATCHER_SAMPLE);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            boolean z2 = f < nq1.b(str, 1.0f) && z;
            jd0.x = z2;
            editor.putBoolean(BLOCK_WATCHER_SAMPLE, z2);
            e30.a("ApmOrangeListener", BLOCK_WATCHER_SAMPLE, Boolean.valueOf(jd0.x));
        }
    }

    @Deprecated
    private void g(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.q = false;
            editor.putBoolean(NEED_CANVAS_ALGORITHM, false);
            return;
        }
        if (map.containsKey(NEED_CANVAS_ALGORITHM)) {
            jd0.o = "true".equals(map.get(NEED_CANVAS_ALGORITHM));
            editor.putBoolean(NEED_CANVAS_ALGORITHM, jd0.q);
        }
        e30.a("ApmOrangeListener", NEED_CANVAS_ALGORITHM, Boolean.valueOf(jd0.q));
    }

    @Deprecated
    private void h(Map<String, String> map, float f, boolean z, SharedPreferences.Editor editor) {
        boolean z2 = f < nq1.b(map.get(CUSTOM_PAGE_SAMPLE), 1.0f) && z;
        jd0.g = z2;
        editor.putBoolean(CUSTOM_PAGE_SAMPLE, z2);
        e30.a("ApmOrangeListener", CUSTOM_PAGE_SAMPLE, Boolean.valueOf(jd0.g));
    }

    @Deprecated
    private void i(Map<String, String> map, SharedPreferences.Editor editor) {
        if (map.containsKey(DEFAULT_ALGORITHM)) {
            PageVisibleAlgorithm valueOf = PageVisibleAlgorithm.valueOf(nq1.c(map.get(DEFAULT_ALGORITHM), rj2.i.getValue()));
            jd0.n = valueOf;
            editor.putInt(DEFAULT_ALGORITHM, valueOf.getValue());
        }
        e30.a("ApmOrangeListener", DEFAULT_ALGORITHM, jd0.n);
    }

    private void j(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.w = false;
            return;
        }
        if (map.containsKey(NEED_FPS)) {
            String str = map.get(NEED_FPS);
            if (!TextUtils.isEmpty(str)) {
                boolean equals = "true".equals(str);
                jd0.w = equals;
                editor.putBoolean(NEED_FPS, equals);
            }
        }
        e30.a("ApmOrangeListener", NEED_FPS, Boolean.valueOf(jd0.w));
    }

    @Deprecated
    private void k(Map<String, String> map, float f, boolean z) {
        boolean z2 = f < nq1.b(map.get(FRAGMENT_PAGE_LOAD_POP_SAMPLE), 1.0f) && z;
        jd0.k = z2;
        e30.a("ApmOrangeListener", FRAGMENT_PAGE_LOAD_POP_SAMPLE, Boolean.valueOf(z2));
    }

    @Deprecated
    private void l(Map<String, String> map, float f, boolean z, SharedPreferences.Editor editor) {
        boolean z2 = f < nq1.b(map.get(FRAGMENT_PAGE_LOAD_SAMPLE), 1.0f) && z;
        jd0.j = z2;
        editor.putBoolean(FRAGMENT_PAGE_LOAD_SAMPLE, z2);
        e30.a("ApmOrangeListener", FRAGMENT_PAGE_LOAD_SAMPLE, Boolean.valueOf(jd0.j));
    }

    @Deprecated
    private void m(Map<String, String> map, float f, boolean z) {
        boolean z2 = f < nq1.b(map.get(IMAGE_PROCESSOR_SAMPLE), 1.0f) && z;
        jd0.d = z2;
        e30.a("ApmOrangeListener", IMAGE_PROCESSOR_SAMPLE, Boolean.valueOf(z2));
    }

    @Deprecated
    private void n(Map<String, String> map, float f, boolean z, SharedPreferences.Editor editor) {
        boolean z2 = f < nq1.b(map.get(LAUNCHER_PROCESSOR_SAMPLE), 1.0f) && z;
        jd0.i = z2;
        editor.putBoolean(LAUNCHER_PROCESSOR_SAMPLE, z2);
        e30.a("ApmOrangeListener", LAUNCHER_PROCESSOR_SAMPLE, Boolean.valueOf(jd0.i));
    }

    private void o(Map<String, String> map, float f, boolean z, SharedPreferences.Editor editor) {
        String str = map.get(LOOPER_MONITOR_SAMPLE);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = f < nq1.b(str, 1.0f) && z;
        jd0.y = z2;
        editor.putBoolean(LOOPER_MONITOR_SAMPLE, z2);
        e30.a("ApmOrangeListener", LOOPER_MONITOR_SAMPLE, Boolean.valueOf(jd0.y));
    }

    @Deprecated
    private void p(Map<String, String> map, SharedPreferences.Editor editor) {
        if (map.containsKey(NEED_PROCEDURE_PARAM_MAP_COPY)) {
            su1.a = "true".equals(map.get(NEED_PROCEDURE_PARAM_MAP_COPY));
            if (rj2.h) {
                boolean equals = "true".equals(map.get(NEED_PROCEDURE_PARAM_MAP_COPY));
                c30.a = equals;
                editor.putBoolean(NEED_PROCEDURE_PARAM_MAP_COPY, equals);
            }
        }
        e30.a("ApmOrangeListener", NEED_PROCEDURE_PARAM_MAP_COPY, Boolean.valueOf(su1.a));
    }

    @Deprecated
    private void q(Map<String, String> map, float f, boolean z) {
        boolean z2 = f < nq1.b(map.get(NETWORK_PROCESSOR_SAMPLE), 1.0f) && z;
        jd0.e = z2;
        e30.a("ApmOrangeListener", NETWORK_PROCESSOR_SAMPLE, Boolean.valueOf(z2));
    }

    @Deprecated
    private void r(Map<String, String> map, float f, boolean z) {
        boolean z2 = f < nq1.b(map.get(USE_NEW_APM_SAMPLE), 1.0f) && z;
        jd0.l = z2;
        e30.a("ApmOrangeListener", USE_NEW_APM_SAMPLE, Boolean.valueOf(z2));
    }

    @Deprecated
    private void s(Map<String, String> map, float f, boolean z) {
        boolean z2 = f < nq1.b(map.get(PAGE_LOAD_POP_SAMPLE), 1.0f) && z;
        jd0.c = z2;
        e30.a("ApmOrangeListener", PAGE_LOAD_POP_SAMPLE, Boolean.valueOf(z2));
    }

    @Deprecated
    private void t(Map<String, String> map, float f, boolean z, SharedPreferences.Editor editor) {
        boolean z2 = f < nq1.b(map.get(PAGE_LOAD_SAMPLE), 1.0f) && z;
        jd0.b = z2;
        editor.putBoolean(PAGE_LOAD_SAMPLE, z2);
        e30.a("ApmOrangeListener", PAGE_LOAD_SAMPLE, Boolean.valueOf(jd0.b));
    }

    @Deprecated
    private void u(Map<String, String> map) {
        if ("true".equals(map.get(NEED_START_ACTIVITY_TRACE_SWITCH))) {
            jd0.m = true;
        } else {
            jd0.m = false;
        }
        e30.a("ApmOrangeListener", NEED_START_ACTIVITY_TRACE_SWITCH, Boolean.valueOf(jd0.m));
    }

    @Deprecated
    private void v(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.r = false;
            editor.putBoolean(NEED_RUNTIME_INFO, false);
            return;
        }
        if (map.containsKey(NEED_RUNTIME_INFO)) {
            boolean equals = "true".equals(map.get(NEED_RUNTIME_INFO));
            jd0.r = equals;
            editor.putBoolean(NEED_RUNTIME_INFO, equals);
        }
        e30.a("ApmOrangeListener", NEED_RUNTIME_INFO, Boolean.valueOf(jd0.r));
    }

    @Deprecated
    private void w(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.p = false;
            editor.putBoolean(NEED_SHADOW_ALGORITHM, false);
            return;
        }
        if (map.containsKey(NEED_SHADOW_ALGORITHM)) {
            boolean equals = "true".equals(map.get(NEED_SHADOW_ALGORITHM));
            jd0.p = equals;
            editor.putBoolean(NEED_SHADOW_ALGORITHM, equals);
        }
        e30.a("ApmOrangeListener", NEED_SHADOW_ALGORITHM, Boolean.valueOf(jd0.p));
    }

    @Deprecated
    private void x(Map<String, String> map, boolean z, float f, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        if (!z) {
            x52.a();
            editor.putString(SPECIAL_PAGE_SAMPLE, "");
            return;
        }
        String str = map.get(SPECIAL_PAGE_SAMPLE);
        try {
            x52.a();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String[] split = str.split(",");
            if (split.length > 0) {
                for (String str2 : split) {
                    String[] split2 = str2.split(":");
                    if (split2.length == 2 && f < nq1.b(split2[1], 0.0f)) {
                        x52.c(split2[0]);
                        e30.a("ApmOrangeListener", SPECIAL_PAGE_SAMPLE, split2[0]);
                    }
                }
                if (str.equals(sharedPreferences.getString(SPECIAL_PAGE_SAMPLE, ""))) {
                    return;
                }
                editor.putString(SPECIAL_PAGE_SAMPLE, str);
            }
        } catch (Exception e) {
            e30.a("ApmOrangeListener", "special_page_sample add error", e.getMessage());
        }
    }

    @Deprecated
    private void y(Map<String, String> map, boolean z, SharedPreferences.Editor editor) {
        if (!z) {
            jd0.o = false;
            editor.putBoolean(NEED_SPECIFIC_VIEW_AREA_ALGORITHM, false);
            return;
        }
        if (map.containsKey(NEED_SPECIFIC_VIEW_AREA_ALGORITHM)) {
            boolean equals = "true".equals(map.get(NEED_SPECIFIC_VIEW_AREA_ALGORITHM));
            jd0.o = equals;
            editor.putBoolean(NEED_SPECIFIC_VIEW_AREA_ALGORITHM, equals);
        }
        e30.a("ApmOrangeListener", NEED_SPECIFIC_VIEW_AREA_ALGORITHM, Boolean.valueOf(jd0.o));
    }

    @Deprecated
    private void z(Map<String, String> map, float f, boolean z) {
        boolean z2 = f < nq1.b(map.get(NETWORK_SAMPLE), 1.0f) && z;
        rj2.c = z2;
        e30.a("ApmOrangeListener", NETWORK_SAMPLE, Boolean.valueOf(z2));
    }

    @Override // com.taobao.orange.OConfigListener
    public void onConfigUpdate(String str, Map<String, String> map) {
        boolean z;
        Map<String, String> configs = OrangeConfig.getInstance().getConfigs(ORANGE_NAMESPACE);
        if (configs == null || configs.size() <= 0) {
            return;
        }
        try {
            float b = b();
            SharedPreferences sharedPreferences = fu0.e().a().getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            D(b, configs);
            boolean I = I(configs, b, sharedPreferences, edit);
            z(configs, b, I);
            A(configs, b, I, edit);
            n(configs, b, I, edit);
            c(configs, I, edit);
            t(configs, b, I, edit);
            s(configs, b, I);
            l(configs, b, I, edit);
            k(configs, b, I);
            h(configs, b, I, edit);
            q(configs, b, I);
            m(configs, b, I);
            C(configs, b, I);
            u(configs);
            r(configs, b, I);
            p(configs, edit);
            i(configs, edit);
            g(configs, I, edit);
            y(configs, I, edit);
            w(configs, I, edit);
            v(configs, I, edit);
            x(configs, I, b, sharedPreferences, edit);
            d(configs, I, sharedPreferences, edit);
            e(configs, I, edit);
            j(configs, I, edit);
            f(configs, b, I, edit);
            o(configs, b, I, edit);
            B(configs, I, edit);
            a(configs, I, edit);
            J(configs, I, edit);
            E(configs, I, edit);
            F(configs, I, edit);
            boolean z2 = I && G(configs, edit, NEED_FRAME_METRICS, jd0.A);
            jd0.A = z2;
            e30.a("ApmOrangeListener", NEED_FRAME_METRICS, Boolean.valueOf(z2));
            if (I && !G(configs, edit, NEED_ROLLBACK_FPS, jd0.B)) {
                z = false;
                jd0.B = z;
                e30.a("ApmOrangeListener", NEED_ROLLBACK_FPS, Boolean.valueOf(z));
                boolean z3 = !I && G(configs, edit, NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE, rj2.j);
                rj2.j = z3;
                e30.a("ApmOrangeListener", NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE, Boolean.valueOf(z3));
                boolean z4 = !I && G(configs, edit, NEED_FIRST_FRAME, jd0.D);
                jd0.D = z4;
                e30.a("ApmOrangeListener", NEED_FIRST_FRAME, Boolean.valueOf(z4));
                boolean z5 = !I && H(configs, b, edit, NEXT_LAUNCH_UPLOAD_SAMPLE);
                jd0.E = z5;
                e30.a("ApmOrangeListener", NEXT_LAUNCH_UPLOAD_SAMPLE, Boolean.valueOf(z5));
                edit.apply();
            }
            z = true;
            jd0.B = z;
            e30.a("ApmOrangeListener", NEED_ROLLBACK_FPS, Boolean.valueOf(z));
            if (I) {
            }
            rj2.j = z3;
            e30.a("ApmOrangeListener", NEED_LAUNCH_VISIBLE_CALCULATE_CHANGE, Boolean.valueOf(z3));
            if (I) {
            }
            jd0.D = z4;
            e30.a("ApmOrangeListener", NEED_FIRST_FRAME, Boolean.valueOf(z4));
            if (I) {
            }
            jd0.E = z5;
            e30.a("ApmOrangeListener", NEXT_LAUNCH_UPLOAD_SAMPLE, Boolean.valueOf(z5));
            edit.apply();
        } catch (Throwable th) {
            e30.a("ApmOrangeListener", th);
        }
    }
}
