package cn.damai.category.category.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.category.bean.BrandBean;
import cn.damai.category.category.bean.BrandStatusBean;
import cn.damai.category.category.bean.StarAndBrandItem;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.kd;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class HorizontalBrandAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private StarAndBrandItem b;
    private List<BrandBean> c = new ArrayList();
    private View.OnClickListener d;
    private View.OnClickListener e;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private View a;
        private View b;
        private DMPosterView c;
        private TextView d;
        private TextView e;
        private View f;
        private TextView g;
        private TextView h;
        private TextView i;

        public ViewHolder() {
            super(LayoutInflater.from(HorizontalBrandAdapter.this.a).inflate(R$layout.category_brand_galley_item, (ViewGroup) null));
            this.a = this.itemView.findViewById(R$id.layout_left);
            this.b = this.itemView.findViewById(R$id.layout_right);
            this.c = (DMPosterView) this.itemView.findViewById(R$id.poster);
            this.d = (TextView) this.itemView.findViewById(R$id.tv_title);
            this.e = (TextView) this.itemView.findViewById(R$id.tv_see_people_num);
            this.f = this.itemView.findViewById(R$id.layout_price);
            this.g = (TextView) this.itemView.findViewById(R$id.tv_price_tag);
            this.h = (TextView) this.itemView.findViewById(R$id.tv_price);
            this.i = (TextView) this.itemView.findViewById(R$id.tv_qi);
        }

        public void a(BrandBean brandBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1542758198")) {
                ipChange.ipc$dispatch("-1542758198", new Object[]{this, brandBean, Integer.valueOf(i)});
            } else if (brandBean == null) {
            } else {
                if (brandBean.position == 0) {
                    this.a.setVisibility(0);
                } else {
                    this.a.setVisibility(8);
                }
                if (i < 6 && brandBean.position == i - 1) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                this.c.setImageUrl(brandBean.verticalPic);
                this.c.setVideoIconVisibility(brandBean.isVideoSupport ? 0 : 8);
                this.c.setCategoryTagName(brandBean.getCategoryNameCompat());
                BrandStatusBean brandStatusBean = brandBean.showStatus;
                if (brandStatusBean != null && brandStatusBean.id == 2) {
                    this.c.setLabelType(DMLabelType.LABEL_TYPE_SOLD_OUT);
                } else {
                    this.c.setLabelType(null);
                }
                this.c.setScoreStar(brandBean.itemScore, true);
                this.d.setText(brandBean.name);
                if (!TextUtils.isEmpty(brandBean.showTag)) {
                    this.e.setVisibility(0);
                    this.e.setText(brandBean.showTag);
                } else {
                    this.e.setVisibility(4);
                }
                if (!TextUtils.isEmpty(brandBean.priceLow)) {
                    if (brandBean.priceLow.contains("待定")) {
                        this.h.setTextSize(1, 12.0f);
                        this.g.setVisibility(8);
                        this.i.setVisibility(8);
                        this.h.setText("价格待定");
                    } else {
                        this.h.setTextSize(1, 16.0f);
                        this.g.setVisibility(0);
                        this.i.setVisibility(0);
                        this.h.setText(brandBean.priceLow);
                    }
                } else {
                    this.h.setTextSize(1, 12.0f);
                    this.g.setVisibility(8);
                    this.i.setVisibility(8);
                    this.h.setText("价格待定");
                }
                this.itemView.setOnClickListener(HorizontalBrandAdapter.this.d);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    class a extends RecyclerView.ViewHolder {

        /* compiled from: Taobao */
        /* renamed from: cn.damai.category.category.ui.adapter.HorizontalBrandAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0020a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC0020a(HorizontalBrandAdapter horizontalBrandAdapter) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-151735165")) {
                    ipChange.ipc$dispatch("-151735165", new Object[]{this, view});
                } else {
                    HorizontalBrandAdapter.this.e.onClick(view);
                }
            }
        }

        public a() {
            super(LayoutInflater.from(HorizontalBrandAdapter.this.a).inflate(R$layout.category_brand_galley_item_all, (ViewGroup) null));
            this.itemView.setOnClickListener(new View$OnClickListenerC0020a(HorizontalBrandAdapter.this));
        }
    }

    public HorizontalBrandAdapter(Context context, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.a = context;
        this.d = onClickListener;
        this.e = onClickListener2;
    }

    public void d(StarAndBrandItem starAndBrandItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "499747187")) {
            ipChange.ipc$dispatch("499747187", new Object[]{this, starAndBrandItem});
        } else if (starAndBrandItem == null || wh2.e(starAndBrandItem.brandList) <= 0) {
        } else {
            this.c = starAndBrandItem.brandList;
            this.b = starAndBrandItem;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271293806")) {
            return ((Integer) ipChange.ipc$dispatch("1271293806", new Object[]{this})).intValue();
        }
        List<BrandBean> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-328860907") ? ((Integer) ipChange.ipc$dispatch("-328860907", new Object[]{this, Integer.valueOf(i)})).intValue() : this.c.get(i).viewType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618348747")) {
            ipChange.ipc$dispatch("618348747", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            BrandBean brandBean = this.c.get(i);
            brandBean.position = i;
            int i2 = brandBean.viewType;
            if (i2 != 8) {
                if (i2 != 9) {
                    return;
                }
                ((a) viewHolder).itemView.setTag(this.b);
                return;
            }
            ((ViewHolder) viewHolder).a(brandBean, this.c.size());
            brandBean.cardIndex = this.b.index;
            viewHolder.itemView.setTag(brandBean);
            kd.j(viewHolder.itemView, brandBean.cardIndex, brandBean.position, z20.E(), brandBean.id);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-723016309")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-723016309", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 8) {
            if (i != 9) {
                return null;
            }
            return new a();
        }
        return new ViewHolder();
    }
}
