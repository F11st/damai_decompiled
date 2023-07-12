package com.alibaba.pictures.bricks.component.scriptmurder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.VenueInfoBean;
import com.alibaba.pictures.bricks.component.scriptmurder.VenueInfoViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.vh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class VenueInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView a;
    private final TextView b;
    private final TextView c;
    private final View d;
    private final TextView e;
    @Nullable
    private OnVenueInfoListener f;
    @Nullable
    private VenueInfoBean g;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnVenueInfoListener {
        void onVenueMapClick(@NotNull View view, @NotNull VenueInfoBean venueInfoBean);

        void onVenueViewExpose(@NotNull View view, @NotNull VenueInfoBean venueInfoBean);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VenueInfoViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.a = (TextView) view.findViewById(R$id.id_sm_venue_name);
        this.b = (TextView) view.findViewById(R$id.id_sm_venue_fans_show_count);
        this.c = (TextView) view.findViewById(R$id.id_sm_venue_loc_address);
        View findViewById = view.findViewById(R$id.id_sm_venue_loc_ui);
        this.d = findViewById;
        this.e = (TextView) view.findViewById(R$id.id_sm_venue_loc_distance);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: tb.bx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VenueInfoViewHolder.b(VenueInfoViewHolder.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VenueInfoViewHolder venueInfoViewHolder, View view) {
        OnVenueInfoListener onVenueInfoListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223299941")) {
            ipChange.ipc$dispatch("-223299941", new Object[]{venueInfoViewHolder, view});
            return;
        }
        b41.i(venueInfoViewHolder, "this$0");
        VenueInfoBean venueInfoBean = venueInfoViewHolder.g;
        if (venueInfoBean == null || (onVenueInfoListener = venueInfoViewHolder.f) == null) {
            return;
        }
        b41.h(view, AdvanceSetting.NETWORK_TYPE);
        onVenueInfoListener.onVenueMapClick(view, venueInfoBean);
    }

    public final void c(@NotNull VenueInfoBean venueInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148814921")) {
            ipChange.ipc$dispatch("-148814921", new Object[]{this, venueInfoBean});
            return;
        }
        b41.i(venueInfoBean, "venueInfo");
        this.g = venueInfoBean;
        this.a.setText(venueInfoBean.getNickname());
        this.c.setText(venueInfoBean.getSummary());
        TextView textView = this.e;
        String distance = venueInfoBean.getDistance();
        textView.setText(distance == null || distance.length() == 0 ? "地图" : venueInfoBean.getDistance());
        StringBuilder sb = new StringBuilder();
        String fansNum = venueInfoBean.getFansNum();
        if (fansNum != null) {
            if (!(vh2.INSTANCE.f(fansNum, 0) > 0)) {
                fansNum = null;
            }
            if (fansNum != null) {
                sb.append("粉丝：");
                sb.append(fansNum);
            }
        }
        String projectCount = venueInfoBean.getProjectCount();
        if (projectCount != null) {
            String str = vh2.INSTANCE.f(projectCount, 0) > 0 ? projectCount : null;
            if (str != null) {
                if (sb.length() > 0) {
                    sb.append(" | ");
                }
                sb.append("在售演出：");
                sb.append(str);
            }
        }
        if (sb.length() > 0) {
            this.b.setText(sb.toString());
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        OnVenueInfoListener onVenueInfoListener = this.f;
        if (onVenueInfoListener != null) {
            View view = this.itemView;
            b41.h(view, "itemView");
            onVenueInfoListener.onVenueViewExpose(view, venueInfoBean);
        }
    }

    public final void d(@Nullable OnVenueInfoListener onVenueInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "668294743")) {
            ipChange.ipc$dispatch("668294743", new Object[]{this, onVenueInfoListener});
        } else {
            this.f = onVenueInfoListener;
        }
    }
}
