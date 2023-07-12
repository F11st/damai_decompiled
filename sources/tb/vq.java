package tb;

import android.util.Log;
import androidx.annotation.NonNull;
import cn.damai.fluttercommon.DMBaseFlutterActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public abstract class vq implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    private static transient /* synthetic */ IpChange $ipChange;
    private MethodChannel a;
    private DMBaseFlutterActivity b;

    protected abstract String a();

    public DMBaseFlutterActivity b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1703900377") ? (DMBaseFlutterActivity) ipChange.ipc$dispatch("1703900377", new Object[]{this}) : this.b;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1929168882")) {
            ipChange.ipc$dispatch("1929168882", new Object[]{this, activityPluginBinding});
            return;
        }
        Log.d("FlutterPlugin", "DMBasePlugin.onAttachedToActivity/in activity:" + activityPluginBinding.getActivity());
        if (activityPluginBinding.getActivity() instanceof DMBaseFlutterActivity) {
            this.b = (DMBaseFlutterActivity) activityPluginBinding.getActivity();
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1391058647")) {
            ipChange.ipc$dispatch("1391058647", new Object[]{this, flutterPluginBinding});
            return;
        }
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), a());
        this.a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-569710895")) {
            ipChange.ipc$dispatch("-569710895", new Object[]{this});
            return;
        }
        Log.d("FlutterPlugin", "DMBasePlugin.onDetachedFromActivity/in activity:");
        this.b = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-887403303")) {
            ipChange.ipc$dispatch("-887403303", new Object[]{this});
        } else {
            this.b = null;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-41978950")) {
            ipChange.ipc$dispatch("-41978950", new Object[]{this, flutterPluginBinding});
            return;
        }
        this.a.setMethodCallHandler(null);
        this.a = null;
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163065923")) {
            ipChange.ipc$dispatch("-163065923", new Object[]{this, methodCall, result});
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681176729")) {
            ipChange.ipc$dispatch("-681176729", new Object[]{this, activityPluginBinding});
        } else {
            onAttachedToActivity(activityPluginBinding);
        }
    }
}
