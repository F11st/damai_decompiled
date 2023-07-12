package cn.damai.search.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.c;
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
import cn.damai.search.ui.viewholder.SearchRecViewHolder;
import cn.damai.search.ui.viewholder.SearchTipViewHolder;
import cn.damai.search.ui.viewholder.SearchTourViewHolder;
import cn.damai.search.ui.viewholder.SearchWordPriviegeProjectViewHolder;
import cn.damai.search.ui.viewholder.SearchWordPrivilegeJuMuViewHolder;
import cn.damai.search.ui.viewholder.SearchWordProjectViewHolder;
import cn.damai.search.ui.viewholder.SearchWordViewHolder;
import cn.damai.search.ui.viewholder.WaterFlowRecommendViewHolder;
import com.alibaba.pictures.bricks.component.project.BricksProjectViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<SearchDataHolder> a;
    private Context b;
    private View.OnClickListener c;
    private FlowerViewHolder d;
    private WaterFlowRecommendViewHolder e;
    private SearchListener f;
    private String g;
    public ConcurrentHashMap<String, BaccountInfo> h;
    public Daojishi i = new Daojishi(true);

    public SearchAdapter(Context context, List<SearchDataHolder> list, ConcurrentHashMap<String, BaccountInfo> concurrentHashMap) {
        this.b = context;
        this.a = list;
        this.h = concurrentHashMap;
    }

    private void c(ProjectItemBean projectItemBean, boolean z, View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1873924064")) {
            ipChange.ipc$dispatch("-1873924064", new Object[]{this, projectItemBean, Boolean.valueOf(z), view, Integer.valueOf(i)});
        } else if (projectItemBean != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("item_id", projectItemBean.id);
            hashMap.put("keyword", this.g);
            hashMap.put("contentlable", projectItemBean.name);
            if (!TextUtils.isEmpty(projectItemBean.alg)) {
                hashMap.put("alg", projectItemBean.alg);
            }
            if (!z) {
                c e = c.e();
                e.G(view, "item_" + i, "list", "search", hashMap);
                return;
            }
            c e2 = c.e();
            e2.G(view, "item_" + i, "keywordother", "search", hashMap);
        }
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1823280592")) {
            ipChange.ipc$dispatch("1823280592", new Object[]{this, str});
        } else {
            this.g = str;
        }
    }

    public void b(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "165727937")) {
            ipChange.ipc$dispatch("165727937", new Object[]{this, onClickListener});
        } else {
            this.c = onClickListener;
        }
    }

    public List<SearchDataHolder> getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1471982358") ? (List) ipChange.ipc$dispatch("-1471982358", new Object[]{this}) : this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1875538118") ? ((Integer) ipChange.ipc$dispatch("-1875538118", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1843110687") ? ((Integer) ipChange.ipc$dispatch("-1843110687", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).mType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ConcurrentHashMap<String, BaccountInfo> concurrentHashMap;
        IpChange ipChange = $ipChange;
        boolean z = true;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-301086337")) {
            ipChange.ipc$dispatch("-301086337", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else if (viewHolder != null) {
            SearchDataHolder searchDataHolder = this.a.get(i);
            int i2 = searchDataHolder.mType;
            if (i2 == 0) {
                ProjectItemViewHolder projectItemViewHolder = (ProjectItemViewHolder) viewHolder;
                projectItemViewHolder.u(this.i);
                projectItemViewHolder.l(searchDataHolder.mProjectItem, BricksProjectViewHolder.PageType.SEARCH_PAGE);
                if (this.c != null) {
                    viewHolder.itemView.setTag(Integer.valueOf(i));
                    viewHolder.itemView.setOnClickListener(this.c);
                }
                c(searchDataHolder.mProjectItem, searchDataHolder.isRecommendProject, viewHolder.itemView, i);
            } else if (i2 == 1) {
                ((SearchRecViewHolder) viewHolder).a(searchDataHolder);
            } else if (i2 == 2) {
                ((SearchFindViewHolder) viewHolder).c(searchDataHolder.mSearchFindWordList);
            } else if (i2 == 3) {
                ((FlowerViewHolder) viewHolder).b(searchDataHolder.mHistoryKey);
            } else if (i2 != 4) {
                if (i2 != 21) {
                    switch (i2) {
                        case 7:
                            BaccountInfo baccountInfo = searchDataHolder.mAccountInfo;
                            if (baccountInfo != null && (concurrentHashMap = this.h) != null) {
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
                            break;
                        case 14:
                            Log.d("tesxx", "3 pos:" + i + " , isfrsit: " + searchDataHolder.isSectionFirst);
                            SearchWordPrivilegeJuMuViewHolder searchWordPrivilegeJuMuViewHolder = (SearchWordPrivilegeJuMuViewHolder) viewHolder;
                            searchWordPrivilegeJuMuViewHolder.b(this.g);
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
                        default:
                            return;
                    }
                }
                Log.d("tesxx", "1 pos:" + i + " , isfrsit: " + searchDataHolder.isSectionFirst);
                ((SearchWordPriviegeProjectViewHolder) viewHolder).b(searchDataHolder.mProjectItem, searchDataHolder.isSectionFirst, searchDataHolder.mType, searchDataHolder.showDiv);
                if (this.c != null) {
                    viewHolder.itemView.setTag(Integer.valueOf(i));
                    viewHolder.itemView.setOnClickListener(this.c);
                }
            } else {
                ((SearchTipViewHolder) viewHolder).a(searchDataHolder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686591831")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("686591831", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.b);
        if (i != 21) {
            switch (i) {
                case 0:
                    return new ProjectItemViewHolder(this.b, from);
                case 1:
                    return new SearchRecViewHolder(from);
                case 2:
                    SearchFindViewHolder searchFindViewHolder = new SearchFindViewHolder(this.b, from);
                    SearchListener searchListener = this.f;
                    if (searchListener != null) {
                        searchFindViewHolder.f(searchListener);
                        return searchFindViewHolder;
                    }
                    return searchFindViewHolder;
                case 3:
                    FlowerViewHolder flowerViewHolder = new FlowerViewHolder(from);
                    this.d = flowerViewHolder;
                    SearchListener searchListener2 = this.f;
                    if (searchListener2 != null) {
                        flowerViewHolder.c(searchListener2);
                        return flowerViewHolder;
                    }
                    return flowerViewHolder;
                case 4:
                    return new SearchTipViewHolder(this.b, from, null);
                case 5:
                    return new SearchEmptyViewHolder(from);
                case 6:
                    return new SearchEndViewHolder(this.b, from);
                case 7:
                    return new SearchAccountViewHolder(this.b, from);
                case 8:
                    return new SearchWordViewHolder(viewGroup.getContext(), from);
                case 9:
                    return new SearchWordProjectViewHolder(viewGroup.getContext(), from, this.i);
                case 10:
                    return new SearchTourViewHolder(this.b, from, this.i);
                case 11:
                    SearchEggRecommendViewHolder searchEggRecommendViewHolder = new SearchEggRecommendViewHolder(viewGroup.getContext(), from);
                    SearchListener searchListener3 = this.f;
                    if (searchListener3 != null) {
                        searchEggRecommendViewHolder.d(searchListener3);
                        return searchEggRecommendViewHolder;
                    }
                    return searchEggRecommendViewHolder;
                case 12:
                    return new BrandOptimizationViewHolder(this.b, from);
                case 13:
                case 17:
                    break;
                case 14:
                    return new SearchWordPrivilegeJuMuViewHolder(viewGroup.getContext(), from);
                case 15:
                    return new WaterFlowRecommendViewHolder(viewGroup.getContext());
                case 16:
                    WaterFlowRecommendViewHolder waterFlowRecommendViewHolder = new WaterFlowRecommendViewHolder(viewGroup.getContext());
                    this.e = waterFlowRecommendViewHolder;
                    return waterFlowRecommendViewHolder;
                default:
                    return null;
            }
        }
        return new SearchWordPriviegeProjectViewHolder(viewGroup.getContext(), from);
    }
}
