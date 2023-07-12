package io.flutter.plugins.connectivity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class ConnectivityMethodChannelHandler implements MethodChannel.MethodCallHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Connectivity connectivity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectivityMethodChannelHandler(Connectivity connectivity) {
        this.connectivity = connectivity;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("check")) {
            result.notImplemented();
        } else {
            result.success(this.connectivity.getNetworkType());
        }
    }
}
