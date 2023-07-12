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
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u001f"}, d2 = {"Lcom/alient/gaiax/container/gaiax/PictureGaiaXEventProvider;", "Lcom/alient/gaiax/container/gaiax/PictureGaiaXDelegate;", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Lcom/alibaba/fastjson/JSONObject;", "data", "", "pos", "Ltb/wt2;", "onGaiaXEvent", "Landroid/view/View;", "itemView", "onItemViewExpose", "onItemViewClick", "Lcom/youku/gaiax/api/data/TrackParams;", "trackParams", "onTrackViewExpose", "onTrackViewClick", "Lcom/youku/gaiax/GaiaX$Params;", "targetParams", "targetView", "doViewUpdatedFun", "doViewInjectedFun", "", "type", "", "onMessage", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;)V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class PictureGaiaXEventProvider extends PictureGaiaXDelegate {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureGaiaXEventProvider(@NotNull Context context) {
        super(context, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void doViewInjectedFun(@NotNull GaiaX.Params params, @NotNull View view) {
        b41.i(params, "targetParams");
        b41.i(view, "targetView");
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void doViewUpdatedFun(@NotNull GaiaX.Params params, @NotNull View view) {
        b41.i(params, "targetParams");
        b41.i(view, "targetView");
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void onGaiaXEvent(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i) {
        b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void onItemViewClick(@NotNull View view, @Nullable JSONObject jSONObject, int i) {
        b41.i(view, "itemView");
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void onItemViewExpose(@NotNull View view, @Nullable JSONObject jSONObject, int i) {
        b41.i(view, "itemView");
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public boolean onMessage(@NotNull String str, @Nullable JSONObject jSONObject) {
        b41.i(str, "type");
        return false;
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void onTrackViewClick(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i) {
        b41.i(eventParams, "trackParams");
    }

    @Override // com.alient.gaiax.container.gaiax.PictureGaiaXDelegate
    public void onTrackViewExpose(@NotNull TrackParams trackParams, @Nullable JSONObject jSONObject, int i) {
        b41.i(trackParams, "trackParams");
    }
}
