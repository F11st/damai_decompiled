package tb;

import android.view.View;
import com.alibaba.android.ultron.vfw.event.OnDynamicEventListener;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class j90 extends w0 {
    public static final String DISPATCHER_TAG = "handleDinamicXEvent";

    @Override // com.taobao.android.dinamic.dinamic.DinamicEventHandler
    public void handleEvent(View view, String str, Object obj, Object obj2, Object obj3, ArrayList arrayList) {
        ay2 ay2Var;
        OnDynamicEventListener onDynamicEventListener;
        if (!(obj3 instanceof Map) || (ay2Var = (ay2) ((Map) obj3).get(ay2.KEY_VIEW_ENGINE)) == null || (onDynamicEventListener = (OnDynamicEventListener) ay2Var.getService(OnDynamicEventListener.class)) == null) {
            return;
        }
        onDynamicEventListener.onReceiveEvent(view, str, obj, obj2, obj3, arrayList);
    }
}
