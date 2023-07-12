package android.taobao.windvane.urlintercept;

import android.taobao.windvane.config.WVServerConfig;
import android.taobao.windvane.connect.api.ApiResponse;
import android.taobao.windvane.urlintercept.WVURLInterceptData;
import android.taobao.windvane.util.WVUrlUtil;
import android.text.TextUtils;
import com.taobao.orange.OConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVURLInterceptHelper {
    private static String TAG = "WVURLInterceptHelper";
    private static final String URL_FILTER_TAG = "_wv_url_hyid";

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e6, code lost:
        r1.params = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e9, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized android.taobao.windvane.urlintercept.WVURLInterceptData.URLInfo parseByRule(java.lang.String r9, java.util.Set<android.taobao.windvane.urlintercept.WVURLInterceptData.RuleData> r10, java.util.Map<java.lang.String, java.util.regex.Pattern> r11) {
        /*
            java.lang.Class<android.taobao.windvane.urlintercept.WVURLInterceptHelper> r0 = android.taobao.windvane.urlintercept.WVURLInterceptHelper.class
            monitor-enter(r0)
            android.taobao.windvane.urlintercept.WVURLInterceptData$URLInfo r1 = new android.taobao.windvane.urlintercept.WVURLInterceptData$URLInfo     // Catch: java.lang.Throwable -> Lea
            r1.<init>()     // Catch: java.lang.Throwable -> Lea
            r1.url = r9     // Catch: java.lang.Throwable -> Lea
            java.util.Hashtable r2 = new java.util.Hashtable     // Catch: java.lang.Throwable -> Lea
            r2.<init>()     // Catch: java.lang.Throwable -> Lea
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> Lea
        L13:
            boolean r3 = r10.hasNext()     // Catch: java.lang.Throwable -> Lea
            if (r3 == 0) goto Le6
            java.lang.Object r3 = r10.next()     // Catch: java.lang.Throwable -> Lea
            android.taobao.windvane.urlintercept.WVURLInterceptData$RuleData r3 = (android.taobao.windvane.urlintercept.WVURLInterceptData.RuleData) r3     // Catch: java.lang.Throwable -> Lea
            java.lang.String r4 = r3.pattern     // Catch: java.lang.Throwable -> Lea
            java.lang.Object r5 = r11.get(r4)     // Catch: java.lang.Throwable -> Lea
            java.util.regex.Pattern r5 = (java.util.regex.Pattern) r5     // Catch: java.lang.Throwable -> Lea
            if (r5 != 0) goto L48
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r4)     // Catch: java.util.regex.PatternSyntaxException -> L31 java.lang.Throwable -> Lea
            r11.put(r4, r5)     // Catch: java.util.regex.PatternSyntaxException -> L31 java.lang.Throwable -> Lea
            goto L48
        L31:
            java.lang.String r6 = android.taobao.windvane.urlintercept.WVURLInterceptHelper.TAG     // Catch: java.lang.Throwable -> Lea
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lea
            r7.<init>()     // Catch: java.lang.Throwable -> Lea
            java.lang.String r8 = "pattern:"
            r7.append(r8)     // Catch: java.lang.Throwable -> Lea
            r7.append(r4)     // Catch: java.lang.Throwable -> Lea
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lea
            android.taobao.windvane.util.TaoLog.e(r6, r7)     // Catch: java.lang.Throwable -> Lea
        L48:
            if (r5 != 0) goto L4c
            monitor-exit(r0)
            return r1
        L4c:
            java.util.regex.Matcher r5 = r5.matcher(r9)     // Catch: java.lang.Throwable -> Lea
            boolean r6 = r5.matches()     // Catch: java.lang.Throwable -> Lea
            if (r6 == 0) goto L13
            boolean r10 = android.taobao.windvane.util.TaoLog.getLogStatus()     // Catch: java.lang.Throwable -> Lea
            if (r10 == 0) goto L73
            java.lang.String r10 = android.taobao.windvane.urlintercept.WVURLInterceptHelper.TAG     // Catch: java.lang.Throwable -> Lea
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lea
            r11.<init>()     // Catch: java.lang.Throwable -> Lea
            java.lang.String r6 = "url matched for pattern "
            r11.append(r6)     // Catch: java.lang.Throwable -> Lea
            r11.append(r4)     // Catch: java.lang.Throwable -> Lea
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> Lea
            android.taobao.windvane.util.TaoLog.d(r10, r11)     // Catch: java.lang.Throwable -> Lea
        L73:
            int r10 = r3.target     // Catch: java.lang.Throwable -> Lea
            r1.code = r10     // Catch: java.lang.Throwable -> Lea
            r1.rule = r4     // Catch: java.lang.Throwable -> Lea
            int r10 = r3.rutype     // Catch: java.lang.Throwable -> Lea
            if (r10 != 0) goto Lb5
            int r9 = r5.groupCount()     // Catch: java.lang.Throwable -> Lea
            java.util.Map<java.lang.String, java.lang.Integer> r10 = r3.indexp     // Catch: java.lang.Throwable -> Lea
            java.util.Set r10 = r10.entrySet()     // Catch: java.lang.Throwable -> Lea
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> Lea
        L8b:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> Lea
            if (r11 == 0) goto Le6
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Throwable -> Lea
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch: java.lang.Throwable -> Lea
            java.lang.Object r3 = r11.getValue()     // Catch: java.lang.Throwable -> Lea
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> Lea
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> Lea
            java.lang.String r4 = r5.group(r3)     // Catch: java.lang.Throwable -> Lea
            if (r9 < r3) goto L8b
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lea
            if (r3 != 0) goto L8b
            java.lang.Object r11 = r11.getKey()     // Catch: java.lang.Throwable -> Lea
            r2.put(r11, r4)     // Catch: java.lang.Throwable -> Lea
            goto L8b
        Lb5:
            r11 = 1
            if (r10 != r11) goto Le6
            java.util.Map<java.lang.String, java.lang.String> r10 = r3.namep     // Catch: java.lang.Throwable -> Lea
            java.util.Set r10 = r10.entrySet()     // Catch: java.lang.Throwable -> Lea
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> Lea
        Lc2:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> Lea
            if (r11 == 0) goto Le6
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Throwable -> Lea
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch: java.lang.Throwable -> Lea
            java.lang.Object r3 = r11.getKey()     // Catch: java.lang.Throwable -> Lea
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lea
            java.lang.String r3 = android.taobao.windvane.util.WVUrlUtil.getParamVal(r9, r3)     // Catch: java.lang.Throwable -> Lea
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lea
            if (r4 != 0) goto Lc2
            java.lang.Object r11 = r11.getValue()     // Catch: java.lang.Throwable -> Lea
            r2.put(r11, r3)     // Catch: java.lang.Throwable -> Lea
            goto Lc2
        Le6:
            r1.params = r2     // Catch: java.lang.Throwable -> Lea
            monitor-exit(r0)
            return r1
        Lea:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.urlintercept.WVURLInterceptHelper.parseByRule(java.lang.String, java.util.Set, java.util.Map):android.taobao.windvane.urlintercept.WVURLInterceptData$URLInfo");
    }

    public static WVURLInterceptData.URLInfo parseByTag(String str) {
        String paramVal = WVUrlUtil.getParamVal(str, URL_FILTER_TAG);
        if (TextUtils.isEmpty(paramVal)) {
            return null;
        }
        WVURLInterceptData.URLInfo uRLInfo = new WVURLInterceptData.URLInfo();
        uRLInfo.url = str;
        if (paramVal.contains(";")) {
            int indexOf = paramVal.indexOf(";");
            uRLInfo.code = Integer.parseInt(TextUtils.substring(paramVal, 0, indexOf));
            HashMap hashMap = new HashMap();
            for (String str2 : TextUtils.substring(paramVal, indexOf + 1, paramVal.length()).split(",")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    String paramVal2 = WVUrlUtil.getParamVal(str, split[1].trim());
                    if (!TextUtils.isEmpty(paramVal2)) {
                        hashMap.put(split[0].trim(), paramVal2);
                    }
                }
            }
            uRLInfo.params = hashMap;
            return uRLInfo;
        }
        return null;
    }

    public static List<WVURLInterceptData.RuleData> parseRuleData(String str) {
        List<WVURLInterceptData.RuleData> synchronizedList = Collections.synchronizedList(new ArrayList());
        ApiResponse apiResponse = new ApiResponse();
        JSONObject jSONObject = apiResponse.parseJsonResult(str).success ? apiResponse.data : null;
        if (jSONObject != null) {
            try {
                ArrayList arrayList = new ArrayList();
                try {
                    WVServerConfig.URL_FILTER = jSONObject.optInt(OConstant.DIMEN_FILE_LOCK, 0) == 0;
                    if (jSONObject.has("rules")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("rules");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                            WVURLInterceptData.RuleData ruleData = new WVURLInterceptData.RuleData();
                            ruleData.target = jSONObject2.getInt("target");
                            ruleData.pattern = jSONObject2.getString("pattern");
                            ruleData.rutype = jSONObject2.optInt("rutype");
                            for (String str2 : jSONObject2.optString("indexp").split(",")) {
                                String[] split = str2.split(":");
                                if (split.length == 2 && TextUtils.isDigitsOnly(split[1].trim())) {
                                    ruleData.indexp.put(split[0].trim(), Integer.valueOf(Integer.parseInt(split[1].trim())));
                                }
                            }
                            for (String str3 : jSONObject2.optString("namep").split(",")) {
                                String[] split2 = str3.split(":");
                                if (split2.length == 2) {
                                    ruleData.namep.put(split2[1].trim(), split2[0].trim());
                                }
                            }
                            arrayList.add(ruleData);
                        }
                    }
                } catch (Exception unused) {
                }
                return arrayList;
            } catch (Exception unused2) {
                return synchronizedList;
            }
        }
        return synchronizedList;
    }
}
