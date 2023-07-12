package io.flutter.wpkbridge;

import android.os.Message;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.extension.UCCore;
import io.flutter.Log;
import java.lang.reflect.Method;
import java.util.Map;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class WPKFactory {
    public static final int CALLBACK_CONFIG_CHANGE = 1;
    public static final int CALLBACK_DATA_SAVER_FILE_OK = 5;
    public static final int CALLBACK_ENCODE = 0;
    public static final int CALLBACK_FILE_GZ_ENCODE_OK = 6;
    public static final int CALLBACK_FILE_UPLOAD_OK = 7;
    public static final int CALLBACK_GET_LOCAL_ENCODE_SECRET = 8;
    public static final int CALLBACK_LOCAL_DECODE = 3;
    public static final int CALLBACK_LOCAL_ENCODE = 2;
    public static final int CALLBACK_PULL_LOG = 9;
    public static final int CALLBACK_STAT = 4;
    private static final String CLS_NAME = "com.uc.wpk.export.WPKFactory";
    public static final int COMPRESSION_METHOD_GZIP = 1;
    public static final int COMPRESSION_METHOD_NONE = 0;
    public static final int COMPRESSION_METHOD_ZIP = 2;
    public static final int CONFIG_UPDATE_BY_HTTP = 0;
    public static final int CONFIG_UPDATE_BY_PUSH = 1;
    public static final String CONF_CLIENT_TIME = "ctm";
    public static final String CONF_SERVER_TIME = "stm";
    public static final int DATA_SPLIT_LINE_BREAK = 0;
    public static final int DATA_SPLIT_MAX = 1;
    public static final int DATA_SPLIT_MIN = 0;
    public static final int DATA_SPLIT_NONE = 1;
    public static final int DATA_TYPE_BINARY = 3;
    public static final int DATA_TYPE_JSON = 1;
    public static final int DATA_TYPE_KEY_VALUE_PAIRS = 2;
    public static final int DATA_TYPE_MAX = 3;
    public static final int DATA_TYPE_MIN = 0;
    public static final int DATA_TYPE_TEXT = 0;
    public static final String INIT_KEY_APP_ID = "appid";
    public static final String INIT_KEY_APP_SECRET = "app_secret";
    public static final String INIT_KEY_CONFIG_UPDATE_MODE = "config_update_mode";
    public static final String INIT_KEY_CONTEXT = "context";
    public static final String INIT_KEY_CONTEXT_GETTER = "context_getter";
    public static final String INIT_KEY_DEBUG = "debug";
    public static final String INIT_KEY_GATE_WAY = "gate_way";
    public static final String INIT_KEY_GATE_WAY_HTTPS = "gate_way_https";
    public static final String INIT_KEY_LOCAL_ENCODE = "local_encode";
    public static final String INIT_KEY_LOCAL_ENOCODE_METHOD = "local_encode_method";
    public static final String INIT_KEY_LOG_UPLOAD_MODE = "log_upload_mode";
    public static final String INIT_KEY_RECORD_LOG_ACCUMULATION_TIME = "record_accumulation_time";
    public static final String INIT_KEY_ROOT_DIR_PREFIX = "root_dir_prefix";
    public static final String INIT_KEY_UPLOAD_COMPRESS = "upload_compress";
    public static final String INIT_KEY_UPLOAD_ENCODE = "upload_encode";
    public static final String INIT_KEY_UPLOAD_ENCODE_METHOD = "upload_encode_method";
    public static final String INSTANCE_KEY_LOG_KIND = "log_kind";
    public static final String INSTANCE_KEY_LOG_TYPE = "log_type";
    public static final int KEY_COMMON_CUSTOM_FILELDS = 0;
    public static final int KEY_COMMON_FIELDS_MASK = 2;
    public static final int KEY_CONFIGS = 1;
    public static final int KEY_CURRENT_CONFIGURES = 3;
    public static final int KEY_CUSTOM_CONFIG_FILTERS = 4;
    public static final int KEY_GENERATE_LOCAL_SECRET = 2;
    public static final int KEY_IS_INITIALIZED = 1;
    public static final int KEY_LOG_TYPE_CUSTOM_FIELDS = 3;
    public static final int LOG_KIND_FILE = 1;
    public static final int LOG_KIND_MAXIMUM = 1;
    public static final int LOG_KIND_MINIMUN = 0;
    public static final int LOG_KIND_RECORD = 0;
    public static final int LOG_UPLOAD_BY_CALLBACK_PULL = 1;
    public static final int LOG_UPLOAD_BY_HTTP = 0;
    public static final int MSG_CMD_CLOSE_FILE = 4;
    public static final int MSG_CMD_DATA = 1;
    public static final int MSG_CMD_DATA_WITH_HEADER = 6;
    public static final int MSG_CMD_HEADER = 5;
    public static final int MSG_CMD_NEW_FILE = 2;
    public static final int MSG_CMD_NEW_SECTION = 3;
    public static String TAG = "WPKFactory";
    private static Class<?> sClass;
    private static Method sGetMethod;
    private static Method sMdLogInst;
    private static Method sMdRegisterCB;
    private static Method sMdSetup;
    private static Method sSetMethod;

    public static ValueCallback<Message> createLogInstance(Map<String, Object> map) {
        try {
            if (sMdLogInst == null) {
                if (sClass == null) {
                    sClass = Class.forName(CLS_NAME);
                }
                sMdLogInst = sClass.getDeclaredMethod("createLogInstance", Map.class);
            }
            return (ValueCallback) sMdLogInst.invoke(null, map);
        } catch (Exception unused) {
            Log.e(WPKStatsUtil.LOG_TAG, "WPKFactory.createLogInstance() failed. It is probably that your app is lack of wpksdk.jar. If you don't need iTrace monitoring Hummer, just ignore it.");
            return null;
        }
    }

    public static Object get(int i, Object obj) {
        try {
            if (sGetMethod == null) {
                if (sClass == null) {
                    sClass = Class.forName(CLS_NAME);
                }
                sGetMethod = sClass.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, Integer.TYPE, Object.class);
            }
            return sGetMethod.invoke(null, Integer.valueOf(i), obj);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void init(Map<String, Object> map) throws Exception {
        try {
            if (sMdSetup == null) {
                if (sClass == null) {
                    sClass = Class.forName(CLS_NAME);
                }
                sMdSetup = sClass.getDeclaredMethod(UCCore.LEGACY_EVENT_INIT, Map.class);
            }
            sMdSetup.invoke(null, map);
        } catch (Exception unused) {
            Log.e(WPKStatsUtil.LOG_TAG, "WPKFactory.init() failed. It is probably that your app is lack of wpksdk.jar. If you don't need iTrace monitoring Hummer, just ignore it.");
        }
    }

    public static void registerCallback(int i, ValueCallback<Pair<Message, Message>> valueCallback) {
        try {
            if (sMdRegisterCB == null) {
                if (sClass == null) {
                    sClass = Class.forName(CLS_NAME);
                }
                sMdRegisterCB = sClass.getDeclaredMethod("registerCallback", Integer.TYPE, ValueCallback.class);
            }
            sMdRegisterCB.invoke(null, Integer.valueOf(i), valueCallback);
        } catch (Exception unused) {
            Log.e(WPKStatsUtil.LOG_TAG, "WPKFactory.registerCallback() failed. It is probably that your app is lack of wpksdk.jar. If you don't need iTrace monitoring Hummer, just ignore it.");
        }
    }

    public static void set(int i, Object obj, Object obj2) {
        try {
            if (sSetMethod == null) {
                if (sClass == null) {
                    sClass = Class.forName(CLS_NAME);
                }
                sSetMethod = sClass.getDeclaredMethod("set", Integer.TYPE, Object.class, Object.class);
            }
            sSetMethod.invoke(null, Integer.valueOf(i), obj, obj2);
        } catch (Exception unused) {
        }
    }
}
