package cn.damai.user.star;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.homepage.R$layout;
import cn.damai.message.observer.Action;
import cn.damai.player.DMVideoPlayer;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.star.bean.StarHeaderData;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.msg.Message;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.page.AbsFragment;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.user.star.second.StarSecondActivity;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.jw0;
import tb.oy2;
import tb.yr;
import tb.z6;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarIndexFragment extends AbsFragmentV2 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String Default_PAGE = "artist";
    public static final String INNER_PAGE = "ace_artist";
    public static final String TAG = "StarIndexFragment";
    Action action;
    public long id;
    public C0525a.C0527b mUTBuilder;
    ViewGroup navBar;
    ViewGroup parent;
    ScrollAlphaListener scrollAlphaListener;
    public int showType;
    StarScroller starScroller;
    DMVideoPlayer videoPlayer;
    private String pageB = Default_PAGE;
    public String type = "2";
    private int REQ_CDOE_PUGLISH = 1001;
    boolean visiableRefreshed = false;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.star.StarIndexFragment$a */
    /* loaded from: classes9.dex */
    public class C2705a implements Action<Object> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2705a() {
        }

        @Override // cn.damai.message.observer.Action
        public void call(Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2038981596")) {
                ipChange.ipc$dispatch("2038981596", new Object[]{this, obj});
            } else {
                StarIndexFragment.this.onRefresh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StarHeaderData getHeaderDat(BaseResponse baseResponse) {
        NodeData item;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-86568795")) {
            return (StarHeaderData) ipChange.ipc$dispatch("-86568795", new Object[]{this, baseResponse});
        }
        StarHeaderData starHeaderData = null;
        if (baseResponse != null && !oy2.a(baseResponse.layers)) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            for (int i = 0; i < arrayList.size(); i++) {
                List<BaseSection> sections = arrayList.get(i).getSections();
                if (!oy2.a(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (baseSection.getComponentId().startsWith("dm_artists_head_") && (item = baseSection.getItem()) != null) {
                            try {
                                starHeaderData = (StarHeaderData) JSON.parseObject(item.toJSONString(), StarHeaderData.class);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return starHeaderData;
    }

    private boolean getParam() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2027195550")) {
            return ((Boolean) ipChange.ipc$dispatch("2027195550", new Object[]{this})).booleanValue();
        }
        if (getArguments() == null) {
            return true;
        }
        try {
            this.id = Long.parseLong(getArguments().getString("id"));
            this.type = getArguments().getString("type", "2");
            this.showType = getArguments().getInt("showType");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static StarIndexFragment newInstance(String str, String str2, int i, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-866581228")) {
            return (StarIndexFragment) ipChange.ipc$dispatch("-866581228", new Object[]{str, str2, Integer.valueOf(i), str3});
        }
        Log.d(TAG, "newInstance : type=" + str2 + ", showType=" + i);
        StarIndexFragment starIndexFragment = new StarIndexFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        bundle.putString("type", str2);
        bundle.putInt("showType", i);
        starIndexFragment.setArguments(bundle);
        return starIndexFragment;
    }

    public RecyclerView getR() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-449302660") ? (RecyclerView) ipChange.ipc$dispatch("-449302660", new Object[]{this}) : this.mRecyclerView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423697982")) {
            ipChange.ipc$dispatch("-423697982", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281612570")) {
            return (View) ipChange.ipc$dispatch("-1281612570", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        Log.d("xfxragment", getId() + " : onCreateView: " + getArguments());
        if (getParam()) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R$layout.mine_starindex_fragment, viewGroup, false);
        viewGroup2.addView(super.onCreateView(layoutInflater, viewGroup2, bundle), 2);
        if (this.showType == 0) {
            this.pageB = Default_PAGE;
        } else {
            this.pageB = "ace_artist";
        }
        this.mUTBuilder = new C0525a.C0527b().i(this.pageB);
        this.action = new C2705a();
        yr.c().e(StarSecondActivity.FORCE_TAG, this.action);
        return viewGroup2;
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AttentionView attentionView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1276205214")) {
            ipChange.ipc$dispatch("1276205214", new Object[]{this});
            return;
        }
        this.scrollAlphaListener = null;
        this.videoPlayer = null;
        this.parent = null;
        this.mBottomView = null;
        this.visiableRefreshed = false;
        this.mRecyclerView.removeOnScrollListener(this.starScroller);
        StarScroller starScroller = this.starScroller;
        if (starScroller != null) {
            starScroller.a();
            this.starScroller = null;
        }
        if (getActivity() != null && (attentionView = (AttentionView) getActivity().findViewById(R$id.attent_view_star)) != null) {
            attentionView.cleanAttenList();
        }
        yr.c().a(StarSecondActivity.FORCE_TAG, this.action);
        super.onDestroy();
    }

    @Override // cn.damai.tetris.page.AbsFragment
    public void onFragmentResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217520354")) {
            ipChange.ipc$dispatch("217520354", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onFragmentResult(i, i2, intent);
        if (i == this.REQ_CDOE_PUGLISH) {
            onRefresh();
        } else if ((i == 1000 || i == 100) && i2 == -1) {
            onRefresh();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792079301")) {
            ipChange.ipc$dispatch("-1792079301", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        ScrollAlphaListener scrollAlphaListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786622222")) {
            ipChange.ipc$dispatch("786622222", new Object[]{this, Integer.valueOf(i), obj});
        } else if (i == 103 && obj != null && (obj instanceof StarHeaderData)) {
            jw0.a(getActivity(), (ViewGroup) this.parent.findViewById(cn.damai.homepage.R$id.user_call_follow), (StarHeaderData) obj, 2);
        } else if (i != 7001 || (scrollAlphaListener = this.scrollAlphaListener) == null) {
        } else {
            scrollAlphaListener.onAlphaChanged(0.0f);
            StarScroller starScroller = this.starScroller;
            if (starScroller != null) {
                starScroller.c();
            }
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1787411938")) {
            ipChange.ipc$dispatch("1787411938", new Object[]{this});
            return;
        }
        super.onPause();
        Log.d("onHiddenChanged", getId() + " : onPause: ");
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-505713123")) {
            ipChange.ipc$dispatch("-505713123", new Object[]{this});
        } else if (getUserVisibleHint()) {
            startProgressDialog();
            enableLoadMore();
            requestTetris();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222981733")) {
            ipChange.ipc$dispatch("1222981733", new Object[]{this});
            return;
        }
        super.onResume();
        Log.d("onHiddenChanged", getId() + " : onResume: ");
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839666441")) {
            ipChange.ipc$dispatch("-839666441", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        Log.d("xfxragment", getId() + " : onViewCreated: " + getArguments());
        this.parent = (ViewGroup) view;
        this.navBar = (ViewGroup) getActivity().findViewById(cn.damai.homepage.R$id.nav_bar);
        if (this.showType != 0 && !TextUtils.isEmpty(z6.a())) {
            z6.d(view.findViewById(cn.damai.homepage.R$id.starindex_layout_bg));
        }
        StarRequest starRequest = new StarRequest();
        String patternName = starRequest.getPatternName();
        String version = starRequest.getVersion();
        ContainerArg containerArg = new ContainerArg(patternName, version, "{\"artistId\":\"" + this.id + "\"}");
        IContainer pageContainer = getPageContainer();
        if (pageContainer != null) {
            pageContainer.setContainerArg(containerArg);
        }
        if (this.visiableRefreshed) {
            return;
        }
        onRefresh();
    }

    public void pageUtBuild() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790595353")) {
            ipChange.ipc$dispatch("1790595353", new Object[]{this});
        } else if (this.mUTBuilder != null) {
            C0529c.e().o(this, this.mUTBuilder);
        }
    }

    public void requestTetris() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "769096465")) {
            ipChange.ipc$dispatch("769096465", new Object[]{this});
            return;
        }
        StarRequest starRequest = new StarRequest();
        starRequest.artistId = this.id + "";
        TetrisRequest tetrisRequest = new TetrisRequest(starRequest);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.user.star.StarIndexFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.user.star.StarIndexFragment$2$a */
            /* loaded from: classes17.dex */
            public class View$OnClickListenerC2704a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                View$OnClickListenerC2704a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-2005447842")) {
                        ipChange.ipc$dispatch("-2005447842", new Object[]{this, view});
                    } else {
                        StarIndexFragment.this.sendMsg(new Message(AbsFragment.TETRIS_BIZ_CODE_SHARE, null));
                    }
                }
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1579954010")) {
                    ipChange2.ipc$dispatch("-1579954010", new Object[]{this, str, str2});
                    return;
                }
                StarIndexFragment.this.stopProgressDialog();
                StarIndexFragment.this.refreshFinish();
                StarIndexFragment.this.onResponseError(str, str2, "");
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "288584408")) {
                    ipChange2.ipc$dispatch("288584408", new Object[]{this, baseResponse});
                    return;
                }
                StarIndexFragment.this.stopProgressDialog();
                StarIndexFragment.this.refreshFinish();
                ScrollAlphaListener scrollAlphaListener = StarIndexFragment.this.scrollAlphaListener;
                if (scrollAlphaListener != null) {
                    scrollAlphaListener.onAlphaChanged(0.0f);
                    StarScroller starScroller = StarIndexFragment.this.starScroller;
                    if (starScroller != null) {
                        starScroller.c();
                    }
                }
                HashMap hashMap = new HashMap();
                hashMap.put("biz_id", StarIndexFragment.this.id + "");
                baseResponse.globalConfig.putBuzUTMap(hashMap);
                if (baseResponse.globalConfig != null) {
                    StarIndexFragment starIndexFragment = StarIndexFragment.this;
                    starIndexFragment.updateB(starIndexFragment.pageB, baseResponse.globalConfig);
                    GlobalConfig globalConfig = baseResponse.globalConfig;
                    if (globalConfig.extraInfo == null) {
                        globalConfig.extraInfo = new JSONObject();
                    }
                    baseResponse.globalConfig.extraInfo.put("showType", (Object) Integer.valueOf(StarIndexFragment.this.showType));
                }
                ArrayList<BaseLayer> arrayList = baseResponse.layers;
                if (arrayList == null || arrayList.size() == 0) {
                    StarIndexFragment.this.onResponseError("", "", "");
                    return;
                }
                StarIndexFragment.this.onResponseSuccess();
                StarIndexFragment.this.setData(baseResponse);
                ((AbsFragment) StarIndexFragment.this).mRecyclerView.postDelayed(new Runnable() { // from class: cn.damai.user.star.StarIndexFragment.2.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-598394637")) {
                            ipChange3.ipc$dispatch("-598394637", new Object[]{this});
                        } else {
                            StarIndexFragment.this.sendMsg(new Message(2000, ((AbsFragment) StarIndexFragment.this).mRecyclerView));
                        }
                    }
                }, 1000L);
                StarIndexFragment starIndexFragment2 = StarIndexFragment.this;
                starIndexFragment2.starScroller = new StarScroller(starIndexFragment2, starIndexFragment2.parent, starIndexFragment2.scrollAlphaListener, starIndexFragment2.getHeaderDat(baseResponse), StarIndexFragment.this.showType);
                ((AbsFragment) StarIndexFragment.this).mRecyclerView.addOnScrollListener(StarIndexFragment.this.starScroller);
                ViewGroup viewGroup = StarIndexFragment.this.navBar;
                if (viewGroup != null) {
                    viewGroup.findViewById(cn.damai.homepage.R$id.ll_share).setOnClickListener(new View$OnClickListenerC2704a());
                }
            }
        });
    }

    public void setScrollAlphaListener(ScrollAlphaListener scrollAlphaListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2014270012")) {
            ipChange.ipc$dispatch("-2014270012", new Object[]{this, scrollAlphaListener});
        } else {
            this.scrollAlphaListener = scrollAlphaListener;
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292001199")) {
            ipChange.ipc$dispatch("1292001199", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        Log.d("onHiddenChanged", getId() + " : setUserVisibleHint: " + z);
        if (z) {
            this.visiableRefreshed = true;
            getParam();
        }
        onRefresh();
    }
}
