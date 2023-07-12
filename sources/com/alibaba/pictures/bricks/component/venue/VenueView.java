package com.alibaba.pictures.bricks.component.venue;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.venue.VenueContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.BricksIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VenueView extends AbsView<IItem<ItemValue>, VenueContract.Model<IItem<ItemValue>>, VenueContract.Presenter<IItem<ItemValue>, VenueContract.Model<IItem<ItemValue>>>> implements VenueContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView distance;
    private final BricksIconFontTextView distanceIcon;
    private final TextView location;
    private final TextView name;
    private final View performance;
    private final TextView performanceContent;
    private final TextView performanceCount;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-737262087")) {
                ipChange.ipc$dispatch("-737262087", new Object[]{this, view});
            } else {
                ((VenueContract.Presenter) VenueView.this.presenter).gotoDetail();
            }
        }
    }

    public VenueView(View view) {
        super(view);
        this.name = (TextView) view.findViewById(R$id.venue_name);
        this.location = (TextView) view.findViewById(R$id.venue_location);
        this.distance = (TextView) view.findViewById(R$id.venue_distance);
        this.distanceIcon = (BricksIconFontTextView) view.findViewById(R$id.venue_distance_icon);
        this.performance = view.findViewById(R$id.performance);
        this.performanceCount = (TextView) view.findViewById(R$id.performance_count);
        this.performanceContent = (TextView) view.findViewById(R$id.performance_content);
        view.setOnClickListener(new a());
    }

    @Override // com.alibaba.pictures.bricks.component.venue.VenueContract.View
    public void renderDistance(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1127076038")) {
            ipChange.ipc$dispatch("-1127076038", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.distanceIcon.setVisibility(8);
            this.distance.setVisibility(8);
        } else {
            this.distanceIcon.setVisibility(0);
            this.distance.setVisibility(0);
            this.distance.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.venue.VenueContract.View
    public void renderLocation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "211415930")) {
            ipChange.ipc$dispatch("211415930", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.location.setVisibility(8);
        } else {
            this.location.setVisibility(0);
            this.location.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.venue.VenueContract.View
    public void renderName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1810227812")) {
            ipChange.ipc$dispatch("1810227812", new Object[]{this, str});
        } else {
            this.name.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.venue.VenueContract.View
    public void renderPerformanceContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "149973382")) {
            ipChange.ipc$dispatch("149973382", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.performance.setVisibility(8);
        } else {
            this.performance.setVisibility(0);
            this.performanceContent.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.venue.VenueContract.View
    public void renderPerformanceCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274776400")) {
            ipChange.ipc$dispatch("-274776400", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.performance.setVisibility(8);
        } else {
            this.performance.setVisibility(0);
            this.performanceCount.setText(str);
        }
    }
}
