package cn.damai.search.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.discover.viewholder.NoteViewHolder;
import cn.damai.commonbusiness.discover.viewholder.OnItemClickListener;
import cn.damai.commonbusiness.search.Daojishi;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.commonbusiness.search.viewholder.ProjectItemViewHolder;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.helper.SearchListener;
import cn.damai.search.ui.viewholder.BrandOptimizationViewHolder;
import cn.damai.search.ui.viewholder.FlowerViewHolder;
import cn.damai.search.ui.viewholder.SearchAccountViewHolder;
import cn.damai.search.ui.viewholder.SearchEggRecommendViewHolder;
import cn.damai.search.ui.viewholder.SearchEmptyViewHolder;
import cn.damai.search.ui.viewholder.SearchEndViewHolder;
import cn.damai.search.ui.viewholder.SearchFindViewHolder;
import cn.damai.search.ui.viewholder.SearchHeadViewHolder;
import cn.damai.search.ui.viewholder.SearchRecViewHolder;
import cn.damai.search.ui.viewholder.SearchTipViewHolder;
import cn.damai.search.ui.viewholder.SearchTourViewHolder;
import cn.damai.search.ui.viewholder.SearchWordPriviegeProjectViewHolder;
import cn.damai.search.ui.viewholder.SearchWordPrivilegeJuMuViewHolder;
import cn.damai.search.ui.viewholder.SearchWordProjectViewHolder;
import cn.damai.search.ui.viewholder.SearchWordViewHolder;
import cn.damai.search.ui.viewholder.WaterFlowRecommendGoodsCardViewHolder;
import cn.damai.search.ui.viewholder.WaterFlowRecommendViewHolder;
import cn.damai.tetris.component.discover.bean.NoteBean;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.b82;
import tb.cb2;
import tb.cs;
import tb.rm1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchAdapterV2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<SearchDataHolder> a;
    private Context b;
    private View.OnClickListener c;
    private SearchListener d;
    private String e;
    @Deprecated
    public ConcurrentHashMap<String, BaccountInfo> f;
    private OnXItemClickListener h;
    private String i;
    private int j;
    private DataListener k;
    private int l;
    public Daojishi g = new Daojishi(true);
    private OnItemClickListener<NoteBean> m = new C1610b();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnXItemClickListener {
        void onLoadMoreProjectClicked(@Nullable List<SearchDataHolder> list);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.adapter.SearchAdapterV2$a */
    /* loaded from: classes6.dex */
    public class C1609a implements SearchTipViewHolder.OnLoadMoreClick {
        private static transient /* synthetic */ IpChange $ipChange;

        C1609a() {
        }

        @Override // cn.damai.search.ui.viewholder.SearchTipViewHolder.OnLoadMoreClick
        public void onLoadMoreBtnClick(@Nullable List<SearchDataHolder> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-130182815")) {
                ipChange.ipc$dispatch("-130182815", new Object[]{this, list});
            } else if (SearchAdapterV2.this.h != null) {
                SearchAdapterV2.this.h.onLoadMoreProjectClicked(list);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.ui.adapter.SearchAdapterV2$b */
    /* loaded from: classes6.dex */
    public class C1610b implements OnItemClickListener<NoteBean> {
        private static transient /* synthetic */ IpChange $ipChange;

        C1610b() {
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: a */
        public void onEditClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1733335896")) {
                ipChange.ipc$dispatch("-1733335896", new Object[]{this, noteBean, Integer.valueOf(i)});
            }
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        /* renamed from: b */
        public void onItemClick(NoteBean noteBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1763484161")) {
                ipChange.ipc$dispatch("-1763484161", new Object[]{this, noteBean, Integer.valueOf(i)});
                return;
            }
            C0529c.e().x(b82.C().u(SearchAdapterV2.this.i, "", noteBean.id, SearchAdapterV2.this.j, i - SearchAdapterV2.this.e(18), ""));
            Bundle bundle = new Bundle();
            bundle.putString("contentId", noteBean.id);
            bundle.putFloat("picWhRatio", noteBean.localPicWhRatio);
            DMNav.from(SearchAdapterV2.this.b).withExtras(bundle).toUri(NavUri.b(cs.DISCOVER_CONTENT_DETAIL));
        }

        @Override // cn.damai.commonbusiness.discover.viewholder.OnItemClickListener
        public /* synthetic */ void onDnaClick(NoteBean noteBean, int i) {
            rm1.a(this, noteBean, i);
        }
    }

    public SearchAdapterV2(Context context, List<SearchDataHolder> list, ConcurrentHashMap<String, BaccountInfo> concurrentHashMap, OnXItemClickListener onXItemClickListener) {
        this.b = context;
        this.a = list;
        this.f = concurrentHashMap;
        this.h = onXItemClickListener;
        DataListener dataListener = new DataListener();
        this.k = dataListener;
        registerAdapterDataObserver(dataListener);
    }

    private void j(int i, RecyclerView.ViewHolder viewHolder) {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1216476218")) {
            ipChange.ipc$dispatch("1216476218", new Object[]{this, Integer.valueOf(i), viewHolder});
        } else if (viewHolder == null || (view = viewHolder.itemView) == null) {
        } else {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
                if (i != 18 && i != 19) {
                    layoutParams2.setFullSpan(true);
                } else {
                    layoutParams2.setFullSpan(false);
                }
            }
        }
    }

    private void m(ProjectItemBean projectItemBean, boolean z, View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860841980")) {
            ipChange.ipc$dispatch("-860841980", new Object[]{this, projectItemBean, Boolean.valueOf(z), view, Integer.valueOf(i)});
        } else if (projectItemBean != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", projectItemBean.id);
            hashMap.put("keyword", this.e);
            hashMap.put("contentlable", projectItemBean.name);
            if (!TextUtils.isEmpty(projectItemBean.alg)) {
                hashMap.put("alg", projectItemBean.alg);
            }
            if (!z) {
                C0529c e = C0529c.e();
                e.G(view, "item_" + i, "list", "search", hashMap);
                return;
            }
            C0529c e2 = C0529c.e();
            e2.G(view, "item_" + i, "keywordother", "search", hashMap);
        }
    }

    public int e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "824914250")) {
            return ((Integer) ipChange.ipc$dispatch("824914250", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (!cb2.d(this.a)) {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.a.get(i2).mType == i) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public int f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1393148313") ? ((Integer) ipChange.ipc$dispatch("-1393148313", new Object[]{this})).intValue() : e(0);
    }

    public void g(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829878408")) {
            ipChange.ipc$dispatch("-1829878408", new Object[]{this, Long.valueOf(j)});
        } else {
            this.g.setServiceTimeAndDiff(j);
        }
    }

    public List<SearchDataHolder> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1469014906") ? (List) ipChange.ipc$dispatch("-1469014906", new Object[]{this}) : this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1926130134") ? ((Integer) ipChange.ipc$dispatch("1926130134", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1901496701") ? ((Integer) ipChange.ipc$dispatch("1901496701", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).mType;
    }

    public void h(SearchListener searchListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972921914")) {
            ipChange.ipc$dispatch("-1972921914", new Object[]{this, searchListener});
        } else {
            this.d = searchListener;
        }
    }

    public void i(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110989202")) {
            ipChange.ipc$dispatch("110989202", new Object[]{this, str, Integer.valueOf(i)});
            return;
        }
        this.i = str;
        this.j = i;
    }

    public void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304795540")) {
            ipChange.ipc$dispatch("-304795540", new Object[]{this, str});
        } else {
            this.e = str;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1115981731")) {
            ipChange.ipc$dispatch("-1115981731", new Object[]{this, onClickListener});
        } else {
            this.c = onClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ConcurrentHashMap<String, BaccountInfo> concurrentHashMap;
        IpChange ipChange = $ipChange;
        boolean z = true;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "1911856483")) {
            ipChange.ipc$dispatch("1911856483", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            SearchDataHolder searchDataHolder = this.a.get(i);
            int i2 = searchDataHolder.mType;
            j(i2, viewHolder);
            switch (i2) {
                case 0:
                    ProjectItemViewHolder projectItemViewHolder = (ProjectItemViewHolder) viewHolder;
                    projectItemViewHolder.u(this.g);
                    projectItemViewHolder.l(searchDataHolder.mProjectItem, BricksProjectViewHolder.PageType.SEARCH_PAGE);
                    if (this.c != null) {
                        viewHolder.itemView.setTag(Integer.valueOf(i));
                        viewHolder.itemView.setOnClickListener(this.c);
                    }
                    m(searchDataHolder.mProjectItem, searchDataHolder.isRecommendProject, viewHolder.itemView, i);
                    return;
                case 1:
                    ((SearchRecViewHolder) viewHolder).a(searchDataHolder);
                    return;
                case 2:
                    ((SearchFindViewHolder) viewHolder).c(searchDataHolder.mSearchFindWordList);
                    return;
                case 3:
                    ((FlowerViewHolder) viewHolder).b(searchDataHolder.mHistoryKey);
                    return;
                case 4:
                    ((SearchTipViewHolder) viewHolder).a(searchDataHolder);
                    return;
                case 5:
                case 6:
                default:
                    return;
                case 7:
                    BaccountInfo baccountInfo = searchDataHolder.mAccountInfo;
                    if (baccountInfo != null && (concurrentHashMap = this.f) != null) {
                        baccountInfo = concurrentHashMap.get(baccountInfo.damaiId);
                    }
                    if (baccountInfo != null) {
                        if ((!baccountInfo.type.equals("2") || searchDataHolder.tour == null) && (!baccountInfo.type.equals("4") || searchDataHolder.mBrandOptimizations == null)) {
                            z = false;
                        }
                        z2 = z;
                    }
                    ((SearchAccountViewHolder) viewHolder).a(baccountInfo, z2, searchDataHolder.isYouKuResponse);
                    return;
                case 8:
                    ((SearchWordViewHolder) viewHolder).a(searchDataHolder.mSuggestWord);
                    if (this.c != null) {
                        viewHolder.itemView.setTag(Integer.valueOf(i));
                        viewHolder.itemView.setOnClickListener(this.c);
                        return;
                    }
                    return;
                case 9:
                    ((SearchWordProjectViewHolder) viewHolder).b(searchDataHolder.mProjectItem);
                    if (this.c != null) {
                        viewHolder.itemView.setTag(Integer.valueOf(i));
                        viewHolder.itemView.setOnClickListener(this.c);
                        return;
                    }
                    return;
                case 10:
                    SearchTourViewHolder searchTourViewHolder = (SearchTourViewHolder) viewHolder;
                    SearchTourBean searchTourBean = searchDataHolder.tour;
                    String str = searchDataHolder.mUtAaid;
                    BaccountInfo baccountInfo2 = searchDataHolder.mAccountInfo;
                    searchTourViewHolder.e(searchTourBean, str, baccountInfo2 != null ? baccountInfo2.moreInfo : null);
                    return;
                case 11:
                    ((SearchEggRecommendViewHolder) viewHolder).b(searchDataHolder.mSearchEggs);
                    return;
                case 12:
                    ((BrandOptimizationViewHolder) viewHolder).d(searchDataHolder.mBrandOptimizations, searchDataHolder.mUtAaid);
                    return;
                case 13:
                    Log.d("tesxx", "1 pos:" + i + " , isfrsit: " + searchDataHolder.isSectionFirst);
                    ((SearchWordPriviegeProjectViewHolder) viewHolder).b(searchDataHolder.mProjectItem, searchDataHolder.isSectionFirst, searchDataHolder.mType, searchDataHolder.showDiv);
                    if (this.c != null) {
                        viewHolder.itemView.setTag(Integer.valueOf(i));
                        viewHolder.itemView.setOnClickListener(this.c);
                        return;
                    }
                    return;
                case 14:
                    Log.d("tesxx", "3 pos:" + i + " , isfrsit: " + searchDataHolder.isSectionFirst);
                    SearchWordPrivilegeJuMuViewHolder searchWordPrivilegeJuMuViewHolder = (SearchWordPrivilegeJuMuViewHolder) viewHolder;
                    searchWordPrivilegeJuMuViewHolder.b(this.e);
                    searchWordPrivilegeJuMuViewHolder.a(searchDataHolder.mAccountInfo, i, searchDataHolder.isSectionFirst, searchDataHolder.showDiv);
                    if (this.c != null) {
                        viewHolder.itemView.setTag(Integer.valueOf(i));
                        viewHolder.itemView.setOnClickListener(this.c);
                        return;
                    }
                    return;
                case 15:
                    ((WaterFlowRecommendViewHolder) viewHolder).a(searchDataHolder.mWaterFlowRecommendList, searchDataHolder.aaid, searchDataHolder.inputType, searchDataHolder.keyword);
                    return;
                case 16:
                    ((WaterFlowRecommendViewHolder) viewHolder).a(searchDataHolder.mWaterFlowContentList, searchDataHolder.aaid, searchDataHolder.inputType, searchDataHolder.keyword);
                    return;
                case 17:
                    Log.d("tesxx", "2 pos:" + i + " , isfrsit: " + searchDataHolder.isSectionFirst);
                    ((SearchWordPriviegeProjectViewHolder) viewHolder).b(searchDataHolder.mProjectItem, searchDataHolder.isSectionFirst, searchDataHolder.mType, searchDataHolder.showDiv);
                    if (this.c != null) {
                        viewHolder.itemView.setTag(Integer.valueOf(i));
                        viewHolder.itemView.setOnClickListener(this.c);
                        return;
                    }
                    return;
                case 18:
                    ((NoteViewHolder) viewHolder).a(searchDataHolder.mNoteBean, i);
                    return;
                case 19:
                    if (this.k.b()) {
                        this.l = e(19);
                        this.k.a();
                    }
                    ((WaterFlowRecommendGoodsCardViewHolder) viewHolder).f(searchDataHolder.mProjectItem, searchDataHolder.aaid, searchDataHolder.inputType, i - this.l);
                    return;
                case 20:
                    ((SearchHeadViewHolder) viewHolder).f(searchDataHolder, searchDataHolder.aaid, searchDataHolder.keyword);
                    return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027365363")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("2027365363", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.b);
        switch (i) {
            case 0:
                return new ProjectItemViewHolder(this.b, from);
            case 1:
                return new SearchRecViewHolder(from);
            case 2:
                SearchFindViewHolder searchFindViewHolder = new SearchFindViewHolder(this.b, from);
                SearchListener searchListener = this.d;
                if (searchListener != null) {
                    searchFindViewHolder.f(searchListener);
                    return searchFindViewHolder;
                }
                return searchFindViewHolder;
            case 3:
                FlowerViewHolder flowerViewHolder = new FlowerViewHolder(from);
                SearchListener searchListener2 = this.d;
                if (searchListener2 != null) {
                    flowerViewHolder.c(searchListener2);
                    return flowerViewHolder;
                }
                return flowerViewHolder;
            case 4:
                return new SearchTipViewHolder(this.b, from, new C1609a());
            case 5:
                return new SearchEmptyViewHolder(from);
            case 6:
                return new SearchEndViewHolder(this.b, from);
            case 7:
                return new SearchAccountViewHolder(this.b, from);
            case 8:
                return new SearchWordViewHolder(viewGroup.getContext(), from);
            case 9:
                return new SearchWordProjectViewHolder(viewGroup.getContext(), from, this.g);
            case 10:
                return new SearchTourViewHolder(this.b, from, this.g);
            case 11:
                SearchEggRecommendViewHolder searchEggRecommendViewHolder = new SearchEggRecommendViewHolder(viewGroup.getContext(), from);
                SearchListener searchListener3 = this.d;
                if (searchListener3 != null) {
                    searchEggRecommendViewHolder.d(searchListener3);
                    return searchEggRecommendViewHolder;
                }
                return searchEggRecommendViewHolder;
            case 12:
                return new BrandOptimizationViewHolder(this.b, from);
            case 13:
                return new SearchWordPriviegeProjectViewHolder(viewGroup.getContext(), from);
            case 14:
                return new SearchWordPrivilegeJuMuViewHolder(viewGroup.getContext(), from);
            case 15:
                return new WaterFlowRecommendViewHolder(viewGroup.getContext());
            case 16:
                return new WaterFlowRecommendViewHolder(viewGroup.getContext());
            case 17:
                return new SearchWordPriviegeProjectViewHolder(viewGroup.getContext(), from);
            case 18:
                return new NoteViewHolder(this.b, viewGroup, this.m);
            case 19:
                return new WaterFlowRecommendGoodsCardViewHolder(viewGroup.getContext());
            case 20:
                return new SearchHeadViewHolder(this.b, this.g);
            default:
                return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117444454")) {
            ipChange.ipc$dispatch("-2117444454", new Object[]{this, viewHolder});
        } else {
            super.onViewAttachedToWindow(viewHolder);
        }
    }
}
