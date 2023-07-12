package com.alient.gaiax.container.gaiax;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH&J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000eH&J\u001a\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&R\u0019\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u0082\u0001\u0001\"¨\u0006#"}, d2 = {"Lcom/alient/gaiax/container/gaiax/PictureGaiaXDelegate;", "", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Lcom/alibaba/fastjson/JSONObject;", "data", "", "pos", "Ltb/wt2;", "onGaiaXEvent", "trackParams", "onTrackViewClick", "Lcom/youku/gaiax/api/data/TrackParams;", "onTrackViewExpose", "Landroid/view/View;", "itemView", "onItemViewExpose", "onItemViewClick", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "targetView", "doViewUpdatedFun", "doViewInjectedFun", "", "type", "", "onMessage", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Lcom/alient/gaiax/container/gaiax/PictureGaiaXEventProvider;", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public abstract class PictureGaiaXDelegate {
    @NotNull
    private final Context context;

    private PictureGaiaXDelegate(Context context) {
        this.context = context;
    }

    public /* synthetic */ PictureGaiaXDelegate(Context context, k50 k50Var) {
        this(context);
    }

    public abstract void doViewInjectedFun(@NotNull GaiaX.Params params, @NotNull View view);

    public abstract void doViewUpdatedFun(@NotNull GaiaX.Params params, @NotNull View view);

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public abstract void onGaiaXEvent(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i);

    public abstract void onItemViewClick(@NotNull View view, @Nullable JSONObject jSONObject, int i);

    public abstract void onItemViewExpose(@NotNull View view, @Nullable JSONObject jSONObject, int i);

    public abstract boolean onMessage(@NotNull String str, @Nullable JSONObject jSONObject);

    public abstract void onTrackViewClick(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i);

    public abstract void onTrackViewExpose(@NotNull TrackParams trackParams, @Nullable JSONObject jSONObject, int i);
}
