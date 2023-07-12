package tb;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.alibaba.emas.datalab.DatalabBizType;
import com.alibaba.fastjson.JSON;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ve2 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class b {
        private static ve2 a = new ve2();
    }

    public static ve2 b() {
        return b.a;
    }

    public p30 a(Context context, DatalabBizType datalabBizType, String str) {
        if (context == null) {
            Log.e("Datalab.SpController", "context is null, need init first");
            return null;
        }
        try {
            String string = context.getSharedPreferences(datalabBizType.toString(), 0).getString(str, null);
            if (string != null) {
                return (p30) JSON.parseObject(string, p30.class);
            }
        } catch (Exception e) {
            Log.e("Datalab.SpController", "error happen ", e);
        }
        return null;
    }

    @TargetApi(9)
    public void c(Context context, p30 p30Var, DatalabBizType datalabBizType, String str) {
        if (context == null) {
            Log.e("Datalab.SpController", "context is null, need init first");
        } else if (p30Var != null && datalabBizType != null && str != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(datalabBizType.toString(), 0).edit();
                edit.putString(str, JSON.toJSONString(p30Var));
                edit.apply();
            } catch (Exception e) {
                Log.e("Datalab.SpController", "error happen ", e);
            }
        } else {
            Log.e("Datalab.SpController", "notify is null or name is null");
        }
    }

    public void d(Context context, DatalabBizType datalabBizType) {
        if (datalabBizType == null) {
            Log.e("Datalab.SpController", "bizType is null");
            return;
        }
        DatalabBizType datalabBizType2 = DatalabBizType.zcache;
        if (datalabBizType.equals(datalabBizType2)) {
            p30 a2 = a(context, datalabBizType2, "app.start");
            Log.w("Datalab.SpController", "appStartEvent result is " + JSON.toJSONString(a2));
            if (a2 != null) {
                try {
                    Log.w("Datalab.SpController", datalabBizType + " app start event notify");
                    com.alibaba.emas.datalab.a.b().b.e(a2);
                } catch (Exception e) {
                    Log.e("Datalab.SpController", "app start event error", e);
                }
            }
        }
    }

    private ve2() {
    }
}
