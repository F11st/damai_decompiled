package com.idlefish.flutterboost;

import com.idlefish.flutterboost.C5782d;
import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.idlefish.flutterboost.d */
/* loaded from: classes10.dex */
public final /* synthetic */ class C5782d {
    public static /* synthetic */ void h(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        Map b;
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.pushNativeRoute(Messages.C5772a.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            b = Messages.b(e);
            hashMap.put("error", b);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void i(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        Map b;
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.pushFlutterRoute(Messages.C5772a.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            b = Messages.b(e);
            hashMap.put("error", b);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void j(Map map, BasicMessageChannel.Reply reply, Void r3) {
        map.put("result", null);
        reply.reply(map);
    }

    public static /* synthetic */ void k(Messages.NativeRouterApi nativeRouterApi, Object obj, final BasicMessageChannel.Reply reply) {
        Map b;
        final HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.popRoute(Messages.C5772a.a((Map) obj), new Messages.Result() { // from class: tb.df1
                @Override // com.idlefish.flutterboost.Messages.Result
                public final void success(Object obj2) {
                    C5782d.j(hashMap, reply, (Void) obj2);
                }
            });
        } catch (Error | RuntimeException e) {
            b = Messages.b(e);
            hashMap.put("error", b);
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void l(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        Map b;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", nativeRouterApi.getStackFromHost().b());
        } catch (Error | RuntimeException e) {
            b = Messages.b(e);
            hashMap.put("error", b);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void m(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        Map b;
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.saveStackToHost(Messages.C5773b.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            b = Messages.b(e);
            hashMap.put("error", b);
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void n(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        Map b;
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.sendEventToNative(Messages.C5772a.a((Map) obj));
            hashMap.put("result", null);
        } catch (Error | RuntimeException e) {
            b = Messages.b(e);
            hashMap.put("error", b);
        }
        reply.reply(hashMap);
    }

    public static void o(BinaryMessenger binaryMessenger, final Messages.NativeRouterApi nativeRouterApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushNativeRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: tb.gf1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    C5782d.h(Messages.NativeRouterApi.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushFlutterRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: tb.ef1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    C5782d.i(Messages.NativeRouterApi.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.popRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: tb.ff1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    C5782d.k(Messages.NativeRouterApi.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.getStackFromHost", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: tb.hf1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    C5782d.l(Messages.NativeRouterApi.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.saveStackToHost", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: tb.jf1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    C5782d.m(Messages.NativeRouterApi.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.sendEventToNative", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: tb.if1
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    C5782d.n(Messages.NativeRouterApi.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
    }
}
