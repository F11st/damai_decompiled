package cn.damai.category.inventory.ui.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.ranking.bean.ItemBean;
import cn.damai.common.image.C0504a;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.ns;
import tb.qd2;
import tb.t60;
import tb.u70;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DetailedItemHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FrameLayout b;
    private RoundImageView c;
    private DMCategroyTagView d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private String m;
    private String n;
    private int o;
    View.OnClickListener p;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.inventory.ui.viewholder.DetailedItemHolder$a */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0417a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC0417a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-917425938")) {
                ipChange.ipc$dispatch("-917425938", new Object[]{this, view});
                return;
            }
            try {
                DetailedItemHolder.this.c((ItemBean) view.getTag());
            } catch (Exception unused) {
            }
        }
    }

    public DetailedItemHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.inventory_project_item, (ViewGroup) null));
        this.p = new View$OnClickListenerC0417a();
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = this.itemView.getContext();
        b(this.itemView);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-919188489")) {
            ipChange.ipc$dispatch("-919188489", new Object[]{this, view});
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.fl_root);
        this.b = frameLayout;
        frameLayout.setOnClickListener(this.p);
        RoundImageView roundImageView = (RoundImageView) view.findViewById(R$id.image_project);
        this.c = roundImageView;
        roundImageView.setBorderRadius(6);
        this.d = (DMCategroyTagView) view.findViewById(R$id.tv_type_mark);
        this.e = (ImageView) view.findViewById(R$id.icon_video);
        this.f = (TextView) view.findViewById(R$id.tv_title);
        this.g = (TextView) view.findViewById(R$id.tv_time);
        this.h = (TextView) view.findViewById(R$id.tv_address);
        this.i = (TextView) view.findViewById(R$id.tv_see);
        this.j = (TextView) view.findViewById(R$id.tv_price);
        this.k = (TextView) view.findViewById(R$id.tv_price_tip);
        this.l = (TextView) view.findViewById(R$id.btn_buy);
        ns.d(this.l, new int[]{Color.parseColor("#FF7F81"), Color.parseColor("#FF2D79")}, t60.a(this.a, 25.0f), Color.parseColor("#4bFF2D79"), t60.a(this.a, 2.0f), 0, t60.a(this.a, 2.0f));
    }

    public void a(ItemBean itemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1111901752")) {
            ipChange.ipc$dispatch("1111901752", new Object[]{this, itemBean, Integer.valueOf(i)});
        } else if (itemBean == null) {
        } else {
            itemBean.index = i;
            this.b.setTag(itemBean);
            C0504a.b().f(itemBean.verticalPic, m62.a(this.a, 111.0f), m62.a(this.a, 148.0f)).c(R$drawable.uikit_default_image_bg_gradient).g(this.c);
            if (!TextUtils.isEmpty(itemBean.categoryName)) {
                this.d.setVisibility(0);
                this.d.setTagName(itemBean.categoryName);
            } else {
                this.d.setVisibility(8);
            }
            if (itemBean.hasVideo()) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            this.f.setText(itemBean.name);
            this.g.setText(itemBean.showTime);
            if (TextUtils.isEmpty(itemBean.venueName)) {
                this.h.setText(itemBean.cityName);
            } else {
                TextView textView = this.h;
                textView.setText(itemBean.cityName + " | " + itemBean.venueName);
            }
            if (!TextUtils.isEmpty(itemBean.ipvuv) && !itemBean.ipvuv.equals("") && !itemBean.ipvuv.equals("0")) {
                TextView textView2 = this.i;
                textView2.setText(itemBean.ipvuv + "人想看");
            } else {
                this.i.setText("人气爆棚");
            }
            if (!TextUtils.isEmpty(itemBean.priceLow)) {
                TextView textView3 = this.j;
                textView3.setText("¥" + itemBean.priceLow);
                this.k.setText("起");
            } else {
                this.j.setText("");
                this.k.setText("");
            }
            if (!TextUtils.isEmpty(itemBean.buttonTitle)) {
                this.l.setVisibility(0);
                this.l.setText(itemBean.buttonTitle);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public void c(ItemBean itemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1039027265")) {
            ipChange.ipc$dispatch("-1039027265", new Object[]{this, itemBean});
        } else if (itemBean == null) {
        } else {
            C0529c.e().x(u70.g().i(this.m, itemBean.id, this.n, itemBean.index + this.o));
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, itemBean.id);
            bundle.putString("projectName", itemBean.name);
            bundle.putString("projectImage", itemBean.verticalPic);
            qd2.a(this.a, itemBean.schema, bundle);
        }
    }

    public void d(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1291974383")) {
            ipChange.ipc$dispatch("-1291974383", new Object[]{this, str, str2, Integer.valueOf(i)});
            return;
        }
        this.m = str;
        this.n = str2;
        this.o = i;
    }
}
