package com.youku.android.opr;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.android.barrage.utils.OPRBitmapUtils;
import com.youku.android.barrage.utils.OPRTextUtils;
import com.youku.android.utils.ApsConfigParams;
import com.youku.android.utils.OPRUtils;
import com.youku.android.utils.OprLogUtils;

/* compiled from: Taobao */
@Keep
/* loaded from: classes8.dex */
public class OprEngine {
    private static final String TAG = "OprEngine";

    static {
        System.loadLibrary(FeatureManager.FEATURE_KEY_OPR);
    }

    private OprEngine(Context context) {
        OPRUtils.setContext(context);
    }

    private static Object postMessageToOprEngine(int i, int i2, int i3, Object obj) {
        StringBuilder sb;
        String str;
        if (i != 3) {
            if (i != 4) {
                if (i == 6) {
                    if (obj == null) {
                        Log.e(TAG, "obj is null");
                        return null;
                    } else if (obj instanceof String) {
                        return OPRUtils.getShader((String) obj);
                    } else {
                        return null;
                    }
                } else if (i != 8) {
                    if (i == 9) {
                        return OPRUtils.getCurrentPhoneLevel();
                    }
                    Log.e(TAG, "Can not support such msg: " + i);
                } else if (obj == null) {
                    Log.e(TAG, "obj is null");
                    return null;
                } else {
                    try {
                        ApsConfigParams apsConfigParams = (ApsConfigParams) obj;
                        return OPRUtils.getApsConfig(apsConfigParams.mNs, apsConfigParams.mKey, apsConfigParams.mDefaultVal);
                    } catch (Throwable th) {
                        th = th;
                        sb = new StringBuilder();
                        str = "NOTIFY_OPR_GET_APS_CONFIG error: ";
                    }
                }
            } else if (obj == null) {
                Log.e(TAG, "obj is null");
                return null;
            } else if (obj instanceof String) {
                OprLogUtils.TLogPrint("TLogs", (String) obj);
            }
            return null;
        } else if (obj == null) {
            Log.e(TAG, "obj is null");
            return null;
        } else {
            try {
                OPRTextUtils oPRTextUtils = (OPRTextUtils) obj;
                return OPRBitmapUtils.getOPRBarrageBitmap(oPRTextUtils.mText, oPRTextUtils.mTextColor, oPRTextUtils.mTextSize, oPRTextUtils.mFontFile, oPRTextUtils.mIsGradualColor, oPRTextUtils.mStartColor, oPRTextUtils.mEndColor);
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "NOTIFY_GET_STR_BITMAP error: ";
            }
        }
        sb.append(str);
        sb.append(th.toString());
        Log.e(TAG, sb.toString());
        return null;
    }
}
