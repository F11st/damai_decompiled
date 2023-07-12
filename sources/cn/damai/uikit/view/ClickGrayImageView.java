package cn.damai.uikit.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.image.C2497a;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import tb.in2;
import tb.l62;

/* compiled from: Taobao */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes8.dex */
public class ClickGrayImageView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String STATE_BORDER_RADIUS = "state_border_radius";
    private static final String STATE_INSTANCE = "state_instance";
    private static final String STATE_TYPE = "state_type";
    public static final int TYPE_CIRCLE = 2;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_ROUND = 1;
    public static final String VIDEO_UNDER_REVIEW_URL = "VIDEO_UNDER_REVIEW_URL";
    private boolean alwaysLoadImage;
    private boolean isAttachedToWindow;
    private int lastHeight;
    private int lastWidth;
    private Paint mBitmapPaint;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private boolean mDrawMask;
    private LinearGradient mGradient;
    private ColorFilter mMaskColorFilter;
    private Matrix mMatrix;
    private int mRadius;
    private RectF mRectF;
    private RectF mRoundRect;
    private int mTextBgHeight;
    private Paint mTextBgPaint;
    private int mTextBgWidth;
    private TextPaint mTextPaint;
    private Paint mVideoUnderReviewPaint;
    private int mWidth;
    private Bitmap playIcon;
    private boolean showPlay;
    boolean single;
    IImageLoader.ImageTicket ticket;
    private int type;
    private String url;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.ClickGrayImageView$a */
    /* loaded from: classes8.dex */
    public class C2569a implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ IImageLoader.IImageSuccListener a;

        C2569a(IImageLoader.IImageSuccListener iImageSuccListener) {
            this.a = iImageSuccListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.C2496b c2496b) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "785277442")) {
                ipChange.ipc$dispatch("785277442", new Object[]{this, c2496b});
            } else if (c2496b != null) {
                Bitmap bitmap = c2496b.b;
                if (bitmap != null) {
                    ClickGrayImageView.this.setImageBitmap(bitmap);
                } else {
                    Drawable drawable = c2496b.a;
                    if (drawable instanceof AnimatedImageDrawable) {
                        ClickGrayImageView.this.setImageDrawable((AnimatedImageDrawable) drawable);
                    }
                }
                IImageLoader.IImageSuccListener iImageSuccListener = this.a;
                if (iImageSuccListener != null) {
                    iImageSuccListener.onSuccess(c2496b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.ClickGrayImageView$b */
    /* loaded from: classes8.dex */
    public class C2570b implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ IImageLoader.IImageFailListener b;

        C2570b(int i, IImageLoader.IImageFailListener iImageFailListener) {
            this.a = i;
            this.b = iImageFailListener;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.C2495a c2495a) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1260735467")) {
                ipChange.ipc$dispatch("1260735467", new Object[]{this, c2495a});
                return;
            }
            ClickGrayImageView.this.setImageResource(this.a);
            IImageLoader.IImageFailListener iImageFailListener = this.b;
            if (iImageFailListener != null) {
                iImageFailListener.onFail(c2495a);
            }
        }
    }

    public ClickGrayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 0;
        this.alwaysLoadImage = false;
        this.showPlay = false;
        this.mRectF = new RectF();
        this.mVideoUnderReviewPaint = new Paint(1);
        this.mTextBgPaint = new Paint(1);
        this.mTextPaint = new TextPaint(1);
        this.single = false;
        init();
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114332350")) {
            return (Bitmap) ipChange.ipc$dispatch("2114332350", new Object[]{this, drawable});
        }
        if ((drawable instanceof BitmapDrawable) && !(drawable instanceof AnimatedImageDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        drawable.getIntrinsicWidth();
        drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private void ensureGradient() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "36537566")) {
            ipChange.ipc$dispatch("36537566", new Object[]{this});
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (this.lastWidth != width || height != this.lastHeight || this.mGradient == null) {
            this.mGradient = new LinearGradient(width, 0.0f, 0.0f, 0.0f, Color.parseColor(in2.DETAIL_PAGE_DEFAULT_COLOR), Color.parseColor("#BAD5FF"), Shader.TileMode.CLAMP);
        }
        this.lastWidth = width;
        this.lastHeight = height;
    }

    private void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879453476")) {
            ipChange.ipc$dispatch("-879453476", new Object[]{this});
            return;
        }
        this.mMatrix = new Matrix();
        Paint paint = new Paint();
        this.mBitmapPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setAntiAlias(true);
        this.mRoundRect = new RectF();
        this.mMaskColorFilter = new PorterDuffColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        int a = l62.a(getContext(), 0.5f);
        this.mBorderWidth = a;
        this.mBorderPaint.setStrokeWidth(a);
        this.mBorderPaint.setColor(Color.parseColor("#1A000000"));
    }

    private boolean isVideoUnderReviewUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2047455982")) {
            return ((Boolean) ipChange.ipc$dispatch("-2047455982", new Object[]{this})).booleanValue();
        }
        String str = this.url;
        return str != null && str.contains("VIDEO_UNDER_REVIEW_URL");
    }

    private Bitmap setUpShader() {
        Bitmap drawableToBitamp;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798561754")) {
            return (Bitmap) ipChange.ipc$dispatch("1798561754", new Object[]{this});
        }
        Drawable drawable = getDrawable();
        if (drawable == null || (drawableToBitamp = drawableToBitamp(drawable)) == null) {
            return null;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(drawableToBitamp, tileMode, tileMode);
        int i = this.type;
        float f = 1.0f;
        if (i == 2) {
            f = (this.mWidth * 1.0f) / Math.min(drawableToBitamp.getWidth(), drawableToBitamp.getHeight());
        } else if (i == 1 && (drawableToBitamp.getWidth() != getWidth() || drawableToBitamp.getHeight() != getHeight())) {
            f = Math.max((getWidth() * 1.0f) / drawableToBitamp.getWidth(), (getHeight() * 1.0f) / drawableToBitamp.getHeight());
        }
        this.mMatrix.setScale(f, f);
        bitmapShader.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader(bitmapShader);
        if (this.mDrawMask) {
            this.mBitmapPaint.setColorFilter(this.mMaskColorFilter);
        } else {
            this.mBitmapPaint.setColorFilter(null);
        }
        return drawableToBitamp;
    }

    public String getURL() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1256904109") ? (String) ipChange.ipc$dispatch("1256904109", new Object[]{this}) : this.url;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091869406")) {
            ipChange.ipc$dispatch("1091869406", new Object[]{this});
            return;
        }
        this.isAttachedToWindow = true;
        setImageUrl(this.url);
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404927105")) {
            ipChange.ipc$dispatch("404927105", new Object[]{this});
            return;
        }
        IImageLoader.ImageTicket imageTicket = this.ticket;
        if (imageTicket != null) {
            imageTicket.cancel();
        }
        this.isAttachedToWindow = false;
        setImageBitmap(null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-592568324")) {
            ipChange.ipc$dispatch("-592568324", new Object[]{this, canvas});
        } else if (isVideoUnderReviewUrl()) {
            ensureGradient();
            int width = getWidth();
            int height = getHeight();
            if (this.mGradient != null) {
                this.mRectF.set(0.0f, 0.0f, width, height);
                this.mVideoUnderReviewPaint.setStyle(Paint.Style.FILL);
                this.mVideoUnderReviewPaint.setShader(this.mGradient);
                RectF rectF = this.mRectF;
                int i = this.mRadius;
                canvas.drawRoundRect(rectF, i, i, this.mVideoUnderReviewPaint);
            }
            this.mRectF.set(0.0f, 0.0f, this.mTextBgWidth, this.mTextBgHeight);
            RectF rectF2 = this.mRectF;
            float f = width;
            float f2 = height;
            rectF2.offset((f - rectF2.width()) / 2.0f, (f2 - this.mRectF.height()) / 2.0f);
            float f3 = this.mTextBgHeight / 2.0f;
            canvas.drawRoundRect(this.mRectF, f3, f3, this.mTextBgPaint);
            canvas.drawText("视频处理中", f / 2.0f, (f2 / 2.0f) + (((-this.mTextPaint.ascent()) - this.mTextBgPaint.descent()) / 2.0f), this.mTextPaint);
        } else if (getDrawable() == null) {
        } else {
            Bitmap upShader = setUpShader();
            RectF rectF3 = this.mRoundRect;
            float f4 = rectF3.left;
            int i2 = this.mBorderWidth;
            RectF rectF4 = new RectF(f4 + i2, rectF3.top + i2, rectF3.right - i2, rectF3.bottom - i2);
            int i3 = this.type;
            if (i3 == 1) {
                RectF rectF5 = this.mRoundRect;
                int i4 = this.mRadius;
                canvas.drawRoundRect(rectF5, i4, i4, this.mBorderPaint);
                int i5 = this.mRadius;
                canvas.drawRoundRect(rectF4, i5, i5, this.mBitmapPaint);
            } else if (i3 == 2) {
                int i6 = this.mRadius;
                canvas.drawCircle(i6, i6, i6, this.mBorderPaint);
                int i7 = this.mRadius;
                canvas.drawCircle(i7, i7, i7 - (this.mBorderWidth * 2), this.mBitmapPaint);
            } else if (upShader != null) {
                this.mRoundRect.set(0.0f, 0.0f, getWidth(), getWidth());
                canvas.drawBitmap(upShader, (Rect) null, this.mRoundRect, (Paint) null);
            }
            if (this.showPlay) {
                if (this.playIcon == null) {
                    this.playIcon = BitmapFactory.decodeResource(getContext().getResources(), R$drawable.feed_video_icon);
                    Matrix matrix = new Matrix();
                    matrix.setScale(2.0f, 2.0f);
                    Bitmap bitmap = this.playIcon;
                    this.playIcon = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.playIcon.getHeight(), matrix, true);
                }
                canvas.drawBitmap(this.playIcon, (getWidth() - this.playIcon.getWidth()) - 10, 10.0f, this.mBitmapPaint);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1281843487")) {
            ipChange.ipc$dispatch("1281843487", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        if (this.type == 2) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.mWidth = min;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1007096180")) {
            ipChange.ipc$dispatch("1007096180", new Object[]{this, parcelable});
        } else if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(STATE_INSTANCE));
            this.type = bundle.getInt(STATE_TYPE);
            this.mRadius = bundle.getInt(STATE_BORDER_RADIUS);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1214632513")) {
            return (Parcelable) ipChange.ipc$dispatch("1214632513", new Object[]{this});
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_INSTANCE, super.onSaveInstanceState());
        bundle.putInt(STATE_TYPE, this.type);
        bundle.putInt(STATE_BORDER_RADIUS, this.mRadius);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267274230")) {
            ipChange.ipc$dispatch("-1267274230", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.type;
        if (i5 == 1 || i5 == 0) {
            this.mRoundRect.set(0.0f, 0.0f, i, i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-476581269")) {
            return ((Boolean) ipChange.ipc$dispatch("-476581269", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDrawMask = true;
            invalidate();
        } else if (action == 1 || action == 3) {
            this.mDrawMask = false;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAlwaysLoadImage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671217324")) {
            ipChange.ipc$dispatch("671217324", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.alwaysLoadImage = z;
        }
    }

    public void setImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2093756562")) {
            ipChange.ipc$dispatch("2093756562", new Object[]{this, str});
        } else {
            setImageUrl(str, null, null);
        }
    }

    public void setShowPlay(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159338935")) {
            ipChange.ipc$dispatch("-159338935", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.showPlay = z;
        }
    }

    public void setSingle(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1667697280")) {
            ipChange.ipc$dispatch("-1667697280", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.single = z;
        }
    }

    public void setImageUrl(String str, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1187426750")) {
            ipChange.ipc$dispatch("1187426750", new Object[]{this, str, iImageSuccListener, iImageFailListener});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.url = str;
            if (this.isAttachedToWindow || this.alwaysLoadImage) {
                int i = R$drawable.uikit_default_image_bg_grey;
                this.ticket = C2497a.a().load(str, i, i, -1, -1, new C2569a(iImageSuccListener), new C2570b(i, iImageFailListener));
            }
        }
    }

    public ClickGrayImageView(Context context) {
        super(context);
        this.type = 0;
        this.alwaysLoadImage = false;
        this.showPlay = false;
        this.mRectF = new RectF();
        this.mVideoUnderReviewPaint = new Paint(1);
        this.mTextBgPaint = new Paint(1);
        this.mTextPaint = new TextPaint(1);
        this.single = false;
        init();
    }

    public ClickGrayImageView(Context context, int i) {
        super(context);
        this.type = 0;
        this.alwaysLoadImage = false;
        this.showPlay = false;
        this.mRectF = new RectF();
        this.mVideoUnderReviewPaint = new Paint(1);
        this.mTextBgPaint = new Paint(1);
        this.mTextPaint = new TextPaint(1);
        this.single = false;
        this.mRadius = i;
        if (i > 0) {
            this.type = 1;
        }
        this.mTextBgWidth = l62.a(context, 62.0f);
        this.mTextBgHeight = l62.a(context, 26.0f);
        this.mTextPaint.setColor(-1);
        this.mTextPaint.setTextSize(l62.a(context, 10.0f));
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextBgPaint.setColor(Color.parseColor("#33000000"));
        this.mTextBgPaint.setStyle(Paint.Style.FILL);
        init();
    }
}
