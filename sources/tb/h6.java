package tb;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h6 {
    public static final String KET_API_MODIFY_CONFIG = "apiModifyConfig";

    private static void a(Activity activity) {
        activity.getSharedPreferences(is.NAMESPACE, 0).edit().clear().apply();
    }

    public static boolean b(Activity activity, Uri uri) {
        String queryParameter;
        if (activity == null || uri == null || (queryParameter = uri.getQueryParameter(KET_API_MODIFY_CONFIG)) == null) {
            return true;
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = JSON.parseArray(queryParameter);
        } catch (Exception unused) {
        }
        if (jSONArray != null && jSONArray.size() != 0) {
            SharedPreferences.Editor edit = activity.getSharedPreferences(is.NAMESPACE, 0).edit();
            for (int i = 0; i < jSONArray.size(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                String string = jSONObject.getString("source");
                if (!TextUtils.isEmpty(string)) {
                    edit.putString(string, jSONObject.getString("modifyApi"));
                    String string2 = jSONObject.getString("modifyVersion");
                    edit.putString(string + ".version", string2);
                }
            }
            edit.apply();
            TextView textView = new TextView(activity);
            textView.setTextSize(18.0f);
            textView.setPadding(50, 50, 50, 50);
            textView.setText("当前config： " + jSONArray.toJSONString());
            activity.setContentView(textView);
            return false;
        }
        a(activity);
        Toast.makeText(activity.getApplicationContext(), "已清除所有apiconfig", 0).show();
        return true;
    }
}
