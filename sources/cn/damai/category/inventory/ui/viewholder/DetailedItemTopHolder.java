package cn.damai.category.inventory.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranking.bean.ItemBean;
import cn.damai.common.user.c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.m62;
import tb.qd2;
import tb.u70;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DetailedItemTopHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private LayoutInflater b;
    private LinearLayout c;
    private LinearLayout d;
    private FrameLayout e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private RoundImageView k;
    private DMCategroyTagView l;
    private LinearLayout m;
    private TextView n;
    private TextView o;
    private LinearLayout p;
    private TextView q;
    private LinearLayout r;
    private TextView s;
    private TextView t;
    private String u;
    private String v;
    private int[] w;
    View.OnClickListener x;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-182620275")) {
                ipChange.ipc$dispatch("-182620275", new Object[]{this, view});
                return;
            }
            try {
                DetailedItemTopHolder.this.g((ItemBean) view.getTag());
            } catch (Exception unused) {
            }
        }
    }

    public DetailedItemTopHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.inventory_first_project, (ViewGroup) null));
        this.x = new a();
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = this.itemView.getContext();
        this.b = layoutInflater;
        f(this.itemView);
    }

    private void b(LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "821271872")) {
            ipChange.ipc$dispatch("821271872", new Object[]{this, linearLayout});
            return;
        }
        this.n = (TextView) linearLayout.findViewById(R$id.tv_desc);
        ((ImageView) linearLayout.findViewById(R$id.iv_icon)).setImageResource(R$drawable.inventory_address);
        this.o = (TextView) linearLayout.findViewById(R$id.tv_info);
    }

    private void c(LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "982386413")) {
            ipChange.ipc$dispatch("982386413", new Object[]{this, linearLayout});
            return;
        }
        this.s = (TextView) linearLayout.findViewById(R$id.tv_desc);
        ((ImageView) linearLayout.findViewById(R$id.iv_icon)).setImageResource(R$drawable.inventory_fans);
        this.t = (TextView) linearLayout.findViewById(R$id.tv_info);
    }

    private void d(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1861709829")) {
            ipChange.ipc$dispatch("1861709829", new Object[]{this, view});
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.fl_root);
        this.e = frameLayout;
        frameLayout.setOnClickListener(this.x);
        this.f = (TextView) view.findViewById(R$id.tv_benefit);
        this.g = (TextView) view.findViewById(R$id.tv_benefit_value);
        this.h = (LinearLayout) view.findViewById(R$id.ll_reason);
        this.i = (TextView) view.findViewById(R$id.tv_reason);
        this.j = (TextView) view.findViewById(R$id.tv_name);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.image_project);
        this.k = roundImageView;
        roundImageView.setBorderRadius(6);
        this.l = (DMCategroyTagView) view.findViewById(R$id.tv_type_mark);
        this.m = (LinearLayout) view.findViewById(R$id.ll_city_venue);
        this.p = (LinearLayout) view.findViewById(R$id.ll_time);
        this.r = (LinearLayout) view.findViewById(R$id.ll_fans);
        b(this.m);
        e(this.p);
        c(this.r);
    }

    private void e(LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776421510")) {
            ipChange.ipc$dispatch("-776421510", new Object[]{this, linearLayout});
            return;
        }
        linearLayout.findViewById(R$id.tv_desc).setVisibility(8);
        ((ImageView) linearLayout.findViewById(R$id.iv_icon)).setImageResource(R$drawable.inventory_time);
        this.q = (TextView) linearLayout.findViewById(R$id.tv_info);
    }

    private void f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-341295752")) {
            ipChange.ipc$dispatch("-341295752", new Object[]{this, view});
            return;
        }
        this.c = (LinearLayout) view.findViewById(R$id.ll_topItems);
        this.d = (LinearLayout) view.findViewById(R$id.ll_topItems_shape);
    }

    private void h(ItemBean itemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927668852")) {
            ipChange.ipc$dispatch("927668852", new Object[]{this, itemBean, Integer.valueOf(i)});
        } else if (itemBean == null) {
        } else {
            itemBean.index = i;
            this.e.setTag(itemBean);
            cn.damai.common.image.a.b().f(itemBean.verticalPic, m62.a(this.a, 111.0f), m62.a(this.a, 148.0f)).c(R$drawable.uikit_default_image_bg_gradient).g(this.k);
            this.f.setText(itemBean.benefitPoint);
            this.g.setText(itemBean.benefitPoint);
            if (!TextUtils.isEmpty(itemBean.categoryName)) {
                this.l.setVisibility(0);
                this.l.setTagName(itemBean.categoryName);
            } else {
                this.l.setVisibility(8);
            }
            this.j.setText(itemBean.name);
            if (TextUtils.isEmpty(itemBean.cityName) && TextUtils.isEmpty(itemBean.venueName)) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                this.n.setText(itemBean.cityName);
                if (TextUtils.isEmpty(itemBean.venueName)) {
                    this.o.setText("");
                } else {
                    this.o.setText(itemBean.venueName);
                }
            }
            this.q.setText(itemBean.showTime);
            if (!TextUtils.isEmpty(itemBean.ipvuv) && !itemBean.ipvuv.equals("") && !itemBean.ipvuv.equals("0")) {
                this.s.setVisibility(0);
                this.s.setText(itemBean.ipvuv);
                this.t.setText("人想看");
            } else {
                this.s.setVisibility(8);
                this.t.setText("人气爆棚");
            }
            if (!TextUtils.isEmpty(itemBean.reason)) {
                this.h.setVisibility(0);
                this.i.setText(itemBean.reason);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public void a(List<ItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1973155699")) {
            ipChange.ipc$dispatch("1973155699", new Object[]{this, list});
            return;
        }
        int e = wh2.e(list);
        if (e == 0) {
            return;
        }
        this.c.removeAllViews();
        for (int i = 0; i < e; i++) {
            View inflate = this.b.inflate(R$layout.inventory_first_project_item, (ViewGroup) null);
            d(inflate);
            h(list.get(i), i);
            this.c.addView(inflate);
        }
        j();
    }

    public void g(ItemBean itemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508739742")) {
            ipChange.ipc$dispatch("1508739742", new Object[]{this, itemBean});
        } else if (itemBean == null) {
        } else {
            c.e().x(u70.g().i(this.u, itemBean.id, this.v, itemBean.index));
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, itemBean.id);
            bundle.putString("projectName", itemBean.name);
            bundle.putString("projectImage", itemBean.verticalPic);
            qd2.a(this.a, itemBean.schema, bundle);
        }
    }

    public void i(String str, String str2, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-425992959")) {
            ipChange.ipc$dispatch("-425992959", new Object[]{this, str, str2, iArr});
            return;
        }
        this.u = str;
        this.v = str2;
        this.w = iArr;
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "9879675")) {
            ipChange.ipc$dispatch("9879675", new Object[]{this});
            return;
        }
        int[] iArr = this.w;
        if (iArr == null || iArr.length != 2) {
            return;
        }
        this.d.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, this.w));
    }
}
