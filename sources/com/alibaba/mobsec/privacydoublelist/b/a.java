package com.alibaba.mobsec.privacydoublelist.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.alibaba.mobsec.privacydoublelist.config.ConfigCenter;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class a extends BroadcastReceiver {
    public final /* synthetic */ ConfigCenter a;

    public a(ConfigCenter configCenter) {
        this.a = configCenter;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("cfg");
        String stringExtra2 = intent.getStringExtra("pkg");
        if (PdlEnvUtils.a) {
            Log.d("DL-CONFIG", "Get cfg from main process: " + stringExtra + ", pkg=" + stringExtra2);
        }
        if (stringExtra == null || stringExtra2 == null || !stringExtra2.equals(context.getPackageName())) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            this.a.a(hashMap);
        } catch (Throwable th) {
            if (PdlEnvUtils.a) {
                th.printStackTrace();
            }
            Log.e("DL-CONFIG", "输入无效配置: " + stringExtra);
        }
    }
}
