package com.alibaba.pictures.bricks.component.artist;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$string;
import com.alibaba.pictures.bricks.component.artist.ArtistContract;
import com.alibaba.pictures.bricks.onearch.AbsView;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistView extends AbsView<IItem<ItemValue>, ArtistContract.Model<IItem<ItemValue>>, ArtistContract.Presenter<IItem<ItemValue>, ArtistContract.Model<IItem<ItemValue>>>> implements ArtistContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    private final RoundRadiusImageView artistAvatar;
    private final TextView artistName;
    private final View divider;
    private final View fans;
    private final TextView fansCount;
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
            if (AndroidInstantRuntime.support(ipChange, "-847727879")) {
                ipChange.ipc$dispatch("-847727879", new Object[]{this, view});
            } else {
                ((ArtistContract.Presenter) ArtistView.this.presenter).gotoHome();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1263562490")) {
                ipChange.ipc$dispatch("1263562490", new Object[]{this, view});
            } else {
                ((ArtistContract.Presenter) ArtistView.this.presenter).gotoHome();
            }
        }
    }

    public ArtistView(View view) {
        super(view);
        this.artistAvatar = (RoundRadiusImageView) view.findViewById(R$id.artist_avatar);
        this.artistName = (TextView) view.findViewById(R$id.artist_name);
        this.fans = view.findViewById(R$id.fans);
        this.fansCount = (TextView) view.findViewById(R$id.fans_count);
        this.divider = view.findViewById(R$id.divider);
        this.performanceCount = (TextView) view.findViewById(R$id.performance_count);
        view.findViewById(R$id.goto_home).setOnClickListener(new a());
        view.setOnClickListener(new b());
    }

    @Override // com.alibaba.pictures.bricks.component.artist.ArtistContract.View
    public void renderArtistAvatar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1030330767")) {
            ipChange.ipc$dispatch("1030330767", new Object[]{this, str});
        } else {
            ImageLoaderProviderProxy.getProxy().loadinto(str, this.artistAvatar);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.artist.ArtistContract.View
    public void renderArtistName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1935134243")) {
            ipChange.ipc$dispatch("-1935134243", new Object[]{this, str});
        } else {
            this.artistName.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.artist.ArtistContract.View
    public void renderFansCount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1873405152")) {
            ipChange.ipc$dispatch("-1873405152", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
            this.fans.setVisibility(8);
            this.divider.setVisibility(8);
            this.fansCount.setText("");
        } else {
            this.fans.setVisibility(0);
            this.divider.setVisibility(0);
            this.fansCount.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.artist.ArtistContract.View
    public void renderPerformanceCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794914723")) {
            ipChange.ipc$dispatch("-794914723", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.performanceCount.setText(getRenderView().getContext().getString(R$string.bricks_search_sale_performance_unit, Integer.valueOf(i)));
        }
    }
}
