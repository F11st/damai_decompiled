package com.youku.resource.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.css.dto.Css;
import com.youku.css.setter.ICssSetter2;
import com.youku.css.util.ColorUtil;
import com.youku.resource.R;
import com.youku.resource.utils.ColorConfigureManager;
import com.youku.resource.utils.DynamicColorDefine;
import com.youku.resource.utils.TextLine;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TagsView extends View implements ICssSetter2 {
    private static final String ELLIPSIZE_TEXT = "…";
    private static final String TAG = "TagsView";
    private static int sDefaultFontPadding = 0;
    private static int sDefaultStrokeColor = 0;
    private static int sDefaultStrokeRadius = -1;
    private static int sDefaultStrokeWidth = 0;
    private static int sDefaultTagInterval = 0;
    private static int sDefaultTextColor = 0;
    private static int sDefaultTextSize = -1;
    private float mClickX;
    private float mEllipsizeWidth;
    protected int mFontPadding;
    protected int mFontPaddingEnd;
    protected int mFontPaddingStart;
    protected int mStrokeColor;
    private Paint mStrokePaint;
    protected int mStrokeRadius;
    protected int mStrokeWidth;
    private OnTagClickListener mTagClickListener;
    protected int mTagInterval;
    protected List<String> mTags;
    protected int[] mTagsEnd;
    protected int mTextColor;
    private Paint.FontMetrics mTextFontMetrics;
    private TextPaint mTextPaint;
    protected int mTextSize;
    private float[] mTextWidth;
    private TextLine mTmpLine;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface OnTagClickListener {
        void onTagClicked(View view, int i);
    }

    public TagsView(Context context) {
        this(context, null);
    }

    private int drawTag(Canvas canvas, String str, int i) {
        int i2;
        Paint.FontMetrics textFontMetrics = getTextFontMetrics();
        float f = textFontMetrics.descent - textFontMetrics.ascent;
        float measuredHeight = getMeasuredHeight();
        float drawTagText = drawTagText(canvas, str, i, (int) (((measuredHeight - f) - (this.mStrokeWidth << 1)) / 2.0f));
        if (drawTagText <= 0.0f) {
            return 0;
        }
        Paint strokePaint = getStrokePaint();
        float f2 = i + drawTagText + (i2 << 1) + this.mFontPaddingStart + this.mFontPaddingEnd;
        int i3 = this.mStrokeWidth >> 1;
        if (Build.VERSION.SDK_INT >= 21) {
            float f3 = i3;
            float f4 = measuredHeight - f3;
            int i4 = this.mStrokeRadius;
            canvas.drawRoundRect(i + i3, i3 + 0, f2 - f3, f4, i4, i4, strokePaint);
        } else {
            float f5 = i3;
            canvas.drawRect(i + i3, i3 + 0, f2 - f5, measuredHeight - f5, strokePaint);
        }
        return ((int) drawTagText) + this.mTagInterval + (this.mStrokeWidth << 1) + this.mFontPaddingStart + this.mFontPaddingEnd;
    }

    private float drawTagText(Canvas canvas, String str, int i, int i2) {
        int i3;
        int i4;
        TextPaint textPaint = getTextPaint();
        float measuredWidth = ((getMeasuredWidth() - i) - (this.mStrokeWidth << 1)) - (this.mFontPaddingStart + this.mFontPaddingEnd);
        int breakText = textPaint.breakText(str, true, measuredWidth, this.mTextWidth);
        float f = 0.0f;
        if (breakText <= 0) {
            return 0.0f;
        }
        Paint.FontMetrics textFontMetrics = getTextFontMetrics();
        if (breakText < str.length()) {
            TextLine textLine = this.mTmpLine;
            textLine.size = 0;
            textLine.appendChars(str, 0, breakText);
            float tagEllipsizeWidth = getTagEllipsizeWidth();
            if (this.mTextWidth[0] + tagEllipsizeWidth > measuredWidth) {
                TextLine textLine2 = this.mTmpLine;
                int i5 = textLine2.size;
                textLine2.removeEndingChar();
                f = textPaint.measureText(str, this.mTmpLine.size, i5);
            }
            float[] fArr = this.mTextWidth;
            fArr[0] = fArr[0] + (tagEllipsizeWidth - f);
            this.mTmpLine.appendChar(ELLIPSIZE_TEXT, 0);
            TextLine textLine3 = this.mTmpLine;
            canvas.drawText(textLine3.text, 0, textLine3.size, i + i4 + this.mFontPaddingStart, (this.mStrokeWidth - textFontMetrics.ascent) + i2, textPaint);
        } else {
            canvas.drawText(str, 0, breakText, i + i3 + this.mFontPaddingStart, (this.mStrokeWidth - textFontMetrics.ascent) + i2, (Paint) textPaint);
        }
        return this.mTextWidth[0];
    }

    private void ensureTagsWidth(int i) {
        if (this.mTagsEnd.length < i) {
            this.mTagsEnd = new int[i];
        }
    }

    private Paint getStrokePaint() {
        if (this.mStrokePaint == null) {
            Paint paint = new Paint();
            this.mStrokePaint = paint;
            paint.setAntiAlias(true);
            this.mStrokePaint.setColor(this.mStrokeColor);
            this.mStrokePaint.setStyle(Paint.Style.STROKE);
            this.mStrokePaint.setStrokeWidth(this.mStrokeWidth);
        }
        return this.mStrokePaint;
    }

    private float getTagEllipsizeWidth() {
        if (this.mEllipsizeWidth <= 0.0f) {
            this.mEllipsizeWidth = getTextPaint().measureText(ELLIPSIZE_TEXT);
        }
        return this.mEllipsizeWidth;
    }

    private List<String> getTagsList() {
        if (this.mTags == null) {
            this.mTags = new ArrayList(4);
        }
        return this.mTags;
    }

    private Paint.FontMetrics getTextFontMetrics() {
        if (this.mTextFontMetrics == null) {
            this.mTextFontMetrics = getTextPaint().getFontMetrics();
        }
        return this.mTextFontMetrics;
    }

    private TextPaint getTextPaint() {
        if (this.mTextPaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mTextPaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mTextPaint.setColor(this.mTextColor);
            this.mTextPaint.setTextSize(this.mTextSize);
        }
        return this.mTextPaint;
    }

    private void initClickListener() {
    }

    private void initProps(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TagsView, 0, 0);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagsView_textSize, sDefaultTextSize);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.TagsView_textColor, sDefaultTextColor);
        this.mStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagsView_strokeWidth, sDefaultStrokeWidth);
        this.mStrokeRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagsView_strokeRadius, sDefaultStrokeRadius);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.TagsView_strokeColor, sDefaultStrokeColor);
        this.mTagInterval = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagsView_tagInterval, sDefaultTagInterval);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagsView_fontPadding, sDefaultFontPadding);
        this.mFontPadding = dimensionPixelSize;
        this.mFontPaddingStart = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagsView_fontPaddingStart, dimensionPixelSize);
        this.mFontPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagsView_fontPaddingEnd, this.mFontPadding);
        obtainStyledAttributes.recycle();
    }

    private void initValues(@NonNull Context context, AttributeSet attributeSet) {
        if (sDefaultTextSize > 0) {
            return;
        }
        Resources resources = context.getResources();
        sDefaultTextSize = resources.getDimensionPixelSize(R.dimen.resource_size_10);
        sDefaultTextColor = ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_TERTIARY_INFO).intValue();
        float f = resources.getDisplayMetrics().density;
        int i = (int) ((0.5f * f) + 0.5d);
        sDefaultStrokeWidth = i;
        if (i < 1) {
            sDefaultStrokeWidth = 1;
        }
        int i2 = (int) ((2.0f * f) + 0.5d);
        sDefaultStrokeRadius = i2;
        sDefaultStrokeColor = ColorConfigureManager.getInstance().getColorMap().get(DynamicColorDefine.YKN_QUATERNARY_INFO).intValue();
        sDefaultTagInterval = (int) ((f * 3.0f) + 0.5d);
        sDefaultFontPadding = i2;
    }

    public void addTag(String str) {
        getTagsList().add(str);
    }

    public void clearTags() {
        List<String> list = this.mTags;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        List<String> list = this.mTags;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = this.mTags.size();
        ensureTagsWidth(size);
        int paddingLeft = getPaddingLeft();
        for (int i = 0; i < size; i++) {
            String str = this.mTags.get(i);
            if (str != null) {
                int drawTag = drawTag(canvas, str, paddingLeft);
                if (drawTag <= 0) {
                    return;
                }
                paddingLeft += drawTag;
                this.mTagsEnd[i] = paddingLeft - (this.mTagInterval >> 1);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            this.mClickX = motionEvent.getX();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.youku.css.setter.ICssSetter2
    public void resetCss(String str) {
        setTagTextColor(sDefaultTextColor);
        setStrokeColor(sDefaultStrokeColor);
    }

    @Override // com.youku.css.setter.ICssSetter
    public void setCss(String str, Css css) {
        int parseColorSafely;
        if (css == null || TextUtils.isEmpty(css.color) || (parseColorSafely = ColorUtil.parseColorSafely(css.color, this.mTextColor)) == 0) {
            return;
        }
        setTagTextColor(parseColorSafely);
        setStrokeColor(parseColorSafely);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        throw new UnsupportedOperationException("Please use setOnTagClickListener instead.");
    }

    public void setOnTagClickListener(OnTagClickListener onTagClickListener) {
        this.mTagClickListener = onTagClickListener;
    }

    public void setStrokeColor(int i) {
        if (i == 0) {
            i = sDefaultStrokeColor;
        }
        if (i == this.mStrokeColor) {
            return;
        }
        this.mStrokeColor = i;
        Paint paint = this.mStrokePaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setTagTextColor(int i) {
        if (i == 0) {
            i = sDefaultTextColor;
        }
        if (i == this.mTextColor) {
            return;
        }
        this.mTextColor = i;
        TextPaint textPaint = this.mTextPaint;
        if (textPaint != null) {
            textPaint.setColor(i);
        }
    }

    public TagsView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTagsEnd = new int[4];
        this.mTextWidth = new float[1];
        this.mEllipsizeWidth = -1.0f;
        this.mTmpLine = new TextLine();
        this.mClickX = -1.0f;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
        initClickListener();
    }

    public TagsView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTagsEnd = new int[4];
        this.mTextWidth = new float[1];
        this.mEllipsizeWidth = -1.0f;
        this.mTmpLine = new TextLine();
        this.mClickX = -1.0f;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
        initClickListener();
    }
}
