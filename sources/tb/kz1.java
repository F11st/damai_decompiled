package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class kz1 extends wi1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String BIZ_ID = "damai";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TEMPLATE_ID = "damai_recommend_project_card";
    @NotNull
    public static final String VERSION = "4";

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz1(@NotNull Context context) {
        super(context, "damai", TEMPLATE_ID, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // tb.xi1
    public void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051136773")) {
            ipChange.ipc$dispatch("2051136773", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        b41.i(jSONObject, "data");
        JSONObject data = eventParams.getData();
        if (data == null || (obj = data.get("eventName")) == null || !b41.d(obj, "item")) {
            return;
        }
        Action action = new Action();
        action.setActionType(1);
        action.setActionUrl(String.valueOf(jSONObject.get("schema")));
        cr1.INSTANCE.b(null, i);
        NavProviderProxy.getProxy().toUri(b(), action);
    }

    @Override // tb.xi1
    public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1150108963")) {
            ipChange.ipc$dispatch("-1150108963", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "itemView");
        b41.i(jSONObject, "data");
        cr1.INSTANCE.c(view, i);
    }

    @Override // tb.wi1, tb.xi1
    public void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-28670698")) {
            ipChange.ipc$dispatch("-28670698", new Object[]{this, trackParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        b41.i(trackParams, "trackParams");
        b41.i(jSONObject, "data");
    }
}
