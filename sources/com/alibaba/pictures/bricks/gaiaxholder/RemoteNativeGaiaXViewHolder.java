package com.alibaba.pictures.bricks.gaiaxholder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.coupon.order.bean.GxTemplate;
import com.alibaba.pictures.bricks.gaiaxholder.RemoteNativeGaiaXViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.youku.arch.v3.data.Constants;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.LoadType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dt0;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RemoteNativeGaiaXViewHolder extends RecyclerView.ViewHolder implements GaiaX.IHostMessage {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Activity a;
    @Nullable
    private final GaiaXUtParamsGenerator b;
    @Nullable
    private dt0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteNativeGaiaXViewHolder(@NotNull Activity activity, @Nullable GaiaXUtParamsGenerator gaiaXUtParamsGenerator) {
        super(new FrameLayout(activity));
        b41.i(activity, "activity");
        this.a = activity;
        this.b = gaiaXUtParamsGenerator;
        this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.n12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoteNativeGaiaXViewHolder.b(RemoteNativeGaiaXViewHolder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RemoteNativeGaiaXViewHolder remoteNativeGaiaXViewHolder, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "541834368")) {
            ipChange.ipc$dispatch("541834368", new Object[]{remoteNativeGaiaXViewHolder, view});
            return;
        }
        b41.i(remoteNativeGaiaXViewHolder, "this$0");
        dt0 dt0Var = remoteNativeGaiaXViewHolder.c;
        if (dt0Var != null) {
            b41.h(view, AdvanceSetting.NETWORK_TYPE);
            dt0Var.d(view);
        }
    }

    public final void c(@NotNull GxTemplate gxTemplate, @Nullable JSONObject jSONObject, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1624581628")) {
            ipChange.ipc$dispatch("-1624581628", new Object[]{this, gxTemplate, jSONObject, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        b41.i(gxTemplate, Constants.TEMPLATE);
        d(gxTemplate.getBizId(), gxTemplate.getTemplateId(), gxTemplate.getTemplateVersion(), jSONObject, f, i);
    }

    public final void d(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable JSONObject jSONObject, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475606481")) {
            ipChange.ipc$dispatch("475606481", new Object[]{this, str, str2, str3, jSONObject, Float.valueOf(f), Integer.valueOf(i)});
            return;
        }
        b41.i(str, hh1.DIMEN_BIZ);
        b41.i(str2, "templateId");
        if (jSONObject == null) {
            return;
        }
        GaiaX.Params build = new GaiaX.Params.Builder().templateBiz(str).templateId(str2).templateVersion(str3).container(this.itemView).mode(LoadType.SYNC_NORMAL).data(jSONObject).width(f).build();
        build.setMessage(this);
        View view = this.itemView;
        b41.h(view, "itemView");
        dt0 dt0Var = new dt0(view, this.a, str, str2, str3, jSONObject, i, this.b);
        build.setEventDelegate(dt0Var);
        build.setTrackDelegate3(dt0Var);
        build.setStatusDelegate(dt0Var);
        this.c = dt0Var;
        dt0Var.c(dt0Var.b());
        GaiaX.Companion.getInstance().bindView(build);
    }

    @Override // com.youku.gaiax.GaiaX.IHostMessage
    public boolean onMessage(@NotNull String str, @NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-916261410")) {
            return ((Boolean) ipChange.ipc$dispatch("-916261410", new Object[]{this, str, jSONObject})).booleanValue();
        }
        b41.i(str, "type");
        b41.i(jSONObject, "data");
        return false;
    }
}
