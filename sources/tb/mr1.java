package tb;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class mr1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final String[] CALENDAR;
    public static final String[] CAMERA;
    public static final String[] CAMERA_STORAGE;
    public static final String[] CONTACTS;
    public static final String[] LOCATION;
    public static final String[] MICROPHONE;
    public static final Map<String, String> PERMISSION_NAME_MAP;
    public static final String[] SENSORS;
    public static final String[] SMS;
    public static final String[] STORAGE;

    static {
        HashMap hashMap = new HashMap();
        PERMISSION_NAME_MAP = hashMap;
        if (Build.VERSION.SDK_INT < 23) {
            CALENDAR = new String[0];
            CAMERA = new String[0];
            CONTACTS = new String[0];
            LOCATION = new String[0];
            MICROPHONE = new String[0];
            SENSORS = new String[0];
            SMS = new String[0];
            STORAGE = new String[0];
            CAMERA_STORAGE = new String[0];
            return;
        }
        String[] strArr = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
        CALENDAR = strArr;
        String[] strArr2 = {"android.permission.CAMERA"};
        CAMERA = strArr2;
        String[] strArr3 = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
        CONTACTS = strArr3;
        String[] strArr4 = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
        LOCATION = strArr4;
        String[] strArr5 = {"android.permission.RECORD_AUDIO"};
        MICROPHONE = strArr5;
        String[] strArr6 = {"android.permission.BODY_SENSORS"};
        SENSORS = strArr6;
        String[] strArr7 = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
        SMS = strArr7;
        String[] strArr8 = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        STORAGE = strArr8;
        CAMERA_STORAGE = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        a(hashMap, strArr2, "相机");
        a(hashMap, strArr8, "存储");
        a(hashMap, strArr, "日历");
        a(hashMap, strArr4, "位置");
        a(hashMap, strArr3, "通讯录");
        a(hashMap, strArr6, "传感器");
        a(hashMap, strArr5, "麦克风");
        a(hashMap, strArr7, "短信");
    }

    private static void a(Map<String, String> map, String[] strArr, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-774075136")) {
            ipChange.ipc$dispatch("-774075136", new Object[]{map, strArr, str});
        } else if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                map.put(str2, str);
            }
        }
    }

    @NonNull
    public static String[] b(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-448264067")) {
            return (String[]) ipChange.ipc$dispatch("-448264067", new Object[]{list});
        }
        if (list != null && list.size() > 0) {
            HashSet hashSet = new HashSet();
            for (String str : list) {
                String str2 = PERMISSION_NAME_MAP.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
            if (hashSet.size() > 0) {
                return (String[]) hashSet.toArray(new String[hashSet.size()]);
            }
        }
        return new String[]{" "};
    }
}
