package mtopsdk.mtop.features;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface MtopFeature {
    public static final int DISABLE_WHITEBOX_SIGN = 3;
    public static final int DISABLE_X_COMMAND = 5;
    public static final int H5_REQUEST = 11;
    public static final int PRIORITY_FLAG = 12;
    public static final int SUPPORT_OPEN_ACCOUNT = 6;
    public static final int SUPPORT_RELATIVE_URL = 1;
    public static final int SUPPORT_UTDID_UNIT = 4;
    public static final int UNIT_INFO_FEATURE = 2;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface Definition {
    }
}
