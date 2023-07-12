package tb;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.discover.content.bean.ContentTour;
import cn.damai.discover.content.bean.TwoTuple;
import cn.damai.discover.content.ui.viewholder.CityProjectListPanel;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.pictures.bricks.component.project.bean.CommonTagBean;
import com.alibaba.pictures.bricks.component.project.bean.ProjectBuyStatus;
import com.alibaba.pictures.bricks.component.project.bean.RankingListBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ew1 extends cp2<TwoTuple<String, ContentTour>> implements OnItemBindListener<ContentTour.ContentRelatedTourListItem> {
    private static transient /* synthetic */ IpChange $ipChange;
    private View d;
    private RoundImageView e;
    private RoundImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private CityProjectListPanel k;
    private TextView l;
    private View m;
    private TextView n;
    private TextView o;
    private View p;
    private View q;
    private FlowLayout r;
    private ProjectItemBean s;

    public ew1(Context context) {
        super(context);
    }

    private void d(ProjectItemBean projectItemBean) {
        CommonTagBean commonTagBean;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "516095163")) {
            ipChange.ipc$dispatch("516095163", new Object[]{this, projectItemBean});
        } else if (!TextUtils.isEmpty(projectItemBean.atmosphericPic)) {
            e(DMTagType.TAG_TYPE_ONEONE, projectItemBean.atmosphericPic);
        } else if (!TextUtils.isEmpty(projectItemBean.discountRate)) {
            f(DMTagType.TAG_TYPE_PREFERENTIAL, projectItemBean.discountRate + "折起");
        } else if (!TextUtils.isEmpty(projectItemBean.showTag)) {
            f(DMTagType.TAG_TYPE_BUSINESS, projectItemBean.showTag);
        } else {
            RankingListBean rankingListBean = projectItemBean.rankingList;
            if (rankingListBean != null) {
                f(DMTagType.TAG_TYPE_RANK, rankingListBean.title);
            } else if (!TextUtils.isEmpty(projectItemBean.actores)) {
                f(DMTagType.TAG_TYPE_BUSINESS, projectItemBean.actores);
            } else {
                String couponTag = projectItemBean.getCouponTag();
                if (!TextUtils.isEmpty(couponTag)) {
                    f(DMTagType.TAG_TYPE_PREFERENTIAL, couponTag);
                    return;
                }
                String activityTag = projectItemBean.getActivityTag();
                if (!TextUtils.isEmpty(activityTag)) {
                    f(DMTagType.TAG_TYPE_PREFERENTIAL, activityTag);
                    return;
                }
                String privilegeTag = projectItemBean.getPrivilegeTag();
                if (!TextUtils.isEmpty(privilegeTag)) {
                    f(DMTagType.TAG_TYPE_PREFERENTIAL, privilegeTag);
                    return;
                }
                List<CommonTagBean> list = projectItemBean.commonTags;
                if (list != null && list.size() > 0 && (commonTagBean = projectItemBean.commonTags.get(0)) != null && commonTagBean.id == 1 && !TextUtils.isEmpty(commonTagBean.name)) {
                    f(DMTagType.TAG_TYPE_SERVICES, commonTagBean.name);
                    return;
                }
                if (projectItemBean.isSelectSeat()) {
                    f(DMTagType.TAG_TYPE_SERVICES, "可选座");
                } else {
                    z = false;
                }
                this.q.setVisibility(z ? 0 : 8);
            }
        }
    }

    private void e(DMTagType dMTagType, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526401874")) {
            ipChange.ipc$dispatch("1526401874", new Object[]{this, dMTagType, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMCommonTagView dMCommonTagView = new DMCommonTagView(this.a);
            dMCommonTagView.setTagType(dMTagType).setTagImage(str);
            this.r.addView(dMCommonTagView);
        }
    }

    private void f(DMTagType dMTagType, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "591917449")) {
            ipChange.ipc$dispatch("591917449", new Object[]{this, dMTagType, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            TextView textView = new TextView(this.a);
            textView.setPadding(0, 0, 0, 0);
            textView.setText(str);
            textView.setTextSize(12.0f);
            textView.setTextColor(Color.parseColor("#FF901C"));
            this.r.addView(textView);
        }
    }

    private void g(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533780071")) {
            ipChange.ipc$dispatch("-533780071", new Object[]{this, str, str2, str3});
            return;
        }
        TextView textView = this.h;
        if (TextUtils.isEmpty(str)) {
            str = "城市待定";
        }
        textView.setText(str);
        TextView textView2 = this.i;
        if (TextUtils.isEmpty(str2)) {
            str2 = "时间待定";
        }
        textView2.setText(str2);
        TextView textView3 = this.j;
        if (TextUtils.isEmpty(str3)) {
            str3 = "场馆待定";
        }
        textView3.setText(str3);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-30596090") ? ((Integer) ipChange.ipc$dispatch("-30596090", new Object[]{this})).intValue() : R$layout.item_content_detail_project_ralate;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167514835")) {
            ipChange.ipc$dispatch("1167514835", new Object[]{this});
            return;
        }
        this.d = this.b.findViewById(R$id.card_project_ui);
        this.e = (RoundImageView) this.b.findViewById(R$id.project_pic);
        this.f = (RoundImageView) this.b.findViewById(R$id.project_pic_tint);
        this.g = (TextView) this.b.findViewById(R$id.project_title);
        this.o = (TextView) this.b.findViewById(R$id.tv_btn);
        this.h = (TextView) this.b.findViewById(R$id.tv_project_city);
        this.i = (TextView) this.b.findViewById(R$id.tv_project_time);
        this.j = (TextView) this.b.findViewById(R$id.tv_project_location);
        this.l = (TextView) this.b.findViewById(R$id.status_project_un_sale);
        this.m = this.b.findViewById(R$id.status_with_price_ui);
        this.n = (TextView) this.b.findViewById(R$id.with_price_text);
        this.p = this.b.findViewById(R$id.status_price_pending);
        this.r = (FlowLayout) this.b.findViewById(R$id.project_tag_ui);
        this.q = this.b.findViewById(R$id.project_tag_ui_line);
        this.r.setSingleLine(true);
        this.k = new CityProjectListPanel(this.b, this);
        this.d.setOnClickListener(this);
        this.e.setBorder(1, Color.parseColor("#1A000000"));
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
    /* renamed from: h */
    public void exposeItem(View view, ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2077465723")) {
            ipChange.ipc$dispatch("2077465723", new Object[]{this, view, contentRelatedTourListItem, Integer.valueOf(i)});
        }
    }

    public void i(TwoTuple<String, ContentTour> twoTuple) {
        ContentTour contentTour;
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1928479016")) {
            ipChange.ipc$dispatch("-1928479016", new Object[]{this, twoTuple});
        } else if (twoTuple != null && (contentTour = twoTuple.second) != null) {
            ContentTour contentTour2 = contentTour;
            ProjectItemBean projectItemBean = contentTour2.itemInfo;
            this.s = projectItemBean;
            if (projectItemBean != null) {
                this.d.setVisibility(0);
                int a = m62.a(mu0.a(), 64.0f);
                int a2 = m62.a(mu0.a(), 48.0f);
                String str = projectItemBean.liveStartTime;
                if (TextUtils.isEmpty(str)) {
                    str = projectItemBean.showTime;
                }
                g(projectItemBean.cityName, str, projectItemBean.venueName);
                this.g.setText(projectItemBean.name);
                ProjectBuyStatus projectBuyStatus = projectItemBean.showStatus;
                if (projectBuyStatus != null && !TextUtils.isEmpty(projectBuyStatus.id) && "2".equals(projectItemBean.showStatus.id)) {
                    this.m.setVisibility(8);
                    this.p.setVisibility(8);
                    this.l.setVisibility(0);
                    this.f.setVisibility(0);
                    this.o.setVisibility(8);
                    z = false;
                } else {
                    this.f.setVisibility(8);
                    this.l.setVisibility(8);
                    String str2 = projectItemBean.priceLow;
                    if (!TextUtils.isEmpty(str2) && !str2.contains("待定")) {
                        this.m.setVisibility(0);
                        this.n.setText(str2);
                        this.p.setVisibility(8);
                    } else {
                        this.p.setVisibility(0);
                        this.m.setVisibility(8);
                    }
                    z = true;
                }
                this.q.setVisibility(z ? 0 : 8);
                if (z) {
                    d(projectItemBean);
                }
                DMImageCreator f = C0504a.b().f(projectItemBean.verticalPic, a2, a);
                int i = R$drawable.uikit_default_image_bg_gradient;
                f.i(i).c(i).g(this.e);
            } else {
                this.d.setVisibility(8);
            }
            this.k.b(contentTour2.relateItem, projectItemBean != null);
            c(true);
        } else {
            c(false);
        }
    }

    @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
    /* renamed from: j */
    public void onItemClick(ContentTour.ContentRelatedTourListItem contentRelatedTourListItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-355292826")) {
            ipChange.ipc$dispatch("-355292826", new Object[]{this, contentRelatedTourListItem, Integer.valueOf(i)});
        } else if (this.a == null) {
        } else {
            C0529c.e().x(getLiveUt().L(contentRelatedTourListItem.itemId, i));
            Bundle bundle = new Bundle();
            bundle.putString("id", contentRelatedTourListItem.itemId);
            qd2.a(this.a, contentRelatedTourListItem.schema, bundle);
        }
    }

    @Override // tb.cp2, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1632561555")) {
            ipChange.ipc$dispatch("-1632561555", new Object[]{this, view});
        } else if (view.getId() != R$id.card_project_ui || this.s == null || this.a == null) {
        } else {
            C0529c.e().x(getLiveUt().A(2, this.s.id));
            Bundle bundle = new Bundle();
            bundle.putString("id", this.s.id);
            bundle.putString("projectImage", this.s.verticalPic);
            qd2.a(this.a, this.s.schema, bundle);
        }
    }
}
