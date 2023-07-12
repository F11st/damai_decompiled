package com.taobao.weex;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.adapter.ClassLoaderAdapter;
import com.taobao.weex.adapter.DefaultFoldDeviceAdapter;
import com.taobao.weex.adapter.DefaultUriAdapter;
import com.taobao.weex.adapter.DefaultWXHttpAdapter;
import com.taobao.weex.adapter.ICrashInfoReporter;
import com.taobao.weex.adapter.IDrawableLoader;
import com.taobao.weex.adapter.ITracingAdapter;
import com.taobao.weex.adapter.IWXAccessibilityRoleAdapter;
import com.taobao.weex.adapter.IWXConfigAdapter;
import com.taobao.weex.adapter.IWXFoldDeviceAdapter;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.adapter.IWXJSExceptionAdapter;
import com.taobao.weex.adapter.IWXJsFileLoaderAdapter;
import com.taobao.weex.adapter.IWXJscProcessManager;
import com.taobao.weex.adapter.IWXSoLoaderAdapter;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.appfram.navigator.IActivityNavBarSetter;
import com.taobao.weex.appfram.navigator.INavigator;
import com.taobao.weex.appfram.storage.DefaultWXStorage;
import com.taobao.weex.appfram.storage.IWXStorageAdapter;
import com.taobao.weex.appfram.websocket.IWebSocketAdapter;
import com.taobao.weex.appfram.websocket.IWebSocketAdapterFactory;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.bridge.WXModuleManager;
import com.taobao.weex.bridge.WXValidateProcessor;
import com.taobao.weex.common.WXRefreshData;
import com.taobao.weex.common.WXRuntimeException;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.common.WXWorkThreadManager;
import com.taobao.weex.performance.IApmGenerator;
import com.taobao.weex.performance.IWXAnalyzer;
import com.taobao.weex.ui.WXRenderManager;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import tb.r62;
import tb.yo0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXSDKManager {
    private static volatile WXSDKManager E;
    private static AtomicInteger F = new AtomicInteger(0);
    private Map<String, WXSDKInstance> A;
    private List<InstanceLifeCycleCallbacks> B;
    private INavigator C;
    private yo0 D;
    private final WXWorkThreadManager a;
    private WXBridgeManager b;
    WXRenderManager c;
    private IWXUserTrackAdapter d;
    private IWXImgLoaderAdapter e;
    private IWXSoLoaderAdapter f;
    private IDrawableLoader g;
    private IWXHttpAdapter h;
    private IActivityNavBarSetter i;
    private IWXAccessibilityRoleAdapter j;
    private List<IWXAnalyzer> k;
    private IApmGenerator l;
    private IWXJsFileLoaderAdapter m;
    private ICrashInfoReporter n;
    private IWXJSExceptionAdapter o;
    private IWXConfigAdapter p;
    private IWXStorageAdapter q;
    private IWXStatisticsListener r;
    private URIAdapter s;
    private ClassLoaderAdapter t;
    private IWebSocketAdapterFactory u;
    private ITracingAdapter v;
    private WXValidateProcessor w;
    private IWXJscProcessManager x;
    private IWXFoldDeviceAdapter y;
    private boolean z;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface InstanceLifeCycleCallbacks {
        void onInstanceCreated(String str);

        void onInstanceDestroyed(String str);
    }

    private WXSDKManager() {
        this(new WXRenderManager());
    }

    public static WXSDKManager v() {
        if (E == null) {
            synchronized (WXSDKManager.class) {
                if (E == null) {
                    E = new WXSDKManager();
                }
            }
        }
        return E;
    }

    public static int w(String str) {
        WXSDKInstance y = v().y(str);
        return y == null ? FeatureFactory.PRIORITY_ABOVE_NORMAL : y.getInstanceViewPortWidth();
    }

    @NonNull
    public URIAdapter A() {
        if (this.s == null) {
            this.s = new DefaultUriAdapter();
        }
        return this.s;
    }

    public WXValidateProcessor B() {
        return this.w;
    }

    public List<IWXAnalyzer> C() {
        return this.k;
    }

    public WXBridgeManager D() {
        return this.b;
    }

    public IWXFoldDeviceAdapter E() {
        if (this.y == null) {
            this.y = new DefaultFoldDeviceAdapter();
        }
        return this.y;
    }

    public IWXJscProcessManager F() {
        return this.x;
    }

    public WXRenderManager G() {
        return this.c;
    }

    public IWXStatisticsListener H() {
        return this.r;
    }

    public WXWorkThreadManager I() {
        return this.a;
    }

    public IWXConfigAdapter J() {
        return this.p;
    }

    public void K(String str) {
        this.b.initScriptsFramework(str);
    }

    public boolean L() {
        return this.z;
    }

    public void M() {
        IWXStatisticsListener iWXStatisticsListener = this.r;
        if (iWXStatisticsListener != null) {
            iWXStatisticsListener.onSDKEngineInitialize();
        }
    }

    public void N(Runnable runnable, long j) {
        this.c.postOnUiThread(WXThread.secure(runnable), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(String str, WXRefreshData wXRefreshData) {
        this.b.refreshInstance(str, wXRefreshData);
    }

    public void P(List<Map<String, Object>> list) {
        this.b.registerComponents(list);
    }

    public void Q(InstanceLifeCycleCallbacks instanceLifeCycleCallbacks) {
        if (this.B == null) {
            this.B = new ArrayList();
        }
        this.B.add(instanceLifeCycleCallbacks);
    }

    public void R(Map<String, Object> map) {
        this.b.registerModules(map);
    }

    public void S() {
        this.b.restart();
    }

    public void T(IActivityNavBarSetter iActivityNavBarSetter) {
        this.i = iActivityNavBarSetter;
    }

    public void U(String str, String str2) {
        ICrashInfoReporter iCrashInfoReporter = this.n;
        if (iCrashInfoReporter != null) {
            iCrashInfoReporter.addCrashInfo(str, str2);
        }
    }

    public void V(ICrashInfoReporter iCrashInfoReporter) {
        this.n = iCrashInfoReporter;
    }

    public void W(IWXJSExceptionAdapter iWXJSExceptionAdapter) {
        this.o = iWXJSExceptionAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(a aVar) {
        this.h = aVar.v();
        this.e = aVar.x();
        this.g = aVar.s();
        this.q = aVar.C();
        this.d = aVar.E();
        this.s = aVar.D();
        this.u = aVar.F();
        this.o = aVar.y();
        this.f = aVar.w();
        this.t = aVar.r();
        this.l = aVar.q();
        this.m = aVar.z();
        this.x = aVar.A();
        this.y = aVar.t();
    }

    public void Y(INavigator iNavigator) {
        this.C = iNavigator;
    }

    public void Z(ITracingAdapter iTracingAdapter) {
        this.v = iTracingAdapter;
    }

    @Deprecated
    public void a(String str, String str2, Map<String, Object> map) {
        this.b.callback(str, str2, map);
    }

    public void a0(IWXConfigAdapter iWXConfigAdapter) {
        this.p = iWXConfigAdapter;
    }

    @Deprecated
    public void b(String str, String str2, Map<String, Object> map, boolean z) {
        this.b.callback(str, str2, map, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(WXSDKInstance wXSDKInstance, r62 r62Var, Map<String, Object> map, String str) {
        this.c.registerInstance(wXSDKInstance);
        this.b.createInstance(wXSDKInstance.getInstanceId(), r62Var, map, str);
        List<InstanceLifeCycleCallbacks> list = this.B;
        if (list != null) {
            for (InstanceLifeCycleCallbacks instanceLifeCycleCallbacks : list) {
                instanceLifeCycleCallbacks.onInstanceCreated(wXSDKInstance.getInstanceId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        U(WXEnvironment.WEEX_CURRENT_KEY, "");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (WXUtils.isUiThread()) {
            List<InstanceLifeCycleCallbacks> list = this.B;
            if (list != null) {
                for (InstanceLifeCycleCallbacks instanceLifeCycleCallbacks : list) {
                    instanceLifeCycleCallbacks.onInstanceDestroyed(str);
                }
            }
            this.c.removeRenderStatement(str);
            this.b.destroyInstance(str);
            WXModuleManager.destroyInstanceModules(str);
            return;
        }
        throw new WXRuntimeException("[WXSDKManager] destroyInstance error");
    }

    @Deprecated
    public void e(String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        if (WXEnvironment.isApkDebugable() && Looper.getMainLooper().getThread().getId() != Thread.currentThread().getId()) {
            throw new WXRuntimeException("[WXSDKManager]  fireEvent error");
        }
        this.b.fireEventOnNode(str, str2, str3, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return String.valueOf(F.incrementAndGet());
    }

    public IWXAccessibilityRoleAdapter g() {
        return this.j;
    }

    public IActivityNavBarSetter h() {
        return this.i;
    }

    public Map<String, WXSDKInstance> i() {
        return this.A;
    }

    public IApmGenerator j() {
        return this.l;
    }

    public ClassLoaderAdapter k() {
        if (this.t == null) {
            this.t = new ClassLoaderAdapter();
        }
        return this.t;
    }

    public IDrawableLoader l() {
        return this.g;
    }

    public yo0 m() {
        if (this.D == null) {
            synchronized (this) {
                if (this.D == null) {
                    this.D = new yo0();
                }
            }
        }
        return this.D;
    }

    @NonNull
    public IWXHttpAdapter n() {
        if (this.h == null) {
            this.h = new DefaultWXHttpAdapter();
        }
        return this.h;
    }

    public IWXImgLoaderAdapter o() {
        return this.e;
    }

    public IWXJSExceptionAdapter p() {
        return this.o;
    }

    public IWXJsFileLoaderAdapter q() {
        return this.m;
    }

    public IWXSoLoaderAdapter r() {
        return this.f;
    }

    public IWXStorageAdapter s() {
        if (this.q == null) {
            Application application = WXEnvironment.sApplication;
            if (application != null) {
                this.q = new DefaultWXStorage(application);
            } else {
                WXLogUtils.e("WXStorageModule", "No Application context found,you should call WXSDKEngine#initialize() method in your application");
            }
        }
        return this.q;
    }

    public IWXUserTrackAdapter t() {
        return this.d;
    }

    @Nullable
    public IWebSocketAdapter u() {
        IWebSocketAdapterFactory iWebSocketAdapterFactory = this.u;
        if (iWebSocketAdapterFactory != null) {
            return iWebSocketAdapterFactory.createWebSocketAdapter();
        }
        return null;
    }

    public INavigator x() {
        return this.C;
    }

    @Nullable
    public WXSDKInstance y(String str) {
        if (str == null) {
            return null;
        }
        return this.c.getWXSDKInstance(str);
    }

    public ITracingAdapter z() {
        return this.v;
    }

    private WXSDKManager(WXRenderManager wXRenderManager) {
        this.y = null;
        this.z = true;
        this.c = wXRenderManager;
        this.b = WXBridgeManager.getInstance();
        this.a = new WXWorkThreadManager();
        this.k = new CopyOnWriteArrayList();
        this.A = new HashMap();
    }
}
