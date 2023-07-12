package com.alibaba.motu.crashreporter2;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.lang.reflect.Field;
import java.nio.CharBuffer;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageMaker {
    protected static final Message EXCEPTION_MSG = new Message();
    private CharBuffer charBuffer = CharBuffer.allocate(1024);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class FieldUtils {
        static Field mMessagesField;

        static {
            try {
                Field declaredField = MessageQueue.class.getDeclaredField("mMessages");
                mMessagesField = declaredField;
                declaredField.setAccessible(true);
            } catch (Exception unused) {
            }
        }

        private FieldUtils() {
        }
    }

    private void createDetailMessageToCache(String str, long j, long j2, Message message) {
        this.charBuffer.append((CharSequence) String.valueOf(System.currentTimeMillis())).append((CharSequence) " ").append((CharSequence) String.valueOf(j));
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                this.charBuffer.append((CharSequence) " current:").append((CharSequence) str);
                this.charBuffer.append((CharSequence) " cpuTime:").append((CharSequence) String.valueOf(j2));
                this.charBuffer.append((CharSequence) " next:").append((CharSequence) message2String(message));
                return;
            } catch (Throwable unused) {
                this.charBuffer.append((CharSequence) ":").append((CharSequence) str).append((CharSequence) " next:exception");
                return;
            }
        }
        this.charBuffer.append((CharSequence) ":").append((CharSequence) str);
    }

    private String message2String(Message message) {
        if (message == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        if (message.getWhen() != 0) {
            sb.append("{ duration=");
            sb.append(message.getWhen() - SystemClock.uptimeMillis());
        } else {
            sb.append("{ duration=0");
        }
        sb.append(" when=");
        sb.append(message.getWhen());
        if (message.getTarget() != null) {
            if (message.getCallback() != null) {
                sb.append(" callback=");
                sb.append(message.getCallback().getClass().getName());
            } else {
                sb.append(" what=");
                sb.append(message.what);
            }
            if (message.arg1 != 0) {
                sb.append(" arg1=");
                sb.append(message.arg1);
            }
            if (message.arg2 != 0) {
                sb.append(" arg2=");
                sb.append(message.arg2);
            }
            sb.append(" target=");
            sb.append(message.getTarget().getClass().getName());
        } else {
            sb.append(" barrier=");
            sb.append(message.arg1);
        }
        sb.append(" }");
        return sb.toString();
    }

    public static Message nextMessage() {
        Field field = FieldUtils.mMessagesField;
        if (field == null) {
            return EXCEPTION_MSG;
        }
        Message message = EXCEPTION_MSG;
        try {
            return Build.VERSION.SDK_INT >= 23 ? (Message) field.get(Looper.getMainLooper().getQueue()) : message;
        } catch (Exception unused) {
            return message;
        }
    }

    public String createMessage(String str, long j, long j2) {
        this.charBuffer.clear();
        if (Build.VERSION.SDK_INT >= 23) {
            createDetailMessageToCache(str, j, j2, nextMessage());
        } else {
            createDetailMessageToCache(str, j, j2, null);
        }
        return this.charBuffer.flip().toString();
    }
}
