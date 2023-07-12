package com.youku.resource.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Css;
import com.youku.css.setter.CssSetter;
import com.youku.css.setter.ICssSetter2;
import com.youku.css.util.ColorUtil;
import com.youku.resource.R;
import com.youku.resource.utils.TextLine;
import com.youku.resource.utils.Utils;
import tb.ui2;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DoubleFeedTagWidget extends View implements ICssSetter2 {
    private static final String ELLIPSIZE_TEXT = "…";
    private static final int LINE_INDEX_TITLE = 0;
    private static final String TAG = "DoubleFeedTagWidget";
    private static Drawable arrowDrawable = null;
    private static float baseline = 0.0f;
    private static int height = 0;
    private static Rect iconRect = null;
    private static int imageHeight = 0;
    private static int imageWidth = 0;
    private static int mBgColor = 0;
    private static Paint mBgPaint = null;
    private static int maxTitleWidth = 0;
    private static int sDefaultPadding = 0;
    private static int sDefaultTitleTextColor = 0;
    private static int sDefaultTitleTextSize = -1;
    private static int textXOffset;
    private Drawable drawable;
    private TextLine[] mLines;
    private int[] mLinesWidth;
    private float[] mTextWidth;
    protected String mTitle;
    private float mTitleEllipsizeWidth;
    private Paint.FontMetrics mTitleFontMetrics;
    private TextPaint mTitlePaint;
    private int mTitleStartPadding;
    private int mTitleTextColor;
    private int mTitleTextSize;

    public DoubleFeedTagWidget(@NonNull Context context) {
        this(context, null);
    }

    private boolean calculateLine(int i, TextPaint textPaint, String str, int i2, float f) {
        float measureText;
        if (i <= 0) {
            i = maxTitleWidth;
        }
        if (i > 0 && !TextUtils.isEmpty(str)) {
            float f2 = i;
            int breakText = textPaint.breakText(str, true, f2, this.mTextWidth);
            if (breakText == str.length()) {
                this.mLinesWidth[i2] = (int) this.mTextWidth[0];
                return true;
            }
            TextLine line = getLine(i2);
            line.size = 0;
            if (this.mTextWidth[0] + f <= f2) {
                line.appendChars(str, 0, breakText);
                measureText = 0.0f;
            } else {
                int i3 = breakText - 1;
                line.appendChars(str, 0, i3);
                measureText = textPaint.measureText(str, i3, breakText);
            }
            if (f > 0.0f) {
                line.appendChar(ELLIPSIZE_TEXT, 0);
                this.mLinesWidth[i2] = (int) ((this.mTextWidth[0] + f) - measureText);
            } else {
                this.mLinesWidth[i2] = (int) this.mTextWidth[0];
            }
            return false;
        }
        getLine(i2).size = 0;
        this.mLinesWidth[i2] = 0;
        return false;
    }

    private boolean calculateTitleLine(int i, boolean z) {
        return calculateLine(i, this.mTitlePaint, this.mTitle, 0, z ? getTitleEllipsizeWidth() : 0.0f);
    }

    private void drawArrow(Canvas canvas) {
        Drawable drawable = arrowDrawable;
        int[] iArr = this.mLinesWidth;
        int i = iArr[0];
        int i2 = textXOffset;
        int i3 = height;
        int i4 = sDefaultPadding;
        int measuredHeight = getMeasuredHeight();
        int i5 = sDefaultPadding;
        drawable.setBounds(i + i2, (i3 - i4) / 2, i2 + iArr[0] + i4, ((measuredHeight - i5) / 2) + i5);
        arrowDrawable.draw(canvas);
    }

    private void drawIcon(Canvas canvas) {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            drawable.setBounds(iconRect);
            this.drawable.draw(canvas);
            return;
        }
        canvas.drawRect(iconRect, mBgPaint);
    }

    private void drawOneLineTitle(Canvas canvas, Paint paint, float f) {
        if (calculateTitleLine(-1, true)) {
            canvas.drawText(this.mTitle, textXOffset, f, paint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[0].size > 0) {
            canvas.drawText(textLineArr[0].text, 0, textLineArr[0].size, textXOffset, f, paint);
        }
    }

    private void drawTitle(Canvas canvas) {
        if (TextUtils.isEmpty(this.mTitle)) {
            return;
        }
        drawOneLineTitle(canvas, initTitlePaint(), baseline);
    }

    private TextLine getLine(int i) {
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[i] == null) {
            textLineArr[i] = new TextLine();
        }
        return this.mLines[i];
    }

    private float getTitleEllipsizeWidth() {
        if (this.mTitleEllipsizeWidth <= 0.0f) {
            this.mTitleEllipsizeWidth = this.mTitlePaint.measureText(ELLIPSIZE_TEXT);
        }
        return this.mTitleEllipsizeWidth;
    }

    private Paint.FontMetrics getTitleFontMetrics() {
        if (this.mTitleFontMetrics == null) {
            this.mTitleFontMetrics = this.mTitlePaint.getFontMetrics();
        }
        return this.mTitleFontMetrics;
    }

    private Paint initBgPaint() {
        if (mBgPaint == null) {
            mBgPaint = new Paint();
        }
        int color = mBgPaint.getColor();
        int i = mBgColor;
        if (color != i) {
            mBgPaint.setColor(i);
        }
        return mBgPaint;
    }

    private Rect initIconRect() {
        if (iconRect == null) {
            int i = height;
            int i2 = imageHeight;
            iconRect = new Rect(0, (i - i2) / 2, imageWidth, ((i - i2) / 2) + i2);
        }
        return iconRect;
    }

    private void initProps(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PhoneCommonTitlesWidget, 0, 0);
        this.mTitleTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_titleTextSize, sDefaultTitleTextSize);
        this.mTitleTextColor = obtainStyledAttributes.getColor(R.styleable.PhoneCommonTitlesWidget_titleTextColor, sDefaultTitleTextColor);
        obtainStyledAttributes.recycle();
        initTitlePaint();
        initBgPaint();
        Paint.FontMetrics titleFontMetrics = getTitleFontMetrics();
        float f = titleFontMetrics.bottom;
        float f2 = f - titleFontMetrics.top;
        float f3 = (f2 / 2.0f) - f;
        int i = (int) (f2 + (sDefaultPadding * 2));
        height = i;
        baseline = (i / 2) + f3;
        initIconRect();
        mBgColor = getResources().getColor(R.C8071color.ykn_primary_fill_color);
    }

    private TextPaint initTitlePaint() {
        if (this.mTitlePaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mTitlePaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mTitlePaint.setColor(this.mTitleTextColor);
            this.mTitlePaint.setTextSize(this.mTitleTextSize);
        }
        return this.mTitlePaint;
    }

    private void initValues(@NonNull Context context, AttributeSet attributeSet) {
        if (sDefaultTitleTextSize <= 0 || sDefaultTitleTextColor != getResources().getColor(R.C8071color.ykn_primary_info)) {
            Resources resources = context.getResources();
            int i = R.dimen.resource_size_12;
            sDefaultTitleTextSize = resources.getDimensionPixelSize(i);
            sDefaultTitleTextColor = resources.getColor(R.C8071color.ykn_primary_info);
            sDefaultPadding = resources.getDimensionPixelOffset(i);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.resource_size_21);
            imageHeight = dimensionPixelSize;
            imageWidth = dimensionPixelSize;
            textXOffset = resources.getDimensionPixelSize(R.dimen.resource_size_24);
            arrowDrawable = getResources().getDrawable(R.C8072drawable.double_feed_tag_arrow);
        }
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        drawIcon(canvas);
        drawTitle(canvas);
        drawArrow(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        maxTitleWidth = (size - imageWidth) - sDefaultPadding;
        setMeasuredDimension(size, height);
    }

    @Override // com.youku.css.setter.ICssSetter2
    public void resetCss(String str) {
        int resetColor = CssSetter.resetColor(this, R.id.tag_css_color);
        if (resetColor != 0) {
            setTitleTextColor(resetColor);
        }
    }

    @Override // com.youku.css.setter.ICssSetter
    public void setCss(String str, Css css) {
        str.hashCode();
        if (str.equals(CssConst.CssScenes.CARD_FOOTER_TITLE)) {
            CssSetter.saveColor(this, R.id.tag_css_color, this.mTitleTextColor);
            setTitleTextColor(ColorUtil.parseColorSafely(css.color, this.mTitleTextColor));
            arrowDrawable.setColorFilter(ColorUtil.parseColorSafely(css.color), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setLeftIcon(String str, int i, final int i2, final int i3) {
        ur1.o().s(str).Q(new IPhenixListener<ui2>() { // from class: com.youku.resource.widget.DoubleFeedTagWidget.1
            @Override // com.taobao.phenix.intf.event.IPhenixListener
            public boolean onHappen(ui2 ui2Var) {
                if (ui2Var.f() == null || ui2Var.i()) {
                    return true;
                }
                DoubleFeedTagWidget.this.drawable = Utils.zoomDrawable(ui2Var.f(), DoubleFeedTagWidget.this.getResources(), i2, i3);
                DoubleFeedTagWidget.this.postInvalidate(DoubleFeedTagWidget.iconRect.left, DoubleFeedTagWidget.iconRect.top, DoubleFeedTagWidget.iconRect.right, DoubleFeedTagWidget.iconRect.bottom);
                return true;
            }
        }).n();
    }

    public void setTitle(String str) {
        if (TextUtils.equals(str, this.mTitle)) {
            return;
        }
        this.mTitle = str;
        invalidate();
    }

    public void setTitleTextColor(int i) {
        if (i == 0) {
            i = sDefaultTitleTextColor;
        }
        if (i == this.mTitleTextColor) {
            return;
        }
        this.mTitleTextColor = i;
        TextPaint textPaint = this.mTitlePaint;
        if (textPaint != null) {
            textPaint.setColor(i);
        }
    }

    public DoubleFeedTagWidget(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleFeedTagWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleStartPadding = 0;
        this.mLines = new TextLine[3];
        this.mLinesWidth = new int[3];
        this.mTextWidth = new float[1];
        this.mTitleEllipsizeWidth = -1.0f;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
    }

    public DoubleFeedTagWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTitleStartPadding = 0;
        this.mLines = new TextLine[3];
        this.mLinesWidth = new int[3];
        this.mTextWidth = new float[1];
        this.mTitleEllipsizeWidth = -1.0f;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
    }
}
