package com.uc.webview.export.cyclone;

import android.os.AsyncTask;
import android.os.Process;
import android.util.Base64;
import android.webkit.ValueCallback;
import com.taobao.weex.ui.component.WXComponent;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import javax.crypto.Cipher;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
@Constant
/* loaded from: classes11.dex */
public class Log {
    private static final String EXTRA_TAG = "cyclone.";
    public static final int LOG_LEVEL_D = 0;
    public static final int LOG_LEVEL_E = 3;
    public static final int LOG_LEVEL_I = 1;
    public static final int LOG_LEVEL_W = 2;
    private static final String TAG = "Log";
    private static final String[] LOG_LEVEL_TAG = {"d", "i", WXComponent.PROP_FS_WRAP_CONTENT, "e"};
    private static final Integer CURRENT_PID = Integer.valueOf(Process.myPid());
    private static volatile boolean sEnabled = false;
    private static volatile boolean sDebug = false;
    private static volatile Logcat sLogcat = null;
    private static volatile CallbackChannel sCallbackChannel = null;
    private static volatile CachedLogs sCachedLogs = new CachedLogs();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class CachedLogs {
        private static final int MAX_SIZE = 512;
        private static final int MAX_SIZE_AFTER_EVICT = 460;
        private LinkedList<Message> mLogs = new LinkedList<>();

        private void evict() {
            while (this.mLogs.size() > 460) {
                this.mLogs.pop();
            }
        }

        public final void add(Message message) {
            synchronized (this) {
                LinkedList<Message> linkedList = this.mLogs;
                if (linkedList == null) {
                    return;
                }
                if (linkedList.size() > 512) {
                    evict();
                }
                this.mLogs.add(message);
            }
        }

        public final LinkedList<Message> take() {
            LinkedList<Message> linkedList;
            synchronized (this) {
                linkedList = this.mLogs;
                this.mLogs = null;
            }
            return linkedList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class CallbackChannel {
        private volatile ValueCallback<Object[]> mCallback;
        private volatile boolean mIsRunning = false;
        private volatile ConcurrentLinkedQueue<Message> mMessages = new ConcurrentLinkedQueue<>();
        private final Runnable mTask = getAsyncTask();

        public CallbackChannel(ValueCallback<Object[]> valueCallback) {
            this.mCallback = valueCallback;
        }

        private Runnable getAsyncTask() {
            return new Runnable() { // from class: com.uc.webview.export.cyclone.Log.CallbackChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ValueCallback valueCallback = CallbackChannel.this.mCallback;
                        if (valueCallback == null) {
                            CallbackChannel.this.mMessages.clear();
                        } else {
                            do {
                                Message message = (Message) CallbackChannel.this.mMessages.poll();
                                while (message != null) {
                                    valueCallback.onReceiveValue(message.getAllInfo());
                                    message = (Message) CallbackChannel.this.mMessages.poll();
                                }
                                try {
                                    Thread.sleep(200L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } while (CallbackChannel.this.mMessages.peek() != null);
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            };
        }

        public final void call(Message message) {
            this.mMessages.add(message);
            if (this.mIsRunning) {
                return;
            }
            this.mIsRunning = true;
            try {
                AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mTask);
            } catch (Throwable th) {
                android.util.Log.e(Log.TAG, "log error", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class Message {
        private static volatile AtomicLong sIndex = new AtomicLong(0);
        private Object[] mInfo;
        private int mLevel;

        public Message(int i, String str, String str2, Throwable th) {
            long incrementAndGet = sIndex.incrementAndGet();
            this.mLevel = i;
            Object[] objArr = new Object[7];
            objArr[0] = Long.valueOf(System.currentTimeMillis());
            objArr[1] = Log.CURRENT_PID;
            objArr[2] = Integer.valueOf(Process.myTid());
            objArr[3] = Log.LOG_LEVEL_TAG[i];
            String str3 = Log.EXTRA_TAG;
            if (str != null) {
                str3 = Log.EXTRA_TAG + str;
            }
            objArr[4] = str3;
            objArr[5] = String.format("[SEQ:%d] %s", Long.valueOf(incrementAndGet), str2);
            objArr[6] = th;
            this.mInfo = objArr;
        }

        public final Object[] getAllInfo() {
            return this.mInfo;
        }

        public final int getLevel() {
            return this.mLevel;
        }

        public final Object[] getLogcatInfo() {
            Object[] objArr = this.mInfo;
            return new Object[]{objArr[4], objArr[5], objArr[6]};
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Log.formatTime(((Long) this.mInfo[0]).longValue()));
            sb.append(" ");
            sb.append(this.mInfo[1]);
            sb.append(" ");
            sb.append(this.mInfo[2]);
            sb.append(" ");
            sb.append(this.mInfo[3]);
            sb.append(" ");
            sb.append(this.mInfo[4]);
            sb.append(" ");
            sb.append(this.mInfo[5]);
            Throwable th = (Throwable) this.mInfo[6];
            if (th != null) {
                sb.append(StringUtils.LF);
                sb.append(Log.getStackTraceString(th));
            }
            return sb.toString();
        }
    }

    static {
        checkLogConfig();
    }

    private static synchronized void checkLogConfig() {
        synchronized (Log.class) {
        }
    }

    public static final void d(String str, String str2) {
        d(str, str2, null);
    }

    private static byte[] decryptLogConfigfile(byte[] bArr) throws Exception {
        byte[] doFinal;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIfT7cb7mtrwWJr6PeLJe+s63nu3OE03e/GBO3IrRJigEsm95jUty30hhq6Mg+Eoo65Tr01rp6uqqUUSgdqPrMuC3lNu8CO5Q1nTJgpdzq5t7Bq4GjaxQLk7S5zHNNQAEB5+16pGE4K9qpY+qNuhjEF1WFZvhHb7RBBHXr+ZTpDQIDAQAB", 2));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec));
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 128) {
                    doFinal = cipher.doFinal(bArr, i, 128);
                } else {
                    doFinal = cipher.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i2++;
                i = i2 * 128;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    public static final void e(String str, String str2) {
        e(str, str2, null);
    }

    public static boolean enabled() {
        return sEnabled || sDebug;
    }

    public static final void flushCachedLogs(StringBuffer stringBuffer) {
        LinkedList<Message> take;
        if (sCachedLogs == null) {
            return;
        }
        if (stringBuffer != null && (take = sCachedLogs.take()) != null) {
            Iterator<Message> it = take.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString());
                stringBuffer.append(StringUtils.LF);
            }
        }
        sCachedLogs = null;
    }

    public static final String formatTime(long j) {
        return new SimpleDateFormat("yyy-MM-dd kk:mm:ss.SSS").format(new Date(j));
    }

    public static final String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    public static final void i(String str, String str2) {
        i(str, str2, null);
    }

    public static final void print(int i, String str, String str2, Throwable th) {
        Message message = new Message(i, str, str2, th);
        if (sCachedLogs != null) {
            sCachedLogs.add(message);
        }
        if (enabled()) {
            if (sLogcat != null) {
                sLogcat.print(i, message);
            }
            if (sCallbackChannel != null) {
                sCallbackChannel.call(message);
            }
        }
    }

    public static final void printAndFlushCachedLogs() {
        if (sCachedLogs == null) {
            Logcat.rInfo(TAG, "no cached logs", null);
            return;
        }
        LinkedList<Message> take = sCachedLogs.take();
        if (take != null) {
            Iterator<Message> it = take.iterator();
            while (it.hasNext()) {
                Message next = it.next();
                Logcat.rInfo(next.getLevel(), next);
            }
        }
        sCachedLogs = null;
    }

    public static final void rInfo(String str, String str2) {
        rInfo(str, str2, null);
    }

    public static synchronized void setup(boolean z, boolean z2, ValueCallback<Object[]> valueCallback) {
        synchronized (Log.class) {
            sEnabled = z;
            if (enabled()) {
                if (z2 && sLogcat == null) {
                    sLogcat = new Logcat();
                }
                if (valueCallback != null) {
                    sCallbackChannel = new CallbackChannel(valueCallback);
                }
            }
        }
    }

    public static final void w(String str, String str2) {
        w(str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class Logcat {
        private static final Method[] mMtds = new Method[4];

        static {
            try {
                Class<?> cls = Class.forName("android.util.Log");
                Class[] clsArr = {String.class, String.class, Throwable.class};
                initMethod(0, cls, clsArr);
                initMethod(1, cls, clsArr);
                initMethod(2, cls, clsArr);
                initMethod(3, cls, clsArr);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private static void initMethod(int i, Class cls, Class[] clsArr) {
            String str = Log.LOG_LEVEL_TAG[i];
            try {
                try {
                    mMtds[i] = cls.getDeclaredMethod(str, clsArr);
                } catch (Throwable unused) {
                    mMtds[i] = cls.getMethod(str, clsArr);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static void rInfo(String str, String str2, Throwable th) {
            try {
                Method method = mMtds[1];
                method.invoke(null, Log.EXTRA_TAG + str, str2, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        public final void print(int i, Message message) {
            try {
                mMtds[i].invoke(null, message.getLogcatInfo());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static void rInfo(int i, Message message) {
            try {
                mMtds[i].invoke(null, message.getLogcatInfo());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static final void d(String str, String str2, Throwable th) {
        print(0, str, str2, th);
    }

    public static final void e(String str, String str2, Throwable th) {
        print(3, str, str2, th);
    }

    public static final void i(String str, String str2, Throwable th) {
        print(1, str, str2, th);
    }

    public static final void rInfo(String str, String str2, Throwable th) {
        if (enabled()) {
            e(str, str2, th);
        }
        Logcat.rInfo(str, str2, th);
    }

    public static final void w(String str, String str2, Throwable th) {
        print(2, str, str2, th);
    }
}
