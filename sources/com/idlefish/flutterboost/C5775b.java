package com.idlefish.flutterboost;

import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import com.idlefish.flutterboost.C5775b;
import com.idlefish.flutterboost.C5776c;
import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import tb.bo0;
import tb.do0;

/* compiled from: Taobao */
/* renamed from: com.idlefish.flutterboost.b */
/* loaded from: classes10.dex */
public class C5775b implements Messages.NativeRouterApi, FlutterPlugin, ActivityAware {
    private static final String h = "b";
    public static final /* synthetic */ int i = 0;
    private FlutterEngine a;
    private Messages.FlutterRouterApi b;
    private FlutterBoostDelegate c;
    private Messages.C5773b d;
    private SparseArray<String> e;
    private int f = 1000;
    private HashMap<String, LinkedList<EventListener>> g = new HashMap<>();

    private void l() {
        FlutterEngine flutterEngine = this.a;
        if (flutterEngine == null || !flutterEngine.getDartExecutor().isExecutingDart()) {
            throw new RuntimeException("The engine is not ready for use. The message may be drop silently by the engine. You should check 'DartExecutor.isExecutingDart()' first!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void o(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean p(int i2, int i3, Intent intent) {
        if (this.b != null) {
            l();
            Messages.C5772a c5772a = new Messages.C5772a();
            String str = this.e.get(i2);
            this.e.remove(i2);
            if (str != null) {
                c5772a.i(str);
                if (intent != null) {
                    c5772a.g(bo0.a(intent.getExtras()));
                }
                this.b.x(c5772a, new Messages.FlutterRouterApi.Reply() { // from class: tb.yn0
                    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                    public final void reply(Object obj) {
                        C5775b.o((Void) obj);
                    }
                });
                return true;
            }
            return true;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(Void r0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(Messages.FlutterRouterApi.Reply reply, Void r1) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(Messages.FlutterRouterApi.Reply reply, Void r1) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    public void A() {
        if (this.b != null) {
            l();
            this.b.t(new Messages.C5772a(), new Messages.FlutterRouterApi.Reply() { // from class: tb.zn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    C5775b.r((Void) obj);
                }
            });
            String str = h;
            Log.v(str, "## onBackground: " + this.b);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void B(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        do0.h().b(uniqueId, flutterViewContainer);
        I(uniqueId, flutterViewContainer.getUrl(), flutterViewContainer.getUrlParams(), new Messages.FlutterRouterApi.Reply() { // from class: tb.tn0
            @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
            public final void reply(Object obj) {
                C5775b.s((Void) obj);
            }
        });
        G(uniqueId);
    }

    public void C(FlutterViewContainer flutterViewContainer) {
        String str = h;
        Log.v(str, "#onContainerCreated: " + flutterViewContainer.getUniqueId());
        do0.h().c(flutterViewContainer.getUniqueId(), flutterViewContainer);
        if (do0.h().e() == 1) {
            FlutterBoost.h().d(0);
        }
    }

    public void D(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        J(uniqueId, new Messages.FlutterRouterApi.Reply() { // from class: tb.wn0
            @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
            public final void reply(Object obj) {
                C5775b.t((Void) obj);
            }
        });
        do0.h().k(uniqueId);
        if (do0.h().e() == 0) {
            FlutterBoost.h().d(2);
        }
    }

    public void E(FlutterViewContainer flutterViewContainer) {
        F(flutterViewContainer.getUniqueId());
    }

    public void F(String str) {
        if (this.b != null) {
            l();
            Messages.C5772a c5772a = new Messages.C5772a();
            c5772a.j(str);
            this.b.u(c5772a, new Messages.FlutterRouterApi.Reply() { // from class: tb.sn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    C5775b.u((Void) obj);
                }
            });
            String str2 = h;
            Log.v(str2, "## onContainerHide: " + str);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void G(String str) {
        if (this.b != null) {
            l();
            Messages.C5772a c5772a = new Messages.C5772a();
            c5772a.j(str);
            this.b.v(c5772a, new Messages.FlutterRouterApi.Reply() { // from class: tb.xn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    C5775b.v((Void) obj);
                }
            });
            String str2 = h;
            Log.v(str2, "## onContainerShow: " + str);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void H() {
        if (this.b != null) {
            l();
            this.b.w(new Messages.C5772a(), new Messages.FlutterRouterApi.Reply() { // from class: tb.un0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    C5775b.w((Void) obj);
                }
            });
            String str = h;
            Log.v(str, "## onForeground: " + this.b);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void I(String str, String str2, Map<String, Object> map, final Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.b != null) {
            l();
            Messages.C5772a c5772a = new Messages.C5772a();
            c5772a.j(str);
            c5772a.i(str2);
            c5772a.g(map);
            this.b.y(c5772a, new Messages.FlutterRouterApi.Reply() { // from class: tb.pn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    C5775b.x(Messages.FlutterRouterApi.Reply.this, (Void) obj);
                }
            });
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void J(String str, final Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.b != null) {
            l();
            Messages.C5772a c5772a = new Messages.C5772a();
            c5772a.j(str);
            this.b.z(c5772a, new Messages.FlutterRouterApi.Reply() { // from class: tb.rn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    C5775b.y(Messages.FlutterRouterApi.Reply.this, (Void) obj);
                }
            });
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void K(FlutterBoostDelegate flutterBoostDelegate) {
        this.c = flutterBoostDelegate;
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public Messages.C5773b getStackFromHost() {
        if (this.d == null) {
            return Messages.C5773b.a(new HashMap());
        }
        String str = h;
        Log.v(str, "#getStackFromHost: " + this.d);
        return this.d;
    }

    public Messages.FlutterRouterApi m() {
        return this.b;
    }

    public FlutterBoostDelegate n() {
        return this.c;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(new PluginRegistry.ActivityResultListener() { // from class: tb.qn0
            @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
            public final boolean onActivityResult(int i2, int i3, Intent intent) {
                boolean p;
                p = C5775b.this.p(i2, i3, intent);
                return p;
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        C5782d.o(flutterPluginBinding.getBinaryMessenger(), this);
        this.a = flutterPluginBinding.getFlutterEngine();
        this.b = new Messages.FlutterRouterApi(flutterPluginBinding.getBinaryMessenger());
        this.e = new SparseArray<>();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.a = null;
        this.b = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void popRoute(Messages.C5772a c5772a, Messages.Result<Void> result) {
        if (this.c != null) {
            if (this.c.popRoute(new C5776c.C5778b().i(c5772a.e()).k(c5772a.f()).f(c5772a.b()).g())) {
                return;
            }
            String f = c5772a.f();
            if (f != null) {
                FlutterViewContainer d = do0.h().d(f);
                if (d != null) {
                    d.finishContainer(c5772a.b());
                }
                result.success(null);
                return;
            }
            throw new RuntimeException("Oops!! The unique id is null!");
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushFlutterRoute(Messages.C5772a c5772a) {
        if (this.c != null) {
            this.c.pushFlutterRoute(new C5776c.C5778b().i(c5772a.e()).k(c5772a.f()).h(c5772a.d().booleanValue()).f(c5772a.b()).g());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushNativeRoute(Messages.C5772a c5772a) {
        if (this.c != null) {
            int i2 = this.f + 1;
            this.f = i2;
            SparseArray<String> sparseArray = this.e;
            if (sparseArray != null) {
                sparseArray.put(i2, c5772a.e());
            }
            this.c.pushNativeRoute(new C5776c.C5778b().i(c5772a.e()).f(c5772a.b()).j(this.f).g());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void saveStackToHost(Messages.C5773b c5773b) {
        this.d = c5773b;
        String str = h;
        Log.v(str, "#saveStackToHost: " + this.d);
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void sendEventToNative(Messages.C5772a c5772a) {
        String c = c5772a.c();
        Map<Object, Object> b = c5772a.b();
        if (b == null) {
            b = new HashMap<>();
        }
        LinkedList<EventListener> linkedList = this.g.get(c);
        if (linkedList == null) {
            return;
        }
        for (EventListener eventListener : linkedList) {
            eventListener.onEvent(c, b);
        }
    }

    public void z() {
        if (this.b != null) {
            l();
            this.b.s(new Messages.FlutterRouterApi.Reply() { // from class: tb.vn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    C5775b.q((Void) obj);
                }
            });
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }
}
