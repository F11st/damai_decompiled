package tb;

import com.alibaba.android.ultron.trade.presenter.AbstractC3258a;
import com.alibaba.android.ultron.vfw.web.IWebEventBridge;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.vessel.base.ResultCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class vj implements IWebEventBridge {
    public static final String BRIDGE_TAG = "closePopup";
    AbstractC3258a a;

    public vj(AbstractC3258a abstractC3258a) {
        this.a = abstractC3258a;
    }

    @Override // com.alibaba.android.ultron.vfw.web.IWebEventBridge
    public void onEvent(Map<String, Object> map, ResultCallback resultCallback, IDMComponent iDMComponent) {
        this.a.getViewManager().closePopupWindow(false);
    }
}
