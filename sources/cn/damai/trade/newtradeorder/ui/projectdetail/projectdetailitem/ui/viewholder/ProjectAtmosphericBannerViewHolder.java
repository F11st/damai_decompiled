package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.m62;
import tb.pp2;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectAtmosphericBannerViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private ImageView b;
    private int c;
    private String d;
    private String e;
    private String f;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-151307650")) {
                ipChange.ipc$dispatch("-151307650", new Object[]{this, view});
            } else if (TextUtils.isEmpty(ProjectAtmosphericBannerViewHolder.this.e)) {
            } else {
                cn.damai.common.user.c.e().x(pp2.u().h0(ProjectAtmosphericBannerViewHolder.this.f));
                DMNav.from(ProjectAtmosphericBannerViewHolder.this.a).toUri(ProjectAtmosphericBannerViewHolder.this.e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2081705777")) {
                ipChange.ipc$dispatch("2081705777", new Object[]{this, dVar});
            } else {
                ProjectAtmosphericBannerViewHolder.this.b.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1502763014")) {
                ipChange.ipc$dispatch("1502763014", new Object[]{this, eVar});
            } else if (eVar == null || (drawable = eVar.a) == null) {
            } else {
                ProjectAtmosphericBannerViewHolder.this.k(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                ProjectAtmosphericBannerViewHolder.this.b.setImageDrawable(drawable);
                ProjectAtmosphericBannerViewHolder.this.b.setVisibility(0);
            }
        }
    }

    public ProjectAtmosphericBannerViewHolder(Context context, ViewGroup viewGroup) {
        super(LayoutInflater.from(context).inflate(R$layout.project_atmospheric_banner_layout, viewGroup, false));
        this.a = context;
        this.c = DisplayMetrics.getwidthPixels(t60.b(context)) - m62.a(context, 42.0f);
        h();
        g();
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "208874334")) {
            ipChange.ipc$dispatch("208874334", new Object[]{this});
            return;
        }
        int i = this.c;
        j(i, (i * 15) / 59);
        this.b.setImageResource(R$drawable.uikit_default_image_bg_grey);
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652906123")) {
            ipChange.ipc$dispatch("652906123", new Object[]{this});
            return;
        }
        ImageView imageView = (ImageView) this.itemView.findViewById(R$id.project_atmospheric_banner_iv);
        this.b = imageView;
        imageView.setOnClickListener(new a());
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762174221")) {
            ipChange.ipc$dispatch("1762174221", new Object[]{this});
        } else if (TextUtils.isEmpty(this.d)) {
        } else {
            cn.damai.common.image.a.b().c(this.d).k(new DMRoundedCornersBitmapProcessor(6, 0)).n(new c()).e(new b()).f();
        }
    }

    private void j(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171057092")) {
            ipChange.ipc$dispatch("-1171057092", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.b.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590781309")) {
            ipChange.ipc$dispatch("590781309", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int i3 = this.c;
        j(i3, (i2 * i3) / i);
    }

    public void f(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639482587")) {
            ipChange.ipc$dispatch("-639482587", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.f = projectDataHolder.getProjectId();
            this.d = projectDataHolder.getBannerPicUrl();
            this.e = projectDataHolder.getBannerRedirectUrl();
            i();
            pp2.u().P1(this.b, this.f);
        }
    }
}
