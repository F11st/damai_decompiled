package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.BrandAndArtists;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.uikit.view.DMLRLabelView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pp2;
import tb.tv1;
import tb.yq;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectArtistSingleViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ImageView b;
    private TextView c;
    private DMLRLabelView d;
    private TextView e;
    private String f;
    private String g;
    View.OnClickListener h;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectArtistSingleViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2384a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2384a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2011918602")) {
                ipChange.ipc$dispatch("2011918602", new Object[]{this, view});
                return;
            }
            BrandAndArtists brandAndArtists = (BrandAndArtists) view.getTag();
            if (brandAndArtists == null) {
                return;
            }
            int i = brandAndArtists.type;
            if (i == 1) {
                tv1.j(ProjectArtistSingleViewHolder.this.a, brandAndArtists, ProjectArtistSingleViewHolder.this.f, 0, ProjectArtistSingleViewHolder.this.g);
            } else if (i == 2) {
                tv1.k(ProjectArtistSingleViewHolder.this.a, brandAndArtists, ProjectArtistSingleViewHolder.this.f, 0, ProjectArtistSingleViewHolder.this.g);
            }
        }
    }

    public ProjectArtistSingleViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_artist_brand_single_layout, viewGroup, false));
        this.h = new View$OnClickListenerC2384a();
        this.a = context;
        e();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1765535424")) {
            ipChange.ipc$dispatch("1765535424", new Object[]{this});
            return;
        }
        this.b = (ImageView) this.itemView.findViewById(R$id.artist_image);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_artist_name);
        this.d = (DMLRLabelView) this.itemView.findViewById(R$id.tv_tag);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_artist_desc);
        this.itemView.setOnClickListener(this.h);
    }

    private void f(View view, int i, BrandAndArtists brandAndArtists) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225458434")) {
            ipChange.ipc$dispatch("-225458434", new Object[]{this, view, Integer.valueOf(i), brandAndArtists});
            return;
        }
        pp2 u = pp2.u();
        String valueOf = String.valueOf(this.f);
        u.r2(view, valueOf, brandAndArtists.type + "", String.valueOf(brandAndArtists.id), i, this.g);
    }

    public void d(ProjectDataHolder projectDataHolder) {
        BrandAndArtists brandAndArtists;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-227628623")) {
            ipChange.ipc$dispatch("-227628623", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder == null || (brandAndArtists = projectDataHolder.brandOrArtists) == null) {
        } else {
            this.itemView.setTag(brandAndArtists);
            this.g = projectDataHolder.getTheaterValue();
            this.f = projectDataHolder.getProjectId();
            DMImageCreator c = C0504a.b().h(this.a).c(brandAndArtists.picUrl);
            int i = R$drawable.uikit_user_default_icon;
            c.i(i).c(i).k(new yq()).g(this.b);
            if (!TextUtils.isEmpty(brandAndArtists.name)) {
                this.c.setText(brandAndArtists.name);
            } else {
                this.c.setText("");
            }
            this.d.setContent("V", brandAndArtists.tag);
            if (brandAndArtists.type == 1) {
                this.d.setColor(1);
            } else {
                this.d.setColor(2);
            }
            if (!TextUtils.isEmpty(brandAndArtists.label)) {
                this.e.setVisibility(0);
                this.e.setText(brandAndArtists.label);
            } else if (!TextUtils.isEmpty(brandAndArtists.desc)) {
                this.e.setText(brandAndArtists.desc);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            f(this.itemView, 0, brandAndArtists);
        }
    }
}
