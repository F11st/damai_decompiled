package io.flutter.wpkbridge;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.webkit.ValueCallback;
import io.flutter.Log;
import io.flutter.wpkbridge.U4Line;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class U4WPKAdapter extends HashMap<String, String> implements ValueCallback<U4StatLine>, U4Line.Clearable {
    private static final String KEY_PREFIX = "w_";
    public static final String KEY_TM = "tm";
    private static final String LOG_TYPE_PVUV = "pvuv";
    private static final int UCDATAFLOW_COMPRESS = 1;
    public static final boolean UCDATAFLOW_DEBUG = false;
    private static final boolean UCDATAFLOW_ENCODE = true;
    private static final boolean UCDATAFLOW_LOCAL_ENCODE = true;
    private static boolean sHasRegisteredCallback;
    private static boolean sHasSetCustomConfigFilters;
    private static boolean sHasSetCustomFields;
    private static Method sWaStatMethod;
    private ValueCallback<Message> mEntry;
    private static final String[] NULL_STRING_ARR = new String[0];
    private static final HashMap<String, ValueCallback<Message>> sLogInst = new HashMap<>();
    private static final HashMap<String, ValueCallback<U4StatLine>> sLogWpkInst = new HashMap<>();
    private static long sServerTimeMillis = -1;
    private static long sClientTimeMillis = -1;
    private static final ValueCallback<Pair<Message, Message>> sInternalCallback = new ValueCallback<Pair<Message, Message>>() { // from class: io.flutter.wpkbridge.U4WPKAdapter.1
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(Pair<Message, Message> pair) {
            try {
                Message message = (Message) pair.first;
                Message message2 = (Message) pair.second;
                Object obj = message.obj;
                if (message.what == 4 && (obj instanceof Pair)) {
                    Pair pair2 = (Pair) obj;
                    Object obj2 = pair2.first;
                    if (obj2 instanceof String) {
                        Object obj3 = pair2.second;
                        if (obj3 instanceof HashMap) {
                            U4WPKAdapter.stat((String) obj2, (HashMap) obj3);
                        }
                    }
                }
                message2.obj = null;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    };
    private static final ValueCallback<Pair<Message, Message>> sConfigChangeCallback = new ValueCallback<Pair<Message, Message>>() { // from class: io.flutter.wpkbridge.U4WPKAdapter.2
        @Override // android.webkit.ValueCallback
        public void onReceiveValue(Pair<Message, Message> pair) {
        }
    };
    private static Object sSetCustomConfigFiltersLock = new Object();
    private static Object sRegisterCallLock = new Object();

    public U4WPKAdapter(ValueCallback<Message> valueCallback, String str) {
        this.mEntry = valueCallback;
    }

    public static void ensureCustomConfigFiltersSet() {
        synchronized (sSetCustomConfigFiltersLock) {
            if (sHasSetCustomConfigFilters) {
                return;
            }
            sHasSetCustomConfigFilters = true;
        }
    }

    private static void ensureCustomFieldsSet() {
        if (sHasSetCustomFields) {
            return;
        }
        sHasSetCustomFields = true;
    }

    public static JSONObject getConfigs() {
        try {
            JSONObject jSONObject = (JSONObject) WPKFactory.get(3, null);
            return jSONObject == null ? new JSONObject() : jSONObject;
        } catch (Exception unused) {
            return new JSONObject();
        } finally {
            new JSONObject();
        }
    }

    public static ValueCallback<Message> getEntry(int i, String str) {
        HashMap<String, ValueCallback<Message>> hashMap = sLogInst;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                return hashMap.get(str);
            }
            try {
                ensureCustomConfigFiltersSet();
                registerCallback();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(WPKFactory.INSTANCE_KEY_LOG_KIND, Integer.valueOf(i));
                hashMap2.put(WPKFactory.INSTANCE_KEY_LOG_TYPE, str);
                ValueCallback<Message> createLogInstance = WPKFactory.createLogInstance(hashMap2);
                if (createLogInstance != null) {
                    hashMap.put(str, createLogInstance);
                }
                return createLogInstance;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static ValueCallback<U4StatLine> getWPKAdapter(int i, String str) {
        HashMap<String, ValueCallback<U4StatLine>> hashMap = sLogWpkInst;
        synchronized (hashMap) {
            if (hashMap.containsKey(str)) {
                return hashMap.get(str);
            }
            try {
                ValueCallback<Message> entry = getEntry(i, str);
                if (entry == null) {
                    return null;
                }
                U4WPKAdapter u4WPKAdapter = new U4WPKAdapter(entry, str);
                hashMap.put(str, u4WPKAdapter);
                return u4WPKAdapter;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static long goodTimeMillis() {
        if (sClientTimeMillis == -1) {
            JSONObject configs = getConfigs();
            long optLong = configs.optLong(WPKFactory.CONF_SERVER_TIME, -1L);
            if (optLong != -1) {
                long optLong2 = configs.optLong(WPKFactory.CONF_CLIENT_TIME, -1L);
                if (optLong2 != -1) {
                    sServerTimeMillis = optLong;
                    sClientTimeMillis = optLong2;
                }
            }
            return System.currentTimeMillis();
        }
        return (SystemClock.elapsedRealtime() - sClientTimeMillis) + sServerTimeMillis;
    }

    public static void logFile(String str, String str2, Map<String, String> map, String str3, JSONObject jSONObject, String str4, String str5) {
        Log.d("WPKFlowLog", "U4WPKAdapter.logFile");
        Log.d(WPKStatsUtil.LOG_TAG, "U4WPKAdapter.logFile");
        ValueCallback<Message> entry = getEntry(1, str);
        if (entry == null) {
            return;
        }
        ensureCustomFieldsSet();
        entry.onReceiveValue(Message.obtain((Handler) null, 2));
        HashMap hashMap = new HashMap();
        if (map.containsKey("linkKey")) {
            hashMap.put("link_key", map.get("linkKey"));
        }
        if (map.containsKey("linkID")) {
            hashMap.put("link_id", map.get("linkID"));
        }
        if (!hashMap.isEmpty()) {
            entry.onReceiveValue(Message.obtain(null, 5, hashMap));
        }
        if (!map.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                arrayList.add(KEY_PREFIX + entry2.getKey());
                arrayList.add(entry2.getValue());
            }
            entry.onReceiveValue(Message.obtain(null, 3, 2, 0, new String[]{str2, "1.0"}));
            entry.onReceiveValue(Message.obtain(null, 1, arrayList.toArray(NULL_STRING_ARR)));
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            entry.onReceiveValue(Message.obtain(null, 3, 1, 1, new String[]{str3, "1.0"}));
            entry.onReceiveValue(Message.obtain(null, 1, jSONObject));
        }
        if (str5 != null && str5.length() > 0) {
            entry.onReceiveValue(Message.obtain(null, 3, 0, 1, new String[]{str4, "1.0"}));
            entry.onReceiveValue(Message.obtain(null, 1, str5));
        }
        if (!str.equals(LOG_TYPE_PVUV)) {
            getEntry(0, LOG_TYPE_PVUV).onReceiveValue(Message.obtain((Handler) null, 4));
        }
        entry.onReceiveValue(Message.obtain((Handler) null, 4));
    }

    public static void registerCallback() {
        synchronized (sRegisterCallLock) {
            if (sHasRegisteredCallback) {
                return;
            }
            WPKFactory.registerCallback(4, sInternalCallback);
            WPKFactory.registerCallback(1, sConfigChangeCallback);
            sHasRegisteredCallback = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stat(String str, HashMap hashMap) {
    }

    @Override // android.webkit.ValueCallback
    public void onReceiveValue(U4StatLine u4StatLine) {
        if (u4StatLine == null || this.mEntry == null) {
            return;
        }
        ensureCustomFieldsSet();
        HashMap hashMap = new HashMap();
        if (u4StatLine.containsKey("linkKey")) {
            hashMap.put("link_key", u4StatLine.get("linkKey"));
        }
        if (u4StatLine.containsKey("linkID")) {
            hashMap.put("link_id", u4StatLine.get("linkID"));
        }
        U4Line kvs = U4StatLine.obtain().kvs(u4StatLine, KEY_PREFIX);
        if (kvs instanceof U4StatLine) {
            U4StatLine u4StatLine2 = (U4StatLine) kvs;
            Log.d("WPKFlowLog", "U4WPKAdapter.onReceiveValue");
            Log.d(WPKStatsUtil.LOG_TAG, "U4WPKAdapter.onReceiveValue");
            Message obtain = Message.obtain(null, 6, new Pair(hashMap, new JSONObject(u4StatLine2)));
            u4StatLine2.recycle();
            this.mEntry.onReceiveValue(obtain);
        }
    }
}
