package io.flutter.plugins.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ConnectivityPlugin implements FlutterPlugin {
    private EventChannel eventChannel;
    private MethodChannel methodChannel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new ConnectivityPlugin().setupChannels(registrar.messenger(), registrar.context());
    }

    private void setupChannels(BinaryMessenger binaryMessenger, Context context) {
        this.methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.io/connectivity");
        this.eventChannel = new EventChannel(binaryMessenger, "plugins.flutter.io/connectivity_status");
        Connectivity connectivity = new Connectivity((ConnectivityManager) context.getSystemService("connectivity"));
        ConnectivityMethodChannelHandler connectivityMethodChannelHandler = new ConnectivityMethodChannelHandler(connectivity);
        ConnectivityBroadcastReceiver connectivityBroadcastReceiver = new ConnectivityBroadcastReceiver(context, connectivity);
        this.methodChannel.setMethodCallHandler(connectivityMethodChannelHandler);
        this.eventChannel.setStreamHandler(connectivityBroadcastReceiver);
    }

    private void teardownChannels() {
        this.methodChannel.setMethodCallHandler(null);
        this.eventChannel.setStreamHandler(null);
        this.methodChannel = null;
        this.eventChannel = null;
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        setupChannels(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        teardownChannels();
    }
}
