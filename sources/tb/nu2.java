package tb;

import android.text.TextUtils;
import com.taobao.android.tlog.protocol.model.joint.point.StartupJointPoint;
import com.taobao.monitor.network.UploadStorage;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nu2 implements UploadStorage.UploadLifecycle {
    public static final String KEY_LAST_LAUNCH_SESSION = "last_launch_session";
    private final boolean a;

    public nu2(boolean z) {
        this.a = z;
    }

    private String a() {
        return fu0.e().a().getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0).getString(KEY_LAST_LAUNCH_SESSION, "");
    }

    @Override // com.taobao.monitor.network.UploadStorage.UploadLifecycle
    public String onDataLoaded(File file, String str) {
        JSONObject jSONObject;
        if (file.getName().startsWith(StartupJointPoint.TYPE)) {
            String a = a();
            if (TextUtils.isEmpty(a)) {
                return str;
            }
            String name = file.getName();
            if (name.endsWith(a + ".json")) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("value");
                    if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject("properties")) != null) {
                        jSONObject.put("processKilled", this.a);
                        pb1.a("UpdateStartupLifecycle", "processKilled", Boolean.valueOf(this.a));
                    }
                    return jSONObject2.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    return str;
                }
            }
            return str;
        }
        return str;
    }

    @Override // com.taobao.monitor.network.UploadStorage.UploadLifecycle
    public void onEnd() {
    }

    @Override // com.taobao.monitor.network.UploadStorage.UploadLifecycle
    public void onSend(String str, String str2) {
    }

    @Override // com.taobao.monitor.network.UploadStorage.UploadLifecycle
    public void onStart(boolean z) {
    }
}
