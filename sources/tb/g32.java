package tb;

import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.core.mtop.GlobalConfig;
import cn.damai.tetris.v2.common.Node;
import cn.damai.tetris.v2.convertor.IConverter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class g32 implements IConverter<BaseResponse, BaseSection, GlobalConfig, List<Node>> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.tetris.v2.convertor.IConverter
    /* renamed from: a */
    public List<Node> convert(BaseResponse baseResponse, BaseSection baseSection, GlobalConfig globalConfig, C9039db c9039db) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-940266358")) {
            return (List) ipChange.ipc$dispatch("-940266358", new Object[]{this, baseResponse, baseSection, globalConfig, c9039db});
        }
        ArrayList arrayList = new ArrayList();
        Node n = c9039db.n(baseSection, globalConfig, baseSection.getItem());
        if (n != null) {
            arrayList.add(n);
        }
        return arrayList;
    }
}
