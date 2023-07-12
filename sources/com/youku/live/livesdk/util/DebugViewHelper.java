package com.youku.live.livesdk.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.widgets.container.pager.model.AppKeyPlayInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.LiveQuickPlayModel;
import com.youku.live.livesdk.widgets.container.pager.model.NewPlayInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.RtcInfoModel;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DebugViewHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PLAY_INFO_TAG = "play_info";
    public static final String SOURCE_FROM = "source_from";
    public static final String SPM_URL = "spm_url";
    public static final String SPM_URL_REPORT = "spm_url_report";
    private static Map<String, String> debugParams = new HashMap();
    private static TextView debugView;
    private static FloatView floatView;
    private static StringBuffer sb;

    public static void addDebugView(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1722691137")) {
            ipChange.ipc$dispatch("1722691137", new Object[]{activity});
        } else if (isDebuggable(activity)) {
            clearDebugView(activity);
            if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(activity)) {
                activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 1010);
            } else if (floatView != null) {
            } else {
                ScrollView scrollView = new ScrollView(activity);
                sb = new StringBuffer();
                TextView textView = new TextView(activity);
                debugView = textView;
                textView.setTextSize(dip2px(activity, 6));
                debugView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                scrollView.addView(debugView);
                FloatView floatView2 = new FloatView(activity, 0, 0, scrollView);
                floatView = floatView2;
                floatView2.setBackgroundColor(Color.parseColor("#80000000"));
                floatView.setIsAllowTouch(true);
                floatView.addToWindow();
            }
        }
    }

    public static void clearDebugView(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696730963")) {
            ipChange.ipc$dispatch("-1696730963", new Object[]{activity});
        } else if (debugView == null || !isDebuggable(activity)) {
        } else {
            StringBuffer stringBuffer = sb;
            stringBuffer.delete(0, stringBuffer.length());
            debugParams.clear();
            debugView.setText("");
        }
    }

    private static int dip2px(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1515758739") ? ((Integer) ipChange.ipc$dispatch("-1515758739", new Object[]{activity, Integer.valueOf(i)})).intValue() : (int) ((i * activity.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean isDebuggable(Activity activity) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140822332")) {
            return ((Boolean) ipChange.ipc$dispatch("-140822332", new Object[]{activity})).booleanValue();
        }
        try {
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if ((activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 0).flags & 2) != 0) {
            z = true;
            return !z && activity.getSharedPreferences("setting", 0).getBoolean("show_play_info", false);
        }
        z = false;
        if (z) {
        }
    }

    public static void removeDebugView(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2077216034")) {
            ipChange.ipc$dispatch("2077216034", new Object[]{activity});
        } else if (floatView == null || !isDebuggable(activity)) {
        } else {
            floatView.removeFromWindow();
            floatView = null;
        }
    }

    public static void updateMsg(Activity activity, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1630333287")) {
            ipChange.ipc$dispatch("1630333287", new Object[]{activity, map});
            return;
        }
        try {
            if (isDebuggable(activity)) {
                Iterator<String> it = map.keySet().iterator();
                while (true) {
                    String str = "空";
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (!TextUtils.isEmpty(next)) {
                        if (!debugParams.containsKey(next) && (next.equals(PLAY_INFO_TAG) || next.equals("source_from"))) {
                            String str2 = map.get(next);
                            if (next.equals(PLAY_INFO_TAG)) {
                                str2 = !TextUtils.isEmpty(str2) ? URLDecoder.decode(str2, "utf-8").replaceAll("\\$", "&") : "";
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            StringBuffer stringBuffer = sb;
                            stringBuffer.append("====" + next + "====\n");
                            stringBuffer.append(str);
                            stringBuffer.append(StringUtils.LF);
                            debugParams.put(next, str);
                        }
                    } else {
                        sb.append("====key为空====\n");
                    }
                }
                if (!debugParams.containsKey(PLAY_INFO_TAG) && !map.containsKey(PLAY_INFO_TAG)) {
                    StringBuffer stringBuffer2 = sb;
                    stringBuffer2.append("==== play_info ====\n");
                    stringBuffer2.append("空");
                    stringBuffer2.append(StringUtils.LF);
                    debugParams.put(PLAY_INFO_TAG, "空");
                }
                if (!debugParams.containsKey("source_from") && !map.containsKey("source_from")) {
                    StringBuffer stringBuffer3 = sb;
                    stringBuffer3.append("==== source_from ====\n");
                    stringBuffer3.append("空");
                    stringBuffer3.append(StringUtils.LF);
                    debugParams.put("source_from", "空");
                }
                debugView.setTextColor(Color.parseColor("#ff0000ff"));
                debugView.setText(sb.toString());
                debugView.setText(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateRoomScrollMsg(Activity activity, LiveQuickPlayModel liveQuickPlayModel, String str) {
        NewPlayInfoModel newPlayInfoModel;
        RtcInfoModel rtcInfoModel;
        NewPlayInfoModel newPlayInfoModel2;
        AppKeyPlayInfoModel appKeyPlayInfoModel;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1203252033")) {
            ipChange.ipc$dispatch("1203252033", new Object[]{activity, liveQuickPlayModel, str});
            return;
        }
        try {
            if (isDebuggable(activity)) {
                HashMap hashMap = new HashMap();
                if (liveQuickPlayModel != null && (newPlayInfoModel2 = liveQuickPlayModel.newPlayInfo) != null && (appKeyPlayInfoModel = newPlayInfoModel2.playInfo) != null) {
                    hashMap.put(PLAY_INFO_TAG, JSON.toJSONString(appKeyPlayInfoModel));
                } else if (liveQuickPlayModel != null && (newPlayInfoModel = liveQuickPlayModel.newPlayInfo) != null && (rtcInfoModel = newPlayInfoModel.rtcInfo) != null) {
                    hashMap.put(PLAY_INFO_TAG, JSON.toJSONString(rtcInfoModel));
                } else {
                    hashMap.put(PLAY_INFO_TAG, "");
                }
                hashMap.put("source_from", str);
                updateMsg(activity, hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
