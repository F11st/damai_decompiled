package io.flutter.plugins.share;

import android.app.Activity;
import android.content.Context;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class SharePlugin implements FlutterPlugin, ActivityAware {
    private static final String CHANNEL = "plugins.flutter.io/share";
    private MethodCallHandler handler;
    private MethodChannel methodChannel;
    private Share share;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SharePlugin().setUpChannel(registrar.context(), registrar.activity(), registrar.messenger());
    }

    private void setUpChannel(Context context, Activity activity, BinaryMessenger binaryMessenger) {
        this.methodChannel = new MethodChannel(binaryMessenger, CHANNEL);
        Share share = new Share(context, activity);
        this.share = share;
        MethodCallHandler methodCallHandler = new MethodCallHandler(share);
        this.handler = methodCallHandler;
        this.methodChannel.setMethodCallHandler(methodCallHandler);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.share.setActivity(activityPluginBinding.getActivity());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setUpChannel(flutterPluginBinding.getApplicationContext(), null, flutterPluginBinding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.share.setActivity(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.methodChannel.setMethodCallHandler(null);
        this.methodChannel = null;
        this.share = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
