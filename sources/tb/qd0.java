package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class qd0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CMD_AUTH_PREFIX = "2235";
    public static final String CMD_GET_UID = "260100";
    public static final String CMD_LOGIN_PREFIX = "22E416";
    public static final String CMD_READ_PREFIX = "2220";
    public static final String CMD_SECURE_READ_PREFIX = "22A516";
    public static final String CMD_SECURE_WRITE_PREFIX = "22A616";
    public static final String CMD_WRITE_PREFIX = "2221";
    public static final String RESP_AUTH_RESULT_PREFIX = "04A7";
    public static final String TAG = "qd0";

    public static byte[] a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1608349508") ? (byte[]) ipChange.ipc$dispatch("1608349508", new Object[0]) : vk2.d(CMD_GET_UID);
    }
}
