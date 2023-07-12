package tb;

import android.app.Activity;
import android.text.TextUtils;
import com.alibaba.poplayer.layermanager.PopRequest;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.trigger.Event;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class t01<T extends BaseConfigItem> extends PopRequest {
    public T k;
    public Event l;

    public t01(int i, Event event, T t, Activity activity, PopRequest.PopRequestStatusCallBack popRequestStatusCallBack) {
        super(i, t.layerType, activity, popRequestStatusCallBack, t.priority, t.enqueue, t.forcePopRespectingPriority, t.exclusive);
        this.l = event;
        this.k = t;
    }

    public boolean equals(Object obj) {
        if (obj instanceof t01) {
            t01 t01Var = (t01) obj;
            return !TextUtils.isEmpty(this.k.uuid) && this.l.equals(t01Var.l) && this.k.uuid.equals(t01Var.k.uuid);
        }
        return super.equals(obj);
    }

    public T r() {
        return this.k;
    }

    public Event s() {
        return this.l;
    }
}
