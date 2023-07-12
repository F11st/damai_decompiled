package tb;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.updatecenter.query.MudpUpdateRequest;
import java.util.ArrayList;
import mtopsdk.mtop.domain.IMTOPDataObject;
import mtopsdk.mtop.domain.JsonTypeEnum;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class oz0 {
    private static oz0 c;
    private Application a;
    private String b;

    private oz0() {
    }

    public static synchronized oz0 a() {
        oz0 oz0Var;
        synchronized (oz0.class) {
            if (c == null) {
                c = new oz0();
            }
            oz0Var = c;
        }
        return oz0Var;
    }

    private String b(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (networkInfo = connectivityManager.getNetworkInfo(1)) != null) {
                if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    return "wifi";
                }
            }
        } catch (Exception unused) {
        }
        return "none";
    }

    public vq1 c(Application application, String str, int i, String str2, String str3, long j) {
        MtopBuilder jsonType;
        this.a = application;
        MudpUpdateRequest mudpUpdateRequest = new MudpUpdateRequest();
        mudpUpdateRequest.appVersion = str;
        mudpUpdateRequest.apiLevel = Build.VERSION.SDK_INT;
        mudpUpdateRequest.patchVersion = i;
        mudpUpdateRequest.dexpatchVersion = j;
        mudpUpdateRequest.group = str2;
        mudpUpdateRequest.identifier = str2;
        mudpUpdateRequest.brand = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
        mudpUpdateRequest.model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        mudpUpdateRequest.netStatus = "wifi".equals(b(this.a)) ? 10L : 1L;
        ArrayList arrayList = new ArrayList();
        arrayList.add("hotpatch");
        arrayList.add(lu2.DEXPATCH);
        mudpUpdateRequest.updateTypes = arrayList;
        if (TextUtils.isEmpty(this.b)) {
            jsonType = Mtop.instance(this.a).build((IMTOPDataObject) mudpUpdateRequest, "600000");
        } else {
            jsonType = Mtop.instance(this.a, this.b).build((IMTOPDataObject) mudpUpdateRequest, this.b).setJsonType(JsonTypeEnum.ORIGINALJSON);
        }
        if (!TextUtils.isEmpty(str3)) {
            jsonType.setCustomDomain(str3);
        }
        jsonType.reqMethod(MethodEnum.GET);
        MtopResponse syncRequest = jsonType.syncRequest();
        if (syncRequest != null && syncRequest.isApiSuccess()) {
            try {
                String str4 = new String(syncRequest.getBytedata());
                if (!TextUtils.isEmpty(str4)) {
                    JSONObject parseObject = JSON.parseObject(str4);
                    if (parseObject.containsKey("data")) {
                        JSONObject jSONObject = parseObject.getJSONObject("data");
                        if (jSONObject.containsKey("hasUpdate") ? jSONObject.getBoolean("hasUpdate").booleanValue() : false) {
                            return vq1.a(jSONObject.getJSONObject("hotpatch"));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("HotPatchBusiness", "response parse exception : " + e.getMessage());
            }
            return null;
        }
        Log.e("HotPatchBusiness", "response is null or response is failed!");
        return null;
    }

    public void d(String str) {
        this.b = str;
    }
}
