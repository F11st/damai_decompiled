package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.dataholder.ProjectDataHolder;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.helper.IRichTextManager;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.listeners.OnItemExtendInfoItemClickListener;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.SplitImageSizeCache;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.C9826vr;
import tb.cb1;
import tb.pp2;
import tb.t60;
import tb.vv1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectRichShrinkViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private static int u;
    private Context a;
    private LinearLayout b;
    private LinearLayout c;
    private TextView d;
    private LinearLayout e;
    private LinearLayout f;
    private TextView g;
    private View h;
    private View.OnClickListener i;
    private List<HtmlParserManager.C2244a> j;
    private int k;
    private IRichTextManager l;
    private int m;
    private ViewTreeObserver.OnGlobalLayoutListener n;
    private ViewTreeObserver.OnGlobalLayoutListener o;
    private ViewTreeObserver.OnGlobalLayoutListener p;
    private String q;
    private OnItemExtendInfoItemClickListener r;
    private int s;
    private int t;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2403a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2403a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1535531936")) {
                ipChange.ipc$dispatch("-1535531936", new Object[]{this, view});
            } else if (ProjectRichShrinkViewHolder.this.r != null) {
                ProjectRichShrinkViewHolder.this.r.onExtendInfoMoreBtnClick(ProjectRichShrinkViewHolder.this.k);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$b */
    /* loaded from: classes16.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC2404b implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ViewTreeObserver$OnGlobalLayoutListenerC2404b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "845782852")) {
                ipChange.ipc$dispatch("845782852", new Object[]{this});
            } else {
                ProjectRichShrinkViewHolder.this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$c */
    /* loaded from: classes16.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC2405c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ViewTreeObserver$OnGlobalLayoutListenerC2405c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1057133765")) {
                ipChange.ipc$dispatch("1057133765", new Object[]{this});
            } else {
                ProjectRichShrinkViewHolder.this.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$d */
    /* loaded from: classes16.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC2406d implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        ViewTreeObserver$OnGlobalLayoutListenerC2406d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1268484678")) {
                ipChange.ipc$dispatch("1268484678", new Object[]{this});
            } else {
                ProjectRichShrinkViewHolder.this.e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$e */
    /* loaded from: classes8.dex */
    public class C2407e implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C2407e(ProjectRichShrinkViewHolder projectRichShrinkViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1925983338")) {
                ipChange.ipc$dispatch("-1925983338", new Object[]{this, c0501d});
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$f */
    /* loaded from: classes8.dex */
    public class C2408f implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ DMImageStrategyConfig.DMImageCropType e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;
        final /* synthetic */ String h;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$f$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2409a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2409a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1614028238")) {
                    ipChange.ipc$dispatch("-1614028238", new Object[]{this, view});
                } else if (ProjectRichShrinkViewHolder.this.r != null) {
                    OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener = ProjectRichShrinkViewHolder.this.r;
                    int i = ProjectRichShrinkViewHolder.this.k;
                    C2408f c2408f = C2408f.this;
                    onItemExtendInfoItemClickListener.onExtendInfoImageItemClick(view, i, c2408f.h, c2408f.d);
                }
            }
        }

        C2408f(ImageView imageView, int i, int i2, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i3, boolean z, String str2) {
            this.a = imageView;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = dMImageCropType;
            this.f = i3;
            this.g = z;
            this.h = str2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1825848491")) {
                ipChange.ipc$dispatch("1825848491", new Object[]{this, c0502e});
            } else if (c0502e != null && (drawable = c0502e.a) != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = c0502e.a.getIntrinsicHeight();
                int i2 = this.b;
                if (intrinsicWidth <= i2 && intrinsicWidth != i2) {
                    i = t60.a(ProjectRichShrinkViewHolder.this.a, intrinsicWidth);
                } else {
                    i = this.c;
                }
                int i3 = (int) (((intrinsicHeight * i) * 1.0f) / intrinsicWidth);
                String d = SplitImageSizeCache.d(this.d, this.e, this.f);
                if (this.g) {
                    SplitImageSizeCache.ImageSizeCache c = SplitImageSizeCache.c(d);
                    if (c == null || c.imgWidth != i || c.imgHeight != i3) {
                        SplitImageSizeCache.a(d, new SplitImageSizeCache.ImageSizeCache(d, i, i3));
                        ProjectRichShrinkViewHolder.this.y(this.a, i, i3);
                    }
                } else {
                    SplitImageSizeCache.a(d, new SplitImageSizeCache.ImageSizeCache(d, i, i3));
                    ProjectRichShrinkViewHolder.this.y(this.a, i, i3);
                }
                this.a.setImageDrawable(c0502e.a);
                this.a.setOnClickListener(new View$OnClickListenerC2409a());
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$g */
    /* loaded from: classes8.dex */
    public class C2410g implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C2410g(ProjectRichShrinkViewHolder projectRichShrinkViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "35591320")) {
                ipChange.ipc$dispatch("35591320", new Object[]{this, c0501d});
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$h */
    /* loaded from: classes8.dex */
    public class C2411h implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ boolean b;
        final /* synthetic */ LinearLayout c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectRichShrinkViewHolder$h$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2412a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2412a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1836933556")) {
                    ipChange.ipc$dispatch("1836933556", new Object[]{this, view});
                } else if (ProjectRichShrinkViewHolder.this.r != null) {
                    OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener = ProjectRichShrinkViewHolder.this.r;
                    int i = ProjectRichShrinkViewHolder.this.k;
                    C2411h c2411h = C2411h.this;
                    onItemExtendInfoItemClickListener.onExtendInfoImageItemClick(view, i, c2411h.e, c2411h.d);
                }
            }
        }

        C2411h(ImageView imageView, boolean z, LinearLayout linearLayout, String str, String str2) {
            this.a = imageView;
            this.b = z;
            this.c = linearLayout;
            this.d = str;
            this.e = str2;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "609694765")) {
                ipChange.ipc$dispatch("609694765", new Object[]{this, c0502e});
            } else if (c0502e != null && (drawable = c0502e.a) != null) {
                if (this.b) {
                    int intrinsicHeight = drawable.getIntrinsicHeight();
                    int i = intrinsicHeight / 500;
                    if (intrinsicHeight % 500 > 0) {
                        i++;
                    }
                    this.c.removeAllViews();
                    for (int i2 = 0; i2 < i; i2++) {
                        RoundImageView roundImageView = new RoundImageView(ProjectRichShrinkViewHolder.this.a);
                        roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        roundImageView.setType(1);
                        roundImageView.setBorderRadius(0);
                        roundImageView.setBackgroundResource(R$drawable.project_image_bg);
                        String str = this.d;
                        DMImageStrategyConfig.DMImageCropType dMImageCropType = DMImageStrategyConfig.DMImageCropType.cy500;
                        SplitImageSizeCache.ImageSizeCache c = SplitImageSizeCache.c(SplitImageSizeCache.d(str, dMImageCropType, i2));
                        if (c != null) {
                            roundImageView.setLayoutParams(new ViewGroup.LayoutParams(c.imgWidth, c.imgHeight));
                        }
                        this.c.addView(roundImageView);
                        ProjectRichShrinkViewHolder.this.w(this.d, roundImageView, this.e, dMImageCropType, i2, c != null);
                    }
                    return;
                }
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight2 = c0502e.a.getIntrinsicHeight();
                int a = (intrinsicWidth > ProjectRichShrinkViewHolder.this.t || intrinsicWidth == ProjectRichShrinkViewHolder.this.t) ? ProjectRichShrinkViewHolder.this.s : t60.a(ProjectRichShrinkViewHolder.this.a, intrinsicWidth);
                ProjectRichShrinkViewHolder.this.y(this.a, a, (int) (((intrinsicHeight2 * a) * 1.0f) / intrinsicWidth));
                this.a.setImageDrawable(c0502e.a);
                this.a.setOnClickListener(new View$OnClickListenerC2412a());
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    public ProjectRichShrinkViewHolder(Context context, ViewGroup viewGroup, OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_rich_text_item_layout, viewGroup, false));
        this.a = context;
        u = t60.a(context, 450.0f);
        int a = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (t60.a(this.a, 21.0f) * 2);
        this.s = a;
        this.t = t60.e(this.a, a);
        this.b = (LinearLayout) this.itemView.findViewById(R$id.rich_info_container_lv);
        this.r = onItemExtendInfoItemClickListener;
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R$id.rich_image_text_ll);
        this.c = linearLayout;
        linearLayout.setVisibility(8);
        TextView textView = (TextView) this.itemView.findViewById(R$id.rich_text_tv);
        this.d = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        LinearLayout linearLayout2 = (LinearLayout) this.itemView.findViewById(R$id.rich_text_image_ll);
        this.e = linearLayout2;
        linearLayout2.setVisibility(8);
        this.f = (LinearLayout) this.itemView.findViewById(R$id.rich_more_container_lv);
        this.g = (TextView) this.itemView.findViewById(R$id.project_item_more_text_tv);
        this.h = this.itemView.findViewById(R$id.line);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i = new View$OnClickListenerC2403a();
        x();
    }

    private void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-919930555")) {
            ipChange.ipc$dispatch("-919930555", new Object[]{this});
            return;
        }
        this.b.getLayoutParams().width = -1;
        this.b.getLayoutParams().height = -2;
        LinearLayout linearLayout = this.b;
        linearLayout.setLayoutParams(linearLayout.getLayoutParams());
    }

    private void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1014355133")) {
            ipChange.ipc$dispatch("1014355133", new Object[]{this});
            return;
        }
        this.g.setText("展开更多");
        this.g.setVisibility(0);
        this.h.setVisibility(0);
        this.f.setOnClickListener(this.i);
        IRichTextManager iRichTextManager = this.l;
        if (iRichTextManager != null) {
            iRichTextManager.setHasMore(true);
        }
        pp2.u().U1(this.f, this.q);
    }

    private void k(HtmlParserManager.C2244a c2244a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "467898564")) {
            ipChange.ipc$dispatch("467898564", new Object[]{this, c2244a});
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        u(c2244a, this.c);
    }

    private void l(HtmlParserManager.C2244a c2244a, HtmlParserManager.C2244a c2244a2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096566591")) {
            ipChange.ipc$dispatch("-1096566591", new Object[]{this, c2244a, c2244a2});
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        u(c2244a, this.c);
        u(c2244a2, this.e);
    }

    private void m(HtmlParserManager.C2244a c2244a, HtmlParserManager.C2244a c2244a2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1534026581")) {
            ipChange.ipc$dispatch("-1534026581", new Object[]{this, c2244a, c2244a2});
            return;
        }
        this.c.setVisibility(0);
        this.e.setVisibility(8);
        if (c2244a2 != null) {
            this.d.setText(c2244a2.a());
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        u(c2244a, this.c);
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "449458692")) {
            ipChange.ipc$dispatch("449458692", new Object[]{this});
        } else if (wh2.e(this.j) > 0) {
            int q = q();
            this.m = q;
            if (q == 1) {
                o(this.j.get(0));
            } else if (q == 2) {
                k(this.j.get(0));
            } else {
                HtmlParserManager.C2244a c2244a = this.j.get(0);
                HtmlParserManager.C2244a c2244a2 = this.j.get(1);
                int i = this.m;
                if (i == 3) {
                    p(c2244a, c2244a2);
                } else if (i == 4) {
                    m(c2244a, c2244a2);
                } else if (i == 5) {
                    l(c2244a, c2244a2);
                }
            }
        }
    }

    private void o(HtmlParserManager.C2244a c2244a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733251788")) {
            ipChange.ipc$dispatch("-1733251788", new Object[]{this, c2244a});
            return;
        }
        this.c.setVisibility(8);
        this.e.setVisibility(8);
        if (c2244a != null) {
            this.d.setText(c2244a.a());
            this.d.setVisibility(0);
        }
    }

    private void p(HtmlParserManager.C2244a c2244a, HtmlParserManager.C2244a c2244a2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "44859697")) {
            ipChange.ipc$dispatch("44859697", new Object[]{this, c2244a, c2244a2});
            return;
        }
        this.e.setVisibility(0);
        this.c.setVisibility(8);
        if (c2244a != null) {
            this.d.setText(c2244a.a());
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        u(c2244a2, this.e);
    }

    private int q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045219711")) {
            return ((Integer) ipChange.ipc$dispatch("-2045219711", new Object[]{this})).intValue();
        }
        int e = wh2.e(this.j);
        if (e > 0) {
            if (e == 1) {
                if (this.j.get(0) != null) {
                    return this.j.get(0).e();
                }
                return -1;
            } else if (e > 1) {
                HtmlParserManager.C2244a c2244a = this.j.get(0);
                HtmlParserManager.C2244a c2244a2 = this.j.get(1);
                if (c2244a == null || c2244a2 == null) {
                    return -1;
                }
                if (c2244a.e() == 1) {
                    return c2244a2.e() == 2 ? 3 : -1;
                } else if (c2244a.e() == 2) {
                    if (c2244a2.e() == 1) {
                        return 4;
                    }
                    return c2244a2.e() == 2 ? 5 : -1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }

    private boolean s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-935993003")) {
            return ((Boolean) ipChange.ipc$dispatch("-935993003", new Object[]{this})).booleanValue();
        }
        IRichTextManager iRichTextManager = this.l;
        if (iRichTextManager != null) {
            return iRichTextManager.hasMoreRichItems();
        }
        return false;
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2009539928")) {
            ipChange.ipc$dispatch("2009539928", new Object[]{this});
            return;
        }
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.f.setOnClickListener(null);
    }

    private void u(HtmlParserManager.C2244a c2244a, LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734553337")) {
            ipChange.ipc$dispatch("1734553337", new Object[]{this, c2244a, linearLayout});
        } else if (c2244a != null && c2244a.a() != null && linearLayout != null) {
            linearLayout.removeAllViews();
            boolean b = vv1.b(c2244a.c(), c2244a.b());
            boolean d = C0511b.d(c2244a.a().toString());
            if (b && d) {
                int b2 = c2244a.b() / 500;
                if (c2244a.b() % 500 > 0) {
                    b2++;
                }
                for (int i = 0; i < b2; i++) {
                    RoundImageView roundImageView = new RoundImageView(this.a);
                    roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    roundImageView.setType(1);
                    roundImageView.setBorderRadius(0);
                    roundImageView.setBackgroundResource(R$drawable.project_image_bg);
                    String obj = c2244a.a().toString();
                    DMImageStrategyConfig.DMImageCropType dMImageCropType = DMImageStrategyConfig.DMImageCropType.cy500;
                    SplitImageSizeCache.ImageSizeCache c = SplitImageSizeCache.c(SplitImageSizeCache.d(obj, dMImageCropType, i));
                    if (c != null) {
                        roundImageView.setLayoutParams(new ViewGroup.LayoutParams(c.imgWidth, c.imgHeight));
                    }
                    linearLayout.addView(roundImageView);
                    w(c2244a.a().toString(), roundImageView, c2244a.d(), dMImageCropType, i, c != null);
                }
                return;
            }
            cb1.c("RichShrink", "load loadSingleImage " + c2244a.a().toString());
            RoundImageView roundImageView2 = new RoundImageView(this.a);
            roundImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            roundImageView2.setType(1);
            roundImageView2.setBorderRadius(0);
            roundImageView2.setBackgroundResource(R$drawable.project_image_bg);
            linearLayout.addView(roundImageView2);
            v(c2244a, d, roundImageView2, linearLayout);
        }
    }

    private void v(HtmlParserManager.C2244a c2244a, boolean z, ImageView imageView, LinearLayout linearLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1188613009")) {
            ipChange.ipc$dispatch("-1188613009", new Object[]{this, c2244a, Boolean.valueOf(z), imageView, linearLayout});
            return;
        }
        String obj = c2244a.a().toString();
        String d = c2244a.d();
        if (imageView.getTag() instanceof C9826vr) {
            ((C9826vr) imageView.getTag()).cancel();
        }
        DMImageStrategyConfig b = C0511b.b(obj, -1, -1);
        if (b != null) {
            b.b = false;
        }
        DMImageCreator g = C0504a.b().g(obj, b);
        int i = R$drawable.project_default_image_bg;
        imageView.setTag(g.i(i).c(i).h(null, this.s, 16383).n(new C2411h(imageView, z, linearLayout, obj, d)).e(new C2410g(this, imageView)).f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, ImageView imageView, String str2, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2010742489")) {
            ipChange.ipc$dispatch("-2010742489", new Object[]{this, str, imageView, str2, dMImageCropType, Integer.valueOf(i), Boolean.valueOf(z)});
            return;
        }
        cb1.c("RichShrink", "hasCache " + z + " index=" + i + " url=" + str);
        if (imageView.getTag() instanceof C9826vr) {
            ((C9826vr) imageView.getTag()).cancel();
        }
        int a = DisplayMetrics.getwidthPixels(this.a.getResources().getDisplayMetrics()) - (t60.a(this.a, 21.0f) * 2);
        int e = t60.e(this.a, a);
        DMImageStrategyConfig b = C0511b.b(str, -1, -1);
        if (b != null) {
            b.b = false;
            b.c = true;
            b.d = dMImageCropType;
            b.e = i;
        }
        DMImageCreator g = C0504a.b().g(str, b);
        int i2 = R$drawable.project_default_image_bg;
        imageView.setTag(g.i(i2).c(i2).n(new C2408f(imageView, e, a, str, dMImageCropType, i, z, str2)).e(new C2407e(this, imageView)).f());
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-217936570")) {
            ipChange.ipc$dispatch("-217936570", new Object[]{this});
            return;
        }
        ViewTreeObserver viewTreeObserver = this.d.getViewTreeObserver();
        this.n = new ViewTreeObserver$OnGlobalLayoutListenerC2404b();
        ViewTreeObserver viewTreeObserver2 = this.c.getViewTreeObserver();
        this.o = new ViewTreeObserver$OnGlobalLayoutListenerC2405c();
        ViewTreeObserver viewTreeObserver3 = this.e.getViewTreeObserver();
        this.p = new ViewTreeObserver$OnGlobalLayoutListenerC2406d();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.n);
        }
        if (viewTreeObserver2.isAlive()) {
            viewTreeObserver2.addOnGlobalLayoutListener(this.o);
        }
        if (viewTreeObserver3.isAlive()) {
            viewTreeObserver3.addOnGlobalLayoutListener(this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ImageView imageView, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "739622483")) {
            ipChange.ipc$dispatch("739622483", new Object[]{this, imageView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        imageView.getLayoutParams().width = i;
        imageView.getLayoutParams().height = i2;
        imageView.setLayoutParams(imageView.getLayoutParams());
    }

    private void z() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684808870")) {
            ipChange.ipc$dispatch("-684808870", new Object[]{this});
            return;
        }
        this.b.getLayoutParams().width = -1;
        this.b.getLayoutParams().height = u;
        LinearLayout linearLayout = this.b;
        linearLayout.setLayoutParams(linearLayout.getLayoutParams());
    }

    public void r(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1299260409")) {
            ipChange.ipc$dispatch("-1299260409", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.q = projectDataHolder.getProjectId();
            this.j = projectDataHolder.getShrinkConvertedItem();
            int shrinkRichType = projectDataHolder.getShrinkRichType();
            this.k = shrinkRichType;
            IRichTextManager richTextManager = this.r.getRichTextManager(shrinkRichType);
            this.l = richTextManager;
            if ((richTextManager == null || !richTextManager.overLimitedHeight()) ? false : false) {
                z();
                B();
            } else if (s()) {
                A();
                B();
            } else {
                A();
                t();
            }
            n();
        }
    }
}
