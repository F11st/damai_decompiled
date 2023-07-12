package com.alibaba.pictures.bricks.component.channel;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.uikit.view.DMLabelType;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.bricks.bean.RankBean;
import com.alibaba.pictures.bricks.component.channel.RankCardContract;
import com.alibaba.pictures.bricks.view.DMPosterView;
import com.alient.onearch.adapter.view.AbsView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class RankCardView extends AbsView<GenericItem<ItemValue>, RankCardModel, RankCardPresent> implements RankCardContract.View {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View itemView;
    private final Context mContext;
    @NotNull
    private final TextView mGoBtn;
    @NotNull
    private final DMPosterView mPoster;
    @NotNull
    private final TextView mProjectNumTv;
    @NotNull
    private final TextView mSeePeopleNumTv;
    @NotNull
    private final TextView mSubTitleTv;
    @NotNull
    private final TextView mTitleTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankCardView(@NotNull View view) {
        super(view);
        b41.i(view, "itemView");
        this.itemView = view;
        this.mContext = view.getContext();
        View findViewById = view.findViewById(R$id.bricks_poster);
        b41.h(findViewById, "itemView.findViewById(R.id.bricks_poster)");
        this.mPoster = (DMPosterView) findViewById;
        View findViewById2 = view.findViewById(R$id.bricks_tv_title);
        b41.h(findViewById2, "itemView.findViewById<Te…w?>(R.id.bricks_tv_title)");
        this.mTitleTv = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.bricks_tv_subtitle);
        b41.h(findViewById3, "itemView.findViewById<Te…(R.id.bricks_tv_subtitle)");
        this.mSubTitleTv = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.bricks_tv_see_people_num);
        b41.h(findViewById4, "itemView.findViewById<Te…bricks_tv_see_people_num)");
        this.mSeePeopleNumTv = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.bricks_tv_project_num);
        b41.h(findViewById5, "itemView.findViewById<Te…id.bricks_tv_project_num)");
        this.mProjectNumTv = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R$id.bricks_btn_go);
        b41.h(findViewById6, "itemView.findViewById<Te…iew?>(R.id.bricks_btn_go)");
        this.mGoBtn = (TextView) findViewById6;
    }

    @Override // com.alibaba.pictures.bricks.component.channel.RankCardContract.View
    public void bind(@Nullable RankBean rankBean) {
        Context context;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-951395441")) {
            ipChange.ipc$dispatch("-951395441", new Object[]{this, rankBean});
        } else if (rankBean == null) {
        } else {
            this.mPoster.setImageUrl(rankBean.getPic());
            this.mPoster.setLabelType(DMLabelType.LABEL_TYPE_CUSTOM);
            this.mPoster.getLabelView().setLabelName("1");
            s60 s60Var = s60.INSTANCE;
            Context context2 = this.mContext;
            b41.h(context2, "mContext");
            float b = s60Var.b(context2, 16);
            b41.h(this.mContext, "mContext");
            Context context3 = this.mContext;
            b41.h(context3, "mContext");
            int b2 = s60Var.b(context3, 32);
            this.mPoster.getLabelView().setCornerRadii(b, b, b, s60Var.b(context, 2));
            this.mPoster.getLabelView().setLabelHeight(b2);
            this.mPoster.getLabelView().setLabelWidth(b2);
            this.mPoster.getLabelView().setLabelTextSize(24.0f);
            this.mPoster.getLabelView().setBgColor("#FF5A5A", "#FF42B0");
            this.mPoster.setCategoryTagName("榜单");
            this.mTitleTv.setText(rankBean.shortName);
            this.mSubTitleTv.setText(rankBean.shortDesc);
            this.mSeePeopleNumTv.setText(rankBean.followDesc);
            if (TextUtils.isEmpty(rankBean.count)) {
                this.mProjectNumTv.setVisibility(8);
            } else {
                this.mProjectNumTv.setVisibility(0);
                if (TextUtils.isEmpty(rankBean.followDesc)) {
                    str = rankBean.count;
                } else {
                    str = " | " + rankBean.count;
                }
                this.mProjectNumTv.setText(str);
            }
            this.mGoBtn.setText("去看看");
            this.mGoBtn.setBackgroundResource(R$drawable.bricks_common_rank_btn_bg);
            this.mGoBtn.setTextColor(Color.parseColor("#ffffff"));
        }
    }

    @NotNull
    public final View getItemView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1620089830") ? (View) ipChange.ipc$dispatch("1620089830", new Object[]{this}) : this.itemView;
    }
}
