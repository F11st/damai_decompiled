package com.idlefish.flutterboost;

import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Messages {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class FlutterRouterApi {
        private final BinaryMessenger a;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterRouterApi(BinaryMessenger binaryMessenger) {
            this.a = binaryMessenger;
        }

        public void A(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.sendEventToFlutter", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.af1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void s(final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onBackPressed", new StandardMessageCodec()).send(null, new BasicMessageChannel.Reply() { // from class: tb.we1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void t(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onBackground", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.ze1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void u(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onContainerHide", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.bf1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void v(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onContainerShow", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.ve1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void w(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onForeground", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.cf1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void x(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onNativeResult", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.xe1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void y(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.pushRoute", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.ue1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void z(C5772a c5772a, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.removeRoute", new StandardMessageCodec()).send(c5772a.k(), new BasicMessageChannel.Reply() { // from class: tb.ye1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface NativeRouterApi {
        C5773b getStackFromHost();

        void popRoute(C5772a c5772a, Result<Void> result);

        void pushFlutterRoute(C5772a c5772a);

        void pushNativeRoute(C5772a c5772a);

        void saveStackToHost(C5773b c5773b);

        void sendEventToNative(C5772a c5772a);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* compiled from: Taobao */
    /* renamed from: com.idlefish.flutterboost.Messages$a */
    /* loaded from: classes10.dex */
    public static class C5772a {
        private String a;
        private String b;
        private Map<Object, Object> c;
        private Boolean d;
        private String e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static C5772a a(Map<String, Object> map) {
            C5772a c5772a = new C5772a();
            c5772a.a = (String) map.get("pageName");
            c5772a.b = (String) map.get("uniqueId");
            c5772a.c = (Map) map.get("arguments");
            c5772a.d = (Boolean) map.get("opaque");
            c5772a.e = (String) map.get("key");
            return c5772a;
        }

        public Map<Object, Object> b() {
            return this.c;
        }

        public String c() {
            return this.e;
        }

        public Boolean d() {
            return this.d;
        }

        public String e() {
            return this.a;
        }

        public String f() {
            return this.b;
        }

        public void g(Map<Object, Object> map) {
            this.c = map;
        }

        public void h(String str) {
            this.e = str;
        }

        public void i(String str) {
            this.a = str;
        }

        public void j(String str) {
            this.b = str;
        }

        Map<String, Object> k() {
            HashMap hashMap = new HashMap();
            hashMap.put("pageName", this.a);
            hashMap.put("uniqueId", this.b);
            hashMap.put("arguments", this.c);
            hashMap.put("opaque", this.d);
            hashMap.put("key", this.e);
            return hashMap;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.idlefish.flutterboost.Messages$b */
    /* loaded from: classes10.dex */
    public static class C5773b {
        private List<Object> a;
        private Map<Object, Object> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static C5773b a(Map<String, Object> map) {
            C5773b c5773b = new C5773b();
            c5773b.a = (List) map.get("containers");
            c5773b.b = (Map) map.get("routes");
            return c5773b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<String, Object> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("containers", this.a);
            hashMap.put("routes", this.b);
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> b(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
