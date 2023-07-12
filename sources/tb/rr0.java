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
    /* renamed from: tb.rr0$a */
    /* loaded from: classes6.dex */
    static final class View$OnClickListenerC9661a implements View.OnClickListener {
        final /* synthetic */ os0 a;
        final /* synthetic */ qr0 b;
        final /* synthetic */ JSONObject c;
        final /* synthetic */ String d;
        final /* synthetic */ Object e;

        View$OnClickListenerC9661a(os0 os0Var, qr0 qr0Var, JSONObject jSONObject, String str, Object obj) {
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
            GXTemplateEngine.C3346h p = this.a.p();
            if (p != null && (c = p.c()) != null) {
                GXTemplateEngine.C3342e c3342e = new GXTemplateEngine.C3342e();
                String str = this.d;
                qr0 qr0Var = this.b;
                Object obj = this.e;
                os0 os0Var = this.a;
                c3342e.setGestureType(str);
                c3342e.setView(qr0Var.q());
                b41.h(obj, "eventData");
                c3342e.setEventParams((JSONObject) obj);
                c3342e.setNodeId(qr0Var.o().i().d());
                c3342e.setTemplateItem(os0Var.r());
                c3342e.setIndex(-1);
                wt2 wt2Var = wt2.INSTANCE;
                c.onGestureEvent(c3342e);
            }
            ss0 l = this.b.o().l();
            Object value = (l == null || (a = l.a()) == null) ? null : a.value(this.c);
            JSONObject jSONObject = value instanceof JSONObject ? (JSONObject) value : null;
            if (jSONObject == null) {
                return;
            }
            os0 os0Var2 = this.a;
            qr0 qr0Var2 = this.b;
            GXTemplateEngine.C3346h p2 = os0Var2.p();
            if (p2 == null || (f = p2.f()) == null) {
                return;
            }
            GXTemplateEngine.C3349k c3349k = new GXTemplateEngine.C3349k();
            c3349k.i(qr0Var2.q());
            c3349k.h(jSONObject);
            c3349k.f(qr0Var2.o().i().d());
            c3349k.g(os0Var2.r());
            c3349k.e(-1);
            wt2 wt2Var2 = wt2.INSTANCE;
            f.onManualClickTrackEvent(c3349k);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.rr0$b */
    /* loaded from: classes6.dex */
    static final class View$OnLongClickListenerC9662b implements View.OnLongClickListener {
        final /* synthetic */ os0 a;
        final /* synthetic */ qr0 b;
        final /* synthetic */ JSONObject c;
        final /* synthetic */ String d;
        final /* synthetic */ Object e;

        View$OnLongClickListenerC9662b(os0 os0Var, qr0 qr0Var, JSONObject jSONObject, String str, Object obj) {
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
            GXTemplateEngine.C3346h p = this.a.p();
            if (p != null && (c = p.c()) != null) {
                GXTemplateEngine.C3342e c3342e = new GXTemplateEngine.C3342e();
                String str = this.d;
                qr0 qr0Var = this.b;
                Object obj = this.e;
                os0 os0Var = this.a;
                c3342e.setGestureType(str);
                c3342e.setView(qr0Var.q());
                b41.h(obj, "eventData");
                c3342e.setEventParams((JSONObject) obj);
                c3342e.setNodeId(qr0Var.o().i().d());
                c3342e.setTemplateItem(os0Var.r());
                c3342e.setIndex(-1);
                wt2 wt2Var = wt2.INSTANCE;
                c.onGestureEvent(c3342e);
            }
            ss0 l = this.b.o().l();
            Object value = (l == null || (a = l.a()) == null) ? null : a.value(this.c);
            JSONObject jSONObject = value instanceof JSONObject ? (JSONObject) value : null;
            if (jSONObject == null) {
                return true;
            }
            os0 os0Var2 = this.a;
            qr0 qr0Var2 = this.b;
            GXTemplateEngine.C3346h p2 = os0Var2.p();
            if (p2 == null || (f = p2.f()) == null) {
                return true;
            }
            GXTemplateEngine.C3349k c3349k = new GXTemplateEngine.C3349k();
            c3349k.i(qr0Var2.q());
            c3349k.h(jSONObject);
            c3349k.f(qr0Var2.o().i().d());
            c3349k.g(os0Var2.r());
            c3349k.e(-1);
            wt2 wt2Var2 = wt2.INSTANCE;
            f.onManualClickTrackEvent(c3349k);
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
                        q.setOnClickListener(new View$OnClickListenerC9661a(os0Var, qr0Var, jSONObject, str, next));
                    }
                } else if (b41.d(str, "longpress")) {
                    View q2 = qr0Var.q();
                    if (q2 != null) {
                        q2.setOnLongClickListener(new View$OnLongClickListenerC9662b(os0Var, qr0Var, jSONObject, str, next));
                    }
                } else {
                    Log.e("[GaiaX]", b41.r("unknown event type ", str));
                }
            }
        }
    }
}
