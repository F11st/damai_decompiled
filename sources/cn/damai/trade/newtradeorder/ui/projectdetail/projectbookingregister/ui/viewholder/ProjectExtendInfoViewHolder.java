package cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.C0511b;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.HtmlParserManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.listeners.OnExtendInfoImageItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import tb.C9826vr;
import tb.t60;
import tb.vv1;
import tb.yv1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectExtendInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FrameLayout b;
    private TextView c;
    private RoundImageView d;
    private LinearLayout e;
    private HtmlParserManager.C2244a f;
    private int g;
    private int h;
    private yv1 i;
    private OnExtendInfoImageItemClickListener j;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectExtendInfoViewHolder$a */
    /* loaded from: classes8.dex */
    public class C2268a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2268a(ProjectExtendInfoViewHolder projectExtendInfoViewHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1592845539")) {
                ipChange.ipc$dispatch("-1592845539", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectExtendInfoViewHolder$b */
    /* loaded from: classes8.dex */
    public class C2269b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectExtendInfoViewHolder$b$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2270a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2270a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1836188793")) {
                    ipChange.ipc$dispatch("1836188793", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.j != null) {
                    ProjectExtendInfoViewHolder.this.j.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        C2269b(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1337490702")) {
                ipChange.ipc$dispatch("-1337490702", new Object[]{this, c0502e});
            } else if (c0502e == null || (drawable = c0502e.a) == null) {
            } else {
                ProjectExtendInfoViewHolder.this.l(this.a, (int) (c0502e.a.getIntrinsicHeight() * ((this.a * 1.0f) / drawable.getIntrinsicWidth())));
                try {
                    AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) c0502e.a;
                    animatedImageDrawable.start();
                    this.b.setImageDrawable(animatedImageDrawable);
                } catch (Exception unused) {
                    this.b.setImageDrawable(c0502e.a);
                }
                this.b.setOnClickListener(new View$OnClickListenerC2270a());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectExtendInfoViewHolder$c */
    /* loaded from: classes8.dex */
    public class C2271c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2271c(ProjectExtendInfoViewHolder projectExtendInfoViewHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "368729119")) {
                ipChange.ipc$dispatch("368729119", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectExtendInfoViewHolder$d */
    /* loaded from: classes8.dex */
    public class C2272d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ ImageView b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectbookingregister.ui.viewholder.ProjectExtendInfoViewHolder$d$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2273a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2273a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "992183291")) {
                    ipChange.ipc$dispatch("992183291", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.j != null) {
                    ProjectExtendInfoViewHolder.this.j.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        C2272d(int i, ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1741322868")) {
                ipChange.ipc$dispatch("1741322868", new Object[]{this, c0502e});
            } else if (c0502e == null || (drawable = c0502e.a) == null) {
            } else {
                float intrinsicWidth = (this.a * 1.0f) / drawable.getIntrinsicWidth();
                this.b.getLayoutParams().width = this.a;
                this.b.getLayoutParams().height = (int) (c0502e.a.getIntrinsicHeight() * intrinsicWidth);
                try {
                    AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) c0502e.a;
                    animatedImageDrawable.start();
                    this.b.setImageDrawable(animatedImageDrawable);
                } catch (Exception unused) {
                    this.b.setImageDrawable(c0502e.a);
                }
                this.b.setOnClickListener(new View$OnClickListenerC2273a());
            }
        }
    }

    public ProjectExtendInfoViewHolder(Context context, ViewGroup viewGroup, OnExtendInfoImageItemClickListener onExtendInfoImageItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_detail_introduce_item_layout, viewGroup, false));
        this.a = context;
        this.j = onExtendInfoImageItemClickListener;
        TextView textView = (TextView) this.itemView.findViewById(R$id.project_item_detail_intro_text_tv);
        this.c = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        RoundImageView roundImageView = (RoundImageView) this.itemView.findViewById(R$id.project_item_detail_intro_image_iv);
        this.d = roundImageView;
        roundImageView.setBorderRadius(0);
        this.e = (LinearLayout) this.itemView.findViewById(R$id.rich_text_image_ll);
        this.b = (FrameLayout) this.itemView;
    }

    private void d(HtmlParserManager.C2244a c2244a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "309451704")) {
            ipChange.ipc$dispatch("309451704", new Object[]{this, c2244a});
            return;
        }
        m();
        this.c.setVisibility(8);
        if (!vv1.b(c2244a.c(), c2244a.b())) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
            i(this.d, c2244a.a().toString());
            return;
        }
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.e.removeAllViews();
        int b = c2244a.b() / 500;
        if (c2244a.b() % 500 > 0) {
            b++;
        }
        for (int i = 0; i < b; i++) {
            RoundImageView roundImageView = new RoundImageView(this.a);
            roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            roundImageView.setType(1);
            roundImageView.setBorderRadius(0);
            this.e.setBackgroundResource(R$drawable.project_image_bg);
            this.e.addView(roundImageView);
            j(roundImageView, c2244a.a().toString(), DMImageStrategyConfig.DMImageCropType.cy500, i);
        }
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030113816")) {
            ipChange.ipc$dispatch("-2030113816", new Object[]{this});
            return;
        }
        HtmlParserManager.C2244a c2244a = this.f;
        if (c2244a != null) {
            f(c2244a.e());
        }
    }

    private void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186886731")) {
            ipChange.ipc$dispatch("186886731", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            g(this.f.a());
        } else if (i == 2) {
            d(this.f);
        } else {
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    private void g(Spanned spanned) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1948897073")) {
            ipChange.ipc$dispatch("1948897073", new Object[]{this, spanned});
            return;
        }
        this.c.setVisibility(0);
        this.c.setText(spanned);
        this.d.setVisibility(8);
        this.f.j(this.c.getMeasuredHeight());
        m();
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
    }

    private void i(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615429172")) {
            ipChange.ipc$dispatch("-615429172", new Object[]{this, imageView, str});
        } else if (imageView == null) {
        } else {
            if (imageView.getTag() instanceof C9826vr) {
                ((C9826vr) imageView.getTag()).cancel();
            }
            int a = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (t60.a(this.a, 21.0f) * 2);
            DMImageStrategyConfig b = C0511b.b(str, -1, -1);
            if (b != null) {
                b.b = false;
            }
            DMImageCreator g = C0504a.b().g(str, b);
            int i = R$drawable.project_default_image_bg;
            imageView.setTag(g.i(i).c(i).n(new C2269b(a, imageView)).e(new C2268a(this)).f());
        }
    }

    private void j(ImageView imageView, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1307128048")) {
            ipChange.ipc$dispatch("1307128048", new Object[]{this, imageView, str, dMImageCropType, Integer.valueOf(i)});
        } else if (imageView == null) {
        } else {
            if (imageView.getTag() instanceof C9826vr) {
                ((C9826vr) imageView.getTag()).cancel();
            }
            int a = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (t60.a(this.a, 21.0f) * 2);
            DMImageStrategyConfig b = C0511b.b(str, -1, -1);
            if (b != null) {
                b.b = false;
                b.c = true;
                b.d = dMImageCropType;
                b.e = i;
            }
            DMImageCreator g = C0504a.b().g(str, b);
            int i2 = R$drawable.project_default_image_bg;
            imageView.setTag(g.i(i2).c(i2).n(new C2272d(a, imageView)).e(new C2271c(this)).f());
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1039253312")) {
            ipChange.ipc$dispatch("1039253312", new Object[]{this});
            return;
        }
        int e = this.f.e();
        int h = this.i.h(this.g);
        if (e == 2) {
            if (h == 2) {
                FrameLayout frameLayout = this.b;
                frameLayout.setPadding(frameLayout.getPaddingLeft(), t60.a(this.a, 18.0f), this.b.getPaddingRight(), 0);
                return;
            }
            FrameLayout frameLayout2 = this.b;
            frameLayout2.setPadding(frameLayout2.getPaddingLeft(), t60.a(this.a, 8.0f), this.b.getPaddingRight(), 0);
        } else if (e == 1) {
            if (h == 2) {
                FrameLayout frameLayout3 = this.b;
                frameLayout3.setPadding(frameLayout3.getPaddingLeft(), t60.a(this.a, 18.0f), this.b.getPaddingRight(), 0);
                return;
            }
            FrameLayout frameLayout4 = this.b;
            frameLayout4.setPadding(frameLayout4.getPaddingLeft(), 0, this.b.getPaddingRight(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558945746")) {
            ipChange.ipc$dispatch("-558945746", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.d.getLayoutParams().width = i;
        this.d.getLayoutParams().height = i2;
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "873960881")) {
            ipChange.ipc$dispatch("873960881", new Object[]{this});
            return;
        }
        int i = this.h;
        int a = t60.a(this.a, 21.0f);
        if (i > 0) {
            if (i == 1) {
                FrameLayout frameLayout = this.b;
                frameLayout.setPadding(frameLayout.getPaddingLeft(), 0, this.b.getPaddingRight(), a);
                return;
            }
            int i2 = this.g;
            if (i2 == i - 1) {
                k();
                FrameLayout frameLayout2 = this.b;
                frameLayout2.setPadding(frameLayout2.getPaddingLeft(), this.b.getPaddingTop(), this.b.getPaddingRight(), t60.a(this.a, 36.0f));
            } else if (i2 == 0) {
                FrameLayout frameLayout3 = this.b;
                frameLayout3.setPadding(frameLayout3.getPaddingLeft(), 0, this.b.getPaddingRight(), 0);
            } else {
                k();
            }
        }
    }

    public void h(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-203340910")) {
            ipChange.ipc$dispatch("-203340910", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.f = projectDataHolder.getConvertedItem();
            this.g = projectDataHolder.getConvertedItemPosition();
            this.i = this.j.getProjectExtendInfoManager();
            this.h = projectDataHolder.getConvertedItemSize();
            e();
        }
    }
}
