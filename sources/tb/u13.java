package tb;

import android.content.Context;
import android.taobao.windvane.connect.api.ApiConstants;
import android.util.Log;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.efs.sdk.base.EfsReporter;
import com.uc.webview.export.extension.UCCore;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class u13 implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private static PluginRegistry.Registrar d;
    private EfsReporter a;
    private Context b;
    private MethodChannel c;

    private Context a() {
        Context context = this.b;
        if (context != null) {
            return context;
        }
        PluginRegistry.Registrar registrar = d;
        if (registrar != null) {
            return registrar.activeContext();
        }
        return null;
    }

    public boolean b(String str, Object obj) {
        EfsReporter efsReporter = this.a;
        if (efsReporter == null) {
            return true;
        }
        Map<String, Object> b = efsReporter.b();
        Object obj2 = b.get(String.format("flu_%s_sampling_rate", str));
        double doubleValue = obj2 != null ? Double.valueOf(obj2.toString()).doubleValue() : 0.0d;
        Object obj3 = b.get(String.format("flu_%s_sampling_rate@%s", str, obj));
        double doubleValue2 = obj3 != null ? Double.valueOf(obj3.toString()).doubleValue() : 0.0d;
        double random = Math.random() * 100.0d;
        int i = (doubleValue2 > 0.0d ? 1 : (doubleValue2 == 0.0d ? 0 : -1));
        if (i == 0 || random >= doubleValue2) {
            int i2 = (doubleValue > 0.0d ? 1 : (doubleValue == 0.0d ? 0 : -1));
            if (i2 == 0 || i != 0 || random >= doubleValue) {
                return (i2 == 0 && i == 0) ? false : true;
            }
            return false;
        }
        return false;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "uc.flutter.io/appMonitor");
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
        if (methodCall.method.equals(UCCore.LEGACY_EVENT_INIT)) {
            Log.e("uc_flutter", "method : " + methodCall.method);
            String str = (String) methodCall.argument(ALBiometricsKeys.KEY_APP_ID);
            String str2 = (String) methodCall.argument(ApiConstants.APPSECRET);
            String str3 = (String) methodCall.argument("uid");
            Boolean bool = Boolean.TRUE;
            boolean equals = bool.equals(methodCall.argument("intl"));
            boolean equals2 = bool.equals(methodCall.argument("debug"));
            Context a = a();
            if (a != null) {
                this.a = new EfsReporter.Builder(a, str, str2).h(str3).d(equals2).g(equals2).f(equals).a();
                d = null;
            }
            result.success(null);
        } else if (methodCall.method.equals("wpkReport")) {
            String str4 = (String) methodCall.argument("logType");
            Map<String, Object> map = (Map) methodCall.argument("data");
            if (!b(str4, map.get("w_bid"))) {
                rd0 rd0Var = new rd0(str4);
                rd0Var.b(map);
                EfsReporter efsReporter = this.a;
                if (efsReporter != null) {
                    efsReporter.d(rd0Var);
                }
            }
            result.success(null);
        } else {
            result.notImplemented();
        }
    }
}
