package tb;

import com.alibaba.poplayer.layermanager.PopRequest;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ft1 {
    public static void a(PopRequest popRequest, PopRequest.Status status) {
        if (popRequest == null || popRequest.i() == status) {
            return;
        }
        popRequest.q(status);
        PopRequest.PopRequestStatusCallBack j = popRequest.j();
        if (j == null) {
            return;
        }
        if (status == PopRequest.Status.READY) {
            j.onReady(popRequest);
        } else if (status == PopRequest.Status.SHOWING) {
            j.onRecovered(popRequest);
        } else if (status == PopRequest.Status.SUSPENDED) {
            j.onSuspended(popRequest);
        }
    }
}
