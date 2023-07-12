package cn.damai.tetris.component.star.officalMall;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.a;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.star.bean.ItemModuleBean;
import cn.damai.tetris.component.star.bean.ModuleTitleModel;
import cn.damai.tetris.component.star.officalMall.ProductShopDelegate;
import cn.damai.tetris.core.BasePresenter;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.fh1;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProductShopDelegate {
    private static transient /* synthetic */ IpChange $ipChange;
    ItemModuleBean a;
    BasePresenter b;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;
        private View d;
        private ImageView e;

        public ProductViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R$id.product_tag);
            this.b = (TextView) view.findViewById(R$id.product_name);
            this.c = (TextView) view.findViewById(R$id.product_price);
            this.d = view.findViewById(R$id.image_layout_juebuchongfu);
            int a = (DisplayMetrics.getwidthPixels(view.getContext().getResources().getDisplayMetrics()) - (t60.a(view.getContext(), 34.0f) * 2)) / 3;
            this.d.getLayoutParams().width = a;
            this.d.getLayoutParams().height = a;
            this.e = (ImageView) view.findViewById(R$id.image_project);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(ItemModuleBean.GoodBean goodBean, int i, HashMap hashMap, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1207222499")) {
                ipChange.ipc$dispatch("1207222499", new Object[]{this, goodBean, Integer.valueOf(i), hashMap, view});
                return;
            }
            DMNav.from(this.itemView.getContext()).toUri(goodBean.goodUrl);
            BasePresenter basePresenter = ProductShopDelegate.this.b;
            basePresenter.userTrackClick("item_" + i, hashMap, true);
        }

        public void c(final ItemModuleBean.GoodBean goodBean, final int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1439443701")) {
                ipChange.ipc$dispatch("-1439443701", new Object[]{this, goodBean, Integer.valueOf(i)});
            } else if (goodBean == null) {
                this.itemView.setOnClickListener(null);
            } else {
                final HashMap hashMap = new HashMap();
                hashMap.put("item_id", goodBean.goodUrl);
                if (ProductShopDelegate.this.b.getSection().getTrackInfo().getArgsMap() != null) {
                    hashMap.putAll(ProductShopDelegate.this.b.getSection().getTrackInfo().getArgsMap());
                }
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tb.ev1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProductShopDelegate.ProductViewHolder.this.b(goodBean, i, hashMap, view);
                    }
                });
                if (!TextUtils.isEmpty(goodBean.pic)) {
                    a.b().loadinto(goodBean.pic, this.e);
                } else {
                    this.e.setImageResource(R$drawable.uikit_default_image_bg_grey);
                }
                this.b.setText(goodBean.goodName);
                this.c.setText(goodBean.price);
                this.a.setText(goodBean.desc);
                BasePresenter basePresenter = ProductShopDelegate.this.b;
                View view = this.itemView;
                basePresenter.userTrackExpose(view, "item_" + i, hashMap, true);
            }
        }
    }

    public ProductShopDelegate(ItemModuleBean itemModuleBean, BasePresenter basePresenter) {
        this.a = itemModuleBean;
        this.b = basePresenter;
    }

    public void a(@NonNull ViewGroup viewGroup, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895486323")) {
            ipChange.ipc$dispatch("-1895486323", new Object[]{this, viewGroup, activity});
            return;
        }
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R$id.offical_goods_list);
        recyclerView.setLayoutManager(new GridLayoutManager(viewGroup.getContext(), 3));
        int a = t60.a(viewGroup.getContext(), 12.0f);
        GridSpacingItemDecoration gridSpacingItemDecoration = new GridSpacingItemDecoration(3, a, a, false);
        if (recyclerView.getItemDecorationCount() > 0) {
            recyclerView.removeItemDecorationAt(0);
        }
        recyclerView.addItemDecoration(gridSpacingItemDecoration);
        recyclerView.setAdapter(new RecyclerView.Adapter<ProductViewHolder>() { // from class: cn.damai.tetris.component.star.officalMall.ProductShopDelegate.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            /* renamed from: a */
            public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "851118523")) {
                    ipChange2.ipc$dispatch("851118523", new Object[]{this, productViewHolder, Integer.valueOf(i)});
                    return;
                }
                List<ItemModuleBean.GoodBean> list = ProductShopDelegate.this.a.goods;
                if (list != null) {
                    productViewHolder.c(list.get(i), i);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            @NonNull
            /* renamed from: b */
            public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup2, int i) {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "1930513563") ? (ProductViewHolder) ipChange2.ipc$dispatch("1930513563", new Object[]{this, viewGroup2, Integer.valueOf(i)}) : new ProductViewHolder(LayoutInflater.from(viewGroup2.getContext()).inflate(R$layout.layout_product_item, viewGroup2, false));
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                List<ItemModuleBean.GoodBean> list;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1570841982")) {
                    return ((Integer) ipChange2.ipc$dispatch("-1570841982", new Object[]{this})).intValue();
                }
                ItemModuleBean itemModuleBean = ProductShopDelegate.this.a;
                if (itemModuleBean == null || (list = itemModuleBean.goods) == null) {
                    return 0;
                }
                return list.size();
            }
        });
        fh1 fh1Var = new fh1(viewGroup, activity, this.b);
        ModuleTitleModel moduleTitleModel = new ModuleTitleModel();
        moduleTitleModel.opList = this.a.getOptionList();
        moduleTitleModel.title = this.a.title;
        fh1Var.d(moduleTitleModel);
    }
}
