package com.alibaba.pictures.bricks.gaiaxholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXGlobalEventReceiver;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import com.youku.gaiax.api.data.EventParams;
import com.youku.gaiax.api.data.TrackParams;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hh1;
import tb.xi1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NativeGaiaXViewHolder extends RecyclerView.ViewHolder implements GaiaX.IHostMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final xi1 a;
    @Nullable
    private GaiaX.Params b;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a implements GaiaX.IEventDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ int c;

        a(JSONObject jSONObject, int i) {
            this.b = jSONObject;
            this.c = i;
        }

        @Override // com.youku.gaiax.GaiaX.IEventDelegate
        public void onEvent(@NotNull EventParams eventParams) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-369272942")) {
                ipChange.ipc$dispatch("-369272942", new Object[]{this, eventParams});
                return;
            }
            b41.i(eventParams, WXGlobalEventReceiver.EVENT_PARAMS);
            NativeGaiaXViewHolder.this.a.e(eventParams, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements GaiaX.ITrackDelegate3 {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ int c;

        b(JSONObject jSONObject, int i) {
            this.b = jSONObject;
            this.c = i;
        }

        @Override // com.youku.gaiax.GaiaX.ITrackDelegate3
        public void onTrack(@NotNull TrackParams trackParams) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-905484593")) {
                ipChange.ipc$dispatch("-905484593", new Object[]{this, trackParams});
                return;
            }
            b41.i(trackParams, "trackParams");
            NativeGaiaXViewHolder.this.a.g(trackParams, this.b, this.c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c implements GaiaX.IStatusDelegate {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.youku.gaiax.GaiaX.IStatusDelegate
        public void onViewInjected(@NotNull GaiaX.Params params, @NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1392150935")) {
                ipChange.ipc$dispatch("1392150935", new Object[]{this, params, view});
                return;
            }
            b41.i(params, "params");
            b41.i(view, "resultView");
        }

        @Override // com.youku.gaiax.GaiaX.IStatusDelegate
        public void onViewUpdated(@NotNull GaiaX.Params params, @NotNull View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-550853774")) {
                ipChange.ipc$dispatch("-550853774", new Object[]{this, params, view});
                return;
            }
            b41.i(params, "params");
            b41.i(view, "resultView");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeGaiaXViewHolder(@NotNull Context context, @NotNull xi1 xi1Var) {
        super(new FrameLayout(context));
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(xi1Var, "gaiaAction");
        this.a = xi1Var;
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    }

    private final void b(JSONObject jSONObject, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477782068")) {
            ipChange.ipc$dispatch("1477782068", new Object[]{this, jSONObject, Integer.valueOf(i)});
            return;
        }
        GaiaX.Params params = this.b;
        if (params != null) {
            params.setMessage(this);
            params.setEventDelegate(new a(jSONObject, i));
            params.setTrackDelegate3(new b(jSONObject, i));
            params.setStatusDelegate(new c());
            GaiaX.Companion.getInstance().bindView(params);
            xi1 xi1Var = this.a;
            View view = this.itemView;
            b41.h(view, "itemView");
            xi1Var.f(view, jSONObject, i);
        }
    }

    public final void c(@Nullable JSONObject jSONObject, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009423701")) {
            ipChange.ipc$dispatch("1009423701", new Object[]{this, jSONObject, Float.valueOf(f), Integer.valueOf(i)});
        } else if (jSONObject == null) {
        } else {
            this.a.h(jSONObject);
            this.b = new GaiaX.Params.Builder().templateBiz(this.a.a()).templateId(this.a.c()).templateVersion(this.a.d()).container(this.itemView).mode(LoadType.SYNC_NORMAL).data(jSONObject).width(f).build();
            b(jSONObject, i);
        }
    }

    public final void d(@NotNull String str, @NotNull String str2, @NotNull String str3, float f, int i, @Nullable JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "841339665")) {
            ipChange.ipc$dispatch("841339665", new Object[]{this, str, str2, str3, Float.valueOf(f), Integer.valueOf(i), jSONObject});
            return;
        }
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        b41.i(str3, "version");
        if (jSONObject == null) {
            return;
        }
        this.a.h(jSONObject);
        this.b = new GaiaX.Params.Builder().templateBiz(str).templateId(str2).templateVersion(str3).container(this.itemView).mode(LoadType.SYNC_NORMAL).data(jSONObject).width(f).build();
        b(jSONObject, i);
    }

    @Override // com.youku.gaiax.GaiaX.IHostMessage
    public boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "908447556")) {
            return ((Boolean) ipChange.ipc$dispatch("908447556", new Object[]{this, str, jSONObject})).booleanValue();
        }
        b41.i(str, "type");
        b41.i(jSONObject, "data");
        return false;
    }
}
