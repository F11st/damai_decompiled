package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class r10 {
    public static final String ASSET_DIR = "template/";
    public static final String ASSET_PRESET_TEMPLATE_INFOLIST = "/presetTemplateInfos.json";
    public static final String ASSET_PRESET_TEMPLATE_OTHER = "other";
    public static final String ASSET_PRESET_TEMPLATE_VERSION = "version";
    public static final String DB_NAME = "dinamicx";
    public static final String DEFAULT_ROOT_DIR = "dinamicx/";
    public static final char DIR = '/';
    public static final String DX_MAIN_TEMPLATE_NAME = "main.dx";

    public static long a(String[] strArr) {
        long j = -1;
        if (strArr != null && strArr.length >= 1) {
            if (strArr.length == 1) {
                try {
                    return Long.valueOf(strArr[0]).longValue();
                } catch (NumberFormatException unused) {
                    return -1L;
                }
            }
            long j2 = -1;
            for (String str : strArr) {
                try {
                    j2 = Long.valueOf(str).longValue();
                } catch (NumberFormatException unused2) {
                }
                if (j2 > j) {
                    j = j2;
                }
            }
        }
        return j;
    }

    public static boolean b(DXTemplateItem dXTemplateItem) {
        return (dXTemplateItem == null || TextUtils.isEmpty(dXTemplateItem.name) || dXTemplateItem.version <= -1) ? false : true;
    }

    public static boolean c(String str, DXTemplateItem dXTemplateItem) {
        return b(dXTemplateItem) && !TextUtils.isEmpty(str);
    }
}
