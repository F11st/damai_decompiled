package cn.damai.category.discountticket.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cn.damai.category.discountticket.adapter.DiscountTicketAdapter;
import cn.damai.category.discountticket.bean.biz.Column3WrapBean;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.uikit.view.DMPosterView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.m62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class Column3ProjectViewHolder extends DiscountTicketAdapter.BaseViewHolder<Column3WrapBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final int a;
    private final int b;
    private List<View$OnClickListenerC0381a> c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.discountticket.adapter.Column3ProjectViewHolder$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0381a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        View a;
        private TextView b;
        private TextView c;
        private ProjectItemBean d;
        private DMPosterView e;
        private View f;
        private View g;

        public View$OnClickListenerC0381a(View view) {
            this.a = view;
            this.e = (DMPosterView) view.findViewById(R$id.item_poster);
            this.b = (TextView) this.a.findViewById(R$id.item_title);
            this.c = (TextView) this.a.findViewById(R$id.item_price_tv);
            this.f = this.a.findViewById(R$id.item_price_layout);
            this.g = this.a.findViewById(R$id.item_price_pending);
        }

        private boolean b(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1593039826") ? ((Boolean) ipChange.ipc$dispatch("1593039826", new Object[]{this, str})).booleanValue() : TextUtils.isEmpty(str) || str.contains("待定");
        }

        public void a(ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "220330583")) {
                ipChange.ipc$dispatch("220330583", new Object[]{this, projectItemBean, Integer.valueOf(i)});
                return;
            }
            this.d = projectItemBean;
            if (projectItemBean == null) {
                this.a.setOnClickListener(null);
                this.a.setTag(null);
                this.a.setVisibility(4);
                return;
            }
            this.a.setVisibility(0);
            this.a.setOnClickListener(this);
            String str = projectItemBean.name;
            String str2 = projectItemBean.cityName;
            if (!TextUtils.isEmpty(str2)) {
                str = "【" + str2 + "】" + str;
            }
            this.b.setText(str);
            boolean b = b(projectItemBean.priceLow);
            if (!b) {
                this.c.setText(projectItemBean.priceLow);
            }
            this.f.setVisibility(b ? 8 : 0);
            this.g.setVisibility(b ? 0 : 8);
            this.e.setImageUrlForWebp(projectItemBean.verticalPic, Column3ProjectViewHolder.this.a, Column3ProjectViewHolder.this.b);
            this.e.setVideoIconVisibility(projectItemBean.hasVideo() ? 0 : 8);
            this.e.setCategoryTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
            String str3 = projectItemBean.discountRate;
            if (TextUtils.isEmpty(str3)) {
                this.e.setCategoryTagName(null);
            } else {
                this.e.setCategoryTagName(str3 + "折起");
            }
            this.e.setScoreStar(projectItemBean.itemScore, true);
            Column3ProjectViewHolder.this.e(this.a, projectItemBean, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "406570957")) {
                ipChange.ipc$dispatch("406570957", new Object[]{this, view});
                return;
            }
            ProjectItemBean projectItemBean = this.d;
            if (projectItemBean == null) {
                return;
            }
            Column3ProjectViewHolder.this.f(projectItemBean);
        }
    }

    public Column3ProjectViewHolder(View view) {
        super(view);
        this.c = new ArrayList(3);
        this.a = m62.a(mu0.a(), 103.0f);
        this.b = m62.a(mu0.a(), 138.0f);
        View findViewById = view.findViewById(R$id.item_1_layout);
        View findViewById2 = view.findViewById(R$id.item_2_layout);
        View findViewById3 = view.findViewById(R$id.item_3_layout);
        View$OnClickListenerC0381a view$OnClickListenerC0381a = new View$OnClickListenerC0381a(findViewById);
        View$OnClickListenerC0381a view$OnClickListenerC0381a2 = new View$OnClickListenerC0381a(findViewById2);
        View$OnClickListenerC0381a view$OnClickListenerC0381a3 = new View$OnClickListenerC0381a(findViewById3);
        this.c.add(view$OnClickListenerC0381a);
        this.c.add(view$OnClickListenerC0381a2);
        this.c.add(view$OnClickListenerC0381a3);
    }

    @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.BaseViewHolder
    /* renamed from: d */
    public void a(Column3WrapBean column3WrapBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-903788432")) {
            ipChange.ipc$dispatch("-903788432", new Object[]{this, column3WrapBean});
            return;
        }
        List<ProjectItemBean> list = column3WrapBean.list;
        int size = list == null ? 0 : list.size();
        while (i < 3) {
            ProjectItemBean projectItemBean = null;
            int i2 = i + 1;
            if (i2 <= size) {
                projectItemBean = list.get(i);
            }
            this.c.get(i).a(projectItemBean, i);
            i = i2;
        }
    }

    public abstract void e(View view, ProjectItemBean projectItemBean, int i);

    public abstract void f(ProjectItemBean projectItemBean);
}
