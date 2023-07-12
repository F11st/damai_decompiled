package tb;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.android.bindingx.core.BindingXEventType;
import com.alibaba.android.bindingx.plugin.android.NativeCallback;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.C6365b;
import com.taobao.android.dinamicx.C6367d;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.bindingx.DXBindingXViewUpdateManager;
import com.taobao.android.dinamicx.expression.event.bindingx.DXBindingXStateChangeEvent;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kt extends C6365b {
    ui1 d;
    mt e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.kt$a */
    /* loaded from: classes11.dex */
    public class C9374a implements NativeCallback {
        final /* synthetic */ nt a;
        final /* synthetic */ DXRootView b;
        final /* synthetic */ DXWidgetNode c;

        C9374a(nt ntVar, DXRootView dXRootView, DXWidgetNode dXWidgetNode) {
            this.a = ntVar;
            this.b = dXRootView;
            this.c = dXWidgetNode;
        }

        @Override // com.alibaba.android.bindingx.plugin.android.NativeCallback
        public void callback(Map<String, Object> map) {
            if (map == null) {
                return;
            }
            String str = null;
            try {
                if (DinamicXEngine.x()) {
                    nz.s(map.toString());
                }
                String str2 = (String) map.get("state");
                String str3 = (String) map.get("token");
                if ("exit".equals(str2)) {
                    if (DinamicXEngine.x()) {
                        nz.m("动画 " + this.a.a + "正常退出，收到bindingX  STATE_EXIT回调");
                    }
                    Map<String, Object> map2 = this.a.b;
                    if (map2 != null && ((String) map2.get("token")).equalsIgnoreCase(str3)) {
                        kt.this.B(null, this.a);
                        nt ntVar = this.a;
                        if (ntVar.i && ntVar.c.equalsIgnoreCase(BindingXEventType.TYPE_TIMING)) {
                            kt.this.f(this.b, this.a, this.c);
                            return;
                        }
                        nt ntVar2 = this.a;
                        if (ntVar2.d) {
                            kt.this.y(this.c, ntVar2, 2, ntVar2.g);
                        } else {
                            kt.this.y(this.c, ntVar2, 1, ntVar2.g);
                        }
                        kt.this.s(this.b, this.c, this.a);
                        kt.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXFINISH, this.a.a);
                    }
                } else if ("start".equalsIgnoreCase(str2)) {
                    if (DinamicXEngine.x()) {
                        nz.m("step3 -->  动画 " + this.a.a + "启动成功，收到bindingX  STATE_START回调");
                    }
                    if (this.a.c.equalsIgnoreCase(BindingXEventType.TYPE_TIMING)) {
                        kt.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTART, this.a.a);
                    }
                } else if ("end".equalsIgnoreCase(str2)) {
                    if (DinamicXEngine.x()) {
                        nz.m("动画 " + this.a.a + "手动退出，收到bindingX  STATE_END回调");
                    }
                } else if ("scrollStart".equalsIgnoreCase(str2)) {
                    kt.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTART, this.a.a);
                } else if ("scrollEnd".equalsIgnoreCase(str2)) {
                    JSONObject jSONObject = this.a.l;
                    if (jSONObject == null || jSONObject.isEmpty()) {
                        nt ntVar3 = this.a;
                        if (ntVar3.d) {
                            kt.this.y(this.c, ntVar3, 2, ntVar3.g);
                        } else {
                            kt.this.y(this.c, ntVar3, 1, ntVar3.g);
                        }
                    }
                    kt.this.l(this.c, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTOP, this.a.a);
                }
            } catch (Throwable th) {
                ry.b(th);
                DXWidgetNode dXWidgetNode = this.c;
                if (dXWidgetNode != null && dXWidgetNode.getDXRuntimeContext() != null) {
                    str = this.c.getDXRuntimeContext().getBizType();
                }
                if (TextUtils.isEmpty(str)) {
                    str = r10.DB_NAME;
                }
                DXAppMonitor.q(str, null, "DX_BindingX", "DX_BindingX_Crash", C6368e.BINDINGX_BINDINGX_CALL_BACK_CRASH, ry.a(th));
            }
        }
    }

    public kt(@NonNull C6367d c6367d) {
        super(c6367d);
        lt ltVar = new lt();
        DXBindingXViewUpdateManager dXBindingXViewUpdateManager = new DXBindingXViewUpdateManager();
        mt mtVar = new mt();
        this.e = mtVar;
        this.d = ui1.b(ltVar, null, dXBindingXViewUpdateManager, mtVar);
    }

    private void A(DXRootView dXRootView, DXWidgetNode dXWidgetNode, nt ntVar, boolean z, boolean z2, boolean z3) {
        Map<String, Object> map;
        if (ntVar == null || (map = ntVar.b) == null) {
            return;
        }
        this.d.e(map);
        B(null, ntVar);
        if (z2) {
            y(dXWidgetNode, ntVar, 2, z3);
        } else {
            y(dXWidgetNode, ntVar, 1, z3);
        }
        if (z) {
            s(dXRootView, dXWidgetNode, ntVar);
        }
        if (BindingXEventType.TYPE_TIMING.equalsIgnoreCase(ntVar.c)) {
            l(dXWidgetNode, DXBindingXStateChangeEvent.DXVIEWWIDGETNODE_ONBINDINGXSTOP, ntVar.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Map<String, Object> map, nt ntVar) {
        ntVar.b = map;
    }

    private DXWidgetNode h(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return null;
        }
        return dXWidgetNode.isFlatten() ? dXWidgetNode : dXWidgetNode.getReferenceNode();
    }

    private String i(String str, JSONArray jSONArray) {
        StringBuilder sb = new StringBuilder();
        sb.append("msg :action: ");
        sb.append(str);
        sb.append("  spec: ");
        sb.append(jSONArray);
        return sb.toString() == null ? " spec is null" : JSON.toJSONString(jSONArray);
    }

    private boolean j(JSONObject jSONObject) {
        String string = jSONObject.getString("property");
        return "transform.translate".equals(string) || "transform.translateX".equals(string) || "transform.translateY".equals(string) || "width".equals(string) || "height".equals(string);
    }

    private Object n(Map<String, Object> map, String str, String str2) {
        if (str.length() < 2) {
            return str;
        }
        String substring = str.substring(1);
        if (map == null || !map.containsKey(substring)) {
            return "";
        }
        Object obj = map.get(substring);
        if (!"StringLiteral".equals(str2) || str.startsWith("'")) {
            return obj;
        }
        return "'" + obj + "'";
    }

    private void o(DXWidgetNode dXWidgetNode, JSONObject jSONObject, int i, boolean z) {
        DXWidgetNode queryWidgetNodeByUserId;
        ViewGroup.LayoutParams layoutParams;
        View nativeView;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        View nativeView2;
        ViewGroup.LayoutParams layoutParams4;
        View nativeView3;
        Drawable background;
        View nativeView4;
        View nativeView5;
        View nativeView6;
        View nativeView7;
        View nativeView8;
        View nativeView9;
        View nativeView10;
        View nativeView11;
        View nativeView12;
        View nativeView13;
        View nativeView14;
        String string = jSONObject.getString("property");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        DXWidgetNode dXWidgetNode2 = null;
        WeakReference weakReference = (WeakReference) jSONObject.get("element_widgetnode");
        if (weakReference != null && weakReference.get() != null) {
            queryWidgetNodeByUserId = (DXWidgetNode) weakReference.get();
        } else {
            String u = u(jSONObject.getString("element"));
            if ("this".equalsIgnoreCase(u)) {
                dXWidgetNode2 = dXWidgetNode;
            } else if (!wt.P0(dXWidgetNode.getDXRuntimeContext())) {
                dXWidgetNode2 = dXWidgetNode.queryWTByUserId(u);
            }
            queryWidgetNodeByUserId = dXWidgetNode2 == null ? dXWidgetNode.queryWidgetNodeByUserId(u) : dXWidgetNode2;
            if (queryWidgetNodeByUserId == null) {
                return;
            }
            jSONObject.put("element_widgetnode", (Object) new WeakReference(queryWidgetNodeByUserId));
        }
        if ("opacity".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView14 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView14.setAlpha(queryWidgetNodeByUserId.getAlpha());
                    return;
                }
                return;
            }
            View nativeView15 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView15 == null) {
                return;
            }
            if (!z) {
                queryWidgetNodeByUserId.setAlpha(nativeView15.getAlpha());
            }
            DXWidgetNode h = h(queryWidgetNodeByUserId);
            if (h != null) {
                h.setAlpha(nativeView15.getAlpha());
            }
        } else if ("transform.translate".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView13 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView13.setTranslationX(queryWidgetNodeByUserId.getTranslateX());
                    nativeView13.setTranslationY(queryWidgetNodeByUserId.getTranslateY());
                    return;
                }
                return;
            }
            View nativeView16 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView16 == null) {
                return;
            }
            float translationX = nativeView16.getTranslationX();
            float translationY = nativeView16.getTranslationY();
            if (!z) {
                queryWidgetNodeByUserId.setTranslateX(translationX);
                queryWidgetNodeByUserId.setTranslateY(translationY);
            }
            DXWidgetNode h2 = h(queryWidgetNodeByUserId);
            if (h2 != null) {
                h2.setTranslateX(translationX);
                h2.setTranslateY(translationY);
            }
        } else if ("transform.translateX".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView12 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView12.setTranslationX(queryWidgetNodeByUserId.getTranslateX());
                    return;
                }
                return;
            }
            View nativeView17 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView17 == null) {
                return;
            }
            float translationX2 = nativeView17.getTranslationX();
            if (!z) {
                queryWidgetNodeByUserId.setTranslateX(translationX2);
            }
            DXWidgetNode h3 = h(queryWidgetNodeByUserId);
            if (h3 != null) {
                h3.setTranslateX(translationX2);
            }
        } else if ("transform.translateY".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView11 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView11.setTranslationY(queryWidgetNodeByUserId.getTranslateY());
                    return;
                }
                return;
            }
            View nativeView18 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView18 == null) {
                return;
            }
            float translationY2 = nativeView18.getTranslationY();
            if (!z) {
                queryWidgetNodeByUserId.setTranslateY(translationY2);
            }
            DXWidgetNode h4 = h(queryWidgetNodeByUserId);
            if (h4 != null) {
                h4.setTranslateY(translationY2);
            }
        } else if ("transform.scale".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView10 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView10.setScaleX(queryWidgetNodeByUserId.getScaleX());
                    nativeView10.setScaleY(queryWidgetNodeByUserId.getScaleY());
                    return;
                }
                return;
            }
            View nativeView19 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView19 == null) {
                return;
            }
            float scaleX = nativeView19.getScaleX();
            float scaleY = nativeView19.getScaleY();
            if (!z) {
                queryWidgetNodeByUserId.setScaleX(scaleX);
                queryWidgetNodeByUserId.setScaleY(scaleY);
            }
            DXWidgetNode h5 = h(queryWidgetNodeByUserId);
            if (h5 != null) {
                h5.setScaleX(scaleX);
                h5.setScaleY(scaleY);
            }
        } else if ("transform.scaleX".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView9 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView9.setScaleX(queryWidgetNodeByUserId.getScaleX());
                    return;
                }
                return;
            }
            View nativeView20 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView20 == null) {
                return;
            }
            float scaleX2 = nativeView20.getScaleX();
            if (!z) {
                queryWidgetNodeByUserId.setScaleX(scaleX2);
            }
            DXWidgetNode h6 = h(queryWidgetNodeByUserId);
            if (h6 != null) {
                h6.setScaleX(scaleX2);
            }
        } else if ("transform.scaleY".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView8 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView8.setScaleY(queryWidgetNodeByUserId.getScaleY());
                    return;
                }
                return;
            }
            View nativeView21 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView21 == null) {
                return;
            }
            float scaleY2 = nativeView21.getScaleY();
            if (!z) {
                queryWidgetNodeByUserId.setScaleY(scaleY2);
            }
            DXWidgetNode h7 = h(queryWidgetNodeByUserId);
            if (h7 != null) {
                h7.setScaleY(scaleY2);
            }
        } else if ("transform.rotateX".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView7 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView7.setRotationX(queryWidgetNodeByUserId.getRotationX());
                    return;
                }
                return;
            }
            View nativeView22 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView22 == null) {
                return;
            }
            float rotationX = nativeView22.getRotationX();
            if (!z) {
                queryWidgetNodeByUserId.setRotationX(rotationX);
            }
            DXWidgetNode h8 = h(queryWidgetNodeByUserId);
            if (h8 != null) {
                h8.setRotationX(rotationX);
            }
        } else if ("transform.rotateY".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView6 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView6.setRotationY(queryWidgetNodeByUserId.getRotationY());
                    return;
                }
                return;
            }
            View nativeView23 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView23 == null) {
                return;
            }
            float rotationY = nativeView23.getRotationY();
            if (!z) {
                queryWidgetNodeByUserId.setRotationY(rotationY);
            }
            DXWidgetNode h9 = h(queryWidgetNodeByUserId);
            if (h9 != null) {
                h9.setRotationY(rotationY);
            }
        } else if ("transform.rotateZ".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView5 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView5.setRotation(queryWidgetNodeByUserId.getRotationZ());
                    return;
                }
                return;
            }
            View nativeView24 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView24 == null) {
                return;
            }
            float rotation = nativeView24.getRotation();
            if (!z) {
                queryWidgetNodeByUserId.setRotationZ(rotation);
            }
            DXWidgetNode h10 = h(queryWidgetNodeByUserId);
            if (h10 != null) {
                h10.setRotationZ(rotation);
            }
        } else if ("background-color".equals(string)) {
            if (i != 1) {
                if (i == 2 && (nativeView4 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null) {
                    nativeView4.setBackgroundColor(queryWidgetNodeByUserId.getBackGroundColor());
                    return;
                }
                return;
            }
            View nativeView25 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView25 == null || (background = nativeView25.getBackground()) == null || !(background instanceof ColorDrawable)) {
                return;
            }
            if (!z) {
                queryWidgetNodeByUserId.setBackGroundColor(((ColorDrawable) background).getColor());
            }
            DXWidgetNode h11 = h(queryWidgetNodeByUserId);
            if (h11 == null) {
                return;
            }
            h11.setBackGroundColor(((ColorDrawable) background).getColor());
        } else if ("color".equals(string)) {
            if (queryWidgetNodeByUserId instanceof DXTextViewWidgetNode) {
                if (i != 1) {
                    if (i == 2 && (nativeView3 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) != null && (nativeView3 instanceof TextView)) {
                        ((TextView) nativeView3).setTextColor(((DXTextViewWidgetNode) queryWidgetNodeByUserId).g());
                        return;
                    }
                    return;
                }
                View nativeView26 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
                if (nativeView26 == null || !(nativeView26 instanceof TextView)) {
                    return;
                }
                int currentTextColor = ((TextView) nativeView26).getCurrentTextColor();
                if (!z) {
                    ((DXTextViewWidgetNode) queryWidgetNodeByUserId).u(currentTextColor);
                }
                DXWidgetNode h12 = h(queryWidgetNodeByUserId);
                if (h12 == null || !(h12 instanceof DXTextViewWidgetNode)) {
                    return;
                }
                ((DXTextViewWidgetNode) h12).u(currentTextColor);
            }
        } else if ("width".equals(string)) {
            if (i != 1) {
                if (i != 2 || (nativeView2 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) == null || (layoutParams4 = nativeView2.getLayoutParams()) == null) {
                    return;
                }
                layoutParams4.width = queryWidgetNodeByUserId.getMeasuredWidth();
                nativeView2.setLayoutParams(layoutParams4);
                return;
            }
            View nativeView27 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView27 == null || (layoutParams3 = nativeView27.getLayoutParams()) == null) {
                return;
            }
            int i2 = layoutParams3.width;
            if (!z) {
                queryWidgetNodeByUserId.setMeasuredDimension(i2, queryWidgetNodeByUserId.getMeasuredHeight());
            }
            DXWidgetNode h13 = h(queryWidgetNodeByUserId);
            if (h13 != null) {
                h13.setMeasuredDimension(i2, h13.getMeasuredHeight());
            }
        } else if ("height".equals(string)) {
            if (i != 1) {
                if (i != 2 || (nativeView = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView()) == null || (layoutParams2 = nativeView.getLayoutParams()) == null) {
                    return;
                }
                layoutParams2.height = queryWidgetNodeByUserId.getMeasuredHeight();
                nativeView.setLayoutParams(layoutParams2);
                return;
            }
            View nativeView28 = queryWidgetNodeByUserId.getDXRuntimeContext().getNativeView();
            if (nativeView28 == null || (layoutParams = nativeView28.getLayoutParams()) == null) {
                return;
            }
            int i3 = layoutParams.height;
            if (!z) {
                queryWidgetNodeByUserId.setMeasuredDimension(queryWidgetNodeByUserId.getMeasuredWidth(), i3);
            }
            DXWidgetNode h14 = h(queryWidgetNodeByUserId);
            if (h14 != null) {
                h14.setMeasuredDimension(h14.getMeasuredWidth(), i3);
            }
        }
    }

    private void p(JSONObject jSONObject, String str) {
        if (jSONObject == null || this.e == null) {
            return;
        }
        String string = jSONObject.getString("sourceId");
        if (DinamicXEngine.x()) {
            nz.m("step1--> 收到scroller bindingx消息:  action " + str + " sourceId " + string);
        }
        int intValue = jSONObject.containsKey("offsetX") ? jSONObject.getInteger("offsetX").intValue() : 0;
        int intValue2 = jSONObject.containsKey("offsetY") ? jSONObject.getInteger("offsetY").intValue() : 0;
        JSONObject jSONObject2 = jSONObject.getJSONObject("args");
        if ("scroll_beigin".equalsIgnoreCase(str)) {
            this.e.c(string, intValue, intValue2, jSONObject2);
        } else if ("scrolling".equalsIgnoreCase(str)) {
            this.e.d(string, intValue, intValue2, jSONObject2);
        } else if ("scroll_end".equalsIgnoreCase(str)) {
            this.e.b(string, intValue, intValue2, jSONObject2);
        }
    }

    private void q(nt ntVar, Map<String, Object> map) {
        JSONArray jSONArray = ntVar.j;
        if (jSONArray != null) {
            int size = jSONArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                z(jSONObject.getJSONObject(DXTraceUtil.TYPE_EXPRESSION_STRING).getJSONObject("transformed"), map, j(jSONObject));
            }
        }
        JSONObject jSONObject2 = ntVar.l;
        if (jSONObject2 != null) {
            z(jSONObject2.getJSONObject("transformed"), map, false);
        }
    }

    private void r(DXRootView dXRootView, DXWidgetNode dXWidgetNode, nt ntVar) {
        if (dXRootView == null || dXWidgetNode == null || ntVar == null) {
            return;
        }
        dXWidgetNode.putBindingXExecutingSpec(ntVar);
        dXRootView._addAnimationWidget(dXWidgetNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(DXRootView dXRootView, DXWidgetNode dXWidgetNode, nt ntVar) {
        if (dXRootView == null || dXWidgetNode == null || ntVar == null) {
            return;
        }
        dXWidgetNode.removeBindingXSpec(ntVar);
        if (dXWidgetNode.hasExecutingAnimationSpec()) {
            return;
        }
        dXRootView._removeAnimationWidget(dXWidgetNode);
    }

    public static String u(String str) {
        return (TextUtils.isEmpty(str) || !str.startsWith(m80.DINAMIC_PREFIX_AT)) ? str : str.substring(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(DXWidgetNode dXWidgetNode, nt ntVar, int i, boolean z) {
        JSONArray jSONArray = ntVar.j;
        int size = jSONArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            o(dXWidgetNode, jSONArray.getJSONObject(i2), i, z);
        }
    }

    private void z(JSONObject jSONObject, Map<String, Object> map, boolean z) {
        Object obj;
        if (jSONObject == null) {
            return;
        }
        String string = jSONObject.getString("type");
        Object obj2 = jSONObject.get("value");
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.startsWith("$")) {
                obj2 = n(map, str, string);
            }
        }
        if (z) {
            try {
                if ("NumericLiteral".equals(string) && (obj2 instanceof String)) {
                    String str2 = (String) obj2;
                    if (str2.endsWith("ap")) {
                        obj2 = Integer.valueOf(z00.b(DinamicXEngine.i(), Float.parseFloat(str2.substring(0, str2.length() - 2))));
                    } else if (((String) obj2).endsWith(d90.DIMEN_SUFFIX_NP)) {
                        obj2 = Integer.valueOf(z00.c(DinamicXEngine.i(), Float.parseFloat(str2.substring(0, str2.length() - 2))));
                    }
                }
            } catch (Throwable th) {
                ry.b(th);
                obj = 0;
            }
        }
        obj = obj2;
        jSONObject.put("value", obj);
        JSONArray jSONArray = jSONObject.getJSONArray(RichTextNode.CHILDREN);
        if (jSONArray == null || jSONArray.size() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            z(jSONArray.getJSONObject(i), map, z);
        }
    }

    void f(DXRootView dXRootView, nt ntVar, DXWidgetNode dXWidgetNode) {
        View nativeView = dXWidgetNode.getDXRuntimeContext().getNativeView();
        if (nativeView != null) {
            nativeView.setTag(g00.b, dXWidgetNode);
        }
        if (DinamicXEngine.x()) {
            nz.m("step2.1 -->  开始进入启动动画 " + ntVar.a + "的bindAnimation阶段");
        }
        Map<String, Object> a = this.d.a(nativeView, ntVar.k, new C9374a(ntVar, dXRootView, dXWidgetNode));
        if (a == null || a.isEmpty()) {
            return;
        }
        B(a, ntVar);
        r(dXRootView, dXWidgetNode, ntVar);
    }

    public ui1 g() {
        return this.d;
    }

    public nt k(String str, String str2, Map<String, Object> map) {
        JSONObject jSONObject;
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (jSONObject = JSON.parseObject(str2).getJSONObject(str)) == null) {
            return null;
        }
        nt ntVar = new nt();
        ntVar.a = str;
        ntVar.c = jSONObject.getString("eventType");
        ntVar.k = jSONObject;
        ntVar.h = "true".equalsIgnoreCase(jSONObject.getString("useConstantArgs"));
        if (map != null && map.containsKey("resetOnStop")) {
            string = (String) map.get("resetOnStop");
        } else {
            string = jSONObject.getString("resetOnStop");
        }
        if (!TextUtils.isEmpty(string)) {
            ntVar.e = !string.equalsIgnoreCase("false");
        }
        if (map != null && map.containsKey("resetOnFinish")) {
            string2 = (String) map.get("resetOnFinish");
        } else {
            string2 = jSONObject.getString("resetOnFinish");
        }
        if (!TextUtils.isEmpty(string2)) {
            ntVar.d = !string2.equalsIgnoreCase("false");
        }
        if (!ntVar.e) {
            if (map != null && map.containsKey("updateFlattenOnlyOnStop")) {
                string5 = (String) map.get("updateFlattenOnlyOnStop");
            } else {
                string5 = jSONObject.getString("updateFlattenOnlyOnStop");
            }
            if (!TextUtils.isEmpty(string5)) {
                ntVar.f = "true".equalsIgnoreCase(string5);
            }
        }
        if (!ntVar.d) {
            if (map != null && map.containsKey("updateFlattenOnlyOnFinish")) {
                string4 = (String) map.get("updateFlattenOnlyOnFinish");
            } else {
                string4 = jSONObject.getString("updateFlattenOnlyOnFinish");
            }
            if (!TextUtils.isEmpty(string4)) {
                ntVar.g = "true".equalsIgnoreCase(string4);
            }
        }
        if (map != null && map.containsKey("repeat")) {
            string3 = (String) map.get("repeat");
        } else {
            string3 = jSONObject.getString("repeat");
        }
        if (!TextUtils.isEmpty(string3)) {
            ntVar.i = string3.equals("true");
        }
        ntVar.j = jSONObject.getJSONArray("props");
        ntVar.l = jSONObject.getJSONObject("exitExpression");
        q(ntVar, map);
        return ntVar;
    }

    void l(DXWidgetNode dXWidgetNode, long j, String str) {
        if (dXWidgetNode == null) {
            return;
        }
        dXWidgetNode.postEvent(new DXBindingXStateChangeEvent(j, str));
    }

    public void m(DXRootView dXRootView, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (this.d == null || jSONObject == null || (jSONObject2 = jSONObject.getJSONObject("params")) == null) {
            return;
        }
        String string = jSONObject2.getString("action");
        if ("scrolling".equalsIgnoreCase(string) || "scroll_beigin".equalsIgnoreCase(string) || "scroll_end".equalsIgnoreCase(string)) {
            p(jSONObject2, string);
        } else if (dXRootView == null) {
            nz.o("processDXMsg timing动画，必须要有rootview");
        } else {
            JSONArray jSONArray = jSONObject2.getJSONArray("spec");
            if (DinamicXEngine.x()) {
                nz.m("step1--> 收到bindingx消息: " + i(string, jSONArray));
            }
            Object obj = jSONObject2.get("widget");
            if (obj instanceof DXWidgetNode) {
                DXWidgetNode dXWidgetNode = (DXWidgetNode) obj;
                if (ot.b(dXWidgetNode) != dXRootView.getExpandWidgetNode()) {
                    if (DinamicXEngine.x()) {
                        nz.o("rootView 被复用 动画操作失败" + i(string, jSONArray));
                        return;
                    }
                    return;
                }
                JSONObject jSONObject3 = jSONObject2.getJSONObject("args");
                if ("start".equalsIgnoreCase(string)) {
                    v(dXRootView, dXWidgetNode, jSONArray, jSONObject3);
                } else if ("stop".equalsIgnoreCase(string)) {
                    x(dXRootView, dXWidgetNode, jSONArray);
                }
            }
        }
    }

    public void t(DXRootView dXRootView) {
        List<DXWidgetNode> _getAnimationWidgets;
        if (dXRootView == null || (_getAnimationWidgets = dXRootView._getAnimationWidgets()) == null || _getAnimationWidgets.isEmpty()) {
            return;
        }
        for (DXWidgetNode dXWidgetNode : _getAnimationWidgets) {
            Map<String, nt> bindingXExecutingMap = dXWidgetNode.getBindingXExecutingMap();
            if (bindingXExecutingMap != null && bindingXExecutingMap.size() > 0) {
                for (nt ntVar : bindingXExecutingMap.values()) {
                    A(dXRootView, dXWidgetNode, ntVar, false, true, false);
                }
                bindingXExecutingMap.clear();
            }
        }
        dXRootView._clearAnimationWidgets();
    }

    public void v(DXRootView dXRootView, DXWidgetNode dXWidgetNode, JSONArray jSONArray, Map<String, Object> map) {
        if (jSONArray == null || jSONArray.isEmpty()) {
            return;
        }
        for (int i = 0; i < jSONArray.size(); i++) {
            String string = jSONArray.getString(i);
            if (DinamicXEngine.x()) {
                nz.m("step2---> 开始启动" + string + "动画");
            }
            w(dXRootView, dXWidgetNode, string, map);
        }
    }

    public void w(DXRootView dXRootView, DXWidgetNode dXWidgetNode, String str, Map<String, Object> map) {
        nt ntVar;
        if (dXWidgetNode == null) {
            nz.o("启动" + str + "动画失败 原因为animationWidget == null");
            return;
        }
        DXWidgetNode queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode();
        if (dXRootView != null && this.d != null && !TextUtils.isEmpty(queryRootWidgetNode.getAnimation()) && queryRootWidgetNode.getDXRuntimeContext() != null && !TextUtils.isEmpty(str)) {
            if (dXWidgetNode.containsExecutingAnimationSpec(str)) {
                if (DinamicXEngine.x()) {
                    nz.o("启动" + str + "动画失败 原因为animationWidget.containsExecutingAnimationSpec(specName)");
                    return;
                }
                return;
            }
            nt ntVar2 = null;
            Map<String, nt> bindingXSpecMap = dXWidgetNode.getBindingXSpecMap();
            if (bindingXSpecMap != null && (ntVar = bindingXSpecMap.get(str)) != null && (ntVar.h || map == null || map.isEmpty())) {
                ntVar2 = ntVar;
            }
            if (ntVar2 == null) {
                ntVar2 = k(str, queryRootWidgetNode.getAnimation(), map);
            }
            if (ntVar2 == null) {
                if (DinamicXEngine.x()) {
                    nz.o("启动" + str + "动画失败 原因为对应的动画描述是空 请检查对应的bindingx.json是否有误");
                    return;
                }
                return;
            }
            if (bindingXSpecMap == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(str, ntVar2);
                dXWidgetNode.setBindingXSpecMap(hashMap);
            } else {
                bindingXSpecMap.put(str, ntVar2);
            }
            if (ntVar2.b != null) {
                if (DinamicXEngine.x()) {
                    nz.o("启动" + str + "动画失败  当前动画已经在运行");
                    return;
                }
                return;
            }
            f(dXRootView, ntVar2, dXWidgetNode);
        } else if (DinamicXEngine.x()) {
            nz.o("启动" + str + "动画失败 原因为rootView == null || animationWidget == null || bindingX == null\n                || TextUtils.isEmpty(rootWidget.getAnimation())\n                || rootWidget.getDXRuntimeContext() == null\n                || TextUtils.isEmpty(specName)");
        }
    }

    public void x(DXRootView dXRootView, DXWidgetNode dXWidgetNode, JSONArray jSONArray) {
        Map<String, nt> bindingXExecutingMap;
        if (this.d == null || dXWidgetNode.getDXRuntimeContext() == null || dXRootView == null || !dXRootView._containAnimationWidget(dXWidgetNode) || (bindingXExecutingMap = dXWidgetNode.getBindingXExecutingMap()) == null || bindingXExecutingMap.isEmpty()) {
            return;
        }
        if (jSONArray != null && !jSONArray.isEmpty()) {
            for (int i = 0; i < jSONArray.size(); i++) {
                nt ntVar = bindingXExecutingMap.get(jSONArray.getString(i));
                if (ntVar != null) {
                    A(dXRootView, dXWidgetNode, ntVar, true, ntVar.e, ntVar.f);
                }
            }
            return;
        }
        for (nt ntVar2 : bindingXExecutingMap.values()) {
            if (ntVar2 != null) {
                A(dXRootView, dXWidgetNode, ntVar2, false, ntVar2.e, ntVar2.f);
            }
        }
        bindingXExecutingMap.clear();
        dXRootView._removeAnimationWidget(dXWidgetNode);
    }
}
