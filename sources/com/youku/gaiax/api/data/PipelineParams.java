package com.youku.gaiax.api.data;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/youku/gaiax/api/data/PipelineParams;", "", "", "position", "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Landroid/view/View;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "", "viewId", "Ljava/lang/String;", "getViewId", "()Ljava/lang/String;", "setViewId", "(Ljava/lang/String;)V", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Lcom/alibaba/fastjson/JSONObject;", "extend", "Lcom/alibaba/fastjson/JSONObject;", "getExtend", "()Lcom/alibaba/fastjson/JSONObject;", "setExtend", "(Lcom/alibaba/fastjson/JSONObject;)V", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PipelineParams {
    @Nullable
    private Object data;
    @Nullable
    private JSONObject extend;
    @Nullable
    private Integer position;
    @Nullable
    private View view;
    @Nullable
    private String viewId;

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @Nullable
    public final JSONObject getExtend() {
        return this.extend;
    }

    @Nullable
    public final Integer getPosition() {
        return this.position;
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    @Nullable
    public final String getViewId() {
        return this.viewId;
    }

    public final void setData(@Nullable Object obj) {
        this.data = obj;
    }

    public final void setExtend(@Nullable JSONObject jSONObject) {
        this.extend = jSONObject;
    }

    public final void setPosition(@Nullable Integer num) {
        this.position = num;
    }

    public final void setView(@Nullable View view) {
        this.view = view;
    }

    public final void setViewId(@Nullable String str) {
        this.viewId = str;
    }
}
