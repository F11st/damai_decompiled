package com.android.alibaba.ip.server;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.alibaba.aliweex.adapter.module.audio.IWXAudio;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Restarter {
    public static List<Activity> getActivities(Context context, boolean z) {
        Class<?> cls;
        Object activityThread;
        Field declaredField;
        Collection values;
        ArrayList arrayList = new ArrayList();
        try {
            cls = Class.forName("android.app.ActivityThread");
            activityThread = MonkeyPatcher.getActivityThread(context, cls);
            declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
        } catch (Throwable th) {
            if (Log.isLoggable("InstantRun", 5)) {
                Log.w("InstantRun", "Error retrieving activities", th);
            }
        }
        if (hasAppCrashed(context, cls, activityThread)) {
            return new ArrayList();
        }
        Object obj = declaredField.get(activityThread);
        if (obj instanceof HashMap) {
            values = ((HashMap) obj).values();
        } else if (Build.VERSION.SDK_INT < 19 || !(obj instanceof ArrayMap)) {
            return arrayList;
        } else {
            values = ((ArrayMap) obj).values();
        }
        for (Object obj2 : values) {
            Class<?> cls2 = obj2.getClass();
            if (z) {
                Field declaredField2 = cls2.getDeclaredField(IWXAudio.KEY_PAUSED);
                declaredField2.setAccessible(true);
                declaredField2.getBoolean(obj2);
            } else {
                Field declaredField3 = cls2.getDeclaredField("activity");
                declaredField3.setAccessible(true);
                Activity activity = (Activity) declaredField3.get(obj2);
                if (activity != null) {
                    arrayList.add(activity);
                }
            }
        }
        return arrayList;
    }

    public static Activity getForegroundActivity(Context context) {
        List<Activity> activities = getActivities(context, true);
        if (activities.isEmpty()) {
            return null;
        }
        return activities.get(0);
    }

    private static String getPackageName(Class cls, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return (String) cls.getDeclaredMethod("currentPackageName", new Class[0]).invoke(obj, new Object[0]);
    }

    private static boolean hasAppCrashed(Context context, Class cls, Object obj) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (context != null && obj != null) {
            String packageName = getPackageName(cls, obj);
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = ((ActivityManager) context.getSystemService("activity")).getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.processName.equals(packageName) && processErrorStateInfo.condition != 0) {
                        if (Log.isLoggable("InstantRun", 2)) {
                            Log.v("InstantRun", "App Thread has crashed, return empty activity list.");
                            return true;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static void restartActivity(Activity activity) {
        if (Log.isLoggable("InstantRun", 2)) {
            Log.v("InstantRun", "About to restart " + activity.getClass().getSimpleName());
        }
        while (activity.getParent() != null) {
            if (Log.isLoggable("InstantRun", 2)) {
                Log.v("InstantRun", activity.getClass().getSimpleName() + " is not a top level activity; restarting " + activity.getParent().getClass().getSimpleName() + " instead");
            }
            activity = activity.getParent();
        }
        activity.recreate();
    }

    public static void restartActivityOnUiThread(final Activity activity) {
        activity.runOnUiThread(new Runnable() { // from class: com.android.alibaba.ip.server.Restarter.1
            @Override // java.lang.Runnable
            public void run() {
                if (Log.isLoggable("InstantRun", 2)) {
                    Log.v("InstantRun", "Resources updated: notify activities");
                }
                Restarter.updateActivity(activity);
            }
        });
    }

    public static void restartApp(Context context, Collection<Activity> collection, boolean z) {
        if (collection.isEmpty()) {
            return;
        }
        Activity foregroundActivity = getForegroundActivity(context);
        if (foregroundActivity != null) {
            if (z) {
                showToast(foregroundActivity, "Restarting app to apply incompatible changes");
            }
            if (Log.isLoggable("InstantRun", 2)) {
                Log.v("InstantRun", "RESTARTING APP");
            }
            ((AlarmManager) foregroundActivity.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 100, PendingIntent.getActivity(foregroundActivity, 0, new Intent(foregroundActivity, foregroundActivity.getClass()), 268435456));
            if (Log.isLoggable("InstantRun", 2)) {
                Log.v("InstantRun", "Scheduling activity " + foregroundActivity + " to start after exiting process");
            }
        } else {
            showToast(collection.iterator().next(), "Unable to restart app");
            if (Log.isLoggable("InstantRun", 2)) {
                Log.v("InstantRun", "Couldn't find any foreground activities to restart for resource refresh");
            }
        }
        System.exit(0);
    }

    static void showToast(final Activity activity, final String str) {
        if (Log.isLoggable("InstantRun", 2)) {
            Log.v("InstantRun", "About to show toast for activity " + activity + ": " + str);
        }
        activity.runOnUiThread(new Runnable() { // from class: com.android.alibaba.ip.server.Restarter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Context applicationContext = activity.getApplicationContext();
                    if ((applicationContext instanceof ContextWrapper) && ((ContextWrapper) applicationContext).getBaseContext() == null) {
                        if (Log.isLoggable("InstantRun", 5)) {
                            Log.w("InstantRun", "Couldn't show toast: no base context");
                            return;
                        }
                        return;
                    }
                    int i = 0;
                    Toast.makeText(activity, str, (str.length() >= 60 || str.indexOf(10) != -1) ? 1 : 1).show();
                } catch (Throwable th) {
                    if (Log.isLoggable("InstantRun", 5)) {
                        Log.w("InstantRun", "Couldn't show toast", th);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateActivity(Activity activity) {
        restartActivity(activity);
    }
}
