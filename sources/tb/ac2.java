package tb;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ac2 extends y0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public ac2() {
        super("damai", "damai_script_order_detail_header");
    }

    @Override // tb.y0
    public void e(@NotNull View view, @NotNull Activity activity, @NotNull EventParams eventParams, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        Object obj;
        JSONObject data;
        Object obj2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517266516")) {
            ipChange.ipc$dispatch("1517266516", new Object[]{this, view, activity, eventParams, jSONObject, Integer.valueOf(i), gaiaXUtParamsGenerator});
            return;
        }
        b41.i(view, "itemView");
        b41.i(activity, "activity");
        b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        JSONObject data2 = eventParams.getData();
        if (data2 == null || (obj = data2.get("eventName")) == null) {
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        if (!b41.d("coupon_detail_action", obj) || (data = eventParams.getData()) == null || (obj2 = data.get("schema")) == null) {
            return;
        }
        action.setActionUrl(obj2.toString());
        NavProviderProxy.getProxy().toUri(activity, action);
    }
}
