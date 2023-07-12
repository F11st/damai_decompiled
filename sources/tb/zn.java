package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.discover.content.bean.ContentDetail;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class zn extends cp2<ContentDetail> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView d;
    private TextView e;
    private View f;
    private TextView g;
    private RoundImageView h;
    private TextView i;
    private TextView j;
    private View k;
    private int l;
    private float m;
    private int n;
    private float o;
    private int p;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1696460249")) {
                ipChange.ipc$dispatch("1696460249", new Object[]{this, dVar});
            } else {
                zn.this.d.setImageResource(R$drawable.uikit_default_image_bg_grey);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1736726702")) {
                ipChange.ipc$dispatch("1736726702", new Object[]{this, eVar});
                return;
            }
            Bitmap bitmap = eVar.b;
            if (bitmap != null) {
                int f = zn.this.f((bitmap.getWidth() * 1.0f) / bitmap.getHeight());
                ViewGroup.LayoutParams layoutParams = zn.this.d.getLayoutParams();
                layoutParams.height = f;
                zn.this.d.setLayoutParams(layoutParams);
                zn.this.d.setImageDrawable(eVar.a);
                return;
            }
            Drawable drawable = eVar.a;
            if (drawable != null) {
                int f2 = zn.this.f((drawable.getIntrinsicWidth() * 1.0f) / drawable.getIntrinsicHeight());
                ViewGroup.LayoutParams layoutParams2 = zn.this.d.getLayoutParams();
                layoutParams2.height = f2;
                zn.this.d.setLayoutParams(layoutParams2);
                zn.this.d.setImageDrawable(drawable);
            }
        }
    }

    public zn(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-317195345")) {
            return ((Integer) ipChange.ipc$dispatch("-317195345", new Object[]{this, Float.valueOf(f)})).intValue();
        }
        if (f >= this.m) {
            return this.n;
        }
        if (f <= this.o) {
            return this.p;
        }
        return (int) (this.l / f);
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1832156537") ? ((Integer) ipChange.ipc$dispatch("1832156537", new Object[]{this})).intValue() : R$layout.live_content_detail_title;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-665655354")) {
            ipChange.ipc$dispatch("-665655354", new Object[]{this});
            return;
        }
        this.d = (ImageView) this.b.findViewById(R$id.live_content_detail_cover);
        this.e = (TextView) this.b.findViewById(R$id.live_content_detail_title);
        this.f = this.b.findViewById(R$id.live_content_detail_from_container);
        this.g = (TextView) this.b.findViewById(R$id.live_content_detail_from_source);
        this.h = (RoundImageView) this.b.findViewById(R$id.live_content_detail_from_avatar);
        this.i = (TextView) this.b.findViewById(R$id.live_content_detail_from_nickname);
        this.k = this.b.findViewById(R$id.live_content_detail_tour_tip_layout);
        this.j = (TextView) this.b.findViewById(R$id.live_content_detail_tour_tip);
        this.h.setBorder(1, Color.parseColor("#1A000000"));
        int i = DisplayMetrics.getwidthPixels(m62.b(this.a));
        this.l = i;
        this.m = 1.7777778f;
        this.n = (int) (i / 1.7777778f);
        this.o = 0.75f;
        this.p = (int) (i / 0.75f);
    }

    public void g(ContentDetail contentDetail) {
        boolean z;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771386145")) {
            ipChange.ipc$dispatch("-1771386145", new Object[]{this, contentDetail});
        } else if (contentDetail == null) {
            c(false);
        } else {
            ContentDetail.CoverImage coverImage = contentDetail.coverImg;
            if (coverImage != null && !wh2.j(coverImage.url)) {
                ContentDetail.CoverImage coverImage2 = contentDetail.coverImg;
                int i2 = coverImage2.width;
                if (i2 > 0 && (i = coverImage2.height) > 0) {
                    int f = f((i2 * 1.0f) / i);
                    ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                    layoutParams.height = f;
                    this.d.setLayoutParams(layoutParams);
                    cn.damai.common.image.a.b().c(coverImage2.url).g(this.d);
                } else {
                    cn.damai.common.image.a.b().c(coverImage2.url).n(new b()).e(new a()).f();
                }
            }
            if (TextUtils.isEmpty(contentDetail.relateTitle)) {
                this.k.setVisibility(8);
                z = false;
            } else {
                this.k.setVisibility(0);
                this.j.setText(contentDetail.relateTitle);
                z = true;
            }
            if (!wh2.j(contentDetail.title)) {
                this.e.setText(contentDetail.title);
                this.e.setVisibility(0);
                if (!z) {
                    ViewGroup.LayoutParams layoutParams2 = this.e.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = m62.a(mu0.a(), 15.0f);
                    }
                }
            } else {
                this.e.setVisibility(8);
            }
            ContentDetail.FromInfo fromInfo = contentDetail.fromInfo;
            if (fromInfo != null && !wh2.j(fromInfo.sourceLabel)) {
                ContentDetail.FromInfo fromInfo2 = contentDetail.fromInfo;
                this.g.setText(fromInfo2.sourceLabel);
                if (!wh2.j(fromInfo2.nickname)) {
                    this.i.setText(fromInfo2.nickname);
                    this.i.setVisibility(0);
                } else {
                    this.i.setVisibility(8);
                }
                if (!wh2.j(fromInfo2.headImg)) {
                    cn.damai.common.image.a.b().c(fromInfo2.headImg).g(this.h);
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                }
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            c(true);
        }
    }
}
