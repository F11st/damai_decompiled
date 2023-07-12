package cn.damai.uikit.scrollsky;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import cn.damai.uikit.R$color;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.th2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SendYouToTheSkyView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int LOOP_INTERVAL = 1500;
    private static float sBottomAlpaha = 200.0f;
    private static float sTopAlpaha = 90.0f;
    private int diam;
    private Activity mActivity;
    private float mAlpaha1;
    private float mAlpaha2;
    private float mAlpaha3;
    private ValueAnimator mAnimator;
    private float mBeishu;
    private Paint mBorderPaint1;
    private Paint mBorderPaint2;
    private Paint mBorderPaint3;
    private Context mContext;
    private int mCurIndex;
    private Bitmap mDefaultBitmap;
    private float mDpHeight;
    private float mFixAlpaha1;
    private float mFixAlpaha2;
    private float mFixAlpaha3;
    private float mFixY1;
    private float mFixY2;
    private float mFixY3;
    private float mHeight;
    private boolean mIsAttached;
    private boolean mIsStart;
    private List<BarrageBean> mList;
    private Paint mPaint1;
    private Paint mPaint2;
    private Paint mPaint3;
    private Paint mPaintBitmap1;
    private Paint mPaintBitmap2;
    private Paint mPaintBitmap3;
    private float mScrollY;
    private float mText1Y;
    private float mText2Y;
    private float mText3Y;
    private int mTextSize;
    private BarrageBean[] mTexts;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2129190206")) {
                ipChange.ipc$dispatch("2129190206", new Object[]{this, valueAnimator});
                return;
            }
            float intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 100.0f;
            float f = SendYouToTheSkyView.this.mScrollY * intValue;
            if (intValue < 1.0f && intValue > 0.0f) {
                SendYouToTheSkyView sendYouToTheSkyView = SendYouToTheSkyView.this;
                sendYouToTheSkyView.mText1Y = sendYouToTheSkyView.mFixY1 - f;
                SendYouToTheSkyView sendYouToTheSkyView2 = SendYouToTheSkyView.this;
                sendYouToTheSkyView2.mText2Y = sendYouToTheSkyView2.mFixY2 - f;
                SendYouToTheSkyView sendYouToTheSkyView3 = SendYouToTheSkyView.this;
                sendYouToTheSkyView3.mText3Y = sendYouToTheSkyView3.mFixY3 - f;
                SendYouToTheSkyView sendYouToTheSkyView4 = SendYouToTheSkyView.this;
                sendYouToTheSkyView4.mAlpaha1 = sendYouToTheSkyView4.mFixAlpaha1 - (((SendYouToTheSkyView.sBottomAlpaha - SendYouToTheSkyView.sTopAlpaha) * intValue) * SendYouToTheSkyView.this.mBeishu);
                SendYouToTheSkyView sendYouToTheSkyView5 = SendYouToTheSkyView.this;
                sendYouToTheSkyView5.mAlpaha2 = sendYouToTheSkyView5.mFixAlpaha2 - (((SendYouToTheSkyView.sBottomAlpaha - SendYouToTheSkyView.sTopAlpaha) * intValue) * SendYouToTheSkyView.this.mBeishu);
                if (SendYouToTheSkyView.this.mText3Y > SendYouToTheSkyView.this.mScrollY) {
                    SendYouToTheSkyView sendYouToTheSkyView6 = SendYouToTheSkyView.this;
                    sendYouToTheSkyView6.mAlpaha3 = sendYouToTheSkyView6.mFixAlpaha3;
                } else {
                    SendYouToTheSkyView sendYouToTheSkyView7 = SendYouToTheSkyView.this;
                    sendYouToTheSkyView7.mAlpaha3 = sendYouToTheSkyView7.mFixAlpaha3 - (((SendYouToTheSkyView.sBottomAlpaha - SendYouToTheSkyView.sTopAlpaha) * intValue) * SendYouToTheSkyView.this.mBeishu);
                }
            }
            SendYouToTheSkyView.this.invalidate();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ BarrageBean a;

        b(BarrageBean barrageBean) {
            this.a = barrageBean;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1579373357")) {
                ipChange.ipc$dispatch("-1579373357", new Object[]{this, bVar});
            } else if (bVar == null || (bitmap = bVar.b) == null) {
            } else {
                this.a.bitmap = SendYouToTheSkyView.this.getCirleBitmap(SendYouToTheSkyView.zoomImage(bitmap, SendYouToTheSkyView.this.dip2pxForFloat(20.0f), SendYouToTheSkyView.this.dip2pxForFloat(20.0f)));
            }
        }
    }

    public SendYouToTheSkyView(Context context) {
        this(context, null);
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1913495191") ? ((Integer) ipChange.ipc$dispatch("-1913495191", new Object[]{this, Float.valueOf(f)})).intValue() : (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float dip2pxForFloat(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1417114649") ? ((Float) ipChange.ipc$dispatch("1417114649", new Object[]{this, Float.valueOf(f)})).floatValue() : f * getContext().getResources().getDisplayMetrics().density;
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585509444")) {
            ipChange.ipc$dispatch("585509444", new Object[]{this});
            return;
        }
        int dip2px = dip2px(20.0f);
        this.diam = dip2px;
        Bitmap createBitmap = Bitmap.createBitmap(dip2px, dip2px, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(Color.parseColor("#33ffffff"));
        this.mDefaultBitmap = getCirleBitmap(createBitmap);
        int i = this.mTextSize;
        this.mDpHeight = i + 5.0f + 25.0f + i + 5.0f;
        this.mHeight = dip2px(i + 5.0f + 25.0f + i + 5.0f);
        this.mFixY1 = dip2px(this.mTextSize + 5);
        int i2 = this.mTextSize;
        this.mFixY2 = dip2px(i2 + 5 + 25 + i2);
        int i3 = this.mTextSize;
        this.mFixY3 = dip2px(i3 + 5 + 25 + i3 + 25 + i3);
        float f = sTopAlpaha;
        float f2 = sBottomAlpaha;
        float f3 = this.mDpHeight;
        this.mFixAlpaha1 = ((f2 - f) * (5.0f / f3)) + f;
        this.mFixAlpaha2 = f2 - ((f2 - f) * (5.0f / f3));
        this.mFixAlpaha3 = f2;
        resetY();
        Paint paint = new Paint();
        this.mPaint1 = paint;
        Resources resources = this.mContext.getResources();
        int i4 = R$color.white;
        paint.setColor(resources.getColor(i4));
        this.mPaint1.setAlpha((int) this.mAlpaha1);
        this.mPaint1.setTextSize(dip2px(this.mTextSize));
        this.mPaint1.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mPaint2 = paint2;
        paint2.setColor(this.mContext.getResources().getColor(i4));
        this.mPaint2.setAlpha((int) this.mAlpaha2);
        this.mPaint2.setTextSize(dip2px(this.mTextSize));
        this.mPaint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mPaint3 = paint3;
        paint3.setColor(this.mContext.getResources().getColor(i4));
        this.mPaint3.setAlpha((int) this.mAlpaha3);
        this.mPaint3.setTextSize(dip2px(this.mTextSize));
        this.mPaint3.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.mPaintBitmap1 = paint4;
        paint4.setAntiAlias(true);
        this.mPaintBitmap1.setAlpha((int) this.mAlpaha1);
        Paint paint5 = new Paint();
        this.mPaintBitmap2 = paint5;
        paint5.setAntiAlias(true);
        this.mPaintBitmap2.setAlpha((int) this.mAlpaha2);
        Paint paint6 = new Paint();
        this.mPaintBitmap3 = paint6;
        paint6.setAntiAlias(true);
        this.mPaintBitmap3.setAlpha((int) this.mAlpaha3);
        Paint paint7 = new Paint();
        this.mBorderPaint1 = paint7;
        paint7.setAntiAlias(true);
        Paint paint8 = this.mBorderPaint1;
        Resources resources2 = this.mContext.getResources();
        int i5 = R$color.color_33FFFFFF;
        paint8.setColor(resources2.getColor(i5));
        this.mBorderPaint1.setAlpha((int) this.mAlpaha1);
        this.mBorderPaint1.setStyle(Paint.Style.STROKE);
        this.mBorderPaint1.setStrokeWidth(dip2px(1.0f));
        Paint paint9 = new Paint();
        this.mBorderPaint2 = paint9;
        paint9.setAntiAlias(true);
        this.mBorderPaint2.setColor(this.mContext.getResources().getColor(i5));
        this.mBorderPaint2.setAlpha((int) this.mAlpaha2);
        this.mBorderPaint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint2.setStrokeWidth(dip2px(1.0f));
        Paint paint10 = new Paint();
        this.mBorderPaint3 = paint10;
        paint10.setAntiAlias(true);
        this.mBorderPaint3.setColor(this.mContext.getResources().getColor(i5));
        this.mBorderPaint3.setAlpha((int) this.mAlpaha3);
        this.mBorderPaint3.setStyle(Paint.Style.STROKE);
        this.mBorderPaint3.setStrokeWidth(dip2px(1.0f));
        float dip2px2 = dip2px(this.mTextSize + 25);
        this.mScrollY = dip2px2;
        this.mBeishu = dip2px2 / this.mHeight;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 100);
        this.mAnimator = ofInt;
        ofInt.setDuration(500L);
        this.mAnimator.setRepeatCount(0);
        this.mAnimator.addUpdateListener(new a());
        this.mAnimator.addListener(new Animator.AnimatorListener() { // from class: cn.damai.uikit.scrollsky.SendYouToTheSkyView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2081677153")) {
                    ipChange2.ipc$dispatch("2081677153", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "430669678")) {
                    ipChange2.ipc$dispatch("430669678", new Object[]{this, animator});
                    return;
                }
                SendYouToTheSkyView.this.setNextString();
                SendYouToTheSkyView.this.resetY();
                SendYouToTheSkyView.this.invalidate();
                SendYouToTheSkyView.this.postDelayed(new Runnable() { // from class: cn.damai.uikit.scrollsky.SendYouToTheSkyView.2.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "649607307")) {
                            ipChange3.ipc$dispatch("649607307", new Object[]{this});
                        } else {
                            SendYouToTheSkyView.this.startAnim();
                        }
                    }
                }, 1500L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "100285472")) {
                    ipChange2.ipc$dispatch("100285472", new Object[]{this, animator});
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "112298311")) {
                    ipChange2.ipc$dispatch("112298311", new Object[]{this, animator});
                }
            }
        });
    }

    private boolean isCanLoop() {
        Activity activity;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1373405461") ? ((Boolean) ipChange.ipc$dispatch("-1373405461", new Object[]{this})).booleanValue() : (!this.mIsAttached || th2.b(this.mList) <= 1 || this.mAnimator.isRunning() || (activity = this.mActivity) == null || activity.isFinishing()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetY() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641042929")) {
            ipChange.ipc$dispatch("-641042929", new Object[]{this});
            return;
        }
        this.mText1Y = this.mFixY1;
        this.mText2Y = this.mFixY2;
        this.mText3Y = this.mFixY3;
        this.mAlpaha1 = this.mFixAlpaha1;
        this.mAlpaha2 = this.mFixAlpaha2;
        this.mAlpaha3 = this.mFixAlpaha3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2027601269")) {
            ipChange.ipc$dispatch("-2027601269", new Object[]{this});
            return;
        }
        int i = 0;
        while (true) {
            BarrageBean[] barrageBeanArr = this.mTexts;
            if (i >= barrageBeanArr.length) {
                return;
            }
            if (barrageBeanArr[i].index < this.mList.size() - 1) {
                BarrageBean[] barrageBeanArr2 = this.mTexts;
                barrageBeanArr2[i] = this.mList.get(barrageBeanArr2[i].index + 1);
            } else {
                this.mTexts[i] = this.mList.get(0);
            }
            i++;
        }
    }

    public static Bitmap zoomImage(Bitmap bitmap, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2112142851")) {
            return (Bitmap) ipChange.ipc$dispatch("2112142851", new Object[]{bitmap, Float.valueOf(f), Float.valueOf(f2)});
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f / width, f2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }

    public Bitmap getCirleBitmap(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1868657041")) {
            return (Bitmap) ipChange.ipc$dispatch("1868657041", new Object[]{this, bitmap});
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int i = this.diam;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        int i2 = this.diam;
        canvas.drawCircle(i2 / 2, i2 / 2, i2 / 2, paint);
        return createBitmap;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1244824981")) {
            ipChange.ipc$dispatch("-1244824981", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.mIsAttached = true;
        postDelayed(new Runnable() { // from class: cn.damai.uikit.scrollsky.SendYouToTheSkyView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-72271562")) {
                    ipChange2.ipc$dispatch("-72271562", new Object[]{this});
                } else {
                    SendYouToTheSkyView.this.startAnim();
                }
            }
        }, 1500L);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109517006")) {
            ipChange.ipc$dispatch("1109517006", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mIsAttached = false;
        stopAnim();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824501135")) {
            ipChange.ipc$dispatch("1824501135", new Object[]{this, canvas});
        } else if (th2.b(this.mList) < 2) {
        } else {
            this.mPaint1.setAlpha((int) this.mAlpaha1);
            this.mPaint2.setAlpha((int) this.mAlpaha2);
            this.mPaint3.setAlpha((int) this.mAlpaha3);
            this.mPaintBitmap1.setAlpha((int) this.mAlpaha1);
            this.mPaintBitmap2.setAlpha((int) this.mAlpaha2);
            this.mPaintBitmap3.setAlpha((int) this.mAlpaha3);
            this.mBorderPaint1.setAlpha((int) this.mAlpaha1);
            this.mBorderPaint2.setAlpha((int) this.mAlpaha2);
            this.mBorderPaint3.setAlpha((int) this.mAlpaha3);
            if (this.mTexts[0].bitmap != null) {
                canvas.drawCircle(dip2px(10.0f), (this.mText1Y - dip2px(13.0f)) + dip2px(10.0f), dip2px(9.5f), this.mBorderPaint1);
                canvas.drawBitmap(this.mTexts[0].bitmap, 0.0f, this.mText1Y - dip2px(13.0f), this.mPaintBitmap1);
            }
            if (this.mTexts[1].bitmap != null) {
                canvas.drawCircle(dip2px(10.0f), (this.mText2Y - dip2px(13.0f)) + dip2px(10.0f), dip2px(9.5f), this.mBorderPaint2);
                canvas.drawBitmap(this.mTexts[1].bitmap, 0.0f, this.mText2Y - dip2px(13.0f), this.mPaintBitmap2);
            }
            if (this.mTexts[2].bitmap != null) {
                canvas.drawCircle(dip2px(10.0f), (this.mText3Y - dip2px(13.0f)) + dip2px(10.0f), dip2px(9.5f), this.mBorderPaint3);
                canvas.drawBitmap(this.mTexts[2].bitmap, 0.0f, this.mText3Y - dip2px(13.0f), this.mPaintBitmap3);
            }
            canvas.drawText(this.mTexts[0].content, dip2px(25.0f), this.mText1Y, this.mPaint1);
            canvas.drawText(this.mTexts[1].content, dip2px(25.0f), this.mText2Y, this.mPaint2);
            canvas.drawText(this.mTexts[2].content, dip2px(25.0f), this.mText3Y, this.mPaint3);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112501445")) {
            ipChange.ipc$dispatch("112501445", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.mIsAttached = true;
            postDelayed(new Runnable() { // from class: cn.damai.uikit.scrollsky.SendYouToTheSkyView.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-268785067")) {
                        ipChange2.ipc$dispatch("-268785067", new Object[]{this});
                    } else {
                        SendYouToTheSkyView.this.startAnim();
                    }
                }
            }, 1500L);
            return;
        }
        this.mIsAttached = false;
        stopAnim();
    }

    public void setData(List<BarrageBean> list, int i, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "995549407")) {
            ipChange.ipc$dispatch("995549407", new Object[]{this, list, Integer.valueOf(i), activity});
            return;
        }
        this.mActivity = activity;
        if (th2.b(list) < 2) {
            return;
        }
        this.mList.clear();
        for (int i2 = 0; i2 < list.size() && i2 < i; i2++) {
            BarrageBean barrageBean = list.get(i2);
            if (barrageBean != null && !TextUtils.isEmpty(barrageBean.content)) {
                if (barrageBean.content.length() > 18) {
                    barrageBean.content = barrageBean.content.substring(0, 18);
                }
                if (barrageBean.content.contains(StringUtils.LF)) {
                    String str = barrageBean.content;
                    barrageBean.content = str.substring(0, str.indexOf(StringUtils.LF));
                }
                barrageBean.bitmap = this.mDefaultBitmap;
                cn.damai.uikit.image.a.a().load(barrageBean.headImg, 0, new b(barrageBean), null);
                this.mList.add(barrageBean);
            }
        }
        for (int i3 = 0; i3 < this.mList.size(); i3++) {
            this.mList.get(i3).index = i3;
        }
        if (th2.b(this.mList) < 2) {
            return;
        }
        this.mTexts[0] = this.mList.get(0);
        this.mTexts[1] = this.mList.get(1);
        if (this.mList.size() == 2) {
            this.mTexts[2] = this.mList.get(0);
        } else {
            this.mTexts[2] = this.mList.get(2);
        }
    }

    public void startAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813106878")) {
            ipChange.ipc$dispatch("813106878", new Object[]{this});
        } else if (this.mAnimator == null || !isCanLoop()) {
        } else {
            this.mAnimator.cancel();
            this.mAnimator.start();
        }
    }

    public void stopAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "964486182")) {
            ipChange.ipc$dispatch("964486182", new Object[]{this});
            return;
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mIsStart = false;
        }
    }

    public SendYouToTheSkyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diam = 20;
        this.mList = new ArrayList();
        this.mTexts = new BarrageBean[3];
        this.mCurIndex = 1;
        this.mFixAlpaha1 = 0.0f;
        this.mFixAlpaha2 = 0.0f;
        this.mFixAlpaha3 = 0.0f;
        this.mAlpaha1 = 0.0f;
        this.mAlpaha2 = 0.0f;
        this.mAlpaha3 = 0.0f;
        this.mTextSize = 11;
        this.mScrollY = 0.0f;
        this.mIsAttached = false;
        this.mContext = context;
        initView();
    }
}
