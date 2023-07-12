package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RestorationChannel {
    private static final String TAG = "RestorationChannel";
    private MethodChannel channel;
    private boolean engineHasProvidedData;
    private boolean frameworkHasRequestedData;
    private final MethodChannel.MethodCallHandler handler;
    private MethodChannel.Result pendingFrameworkRestorationChannelRequest;
    private byte[] restorationData;
    public final boolean waitForRestorationData;

    public RestorationChannel(@NonNull DartExecutor dartExecutor, @NonNull boolean z) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> packageData(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(ConfigManager.q, Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void clearData() {
        this.restorationData = null;
    }

    public byte[] getRestorationData() {
        return this.restorationData;
    }

    public void setRestorationData(final byte[] bArr) {
        this.engineHasProvidedData = true;
        MethodChannel.Result result = this.pendingFrameworkRestorationChannelRequest;
        if (result != null) {
            result.success(packageData(bArr));
            this.pendingFrameworkRestorationChannelRequest = null;
            this.restorationData = bArr;
        } else if (this.frameworkHasRequestedData) {
            this.channel.invokeMethod("push", packageData(bArr), new MethodChannel.Result() { // from class: io.flutter.embedding.engine.systemchannels.RestorationChannel.1
                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void error(String str, String str2, Object obj) {
                    Log.e(RestorationChannel.TAG, "Error " + str + " while sending restoration data to framework: " + str2);
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void notImplemented() {
                }

                @Override // io.flutter.plugin.common.MethodChannel.Result
                public void success(Object obj) {
                    RestorationChannel.this.restorationData = bArr;
                }
            });
        } else {
            this.restorationData = bArr;
        }
    }

    RestorationChannel(MethodChannel methodChannel, @NonNull boolean z) {
        this.engineHasProvidedData = false;
        this.frameworkHasRequestedData = false;
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.RestorationChannel.2
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                str.hashCode();
                if (!str.equals(gn1.TYPE_OPEN_URL_METHOD_GET)) {
                    if (str.equals("put")) {
                        RestorationChannel.this.restorationData = (byte[]) obj;
                        result.success(null);
                        return;
                    }
                    result.notImplemented();
                    return;
                }
                RestorationChannel.this.frameworkHasRequestedData = true;
                if (!RestorationChannel.this.engineHasProvidedData) {
                    RestorationChannel restorationChannel = RestorationChannel.this;
                    if (restorationChannel.waitForRestorationData) {
                        restorationChannel.pendingFrameworkRestorationChannelRequest = result;
                        return;
                    }
                }
                RestorationChannel restorationChannel2 = RestorationChannel.this;
                result.success(restorationChannel2.packageData(restorationChannel2.restorationData));
            }
        };
        this.handler = methodCallHandler;
        this.channel = methodChannel;
        this.waitForRestorationData = z;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }
}
