package com.ali.user.open.core.message;

import android.content.Context;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.ResourceUtils;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes9.dex */
public class MessageUtils {
    private static final Message defaultMessageNotFoundMessage;
    private static final Message defaultUnknownErrorMessage;
    private static Message messageNotFoundMessage;
    private static Message unknownErrorMessage;
    private static Map<Integer, Message> cachedMessageMetas = new HashMap();
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final Object defaultMessageLoadLock = new Object();

    static {
        Message message = new Message();
        defaultMessageNotFoundMessage = message;
        message.code = 1;
        message.message = "";
        Message message2 = new Message();
        defaultUnknownErrorMessage = message2;
        message2.code = 2;
        message2.message = "系统异常，请稍后再试";
    }

    public static Message createMessage(int i, Object... objArr) {
        try {
            lock.readLock().lock();
            Message message = cachedMessageMetas.get(Integer.valueOf(i));
            if (message == null) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                message = loadMessage(i);
                if (message != null) {
                    cachedMessageMetas.put(Integer.valueOf(i), message);
                }
                lock.readLock().lock();
                lock.writeLock().unlock();
            }
            if (message == null) {
                Message createMessageNotFoundMessage = createMessageNotFoundMessage(i);
                lock.readLock().unlock();
                return createMessageNotFoundMessage;
            } else if (objArr.length == 0) {
                lock.readLock().unlock();
                return message;
            } else {
                Message message2 = (Message) message.clone();
                message2.message = MessageFormat.format(message.message, objArr);
                lock.readLock().unlock();
                return message2;
            }
        } catch (Exception e) {
            return createUnknownErrorMessage(e.getMessage());
        }
    }

    private static Message createMessageNotFoundMessage(int i) {
        if (messageNotFoundMessage == null) {
            synchronized (defaultMessageLoadLock) {
                if (messageNotFoundMessage == null) {
                    Message loadMessage = loadMessage(1);
                    messageNotFoundMessage = loadMessage;
                    if (loadMessage == null) {
                        messageNotFoundMessage = defaultMessageNotFoundMessage;
                    }
                }
            }
        }
        try {
            Message message = (Message) messageNotFoundMessage.clone();
            message.message = MessageFormat.format(message.message, String.valueOf(i));
            return message;
        } catch (CloneNotSupportedException unused) {
            return messageNotFoundMessage;
        }
    }

    private static Message createUnknownErrorMessage(String str) {
        if (unknownErrorMessage == null) {
            synchronized (defaultMessageLoadLock) {
                if (unknownErrorMessage == null) {
                    Message loadMessage = loadMessage(2);
                    unknownErrorMessage = loadMessage;
                    if (loadMessage == null) {
                        unknownErrorMessage = defaultUnknownErrorMessage;
                    }
                }
            }
        }
        try {
            Message message = (Message) unknownErrorMessage.clone();
            message.message = MessageFormat.format(message.message, str);
            return message;
        } catch (CloneNotSupportedException unused) {
            return unknownErrorMessage;
        }
    }

    public static String getMessageContent(int i, Object... objArr) {
        try {
            lock.readLock().lock();
            Message message = cachedMessageMetas.get(Integer.valueOf(i));
            if (message == null) {
                lock.readLock().unlock();
                lock.writeLock().lock();
                message = loadMessage(i);
                if (message != null) {
                    cachedMessageMetas.put(Integer.valueOf(i), message);
                }
                lock.readLock().lock();
                lock.writeLock().unlock();
            }
            if (message == null) {
                String str = createMessageNotFoundMessage(i).message;
                lock.readLock().unlock();
                return str;
            }
            String format = MessageFormat.format(message.message, objArr);
            lock.readLock().unlock();
            return format;
        } catch (Exception e) {
            return createUnknownErrorMessage(e.getMessage()).message;
        }
    }

    private static Message loadMessage(int i) {
        try {
            Context applicationContext = KernelContext.getApplicationContext();
            if (ResourceUtils.getIdentifier(applicationContext, "string", "member_sdk_message_" + i + "_message") == 0) {
                return null;
            }
            Message message = new Message();
            message.code = i;
            Context applicationContext2 = KernelContext.getApplicationContext();
            message.message = ResourceUtils.getString(applicationContext2, "member_sdk_message_" + i + "_message");
            return message;
        } catch (Exception e) {
            SDKLogger.e(KernelContext.TAG, "Fail to get message of the code " + i + ", the error message is " + e.getMessage());
            return null;
        }
    }
}
