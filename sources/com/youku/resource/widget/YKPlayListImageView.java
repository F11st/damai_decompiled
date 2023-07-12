package com.youku.resource.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.taobao.uikit.extend.feature.features.PhenixOptions;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKPlayListImageView extends YKImageView {
    private int dp10;
    private int dp16;
    private int dp18;
    private int dp20;
    private int dp3;
    private int dp30;
    private int dp34;
    private int dp50;
    private int height;
    private boolean isLayer;
    private Drawable layerBackground;
    int numHeight;
    float numWidth;
    private Paint paint;
    private GradientDrawable playListBg;
    float playListWidth;
    float playlist_num_x;
    float playlist_num_y;
    private String playlist_text_num;
    private String playlist_tx;
    float playlist_x;
    int textColor;
    private int textSize;
    int txHeight;
    float txWidth;
    private int width;

    public YKPlayListImageView(Context context) {
        super(context);
        init();
    }

    private void drawLayerBackgroud(Canvas canvas) {
        if (!isOnlyGrey() && this.isLayer) {
            Drawable drawable = getResources().getDrawable(R.color.cg_2);
            this.layerBackground = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.width, this.height);
                this.layerBackground.draw(canvas);
            }
        }
    }

    private void drawPlayListHint(Canvas canvas) {
        if (TextUtils.isEmpty(this.playlist_text_num) || isOnlyGrey()) {
            return;
        }
        drawPlayListHintInfo(canvas);
    }

    private void drawPlayListHintInfo(Canvas canvas) {
        GradientDrawable playListBg = getPlayListBg();
        if (playListBg != null) {
            int i = this.width;
            playListBg.setBounds(i - (this.dp20 * 4), 0, i, this.height);
            playListBg.draw(canvas);
        }
        this.paint.setTextSize(this.dp16);
        canvas.drawText(this.playlist_text_num, this.playlist_num_x, this.playlist_num_y, this.paint);
        this.paint.setTextSize(this.dp10);
        canvas.drawText(this.playlist_tx, this.playlist_x, this.playlist_num_y + this.numHeight + this.dp3, this.paint);
    }

    private void init() {
        enableLoadOnFling(false);
        setFadeIn(true);
        Resources resources = getResources();
        this.dp3 = resources.getDimensionPixelSize(R.dimen.resource_size_3);
        this.dp30 = resources.getDimensionPixelSize(R.dimen.resource_size_30);
        int i = R.dimen.resource_size_10;
        this.dp10 = resources.getDimensionPixelSize(i);
        this.dp16 = resources.getDimensionPixelSize(R.dimen.resource_size_16);
        this.dp18 = resources.getDimensionPixelSize(R.dimen.resource_size_18);
        this.dp20 = resources.getDimensionPixelSize(R.dimen.resource_size_20);
        this.dp34 = resources.getDimensionPixelSize(R.dimen.resource_size_34);
        this.dp50 = resources.getDimensionPixelSize(R.dimen.resource_size_50);
        this.textSize = resources.getDimensionPixelSize(i);
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.playlist_tx = getResources().getString(R.string.soku_playlist_txt);
        this.paint.setTextSize(this.dp10);
        Rect rect = new Rect();
        Paint paint2 = this.paint;
        String str = this.playlist_tx;
        paint2.getTextBounds(str, 0, str.length(), rect);
        this.txWidth = this.paint.measureText(this.playlist_tx);
        this.txHeight = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
        int color = getResources().getColor(R.color.cw_1);
        this.textColor = color;
        this.paint.setColor(color);
    }

    private void initPlayList() {
        if (TextUtils.isEmpty(this.playlist_text_num)) {
            return;
        }
        this.paint.setTextSize(this.dp16);
        Rect rect = new Rect();
        Paint paint = this.paint;
        String str = this.playlist_text_num;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.numWidth = this.paint.measureText(this.playlist_text_num);
        this.numHeight = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect);
        float f = this.numWidth;
        float f2 = this.txWidth;
        this.playListWidth = f > f2 ? f : f2;
        int i = this.width;
        int i2 = this.dp34;
        int i3 = this.dp30;
        this.playlist_num_x = (float) ((i - i2) + ((i3 - f) / 2.0d));
        this.playlist_x = (float) ((i - i2) + ((i3 - f2) / 2.0d));
        this.playlist_num_y = this.height / 2;
    }

    public void displayVideoImg(String str, PhenixOptions phenixOptions, Object obj) {
        setImageUrl(null);
        if (obj != null) {
            setStrategyConfig(obj);
        }
        setImageUrl(str, phenixOptions);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKImageView, com.youku.resource.widget.YKRatioImageView
    public void drawImageAfter(Canvas canvas) {
        drawPlayListHint(canvas);
        drawLayerBackgroud(canvas);
        super.drawImageAfter(canvas);
    }

    public GradientDrawable getPlayListBg() {
        if (this.playListBg == null && getContext() != null) {
            this.playListBg = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#00000000"), Color.parseColor("#66000000")});
        }
        return this.playListBg;
    }

    @Override // com.youku.resource.widget.YKImageView
    public void hideAll() {
        this.playlist_text_num = null;
        super.hideAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKImageView, com.youku.resource.widget.YKRatioImageView, com.taobao.uikit.feature.view.TImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        initPlayList();
    }

    public void setLayer(Boolean bool) {
        this.isLayer = bool.booleanValue();
    }

    public void setPlayListNum(String str) {
        this.playlist_text_num = str;
        initPlayList();
    }

    public YKPlayListImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }
}
