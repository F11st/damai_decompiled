package com.alibaba.motu.tbrest.rest;

import android.content.Context;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.utils.DeviceUtils;
import com.alibaba.motu.tbrest.utils.LogUtil;
import com.alibaba.motu.tbrest.utils.RC4;
import com.alibaba.motu.tbrest.utils.StringUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import tb.C9225hn;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestReqDataBuilder {
    private static long s_session_start_timestamp = System.currentTimeMillis();

    private static String _fixVariableValue(String str) {
        if (StringUtils.isBlank(str)) {
            return "-";
        }
        if (str == null || "".equals(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '\n' && charArray[i] != '\r' && charArray[i] != '\t' && charArray[i] != '|') {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }

    public static String assembleWithFullFields(Map<String, String> map) {
        boolean z;
        RestFieldsScheme restFieldsScheme;
        StringBuffer stringBuffer = new StringBuffer();
        RestFieldsScheme[] values = RestFieldsScheme.values();
        int length = values.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length || (restFieldsScheme = values[i]) == RestFieldsScheme.ARGS) {
                break;
            }
            if (map.containsKey(restFieldsScheme.toString())) {
                str = StringUtils.convertObjectToString(map.get(restFieldsScheme.toString()));
                map.remove(restFieldsScheme.toString());
            }
            stringBuffer.append(_fixVariableValue(str));
            stringBuffer.append(jn1.OR);
            i++;
        }
        RestFieldsScheme restFieldsScheme2 = RestFieldsScheme.ARGS;
        if (map.containsKey(restFieldsScheme2.toString())) {
            stringBuffer.append(_fixVariableValue(StringUtils.convertObjectToString(map.get(restFieldsScheme2.toString()))));
            map.remove(restFieldsScheme2.toString());
            z = false;
        } else {
            z = true;
        }
        for (String str2 : map.keySet()) {
            String convertObjectToString = map.containsKey(str2) ? StringUtils.convertObjectToString(map.get(str2)) : null;
            if (z) {
                if ("StackTrace".equals(str2)) {
                    stringBuffer.append("StackTrace=====>");
                    stringBuffer.append(convertObjectToString);
                } else {
                    stringBuffer.append(_fixVariableValue(str2));
                    stringBuffer.append("=");
                    stringBuffer.append(convertObjectToString);
                }
                z = false;
            } else if ("StackTrace".equals(str2)) {
                stringBuffer.append(",");
                stringBuffer.append("StackTrace=====>");
                stringBuffer.append(convertObjectToString);
            } else {
                stringBuffer.append(",");
                stringBuffer.append(_fixVariableValue(str2));
                stringBuffer.append("=");
                stringBuffer.append(convertObjectToString);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (StringUtils.isEmpty(stringBuffer2) || !stringBuffer2.endsWith(jn1.OR)) {
            return stringBuffer2;
        }
        return stringBuffer2 + "-";
    }

    public static RestReqDataBuildResult buildMonkeyPostReqDataObj(String str, Context context, long j, String str2, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        return buildMonkeyPostReqDataObj(SendService.getInstance().appKey, str, context, j, str2, i, obj, obj2, obj3, map);
    }

    public static Map<String, Object> buildPostRequestMap(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("stm_x", str);
        return buildPostRequestMap(hashMap);
    }

    public static String buildRequestData(long j, String str, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        return buildRequestData(SendService.getInstance().appKey, j, str, i, obj, obj2, obj3, map);
    }

    public static RestReqDataBuildResult buildMonkeyPostReqDataObj(String str, String str2, Context context, long j, String str3, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        if (i == 0) {
            return null;
        }
        try {
            String utdid = DeviceUtils.getUtdid(SendService.getInstance().context);
            if (utdid == null) {
                LogUtil.e("get utdid failure, so build report failure, now return");
                return null;
            }
            String[] networkType = DeviceUtils.getNetworkType(SendService.getInstance().context);
            String str4 = networkType[0];
            String str5 = (networkType.length <= 1 || str4 == null || "Wi-Fi".equals(str4)) ? null : networkType[1];
            long currentTimeMillis = j > 0 ? j : System.currentTimeMillis();
            String str6 = "" + currentTimeMillis;
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(currentTimeMillis));
            String _fixVariableValue = _fixVariableValue(str3);
            String _fixVariableValue2 = _fixVariableValue(String.valueOf(i));
            String _fixVariableValue3 = _fixVariableValue(StringUtils.convertObjectToString(obj));
            String _fixVariableValue4 = _fixVariableValue(StringUtils.convertObjectToString(obj2));
            String _fixVariableValue5 = _fixVariableValue(StringUtils.convertObjectToString(obj3));
            String _fixVariableValue6 = _fixVariableValue(StringUtils.convertMapToString(map));
            String _fixVariableValue7 = _fixVariableValue(DeviceUtils.getImei(SendService.getInstance().context));
            String _fixVariableValue8 = _fixVariableValue(DeviceUtils.getImsi(SendService.getInstance().context));
            String _fixVariableValue9 = _fixVariableValue(Build.getBRAND());
            String _fixVariableValue10 = _fixVariableValue(DeviceUtils.getCpuName());
            String _fixVariableValue11 = _fixVariableValue(_fixVariableValue7);
            String _fixVariableValue12 = _fixVariableValue(Build.getMODEL());
            String _fixVariableValue13 = _fixVariableValue(DeviceUtils.getResolution());
            String _fixVariableValue14 = _fixVariableValue(DeviceUtils.getCarrier(SendService.getInstance().context));
            String _fixVariableValue15 = _fixVariableValue(str4);
            String _fixVariableValue16 = _fixVariableValue(str5);
            String _fixVariableValue17 = _fixVariableValue(str);
            String _fixVariableValue18 = _fixVariableValue(SendService.getInstance().appVersion);
            String _fixVariableValue19 = _fixVariableValue(SendService.getInstance().channel);
            String _fixVariableValue20 = _fixVariableValue(SendService.getInstance().userNick);
            String _fixVariableValue21 = _fixVariableValue(SendService.getInstance().userNick);
            String _fixVariableValue22 = _fixVariableValue(DeviceUtils.getCountry());
            String _fixVariableValue23 = _fixVariableValue(DeviceUtils.getLanguage());
            String str7 = SendService.getInstance().appId;
            String str8 = "aliyunos";
            if (str7 == null || !str7.contains("aliyunos")) {
                str8 = "Android";
            }
            String _fixVariableValue24 = _fixVariableValue(Build.VERSION.getRELEASE());
            String _fixVariableValue25 = _fixVariableValue(utdid);
            StringUtils.isBlank("");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("5.0.1");
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue7);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue8);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue9);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue10);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue11);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue12);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue13);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue14);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue15);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue16);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue19);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue17);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue18);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue20);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue21);
            stringBuffer.append(jn1.OR);
            stringBuffer.append("-");
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue22);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue23);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(str8);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue24);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(C9225hn.SDK_TYPE);
            stringBuffer.append(jn1.OR);
            stringBuffer.append("1.0");
            stringBuffer.append(jn1.OR);
            stringBuffer.append("" + s_session_start_timestamp);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue25);
            stringBuffer.append(jn1.OR);
            stringBuffer.append("-");
            stringBuffer.append(jn1.OR);
            stringBuffer.append("-");
            stringBuffer.append(jn1.OR);
            stringBuffer.append("-");
            stringBuffer.append(jn1.OR);
            stringBuffer.append("-");
            stringBuffer.append(jn1.OR);
            stringBuffer.append(format);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(str6);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue2);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue3);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue4);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue5);
            stringBuffer.append(jn1.OR);
            stringBuffer.append(_fixVariableValue6);
            String stringBuffer2 = stringBuffer.toString();
            HashMap hashMap = new HashMap();
            hashMap.put("stm_x", stringBuffer2.getBytes());
            RestReqDataBuildResult restReqDataBuildResult = new RestReqDataBuildResult();
            restReqDataBuildResult.setReqUrl(RestUrlWrapper.getSignedTransferUrl(str2, null, hashMap, context, _fixVariableValue17, _fixVariableValue19, _fixVariableValue18, str8, "", _fixVariableValue25));
            restReqDataBuildResult.setPostReqData(hashMap);
            return restReqDataBuildResult;
        } catch (Exception e) {
            LogUtil.e("UTRestAPI buildTracePostReqDataObj catch!", e);
            return null;
        }
    }

    public static String buildRequestData(String str, long j, String str2, int i, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        String str3 = null;
        if (i == 0) {
            return null;
        }
        try {
            String utdid = DeviceUtils.getUtdid(SendService.getInstance().context);
            if (utdid == null) {
                LogUtil.e("get utdid failure, so build report failure, now return");
                return null;
            }
            String[] networkType = DeviceUtils.getNetworkType(SendService.getInstance().context);
            String str4 = networkType[0];
            if (networkType.length > 1 && str4 != null && !"Wi-Fi".equals(str4)) {
                str3 = networkType[1];
            }
            String str5 = "" + (j > 0 ? j : System.currentTimeMillis());
            String _fixVariableValue = _fixVariableValue(str2);
            String _fixVariableValue2 = _fixVariableValue(String.valueOf(i));
            String _fixVariableValue3 = _fixVariableValue(StringUtils.convertObjectToString(obj));
            String _fixVariableValue4 = _fixVariableValue(StringUtils.convertObjectToString(obj2));
            String _fixVariableValue5 = _fixVariableValue(StringUtils.convertObjectToString(obj3));
            String _fixVariableValue6 = _fixVariableValue(StringUtils.convertMapToString(map));
            String _fixVariableValue7 = _fixVariableValue(DeviceUtils.getImei(SendService.getInstance().context));
            String _fixVariableValue8 = _fixVariableValue(DeviceUtils.getImsi(SendService.getInstance().context));
            String _fixVariableValue9 = _fixVariableValue(Build.getBRAND());
            _fixVariableValue(DeviceUtils.getCpuName());
            _fixVariableValue(_fixVariableValue7);
            String _fixVariableValue10 = _fixVariableValue(Build.getMODEL());
            String _fixVariableValue11 = _fixVariableValue(DeviceUtils.getResolution());
            String _fixVariableValue12 = _fixVariableValue(DeviceUtils.getCarrier(SendService.getInstance().context));
            String _fixVariableValue13 = _fixVariableValue(str4);
            String _fixVariableValue14 = _fixVariableValue(str3);
            String _fixVariableValue15 = _fixVariableValue(str);
            String _fixVariableValue16 = _fixVariableValue(SendService.getInstance().appVersion);
            String _fixVariableValue17 = _fixVariableValue(SendService.getInstance().channel);
            String _fixVariableValue18 = _fixVariableValue(SendService.getInstance().userNick);
            String _fixVariableValue19 = _fixVariableValue(SendService.getInstance().userNick);
            String _fixVariableValue20 = _fixVariableValue(DeviceUtils.getCountry());
            String _fixVariableValue21 = _fixVariableValue(DeviceUtils.getLanguage());
            String str6 = SendService.getInstance().appId;
            String str7 = "a";
            String _fixVariableValue22 = _fixVariableValue(Build.VERSION.getRELEASE());
            String _fixVariableValue23 = _fixVariableValue(utdid);
            String _fixVariableValue24 = _fixVariableValue("_app_build_id=" + SendService.getInstance().buildId);
            String _fixVariableValue25 = _fixVariableValue(_fixVariableValue("country=" + _fixVariableValue20) + "," + _fixVariableValue24);
            StringUtils.isBlank("");
            if (str6 != null && str6.contains("aliyunos")) {
                str7 = Constants.Name.Y;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(RestFieldsScheme.IMEI.toString(), _fixVariableValue7);
            hashMap.put(RestFieldsScheme.IMSI.toString(), _fixVariableValue8);
            hashMap.put(RestFieldsScheme.BRAND.toString(), _fixVariableValue9);
            hashMap.put(RestFieldsScheme.DEVICE_MODEL.toString(), _fixVariableValue10);
            hashMap.put(RestFieldsScheme.RESOLUTION.toString(), _fixVariableValue11);
            hashMap.put(RestFieldsScheme.CARRIER.toString(), _fixVariableValue12);
            hashMap.put(RestFieldsScheme.ACCESS.toString(), _fixVariableValue13);
            hashMap.put(RestFieldsScheme.ACCESS_SUBTYPE.toString(), _fixVariableValue14);
            hashMap.put(RestFieldsScheme.CHANNEL.toString(), _fixVariableValue17);
            hashMap.put(RestFieldsScheme.APPKEY.toString(), _fixVariableValue15);
            hashMap.put(RestFieldsScheme.APPVERSION.toString(), _fixVariableValue16);
            hashMap.put(RestFieldsScheme.LL_USERNICK.toString(), _fixVariableValue18);
            hashMap.put(RestFieldsScheme.USERNICK.toString(), _fixVariableValue19);
            hashMap.put(RestFieldsScheme.LL_USERID.toString(), "-");
            hashMap.put(RestFieldsScheme.USERID.toString(), "-");
            hashMap.put(RestFieldsScheme.LANGUAGE.toString(), _fixVariableValue21);
            hashMap.put(RestFieldsScheme.OS.toString(), str7);
            hashMap.put(RestFieldsScheme.OSVERSION.toString(), _fixVariableValue22);
            hashMap.put(RestFieldsScheme.SDKVERSION.toString(), "1.0");
            hashMap.put(RestFieldsScheme.START_SESSION_TIMESTAMP.toString(), "" + s_session_start_timestamp);
            hashMap.put(RestFieldsScheme.UTDID.toString(), _fixVariableValue23);
            hashMap.put(RestFieldsScheme.SDKTYPE.toString(), C9225hn.SDK_TYPE);
            hashMap.put(RestFieldsScheme.RESERVE2.toString(), _fixVariableValue23);
            hashMap.put(RestFieldsScheme.RESERVE3.toString(), "-");
            hashMap.put(RestFieldsScheme.RESERVE4.toString(), "-");
            hashMap.put(RestFieldsScheme.RESERVE5.toString(), "-");
            hashMap.put(RestFieldsScheme.RESERVES.toString(), _fixVariableValue25);
            hashMap.put(RestFieldsScheme.RECORD_TIMESTAMP.toString(), str5);
            hashMap.put(RestFieldsScheme.PAGE.toString(), _fixVariableValue);
            hashMap.put(RestFieldsScheme.EVENTID.toString(), _fixVariableValue2);
            hashMap.put(RestFieldsScheme.ARG1.toString(), _fixVariableValue3);
            hashMap.put(RestFieldsScheme.ARG2.toString(), _fixVariableValue4);
            hashMap.put(RestFieldsScheme.ARG3.toString(), _fixVariableValue5);
            hashMap.put(RestFieldsScheme.ARGS.toString(), _fixVariableValue6);
            return assembleWithFullFields(hashMap);
        } catch (Exception e) {
            LogUtil.e("UTRestAPI buildTracePostReqDataObj catch!", e);
            return "";
        }
    }

    public static Map<String, Object> buildPostRequestMap(Map<String, String> map) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (map != null && map.size() > 0) {
            try {
                HashMap hashMap = new HashMap();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(str2)) {
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            } catch (IOException unused) {
                                gZIPOutputStream = null;
                            }
                        } catch (IOException unused2) {
                            byteArrayOutputStream = null;
                            gZIPOutputStream = null;
                        }
                        try {
                            gZIPOutputStream.write(str2.getBytes("UTF-8"));
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                            hashMap.put(str, RC4.rc4(byteArrayOutputStream.toByteArray()));
                        } catch (IOException unused3) {
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                        }
                    }
                }
                return hashMap;
            } catch (Exception e) {
                LogUtil.e("buildPostRequestMap", e);
            }
        }
        return null;
    }
}
