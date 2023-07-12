package com.alibaba.android.bindingx.core;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.alibaba.android.bindingx.core.internal.C3211b;
import com.alibaba.android.bindingx.core.internal.C3215e;
import com.alibaba.android.bindingx.core.internal.C3216f;
import com.alibaba.android.bindingx.core.internal.C3227o;
import com.alibaba.android.bindingx.core.internal.GestureDetector$OnGestureListenerC3217g;
import com.alibaba.android.bindingx.core.internal.ScaleGestureDetector$OnScaleGestureListenerC3213c;
import com.alibaba.android.bindingx.core.internal.View$OnTouchListenerC3214d;
import com.taobao.weex.bridge.WXBridgeManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
import tb.bb1;
import tb.jn1;
import tb.xg0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BindingXCore implements IHandlerCleanable {
    private static final Map<String, ObjectCreator<IEventHandler, Context, PlatformManager>> d = new HashMap(4);
    private Map<String, Map<String, IEventHandler>> a;
    private final Map<String, ObjectCreator<IEventHandler, Context, PlatformManager>> b = new HashMap(8);
    private final PlatformManager c;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface JavaScriptCallback {
        void callback(Object obj);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface ObjectCreator<Type, ParamA, ParamB> {
        Type createWith(@NonNull ParamA parama, @NonNull ParamB paramb, Object... objArr);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.BindingXCore$a */
    /* loaded from: classes5.dex */
    class C3144a implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        C3144a(BindingXCore bindingXCore) {
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new GestureDetector$OnGestureListenerC3217g(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.BindingXCore$b */
    /* loaded from: classes5.dex */
    class C3145b implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        C3145b(BindingXCore bindingXCore) {
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new ScaleGestureDetector$OnScaleGestureListenerC3213c(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.BindingXCore$c */
    /* loaded from: classes5.dex */
    class C3146c implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        C3146c(BindingXCore bindingXCore) {
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new View$OnTouchListenerC3214d(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.BindingXCore$d */
    /* loaded from: classes5.dex */
    class C3147d implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        C3147d(BindingXCore bindingXCore) {
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new C3211b(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.BindingXCore$e */
    /* loaded from: classes5.dex */
    class C3148e implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        C3148e(BindingXCore bindingXCore) {
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new C3216f(context, platformManager, objArr);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.bindingx.core.BindingXCore$f */
    /* loaded from: classes5.dex */
    class C3149f implements ObjectCreator<IEventHandler, Context, PlatformManager> {
        C3149f(BindingXCore bindingXCore) {
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new C3215e(context, platformManager, objArr);
        }
    }

    public BindingXCore(@NonNull PlatformManager platformManager) {
        this.c = platformManager;
        i("pan", new C3144a(this));
        i(BindingXEventType.TYPE_PINCH, new C3145b(this));
        i("rotation", new C3146c(this));
        i("orientation", new C3147d(this));
        i(BindingXEventType.TYPE_TIMING, new C3148e(this));
        i(BindingXEventType.TYPE_SPRING, new C3149f(this));
    }

    @Nullable
    private IEventHandler a(@NonNull Context context, @Nullable String str, @NonNull String str2) {
        if (!this.b.isEmpty() && this.c != null) {
            ObjectCreator<IEventHandler, Context, PlatformManager> objectCreator = this.b.get(str2);
            if (objectCreator == null) {
                objectCreator = d.get(str2);
            }
            r1 = objectCreator != null ? objectCreator.createWith(context, this.c, str) : null;
            if (r1 != null) {
                r1.setHandlerCleaner(this);
            }
        }
        return r1;
    }

    private String h() {
        return UUID.randomUUID().toString();
    }

    public String b(@Nullable Context context, @Nullable String str, @NonNull Map<String, Object> map, @NonNull JavaScriptCallback javaScriptCallback, Object... objArr) {
        Map<String, Object> map2;
        String h = C3227o.h(map, "eventType");
        String h2 = C3227o.h(map, "instanceId");
        bb1.d(map);
        Object obj = map.get(WXBridgeManager.OPTIONS);
        if (obj != null && (obj instanceof Map)) {
            try {
                map2 = C3227o.n(new JSONObject((Map) obj));
            } catch (Exception e) {
                bb1.c("parse external config failed.\n", e);
            }
            xg0 e2 = C3227o.e(map, "exitExpression");
            return c(C3227o.h(map, "anchor"), h2, h, map2, e2, C3227o.g(map), C3227o.c(map), javaScriptCallback, context, str, map, objArr);
        }
        map2 = null;
        xg0 e22 = C3227o.e(map, "exitExpression");
        return c(C3227o.h(map, "anchor"), h2, h, map2, e22, C3227o.g(map), C3227o.c(map), javaScriptCallback, context, str, map, objArr);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String c(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Map<String, Object> map, @Nullable xg0 xg0Var, @Nullable List<Map<String, Object>> list, @Nullable Map<String, xg0> map2, @Nullable JavaScriptCallback javaScriptCallback, @Nullable Context context, @Nullable String str4, @Nullable Map<String, Object> map3, @Nullable Object... objArr) {
        String str5;
        Map<String, Map<String, IEventHandler>> map4;
        Map<String, IEventHandler> map5;
        Map<String, IEventHandler> map6;
        IEventHandler iEventHandler = null;
        if (!TextUtils.isEmpty(str3) && list != null) {
            if (this.a != null && !TextUtils.isEmpty(str) && (map6 = this.a.get(str)) != null) {
                iEventHandler = map6.get(str3);
            }
            IEventHandler iEventHandler2 = iEventHandler;
            if (iEventHandler2 == null) {
                if (bb1.a) {
                    bb1.a("binding not enabled,try auto enable it.[sourceRef:" + str + ",eventType:" + str3 + jn1.ARRAY_END_STR);
                }
                String d2 = d(context, str4, str, str2, str3, map, map3, objArr);
                if (!TextUtils.isEmpty(d2) && (map4 = this.a) != null && (map5 = map4.get(d2)) != null) {
                    iEventHandler2 = map5.get(str3);
                }
                str5 = d2;
            } else {
                str5 = str;
            }
            if (iEventHandler2 != null) {
                iEventHandler2.setOriginalParams(map3);
                iEventHandler2.onBindExpression(str3, map, xg0Var, list, javaScriptCallback);
                if (bb1.a) {
                    bb1.a("createBinding success.[exitExp:" + xg0Var + ",args:" + list + jn1.ARRAY_END_STR);
                }
                iEventHandler2.setInterceptors(map2);
            } else if (bb1.a) {
                bb1.b("internal error.binding failed for ref:" + str + ",type:" + str3);
            }
            return str5;
        }
        bb1.b("doBind failed,illegal argument.[" + str3 + "," + list + jn1.ARRAY_END_STR);
        return null;
    }

    @Override // com.alibaba.android.bindingx.core.IHandlerCleanable
    public void cleanHandlerByToken(@NonNull String str) {
        Map<String, Map<String, IEventHandler>> map = this.a;
        if (map != null) {
            map.remove(str);
        }
    }

    public String d(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Map<String, Object> map, @Nullable Map<String, Object> map2, @Nullable Object... objArr) {
        IEventHandler iEventHandler;
        if (TextUtils.isEmpty(str4)) {
            bb1.b("[doPrepare] failed. can not found eventType");
            return null;
        } else if (context == null) {
            bb1.b("[doPrepare] failed. context or wxInstance is null");
            return null;
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = h();
            }
            if (this.a == null) {
                this.a = new HashMap();
            }
            Map<String, IEventHandler> map3 = this.a.get(str2);
            if (map3 != null && (iEventHandler = map3.get(str4)) != null) {
                if (bb1.a) {
                    bb1.a("you have already enabled binding,[token:" + str2 + ",type:" + str4 + jn1.ARRAY_END_STR);
                }
                iEventHandler.setExtensionParams(objArr);
                iEventHandler.onStart(str2, str4);
                if (bb1.a) {
                    bb1.a("enableBinding success.[token:" + str2 + ",type:" + str4 + jn1.ARRAY_END_STR);
                }
            } else {
                if (map3 == null) {
                    map3 = new HashMap<>(4);
                    this.a.put(str2, map3);
                }
                IEventHandler a = a(context, str, str4);
                if (a != null) {
                    a.setAnchorInstanceId(str3);
                    a.setToken(str2);
                    a.setGlobalConfig(map);
                    a.setExtensionParams(objArr);
                    if (a.onCreate(str2, str4)) {
                        a.onStart(str2, str4);
                        map3.put(str4, a);
                        if (bb1.a) {
                            bb1.a("enableBinding success.[token:" + str2 + ",type:" + str4 + jn1.ARRAY_END_STR);
                        }
                    } else {
                        if (bb1.a) {
                            bb1.b("expression enabled failed. [token:" + str2 + ",type:" + str4 + jn1.ARRAY_END_STR);
                        }
                        return null;
                    }
                } else {
                    bb1.b("unknown eventType: " + str4);
                    return null;
                }
            }
            return str2;
        }
    }

    public void e() {
        Map<String, Map<String, IEventHandler>> map = this.a;
        if (map != null) {
            try {
                for (Map<String, IEventHandler> map2 : map.values()) {
                    if (map2 != null && !map2.isEmpty()) {
                        for (IEventHandler iEventHandler : map2.values()) {
                            if (iEventHandler != null) {
                                iEventHandler.onDestroy();
                            }
                        }
                    }
                }
                this.a.clear();
                this.a = null;
            } catch (Exception e) {
                bb1.c("release failed", e);
            }
        }
    }

    public void f(@Nullable String str, @Nullable String str2) {
        bb1.a("disable binding [" + str + "," + str2 + jn1.ARRAY_END_STR);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Map<String, Map<String, IEventHandler>> map = this.a;
            if (map != null && !map.isEmpty()) {
                Map<String, IEventHandler> map2 = this.a.get(str);
                if (map2 != null && !map2.isEmpty()) {
                    IEventHandler iEventHandler = map2.get(str2);
                    if (iEventHandler == null) {
                        bb1.a("disable binding failed(0x4) [" + str + "," + str2 + jn1.ARRAY_END_STR);
                        return;
                    } else if (iEventHandler.onDisable(str, str2)) {
                        this.a.remove(str);
                        bb1.a("disable binding success[" + str + "," + str2 + jn1.ARRAY_END_STR);
                        return;
                    } else {
                        bb1.a("disabled failed(0x4) [" + str + "," + str2 + jn1.ARRAY_END_STR);
                        return;
                    }
                }
                bb1.a("disable binding failed(0x3) [" + str + "," + str2 + jn1.ARRAY_END_STR);
                return;
            }
            bb1.a("disable binding failed(0x2) [" + str + "," + str2 + jn1.ARRAY_END_STR);
            return;
        }
        bb1.a("disable binding failed(0x1) [" + str + "," + str2 + jn1.ARRAY_END_STR);
    }

    public void g(@Nullable Map<String, Object> map) {
        if (map == null) {
            return;
        }
        f(C3227o.h(map, "token"), C3227o.h(map, "eventType"));
    }

    public void i(String str, ObjectCreator<IEventHandler, Context, PlatformManager> objectCreator) {
        if (TextUtils.isEmpty(str) || objectCreator == null) {
            return;
        }
        this.b.put(str, objectCreator);
    }
}
