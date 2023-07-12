package com.alibaba.pictures.bricks.component.project.tour;

import cn.damai.commonbusiness.search.bean.SearchTourBean;
import cn.damai.search.component.bean.SearchYouKuArchTourBean;
import cn.damai.tetris.component.drama.bean.ProjectShowBean;
import com.alibaba.pictures.bricks.component.project.bean.SearchYouKuHelper;
import com.alibaba.pictures.bricks.component.project.tour.TourContract;
import com.alibaba.pictures.bricks.onearch.AbsModel;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.item.GenericItem;
import org.jetbrains.annotations.NotNull;
import tb.n91;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TourModel extends AbsModel<IItem<ItemValue>, Object> implements TourContract.Model<IItem<ItemValue>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private long nativeDiffTime = 0;
    private long serverTime = 0;
    private SearchTourBean tourBean;

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Model
    public long getNativeDiffTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "889593604") ? ((Long) ipChange.ipc$dispatch("889593604", new Object[]{this})).longValue() : this.nativeDiffTime;
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Model
    public long getServerTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1038735517") ? ((Long) ipChange.ipc$dispatch("1038735517", new Object[]{this})).longValue() : this.serverTime;
    }

    @Override // com.alibaba.pictures.bricks.component.project.tour.TourContract.Model
    public SearchTourBean getTourBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1652579779") ? (SearchTourBean) ipChange.ipc$dispatch("1652579779", new Object[]{this}) : this.tourBean;
    }

    @Override // com.alient.onearch.adapter.view.AbsModel
    public void parseModelImpl(@NotNull IItem<ItemValue> iItem) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1363106067")) {
            ipChange.ipc$dispatch("-1363106067", new Object[]{this, iItem});
            return;
        }
        try {
            SearchYouKuArchTourBean searchYouKuArchTourBean = (SearchYouKuArchTourBean) iItem.getProperty().getData().toJavaObject(SearchYouKuArchTourBean.class);
            if (searchYouKuArchTourBean != null && searchYouKuArchTourBean.topItem == null && n91.a(searchYouKuArchTourBean.items) == 0) {
                return;
            }
            if (((GenericItem) iItem).getRawNode().getParent() != null && ((GenericItem) iItem).getRawNode().getParent().getData() != null) {
                if (((GenericItem) iItem).getRawNode().getParent().getData().containsKey("nativeDiffTime")) {
                    this.nativeDiffTime = ((Long) ((GenericItem) iItem).getRawNode().getParent().getData().get("nativeDiffTime")).longValue();
                }
                if (((GenericItem) iItem).getRawNode().getParent().getData().containsKey(ProjectShowBean.SERVER_TIME)) {
                    this.serverTime = ((Long) ((GenericItem) iItem).getRawNode().getParent().getData().get(ProjectShowBean.SERVER_TIME)).longValue();
                }
            }
            SearchTourBean searchTourBean = new SearchTourBean();
            this.tourBean = searchTourBean;
            searchTourBean.title = searchYouKuArchTourBean.title;
            searchTourBean.items = searchYouKuArchTourBean.items;
            searchTourBean.topItem = SearchYouKuHelper.parseOneProductInner(searchYouKuArchTourBean.topItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
