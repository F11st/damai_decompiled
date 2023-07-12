package com.youku.gaiax.api.data;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXTemplateEngine;
import com.youku.gaiax.api.context.IContextParams;
import com.youku.gaiax.impl.register.GXMixNodeEvent;
import java.util.Objects;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b@\u0010AJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\n\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR$\u0010,\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/youku/gaiax/api/data/EventParams;", "", "other", "", "equals", "", "hashCode", "", "toString", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "jsOptionLevel", "I", "getJsOptionLevel", "()I", "setJsOptionLevel", "(I)V", "jsOptionCover", "Z", "getJsOptionCover", "()Z", "setJsOptionCover", "(Z)V", "", "jsComponentId", "J", "getJsComponentId", "()J", "setJsComponentId", "(J)V", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "viewId", "getViewId", "setViewId", "position", "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/alibaba/fastjson/JSONObject;", "getData", "()Lcom/alibaba/fastjson/JSONObject;", "setData", "(Lcom/alibaba/fastjson/JSONObject;)V", "Lcom/youku/gaiax/api/context/IContextParams;", "params", "Lcom/youku/gaiax/api/context/IContextParams;", "getParams", "()Lcom/youku/gaiax/api/context/IContextParams;", "setParams", "(Lcom/youku/gaiax/api/context/IContextParams;)V", "<init>", "()V", "Companion", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EventParams {
    @NotNull
    public static final String CLICK_TYPE_JS_TAP = "click";
    @NotNull
    public static final String CLICK_TYPE_LONGPRESS = "longpress";
    @NotNull
    public static final String CLICK_TYPE_TAP = "tap";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private JSONObject data;
    private boolean jsOptionCover;
    private int jsOptionLevel;
    @Nullable
    private IContextParams params;
    @Nullable
    private Integer position;
    @Nullable
    private View view;
    @Nullable
    private String viewId;
    @NotNull
    private String type = CLICK_TYPE_TAP;
    private long jsComponentId = -1;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/api/data/EventParams$Companion;", "", "Lcom/alibaba/gaiax/GXTemplateEngine$e;", "gxGesture", "Lcom/youku/gaiax/api/data/EventParams;", "create", "", "CLICK_TYPE_JS_TAP", "Ljava/lang/String;", "CLICK_TYPE_LONGPRESS", "CLICK_TYPE_TAP", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final EventParams create(@NotNull GXTemplateEngine.C3342e c3342e) {
            b41.i(c3342e, "gxGesture");
            GXMixNodeEvent.GXJSGesture gXJSGesture = (GXMixNodeEvent.GXJSGesture) c3342e;
            EventParams eventParams = new EventParams();
            eventParams.setType(gXJSGesture.getGestureType());
            eventParams.setData(gXJSGesture.getEventParams());
            eventParams.setView(gXJSGesture.getView());
            eventParams.setViewId(gXJSGesture.getNodeId());
            eventParams.setPosition(gXJSGesture.getIndex());
            eventParams.setJsComponentId(gXJSGesture.getJsComponentId());
            eventParams.setJsOptionCover(gXJSGesture.getJsOptionCover());
            eventParams.setJsOptionLevel(gXJSGesture.getJsOptionLevel());
            return eventParams;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (b41.d(EventParams.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.youku.gaiax.api.data.EventParams");
            return b41.d(this.type, ((EventParams) obj).type);
        }
        return false;
    }

    @Nullable
    public final JSONObject getData() {
        return this.data;
    }

    public final long getJsComponentId() {
        return this.jsComponentId;
    }

    public final boolean getJsOptionCover() {
        return this.jsOptionCover;
    }

    public final int getJsOptionLevel() {
        return this.jsOptionLevel;
    }

    @Nullable
    public final IContextParams getParams() {
        return this.params;
    }

    @Nullable
    public final Integer getPosition() {
        return this.position;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    @Nullable
    public final String getViewId() {
        return this.viewId;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public final void setData(@Nullable JSONObject jSONObject) {
        this.data = jSONObject;
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

    public final void setParams(@Nullable IContextParams iContextParams) {
        this.params = iContextParams;
    }

    public final void setPosition(@Nullable Integer num) {
        this.position = num;
    }

    public final void setType(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.type = str;
    }

    public final void setView(@Nullable View view) {
        this.view = view;
    }

    public final void setViewId(@Nullable String str) {
        this.viewId = str;
    }

    @NotNull
    public String toString() {
        return "EventParams(type='" + this.type + "', jsOptionLevel=" + this.jsOptionLevel + ", jsOptionCover=" + this.jsOptionCover + ", jsComponentId=" + this.jsComponentId + ", view=" + this.view + ", viewId=" + ((Object) this.viewId) + ", position=" + this.position + ')';
    }
}
