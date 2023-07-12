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

        public void A(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.sendEventToFlutter", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.af1
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

        public void t(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onBackground", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.ze1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void u(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onContainerHide", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.bf1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void v(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onContainerShow", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.ve1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void w(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onForeground", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.cf1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void x(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.onNativeResult", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.xe1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void y(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.pushRoute", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.ue1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    Messages.FlutterRouterApi.Reply.this.reply(null);
                }
            });
        }

        public void z(a aVar, final Reply<Void> reply) {
            new BasicMessageChannel(this.a, "dev.flutter.pigeon.FlutterRouterApi.removeRoute", new StandardMessageCodec()).send(aVar.k(), new BasicMessageChannel.Reply() { // from class: tb.ye1
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
        b getStackFromHost();

        void popRoute(a aVar, Result<Void> result);

        void pushFlutterRoute(a aVar);

        void pushNativeRoute(a aVar);

        void saveStackToHost(b bVar);

        void sendEventToNative(a aVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface Result<T> {
        void success(T t);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private String a;
        private String b;
        private Map<Object, Object> c;
        private Boolean d;
        private String e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(Map<String, Object> map) {
            a aVar = new a();
            aVar.a = (String) map.get("pageName");
            aVar.b = (String) map.get("uniqueId");
            aVar.c = (Map) map.get("arguments");
            aVar.d = (Boolean) map.get("opaque");
            aVar.e = (String) map.get("key");
            return aVar;
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
    /* loaded from: classes10.dex */
    public static class b {
        private List<Object> a;
        private Map<Object, Object> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Map<String, Object> map) {
            b bVar = new b();
            bVar.a = (List) map.get("containers");
            bVar.b = (Map) map.get("routes");
            return bVar;
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
