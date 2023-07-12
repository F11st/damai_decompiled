package com.taobao.accs.utl;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.connection.ElectionServiceImpl;
import com.taobao.accs.data.Message;
import com.taobao.accs.net.BaseConnection;
import com.taobao.aranger.ARanger;
import com.taobao.weex.annotation.JSMethod;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Random;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.lu2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class NoTraceTriggerHelper {
    static String ACTION_BACK = null;
    static String ACTION_FORE = null;
    static final String TAG = "NoTraceTriggerHelper";
    static final Random random = new Random();
    public static int channel = 0;
    static BroadcastReceiver eventReceiver = new BroadcastReceiver() { // from class: com.taobao.accs.utl.NoTraceTriggerHelper.1
        private volatile long lastEventSendTime;

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, final Intent intent) {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.utl.NoTraceTriggerHelper.1.1
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    String action = intent.getAction();
                    if ("android.intent.action.ACTION_POWER_CONNECTED".equals(action)) {
                        i = 4;
                    } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                        i = 5;
                    } else if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                        i = 6;
                    } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                        ALog.e(NoTraceTriggerHelper.TAG, "Trigger SCREEN_ON", new Object[0]);
                        i = 1;
                    } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        ALog.e(NoTraceTriggerHelper.TAG, "Trigger SCREEN_OFF", new Object[0]);
                        i = 3;
                    } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                        i = 2;
                    } else if (NoTraceTriggerHelper.ACTION_FORE.equals(action)) {
                        i = 0;
                    } else {
                        i = NoTraceTriggerHelper.ACTION_BACK.equals(action) ? 7 : -1;
                    }
                    if (!"com.taobao.taobao".equals(context.getPackageName()) && OrangeAdapter.isTriggerEnable(context)) {
                        NoTraceTriggerHelper.trigger(context, null, 8, i);
                    }
                    if (OrangeAdapter.isEventCollectEnable(context)) {
                        try {
                            if (TextUtils.isEmpty(OrangeAdapter.getEventCollectStrategy(context))) {
                                return;
                            }
                            JSONObject jSONObject = new JSONObject(OrangeAdapter.getEventCollectStrategy(context));
                            int i2 = jSONObject.getInt(Constants.KEY_EVENT_COLLECT_RANDOM_TIME_LIMIT);
                            int i3 = jSONObject.getInt(Constants.KEY_EVENT_COLLECT_REPORT_INTERVAL);
                            JSONArray jSONArray = jSONObject.getJSONArray(Constants.KEY_EVENT_COLLECT_EVENT_ID_LIST);
                            int length = jSONArray.length();
                            int[] iArr = new int[length];
                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                iArr[i4] = ((Integer) jSONArray.get(i4)).intValue();
                            }
                            for (int i5 = 0; i5 < length; i5++) {
                                if (iArr[i5] == i) {
                                    final BaseConnection connection = ElectionServiceImpl.getConnection(context, "default", true, 0);
                                    if (connection != null) {
                                        if (System.currentTimeMillis() - AnonymousClass1.this.lastEventSendTime >= i3) {
                                            AnonymousClass1.this.lastEventSendTime = System.currentTimeMillis();
                                            final Message buildEventMessage = Message.buildEventMessage(i, System.currentTimeMillis(), connection.getHost(null), "default", context);
                                            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.utl.NoTraceTriggerHelper.1.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    ALog.i(NoTraceTriggerHelper.TAG, "send event request", "in channel process");
                                                    connection.sendMessage(buildEventMessage, true);
                                                }
                                            }, NoTraceTriggerHelper.random.nextInt(i2), TimeUnit.MILLISECONDS);
                                            return;
                                        }
                                        return;
                                    }
                                    ALog.e(NoTraceTriggerHelper.TAG, "connection is null in channel", new Object[0]);
                                    return;
                                }
                            }
                        } catch (Exception unused) {
                            ALog.e(NoTraceTriggerHelper.TAG, "send event request error", new Object[0]);
                        }
                    }
                }
            });
        }
    };
    private static ScheduledFuture<?> scheduledFuture = null;
    private static CycleTriggerRunnable cycleTriggerRunnable = null;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ChannelType {
        public static final int AGOO = 0;
        public static final int BAI_CHUAN = 1;
        public static final int UMENG = 2;

        /* compiled from: Taobao */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes8.dex */
        public @interface Definition {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class CycleTriggerRunnable implements Runnable {
        private final long cycleCutOffTime;
        private final Bundle extras;

        public CycleTriggerRunnable(long j, Bundle bundle) {
            this.cycleCutOffTime = j;
            this.extras = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() >= this.cycleCutOffTime) {
                if (NoTraceTriggerHelper.scheduledFuture != null) {
                    NoTraceTriggerHelper.scheduledFuture.cancel(false);
                    return;
                }
                return;
            }
            NoTraceTriggerHelper.startTriggerProcess(ARanger.getContext(), this.extras, false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface TriggerType {
        public static final int ACCS = 6;
        public static final int CYCLE = 7;
        public static final int DEFAULT = 0;
        public static final int EVENT = 8;
        public static final int MODULE = 5;
        public static final int NOTIFY = 4;
        public static final int PUSH = 3;
        public static final int START = 1;
        public static final int TIMER = 2;
    }

    static boolean isTargetAlive(Context context, String str) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, AdapterUtilityImpl.channelService));
        return context.stopService(intent);
    }

    public static void registerEventReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        if (TextUtils.isEmpty(ACTION_FORE)) {
            ACTION_FORE = context.getPackageName() + JSMethod.NOT_SET + ForeBackManager.ACTION_STATE_FORE;
        }
        if (TextUtils.isEmpty(ACTION_BACK)) {
            ACTION_BACK = context.getPackageName() + JSMethod.NOT_SET + ForeBackManager.ACTION_STATE_BACK;
        }
        intentFilter.addAction(ACTION_FORE);
        intentFilter.addAction(ACTION_BACK);
        intentFilter.setPriority(Integer.MAX_VALUE);
        context.registerReceiver(eventReceiver, intentFilter);
    }

    static void startInstrumentation(Context context, Bundle bundle) {
        String string = bundle.getString("packageName");
        if (isTargetAlive(context, string)) {
            return;
        }
        try {
            context.startInstrumentation(new ComponentName(string, "com.taobao.adaemon.TriggerInstrumentation"), null, bundle);
        } catch (Exception e) {
            ALog.e(TAG, "start trigger process error:", e, new Object[0]);
        }
    }

    static void startTriggerProcess(final Context context, final Bundle bundle, boolean z) {
        if (z) {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new Runnable() { // from class: com.taobao.accs.utl.NoTraceTriggerHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    NoTraceTriggerHelper.startInstrumentation(context, bundle);
                }
            });
        } else {
            startInstrumentation(context, bundle);
        }
    }

    public static void trigger(Context context, String str, int i) {
        if ("com.taobao.taobao".equals(context.getPackageName()) || !OrangeAdapter.isTriggerEnable(context)) {
            return;
        }
        trigger(OrangeAdapter.getStrategy(context), context, str, i, -1);
    }

    public static void trigger(Context context, String str, int i, int i2) {
        if ("com.taobao.taobao".equals(context.getPackageName()) || !OrangeAdapter.isTriggerEnable(context)) {
            return;
        }
        trigger(OrangeAdapter.getStrategy(context), context, str, i, i2);
    }

    public static void trigger(String str, final Context context, String str2, int i, int i2) {
        String str3;
        String str4;
        String str5;
        int i3;
        int[] iArr;
        String str6 = "packageName";
        String str7 = lu2.MAIN;
        String str8 = "channel";
        boolean z = true;
        try {
            if (i != 4 && i != 3 && i != 6) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() != 0) {
                    int i4 = 0;
                    while (i4 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i4);
                        if (jSONObject != null) {
                            String string = jSONObject.getString("package");
                            final Bundle bundle = new Bundle();
                            bundle.putString("origin", context.getPackageName());
                            bundle.putInt("type", i);
                            bundle.putInt(str8, channel);
                            bundle.putBoolean(str7, z);
                            bundle.putString(str6, string);
                            JSONArray jSONArray2 = jSONObject.getJSONArray(Constants.KEY_PULL_SCENE);
                            int length = jSONArray2.length();
                            int[] iArr2 = new int[length];
                            str3 = str6;
                            str4 = str7;
                            for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                                iArr2[i5] = ((Integer) jSONArray2.get(i5)).intValue();
                            }
                            int i6 = 0;
                            while (true) {
                                if (i6 >= length) {
                                    break;
                                }
                                int i7 = iArr2[i6];
                                if (i7 == 1 && i == 1) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (jSONObject.has(Constants.SP_KEY_LAST_TRIGGER_TIME)) {
                                        currentTimeMillis = jSONObject.getLong(Constants.SP_KEY_LAST_TRIGGER_TIME);
                                    }
                                    if (UtilityImpl.isSameDay(currentTimeMillis, System.currentTimeMillis())) {
                                        int i8 = jSONObject.getInt(Constants.KEY_TIMES);
                                        int i9 = jSONObject.has(Constants.SP_KEY_TRIGGER_TIMES) ? jSONObject.getInt(Constants.SP_KEY_TRIGGER_TIMES) : 0;
                                        if (i9 < i8) {
                                            str5 = str8;
                                            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new Runnable() { // from class: com.taobao.accs.utl.NoTraceTriggerHelper.2
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    NoTraceTriggerHelper.startTriggerProcess(context, bundle, false);
                                                }
                                            }, random.nextInt(jSONObject.getInt(Constants.KEY_DELAY_CEILING)), TimeUnit.SECONDS);
                                            jSONObject.put(Constants.SP_KEY_TRIGGER_TIMES, i9 + 1);
                                            jSONObject.put(Constants.SP_KEY_LAST_TRIGGER_TIME, System.currentTimeMillis());
                                        }
                                    } else {
                                        str5 = str8;
                                        jSONObject.put(Constants.SP_KEY_TRIGGER_TIMES, 0);
                                    }
                                } else {
                                    str5 = str8;
                                    if (i7 == 2 && i == 8) {
                                        JSONArray jSONArray3 = jSONObject.getJSONArray(Constants.KEY_EVENT_LIST);
                                        int length2 = jSONArray3.length();
                                        int[] iArr3 = new int[length2];
                                        for (int i10 = 0; i10 < jSONArray3.length(); i10++) {
                                            iArr3[i10] = ((Integer) jSONArray3.get(i10)).intValue();
                                        }
                                        int i11 = 0;
                                        while (i11 < length2) {
                                            if (i2 == iArr3[i11]) {
                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                if (jSONObject.has(Constants.SP_KEY_LAST_EVENT_TRIGGER_TIME)) {
                                                    currentTimeMillis2 = jSONObject.getLong(Constants.SP_KEY_LAST_EVENT_TRIGGER_TIME);
                                                }
                                                i3 = length2;
                                                iArr = iArr3;
                                                if (UtilityImpl.isSameDay(currentTimeMillis2, System.currentTimeMillis())) {
                                                    int i12 = jSONObject.getInt(Constants.KEY_EVENT_TIMES);
                                                    int i13 = jSONObject.has(Constants.SP_KEY_EVENT_TRIGGER_TIMES) ? jSONObject.getInt(Constants.SP_KEY_EVENT_TRIGGER_TIMES) : 0;
                                                    if (i13 < i12) {
                                                        startTriggerProcess(context, bundle, false);
                                                        jSONObject.put(Constants.SP_KEY_EVENT_TRIGGER_TIMES, i13 + 1);
                                                        jSONObject.put(Constants.SP_KEY_LAST_EVENT_TRIGGER_TIME, System.currentTimeMillis());
                                                    }
                                                } else {
                                                    jSONObject.put(Constants.SP_KEY_EVENT_TRIGGER_TIMES, 0);
                                                }
                                            } else {
                                                i3 = length2;
                                                iArr = iArr3;
                                            }
                                            i11++;
                                            length2 = i3;
                                            iArr3 = iArr;
                                        }
                                    } else if (i7 == 3 && i == 7) {
                                        long j = jSONObject.getLong(Constants.KEY_CYCLE_CUT_OFF_TIME);
                                        int i14 = jSONObject.getInt(Constants.KEY_CYCLE_INTERVAL);
                                        if (System.currentTimeMillis() < j) {
                                            if (cycleTriggerRunnable == null) {
                                                cycleTriggerRunnable = new CycleTriggerRunnable(j, bundle);
                                            }
                                            ScheduledFuture<?> scheduledFuture2 = scheduledFuture;
                                            if (scheduledFuture2 != null) {
                                                scheduledFuture2.cancel(false);
                                            }
                                            scheduledFuture = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleAtFixedRate(cycleTriggerRunnable, 0L, i14, TimeUnit.MINUTES);
                                        }
                                    } else {
                                        i6++;
                                        str8 = str5;
                                    }
                                }
                            }
                        } else {
                            str3 = str6;
                            str4 = str7;
                        }
                        str5 = str8;
                        i4++;
                        str6 = str3;
                        str7 = str4;
                        str8 = str5;
                        z = true;
                    }
                    OrangeAdapter.saveStrategy(context, jSONArray.toString());
                }
            } else if (!TextUtils.isEmpty(str2)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("origin", context.getPackageName());
                bundle2.putInt("type", i);
                bundle2.putInt("channel", channel);
                bundle2.putBoolean(lu2.MAIN, true);
                bundle2.putString("packageName", str2);
                startTriggerProcess(context, bundle2, true);
            }
        } catch (Exception e) {
            ALog.e(TAG, "trigger error:", e, new Object[0]);
        }
    }
}
