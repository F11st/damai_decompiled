package tb;

import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.vessel.base.ResultCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class yt0 implements IWebEventBridge {
    public static final String BRIDGE_TAG = "getComponentData";

    public yt0(com.alibaba.android.ultron.trade.presenter.a aVar) {
    }

    @Override // com.alibaba.android.ultron.vfw.web.IWebEventBridge
    public void onEvent(Map<String, Object> map, ResultCallback resultCallback, IDMComponent iDMComponent) {
        if (iDMComponent == null || resultCallback == null) {
            return;
        }
        resultCallback.invoke(iDMComponent.getFields());
    }
}
