package com.youku.gaiax.impl.register;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.impl.js.GaiaXJSDelegate;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.os0;
import tb.qr0;
import tb.vq0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ6\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%¨\u0006+"}, d2 = {"Lcom/youku/gaiax/impl/register/GXMixNodeEvent;", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "gestureParams", "Ltb/wt2;", "initViewEventListener", "initViewClickEventDispatcher", "initViewLongClickEventDispatcher", "dispatcherClick", "dispatcherLongClick", "", "componentId", "", "eventType", "removeJSEvent", "Ltb/os0;", "gxTemplateContext", "Ltb/qr0;", "gxNode", "", "optionCover", "", "optionLevel", "addJSEvent", "Lcom/alibaba/fastjson/JSONObject;", "templateData", "addDataBindingEvent", "Landroid/view/View$OnClickListener;", "onClickListener", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "onLongClickListener", "Landroid/view/View$OnLongClickListener;", "clickEventByDataBinding", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "Lcom/youku/gaiax/impl/register/GXMixNodeEvent$GXJSGesture;", "clickEventByJS", "Lcom/youku/gaiax/impl/register/GXMixNodeEvent$GXJSGesture;", "longClickEventByDataBinding", "longClickEventByJS", "<init>", "()V", "GXJSGesture", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXMixNodeEvent implements GXINodeEvent {
    @Nullable
    private GXTemplateEngine.e clickEventByDataBinding;
    @Nullable
    private GXJSGesture clickEventByJS;
    @Nullable
    private os0 gxTemplateContext;
    @Nullable
    private GXTemplateEngine.e longClickEventByDataBinding;
    @Nullable
    private GXJSGesture longClickEventByJS;
    @Nullable
    private View.OnClickListener onClickListener;
    @Nullable
    private View.OnLongClickListener onLongClickListener;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/youku/gaiax/impl/register/GXMixNodeEvent$GXJSGesture;", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "", "jsOptionLevel", "I", "getJsOptionLevel", "()I", "setJsOptionLevel", "(I)V", "", "jsOptionCover", "Z", "getJsOptionCover", "()Z", "setJsOptionCover", "(Z)V", "", "jsComponentId", "J", "getJsComponentId", "()J", "setJsComponentId", "(J)V", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class GXJSGesture extends GXTemplateEngine.e {
        private long jsComponentId = -1;
        private boolean jsOptionCover;
        private int jsOptionLevel;

        public final long getJsComponentId() {
            return this.jsComponentId;
        }

        public final boolean getJsOptionCover() {
            return this.jsOptionCover;
        }

        public final int getJsOptionLevel() {
            return this.jsOptionLevel;
        }

        public final void setJsComponentId(long j) {
            this.jsComponentId = j;
        }

        public final void setJsOptionCover(boolean z) {
            this.jsOptionCover = z;
        }

        public final void setJsOptionLevel(int i) {
            this.jsOptionLevel = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatcherClick() {
        os0 os0Var;
        GXTemplateEngine.h p;
        GXTemplateEngine.GXIEventListener c;
        os0 os0Var2;
        GXTemplateEngine.h p2;
        GXTemplateEngine.GXIEventListener c2;
        os0 os0Var3;
        GXTemplateEngine.h p3;
        GXTemplateEngine.GXIEventListener c3;
        GXJSGesture gXJSGesture = this.clickEventByJS;
        GXTemplateEngine.e eVar = this.clickEventByDataBinding;
        if (gXJSGesture == null) {
            if (eVar == null || (os0Var = this.gxTemplateContext) == null || (p = os0Var.p()) == null || (c = p.c()) == null) {
                return;
            }
            c.onGestureEvent(eVar);
        } else if (gXJSGesture.getJsOptionCover()) {
            GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
        } else if (gXJSGesture.getJsOptionLevel() == 0) {
            if (eVar != null && (os0Var3 = this.gxTemplateContext) != null && (p3 = os0Var3.p()) != null && (c3 = p3.c()) != null) {
                c3.onGestureEvent(eVar);
            }
            GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
        } else {
            GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
            if (eVar == null || (os0Var2 = this.gxTemplateContext) == null || (p2 = os0Var2.p()) == null || (c2 = p2.c()) == null) {
                return;
            }
            c2.onGestureEvent(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatcherLongClick() {
        os0 os0Var;
        GXTemplateEngine.h p;
        GXTemplateEngine.GXIEventListener c;
        os0 os0Var2;
        GXTemplateEngine.h p2;
        GXTemplateEngine.GXIEventListener c2;
        os0 os0Var3;
        GXTemplateEngine.h p3;
        GXTemplateEngine.GXIEventListener c3;
        GXJSGesture gXJSGesture = this.longClickEventByJS;
        GXTemplateEngine.e eVar = this.longClickEventByDataBinding;
        if (gXJSGesture == null) {
            if (eVar == null || (os0Var = this.gxTemplateContext) == null || (p = os0Var.p()) == null || (c = p.c()) == null) {
                return;
            }
            c.onGestureEvent(eVar);
        } else if (gXJSGesture.getJsOptionCover()) {
            GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
        } else if (gXJSGesture.getJsOptionLevel() == 0) {
            if (eVar != null && (os0Var3 = this.gxTemplateContext) != null && (p3 = os0Var3.p()) != null && (c3 = p3.c()) != null) {
                c3.onGestureEvent(eVar);
            }
            GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
        } else {
            GaiaXJSDelegate.INSTANCE.dispatcherEvent(EventParams.Companion.create(gXJSGesture));
            if (eVar == null || (os0Var2 = this.gxTemplateContext) == null || (p2 = os0Var2.p()) == null || (c2 = p2.c()) == null) {
                return;
            }
            c2.onGestureEvent(eVar);
        }
    }

    private final void initViewClickEventDispatcher(final GXTemplateEngine.e eVar) {
        if (this.onClickListener == null) {
            this.onClickListener = new View.OnClickListener() { // from class: com.youku.gaiax.impl.register.GXMixNodeEvent$initViewClickEventDispatcher$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GXMixNodeEvent.this.dispatcherClick();
                }
            };
        }
        if (GaiaXUiExecutor.INSTANCE.isMainThread()) {
            View view = eVar.getView();
            if (view == null) {
                return;
            }
            view.setOnClickListener(this.onClickListener);
            return;
        }
        View view2 = eVar.getView();
        if (view2 == null) {
            return;
        }
        view2.post(new Runnable() { // from class: com.youku.gaiax.impl.register.GXMixNodeEvent$initViewClickEventDispatcher$2
            @Override // java.lang.Runnable
            public final void run() {
                View.OnClickListener onClickListener;
                View view3 = GXTemplateEngine.e.this.getView();
                if (view3 == null) {
                    return;
                }
                onClickListener = this.onClickListener;
                view3.setOnClickListener(onClickListener);
            }
        });
    }

    private final void initViewEventListener(GXTemplateEngine.e eVar) {
        String gestureType = eVar.getGestureType();
        int hashCode = gestureType.hashCode();
        if (hashCode != 114595) {
            if (hashCode != 94750088) {
                if (hashCode == 143756103 && gestureType.equals("longpress")) {
                    initViewLongClickEventDispatcher(eVar);
                    return;
                }
                return;
            } else if (!gestureType.equals("click")) {
                return;
            }
        } else if (!gestureType.equals(EventParams.CLICK_TYPE_TAP)) {
            return;
        }
        initViewClickEventDispatcher(eVar);
    }

    private final void initViewLongClickEventDispatcher(final GXTemplateEngine.e eVar) {
        if (this.onLongClickListener == null) {
            this.onLongClickListener = new View.OnLongClickListener() { // from class: com.youku.gaiax.impl.register.GXMixNodeEvent$initViewLongClickEventDispatcher$1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    GXMixNodeEvent.this.dispatcherLongClick();
                    return true;
                }
            };
        }
        if (GaiaXUiExecutor.INSTANCE.isMainThread()) {
            View view = eVar.getView();
            if (view == null) {
                return;
            }
            view.setOnLongClickListener(this.onLongClickListener);
            return;
        }
        View view2 = eVar.getView();
        if (view2 == null) {
            return;
        }
        view2.post(new Runnable() { // from class: com.youku.gaiax.impl.register.GXMixNodeEvent$initViewLongClickEventDispatcher$2
            @Override // java.lang.Runnable
            public final void run() {
                View.OnLongClickListener onLongClickListener;
                View view3 = GXTemplateEngine.e.this.getView();
                if (view3 == null) {
                    return;
                }
                onLongClickListener = this.onLongClickListener;
                view3.setOnLongClickListener(onLongClickListener);
            }
        });
    }

    @Override // com.alibaba.gaiax.render.node.GXINodeEvent
    public void addDataBindingEvent(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject) {
        String str;
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONObject, "templateData");
        this.gxTemplateContext = os0Var;
        vq0 g = qr0Var.o().g();
        if (g == null) {
            return;
        }
        Object value = g.a().value(jSONObject);
        JSONObject jSONObject2 = value instanceof JSONObject ? (JSONObject) value : null;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (!jSONObject2.containsKey("type") || !jSONObject2.containsKey("event") || (str = jSONObject2.getString("type")) == null) {
            str = EventParams.CLICK_TYPE_TAP;
        }
        GXTemplateEngine.e eVar = new GXTemplateEngine.e();
        eVar.setGestureType(str);
        eVar.setView(qr0Var.q());
        eVar.setEventParams(jSONObject2);
        eVar.setNodeId(qr0Var.o().i().d());
        eVar.setTemplateItem(os0Var.r());
        eVar.setIndex(-1);
        if (b41.d(str, EventParams.CLICK_TYPE_TAP)) {
            this.clickEventByDataBinding = eVar;
        } else if (b41.d(str, "longpress")) {
            this.longClickEventByDataBinding = eVar;
        }
        initViewEventListener(eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0071, code lost:
        if (r7.equals("click") == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007a, code lost:
        if (r7.equals(com.youku.gaiax.api.data.EventParams.CLICK_TYPE_TAP) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
        r2.clickEventByJS = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void addJSEvent(@org.jetbrains.annotations.NotNull tb.os0 r3, @org.jetbrains.annotations.NotNull tb.qr0 r4, long r5, @org.jetbrains.annotations.NotNull java.lang.String r7, boolean r8, int r9) {
        /*
            r2 = this;
            java.lang.String r0 = "gxTemplateContext"
            tb.b41.i(r3, r0)
            java.lang.String r0 = "gxNode"
            tb.b41.i(r4, r0)
            java.lang.String r0 = "eventType"
            tb.b41.i(r7, r0)
            r2.gxTemplateContext = r3
            com.youku.gaiax.impl.register.GXMixNodeEvent$GXJSGesture r0 = new com.youku.gaiax.impl.register.GXMixNodeEvent$GXJSGesture
            r0.<init>()
            r0.setGestureType(r7)
            android.view.View r1 = r4.q()
            r0.setView(r1)
            r1 = 0
            r0.setEventParams(r1)
            tb.qs0 r4 = r4.o()
            tb.gr0 r4 = r4.i()
            java.lang.String r4 = r4.d()
            r0.setNodeId(r4)
            com.alibaba.gaiax.GXTemplateEngine$i r3 = r3.r()
            r0.setTemplateItem(r3)
            r3 = -1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.setIndex(r3)
            r0.setJsComponentId(r5)
            r0.setJsOptionCover(r8)
            r0.setJsOptionLevel(r9)
            int r3 = r7.hashCode()
            r4 = 114595(0x1bfa3, float:1.60582E-40)
            if (r3 == r4) goto L74
            r4 = 94750088(0x5a5c588, float:1.5589087E-35)
            if (r3 == r4) goto L6b
            r4 = 143756103(0x8918b47, float:8.759614E-34)
            if (r3 == r4) goto L5f
            goto L7f
        L5f:
            java.lang.String r3 = "longpress"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L68
            goto L7f
        L68:
            r2.longClickEventByJS = r0
            goto L7f
        L6b:
            java.lang.String r3 = "click"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L7d
            goto L7f
        L74:
            java.lang.String r3 = "tap"
            boolean r3 = r7.equals(r3)
            if (r3 != 0) goto L7d
            goto L7f
        L7d:
            r2.clickEventByJS = r0
        L7f:
            r2.initViewEventListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.gaiax.impl.register.GXMixNodeEvent.addJSEvent(tb.os0, tb.qr0, long, java.lang.String, boolean, int):void");
    }

    public final void removeJSEvent(long j, @NotNull String str) {
        b41.i(str, "eventType");
        if (b41.d(str, EventParams.CLICK_TYPE_TAP)) {
            this.clickEventByJS = null;
        } else if (b41.d(str, "longpress")) {
            this.longClickEventByJS = null;
        }
    }
}
