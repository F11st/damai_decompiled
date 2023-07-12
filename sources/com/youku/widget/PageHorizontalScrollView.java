package com.youku.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PageHorizontalScrollView extends HorizontalScrollView {
    ImageView _bt_left;
    ImageView _bt_right;
    ImageView cover_left;
    ImageView cover_right;
    private int currentPos;
    private int screenWidth;
    private int totalPos;

    public PageHorizontalScrollView(Context context) {
        super(context);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void computeScroll() {
        this.currentPos = computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = computeHorizontalScrollRange();
        this.totalPos = computeHorizontalScrollRange;
        if (computeHorizontalScrollRange <= this.screenWidth) {
            ImageView imageView = this._bt_left;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            ImageView imageView2 = this._bt_right;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            ImageView imageView3 = this.cover_left;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.cover_right;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        } else {
            if (this.currentPos == 0) {
                ImageView imageView5 = this._bt_left;
                if (imageView5 != null) {
                    imageView5.setVisibility(4);
                }
                ImageView imageView6 = this._bt_right;
                if (imageView6 != null) {
                    imageView6.setVisibility(0);
                }
                ImageView imageView7 = this.cover_left;
                if (imageView7 != null) {
                    imageView7.setVisibility(8);
                }
                ImageView imageView8 = this.cover_right;
                if (imageView8 != null) {
                    imageView8.setVisibility(0);
                }
            }
            int i = this.currentPos;
            if ((i > 0) & (i < this.totalPos - this.screenWidth)) {
                ImageView imageView9 = this._bt_left;
                if (imageView9 != null) {
                    imageView9.setVisibility(0);
                }
                ImageView imageView10 = this._bt_right;
                if (imageView10 != null) {
                    imageView10.setVisibility(0);
                }
                ImageView imageView11 = this.cover_left;
                if (imageView11 != null) {
                    imageView11.setVisibility(0);
                }
                ImageView imageView12 = this.cover_right;
                if (imageView12 != null) {
                    imageView12.setVisibility(0);
                }
            }
            if (this.currentPos >= this.totalPos - this.screenWidth) {
                ImageView imageView13 = this._bt_left;
                if (imageView13 != null) {
                    imageView13.setVisibility(0);
                }
                ImageView imageView14 = this._bt_right;
                if (imageView14 != null) {
                    imageView14.setVisibility(4);
                }
                ImageView imageView15 = this.cover_left;
                if (imageView15 != null) {
                    imageView15.setVisibility(0);
                }
                ImageView imageView16 = this.cover_right;
                if (imageView16 != null) {
                    imageView16.setVisibility(8);
                }
            }
        }
        super.computeScroll();
    }

    public void scrollToCurrent(int i, int i2, View view) {
        if (i >= i2 || i2 <= 0) {
            return;
        }
        if (view != null) {
            smoothScrollTo(view.getLeft() - ((this.screenWidth - view.getWidth()) / 2), 0);
            return;
        }
        if (i < 0) {
            i = 0;
        }
        scrollTo(i * (this.totalPos / i2), 0);
    }

    public void setCoverLeftImage(ImageView imageView) {
        this.cover_left = imageView;
    }

    public void setCoverRightImage(ImageView imageView) {
        this.cover_right = imageView;
    }

    public void setLeftButton(ImageView imageView) {
        this._bt_left = imageView;
    }

    public void setRightButton(ImageView imageView) {
        this._bt_right = imageView;
    }

    public void setScreenWidth(int i) {
        this.screenWidth = i;
        this.currentPos = computeHorizontalScrollOffset();
        this.totalPos = computeHorizontalScrollRange();
    }

    public PageHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PageHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
