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
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3812i;
import com.alibaba.security.common.track.model.CommonTrackResult;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.C3847g;
import com.alibaba.security.realidentity.activity.RPTakePhotoActivity;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.alibaba.security.realidentity.jsbridge.AbstractC3907h;
import com.alibaba.security.realidentity.jsbridge.InterfaceC3904f;
import com.alibaba.security.realidentity.utils.ImageData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
@InterfaceC3904f(a = "takePhoto,rpTakePhoto")
/* renamed from: com.alibaba.security.realidentity.jsbridge.a.e */
/* loaded from: classes8.dex */
public class C3899e extends AbstractC3893a {
    private static final String as = "e";
    private static final String at = "LOW_MEMORY";

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.jsbridge.a.e$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    final class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ String a;
        final /* synthetic */ C3812i b;

        AnonymousClass1(String str, C3812i c3812i) {
            this.a = str;
            this.b = c3812i;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (this.a.equals(intent.getAction())) {
                C3899e.a(C3899e.this, intent);
                this.b.a(this);
            }
        }
    }

    private void b(Intent intent) {
        if (intent.getIntExtra("ret", -1) != -1) {
            AbstractC3893a.a(this.an, "takePhoto activity result is not ok");
            AbstractC3893a.b("takePhoto activity result is not ok");
            C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto activity result is not ok"), false));
            return;
        }
        Object stringExtra = intent.getStringExtra("errorMsg");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(AbstractC3893a.K);
        int[] intArrayExtra = intent.getIntArrayExtra(AbstractC3893a.C);
        if (intent.getBooleanExtra(AbstractC3893a.ac, false)) {
            AbstractC3893a.a(this.an, "takePhoto imageList is null by user cancel");
        } else if (parcelableArrayListExtra == null) {
            AbstractC3893a.a(this.an, "takePhoto imageList is null");
            AbstractC3893a.b("takePhoto imageList is null");
            C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto imageList is null"), false));
        } else {
            WVResult wVResult = new WVResult();
            RPWebViewMediaCacheManager rPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
            for (int i = 0; i < parcelableArrayListExtra.size(); i++) {
                ImageData imageData = (ImageData) parcelableArrayListExtra.get(i);
                Pair<String, String> putIdCardImage = rPWebViewMediaCacheManager.putIdCardImage(this.ao, imageData.a);
                String str = imageData.c;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AbstractC3893a.N, String.valueOf(imageData.b));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(AbstractC3893a.W, str);
                    }
                    if (putIdCardImage != null && !"0".equals(putIdCardImage.first)) {
                        jSONObject.put(AbstractC3893a.r, putIdCardImage.first);
                        jSONObject.put(AbstractC3893a.Y, putIdCardImage.second);
                        jSONObject.put(AbstractC3893a.Z, imageData.d);
                        wVResult.addData(AbstractC3893a.X + imageData.b, jSONObject);
                        C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(), true));
                    } else {
                        jSONObject.put("errorMsg", at);
                        wVResult.addData(AbstractC3893a.X + imageData.b, jSONObject);
                        this.an.a(wVResult);
                        C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, at), false));
                        return;
                    }
                } catch (JSONException e) {
                    AbstractC3893a.a("TakePhotoApi onActivityResult data assemble  error", e);
                    AbstractC3893a.a(this.an, "TakePhotoApi onActivityResult data assemble error");
                    C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "TakePhotoApi onActivityResult data assemble error"), false));
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
                            jSONObject2.put(AbstractC3893a.y, intArrayExtra[i2]);
                            jSONObject2.put("errorMsg", stringExtra);
                        } catch (JSONException unused) {
                            C3800a.b();
                        }
                        wVResult.addData(AbstractC3893a.X + intArrayExtra[i2], jSONObject2);
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
        C3812i a = C3812i.a(this.ao);
        String obj = toString();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(obj);
        a.a(new AnonymousClass1(obj, a), intentFilter);
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final String a() {
        return "takePhoto";
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, AbstractC3907h abstractC3907h) {
        if (C3800a.a()) {
            C3800a.a(as, "TakePhotoApi execute params: ".concat(String.valueOf(str)));
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray(AbstractC3893a.y);
            JSONArray jSONArray2 = jSONObject.getJSONArray(AbstractC3893a.z);
            String optString = jSONObject.optString(AbstractC3893a.A, "0");
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
            C3847g.C3848a.a.a(TrackLog.createTakePhotoStartLog());
            if (length > 0) {
                Intent intent = new Intent();
                intent.setClass(this.ao, RPTakePhotoActivity.class);
                intent.putExtra(AbstractC3893a.A, TextUtils.equals(optString, "1"));
                intent.putExtra(AbstractC3893a.B, strArr);
                intent.putExtra(AbstractC3893a.C, iArr);
                intent.putExtra(AbstractC3893a.J, toString());
                intent.setFlags(268435456);
                this.ao.startActivity(intent);
                C3812i a = C3812i.a(this.ao);
                String obj = toString();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(obj);
                a.a(new AnonymousClass1(obj, a), intentFilter);
                return true;
            }
            return false;
        } catch (JSONException e) {
            if (C3800a.a()) {
                C3800a.c(as, "TakePhotoApi parse params error");
            }
            AbstractC3893a.a("TakePhotoApi parse params error", e);
            AbstractC3893a.a(abstractC3907h);
            return false;
        }
    }

    private void a(Intent intent) {
        intent.putExtra(AbstractC3893a.J, toString());
        intent.setFlags(268435456);
        this.ao.startActivity(intent);
        C3812i a = C3812i.a(this.ao);
        String obj = toString();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(obj);
        a.a(new AnonymousClass1(obj, a), intentFilter);
    }

    static /* synthetic */ void a(C3899e c3899e, Intent intent) {
        if (intent.getIntExtra("ret", -1) != -1) {
            AbstractC3893a.a(c3899e.an, "takePhoto activity result is not ok");
            AbstractC3893a.b("takePhoto activity result is not ok");
            C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto activity result is not ok"), false));
            return;
        }
        Object stringExtra = intent.getStringExtra("errorMsg");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(AbstractC3893a.K);
        int[] intArrayExtra = intent.getIntArrayExtra(AbstractC3893a.C);
        if (intent.getBooleanExtra(AbstractC3893a.ac, false)) {
            AbstractC3893a.a(c3899e.an, "takePhoto imageList is null by user cancel");
        } else if (parcelableArrayListExtra == null) {
            AbstractC3893a.a(c3899e.an, "takePhoto imageList is null");
            AbstractC3893a.b("takePhoto imageList is null");
            C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "takePhoto imageList is null"), false));
        } else {
            WVResult wVResult = new WVResult();
            RPWebViewMediaCacheManager rPWebViewMediaCacheManager = RPWebViewMediaCacheManager.getInstance();
            for (int i = 0; i < parcelableArrayListExtra.size(); i++) {
                ImageData imageData = (ImageData) parcelableArrayListExtra.get(i);
                Pair<String, String> putIdCardImage = rPWebViewMediaCacheManager.putIdCardImage(c3899e.ao, imageData.a);
                String str = imageData.c;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AbstractC3893a.N, String.valueOf(imageData.b));
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(AbstractC3893a.W, str);
                    }
                    if (putIdCardImage != null && !"0".equals(putIdCardImage.first)) {
                        jSONObject.put(AbstractC3893a.r, putIdCardImage.first);
                        jSONObject.put(AbstractC3893a.Y, putIdCardImage.second);
                        jSONObject.put(AbstractC3893a.Z, imageData.d);
                        wVResult.addData(AbstractC3893a.X + imageData.b, jSONObject);
                        C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(), true));
                    } else {
                        jSONObject.put("errorMsg", at);
                        wVResult.addData(AbstractC3893a.X + imageData.b, jSONObject);
                        c3899e.an.a(wVResult);
                        C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, at), false));
                        return;
                    }
                } catch (JSONException e) {
                    AbstractC3893a.a("TakePhotoApi onActivityResult data assemble  error", e);
                    AbstractC3893a.a(c3899e.an, "TakePhotoApi onActivityResult data assemble error");
                    C3847g.C3848a.a.a(TrackLog.createTakePhotoFinishLog(new CommonTrackResult(-1, "TakePhotoApi onActivityResult data assemble error"), false));
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
                            jSONObject2.put(AbstractC3893a.y, intArrayExtra[i2]);
                            jSONObject2.put("errorMsg", stringExtra);
                        } catch (JSONException unused) {
                            C3800a.b();
                        }
                        wVResult.addData(AbstractC3893a.X + intArrayExtra[i2], jSONObject2);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            if (intArrayExtra.length == parcelableArrayListExtra.size()) {
                wVResult.setSuccess();
                c3899e.an.b(wVResult);
                c3899e.a(wVResult, true);
                return;
            }
            c3899e.an.a(wVResult);
            c3899e.a(wVResult, false);
        }
    }
}
