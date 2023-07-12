package cn.damai.search.v2.tool;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.search.bean.SearchDataHolder;
import cn.damai.search.bean.SearchEggs;
import cn.damai.search.model.SearchEggsRequest;
import cn.damai.search.ui.viewholder.SearchEggRecommendViewHolderV2;
import cn.damai.search.v2.adapter.EggAdapter;
import cn.damai.search.v2.listener.ISearchUIController;
import cn.damai.search.v2.listener.InputInfoProvider;
import cn.damai.search.v2.listener.OnEggListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.c82;
import tb.cb2;
import tb.qd2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SearchEggManager {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private ISearchUIController b;
    private Activity c;
    private ViewGroup d;
    private boolean e = false;
    private List<SearchDataHolder> f = new ArrayList();
    private EggAdapter g;
    private InputInfoProvider h;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.tool.SearchEggManager$a */
    /* loaded from: classes6.dex */
    public class C1656a implements SearchEggRecommendViewHolderV2.OnEggListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1656a() {
        }

        @Override // cn.damai.search.ui.viewholder.SearchEggRecommendViewHolderV2.OnEggListener
        public void onImgClick(SearchEggs searchEggs, ImageView imageView, SearchEggs.SearchEggHeader searchEggHeader, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1526574532")) {
                ipChange.ipc$dispatch("1526574532", new Object[]{this, searchEggs, imageView, searchEggHeader, Integer.valueOf(i)});
            } else {
                SearchEggManager.this.d(searchEggs, searchEggHeader, imageView, i);
            }
        }

        @Override // cn.damai.search.ui.viewholder.SearchEggRecommendViewHolderV2.OnEggListener
        public void onImgExpose(ImageView imageView, SearchEggs.SearchEggHeader searchEggHeader, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2010223050")) {
                ipChange.ipc$dispatch("2010223050", new Object[]{this, imageView, searchEggHeader, Integer.valueOf(i)});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.search.v2.tool.SearchEggManager$b */
    /* loaded from: classes6.dex */
    public class C1657b implements EggAdapter.OnProjectClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1657b() {
        }

        @Override // cn.damai.search.v2.adapter.EggAdapter.OnProjectClickListener
        public void onProjectClick(SearchEggs searchEggs, View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1895981293")) {
                ipChange.ipc$dispatch("1895981293", new Object[]{this, searchEggs, view, projectItemBean, Integer.valueOf(i)});
            } else {
                SearchEggManager.this.h(searchEggs, projectItemBean, i);
            }
        }

        @Override // cn.damai.search.v2.adapter.EggAdapter.OnProjectClickListener
        public void onProjectExpose(View view, ProjectItemBean projectItemBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-847083865")) {
                ipChange.ipc$dispatch("-847083865", new Object[]{this, view, projectItemBean, Integer.valueOf(i)});
            }
        }
    }

    public SearchEggManager(Activity activity, View view, ISearchUIController iSearchUIController, InputInfoProvider inputInfoProvider) {
        this.a = view;
        this.d = (ViewGroup) view.findViewById(R$id.search_v2_egg_layout);
        this.b = iSearchUIController;
        this.c = activity;
        this.h = inputInfoProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(SearchEggs searchEggs, SearchEggs.SearchEggHeader searchEggHeader, ImageView imageView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929279414")) {
            ipChange.ipc$dispatch("1929279414", new Object[]{this, searchEggs, searchEggHeader, imageView, Integer.valueOf(i)});
        } else if (searchEggHeader == null || TextUtils.isEmpty(searchEggHeader.url)) {
        } else {
            String str = searchEggHeader.url;
            HashMap hashMap = new HashMap();
            if (searchEggs != null) {
                if (!TextUtils.isEmpty(searchEggs.comboDispatchSystem)) {
                    hashMap.put("dispatch_system", searchEggs.comboDispatchSystem);
                }
                if (!TextUtils.isEmpty(searchEggs.comboDispatchId)) {
                    hashMap.put("dispatch_id", searchEggs.comboDispatchId);
                }
            }
            c82.l(this.h.getCurrentInputInfo(), str, i, hashMap);
            DMNav.from(this.c).toUri(str);
        }
    }

    private void e(String str, SearchEggs searchEggs) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899904298")) {
            ipChange.ipc$dispatch("899904298", new Object[]{this, str, searchEggs});
            return;
        }
        this.f.clear();
        List<SearchEggs.SearchEggHeader> list = searchEggs.header;
        if (list != null && list.size() >= 4) {
            SearchDataHolder searchDataHolder = new SearchDataHolder(11);
            searchDataHolder.mSearchEggs = searchEggs;
            this.f.add(searchDataHolder);
        }
        List<ProjectItemBean> list2 = searchEggs.projectInfo;
        if (list2 != null && list2.size() > 0) {
            for (int i = 0; i < searchEggs.projectInfo.size(); i++) {
                SearchDataHolder searchDataHolder2 = new SearchDataHolder(0);
                searchDataHolder2.mSearchEggs = searchEggs;
                searchDataHolder2.mProjectItem = searchEggs.projectInfo.get(i);
                searchDataHolder2.isRecommendProject = false;
                this.f.add(searchDataHolder2);
            }
        }
        SearchDataHolder searchDataHolder3 = new SearchDataHolder(4);
        searchDataHolder3.isVisableLine = false;
        List<ProjectItemBean> list3 = searchEggs.projectInfo;
        if (list3 != null && list3.size() > 0) {
            searchDataHolder3.mTipType = 2;
            searchDataHolder3.mArtistName = str;
        } else {
            searchDataHolder3.mTipType = 3;
            searchDataHolder3.mArtistName = str;
        }
        this.f.add(searchDataHolder3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, SearchEggs searchEggs, OnEggListener onEggListener) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-525739534")) {
            ipChange.ipc$dispatch("-525739534", new Object[]{this, str, searchEggs, onEggListener});
            return;
        }
        if (searchEggs != null && searchEggs.isValidType()) {
            if (searchEggs.isTypeShowList()) {
                g();
                e(str, searchEggs);
                if (!cb2.d(this.f)) {
                    this.b.showUi(3);
                    this.g.b(str);
                    this.g.f.setServiceTimeAndDiff(searchEggs.currentTime);
                    this.g.f(this.f);
                    z = true;
                }
            } else if (searchEggs.isTypeJumpPage() && !TextUtils.isEmpty(searchEggs.url)) {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(searchEggs.comboDispatchSystem)) {
                    hashMap.put("dispatch_system", searchEggs.comboDispatchSystem);
                }
                if (!TextUtils.isEmpty(searchEggs.comboDispatchId)) {
                    hashMap.put("dispatch_id", searchEggs.comboDispatchId);
                }
                c82.m(this.h.getCurrentInputInfo(), hashMap);
                DMNav.from(this.c).toUri(searchEggs.url);
                z = true;
            }
        }
        onEggListener.onEggFinish(z);
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1338114202")) {
            ipChange.ipc$dispatch("1338114202", new Object[]{this});
        } else if (this.e) {
        } else {
            this.e = true;
            View inflate = LayoutInflater.from(this.c).inflate(R$layout.item_layout_egg_show_list, this.d, false);
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.search_egg_list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.c, 1, false));
            EggAdapter eggAdapter = new EggAdapter(this.c);
            this.g = eggAdapter;
            eggAdapter.c(new C1656a());
            this.g.e(new C1657b());
            recyclerView.setAdapter(this.g);
            this.d.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(SearchEggs searchEggs, ProjectItemBean projectItemBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "636861374")) {
            ipChange.ipc$dispatch("636861374", new Object[]{this, searchEggs, projectItemBean, Integer.valueOf(i)});
        } else if (projectItemBean == null) {
        } else {
            HashMap hashMap = new HashMap();
            if (searchEggs != null) {
                if (!TextUtils.isEmpty(searchEggs.comboDispatchSystem)) {
                    hashMap.put("dispatch_system", searchEggs.comboDispatchSystem);
                }
                if (!TextUtils.isEmpty(searchEggs.comboDispatchId)) {
                    hashMap.put("dispatch_id", searchEggs.comboDispatchId);
                }
            }
            c82.n(projectItemBean, this.h.getCurrentInputInfo(), i, hashMap);
            qd2.b(this.c, projectItemBean.schema, projectItemBean.id, projectItemBean.name, projectItemBean.verticalPic);
        }
    }

    public void i(final String str, final OnEggListener onEggListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1376656655")) {
            ipChange.ipc$dispatch("1376656655", new Object[]{this, str, onEggListener});
            return;
        }
        onEggListener.showLoading(true);
        SearchEggsRequest searchEggsRequest = new SearchEggsRequest();
        searchEggsRequest.keyword = str;
        searchEggsRequest.request(new DMMtopRequestListener<SearchEggs>(SearchEggs.class) { // from class: cn.damai.search.v2.tool.SearchEggManager.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-368013415")) {
                    ipChange2.ipc$dispatch("-368013415", new Object[]{this, str2, str3});
                    return;
                }
                onEggListener.showLoading(false);
                onEggListener.onEggFinish(false);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(SearchEggs searchEggs) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2072754068")) {
                    ipChange2.ipc$dispatch("2072754068", new Object[]{this, searchEggs});
                    return;
                }
                onEggListener.showLoading(false);
                SearchEggManager.this.f(str, searchEggs, onEggListener);
            }
        });
    }
}
