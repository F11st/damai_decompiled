package com.google.vr.cardboard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.ndk.base.SdkConfigurationReader;
import com.google.vr.sdk.proto.nano.CardboardDevice;
import com.google.vr.sdk.proto.nano.Phone;
import com.google.vr.sdk.proto.nano.Preferences;
import tb.az2;
import tb.ga0;
import tb.v;

/* compiled from: Taobao */
@UsedByNative
/* loaded from: classes10.dex */
public class VrParamsProviderJni {
    private static volatile DisplayMetrics a;

    private static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = a;
        return displayMetrics != null ? displayMetrics : ga0.c(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay());
    }

    private static void b(long j, DisplayMetrics displayMetrics, float f) {
        nativeUpdateNativePhoneParamsPointer(j, com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics), displayMetrics.xdpi, displayMetrics.ydpi, f);
    }

    private static native void nativeUpdateNativePhoneParamsPointer(long j, int i, int i2, float f, float f2, float f3);

    @UsedByNative
    private static byte[] readDeviceParams(Context context) {
        VrParamsProvider a2 = az2.a(context);
        CardboardDevice.DeviceParams readDeviceParams = a2.readDeviceParams();
        a2.close();
        if (readDeviceParams == null) {
            return null;
        }
        return MessageNano.toByteArray(readDeviceParams);
    }

    @UsedByNative
    private static void readPhoneParams(Context context, long j) {
        if (context == null) {
            Log.w("VrParamsProviderJni", "Missing context for phone params lookup. Results may be invalid.");
            b(j, Resources.getSystem().getDisplayMetrics(), ga0.a(null));
            return;
        }
        DisplayMetrics a2 = a(context);
        VrParamsProvider a3 = az2.a(context);
        Phone.PhoneParams readPhoneParams = a3.readPhoneParams();
        a3.close();
        if (readPhoneParams != null) {
            if (readPhoneParams.hasXPpi()) {
                a2.xdpi = readPhoneParams.getXPpi();
            }
            if (readPhoneParams.hasYPpi()) {
                a2.ydpi = readPhoneParams.getYPpi();
            }
        }
        b(j, a2, ga0.a(readPhoneParams));
    }

    @UsedByNative
    private static byte[] readSdkConfigurationParams(Context context) {
        return MessageNano.toByteArray(SdkConfigurationReader.getParams(context));
    }

    @UsedByNative
    private static byte[] readUserPrefs(Context context) {
        VrParamsProvider a2 = az2.a(context);
        Preferences.UserPrefs readUserPrefs = a2.readUserPrefs();
        a2.close();
        if (readUserPrefs == null) {
            return null;
        }
        return MessageNano.toByteArray(readUserPrefs);
    }

    @UsedByNative
    private static boolean writeDeviceParams(Context context, byte[] bArr) {
        CardboardDevice.DeviceParams deviceParams;
        VrParamsProvider a2 = az2.a(context);
        try {
            if (bArr != null) {
                try {
                    deviceParams = (CardboardDevice.DeviceParams) MessageNano.mergeFrom(new CardboardDevice.DeviceParams(), bArr);
                } catch (InvalidProtocolBufferNanoException e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 31);
                    sb.append("Error parsing protocol buffer: ");
                    sb.append(valueOf);
                    Log.w("VrParamsProviderJni", sb.toString());
                    a2.close();
                    return false;
                }
            } else {
                deviceParams = null;
            }
            boolean writeDeviceParams = a2.writeDeviceParams(deviceParams);
            a2.close();
            return writeDeviceParams;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }
}
