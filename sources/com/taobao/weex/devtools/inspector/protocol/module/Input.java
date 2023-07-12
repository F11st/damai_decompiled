package com.taobao.weex.devtools.inspector.protocol.module;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.taobao.weex.devtools.inspector.elements.android.ActivityTracker;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcResult;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsMethod;
import com.taobao.weex.devtools.inspector.screencast.ScreencastDispatcher;
import com.taobao.weex.devtools.json.ObjectMapper;
import com.taobao.weex.devtools.json.annotation.JsonProperty;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Input implements ChromeDevtoolsDomain {
    private static final String KEY_UP = "keyUp";
    private static final String MOUSE_BUTTON_LEFT = "left";
    private static final String MOUSE_BUTTON_RIGHT = "right";
    private static final String MOUSE_MOVED = "mouseMoved";
    private static final String MOUSE_PRESSED = "mousePressed";
    private static final String MOUSE_RELEASED = "mouseReleased";
    private static final String MOUSE_WHEEL = "mouseWheel";
    private long downTime;
    private Point lastPoint = new Point();
    private ObjectMapper mObjectMapper = new ObjectMapper();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class DispatchKeyEventRequest {
        @JsonProperty
        public Boolean autoRepeat;
        @JsonProperty
        public String code;
        @JsonProperty
        public Boolean isKeypad;
        @JsonProperty
        public Boolean isSystemKey;
        @JsonProperty
        public String key;
        @JsonProperty
        public String keyIdentifier;
        @JsonProperty
        public Integer modifiers;
        @JsonProperty
        public Integer nativeVirtualKeyCode;
        @JsonProperty
        public String text;
        @JsonProperty
        public Double timestamp;
        @JsonProperty(required = true)
        public String type;
        @JsonProperty
        public String unmodifiedText;
        @JsonProperty
        public Integer windowsVirtualKeyCode;
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class EmulateTouchFromMouseEventRequest {
        @JsonProperty(required = true)
        public String button;
        @JsonProperty
        public Integer clickCount;
        @JsonProperty
        public Double deltaX;
        @JsonProperty
        public Double deltaY;
        @JsonProperty
        public Integer modifiers;
        @JsonProperty(required = true)
        public double timestamp;
        @JsonProperty(required = true)
        public String type;
        @JsonProperty(required = true)
        public int x;
        @JsonProperty(required = true)
        public int y;
    }

    private void down(int i, int i2) {
        final Activity tryGetTopActivity = ActivityTracker.get().tryGetTopActivity();
        if (tryGetTopActivity != null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.downTime = currentTimeMillis;
            final MotionEvent obtain = MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, i / ScreencastDispatcher.getsBitmapScale(), (i2 / ScreencastDispatcher.getsBitmapScale()) + getStatusBarHeight(tryGetTopActivity), 0);
            tryGetTopActivity.runOnUiThread(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.Input.2
                @Override // java.lang.Runnable
                public void run() {
                    tryGetTopActivity.dispatchTouchEvent(obtain);
                }
            });
            obtain.recycle();
        }
    }

    private static int getStatusBarHeight(Context context) {
        if (context instanceof Activity) {
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        }
        return 0;
    }

    private void move(int i, int i2) {
        final Activity tryGetTopActivity = ActivityTracker.get().tryGetTopActivity();
        if (tryGetTopActivity != null) {
            final MotionEvent obtain = MotionEvent.obtain(this.downTime, System.currentTimeMillis(), 2, i / ScreencastDispatcher.getsBitmapScale(), (i2 / ScreencastDispatcher.getsBitmapScale()) + getStatusBarHeight(tryGetTopActivity), 0);
            tryGetTopActivity.runOnUiThread(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.Input.1
                @Override // java.lang.Runnable
                public void run() {
                    tryGetTopActivity.dispatchTouchEvent(obtain);
                }
            });
            obtain.recycle();
        }
    }

    private synchronized void scroll(Point point, Point point2) {
        down(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        move(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        up(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        Point point3 = this.lastPoint;
        point3.x = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
        point3.y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
    }

    private void up(int i, int i2) {
        final Activity tryGetTopActivity = ActivityTracker.get().tryGetTopActivity();
        if (tryGetTopActivity != null) {
            final MotionEvent obtain = MotionEvent.obtain(this.downTime, System.currentTimeMillis(), 1, i / ScreencastDispatcher.getsBitmapScale(), (i2 / ScreencastDispatcher.getsBitmapScale()) + getStatusBarHeight(tryGetTopActivity), 0);
            tryGetTopActivity.runOnUiThread(new Runnable() { // from class: com.taobao.weex.devtools.inspector.protocol.module.Input.3
                @Override // java.lang.Runnable
                public void run() {
                    tryGetTopActivity.dispatchTouchEvent(obtain);
                }
            });
            obtain.recycle();
        }
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult dispatchKeyEvent(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        DispatchKeyEventRequest dispatchKeyEventRequest = (DispatchKeyEventRequest) this.mObjectMapper.convertValue(jSONObject, DispatchKeyEventRequest.class);
        if (KEY_UP.equals(dispatchKeyEventRequest.type)) {
            Instrumentation instrumentation = new Instrumentation();
            if (dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() >= 48 && dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() <= 57) {
                instrumentation.sendKeyDownUpSync((dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() - 48) + 7);
                return null;
            } else if (dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() >= 65 && dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() <= 90) {
                instrumentation.sendKeyDownUpSync((dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() - 65) + 29);
                return null;
            } else if (dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() == 8) {
                instrumentation.sendKeyDownUpSync(67);
                return null;
            } else if (dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() == 13) {
                instrumentation.sendKeyDownUpSync(66);
                return null;
            } else if (dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() == 16) {
                instrumentation.sendKeyDownUpSync(59);
                return null;
            } else if (dispatchKeyEventRequest.nativeVirtualKeyCode.intValue() == 20) {
                instrumentation.sendKeyDownUpSync(115);
                return null;
            } else {
                instrumentation.sendCharacterSync((char) dispatchKeyEventRequest.nativeVirtualKeyCode.intValue());
            }
        }
        return null;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult emulateTouchFromMouseEvent(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        EmulateTouchFromMouseEventRequest emulateTouchFromMouseEventRequest = (EmulateTouchFromMouseEventRequest) this.mObjectMapper.convertValue(jSONObject, EmulateTouchFromMouseEventRequest.class);
        try {
            if (MOUSE_PRESSED.equals(emulateTouchFromMouseEventRequest.type) && "left".equals(emulateTouchFromMouseEventRequest.button)) {
                Point point = this.lastPoint;
                int i = emulateTouchFromMouseEventRequest.x;
                point.x = i;
                int i2 = emulateTouchFromMouseEventRequest.y;
                point.y = i2;
                down(i, i2);
            } else if (MOUSE_RELEASED.equals(emulateTouchFromMouseEventRequest.type)) {
                if ("left".equals(emulateTouchFromMouseEventRequest.button)) {
                    Point point2 = this.lastPoint;
                    int i3 = emulateTouchFromMouseEventRequest.x;
                    point2.x = i3;
                    int i4 = emulateTouchFromMouseEventRequest.y;
                    point2.y = i4;
                    up(i3, i4);
                } else if ("right".equals(emulateTouchFromMouseEventRequest.button) && ActivityTracker.get().getActivitiesView().size() > 1) {
                    new Instrumentation().sendKeyDownUpSync(4);
                }
            } else if (MOUSE_MOVED.equals(emulateTouchFromMouseEventRequest.type)) {
                move(emulateTouchFromMouseEventRequest.x, emulateTouchFromMouseEventRequest.y);
            } else {
                MOUSE_WHEEL.equals(emulateTouchFromMouseEventRequest.type);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
