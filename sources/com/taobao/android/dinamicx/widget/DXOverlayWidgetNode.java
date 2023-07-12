package com.taobao.android.dinamicx.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.abilitykit.AKIAbilityCallback;
import com.taobao.weex.annotation.JSMethod;
import com.youku.arch.v3.data.Constants;
import tb.C9192h;
import tb.C9392l;
import tb.C9587q0;
import tb.C9636r;
import tb.C9796v;
import tb.C9833w;
import tb.hy;
import tb.nz;
import tb.z10;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXOverlayWidgetNode extends C6493f {
    public static final long DXOVERLAY_ANIMATION = -60331626368423735L;
    public static final long DXOVERLAY_ANIMATIONTYPE = -7121038128194277777L;
    public static final long DXOVERLAY_EXITANIMATION = -5767894532178812313L;
    public static final long DXOVERLAY_MASK = 36153551024L;
    public static final long DXOVERLAY_MASKANIMATION = 5065226854897227865L;
    public static final long DXOVERLAY_MASKCOLOR = -2639343862509521740L;
    public static final long DXOVERLAY_NODEREF = 5139463086743887818L;
    public static final long DXOVERLAY_ONCLOSE = 5176469550471315930L;
    public static final long DXOVERLAY_OVERLAY = 3988216987803710313L;
    public static final long DXOVERLAY_POSITION = 5584520067254839933L;
    public static final long DXOVERLAY_SHOW = 37892802069L;
    public static final long DXOVERLAY_TYPE = 38200462374L;
    public static final long DXOVERLAY_ZINDEX = 10650399930384760L;
    private boolean a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private String g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    C9192h l;
    private JSONArray m;
    private DXTemplateWidgetNode n;
    private boolean o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXOverlayWidgetNode$a */
    /* loaded from: classes11.dex */
    public class C6445a implements AKIAbilityCallback {
        C6445a() {
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, C9392l c9392l) {
            if ("onClose".equals(str)) {
                DXOverlayWidgetNode.this.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXOverlayWidgetNode$b */
    /* loaded from: classes11.dex */
    public class C6446b implements AKIAbilityCallback {
        C6446b(DXOverlayWidgetNode dXOverlayWidgetNode) {
        }

        @Override // com.taobao.android.abilitykit.AKIAbilityCallback
        public void callback(String str, C9392l c9392l) {
            nz.s("dismiss pop " + str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXOverlayWidgetNode$c */
    /* loaded from: classes11.dex */
    public static class C6447c implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXOverlayWidgetNode();
        }
    }

    private void b() {
        if (this.l == null) {
            if (getDXRuntimeContext() != null && getDXRuntimeContext().getEngineContext() != null && getDXRuntimeContext().getEngineContext().b() != null) {
                this.l = getDXRuntimeContext().getEngineContext().b().a();
            }
            if (this.l == null) {
                this.l = new C9192h();
            }
        }
        DXTemplateWidgetNode dXTemplateWidgetNode = this.n;
        if (dXTemplateWidgetNode != null) {
            String str = (dXTemplateWidgetNode.getName() != null ? this.n.getName() : "") + JSMethod.NOT_SET + (this.n.getVersion() != null ? this.n.getVersion() : "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "dismissDxPop");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(C9833w.KEY_POP_ID, (Object) str);
            jSONObject.put("params", (Object) jSONObject2);
            C9636r c9636r = new C9636r(jSONObject);
            z10 z10Var = new z10();
            z10Var.d(this.l);
            z10Var.i(getDXRuntimeContext().getRootView());
            z10Var.e(getDXRuntimeContext().getContext());
            z10Var.g(((Activity) getDXRuntimeContext().getContext()).getWindow().getDecorView());
            this.l.b(c9636r, z10Var, new C6446b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        postEvent(new hy(DXOVERLAY_ONCLOSE));
        this.o = false;
        if (getChildAt(0) == null || getChildAt(0).getDXRuntimeContext() == null || getDXRuntimeContext() == null || getDXRuntimeContext().getEngineContext() == null || getDXRuntimeContext().getEngineContext().e() == null || getDXRuntimeContext().getEngineContext().e().j() == null) {
            return;
        }
        getDXRuntimeContext().getEngineContext().e().j().destroy(getChildAt(0).getDXRuntimeContext().getInstanceId());
    }

    private void d() {
        if (this.l == null) {
            if (getDXRuntimeContext() != null && getDXRuntimeContext().getEngineContext() != null && getDXRuntimeContext().getEngineContext().b() != null) {
                this.l = getDXRuntimeContext().getEngineContext().b().a();
            }
            if (this.l == null) {
                this.l = new C9192h();
                this.l.h(new C9587q0(getDXRuntimeContext().getBizType(), "DX"));
            }
        }
        DXTemplateWidgetNode dXTemplateWidgetNode = this.n;
        if (dXTemplateWidgetNode == null || this.o) {
            return;
        }
        String name = dXTemplateWidgetNode.getName() != null ? this.n.getName() : "";
        String version = this.n.getVersion() != null ? this.n.getVersion() : "";
        Object obj = name + JSMethod.NOT_SET + version;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "showDxPop");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(C9833w.KEY_POP_ID, obj);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(C9796v.TAK_ABILITY_SHOW_POP_ANIMATION, (Object) "bottomInOut");
        jSONObject3.put(C9796v.TAK_ABILITY_SHOW_POP_BACKGROUND_MODE, (Object) Integer.valueOf(this.f));
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("name", (Object) name);
        jSONObject5.put("version", (Object) version);
        jSONObject5.put("url", (Object) this.n.getUrl());
        jSONObject4.put(Constants.TEMPLATE, (Object) jSONObject5);
        jSONObject4.put("data", (Object) getDXRuntimeContext().getData());
        jSONObject4.put(C9833w.KEY_POP_ID, obj);
        jSONObject2.put("popConfig", (Object) jSONObject3);
        jSONObject2.put(C9796v.TAK_ABILITY_SHOW_POP_ANIMATION, "bottomInOut");
        jSONObject2.put("content", (Object) jSONObject4);
        jSONObject2.put("gravity", getLayoutGravity() == 4 ? "center" : "bottom");
        jSONObject.put("params", (Object) jSONObject2);
        C9636r c9636r = new C9636r(jSONObject);
        z10 z10Var = new z10();
        z10Var.d(this.l);
        z10Var.i(getDXRuntimeContext().getRootView());
        z10Var.e(getDXRuntimeContext().getContext());
        z10Var.g(((Activity) getDXRuntimeContext().getContext()).getWindow().getDecorView());
        this.l.b(c9636r, z10Var, new C6445a());
        this.o = true;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXOverlayWidgetNode();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONArray exportMethods() {
        if (this.m == null) {
            this.m = new JSONArray() { // from class: com.taobao.android.dinamicx.widget.DXOverlayWidgetNode.3
                {
                    add("dismiss");
                }
            };
            this.m.addAll(super.exportMethods());
        }
        return this.m;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONObject invokeRefMethod(String str, JSONArray jSONArray) {
        str.hashCode();
        if (!str.equals("dismiss")) {
            return super.invokeRefMethod(str, jSONArray);
        }
        b();
        return null;
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if (getChildrenCount() > 0 && (getChildAt(0) instanceof DXTemplateWidgetNode)) {
            this.n = (DXTemplateWidgetNode) getChildAt(0);
        }
        super.onBeforeBindChildData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXOverlayWidgetNode)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXOverlayWidgetNode dXOverlayWidgetNode = (DXOverlayWidgetNode) dXWidgetNode;
        this.a = dXOverlayWidgetNode.a;
        this.b = dXOverlayWidgetNode.b;
        this.c = dXOverlayWidgetNode.c;
        this.d = dXOverlayWidgetNode.d;
        this.e = dXOverlayWidgetNode.e;
        this.f = dXOverlayWidgetNode.f;
        this.g = dXOverlayWidgetNode.g;
        this.h = dXOverlayWidgetNode.h;
        this.i = dXOverlayWidgetNode.i;
        this.j = dXOverlayWidgetNode.j;
        this.k = dXOverlayWidgetNode.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        this.layoutHeight = 0;
        this.layoutWidth = 0;
        return super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        if (this.i) {
            d();
        }
        super.onRenderView(context, view);
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXOVERLAY_ANIMATION) {
            this.a = i != 0;
        } else if (j == DXOVERLAY_ANIMATIONTYPE) {
            this.b = i;
        } else if (j == DXOVERLAY_EXITANIMATION) {
            this.c = i != 0;
        } else if (j == DXOVERLAY_MASK) {
            this.d = i != 0;
        } else if (j == DXOVERLAY_MASKANIMATION) {
            this.e = i != 0;
        } else if (j == DXOVERLAY_MASKCOLOR) {
            this.f = i;
        } else if (j == DXOVERLAY_POSITION) {
            this.h = i;
        } else if (j == DXOVERLAY_SHOW) {
            this.i = i != 0;
        } else if (j == 38200462374L) {
            this.j = i;
        } else if (j == DXOVERLAY_ZINDEX) {
            this.k = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == DXOVERLAY_NODEREF) {
            this.g = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
