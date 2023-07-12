package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.asyncrender.C6363a;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchRenderWorkTask;
import com.taobao.android.dinamicx.config.IDXConfigInterface;
import com.taobao.android.dinamicx.eventchain.C6372b;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.log.IDXRemoteDebugLog;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.DXPerformBaselineUtil;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.monitor.IDXAppMonitor;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.script.IDXJSEngine;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.template.download.IDXDownloader;
import com.taobao.android.dinamicx.timer.DXTimerListener;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXAbTestInterface;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXRichTextImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageUrlInterface;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.bb1;
import tb.bu;
import tb.dz;
import tb.fy;
import tb.g20;
import tb.gn1;
import tb.ht;
import tb.kt;
import tb.nz;
import tb.pz;
import tb.r10;
import tb.ry;
import tb.s00;
import tb.t00;
import tb.tt;
import tb.uy;
import tb.vy;
import tb.w10;
import tb.wt;
import tb.z00;
import tb.zz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class DinamicXEngine extends C6365b {
    public static final String ENGINE_INIT_ERROR_LOG_KEY = "DinamicXInitError";
    public static final String OPEN_TRACE_KEY_RENDER_TMPL = "renderForTemplate";
    public static final int REFRESH_TYPE_LAYOUT = 1;
    public static final int REFRESH_TYPE_PARSE = 0;
    public static final String RENDER_TEMPLATE = "renderTemplateTime";
    public static final String URL_SKIP_VERSION_KEY = "skipV";
    private static boolean w;
    private static boolean x;
    private static Context y;
    private static Class<? extends IDXJSEngine> z;
    private w10 d;
    private C6363a e;
    private DXLongSparseArray<IDXDataParser> f;
    private DXLongSparseArray<IDXEventHandler> g;
    private DXLongSparseArray<IDXBuilderWidgetNode> h;
    DXRenderPipeline i;
    DXTemplateManager j;
    bu k;
    protected DXNotificationCenter l;
    C6380h m;
    kt n;
    private DXRemoteTimeInterface o;
    private uy p;
    private HashMap<String, IDXFunction> q;
    private vy r;
    private IDXJSEngine s;
    private Map<String, DXRemoteChildTemplateManager> t;
    C6372b u;
    private g20 v;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.DinamicXEngine$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ JSONObject val$data;
        final /* synthetic */ DXRenderOptions val$renderOptions;
        final /* synthetic */ DXTemplateItem val$templateItem;

        AnonymousClass1(DXRenderOptions dXRenderOptions, Context context, DXTemplateItem dXTemplateItem, JSONObject jSONObject) {
            this.val$renderOptions = dXRenderOptions;
            this.val$context = context;
            this.val$templateItem = dXTemplateItem;
            this.val$data = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DXRenderOptions dXRenderOptions = this.val$renderOptions;
                if (dXRenderOptions == null) {
                    dXRenderOptions = DXRenderOptions.DEFAULT_PRERENDER_OPTIONS;
                }
                DXRuntimeContext z = DinamicXEngine.this.z(this.val$context, null, this.val$templateItem, this.val$data, null, dXRenderOptions);
                C6363a c6363a = DinamicXEngine.this.e;
                DinamicXEngine dinamicXEngine = DinamicXEngine.this;
                c6363a.s(z, dXRenderOptions, dinamicXEngine.j, dinamicXEngine.m, dinamicXEngine.k);
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.DinamicXEngine$3  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ JSONObject val$data;
        final /* synthetic */ DXRenderOptions val$renderOptions;
        final /* synthetic */ DXTemplateItem val$templateItem;

        AnonymousClass3(DXRenderOptions dXRenderOptions, Context context, DXTemplateItem dXTemplateItem, JSONObject jSONObject) {
            this.val$renderOptions = dXRenderOptions;
            this.val$context = context;
            this.val$templateItem = dXTemplateItem;
            this.val$data = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            DXRenderOptions k;
            try {
                if (this.val$renderOptions != null) {
                    k = new DXRenderOptions.C6359b().r(1).s(this.val$renderOptions.f()).l(this.val$renderOptions.a()).u(this.val$renderOptions.h()).m(this.val$renderOptions.b()).t(this.val$renderOptions.g()).n(this.val$renderOptions.i()).o(this.val$renderOptions.j()).k();
                } else {
                    k = new DXRenderOptions.C6359b().r(1).s(4).k();
                }
                DXRuntimeContext z = DinamicXEngine.this.z(this.val$context, null, this.val$templateItem, this.val$data, null, k);
                C6363a c6363a = DinamicXEngine.this.e;
                DinamicXEngine dinamicXEngine = DinamicXEngine.this;
                c6363a.u(z, k, dinamicXEngine.j, dinamicXEngine.m, dinamicXEngine.k);
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.DinamicXEngine$4  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ DXBatchAsyncRenderCallback val$callback;
        final /* synthetic */ Context val$context;
        final /* synthetic */ boolean val$isBatch;
        final /* synthetic */ List val$items;
        final /* synthetic */ DXRenderOptions val$renderOptions;

        AnonymousClass4(DXRenderOptions dXRenderOptions, List list, Context context, DXBatchAsyncRenderCallback dXBatchAsyncRenderCallback, boolean z) {
            this.val$renderOptions = dXRenderOptions;
            this.val$items = list;
            this.val$context = context;
            this.val$callback = dXBatchAsyncRenderCallback;
            this.val$isBatch = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            DXRenderOptions dXRenderOptions = this.val$renderOptions;
            if (dXRenderOptions == null) {
                dXRenderOptions = DXBatchRenderWorkTask.prefetchOptions();
            }
            ArrayList arrayList = new ArrayList();
            for (ht htVar : this.val$items) {
                arrayList.add(DinamicXEngine.this.z(this.val$context, null, htVar.b, htVar.a, null, dXRenderOptions));
            }
            C6363a c6363a = DinamicXEngine.this.e;
            DinamicXEngine dinamicXEngine = DinamicXEngine.this;
            c6363a.h(arrayList, dXRenderOptions, dinamicXEngine.j, dinamicXEngine.m, dinamicXEngine.k, this.val$callback, this.val$isBatch);
        }
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface DXRefreshType {
    }

    public DinamicXEngine(@NonNull DXEngineConfig dXEngineConfig) {
        super(new C6367d(dXEngineConfig));
        if (dXEngineConfig == null && x()) {
            throw new RuntimeException("DXEngineConfig cannot be null");
        }
        String str = null;
        if (!w || i() == null) {
            if (!x()) {
                C6368e c6368e = new C6368e(this.b);
                C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Init", C6368e.DXError_EngineInitContextNUll);
                String str2 = !w ? "没有初始化" : "context == null";
                c6369a.e = str2;
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
                y(c6368e);
                str = str2;
            } else {
                throw new RuntimeException("DinamicX not initialize");
            }
        }
        try {
            this.c.n(this);
            this.f = new DXLongSparseArray<>(DXGlobalCenter.a);
            this.g = new DXLongSparseArray<>(DXGlobalCenter.b);
            this.h = new DXLongSparseArray<>(DXGlobalCenter.c);
            this.k = new bu();
            this.l = new DXNotificationCenter(this.a);
            DXTemplateManager s = s();
            this.j = s;
            s.m(this.a.d);
            this.m = new C6380h(this.c);
            this.i = new DXRenderPipeline(this.c, this.j);
        } catch (Throwable th) {
            C6368e c6368e2 = new C6368e(this.b);
            C6368e.C6369a c6369a2 = new C6368e.C6369a("Engine", "Engine_Init", C6368e.DXError_EngineInitException);
            c6369a2.e = "30011reason=" + str + "-" + ry.a(th);
            c6368e2.c.add(c6369a2);
            DXAppMonitor.n(c6368e2);
            ry.b(th);
            y(c6368e2);
        }
        G(false);
        q();
        p();
        v(dXEngineConfig);
        u();
        r(dXEngineConfig);
        wt.Z();
        t(dXEngineConfig);
    }

    private void D(@NonNull DXTemplateItem dXTemplateItem) {
        int i;
        dXTemplateItem.skipVersions = new ArrayList();
        if (TextUtils.isEmpty(dXTemplateItem.templateUrl)) {
            return;
        }
        char[] charArray = dXTemplateItem.templateUrl.toCharArray();
        int length = charArray.length;
        while (true) {
            length--;
            if (length < 0) {
                i = 0;
                break;
            } else if (charArray[length] == '?') {
                i = length + 1;
                break;
            }
        }
        if (i > 0) {
            StringBuilder sb = new StringBuilder();
            while (i < charArray.length) {
                if (charArray[i] == '=') {
                    if (sb.toString().equalsIgnoreCase(URL_SKIP_VERSION_KEY)) {
                        StringBuilder sb2 = new StringBuilder();
                        int i2 = i + 1;
                        while (true) {
                            if (i2 < charArray.length) {
                                if (charArray[i2] != '&') {
                                    sb2.append(charArray[i2]);
                                    i2++;
                                } else {
                                    sb.setLength(0);
                                    i = i2;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        dXTemplateItem.skipVersions.add(sb2.toString());
                    } else {
                        sb.setLength(0);
                    }
                } else {
                    sb.append(charArray[i]);
                }
                i++;
            }
        }
    }

    public static void G(boolean z2) {
        try {
            nz.b(nz.TAG, "DinamicX processWindowChanged forceChange" + z2);
            z00.d(z2);
        } catch (Exception e) {
            ry.b(e);
        }
    }

    private void S(DXTemplateItem dXTemplateItem, String str, long j, Map<String, String> map) {
        DXAppMonitor.s(0, this.b, "Engine", str, dXTemplateItem, map, j, true);
    }

    public static Context i() {
        return y;
    }

    private void p() {
        try {
            this.e = new C6363a(this.c);
        } catch (Throwable th) {
            DXAppMonitor.q(this.b, null, "AsyncRender", "Async_Render_3.0_init_Crash", C6368e.V3_ASYNC_RENDER_INIT_CRASH, ry.a(th));
        }
    }

    private void q() {
        try {
            this.n = new kt(this.c);
            if (x()) {
                bb1.a = false;
            }
        } catch (Throwable th) {
            ry.b(th);
            DXAppMonitor.q(this.b, null, "DX_BindingX", "DX_BindingX_Crash", C6368e.BINDINGX_INIT_CRASH, ry.a(th));
        }
    }

    private void r(DXEngineConfig dXEngineConfig) {
        try {
            uy uyVar = new uy();
            this.p = uyVar;
            this.c.l(uyVar);
            this.q = new HashMap<>();
            Class<? extends IDXJSEngine> cls = z;
            if (cls != null) {
                this.s = cls.newInstance();
            }
            vy vyVar = new vy(this.q, this.s);
            this.r = vyVar;
            this.c.m(vyVar);
        } catch (Throwable th) {
            ry.b(th);
            DXAppMonitor.q(this.b, null, "DX_SCRIPT", "DX_SCRIPT_ERROR", C6368e.DXSCRIPT_INIT_ERROR, ry.a(th));
        }
    }

    private DXTemplateManager s() {
        dz dzVar;
        DXTemplateManager dXTemplateManager = new DXTemplateManager(this.c, y);
        if (x()) {
            try {
                Class<?> cls = Class.forName("com.taobao.android.dinamicx.DXDevTemplateManager");
                Method method = cls.getMethod("getDXDevFileManager", new Class[0]);
                DXTemplateManager dXTemplateManager2 = null;
                if (method != null) {
                    method.setAccessible(true);
                    dzVar = (dz) method.invoke(null, new Object[0]);
                } else {
                    dzVar = null;
                }
                Method method2 = cls.getMethod("newDXDevTemplateManager", C6367d.class, Context.class);
                if (method2 != null) {
                    method2.setAccessible(true);
                    dXTemplateManager2 = (DXTemplateManager) method2.invoke(null, this.c, y);
                }
                if (dXTemplateManager2 == null || dzVar == null) {
                    return dXTemplateManager;
                }
                dz.h(dzVar);
                return dXTemplateManager2;
            } catch (Exception unused) {
                return dXTemplateManager;
            }
        }
        return dXTemplateManager;
    }

    private void t(DXEngineConfig dXEngineConfig) {
        try {
            this.v = new g20(dXEngineConfig.l() != null ? dXEngineConfig.l() : DXVideoControlConfig.j());
            if (wt.C0() && dXEngineConfig.q()) {
                this.v.a();
            }
        } catch (Throwable th) {
            DXAppMonitor.q(this.b, null, "DX_Video_Control", "DX_Video_Control_Init_Crash", C6368e.DX_VIDEO_CONTROL_INIT_CRASH, ry.a(th));
        }
    }

    private void u() {
        try {
            this.u = new C6372b(this.c);
        } catch (Throwable th) {
            ry.b(th);
            DXAppMonitor.q(this.b, null, "DX_EventChain", "DX_EventChain_Crash", C6368e.EVENTCHAIN_INIT_CRASH, ry.a(th));
        }
    }

    private void v(@NonNull DXEngineConfig dXEngineConfig) {
        try {
            this.d = new w10(dXEngineConfig.k());
        } catch (Throwable th) {
            ry.b(th);
            DXAppMonitor.q(this.b, null, "Engine", "Engine_Init", C6368e.DXERROR_ENGINE_INIT_EXCEPTION_TIMER_ERROR, ry.a(th));
        }
    }

    public static void w(@NonNull Context context, @Nullable C6376f c6376f) {
        try {
            long nanoTime = System.nanoTime();
            if (w) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                y = applicationContext;
            } else {
                y = context;
            }
            w = true;
            if (c6376f == null) {
                return;
            }
            x = c6376f.m;
            IDXRemoteDebugLog iDXRemoteDebugLog = c6376f.f;
            if (iDXRemoteDebugLog != null) {
                s00.g(iDXRemoteDebugLog);
            }
            IDXAppMonitor iDXAppMonitor = c6376f.e;
            if (iDXAppMonitor != null) {
                DXAppMonitor.j(iDXAppMonitor);
            }
            DXLongSparseArray<IDXDataParser> dXLongSparseArray = c6376f.b;
            if (dXLongSparseArray != null) {
                DXGlobalCenter.a.putAll(dXLongSparseArray);
            }
            if (y == null) {
                C6368e c6368e = new C6368e("initialize");
                C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "SDK_InitEnv", C6368e.DXError_SDKInitException);
                c6369a.e = applicationContext == null ? "applicationContext == null" : "";
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
                y(c6368e);
            }
            for (int i = 0; i < DXGlobalCenter.a.size(); i++) {
                IDXDataParser valueAt = DXGlobalCenter.a.valueAt(i);
                if ((valueAt instanceof AbstractC6375a) && !TextUtils.isEmpty(((AbstractC6375a) valueAt).getDxFunctionName())) {
                    uy.d(((AbstractC6375a) valueAt).getDxFunctionName(), (AbstractC6375a) valueAt);
                }
            }
            DXLongSparseArray<IDXEventHandler> dXLongSparseArray2 = c6376f.a;
            if (dXLongSparseArray2 != null) {
                DXGlobalCenter.b.putAll(dXLongSparseArray2);
            }
            for (int i2 = 0; i2 < DXGlobalCenter.b.size(); i2++) {
                IDXEventHandler valueAt2 = DXGlobalCenter.b.valueAt(i2);
                if ((valueAt2 instanceof AbstractC6362a) && !TextUtils.isEmpty(((AbstractC6362a) valueAt2).getDxFunctionName())) {
                    uy.d(((AbstractC6362a) valueAt2).getDxFunctionName(), (AbstractC6362a) valueAt2);
                }
            }
            DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray3 = c6376f.c;
            if (dXLongSparseArray3 != null) {
                DXGlobalCenter.c.putAll(dXLongSparseArray3);
            }
            IDXDownloader iDXDownloader = c6376f.d;
            if (iDXDownloader != null) {
                DXGlobalCenter.d = iDXDownloader;
            }
            IDXWebImageInterface iDXWebImageInterface = c6376f.g;
            if (iDXWebImageInterface != null) {
                DXGlobalCenter.e = iDXWebImageInterface;
            }
            IDXRichTextImageInterface iDXRichTextImageInterface = c6376f.i;
            if (iDXRichTextImageInterface != null) {
                DXGlobalCenter.f = iDXRichTextImageInterface;
            }
            IDXAbTestInterface iDXAbTestInterface = c6376f.q;
            if (iDXAbTestInterface != null) {
                DXGlobalCenter.g = iDXAbTestInterface;
            }
            IDXConfigInterface iDXConfigInterface = c6376f.j;
            if (iDXConfigInterface != null) {
                DXGlobalCenter.j = iDXConfigInterface;
            }
            IDXWebImageInterface iDXWebImageInterface2 = c6376f.h;
            if (iDXWebImageInterface2 != null) {
                DXGlobalCenter.i = iDXWebImageInterface2;
            }
            IDXHardwareInterface iDXHardwareInterface = c6376f.r;
            if (iDXHardwareInterface != null) {
                DXGlobalCenter.h = iDXHardwareInterface;
            }
            wt.K0();
            int i3 = c6376f.o;
            if (i3 != 0) {
                z00.a(i3);
            }
            IDXDarkModeInterface iDXDarkModeInterface = c6376f.k;
            if (iDXDarkModeInterface != null) {
                DXDarkModeCenter.b = iDXDarkModeInterface;
            }
            Class<? extends IDXJSEngine> cls = c6376f.p;
            if (cls != null) {
                z = cls;
            }
            IDXElderInterface iDXElderInterface = c6376f.s;
            if (iDXElderInterface != null) {
                C6366c.a = iDXElderInterface;
            }
            IDXElderTextSizeStrategy iDXElderTextSizeStrategy = c6376f.t;
            if (iDXElderTextSizeStrategy != null) {
                C6366c.b = new fy(iDXElderTextSizeStrategy);
            }
            IDXWebImageUrlInterface iDXWebImageUrlInterface = c6376f.u;
            if (iDXWebImageUrlInterface != null) {
                DXGlobalCenter.k = iDXWebImageUrlInterface;
            }
            DXDarkModeCenter.a = c6376f.n;
            Log.e(nz.TAG, "DX初始化完成，时间为：" + (System.nanoTime() - nanoTime));
        } catch (Throwable th) {
            try {
                if (x()) {
                    th.printStackTrace();
                }
                C6368e c6368e2 = new C6368e("initialize");
                C6368e.C6369a c6369a2 = new C6368e.C6369a("Engine", "Engine_InitEnv", 30001);
                c6369a2.e = ry.a(th);
                c6368e2.c.add(c6369a2);
                DXAppMonitor.n(c6368e2);
                y(c6368e2);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean x() {
        return x;
    }

    private static void y(C6368e c6368e) {
        Log.e(ENGINE_INIT_ERROR_LOG_KEY, c6368e.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DXRuntimeContext z(Context context, DXRootView dXRootView, DXTemplateItem dXTemplateItem, JSONObject jSONObject, DXRenderPipeline dXRenderPipeline, DXRenderOptions dXRenderOptions) {
        DXRuntimeContext dXRuntimeContext = new DXRuntimeContext(this.c);
        dXRuntimeContext.contextWeakReference = new WeakReference<>(context);
        dXRuntimeContext.parserMap = this.f;
        dXRuntimeContext.eventHandlerMapWeakReference = new WeakReference<>(this.g);
        dXRuntimeContext.widgetNodeMap = this.h;
        dXRuntimeContext.dxControlEventCenterWeakReference = new WeakReference<>(this.k);
        dXRuntimeContext.dxRenderPipelineWeakReference = new WeakReference<>(dXRenderPipeline);
        dXRuntimeContext.dxNotificationCenterWeakReference = new WeakReference<>(this.l);
        dXRuntimeContext.dxTemplateItem = dXTemplateItem;
        dXRuntimeContext.rootViewWeakReference = new WeakReference<>(dXRootView);
        dXRuntimeContext.setData(jSONObject);
        C6368e c6368e = new C6368e(this.b);
        dXRuntimeContext.dxError = c6368e;
        c6368e.b = dXTemplateItem;
        dXRuntimeContext.refreshType = 0;
        if (dXRenderOptions != null) {
            dXRuntimeContext.dxUserContext = dXRenderOptions.c();
            dXRenderOptions.g();
            dXRuntimeContext.renderType = dXRenderOptions.e();
            dXRuntimeContext.rootWidthSpec = dXRenderOptions.h();
            dXRuntimeContext.rootHeightSpec = dXRenderOptions.b();
        }
        return dXRuntimeContext;
    }

    public void A() {
        C6363a c6363a = this.e;
        if (c6363a != null) {
            c6363a.r();
        }
        kt ktVar = this.n;
        if (ktVar != null && ktVar.g() != null) {
            this.n.g().d();
        }
        w10 w10Var = this.d;
        if (w10Var != null) {
            w10Var.d();
        }
        g20 g20Var = this.v;
        if (g20Var != null) {
            g20Var.destroy();
        }
        e();
        IDXJSEngine iDXJSEngine = this.s;
        if (iDXJSEngine != null) {
            try {
                iDXJSEngine.destroy();
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    public void B(DXRootView dXRootView) {
        if (dXRootView == null) {
            return;
        }
        dXRootView.onRootViewAppear(-1);
    }

    public void C(DXRootView dXRootView) {
        if (dXRootView == null) {
            return;
        }
        dXRootView.onRootViewDisappear(-1);
    }

    public void E(DXRootView dXRootView, Object obj) {
        DXWidgetNode expandWidgetNode;
        JSONObject jSONObject;
        DXWidgetNode expandWidgetNode2;
        JSONObject jSONObject2;
        kt ktVar;
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject3 = (JSONObject) obj;
                String string = jSONObject3.getString("type");
                if ("BNDX".equalsIgnoreCase(string) && (ktVar = this.n) != null) {
                    ktVar.m(dXRootView, jSONObject3);
                } else if (!"General".equalsIgnoreCase(string)) {
                    if (dXRootView == null || (expandWidgetNode = dXRootView.getExpandWidgetNode()) == null || (jSONObject = jSONObject3.getJSONObject("params")) == null) {
                        return;
                    }
                    String string2 = jSONObject.getString("targetId");
                    pz pzVar = new pz(-1747756056147111305L);
                    pzVar.j(jSONObject);
                    pzVar.k(string2);
                    pzVar.l(string);
                    DXWidgetNode queryWidgetNodeByUserId = expandWidgetNode.queryWidgetNodeByUserId(string2);
                    if (queryWidgetNodeByUserId == null) {
                        expandWidgetNode.sendBroadcastEvent(pzVar);
                    } else {
                        queryWidgetNodeByUserId.postEvent(pzVar);
                    }
                } else if (dXRootView == null || (expandWidgetNode2 = dXRootView.getExpandWidgetNode()) == null || (jSONObject2 = jSONObject3.getJSONObject("params")) == null) {
                } else {
                    String string3 = jSONObject2.getString("targetId");
                    if (TextUtils.isEmpty(string3) && jSONObject2.containsKey("target")) {
                        string3 = jSONObject2.getString("target");
                    }
                    String string4 = jSONObject2.getString("method");
                    pz pzVar2 = new pz(-1747756056147111305L);
                    pzVar2.j(jSONObject2);
                    pzVar2.k(string3);
                    pzVar2.l(string);
                    pzVar2.i(string4);
                    DXWidgetNode queryWidgetNodeByUserId2 = expandWidgetNode2.queryWidgetNodeByUserId(string3);
                    if (queryWidgetNodeByUserId2 != null && queryWidgetNodeByUserId2.getReferenceNode() != null) {
                        queryWidgetNodeByUserId2.postEvent(pzVar2);
                    } else {
                        expandWidgetNode2.sendBroadcastEvent(pzVar2);
                    }
                }
            }
        } catch (Throwable th) {
            ry.b(th);
            String a = a();
            if (TextUtils.isEmpty(a)) {
                a = r10.DB_NAME;
            }
            DXAppMonitor.q(a, null, "Engine", "Engine_Post_Message", C6368e.ENGINE_POST_MSG_CRASH, ry.a(th));
        }
    }

    public void F(DXRuntimeContext dXRuntimeContext, final DXRenderOptions dXRenderOptions, final View view, @Nullable final DXAsyncRenderCallback<DXRuntimeContext> dXAsyncRenderCallback) {
        if (this.e == null) {
            return;
        }
        final DXWidgetNode a = tt.a(dXRuntimeContext, dXRuntimeContext.widgetNode);
        if (wt.r0()) {
            a.setParentWidget(dXRuntimeContext.widgetNode.getParentWidget());
        }
        this.e.F(new Runnable() { // from class: com.taobao.android.dinamicx.DinamicXEngine.2
            @Override // java.lang.Runnable
            public void run() {
                DXRenderOptions k;
                try {
                    if (dXRenderOptions != null) {
                        k = new DXRenderOptions.C6359b().r(1).s(dXRenderOptions.f()).l(dXRenderOptions.a()).u(dXRenderOptions.h()).m(dXRenderOptions.b()).t(dXRenderOptions.g()).n(dXRenderOptions.i()).o(dXRenderOptions.j()).k();
                    } else {
                        k = new DXRenderOptions.C6359b().r(1).s(4).k();
                    }
                    DXRuntimeContext dXRuntimeContext2 = a.getDXRuntimeContext();
                    DinamicXEngine.this.e.v(dXRuntimeContext2, k, null, view, dXAsyncRenderCallback);
                } catch (Throwable th) {
                    ry.b(th);
                }
            }
        });
    }

    public void H(String str, IDXFunction iDXFunction) {
        if (TextUtils.isEmpty(str) || iDXFunction == null) {
            return;
        }
        this.q.put(str, iDXFunction);
    }

    public void I(DXRootView dXRootView, DXRootView.AbstractC6360a abstractC6360a) {
        if (dXRootView == null) {
            return;
        }
        dXRootView.registerDXRootViewLifeCycle(abstractC6360a);
    }

    public boolean J(long j, IDXDataParser iDXDataParser) {
        DXLongSparseArray<IDXDataParser> dXLongSparseArray;
        if (j == 0 || iDXDataParser == null || (dXLongSparseArray = this.f) == null) {
            return false;
        }
        dXLongSparseArray.put(j, iDXDataParser);
        if (iDXDataParser instanceof AbstractC6375a) {
            AbstractC6375a abstractC6375a = (AbstractC6375a) iDXDataParser;
            if (TextUtils.isEmpty(abstractC6375a.getDxFunctionName())) {
                return true;
            }
            H(abstractC6375a.getDxFunctionName(), abstractC6375a);
            return true;
        }
        return true;
    }

    public boolean K(long j, IDXEventHandler iDXEventHandler) {
        DXLongSparseArray<IDXEventHandler> dXLongSparseArray;
        if (j == 0 || (dXLongSparseArray = this.g) == null || iDXEventHandler == null) {
            return false;
        }
        dXLongSparseArray.put(j, iDXEventHandler);
        return true;
    }

    public void L(IDXNotificationListener iDXNotificationListener) {
        if (iDXNotificationListener != null) {
            try {
                DXNotificationCenter dXNotificationCenter = this.l;
                if (dXNotificationCenter != null) {
                    dXNotificationCenter.g(iDXNotificationListener);
                }
            } catch (Throwable th) {
                C6368e c6368e = new C6368e(this.a.a);
                C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Register_Notification", C6368e.DXERROR_REGISTER_NOTIFICATION_CRASH);
                c6369a.e = ry.a(th);
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
            }
        }
    }

    public void M(DXTimerListener dXTimerListener, long j) {
        this.d.f(dXTimerListener, j);
    }

    public boolean N(long j, IDXBuilderWidgetNode iDXBuilderWidgetNode) {
        DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray;
        if (j == 0 || iDXBuilderWidgetNode == null || (dXLongSparseArray = this.h) == null) {
            return false;
        }
        dXLongSparseArray.put(j, iDXBuilderWidgetNode);
        return true;
    }

    public t00<DXRootView> O(Context context, JSONObject jSONObject, @NonNull DXRootView dXRootView, int i, int i2, Object obj) {
        DXTemplateItem dXTemplateItem;
        try {
            dXTemplateItem = dXRootView.dxTemplateItem;
        } catch (Throwable th) {
            th = th;
            dXTemplateItem = null;
        }
        try {
            return P(context, dXRootView, dXTemplateItem, jSONObject, -1, new DXRenderOptions.C6359b().u(i).m(i2).p(obj).k());
        } catch (Throwable th2) {
            th = th2;
            ry.b(th);
            C6368e c6368e = new C6368e(this.b);
            c6368e.b = dXTemplateItem;
            C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DXError_EngineRenderException);
            c6369a.e = ry.a(th);
            c6368e.c.add(c6369a);
            DXAppMonitor.n(c6368e);
            return null;
        }
    }

    public t00<DXRootView> P(Context context, DXRootView dXRootView, DXTemplateItem dXTemplateItem, JSONObject jSONObject, int i, DXRenderOptions dXRenderOptions) {
        String str;
        String str2;
        FalcoContainerSpan falcoContainerSpan;
        String str3 = "data is not null";
        try {
            if (dXTemplateItem == null) {
                String str4 = this.b;
                s00.c(str4, "renderTemplate", null, null, "DXTemplate 为空 + positon=" + i);
                t00<DXRootView> t00Var = new t00<>();
                t00Var.f(null);
                C6368e c6368e = new C6368e(this.b);
                C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DXERROR_ENGINERENDER_TEMPLATE_NULL);
                StringBuilder sb = new StringBuilder();
                sb.append("position=");
                sb.append(i);
                sb.append(gn1.KEY_H5_DATA_PREFIX);
                if (jSONObject == null) {
                    str3 = "data is null";
                }
                sb.append(str3);
                c6369a.e = sb.toString();
                c6368e.c.add(c6369a);
                t00Var.d(c6368e);
                return t00Var;
            } else if (!dXTemplateItem.checkValid()) {
                t00<DXRootView> t00Var2 = new t00<>();
                t00Var2.f(null);
                C6368e c6368e2 = new C6368e(this.b);
                C6368e.C6369a c6369a2 = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DXERROR_ENGINERENDER_INVALID_PARAMS);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("参数校验不合法 position=");
                sb2.append(i);
                sb2.append(gn1.KEY_H5_DATA_PREFIX);
                if (jSONObject == null) {
                    str3 = "data is null";
                }
                sb2.append(str3);
                c6369a2.e = sb2.toString();
                c6368e2.c.add(c6369a2);
                t00Var2.d(c6368e2);
                DXAppMonitor.n(c6368e2);
                return t00Var2;
            } else {
                DXTraceUtil.b("DX-RenderTemplate", " : ", dXTemplateItem.getIdentifier());
                long nanoTime = System.nanoTime();
                DXRenderOptions dXRenderOptions2 = dXRenderOptions == null ? DXRenderOptions.DEFAULT_RENDER_OPTIONS : dXRenderOptions;
                DXRuntimeContext z2 = z(context, dXRootView, dXTemplateItem, jSONObject, this.i, dXRenderOptions2);
                if (dXRenderOptions2.d() == null || !this.a.n()) {
                    falcoContainerSpan = null;
                } else {
                    FalcoContainerSpan e = zz.e(dXRenderOptions2.d(), "DX", RENDER_TEMPLATE);
                    zz.q(e, OPEN_TRACE_KEY_RENDER_TMPL, String.format("templateInfo:name:%s,version:%s", dXTemplateItem.name, Long.valueOf(dXTemplateItem.version)));
                    z2.setOpenTracerSpan(e);
                    falcoContainerSpan = e;
                }
                C6363a c6363a = this.e;
                if (c6363a != null) {
                    c6363a.i(z2);
                }
                t00<DXRootView> q = this.i.q(dXRootView, z2, i, dXRenderOptions2);
                if (x() && q != null && q.c()) {
                    nz.g(nz.TAG, q.a().toString());
                }
                long nanoTime2 = System.nanoTime() - nanoTime;
                if (x()) {
                    q.e(z2.getDxPerformInfo());
                    q.b().g = ((float) nanoTime2) / 1000000.0f;
                }
                z2.putPerformTrackerData(RENDER_TEMPLATE, String.valueOf(((float) nanoTime2) / 1000000.0f));
                str = "Engine_Render";
                str2 = "Engine";
                try {
                    S(dXTemplateItem, "Engine_Render", nanoTime2, z2.getDxPerformTrackerData());
                    zz.l(falcoContainerSpan);
                    DXTraceUtil.c();
                    DXPerformBaselineUtil.a("DX-RenderTemplate", nanoTime2, dXTemplateItem);
                    return q;
                } catch (Throwable th) {
                    th = th;
                    ry.b(th);
                    C6368e c6368e3 = new C6368e(this.b);
                    c6368e3.b = dXTemplateItem;
                    C6368e.C6369a c6369a3 = new C6368e.C6369a(str2, str, C6368e.DXError_EngineRenderException);
                    c6369a3.e = ry.a(th);
                    c6368e3.c.add(c6369a3);
                    DXAppMonitor.n(c6368e3);
                    DXTraceUtil.c();
                    return null;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str = "Engine_Render";
            str2 = "Engine";
        }
    }

    public t00<DXRootView> Q(DXRootView dXRootView, JSONObject jSONObject) {
        if (dXRootView != null) {
            try {
                if (dXRootView.getContext() != null && dXRootView.dxTemplateItem != null) {
                    return O(dXRootView.getContext(), jSONObject, dXRootView, z00.f(), z00.e(), null);
                }
            } catch (Throwable th) {
                if (x()) {
                    th.printStackTrace();
                }
                C6368e c6368e = new C6368e(this.b);
                if (dXRootView != null) {
                    c6368e.b = dXRootView.dxTemplateItem;
                }
                C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DXError_EngineRenderException);
                c6369a.e = ry.a(th);
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
                return new t00<>(c6368e);
            }
        }
        C6368e c6368e2 = new C6368e(this.b);
        C6368e.C6369a c6369a2 = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DXError_EngineRenderException);
        c6369a2.e = "dxRootView == null || dxRootView.getContext() == null || dxRootView.dxTemplateItem == null";
        c6368e2.c.add(c6369a2);
        DXAppMonitor.n(c6368e2);
        return new t00<>(c6368e2);
    }

    public void R() {
        C6380h c6380h = this.m;
        if (c6380h != null) {
            c6380h.d();
        }
        C6363a c6363a = this.e;
        if (c6363a != null) {
            c6363a.w();
        }
        C6372b o = o();
        if (o != null) {
            o.l();
        }
    }

    public void T(DXTimerListener dXTimerListener) {
        this.d.h(dXTimerListener);
    }

    public void e() {
        C6372b c6372b = this.u;
        if (c6372b != null) {
            c6372b.c();
        }
    }

    public t00<DXRootView> f(Context context, DXTemplateItem dXTemplateItem) {
        DXRootView dXRootView = new DXRootView(context);
        dXRootView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        dXRootView.dxTemplateItem = dXTemplateItem;
        dXRootView.setBindingXManagerWeakReference(this.n);
        return new t00<>(dXRootView);
    }

    public void g(List<DXTemplateItem> list) {
        try {
            this.j.f(list);
        } catch (Throwable th) {
            if (x()) {
                th.printStackTrace();
            }
            C6368e c6368e = new C6368e(this.b);
            C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Download", C6368e.DXError_EngineDownloadException);
            c6369a.e = "downLoadTemplates error " + ry.a(th);
            c6368e.c.add(c6369a);
            DXAppMonitor.n(c6368e);
        }
    }

    public DXTemplateItem h(DXTemplateItem dXTemplateItem) {
        if (dXTemplateItem == null) {
            return null;
        }
        try {
            if (wt.B0()) {
                D(dXTemplateItem);
            }
            long nanoTime = System.nanoTime();
            DXTemplateItem h = this.j.h(dXTemplateItem);
            long nanoTime2 = System.nanoTime() - nanoTime;
            S(dXTemplateItem, "Engine_Fetch", nanoTime2, DXAppMonitor.g((float) nanoTime2));
            return h;
        } catch (Throwable th) {
            if (x()) {
                th.printStackTrace();
            }
            C6368e c6368e = new C6368e(this.b);
            C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Fetch", C6368e.DXError_EngineFetchException);
            c6368e.b = dXTemplateItem;
            c6369a.e = ry.a(th);
            c6368e.c.add(c6369a);
            DXAppMonitor.n(c6368e);
            return null;
        }
    }

    public IDXJSEngine j() {
        return this.s;
    }

    @Nullable
    public C6363a k() {
        return this.e;
    }

    public Map<String, DXRemoteChildTemplateManager> l() {
        if (this.t == null) {
            this.t = new ConcurrentHashMap();
        }
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DXRemoteTimeInterface m() {
        return this.o;
    }

    @Nullable
    public g20 n() {
        return this.v;
    }

    public C6372b o() {
        return this.u;
    }
}
