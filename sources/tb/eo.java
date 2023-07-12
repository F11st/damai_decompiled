package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class eo {
    public static final int FAILED_CLIENT_OBSOLETE = 3;
    public static final int FAILED_NOT_AUTHORIZED = 2;
    public static final int FAILED_UNSUPPORTED = 1;
    public static final int SUCCESS = 0;

    public static final String a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        StringBuilder sb = new StringBuilder(45);
                        sb.append("[UNKNOWN CONTROLLER INIT RESULT: ");
                        sb.append(i);
                        sb.append(jn1.ARRAY_END_STR);
                        return sb.toString();
                    }
                    return "FAILED_CLIENT_OBSOLETE";
                }
                return "FAILED_NOT_AUTHORIZED";
            }
            return "FAILED_UNSUPPORTED";
        }
        return "SUCCESS";
    }
}
