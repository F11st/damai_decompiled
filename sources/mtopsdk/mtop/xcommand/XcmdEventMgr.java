package mtopsdk.mtop.xcommand;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mtopsdk.common.util.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class XcmdEventMgr {
    private static final String TAG = "mtopsdk.XcmdEventMgr";
    static Set<NewXcmdListener> oxcmdListeners = new CopyOnWriteArraySet();
    private static XcmdEventMgr xm;

    public static XcmdEventMgr getInstance() {
        if (xm == null) {
            synchronized (XcmdEventMgr.class) {
                if (xm == null) {
                    xm = new XcmdEventMgr();
                }
            }
        }
        return xm;
    }

    public void addOrangeXcmdListener(NewXcmdListener newXcmdListener) {
        oxcmdListeners.add(newXcmdListener);
    }

    public void onOrangeEvent(String str) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        NewXcmdEvent newXcmdEvent = new NewXcmdEvent(str);
        for (NewXcmdListener newXcmdListener : oxcmdListeners) {
            try {
                newXcmdListener.onEvent(newXcmdEvent);
            } catch (Throwable unused) {
            }
        }
    }

    public void removeOrangeXcmdListener(NewXcmdListener newXcmdListener) {
        oxcmdListeners.remove(newXcmdListener);
    }
}
