package com.idlefish.flutterboost;

import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.c;
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
/* loaded from: classes10.dex */
public class b implements Messages.NativeRouterApi, FlutterPlugin, ActivityAware {
    private static final String h = "b";
    public static final /* synthetic */ int i = 0;
    private FlutterEngine a;
    private Messages.FlutterRouterApi b;
    private FlutterBoostDelegate c;
    private Messages.b d;
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
            Messages.a aVar = new Messages.a();
            String str = this.e.get(i2);
            this.e.remove(i2);
            if (str != null) {
                aVar.i(str);
                if (intent != null) {
                    aVar.g(bo0.a(intent.getExtras()));
                }
                this.b.x(aVar, new Messages.FlutterRouterApi.Reply() { // from class: tb.yn0
                    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                    public final void reply(Object obj) {
                        com.idlefish.flutterboost.b.o((Void) obj);
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
            this.b.t(new Messages.a(), new Messages.FlutterRouterApi.Reply() { // from class: tb.zn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    com.idlefish.flutterboost.b.r((Void) obj);
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
                com.idlefish.flutterboost.b.s((Void) obj);
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
                com.idlefish.flutterboost.b.t((Void) obj);
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
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            this.b.u(aVar, new Messages.FlutterRouterApi.Reply() { // from class: tb.sn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    com.idlefish.flutterboost.b.u((Void) obj);
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
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            this.b.v(aVar, new Messages.FlutterRouterApi.Reply() { // from class: tb.xn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    com.idlefish.flutterboost.b.v((Void) obj);
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
            this.b.w(new Messages.a(), new Messages.FlutterRouterApi.Reply() { // from class: tb.un0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    com.idlefish.flutterboost.b.w((Void) obj);
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
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            aVar.i(str2);
            aVar.g(map);
            this.b.y(aVar, new Messages.FlutterRouterApi.Reply() { // from class: tb.pn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    com.idlefish.flutterboost.b.x(Messages.FlutterRouterApi.Reply.this, (Void) obj);
                }
            });
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void J(String str, final Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.b != null) {
            l();
            Messages.a aVar = new Messages.a();
            aVar.j(str);
            this.b.z(aVar, new Messages.FlutterRouterApi.Reply() { // from class: tb.rn0
                @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
                public final void reply(Object obj) {
                    com.idlefish.flutterboost.b.y(Messages.FlutterRouterApi.Reply.this, (Void) obj);
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
    public Messages.b getStackFromHost() {
        if (this.d == null) {
            return Messages.b.a(new HashMap());
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
                p = com.idlefish.flutterboost.b.this.p(i2, i3, intent);
                return p;
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        d.o(flutterPluginBinding.getBinaryMessenger(), this);
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
    public void popRoute(Messages.a aVar, Messages.Result<Void> result) {
        if (this.c != null) {
            if (this.c.popRoute(new c.b().i(aVar.e()).k(aVar.f()).f(aVar.b()).g())) {
                return;
            }
            String f = aVar.f();
            if (f != null) {
                FlutterViewContainer d = do0.h().d(f);
                if (d != null) {
                    d.finishContainer(aVar.b());
                }
                result.success(null);
                return;
            }
            throw new RuntimeException("Oops!! The unique id is null!");
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushFlutterRoute(Messages.a aVar) {
        if (this.c != null) {
            this.c.pushFlutterRoute(new c.b().i(aVar.e()).k(aVar.f()).h(aVar.d().booleanValue()).f(aVar.b()).g());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushNativeRoute(Messages.a aVar) {
        if (this.c != null) {
            int i2 = this.f + 1;
            this.f = i2;
            SparseArray<String> sparseArray = this.e;
            if (sparseArray != null) {
                sparseArray.put(i2, aVar.e());
            }
            this.c.pushNativeRoute(new c.b().i(aVar.e()).f(aVar.b()).j(this.f).g());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void saveStackToHost(Messages.b bVar) {
        this.d = bVar;
        String str = h;
        Log.v(str, "#saveStackToHost: " + this.d);
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void sendEventToNative(Messages.a aVar) {
        String c = aVar.c();
        Map<Object, Object> b = aVar.b();
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
                    com.idlefish.flutterboost.b.q((Void) obj);
                }
            });
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }
}
