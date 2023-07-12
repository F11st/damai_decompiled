package cn.damai.search.ui.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.brand.BrandOptimizationDO;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.youku.ArtificialProxy;
import cn.damai.search.bean.youku.PageSpec;
import cn.damai.search.helper.SearchHelper;
import cn.damai.search.ui.adapter.ArtificialAdapter;
import cn.damai.tetris.component.drama.viewholder.OnItemBindListener;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.b82;
import tb.cb2;
import tb.m62;
import tb.mu0;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchHeadViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private SearchHeadAccountViewHolder a;
    private SearchHeadTourViewHolder b;
    private SearchHeadBrandOptViewHolder c;
    private View d;
    private View e;
    private View f;
    private View g;
    private Context h;
    private ArtificialAdapter i;
    private int j;
    private int k;
    private View l;
    private View m;
    private String n;
    private String o;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArtificialProxy a;

        a(ArtificialProxy artificialProxy) {
            this.a = artificialProxy;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-561252613")) {
                ipChange.ipc$dispatch("-561252613", new Object[]{this, view});
            } else {
                SearchHeadViewHolder.this.j(this.a, 0);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class b implements OnItemBindListener<ArtificialProxy> {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemBindListener
        /* renamed from: a */
        public void exposeItem(View view, ArtificialProxy artificialProxy, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "969217969")) {
                ipChange.ipc$dispatch("969217969", new Object[]{this, view, artificialProxy, Integer.valueOf(i)});
            } else {
                SearchHeadViewHolder.this.g(view, artificialProxy, i);
            }
        }

        @Override // cn.damai.tetris.component.drama.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(ArtificialProxy artificialProxy, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-394834074")) {
                ipChange.ipc$dispatch("-394834074", new Object[]{this, artificialProxy, Integer.valueOf(i)});
            } else {
                SearchHeadViewHolder.this.j(artificialProxy, i);
            }
        }
    }

    public SearchHeadViewHolder(Context context, Daojishi daojishi) {
        super(LayoutInflater.from(mu0.a()).inflate(R$layout.item_view_search_head, (ViewGroup) null));
        this.j = m62.a(mu0.a(), 12.0f);
        this.k = m62.a(mu0.a(), 15.0f);
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        View findViewById = this.itemView.findViewById(R$id.item_layout_b_account);
        View findViewById2 = this.itemView.findViewById(R$id.item_layout_tour);
        View findViewById3 = this.itemView.findViewById(R$id.item_layout_brand_opt);
        this.d = this.itemView.findViewById(R$id.item_layout_below_account);
        this.e = this.itemView.findViewById(R$id.item_layout_below_account_inner);
        this.f = this.itemView.findViewById(R$id.item_single_artificial);
        this.g = this.itemView.findViewById(R$id.item_multi_artificial);
        this.l = this.itemView.findViewById(R$id.item_view_search_divide_line_below_tour);
        this.m = this.itemView.findViewById(R$id.item_view_search_divide_line_below_brand);
        this.a = new SearchHeadAccountViewHolder(context, findViewById);
        this.b = new SearchHeadTourViewHolder(context, findViewById2, daojishi);
        this.c = new SearchHeadBrandOptViewHolder(context, findViewById3);
        this.h = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, ArtificialProxy artificialProxy, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643619959")) {
            ipChange.ipc$dispatch("-1643619959", new Object[]{this, view, artificialProxy, Integer.valueOf(i)});
        } else if (view == null || artificialProxy == null) {
        } else {
            String id = artificialProxy.getId();
            ArtificialProxy.Type type = artificialProxy.getType();
            if (type == null) {
                return;
            }
            b82.C().A(view, i, this.n, this.o, id, type.utName);
        }
    }

    private boolean h(SearchDataHolder searchDataHolder) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "941091347") ? ((Boolean) ipChange.ipc$dispatch("941091347", new Object[]{this, searchDataHolder})).booleanValue() : (searchDataHolder.tour == null && wh2.e(searchDataHolder.mBrandOptimizations) < 3 && cb2.d(searchDataHolder.artificialList)) ? false : true;
    }

    private boolean i(SearchDataHolder searchDataHolder) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "605361562") ? ((Boolean) ipChange.ipc$dispatch("605361562", new Object[]{this, searchDataHolder})).booleanValue() : (cb2.d(searchDataHolder.mBrandOptimizations) && cb2.d(searchDataHolder.artificialList)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(ArtificialProxy artificialProxy, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164574469")) {
            ipChange.ipc$dispatch("164574469", new Object[]{this, artificialProxy, Integer.valueOf(i)});
        } else if (this.h == null || artificialProxy == null) {
        } else {
            PageSpec toPageSpec = artificialProxy.getToPageSpec();
            if (TextUtils.isEmpty(toPageSpec.url)) {
                return;
            }
            c.e().x(b82.C().B(this.n, this.o, i));
            if (toPageSpec.mBundle != null) {
                DMNav.from(this.h).withExtras(toPageSpec.mBundle).toUri(toPageSpec.url);
            } else {
                DMNav.from(this.h).toUri(toPageSpec.url);
            }
        }
    }

    private void k(List<ArtificialProxy> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044400648")) {
            ipChange.ipc$dispatch("2044400648", new Object[]{this, list});
            return;
        }
        if (this.i == null) {
            this.i = new ArtificialAdapter(this.h, new b());
            RecyclerView recyclerView = (RecyclerView) this.g.findViewById(R$id.item_multi_artificial);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.h, 0, false));
            recyclerView.setAdapter(this.i);
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.search.ui.viewholder.SearchHeadViewHolder.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView2, RecyclerView.State state) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1136092223")) {
                        ipChange2.ipc$dispatch("-1136092223", new Object[]{this, rect, view, recyclerView2, state});
                        return;
                    }
                    int childAdapterPosition = recyclerView2.getChildAdapterPosition(view);
                    if (childAdapterPosition == 0) {
                        rect.left = SearchHeadViewHolder.this.k;
                    } else {
                        rect.left = SearchHeadViewHolder.this.j;
                    }
                    if (childAdapterPosition >= SearchHeadViewHolder.this.i.getItemCount() - 1) {
                        rect.right = SearchHeadViewHolder.this.k;
                    }
                }
            });
        }
        this.i.c(list);
    }

    private void l(ArtificialProxy artificialProxy) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299895470")) {
            ipChange.ipc$dispatch("-299895470", new Object[]{this, artificialProxy});
            return;
        }
        ImageView imageView = (ImageView) this.f.findViewById(R$id.item_single_artificial_img);
        TextView textView = (TextView) this.f.findViewById(R$id.item_single_artificial_text);
        this.f.findViewById(R$id.item_single_video_tag).setVisibility(artificialProxy.isShowVideoTag() ? 0 : 8);
        textView.setText(artificialProxy.getTitle());
        SearchHelper.s(imageView, artificialProxy.getImgUrl(), DisplayMetrics.getwidthPixels(m62.b(mu0.a())) - (m62.a(mu0.a(), 36.0f) * 2), m62.a(mu0.a(), 170.0f));
        this.f.setOnClickListener(new a(artificialProxy));
        g(this.f, artificialProxy, 0);
    }

    public void f(SearchDataHolder searchDataHolder, String str, String str2) {
        boolean z;
        int i;
        int i2;
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "1753313108")) {
            ipChange.ipc$dispatch("1753313108", new Object[]{this, searchDataHolder, str, str2});
        } else if (searchDataHolder == null) {
        } else {
            this.n = str2;
            this.o = str;
            BaccountInfo baccountInfo = searchDataHolder.mAccountInfo;
            List<BrandOptimizationDO> list = searchDataHolder.mBrandOptimizations;
            SearchTourBean searchTourBean = searchDataHolder.tour;
            boolean z3 = wh2.e(list) >= 3;
            boolean h = h(searchDataHolder);
            this.l.setVisibility(searchTourBean != null && i(searchDataHolder) ? 0 : 8);
            List<String> list2 = null;
            if (baccountInfo != null) {
                list2 = baccountInfo.moreInfo;
                z = true;
            } else {
                z = false;
            }
            this.a.a(baccountInfo, h);
            this.b.e(searchTourBean, str, list2);
            this.c.d(list, str);
            List<ArtificialProxy> list3 = searchDataHolder.artificialList;
            int e = wh2.e(list3);
            if (e <= 0) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                z2 = false;
            } else if (e == 1) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
                l(list3.get(0));
            } else {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                k(list3);
            }
            this.m.setVisibility((z3 && z2) ? 0 : 8);
            this.d.setVisibility(h ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (z && h) {
                i = -m62.a(mu0.a(), 28.0f);
                i2 = m62.a(mu0.a(), 23.0f);
            } else {
                i = 0;
                i2 = 0;
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i;
                this.e.setPadding(0, i2, 0, 0);
                this.d.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
