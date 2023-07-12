package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.util.Trace;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";
    private static final String TAG = "BasicMessageChannel#";
    @NonNull
    private final MessageCodec<T> codec;
    @NonNull
    private final BinaryMessenger messenger;
    @NonNull
    private final String name;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
        public void onMessage(@Nullable ByteBuffer byteBuffer, @NonNull final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.decodeMessage(byteBuffer), new Reply<T>() { // from class: io.flutter.plugin.common.BasicMessageChannel.IncomingMessageHandler.1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                    public void reply(T t) {
                        binaryReply.reply(BasicMessageChannel.this.encodeMessage(t));
                    }
                });
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message", e);
                binaryReply.reply(null);
            }
        }

        private IncomingMessageHandler(@NonNull MessageHandler<T> messageHandler) {
            this.handler = messageHandler;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.flutter.plugin.common.BinaryMessenger.BinaryReply
        public void reply(@Nullable ByteBuffer byteBuffer) {
            try {
                this.callback.reply(BasicMessageChannel.this.decodeMessage(byteBuffer));
            } catch (RuntimeException e) {
                Log.e(BasicMessageChannel.TAG + BasicMessageChannel.this.name, "Failed to handle message reply", e);
            }
        }

        private IncomingReplyHandler(@NonNull Reply<T> reply) {
            this.callback = reply;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface MessageHandler<T> {
        void onMessage(@Nullable T t, @NonNull Reply<T> reply);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Reply<T> {
        void reply(@Nullable T t);
    }

    public BasicMessageChannel(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @NonNull MessageCodec<T> messageCodec) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = messageCodec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public T decodeMessage(@Nullable ByteBuffer byteBuffer) {
        Trace.beginSection("decodeMessage @" + this.name);
        T decodeMessage = this.codec.decodeMessage(byteBuffer);
        Trace.endSection();
        return decodeMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ByteBuffer encodeMessage(@Nullable T t) {
        Trace.beginSection("encodeMessage @" + this.name);
        ByteBuffer encodeMessage = this.codec.encodeMessage(t);
        Trace.endSection();
        return encodeMessage;
    }

    public void resizeChannelBuffer(int i) {
        resizeChannelBuffer(this.messenger, this.name, i);
    }

    public void send(@Nullable T t) {
        send(t, null);
    }

    @UiThread
    public void setMessageHandler(@Nullable MessageHandler<T> messageHandler) {
        this.messenger.setMessageHandler(this.name, messageHandler != null ? new IncomingMessageHandler(messageHandler) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resizeChannelBuffer(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, int i) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", str, Integer.valueOf(i)).getBytes(Charset.forName("UTF-8"))));
    }

    @UiThread
    public void send(@Nullable T t, @Nullable Reply<T> reply) {
        this.messenger.send(this.name, encodeMessage(t), reply != null ? new IncomingReplyHandler(reply) : null);
    }
}
