package com.taobao.android.dinamicx;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.List;
import tb.g00;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h extends b {
    LruCache<String, a> d;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class a {
        public DXWidgetNode a;
        public e b;

        public boolean a() {
            List<e.a> list;
            e eVar = this.b;
            return (eVar == null || (list = eVar.c) == null || list.size() <= 0) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(@NonNull d dVar) {
        super(dVar);
        this.d = new LruCache<>(this.a.i());
    }

    public a c(DXWidgetNode dXWidgetNode, e eVar) {
        a aVar = new a();
        aVar.a = dXWidgetNode;
        aVar.b = eVar;
        return aVar;
    }

    public void d() {
        this.d.evictAll();
    }

    public a e(DXRuntimeContext dXRuntimeContext) {
        return f(dXRuntimeContext.getCacheIdentify());
    }

    public a f(String str) {
        LruCache<String, a> lruCache;
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

    public void h(DXRuntimeContext dXRuntimeContext, a aVar) {
        LruCache<String, a> lruCache;
        String cacheIdentify = dXRuntimeContext.getCacheIdentify();
        if (!this.a.s() || TextUtils.isEmpty(cacheIdentify) || aVar == null || (lruCache = this.d) == null) {
            return;
        }
        lruCache.put(cacheIdentify, aVar);
    }

    public DXWidgetNode i(DXRuntimeContext dXRuntimeContext, View view) {
        DXWidgetNode dXWidgetNode;
        try {
            a e = e(dXRuntimeContext);
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
            DXAppMonitor.q(this.b, dXRuntimeContext.getDxTemplateItem(), "Render", "Render_Get_Expand_Tree_Crash", e.GET_EXPAND_TREE_CRASH, ry.a(e2));
            return null;
        }
    }

    public void j(String str) {
        LruCache<String, a> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.d) == null) {
            return;
        }
        lruCache.remove(str);
    }
}
