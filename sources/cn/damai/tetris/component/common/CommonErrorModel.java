package cn.damai.tetris.component.common;

import cn.damai.tetris.component.common.CommonErrorContract;
import cn.damai.tetris.core.AbsModel;
import cn.damai.tetris.core.BaseNode;
import cn.damai.tetris.core.NodeData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class CommonErrorModel extends AbsModel implements CommonErrorContract.Model {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MSG = "errorMsg";
    String code;
    String message;

    @Override // cn.damai.tetris.component.common.CommonErrorContract.Model
    public String getCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-868688871") ? (String) ipChange.ipc$dispatch("-868688871", new Object[]{this}) : this.code;
    }

    @Override // cn.damai.tetris.component.common.CommonErrorContract.Model
    public String getMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2081162805") ? (String) ipChange.ipc$dispatch("-2081162805", new Object[]{this}) : this.message;
    }

    @Override // cn.damai.tetris.core.AbsModel
    public void parseModel(BaseNode baseNode) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1572949009")) {
            ipChange.ipc$dispatch("-1572949009", new Object[]{this, baseNode});
            return;
        }
        NodeData item = baseNode.getItem();
        if (item.get("errorMsg") != null) {
            this.message = item.getString("errorMsg");
        }
        if (item.get("errorCode") != null) {
            this.code = item.getString("errorCode");
        }
    }
}
