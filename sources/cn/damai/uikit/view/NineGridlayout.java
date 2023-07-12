package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.jn1;
import tb.q60;
import tb.yr2;
import tb.z32;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class NineGridlayout extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean alwaysLoadImage;
    private boolean autoShrink;
    private int childBoundClipRadius;
    private int columns;
    TextView conertip;
    private int gap;
    private boolean handleSinglePic;
    private IImageLoader.IImageFailListener imageFailListener;
    private OnImageLoadFinishListener imageLoadFinishListener;
    private IImageLoader.IImageSuccListener imageSuccListener;
    private List<Image> images;
    private View.OnClickListener listener;
    private Path mPath;
    private RectF mRectF;
    private RectF mTempRectF;
    private int multiImageLoadCounter;
    private int multiImageLoadTotal;
    private Bitmap playIcon;
    private int radius;
    private int realSize;
    private int rows;
    private int singleH;
    private int singleW;
    private int totalWidth;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnImageLoadFinishListener {
        void onCompletion(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "142332311")) {
                ipChange.ipc$dispatch("142332311", new Object[]{this, view});
                return;
            }
            view.setTag(0);
            if (NineGridlayout.this.listener != null) {
                NineGridlayout.this.listener.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2041344616")) {
                ipChange.ipc$dispatch("-2041344616", new Object[]{this, view});
            } else if (NineGridlayout.this.listener != null) {
                NineGridlayout.this.listener.onClick(view);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class c implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1536909043")) {
                ipChange.ipc$dispatch("1536909043", new Object[]{this, bVar});
            } else if (NineGridlayout.access$204(NineGridlayout.this) != NineGridlayout.this.multiImageLoadTotal || NineGridlayout.this.imageLoadFinishListener == null) {
            } else {
                NineGridlayout.this.imageLoadFinishListener.onCompletion(true);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class d implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-521465444")) {
                ipChange.ipc$dispatch("-521465444", new Object[]{this, aVar});
            } else if (NineGridlayout.access$204(NineGridlayout.this) != NineGridlayout.this.multiImageLoadTotal || NineGridlayout.this.imageLoadFinishListener == null) {
            } else {
                NineGridlayout.this.imageLoadFinishListener.onCompletion(false);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class e implements IImageLoader.IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ List a;

        e(List list) {
            this.a = list;
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
        public void onSuccess(IImageLoader.b bVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1482516145")) {
                ipChange.ipc$dispatch("1482516145", new Object[]{this, bVar});
                return;
            }
            Bitmap bitmap = bVar.b;
            if (bitmap != null) {
                Log.d("getWidth", " getWidth onSuccess 222: " + bVar.a.getIntrinsicWidth() + " , " + bVar.a.getIntrinsicHeight());
                int[] imgWH = NineGridlayout.this.getImgWH(bitmap.getWidth(), bitmap.getHeight());
                int i = imgWH[0];
                int i2 = imgWH[1];
                Log.d("blockW", " imgW: " + i + " , " + i2);
                Log.d("blockW", " change imgW: " + i + " , " + i2);
                ViewGroup.LayoutParams layoutParams = NineGridlayout.this.getLayoutParams();
                layoutParams.height = i2;
                layoutParams.width = i;
                NineGridlayout.this.setLayoutParams(layoutParams);
                Log.d("blockW", " old bitmap W: " + bitmap.getWidth() + " , " + bitmap.getHeight());
                Bitmap newBitmap = NineGridlayout.this.getNewBitmap(bitmap, i, i2);
                Log.d("blockW", " new bitmap W: " + newBitmap.getWidth() + " , " + newBitmap.getHeight());
                z32 z32Var = new z32(newBitmap);
                z32Var.b(q60.a(NineGridlayout.this.getContext(), 6.0f));
                if (((Image) this.a.get(0)).showPlay) {
                    z32Var.a(NineGridlayout.this.playIcon);
                } else {
                    z32Var.a(null);
                }
                NineGridlayout.this.setBackground(z32Var);
                if (NineGridlayout.this.imageLoadFinishListener != null) {
                    NineGridlayout.this.imageLoadFinishListener.onCompletion(true);
                    return;
                }
                return;
            }
            Drawable drawable = bVar.a;
            if (drawable != null) {
                int[] imgWH2 = NineGridlayout.this.getImgWH(drawable.getMinimumWidth(), bVar.a.getMinimumHeight());
                int i3 = imgWH2[0];
                int i4 = imgWH2[1];
                Log.d("blockW", " imgW: " + i3 + " , " + i4);
                Log.d("blockW", " change imgW: " + i3 + " , " + i4);
                ViewGroup.LayoutParams layoutParams2 = NineGridlayout.this.getLayoutParams();
                layoutParams2.height = i4;
                layoutParams2.width = i3;
                NineGridlayout.this.setLayoutParams(layoutParams2);
                NineGridlayout.this.setBackground(bVar.a);
                if (NineGridlayout.this.imageLoadFinishListener != null) {
                    NineGridlayout.this.imageLoadFinishListener.onCompletion(true);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class f implements IImageLoader.IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f(NineGridlayout nineGridlayout) {
        }

        @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
        public void onFail(IImageLoader.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-87736358")) {
                ipChange.ipc$dispatch("-87736358", new Object[]{this, aVar});
            }
        }
    }

    public NineGridlayout(Context context) {
        super(context);
        this.gap = 5;
        this.radius = 0;
        this.autoShrink = false;
        this.handleSinglePic = false;
        this.multiImageLoadCounter = 0;
        this.multiImageLoadTotal = 0;
        this.alwaysLoadImage = false;
        this.childBoundClipRadius = 0;
        this.mRectF = new RectF();
        this.mTempRectF = new RectF();
        this.imageSuccListener = new c();
        this.imageFailListener = new d();
    }

    static /* synthetic */ int access$204(NineGridlayout nineGridlayout) {
        int i = nineGridlayout.multiImageLoadCounter + 1;
        nineGridlayout.multiImageLoadCounter = i;
        return i;
    }

    private void addConerTip(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "255309924")) {
            ipChange.ipc$dispatch("255309924", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (this.realSize > this.images.size()) {
            if (this.conertip == null) {
                this.conertip = new TextView(getContext());
                addView(this.conertip, new ViewGroup.LayoutParams(q60.a(getContext(), 40.0f), q60.a(getContext(), 25.0f)));
            }
            this.conertip.setBackground(getResources().getDrawable(R$drawable.bg_corner_ninegrid_tip));
            this.conertip.setGravity(17);
            int a2 = yr2.a(getContext(), 1.0f);
            this.conertip.setPadding(yr2.a(getContext(), 4.0f), a2, yr2.a(getContext(), 2.5f), a2);
            TextView textView = this.conertip;
            textView.setText(jn1.PLUS + (this.realSize - 3));
            this.conertip.setTextColor(getResources().getColor(R$color.white));
            this.conertip.setTextSize((float) yr2.a(getContext(), 3.5f));
            int a3 = i - yr2.a(getContext(), 24.5f);
            int a4 = i2 - yr2.a(getContext(), 16.5f);
            int a5 = i - yr2.a(getContext(), 0.5f);
            int a6 = i2 - yr2.a(getContext(), 0.5f);
            this.conertip.layout(a3, a4, a5, a6);
            Log.d("grid", " layout === : " + a3 + " , " + a4 + " , " + a5 + " , " + a6);
            this.conertip.setVisibility(0);
        } else {
            TextView textView2 = this.conertip;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
    }

    private void ensureClipPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "421927494")) {
            ipChange.ipc$dispatch("421927494", new Object[]{this});
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0 && this.childBoundClipRadius > 0) {
            this.mTempRectF.set(this.mRectF);
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8) {
                    if (i == 0) {
                        this.mRectF.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                    } else {
                        this.mRectF.left = Math.min(childAt.getLeft(), this.mRectF.left);
                        this.mRectF.top = Math.min(childAt.getTop(), this.mRectF.top);
                        this.mRectF.right = Math.max(childAt.getRight(), this.mRectF.right);
                        this.mRectF.bottom = Math.max(childAt.getBottom(), this.mRectF.bottom);
                    }
                }
            }
            if (this.mPath == null || !this.mTempRectF.equals(this.mRectF)) {
                Path path = new Path();
                this.mPath = path;
                RectF rectF = this.mRectF;
                int i2 = this.childBoundClipRadius;
                path.addRoundRect(rectF, i2, i2, Path.Direction.CW);
                return;
            }
            return;
        }
        this.mPath = null;
    }

    private int[] findPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-266492584")) {
            return (int[]) ipChange.ipc$dispatch("-266492584", new Object[]{this, Integer.valueOf(i)});
        }
        int[] iArr = new int[2];
        for (int i2 = 0; i2 < this.rows; i2++) {
            int i3 = 0;
            while (true) {
                int i4 = this.columns;
                if (i3 >= i4) {
                    break;
                } else if ((i4 * i2) + i3 == i) {
                    iArr[0] = i2;
                    iArr[1] = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        return iArr;
    }

    private void fixMutiImgs(List<Image> list) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "617274368")) {
            ipChange.ipc$dispatch("617274368", new Object[]{this, list});
            return;
        }
        List<Image> list2 = this.images;
        if (list2 == null) {
            while (i < list.size()) {
                addView(generateImageView(), generateDefaultLayoutParams());
                Log.d("grid", " addView: " + i);
                i++;
            }
            return;
        }
        int size = list2.size();
        int size2 = list.size();
        if (size > size2) {
            removeViews(size2 - 1, size - size2);
            Log.d("grid", " removeViews---: " + size2 + " total");
        } else if (size < size2) {
            while (i < size2 - size) {
                addView(generateImageView(), generateDefaultLayoutParams());
                Log.d("grid", " addViews---: " + size2 + " total");
                i++;
            }
        }
    }

    private void fixSingleImg(List<Image> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "540690820")) {
            ipChange.ipc$dispatch("540690820", new Object[]{this, list});
            return;
        }
        if (this.playIcon == null) {
            this.playIcon = BitmapFactory.decodeResource(getContext().getResources(), R$drawable.feed_video_icon);
            Matrix matrix = new Matrix();
            matrix.setScale(2.0f, 2.0f);
            Bitmap bitmap = this.playIcon;
            this.playIcon = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.playIcon.getHeight(), matrix, true);
        }
        if (list.get(0) == null) {
            return;
        }
        cn.damai.uikit.image.a.a().load(list.get(0).url, R$drawable.uikit_default_image_bg_grey, new e(list), new f(this));
    }

    private ClickGrayImageView generateImageView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-293380792")) {
            return (ClickGrayImageView) ipChange.ipc$dispatch("-293380792", new Object[]{this});
        }
        ClickGrayImageView clickGrayImageView = new ClickGrayImageView(getContext(), this.radius);
        clickGrayImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        clickGrayImageView.setOnClickListener(new b());
        clickGrayImageView.setBackgroundColor(Color.parseColor("#f5f5f5"));
        return clickGrayImageView;
    }

    private int getBlockW(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587934171")) {
            return ((Integer) ipChange.ipc$dispatch("-587934171", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        if (this.totalWidth == 0) {
            this.totalWidth = (int) (yr2.d(getContext()) - yr2.a(getContext(), i));
        }
        return (this.totalWidth - (this.gap * 2)) / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getImgWH(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113466007")) {
            return (int[]) ipChange.ipc$dispatch("-1113466007", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int[] iArr = new int[2];
        int blockW = getBlockW(42);
        int i3 = this.totalWidth;
        int a2 = yr2.a(getContext(), 184.0f);
        int a3 = yr2.a(getContext(), 217.0f);
        int a4 = yr2.a(getContext(), 289.0f);
        Log.d("blockW", " imgW: " + i + " , " + i2);
        int i4 = this.totalWidth;
        if (i * 9 < i2 * 16) {
            if (i * 4 <= i2 * 3) {
                i3 = a3;
                a2 = a4;
            } else {
                i3 = (int) (i4 * 0.66d);
                a2 = i3;
            }
        }
        if (i3 < blockW) {
            a2 = (a2 * blockW) / i3;
            i3 = blockW;
        }
        if (a2 < blockW) {
            i3 = (i3 * blockW) / a2;
        } else {
            blockW = a2;
        }
        if (blockW <= i4) {
            i4 = blockW;
        }
        iArr[0] = i3;
        iArr[1] = i4;
        return iArr;
    }

    private void initChild(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109999682")) {
            ipChange.ipc$dispatch("-109999682", new Object[]{this, Integer.valueOf(i)});
        } else if (i <= 3) {
            this.rows = 1;
            this.columns = i;
        } else if (i <= 6) {
            this.rows = 2;
            this.columns = 3;
            if (i == 4) {
                this.columns = 2;
            }
        } else {
            this.rows = 3;
            this.columns = 3;
        }
    }

    private void layoutChildrenView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1624973003")) {
            ipChange.ipc$dispatch("1624973003", new Object[]{this});
            return;
        }
        int size = this.images.size();
        this.multiImageLoadTotal = size;
        this.multiImageLoadCounter = 0;
        int blockW = getBlockW(42);
        if (this.singleW > -1 && this.singleH > -1 && size == 1) {
            blockW *= 2;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i = this.rows;
        layoutParams.height = (blockW * i) + (this.gap * (i - 1));
        layoutParams.width = this.totalWidth;
        setLayoutParams(layoutParams);
        Log.d("grid", " params: " + layoutParams.width + " , " + layoutParams.height);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ClickGrayImageView) {
                ClickGrayImageView clickGrayImageView = (ClickGrayImageView) childAt;
                clickGrayImageView.setAlwaysLoadImage(this.alwaysLoadImage);
                clickGrayImageView.setShowPlay(this.images.get(i2).isShowPlay());
                clickGrayImageView.setBackgroundResource(R$drawable.transparent);
                if (size == 1) {
                    clickGrayImageView.setSingle(true);
                } else {
                    clickGrayImageView.setSingle(false);
                }
                int[] findPosition = findPosition(i2);
                int i5 = this.gap;
                int i6 = (blockW + i5) * findPosition[1];
                int i7 = (i5 + blockW) * findPosition[0];
                i3 = i6 + blockW;
                int i8 = i7 + blockW;
                Log.d("grid", " layout: " + i6 + " , " + i7 + " , " + i3 + " , " + i8);
                clickGrayImageView.setTag(Integer.valueOf(i2));
                clickGrayImageView.layout(i6, i7, i3, i8);
                i4 = i8;
            } else {
                i2--;
                size--;
            }
            i2++;
        }
        addConerTip(i3, i4);
        for (int i9 = 0; i9 < size; i9++) {
            View childAt2 = getChildAt(i9);
            if (childAt2 instanceof ClickGrayImageView) {
                ((ClickGrayImageView) childAt2).setImageUrl(this.images.get(i9).getUrl(), this.imageSuccListener, this.imageFailListener);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "355812682")) {
            ipChange.ipc$dispatch("355812682", new Object[]{this, canvas});
            return;
        }
        if (this.childBoundClipRadius > 0) {
            canvas.save();
            ensureClipPath();
            Path path = this.mPath;
            if (path != null) {
                canvas.clipPath(path);
            }
        } else {
            z = false;
        }
        super.dispatchDraw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    public int getGap() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-50398868") ? ((Integer) ipChange.ipc$dispatch("-50398868", new Object[]{this})).intValue() : this.gap;
    }

    public Bitmap getNewBitmap(Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-200136532")) {
            return (Bitmap) ipChange.ipc$dispatch("-200136532", new Object[]{this, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public int getRadius() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1023989060") ? ((Integer) ipChange.ipc$dispatch("-1023989060", new Object[]{this})).intValue() : this.radius;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-933507580")) {
            ipChange.ipc$dispatch("-933507580", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "206743634")) {
            ipChange.ipc$dispatch("206743634", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        Log.d("onMeasure", " onMeasure w: " + i);
    }

    public void setAlwaysLoadImage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1364744927")) {
            ipChange.ipc$dispatch("1364744927", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.alwaysLoadImage = z;
        }
    }

    public void setAutoShrink(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2084577987")) {
            ipChange.ipc$dispatch("-2084577987", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.autoShrink = z;
        }
    }

    public void setChildBoundClipRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1419601592")) {
            ipChange.ipc$dispatch("1419601592", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.childBoundClipRadius = i;
        invalidate();
    }

    public void setGap(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374470174")) {
            ipChange.ipc$dispatch("374470174", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.gap = i;
        }
    }

    public void setHandleSinglePic(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1385317133")) {
            ipChange.ipc$dispatch("-1385317133", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.handleSinglePic = z;
        }
    }

    public void setListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735108866")) {
            ipChange.ipc$dispatch("-735108866", new Object[]{this, onClickListener});
        } else {
            this.listener = onClickListener;
        }
    }

    public void setOnImageLoadListener(OnImageLoadFinishListener onImageLoadFinishListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681688373")) {
            ipChange.ipc$dispatch("-681688373", new Object[]{this, onImageLoadFinishListener});
        } else {
            this.imageLoadFinishListener = onImageLoadFinishListener;
        }
    }

    public void setRadius(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-904728730")) {
            ipChange.ipc$dispatch("-904728730", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.radius = i;
        }
    }

    public void setSingleWH(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1974607286")) {
            ipChange.ipc$dispatch("1974607286", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.singleH = i2;
        this.singleW = i;
    }

    public void setTotalWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-387226442")) {
            ipChange.ipc$dispatch("-387226442", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.totalWidth = i;
        }
    }

    public void updateImages(List<Image> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1168863945")) {
            ipChange.ipc$dispatch("1168863945", new Object[]{this, list});
        } else if (list == null || list.isEmpty()) {
        } else {
            this.realSize = list.size();
            if (this.autoShrink && list.size() > 3) {
                list = list.subList(0, 3);
            }
            Log.d("onMeasure", " updateImages w: " + getMeasuredWidth());
            initChild(list.size());
            Log.d("grid", " row: " + this.rows + ", col :" + this.columns);
            if (this.handleSinglePic && list.size() == 1 && list.get(0) != null && !TextUtils.isEmpty(list.get(0).url)) {
                removeAllViews();
                this.images = null;
                setBackgroundResource(R$drawable.uikit_default_image_bg_grey);
                fixSingleImg(list);
                setOnClickListener(new a());
                return;
            }
            setBackground(null);
            fixMutiImgs(list);
            this.images = list;
            layoutChildrenView();
            setOnClickListener(null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Image implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public int imgH;
        public int imgW;
        private boolean showPlay;
        private String url;

        public Image(String str) {
            this.showPlay = false;
            this.url = str;
            Log.i(BizTime.IMAGE, toString());
        }

        public String getUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1687055319") ? (String) ipChange.ipc$dispatch("-1687055319", new Object[]{this}) : this.url;
        }

        public boolean isShowPlay() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "675576761") ? ((Boolean) ipChange.ipc$dispatch("675576761", new Object[]{this})).booleanValue() : this.showPlay;
        }

        public void setShowPlay(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "360425805")) {
                ipChange.ipc$dispatch("360425805", new Object[]{this, Boolean.valueOf(z)});
            } else {
                this.showPlay = z;
            }
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2045002652")) {
                return (String) ipChange.ipc$dispatch("2045002652", new Object[]{this});
            }
            return " image---->> url = " + this.url;
        }

        public Image(String str, boolean z) {
            this.showPlay = false;
            this.url = str;
            this.showPlay = z;
            Log.i(BizTime.IMAGE, toString());
        }
    }

    public NineGridlayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gap = 5;
        this.radius = 0;
        this.autoShrink = false;
        this.handleSinglePic = false;
        this.multiImageLoadCounter = 0;
        this.multiImageLoadTotal = 0;
        this.alwaysLoadImage = false;
        this.childBoundClipRadius = 0;
        this.mRectF = new RectF();
        this.mTempRectF = new RectF();
        this.imageSuccListener = new c();
        this.imageFailListener = new d();
        Log.d("onMeasure", " NineGridlayout w: " + getMeasuredWidth());
    }
}
