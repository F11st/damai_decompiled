package com.ali.user.mobile.log;

import android.app.Activity;
import android.util.Log;
import com.ali.user.mobile.app.init.Debuggable;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.service.UserTrackService;
import java.util.Map;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UserTrackAdapter {
    private static final boolean DEBUG;
    private static final String TAG;

    static {
        boolean isDebug = Debuggable.isDebug();
        DEBUG = isDebug;
        TAG = isDebug ? "login.UserTrackAdapter" : UserTrackAdapter.class.getSimpleName();
    }

    public static void UIShown(String str, String str2, String str3) {
        if (ServiceFactory.getService(UserTrackService.class) != null) {
            ((UserTrackService) ServiceFactory.getService(UserTrackService.class)).UIShown(str, str2, str3);
        }
    }

    public static void control(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (ServiceFactory.getService(UserTrackService.class) != null) {
            ((UserTrackService) ServiceFactory.getService(UserTrackService.class)).sendControlUT(str, str2, str3, str4, null, map);
        } else if (DEBUG) {
            Log.e(TAG, "UserTrackService is null!");
        }
    }

    private static UserTrackService getUserTrackService() {
        UserTrackService userTrackService = (UserTrackService) ServiceFactory.getService(UserTrackService.class);
        if (userTrackService == null && DEBUG) {
            Log.e(TAG, "UserTrackService is null!");
        }
        return userTrackService;
    }

    public static void pageDisAppear(Activity activity) {
        if (getUserTrackService() != null) {
            getUserTrackService().pageDisAppear(activity);
        }
    }

    public static void sendControlUT(String str, String str2) {
        if (getUserTrackService() != null) {
            getUserTrackService().sendControlUT(str, str2);
        }
    }

    public static void sendUT(String str) {
        sendUT(null, str, null);
    }

    public static void sendUserTrack(String str, String str2, Map<String, String> map) {
        if (ServiceFactory.getService(UserTrackService.class) != null) {
            ((UserTrackService) ServiceFactory.getService(UserTrackService.class)).sendUserTrack(str, str2, map);
        } else if (DEBUG) {
            Log.e(TAG, "UserTrackService is null!");
        }
    }

    public static void skipPage(Activity activity) {
        if (getUserTrackService() != null) {
            getUserTrackService().skipPage(activity);
        }
    }

    public static void updatePageName(Activity activity, String str, String str2) {
        if (getUserTrackService() != null) {
            getUserTrackService().updatePageName(activity, str, str2);
        }
    }

    public static void sendUT(int i) {
        sendUT(null, String.valueOf(i), null);
    }

    public static void sendControlUT(String str, String str2, String str3) {
        if (getUserTrackService() != null) {
            getUserTrackService().sendControlUT(str, str2, str3);
        }
    }

    public static void sendUT(String str, String str2) {
        sendUT(str, str2, null);
    }

    public static void updatePageName(Activity activity, String str) {
        if (getUserTrackService() != null) {
            getUserTrackService().updatePageName(activity, str, null);
        }
    }

    public static void sendUT(String str, Properties properties) {
        sendUT(null, str, properties);
    }

    public static void control(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (ServiceFactory.getService(UserTrackService.class) != null) {
            ((UserTrackService) ServiceFactory.getService(UserTrackService.class)).sendControlUT(str, str2, str3, str4, str5, map);
        } else if (DEBUG) {
            Log.e(TAG, "UserTrackService is null!");
        }
    }

    public static void sendControlUT(String str, String str2, String str3, String str4) {
        if (ServiceFactory.getService(UserTrackService.class) != null) {
            ((UserTrackService) ServiceFactory.getService(UserTrackService.class)).sendControlUT(str, str2, str3, str4, null, null);
        } else if (DEBUG) {
            Log.e(TAG, "UserTrackService is null!");
        }
    }

    public static void sendUT(String str, String str2, Properties properties) {
        sendUT(str, str2, null, properties);
    }

    public static void sendUT(String str, String str2, String str3, Properties properties) {
        sendUT(str, str2, str3, null, properties);
    }

    public static void sendUT(String str, String str2, String str3, String str4, Properties properties) {
        try {
            if (getUserTrackService() != null) {
                getUserTrackService().sendUT(str, str2, str3, str4, properties);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void control(String str, String str2, String str3) {
        if (ServiceFactory.getService(UserTrackService.class) != null) {
            ((UserTrackService) ServiceFactory.getService(UserTrackService.class)).sendControlUT(str, str2, str3, null, null, null);
        } else {
            Log.e("login.UserTrackAdapter", "UserTrackService is null!");
        }
    }

    public static void sendControlUT(String str, String str2, String str3, Map<String, String> map) {
        if (getUserTrackService() != null) {
            getUserTrackService().sendControlUT(str, str2, str3, map);
        }
    }

    public static void sendControlUT(String str, String str2, String str3, String str4, Map<String, String> map) {
        if (getUserTrackService() != null) {
            getUserTrackService().sendControlUT(str, null, str2, str3, str4, map);
        }
    }
}
