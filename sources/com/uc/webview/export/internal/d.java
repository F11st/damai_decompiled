package com.uc.webview.export.internal;

import com.uc.webview.export.PermissionRequest;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import com.uc.webview.export.internal.utility.Log;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d implements InvokeObject {
    private static String a = "d";
    private static d b;
    private InvokeObject c;

    private d(InvokeObject invokeObject) {
        this.c = invokeObject;
        invokeObject.invoke(101, new Object[]{this});
    }

    public static void a(InvokeObject invokeObject) {
        if (b == null) {
            b = new d(invokeObject);
        }
    }

    public final Object b(int i, Object[] objArr) {
        return this.c.invoke(i, objArr);
    }

    @Override // com.uc.webview.export.internal.interfaces.InvokeObject
    public Object invoke(int i, Object[] objArr) {
        String str = a;
        Log.d(str, "invoke.case.id: " + i + " params: " + Arrays.toString(objArr));
        switch (i) {
            case 201:
                if (objArr != null && objArr.length == 1) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    String str2 = a;
                    Log.d(str2, "onCoreClearRecord value: " + intValue);
                }
                return null;
            case 202:
                if (objArr != null && objArr.length == 1) {
                    boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                    String str3 = a;
                    Log.d(str3, "onProxySettingChanged value: " + booleanValue);
                }
                return null;
            case 203:
                ((WebChromeClient) objArr[0]).onPermissionRequest((PermissionRequest) objArr[1]);
                return null;
            case 204:
                ((WebChromeClient) objArr[0]).onPermissionRequestCanceled((PermissionRequest) objArr[1]);
                return null;
            case 205:
                ((WebChromeClient) objArr[0]).onConsoleMessage((String) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3]);
                return null;
            default:
                return null;
        }
    }

    public static d a() {
        d dVar = b;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException("Not initialize the instance yet, call initInstance first.");
    }

    public final void a(int i, Object[] objArr) {
        try {
            this.c.invoke(i, objArr);
        } catch (Throwable unused) {
            String str = a;
            Log.e(str, "callCore failed id:" + i + ", params:" + Arrays.toString(objArr));
        }
    }
}
