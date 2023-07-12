package tb;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.poplayer.layermanager.C3660e;
import com.alibaba.poplayer.layermanager.ILayerMgrAdapter;
import com.alibaba.poplayer.layermanager.config.ConfigItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: tb.pm */
/* loaded from: classes8.dex */
public class C9556pm {
    public static final String CONFIG_SET_KEY = "layer_manager_config";
    public static final String DEFAULT_KEY = "default";
    public static final String TAG = "pm";
    Map<String, sc> a;
    private ILayerMgrAdapter b;
    private AsyncTaskC9558b c;
    private boolean d = false;

    /* compiled from: Taobao */
    /* renamed from: tb.pm$b */
    /* loaded from: classes8.dex */
    private class AsyncTaskC9558b extends AsyncTask<Void, Void, Map<String, sc>> {
        private AsyncTaskC9558b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Map<String, sc> doInBackground(Void... voidArr) {
            char c = 1;
            String str = C9556pm.TAG;
            char c2 = 0;
            dt1.b("%s. begin update Config.", str);
            new ArrayList();
            String configByKey = C9556pm.this.b.getConfigByKey(C9556pm.CONFIG_SET_KEY);
            int i = 2;
            if (TextUtils.isEmpty(configByKey)) {
                dt1.b("%s. %s is empty.", str, C9556pm.CONFIG_SET_KEY);
                return new HashMap();
            }
            dt1.b("%s. %s: {%s}.", str, C9556pm.CONFIG_SET_KEY, configByKey);
            HashMap hashMap = new HashMap();
            String[] split = configByKey.split("\\,");
            int length = split.length;
            int i2 = 0;
            while (i2 < length) {
                String trim = split[i2].trim();
                Object[] objArr = new Object[i];
                objArr[c2] = C9556pm.TAG;
                objArr[c] = trim;
                dt1.b("%s. ==> update bizConfig: bizId:{%s}.", objArr);
                String configByKey2 = C9556pm.this.b.getConfigByKey(trim);
                try {
                    sc scVar = new sc();
                    Map<String, String> b = fw2.b(configByKey2);
                    for (String str2 : b.keySet()) {
                        ConfigItem configItem = (ConfigItem) JSON.parseObject(b.get(str2), ConfigItem.class);
                        scVar.a.put(str2, configItem);
                        dt1.b("%s. ==> put tpye:{%s},val:{%s}.", C9556pm.TAG, str2, configItem.toString());
                    }
                    if (!scVar.a.isEmpty()) {
                        hashMap.put(trim, scVar);
                        Object[] objArr2 = new Object[3];
                        try {
                            objArr2[0] = C9556pm.TAG;
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            objArr2[1] = C9556pm.CONFIG_SET_KEY;
                        } catch (Throwable th2) {
                            th = th2;
                            dt1.c("" + C9556pm.TAG + ".update key:" + trim + ",error.", th);
                            i2++;
                            c = 1;
                            c2 = 0;
                            i = 2;
                        }
                        try {
                            objArr2[2] = trim;
                            dt1.b("%s. --> complete bizId:{%s}. update", objArr2);
                        } catch (Throwable th3) {
                            th = th3;
                            dt1.c("" + C9556pm.TAG + ".update key:" + trim + ",error.", th);
                            i2++;
                            c = 1;
                            c2 = 0;
                            i = 2;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
                i2++;
                c = 1;
                c2 = 0;
                i = 2;
            }
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Map<String, sc> map) {
            try {
                C9556pm c9556pm = C9556pm.this;
                c9556pm.a = map;
                c9556pm.d(map);
            } catch (Throwable th) {
                dt1.c("" + C9556pm.TAG + ".onPostExecute.error.", th);
            }
        }
    }

    public C9556pm(ILayerMgrAdapter iLayerMgrAdapter) {
        this.b = iLayerMgrAdapter;
    }

    public sc b(String str) {
        Map<String, sc> map = this.a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (String str2 : this.a.keySet()) {
            if (str2.equals(str)) {
                return this.a.get(str2);
            }
        }
        return this.a.get("default");
    }

    public boolean c() {
        return this.d;
    }

    protected void d(Map<String, sc> map) {
        C3660e.f().o();
        this.d = true;
    }

    public void e() {
        AsyncTaskC9558b asyncTaskC9558b = this.c;
        if (asyncTaskC9558b != null && AsyncTask.Status.FINISHED != asyncTaskC9558b.getStatus()) {
            this.c.cancel(true);
        }
        AsyncTaskC9558b asyncTaskC9558b2 = new AsyncTaskC9558b();
        this.c = asyncTaskC9558b2;
        asyncTaskC9558b2.execute(new Void[0]);
    }
}
