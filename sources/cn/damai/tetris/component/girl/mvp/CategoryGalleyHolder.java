package cn.damai.tetris.component.girl.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.girl.bean.BannerBean;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.utils.RGBUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CategoryGalleyHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private View b;
    private ImageView c;
    private RCRelativeLayoutView d;
    private DMPosterView e;
    private TextView f;
    private TextView g;
    private Context h;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Map a;
        final /* synthetic */ BannerBean b;

        a(Map map, BannerBean bannerBean) {
            this.a = map;
            this.b = bannerBean;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1976352789")) {
                ipChange.ipc$dispatch("-1976352789", new Object[]{this, bVar});
            } else if (bVar == null || bVar.b == null) {
            } else {
                Integer num = (Integer) this.a.get(this.b.pic);
                if (num == null || num.intValue() == 0) {
                    num = Integer.valueOf(RGBUtil.e(bVar.b));
                    this.a.put(this.b.pic, num);
                }
                CategoryGalleyHolder.this.d.setBackgroundColor(num.intValue());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(CategoryGalleyHolder categoryGalleyHolder) {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1398606996")) {
                ipChange.ipc$dispatch("1398606996", new Object[]{this, aVar});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BannerPresenter a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        c(CategoryGalleyHolder categoryGalleyHolder, BannerPresenter bannerPresenter, int i, String str) {
            this.a = bannerPresenter;
            this.b = i;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1987649443")) {
                ipChange.ipc$dispatch("1987649443", new Object[]{this, view});
                return;
            }
            BannerBean bannerBean = (BannerBean) view.getTag();
            BannerPresenter bannerPresenter = this.a;
            if (bannerPresenter != null) {
                bannerPresenter.itemClick(bannerBean, this.b, this.c);
            }
        }
    }

    public CategoryGalleyHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.subgroup_banner_item, (ViewGroup) null));
        this.h = layoutInflater.getContext();
        this.a = this.itemView.findViewById(R$id.layout_left);
        this.b = this.itemView.findViewById(R$id.layout_right);
        this.c = (ImageView) this.itemView.findViewById(R$id.image_item);
        this.d = (RCRelativeLayoutView) this.itemView.findViewById(R$id.image_item_bg);
        this.e = (DMPosterView) this.itemView.findViewById(R$id.poster_rank);
        this.f = (TextView) this.itemView.findViewById(R$id.tv_desc1);
        this.g = (TextView) this.itemView.findViewById(R$id.tv_desc2);
    }

    public void b(BannerPresenter bannerPresenter, int i, String str, BannerBean bannerBean, boolean z, boolean z2, Map<String, Integer> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-611549161")) {
            ipChange.ipc$dispatch("-611549161", new Object[]{this, bannerPresenter, Integer.valueOf(i), str, bannerBean, Boolean.valueOf(z), Boolean.valueOf(z2), map});
        } else if (bannerBean == null) {
        } else {
            if (z) {
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            if (z2) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            int i2 = bannerBean.type;
            if (i2 == 3) {
                this.c.setMaxHeight(yr2.a(this.h, 144.0f));
                IImageLoader a2 = cn.damai.uikit.image.a.a();
                String str2 = bannerBean.pic;
                ImageView imageView = this.c;
                int i3 = R$drawable.uikit_default_image_bg_grey;
                a2.loadinto(str2, imageView, i3, i3);
            } else {
                if (i2 == 4) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(0);
                    this.e.setImageUrl(bannerBean.pic);
                    this.e.setLabelType(DMLabelType.LABEL_TYPE_RANK_TOP_ONE);
                    this.e.getLabelView().setLabelWidth(yr2.a(this.h, 21.0f));
                    this.e.getLabelView().setLabelHeight(yr2.a(this.h, 21.0f));
                    this.e.getLabelView().setLabelName("1");
                    this.c.setImageResource(R$drawable.category_galley_rank_bg);
                    cn.damai.uikit.image.a.a().load(bannerBean.pic, -1, new a(map, bannerBean), new b(this));
                } else {
                    IImageLoader a3 = cn.damai.uikit.image.a.a();
                    String str3 = bannerBean.pic;
                    ImageView imageView2 = this.c;
                    int i4 = R$drawable.uikit_default_image_bg_grey;
                    a3.loadinto(str3, imageView2, i4, i4);
                }
                this.c.setMaxHeight(yr2.a(this.h, 86.0f));
                this.f.setText(bannerBean.title);
                this.g.setText(bannerBean.subTitle);
            }
            this.itemView.setTag(bannerBean);
            this.itemView.setOnClickListener(new c(this, bannerPresenter, i, str));
        }
    }
}
