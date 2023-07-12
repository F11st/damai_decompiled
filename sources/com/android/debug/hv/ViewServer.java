package com.android.debug.hv;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ViewServer implements Runnable {
    private static final String BUILD_TYPE_USER = "user";
    private static final String COMMAND_PROTOCOL_VERSION = "PROTOCOL";
    private static final String COMMAND_SERVER_VERSION = "SERVER";
    private static final String COMMAND_WINDOW_MANAGER_AUTOLIST = "AUTOLIST";
    private static final String COMMAND_WINDOW_MANAGER_GET_FOCUS = "GET_FOCUS";
    private static final String COMMAND_WINDOW_MANAGER_LIST = "LIST";
    private static final String LOG_TAG = "ViewServer";
    private static final String VALUE_PROTOCOL_VERSION = "4";
    private static final String VALUE_SERVER_VERSION = "4";
    private static final int VIEW_SERVER_DEFAULT_PORT = 4939;
    private static final int VIEW_SERVER_MAX_CONNECTIONS = 10;
    private static ViewServer sServer;
    private final ReentrantReadWriteLock mFocusLock;
    private View mFocusedWindow;
    private final List<WindowListener> mListeners;
    private final int mPort;
    private ServerSocket mServer;
    private Thread mThread;
    private ExecutorService mThreadPool;
    private final HashMap<View, String> mWindows;
    private final ReentrantReadWriteLock mWindowsLock;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class NoopViewServer extends ViewServer {
        @Override // com.android.debug.hv.ViewServer
        public void addWindow(Activity activity) {
        }

        @Override // com.android.debug.hv.ViewServer
        public void addWindow(View view, String str) {
        }

        @Override // com.android.debug.hv.ViewServer
        public boolean isRunning() {
            return false;
        }

        @Override // com.android.debug.hv.ViewServer
        public void removeWindow(Activity activity) {
        }

        @Override // com.android.debug.hv.ViewServer
        public void removeWindow(View view) {
        }

        @Override // com.android.debug.hv.ViewServer, java.lang.Runnable
        public void run() {
        }

        @Override // com.android.debug.hv.ViewServer
        public void setFocusedWindow(Activity activity) {
        }

        @Override // com.android.debug.hv.ViewServer
        public void setFocusedWindow(View view) {
        }

        @Override // com.android.debug.hv.ViewServer
        public boolean start() throws IOException {
            return false;
        }

        @Override // com.android.debug.hv.ViewServer
        public boolean stop() {
            return false;
        }

        private NoopViewServer() {
            super();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class ViewServerWorker implements WindowListener, Runnable {
        private Socket mClient;
        private final Object[] mLock = new Object[0];
        private boolean mNeedWindowListUpdate = false;
        private boolean mNeedFocusedWindowUpdate = false;

        public ViewServerWorker(Socket socket) {
            this.mClient = socket;
        }

        private View findWindow(int i) {
            if (i == -1) {
                ViewServer.this.mWindowsLock.readLock().lock();
                try {
                    return ViewServer.this.mFocusedWindow;
                } finally {
                }
            }
            ViewServer.this.mWindowsLock.readLock().lock();
            try {
                for (Map.Entry entry : ViewServer.this.mWindows.entrySet()) {
                    if (System.identityHashCode(entry.getKey()) == i) {
                        return (View) entry.getKey();
                    }
                }
                ViewServer.this.mWindowsLock.readLock().unlock();
                return null;
            } finally {
            }
        }

        private boolean getFocusedWindow(Socket socket) {
            BufferedWriter bufferedWriter;
            boolean z = false;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
                    try {
                        ViewServer.this.mFocusLock.readLock().lock();
                    } catch (Exception unused) {
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.close();
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused4) {
            }
            try {
                View view = ViewServer.this.mFocusedWindow;
                if (view != null) {
                    ViewServer.this.mWindowsLock.readLock().lock();
                    try {
                        String str = (String) ViewServer.this.mWindows.get(ViewServer.this.mFocusedWindow);
                        ViewServer.this.mWindowsLock.readLock().unlock();
                        bufferedWriter.write(Integer.toHexString(System.identityHashCode(view)));
                        bufferedWriter.write(32);
                        bufferedWriter.append((CharSequence) str);
                    } catch (Throwable th3) {
                        ViewServer.this.mWindowsLock.readLock().unlock();
                        throw th3;
                    }
                }
                bufferedWriter.write(10);
                bufferedWriter.flush();
                bufferedWriter.close();
                z = true;
                return z;
            } finally {
                ViewServer.this.mFocusLock.readLock().unlock();
            }
        }

        private boolean listWindows(Socket socket) {
            boolean z = false;
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    ViewServer.this.mWindowsLock.readLock().lock();
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
                    try {
                        for (Map.Entry entry : ViewServer.this.mWindows.entrySet()) {
                            bufferedWriter2.write(Integer.toHexString(System.identityHashCode(entry.getKey())));
                            bufferedWriter2.write(32);
                            bufferedWriter2.append((CharSequence) entry.getValue());
                            bufferedWriter2.write(10);
                        }
                        bufferedWriter2.write("DONE.\n");
                        bufferedWriter2.flush();
                        ViewServer.this.mWindowsLock.readLock().unlock();
                        bufferedWriter2.close();
                        z = true;
                    } catch (Exception unused) {
                        bufferedWriter = bufferedWriter2;
                        ViewServer.this.mWindowsLock.readLock().unlock();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        ViewServer.this.mWindowsLock.readLock().unlock();
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused4) {
            }
            return z;
        }

        private boolean windowCommand(Socket socket, String str, String str2) {
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    try {
                        int indexOf = str2.indexOf(32);
                        if (indexOf == -1) {
                            indexOf = str2.length();
                        }
                        int parseLong = (int) Long.parseLong(str2.substring(0, indexOf), 16);
                        str2 = indexOf < str2.length() ? str2.substring(indexOf + 1) : "";
                        View findWindow = findWindow(parseLong);
                        if (findWindow == null) {
                            return false;
                        }
                        Method declaredMethod = ViewDebug.class.getDeclaredMethod("dispatchCommand", View.class, String.class, String.class, OutputStream.class);
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(null, findWindow, str, str2, new C4661b(socket.getOutputStream()));
                        if (!socket.isOutputShutdown()) {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            try {
                                bufferedWriter2.write("DONE\n");
                                bufferedWriter2.flush();
                                bufferedWriter = bufferedWriter2;
                            } catch (Exception e) {
                                e = e;
                                bufferedWriter = bufferedWriter2;
                                Log.w(ViewServer.LOG_TAG, "Could not send command " + str + " with parameters " + str2, e);
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                bufferedWriter = bufferedWriter2;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                throw th;
                            }
                        }
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                            return true;
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (IOException unused2) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
            if (r2 == null) goto L41;
         */
        /* JADX WARN: Not initialized variable reg: 2, insn: 0x0071: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:41:0x0071 */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean windowManagerAutolistLoop() {
            /*
                r7 = this;
                com.android.debug.hv.ViewServer r0 = com.android.debug.hv.ViewServer.this
                com.android.debug.hv.ViewServer.access$700(r0, r7)
                r0 = 1
                r1 = 0
                java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.net.Socket r4 = r7.mClient     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                java.io.OutputStream r4 = r4.getOutputStream()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
                r2.<init>(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            L17:
                boolean r1 = java.lang.Thread.interrupted()     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
                if (r1 != 0) goto L67
                java.lang.Object[] r1 = r7.mLock     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
                monitor-enter(r1)     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
            L20:
                boolean r3 = r7.mNeedWindowListUpdate     // Catch: java.lang.Throwable -> L53
                if (r3 != 0) goto L2e
                boolean r4 = r7.mNeedFocusedWindowUpdate     // Catch: java.lang.Throwable -> L53
                if (r4 != 0) goto L2e
                java.lang.Object[] r3 = r7.mLock     // Catch: java.lang.Throwable -> L53
                r3.wait()     // Catch: java.lang.Throwable -> L53
                goto L20
            L2e:
                r4 = 0
                if (r3 == 0) goto L35
                r7.mNeedWindowListUpdate = r4     // Catch: java.lang.Throwable -> L53
                r3 = 1
                goto L36
            L35:
                r3 = 0
            L36:
                boolean r5 = r7.mNeedFocusedWindowUpdate     // Catch: java.lang.Throwable -> L53
                if (r5 == 0) goto L3d
                r7.mNeedFocusedWindowUpdate = r4     // Catch: java.lang.Throwable -> L53
                r4 = 1
            L3d:
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L53
                if (r3 == 0) goto L48
                java.lang.String r1 = "LIST UPDATE\n"
                r2.write(r1)     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
                r2.flush()     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
            L48:
                if (r4 == 0) goto L17
                java.lang.String r1 = "FOCUS UPDATE\n"
                r2.write(r1)     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
                r2.flush()     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
                goto L17
            L53:
                r3 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L53
                throw r3     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> L70
            L56:
                r1 = move-exception
                goto L5e
            L58:
                r0 = move-exception
                goto L72
            L5a:
                r2 = move-exception
                r6 = r2
                r2 = r1
                r1 = r6
            L5e:
                java.lang.String r3 = "ViewServer"
                java.lang.String r4 = "Connection error: "
                android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L70
                if (r2 == 0) goto L6a
            L67:
                r2.close()     // Catch: java.io.IOException -> L6a
            L6a:
                com.android.debug.hv.ViewServer r1 = com.android.debug.hv.ViewServer.this
                com.android.debug.hv.ViewServer.access$800(r1, r7)
                return r0
            L70:
                r0 = move-exception
                r1 = r2
            L72:
                if (r1 == 0) goto L77
                r1.close()     // Catch: java.io.IOException -> L77
            L77:
                com.android.debug.hv.ViewServer r1 = com.android.debug.hv.ViewServer.this
                com.android.debug.hv.ViewServer.access$800(r1, r7)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.debug.hv.ViewServer.ViewServerWorker.windowManagerAutolistLoop():boolean");
        }

        @Override // com.android.debug.hv.ViewServer.WindowListener
        public void focusChanged() {
            synchronized (this.mLock) {
                this.mNeedFocusedWindowUpdate = true;
                this.mLock.notifyAll();
            }
        }

        /* JADX WARN: Not initialized variable reg: 2, insn: 0x00e4: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:69:0x00e4 */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.debug.hv.ViewServer.ViewServerWorker.run():void");
        }

        @Override // com.android.debug.hv.ViewServer.WindowListener
        public void windowsChanged() {
            synchronized (this.mLock) {
                this.mNeedWindowListUpdate = true;
                this.mLock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface WindowListener {
        void focusChanged();

        void windowsChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.android.debug.hv.ViewServer$b */
    /* loaded from: classes10.dex */
    public static class C4661b extends OutputStream {
        private final OutputStream a;

        C4661b(OutputStream outputStream) {
            this.a = outputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public boolean equals(Object obj) {
            return this.a.equals(obj);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.a.flush();
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a.toString();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.a.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.a.write(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addWindowListener(WindowListener windowListener) {
        if (this.mListeners.contains(windowListener)) {
            return;
        }
        this.mListeners.add(windowListener);
    }

    private void fireFocusChangedEvent() {
        for (WindowListener windowListener : this.mListeners) {
            windowListener.focusChanged();
        }
    }

    private void fireWindowsChangedEvent() {
        for (WindowListener windowListener : this.mListeners) {
            windowListener.windowsChanged();
        }
    }

    public static ViewServer get(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (BUILD_TYPE_USER.equals(Build.TYPE) && (applicationInfo.flags & 2) != 0) {
            if (sServer == null) {
                sServer = new ViewServer((int) VIEW_SERVER_DEFAULT_PORT);
            }
            if (!sServer.isRunning()) {
                try {
                    sServer.start();
                } catch (IOException e) {
                    Log.d(LOG_TAG, "Error:", e);
                }
            }
        } else {
            sServer = new NoopViewServer();
        }
        return sServer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeWindowListener(WindowListener windowListener) {
        this.mListeners.remove(windowListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean writeValue(Socket socket, String str) {
        boolean z = false;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()), 8192);
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.write(StringUtils.LF);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    z = true;
                } catch (Exception unused) {
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused4) {
        }
        return z;
    }

    public void addWindow(Activity activity) {
        String str;
        String charSequence = activity.getTitle().toString();
        if (TextUtils.isEmpty(charSequence)) {
            str = activity.getClass().getCanonicalName() + "/0x" + System.identityHashCode(activity);
        } else {
            str = charSequence + jn1.BRACKET_START_STR + activity.getClass().getCanonicalName() + jn1.BRACKET_END_STR;
        }
        addWindow(activity.getWindow().getDecorView(), str);
    }

    public boolean isRunning() {
        Thread thread = this.mThread;
        return thread != null && thread.isAlive();
    }

    public void removeWindow(Activity activity) {
        removeWindow(activity.getWindow().getDecorView());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mServer = new ServerSocket(this.mPort, 10, InetAddress.getLocalHost());
        } catch (Exception e) {
            Log.w(LOG_TAG, "Starting ServerSocket error: ", e);
        }
        while (this.mServer != null && Thread.currentThread() == this.mThread) {
            try {
                Socket accept = this.mServer.accept();
                ExecutorService executorService = this.mThreadPool;
                if (executorService != null) {
                    executorService.submit(new ViewServerWorker(accept));
                } else {
                    try {
                        accept.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                Log.w(LOG_TAG, "Connection error: ", e3);
            }
        }
    }

    public void setFocusedWindow(Activity activity) {
        setFocusedWindow(activity.getWindow().getDecorView());
    }

    public boolean start() throws IOException {
        if (this.mThread != null) {
            return false;
        }
        this.mThread = new Thread(this, "Local View Server [port=" + this.mPort + jn1.ARRAY_END_STR);
        this.mThreadPool = Executors.newFixedThreadPool(10);
        this.mThread.start();
        return true;
    }

    public boolean stop() {
        Thread thread = this.mThread;
        if (thread != null) {
            thread.interrupt();
            ExecutorService executorService = this.mThreadPool;
            if (executorService != null) {
                try {
                    executorService.shutdownNow();
                } catch (SecurityException unused) {
                    Log.w(LOG_TAG, "Could not stop all view server threads");
                }
            }
            this.mThreadPool = null;
            this.mThread = null;
            try {
                this.mServer.close();
                this.mServer = null;
                return true;
            } catch (IOException unused2) {
                Log.w(LOG_TAG, "Could not close the view server");
            }
        }
        this.mWindowsLock.writeLock().lock();
        try {
            this.mWindows.clear();
            this.mWindowsLock.writeLock().unlock();
            this.mFocusLock.writeLock().lock();
            try {
                this.mFocusedWindow = null;
                this.mFocusLock.writeLock().unlock();
                return false;
            } catch (Throwable th) {
                this.mFocusLock.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.mWindowsLock.writeLock().unlock();
            throw th2;
        }
    }

    private ViewServer() {
        this.mListeners = new CopyOnWriteArrayList();
        this.mWindows = new HashMap<>();
        this.mWindowsLock = new ReentrantReadWriteLock();
        this.mFocusLock = new ReentrantReadWriteLock();
        this.mPort = -1;
    }

    public void removeWindow(View view) {
        this.mWindowsLock.writeLock().lock();
        try {
            View rootView = view.getRootView();
            this.mWindows.remove(rootView);
            this.mWindowsLock.writeLock().unlock();
            this.mFocusLock.writeLock().lock();
            try {
                if (this.mFocusedWindow == rootView) {
                    this.mFocusedWindow = null;
                }
                this.mFocusLock.writeLock().unlock();
                fireWindowsChangedEvent();
            } catch (Throwable th) {
                this.mFocusLock.writeLock().unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.mWindowsLock.writeLock().unlock();
            throw th2;
        }
    }

    public void setFocusedWindow(View view) {
        View rootView;
        this.mFocusLock.writeLock().lock();
        if (view == null) {
            rootView = null;
        } else {
            try {
                rootView = view.getRootView();
            } catch (Throwable th) {
                this.mFocusLock.writeLock().unlock();
                throw th;
            }
        }
        this.mFocusedWindow = rootView;
        this.mFocusLock.writeLock().unlock();
        fireFocusChangedEvent();
    }

    public void addWindow(View view, String str) {
        this.mWindowsLock.writeLock().lock();
        try {
            this.mWindows.put(view.getRootView(), str);
            this.mWindowsLock.writeLock().unlock();
            fireWindowsChangedEvent();
        } catch (Throwable th) {
            this.mWindowsLock.writeLock().unlock();
            throw th;
        }
    }

    private ViewServer(int i) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mWindows = new HashMap<>();
        this.mWindowsLock = new ReentrantReadWriteLock();
        this.mFocusLock = new ReentrantReadWriteLock();
        this.mPort = i;
    }
}
