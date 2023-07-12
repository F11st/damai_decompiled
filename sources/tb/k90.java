package tb;

import android.view.View;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import com.taobao.android.dinamicx.AbstractC6362a;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class k90 extends AbstractC6362a {
    public static final String DISPATCHER_TAG = "handleDinamicXEvent";

    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void handleEvent(hy hyVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        ay2 ay2Var;
        OnDynamicEventListener onDynamicEventListener;
        ArrayList arrayList;
        vt2.b("DinamicXEventDispatcherV3", "handleEvent", String.valueOf(objArr));
        if (dXRuntimeContext == null || dXRuntimeContext.getDxUserContext() == null) {
            return;
        }
        Object dxUserContext = dXRuntimeContext.getDxUserContext();
        if (!(dxUserContext instanceof Map) || (ay2Var = (ay2) ((Map) dxUserContext).get(ay2.KEY_VIEW_ENGINE)) == null || (onDynamicEventListener = (OnDynamicEventListener) ay2Var.getService(OnDynamicEventListener.class)) == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        View nativeView = dXRuntimeContext.getNativeView();
        if (nativeView != null) {
            Object tag = nativeView.getTag(ny2.DINAMICX_3_CUSTOM_INPUT_KEY);
            if (tag instanceof ArrayList) {
                arrayList = (ArrayList) tag;
                onDynamicEventListener.onReceiveEvent(dXRuntimeContext.getRootView(), "", objArr, null, dxUserContext, arrayList);
            }
        }
        arrayList = arrayList2;
        onDynamicEventListener.onReceiveEvent(dXRuntimeContext.getRootView(), "", objArr, null, dxUserContext, arrayList);
    }
}
