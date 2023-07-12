package cn.damai.commonbusiness.qrcode.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import cn.damai.commonbusiness.R$drawable;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import tb.e80;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ScaleFinderView extends View implements View.OnTouchListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_SUPPORT_MANUAL = "key_support_manual";
    private static int MSG_CLICK = 1;
    public static final String TAG = "ScaleFinderView";
    private int LINE_COLOR;
    private int MOVE_PACE;
    private int ZOOM_PACE;
    private Bitmap angle_leftTop;
    private int dLineWidth;
    private Handler handler;
    private long lastActionUp;
    private float lastSingleFingerPositionY;
    private float lastTwoFingerDistance;
    private boolean mSupportManual;
    private Matrix matrix;
    private OnFinderClickListener onFinderClickListener;
    private OnFinderMoveListener onFinderMoveListener;
    private OnZoomOperatedListener onZoomOperatedListener;
    private Paint paint;
    private int shadowColor;
    private boolean showScanRect;
    private int targetBottom;
    private int targetLeft;
    private int targetRight;
    private int targetTop;
    private Paint xFerPaint;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnFinderClickListener {
        void onClick(int i, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnFinderMoveListener {
        void onMove(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnZoomOperatedListener {
        void onZoomReverted();

        void setZoom(float f);

        void startContinuousZoom(float f);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-424393998")) {
                ipChange.ipc$dispatch("-424393998", new Object[]{this, message});
                return;
            }
            MPaasLogger.d(ScaleFinderView.TAG, new String[]{"handleMessage: msg(", String.valueOf(message.what), AVFSCacheConstants.COMMA_SEP, String.valueOf(message.arg1), AVFSCacheConstants.COMMA_SEP, String.valueOf(message.arg2), AVFSCacheConstants.COMMA_SEP, String.valueOf(message.obj), jn1.BRACKET_END_STR});
            if (message.what == ScaleFinderView.MSG_CLICK) {
                Object obj = message.obj;
                if ((obj instanceof Long) && ((Long) obj).compareTo(Long.valueOf(ScaleFinderView.this.lastActionUp)) == 0) {
                    ScaleFinderView.this.onFinderClickHappen(message);
                }
            }
        }
    }

    public ScaleFinderView(Context context) {
        this(context, null);
    }

    private void drawAngle(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "176888265")) {
            ipChange.ipc$dispatch("176888265", new Object[]{this, canvas});
            return;
        }
        this.paint.setAlpha(255);
        canvas.drawBitmap(this.angle_leftTop, this.targetLeft, this.targetTop, this.paint);
        this.matrix.reset();
        canvas.save();
        this.matrix.setRotate(90.0f, this.angle_leftTop.getWidth() / 2, this.angle_leftTop.getHeight() / 2);
        canvas.translate(this.targetRight - this.angle_leftTop.getWidth(), this.targetTop);
        canvas.drawBitmap(this.angle_leftTop, this.matrix, this.paint);
        canvas.translate(0.0f, (this.targetBottom - this.targetTop) - this.angle_leftTop.getHeight());
        this.matrix.setRotate(180.0f, this.angle_leftTop.getWidth() / 2, this.angle_leftTop.getHeight() / 2);
        canvas.drawBitmap(this.angle_leftTop, this.matrix, this.paint);
        canvas.translate(-((this.targetRight - this.targetLeft) - this.angle_leftTop.getWidth()), 0.0f);
        this.matrix.setRotate(270.0f, this.angle_leftTop.getWidth() / 2, this.angle_leftTop.getHeight() / 2);
        canvas.drawBitmap(this.angle_leftTop, this.matrix, this.paint);
        canvas.restore();
    }

    private void drawRect(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728869070")) {
            ipChange.ipc$dispatch("1728869070", new Object[]{this, canvas});
        } else {
            canvas.drawRect(new Rect(this.targetLeft, this.targetTop, this.targetRight, this.targetBottom), this.xFerPaint);
        }
    }

    private void drawRectSide(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-566645563")) {
            ipChange.ipc$dispatch("-566645563", new Object[]{this, canvas});
            return;
        }
        this.paint.setColor(this.LINE_COLOR);
        this.paint.setStrokeWidth(this.dLineWidth);
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659551407")) {
            ipChange.ipc$dispatch("1659551407", new Object[]{this});
            return;
        }
        setLayerType(2, null);
        setOnTouchListener(this);
        if (TextUtils.equals(Build.getBRAND() + "/" + e80.b(), "GiONEE/GN5001S")) {
            this.ZOOM_PACE = 10;
        }
        this.handler = new a(Looper.getMainLooper());
    }

    private void initAngleBitmap(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1096066833")) {
            ipChange.ipc$dispatch("-1096066833", new Object[]{this, context});
        } else {
            this.angle_leftTop = BitmapFactory.decodeResource(context.getResources(), R$drawable.qrcode_corner_left_top);
        }
    }

    private void initPaint() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "922194813")) {
            ipChange.ipc$dispatch("922194813", new Object[]{this});
            return;
        }
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.xFerPaint = paint2;
        paint2.setAntiAlias(true);
        this.xFerPaint.setColor(-1);
        this.xFerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinderClickHappen(Message message) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887392633")) {
            ipChange.ipc$dispatch("887392633", new Object[]{this, message});
            return;
        }
        MPaasLogger.d(TAG, new String[]{"onClick(): x=", String.valueOf(message.arg1), ", y=", String.valueOf(message.arg2)});
        int i = message.arg1;
        int i2 = message.arg2;
        OnFinderClickListener onFinderClickListener = this.onFinderClickListener;
        if (onFinderClickListener == null || i <= this.targetLeft || i2 <= this.targetTop || i >= this.targetRight || i >= this.targetBottom) {
            return;
        }
        onFinderClickListener.onClick(i, i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1877160009")) {
            ipChange.ipc$dispatch("1877160009", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        canvas.drawColor(this.shadowColor);
        if (this.showScanRect) {
            drawRect(canvas);
            drawRectSide(canvas);
            drawAngle(canvas);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        OnZoomOperatedListener onZoomOperatedListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "270584320")) {
            return ((Boolean) ipChange.ipc$dispatch("270584320", new Object[]{this, view, motionEvent})).booleanValue();
        }
        MPaasLogger.d(TAG, new Object[]{motionEvent.toString()});
        if (view != this) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            this.lastTwoFingerDistance = 0.0f;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastActionUp < 300) {
                MPaasLogger.d(TAG, new Object[]{"double click"});
                OnZoomOperatedListener onZoomOperatedListener2 = this.onZoomOperatedListener;
                if (onZoomOperatedListener2 != null) {
                    onZoomOperatedListener2.onZoomReverted();
                }
                this.lastActionUp = 0L;
            } else {
                this.lastActionUp = currentTimeMillis;
                if (this.mSupportManual) {
                    MPaasLogger.d(TAG, new Object[]{"click"});
                    if (this.handler != null) {
                        Message obtain = Message.obtain();
                        obtain.what = MSG_CLICK;
                        obtain.arg1 = (int) motionEvent.getX();
                        obtain.arg2 = (int) motionEvent.getY();
                        obtain.obj = new Long(this.lastActionUp);
                        this.handler.sendMessageDelayed(obtain, 300L);
                    }
                }
            }
            return true;
        } else if (motionEvent.getAction() == 2) {
            if (motionEvent.getPointerCount() == 2) {
                if (this.lastTwoFingerDistance < 0.1f) {
                    this.lastTwoFingerDistance = (float) Math.sqrt(Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                } else {
                    float sqrt = (float) Math.sqrt(Math.pow(motionEvent.getX(0) - motionEvent.getX(1), 2.0d) + Math.pow(motionEvent.getY(0) - motionEvent.getY(1), 2.0d));
                    MPaasLogger.d(TAG, new Object[]{"lastTwoFingerDistance is ", Float.valueOf(this.lastTwoFingerDistance), ", distance is ", Float.valueOf(sqrt)});
                    int i = ((int) (sqrt - this.lastTwoFingerDistance)) / this.ZOOM_PACE;
                    if (Math.abs(i) > 1 && (onZoomOperatedListener = this.onZoomOperatedListener) != null) {
                        onZoomOperatedListener.setZoom(i);
                    }
                }
                return true;
            } else if (motionEvent.getPointerCount() == 1) {
                if (this.mSupportManual) {
                    if (this.lastSingleFingerPositionY <= 0.1f) {
                        this.lastSingleFingerPositionY = motionEvent.getY(0);
                    } else {
                        float y = motionEvent.getY(0);
                        MPaasLogger.d(TAG, new Object[]{"move: singleFingerPositionY is ", Float.valueOf(this.lastSingleFingerPositionY), ", curPositionY is ", Float.valueOf(y)});
                        int i2 = ((int) (this.lastSingleFingerPositionY - y)) / this.MOVE_PACE;
                        MPaasLogger.d(TAG, new Object[]{"move: rate = ", Integer.valueOf(i2)});
                        if (Math.abs(i2) > 1) {
                            OnFinderMoveListener onFinderMoveListener = this.onFinderMoveListener;
                            if (onFinderMoveListener != null) {
                                onFinderMoveListener.onMove(i2);
                            }
                            this.lastSingleFingerPositionY = y;
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            this.lastTwoFingerDistance = 0.0f;
            this.lastSingleFingerPositionY = 0.0f;
            return true;
        }
    }

    public void setOnFinderClickListener(OnFinderClickListener onFinderClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1520388478")) {
            ipChange.ipc$dispatch("-1520388478", new Object[]{this, onFinderClickListener});
        } else {
            this.onFinderClickListener = onFinderClickListener;
        }
    }

    public void setOnFinderMoveListener(OnFinderMoveListener onFinderMoveListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-816256638")) {
            ipChange.ipc$dispatch("-816256638", new Object[]{this, onFinderMoveListener});
        } else {
            this.onFinderMoveListener = onFinderMoveListener;
        }
    }

    public void setOnZoomOperatedListener(OnZoomOperatedListener onZoomOperatedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199232374")) {
            ipChange.ipc$dispatch("-1199232374", new Object[]{this, onZoomOperatedListener});
        } else {
            this.onZoomOperatedListener = onZoomOperatedListener;
        }
    }

    public void setShowScanRect(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1180272361")) {
            ipChange.ipc$dispatch("1180272361", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.showScanRect = z;
        }
    }

    public void setSupportManual(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832764328")) {
            ipChange.ipc$dispatch("832764328", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mSupportManual = z;
        }
    }

    public void setTargetLocation(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "308858435")) {
            ipChange.ipc$dispatch("308858435", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        MPaasLogger.d(TAG, new Object[]{"setTargetLocation: left=", Integer.valueOf(i), ", top=", Integer.valueOf(i2), ", right=", Integer.valueOf(i3), ", bottom=", Integer.valueOf(i4)});
        if (i == this.targetLeft && this.targetRight == i3 && this.targetTop == i2 && this.targetBottom == i4) {
            return;
        }
        this.targetLeft = i;
        this.targetRight = i3;
        this.targetTop = i2;
        this.targetBottom = i4;
    }

    public ScaleFinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleFinderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dLineWidth = 2;
        this.shadowColor = Color.parseColor("#5b03112b");
        this.LINE_COLOR = Color.parseColor("#108EE9");
        this.ZOOM_PACE = 30;
        this.MOVE_PACE = 30;
        this.matrix = new Matrix();
        initAngleBitmap(context);
        initPaint();
        init();
        this.showScanRect = true;
    }
}
