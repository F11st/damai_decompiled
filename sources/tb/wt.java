package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IDXHardwareInterface;
import com.taobao.android.dinamicx.config.IConfigChangeListener;
import com.taobao.android.dinamicx.config.IDXConfigInterface;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wt {
    private static boolean A = true;
    private static List<String> B = null;
    private static List<String> C = null;
    private static List<String> D = null;
    private static boolean E = true;
    private static boolean F = true;
    private static boolean G = true;
    private static boolean H = true;
    private static boolean I = false;
    private static boolean J = true;
    private static boolean K = true;
    private static List<String> L = new ArrayList();
    private static int M = 150;
    private static int N = 500;
    private static boolean O = true;
    private static boolean P = true;
    private static boolean Q = false;
    private static List<String> a = null;
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static List<String> e = null;
    private static List<String> f = null;
    private static boolean g = true;
    private static boolean h = true;
    private static boolean i = true;
    private static boolean j = true;
    private static boolean k = false;
    private static boolean l = true;
    private static boolean m = true;
    private static int n = 5;
    private static boolean o = true;
    private static List<String> p = null;
    private static boolean q = true;
    private static boolean r = false;
    private static List<String> s = null;
    private static boolean t = true;
    private static List<String> u = null;
    private static boolean v = true;
    private static boolean w = true;
    private static boolean x = true;
    private static boolean y = true;
    private static boolean z = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wt$a */
    /* loaded from: classes11.dex */
    public static class C9882a implements IConfigChangeListener {
        final /* synthetic */ IDXConfigInterface a;

        C9882a(IDXConfigInterface iDXConfigInterface) {
            this.a = iDXConfigInterface;
        }

        @Override // com.taobao.android.dinamicx.config.IConfigChangeListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            if ("group_dinamicX_common_android".equals(str)) {
                try {
                    List unused = wt.a = Arrays.asList(this.a.getConfig(str, "dinamic_image_impl", "").trim().split(","));
                    boolean unused2 = wt.b = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_skip_version_impl", "true").trim());
                    wt.a0();
                    List unused3 = wt.e = Arrays.asList(this.a.getConfig(str, "dinamic_enable_doDiff_new", "").trim().split(","));
                    boolean unused4 = wt.g = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_enable_remote_download_distinct", "true").trim());
                    boolean unused5 = wt.i = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_enable_event_chain_full_trace", "true").trim());
                    boolean unused6 = wt.j = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_video_control_switch", "true").trim());
                    boolean unused7 = wt.k = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_remove_all_children", "false").trim());
                    boolean unused8 = wt.o = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_recycler_layout_prefetch_switch", "true").trim());
                    boolean unused9 = wt.l = Boolean.parseBoolean(this.a.getConfig(str, "open_recyclerlayout_part_refresh", "true").trim());
                    boolean unused10 = wt.m = Boolean.parseBoolean(this.a.getConfig(str, "open_layout_list_data_part_refresh", "true").trim());
                    List unused11 = wt.p = Arrays.asList(this.a.getConfig(str, "dinamic_measure_root_error_report_biz", "detail2").trim().split(","));
                    boolean unused12 = wt.q = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_image_decide_url", "true").trim());
                    wt.f(Boolean.parseBoolean(this.a.getConfig(str, "dinamic_new_order_skip_auto_size", "true").trim()));
                    int unused13 = wt.n = Integer.parseInt(this.a.getConfig(str, "dinamic_recycler_layout_sticky_offset", "5").trim());
                    boolean unused14 = wt.h = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_enable_parser_gone_to_visible", "true").trim());
                    List unused15 = wt.s = Arrays.asList(this.a.getConfig(str, "dinamic_dx_expr_vm_biz_list", "guangguang").trim().split(","));
                    boolean unused16 = wt.r = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_open_bind_source_widget", "false").trim());
                    boolean unused17 = wt.t = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_enable_widget_view_create_null", "true").trim());
                    boolean unused18 = wt.v = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_dx_viewpager_onchange", "true").trim());
                    List unused19 = wt.u = Arrays.asList(this.a.getConfig(str, "dinamic_dx_new_query_node_by_id_white_biz_list", "subscription").trim().split(","));
                    boolean unused20 = wt.w = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_open_fix_tmall_temp_scroll", "true").trim());
                    boolean unused21 = wt.x = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_set_expand_widget_pipeline", "true").trim());
                    boolean unused22 = wt.y = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_event_chain_optimize", "true").trim());
                    boolean unused23 = wt.z = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_diff_rate_fix", "true").trim());
                    boolean unused24 = wt.A = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_fix_tab_state", "true").trim());
                    List unused25 = wt.B = Arrays.asList(this.a.getConfig(str, "dinamic_rl_load_more_gone_black_biz_list", "").trim().split(","));
                    List unused26 = wt.C = Arrays.asList(this.a.getConfig(str, "dinamic_video_control_expand_black_biz_list", "guess,homepage,mytaobao").trim().split(","));
                    wt.v(Boolean.parseBoolean(this.a.getConfig(str, "dinamic_fix_image_api_sequence", "true").trim()));
                    List unused27 = wt.D = Arrays.asList(this.a.getConfig(str, "dinamic_fix_nested_scroll_state_black_biz_list", "").trim().split(","));
                    boolean unused28 = wt.E = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_recyclerlayout_use_new_interface", "true").trim());
                    boolean unused29 = wt.F = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_textview_crash_fix", "true").trim());
                    boolean unused30 = wt.G = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_renderManagerIndexOut", "true").trim());
                    boolean unused31 = wt.I = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_useNewEventChainContext", "false").trim());
                    boolean unused32 = wt.H = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_use_new_eventchain_list", "true").trim());
                    boolean unused33 = wt.J = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_fix_rl_prefetch_data_index", "true").trim());
                    boolean unused34 = wt.O = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_fix_scroller_appear_widget", "true").trim());
                    boolean unused35 = wt.P = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_fix_event_chain_data_parser_reflection", "true").trim());
                    boolean unused36 = wt.K = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_checkEventChainExecuteThread", "true").trim());
                    boolean unused37 = wt.Q = Boolean.parseBoolean(this.a.getConfig(str, "dinamic_needThrowException", "false").trim());
                } catch (Throwable th) {
                    ry.b(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wt$b */
    /* loaded from: classes11.dex */
    public static class C9883b implements IConfigChangeListener {
        final /* synthetic */ IDXConfigInterface a;

        C9883b(IDXConfigInterface iDXConfigInterface) {
            this.a = iDXConfigInterface;
        }

        @Override // com.taobao.android.dinamicx.config.IConfigChangeListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            if ("group_dinamicx_textview".equals(str)) {
                boolean unused = wt.c = Boolean.parseBoolean(this.a.getConfig("group_dinamicx_textview", "dx_textview_font_ut_switch", "false"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wt$c */
    /* loaded from: classes11.dex */
    public static class C9884c implements IConfigChangeListener {
        final /* synthetic */ IDXConfigInterface a;

        C9884c(IDXConfigInterface iDXConfigInterface) {
            this.a = iDXConfigInterface;
        }

        @Override // com.taobao.android.dinamicx.config.IConfigChangeListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            if ("group_dinamicx_elder".equals(str)) {
                try {
                    List unused = wt.f = Arrays.asList(this.a.getConfig(str, "dinamic_elder_white_list", ay1.KEY_MODULE_NAME).trim().split(","));
                } catch (Throwable th) {
                    ry.b(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wt$d */
    /* loaded from: classes11.dex */
    public static class C9885d implements IConfigChangeListener {
        final /* synthetic */ IDXConfigInterface a;

        C9885d(IDXConfigInterface iDXConfigInterface) {
            this.a = iDXConfigInterface;
        }

        @Override // com.taobao.android.dinamicx.config.IConfigChangeListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            if ("group_dinamicx_image_corner".equals(str)) {
                try {
                    wt.L(Boolean.parseBoolean(this.a.getConfig(str, "dinamic_fix_image_corner", "false").trim()));
                } catch (Throwable th) {
                    ry.b(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.wt$e */
    /* loaded from: classes11.dex */
    public static class C9886e implements IConfigChangeListener {
        final /* synthetic */ IDXConfigInterface a;

        C9886e(IDXConfigInterface iDXConfigInterface) {
            this.a = iDXConfigInterface;
        }

        @Override // com.taobao.android.dinamicx.config.IConfigChangeListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            if ("group_dinamicx_rl_mem_perf".equals(str)) {
                try {
                    List unused = wt.L = Arrays.asList(this.a.getConfig(str, "dinamic_rl_mem_perf_white_list", "").trim().split(","));
                    int unused2 = wt.M = Integer.parseInt(this.a.getConfig(str, "dinamic_rl_mem_perf_low_device_count", "150").trim());
                    int unused3 = wt.N = Integer.parseInt(this.a.getConfig(str, "dinamic_rl_mem_perf_high_device_count", "500").trim());
                } catch (Throwable th) {
                    ry.b(th);
                }
            }
        }
    }

    public static boolean A0() {
        return l;
    }

    public static boolean B0() {
        return b;
    }

    public static boolean C0() {
        return j;
    }

    public static boolean D0() {
        return k;
    }

    public static boolean E0() {
        return t;
    }

    public static boolean F0() {
        return x;
    }

    public static boolean G0() {
        return F;
    }

    public static boolean H0() {
        return c;
    }

    public static boolean I0() {
        return d;
    }

    public static boolean J0(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (C == null) {
            ArrayList arrayList = new ArrayList();
            C = arrayList;
            arrayList.add("guess");
            C.add("homepage");
            C.add("mytaobao");
        }
        return !C.contains(str);
    }

    public static void K0() {
        IDXConfigInterface b2 = DXGlobalCenter.b();
        if (b2 == null) {
            return;
        }
        b2.registerListener(new String[]{"group_dinamicX_common_android"}, new C9882a(b2), true);
        b2.registerListener(new String[]{"group_dinamicx_textview"}, new C9883b(b2), true);
        b2.registerListener(new String[]{"group_dinamicx_elder"}, new C9884c(b2), true);
        b2.registerListener(new String[]{"group_dinamicx_image_corner"}, new C9885d(b2), true);
        b2.registerListener(new String[]{"group_dinamicx_rl_mem_perf"}, new C9886e(b2), true);
    }

    static /* synthetic */ boolean L(boolean z2) {
        return z2;
    }

    public static boolean L0() {
        return I;
    }

    public static boolean M0() {
        return H;
    }

    public static boolean N0(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || a == null) {
            return false;
        }
        return a.contains(dXRuntimeContext.getBizType());
    }

    public static boolean O0() {
        return E;
    }

    public static boolean P0(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getEngineContext() == null) {
            return false;
        }
        return dXRuntimeContext.getEngineContext().i();
    }

    public static boolean Q0(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = L) == null || list.isEmpty()) {
            return false;
        }
        return L.contains(str);
    }

    public static boolean U() {
        return K;
    }

    private static Map<String, Set<Object>> V(String str) {
        ConcurrentHashMap concurrentHashMap = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            if (parseObject != null || parseObject.size() > 0) {
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                try {
                    for (String str2 : parseObject.keySet()) {
                        JSONArray jSONArray = parseObject.getJSONArray(str2);
                        if (jSONArray != null && jSONArray.size() > 0) {
                            concurrentHashMap2.put(str2, new HashSet(jSONArray));
                        }
                    }
                    return concurrentHashMap2;
                } catch (Throwable th) {
                    th = th;
                    concurrentHashMap = concurrentHashMap2;
                    nz.g("DXConfigCenter", "convertToMapSet error" + th.getMessage());
                    return concurrentHashMap;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Set<String> W(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            List parseArray = JSON.parseArray(str, String.class);
            if (parseArray == null || parseArray.size() <= 0) {
                return null;
            }
            return new HashSet(parseArray);
        } catch (Throwable th) {
            nz.g("DXConfigCenter", "convertToStringSet error" + th.getMessage());
            return null;
        }
    }

    public static int X() {
        try {
            IDXHardwareInterface c2 = DXGlobalCenter.c();
            if ((c2 != null ? c2.getDeviceLevel() : -1) == 2) {
                return M;
            }
            return N;
        } catch (Exception e2) {
            ry.b(e2);
            return N;
        }
    }

    public static int Y() {
        return n;
    }

    public static void Z() {
        try {
            if (DXGlobalCenter.b() != null) {
                Boolean.parseBoolean(DXGlobalCenter.b().getConfig("group_dinamicx_textview", "dx_textview_font_ut_switch", "false"));
                a0();
            }
        } catch (Throwable th) {
            if (DinamicXEngine.x()) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a0() {
        IDXConfigInterface b2 = DXGlobalCenter.b();
        if (b2 == null) {
            return;
        }
        boolean parseBoolean = Boolean.parseBoolean(b2.getConfig("group_dinamicX_common_android", "dx_textview_font_switch", "false"));
        Map<String, Set<Object>> V = V(b2.getConfig("group_dinamicX_common_android", "dx_textview_font_config", ""));
        Map<String, Set<Object>> V2 = V(b2.getConfig("group_dinamicX_common_android", "dx_textview_font_rom_config", ""));
        Set<String> W = W(b2.getConfig("group_dinamicX_common_android", "dx_textview_font_phone_config", ""));
        boolean z2 = true;
        if (parseBoolean) {
            d = true;
            return;
        }
        if (W != null && (W.contains(lm1.a()) || W.contains("ALL"))) {
            if (V2 != null && V2.size() > 0) {
                if (V2.containsKey(lm1.d()) && V2.get(lm1.d()).contains(lm1.e())) {
                    d = true;
                    return;
                }
            } else {
                d = true;
                return;
            }
        }
        if (V != null && V.containsKey(lm1.f()) && V.get(lm1.f()) != null) {
            Set<Object> set = V.get(lm1.f());
            if (!set.contains("ALL") && !set.contains(lm1.c())) {
                z2 = false;
            }
            d = z2;
            return;
        }
        d = false;
    }

    public static boolean b0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (u == null) {
            ArrayList arrayList = new ArrayList();
            u = arrayList;
            arrayList.add("subscription");
        }
        return u.contains(str);
    }

    public static boolean c0(String str) {
        if (str == null) {
            return false;
        }
        if (s == null) {
            ArrayList arrayList = new ArrayList();
            s = arrayList;
            arrayList.add("guangguang");
        }
        return s.contains(str);
    }

    public static boolean d0() {
        return v;
    }

    public static boolean e0() {
        return P;
    }

    static /* synthetic */ boolean f(boolean z2) {
        return z2;
    }

    public static boolean f0() {
        return i;
    }

    public static boolean g0(DXRuntimeContext dXRuntimeContext) {
        return true;
    }

    public static boolean h0() {
        return h;
    }

    public static boolean i0() {
        return g;
    }

    public static boolean j0(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return false;
        }
        if ((dXWidgetNode instanceof u10) || (dXWidgetNode instanceof DXImageSpanWidgetNode)) {
            return t;
        }
        return false;
    }

    public static boolean k0() {
        return y;
    }

    public static boolean l0() {
        return G;
    }

    public static boolean m0(String str) {
        List<String> list = f;
        if (list == null) {
            IDXConfigInterface b2 = DXGlobalCenter.b();
            if (b2 == null) {
                return false;
            }
            f = Arrays.asList(b2.getConfig("group_dinamicx_elder", "dinamic_elder_white_list", ay1.KEY_MODULE_NAME).trim().split(","));
            return false;
        }
        return list.contains(str);
    }

    public static boolean n0() {
        return Q;
    }

    public static boolean o0() {
        return r;
    }

    public static boolean p0() {
        return z;
    }

    public static boolean q0(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (D == null) {
            D = new ArrayList();
        }
        return !D.contains(str);
    }

    public static boolean r0() {
        return J;
    }

    public static boolean s0() {
        return O;
    }

    public static boolean t0() {
        return A;
    }

    public static boolean u0() {
        return w;
    }

    static /* synthetic */ boolean v(boolean z2) {
        return z2;
    }

    public static boolean v0() {
        return q;
    }

    public static boolean w0() {
        return m;
    }

    public static boolean x0(String str) {
        if (str == null) {
            return false;
        }
        if (p == null) {
            ArrayList arrayList = new ArrayList();
            p = arrayList;
            arrayList.add("detail2");
        }
        return p.contains(str);
    }

    public static boolean y0(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = B) == null || list.isEmpty()) {
            return true;
        }
        return !B.contains(str);
    }

    public static boolean z0() {
        return o;
    }
}
