package com.youku.gaiax.provider.module.js;

import android.content.Context;
import android.os.Trace;
import android.view.View;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.alipay.sdk.m.k.C4226b;
import com.taobao.weex.WXGlobalEventReceiver;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.proxy.IProxyMonitor;
import com.youku.gaiax.common.utils.Log;
import com.youku.gaiax.impl.GaiaXContext;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.js.IJSDelegate;
import com.youku.gaiax.impl.register.GXMixNodeEvent;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.impl.utils.PropUtils;
import com.youku.gaiax.js.GaiaXJS;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.support.GaiaXNativeEventManager;
import com.youku.gaiax.js.utils.TimeUtils;
import com.youku.uplayer.FileUtils;
import io.flutter.wpkbridge.WPKFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.gr0;
import tb.k50;
import tb.os0;
import tb.qr0;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\b\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0018\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 J.\u0010(\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&J\u001e\u0010)\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010$\u001a\u00020\u000bJ\u0016\u0010+\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000bJ&\u0010-\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020,J&\u00100\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0002J\u0016\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 J\u001e\u00103\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0002J\u0016\u00104\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010*\u001a\u00020\u000bJ\u0010\u00105\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016R\"\u00107\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0005068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/youku/gaiax/provider/module/js/JSDelegate;", "Lcom/youku/gaiax/impl/js/IJSDelegate;", "", "isJSEngineDefault", "isJSEngineStarted", "Lcom/youku/gaiax/impl/GaiaXContext;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "templateInfo", "Ltb/wt2;", "registerTemplateTree", "", "targetId", "gaiaxContext", "Lcom/alibaba/fastjson/JSONObject;", "getNodeInfo", "Landroid/content/Context;", "Lkotlin/Function0;", WXBridgeManager.METHOD_CALLBACK, "startEngine", "onReadyComponent", "onReuseComponent", "onShowComponent", "onHiddenComponent", "onDestroyComponent", "data", "onLoadMoreComponent", "unregisterComponent", "registerComponent", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "dispatcherEvent", "", "componentId", "Landroid/view/View;", "getTemplateView", "eventType", "optionCover", "", "optionLevel", "addEventListener", "removeEventListener", "templateId", "getData", "Lcom/youku/gaiax/js/api/IGaiaXCallback;", "setData", "resetOffset", "noRequest", "refreshPage", "jsonObject", "invokeService", "refreshCard", "refreshComponent", "dispatcherNativeMessageEvent", "", "links", "Ljava/util/Map;", "jsEngineStatus", "I", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class JSDelegate implements IJSDelegate {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<JSDelegate> instance$delegate;
    @NotNull
    private final Map<Long, GaiaXContext> links = new ConcurrentHashMap();
    private volatile int jsEngineStatus = 1;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001d\u0010\t\u001a\u00020\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/youku/gaiax/provider/module/js/JSDelegate$Companion;", "", "Lcom/youku/gaiax/impl/js/IJSDelegate;", "getJSDelegate", "Lcom/youku/gaiax/provider/module/js/JSDelegate;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/youku/gaiax/provider/module/js/JSDelegate;", "instance", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final JSDelegate getInstance() {
            return (JSDelegate) JSDelegate.instance$delegate.getValue();
        }

        @JvmStatic
        @NotNull
        public final IJSDelegate getJSDelegate() {
            return getInstance();
        }
    }

    static {
        Lazy<JSDelegate> b;
        b = C8177b.b(new Function0<JSDelegate>() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSDelegate invoke() {
                return new JSDelegate();
            }
        });
        instance$delegate = b;
    }

    @JvmStatic
    @NotNull
    public static final IJSDelegate getJSDelegate() {
        return Companion.getJSDelegate();
    }

    private final boolean isJSEngineDefault() {
        return (this.jsEngineStatus & 1) == 1;
    }

    private final boolean isJSEngineStarted() {
        return (this.jsEngineStatus & 4) == 4;
    }

    private final void registerTemplateTree(GaiaXContext gaiaXContext, GXTemplateInfo gXTemplateInfo) {
        String a = gXTemplateInfo.s().a();
        String d = gXTemplateInfo.s().d();
        String valueOf = String.valueOf(gXTemplateInfo.s().h());
        String o = gXTemplateInfo.o();
        gr0 p = gXTemplateInfo.p();
        boolean z = false;
        if (o != null) {
            if (o.length() > 0) {
                z = true;
            }
        }
        if (z) {
            long registerComponent = GaiaXJS.Companion.getInstance().registerComponent(a, d, valueOf, o);
            Set<Long> jsComponentIds = gaiaXContext.getJsComponentIds();
            if (jsComponentIds != null) {
                jsComponentIds.add(Long.valueOf(registerComponent));
            }
            this.links.put(Long.valueOf(registerComponent), gaiaXContext);
        }
        List<GXTemplateInfo> k = gXTemplateInfo.k();
        if (p.m() || k == null || !(!k.isEmpty())) {
            return;
        }
        for (GXTemplateInfo gXTemplateInfo2 : k) {
            registerTemplateTree(gaiaXContext, gXTemplateInfo2);
        }
    }

    public final void addEventListener(@NotNull String str, long j, @NotNull String str2, boolean z, int i) {
        b41.i(str, "targetId");
        b41.i(str2, "eventType");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext == null) {
            return;
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "addEventListener", null, 4, null);
        }
        View rootView = gaiaXContext.getRootView();
        if (rootView == null) {
            return;
        }
        GXTemplateEngine.C3337a c3337a = GXTemplateEngine.Companion;
        os0 j2 = c3337a.a().j(rootView);
        if (j2 == null) {
            return;
        }
        qr0 i2 = c3337a.a().i(rootView, str);
        if (i2 != null) {
            i2.r();
        }
        GXINodeEvent f = i2 == null ? null : i2.f();
        GXMixNodeEvent gXMixNodeEvent = f instanceof GXMixNodeEvent ? (GXMixNodeEvent) f : null;
        if (gXMixNodeEvent == null) {
            return;
        }
        gXMixNodeEvent.addJSEvent(j2, i2, j, str2, z, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r7.equals("longpress") == false) goto L31;
     */
    @Override // com.youku.gaiax.impl.js.IJSDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void dispatcherEvent(@org.jetbrains.annotations.NotNull com.youku.gaiax.api.data.EventParams r7) {
        /*
            r6 = this;
            java.lang.String r0 = "eventParams"
            tb.b41.i(r7, r0)
            boolean r0 = r6.isJSEngineStarted()
            if (r0 != 0) goto Lc
            return
        Lc:
            long r0 = r7.getJsComponentId()
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La7
            java.util.Map<java.lang.Long, com.youku.gaiax.impl.GaiaXContext> r0 = r6.links
            long r1 = r7.getJsComponentId()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.Object r0 = r0.get(r1)
            com.youku.gaiax.impl.GaiaXContext r0 = (com.youku.gaiax.impl.GaiaXContext) r0
            if (r0 != 0) goto L2a
            goto La7
        L2a:
            com.youku.gaiax.common.utils.Log r1 = com.youku.gaiax.common.utils.Log.INSTANCE
            boolean r2 = r1.isLog()
            if (r2 == 0) goto L3b
            java.lang.String r2 = r7.toString()
            java.lang.String r3 = "dispatcherEvent"
            r1.trace(r0, r3, r2)
        L3b:
            java.lang.String r1 = r7.getViewId()
            if (r1 != 0) goto L42
            goto La7
        L42:
            com.alibaba.fastjson.JSONObject r1 = r6.getNodeInfo(r1, r0)
            java.lang.String r7 = r7.getType()
            int r2 = r7.hashCode()
            r3 = 114595(0x1bfa3, float:1.60582E-40)
            java.lang.String r4 = "longpress"
            java.lang.String r5 = "click"
            if (r2 == r3) goto L6e
            r3 = 94750088(0x5a5c588, float:1.5589087E-35)
            if (r2 == r3) goto L69
            r3 = 143756103(0x8918b47, float:8.759614E-34)
            if (r2 == r3) goto L62
            goto L74
        L62:
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L75
            goto L74
        L69:
            boolean r7 = r7.equals(r5)
            goto L74
        L6e:
            java.lang.String r2 = "tap"
            boolean r7 = r7.equals(r2)
        L74:
            r4 = r5
        L75:
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r7 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "timeStamp"
            r1.put(r2, r7)
            java.util.Set r7 = r0.getJsComponentIds()
            if (r7 != 0) goto L89
            goto La7
        L89:
            java.util.Iterator r7 = r7.iterator()
        L8d:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto La7
            java.lang.Object r0 = r7.next()
            java.lang.Number r0 = (java.lang.Number) r0
            long r2 = r0.longValue()
            com.youku.gaiax.js.GaiaXJS$Companion r0 = com.youku.gaiax.js.GaiaXJS.Companion
            com.youku.gaiax.js.GaiaXJS r0 = r0.getInstance()
            r0.onEventComponent(r2, r4, r1)
            goto L8d
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.provider.module.js.JSDelegate.dispatcherEvent(com.youku.gaiax.api.data.EventParams):void");
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void dispatcherNativeMessageEvent(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "data");
        for (JSONObject jSONObject2 : GaiaXNativeEventManager.Companion.getInstance().getEventsData()) {
            long longValue = jSONObject2.getLongValue("instanceId");
            if (this.links.containsKey(Long.valueOf(longValue))) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putAll(jSONObject);
                jSONObject3.putAll(jSONObject2);
                jSONObject3.put((JSONObject) "timestamp", (String) Long.valueOf(TimeUtils.INSTANCE.elapsedRealtime()));
                GaiaXJS.Companion.getInstance().onNativeEventComponent(longValue, jSONObject3);
            }
        }
    }

    @NotNull
    public final JSONObject getData(long j, @NotNull String str) {
        GaiaX.Params params;
        b41.i(str, "templateId");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        JSONObject jSONObject = null;
        if (gaiaXContext != null && (params = gaiaXContext.getParams()) != null) {
            jSONObject = params.getData();
        }
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    @NotNull
    public final JSONObject getNodeInfo(@NotNull String str, long j) {
        b41.i(str, "targetId");
        return getNodeInfo(str, this.links.get(Long.valueOf(j)));
    }

    @Nullable
    public final View getTemplateView(@NotNull String str, long j) {
        b41.i(str, "targetId");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        return GXTemplateEngine.Companion.a().k(gaiaXContext == null ? null : gaiaXContext.getRootView(), str);
    }

    public final void invokeService(@NotNull final JSONObject jSONObject, long j) {
        b41.i(jSONObject, "jsonObject");
        final GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext == null) {
            return;
        }
        GaiaXUiExecutor.INSTANCE.action(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$invokeService$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GaiaX.IHostMessage message = GaiaXContext.this.getParams().getMessage();
                if (message == null) {
                    return;
                }
                message.onMessage("GAIAX_JS_INVOKE_SERVICE", jSONObject);
            }
        });
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onDestroyComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onDestroyComponent", null, 4, null);
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            for (Number number : jsComponentIds) {
                GaiaXJS.Companion.getInstance().onDestroyComponent(number.longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onHiddenComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onHiddenComponent", null, 4, null);
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            for (Number number : jsComponentIds) {
                GaiaXJS.Companion.getInstance().onHiddenComponent(number.longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onLoadMoreComponent(@NotNull GaiaXContext gaiaXContext, @NotNull JSONObject jSONObject) {
        Set<Long> jsComponentIds;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(jSONObject, "data");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onLoadMoreComponent", null, 4, null);
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            for (Number number : jsComponentIds) {
                GaiaXJS.Companion.getInstance().onLoadMoreComponent(number.longValue(), jSONObject);
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onReadyComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onReadyComponent", null, 4, null);
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            for (Number number : jsComponentIds) {
                GaiaXJS.Companion.getInstance().onReadyComponent(number.longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onReuseComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onReuseComponent", null, 4, null);
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            for (Number number : jsComponentIds) {
                GaiaXJS.Companion.getInstance().onReuseComponent(number.longValue());
            }
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void onShowComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "onShowComponent", null, 4, null);
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            for (Number number : jsComponentIds) {
                GaiaXJS.Companion.getInstance().onShowComponent(number.longValue());
            }
        }
    }

    public final void refreshCard(long j, @NotNull String str, final boolean z) {
        b41.i(str, "templateId");
        final GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext == null) {
            return;
        }
        GaiaXUiExecutor.INSTANCE.action(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$refreshCard$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    Log.trace$default(log, GaiaXContext.this, WPKFactory.INIT_KEY_CONTEXT, null, 4, null);
                }
                GaiaX.IHostMessage message = GaiaXContext.this.getParams().getMessage();
                if (message == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put((JSONObject) "noRequest", (String) Boolean.valueOf(z));
                wt2 wt2Var = wt2.INSTANCE;
                message.onMessage("GAIAX_JS_REFRESH_CARD", jSONObject);
            }
        });
    }

    public final void refreshComponent(long j, @NotNull String str) {
        b41.i(str, "templateId");
        final GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext == null) {
            return;
        }
        GaiaXUiExecutor.INSTANCE.action(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$refreshComponent$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    Log.trace$default(log, GaiaXContext.this, "refreshComponent", null, 4, null);
                }
                GaiaX.IHostMessage message = GaiaXContext.this.getParams().getMessage();
                if (message == null) {
                    return;
                }
                message.onMessage("GAIAX_JS_REFRESH_COMPONENT", new JSONObject());
            }
        });
    }

    public final void refreshPage(long j, @NotNull String str, final boolean z, final boolean z2) {
        b41.i(str, "templateId");
        final GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext == null) {
            return;
        }
        GaiaXUiExecutor.INSTANCE.action(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$refreshPage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    Log.trace$default(log, GaiaXContext.this, "refreshPage", null, 4, null);
                }
                GaiaX.IHostMessage message = GaiaXContext.this.getParams().getMessage();
                if (message == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                boolean z3 = z;
                boolean z4 = z2;
                jSONObject.put((JSONObject) "resetOffset", (String) Boolean.valueOf(z3));
                jSONObject.put((JSONObject) "noRequest", (String) Boolean.valueOf(z4));
                wt2 wt2Var = wt2.INSTANCE;
                message.onMessage("GAIAX_JS_REFRESH_PAGE", jSONObject);
            }
        });
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void registerComponent(@NotNull GaiaXContext gaiaXContext) {
        GXTemplateInfo q;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "registerComponent", null, 4, null);
        }
        if (isJSEngineStarted()) {
            if (gaiaXContext.getJsComponentIds() == null) {
                gaiaXContext.setJsComponentIds(new CopyOnWriteArraySet());
            }
            os0 gxTemplateContext = gaiaXContext.getGxTemplateContext();
            if (gxTemplateContext == null || (q = gxTemplateContext.q()) == null) {
                return;
            }
            registerTemplateTree(gaiaXContext, q);
        }
    }

    public final void removeEventListener(@NotNull String str, long j, @NotNull String str2) {
        b41.i(str, "targetId");
        b41.i(str2, "eventType");
        GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext == null) {
            return;
        }
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "removeEventListener", null, 4, null);
        }
        View rootView = gaiaXContext.getRootView();
        if (rootView == null) {
            return;
        }
        qr0 i = GXTemplateEngine.Companion.a().i(rootView, str);
        if (i != null) {
            i.r();
        }
        GXINodeEvent f = i == null ? null : i.f();
        GXMixNodeEvent gXMixNodeEvent = f instanceof GXMixNodeEvent ? (GXMixNodeEvent) f : null;
        if (gXMixNodeEvent == null) {
            return;
        }
        gXMixNodeEvent.removeJSEvent(j, str2);
    }

    public final void setData(long j, @NotNull String str, @NotNull final JSONObject jSONObject, @NotNull final IGaiaXCallback iGaiaXCallback) {
        b41.i(str, "templateId");
        b41.i(jSONObject, "data");
        b41.i(iGaiaXCallback, WXBridgeManager.METHOD_CALLBACK);
        final GaiaXContext gaiaXContext = this.links.get(Long.valueOf(j));
        if (gaiaXContext != null) {
            GaiaXUiExecutor.INSTANCE.action(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$setData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Log log = Log.INSTANCE;
                    if (log.isLog()) {
                        Log.trace$default(log, GaiaXContext.this, "setData", null, 4, null);
                    }
                    PropUtils propUtils = PropUtils.INSTANCE;
                    if (propUtils.isTrace()) {
                        Trace.beginSection("GX JSDelegate setData");
                    }
                    GaiaXContext.this.setIgnoreJSReuse(true);
                    GaiaXContext.this.getParams().setData(jSONObject);
                    GaiaX.Companion.getInstance().bindView(GaiaXContext.this.getParams());
                    IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXCallback, null, 1, null);
                    if (propUtils.isTrace()) {
                        Trace.endSection();
                    }
                }
            });
        }
        if (PropUtils.INSTANCE.isTrace()) {
            Trace.endSection();
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void startEngine(@NotNull Context context, @NotNull final Function0<wt2> function0) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(function0, WXBridgeManager.METHOD_CALLBACK);
        if (isJSEngineDefault()) {
            this.jsEngineStatus <<= 1;
            GaiaXJS.Companion companion = GaiaXJS.Companion;
            companion.getInstance().init(context).initListener(new GaiaXJS.Listener() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$startEngine$1
                @Override // com.youku.gaiax.js.GaiaXJS.Listener
                public void errorLog(@NotNull JSONObject jSONObject) {
                    b41.i(jSONObject, "data");
                    GaiaXLogModule.Companion.errorLog(jSONObject);
                }

                @Override // com.youku.gaiax.js.GaiaXJS.Listener
                public void monitor(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
                    b41.i(str, "scene");
                    b41.i(str2, C4226b.l);
                    b41.i(str3, "id");
                    b41.i(str4, "type");
                    b41.i(str5, "state");
                    b41.i(str6, "jsModuleName");
                    b41.i(str7, "jsApiName");
                    b41.i(str8, "jsApiType");
                    IProxyMonitor monitor = GaiaXProxy.Companion.getInstance().getMonitor();
                    if (monitor == null) {
                        return;
                    }
                    IProxyMonitor.DefaultImpls.monitor$default(monitor, str, str2, str3, str4, str5, j, null, null, null, FileUtils.S_IRWXU, null);
                }
            });
            companion.getInstance().startEngine(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.JSDelegate$startEngine$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    int i;
                    JSDelegate jSDelegate = JSDelegate.this;
                    i = jSDelegate.jsEngineStatus;
                    jSDelegate.jsEngineStatus = i << 1;
                    function0.invoke();
                }
            });
        }
    }

    @Override // com.youku.gaiax.impl.js.IJSDelegate
    public void unregisterComponent(@NotNull GaiaXContext gaiaXContext) {
        Set<Long> jsComponentIds;
        b41.i(gaiaXContext, WPKFactory.INIT_KEY_CONTEXT);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            Log.trace$default(log, gaiaXContext, "unregisterComponent", null, 4, null);
        }
        if (isJSEngineStarted() && (jsComponentIds = gaiaXContext.getJsComponentIds()) != null) {
            for (Number number : jsComponentIds) {
                long longValue = number.longValue();
                GaiaXJS.Companion.getInstance().unregisterComponent(longValue);
                Set<Long> jsComponentIds2 = gaiaXContext.getJsComponentIds();
                if (jsComponentIds2 != null) {
                    jsComponentIds2.remove(Long.valueOf(longValue));
                }
                this.links.remove(Long.valueOf(longValue));
            }
        }
    }

    private final JSONObject getNodeInfo(String str, GaiaXContext gaiaXContext) {
        qr0 i;
        if (gaiaXContext == null) {
            return new JSONObject();
        }
        View rootView = gaiaXContext.getRootView();
        if (rootView != null && (i = GXTemplateEngine.Companion.a().i(rootView, str)) != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "targetType", i.o().i().k());
            jSONObject.put((JSONObject) "targetSubType", i.o().i().j());
            jSONObject.put((JSONObject) "targetId", str);
            return jSONObject;
        }
        return new JSONObject();
    }
}
