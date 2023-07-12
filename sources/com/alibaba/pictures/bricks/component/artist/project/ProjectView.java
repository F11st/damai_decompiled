package com.alibaba.pictures.bricks.component.artist.project;

import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.component.artist.project.ProjectContract;
import com.alibaba.pictures.bricks.view.RoundRadiusImageView;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.kg1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ProjectView extends AbsView<GenericItem<ItemValue>, ProjectModel, ProjectPresent> implements ProjectContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final RoundRadiusImageView artistAvatar;
    @NotNull
    private final TextView cityName;
    @NotNull
    private final View divider;
    @NotNull
    private final TextView price;
    @NotNull
    private final TextView pricePrefix;
    @NotNull
    private final TextView priceSuffix;
    @NotNull
    private final TextView showTime;
    @NotNull
    private final TextView title;
    @NotNull
    private final TextView venueName;
    @NotNull
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProjectView(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        this.view = view;
        View findViewById = view.findViewById(R$id.poster);
        b41.h(findViewById, "view.findViewById(R.id.poster)");
        this.artistAvatar = (RoundRadiusImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.title);
        b41.h(findViewById2, "view.findViewById(R.id.title)");
        TextView textView = (TextView) findViewById2;
        this.title = textView;
        View findViewById3 = view.findViewById(R$id.city_name);
        b41.h(findViewById3, "view.findViewById(R.id.city_name)");
        this.cityName = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.show_time);
        b41.h(findViewById4, "view.findViewById(R.id.show_time)");
        this.showTime = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.venue_name);
        b41.h(findViewById5, "view.findViewById(R.id.venue_name)");
        this.venueName = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R$id.price_prefix);
        b41.h(findViewById6, "view.findViewById(R.id.price_prefix)");
        this.pricePrefix = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R$id.price_suffix);
        b41.h(findViewById7, "view.findViewById(R.id.price_suffix)");
        this.priceSuffix = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R$id.price);
        b41.h(findViewById8, "view.findViewById(R.id.price)");
        TextView textView2 = (TextView) findViewById8;
        this.price = textView2;
        View findViewById9 = view.findViewById(R$id.divider);
        b41.h(findViewById9, "view.findViewById(R.id.divider)");
        this.divider = findViewById9;
        TextPaint paint = textView.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        TextPaint paint2 = textView2.getPaint();
        if (paint2 == null) {
            return;
        }
        paint2.setFakeBoldText(true);
    }

    @NotNull
    public final View getView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1865790042") ? (View) ipChange.ipc$dispatch("-1865790042", new Object[]{this}) : this.view;
    }

    @Override // com.alibaba.pictures.bricks.component.artist.project.ProjectContract.View
    public void renderBackground(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642565939")) {
            ipChange.ipc$dispatch("-1642565939", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.view.setBackgroundResource(R$drawable.bricks_list_bg_bottom_radius_9);
            this.divider.setVisibility(8);
        } else {
            this.view.setBackgroundResource(R$drawable.bricks_list_bg);
            this.divider.setVisibility(0);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.artist.project.ProjectContract.View
    public void renderCityName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973615991")) {
            ipChange.ipc$dispatch("-1973615991", new Object[]{this, str});
        } else {
            this.cityName.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.artist.project.ProjectContract.View
    public void renderPoster(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-33202126")) {
            ipChange.ipc$dispatch("-33202126", new Object[]{this, str});
            return;
        }
        kg1 j = kg1.Companion.a(this.view.getContext()).j(str);
        int i = R$drawable.bricks_uikit_default_image_bg_gradient;
        j.n(i).e(i).g(this.artistAvatar);
    }

    @Override // com.alibaba.pictures.bricks.component.artist.project.ProjectContract.View
    public void renderPrice(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1971503862")) {
            ipChange.ipc$dispatch("1971503862", new Object[]{this, str});
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z && !b41.d(str, "价格待定") && !b41.d(str, "待定")) {
            this.pricePrefix.setVisibility(0);
            this.priceSuffix.setVisibility(0);
            this.price.setText(str);
            return;
        }
        this.pricePrefix.setVisibility(8);
        this.priceSuffix.setVisibility(8);
        this.price.setText("价格待定");
    }

    @Override // com.alibaba.pictures.bricks.component.artist.project.ProjectContract.View
    public void renderShowTime(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "91262517")) {
            ipChange.ipc$dispatch("91262517", new Object[]{this, str});
        } else {
            this.showTime.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.artist.project.ProjectContract.View
    public void renderTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1191502151")) {
            ipChange.ipc$dispatch("1191502151", new Object[]{this, str});
        } else {
            this.title.setText(str);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.artist.project.ProjectContract.View
    public void renderVenueName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995921595")) {
            ipChange.ipc$dispatch("-1995921595", new Object[]{this, str});
        } else {
            this.venueName.setText(str);
        }
    }
}
