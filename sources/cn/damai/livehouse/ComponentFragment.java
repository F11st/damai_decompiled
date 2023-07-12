package cn.damai.livehouse;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.commonbusiness.search.bean.FollowDataBean;
import cn.damai.livehouse.bean.CmsCommonParams;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.drama.bean.CategoryItemListInfo;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisParams;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.componentplugin.OnErrClickListener;
import cn.damai.uikit.irecycler.DamaiRootRecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Set;
import tb.pg;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ComponentFragment extends AbsFragmentV2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PATTERN_NAME = "patternName";
    public static final String PATTERN_VERSION = "patternVersion";
    private ContainerArg mArg;
    private OnCompFragmentListener mLifeListener;
    private RecyclerView.OnScrollListener mScrollListener;
    private OnWantSeeListener mWantSeeListener;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnCompFragmentListener {
        TetrisParams obtainPreferParams();

        void onViewCreatedFinish(ComponentFragment componentFragment);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnWantSeeListener {
        void onWantSeeClick(FollowDataBean followDataBean);
    }

    private void callLifeListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "228639486")) {
            ipChange.ipc$dispatch("228639486", new Object[]{this});
            return;
        }
        OnCompFragmentListener onCompFragmentListener = this.mLifeListener;
        if (onCompFragmentListener != null) {
            onCompFragmentListener.onViewCreatedFinish(this);
        }
    }

    private void enableExtraListener() {
        RecyclerView.OnScrollListener onScrollListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115655491")) {
            ipChange.ipc$dispatch("-115655491", new Object[]{this});
            return;
        }
        DamaiRootRecyclerView damaiRootRecyclerView = this.mRecyclerView;
        if (damaiRootRecyclerView == null || (onScrollListener = this.mScrollListener) == null) {
            return;
        }
        damaiRootRecyclerView.addOnScrollListener(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void load(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111222958")) {
            ipChange.ipc$dispatch("111222958", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            startProgressDialog();
        }
        OnCompFragmentListener onCompFragmentListener = this.mLifeListener;
        TetrisParams obtainPreferParams = onCompFragmentListener != null ? onCompFragmentListener.obtainPreferParams() : null;
        if (obtainPreferParams == null) {
            obtainPreferParams = new CmsCommonParams();
        }
        TetrisRequest tetrisRequest = new TetrisRequest(obtainPreferParams);
        TetrisRequest.overrideParams(tetrisRequest, this.mArg);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.livehouse.ComponentFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.livehouse.ComponentFragment$1$a */
            /* loaded from: classes5.dex */
            public class a implements OnErrClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                a() {
                }

                @Override // cn.damai.tetris.v2.componentplugin.OnErrClickListener
                public void onClick() {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1460791205")) {
                        ipChange.ipc$dispatch("-1460791205", new Object[]{this});
                    } else {
                        ComponentFragment.this.load(true);
                    }
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-544800596")) {
                    ipChange2.ipc$dispatch("-544800596", new Object[]{this, str, str2});
                    return;
                }
                if (z) {
                    ComponentFragment.this.stopProgressDialog();
                }
                ComponentFragment.this.refreshFinish();
                ComponentFragment.this.showErrorViewV2(str, str2, new a());
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1003573266")) {
                    ipChange2.ipc$dispatch("1003573266", new Object[]{this, baseResponse});
                    return;
                }
                if (z) {
                    ComponentFragment.this.stopProgressDialog();
                }
                ComponentFragment.this.hideErrorViewV2();
                ComponentFragment.this.refreshFinish();
                if (pg.b(baseResponse)) {
                    CategoryItemListInfo a2 = pg.a(baseResponse);
                    if (a2.isCanRequestNextPage(true, 1)) {
                        ComponentFragment.this.loadMoreResetV2(true);
                    } else if (a2.hasListSize()) {
                        ComponentFragment.this.showNoMoreV2();
                    } else {
                        ComponentFragment.this.showNoMoreV2("没有找到相关演出，换个筛选条件试试吧");
                    }
                }
                ComponentFragment.this.setData(baseResponse);
                ComponentFragment.this.updateB(baseResponse);
            }
        });
    }

    private void setContainerArg() {
        Bundle extras;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-235697657")) {
            ipChange.ipc$dispatch("-235697657", new Object[]{this});
            return;
        }
        FragmentActivity activity = getActivity();
        String str = "dm_perform_all_page";
        String str2 = "1.0";
        String str3 = null;
        if (activity != null && (extras = activity.getIntent().getExtras()) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(DMNav.KRequestCodeReferrer);
            arrayList.add("referrer");
            arrayList.add("title");
            Set<String> keySet = extras.keySet();
            JSONObject jSONObject = new JSONObject();
            for (String str4 : keySet) {
                if (TextUtils.equals("patternName", str4)) {
                    str = extras.getString(str4);
                } else if (TextUtils.equals("patternVersion", str4)) {
                    str2 = extras.getString(str4);
                } else if (!arrayList.contains(str4)) {
                    Object obj = extras.get(str4);
                    if (obj instanceof String) {
                        jSONObject.put(str4, obj);
                    } else if (obj instanceof Number) {
                        jSONObject.put(str4, (Object) obj.toString());
                    }
                }
            }
            if (!jSONObject.containsKey("sortType")) {
                jSONObject.put("sortType", (Object) "10");
            }
            str3 = jSONObject.toJSONString();
        }
        this.mArg = new ContainerArg(str, str2, str3);
        if (getPageContainer() != null) {
            getPageContainer().setContainerArg(this.mArg);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624756256")) {
            ipChange.ipc$dispatch("-624756256", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794109129")) {
            ipChange.ipc$dispatch("1794109129", new Object[]{this, Integer.valueOf(i), obj});
            return;
        }
        OnWantSeeListener onWantSeeListener = this.mWantSeeListener;
        if (onWantSeeListener != null && i == 24 && (obj instanceof FollowDataBean)) {
            onWantSeeListener.onWantSeeClick((FollowDataBean) obj);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417996222")) {
            ipChange.ipc$dispatch("-417996222", new Object[]{this});
        } else {
            load(false);
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1934764764")) {
            ipChange.ipc$dispatch("1934764764", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        loadMoreResetV2(true);
        setContainerArg();
        enableDividerLine(false);
        disableRefresh();
        enableLoadMore();
        enableExtraListener();
        callLifeListener();
        load(true);
    }

    public void setLifeListener(OnCompFragmentListener onCompFragmentListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "319540470")) {
            ipChange.ipc$dispatch("319540470", new Object[]{this, onCompFragmentListener});
        } else {
            this.mLifeListener = onCompFragmentListener;
        }
    }

    public void setScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1549244016")) {
            ipChange.ipc$dispatch("-1549244016", new Object[]{this, onScrollListener});
        } else {
            this.mScrollListener = onScrollListener;
        }
    }

    public void setWantSeeListener(OnWantSeeListener onWantSeeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "857648635")) {
            ipChange.ipc$dispatch("857648635", new Object[]{this, onWantSeeListener});
        } else {
            this.mWantSeeListener = onWantSeeListener;
        }
    }
}
