package org.android.netutil;

import androidx.annotation.Keep;
import java.util.concurrent.Future;

/* compiled from: Taobao */
@Keep
/* loaded from: classes2.dex */
public class NetUtils {
    public static String getDefaultGateway(String str) {
        return native_GetDefaultGateway(str);
    }

    public static String getPreferNextHop(String str) {
        return getPreferNextHop(str, 1);
    }

    private static native long native_CreateAndRegister(long j, NetListener netListener);

    private static native String native_GetDefaultGateway(String str);

    private static native void native_UnRegister(long j);

    public static boolean registerNetListener(NetListener netListener) {
        if (netListener != null) {
            long native_CreateAndRegister = native_CreateAndRegister(netListener.netListenerType.getValue(), netListener);
            netListener.native_ptr = native_CreateAndRegister;
            return native_CreateAndRegister != 0;
        }
        return false;
    }

    public static void unRegisterNetListener(NetListener netListener) {
        if (netListener != null) {
            long j = netListener.native_ptr;
            if (j != 0) {
                native_UnRegister(j);
            }
        }
    }

    public static String getPreferNextHop(String str, int i) {
        Future<b> launch = new PingTask(str, 0, 1, 0, i).launch();
        if (launch != null) {
            try {
                b bVar = launch.get();
                if (bVar != null) {
                    return bVar.c();
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
