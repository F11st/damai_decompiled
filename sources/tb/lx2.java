package tb;

import android.text.TextUtils;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class lx2 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, db dbVar) {
        NodeData item;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-420435462")) {
            return (List) ipChange.ipc$dispatch("-420435462", new Object[]{this, baseResponse, baseSection, globalConfig, dbVar});
        }
        NodeData nodeData = null;
        if (baseResponse != null) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            if (!cb2.d(arrayList)) {
                Iterator<BaseLayer> it = arrayList.iterator();
                while (it.hasNext()) {
                    List<BaseSection> sections = it.next().getSections();
                    if (!cb2.d(sections)) {
                        for (BaseSection baseSection2 : sections) {
                            if (baseSection2 != null) {
                                String componentId = baseSection2.getComponentId();
                                if (TextUtils.equals(xl2.DRAMA_CALENDAR_VERTICAL_CID, componentId) && (item = baseSection2.getItem()) != null) {
                                    item.put("tabIndex", (Object) Integer.valueOf(i));
                                    item.put("isLastTab", (Object) Boolean.FALSE);
                                    nodeData = item;
                                }
                                if (!TextUtils.equals(xl2.DM_FLOATING_ANCHOR_POINT_BAR_CID, componentId)) {
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (nodeData != null) {
            nodeData.put("isLastTab", (Object) Boolean.TRUE);
        }
        return new g32().convert(baseResponse, baseSection, globalConfig, dbVar);
    }
}
