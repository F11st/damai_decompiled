package cn.damai.tetris.componentplugin;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.musicfestival.bean.FeedInfo;
import cn.damai.musicfestival.model.MusicFestivalParams;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.DrObj;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import cn.damai.tetris.v2.componentplugin.ComponentPageUi;
import cn.damai.tetris.v2.componentplugin.ComponentPlugin;
import cn.damai.tetris.v2.structure.container.IContainer;
import cn.damai.tetris.v2.structure.layer.ILayer;
import cn.damai.tetris.v2.structure.section.ISection;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.db;
import tb.jn1;
import tb.m61;
import tb.xl2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DiscoverFeedPlugin extends ComponentPlugin {
    private static transient /* synthetic */ IpChange $ipChange;
    private ContainerArg mArg;
    private FeedInfo mInfo;
    private int pageIndex;

    public DiscoverFeedPlugin(ComponentPageUi componentPageUi) {
        super(componentPageUi);
        this.pageIndex = 2;
        IContainer pageContainer = componentPageUi.getPageContainer();
        if (pageContainer != null) {
            this.mArg = pageContainer.getContainerArg();
        }
    }

    static /* synthetic */ int access$008(DiscoverFeedPlugin discoverFeedPlugin) {
        int i = discoverFeedPlugin.pageIndex;
        discoverFeedPlugin.pageIndex = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isFeedHasNextPage(BaseResponse baseResponse) {
        ArrayList<BaseLayer> arrayList;
        NodeData item;
        Boolean bool;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "283807132")) {
            return ((Boolean) ipChange.ipc$dispatch("283807132", new Object[]{baseResponse})).booleanValue();
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

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1992213421")) {
            return ((Boolean) ipChange.ipc$dispatch("-1992213421", new Object[]{this})).booleanValue();
        }
        if (this.mInfo != null && this.mArg != null) {
            this.mComponentUi.showLoadMoreV2();
            TetrisRequest tetrisRequest = new TetrisRequest(new MusicFestivalParams(this.pageIndex, this.mArg));
            TetrisRequest.overrideParams(tetrisRequest, this.mArg);
            FeedInfo feedInfo = this.mInfo;
            if (feedInfo != null) {
                DrObj drObj = new DrObj(feedInfo.targetLayerId, feedInfo.targetSectionId, tetrisRequest.args);
                tetrisRequest.dr = jn1.ARRAY_START_STR + JSON.toJSONString(drObj) + jn1.ARRAY_END_STR;
            }
            tetrisRequest.request(new DMMtopRequestListener<BaseResponse>(BaseResponse.class) { // from class: cn.damai.tetris.componentplugin.DiscoverFeedPlugin.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1250880461")) {
                        ipChange2.ipc$dispatch("1250880461", new Object[]{this, str, str2});
                        return;
                    }
                    ((ComponentPlugin) DiscoverFeedPlugin.this).mComponentUi.loadMoreResetV2(true);
                    ToastUtil.i(str2);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(BaseResponse baseResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-598302437")) {
                        ipChange2.ipc$dispatch("-598302437", new Object[]{this, baseResponse});
                        return;
                    }
                    DiscoverFeedPlugin.access$008(DiscoverFeedPlugin.this);
                    if (DiscoverFeedPlugin.isFeedHasNextPage(baseResponse)) {
                        ((ComponentPlugin) DiscoverFeedPlugin.this).mComponentUi.loadMoreResetV2(true);
                    } else {
                        ((ComponentPlugin) DiscoverFeedPlugin.this).mComponentUi.showNoMoreV2();
                    }
                    IContainer pageContainer = ((ComponentPlugin) DiscoverFeedPlugin.this).mComponentUi.getPageContainer();
                    if (pageContainer != null) {
                        List<ILayer> layerList = pageContainer.getLayerList();
                        if (cb2.d(layerList)) {
                            return;
                        }
                        layerList.get(layerList.size() - 1).addSectionListEnd(new db().f(baseResponse), true);
                    }
                }
            });
        }
        return true;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onMessage(int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597299158")) {
            return ((Boolean) ipChange.ipc$dispatch("-597299158", new Object[]{this, Integer.valueOf(i), obj})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public boolean onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1102345207")) {
            return ((Boolean) ipChange.ipc$dispatch("-1102345207", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionBind(ISection iSection) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1478490441")) {
            ipChange.ipc$dispatch("1478490441", new Object[]{this, iSection});
            return;
        }
        JSONObject item = iSection.getItem();
        if (item != null) {
            FeedInfo feedInfo = (FeedInfo) m61.d(item, FeedInfo.class);
            this.mInfo = feedInfo;
            if (feedInfo != null) {
                z = feedInfo.hasNext;
            }
        }
        if (z) {
            this.mComponentUi.loadMoreResetV2(true);
        } else {
            this.mComponentUi.showNoMoreV2();
        }
    }

    @Override // cn.damai.tetris.v2.componentplugin.ComponentPlugin
    public void onSectionRemoved(@Nullable ISection iSection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-17961928")) {
            ipChange.ipc$dispatch("-17961928", new Object[]{this, iSection});
            return;
        }
        this.pageIndex = 2;
        this.mInfo = null;
    }
}
