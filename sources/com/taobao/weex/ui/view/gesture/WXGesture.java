package com.taobao.weex.ui.view.gesture;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.bridge.EventResult;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.view.gesture.WXGestureType;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXGesture extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    private static final int CUR_EVENT = -1;
    public static final String DOWN = "down";
    public static final String END = "end";
    public static final String LEFT = "left";
    public static final String MOVE = "move";
    public static final String RIGHT = "right";
    public static final String START = "start";
    private static final String TAG = "Gesture";
    public static final String UNKNOWN = "unknown";
    public static final String UP = "up";
    private WXComponent component;
    private GestureDetector mGestureDetector;
    private int mParentOrientation;
    private int shouldBubbleInterval;
    private boolean shouldBubbleResult;
    private long swipeDownTime = -1;
    private long panDownTime = -1;
    private WXGestureType mPendingPan = null;
    private boolean mIsPreventMoveEvent = false;
    private boolean mIsTouchEventConsumed = false;
    private boolean requestDisallowInterceptTouchEvent = false;
    private int shouldBubbleCallRemainTimes = 0;
    private final List<View.OnTouchListener> mTouchListeners = new LinkedList();
    private Rect globalRect = new Rect();
    private Point globalOffset = new Point();
    private Point globalEventOffset = new Point();
    private PointF locEventOffset = new PointF();
    private PointF locLeftTop = new PointF();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class GestureHandler extends Handler {
        public GestureHandler() {
            super(Looper.getMainLooper());
        }
    }

    public WXGesture(WXComponent wXComponent, Context context) {
        this.mParentOrientation = -1;
        this.shouldBubbleResult = true;
        this.shouldBubbleInterval = 0;
        this.component = wXComponent;
        this.mGestureDetector = new GestureDetector(context, this, new GestureHandler());
        Scrollable parentScroller = wXComponent.getParentScroller();
        if (parentScroller != null) {
            this.mParentOrientation = parentScroller.getOrientation();
        }
        this.shouldBubbleResult = WXUtils.getBoolean(wXComponent.getAttrs().get(Constants.Name.SHOULD_STOP_PROPAGATION_INIT_RESULT), Boolean.TRUE).booleanValue();
        this.shouldBubbleInterval = WXUtils.getNumberInt(wXComponent.getAttrs().get(Constants.Name.SHOULD_STOP_PROPAGATION_INTERVAL), 0);
    }

    private boolean containsSimplePan() {
        return this.component.containsGesture(WXGestureType.HighLevelGesture.PAN_START) || this.component.containsGesture(WXGestureType.HighLevelGesture.PAN_MOVE) || this.component.containsGesture(WXGestureType.HighLevelGesture.PAN_END);
    }

    private Map<String, Object> createFireEventParam(MotionEvent motionEvent, int i, String str) {
        JSONArray jSONArray = new JSONArray(motionEvent.getPointerCount());
        if (motionEvent.getActionMasked() == 2) {
            for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
                jSONArray.add(createJSONObject(motionEvent, i, i2));
            }
        } else if (isPointerNumChanged(motionEvent)) {
            jSONArray.add(createJSONObject(motionEvent, -1, motionEvent.getActionIndex()));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WXGestureType.GestureInfo.HISTORICAL_XY, jSONArray);
        if (str != null) {
            hashMap.put("state", str);
        }
        return hashMap;
    }

    private JSONObject createJSONObject(MotionEvent motionEvent, int i, int i2) {
        PointF eventLocInScreenCoordinate;
        PointF pointF;
        if (i == -1) {
            pointF = getEventLocInPageCoordinate(motionEvent, i2);
            eventLocInScreenCoordinate = getEventLocInScreenCoordinate(motionEvent, i2);
        } else {
            PointF eventLocInPageCoordinate = getEventLocInPageCoordinate(motionEvent, i2, i);
            eventLocInScreenCoordinate = getEventLocInScreenCoordinate(motionEvent, i2, i);
            pointF = eventLocInPageCoordinate;
        }
        JSONObject createJSONObject = createJSONObject(eventLocInScreenCoordinate, pointF, motionEvent.getPointerId(i2));
        float pressure = motionEvent.getPressure();
        if (pressure > 0.0f && pressure < 1.0f) {
            createJSONObject.put("force", (Object) Float.valueOf(motionEvent.getPressure()));
        }
        return createJSONObject;
    }

    private List<Map<String, Object>> createMultipleFireEventParam(MotionEvent motionEvent, String str) {
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize() + 1);
        arrayList.add(createFireEventParam(motionEvent, -1, str));
        return arrayList;
    }

    private void finishDisallowInterceptTouchEvent(View view) {
        if (view.getParent() != null) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    private PointF getEventLocInPageCoordinate(MotionEvent motionEvent, int i) {
        return getEventLocInPageCoordinate(motionEvent, i, -1);
    }

    private PointF getEventLocInScreenCoordinate(MotionEvent motionEvent, int i) {
        return getEventLocInScreenCoordinate(motionEvent, i, -1);
    }

    private List<Map<String, Object>> getHistoricalEvents(MotionEvent motionEvent) {
        ArrayList arrayList = new ArrayList(motionEvent.getHistorySize());
        if (motionEvent.getActionMasked() == 2) {
            for (int i = 0; i < motionEvent.getHistorySize(); i++) {
                arrayList.add(createFireEventParam(motionEvent, i, null));
            }
        }
        return arrayList;
    }

    private String getPanEventAction(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        return action != 0 ? action != 1 ? action != 2 ? action != 3 ? "unknown" : "end" : MOVE : "end" : "start";
    }

    private boolean handleMotionEvent(WXGestureType wXGestureType, MotionEvent motionEvent) {
        if (this.component.containsGesture(wXGestureType)) {
            for (Map<String, Object> map : createMultipleFireEventParam(motionEvent, null)) {
                this.component.fireEvent(wXGestureType.toString(), map);
            }
            return true;
        }
        return false;
    }

    private boolean handlePanMotionEvent(MotionEvent motionEvent) {
        WXGestureType wXGestureType = this.mPendingPan;
        if (wXGestureType == null) {
            return false;
        }
        String panEventAction = (wXGestureType == WXGestureType.HighLevelGesture.HORIZONTALPAN || wXGestureType == WXGestureType.HighLevelGesture.VERTICALPAN) ? getPanEventAction(motionEvent) : null;
        if (this.component.containsGesture(this.mPendingPan)) {
            if (this.mIsPreventMoveEvent && MOVE.equals(panEventAction)) {
                return true;
            }
            for (Map<String, Object> map : createMultipleFireEventParam(motionEvent, panEventAction)) {
                this.component.fireEvent(this.mPendingPan.toString(), map);
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.mPendingPan = null;
            }
            return true;
        }
        return false;
    }

    private boolean hasSameOrientationWithParent() {
        if (this.mParentOrientation == 0 && this.component.containsGesture(WXGestureType.HighLevelGesture.HORIZONTALPAN)) {
            return true;
        }
        return this.mParentOrientation == 1 && this.component.containsGesture(WXGestureType.HighLevelGesture.VERTICALPAN);
    }

    public static boolean hasStopPropagation(WXComponent wXComponent) {
        WXEvent events = wXComponent.getEvents();
        if (events == null) {
            return false;
        }
        int size = events.size();
        for (int i = 0; i < size && i < events.size(); i++) {
            if (isStopPropagation(events.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isParentScrollable() {
        Scrollable parentScroller;
        WXComponent wXComponent = this.component;
        return wXComponent == null || (parentScroller = wXComponent.getParentScroller()) == null || parentScroller.isScrollable();
    }

    private boolean isPointerNumChanged(MotionEvent motionEvent) {
        return motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5 || motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6 || motionEvent.getActionMasked() == 3;
    }

    public static boolean isStopPropagation(String str) {
        return Constants.Event.STOP_PROPAGATION.equals(str) || Constants.Event.STOP_PROPAGATION_RAX.equals(str);
    }

    private boolean shouldBubbleTouchEvent(MotionEvent motionEvent) {
        int i;
        if (hasStopPropagation(this.component)) {
            if (this.shouldBubbleInterval > 0 && (i = this.shouldBubbleCallRemainTimes) > 0) {
                this.shouldBubbleCallRemainTimes = i - 1;
                return this.shouldBubbleResult;
            }
            Map<String, Object> createFireEventParam = createFireEventParam(motionEvent, -1, null);
            createFireEventParam.put("type", "touch");
            if (motionEvent.getAction() == 0) {
                createFireEventParam.put("action", "start");
            } else if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
                createFireEventParam.put("action", MOVE);
            } else {
                createFireEventParam.put("action", "end");
            }
            WXEvent events = this.component.getEvents();
            String str = Constants.Event.STOP_PROPAGATION;
            if (!events.contains(Constants.Event.STOP_PROPAGATION)) {
                str = Constants.Event.STOP_PROPAGATION_RAX;
            }
            EventResult fireEventWait = this.component.fireEventWait(str, createFireEventParam);
            if (fireEventWait.isSuccess() && fireEventWait.getResult() != null) {
                this.shouldBubbleResult = !WXUtils.getBoolean(fireEventWait.getResult(), Boolean.valueOf(!this.shouldBubbleResult)).booleanValue();
            }
            this.shouldBubbleCallRemainTimes = this.shouldBubbleInterval;
            return this.shouldBubbleResult;
        }
        return true;
    }

    public void addOnTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.mTouchListeners.add(onTouchListener);
        }
    }

    public boolean isRequestDisallowInterceptTouchEvent() {
        return this.requestDisallowInterceptTouchEvent;
    }

    public boolean isTouchEventConsumedByAdvancedGesture() {
        return this.mIsTouchEventConsumed;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        WXComponent wXComponent = this.component;
        WXGestureType.HighLevelGesture highLevelGesture = WXGestureType.HighLevelGesture.LONG_PRESS;
        if (wXComponent.containsGesture(highLevelGesture)) {
            List<Map<String, Object>> createMultipleFireEventParam = createMultipleFireEventParam(motionEvent, null);
            this.component.getInstance().fireEvent(this.component.getRef(), highLevelGesture.toString(), createMultipleFireEventParam.get(createMultipleFireEventParam.size() - 1));
            this.mIsTouchEventConsumed = true;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        WXGestureType.HighLevelGesture highLevelGesture;
        boolean handlePanMotionEvent;
        boolean z = false;
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (Math.abs(motionEvent2.getX() - motionEvent.getX()) > Math.abs(motionEvent2.getY() - motionEvent.getY())) {
            highLevelGesture = WXGestureType.HighLevelGesture.HORIZONTALPAN;
        } else {
            highLevelGesture = WXGestureType.HighLevelGesture.VERTICALPAN;
        }
        WXGestureType wXGestureType = this.mPendingPan;
        if (wXGestureType != WXGestureType.HighLevelGesture.HORIZONTALPAN && wXGestureType != WXGestureType.HighLevelGesture.VERTICALPAN) {
            if (this.component.containsGesture(highLevelGesture)) {
                ViewParent parent = this.component.getRealView().getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                WXGestureType wXGestureType2 = this.mPendingPan;
                if (wXGestureType2 != null) {
                    handleMotionEvent(wXGestureType2, motionEvent2);
                }
                this.mPendingPan = highLevelGesture;
                this.component.fireEvent(highLevelGesture.toString(), createFireEventParam(motionEvent2, -1, "start"));
            } else if (containsSimplePan()) {
                if (this.panDownTime != motionEvent.getEventTime()) {
                    this.panDownTime = motionEvent.getEventTime();
                    this.mPendingPan = WXGestureType.HighLevelGesture.PAN_END;
                    this.component.fireEvent(WXGestureType.HighLevelGesture.PAN_START.toString(), createFireEventParam(motionEvent, -1, null));
                } else {
                    this.component.fireEvent(WXGestureType.HighLevelGesture.PAN_MOVE.toString(), createFireEventParam(motionEvent2, -1, null));
                }
            } else {
                WXComponent wXComponent = this.component;
                WXGestureType.HighLevelGesture highLevelGesture2 = WXGestureType.HighLevelGesture.SWIPE;
                if (!wXComponent.containsGesture(highLevelGesture2) || this.swipeDownTime == motionEvent.getEventTime()) {
                    handlePanMotionEvent = false;
                } else {
                    this.swipeDownTime = motionEvent.getEventTime();
                    List<Map<String, Object>> createMultipleFireEventParam = createMultipleFireEventParam(motionEvent2, null);
                    Map<String, Object> map = createMultipleFireEventParam.get(createMultipleFireEventParam.size() - 1);
                    if (Math.abs(f) > Math.abs(f2)) {
                        map.put("direction", f > 0.0f ? "left" : "right");
                    } else {
                        map.put("direction", f2 > 0.0f ? "up" : "down");
                    }
                    this.component.getInstance().fireEvent(this.component.getRef(), highLevelGesture2.toString(), map);
                }
            }
            handlePanMotionEvent = true;
        } else {
            handlePanMotionEvent = handlePanMotionEvent(motionEvent2);
        }
        this.mIsTouchEventConsumed = (this.mIsTouchEventConsumed || handlePanMotionEvent) ? true : true;
        return handlePanMotionEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0098 A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:6:0x0008, B:8:0x0012, B:10:0x0018, B:11:0x001e, B:13:0x0024, B:14:0x0030, B:37:0x0090, B:39:0x0098, B:41:0x00a0, B:43:0x00aa, B:45:0x00b2, B:46:0x00bb, B:48:0x00bf, B:50:0x00d7, B:25:0x0046, B:27:0x005b, B:26:0x0055, B:28:0x005d, B:29:0x006c, B:31:0x0074, B:33:0x007a, B:35:0x0086, B:36:0x0089), top: B:55:0x0008 }] */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            boolean r0 = r6.requestDisallowInterceptTouchEvent
            r1 = 0
            if (r0 == 0) goto L8
            r6.requestDisallowInterceptTouchEvent = r1
            return r1
        L8:
            android.view.GestureDetector r0 = r6.mGestureDetector     // Catch: java.lang.Exception -> Ldb
            boolean r0 = r0.onTouchEvent(r8)     // Catch: java.lang.Exception -> Ldb
            java.util.List<android.view.View$OnTouchListener> r2 = r6.mTouchListeners     // Catch: java.lang.Exception -> Ldb
            if (r2 == 0) goto L30
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Exception -> Ldb
            if (r2 != 0) goto L30
            java.util.List<android.view.View$OnTouchListener> r2 = r6.mTouchListeners     // Catch: java.lang.Exception -> Ldb
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> Ldb
        L1e:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> Ldb
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> Ldb
            android.view.View$OnTouchListener r3 = (android.view.View.OnTouchListener) r3     // Catch: java.lang.Exception -> Ldb
            boolean r3 = r3.onTouch(r7, r8)     // Catch: java.lang.Exception -> Ldb
            r0 = r0 | r3
            goto L1e
        L30:
            int r2 = r8.getActionMasked()     // Catch: java.lang.Exception -> Ldb
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L6c
            if (r2 == r4) goto L5d
            r5 = 2
            if (r2 == r5) goto L55
            if (r2 == r3) goto L46
            r5 = 5
            if (r2 == r5) goto L6c
            r5 = 6
            if (r2 == r5) goto L5d
            goto L90
        L46:
            r6.finishDisallowInterceptTouchEvent(r7)     // Catch: java.lang.Exception -> Ldb
            com.taobao.weex.ui.view.gesture.WXGestureType$LowLevelGesture r2 = com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_CANCEL     // Catch: java.lang.Exception -> Ldb
            boolean r2 = r6.handleMotionEvent(r2, r8)     // Catch: java.lang.Exception -> Ldb
            r0 = r0 | r2
            boolean r2 = r6.handlePanMotionEvent(r8)     // Catch: java.lang.Exception -> Ldb
            goto L5b
        L55:
            com.taobao.weex.ui.view.gesture.WXGestureType$LowLevelGesture r2 = com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_MOVE     // Catch: java.lang.Exception -> Ldb
            boolean r2 = r6.handleMotionEvent(r2, r8)     // Catch: java.lang.Exception -> Ldb
        L5b:
            r0 = r0 | r2
            goto L90
        L5d:
            r6.finishDisallowInterceptTouchEvent(r7)     // Catch: java.lang.Exception -> Ldb
            com.taobao.weex.ui.view.gesture.WXGestureType$LowLevelGesture r2 = com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_UP     // Catch: java.lang.Exception -> Ldb
            boolean r2 = r6.handleMotionEvent(r2, r8)     // Catch: java.lang.Exception -> Ldb
            r0 = r0 | r2
            boolean r2 = r6.handlePanMotionEvent(r8)     // Catch: java.lang.Exception -> Ldb
            goto L5b
        L6c:
            r6.mIsTouchEventConsumed = r1     // Catch: java.lang.Exception -> Ldb
            boolean r2 = r6.hasSameOrientationWithParent()     // Catch: java.lang.Exception -> Ldb
            if (r2 == 0) goto L89
            boolean r2 = r6.isParentScrollable()     // Catch: java.lang.Exception -> Ldb
            if (r2 != 0) goto L89
            com.taobao.weex.ui.component.WXComponent r2 = r6.component     // Catch: java.lang.Exception -> Ldb
            android.view.View r2 = r2.getRealView()     // Catch: java.lang.Exception -> Ldb
            android.view.ViewParent r2 = r2.getParent()     // Catch: java.lang.Exception -> Ldb
            if (r2 == 0) goto L89
            r2.requestDisallowInterceptTouchEvent(r4)     // Catch: java.lang.Exception -> Ldb
        L89:
            com.taobao.weex.ui.view.gesture.WXGestureType$LowLevelGesture r2 = com.taobao.weex.ui.view.gesture.WXGestureType.LowLevelGesture.ACTION_DOWN     // Catch: java.lang.Exception -> Ldb
            boolean r2 = r6.handleMotionEvent(r2, r8)     // Catch: java.lang.Exception -> Ldb
            goto L5b
        L90:
            com.taobao.weex.ui.component.WXComponent r2 = r6.component     // Catch: java.lang.Exception -> Ldb
            boolean r2 = hasStopPropagation(r2)     // Catch: java.lang.Exception -> Ldb
            if (r2 == 0) goto Lda
            android.view.ViewParent r7 = r7.getParent()     // Catch: java.lang.Exception -> Ldb
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7     // Catch: java.lang.Exception -> Ldb
            if (r7 == 0) goto La9
            boolean r2 = r6.shouldBubbleTouchEvent(r8)     // Catch: java.lang.Exception -> Ldb
            r2 = r2 ^ r4
            r7.requestDisallowInterceptTouchEvent(r2)     // Catch: java.lang.Exception -> Ldb
            goto Laa
        La9:
            r2 = 0
        Laa:
            com.taobao.weex.ui.component.WXComponent r7 = r6.component     // Catch: java.lang.Exception -> Ldb
            com.taobao.weex.ui.component.WXVContainer r7 = r7.getParent()     // Catch: java.lang.Exception -> Ldb
            if (r7 == 0) goto Lbb
            com.taobao.weex.ui.component.WXComponent r7 = r6.component     // Catch: java.lang.Exception -> Ldb
            com.taobao.weex.ui.component.WXVContainer r7 = r7.getParent()     // Catch: java.lang.Exception -> Ldb
            r7.requestDisallowInterceptTouchEvent(r2)     // Catch: java.lang.Exception -> Ldb
        Lbb:
            boolean r7 = r6.mIsTouchEventConsumed     // Catch: java.lang.Exception -> Ldb
            if (r7 == 0) goto Lda
            com.taobao.weex.ui.component.WXComponent r7 = r6.component     // Catch: java.lang.Exception -> Ldb
            com.taobao.weex.dom.WXAttr r7 = r7.getAttrs()     // Catch: java.lang.Exception -> Ldb
            java.lang.String r2 = "cancelTouchOnConsume"
            java.lang.Object r7 = r7.get(r2)     // Catch: java.lang.Exception -> Ldb
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> Ldb
            java.lang.Boolean r7 = com.taobao.weex.utils.WXUtils.getBoolean(r7, r2)     // Catch: java.lang.Exception -> Ldb
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Exception -> Ldb
            if (r7 == 0) goto Lda
            r8.setAction(r3)     // Catch: java.lang.Exception -> Ldb
        Lda:
            return r0
        Ldb:
            r7 = move-exception
            java.lang.String r8 = "Gesture RunTime Error "
            com.taobao.weex.utils.WXLogUtils.e(r8, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.view.gesture.WXGesture.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean removeTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            return this.mTouchListeners.remove(onTouchListener);
        }
        return false;
    }

    public void setPreventMoveEvent(boolean z) {
        this.mIsPreventMoveEvent = z;
    }

    public void setRequestDisallowInterceptTouchEvent(boolean z) {
        this.requestDisallowInterceptTouchEvent = z;
    }

    private PointF getEventLocInPageCoordinate(MotionEvent motionEvent, int i, int i2) {
        float historicalY;
        float f;
        if (i2 == -1) {
            f = motionEvent.getX(i);
            historicalY = motionEvent.getY(i);
        } else {
            float historicalX = motionEvent.getHistoricalX(i, i2);
            historicalY = motionEvent.getHistoricalY(i, i2);
            f = historicalX;
        }
        return getEventLocInPageCoordinate(f, historicalY);
    }

    private PointF getEventLocInScreenCoordinate(MotionEvent motionEvent, int i, int i2) {
        float historicalY;
        float f;
        if (i2 == -1) {
            f = motionEvent.getX(i);
            historicalY = motionEvent.getY(i);
        } else {
            float historicalX = motionEvent.getHistoricalX(i, i2);
            historicalY = motionEvent.getHistoricalY(i, i2);
            f = historicalX;
        }
        return getEventLocInScreenCoordinate(f, historicalY);
    }

    @NonNull
    private PointF getEventLocInPageCoordinate(float f, float f2) {
        this.locEventOffset.set(f, f2);
        this.locLeftTop.set(0.0f, 0.0f);
        this.component.computeVisiblePointInViewCoordinate(this.locLeftTop);
        PointF pointF = this.locEventOffset;
        PointF pointF2 = this.locLeftTop;
        pointF.offset(pointF2.x, pointF2.y);
        return new PointF(WXViewUtils.getWebPxByWidth(this.locEventOffset.x, this.component.getInstance().getInstanceViewPortWidth()), WXViewUtils.getWebPxByWidth(this.locEventOffset.y, this.component.getInstance().getInstanceViewPortWidth()));
    }

    @NonNull
    private PointF getEventLocInScreenCoordinate(float f, float f2) {
        this.globalRect.set(0, 0, 0, 0);
        this.globalOffset.set(0, 0);
        this.globalEventOffset.set((int) f, (int) f2);
        this.component.getRealView().getGlobalVisibleRect(this.globalRect, this.globalOffset);
        Point point = this.globalEventOffset;
        Point point2 = this.globalOffset;
        point.offset(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        return new PointF(WXViewUtils.getWebPxByWidth(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.globalEventOffset), this.component.getInstance().getInstanceViewPortWidth()), WXViewUtils.getWebPxByWidth(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.globalEventOffset), this.component.getInstance().getInstanceViewPortWidth()));
    }

    @NonNull
    private JSONObject createJSONObject(PointF pointF, PointF pointF2, float f) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WXGestureType.GestureInfo.PAGE_X, (Object) Float.valueOf(pointF2.x));
        jSONObject.put(WXGestureType.GestureInfo.PAGE_Y, (Object) Float.valueOf(pointF2.y));
        jSONObject.put(WXGestureType.GestureInfo.SCREEN_X, (Object) Float.valueOf(pointF.x));
        jSONObject.put(WXGestureType.GestureInfo.SCREEN_Y, (Object) Float.valueOf(pointF.y));
        jSONObject.put(WXGestureType.GestureInfo.POINTER_ID, (Object) Float.valueOf(f));
        return jSONObject;
    }
}
