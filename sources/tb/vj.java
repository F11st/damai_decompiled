package tb;

import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.vessel.base.ResultCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class vj implements IWebEventBridge {
    public static final String BRIDGE_TAG = "closePopup";
    com.alibaba.android.ultron.trade.presenter.a a;

    public vj(com.alibaba.android.ultron.trade.presenter.a aVar) {
        this.a = aVar;
    }

    @Override // com.alibaba.android.ultron.vfw.web.IWebEventBridge
    public void onEvent(Map<String, Object> map, ResultCallback resultCallback, IDMComponent iDMComponent) {
        this.a.getViewManager().closePopupWindow(false);
    }
}
