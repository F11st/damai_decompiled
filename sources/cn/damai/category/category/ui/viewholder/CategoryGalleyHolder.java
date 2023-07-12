package cn.damai.category.category.ui.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.category.category.bean.CategoryBannerBean;
import cn.damai.category.category.bean.GalleyTag;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.df;
import tb.m62;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
    /* renamed from: cn.damai.category.category.ui.viewholder.CategoryGalleyHolder$a */
    /* loaded from: classes.dex */
    public class C0363a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0363a(CategoryGalleyHolder categoryGalleyHolder) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1690376509")) {
                ipChange.ipc$dispatch("-1690376509", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.viewholder.CategoryGalleyHolder$b */
    /* loaded from: classes.dex */
    public class C0364b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CategoryBannerBean a;

        C0364b(df dfVar, CategoryBannerBean categoryBannerBean) {
            this.a = categoryBannerBean;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-377652712")) {
                ipChange.ipc$dispatch("-377652712", new Object[]{this, c0502e});
            } else if (c0502e != null && c0502e.b != null) {
                throw null;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.category.category.ui.viewholder.CategoryGalleyHolder$c */
    /* loaded from: classes.dex */
    public class View$OnClickListenerC0365c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ CategoryBannerBean b;
        final /* synthetic */ View.OnClickListener c;

        View$OnClickListenerC0365c(CategoryGalleyHolder categoryGalleyHolder, int i, CategoryBannerBean categoryBannerBean, View.OnClickListener onClickListener) {
            this.a = i;
            this.b = categoryBannerBean;
            this.c = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1138641645")) {
                ipChange.ipc$dispatch("-1138641645", new Object[]{this, view});
                return;
            }
            GalleyTag galleyTag = new GalleyTag();
            galleyTag.index = this.a;
            CategoryBannerBean categoryBannerBean = this.b;
            galleyTag.type = categoryBannerBean.type;
            galleyTag.rankId = categoryBannerBean.rankId;
            galleyTag.url = categoryBannerBean.url;
            view.setTag(galleyTag);
            this.c.onClick(view);
        }
    }

    public CategoryGalleyHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.category_galley_item, (ViewGroup) null));
        this.h = layoutInflater.getContext();
        this.a = this.itemView.findViewById(R$id.layout_left);
        this.b = this.itemView.findViewById(R$id.layout_right);
        this.c = (ImageView) this.itemView.findViewById(R$id.image_item);
        this.d = (RCRelativeLayoutView) this.itemView.findViewById(R$id.image_item_bg);
        this.e = (DMPosterView) this.itemView.findViewById(R$id.poster_rank);
        this.f = (TextView) this.itemView.findViewById(R$id.tv_desc1);
        this.g = (TextView) this.itemView.findViewById(R$id.tv_desc2);
    }

    public void a(int i, View.OnClickListener onClickListener, CategoryBannerBean categoryBannerBean, df dfVar, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064262582")) {
            ipChange.ipc$dispatch("-2064262582", new Object[]{this, Integer.valueOf(i), onClickListener, categoryBannerBean, dfVar, Boolean.valueOf(z), Boolean.valueOf(z2)});
        } else if (categoryBannerBean == null) {
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
            int i2 = categoryBannerBean.type;
            if (i2 == 3) {
                this.c.setMaxHeight(ScreenUtil.dip2px(this.h, 144.0f));
                C0504a.b().e(categoryBannerBean.pic).c(R$drawable.uikit_default_image_bg_grey).g(this.c);
            } else {
                if (i2 == 4) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(0);
                    this.e.setImageUrl(categoryBannerBean.pic);
                    this.e.setLabelType(DMLabelType.LABEL_TYPE_RANK_TOP_ONE);
                    this.e.getLabelView().setLabelWidth(m62.a(this.h, 21.0f));
                    this.e.getLabelView().setLabelHeight(m62.a(this.h, 21.0f));
                    this.e.getLabelView().setLabelName("1");
                    this.c.setImageResource(R$drawable.category_galley_rank_bg);
                    C0504a.b().e(categoryBannerBean.pic).n(new C0364b(dfVar, categoryBannerBean)).e(new C0363a(this)).f();
                } else {
                    C0504a.b().e(categoryBannerBean.pic).c(R$drawable.uikit_default_image_bg_grey).g(this.c);
                }
                this.c.setMaxHeight(ScreenUtil.dip2px(this.h, 86.0f));
                this.f.setText(categoryBannerBean.artistName);
                this.g.setText(categoryBannerBean.title);
            }
            this.itemView.setOnClickListener(new View$OnClickListenerC0365c(this, i, categoryBannerBean, onClickListener));
        }
    }
}
