package com.taobao.android.dinamicx;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.List;
import tb.g00;
import tb.ry;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.h */
/* loaded from: classes11.dex */
public class C6380h extends C6365b {
    LruCache<String, C6381a> d;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.h$a */
    /* loaded from: classes12.dex */
    public static class C6381a {
        public DXWidgetNode a;
        public C6368e b;

        public boolean a() {
            List<C6368e.C6369a> list;
            C6368e c6368e = this.b;
            return (c6368e == null || (list = c6368e.c) == null || list.size() <= 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C6380h(@NonNull C6367d c6367d) {
        super(c6367d);
        this.d = new LruCache<>(this.a.i());
    }

    public C6381a c(DXWidgetNode dXWidgetNode, C6368e c6368e) {
        C6381a c6381a = new C6381a();
        c6381a.a = dXWidgetNode;
        c6381a.b = c6368e;
        return c6381a;
    }

    public void d() {
        this.d.evictAll();
    }

    public C6381a e(DXRuntimeContext dXRuntimeContext) {
        return f(dXRuntimeContext.getCacheIdentify());
    }

    public C6381a f(String str) {
        LruCache<String, C6381a> lruCache;
        if (!this.a.s() || TextUtils.isEmpty(str) || (lruCache = this.d) == null) {
            return null;
        }
        return lruCache.get(str);
    }

    public boolean g(DXWidgetNode dXWidgetNode, DXRenderOptions dXRenderOptions) {
        if (!this.a.s() || dXRenderOptions.j()) {
            return false;
        }
        return (dXWidgetNode == null || dXWidgetNode.getParentWidget() == null) && dXRenderOptions.e() != 1;
    }

    public void h(DXRuntimeContext dXRuntimeContext, C6381a c6381a) {
        LruCache<String, C6381a> lruCache;
        String cacheIdentify = dXRuntimeContext.getCacheIdentify();
        if (!this.a.s() || TextUtils.isEmpty(cacheIdentify) || c6381a == null || (lruCache = this.d) == null) {
            return;
        }
        lruCache.put(cacheIdentify, c6381a);
    }

    public DXWidgetNode i(DXRuntimeContext dXRuntimeContext, View view) {
        DXWidgetNode dXWidgetNode;
        try {
            C6381a e = e(dXRuntimeContext);
            if (e == null || (dXWidgetNode = e.a) == null || dXRuntimeContext.getData() != dXWidgetNode.getDXRuntimeContext().getData()) {
                return null;
            }
            if (e.a()) {
                dXRuntimeContext.dxError.c.addAll(e.b.c);
            }
            dXWidgetNode.bindRuntimeContext(dXRuntimeContext, true);
            if (view != null) {
                view.setTag(g00.a, dXWidgetNode);
            }
            return dXWidgetNode;
        } catch (Exception e2) {
            DXAppMonitor.q(this.b, dXRuntimeContext.getDxTemplateItem(), "Render", "Render_Get_Expand_Tree_Crash", C6368e.GET_EXPAND_TREE_CRASH, ry.a(e2));
            return null;
        }
    }

    public void j(String str) {
        LruCache<String, C6381a> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.d) == null) {
            return;
        }
        lruCache.remove(str);
    }
}
