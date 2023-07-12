package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.loc.u1;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;
import tb.y90;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j1 {
    public static String a = "5.3";
    static HashMap<String, String> l;
    public static final String[] b = {y90.VER_CODE_OLD};
    static String c = "http://apilocate.amap.com/mobile/binary";
    static String d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
    private static final String[] e = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};
    static String f = "11G;11K;13J;13S;15O;15U;17J;17Y;197";
    public static String g = null;
    public static String h = null;
    public static int i = 30000;
    public static String j = null;
    public static String k = null;
    private static u1 m = null;

    public static Bundle a(AMapLocationClientOption aMapLocationClientOption) {
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
        } catch (Throwable th) {
            h(th, "CoreUtil", "getOptionBundle");
        }
        return bundle;
    }

    public static AMapLocation b(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null) {
            return aMapLocation;
        }
        try {
            aMapLocation.setCountry(aMapLocation2.getCountry());
            aMapLocation.setRoad(aMapLocation2.getRoad());
            aMapLocation.setPoiName(aMapLocation2.getPoiName());
            aMapLocation.setStreet(aMapLocation2.getStreet());
            aMapLocation.setNumber(aMapLocation2.getStreetNum());
            String cityCode = aMapLocation2.getCityCode();
            String adCode = aMapLocation2.getAdCode();
            aMapLocation.setCityCode(cityCode);
            aMapLocation.setAdCode(adCode);
            aMapLocation.setCity(aMapLocation2.getCity());
            aMapLocation.setDistrict(aMapLocation2.getDistrict());
            aMapLocation.setProvince(aMapLocation2.getProvince());
            aMapLocation.setAoiName(aMapLocation2.getAoiName());
            aMapLocation.setAddress(aMapLocation2.getAddress());
            aMapLocation.setDescription(aMapLocation2.getDescription());
            if (aMapLocation.getExtras() != null) {
                aMapLocation.getExtras().putString("citycode", aMapLocation2.getCityCode());
                aMapLocation.getExtras().putString(SocialConstants.PARAM_APP_DESC, aMapLocation2.getExtras().getString(SocialConstants.PARAM_APP_DESC));
                aMapLocation.getExtras().putString("adcode", aMapLocation2.getAdCode());
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation2.getCityCode());
                bundle.putString(SocialConstants.PARAM_APP_DESC, aMapLocation2.getExtras().getString(SocialConstants.PARAM_APP_DESC));
                bundle.putString("adcode", aMapLocation2.getAdCode());
                aMapLocation.setExtras(bundle);
            }
        } catch (Throwable unused) {
        }
        return aMapLocation;
    }

    public static AMapLocationClientOption c(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
            return (AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (Throwable th) {
            h(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    public static String d() {
        return c;
    }

    public static void e(Context context) {
        try {
            if (v1.t(context)) {
                c = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            u();
            g(e1.a(l.j(context)));
        } catch (Throwable th) {
            h(th, "CoreUtil", "checkUrl");
        }
    }

    public static void f(AMapLocation aMapLocation, JSONObject jSONObject) {
        String str;
        if (jSONObject != null) {
            try {
                double optDouble = jSONObject.optDouble("lat", aMapLocation.getLatitude());
                double optDouble2 = jSONObject.optDouble("lon", aMapLocation.getLongitude());
                aMapLocation.setProvider(jSONObject.optString("provider", aMapLocation.getProvider()));
                aMapLocation.setLatitude(optDouble);
                aMapLocation.setLongitude(optDouble2);
                aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
                try {
                    String optString = jSONObject.optString("accuracy");
                    if (!TextUtils.isEmpty(optString)) {
                        aMapLocation.setAccuracy(Float.parseFloat(optString));
                    }
                } catch (Throwable unused) {
                }
                try {
                    String optString2 = jSONObject.optString("speed");
                    if (!TextUtils.isEmpty(optString2)) {
                        aMapLocation.setSpeed(Float.parseFloat(optString2));
                    }
                } catch (Throwable unused2) {
                }
                try {
                    String optString3 = jSONObject.optString("bearing");
                    if (!TextUtils.isEmpty(optString3)) {
                        aMapLocation.setBearing(Float.parseFloat(optString3));
                    }
                } catch (Throwable unused3) {
                }
                aMapLocation.setAdCode(jSONObject.optString("adcode", aMapLocation.getAdCode()));
                aMapLocation.setCityCode(jSONObject.optString("citycode", aMapLocation.getCityCode()));
                aMapLocation.setAddress(jSONObject.optString(ILocatable.ADDRESS, aMapLocation.getAddress()));
                String optString4 = jSONObject.optString(SocialConstants.PARAM_APP_DESC, "");
                aMapLocation.setCountry(jSONObject.optString(DistrictSearchQuery.KEYWORDS_COUNTRY, aMapLocation.getCountry()));
                aMapLocation.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince()));
                aMapLocation.setCity(jSONObject.optString("city", aMapLocation.getCity()));
                aMapLocation.setDistrict(jSONObject.optString(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict()));
                aMapLocation.setRoad(jSONObject.optString("road", aMapLocation.getRoad()));
                aMapLocation.setStreet(jSONObject.optString("street", aMapLocation.getStreet()));
                aMapLocation.setNumber(jSONObject.optString("number", aMapLocation.getStreetNum()));
                aMapLocation.setPoiName(jSONObject.optString("poiname", aMapLocation.getPoiName()));
                aMapLocation.setAoiName(jSONObject.optString("aoiname", aMapLocation.getAoiName()));
                aMapLocation.setErrorCode(jSONObject.optInt("errorCode", aMapLocation.getErrorCode()));
                aMapLocation.setErrorInfo(jSONObject.optString(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo()));
                aMapLocation.setLocationType(jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, aMapLocation.getLocationType()));
                aMapLocation.setLocationDetail(jSONObject.optString("locationDetail", aMapLocation.getLocationDetail()));
                aMapLocation.setTime(jSONObject.optLong("time", aMapLocation.getTime()));
                boolean optBoolean = jSONObject.optBoolean("isOffset", aMapLocation.isOffset());
                aMapLocation.setOffset(optBoolean);
                aMapLocation.setBuildingId(jSONObject.optString("poiid", aMapLocation.getBuildingId()));
                aMapLocation.setFloor(jSONObject.optString("floor", aMapLocation.getFloor()));
                aMapLocation.setDescription(jSONObject.optString(SocialConstants.PARAM_COMMENT, aMapLocation.getDescription()));
                if (jSONObject.has("coordType")) {
                    str = jSONObject.optString("coordType", AMapLocation.COORD_TYPE_GCJ02);
                } else if (i(optDouble, optDouble2) && optBoolean) {
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    Bundle bundle = new Bundle();
                    bundle.putString("citycode", aMapLocation.getCityCode());
                    bundle.putString(SocialConstants.PARAM_APP_DESC, optString4.toString());
                    bundle.putString("adcode", aMapLocation.getAdCode());
                    aMapLocation.setExtras(bundle);
                } else {
                    str = AMapLocation.COORD_TYPE_WGS84;
                }
                aMapLocation.setCoordType(str);
                Bundle bundle2 = new Bundle();
                bundle2.putString("citycode", aMapLocation.getCityCode());
                bundle2.putString(SocialConstants.PARAM_APP_DESC, optString4.toString());
                bundle2.putString("adcode", aMapLocation.getAdCode());
                aMapLocation.setExtras(bundle2);
            } catch (Throwable th) {
                h(th, "CoreUtil", "transformLocation");
            }
        }
    }

    private static void g(String str) {
        HashMap<String, String> hashMap;
        if (str != null) {
            try {
                if (str.length() == 0 || (hashMap = l) == null || !hashMap.containsKey(str)) {
                    return;
                }
                String str2 = l.get(str);
                String str3 = null;
                if (str2 != null && str2.length() > 0) {
                    str3 = new String(e1.h(p(str2), str), "utf-8");
                }
                if (str3 == null || str3.length() <= 0 || !str3.contains("http:")) {
                    return;
                }
                c = str3;
            } catch (Throwable th) {
                h(th, "CoreUtil", "checkUrl");
            }
        }
    }

    public static void h(Throwable th, String str, String str2) {
        if ("reportError".equals(str2) || (th instanceof k)) {
            return;
        }
        try {
            an.m(th, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static boolean i(double d2, double d3) {
        int i2 = (int) ((d3 - 73.0d) / 0.5d);
        int i3 = (int) ((d2 - 3.5d) / 0.5d);
        if (i3 < 0 || i3 >= 101 || i2 < 0 || i2 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((i3 * 124) + i2) == '1';
        } catch (Throwable th) {
            h(th, "CoreUtil", "isChina");
            return true;
        }
    }

    private static boolean j(double d2, double d3, double d4, double d5, double d6, double d7) {
        return Math.abs(m(d2, d3, d4, d5, d6, d7)) < 1.0E-9d && (d2 - d4) * (d2 - d6) <= 0.0d && (d3 - d5) * (d3 - d7) <= 0.0d;
    }

    private static boolean k(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d4 - d2;
        double d10 = d8 - d7;
        double d11 = d5 - d3;
        double d12 = 180.0d - d6;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 != 0.0d) {
            double d14 = d3 - d7;
            double d15 = d2 - d6;
            double d16 = ((d12 * d14) - (d10 * d15)) / d13;
            double d17 = ((d14 * d9) - (d15 * d11)) / d13;
            if (d16 >= 0.0d && d16 <= 1.0d && d17 >= 0.0d && d17 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x009a, code lost:
        if (r25 > r29) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009c, code lost:
        r22 = r22 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b9, code lost:
        if (r29 > r25) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean l(com.amap.api.location.DPoint r31, java.util.List<com.amap.api.location.DPoint> r32) {
        /*
            r0 = r32
            double r15 = r31.getLongitude()
            double r17 = r31.getLatitude()
            double r19 = r31.getLatitude()
            r13 = 0
            java.lang.Object r1 = r0.get(r13)
            com.amap.api.location.DPoint r1 = (com.amap.api.location.DPoint) r1
            int r2 = r32.size()
            r21 = 1
            int r2 = r2 + (-1)
            java.lang.Object r2 = r0.get(r2)
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L2e
            java.lang.Object r1 = r0.get(r13)
            r0.add(r1)
        L2e:
            r1 = 0
            r22 = 0
        L31:
            int r2 = r32.size()
            int r2 = r2 + (-1)
            if (r1 >= r2) goto Lda
            java.lang.Object r2 = r0.get(r1)
            com.amap.api.location.DPoint r2 = (com.amap.api.location.DPoint) r2
            double r23 = r2.getLongitude()
            java.lang.Object r2 = r0.get(r1)
            com.amap.api.location.DPoint r2 = (com.amap.api.location.DPoint) r2
            double r25 = r2.getLatitude()
            int r14 = r1 + 1
            java.lang.Object r1 = r0.get(r14)
            com.amap.api.location.DPoint r1 = (com.amap.api.location.DPoint) r1
            double r27 = r1.getLongitude()
            java.lang.Object r1 = r0.get(r14)
            com.amap.api.location.DPoint r1 = (com.amap.api.location.DPoint) r1
            double r29 = r1.getLatitude()
            r1 = r15
            r3 = r17
            r5 = r23
            r7 = r25
            r9 = r27
            r11 = r29
            boolean r1 = j(r1, r3, r5, r7, r9, r11)
            if (r1 == 0) goto L75
            return r21
        L75:
            double r1 = r29 - r25
            double r1 = java.lang.Math.abs(r1)
            r3 = 4472406533629990549(0x3e112e0be826d695, double:1.0E-9)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L9e
            r9 = 4640537203540230144(0x4066800000000000, double:180.0)
            r1 = r23
            r3 = r25
            r5 = r15
            r7 = r17
            r11 = r19
            boolean r1 = j(r1, r3, r5, r7, r9, r11)
            if (r1 == 0) goto La3
            int r1 = (r25 > r29 ? 1 : (r25 == r29 ? 0 : -1))
            if (r1 <= 0) goto L9e
        L9c:
            int r22 = r22 + 1
        L9e:
            r24 = r14
            r23 = 0
            goto Ld5
        La3:
            r9 = 4640537203540230144(0x4066800000000000, double:180.0)
            r1 = r27
            r3 = r29
            r5 = r15
            r7 = r17
            r11 = r19
            boolean r1 = j(r1, r3, r5, r7, r9, r11)
            if (r1 == 0) goto Lbc
            int r1 = (r29 > r25 ? 1 : (r29 == r25 ? 0 : -1))
            if (r1 <= 0) goto L9e
            goto L9c
        Lbc:
            r1 = r23
            r3 = r25
            r5 = r27
            r7 = r29
            r9 = r15
            r11 = r17
            r24 = r14
            r23 = 0
            r13 = r19
            boolean r1 = k(r1, r3, r5, r7, r9, r11, r13)
            if (r1 == 0) goto Ld5
            int r22 = r22 + 1
        Ld5:
            r1 = r24
            r13 = 0
            goto L31
        Lda:
            r23 = 0
            int r22 = r22 % 2
            if (r22 == 0) goto Le2
            r13 = 1
            goto Le3
        Le2:
            r13 = 0
        Le3:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.j1.l(com.amap.api.location.DPoint, java.util.List):boolean");
    }

    private static double m(double d2, double d3, double d4, double d5, double d6, double d7) {
        return ((d4 - d2) * (d7 - d3)) - ((d6 - d2) * (d5 - d3));
    }

    public static String n() {
        return d;
    }

    public static String o(Context context) {
        return r1.a(l.i(context));
    }

    private static byte[] p(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase(Locale.US);
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (m1.V(lowerCase.substring(i3, i3 + 2)) & 255);
        }
        return bArr;
    }

    public static u1 q() {
        try {
            if (m == null) {
                m = new u1.a("loc", "6.1.0", "AMAP_Location_SDK_Android 6.1.0").b(t()).a("6.1.0").c();
            }
        } catch (Throwable th) {
            h(th, "CoreUtil", "getSDKInfo");
        }
        return m;
    }

    public static void r(Context context) {
        try {
            if (v1.t(context)) {
                c = "http://abroad.apilocate.amap.com/mobile/binary";
                d = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            c = "http://apilocate.amap.com/mobile/binary";
            d = "http://dualstack-a.apilocate.amap.com/mobile/binary";
        } catch (Throwable th) {
            h(th, "CoreUtil", "changeUrl");
        }
    }

    public static String s() {
        return f;
    }

    private static String[] t() {
        return (String[]) e.clone();
    }

    private static void u() {
        try {
            if (l == null) {
                l = new HashMap<>(16);
            }
            l.clear();
            l.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
            l.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
            l.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
        } catch (Throwable th) {
            h(th, "CoreUtil", "initUrlHash");
        }
    }
}
