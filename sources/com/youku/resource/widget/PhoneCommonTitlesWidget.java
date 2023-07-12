package com.youku.resource.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import com.youku.css.constraint.CssConst;
import com.youku.css.dto.Css;
import com.youku.css.setter.ICssSetter2;
import com.youku.css.util.ColorUtil;
import com.youku.resource.R;
import com.youku.resource.utils.AppPerfABUtils;
import com.youku.resource.utils.TextLine;
import com.youku.uplayer.AliMediaPlayer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PhoneCommonTitlesWidget extends View implements ICssSetter2 {
    private static final String ELLIPSIZE_TEXT = "…";
    private static final int GRAVITY_CENTER = 2;
    private static final int GRAVITY_END = 3;
    private static final int GRAVITY_START = 1;
    private static final int LINE_INDEX_SUBTITLE = 1;
    private static final int LINE_INDEX_SUBTITLE_PREFIX = 2;
    private static final int LINE_INDEX_TITLE = 0;
    private static final int LINE_INDEX_TITLE_PREFIX = 3;
    private static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;
    private static final int STYLE_NORMAL = 0;
    private static final String TAG = "PhoneCommonTitles";
    private static int mStrokeRadius = 0;
    private static int mTitlePrefixPadding = 0;
    private static int mTitlePrefixTextSize = 0;
    private static int sDefaultSubtitleHeight = 0;
    private static int sDefaultSubtitleTextColor = 0;
    private static int sDefaultSubtitleTextSize = 0;
    private static int sDefaultSubtitleTopPadding = 0;
    private static int sDefaultTitleHeight = 0;
    private static int sDefaultTitleTextColor = 0;
    private static int sDefaultTitleTextSize = -1;
    private static int sDefaultTitleTopPadding;
    private static boolean sIsDegrade;
    private boolean mAutoShrinkSubtitle;
    private boolean mHasMeasuredTitle;
    private int mHorizontalGravity;
    private boolean mIsSingleLineTitle;
    private TextLine[] mLines;
    private int[] mLinesWidth;
    private boolean mNeedShowSubtitle;
    protected String mSubtitle;
    private float mSubtitleEllipsizeWidth;
    private int mSubtitleHeight;
    private TextPaint mSubtitlePaint;
    protected String mSubtitlePrefix;
    private TextPaint mSubtitlePrefixPaint;
    protected int mSubtitlePrefixStyle;
    protected int mSubtitlePrefixTextColor;
    protected int mSubtitlePrefixTextSize;
    private int mSubtitleStartPadding;
    private int mSubtitleStyle;
    private int mSubtitleTextColor;
    private int mSubtitleTextSize;
    private int mSubtitleTopPadding;
    private float[] mTextWidth;
    protected String mTitle;
    private float mTitleEllipsizeWidth;
    private Paint.FontMetrics mTitleFontMetrics;
    private int mTitleHeight;
    private int mTitleLines;
    private TextPaint mTitlePaint;
    protected String mTitlePrefix;
    private TextPaint mTitlePrefixBgPaint;
    private Paint.FontMetrics mTitlePrefixFontMetrics;
    protected int mTitlePrefixTextColor;
    private TextPaint mTitlePrefixTextPaint;
    private int mTitleStartPadding;
    private int mTitleStyle;
    private int mTitleTextColor;
    private int mTitleTextSize;
    private int mTitleTopPadding;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class SubtitleAreaDisplayStatus {
        boolean autoShrinkSubtitle;
        boolean isSingleLineTitle;
        boolean needShowSubtitle;
        String subtitle;
    }

    public PhoneCommonTitlesWidget(@NonNull Context context) {
        this(context, null);
    }

    private boolean calculateLine(int i, TextPaint textPaint, String str, int i2, int i3, float f) {
        float f2;
        if (i <= 0) {
            i = getMeasuredWidth();
        }
        int i4 = i - i3;
        if (i4 > 0 && !TextUtils.isEmpty(str)) {
            float f3 = i4;
            int breakText = textPaint.breakText(str, true, f3, this.mTextWidth);
            if (breakText != str.length() && breakText != 0) {
                TextLine line = getLine(i2);
                line.size = 0;
                if (this.mTextWidth[0] + f <= f3) {
                    line.appendChars(str, 0, breakText);
                    f2 = 0.0f;
                } else {
                    f2 = 0.0f;
                    int i5 = 0;
                    while ((this.mTextWidth[0] - f2) + f > f3) {
                        f2 += textPaint.measureText(str, (breakText - 1) - i5, breakText - i5);
                        i5++;
                        if (breakText <= i5) {
                            break;
                        }
                    }
                    line.appendChars(str, 0, breakText - i5);
                }
                if (f > 0.0f) {
                    line.appendChar(ELLIPSIZE_TEXT, 0);
                    this.mLinesWidth[i2] = (int) ((this.mTextWidth[0] + f) - f2);
                } else {
                    this.mLinesWidth[i2] = (int) this.mTextWidth[0];
                }
                return false;
            }
            this.mLinesWidth[i2] = (int) this.mTextWidth[0];
            return true;
        }
        getLine(i2).size = 0;
        this.mLinesWidth[i2] = 0;
        return false;
    }

    private boolean calculateSubtitleLine(int i, int i2) {
        return calculateLine(i, getSubtitlePaint(), this.mSubtitle, 1, this.mSubtitleStartPadding + i2, getSubtitleEllipsizeWidth());
    }

    private boolean calculateTitleLine(int i, boolean z) {
        return calculateLine(i, getTitlePaint(), this.mTitle, 0, this.mTitleStartPadding, z ? getTitleEllipsizeWidth() : 0.0f);
    }

    private void drawOneLineTitle(Canvas canvas, Paint paint, Paint.FontMetrics fontMetrics, float f) {
        if ((sIsDegrade && this.mHorizontalGravity == 1) || calculateTitleLine(-1, true)) {
            canvas.drawText(this.mTitle, this.mTitleStartPadding + getTitleXOffset(0), f, paint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[0].size > 0) {
            canvas.drawText(textLineArr[0].text, 0, textLineArr[0].size, this.mTitleStartPadding + getTitleXOffset(0), f, paint);
        }
    }

    private void drawOneLineTitleWithPrefix(Canvas canvas, Paint paint, Paint.FontMetrics fontMetrics, float f) {
        if ((sIsDegrade && this.mHorizontalGravity == 1) || calculateTitleLine(getMeasuredWidth() - getTitlePrefixOffset(), true)) {
            canvas.drawText(this.mTitle, this.mTitleStartPadding + getTitlePrefixOffset(), f, paint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[0].size > 0) {
            canvas.drawText(textLineArr[0].text, 0, textLineArr[0].size, this.mTitleStartPadding + getTitlePrefixOffset(), f, paint);
        }
    }

    private void drawSubtitle(Canvas canvas) {
        int drawSubtitlePrefix = !TextUtils.isEmpty(this.mSubtitlePrefix) ? drawSubtitlePrefix(canvas) : 0;
        if (!this.mNeedShowSubtitle || TextUtils.isEmpty(this.mSubtitle)) {
            return;
        }
        TextPaint subtitlePaint = getSubtitlePaint();
        float f = ((this.mTitleTopPadding + this.mTitleHeight) + this.mSubtitleTopPadding) - subtitlePaint.getFontMetrics().ascent;
        if ((sIsDegrade && this.mHorizontalGravity == 1) || calculateSubtitleLine(-1, drawSubtitlePrefix)) {
            canvas.drawText(this.mSubtitle, this.mSubtitleStartPadding + drawSubtitlePrefix + getSubtitleXOffset(), f, subtitlePaint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        canvas.drawText(textLineArr[1].text, 0, textLineArr[1].size, this.mSubtitleStartPadding + drawSubtitlePrefix + getSubtitleXOffset(), f, subtitlePaint);
    }

    private int drawSubtitlePrefix(Canvas canvas) {
        TextPaint subtitlePrefixPaint = getSubtitlePrefixPaint();
        float f = ((this.mTitleTopPadding + this.mTitleHeight) + this.mSubtitleTopPadding) - subtitlePrefixPaint.getFontMetrics().ascent;
        if (calculateLine(-1, subtitlePrefixPaint, this.mSubtitlePrefix, 2, this.mSubtitleStartPadding, 0.0f)) {
            canvas.drawText(this.mSubtitlePrefix, this.mSubtitleStartPadding + getSubtitleXOffset(), f, subtitlePrefixPaint);
        } else {
            TextLine[] textLineArr = this.mLines;
            canvas.drawText(textLineArr[2].text, 0, textLineArr[2].size, this.mSubtitleStartPadding + getSubtitleXOffset(), f, subtitlePrefixPaint);
        }
        return this.mLinesWidth[2];
    }

    private void drawTitle(Canvas canvas) {
        if (TextUtils.isEmpty(this.mTitle)) {
            return;
        }
        TextPaint titlePaint = getTitlePaint();
        Paint.FontMetrics titleFontMetrics = getTitleFontMetrics();
        float f = this.mTitleTopPadding - titleFontMetrics.ascent;
        if (this.mTitleLines == 1) {
            drawOneLineTitle(canvas, titlePaint, titleFontMetrics, f);
        } else {
            drawTwoLineTitles(canvas, titlePaint, titleFontMetrics, f);
        }
    }

    private void drawTitlePrefix(Canvas canvas) {
        float f;
        TextPaint titlePrefixTextPaint = getTitlePrefixTextPaint();
        TextPaint titlePrefixBgPaint = getTitlePrefixBgPaint();
        Paint.FontMetrics titlePrefixFontMetrics = getTitlePrefixFontMetrics();
        Paint.FontMetrics titleFontMetrics = getTitleFontMetrics();
        float f2 = titlePrefixFontMetrics.descent;
        float f3 = titlePrefixFontMetrics.ascent;
        float f4 = f2 - f3;
        int i = (int) (titleFontMetrics.descent - titleFontMetrics.ascent);
        int i2 = (int) ((mStrokeRadius << 1) + f4);
        int i3 = this.mTitleTopPadding;
        int i4 = i3 + ((i - i2) >> 1);
        float f5 = (i3 + ((i - f4) / 2.0f)) - f3;
        if (this.mLinesWidth[3] == 0) {
            calculateLine(getMeasuredWidth(), titlePrefixTextPaint, this.mTitlePrefix, 3, this.mTitleStartPadding + (mTitlePrefixPadding << 1), 0.0f);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            int i5 = this.mTitleStartPadding;
            int i6 = mStrokeRadius;
            f = f5;
            canvas.drawRoundRect(i5, i4, i5 + this.mLinesWidth[3] + (mTitlePrefixPadding << 1), i2 + i4, i6, i6, titlePrefixBgPaint);
        } else {
            f = f5;
            int i7 = this.mTitleStartPadding;
            canvas.drawRect(i7, i4, i7 + this.mLinesWidth[3] + (mTitlePrefixPadding << 1), i2 + i4, titlePrefixBgPaint);
        }
        canvas.drawText(this.mTitlePrefix, this.mSubtitleStartPadding + mTitlePrefixPadding, f, titlePrefixTextPaint);
    }

    private void drawTitleWithPrefix(Canvas canvas) {
        if (!TextUtils.isEmpty(this.mTitlePrefix)) {
            drawTitlePrefix(canvas);
        }
        if (TextUtils.isEmpty(this.mTitle)) {
            return;
        }
        TextPaint titlePaint = getTitlePaint();
        Paint.FontMetrics titleFontMetrics = getTitleFontMetrics();
        float f = this.mTitleTopPadding - titleFontMetrics.ascent;
        if (this.mTitleLines == 1) {
            drawOneLineTitleWithPrefix(canvas, titlePaint, titleFontMetrics, f);
        } else {
            drawTwoLineTitlesWithPrefix(canvas, titlePaint, titleFontMetrics, f);
        }
    }

    private void drawTwoLineTitles(Canvas canvas, Paint paint, Paint.FontMetrics fontMetrics, float f) {
        if (!this.mHasMeasuredTitle) {
            this.mIsSingleLineTitle = calculateTitleLines(-1);
            this.mHasMeasuredTitle = true;
        }
        if (this.mIsSingleLineTitle) {
            canvas.drawText(this.mTitle, this.mTitleStartPadding + getTitleXOffset(0), f, paint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        canvas.drawText(textLineArr[0].text, 0, textLineArr[0].size, this.mTitleStartPadding + getTitleXOffset(0), f, paint);
        TextLine[] textLineArr2 = this.mLines;
        canvas.drawText(textLineArr2[1].text, 0, textLineArr2[1].size, getTitleXOffset(1), ((f + fontMetrics.descent) - fontMetrics.ascent) + fontMetrics.leading, paint);
    }

    private void drawTwoLineTitlesWithPrefix(Canvas canvas, Paint paint, Paint.FontMetrics fontMetrics, float f) {
        if (!this.mHasMeasuredTitle) {
            this.mIsSingleLineTitle = calculateTitleLines(-1, getTitlePrefixOffset());
            this.mHasMeasuredTitle = true;
        }
        if (this.mIsSingleLineTitle) {
            canvas.drawText(this.mTitle, this.mTitleStartPadding + getTitleXOffset(0), f, paint);
            return;
        }
        TextLine[] textLineArr = this.mLines;
        canvas.drawText(textLineArr[0].text, 0, textLineArr[0].size, this.mTitleStartPadding + getTitleXOffset(0) + getTitlePrefixOffset(), f, paint);
        TextLine[] textLineArr2 = this.mLines;
        canvas.drawText(textLineArr2[1].text, 0, textLineArr2[1].size, getTitleXOffset(1), ((f + fontMetrics.descent) - fontMetrics.ascent) + fontMetrics.leading, paint);
    }

    private TextLine getLine(int i) {
        TextLine[] textLineArr = this.mLines;
        if (textLineArr[i] == null) {
            textLineArr[i] = new TextLine();
        }
        return this.mLines[i];
    }

    private float getSubtitleEllipsizeWidth() {
        if (this.mSubtitleEllipsizeWidth <= 0.0f) {
            this.mSubtitleEllipsizeWidth = this.mSubtitlePaint.measureText(ELLIPSIZE_TEXT);
        }
        return this.mSubtitleEllipsizeWidth;
    }

    private TextPaint getSubtitlePaint() {
        if (this.mSubtitlePaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mSubtitlePaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mSubtitlePaint.setColor(this.mSubtitleTextColor);
            this.mSubtitlePaint.setTextSize(this.mSubtitleTextSize);
            this.mSubtitlePaint.setTypeface(getTypeface(this.mSubtitleStyle));
        }
        return this.mSubtitlePaint;
    }

    private TextPaint getSubtitlePrefixPaint() {
        if (this.mSubtitlePrefixPaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mSubtitlePrefixPaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mSubtitlePrefixPaint.setColor(this.mSubtitlePrefixTextColor);
            this.mSubtitlePrefixPaint.setTextSize(this.mSubtitlePrefixTextSize);
            this.mSubtitlePrefixPaint.setTypeface(getTypeface(this.mSubtitlePrefixStyle));
        }
        return this.mSubtitlePrefixPaint;
    }

    private int getSubtitleXOffset() {
        int i = this.mHorizontalGravity;
        if (i == 2) {
            int measuredWidth = getMeasuredWidth() - this.mSubtitleStartPadding;
            int[] iArr = this.mLinesWidth;
            return ((measuredWidth - iArr[1]) - iArr[2]) / 2;
        } else if (i != 3) {
            return 0;
        } else {
            int measuredWidth2 = getMeasuredWidth() - this.mSubtitleStartPadding;
            int[] iArr2 = this.mLinesWidth;
            return (measuredWidth2 - iArr2[1]) - iArr2[2];
        }
    }

    private float getTitleEllipsizeWidth() {
        if (this.mTitleEllipsizeWidth <= 0.0f) {
            this.mTitleEllipsizeWidth = this.mTitlePaint.measureText(ELLIPSIZE_TEXT);
        }
        return this.mTitleEllipsizeWidth;
    }

    private Paint.FontMetrics getTitleFontMetrics() {
        if (this.mTitleFontMetrics == null) {
            getTitlePaint();
            this.mTitleFontMetrics = this.mTitlePaint.getFontMetrics();
        }
        return this.mTitleFontMetrics;
    }

    private TextPaint getTitlePaint() {
        if (this.mTitlePaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mTitlePaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mTitlePaint.setColor(this.mTitleTextColor);
            this.mTitlePaint.setTextSize(this.mTitleTextSize);
            this.mTitlePaint.setTypeface(getTypeface(this.mTitleStyle));
        }
        return this.mTitlePaint;
    }

    private TextPaint getTitlePrefixBgPaint() {
        if (this.mTitlePrefixBgPaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mTitlePrefixBgPaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mTitlePrefixBgPaint.setColor(ColorUtils.setAlphaComponent(this.mTitlePrefixTextColor, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD));
        }
        return this.mTitlePrefixBgPaint;
    }

    private Paint.FontMetrics getTitlePrefixFontMetrics() {
        if (this.mTitlePrefixFontMetrics == null) {
            this.mTitlePrefixFontMetrics = this.mTitlePrefixTextPaint.getFontMetrics();
        }
        return this.mTitlePrefixFontMetrics;
    }

    private TextPaint getTitlePrefixTextPaint() {
        if (this.mTitlePrefixTextPaint == null) {
            TextPaint textPaint = new TextPaint();
            this.mTitlePrefixTextPaint = textPaint;
            textPaint.setAntiAlias(true);
            this.mTitlePrefixTextPaint.setTextSize(mTitlePrefixTextSize);
            this.mTitlePrefixTextPaint.setColor(-1);
        }
        return this.mTitlePrefixTextPaint;
    }

    private int getTitleXOffset(int i) {
        int i2 = this.mHorizontalGravity;
        if (i2 != 2) {
            if (i2 != 3) {
                return 0;
            }
            return (getMeasuredWidth() - this.mTitleStartPadding) - this.mLinesWidth[i];
        }
        return ((getMeasuredWidth() - this.mTitleStartPadding) - this.mLinesWidth[i]) / 2;
    }

    private Typeface getTypeface(int i) {
        if (i != 1) {
            if (i != 2) {
                return Typeface.create(Typeface.DEFAULT, 0);
            }
            return Typeface.create(Typeface.DEFAULT, 2);
        }
        return Typeface.create(Typeface.DEFAULT, 1);
    }

    private void initProps(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.mTitleTextSize = sDefaultTitleTextSize;
            int i = sDefaultSubtitleTextSize;
            this.mSubtitleTextSize = i;
            this.mSubtitlePrefixTextSize = i;
            this.mTitleHeight = sDefaultTitleHeight;
            this.mSubtitleHeight = sDefaultSubtitleHeight;
            this.mTitleTextColor = sDefaultTitleTextColor;
            int i2 = sDefaultSubtitleTextColor;
            this.mSubtitleTextColor = i2;
            this.mSubtitlePrefixTextColor = i2;
            this.mSubtitleStartPadding = 0;
            this.mTitleStartPadding = 0;
            this.mTitleTopPadding = sDefaultTitleTopPadding;
            this.mSubtitleTopPadding = sDefaultSubtitleTopPadding;
            this.mSubtitlePrefixStyle = 0;
            this.mSubtitleStyle = 0;
            this.mTitleStyle = 0;
            this.mAutoShrinkSubtitle = false;
            this.mHorizontalGravity = 1;
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PhoneCommonTitlesWidget, 0, 0);
        this.mTitleTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_titleTextSize, sDefaultTitleTextSize);
        this.mSubtitleTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_subtitleTextSize, sDefaultSubtitleTextSize);
        this.mSubtitlePrefixTextSize = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_subtitlePrefixTextSize, sDefaultSubtitleTextSize);
        this.mTitleHeight = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_titleHeight, sDefaultTitleHeight);
        this.mSubtitleHeight = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_subtitleHeight, sDefaultSubtitleHeight);
        this.mTitleTextColor = obtainStyledAttributes.getColor(R.styleable.PhoneCommonTitlesWidget_titleTextColor, sDefaultTitleTextColor);
        this.mSubtitleTextColor = obtainStyledAttributes.getColor(R.styleable.PhoneCommonTitlesWidget_subtitleTextColor, sDefaultSubtitleTextColor);
        this.mSubtitlePrefixTextColor = obtainStyledAttributes.getColor(R.styleable.PhoneCommonTitlesWidget_subtitlePrefixTextColor, sDefaultSubtitleTextColor);
        this.mTitleStartPadding = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_titleStartPadding, 0.0f);
        this.mSubtitleStartPadding = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_subtitleStartPadding, 0.0f);
        this.mTitleTopPadding = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_titleTopPadding, sDefaultTitleTopPadding);
        this.mSubtitleTopPadding = (int) obtainStyledAttributes.getDimension(R.styleable.PhoneCommonTitlesWidget_subtitleTopPadding, sDefaultSubtitleTopPadding);
        this.mTitleStyle = obtainStyledAttributes.getInt(R.styleable.PhoneCommonTitlesWidget_titleStyle, 0);
        this.mSubtitleStyle = obtainStyledAttributes.getInt(R.styleable.PhoneCommonTitlesWidget_subtitleStyle, 0);
        this.mSubtitlePrefixStyle = obtainStyledAttributes.getInt(R.styleable.PhoneCommonTitlesWidget_subtitlePrefixStyle, 0);
        this.mAutoShrinkSubtitle = obtainStyledAttributes.getBoolean(R.styleable.PhoneCommonTitlesWidget_autoShrinkSubtitle, false);
        this.mHorizontalGravity = obtainStyledAttributes.getInt(R.styleable.PhoneCommonTitlesWidget_hGravity, 1);
        obtainStyledAttributes.recycle();
    }

    private void initValues(@NonNull Context context, AttributeSet attributeSet) {
        if (sDefaultTitleTextSize <= 0 || sDefaultTitleTextColor != getResources().getColor(R.color.ykn_primary_info)) {
            Resources resources = context.getResources();
            sDefaultTitleTextSize = resources.getDimensionPixelSize(R.dimen.font_size_middle2);
            sDefaultSubtitleTextSize = resources.getDimensionPixelSize(R.dimen.font_size_middle4);
            float f = resources.getDisplayMetrics().density;
            sDefaultTitleHeight = (int) (17.75f * f);
            sDefaultSubtitleHeight = (int) (f * 14.25d);
            sDefaultTitleTextColor = resources.getColor(R.color.ykn_primary_info);
            sDefaultSubtitleTextColor = resources.getColor(R.color.ykn_tertiary_info);
            sDefaultTitleTopPadding = resources.getDimensionPixelOffset(R.dimen.dim_5);
            sDefaultSubtitleTopPadding = resources.getDimensionPixelOffset(R.dimen.resource_size_4);
            mStrokeRadius = resources.getDimensionPixelSize(R.dimen.resource_size_2);
            mTitlePrefixPadding = resources.getDimensionPixelSize(R.dimen.resource_size_3);
            mTitlePrefixTextSize = resources.getDimensionPixelSize(R.dimen.resource_size_9);
            sIsDegrade = AppPerfABUtils.isOpenDegrade();
        }
    }

    private boolean isNeedTitlePrefix() {
        return TextUtils.isEmpty(this.mSubtitle) && !TextUtils.isEmpty(this.mTitlePrefix);
    }

    private boolean measureTitleFor2Line(int i) {
        return isNeedTitlePrefix() ? measureTitleFor2LineWithPrefix(i) : measureTitleFor2LineNormal(i);
    }

    private boolean measureTitleFor2LineNormal(int i) {
        if (i <= 0) {
            return false;
        }
        if (this.mHasMeasuredTitle) {
            return this.mIsSingleLineTitle;
        }
        boolean calculateTitleLines = calculateTitleLines(i);
        this.mIsSingleLineTitle = calculateTitleLines;
        this.mHasMeasuredTitle = true;
        return calculateTitleLines;
    }

    private boolean measureTitleFor2LineWithPrefix(int i) {
        if (i <= 0) {
            return false;
        }
        if (this.mHasMeasuredTitle) {
            return this.mIsSingleLineTitle;
        }
        calculateLine(i, getTitlePrefixTextPaint(), this.mTitlePrefix, 3, this.mTitleStartPadding + (mTitlePrefixPadding << 1), 0.0f);
        boolean calculateTitleLines = calculateTitleLines(i, getTitlePrefixOffset());
        this.mIsSingleLineTitle = calculateTitleLines;
        this.mHasMeasuredTitle = true;
        return calculateTitleLines;
    }

    public boolean calculateTitleLines(int i) {
        if (calculateTitleLine(i, false) || TextUtils.isEmpty(this.mTitle)) {
            return true;
        }
        int i2 = this.mLines[0].size;
        int length = this.mTitle.length() - i2;
        if (sIsDegrade && this.mHorizontalGravity == 1) {
            TextLine line = getLine(1);
            line.size = 0;
            line.appendChars(this.mTitle, i2, length);
            return false;
        }
        int length2 = this.mTitle.length();
        if (i <= 0) {
            i = getWidth();
        }
        if (i <= 0) {
            getLine(1).size = 0;
            return false;
        }
        float f = i;
        int breakText = this.mTitlePaint.breakText(this.mTitle, i2, length2, true, f, this.mTextWidth);
        TextLine line2 = getLine(1);
        line2.size = 0;
        if (breakText < length) {
            float titleEllipsizeWidth = getTitleEllipsizeWidth();
            float[] fArr = this.mTextWidth;
            if (fArr[0] + titleEllipsizeWidth <= f) {
                this.mLinesWidth[1] = (int) (fArr[0] + titleEllipsizeWidth);
            } else {
                int i3 = breakText - 1;
                this.mLinesWidth[1] = (int) ((fArr[0] + titleEllipsizeWidth) - this.mTitlePaint.measureText(this.mTitle, i3, breakText));
                breakText = i3;
            }
            line2.appendChars(this.mTitle, i2, breakText);
            line2.appendChar(ELLIPSIZE_TEXT, 0);
        } else {
            line2.appendChars(this.mTitle, i2, breakText);
            this.mLinesWidth[1] = (int) this.mTextWidth[0];
        }
        return false;
    }

    public void fillSubtitleAreaDisplayStatus(@NonNull SubtitleAreaDisplayStatus subtitleAreaDisplayStatus) {
        subtitleAreaDisplayStatus.autoShrinkSubtitle = this.mAutoShrinkSubtitle;
        subtitleAreaDisplayStatus.needShowSubtitle = this.mNeedShowSubtitle;
        subtitleAreaDisplayStatus.subtitle = this.mSubtitle;
        boolean z = true;
        if (this.mTitleLines != 1 && !this.mIsSingleLineTitle) {
            z = false;
        }
        subtitleAreaDisplayStatus.isSingleLineTitle = z;
    }

    public boolean getAutoShrinkSubtitle() {
        return this.mAutoShrinkSubtitle;
    }

    public boolean getNeedShowSubtitle() {
        return this.mNeedShowSubtitle;
    }

    public String getSubtitle() {
        return this.mSubtitle;
    }

    public int getSubtitleHeight() {
        return this.mSubtitleHeight;
    }

    public String getSubtitlePrefix() {
        return this.mSubtitlePrefix;
    }

    public int getSubtitlePrefixStyle() {
        return this.mSubtitlePrefixStyle;
    }

    public int getSubtitlePrefixTextColor() {
        return this.mSubtitlePrefixTextColor;
    }

    public int getSubtitleTopPadding() {
        return this.mSubtitleTopPadding;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getTitleHeight() {
        return this.mTitleHeight;
    }

    public int getTitleLines() {
        return this.mTitleLines;
    }

    public int getTitlePrefixOffset() {
        return this.mLinesWidth[3] + (mTitlePrefixPadding * 3);
    }

    public int getTitleTopPadding() {
        return this.mTitleTopPadding;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (isNeedTitlePrefix()) {
            drawTitleWithPrefix(canvas);
        } else {
            drawTitle(canvas);
        }
        drawSubtitle(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        int size = View.MeasureSpec.getSize(i);
        if (size != getMeasuredWidth()) {
            this.mHasMeasuredTitle = false;
        }
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.mAutoShrinkSubtitle && !sIsDegrade) {
            if (marginLayoutParams != null && marginLayoutParams.height == -2) {
                if (!this.mNeedShowSubtitle && (this.mTitleLines == 1 || measureTitleFor2Line(size))) {
                    i3 = this.mTitleHeight;
                    i4 = this.mTitleTopPadding;
                } else {
                    i3 = this.mTitleHeight + this.mTitleTopPadding + this.mSubtitleHeight;
                    i4 = this.mSubtitleTopPadding;
                }
                size2 = i3 + i4;
            }
        } else if (marginLayoutParams != null && marginLayoutParams.height == -2) {
            i3 = this.mTitleHeight + this.mTitleTopPadding + this.mSubtitleHeight;
            i4 = this.mSubtitleTopPadding;
            size2 = i3 + i4;
        }
        setMeasuredDimension(size, size2);
    }

    public void requestLayoutIfNecessary(@NonNull SubtitleAreaDisplayStatus subtitleAreaDisplayStatus) {
        if (sIsDegrade || getMeasuredWidth() == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = subtitleAreaDisplayStatus.autoShrinkSubtitle && (TextUtils.isEmpty(subtitleAreaDisplayStatus.subtitle) || !subtitleAreaDisplayStatus.needShowSubtitle) && subtitleAreaDisplayStatus.isSingleLineTitle;
        if (!this.mHasMeasuredTitle) {
            measureTitleFor2Line(getMeasuredWidth());
        }
        if (this.mAutoShrinkSubtitle && ((TextUtils.isEmpty(this.mSubtitle) || !this.mNeedShowSubtitle) && (this.mTitleLines == 1 || this.mIsSingleLineTitle))) {
            z = true;
        }
        if (z2 != z) {
            requestLayout();
        }
    }

    @Override // com.youku.css.setter.ICssSetter2
    public void resetCss(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals(CssConst.CssScenes.SUB_TITLE)) {
            setSubtitleTextColor(sDefaultSubtitleTextColor);
        } else if (str.equals(CssConst.CssScenes.TITLE)) {
            setTitleTextColor(sDefaultTitleTextColor);
        }
    }

    public void setAutoShrinkSubtitle(boolean z) {
        this.mAutoShrinkSubtitle = z;
    }

    @Override // com.youku.css.setter.ICssSetter
    public void setCss(String str, Css css) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2127055820:
                if (str.equals(CssConst.CssKey.SCENE_CARD_HEADER_TITLE_COLOR)) {
                    c = 0;
                    break;
                }
                break;
            case -2097705534:
                if (str.equals(CssConst.CssKey.SCENE_CARD_FOOTER_TITLE_COLOR)) {
                    c = 1;
                    break;
                }
                break;
            case -2025406440:
                if (str.equals(CssConst.CssScenes.SUB_TITLE)) {
                    c = 2;
                    break;
                }
                break;
            case -399996521:
                if (str.equals(CssConst.CssKey.SCENE_TITLE_COLOR)) {
                    c = 3;
                    break;
                }
                break;
            case -176676819:
                if (str.equals(CssConst.CssScenes.CARD_FOOTER_TITLE)) {
                    c = 4;
                    break;
                }
                break;
            case -91080069:
                if (str.equals(CssConst.CssScenes.CARD_HEADER_TITLE)) {
                    c = 5;
                    break;
                }
                break;
            case 80818744:
                if (str.equals(CssConst.CssScenes.TITLE)) {
                    c = 6;
                    break;
                }
                break;
            case 441973023:
                if (str.equals(CssConst.CssKey.SCENE_SUB_TITLE_COLOR)) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 3:
            case 5:
            case 6:
                setTitleTextColor(ColorUtil.parseColorSafely(css.color, this.mTitleTextColor));
                return;
            case 1:
            case 2:
            case 4:
            case 7:
                setSubtitleTextColor(ColorUtil.parseColorSafely(css.color, this.mSubtitleTextColor));
                return;
            default:
                return;
        }
    }

    public void setNeedShowSubtitle(boolean z) {
        if (z == this.mNeedShowSubtitle) {
            return;
        }
        this.mNeedShowSubtitle = z;
        if (z) {
            setTitleLines(1);
        }
    }

    public void setSubtitle(String str) {
        if (TextUtils.equals(str, this.mSubtitle)) {
            return;
        }
        this.mSubtitle = str;
        invalidate();
    }

    public void setSubtitleHeight(int i) {
        if (i == this.mSubtitleHeight) {
            return;
        }
        this.mSubtitleHeight = i;
    }

    public void setSubtitlePrefix(String str, int i) {
        if (TextUtils.equals(str, this.mSubtitlePrefix) && i == this.mSubtitlePrefixTextColor) {
            return;
        }
        this.mSubtitlePrefix = str;
        if (i == 0) {
            i = sDefaultSubtitleTextColor;
        }
        this.mSubtitlePrefixTextColor = i;
        TextPaint textPaint = this.mSubtitlePrefixPaint;
        if (textPaint != null) {
            textPaint.setColor(i);
        }
        invalidate();
    }

    public void setSubtitlePrefixStyle(int i) {
        if (i != this.mSubtitlePrefixStyle) {
            if (i == 0 || i == 1 || i == 2) {
                this.mSubtitlePrefixStyle = i;
                TextPaint textPaint = this.mSubtitlePrefixPaint;
                if (textPaint != null) {
                    textPaint.setTypeface(getTypeface(i));
                }
            }
        }
    }

    public void setSubtitleStartPadding(int i) {
        if (i == this.mSubtitleStartPadding) {
            return;
        }
        this.mSubtitleStartPadding = i;
    }

    public void setSubtitleStyle(int i) {
        if (i != this.mSubtitleStyle) {
            if (i == 0 || i == 1 || i == 2) {
                this.mSubtitleStyle = i;
                TextPaint textPaint = this.mSubtitlePaint;
                if (textPaint != null) {
                    textPaint.setTypeface(getTypeface(i));
                }
            }
        }
    }

    public void setSubtitleTextColor(int i) {
        if (i == 0) {
            i = sDefaultSubtitleTextColor;
        }
        if (i == this.mSubtitleTextColor) {
            return;
        }
        this.mSubtitleTextColor = i;
        TextPaint textPaint = this.mSubtitlePaint;
        if (textPaint != null) {
            textPaint.setColor(i);
        }
    }

    public void setSubtitleTextSize(int i) {
        if (i <= 0) {
            i = sDefaultSubtitleTextSize;
        }
        if (i == this.mSubtitleTextSize) {
            return;
        }
        this.mSubtitleTextSize = i;
        this.mSubtitleEllipsizeWidth = -1.0f;
        TextPaint textPaint = this.mSubtitlePaint;
        if (textPaint != null) {
            textPaint.setTextSize(i);
        }
    }

    public void setSubtitleTopPadding(int i) {
        if (i == this.mSubtitleTopPadding) {
            return;
        }
        this.mSubtitleTopPadding = i;
    }

    public void setTitle(String str) {
        if (TextUtils.equals(str, this.mTitle)) {
            return;
        }
        this.mTitle = str;
        this.mHasMeasuredTitle = false;
        invalidate();
    }

    public void setTitleHeight(int i) {
        if (i == this.mTitleHeight) {
            return;
        }
        this.mTitleHeight = i;
    }

    public void setTitleLines(int i) {
        if (i == this.mTitleLines) {
            return;
        }
        this.mHasMeasuredTitle = false;
        if (i == 1) {
            this.mTitleLines = 1;
            return;
        }
        this.mTitleLines = 2;
        this.mNeedShowSubtitle = false;
    }

    public void setTitlePrefix(String str, int i) {
        if (TextUtils.equals(str, this.mTitlePrefix) && i == this.mTitlePrefixTextColor) {
            return;
        }
        this.mLinesWidth[3] = 0;
        this.mTitlePrefix = str;
        if (i == 0) {
            i = sDefaultSubtitleTextColor;
        }
        this.mTitlePrefixTextColor = i;
        getTitlePrefixBgPaint().setColor(ColorUtils.setAlphaComponent(this.mTitlePrefixTextColor, AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD));
        invalidate();
    }

    public void setTitleStartPadding(int i) {
        if (i == this.mTitleStartPadding) {
            return;
        }
        this.mHasMeasuredTitle = false;
        this.mTitleStartPadding = i;
    }

    public void setTitleStyle(int i) {
        if (i != this.mTitleStyle) {
            if (i == 0 || i == 1 || i == 2) {
                this.mHasMeasuredTitle = false;
                this.mTitleStyle = i;
                TextPaint textPaint = this.mTitlePaint;
                if (textPaint != null) {
                    textPaint.setTypeface(getTypeface(i));
                }
            }
        }
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

    public void setTitleTextSize(int i) {
        if (i <= 0) {
            i = sDefaultTitleTextSize;
        }
        if (i == this.mTitleTextSize) {
            return;
        }
        this.mHasMeasuredTitle = false;
        this.mTitleTextSize = i;
        this.mTitleEllipsizeWidth = -1.0f;
        TextPaint textPaint = this.mTitlePaint;
        if (textPaint != null) {
            textPaint.setTextSize(i);
            this.mTitleFontMetrics = null;
        }
    }

    public void setTitleTopPadding(int i) {
        if (i == this.mTitleTopPadding) {
            return;
        }
        this.mTitleTopPadding = i;
    }

    public PhoneCommonTitlesWidget(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhoneCommonTitlesWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTitleLines = 1;
        this.mNeedShowSubtitle = true;
        this.mTitleStartPadding = 0;
        this.mSubtitleStartPadding = 0;
        this.mTitleTopPadding = 0;
        this.mSubtitleTopPadding = 0;
        this.mAutoShrinkSubtitle = false;
        this.mHorizontalGravity = 1;
        this.mLines = new TextLine[4];
        this.mLinesWidth = new int[4];
        this.mTextWidth = new float[1];
        this.mTitleEllipsizeWidth = -1.0f;
        this.mSubtitleEllipsizeWidth = -1.0f;
        this.mHasMeasuredTitle = false;
        this.mIsSingleLineTitle = false;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
    }

    public PhoneCommonTitlesWidget(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTitleLines = 1;
        this.mNeedShowSubtitle = true;
        this.mTitleStartPadding = 0;
        this.mSubtitleStartPadding = 0;
        this.mTitleTopPadding = 0;
        this.mSubtitleTopPadding = 0;
        this.mAutoShrinkSubtitle = false;
        this.mHorizontalGravity = 1;
        this.mLines = new TextLine[4];
        this.mLinesWidth = new int[4];
        this.mTextWidth = new float[1];
        this.mTitleEllipsizeWidth = -1.0f;
        this.mSubtitleEllipsizeWidth = -1.0f;
        this.mHasMeasuredTitle = false;
        this.mIsSingleLineTitle = false;
        initValues(context, attributeSet);
        initProps(context, attributeSet);
    }

    public boolean calculateTitleLines(int i, int i2) {
        if (i == -1) {
            i = getMeasuredWidth();
        }
        if (calculateTitleLine(i - i2, false) || TextUtils.isEmpty(this.mTitle)) {
            return true;
        }
        int i3 = this.mLines[0].size;
        int length = this.mTitle.length() - i3;
        if (sIsDegrade && this.mHorizontalGravity == 1) {
            TextLine line = getLine(1);
            line.size = 0;
            line.appendChars(this.mTitle, i3, length);
            return false;
        }
        int length2 = this.mTitle.length();
        if (i <= 0) {
            i = getWidth();
        }
        if (i <= 0) {
            getLine(1).size = 0;
            return false;
        }
        float f = i;
        int breakText = this.mTitlePaint.breakText(this.mTitle, i3, length2, true, f, this.mTextWidth);
        TextLine line2 = getLine(1);
        line2.size = 0;
        if (breakText < length) {
            float titleEllipsizeWidth = getTitleEllipsizeWidth();
            float[] fArr = this.mTextWidth;
            if (fArr[0] + titleEllipsizeWidth <= f) {
                this.mLinesWidth[1] = (int) (fArr[0] + titleEllipsizeWidth);
            } else {
                int i4 = breakText - 1;
                this.mLinesWidth[1] = (int) ((fArr[0] + titleEllipsizeWidth) - this.mTitlePaint.measureText(this.mTitle, i4, breakText));
                breakText = i4;
            }
            line2.appendChars(this.mTitle, i3, breakText);
            line2.appendChar(ELLIPSIZE_TEXT, 0);
        } else {
            line2.appendChars(this.mTitle, i3, breakText);
            this.mLinesWidth[1] = (int) this.mTextWidth[0];
        }
        return false;
    }
}
