package com.alipay.mobile.bqcscanservice.behavior;

import android.os.AsyncTask;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WalletBury {
    public static final String TAG = "WalletBury";

    public static void addWalletBury(final String str, final Class[] clsArr, final Object[] objArr) {
        new AsyncTask<Object, Object, Object>() { // from class: com.alipay.mobile.bqcscanservice.behavior.WalletBury.1
            @Override // android.os.AsyncTask
            protected Object doInBackground(Object... objArr2) {
                try {
                    Class.forName("com.alipay.mobile.bqcscanservice.behavior.BehaviorBury").getMethod(str, clsArr).invoke(null, objArr);
                } catch (ClassNotFoundException e) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e.getMessage()});
                } catch (IllegalAccessException e2) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e2.getMessage()});
                } catch (NoSuchMethodException e3) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e3.getMessage()});
                } catch (InvocationTargetException e4) {
                    MPaasLogger.e(WalletBury.TAG, new Object[]{e4.getMessage()});
                }
                return null;
            }
        }.execute(new Object[0]);
    }
}
