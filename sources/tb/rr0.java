package tb;

import android.util.Log;
import android.view.View;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.template.GXIExpression;
import com.youku.gaiax.api.data.EventParams;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class rr0 implements GXINodeEvent {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static final class a implements View.OnClickListener {
        final /* synthetic */ os0 a;
        final /* synthetic */ qr0 b;
        final /* synthetic */ JSONObject c;
        final /* synthetic */ String d;
        final /* synthetic */ Object e;

        a(os0 os0Var, qr0 qr0Var, JSONObject jSONObject, String str, Object obj) {
            this.a = os0Var;
            this.b = qr0Var;
            this.c = jSONObject;
            this.d = str;
            this.e = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GXIExpression a;
            GXTemplateEngine.GXITrackListener f;
            GXTemplateEngine.GXIEventListener c;
            GXTemplateEngine.h p = this.a.p();
            if (p != null && (c = p.c()) != null) {
                GXTemplateEngine.e eVar = new GXTemplateEngine.e();
                String str = this.d;
                qr0 qr0Var = this.b;
                Object obj = this.e;
                os0 os0Var = this.a;
                eVar.setGestureType(str);
                eVar.setView(qr0Var.q());
                b41.h(obj, "eventData");
                eVar.setEventParams((JSONObject) obj);
                eVar.setNodeId(qr0Var.o().i().d());
                eVar.setTemplateItem(os0Var.r());
                eVar.setIndex(-1);
                wt2 wt2Var = wt2.INSTANCE;
                c.onGestureEvent(eVar);
            }
            ss0 l = this.b.o().l();
            Object value = (l == null || (a = l.a()) == null) ? null : a.value(this.c);
            JSONObject jSONObject = value instanceof JSONObject ? (JSONObject) value : null;
            if (jSONObject == null) {
                return;
            }
            os0 os0Var2 = this.a;
            qr0 qr0Var2 = this.b;
            GXTemplateEngine.h p2 = os0Var2.p();
            if (p2 == null || (f = p2.f()) == null) {
                return;
            }
            GXTemplateEngine.k kVar = new GXTemplateEngine.k();
            kVar.i(qr0Var2.q());
            kVar.h(jSONObject);
            kVar.f(qr0Var2.o().i().d());
            kVar.g(os0Var2.r());
            kVar.e(-1);
            wt2 wt2Var2 = wt2.INSTANCE;
            f.onManualClickTrackEvent(kVar);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    static final class b implements View.OnLongClickListener {
        final /* synthetic */ os0 a;
        final /* synthetic */ qr0 b;
        final /* synthetic */ JSONObject c;
        final /* synthetic */ String d;
        final /* synthetic */ Object e;

        b(os0 os0Var, qr0 qr0Var, JSONObject jSONObject, String str, Object obj) {
            this.a = os0Var;
            this.b = qr0Var;
            this.c = jSONObject;
            this.d = str;
            this.e = obj;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            GXIExpression a;
            GXTemplateEngine.GXITrackListener f;
            GXTemplateEngine.GXIEventListener c;
            GXTemplateEngine.h p = this.a.p();
            if (p != null && (c = p.c()) != null) {
                GXTemplateEngine.e eVar = new GXTemplateEngine.e();
                String str = this.d;
                qr0 qr0Var = this.b;
                Object obj = this.e;
                os0 os0Var = this.a;
                eVar.setGestureType(str);
                eVar.setView(qr0Var.q());
                b41.h(obj, "eventData");
                eVar.setEventParams((JSONObject) obj);
                eVar.setNodeId(qr0Var.o().i().d());
                eVar.setTemplateItem(os0Var.r());
                eVar.setIndex(-1);
                wt2 wt2Var = wt2.INSTANCE;
                c.onGestureEvent(eVar);
            }
            ss0 l = this.b.o().l();
            Object value = (l == null || (a = l.a()) == null) ? null : a.value(this.c);
            JSONObject jSONObject = value instanceof JSONObject ? (JSONObject) value : null;
            if (jSONObject == null) {
                return true;
            }
            os0 os0Var2 = this.a;
            qr0 qr0Var2 = this.b;
            GXTemplateEngine.h p2 = os0Var2.p();
            if (p2 == null || (f = p2.f()) == null) {
                return true;
            }
            GXTemplateEngine.k kVar = new GXTemplateEngine.k();
            kVar.i(qr0Var2.q());
            kVar.h(jSONObject);
            kVar.f(qr0Var2.o().i().d());
            kVar.g(os0Var2.r());
            kVar.e(-1);
            wt2 wt2Var2 = wt2.INSTANCE;
            f.onManualClickTrackEvent(kVar);
            return true;
        }
    }

    @Override // com.alibaba.gaiax.render.node.GXINodeEvent
    public void addDataBindingEvent(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONObject, "templateData");
        vq0 g = qr0Var.o().g();
        if (g == null) {
            return;
        }
        Object value = g.a().value(jSONObject);
        JSONArray jSONArray = null;
        Object obj = value instanceof JSON ? (JSON) value : null;
        if (obj == null) {
            return;
        }
        if (obj instanceof JSONObject) {
            jSONArray = new JSONArray();
            jSONArray.add(obj);
        } else if (obj instanceof JSONArray) {
            jSONArray = obj;
        }
        if (jSONArray == null) {
            return;
        }
        Iterator<Object> it = jSONArray.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof JSONObject) {
                String string = ((JSONObject) next).getString("type");
                String str = string == null ? EventParams.CLICK_TYPE_TAP : string;
                if (b41.d(str, EventParams.CLICK_TYPE_TAP)) {
                    View q = qr0Var.q();
                    if (q != null) {
                        q.setOnClickListener(new a(os0Var, qr0Var, jSONObject, str, next));
                    }
                } else if (b41.d(str, "longpress")) {
                    View q2 = qr0Var.q();
                    if (q2 != null) {
                        q2.setOnLongClickListener(new b(os0Var, qr0Var, jSONObject, str, next));
                    }
                } else {
                    Log.e("[GaiaX]", b41.r("unknown event type ", str));
                }
            }
        }
    }
}
