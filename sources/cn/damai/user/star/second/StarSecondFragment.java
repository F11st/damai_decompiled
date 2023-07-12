package cn.damai.user.star.second;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.a;
import cn.damai.homepage.R$id;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.component.star.content.base.bean.ContentFreeRootBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.jn1;
import tb.l8;
import tb.m61;
import tb.xl2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarSecondFragment extends AbsFragmentV2 implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "StarSecondFragment";
    private boolean mCanLoadMore;
    private DrObj mDrObj;
    private ContentFreeRootBean mFreeBean;
    public a.b mUTBuilder;
    private ContentFreeRootBean mVipBean;
    ViewGroup navBar;
    ViewGroup parent;
    ScrollAlphaListener scrollAlphaListener;
    private String mArtistId = "";
    private String mFromType = "";
    private boolean mIsVisibleToUser = false;
    private int mPageNum = 1;
    private int mFreePageNum = 0;
    private DrObj mFreeDrObj = null;
    private int mVipPageNum = 0;
    private DrObj mVipDrObj = null;
    private boolean mIsFirstLoad = true;
    private String mLoadMoreType = "";
    private int REQ_CDOE_PUGLISH = 1001;

    private boolean canLoadMore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1011618833") ? ((Boolean) ipChange.ipc$dispatch("1011618833", new Object[]{this})).booleanValue() : this.mCanLoadMore;
    }

    private void doLoadMore() {
        ContentFreeRootBean contentFreeRootBean;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "635061388")) {
            ipChange.ipc$dispatch("635061388", new Object[]{this});
            return;
        }
        if (this.mIsVisibleToUser) {
            startProgressDialog();
        }
        DrObj drObj = null;
        if (this.mVipDrObj != null && (contentFreeRootBean = this.mVipBean) != null && contentFreeRootBean.getContents() != null && this.mVipBean.getContents().size() > 0) {
            this.mLoadMoreType = xl2.DM_BASE_CONTENT_VIP;
        }
        String str = this.mLoadMoreType;
        str.hashCode();
        if (str.equals(xl2.DM_BASE_CONTENT_FREE)) {
            i = this.mFreePageNum;
            drObj = this.mFreeDrObj;
        } else if (str.equals(xl2.DM_BASE_CONTENT_VIP)) {
            i = this.mVipPageNum;
            drObj = this.mVipDrObj;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(new StarSecondParams(this.mArtistId + "", this.mFromType + "", (i + 1) + ""));
        if (drObj != null) {
            drObj.targetArgs = tetrisRequest.args;
            tetrisRequest.dr = jn1.ARRAY_START_STR + JSON.toJSONString(drObj) + jn1.ARRAY_END_STR;
        }
        DMMtopRequestListener<BaseResponse> dMMtopRequestListener = new DMMtopRequestListener<BaseResponse>(BaseResponse.class) { // from class: cn.damai.user.star.second.StarSecondFragment.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "450713079")) {
                    ipChange2.ipc$dispatch("450713079", new Object[]{this, str2, str3});
                    return;
                }
                StarSecondFragment.this.stopProgressDialog();
                StarSecondFragment.this.refreshFinish();
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(BaseResponse baseResponse) {
                ArrayList<BaseLayer> arrayList;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-3255375")) {
                    ipChange2.ipc$dispatch("-3255375", new Object[]{this, baseResponse});
                    return;
                }
                StarSecondFragment.this.onResponseSuccess();
                StarSecondFragment.this.stopProgressDialog();
                StarSecondFragment.this.refreshFinish();
                StarSecondFragment.this.updateUT(baseResponse);
                if (baseResponse == null || (arrayList = baseResponse.layers) == null || arrayList.size() == 0) {
                    StarSecondFragment.this.onResponseError("", "", "");
                    return;
                }
                StarSecondFragment starSecondFragment = StarSecondFragment.this;
                BaseResponse fixRespData = starSecondFragment.fixRespData(baseResponse, starSecondFragment.mLoadMoreType);
                StarSecondFragment.this.handleResp(fixRespData);
                StarSecondFragment.this.updateLoadStatus();
                String str2 = StarSecondFragment.this.mLoadMoreType;
                str2.hashCode();
                if (!str2.equals(xl2.DM_BASE_CONTENT_FREE)) {
                    if (str2.equals(xl2.DM_BASE_CONTENT_VIP) && StarSecondFragment.this.mVipBean.getContents() != null && StarSecondFragment.this.mVipBean.getContents().size() > 0) {
                        StarSecondFragment starSecondFragment2 = StarSecondFragment.this;
                        starSecondFragment2.appendData(fixRespData, xl2.DM_BASE_CONTENT_VIP, starSecondFragment2.mVipPageNum, (JSONObject) JSON.toJSON(StarSecondFragment.this.mVipBean));
                    }
                } else if (StarSecondFragment.this.mFreeBean.getContents() == null || StarSecondFragment.this.mFreeBean.getContents().size() <= 0) {
                } else {
                    StarSecondFragment starSecondFragment3 = StarSecondFragment.this;
                    starSecondFragment3.appendData(fixRespData, xl2.DM_BASE_CONTENT_FREE, starSecondFragment3.mFreePageNum, (JSONObject) JSON.toJSON(StarSecondFragment.this.mFreeBean));
                }
            }
        };
        startProgressDialog();
        tetrisRequest.request(dMMtopRequestListener);
    }

    private void firstLoad() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086011262")) {
            ipChange.ipc$dispatch("-2086011262", new Object[]{this});
            return;
        }
        if (this.mIsVisibleToUser) {
            startProgressDialog();
        }
        TetrisRequest tetrisRequest = new TetrisRequest(new StarSecondParams(this.mArtistId + "", this.mFromType + "", "1"));
        DMMtopWarningListener<BaseResponse> dMMtopWarningListener = new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.user.star.second.StarSecondFragment.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-539707034")) {
                    ipChange2.ipc$dispatch("-539707034", new Object[]{this, str, str2});
                    return;
                }
                StarSecondFragment.this.stopProgressDialog();
                StarSecondFragment.this.refreshFinish();
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                ArrayList<BaseLayer> arrayList;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "213856792")) {
                    ipChange2.ipc$dispatch("213856792", new Object[]{this, baseResponse});
                    return;
                }
                StarSecondFragment.this.stopProgressDialog();
                StarSecondFragment.this.refreshFinish();
                StarSecondFragment.this.onResponseSuccess();
                StarSecondFragment.this.updateUT(baseResponse);
                if (baseResponse == null || (arrayList = baseResponse.layers) == null || arrayList.size() == 0) {
                    StarSecondFragment.this.onResponseError("", "", "");
                    return;
                }
                StarSecondFragment.this.handleResp(baseResponse);
                StarSecondFragment.this.updateLoadStatus();
                StarSecondFragment.this.setData(baseResponse);
                StarSecondFragment.this.mIsFirstLoad = false;
            }
        };
        startProgressDialog();
        tetrisRequest.request(dMMtopWarningListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseResponse fixRespData(BaseResponse baseResponse, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1989208387")) {
            return (BaseResponse) ipChange.ipc$dispatch("1989208387", new Object[]{this, baseResponse, str});
        }
        if (baseResponse != null) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            if (!cb2.d(arrayList)) {
                Iterator<BaseLayer> it = arrayList.iterator();
                while (it.hasNext()) {
                    List<BaseSection> sections = it.next().getSections();
                    if (!cb2.d(sections)) {
                        for (int i = 0; i < sections.size(); i++) {
                            if (!TextUtils.equals(sections.get(i).getComponentId(), str)) {
                                sections.remove(i);
                            }
                        }
                    }
                }
            }
        }
        return baseResponse;
    }

    private String fromType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-61443502") ? (String) ipChange.ipc$dispatch("-61443502", new Object[]{this}) : this.mFromType;
    }

    private static ContentFreeRootBean getBean(BaseResponse baseResponse, String str) {
        ArrayList<BaseLayer> arrayList;
        NodeData item;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1402082510")) {
            return (ContentFreeRootBean) ipChange.ipc$dispatch("1402082510", new Object[]{baseResponse, str});
        }
        if (baseResponse != null && (arrayList = baseResponse.layers) != null) {
            Iterator<BaseLayer> it = arrayList.iterator();
            while (it.hasNext()) {
                List<BaseSection> sections = it.next().getSections();
                if (!cb2.d(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (TextUtils.equals(str, baseSection.getComponentId()) && (item = baseSection.getItem()) != null) {
                            return (ContentFreeRootBean) m61.d(item, ContentFreeRootBean.class);
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResp(BaseResponse baseResponse) {
        ContentFreeRootBean contentFreeRootBean;
        ContentFreeRootBean contentFreeRootBean2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "692705701")) {
            ipChange.ipc$dispatch("692705701", new Object[]{this, baseResponse});
            return;
        }
        this.mFreeBean = getBean(baseResponse, xl2.DM_BASE_CONTENT_FREE);
        this.mFreeDrObj = getTetrisDr(baseResponse, xl2.DM_BASE_CONTENT_FREE);
        this.mVipBean = getBean(baseResponse, xl2.DM_BASE_CONTENT_VIP);
        this.mVipDrObj = getTetrisDr(baseResponse, xl2.DM_BASE_CONTENT_VIP);
        if (this.mIsFirstLoad) {
            ContentFreeRootBean contentFreeRootBean3 = this.mFreeBean;
            if (contentFreeRootBean3 != null && contentFreeRootBean3.getContents() != null && this.mFreeBean.getContents().size() > 0) {
                this.mFreePageNum = 1;
            }
            ContentFreeRootBean contentFreeRootBean4 = this.mVipBean;
            if (contentFreeRootBean4 != null && contentFreeRootBean4.getContents() != null && this.mVipBean.getContents().size() > 0) {
                this.mVipPageNum = 1;
            }
            if (this.mFreeDrObj != null) {
                Intent intent = new Intent();
                intent.putExtra(l8.KEY_ARTIST_ID, this.mArtistId);
                intent.putExtra("type", this.mFromType);
                intent.putExtra("DrObj", this.mFreeDrObj);
                getActivity().setIntent(intent);
                return;
            }
            return;
        }
        if (xl2.DM_BASE_CONTENT_FREE.equals(this.mLoadMoreType) && (contentFreeRootBean2 = this.mFreeBean) != null && contentFreeRootBean2.getContents() != null && this.mFreeBean.getContents().size() > 0) {
            this.mFreePageNum++;
        }
        if (!xl2.DM_BASE_CONTENT_VIP.equals(this.mLoadMoreType) || (contentFreeRootBean = this.mVipBean) == null || contentFreeRootBean.getContents() == null || this.mVipBean.getContents().size() <= 0) {
            return;
        }
        this.mVipPageNum++;
    }

    private static boolean hasNextPage(BaseResponse baseResponse) {
        ArrayList<BaseLayer> arrayList;
        NodeData item;
        Boolean bool;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-1141049781")) {
            return ((Boolean) ipChange.ipc$dispatch("-1141049781", new Object[]{baseResponse})).booleanValue();
        }
        if (baseResponse != null && (arrayList = baseResponse.layers) != null) {
            Iterator<BaseLayer> it = arrayList.iterator();
            while (it.hasNext()) {
                List<BaseSection> sections = it.next().getSections();
                if (!cb2.d(sections)) {
                    for (BaseSection baseSection : sections) {
                        if (TextUtils.equals(xl2.DISCOVER_FEED_V2_COMPONENT_ID, baseSection.getComponentId()) && (item = baseSection.getItem()) != null && (bool = item.getBoolean(xl2.HAS_NEXT)) != null) {
                            z = bool.booleanValue();
                        }
                    }
                }
            }
        }
        return z;
    }

    private boolean hasVipButton() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1839094209")) {
            return ((Boolean) ipChange.ipc$dispatch("1839094209", new Object[]{this})).booleanValue();
        }
        ContentFreeRootBean contentFreeRootBean = this.mVipBean;
        return (contentFreeRootBean == null || (contentFreeRootBean.getArtistVip() && this.mVipBean.getButton() == null)) ? false : true;
    }

    public static StarSecondFragment newInstance(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "23177585")) {
            return (StarSecondFragment) ipChange.ipc$dispatch("23177585", new Object[]{str, str2});
        }
        StarSecondFragment starSecondFragment = new StarSecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(l8.KEY_ARTIST_ID, str);
        bundle.putString("type", str2);
        starSecondFragment.setArguments(bundle);
        return starSecondFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadStatus() {
        ContentFreeRootBean contentFreeRootBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-957207087")) {
            ipChange.ipc$dispatch("-957207087", new Object[]{this});
            return;
        }
        this.mCanLoadMore = false;
        String fromType = fromType();
        fromType.hashCode();
        if (fromType.equals("1")) {
            ContentFreeRootBean contentFreeRootBean2 = this.mVipBean;
            if (contentFreeRootBean2 != null && contentFreeRootBean2.getHasNext()) {
                this.mCanLoadMore = true;
                this.mLoadMoreType = xl2.DM_BASE_CONTENT_VIP;
            }
        } else if (fromType.equals("2") && (contentFreeRootBean = this.mFreeBean) != null && contentFreeRootBean.getHasNext()) {
            this.mCanLoadMore = true;
            this.mLoadMoreType = xl2.DM_BASE_CONTENT_FREE;
        }
        if (this.mCanLoadMore) {
            enableRefresh();
            enableLoadMore();
            return;
        }
        disableLoadMore();
        disableRefresh();
        if (hasVipButton()) {
            return;
        }
        showNoMoreV2("只有这么多了(-.-)");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUT(BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222760405")) {
            ipChange.ipc$dispatch("1222760405", new Object[]{this, baseResponse});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(l8.KEY_ARTIST_ID, this.mArtistId + "");
        baseResponse.globalConfig.putBuzUTMap(hashMap);
        if (baseResponse.globalConfig != null) {
            this.mUTBuilder = new a.b().i(baseResponse.globalConfig.pageName);
        }
        updateB(baseResponse);
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1748165308")) {
            ipChange.ipc$dispatch("-1748165308", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == this.REQ_CDOE_PUGLISH) {
            onRefresh();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893253309")) {
            ipChange.ipc$dispatch("-893253309", new Object[]{this, view});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-998290307")) {
            ipChange.ipc$dispatch("-998290307", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mArtistId = getArguments().getString(l8.KEY_ARTIST_ID);
            this.mFromType = getArguments().getString("type");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1103394328")) {
            ipChange.ipc$dispatch("1103394328", new Object[]{this});
            return;
        }
        super.onDestroyView();
        this.scrollAlphaListener = null;
        this.mRecyclerView = null;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnLoadMoreListener
    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1606342886")) {
            ipChange.ipc$dispatch("-1606342886", new Object[]{this, view});
        } else if (canLoadMore()) {
            doLoadMore();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.tetris.core.msg.IMessage
    public void onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515519055")) {
            ipChange.ipc$dispatch("515519055", new Object[]{this, Integer.valueOf(i), obj});
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886964737")) {
            ipChange.ipc$dispatch("1886964737", new Object[]{this});
            return;
        }
        super.onPause();
        Log.d("onHiddenChanged", getId() + " : onPause: ");
        this.mIsVisibleToUser = false;
    }

    @Override // cn.damai.tetris.page.AbsFragment, cn.damai.uikit.irecycler.OnRefreshListener
    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675246204")) {
            ipChange.ipc$dispatch("675246204", new Object[]{this});
        } else {
            doLoadMore();
        }
    }

    @Override // cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "14151206")) {
            ipChange.ipc$dispatch("14151206", new Object[]{this});
            return;
        }
        super.onResume();
        Log.d("onHiddenChanged", getId() + " : onResume: ");
        this.mIsVisibleToUser = true;
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1836929174")) {
            ipChange.ipc$dispatch("1836929174", new Object[]{this, view, bundle});
            return;
        }
        super.onViewCreated(view, bundle);
        Log.d("xfxragment", getId() + " : onViewCreated: " + getArguments());
        this.parent = (ViewGroup) view;
        this.navBar = (ViewGroup) getActivity().findViewById(R$id.nav_bar);
        enableLoadMore();
        enableRefresh();
        firstLoad();
        this.mRecyclerView.scrollToPosition(0);
    }

    public void setScrollAlphaListener(ScrollAlphaListener scrollAlphaListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-396022941")) {
            ipChange.ipc$dispatch("-396022941", new Object[]{this, scrollAlphaListener});
        } else {
            this.scrollAlphaListener = scrollAlphaListener;
        }
    }

    @Override // cn.damai.tetris.page.AbsFragmentV2, cn.damai.tetris.page.AbsFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257280178")) {
            ipChange.ipc$dispatch("-257280178", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        Log.d("onHiddenChanged", getId() + " : setUserVisibleHint: " + z);
        this.mIsVisibleToUser = z;
    }
}
