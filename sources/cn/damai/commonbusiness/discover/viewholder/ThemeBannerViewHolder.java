package cn.damai.commonbusiness.discover.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.discover.bean.ThemeBannerBean;
import cn.damai.commonbusiness.discover.bean.ThemeBannerWrapBean;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import cn.damai.uikit.banner.sub.BannerItem;
import cn.damai.uikit.banner.sub.XBanner;
import cn.damai.uikit.banner.sub.XIndicator;
import cn.damai.uikit.tag.DMCategroyTagView;
import com.alibaba.pictures.bricks.view.DMCategroyTagView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ThemeBannerViewHolder extends BaseViewHolderV2<ThemeBannerWrapBean> implements XBanner.OnBannerClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private final XBanner c;
    private OnItemBindListener<ThemeBannerBean> d;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.discover.viewholder.ThemeBannerViewHolder$a */
    /* loaded from: classes4.dex */
    public class C0649a implements XBanner.BannerItemViewCreator {
        private static transient /* synthetic */ IpChange $ipChange;

        C0649a() {
        }

        @Override // cn.damai.uikit.banner.sub.XBanner.BannerItemViewCreator
        public void bindItemView(BannerItem bannerItem, View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-918939599")) {
                ipChange.ipc$dispatch("-918939599", new Object[]{this, bannerItem, view, Integer.valueOf(i)});
            } else if (bannerItem instanceof ThemeBannerBean) {
                ThemeBannerBean themeBannerBean = (ThemeBannerBean) bannerItem;
                ThemeBannerViewHolder.this.d.exposeItem(view, themeBannerBean, i);
                ThemeBannerViewHolder.this.f(themeBannerBean, view);
            }
        }

        @Override // cn.damai.uikit.banner.sub.XBanner.BannerItemViewCreator
        public View inflateItemView(Context context, ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1636985747") ? (View) ipChange.ipc$dispatch("-1636985747", new Object[]{this, context, viewGroup}) : LayoutInflater.from(context).inflate(R$layout.item_discover_theme_banner_item, viewGroup, false);
        }
    }

    public ThemeBannerViewHolder(View view, OnItemBindListener<ThemeBannerBean> onItemBindListener) {
        super(view);
        this.d = onItemBindListener;
        XBanner xBanner = (XBanner) view.findViewById(R$id.theme_banner);
        this.c = xBanner;
        xBanner.setViewCreator(new C0649a());
        xBanner.setBannerClickListener(this);
        xBanner.setListener((XIndicator) view.findViewById(R$id.theme_indicator));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ThemeBannerBean themeBannerBean, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1521891022")) {
            ipChange.ipc$dispatch("-1521891022", new Object[]{this, themeBannerBean, view});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.t_banner_join_count);
        DMCategroyTagView dMCategroyTagView = (DMCategroyTagView) view.findViewById(R$id.t_banner_tag);
        View findViewById = view.findViewById(R$id.t_banner_title_prefix);
        C0504a.b().f(themeBannerBean.bannerPicUrl(), DisplayMetrics.getwidthPixels(l62.b(mu0.a())) - (l62.a(mu0.a(), 21.0f) * 2), l62.a(mu0.a(), 84.0f)).i(R$drawable.img_corners_4_gradient_placeholder).g((ImageView) view.findViewById(R$id.t_banner_img));
        ((TextView) view.findViewById(R$id.t_banner_title)).setText(themeBannerBean.getTitle());
        findViewById.setVisibility(themeBannerBean.isOldTheme() ? 0 : 8);
        textView.setText(themeBannerBean.getSubTitle());
        String tagText = themeBannerBean.getTagText();
        if (TextUtils.isEmpty(tagText)) {
            dMCategroyTagView.setVisibility(8);
            return;
        }
        dMCategroyTagView.setVisibility(0);
        dMCategroyTagView.setTagName(tagText);
        dMCategroyTagView.setTagType(DMCategroyTagView.DMCategroyTagType.TAG_TYPE_PREFERENTIAL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.discover.viewholder.BaseViewHolderV2
    /* renamed from: g */
    public void c(ThemeBannerWrapBean themeBannerWrapBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1370953043")) {
            ipChange.ipc$dispatch("1370953043", new Object[]{this, themeBannerWrapBean, Integer.valueOf(i)});
        } else if (themeBannerWrapBean == null) {
        } else {
            this.c.update(themeBannerWrapBean.card);
        }
    }

    @Override // cn.damai.uikit.banner.sub.XBanner.OnBannerClickListener
    public void onBannerClick(BannerItem bannerItem, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-654232430")) {
            ipChange.ipc$dispatch("-654232430", new Object[]{this, bannerItem, Integer.valueOf(i)});
        } else if (bannerItem instanceof ThemeBannerBean) {
            this.d.onItemClick((ThemeBannerBean) bannerItem, i);
        }
    }
}
