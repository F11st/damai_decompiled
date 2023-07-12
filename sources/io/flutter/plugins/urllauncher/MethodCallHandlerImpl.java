package io.flutter.plugins.urllauncher;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.urllauncher.UrlLauncher;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private static final String TAG = "MethodCallHandlerImpl";
    @Nullable
    private MethodChannel channel;
    private final UrlLauncher urlLauncher;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodCallHandlerImpl(UrlLauncher urlLauncher) {
        this.urlLauncher = urlLauncher;
    }

    private static Bundle extractBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            bundle.putString(str, map.get(str));
        }
        return bundle;
    }

    private void onCanLaunch(MethodChannel.Result result, String str) {
        result.success(Boolean.valueOf(this.urlLauncher.canLaunch(str)));
    }

    private void onCloseWebView(MethodChannel.Result result) {
        this.urlLauncher.closeWebView();
        result.success(null);
    }

    private void onLaunch(MethodCall methodCall, MethodChannel.Result result, String str) {
        UrlLauncher.LaunchStatus launch = this.urlLauncher.launch(str, extractBundle((Map) methodCall.argument("headers")), ((Boolean) methodCall.argument("useWebView")).booleanValue(), ((Boolean) methodCall.argument("enableJavaScript")).booleanValue(), ((Boolean) methodCall.argument("enableDomStorage")).booleanValue());
        if (launch == UrlLauncher.LaunchStatus.NO_ACTIVITY) {
            result.error("NO_ACTIVITY", "Launching a URL requires a foreground activity.", null);
        } else if (launch == UrlLauncher.LaunchStatus.ACTIVITY_NOT_FOUND) {
            result.error("ACTIVITY_NOT_FOUND", String.format("No Activity found to handle intent { %s }", str), null);
        } else {
            result.success(Boolean.TRUE);
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("url");
        String str2 = methodCall.method;
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1109843021:
                if (str2.equals("launch")) {
                    c = 0;
                    break;
                }
                break;
            case -185306205:
                if (str2.equals("canLaunch")) {
                    c = 1;
                    break;
                }
                break;
            case -121617663:
                if (str2.equals("closeWebView")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                onLaunch(methodCall, result, str);
                return;
            case 1:
                onCanLaunch(result, str);
                return;
            case 2:
                onCloseWebView(result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListening(BinaryMessenger binaryMessenger) {
        if (this.channel != null) {
            Log.wtf(TAG, "Setting a method call handler before the last was disposed.");
            stopListening();
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/url_launcher");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListening() {
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Log.d(TAG, "Tried to stop listening when no MethodChannel had been initialized.");
            return;
        }
        methodChannel.setMethodCallHandler(null);
        this.channel = null;
    }
}
