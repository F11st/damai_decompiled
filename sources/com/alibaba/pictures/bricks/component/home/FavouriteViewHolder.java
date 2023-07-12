package com.alibaba.pictures.bricks.component.home;

import android.view.View;
import android.widget.TextView;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.FavouriteBean;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMDigitTextView;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.alibaba.pictures.bricks.view.RoundImageView;
import com.alibaba.pictures.bricks.view.ScoreStarViewV2;
import com.alient.onearch.adapter.view.BaseViewHolder;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FavouriteViewHolder extends BaseViewHolder<FavouriteBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final TextView content;
    @NotNull
    private final DMLabelView label;
    @NotNull
    private final LiveRoomView live;
    @NotNull
    private final TextView name;
    @NotNull
    private final RoundImageView poster;
    @NotNull
    private final ScoreStarViewV2 scoreIcon;
    @NotNull
    private final View scoreLayout;
    @NotNull
    private final DMDigitTextView scoreText;
    @NotNull
    private final DMCategroyTagView tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavouriteViewHolder(@NotNull View view) {
        super(view);
        b41.i(view, "view");
        View findViewById = view.findViewById(R$id.favourite_poster);
        b41.h(findViewById, "view.findViewById(R.id.favourite_poster)");
        this.poster = (RoundImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.content);
        b41.h(findViewById2, "view.findViewById(R.id.content)");
        this.content = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.name);
        b41.h(findViewById3, "view.findViewById(R.id.name)");
        this.name = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.favourite_tag);
        b41.h(findViewById4, "view.findViewById(R.id.favourite_tag)");
        this.tag = (DMCategroyTagView) findViewById4;
        View findViewById5 = view.findViewById(R$id.favourite_live);
        b41.h(findViewById5, "view.findViewById(R.id.favourite_live)");
        this.live = (LiveRoomView) findViewById5;
        View findViewById6 = view.findViewById(R$id.favourite_score_layout);
        b41.h(findViewById6, "view.findViewById(R.id.favourite_score_layout)");
        this.scoreLayout = findViewById6;
        View findViewById7 = view.findViewById(R$id.favourite_score_text);
        b41.h(findViewById7, "view.findViewById(R.id.favourite_score_text)");
        this.scoreText = (DMDigitTextView) findViewById7;
        View findViewById8 = view.findViewById(R$id.favourite_score_icon);
        b41.h(findViewById8, "view.findViewById(R.id.favourite_score_icon)");
        this.scoreIcon = (ScoreStarViewV2) findViewById8;
        View findViewById9 = view.findViewById(R$id.favourite_label);
        b41.h(findViewById9, "view.findViewById(R.id.favourite_label)");
        this.label = (DMLabelView) findViewById9;
    }

    @Override // com.alient.onearch.adapter.view.BaseViewHolder
    public void bindData(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "308122020")) {
            ipChange.ipc$dispatch("308122020", new Object[]{this, iItem});
            return;
        }
        b41.i(iItem, "item");
        ImageLoaderProviderProxy.getProxy().loadinto(getValue().coverUrl, this.poster);
        String str = getValue().name;
        if (str == null || str.length() == 0) {
            this.name.setVisibility(8);
        } else {
            this.name.setVisibility(0);
            this.name.setText(getValue().name);
        }
        this.content.setText(getValue().displayContent);
        String str2 = getValue().liveStatus;
        if (str2 == null || str2.length() == 0) {
            String str3 = getValue().categoryName;
            if (!(str3 == null || str3.length() == 0) && !getValue().tagType.equals("1") && !getValue().tagType.equals("2") && !getValue().tagType.equals("5")) {
                this.live.setVisibility(8);
                this.tag.setVisibility(0);
                this.tag.setTagName(getValue().categoryName);
            } else {
                this.tag.setVisibility(8);
            }
        } else {
            this.tag.setVisibility(8);
            this.live.setVisibility(0);
            this.live.setLiveType(getValue().getLiveType());
        }
        String str4 = getValue().itemScore;
        if (str4 == null || str4.length() == 0) {
            this.scoreLayout.setVisibility(8);
            String str5 = getValue().tagType;
            if (str5 != null && str5.length() != 0) {
                z = false;
            }
            if (!z && (getValue().tagType.equals("1") || getValue().tagType.equals("2") || getValue().tagType.equals("5"))) {
                this.label.setVisibility(0);
                if (b41.d("1", getValue().tagType)) {
                    this.label.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
                    return;
                } else if (b41.d("2", getValue().tagType)) {
                    this.label.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                    return;
                } else if (b41.d("5", getValue().tagType)) {
                    this.label.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_PERFORMANCE);
                    return;
                } else {
                    return;
                }
            }
            this.label.setVisibility(8);
            return;
        }
        this.label.setVisibility(8);
        this.scoreLayout.setVisibility(0);
        this.scoreText.setText(getValue().itemScore);
        try {
            ScoreStarViewV2 scoreStarViewV2 = this.scoreIcon;
            String str6 = getValue().itemScore;
            b41.h(str6, "value.itemScore");
            scoreStarViewV2.updateView(Double.parseDouble(str6));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
