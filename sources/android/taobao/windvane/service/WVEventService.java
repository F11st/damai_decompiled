package android.taobao.windvane.service;

import android.taobao.windvane.util.TaoLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVEventService {
    private static volatile WVEventService EventManager = null;
    public static int WV_BACKWARD_EVENT = -1;
    public static int WV_EVENT = 0;
    public static int WV_FORWARD_EVENT = 1;
    private WVInstantEventListener mInstantEvent;
    private List<WVEventListener> mForwardList = new ArrayList();
    private List<WVEventListener> mList = new ArrayList();
    private List<WVEventListener> mBackwardList = new ArrayList();

    public static WVEventService getInstance() {
        if (EventManager == null) {
            synchronized (WVEventService.class) {
                if (EventManager == null) {
                    EventManager = new WVEventService();
                }
            }
        }
        return EventManager;
    }

    public synchronized void addEventListener(WVEventListener wVEventListener, int i) {
        if (wVEventListener != null) {
            if (i == WV_FORWARD_EVENT) {
                this.mForwardList.add(wVEventListener);
            } else if (i == WV_EVENT) {
                this.mList.add(wVEventListener);
            } else if (i == WV_BACKWARD_EVENT) {
                this.mBackwardList.add(wVEventListener);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x008b, code lost:
        return new android.taobao.windvane.service.WVEventResult(false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.taobao.windvane.service.WVEventResult onEvent(int r4, android.taobao.windvane.webview.IWVWebView r5, java.lang.String r6, java.lang.Object... r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.taobao.windvane.service.WVEventContext r0 = new android.taobao.windvane.service.WVEventContext     // Catch: java.lang.Throwable -> L8c
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> L8c
            r5 = 0
            r6 = 0
        L8:
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mForwardList     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L31
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L8c
            if (r6 >= r1) goto L31
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mForwardList     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L2e
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mForwardList     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L8c
            android.taobao.windvane.service.WVEventListener r1 = (android.taobao.windvane.service.WVEventListener) r1     // Catch: java.lang.Throwable -> L8c
            android.taobao.windvane.service.WVEventResult r1 = r1.onEvent(r4, r0, r7)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L2e
            boolean r2 = r1.isSuccess     // Catch: java.lang.Throwable -> L8c
            if (r2 == 0) goto L2e
            monitor-exit(r3)
            return r1
        L2e:
            int r6 = r6 + 1
            goto L8
        L31:
            r6 = 0
        L32:
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mList     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L5b
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L8c
            if (r6 >= r1) goto L5b
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mList     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L58
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mList     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L8c
            android.taobao.windvane.service.WVEventListener r1 = (android.taobao.windvane.service.WVEventListener) r1     // Catch: java.lang.Throwable -> L8c
            android.taobao.windvane.service.WVEventResult r1 = r1.onEvent(r4, r0, r7)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L58
            boolean r2 = r1.isSuccess     // Catch: java.lang.Throwable -> L8c
            if (r2 == 0) goto L58
            monitor-exit(r3)
            return r1
        L58:
            int r6 = r6 + 1
            goto L32
        L5b:
            r6 = 0
        L5c:
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mBackwardList     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L85
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L8c
            if (r6 >= r1) goto L85
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mBackwardList     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L82
            java.util.List<android.taobao.windvane.service.WVEventListener> r1 = r3.mBackwardList     // Catch: java.lang.Throwable -> L8c
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L8c
            android.taobao.windvane.service.WVEventListener r1 = (android.taobao.windvane.service.WVEventListener) r1     // Catch: java.lang.Throwable -> L8c
            android.taobao.windvane.service.WVEventResult r1 = r1.onEvent(r4, r0, r7)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L82
            boolean r2 = r1.isSuccess     // Catch: java.lang.Throwable -> L8c
            if (r2 == 0) goto L82
            monitor-exit(r3)
            return r1
        L82:
            int r6 = r6 + 1
            goto L5c
        L85:
            android.taobao.windvane.service.WVEventResult r4 = new android.taobao.windvane.service.WVEventResult     // Catch: java.lang.Throwable -> L8c
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L8c
            monitor-exit(r3)
            return r4
        L8c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.service.WVEventService.onEvent(int, android.taobao.windvane.webview.IWVWebView, java.lang.String, java.lang.Object[]):android.taobao.windvane.service.WVEventResult");
    }

    public WVEventResult onInstantEvent(int i, Object... objArr) {
        WVEventContext wVEventContext = new WVEventContext(null, null);
        WVInstantEventListener wVInstantEventListener = this.mInstantEvent;
        if (wVInstantEventListener != null) {
            return wVInstantEventListener.onInstantEvent(i, wVEventContext, objArr);
        }
        return null;
    }

    public synchronized void removeEventListener(WVEventListener wVEventListener) {
        if (wVEventListener != null) {
            int indexOf = this.mList.indexOf(wVEventListener);
            if (-1 != indexOf) {
                this.mList.remove(indexOf);
            }
            int indexOf2 = this.mForwardList.indexOf(wVEventListener);
            if (-1 != indexOf2) {
                this.mForwardList.remove(indexOf2);
            }
            int indexOf3 = this.mBackwardList.indexOf(wVEventListener);
            if (-1 != this.mBackwardList.indexOf(wVEventListener)) {
                this.mBackwardList.remove(indexOf3);
            }
        }
    }

    public synchronized void removeInstantEvent(WVInstantEventListener wVInstantEventListener) {
        if (wVInstantEventListener == null) {
            TaoLog.e("WVEventService", "event can not be null");
            return;
        }
        WVInstantEventListener wVInstantEventListener2 = this.mInstantEvent;
        if (wVInstantEventListener2 == null) {
            TaoLog.e("WVEventService", "event already be null");
        } else if (wVInstantEventListener2 != wVInstantEventListener) {
            TaoLog.e("WVEventService", "remove failed");
        } else {
            this.mInstantEvent = null;
        }
    }

    public synchronized void setInstantEvent(WVInstantEventListener wVInstantEventListener) {
        if (wVInstantEventListener == null) {
            TaoLog.e("WVEventService", "event can not be null");
        } else if (this.mInstantEvent != null) {
            TaoLog.e("WVEventService", "an instance has already been set, please wait it end");
        } else {
            this.mInstantEvent = wVInstantEventListener;
        }
    }

    public synchronized void addEventListener(WVEventListener wVEventListener) {
        addEventListener(wVEventListener, WV_EVENT);
    }

    public WVEventResult onEvent(int i) {
        return onEvent(i, null, null, new Object[0]);
    }

    public WVEventResult onEvent(int i, Object... objArr) {
        return onEvent(i, null, null, objArr);
    }
}
