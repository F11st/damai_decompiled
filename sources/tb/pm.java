package tb;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.poplayer.layermanager.ILayerMgrAdapter;
import com.alibaba.poplayer.layermanager.config.ConfigItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class pm {
    public static final String CONFIG_SET_KEY = "layer_manager_config";
    public static final String DEFAULT_KEY = "default";
    public static final String TAG = "pm";
    Map<String, sc> a;
    private ILayerMgrAdapter b;
    private b c;
    private boolean d = false;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    private class b extends AsyncTask<Void, Void, Map<String, sc>> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Map<String, sc> doInBackground(Void... voidArr) {
            char c = 1;
            String str = pm.TAG;
            char c2 = 0;
            dt1.b("%s. begin update Config.", str);
            new ArrayList();
            String configByKey = pm.this.b.getConfigByKey(pm.CONFIG_SET_KEY);
            int i = 2;
            if (TextUtils.isEmpty(configByKey)) {
                dt1.b("%s. %s is empty.", str, pm.CONFIG_SET_KEY);
                return new HashMap();
            }
            dt1.b("%s. %s: {%s}.", str, pm.CONFIG_SET_KEY, configByKey);
            HashMap hashMap = new HashMap();
            String[] split = configByKey.split("\\,");
            int length = split.length;
            int i2 = 0;
            while (i2 < length) {
                String trim = split[i2].trim();
                Object[] objArr = new Object[i];
                objArr[c2] = pm.TAG;
                objArr[c] = trim;
                dt1.b("%s. ==> update bizConfig: bizId:{%s}.", objArr);
                String configByKey2 = pm.this.b.getConfigByKey(trim);
                try {
                    sc scVar = new sc();
                    Map<String, String> b = fw2.b(configByKey2);
                    for (String str2 : b.keySet()) {
                        ConfigItem configItem = (ConfigItem) JSON.parseObject(b.get(str2), ConfigItem.class);
                        scVar.a.put(str2, configItem);
                        dt1.b("%s. ==> put tpye:{%s},val:{%s}.", pm.TAG, str2, configItem.toString());
                    }
                    if (!scVar.a.isEmpty()) {
                        hashMap.put(trim, scVar);
                        Object[] objArr2 = new Object[3];
                        try {
                            objArr2[0] = pm.TAG;
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            objArr2[1] = pm.CONFIG_SET_KEY;
                        } catch (Throwable th2) {
                            th = th2;
                            dt1.c("" + pm.TAG + ".update key:" + trim + ",error.", th);
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
                            dt1.c("" + pm.TAG + ".update key:" + trim + ",error.", th);
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
                pm pmVar = pm.this;
                pmVar.a = map;
                pmVar.d(map);
            } catch (Throwable th) {
                dt1.c("" + pm.TAG + ".onPostExecute.error.", th);
            }
        }
    }

    public pm(ILayerMgrAdapter iLayerMgrAdapter) {
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
        com.alibaba.poplayer.layermanager.e.f().o();
        this.d = true;
    }

    public void e() {
        b bVar = this.c;
        if (bVar != null && AsyncTask.Status.FINISHED != bVar.getStatus()) {
            this.c.cancel(true);
        }
        b bVar2 = new b();
        this.c = bVar2;
        bVar2.execute(new Void[0]);
    }
}
