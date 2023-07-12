package com.youku.live.dago.widgetlib.doodle;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.doodle.SplashScheduler;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class RobotPainter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_DRAW_INTERVAL = 100;
    private static final int MSG_DRAW = 1;
    private Handler mHandler;
    private OnPaintListener mOnPaintListener;
    private SketchBoard mSketchBoard;
    private long mDrawInterval = DEFAULT_DRAW_INTERVAL;
    private ScaleType mScaleType = ScaleType.FIX_XY;
    private int mCanvasWidth = -1;
    private int mCanvasHeight = -1;
    private float mCanvasRatio = -1.0f;
    private float mBoardRatio = -1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.live.dago.widgetlib.doodle.RobotPainter$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType;

        static {
            int[] iArr = new int[ScaleType.values().length];
            $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType = iArr;
            try {
                iArr[ScaleType.FIX_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType[ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType[ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class DrawHandler extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;
        private WeakReference<RobotPainter> mRobotPainterRef;

        public DrawHandler(Looper looper, RobotPainter robotPainter) {
            super(looper);
            this.mRobotPainterRef = new WeakReference<>(robotPainter);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1928990065")) {
                ipChange.ipc$dispatch("1928990065", new Object[]{this, message});
                return;
            }
            RobotPainter robotPainter = this.mRobotPainterRef.get();
            if (robotPainter == null || message.what != 1) {
                return;
            }
            SplashScheduler.SplashItem splashItem = (SplashScheduler.SplashItem) message.obj;
            robotPainter.updateSplashItem(splashItem);
            SketchBoard sketchBoard = robotPainter.mSketchBoard;
            SplashScheduler.IconItem iconItem = splashItem.iconItem;
            sketchBoard.draw(iconItem.icon, iconItem.iconIdentity, (int) splashItem.x, (int) splashItem.y);
            if (robotPainter.mOnPaintListener != null) {
                if (message.arg1 == 0) {
                    robotPainter.mOnPaintListener.onPaintingStart();
                }
                if (message.arg1 == message.arg2 - 1) {
                    robotPainter.mOnPaintListener.onPaintingEnd();
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnPaintListener {
        void onPaintingEnd();

        void onPaintingStart();
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum ScaleType {
        NONE("NULL"),
        FIX_XY("fix_xy"),
        CENTER_CROP("center_crop"),
        CENTER_INSIDE("center_inside");
        
        String typeName;

        ScaleType(String str) {
            this.typeName = str;
        }

        public static ScaleType toScaleType(String str) {
            ScaleType[] values;
            for (ScaleType scaleType : values()) {
                if (scaleType.typeName.equals(str)) {
                    return scaleType;
                }
            }
            return NONE;
        }
    }

    public RobotPainter(SketchBoard sketchBoard) {
        this.mSketchBoard = sketchBoard;
        if (sketchBoard != null) {
            this.mHandler = new DrawHandler(Looper.getMainLooper(), this);
            return;
        }
        throw new IllegalArgumentException("SplashBoard must not be null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSplashItem(SplashScheduler.SplashItem splashItem) {
        float f;
        int i;
        float f2;
        int i2;
        int i3;
        int i4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "747218210")) {
            ipChange.ipc$dispatch("747218210", new Object[]{this, splashItem});
            return;
        }
        int boardWidth = this.mSketchBoard.getBoardWidth();
        int boardHeight = this.mSketchBoard.getBoardHeight();
        if (this.mBoardRatio <= 0.0f && boardWidth != 0 && boardHeight != 0) {
            this.mBoardRatio = boardWidth / boardHeight;
        }
        if (this.mCanvasRatio <= 0.0f && (i3 = this.mCanvasWidth) != 0 && (i4 = this.mCanvasHeight) != 0) {
            this.mCanvasRatio = i3 / i4;
        }
        int i5 = AnonymousClass1.$SwitchMap$com$youku$live$dago$widgetlib$doodle$RobotPainter$ScaleType[this.mScaleType.ordinal()];
        if (i5 == 1) {
            splashItem.x *= boardWidth / this.mCanvasWidth;
            splashItem.y *= boardHeight / this.mCanvasHeight;
        } else if (i5 == 2) {
            if (this.mBoardRatio > this.mCanvasRatio) {
                f = boardWidth;
                i = this.mCanvasWidth;
            } else {
                f = boardHeight;
                i = this.mCanvasHeight;
            }
            float f3 = f / i;
            splashItem.x *= f3;
            splashItem.y *= f3;
        } else if (i5 != 3) {
        } else {
            if (this.mBoardRatio < this.mCanvasRatio) {
                f2 = boardWidth;
                i2 = this.mCanvasWidth;
            } else {
                f2 = boardHeight;
                i2 = this.mCanvasHeight;
            }
            float f4 = f2 / i2;
            splashItem.x *= f4;
            splashItem.y *= f4;
        }
    }

    public void paint(List<SplashScheduler.SplashItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "628851442")) {
            ipChange.ipc$dispatch("628851442", new Object[]{this, list});
        } else if (list != null && list.size() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Message obtain = Message.obtain(this.mHandler, 1, list.get(i));
                obtain.arg1 = i;
                obtain.arg2 = size;
                this.mHandler.sendMessageAtTime(obtain, (i * this.mDrawInterval) + uptimeMillis);
            }
        }
    }

    public void setDrawInterval(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1678609360")) {
            ipChange.ipc$dispatch("-1678609360", new Object[]{this, Long.valueOf(j)});
        } else {
            this.mDrawInterval = j;
        }
    }

    public void setOnPaintListener(OnPaintListener onPaintListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267033770")) {
            ipChange.ipc$dispatch("1267033770", new Object[]{this, onPaintListener});
        } else {
            this.mOnPaintListener = onPaintListener;
        }
    }

    public void setScaleType(ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471291190")) {
            ipChange.ipc$dispatch("-471291190", new Object[]{this, scaleType});
        } else {
            this.mScaleType = scaleType;
        }
    }

    public void updateCanvasSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391669943")) {
            ipChange.ipc$dispatch("-391669943", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mCanvasWidth = i;
        this.mCanvasHeight = i2;
    }
}
