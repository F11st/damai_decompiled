package tb;

import com.taobao.power_image.dispatcher.PowerImageDispatcher;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ut1 implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel a;
    private EventChannel b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements EventChannel.StreamHandler {
        private EventChannel.EventSink a;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public static class a {
            private static final b a = new b();
        }

        public static b a() {
            return a.a;
        }

        public void b(Map<String, Object> map, boolean z) {
            if (this.a == null || map == null) {
                return;
            }
            map.put("eventName", "onReceiveImageEvent");
            map.put("success", Boolean.valueOf(z));
            this.a.success(map);
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onCancel(Object obj) {
            this.a = null;
        }

        @Override // io.flutter.plugin.common.EventChannel.StreamHandler
        public void onListen(Object obj, EventChannel.EventSink eventSink) {
            this.a = eventSink;
        }

        private b() {
        }
    }

    static {
        System.loadLibrary("powerimage");
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "power_image/method");
        this.a = methodChannel;
        methodChannel.setMethodCallHandler(this);
        EventChannel eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "power_image/event");
        this.b = eventChannel;
        eventChannel.setStreamHandler(b.a());
        com.taobao.power_image.request.a.c().b(flutterPluginBinding.getTextureRegistry());
        PowerImageDispatcher.c().d();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.a.setMethodCallHandler(null);
        this.b.setStreamHandler(null);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if ("startImageRequests".equals(methodCall.method)) {
            Object obj = methodCall.arguments;
            if (obj instanceof List) {
                List<Map<String, Object>> list = (List) obj;
                result.success(com.taobao.power_image.request.a.c().a(list));
                com.taobao.power_image.request.a.c().e(list);
                return;
            }
            throw new IllegalArgumentException("startImageRequests require List arguments");
        } else if ("releaseImageRequests".equals(methodCall.method)) {
            Object obj2 = methodCall.arguments;
            if (obj2 instanceof List) {
                result.success(com.taobao.power_image.request.a.c().d((List) obj2));
                return;
            }
            throw new IllegalArgumentException("stopImageRequests require List arguments");
        } else {
            result.notImplemented();
        }
    }
}
