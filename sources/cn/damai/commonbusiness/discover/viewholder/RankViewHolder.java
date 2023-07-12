package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.damai.common.bean.RankBean;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class RankViewHolder extends BaseViewHolder<RankBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private OnItemClickListener<RankBean> b;
    private DMPosterView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private RankBean i;
    private int j;

    public RankViewHolder(Context context, ViewGroup viewGroup, OnItemClickListener<RankBean> onItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.common_rank_item_v2, viewGroup, false));
        this.b = onItemClickListener;
        this.a = context;
        this.c = (DMPosterView) this.itemView.findViewById(R$id.poster_v2);
        this.d = (TextView) this.itemView.findViewById(R$id.tv_title_v2);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_subtitle_v2);
        this.f = (TextView) this.itemView.findViewById(R$id.tv_see_people_num_v2);
        this.g = (TextView) this.itemView.findViewById(R$id.tv_project_num_v2);
        this.h = (TextView) this.itemView.findViewById(R$id.btn_go_v2);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: c */
    public void a(RankBean rankBean, int i) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1806872091")) {
            ipChange.ipc$dispatch("-1806872091", new Object[]{this, rankBean, Integer.valueOf(i)});
        } else if (rankBean == null) {
        } else {
            rankBean.pos = i;
            this.i = rankBean;
            this.j = i;
            this.c.setImageUrl(rankBean.bgPic);
            if (rankBean.isRankListType()) {
                this.c.setLabelType(DMLabelType.LABEL_TYPE_CUSTOM);
                this.c.getLabelView().setLabelName("1");
                this.c.getLabelView().setCornerRadii(l62.a(this.a, 16.0f), l62.a(this.a, 16.0f), l62.a(this.a, 16.0f), l62.a(this.a, 2.0f));
                this.c.getLabelView().setLabelHeight(l62.a(this.a, 32.0f));
                this.c.getLabelView().setLabelWidth(l62.a(this.a, 32.0f));
                this.c.getLabelView().setLabelTextSize(24.0f);
                this.c.getLabelView().setBgColor("#FF5A5A", "#FF42B0");
                this.c.setCategoryTagName("榜单");
            } else {
                this.c.setLabelType(null);
                this.c.setCategoryTagName("麦单");
            }
            this.d.setText(rankBean.name);
            this.e.setText(rankBean.shortName);
            this.f.setText(rankBean.ipvuv);
            if (TextUtils.isEmpty(rankBean.count)) {
                this.g.setVisibility(8);
            } else {
                if (TextUtils.isEmpty(rankBean.ipvuv)) {
                    str = rankBean.count;
                } else {
                    str = " | " + rankBean.count;
                }
                this.g.setVisibility(0);
                this.g.setText(str);
            }
            if (TextUtils.isEmpty(rankBean.statusName)) {
                this.h.setText("去看看");
                this.h.setBackgroundResource(R$drawable.common_rank_btn_bg_v2);
                this.h.setTextColor(Color.parseColor("#ffffff"));
            } else {
                this.h.setText(rankBean.statusName);
                if (!rankBean.statusName.contains("失效") && !rankBean.statusName.contains("下架")) {
                    this.h.setBackgroundResource(R$drawable.common_rank_btn_bg_v2);
                    this.h.setTextColor(Color.parseColor("#ffffff"));
                } else {
                    this.h.setBackgroundResource(R$drawable.common_rank_grey_bg_v2);
                    this.h.setTextColor(Color.parseColor("#666666"));
                }
            }
            this.itemView.setTag(rankBean);
            this.itemView.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970175132")) {
            ipChange.ipc$dispatch("-970175132", new Object[]{this, view});
            return;
        }
        RankBean rankBean = this.i;
        if (rankBean == null || this.b == null || !rankBean.isEnableClick()) {
            return;
        }
        this.b.onItemClick(this.i, this.j);
    }
}
