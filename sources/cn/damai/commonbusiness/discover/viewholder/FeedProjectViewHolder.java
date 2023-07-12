package cn.damai.commonbusiness.discover.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.mu0;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FeedProjectViewHolder extends BaseViewHolder<ProjectItemBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnItemBindListener<ProjectItemBean> a;
    private DMPosterView b;
    private TextView c;
    private TextView d;
    private View e;
    private TextView f;
    private View g;
    private View h;
    private int i;
    private int j;
    private ProjectItemBean k;
    private int l;

    public FeedProjectViewHolder(View view, OnItemBindListener<ProjectItemBean> onItemBindListener) {
        super(view);
        this.a = onItemBindListener;
        this.b = (DMPosterView) view.findViewById(R$id.feed_project_poster);
        this.c = (TextView) view.findViewById(R$id.feed_project_title);
        this.d = (TextView) view.findViewById(R$id.feed_project_time);
        this.e = view.findViewById(R$id.feed_project_with_price_ui);
        this.f = (TextView) view.findViewById(R$id.feed_project_with_price_tv);
        this.g = view.findViewById(R$id.feed_project_wantsee);
        this.h = view.findViewById(R$id.feed_project_price_pending_ui);
        DMCommonTagView dMCommonTagView = (DMCommonTagView) view.findViewById(R$id.feed_project_tag);
        this.b.setPlaceholder(R$drawable.homepage_waterflow_poster_bg);
        this.b.setVideoIconSize(24.0f, 6.0f);
        this.b.setCategoryMargin(6.0f, 6.0f);
        DMLabelView labelView = this.b.getLabelView();
        if (labelView != null) {
            float a = t60.a(mu0.a(), 12.0f);
            labelView.setCornerRadii(a, a, a, 0.0f);
        }
        this.i = m62.a(mu0.a(), 214.0f);
        this.j = m62.a(mu0.a(), 160.0f);
    }

    private boolean d(ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592798194")) {
            return ((Boolean) ipChange.ipc$dispatch("-1592798194", new Object[]{this, projectItemBean})).booleanValue();
        }
        String str = projectItemBean.liveStatus;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals("1", str) || TextUtils.equals("2", str);
    }

    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
    /* renamed from: c */
    public void a(ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1087775395")) {
            ipChange.ipc$dispatch("1087775395", new Object[]{this, projectItemBean, Integer.valueOf(i)});
        } else if (projectItemBean == null) {
        } else {
            this.k = projectItemBean;
            this.l = i;
            this.b.setImageUrlForWebp(projectItemBean.verticalPic, this.j, this.i);
            this.b.setBorderVisibility(8);
            this.b.setBorderRadius(0);
            this.b.setCategoryTagName(projectItemBean.getCategoryNameCompat());
            if (d(projectItemBean)) {
                if (TextUtils.equals("1", projectItemBean.liveStatus)) {
                    this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
                } else {
                    this.b.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
                }
            } else {
                this.b.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            }
            this.b.setScoreStar(projectItemBean.itemScore);
            this.b.setVideoIconVisibility(projectItemBean.hasVideo() ? 0 : 8);
            this.c.setText(projectItemBean.name);
            if (!TextUtils.isEmpty(projectItemBean.liveStartTime)) {
                this.d.setText(projectItemBean.liveStartTime);
            } else {
                this.d.setText(projectItemBean.showTime);
            }
            String str = projectItemBean.priceLow;
            if (!TextUtils.isEmpty(str) && !str.contains("待定")) {
                this.h.setVisibility(8);
                this.e.setVisibility(0);
                this.f.setText(str);
            } else {
                this.h.setVisibility(0);
                this.e.setVisibility(8);
            }
            this.itemView.setOnClickListener(this);
            OnItemBindListener<ProjectItemBean> onItemBindListener = this.a;
            if (onItemBindListener != null) {
                onItemBindListener.exposeItem(this.itemView, projectItemBean, i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProjectItemBean projectItemBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837881831")) {
            ipChange.ipc$dispatch("-1837881831", new Object[]{this, view});
            return;
        }
        OnItemBindListener<ProjectItemBean> onItemBindListener = this.a;
        if (onItemBindListener == null || (projectItemBean = this.k) == null) {
            return;
        }
        onItemBindListener.onItemClick(projectItemBean, this.l);
    }
}
