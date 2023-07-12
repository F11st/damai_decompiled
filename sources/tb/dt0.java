package tb;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.gaiaxholder.GaiaXUtParamsGenerator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class dt0 implements GaiaX.IEventDelegate, GaiaX.IStatusDelegate, GaiaX.ITrackDelegate3 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private static final HashMap<String, y0> h;
    @NotNull
    private final View a;
    @NotNull
    private final Activity b;
    @NotNull
    private final String c;
    @NotNull
    private final String d;
    @Nullable
    private final JSONObject e;
    private final int f;
    @Nullable
    private final GaiaXUtParamsGenerator g;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @Nullable
        public final y0 a(@NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-103929136")) {
                return (y0) ipChange.ipc$dispatch("-103929136", new Object[]{this, str, str2});
            }
            b41.i(str, hh1.DIMEN_BIZ);
            b41.i(str2, "templateId");
            HashMap hashMap = dt0.h;
            return (y0) hashMap.get(str + '_' + str2);
        }
    }

    static {
        HashMap<String, y0> hashMap = new HashMap<>();
        h = hashMap;
        ec2 ec2Var = new ec2();
        hashMap.put(ec2Var.a(), ec2Var);
        ac2 ac2Var = new ac2();
        hashMap.put(ac2Var.a(), ac2Var);
    }

    public dt0(@NotNull View view, @NotNull Activity activity, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable JSONObject jSONObject, int i, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        b41.i(view, "itemView");
        b41.i(activity, "activity");
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        this.a = view;
        this.b = activity;
        this.c = str;
        this.d = str2;
        this.e = jSONObject;
        this.f = i;
        this.g = gaiaXUtParamsGenerator;
    }

    @NotNull
    public final View b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "340973694") ? (View) ipChange.ipc$dispatch("340973694", new Object[]{this}) : this.a;
    }

    public final void c(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "758089222")) {
            ipChange.ipc$dispatch("758089222", new Object[]{this, view});
            return;
        }
        b41.i(view, "itemView");
        y0 a2 = Companion.a(this.c, this.d);
        if (a2 != null) {
            a2.d(view, this.b, this.e, this.f, this.g);
        }
    }

    public final void d(@NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-176555783")) {
            ipChange.ipc$dispatch("-176555783", new Object[]{this, view});
            return;
        }
        b41.i(view, "itemView");
        y0 a2 = Companion.a(this.c, this.d);
        if (a2 != null) {
            a2.f(view, this.b, this.e, this.f, this.g);
        }
    }

    @Override // com.youku.gaiax.GaiaX.IEventDelegate
    public void onEvent(@NotNull EventParams eventParams) {
        y0 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1061201009")) {
            ipChange.ipc$dispatch("1061201009", new Object[]{this, eventParams});
            return;
        }
        b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
        if (this.b.isFinishing() || (a2 = Companion.a(this.c, this.d)) == null) {
            return;
        }
        a2.e(this.a, this.b, eventParams, this.e, this.f, this.g);
    }

    @Override // com.youku.gaiax.GaiaX.ITrackDelegate3
    public void onTrack(@NotNull TrackParams trackParams) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244180657")) {
            ipChange.ipc$dispatch("-244180657", new Object[]{this, trackParams});
        } else {
            b41.i(trackParams, "trackParams");
        }
    }

    @Override // com.youku.gaiax.GaiaX.IStatusDelegate
    public void onViewInjected(@NotNull GaiaX.Params params, @NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1210923896")) {
            ipChange.ipc$dispatch("1210923896", new Object[]{this, params, view});
            return;
        }
        b41.i(params, "params");
        b41.i(view, "resultView");
        y0 a2 = Companion.a(this.c, this.d);
        if (a2 != null) {
            a2.g(params, view, this.a, this.b, this.e, this.f, this.g);
        }
    }

    @Override // com.youku.gaiax.GaiaX.IStatusDelegate
    public void onViewUpdated(@NotNull GaiaX.Params params, @NotNull View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2510479")) {
            ipChange.ipc$dispatch("-2510479", new Object[]{this, params, view});
            return;
        }
        b41.i(params, "params");
        b41.i(view, "resultView");
    }
}
