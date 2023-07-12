package com.taobao.accs.asp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class APreferencesManager {
    private static final String TAG = "APreferencesManager";
    private static Context sContext;
    private static final HashMap<String, SharedPreferences> sSharedPrefsCache = new HashMap<>();
    private static final AtomicBoolean isInit = new AtomicBoolean(false);

    private APreferencesManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SharedPreferences getMultiProcessSharedPreferences(String str) {
        return getSharedPreferences(sContext, str, 0);
    }

    public static SharedPreferences getSharedPreferences(@NonNull Context context, String str, int i) {
        return replaceSharePreferences(context, str, context.getSharedPreferences(str, i));
    }

    private static void init(Context context) {
        if (isInit.compareAndSet(false, true)) {
            sContext = context;
            PrefsIPCChannel.getInstance().register(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void recoverPreferences() {
        synchronized (APreferencesManager.class) {
            try {
                for (SharedPreferences sharedPreferences : sSharedPrefsCache.values()) {
                    if (sharedPreferences instanceof EdgeSharedPreferences) {
                        ((EdgeSharedPreferences) sharedPreferences).registerChannelListener();
                    }
                }
            }
        }
    }

    public static SharedPreferences replaceSharePreferences(@NonNull Context context, @NonNull String str, @NonNull SharedPreferences sharedPreferences) {
        SharedPreferences sharedPreferences2;
        if (!TextUtils.isEmpty(str)) {
            if (context != null && !UtilityImpl.isDualApp(context)) {
                init(context);
                if (OrangeAdapter.isAspEnable(context) && !TextUtils.isEmpty(Utils.getCoreProviderProcess()) && PrefsIPCChannel.getInstance().isCoreProcessReady()) {
                    synchronized (APreferencesManager.class) {
                        HashMap<String, SharedPreferences> hashMap = sSharedPrefsCache;
                        sharedPreferences2 = hashMap.get(str);
                        if (sharedPreferences2 == null) {
                            if (Utils.isCoreProcess()) {
                                sharedPreferences2 = new CoreSharedPreferences(context, str, sharedPreferences);
                            } else {
                                sharedPreferences2 = new EdgeSharedPreferences(context, str, sharedPreferences);
                            }
                            hashMap.put(str, sharedPreferences2);
                        }
                    }
                    return sharedPreferences2;
                }
            }
            return sharedPreferences;
        }
        throw new IllegalArgumentException("SharedPreferences name can not be empty");
    }
}
