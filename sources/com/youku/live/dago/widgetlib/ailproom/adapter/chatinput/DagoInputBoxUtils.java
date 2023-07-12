package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.BuildConfig;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoInputBoxUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String KEY_SOFT_KEYBOARD_HEIGHT = "SoftKeyboardHeight";
    public static final int HEIGHT_EDIT_TEXT_DEFAULT = UIUtil.dip2px(54);
    public static final int HEIGHT_PANEL_EMOJI = UIUtil.dip2px(BuildConfig.VERSION_CODE);
    private static final int HEIGHT_KEYBOARD_DEFAULT = UIUtil.getScreenHeight(UIUtil.getContext()) / 2;
    private static final String EMOJI_KEYBOARD = "EmojiKeyboard";
    private static SharedPreferences sharedPreferences = UIUtil.getContext().getSharedPreferences(EMOJI_KEYBOARD, 0);

    public static int getKeyboardHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602541067")) {
            return ((Integer) ipChange.ipc$dispatch("-1602541067", new Object[0])).intValue();
        }
        int i = sharedPreferences.getInt(KEY_SOFT_KEYBOARD_HEIGHT, HEIGHT_KEYBOARD_DEFAULT);
        ((ILog) Dsl.getService(ILog.class)).i("jiangzkb", "getKeyboardHeight: " + i);
        return i;
    }

    public static double getLengthCH(String str) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-187035203")) {
            return ((Double) ipChange.ipc$dispatch("-187035203", new Object[]{str})).doubleValue();
        }
        double d = 0.0d;
        while (i < str.length()) {
            int i2 = i + 1;
            d += str.substring(i, i2).matches("[一-龥]") ? 1.0d : 0.5d;
            i = i2;
        }
        return Math.ceil(d);
    }

    public static boolean getOptionsBoolean(Map<String, Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089302515")) {
            return ((Boolean) ipChange.ipc$dispatch("-2089302515", new Object[]{map, str})).booleanValue();
        }
        String optionsString = getOptionsString(map, str);
        return optionsString != null && Boolean.parseBoolean(optionsString);
    }

    public static int getOptionsInt(Map<String, Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1212791357")) {
            return ((Integer) ipChange.ipc$dispatch("-1212791357", new Object[]{map, str})).intValue();
        }
        String optionsString = getOptionsString(map, str);
        if (optionsString == null) {
            return 0;
        }
        return Integer.parseInt(optionsString);
    }

    public static String getOptionsString(Map<String, Object> map, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793120220")) {
            return (String) ipChange.ipc$dispatch("793120220", new Object[]{map, str});
        }
        Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static void hideKeyboard(View view) {
        IBinder windowToken;
        InputMethodManager inputMethodManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1584946697")) {
            ipChange.ipc$dispatch("-1584946697", new Object[]{view});
        } else if (view == null || (windowToken = view.getWindowToken()) == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
        } else {
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            ((ILog) Dsl.getService(ILog.class)).w("jiangzInput", "hideKeyboard");
        }
    }

    public static void saveKeyboardHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1912628522")) {
            ipChange.ipc$dispatch("1912628522", new Object[]{Integer.valueOf(i)});
        } else if (i != 0) {
            ((ILog) Dsl.getService(ILog.class)).w("jiangzkb", "saveKeyboardHeight: " + i);
            sharedPreferences.edit().putInt(KEY_SOFT_KEYBOARD_HEIGHT, i).apply();
        }
    }

    public static void toggleSoftInput(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2079316280")) {
            ipChange.ipc$dispatch("2079316280", new Object[]{view});
        } else if (view == null) {
        } else {
            view.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view, 2);
                inputMethodManager.toggleSoftInput(2, 1);
                ((ILog) Dsl.getService(ILog.class)).w("jiangzInput", "toggleSoftInput");
            }
        }
    }

    public static void updateSoftInputMethod(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1451961597")) {
            ipChange.ipc$dispatch("-1451961597", new Object[]{activity, Integer.valueOf(i)});
        } else if (activity.isFinishing()) {
        } else {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.softInputMode != i) {
                attributes.softInputMode = i;
                activity.getWindow().setAttributes(attributes);
            }
        }
    }
}
