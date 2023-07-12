package cn.damai.category.category.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.utils.BannerImageLoader;
import cn.damai.commonbusiness.search.TimerView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.banner.Banner;
import cn.damai.uikit.banner.listener.OnBannerListener;
import cn.damai.uikit.banner.transformer.DefaultTransformer;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.ScoreStarDigitView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class VideoStarHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DMPosterView b;
    private Banner c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TimerView g;
    private BannerImageLoader h;
    private ScoreStarDigitView i;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.viewholder.VideoStarHolder$a */
    /* loaded from: classes.dex */
    public class C0366a implements OnBannerListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0366a() {
        }

        @Override // cn.damai.uikit.banner.listener.OnBannerListener
        public void OnBannerClick(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "344443763")) {
                ipChange.ipc$dispatch("344443763", new Object[]{this, Integer.valueOf(i)});
            } else {
                VideoStarHolder.this.itemView.performClick();
            }
        }
    }

    public VideoStarHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.category_starvideo_item, (ViewGroup) null));
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.a = this.itemView.getContext();
        this.b = (DMPosterView) this.itemView.findViewById(R$id.poster);
        this.c = (Banner) this.itemView.findViewById(R$id.banner_video);
        this.d = (TextView) this.itemView.findViewById(R$id.tv_name);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_time);
        this.f = (TextView) this.itemView.findViewById(R$id.tv_address);
        this.g = (TimerView) this.itemView.findViewById(R$id.ll_timer);
        this.i = (ScoreStarDigitView) this.itemView.findViewById(cn.damai.commonbusiness.R$id.layout_score);
        a();
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576190250")) {
            ipChange.ipc$dispatch("-576190250", new Object[]{this});
            return;
        }
        this.c.setBannerStyle(1);
        BannerImageLoader bannerImageLoader = new BannerImageLoader();
        this.h = bannerImageLoader;
        this.c.setImageLoader(bannerImageLoader);
        this.c.setImages(new ArrayList());
        this.c.setPageTransformer(true, new DefaultTransformer());
        this.c.setOffscreenPageLimit(5);
        this.c.setImageClipChildren(false);
        this.c.setPageMargin(t60.a(this.a, 0.0f));
        this.c.setViewPagerLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.c.isAutoPlay(false);
        this.c.setIndicatorGravity(5);
        this.c.setOnBannerListener(new C0366a());
        this.c.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(cn.damai.category.category.bean.StarAndBrandItem r12, cn.damai.commonbusiness.search.Daojishi r13) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.category.category.ui.viewholder.VideoStarHolder.b(cn.damai.category.category.bean.StarAndBrandItem, cn.damai.commonbusiness.search.Daojishi):void");
    }
}
