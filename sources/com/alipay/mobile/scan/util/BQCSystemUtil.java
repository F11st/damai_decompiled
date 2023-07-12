package com.alipay.mobile.scan.util;

import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.lang.reflect.InvocationTargetException;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BQCSystemUtil {
    public static String reflectSystemProperties(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (ClassNotFoundException unused) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"ClassNotFoundException error"});
            return null;
        } catch (IllegalAccessException unused2) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"IllegalAccessException error"});
            return null;
        } catch (NoSuchMethodException unused3) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"NoSuchMethodException error"});
            return null;
        } catch (InvocationTargetException unused4) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"InvocationTargetException error"});
            return null;
        } catch (Exception e) {
            MPaasLogger.e("reflectSystemProperties", new Object[]{"error "}, e);
            return null;
        }
    }
}
