package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.orderresult.CouponPayResultFragment;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class gp extends wi1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String BIZ_ID = "damai";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String GAIAX_COUPON_PAYRESULT_NATIVE_URL = "nativeUrl";
    @NotNull
    public static final String TEMPLATE_ID = "damai_script_play_pay_result_item";
    @NotNull
    public static final String VERSION = "1";

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
    public gp(@NotNull Context context, @Nullable String str) {
        super(context, "damai", TEMPLATE_ID, "1");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    @Override // tb.xi1
    public void e(@NotNull EventParams eventParams, @NotNull JSONObject jSONObject, int i) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "597334690")) {
            ipChange.ipc$dispatch("597334690", new Object[]{this, eventParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        b41.i(jSONObject, "data");
        JSONObject data = eventParams.getData();
        if (data == null || (obj = data.get("eventName")) == null) {
            return;
        }
        JSONObject data2 = eventParams.getData();
        Object obj2 = data2 != null ? data2.get(GAIAX_COUPON_PAYRESULT_NATIVE_URL) : null;
        b41.g(obj2, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj2;
        if (b41.d((String) obj, CouponPayResultFragment.HOME_CLICK)) {
            if (jSONObject != null) {
                Action action = new Action();
                action.setActionType(1);
                action.setActionUrl(str);
                cr1.INSTANCE.f(null);
                NavProviderProxy.getProxy().toUri(b(), action);
            }
        } else if (jSONObject != null) {
            Action action2 = new Action();
            action2.setActionType(1);
            action2.setActionUrl(a4.INSTANCE.a(str, "CouponCreateOrderPage=true"));
            cr1.INSTANCE.d(null);
            NavProviderProxy.getProxy().toUri(b(), action2);
        }
    }

    @Override // tb.xi1
    public void f(@NotNull View view, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366038240")) {
            ipChange.ipc$dispatch("1366038240", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
            return;
        }
        b41.i(view, "itemView");
        b41.i(jSONObject, "data");
    }

    @Override // tb.wi1, tb.xi1
    public void g(@NotNull TrackParams trackParams, @NotNull JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70729319")) {
            ipChange.ipc$dispatch("-70729319", new Object[]{this, trackParams, jSONObject, Integer.valueOf(i)});
            return;
        }
        b41.i(trackParams, "trackParams");
        b41.i(jSONObject, "data");
        if (b41.d("home_btn", trackParams.getViewId())) {
            cr1.INSTANCE.g(trackParams.getView());
        } else if (b41.d("order_btn", trackParams.getViewId())) {
            cr1.INSTANCE.e(trackParams.getView());
        }
    }
}
