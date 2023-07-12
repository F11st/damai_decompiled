package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class km {
    private StringBuilder a = new StringBuilder();

    public final kj a(String str, Context context, ik ikVar) {
        kj kjVar = new kj("");
        kjVar.setErrorCode(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                StringBuilder sb = this.a;
                sb.append("json is error " + str);
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            if (string.equals("0")) {
                StringBuilder sb2 = this.a;
                sb2.append("auth fail:" + string2);
            }
        } catch (Throwable th) {
            StringBuilder sb3 = this.a;
            sb3.append("json exception error:" + th.getMessage());
            jy.a(th, "MapParser", "paseAuthFailurJson");
        }
        try {
            StringBuilder sb4 = this.a;
            sb4.append("#SHA1AndPackage#");
            sb4.append(gc.e(context));
            String str2 = ikVar.b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb5 = this.a;
                sb5.append(" #gsid#");
                sb5.append(str2);
            }
            String str3 = ikVar.c;
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb6 = this.a;
                sb6.append(" #csid#" + str3);
            }
        } catch (Throwable unused) {
        }
        kjVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            StringBuilder sb7 = this.a;
            sb7.delete(0, sb7.length());
        }
        return kjVar;
    }

    public final kj a(byte[] bArr) {
        kj kjVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ByteBuffer byteBuffer = null;
        try {
            kjVar = new kj("");
        } catch (Throwable th) {
            try {
                kj kjVar2 = new kj("");
                kjVar2.setErrorCode(5);
                StringBuilder sb = this.a;
                sb.append("parser data error:" + th.getMessage());
                kjVar2.setLocationDetail(this.a.toString());
                kjVar = kjVar2;
            } finally {
                if (0 != 0) {
                    byteBuffer.clear();
                }
            }
        }
        if (bArr == null) {
            kjVar.setErrorCode(5);
            this.a.append("byte[] is null");
            kjVar.setLocationDetail(this.a.toString());
            StringBuilder sb2 = this.a;
            sb2.delete(0, sb2.length());
            return kjVar;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.get() == 0) {
            kjVar.b(String.valueOf((int) wrap.getShort()));
            wrap.clear();
            wrap.clear();
            return kjVar;
        }
        kjVar.setLongitude(kc.a(wrap.getInt() / 1000000.0d));
        kjVar.setLatitude(kc.a(wrap.getInt() / 1000000.0d));
        kjVar.setAccuracy(wrap.getShort());
        kjVar.c(String.valueOf((int) wrap.get()));
        kjVar.d(String.valueOf((int) wrap.get()));
        if (wrap.get() == 1) {
            byte[] bArr2 = new byte[wrap.get() & 255];
            wrap.get(bArr2);
            try {
                kjVar.setCountry(new String(bArr2, "UTF-8"));
            } catch (Throwable unused) {
            }
            byte[] bArr3 = new byte[wrap.get() & 255];
            wrap.get(bArr3);
            try {
                str = new String(bArr3, "UTF-8");
                try {
                    kjVar.setProvince(str);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                str = "";
            }
            byte[] bArr4 = new byte[wrap.get() & 255];
            wrap.get(bArr4);
            try {
                str2 = new String(bArr4, "UTF-8");
                try {
                    kjVar.setCity(str2);
                } catch (Throwable unused4) {
                }
            } catch (Throwable unused5) {
                str2 = "";
            }
            byte[] bArr5 = new byte[wrap.get() & 255];
            wrap.get(bArr5);
            try {
                str3 = new String(bArr5, "UTF-8");
                try {
                    kjVar.setDistrict(str3);
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                str3 = "";
            }
            byte[] bArr6 = new byte[wrap.get() & 255];
            wrap.get(bArr6);
            try {
                str4 = new String(bArr6, "UTF-8");
                try {
                    kjVar.setStreet(str4);
                    kjVar.setRoad(str4);
                } catch (Throwable unused8) {
                }
            } catch (Throwable unused9) {
                str4 = "";
            }
            byte[] bArr7 = new byte[wrap.get() & 255];
            wrap.get(bArr7);
            try {
                kjVar.setNumber(new String(bArr7, "UTF-8"));
            } catch (Throwable unused10) {
            }
            byte[] bArr8 = new byte[wrap.get() & 255];
            wrap.get(bArr8);
            try {
                str5 = new String(bArr8, "UTF-8");
                try {
                    kjVar.setPoiName(str5);
                } catch (Throwable unused11) {
                }
            } catch (Throwable unused12) {
                str5 = "";
            }
            byte[] bArr9 = new byte[wrap.get() & 255];
            wrap.get(bArr9);
            try {
                kjVar.setAoiName(new String(bArr9, "UTF-8"));
            } catch (Throwable unused13) {
            }
            byte[] bArr10 = new byte[wrap.get() & 255];
            wrap.get(bArr10);
            try {
                str6 = new String(bArr10, "UTF-8");
                try {
                    kjVar.setAdCode(str6);
                } catch (Throwable unused14) {
                }
            } catch (Throwable unused15) {
                str6 = "";
            }
            byte[] bArr11 = new byte[wrap.get() & 255];
            wrap.get(bArr11);
            try {
                kjVar.setCityCode(new String(bArr11, "UTF-8"));
            } catch (Throwable unused16) {
            }
            StringBuilder sb3 = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb3.append(str);
                sb3.append(" ");
            }
            if (!TextUtils.isEmpty(str2) && (!str.contains("市") || !str.equals(str2))) {
                sb3.append(str2);
                sb3.append(" ");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb3.append(str3);
                sb3.append(" ");
            }
            if (!TextUtils.isEmpty(str4)) {
                sb3.append(str4);
                sb3.append(" ");
            }
            if (!TextUtils.isEmpty(str5)) {
                if (!TextUtils.isEmpty(str6)) {
                    sb3.append("靠近");
                }
                sb3.append(str5);
                sb3.append(" ");
            }
            Bundle bundle = new Bundle();
            bundle.putString("citycode", kjVar.getCityCode());
            bundle.putString(SocialConstants.PARAM_APP_DESC, sb3.toString());
            bundle.putString("adcode", kjVar.getAdCode());
            kjVar.setExtras(bundle);
            kjVar.e(sb3.toString());
            String adCode = kjVar.getAdCode();
            kjVar.setAddress((adCode == null || adCode.trim().length() <= 0) ? sb3.toString() : sb3.toString().replace(" ", ""));
        }
        wrap.get(new byte[wrap.get() & 255]);
        if (wrap.get() == 1) {
            wrap.getInt();
            wrap.getInt();
            wrap.getShort();
        }
        if (wrap.get() == 1) {
            byte[] bArr12 = new byte[wrap.get() & 255];
            wrap.get(bArr12);
            try {
                kjVar.setBuildingId(new String(bArr12, "UTF-8"));
            } catch (Throwable unused17) {
            }
            byte[] bArr13 = new byte[wrap.get() & 255];
            wrap.get(bArr13);
            try {
                kjVar.setFloor(new String(bArr13, "UTF-8"));
            } catch (Throwable unused18) {
            }
        }
        if (wrap.get() == 1) {
            wrap.get();
            wrap.getInt();
            wrap.get();
        }
        if (wrap.get() == 1) {
            kjVar.setTime(wrap.getLong());
        }
        byte[] bArr14 = new byte[wrap.getShort()];
        wrap.get(bArr14);
        try {
            kjVar.a(new String(bArr14, "UTF-8"));
        } catch (Throwable unused19) {
        }
        wrap.clear();
        if (this.a.length() > 0) {
            StringBuilder sb4 = this.a;
            sb4.delete(0, sb4.length());
        }
        return kjVar;
    }
}
