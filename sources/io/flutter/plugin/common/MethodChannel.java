package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.util.Trace;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import tb.m80;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MethodChannel {
    private static final String TAG = "MethodChannel#";
    private final MethodCodec codec;
    private final BinaryMessenger messenger;
    private final String name;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MethodCallHandler handler;

        IncomingMethodCallHandler(MethodCallHandler methodCallHandler) {
            this.handler = methodCallHandler;
        }

        private String getStackTrace(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        @UiThread
        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMethodCall(MethodChannel.this.decodeMethodCall(byteBuffer), new Result() { // from class: io.flutter.plugin.common.MethodChannel.IncomingMethodCallHandler.1
                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void error(String str, String str2, Object obj) {
                        binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void notImplemented() {
                        binaryReply.reply(null);
                    }

                    @Override // io.flutter.plugin.common.MethodChannel.Result
                    public void success(Object obj) {
                        binaryReply.reply(MethodChannel.this.encodeSuccessEnvelope(obj));
                    }
                });
            } catch (RuntimeException e) {
                Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call", e);
                binaryReply.reply(MethodChannel.this.codec.encodeErrorEnvelopeWithStacktrace("error", e.getMessage(), null, getStackTrace(e)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        private final Result callback;

        IncomingResultHandler(Result result) {
            this.callback = result;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        @UiThread
        public void reply(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.callback.notImplemented();
                } else {
                    try {
                        this.callback.success(MethodChannel.this.decodeEnvelope(byteBuffer));
                    } catch (FlutterException e) {
                        this.callback.error(e.code, e.getMessage(), e.details);
                    }
                }
            } catch (RuntimeException e2) {
                Log.e(MethodChannel.TAG + MethodChannel.this.name, "Failed to handle method call result", e2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface MethodCallHandler {
        @UiThread
        void onMethodCall(@NonNull MethodCall methodCall, @NonNull Result result);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Result {
        @UiThread
        void error(String str, @Nullable String str2, @Nullable Object obj);

        @UiThread
        void notImplemented();

        @UiThread
        void success(@Nullable Object obj);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object decodeEnvelope(ByteBuffer byteBuffer) {
        Trace.beginSection("decodeEnvelope @" + this.name);
        Object decodeEnvelope = this.codec.decodeEnvelope(byteBuffer);
        Trace.endSection();
        return decodeEnvelope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MethodCall decodeMethodCall(ByteBuffer byteBuffer) {
        Trace.beginSection("decodeMethodCall @" + this.name);
        MethodCall decodeMethodCall = this.codec.decodeMethodCall(byteBuffer);
        Trace.endSection();
        return decodeMethodCall;
    }

    private ByteBuffer encodeMethodCall(MethodCall methodCall) {
        Trace.beginSection("encodeMethodCall " + methodCall.method + m80.DINAMIC_PREFIX_AT + this.name);
        ByteBuffer encodeMethodCall = this.codec.encodeMethodCall(methodCall);
        Trace.endSection();
        return encodeMethodCall;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ByteBuffer encodeSuccessEnvelope(Object obj) {
        Trace.beginSection("encodeSuccessEnvelope @" + this.name);
        ByteBuffer encodeSuccessEnvelope = this.codec.encodeSuccessEnvelope(obj);
        Trace.endSection();
        return encodeSuccessEnvelope;
    }

    @UiThread
    public void invokeMethod(@NonNull String str, @Nullable Object obj) {
        invokeMethod(str, obj, null);
    }

    public void resizeChannelBuffer(int i) {
        BasicMessageChannel.resizeChannelBuffer(this.messenger, this.name, i);
    }

    @UiThread
    public void setMethodCallHandler(@Nullable MethodCallHandler methodCallHandler) {
        this.messenger.setMessageHandler(this.name, methodCallHandler == null ? null : new IncomingMethodCallHandler(methodCallHandler));
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
    }

    @UiThread
    public void invokeMethod(String str, @Nullable Object obj, @Nullable Result result) {
        this.messenger.send(this.name, encodeMethodCall(new MethodCall(str, obj)), result == null ? null : new IncomingResultHandler(result));
    }
}
