package com.google.vr.ndk.base;

import android.content.Context;
import android.util.Log;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.base.api.VrCoreUtils;
import com.google.vr.vrcore.library.api.C5448a;
import com.google.vr.vrcore.library.api.IGvrLayout;
import com.google.vr.vrcore.library.api.ObjectWrapper;
import tb.zy2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GvrLayoutFactory {
    public static IGvrLayout create(Context context) {
        IGvrLayout tryCreateFromVrCorePackage = tryCreateFromVrCorePackage(context);
        if (tryCreateFromVrCorePackage == null) {
            IGvrLayout createFromCurrentPackage = createFromCurrentPackage(context);
            Log.d("GvrLayoutFactory", "Loaded GvrLayout from SDK.");
            return createFromCurrentPackage;
        }
        return tryCreateFromVrCorePackage;
    }

    private static IGvrLayout createFromCurrentPackage(Context context) {
        return new GvrLayoutImplWrapper(new GvrLayoutImpl(context));
    }

    private static IGvrLayout tryCreateFromVrCorePackage(Context context) {
        if (VrCoreUtils.e(context.getPackageName())) {
            return createFromCurrentPackage(context);
        }
        if (!(context instanceof zy2)) {
            if (!GvrApi.usingDynamicLibrary(context)) {
                Log.v("GvrLayoutFactory", "Dynamic library loading disabled, using built-in GvrLayout implementation.");
                return null;
            }
            Boolean bool = SdkConfigurationReader.getParams(context).allowDynamicJavaLibraryLoading;
            if (bool != null && bool.booleanValue()) {
                try {
                    if (VrCoreUtils.getVrCoreClientApiVersion(context) < 17) {
                        Log.d("GvrLayoutFactory", "VrCore outdated, using built-in GvrLayout implementation.");
                        return null;
                    }
                    try {
                        IGvrLayout newGvrLayout = C5448a.c(context).newGvrLayout(ObjectWrapper.wrap(C5448a.a(context)), ObjectWrapper.wrap(context));
                        if (newGvrLayout != null) {
                            Log.i("GvrLayoutFactory", "Successfully loaded GvrLayout from VrCore.");
                        } else {
                            Log.w("GvrLayoutFactory", "GvrLayout creation from VrCore failed.");
                        }
                        return newGvrLayout;
                    } catch (Exception e) {
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 40);
                        sb.append("Failed to load GvrLayout from VrCore:\n  ");
                        sb.append(valueOf);
                        Log.e("GvrLayoutFactory", sb.toString());
                        return null;
                    }
                } catch (VrCoreNotAvailableException unused) {
                    Log.d("GvrLayoutFactory", "VrCore unavailable, using built-in GvrLayout implementation.");
                    return null;
                }
            }
            Log.v("GvrLayoutFactory", "Dynamic Java library loading disabled, using built-in GvrLayout implementation.");
            return null;
        }
        throw new IllegalArgumentException("VrContextWrapper only supported within VrCore.");
    }
}
