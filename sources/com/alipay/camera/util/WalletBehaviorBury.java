package com.alipay.camera.util;

import android.os.AsyncTask;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WalletBehaviorBury {
    public static final String TAG = "WalletBehaviorBury";

    public static void bury(final String str, final Class[] clsArr, final Object[] objArr) {
        CameraLog.d(TAG, "bury, method:" + str);
        new AsyncTask<Object, Object, Object>() { // from class: com.alipay.camera.util.WalletBehaviorBury.1
            @Override // android.os.AsyncTask
            protected Object doInBackground(Object... objArr2) {
                try {
                    Class.forName("com.alipay.mobile.bqcscanservice.behavior.BehaviorBury").getMethod(str, clsArr).invoke(null, objArr);
                } catch (ClassNotFoundException e) {
                    CameraLog.e(WalletBehaviorBury.TAG, e.getMessage());
                } catch (IllegalAccessException e2) {
                    CameraLog.e(WalletBehaviorBury.TAG, e2.getMessage());
                } catch (NoSuchMethodException e3) {
                    CameraLog.e(WalletBehaviorBury.TAG, e3.getMessage());
                } catch (InvocationTargetException e4) {
                    CameraLog.e(WalletBehaviorBury.TAG, e4.getMessage());
                }
                return null;
            }
        }.execute(new Object[0]);
    }
}
