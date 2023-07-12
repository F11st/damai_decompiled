package com.ta.utdid2.device;

import android.content.Context;
import com.ta.audid.Constants;
import com.ta.audid.Variables;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes7.dex */
public class UTDevice {
    public static int getType() {
        return UTUtdid.getType();
    }

    @Deprecated
    public static String getUtdid(Context context) {
        if (context == null) {
            return Constants.UTDID_INVALID;
        }
        Variables.getInstance().initContext(context);
        Variables.getInstance().init();
        return AppUtdid.getInstance().getUtdid(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return getUtdid(context);
    }
}
