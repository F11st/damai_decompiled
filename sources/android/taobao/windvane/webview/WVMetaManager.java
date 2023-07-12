package android.taobao.windvane.webview;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVMetaManager {
    private static final String TAG = "WVMetaManager";
    private static volatile WVMetaManager instance;
    private JSONObject metaDataObject = null;
    private String[] metaKeys = null;

    public static WVMetaManager getInstance() {
        if (instance == null) {
            synchronized (WVMetaManager.class) {
                if (instance == null) {
                    instance = new WVMetaManager();
                }
            }
        }
        return instance;
    }

    public void clear() {
        this.metaDataObject = null;
    }

    public JSONObject getMetaData() {
        return this.metaDataObject;
    }

    public String[] getMetaKeys() {
        return this.metaKeys;
    }

    public void setMetaData(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.startsWith("\"") && str.endsWith("\"")) {
                str = str.substring(1, str.length() - 1);
            }
            this.metaDataObject = new JSONObject(str.replace("\\", ""));
        } catch (Exception unused) {
            this.metaDataObject = null;
        }
    }

    public void setMetaKeys(String[] strArr) {
        this.metaKeys = strArr;
    }
}
