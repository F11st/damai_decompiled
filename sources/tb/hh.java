package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.musicfestival.bean.FeedInfo;
import cn.damai.tetris.component.drama.bean.CardTitleBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.v2.convertor.ChainPreProcess;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class hh implements ChainPreProcess {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ChainPreProcess
    public void process(@NonNull BaseResponse baseResponse) {
        Boolean bool;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "555811360")) {
            ipChange.ipc$dispatch("555811360", new Object[]{this, baseResponse});
            return;
        }
        ArrayList<BaseLayer> arrayList = baseResponse.layers;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<BaseLayer> it = arrayList.iterator();
        while (it.hasNext()) {
            BaseLayer next = it.next();
            List<BaseSection> sections = next.getSections();
            if (sections != null && sections.size() > 0) {
                int size = sections.size();
                BaseSection baseSection = null;
                int i = -1;
                for (int i2 = 0; i2 < size; i2++) {
                    BaseSection baseSection2 = sections.get(i2);
                    if (baseSection2 != null && (TextUtils.equals(xl2.DISCOVER_FEED_V2_COMPONENT_ID, baseSection2.getComponentId()) || TextUtils.equals(xl2.CIRCLE_FEED_COMPONENT_ID, baseSection2.getComponentId()))) {
                        i = i2;
                        baseSection = baseSection2;
                        break;
                    }
                }
                if (baseSection != null) {
                    NodeData item = baseSection.getItem();
                    boolean booleanValue = (item == null || (bool = item.getBoolean(xl2.HAS_NEXT)) == null) ? false : bool.booleanValue();
                    String layerId = next.getLayerId();
                    CardTitleBean fromTetrisStyle = CardTitleBean.fromTetrisStyle(baseSection.getStyle());
                    FeedInfo feedInfo = new FeedInfo();
                    feedInfo.hasNext = booleanValue;
                    feedInfo.targetLayerId = layerId;
                    feedInfo.targetSectionId = baseSection.getSectionId();
                    feedInfo.feedTitle = fromTetrisStyle.title;
                    sections.add(i, BaseSection.obj2Section(xl2.DISCOVER_FEED_V2_COMPONENT_PLUGIN_ID, JSON.parseObject(JSON.toJSONString(feedInfo)), baseSection.getTrackInfo()));
                }
            }
        }
    }
}
