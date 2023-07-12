package com.ali.user.mobile;

import android.app.Activity;
import android.text.TextUtils;
import com.ali.user.mobile.app.LoginContext;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.info.AppInfo;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.service.UserTrackService;
import com.alibaba.fastjson.JSON;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.annotation.JSMethod;
import com.tencent.open.SocialConstants;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import tb.fd1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserTraceImpl implements UserTrackService {
    public static final String TAG = "login.UserTraceImpl";
    private Map<String, Long> durationMap = new ConcurrentHashMap();
    private String cachePageName = "";

    private void addMonitorPageTrack(String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            if (TextUtils.equals("page-appear", str2)) {
                this.cachePageName = str;
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("page", str);
                }
            } else if (TextUtils.equals("page-disappear", str2)) {
                if (!TextUtils.isEmpty(this.cachePageName)) {
                    hashMap.put("page", this.cachePageName);
                }
                this.cachePageName = "";
            }
            hashMap.put("type", str2);
            hashMap.put("action", "page-action");
            hashMap.put("status", "commit");
            ArmsMonitor.commitSuccess(DataProviderFactory.getApplicationContext(), "halo-account-sdk", URIAdapter.OTHERS, JSON.toJSONString(hashMap));
        } catch (Throwable unused) {
        }
    }

    private void addMonitorTrack(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("page", str);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("code", URLEncoder.encode(str3, "UTF-8"));
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("type", str4);
            } else if (map != null && !TextUtils.isEmpty(map.get("type"))) {
                hashMap.put("type", map.get("type"));
                map.remove("type");
            }
            if (!TextUtils.isEmpty(str2)) {
                if (TextUtils.equals("loginRpc", str2)) {
                    hashMap.put("action", "loginRpc");
                    hashMap.put("status", "commit");
                } else {
                    if (TextUtils.equals("loginSuccess", str2)) {
                        hashMap.put("action", "loginRpc");
                        hashMap.put("status", "success");
                    } else if (TextUtils.equals("loginFailed", str2)) {
                        hashMap.put("action", "loginRpc");
                        hashMap.put("status", AKBaseAbility.CALLBACK_FAILURE);
                    } else if (!TextUtils.isEmpty(str2) && (str2.endsWith("_commit") || str2.endsWith("_success") || str2.endsWith("_failure") || str2.endsWith("_cancel"))) {
                        int lastIndexOf = str2.lastIndexOf(JSMethod.NOT_SET);
                        hashMap.put("action", str2.substring(0, lastIndexOf));
                        hashMap.put("status", str2.substring(lastIndexOf + 1));
                    } else {
                        hashMap.put("action", str2);
                    }
                    str5 = "T";
                }
            }
            if (map != null) {
                hashMap.put(SocialConstants.PARAM_COMMENT, URLEncoder.encode(map.toString(), "UTF-8"));
                hashMap.put("duration", TextUtils.isEmpty(map.get("duration")) ? "0" : map.get("duration"));
            }
            if (TextUtils.equals("T", str5)) {
                ArmsMonitor.commitSuccess(DataProviderFactory.getApplicationContext(), "halo-account-sdk", LoginConstant.ACCOUNT, JSON.toJSONString(hashMap));
            } else if (TextUtils.equals("NONE", str5)) {
            } else {
                ArmsMonitor.commitSuccess(DataProviderFactory.getApplicationContext(), "halo-account-sdk", "tracelog", JSON.toJSONString(hashMap));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private long getDuration(String str) {
        Long l;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (str.endsWith("_commit") || str.endsWith("_success")) {
            int lastIndexOf = str.lastIndexOf(JSMethod.NOT_SET);
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf + 1);
            if (TextUtils.equals(substring2, "commit")) {
                this.durationMap.put(substring, Long.valueOf(System.currentTimeMillis()));
                return 0L;
            } else if (!TextUtils.equals(substring2, "success") || (l = this.durationMap.get(substring)) == null || l.longValue() <= 0) {
                return 0L;
            } else {
                long currentTimeMillis = System.currentTimeMillis() - l.longValue();
                this.durationMap.remove(substring);
                return currentTimeMillis;
            }
        }
        return 0L;
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void UIShown(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("spm-cnt", str2 + "." + str3 + "." + str3);
            }
            addExtra(hashMap);
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(str, 2201, str3, null, null, hashMap);
            uTOriginalCustomHitBuilder.setProperties(hashMap);
            UTAnalytics.getInstance().getDefaultTracker().send(uTOriginalCustomHitBuilder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addExtra(Map<String, String> map) {
        try {
            map.put("utdid_hash", String.valueOf(Math.abs(AppInfo.getInstance().getUtdid().hashCode()) % 10000));
            map.put("trace_id", LoginContext.getTraceId());
            map.put("launch_times", String.valueOf(LoginContext.getLaunchTimes()));
            if (!TextUtils.isEmpty(LoginContext.loginUIType)) {
                map.put("loginUIType", LoginContext.loginUIType);
            }
            if (TextUtils.isEmpty(LoginContext.mFrom)) {
                return;
            }
            map.put("source", LoginContext.mFrom);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void pageDisAppear(Activity activity) {
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
        addMonitorPageTrack("", "page-disappear");
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendControlUT(String str, String str2) {
        sendControlUT(str, str2, "", null);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendUT(String str, String str2, Properties properties) {
        sendUT(str, str2, null, properties);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendUserTrack(String str, String str2, Map<String, String> map) {
        try {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
            if (!TextUtils.isEmpty(str)) {
                uTCustomHitBuilder.setEventPage(str);
            } else {
                uTCustomHitBuilder.setEventPage(UTConstant.PageName.UT_PAGE_EXTEND);
            }
            String str3 = "";
            if (map != null) {
                str3 = map.get("monitor");
                uTCustomHitBuilder.setProperties(map);
            } else {
                map = new HashMap<>();
            }
            Map<String, String> map2 = map;
            addExtra(map2);
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
            addMonitorTrack(str, str2, "", "", str3, map2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void skipPage(Activity activity) {
        UTAnalytics.getInstance().getDefaultTracker().skipPage(activity);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void updatePageName(Activity activity, String str, String str2) {
        UTAnalytics.getInstance().getDefaultTracker().pageDisAppear(activity);
        UTAnalytics.getInstance().getDefaultTracker().pageAppearDonotSkip(activity, str);
        try {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("spm-cnt", str2);
            }
            addExtra(hashMap);
            UTAnalytics.getInstance().getDefaultTracker().updatePageProperties(activity, hashMap);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        addMonitorPageTrack(str, "page-appear");
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendControlUT(String str, String str2, String str3) {
        sendControlUT(str, str2, str3, null);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendUT(String str, String str2) {
        sendUT(str, str2, null);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendControlUT(String str, String str2, String str3, Map<String, String> map) {
        sendControlUT(str, null, str2, str3, "", map);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendUT(String str, Properties properties) {
        sendUT(null, str, properties);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendControlUT(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        UTHitBuilders.UTControlHitBuilder uTControlHitBuilder = new UTHitBuilders.UTControlHitBuilder(str, str3);
        if (!TextUtils.isEmpty(str4)) {
            uTControlHitBuilder.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG2, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            uTControlHitBuilder.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG3, str5);
        }
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder(str2);
            if (UTConstant.CustomEvent.UT_LOGIN_ACTION.equals(str3)) {
                sb.append(".");
                sb.append("loginAction_");
                sb.append(str5);
                sb.append(".");
                sb.append("loginAction_");
                sb.append(str5);
            } else {
                sb.append(".");
                sb.append(str3);
                sb.append(".");
                sb.append(str3);
            }
            map2.put("spm-cnt", sb.toString());
        }
        addExtra(map2);
        uTControlHitBuilder.setProperties(map2);
        UTAnalytics.getInstance().getDefaultTracker().send(uTControlHitBuilder.build());
        addMonitorTrack(str, str3, str4, str5, "", map2);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendUT(String str) {
        sendUT(null, str, null);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendUT(String str, String str2, String str3, Properties properties) {
        sendUT(str, str2, str3, null, properties);
    }

    @Override // com.ali.user.mobile.service.UserTrackService
    public void sendUT(String str, String str2, String str3, String str4, Properties properties) {
        try {
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder(str2);
            if (!TextUtils.isEmpty(str)) {
                uTCustomHitBuilder.setEventPage(str);
            } else {
                uTCustomHitBuilder.setEventPage(UTConstant.PageName.UT_PAGE_EXTEND);
            }
            if (!TextUtils.isEmpty(str3)) {
                uTCustomHitBuilder.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG2, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                uTCustomHitBuilder.setProperty(UTHitBuilders.UTHitBuilder.FIELD_ARG3, str4);
            }
            String str5 = "";
            if (properties != null) {
                str5 = properties.getProperty("monitor");
            } else {
                properties = new Properties();
            }
            String str6 = str5;
            long duration = getDuration(str2);
            if (duration > 0) {
                properties.setProperty("duration", String.valueOf(duration));
            }
            properties.put("utdid_hash", String.valueOf(Math.abs(AppInfo.getInstance().getUtdid().hashCode()) % 10000));
            properties.put("trace_id", LoginContext.getTraceId());
            properties.put("launch_times", String.valueOf(LoginContext.getLaunchTimes()));
            if (!TextUtils.isEmpty(LoginContext.loginUIType)) {
                properties.put("loginUIType", LoginContext.loginUIType);
            }
            if (!TextUtils.isEmpty(LoginContext.mFrom)) {
                properties.put("source", LoginContext.mFrom);
            }
            uTCustomHitBuilder.setProperties(fd1.b(properties));
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
            addMonitorTrack(str, str2, str3, str4, str6, fd1.b(properties));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
