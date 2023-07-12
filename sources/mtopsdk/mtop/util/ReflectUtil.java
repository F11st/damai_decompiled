package mtopsdk.mtop.util;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.MtopRequest;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ReflectUtil {
    private static final String API_NAME = "API_NAME";
    private static final String NEED_ECODE = "NEED_ECODE";
    private static final String NEED_SESSION = "NEED_SESSION";
    private static final String ORIGINALJSON = "ORIGINALJSON";
    private static final String SERIAL_VERSION_UID = "serialVersionUID";
    private static final String TAG = "mtopsdk.ReflectUtil";
    private static final String VERSION = "VERSION";

    @Deprecated
    public static String converMapToDataStr(Map<String, String> map) {
        return convertMapToDataStr(map);
    }

    public static String convertMapToDataStr(Map<String, String> map) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(jn1.BLOCK_START_STR);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    try {
                        sb.append(JSON.toJSONString(key));
                        sb.append(":");
                        sb.append(JSON.toJSONString(value));
                        sb.append(",");
                    } catch (Throwable th) {
                        StringBuilder sb2 = new StringBuilder(64);
                        sb2.append("[convertMapToDataStr] convert key=");
                        sb2.append(key);
                        sb2.append(",value=");
                        sb2.append(value);
                        sb2.append(" to dataStr error.");
                        TBSdkLog.e(TAG, sb2.toString(), th);
                    }
                }
            }
            int length = sb.length();
            if (length > 1) {
                sb.deleteCharAt(length - 1);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static MtopRequest convertToMtopRequest(Object obj) {
        MtopRequest mtopRequest = new MtopRequest();
        if (obj != null) {
            parseParams(mtopRequest, obj);
        }
        return mtopRequest;
    }

    @Deprecated
    private static boolean excludeField(String str, HashMap<String, String> hashMap, boolean z) {
        if (str.contains("$") || API_NAME.equals(str) || VERSION.equals(str) || NEED_ECODE.equals(str) || NEED_SESSION.equals(str) || SERIAL_VERSION_UID.equalsIgnoreCase(str) || ORIGINALJSON.equalsIgnoreCase(str)) {
            return true;
        }
        if (z) {
            return hashMap.containsKey(str);
        }
        return false;
    }

    @Deprecated
    public static Object getFieldValueByName(String str, Object obj) {
        Field[] declaredFields;
        if (obj != null && str != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getName().equals(str)) {
                    try {
                        return field.get(obj);
                    } catch (IllegalAccessException e) {
                        TBSdkLog.e(TAG, e.toString());
                    } catch (IllegalArgumentException e2) {
                        TBSdkLog.e(TAG, e2.toString());
                    }
                }
            }
        }
        return null;
    }

    @Deprecated
    public static boolean needEcode(Object obj) {
        Object fieldValueByName = getFieldValueByName(NEED_ECODE, obj);
        Boolean bool = Boolean.FALSE;
        if (fieldValueByName != null) {
            bool = (Boolean) fieldValueByName;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static boolean needJsonType(Object obj) {
        Object fieldValueByName = getFieldValueByName(ORIGINALJSON, obj);
        Boolean bool = Boolean.FALSE;
        if (fieldValueByName != null) {
            bool = (Boolean) fieldValueByName;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static boolean needSession(Object obj) {
        Object fieldValueByName = getFieldValueByName(NEED_SESSION, obj);
        Boolean bool = Boolean.FALSE;
        if (fieldValueByName != null) {
            bool = (Boolean) fieldValueByName;
        }
        return bool.booleanValue();
    }

    @Deprecated
    public static Map<String, String> parseDataParams(IMTOPDataObject iMTOPDataObject) {
        if (iMTOPDataObject == null) {
            return new HashMap();
        }
        return parseFields(iMTOPDataObject, iMTOPDataObject.getClass());
    }

    @Deprecated
    private static Map<String, String> parseFields(Object obj, Class<?> cls) {
        HashMap hashMap = new HashMap();
        parseFieldsToMap(obj, cls.getDeclaredFields(), hashMap, false);
        parseFieldsToMap(obj, cls.getFields(), hashMap, true);
        return hashMap;
    }

    @Deprecated
    private static void parseFieldsToMap(Object obj, Field[] fieldArr, HashMap<String, String> hashMap, boolean z) {
        Object obj2;
        if (fieldArr == null || fieldArr.length == 0) {
            return;
        }
        String str = null;
        for (Field field : fieldArr) {
            try {
                str = field.getName();
            } catch (Throwable th) {
                TBSdkLog.e(TAG, "[parseFieldsToMap]get biz param error through reflection.---" + th.toString());
                obj2 = null;
            }
            if (!excludeField(str, hashMap, z)) {
                field.setAccessible(true);
                obj2 = field.get(obj);
                if (obj2 != null) {
                    try {
                        if (obj2 instanceof String) {
                            hashMap.put(str, obj2.toString());
                        } else {
                            hashMap.put(str, JSON.toJSONString(obj2));
                        }
                    } catch (Throwable th2) {
                        TBSdkLog.e(TAG, "[parseFieldsToMap]transform biz param to json string error.---" + th2.toString());
                    }
                }
            }
        }
    }

    private static void parseParams(MtopRequest mtopRequest, Object obj) {
        try {
            HashMap hashMap = new HashMap();
            Class<?> cls = obj.getClass();
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(cls.getFields()));
            hashSet.addAll(Arrays.asList(cls.getDeclaredFields()));
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Field field = (Field) it.next();
                String name = field.getName();
                if (!name.contains("$") && !name.equals(SERIAL_VERSION_UID) && !name.equals(ORIGINALJSON)) {
                    boolean z = true;
                    field.setAccessible(true);
                    char c = 65535;
                    switch (name.hashCode()) {
                        case -513196083:
                            if (name.equals(NEED_SESSION)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 397645513:
                            if (name.equals(NEED_ECODE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 1069590712:
                            if (name.equals(VERSION)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 1779423664:
                            if (name.equals(API_NAME)) {
                                c = 0;
                                break;
                            }
                            break;
                    }
                    if (c == 0) {
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            mtopRequest.setApiName(obj2.toString());
                        }
                    } else if (c == 1) {
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            mtopRequest.setVersion(obj3.toString());
                        }
                    } else if (c == 2) {
                        Boolean valueOf = Boolean.valueOf(field.getBoolean(obj));
                        if (valueOf == null || !valueOf.booleanValue()) {
                            z = false;
                        }
                        mtopRequest.setNeedEcode(z);
                    } else if (c != 3) {
                        Object obj4 = field.get(obj);
                        if (obj4 != null) {
                            if (obj4 instanceof String) {
                                hashMap.put(name, obj4.toString());
                            } else {
                                hashMap.put(name, JSON.toJSONString(obj4));
                            }
                        }
                    } else {
                        Boolean valueOf2 = Boolean.valueOf(field.getBoolean(obj));
                        if (valueOf2 == null || !valueOf2.booleanValue()) {
                            z = false;
                        }
                        mtopRequest.setNeedSession(z);
                    }
                }
            }
            mtopRequest.dataParams = hashMap;
            mtopRequest.setData(convertMapToDataStr(hashMap));
        } catch (Exception e) {
            TBSdkLog.e(TAG, "parseParams failed.", e);
        }
    }

    @Deprecated
    public static void parseUrlParams(MtopRequest mtopRequest, Object obj) {
        if (obj != null) {
            Object fieldValueByName = getFieldValueByName(API_NAME, obj);
            if (fieldValueByName != null) {
                mtopRequest.setApiName(fieldValueByName.toString());
            }
            Object fieldValueByName2 = getFieldValueByName(VERSION, obj);
            if (fieldValueByName2 != null) {
                mtopRequest.setVersion(fieldValueByName2.toString());
            }
            if (needEcode(obj)) {
                mtopRequest.setNeedEcode(true);
            }
            if (needSession(obj)) {
                mtopRequest.setNeedSession(true);
            }
        }
    }

    public static MtopRequest convertToMtopRequest(IMTOPDataObject iMTOPDataObject) {
        MtopRequest mtopRequest = new MtopRequest();
        if (iMTOPDataObject != null) {
            parseParams(mtopRequest, iMTOPDataObject);
        }
        return mtopRequest;
    }

    @Deprecated
    private static Map<String, String> parseDataParams(Object obj) {
        if (obj == null) {
            return new HashMap();
        }
        return parseFields(obj, obj.getClass());
    }
}
