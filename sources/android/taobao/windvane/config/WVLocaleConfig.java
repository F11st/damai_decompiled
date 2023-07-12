package android.taobao.windvane.config;

import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVLocaleConfig {
    private static volatile WVLocaleConfig instance;
    public String mCurrentLocale = null;
    public String mLastLocale = null;

    public static WVLocaleConfig getInstance() {
        if (instance == null) {
            synchronized (WVLocaleConfig.class) {
                if (instance == null) {
                    instance = new WVLocaleConfig();
                }
            }
        }
        return instance;
    }

    public void init() {
        try {
            String stringVal = ConfigStorage.getStringVal(WVConfigManager.SPNAME_CONFIG, "locale");
            if (TextUtils.isEmpty(stringVal)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(stringVal);
            this.mCurrentLocale = jSONObject.optString("currentLocale", null);
            this.mLastLocale = jSONObject.optString("lastLocale", null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean needFull() {
        /*
            r3 = this;
            java.lang.String r0 = r3.mCurrentLocale
            r1 = 1
            if (r0 == 0) goto L18
            java.lang.String r2 = r3.mLastLocale
            if (r2 != 0) goto Ld
            r3.mLastLocale = r0
        Lb:
            r0 = 1
            goto L19
        Ld:
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L18
            java.lang.String r0 = r3.mCurrentLocale
            r3.mLastLocale = r0
            goto Lb
        L18:
            r0 = 0
        L19:
            java.lang.String r2 = r3.mLastLocale
            if (r2 == 0) goto L25
            java.lang.String r2 = r3.mCurrentLocale
            if (r2 != 0) goto L25
            r0 = 0
            r3.mLastLocale = r0
            goto L26
        L25:
            r1 = r0
        L26:
            if (r1 == 0) goto L2b
            r3.save()
        L2b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.config.WVLocaleConfig.needFull():boolean");
    }

    public void save() {
        if (this.mCurrentLocale == null && this.mLastLocale == null) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("currentLocale", this.mCurrentLocale);
            jSONObject.put("lastLocale", this.mLastLocale);
            WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.config.WVLocaleConfig.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigStorage.putStringVal(WVConfigManager.SPNAME_CONFIG, "locale", jSONObject.toString());
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setLocale(String str) {
        this.mCurrentLocale = str;
        save();
    }
}
