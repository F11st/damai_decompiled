package com.taobao.android.dinamicx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.model.DXPools$DXPoolItem;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.nested.DXNestedScrollerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.g00;
import tb.kt;
import tb.n20;
import tb.o20;
import tb.pz;
import tb.r10;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXRootView extends DXNativeFrameLayout implements DXPools$DXPoolItem {
    List<DXWidgetNode> animationWidgets;
    WeakReference<kt> bindingXManagerWeakReference;
    JSONObject data;
    DXNestedScrollerView dxNestedScrollerView;
    DXTemplateItem dxTemplateItem;
    int parentHeightSpec;
    int parentWidthSpec;
    private int position;
    a rootViewLifeCycle;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static abstract class a {
        public void a(int i) {
        }

        public void b(DXRootView dXRootView, int i) {
            a(i);
        }

        protected abstract void c(DXRootView dXRootView);

        protected abstract void d(DXRootView dXRootView);

        protected void e() {
        }

        protected void f(DXRootView dXRootView) {
            e();
        }

        protected void g() {
        }

        protected void h(DXRootView dXRootView) {
            g();
        }

        protected abstract void i(@NonNull View view, int i);

        protected abstract void j(DXRootView dXRootView, int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DXRootView(@NonNull Context context) {
        super(context);
    }

    private void trackError(int i, Throwable th) {
        ry.b(th);
        String str = getBindingXManager() != null ? getBindingXManager().b : null;
        if (TextUtils.isEmpty(str)) {
            str = r10.DB_NAME;
        }
        DXAppMonitor.q(str, getDxTemplateItem(), "native", "native_crash", i, ry.a(th));
    }

    public void _addAnimationWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return;
        }
        if (this.animationWidgets == null) {
            this.animationWidgets = new ArrayList();
        }
        if (this.animationWidgets.contains(dXWidgetNode)) {
            return;
        }
        this.animationWidgets.add(dXWidgetNode);
    }

    public void _clearAnimationWidgets() {
        this.animationWidgets = new ArrayList();
    }

    public boolean _containAnimationWidget(DXWidgetNode dXWidgetNode) {
        List<DXWidgetNode> list;
        if (dXWidgetNode == null || (list = this.animationWidgets) == null || list.size() == 0) {
            return false;
        }
        return this.animationWidgets.contains(dXWidgetNode);
    }

    public List<DXWidgetNode> _getAnimationWidgets() {
        return this.animationWidgets;
    }

    public void _removeAnimationWidget(DXWidgetNode dXWidgetNode) {
        List<DXWidgetNode> list = this.animationWidgets;
        if (list == null) {
            return;
        }
        list.remove(dXWidgetNode);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowVisibilityChanged(int i) {
        try {
            super.dispatchWindowVisibilityChanged(i);
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.b(this, i);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_7, th);
        }
    }

    public kt getBindingXManager() {
        WeakReference<kt> weakReference = this.bindingXManagerWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public JSONObject getData() {
        return this.data;
    }

    public DXNestedScrollerView getDxNestedScrollerView() {
        if (this.dxNestedScrollerView == null) {
            this.dxNestedScrollerView = new DXNestedScrollerView(getContext());
        }
        return this.dxNestedScrollerView;
    }

    public DXTemplateItem getDxTemplateItem() {
        return this.dxTemplateItem;
    }

    public DXWidgetNode getExpandWidgetNode() {
        return (DXWidgetNode) getTag(g00.a);
    }

    public DXWidgetNode getFlattenWidgetNode() {
        return (DXWidgetNode) getTag(DXWidgetNode.TAG_WIDGET_NODE);
    }

    @Override // com.taobao.android.dinamicx.model.DXPools$DXPoolItem
    public Object getKey() {
        return this.data;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean hasDXRootViewLifeCycle() {
        return this.rootViewLifeCycle != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.c(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_11, th);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.d(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_10, th);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        try {
            super.onFinishTemporaryDetach();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.f(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_13, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRootViewAppear(int i) {
        n20 n20Var = new n20(5288671110273408574L);
        n20Var.f(i);
        DXWidgetNode expandWidgetNode = getExpandWidgetNode();
        if (expandWidgetNode == null) {
            return;
        }
        expandWidgetNode.sendBroadcastEvent(n20Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRootViewDisappear(int i) {
        o20 o20Var = new o20(5388973340095122049L);
        o20Var.f(i);
        DXWidgetNode expandWidgetNode = getExpandWidgetNode();
        if (expandWidgetNode == null) {
            return;
        }
        expandWidgetNode.sendBroadcastEvent(o20Var);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        try {
            super.onStartTemporaryDetach();
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.h(this);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_12, th);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        try {
            super.onVisibilityChanged(view, i);
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.i(view, i);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_9, th);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
            a aVar = this.rootViewLifeCycle;
            if (aVar != null) {
                aVar.j(this, i);
            }
        } catch (Throwable th) {
            trackError(e.DX_NATIVE_CRASH_8, th);
        }
    }

    public void postMessage(Object obj) {
        JSONObject jSONObject;
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                String string = jSONObject2.getString("type");
                if ("BNDX".equalsIgnoreCase(string) && getBindingXManager() != null) {
                    getBindingXManager().m(this, jSONObject2);
                } else {
                    DXWidgetNode expandWidgetNode = getExpandWidgetNode();
                    if (expandWidgetNode == null || (jSONObject = jSONObject2.getJSONObject("params")) == null) {
                        return;
                    }
                    String string2 = jSONObject.getString("targetId");
                    pz pzVar = new pz(-1747756056147111305L);
                    pzVar.j(jSONObject);
                    pzVar.k(string2);
                    pzVar.l(string);
                    DXWidgetNode queryWidgetNodeByUserId = expandWidgetNode.queryWidgetNodeByUserId(string2);
                    if (queryWidgetNodeByUserId != null && queryWidgetNodeByUserId.getReferenceNode() != null) {
                        queryWidgetNodeByUserId.postEvent(pzVar);
                    } else {
                        expandWidgetNode.sendBroadcastEvent(pzVar);
                    }
                }
            }
        } catch (Throwable th) {
            ry.b(th);
            String str = getBindingXManager() != null ? getBindingXManager().b : null;
            if (TextUtils.isEmpty(str)) {
                str = r10.DB_NAME;
            }
            DXAppMonitor.q(str, null, "DX_BindingX", "DX_BindingX_Crash", e.BINDINGX_POST_MSG_CRASH, ry.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerDXRootViewLifeCycle(a aVar) {
        this.rootViewLifeCycle = aVar;
    }

    public void setBindingXManagerWeakReference(kt ktVar) {
        this.bindingXManagerWeakReference = new WeakReference<>(ktVar);
    }

    void setExpandWidgetNode(DXWidgetNode dXWidgetNode) {
        setTag(g00.a, dXWidgetNode);
    }

    void setFlattenWidgetNode(DXWidgetNode dXWidgetNode) {
        setTag(DXWidgetNode.TAG_WIDGET_NODE, dXWidgetNode);
    }

    public void setMeasureDimension(int i, int i2) {
        setMeasuredDimension(i, i2);
    }

    public void setPosition(int i) {
        this.position = i;
    }

    DXRootView(@NonNull Context context, DXWidgetNode dXWidgetNode) {
        super(context);
        setExpandWidgetNode(dXWidgetNode);
    }
}
