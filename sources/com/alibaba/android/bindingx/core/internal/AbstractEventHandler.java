package com.alibaba.android.bindingx.core.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.BindingXPropertyInterceptor;
import com.alibaba.android.bindingx.core.IEventHandler;
import com.alibaba.android.bindingx.core.IHandlerCleanable;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.arch.v3.core.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tb.bb1;
import tb.hc;
import tb.jn1;
import tb.xg0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class AbstractEventHandler implements IEventHandler {
    protected volatile Map<String, List<j>> a;
    protected volatile Map<String, xg0> b;
    protected BindingXCore.JavaScriptCallback c;
    protected String e;
    protected String f;
    protected String g;
    protected PlatformManager h;
    protected IHandlerCleanable i;
    protected volatile xg0 j;
    protected Object[] k;
    protected Map<String, Object> m;
    protected final Map<String, Object> d = new HashMap(64);
    private Cache<String, i> l = new Cache<>(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class Cache<K, V> extends LinkedHashMap<K, V> {
        private int maxSize;

        Cache(int i) {
            super(4, 0.75f, true);
            this.maxSize = Math.max(i, 4);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.maxSize;
        }
    }

    public AbstractEventHandler(Context context, PlatformManager platformManager, Object... objArr) {
        this.h = platformManager;
        this.e = (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) ? null : (String) objArr[0];
    }

    private void a() {
        Map<String, JSFunctionInterface> b = hc.a().b();
        if (b == null || b.isEmpty()) {
            return;
        }
        this.d.putAll(b);
    }

    private void g(@NonNull String str, @NonNull List<Map<String, Object>> list) {
        Map<String, Object> map;
        if (this.a == null) {
            this.a = new HashMap();
        }
        for (Map<String, Object> map2 : list) {
            String h = o.h(map2, "element");
            String h2 = o.h(map2, "instanceId");
            String h3 = o.h(map2, "property");
            xg0 e = o.e(map2, DXTraceUtil.TYPE_EXPRESSION_STRING);
            Object obj = map2.get(Constants.CONFIG);
            if (obj != null && (obj instanceof Map)) {
                try {
                    map = o.n(new JSONObject((Map) obj));
                } catch (Exception e2) {
                    bb1.c("parse config failed", e2);
                }
                if (!TextUtils.isEmpty(h) || TextUtils.isEmpty(h3) || e == null) {
                    bb1.b("skip illegal binding args[" + h + "," + h3 + "," + e + jn1.ARRAY_END_STR);
                } else {
                    j jVar = new j(h, h2, e, h3, str, map);
                    List<j> list2 = this.a.get(h);
                    if (list2 == null) {
                        ArrayList arrayList = new ArrayList(4);
                        this.a.put(h, arrayList);
                        arrayList.add(jVar);
                    } else if (!list2.contains(jVar)) {
                        list2.add(jVar);
                    }
                }
            }
            map = null;
            if (!TextUtils.isEmpty(h)) {
            }
            bb1.b("skip illegal binding args[" + h + "," + h3 + "," + e + jn1.ARRAY_END_STR);
        }
    }

    private void h(@NonNull Map<String, Object> map) {
        if (this.b == null || this.b.isEmpty()) {
            return;
        }
        for (Map.Entry<String, xg0> entry : this.b.entrySet()) {
            String key = entry.getKey();
            xg0 value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                performInterceptIfNeeded(key, value, map);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        bb1.a("all expression are cleared");
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(@Nullable Map<String, List<j>> map, @NonNull Map<String, Object> map2, @NonNull String str) throws IllegalArgumentException, JSONException {
        Map<String, Object> map3 = map2;
        h(map3);
        if (map == null) {
            bb1.b("expression args is null");
        } else if (map.isEmpty()) {
            bb1.b("no expression need consumed");
        } else {
            int i = 2;
            if (bb1.a) {
                bb1.a(String.format(Locale.getDefault(), "consume expression with %d tasks. event type is %s", Integer.valueOf(map.size()), str));
            }
            LinkedList linkedList = new LinkedList();
            for (List<j> list : map.values()) {
                for (j jVar : list) {
                    if (str.equals(jVar.e)) {
                        linkedList.clear();
                        Object[] objArr = this.k;
                        if (objArr != null && objArr.length > 0) {
                            Collections.addAll(linkedList, objArr);
                        }
                        String str2 = TextUtils.isEmpty(jVar.b) ? this.e : jVar.b;
                        if (!TextUtils.isEmpty(str2)) {
                            linkedList.add(str2);
                        }
                        xg0 xg0Var = jVar.c;
                        if (xg0.c(xg0Var)) {
                            i iVar = this.l.get(xg0Var.b);
                            if (iVar == null) {
                                iVar = i.a(xg0Var);
                                if (iVar != null) {
                                    if (!TextUtils.isEmpty(xg0Var.b)) {
                                        this.l.put(xg0Var.b, iVar);
                                    }
                                }
                            }
                            Object c = iVar.c(map3);
                            if (c == null) {
                                bb1.b("failed to execute expression,expression result is null");
                            } else if (((c instanceof Double) && Double.isNaN(((Double) c).doubleValue())) || ((c instanceof Float) && Float.isNaN(((Float) c).floatValue()))) {
                                bb1.b("failed to execute expression,expression result is NaN");
                            } else {
                                View findViewBy = this.h.g().findViewBy(jVar.a, linkedList.toArray());
                                BindingXPropertyInterceptor c2 = BindingXPropertyInterceptor.c();
                                String str3 = jVar.d;
                                PlatformManager.IDeviceResolutionTranslator e = this.h.e();
                                Map<String, Object> map4 = jVar.f;
                                Object[] objArr2 = new Object[i];
                                objArr2[0] = jVar.a;
                                objArr2[1] = str2;
                                c2.d(findViewBy, str3, c, e, map4, objArr2);
                                if (findViewBy == null) {
                                    bb1.b("failed to execute expression,target view not found.[ref:" + jVar.a + jn1.ARRAY_END_STR);
                                    map3 = map2;
                                    i = 2;
                                } else {
                                    i = 2;
                                    this.h.h().synchronouslyUpdateViewOnUIThread(findViewBy, jVar.d, c, this.h.e(), jVar.f, jVar.a, str2);
                                    map3 = map2;
                                }
                            }
                        }
                    } else {
                        bb1.a("skip expression with wrong event type.[expected:" + str + ",found:" + jVar.e + jn1.ARRAY_END_STR);
                    }
                }
                map3 = map2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(xg0 xg0Var, @NonNull Map<String, Object> map) {
        boolean z = false;
        if (xg0.c(xg0Var)) {
            i a = i.a(xg0Var);
            if (a == null) {
                return false;
            }
            try {
                z = ((Boolean) a.c(map)).booleanValue();
            } catch (Exception e) {
                bb1.c("evaluateExitExpression failed. ", e);
            }
        }
        if (z) {
            b();
            try {
                e(map);
            } catch (Exception e2) {
                bb1.c("execute exit expression failed: ", e2);
            }
            bb1.a("exit = true,consume finished");
        }
        return z;
    }

    protected abstract void e(@NonNull Map<String, Object> map);

    protected abstract void f(String str, @NonNull Map<String, Object> map);

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(@NonNull String str, @Nullable Map<String, Object> map, @Nullable xg0 xg0Var, @NonNull List<Map<String, Object>> list, @Nullable BindingXCore.JavaScriptCallback javaScriptCallback) {
        b();
        g(str, list);
        this.c = javaScriptCallback;
        this.j = xg0Var;
        if (!this.d.isEmpty()) {
            this.d.clear();
        }
        a();
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    @CallSuper
    public void onDestroy() {
        this.l.clear();
        BindingXPropertyInterceptor.c().b();
    }

    @Override // com.alibaba.android.bindingx.core.IEventInterceptor
    public void performInterceptIfNeeded(@NonNull String str, @NonNull xg0 xg0Var, @NonNull Map<String, Object> map) {
        i a;
        if (xg0.c(xg0Var) && (a = i.a(xg0Var)) != null) {
            boolean z = false;
            try {
                z = ((Boolean) a.c(map)).booleanValue();
            } catch (Exception e) {
                bb1.c("evaluate interceptor [" + str + "] expression failed. ", e);
            }
            if (z) {
                f(str, map);
            }
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setAnchorInstanceId(String str) {
        this.f = str;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setExtensionParams(Object[] objArr) {
        this.k = objArr;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setGlobalConfig(@Nullable Map<String, Object> map) {
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setHandlerCleaner(IHandlerCleanable iHandlerCleanable) {
        this.i = iHandlerCleanable;
    }

    @Override // com.alibaba.android.bindingx.core.IEventInterceptor
    public void setInterceptors(@Nullable Map<String, xg0> map) {
        this.b = map;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setOriginalParams(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            this.m = map;
        } else {
            this.m = Collections.emptyMap();
        }
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setToken(String str) {
        this.g = str;
    }
}
