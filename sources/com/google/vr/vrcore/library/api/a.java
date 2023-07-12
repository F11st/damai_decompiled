package com.google.vr.vrcore.library.api;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.library.api.IVrCreator;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    private static Context a;
    private static int b;
    private static IVrCreator c;

    public static Context a(Context context) throws VrCoreNotAvailableException {
        if (a == null) {
            int vrCoreClientApiVersion = VrCoreUtils.getVrCoreClientApiVersion(context);
            if (vrCoreClientApiVersion >= 9) {
                try {
                    a = context.createPackageContext("com.google.vr.vrcore", 3);
                    b = vrCoreClientApiVersion;
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new VrCoreNotAvailableException(1);
                }
            } else {
                throw new VrCoreNotAvailableException(4);
            }
        }
        return a;
    }

    public static int b(Context context) throws VrCoreNotAvailableException {
        a(context);
        return b;
    }

    public static IVrCreator c(Context context) throws VrCoreNotAvailableException {
        if (c == null) {
            c = IVrCreator.Stub.asInterface(d(a(context).getClassLoader(), "com.google.vr.vrcore.library.VrCreator"));
        }
        return c;
    }

    private static IBinder d(ClassLoader classLoader, String str) {
        try {
            return (IBinder) classLoader.loadClass(str).newInstance();
        } catch (ClassNotFoundException unused) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "));
        } catch (IllegalAccessException unused2) {
            String valueOf2 = String.valueOf(str);
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf2) : new String("Unable to call the default constructor of "));
        } catch (InstantiationException unused3) {
            String valueOf3 = String.valueOf(str);
            throw new IllegalStateException(valueOf3.length() != 0 ? "Unable to instantiate the remote class ".concat(valueOf3) : new String("Unable to instantiate the remote class "));
        }
    }
}
