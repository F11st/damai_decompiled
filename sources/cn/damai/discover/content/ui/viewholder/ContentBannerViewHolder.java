package cn.damai.discover.content.ui.viewholder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.commonbusiness.view.DmViewPager;
import cn.damai.discover.content.bean.ContentDetail;
import cn.damai.discover.content.ui.ContentDetailActivity;
import cn.damai.discover.content.ui.viewholder.item.ContentVideoHelper;
import cn.damai.discover.content.ui.viewholder.item.ContentVideoView;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.tetris.component.discover.bean.VideoInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.cp2;
import tb.m62;
import tb.px2;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ContentBannerViewHolder extends cp2<ArrayList<ContentDetail.ContentBanner>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<PicInfo> d;
    private VideoInfo e;
    private DmViewPager f;
    private TextView g;
    private int[] h;
    private int i;
    private float j;
    private int k;
    private float l;
    private int m;
    private int n;
    private ContentVideoHelper o;
    public String p;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1500487327")) {
                ipChange.ipc$dispatch("1500487327", new Object[]{this, dVar});
                return;
            }
            float f = (ContentBannerViewHolder.this.i * 1.0f) / ContentBannerViewHolder.this.n;
            if (ContentBannerViewHolder.this.e != null) {
                f = ContentBannerViewHolder.this.j;
            }
            cb1.b("ContentBannerViewHolder", "Set ratio default:" + f);
            ContentBannerViewHolder.this.t(f, this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArrayList a;

        b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            float intrinsicWidth;
            int intrinsicHeight;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1306778868")) {
                ipChange.ipc$dispatch("1306778868", new Object[]{this, eVar});
                return;
            }
            float f = (ContentBannerViewHolder.this.i * 1.0f) / ContentBannerViewHolder.this.n;
            Bitmap bitmap = eVar.b;
            if (bitmap != null) {
                intrinsicWidth = bitmap.getWidth() * 1.0f;
                intrinsicHeight = eVar.b.getHeight();
            } else {
                Drawable drawable = eVar.a;
                if (drawable != null) {
                    intrinsicWidth = drawable.getIntrinsicWidth() * 1.0f;
                    intrinsicHeight = eVar.a.getIntrinsicHeight();
                }
                cb1.b("ContentBannerViewHolder", "Got ratio from  first banner:" + f);
                ContentBannerViewHolder.this.t(f, this.a);
            }
            f = intrinsicWidth / intrinsicHeight;
            cb1.b("ContentBannerViewHolder", "Got ratio from  first banner:" + f);
            ContentBannerViewHolder.this.t(f, this.a);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;

        c(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-651751926")) {
                ipChange.ipc$dispatch("-651751926", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(ContentBannerViewHolder.this.getLiveUt().q(ContentBannerViewHolder.this.p, this.a));
            if (ContentBannerViewHolder.this.e != null && !TextUtils.isEmpty(ContentBannerViewHolder.this.e.url) && !TextUtils.isEmpty(ContentBannerViewHolder.this.e.coverUrl)) {
                ContentBannerViewHolder contentBannerViewHolder = ContentBannerViewHolder.this;
                px2.a(contentBannerViewHolder.a, "", contentBannerViewHolder.e.coverUrl, ContentBannerViewHolder.this.e.url, ContentBannerViewHolder.this.e.sourceLabel, ContentBannerViewHolder.this.d, this.a);
                return;
            }
            ContentBannerViewHolder contentBannerViewHolder2 = ContentBannerViewHolder.this;
            px2.a(contentBannerViewHolder2.a, "", null, null, null, contentBannerViewHolder2.d, this.a);
        }
    }

    public ContentBannerViewHolder(Context context) {
        super(context);
        this.d = new ArrayList<>();
        int i = DisplayMetrics.getwidthPixels(m62.b(context));
        this.i = i;
        this.j = 1.7777778f;
        this.k = (int) (i / 1.7777778f);
        this.l = 0.75f;
        this.m = (int) (i / 0.75f);
        this.n = t60.a(context, 200.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321025781")) {
            return ((Integer) ipChange.ipc$dispatch("321025781", new Object[]{this, Float.valueOf(f)})).intValue();
        }
        if (f >= this.j) {
            return this.k;
        }
        if (f <= this.l) {
            return this.m;
        }
        return (int) (this.i / f);
    }

    private ArrayList<PicInfo> r(List<ContentDetail.ContentBanner> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "916316919")) {
            return (ArrayList) ipChange.ipc$dispatch("916316919", new Object[]{this, list});
        }
        ArrayList<PicInfo> arrayList = new ArrayList<>();
        int e = wh2.e(list);
        for (int i = 0; i < e; i++) {
            ContentDetail.ContentBanner contentBanner = list.get(i);
            if (contentBanner != null) {
                PicInfo picInfo = new PicInfo();
                picInfo.setPicUrl(contentBanner.url);
                arrayList.add(picInfo);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(float f, final List<ContentDetail.ContentBanner> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1194245444")) {
            ipChange.ipc$dispatch("1194245444", new Object[]{this, Float.valueOf(f), list});
            return;
        }
        final int e = wh2.e(list);
        this.h = new int[e];
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        this.h[0] = q(f);
        layoutParams.height = this.h[0];
        this.f.setLayoutParams(layoutParams);
        TextView textView = this.g;
        textView.setText("1/" + e);
        this.f.setAdapter(new PagerAdapter() { // from class: cn.damai.discover.content.ui.viewholder.ContentBannerViewHolder.3
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.discover.content.ui.viewholder.ContentBannerViewHolder$3$a */
            /* loaded from: classes5.dex */
            public class a implements DMImageCreator.DMImageFailListener {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ ImageView a;
                final /* synthetic */ int b;

                a(ImageView imageView, int i) {
                    this.a = imageView;
                    this.b = i;
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.d dVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-592432786")) {
                        ipChange.ipc$dispatch("-592432786", new Object[]{this, dVar});
                        return;
                    }
                    this.a.setImageResource(R$drawable.uikit_default_image_bg_grey);
                    ContentBannerViewHolder.this.h[this.b] = ContentBannerViewHolder.this.n;
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.discover.content.ui.viewholder.ContentBannerViewHolder$3$b */
            /* loaded from: classes5.dex */
            public class b implements DMImageCreator.DMImageSuccListener {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ int a;
                final /* synthetic */ ImageView b;

                b(int i, ImageView imageView) {
                    this.a = i;
                    this.b = imageView;
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.e eVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1964562563")) {
                        ipChange.ipc$dispatch("1964562563", new Object[]{this, eVar});
                        return;
                    }
                    Bitmap bitmap = eVar.b;
                    if (bitmap != null) {
                        ContentBannerViewHolder.this.h[this.a] = ContentBannerViewHolder.this.q((bitmap.getWidth() * 1.0f) / bitmap.getHeight());
                        this.b.setImageBitmap(bitmap);
                        return;
                    }
                    Drawable drawable = eVar.a;
                    if (drawable != null) {
                        ContentBannerViewHolder.this.h[this.a] = ContentBannerViewHolder.this.q((drawable.getIntrinsicWidth() * 1.0f) / drawable.getIntrinsicHeight());
                        this.b.setImageDrawable(drawable);
                    }
                }
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2137378913")) {
                    ipChange2.ipc$dispatch("2137378913", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                } else {
                    viewGroup.removeView((View) obj);
                }
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "759954232") ? ((Integer) ipChange2.ipc$dispatch("759954232", new Object[]{this})).intValue() : e;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getItemPosition(Object obj) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-166999607")) {
                    return ((Integer) ipChange2.ipc$dispatch("-166999607", new Object[]{this, obj})).intValue();
                }
                if (getCount() > 0) {
                    return -2;
                }
                return super.getItemPosition(obj);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public Object instantiateItem(ViewGroup viewGroup, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1716677021")) {
                    return ipChange2.ipc$dispatch("1716677021", new Object[]{this, viewGroup, Integer.valueOf(i)});
                }
                ContentDetail.ContentBanner contentBanner = (ContentDetail.ContentBanner) list.get(i);
                if (contentBanner == null) {
                    return null;
                }
                if (contentBanner.videoInfo != null && i == 0) {
                    if (ContentBannerViewHolder.this.o != null) {
                        ContentBannerViewHolder.this.o.n(false);
                    } else {
                        ContentBannerViewHolder.this.o = new ContentVideoHelper(new ContentVideoView(ContentBannerViewHolder.this.a));
                        ContentBannerViewHolder.this.o.n(true);
                    }
                    ContentVideoView g = ContentBannerViewHolder.this.o.g();
                    g.setPlayerSize(-1, ContentBannerViewHolder.this.h[0]);
                    g.setDataSource(ContentBannerViewHolder.this.x(contentBanner.videoInfo));
                    g.setupPlayer();
                    if (g.getParent() != null && (g.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) g.getParent()).removeView(g);
                    }
                    g.setPlayerClickListener(new c(i));
                    viewGroup.addView(g);
                    return g;
                }
                ImageView imageView = new ImageView(ContentBannerViewHolder.this.a);
                imageView.setImageResource(R$drawable.uikit_default_image_bg_grey);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setOnClickListener(new c(i));
                cn.damai.common.image.a.b().c(((ContentDetail.ContentBanner) list.get(i)).url).n(new b(i, imageView)).e(new a(imageView, i)).f();
                viewGroup.addView(imageView);
                return imageView;
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public boolean isViewFromObject(View view, Object obj) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-55599476") ? ((Boolean) ipChange2.ipc$dispatch("-55599476", new Object[]{this, view, obj})).booleanValue() : view == obj;
            }
        });
        this.f.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: cn.damai.discover.content.ui.viewholder.ContentBannerViewHolder.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "605356642")) {
                    ipChange2.ipc$dispatch("605356642", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f2, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-904064767")) {
                    ipChange2.ipc$dispatch("-904064767", new Object[]{this, Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)});
                } else if (i == ContentBannerViewHolder.this.h.length - 1) {
                } else {
                    float f3 = (ContentBannerViewHolder.this.h[i] == 0 ? ContentBannerViewHolder.this.n : ContentBannerViewHolder.this.h[i]) * (1.0f - f2);
                    int i3 = i + 1;
                    int i4 = ContentBannerViewHolder.this.h[i3] == 0 ? ContentBannerViewHolder.this.n : ContentBannerViewHolder.this.h[i3];
                    ViewGroup.LayoutParams layoutParams2 = ContentBannerViewHolder.this.f.getLayoutParams();
                    layoutParams2.height = (int) (f3 + (i4 * f2));
                    ContentBannerViewHolder.this.f.setLayoutParams(layoutParams2);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2092952531")) {
                    ipChange2.ipc$dispatch("-2092952531", new Object[]{this, Integer.valueOf(i)});
                    return;
                }
                TextView textView2 = ContentBannerViewHolder.this.g;
                textView2.setText((i + 1) + "/" + e);
                if (ContentBannerViewHolder.this.e != null) {
                    if (i == 0) {
                        if (ContentBannerViewHolder.this.o != null) {
                            ContentBannerViewHolder.this.o.m();
                        }
                    } else if (i != 1 || ContentBannerViewHolder.this.o == null) {
                    } else {
                        ContentBannerViewHolder.this.o.k();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cn.damai.commonbusiness.imagebrowse.bean.VideoInfo x(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-826387325")) {
            return (cn.damai.commonbusiness.imagebrowse.bean.VideoInfo) ipChange.ipc$dispatch("-826387325", new Object[]{this, videoInfo});
        }
        if (videoInfo == null) {
            return null;
        }
        cn.damai.commonbusiness.imagebrowse.bean.VideoInfo videoInfo2 = new cn.damai.commonbusiness.imagebrowse.bean.VideoInfo();
        videoInfo2.setPicUrl(videoInfo.coverUrl);
        videoInfo2.setVideoUrl(videoInfo.url);
        videoInfo2.setType(VideoInfo.VideoType.VIDEO_URL);
        return videoInfo2;
    }

    @Override // tb.cp2
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "142174963") ? ((Integer) ipChange.ipc$dispatch("142174963", new Object[]{this})).intValue() : R$layout.live_content_detail_banner;
    }

    @Override // tb.cp2
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-53632448")) {
            ipChange.ipc$dispatch("-53632448", new Object[]{this});
            return;
        }
        DmViewPager dmViewPager = (DmViewPager) this.b.findViewById(R$id.content_detail_banner);
        this.f = dmViewPager;
        dmViewPager.setOffscreenPageLimit(1);
        this.g = (TextView) this.b.findViewById(R$id.content_detail_banner_count);
        ImageView imageView = (ImageView) this.b.findViewById(R$id.discover_video_icon);
    }

    public void s(ArrayList<ContentDetail.ContentBanner> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-445575928")) {
            ipChange.ipc$dispatch("-445575928", new Object[]{this, arrayList});
            return;
        }
        this.d.clear();
        this.d.addAll(r(arrayList));
        if (this.e != null) {
            ContentDetail.ContentBanner contentBanner = new ContentDetail.ContentBanner();
            cn.damai.tetris.component.discover.bean.VideoInfo videoInfo = this.e;
            contentBanner.url = videoInfo.coverUrl;
            contentBanner.isPlayIcon = true;
            contentBanner.videoInfo = videoInfo;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(0, contentBanner);
        }
        if (wh2.e(arrayList) <= 0) {
            c(false);
            return;
        }
        c(true);
        Intent intent = ((ContentDetailActivity) this.a).getIntent();
        cn.damai.tetris.component.discover.bean.VideoInfo videoInfo2 = this.e;
        float f = -1.0f;
        if (videoInfo2 != null) {
            if (!TextUtils.isEmpty(videoInfo2.width) && Float.valueOf(this.e.width).floatValue() > 0.0f && !TextUtils.isEmpty(this.e.height) && Float.valueOf(this.e.height).floatValue() > 0.0f) {
                cb1.b("ContentBannerViewHolder", "Video width:" + this.e.width + " height:" + this.e.height);
                f = Float.valueOf(this.e.width).floatValue() / Float.valueOf(this.e.height).floatValue();
            }
        } else if (intent != null) {
            f = intent.getFloatExtra("picWhRatio", -1.0f);
            cb1.b("ContentBannerViewHolder", "Passed pic ratio:" + f);
        }
        if (f > 0.0f) {
            cb1.b("ContentBannerViewHolder", "Got ratio from Intent or VideoInfo:" + f);
            t(f, arrayList);
            return;
        }
        cn.damai.common.image.a.b().c(arrayList.get(0).url).n(new b(arrayList)).e(new a(arrayList)).f();
    }

    public void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1430962641")) {
            ipChange.ipc$dispatch("-1430962641", new Object[]{this});
            return;
        }
        ContentVideoHelper contentVideoHelper = this.o;
        if (contentVideoHelper != null) {
            contentVideoHelper.h();
        }
    }

    public void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "895210419")) {
            ipChange.ipc$dispatch("895210419", new Object[]{this});
            return;
        }
        ContentVideoHelper contentVideoHelper = this.o;
        if (contentVideoHelper != null) {
            contentVideoHelper.i();
        }
    }

    public void w() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-665461580")) {
            ipChange.ipc$dispatch("-665461580", new Object[]{this});
            return;
        }
        ContentVideoHelper contentVideoHelper = this.o;
        if (contentVideoHelper != null) {
            if (this.e != null && this.f.getCurrentItem() == 0) {
                z = true;
            }
            contentVideoHelper.j(z);
        }
    }

    public void y(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "456695751")) {
            ipChange.ipc$dispatch("456695751", new Object[]{this, str});
        } else {
            this.p = str;
        }
    }

    public void z(cn.damai.tetris.component.discover.bean.VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199696662")) {
            ipChange.ipc$dispatch("1199696662", new Object[]{this, videoInfo});
        } else {
            this.e = videoInfo;
        }
    }
}
