package android.taobao.windvane.service;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class WVCoreEventFilter implements WVEventListener {
    protected void onCoreSwitch() {
    }

    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        WVEventResult wVEventResult = new WVEventResult(false);
        if (i == 3016) {
            onUCCorePrepared();
        } else if (i == 3017) {
            onCoreSwitch();
        }
        return wVEventResult;
    }

    protected void onUCCorePrepared() {
    }
}
