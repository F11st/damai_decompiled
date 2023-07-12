package com.alibaba.security.realidentity.jsbridge.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.common.d.i;
import com.alibaba.security.common.track.model.CommonTrackResult;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.g;
import com.alibaba.security.realidentity.activity.RPTakePhotoActivity;
import com.alibaba.security.realidentity.jsbridge.f;
import com.alibaba.security.realidentity.jsbridge.h;
import com.alibaba.security.realidentity.utils.ImageData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@f(a = "takePhoto,rpTakePhoto")
/* loaded from: classes8.dex */
public class e extends com.alibaba.security.realidentity.jsbridge.a {
    private static final String as = "e";
    private static final String at = "LOW_MEMORY";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.jsbridge.a.e$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    final class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ String a;
        final /* synthetic */ i b;

        AnonymousClass1(String str, i iVar) {
            this.a = str;
            this.b = iVar;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (this.a.equals(intent.getAction())) {
                e.a(e.this, intent);
                this.b.a(this);
            }
        }
    }

    private void b(Intent intent) {
        if (intent.getIntExtra("ret", -1) != -1) {
            com.alibaba.security.realidentity.jsbridge.a.a(this.an, "takePhoto activity result is not ok");
            com.alibaba.security.realidentity.jsbridge.a.b("takePhoto activity result is not ok");
            g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto activity result is not ok"), false));
            return;
        }
        Object stringExtra = intent.getStringExtra("errorMsg");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.alibaba.security.realidentity.jsbridge.a.K);
        int[] intArrayExtra = intent.getIntArrayExtra(com.alibaba.security.realidentity.jsbridge.a.C);
        if (intent.getBooleanExtra(com.alibaba.security.realidentity.jsbridge.a.ac, false)) {
            com.alibaba.security.realidentity.jsbridge.a.a(this.an, "takePhoto imageList is null by user cancel");
        } else if (parcelableArrayListExtra == null) {
            com.alibaba.security.realidentity.jsbridge.a.a(this.an, "takePhoto imageList is null");
            com.alibaba.security.realidentity.jsbridge.a.b("takePhoto imageList is null");
            g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto imageList is null"), false));
        } else {
            WVResult wVResult = new WVResult();
            RPWebViewMediaCacheManager rPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
            for (int i = 0; i < parcelableArrayListExtra.size(); i++) {
                ImageData imageData = (ImageData) parcelableArrayListExtra.get(i);
                Pair<String, String> putIdCardImage = rPWebViewMediaCacheManager.putIdCardImage(this.ao, imageData.a);
                String str = imageData.c;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.N, String.valueOf(imageData.b));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.W, str);
                    }
                    if (putIdCardImage != null && !"0".equals(putIdCardImage.first)) {
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.r, putIdCardImage.first);
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.Y, putIdCardImage.second);
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.Z, imageData.d);
                        wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.X + imageData.b, jSONObject);
                        g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(), true));
                    } else {
                        jSONObject.put("errorMsg", at);
                        wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.X + imageData.b, jSONObject);
                        this.an.a(wVResult);
                        g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, at), false));
                        return;
                    }
                } catch (JSONException e) {
                    com.alibaba.security.realidentity.jsbridge.a.a("TakePhotoApi onActivityResult data assemble  error", e);
                    com.alibaba.security.realidentity.jsbridge.a.a(this.an, "TakePhotoApi onActivityResult data assemble error");
                    g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "TakePhotoApi onActivityResult data assemble error"), false));
                    return;
                }
            }
            if (intArrayExtra.length != parcelableArrayListExtra.size()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= intArrayExtra.length) {
                        break;
                    } else if (intArrayExtra[i2] >= 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(com.alibaba.security.realidentity.jsbridge.a.y, intArrayExtra[i2]);
                            jSONObject2.put("errorMsg", stringExtra);
                        } catch (JSONException unused) {
                            com.alibaba.security.common.c.a.b();
                        }
                        wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.X + intArrayExtra[i2], jSONObject2);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (intArrayExtra.length == parcelableArrayListExtra.size()) {
                wVResult.setSuccess();
                this.an.b(wVResult);
                a(wVResult, true);
                return;
            }
            this.an.a(wVResult);
            a(wVResult, false);
        }
    }

    private static String c(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://")) {
            return str;
        }
        if (str.startsWith(WVUtils.URL_SEPARATOR)) {
            return "http:".concat(str);
        }
        return "http://".concat(str);
    }

    private String d() {
        return toString();
    }

    private void e() {
        i a = i.a(this.ao);
        String obj = toString();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(obj);
        a.a(new AnonymousClass1(obj, a), intentFilter);
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final String a() {
        return "takePhoto";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, h hVar) {
        if (com.alibaba.security.common.c.a.a()) {
            com.alibaba.security.common.c.a.a(as, "TakePhotoApi execute params: ".concat(String.valueOf(str)));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray(com.alibaba.security.realidentity.jsbridge.a.y);
            JSONArray jSONArray2 = jSONObject.getJSONArray(com.alibaba.security.realidentity.jsbridge.a.z);
            String optString = jSONObject.optString(com.alibaba.security.realidentity.jsbridge.a.A, "0");
            int length = jSONArray.length();
            int[] iArr = new int[length];
            for (int i = 0; i < jSONArray.length(); i++) {
                iArr[i] = jSONArray.getInt(i);
            }
            String[] strArr = new String[jSONArray2.length()];
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                String string = jSONArray2.getString(i2);
                if (!TextUtils.isEmpty(string) && !string.startsWith("http://")) {
                    string = string.startsWith(WVUtils.URL_SEPARATOR) ? "http:".concat(string) : "http://".concat(string);
                }
                strArr[i2] = string;
            }
            g.a.a.a(TrackLog.createTakePhotoStartLog());
            if (length > 0) {
                Intent intent = new Intent();
                intent.setClass(this.ao, RPTakePhotoActivity.class);
                intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.A, TextUtils.equals(optString, "1"));
                intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.B, strArr);
                intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.C, iArr);
                intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.J, toString());
                intent.setFlags(268435456);
                this.ao.startActivity(intent);
                i a = i.a(this.ao);
                String obj = toString();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(obj);
                a.a(new AnonymousClass1(obj, a), intentFilter);
                return true;
            }
            return false;
        } catch (JSONException e) {
            if (com.alibaba.security.common.c.a.a()) {
                com.alibaba.security.common.c.a.c(as, "TakePhotoApi parse params error");
            }
            com.alibaba.security.realidentity.jsbridge.a.a("TakePhotoApi parse params error", e);
            com.alibaba.security.realidentity.jsbridge.a.a(hVar);
            return false;
        }
    }

    private void a(Intent intent) {
        intent.putExtra(com.alibaba.security.realidentity.jsbridge.a.J, toString());
        intent.setFlags(268435456);
        this.ao.startActivity(intent);
        i a = i.a(this.ao);
        String obj = toString();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(obj);
        a.a(new AnonymousClass1(obj, a), intentFilter);
    }

    static /* synthetic */ void a(e eVar, Intent intent) {
        if (intent.getIntExtra("ret", -1) != -1) {
            com.alibaba.security.realidentity.jsbridge.a.a(eVar.an, "takePhoto activity result is not ok");
            com.alibaba.security.realidentity.jsbridge.a.b("takePhoto activity result is not ok");
            g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto activity result is not ok"), false));
            return;
        }
        Object stringExtra = intent.getStringExtra("errorMsg");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.alibaba.security.realidentity.jsbridge.a.K);
        int[] intArrayExtra = intent.getIntArrayExtra(com.alibaba.security.realidentity.jsbridge.a.C);
        if (intent.getBooleanExtra(com.alibaba.security.realidentity.jsbridge.a.ac, false)) {
            com.alibaba.security.realidentity.jsbridge.a.a(eVar.an, "takePhoto imageList is null by user cancel");
        } else if (parcelableArrayListExtra == null) {
            com.alibaba.security.realidentity.jsbridge.a.a(eVar.an, "takePhoto imageList is null");
            com.alibaba.security.realidentity.jsbridge.a.b("takePhoto imageList is null");
            g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto imageList is null"), false));
        } else {
            WVResult wVResult = new WVResult();
            RPWebViewMediaCacheManager rPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
            for (int i = 0; i < parcelableArrayListExtra.size(); i++) {
                ImageData imageData = (ImageData) parcelableArrayListExtra.get(i);
                Pair<String, String> putIdCardImage = rPWebViewMediaCacheManager.putIdCardImage(eVar.ao, imageData.a);
                String str = imageData.c;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.N, String.valueOf(imageData.b));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.W, str);
                    }
                    if (putIdCardImage != null && !"0".equals(putIdCardImage.first)) {
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.r, putIdCardImage.first);
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.Y, putIdCardImage.second);
                        jSONObject.put(com.alibaba.security.realidentity.jsbridge.a.Z, imageData.d);
                        wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.X + imageData.b, jSONObject);
                        g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(), true));
                    } else {
                        jSONObject.put("errorMsg", at);
                        wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.X + imageData.b, jSONObject);
                        eVar.an.a(wVResult);
                        g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, at), false));
                        return;
                    }
                } catch (JSONException e) {
                    com.alibaba.security.realidentity.jsbridge.a.a("TakePhotoApi onActivityResult data assemble  error", e);
                    com.alibaba.security.realidentity.jsbridge.a.a(eVar.an, "TakePhotoApi onActivityResult data assemble error");
                    g.a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "TakePhotoApi onActivityResult data assemble error"), false));
                    return;
                }
            }
            if (intArrayExtra.length != parcelableArrayListExtra.size()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= intArrayExtra.length) {
                        break;
                    } else if (intArrayExtra[i2] >= 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put(com.alibaba.security.realidentity.jsbridge.a.y, intArrayExtra[i2]);
                            jSONObject2.put("errorMsg", stringExtra);
                        } catch (JSONException unused) {
                            com.alibaba.security.common.c.a.b();
                        }
                        wVResult.addData(com.alibaba.security.realidentity.jsbridge.a.X + intArrayExtra[i2], jSONObject2);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (intArrayExtra.length == parcelableArrayListExtra.size()) {
                wVResult.setSuccess();
                eVar.an.b(wVResult);
                eVar.a(wVResult, true);
                return;
            }
            eVar.an.a(wVResult);
            eVar.a(wVResult, false);
        }
    }
}
