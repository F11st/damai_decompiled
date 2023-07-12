package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import tb.C9826vr;
import tb.t60;
import tb.vv1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ProjectExtendInfoViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private RoundImageView c;
    private LinearLayout d;
    private Context e;
    private HtmlParserManager.C2244a f;
    private int g;
    private int h;
    private int i;
    private IRichTextManager j;
    private int k;
    private int l;
    private int m;
    private int n;
    private OnItemExtendInfoItemClickListener o;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectExtendInfoViewHolder$a */
    /* loaded from: classes8.dex */
    public class C2394a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C2394a(ProjectExtendInfoViewHolder projectExtendInfoViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1751653237")) {
                ipChange.ipc$dispatch("1751653237", new Object[]{this, c0501d});
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectExtendInfoViewHolder$b */
    /* loaded from: classes8.dex */
    public class C2395b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectExtendInfoViewHolder$b$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2396a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2396a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1921072431")) {
                    ipChange.ipc$dispatch("-1921072431", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.o != null) {
                    ProjectExtendInfoViewHolder.this.o.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.g, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        C2395b(ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "319818")) {
                ipChange.ipc$dispatch("319818", new Object[]{this, c0502e});
            } else if (c0502e != null && c0502e.a != null) {
                ProjectExtendInfoViewHolder.this.d.setVisibility(8);
                ProjectExtendInfoViewHolder.this.c.setVisibility(0);
                int intrinsicWidth = c0502e.a.getIntrinsicWidth();
                int intrinsicHeight = c0502e.a.getIntrinsicHeight();
                int a = (intrinsicWidth > ProjectExtendInfoViewHolder.this.n || intrinsicWidth == ProjectExtendInfoViewHolder.this.n) ? ProjectExtendInfoViewHolder.this.m : t60.a(ProjectExtendInfoViewHolder.this.e, intrinsicWidth);
                ProjectExtendInfoViewHolder.this.c.getLayoutParams().width = a;
                ProjectExtendInfoViewHolder.this.c.getLayoutParams().height = (int) (((intrinsicHeight * a) * 1.0f) / intrinsicWidth);
                ProjectExtendInfoViewHolder.this.c.setImageDrawable(c0502e.a);
                ProjectExtendInfoViewHolder.this.c.setOnClickListener(new View$OnClickListenerC2396a());
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectExtendInfoViewHolder$c */
    /* loaded from: classes8.dex */
    public class C2397c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C2397c(ProjectExtendInfoViewHolder projectExtendInfoViewHolder, ImageView imageView) {
            this.a = imageView;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-581739401")) {
                ipChange.ipc$dispatch("-581739401", new Object[]{this, c0501d});
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectExtendInfoViewHolder$d */
    /* loaded from: classes8.dex */
    public class C2398d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ DMImageStrategyConfig.DMImageCropType e;
        final /* synthetic */ int f;
        final /* synthetic */ boolean g;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.viewholder.ProjectExtendInfoViewHolder$d$a */
        /* loaded from: classes16.dex */
        public class View$OnClickListenerC2399a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC2399a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1529889363")) {
                    ipChange.ipc$dispatch("1529889363", new Object[]{this, view});
                } else if (ProjectExtendInfoViewHolder.this.o != null) {
                    ProjectExtendInfoViewHolder.this.o.onExtendInfoImageItemClick(view, ProjectExtendInfoViewHolder.this.g, ProjectExtendInfoViewHolder.this.f.d(), ProjectExtendInfoViewHolder.this.f.a().toString());
                }
            }
        }

        C2398d(ImageView imageView, int i, int i2, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i3, boolean z) {
            this.a = imageView;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = dMImageCropType;
            this.f = i3;
            this.g = z;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Drawable drawable;
            int i;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1215833908")) {
                ipChange.ipc$dispatch("-1215833908", new Object[]{this, c0502e});
            } else if (c0502e != null && (drawable = c0502e.a) != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = c0502e.a.getIntrinsicHeight();
                int i2 = this.b;
                if (intrinsicWidth <= i2 && intrinsicWidth != i2) {
                    i = t60.a(ProjectExtendInfoViewHolder.this.e, intrinsicWidth);
                } else {
                    i = this.c;
                }
                int i3 = (int) (((intrinsicHeight * i) * 1.0f) / intrinsicWidth);
                String d = SplitImageSizeCache.d(this.d, this.e, this.f);
                if (this.g) {
                    SplitImageSizeCache.ImageSizeCache c = SplitImageSizeCache.c(d);
                    if (c == null || c.imgWidth != i || c.imgHeight != i3) {
                        SplitImageSizeCache.a(d, new SplitImageSizeCache.ImageSizeCache(d, i, i3));
                        this.a.getLayoutParams().width = i;
                        this.a.getLayoutParams().height = i3;
                        this.a.requestLayout();
                    }
                } else {
                    SplitImageSizeCache.a(d, new SplitImageSizeCache.ImageSizeCache(d, i, i3));
                    this.a.getLayoutParams().width = i;
                    this.a.getLayoutParams().height = i3;
                    this.a.requestLayout();
                }
                this.a.setImageDrawable(c0502e.a);
                this.a.setOnClickListener(new View$OnClickListenerC2399a());
            } else {
                this.a.setImageResource(R$drawable.project_default_image_bg);
            }
        }
    }

    public ProjectExtendInfoViewHolder(Context context, ViewGroup viewGroup, OnItemExtendInfoItemClickListener onItemExtendInfoItemClickListener) {
        super(LayoutInflater.from(context).inflate(R$layout.project_item_detail_introduce_item_layout, viewGroup, false));
        this.e = context;
        this.o = onItemExtendInfoItemClickListener;
        int a = DisplayMetrics.getwidthPixels(context.getResources().getDisplayMetrics()) - (t60.a(this.e, 21.0f) * 2);
        this.m = a;
        this.n = t60.e(this.e, a);
        n();
    }

    private void i(HtmlParserManager.C2244a c2244a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1439931808")) {
            ipChange.ipc$dispatch("-1439931808", new Object[]{this, c2244a});
        } else if (c2244a != null) {
            q();
            this.b.setVisibility(8);
            boolean b = vv1.b(c2244a.c(), c2244a.b());
            boolean d = C0511b.d(c2244a.a().toString());
            if (b && d) {
                this.c.setVisibility(8);
                this.d.setVisibility(0);
                this.d.removeAllViews();
                int b2 = c2244a.b() / 500;
                if (c2244a.b() % 500 > 0) {
                    b2++;
                }
                for (int i = 0; i < b2; i++) {
                    RoundImageView roundImageView = new RoundImageView(this.e);
                    roundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    roundImageView.setType(1);
                    roundImageView.setBorderRadius(0);
                    String obj = c2244a.a().toString();
                    DMImageStrategyConfig.DMImageCropType dMImageCropType = DMImageStrategyConfig.DMImageCropType.cy500;
                    SplitImageSizeCache.ImageSizeCache c = SplitImageSizeCache.c(SplitImageSizeCache.d(obj, dMImageCropType, i));
                    if (c != null) {
                        roundImageView.setLayoutParams(new ViewGroup.LayoutParams(c.imgWidth, c.imgHeight));
                    }
                    this.d.addView(roundImageView);
                    p(roundImageView, c2244a.a().toString(), dMImageCropType, i, c != null);
                }
                return;
            }
            o(this.c, c2244a);
        }
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2004820848")) {
            ipChange.ipc$dispatch("-2004820848", new Object[]{this});
            return;
        }
        HtmlParserManager.C2244a c2244a = this.f;
        if (c2244a != null) {
            k(c2244a.e());
        }
    }

    private void k(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105584397")) {
            ipChange.ipc$dispatch("-2105584397", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 1) {
            l(this.f.a());
        } else if (i == 2) {
            i(this.f);
        } else {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
        }
    }

    private void l(Spanned spanned) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-528580727")) {
            ipChange.ipc$dispatch("-528580727", new Object[]{this, spanned});
            return;
        }
        q();
        this.b.setVisibility(0);
        if (this.k < this.l - 1) {
            this.b.setText(spanned);
        } else if (spanned != null && !TextUtils.isEmpty(spanned.toString().trim())) {
            this.b.setText(r(spanned.toString().trim().toCharArray()));
        }
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.f.j(this.b.getMeasuredHeight());
    }

    private void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2012448432")) {
            ipChange.ipc$dispatch("-2012448432", new Object[]{this});
            return;
        }
        this.a = this.itemView.findViewById(R$id.line);
        TextView textView = (TextView) this.itemView.findViewById(R$id.project_item_detail_intro_text_tv);
        this.b = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        RoundImageView roundImageView = (RoundImageView) this.itemView.findViewById(R$id.project_item_detail_intro_image_iv);
        this.c = roundImageView;
        roundImageView.setBorderRadius(0);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.rich_text_image_ll);
    }

    private void o(ImageView imageView, HtmlParserManager.C2244a c2244a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308755981")) {
            ipChange.ipc$dispatch("308755981", new Object[]{this, imageView, c2244a});
            return;
        }
        String obj = c2244a.a().toString();
        if (imageView == null) {
            return;
        }
        if (imageView.getTag() instanceof C9826vr) {
            ((C9826vr) imageView.getTag()).cancel();
        }
        DMImageStrategyConfig b = C0511b.b(obj, -1, -1);
        if (b != null) {
            b.b = false;
        }
        DMImageCreator h = C0504a.b().g(obj, b).h(null, this.m, 16383);
        int i = R$drawable.project_default_image_bg;
        imageView.setTag(h.i(i).c(i).n(new C2395b(imageView)).e(new C2394a(this, imageView)).f());
    }

    private void p(ImageView imageView, String str, DMImageStrategyConfig.DMImageCropType dMImageCropType, int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1446893842")) {
            ipChange.ipc$dispatch("-1446893842", new Object[]{this, imageView, str, dMImageCropType, Integer.valueOf(i), Boolean.valueOf(z)});
        } else if (imageView == null) {
        } else {
            if (imageView.getTag() instanceof C9826vr) {
                ((C9826vr) imageView.getTag()).cancel();
            }
            int a = DisplayMetrics.getwidthPixels(this.e.getResources().getDisplayMetrics()) - (t60.a(this.e, 21.0f) * 2);
            int e = t60.e(this.e, a);
            DMImageStrategyConfig b = C0511b.b(str, -1, -1);
            if (b != null) {
                b.b = false;
                b.c = true;
                b.d = dMImageCropType;
                b.e = i;
            }
            DMImageCreator g = C0504a.b().g(str, b);
            int i2 = R$drawable.project_default_image_bg;
            imageView.setTag(g.i(i2).c(i2).n(new C2398d(imageView, e, a, str, dMImageCropType, i, z)).e(new C2397c(this, imageView)).f());
        }
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537473527")) {
            ipChange.ipc$dispatch("-1537473527", new Object[]{this});
            return;
        }
        int i = this.i;
        if (i > 0) {
            if (i != 1 && this.h != 0) {
                this.a.setVisibility(8);
            } else {
                this.a.setVisibility(0);
            }
        }
    }

    public void m(ProjectDataHolder projectDataHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "478622698")) {
            ipChange.ipc$dispatch("478622698", new Object[]{this, projectDataHolder});
        } else if (projectDataHolder != null) {
            this.f = projectDataHolder.getConvertedItem();
            this.g = projectDataHolder.getRichType();
            this.h = projectDataHolder.getConvertedItemPosition();
            this.j = this.o.getRichTextManager(this.g);
            this.i = projectDataHolder.getConvertedItemSize();
            this.k = projectDataHolder.getConvertedItemPosition();
            this.l = projectDataHolder.getConvertedItemSize();
            j();
        }
    }

    public String r(char[] cArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185768533")) {
            return (String) ipChange.ipc$dispatch("185768533", new Object[]{this, cArr});
        }
        int length = cArr.length;
        while (length > 0 && cArr[length - 1] == '\n') {
            length--;
        }
        int length2 = cArr.length;
        String valueOf = String.valueOf(cArr);
        return length < length2 ? valueOf.substring(0, length) : valueOf;
    }
}
