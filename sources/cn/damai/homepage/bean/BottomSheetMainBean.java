package cn.damai.homepage.bean;

import cn.damai.commonbusiness.tab.BottomSheetBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import mtopsdk.mtop.domain.BaseOutDo;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class BottomSheetMainBean extends BaseOutDo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public BottomSheetBean data;

    @Override // mtopsdk.mtop.domain.BaseOutDo
    public BottomSheetBean getData() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-320272255") ? (BottomSheetBean) ipChange.ipc$dispatch("-320272255", new Object[]{this}) : this.data;
    }
}
