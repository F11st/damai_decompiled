package cn.damai.discover.main.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.discover.viewholder.BaseViewHolder;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ProjectHorizontalAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<ProjectItemBean> b;
    private int c;
    private int d;
    private int e;
    private int f;
    private OnProjectClickListener g;
    private ProjectExposure h;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnProjectClickListener {
        void onProjectClick(ProjectItemBean projectItemBean, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class PVh extends BaseViewHolder<ProjectItemBean> implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private RoundImageView a;
        private TextView b;
        private TextView c;
        private View d;
        private TextView e;
        private View f;
        private ProjectItemBean g;
        private int h;

        public PVh(View view) {
            super(view);
            this.a = (RoundImageView) view.findViewById(R$id.img_p);
            this.b = (TextView) view.findViewById(R$id.title_p);
            this.c = (TextView) view.findViewById(R$id.city_time_addr);
            this.d = view.findViewById(R$id.price_ui);
            this.e = (TextView) view.findViewById(R$id.project_price);
            this.f = view.findViewById(R$id.price_pending);
        }

        private String d(ProjectItemBean projectItemBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1595014774")) {
                return (String) ipChange.ipc$dispatch("-1595014774", new Object[]{this, projectItemBean});
            }
            String str = projectItemBean.cityName;
            String str2 = projectItemBean.venueName;
            String str3 = projectItemBean.showTime;
            if (TextUtils.isEmpty(str)) {
                str = "城市待定";
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "时间待定";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "场馆待定";
            }
            return str + " | " + str3 + " | " + str2;
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolder
        /* renamed from: c */
        public void a(ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1565358128")) {
                ipChange.ipc$dispatch("-1565358128", new Object[]{this, projectItemBean, Integer.valueOf(i)});
                return;
            }
            this.g = projectItemBean;
            this.h = i;
            this.itemView.setOnClickListener(this);
            this.b.setText(projectItemBean.name);
            this.c.setText(d(projectItemBean));
            String str = projectItemBean.priceLow;
            if (!TextUtils.isEmpty(str) && !str.contains("待定")) {
                this.e.setText(str);
                this.d.setVisibility(0);
                this.f.setVisibility(8);
            } else {
                this.d.setVisibility(8);
                this.f.setVisibility(0);
            }
            this.a.setBorder(1, Color.parseColor("#1A000000"));
            DMImageCreator f = C0504a.b().f(projectItemBean.verticalPic, ProjectHorizontalAdapter.this.e, ProjectHorizontalAdapter.this.f);
            int i2 = R$drawable.uikit_default_image_bg_gradient;
            f.i(i2).c(i2);
            f.g(this.a);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-615113274")) {
                ipChange.ipc$dispatch("-615113274", new Object[]{this, view});
            } else if (ProjectHorizontalAdapter.this.g == null || this.g == null) {
            } else {
                ProjectHorizontalAdapter.this.g.onProjectClick(this.g, this.h);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface ProjectExposure {
        void exposure(View view, ProjectItemBean projectItemBean, int i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-762619123")) {
            ipChange.ipc$dispatch("-762619123", new Object[]{this, baseViewHolder, Integer.valueOf(i)});
            return;
        }
        ProjectItemBean projectItemBean = this.b.get(i);
        baseViewHolder.a(projectItemBean, i);
        ProjectExposure projectExposure = this.h;
        if (projectExposure != null) {
            projectExposure.exposure(baseViewHolder.itemView, projectItemBean, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: e */
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829438071")) {
            return (BaseViewHolder) ipChange.ipc$dispatch("-1829438071", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.item_theme_project_horizontal, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams != null) {
            if (getItemCount() > 1) {
                layoutParams.width = this.c;
            } else {
                layoutParams.width = this.d;
            }
        }
        return new PVh(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-794154748")) {
            return ((Integer) ipChange.ipc$dispatch("-794154748", new Object[]{this})).intValue();
        }
        List<ProjectItemBean> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
