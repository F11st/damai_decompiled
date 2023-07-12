package tb;

import com.taobao.power_image.dispatcher.PowerImageDispatcher;
import com.taobao.power_image.request.C6871a;
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
    /* renamed from: tb.ut1$b */
    /* loaded from: classes11.dex */
    public static class C9791b implements EventChannel.StreamHandler {
        private EventChannel.EventSink a;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* renamed from: tb.ut1$b$a */
        /* loaded from: classes11.dex */
        public static class C9792a {
            private static final C9791b a = new C9791b();
        }

        public static C9791b a() {
            return C9792a.a;
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

        private C9791b() {
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
        eventChannel.setStreamHandler(C9791b.a());
        C6871a.c().b(flutterPluginBinding.getTextureRegistry());
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
                result.success(C6871a.c().a(list));
                C6871a.c().e(list);
                return;
            }
            throw new IllegalArgumentException("startImageRequests require List arguments");
        } else if ("releaseImageRequests".equals(methodCall.method)) {
            Object obj2 = methodCall.arguments;
            if (obj2 instanceof List) {
                result.success(C6871a.c().d((List) obj2));
                return;
            }
            throw new IllegalArgumentException("stopImageRequests require List arguments");
        } else {
            result.notImplemented();
        }
    }
}
