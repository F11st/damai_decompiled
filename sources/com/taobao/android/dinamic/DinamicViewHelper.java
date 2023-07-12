package com.taobao.android.dinamic;

import android.text.TextUtils;
import com.taobao.android.dinamic.constructor.DCheckBoxConstructor;
import com.taobao.android.dinamic.constructor.DCountDownTimerConstructor;
import com.taobao.android.dinamic.constructor.DFrameLayoutConstructor;
import com.taobao.android.dinamic.constructor.DHorizontalScrollLayoutConstructor;
import com.taobao.android.dinamic.constructor.DImageViewConstructor;
import com.taobao.android.dinamic.constructor.DLinearLayoutConstructor;
import com.taobao.android.dinamic.constructor.DLoopLinearLayoutConstructor;
import com.taobao.android.dinamic.constructor.DSwitchConstructor;
import com.taobao.android.dinamic.constructor.DTextInputConstructor;
import com.taobao.android.dinamic.constructor.DTextViewConstructor;
import com.taobao.android.dinamic.dinamic.DinamicEventHandler;
import com.taobao.android.dinamic.dinamic.DinamicViewAdvancedConstructor;
import com.taobao.android.dinamic.exception.DinamicException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import tb.m80;
import tb.w0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DinamicViewHelper implements Serializable {
    private static Map<String, DinamicViewAdvancedConstructor> viewConstructors = new HashMap();
    private static Map<String, w0> eventHandlers = new HashMap();

    static {
        viewConstructors.put(m80.D_VIEW, new DinamicViewAdvancedConstructor());
        viewConstructors.put(m80.D_TEXT_VIEW, new DTextViewConstructor());
        viewConstructors.put(m80.D_IMAGE_VIEW, new DImageViewConstructor());
        viewConstructors.put(m80.D_FRAME_LAYOUT, new DFrameLayoutConstructor());
        viewConstructors.put(m80.D_LINEAR_LAYOUT, new DLinearLayoutConstructor());
        viewConstructors.put(m80.D_HORIZONTAL_SCROLL_LAYOUT, new DHorizontalScrollLayoutConstructor());
        viewConstructors.put(m80.D_COUNT_DOWN_TIMER_VIEW, new DCountDownTimerConstructor());
        viewConstructors.put(m80.D_LOOP_LINEAR_LAYOUT, new DLoopLinearLayoutConstructor());
        viewConstructors.put(m80.D_TEXT_INPUT, new DTextInputConstructor());
        viewConstructors.put("DCheckBox", new DCheckBoxConstructor());
        viewConstructors.put("DSwitch", new DSwitchConstructor());
    }

    DinamicViewHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DinamicEventHandler getEventHandler(String str) {
        return eventHandlers.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DinamicViewAdvancedConstructor getViewConstructor(String str) {
        return viewConstructors.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerEventHandler(String str, w0 w0Var) throws DinamicException {
        if (!TextUtils.isEmpty(str) && w0Var != null) {
            if (eventHandlers.get(str) == null) {
                eventHandlers.put(str, w0Var);
                return;
            }
            throw new DinamicException("registerEventHandler failed, eventHander already register by current identify:" + str);
        }
        throw new DinamicException("registerEventHandler failed, eventIdentify or handler is null");
    }

    static void registerReplaceEventHandler(String str, w0 w0Var) throws DinamicException {
        if (!TextUtils.isEmpty(str) && w0Var != null) {
            eventHandlers.put(str, w0Var);
            return;
        }
        throw new DinamicException("registerEventHandler failed, eventIdentify or handler is null");
    }

    static void registerReplaceViewConstructor(String str, DinamicViewAdvancedConstructor dinamicViewAdvancedConstructor) throws DinamicException {
        if (!TextUtils.isEmpty(str) && dinamicViewAdvancedConstructor != null) {
            viewConstructors.put(str, dinamicViewAdvancedConstructor);
            return;
        }
        throw new DinamicException("viewIdentify or assistant is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void registerViewConstructor(String str, DinamicViewAdvancedConstructor dinamicViewAdvancedConstructor) throws DinamicException {
        if (!TextUtils.isEmpty(str) && dinamicViewAdvancedConstructor != null) {
            if (viewConstructors.get(str) == null) {
                viewConstructors.put(str, dinamicViewAdvancedConstructor);
                return;
            }
            throw new DinamicException("assistant already registed by current identify:" + str);
        }
        throw new DinamicException("viewIdentify or assistant is null");
    }
}
