package com.alient.gaiax.container.gaiax;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.gaiax.container.util.Utils;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\"\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/alient/gaiax/container/gaiax/GaiaxAutoEventTrack;", "", "Lcom/youku/gaiax/api/data/EventParams;", WXGlobalEventReceiver.EVENT_PARAMS, "Lcom/alibaba/fastjson/JSONObject;", "data", "", "pos", "Ltb/wt2;", "eventClick", "(Lcom/youku/gaiax/api/data/EventParams;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/Integer;)V", "Landroid/view/View;", "view", "Lcom/alient/gaiax/container/gaiax/GaiaxAutoEventTrack$UtType;", "type", "trackUt", "", "TRACK_TYPE_ALL", "Ljava/lang/String;", "TRACK_TYPE_CLICK_JUMP", "TRACK_TYPE_CLICK", "TRACK_TYPE_EXPOSE", "ACTION_KEY", "<init>", "()V", "UtType", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class GaiaxAutoEventTrack {
    @NotNull
    private static final String ACTION_KEY = "action";
    @NotNull
    public static final GaiaxAutoEventTrack INSTANCE = new GaiaxAutoEventTrack();
    @NotNull
    private static final String TRACK_TYPE_ALL = "all";
    @NotNull
    private static final String TRACK_TYPE_CLICK = "click";
    @NotNull
    private static final String TRACK_TYPE_CLICK_JUMP = "clickjump";
    @NotNull
    private static final String TRACK_TYPE_EXPOSE = "expose";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/alient/gaiax/container/gaiax/GaiaxAutoEventTrack$UtType;", "", "<init>", "(Ljava/lang/String;I)V", "Click", "Expose", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public enum UtType {
        Click,
        Expose
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UtType.values().length];
            iArr[UtType.Click.ordinal()] = 1;
            iArr[UtType.Expose.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private GaiaxAutoEventTrack() {
    }

    public final void eventClick(@NotNull EventParams eventParams, @Nullable JSONObject jSONObject, @Nullable Integer num) {
        b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        JSONObject data = eventParams.getData();
        Object obj = data == null ? null : data.get("action");
        JSONObject jSONObject2 = obj instanceof JSONObject ? (JSONObject) obj : null;
        if (jSONObject2 == null) {
            return;
        }
        GaiaxAction gaiaxAction = (GaiaxAction) Utils.INSTANCE.toJavaObject(jSONObject2, GaiaxAction.class);
        Integer valueOf = gaiaxAction == null ? null : Integer.valueOf(gaiaxAction.getActionType());
        if ((valueOf == null || 1 != valueOf.intValue()) && (valueOf == null || 2 != valueOf.intValue())) {
            if ((valueOf != null && valueOf.intValue() == 0) || valueOf == null) {
                return;
            }
            valueOf.intValue();
            return;
        }
        View view = eventParams.getView();
        NavProviderProxy.toUri(view != null ? view.getContext() : null, gaiaxAction);
    }

    public final void trackUt(@Nullable View view, @Nullable JSONObject jSONObject, @NotNull UtType utType) {
        TrackInfo trackInfo;
        b41.i(utType, "type");
        Object obj = jSONObject == null ? null : jSONObject.get("action");
        JSONObject jSONObject2 = obj instanceof JSONObject ? (JSONObject) obj : null;
        if (jSONObject2 == null) {
            return;
        }
        GaiaxAction gaiaxAction = (GaiaxAction) Utils.INSTANCE.toJavaObject(jSONObject2, GaiaxAction.class);
        String str = gaiaxAction == null ? null : gaiaxAction.autoTrack;
        String str2 = gaiaxAction != null ? gaiaxAction.trackType : null;
        if (!b41.d("true", str) || gaiaxAction == null || (trackInfo = gaiaxAction.getTrackInfo()) == null) {
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[utType.ordinal()];
        if (i != 1) {
            if (i == 2 && b41.d("expose", str2)) {
                UserTrackProviderProxy.expose(view, trackInfo);
            }
        } else if (!b41.d("all", str2) && !b41.d(TRACK_TYPE_CLICK_JUMP, str2)) {
            if (b41.d("click", str2)) {
                UserTrackProviderProxy.click(view, trackInfo, false);
            }
        } else {
            UserTrackProviderProxy.click(view, trackInfo, true);
        }
    }
}
