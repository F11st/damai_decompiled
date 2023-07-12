package tb;

import android.content.Context;
import android.view.WindowManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rw0 implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static long d = -1;
    private final PluginRegistry.Registrar a = null;
    private Context b;
    private MethodChannel c;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "high_available");
        this.c = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.b = flutterPluginBinding.getApplicationContext();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.c.setMethodCallHandler(null);
        this.b = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        WindowManager windowManager;
        PluginRegistry.Registrar registrar;
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("getStartTime")) {
            result.success(String.valueOf(d));
            d = -1L;
        } else if (!str.equals("getRefreshRate")) {
            result.notImplemented();
        } else {
            float f = 60.0f;
            Context context = this.b;
            if (context == null && (registrar = this.a) != null && registrar.activeContext() != null) {
                context = this.a.activeContext();
            }
            if (context != null && (windowManager = (WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)) != null) {
                f = windowManager.getDefaultDisplay().getRefreshRate();
            }
            result.success(Float.valueOf(f));
        }
    }
}
