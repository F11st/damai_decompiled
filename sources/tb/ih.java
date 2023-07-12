package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.v2.convertor.ChainPreProcess;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ih implements ChainPreProcess {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.ChainPreProcess
    public void process(@NonNull BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1495235075")) {
            ipChange.ipc$dispatch("1495235075", new Object[]{this, baseResponse});
            return;
        }
        ArrayList<BaseLayer> arrayList = baseResponse.layers;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<BaseLayer> it = arrayList.iterator();
        while (it.hasNext()) {
            List<BaseSection> sections = it.next().getSections();
            BaseSection baseSection = null;
            if (sections != null && sections.size() > 0) {
                for (BaseSection baseSection2 : sections) {
                    if (baseSection2 != null && TextUtils.equals(xl2.DM_FLOATING_ANCHOR_POINT_BAR_CID, baseSection2.getComponentId())) {
                        baseSection = baseSection2;
                    }
                }
            }
            if (baseSection != null) {
                sections.remove(baseSection);
                sections.add(0, baseSection);
            }
        }
    }
}
