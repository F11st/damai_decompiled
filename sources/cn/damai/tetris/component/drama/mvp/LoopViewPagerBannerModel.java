package cn.damai.tetris.component.drama.mvp;

import cn.damai.tetris.component.drama.bean.DynSizeBannerBean;
import cn.damai.tetris.component.drama.bean.XBannerBean;
import cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LoopViewPagerBannerModel extends AbsModel implements LoopViewPagerBannerContract.Model {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<XBannerBean> xBannerBeans;

    @Override // cn.damai.tetris.component.drama.mvp.LoopViewPagerBannerContract.Model
    public List<XBannerBean> getBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1049301400") ? (List) ipChange.ipc$dispatch("1049301400", new Object[]{this}) : this.xBannerBeans;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1882654522")) {
            ipChange.ipc$dispatch("1882654522", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item.get("banners") != null) {
            List<DynSizeBannerBean> parseArray = JSON.parseArray(item.getString("banners"), DynSizeBannerBean.class);
            this.xBannerBeans = new ArrayList();
            for (DynSizeBannerBean dynSizeBannerBean : parseArray) {
                XBannerBean xBannerBean = new XBannerBean();
                xBannerBean.cover = dynSizeBannerBean.pic;
                xBannerBean.jumpUrl = dynSizeBannerBean.url;
                xBannerBean.width = dynSizeBannerBean.width;
                xBannerBean.height = dynSizeBannerBean.height;
                this.xBannerBeans.add(xBannerBean);
            }
        } else if (item.get("result") != null) {
            this.xBannerBeans = JSON.parseArray(item.getString("result"), XBannerBean.class);
        }
    }
}
