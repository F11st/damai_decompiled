package com.taobao.weex.ui.view.gesture;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface WXGestureType {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class GestureInfo {
        public static final String DIRECTION = "direction";
        public static final String HISTORICAL_XY = "changedTouches";
        public static final String PAGE_X = "pageX";
        public static final String PAGE_Y = "pageY";
        public static final String POINTER_ID = "identifier";
        public static final String SCREEN_X = "screenX";
        public static final String SCREEN_Y = "screenY";
        public static final String STATE = "state";
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum HighLevelGesture implements WXGestureType {
        SWIPE("swipe"),
        LONG_PRESS("longpress"),
        PAN_START("panstart"),
        PAN_MOVE("panmove"),
        PAN_END("panend"),
        HORIZONTALPAN("horizontalpan"),
        VERTICALPAN("verticalpan");
        
        private String description;

        HighLevelGesture(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum LowLevelGesture implements WXGestureType {
        ACTION_DOWN("touchstart"),
        ACTION_MOVE("touchmove"),
        ACTION_UP("touchend"),
        ACTION_CANCEL("touchcancel");
        
        private String description;

        LowLevelGesture(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }
}
