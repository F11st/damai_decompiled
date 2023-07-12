package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MouseCursorChannel {
    private static final String TAG = "MouseCursorChannel";
    @NonNull
    public final MethodChannel channel;
    @Nullable
    private MouseCursorMethodHandler mouseCursorMethodHandler;
    @NonNull
    private final MethodChannel.MethodCallHandler parsingMethodCallHandler;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface MouseCursorMethodHandler {
        void activateSystemCursor(@NonNull String str);
    }

    public MouseCursorChannel(@NonNull DartExecutor dartExecutor) {
        MethodChannel.MethodCallHandler methodCallHandler = new MethodChannel.MethodCallHandler() { // from class: io.flutter.embedding.engine.systemchannels.MouseCursorChannel.1
            /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
                return;
             */
            @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onMethodCall(@androidx.annotation.NonNull io.flutter.plugin.common.MethodCall r7, @androidx.annotation.NonNull io.flutter.plugin.common.MethodChannel.Result r8) {
                /*
                    r6 = this;
                    java.lang.String r0 = "error"
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel r1 = io.flutter.embedding.engine.systemchannels.MouseCursorChannel.this
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel$MouseCursorMethodHandler r1 = io.flutter.embedding.engine.systemchannels.MouseCursorChannel.access$000(r1)
                    if (r1 != 0) goto Lb
                    return
                Lb:
                    java.lang.String r1 = r7.method
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Received '"
                    r2.append(r3)
                    r2.append(r1)
                    java.lang.String r3 = "' message."
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    java.lang.String r3 = "MouseCursorChannel"
                    io.flutter.Log.v(r3, r2)
                    r2 = -1
                    r3 = 0
                    int r4 = r1.hashCode()     // Catch: java.lang.Exception -> L75
                    r5 = -1307105544(0xffffffffb21726f8, float:-8.798217E-9)
                    if (r4 == r5) goto L34
                    goto L3d
                L34:
                    java.lang.String r4 = "activateSystemCursor"
                    boolean r1 = r1.equals(r4)     // Catch: java.lang.Exception -> L75
                    if (r1 == 0) goto L3d
                    r2 = 0
                L3d:
                    if (r2 == 0) goto L40
                    goto L8e
                L40:
                    java.lang.Object r7 = r7.arguments     // Catch: java.lang.Exception -> L75
                    java.util.HashMap r7 = (java.util.HashMap) r7     // Catch: java.lang.Exception -> L75
                    java.lang.String r1 = "kind"
                    java.lang.Object r7 = r7.get(r1)     // Catch: java.lang.Exception -> L75
                    java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Exception -> L75
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel r1 = io.flutter.embedding.engine.systemchannels.MouseCursorChannel.this     // Catch: java.lang.Exception -> L5b
                    io.flutter.embedding.engine.systemchannels.MouseCursorChannel$MouseCursorMethodHandler r1 = io.flutter.embedding.engine.systemchannels.MouseCursorChannel.access$000(r1)     // Catch: java.lang.Exception -> L5b
                    r1.activateSystemCursor(r7)     // Catch: java.lang.Exception -> L5b
                    java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Exception -> L75
                    r8.success(r7)     // Catch: java.lang.Exception -> L75
                    goto L8e
                L5b:
                    r7 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L75
                    r1.<init>()     // Catch: java.lang.Exception -> L75
                    java.lang.String r2 = "Error when setting cursors: "
                    r1.append(r2)     // Catch: java.lang.Exception -> L75
                    java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Exception -> L75
                    r1.append(r7)     // Catch: java.lang.Exception -> L75
                    java.lang.String r7 = r1.toString()     // Catch: java.lang.Exception -> L75
                    r8.error(r0, r7, r3)     // Catch: java.lang.Exception -> L75
                    goto L8e
                L75:
                    r7 = move-exception
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "Unhandled error: "
                    r1.append(r2)
                    java.lang.String r7 = r7.getMessage()
                    r1.append(r7)
                    java.lang.String r7 = r1.toString()
                    r8.error(r0, r7, r3)
                L8e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.systemchannels.MouseCursorChannel.AnonymousClass1.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
            }
        };
        this.parsingMethodCallHandler = methodCallHandler;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(methodCallHandler);
    }

    public void setMethodHandler(@Nullable MouseCursorMethodHandler mouseCursorMethodHandler) {
        this.mouseCursorMethodHandler = mouseCursorMethodHandler;
    }

    @VisibleForTesting
    public void synthesizeMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        this.parsingMethodCallHandler.onMethodCall(methodCall, result);
    }
}
