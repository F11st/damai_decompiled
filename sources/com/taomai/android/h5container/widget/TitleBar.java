package com.taomai.android.h5container.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taomai.android.h5container.R$id;
import com.taomai.android.h5container.R$layout;
import tb.pg2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TitleBar extends LinearLayout implements View.OnClickListener {
    private static final String BROADCAST_TITLE_URL = "com.alipay.mobile.h5container.titleRefreshed";
    public static int COLOR_MAIN_BG = -1;
    public static int COLOR_MAIN_BTN_TEXT = -16777216;
    public static int COLOR_MAIN_STATUS_BAR_BG = -16777216;
    public static int COLOR_MAIN_TITLE_TEXT = -16777216;
    public static final int COLOR_NUM = 8;
    public static int COLOR_OVERLAY_BG = 16777215;
    public static int COLOR_OVERLAY_BTN_TEXT = -1;
    public static int COLOR_OVERLAY_STATUS_BAR_BG = 1294082594;
    public static int COLOR_OVERLAY_TITLE_TEXT = -1;
    public static int COLOR_SUB_BG = -1;
    public static int COLOR_SUB_BTN_TEXT = -16777216;
    public static int COLOR_SUB_STATUS_BAR_BG = -16777216;
    public static int COLOR_SUB_TITLE_TEXT = -16777216;
    public static int DEFAULT_COLOR_MAIN_BG = -1;
    public static int DEFAULT_COLOR_MAIN_BTN_TEXT = -16777216;
    public static int DEFAULT_COLOR_MAIN_STATUS_BAR_BG = -16777216;
    public static int DEFAULT_COLOR_MAIN_TITLE_TEXT = -16777216;
    public static int DEFAULT_COLOR_OVERLAY_BG = 16777215;
    public static int DEFAULT_COLOR_OVERLAY_BTN_TEXT = -1;
    public static int DEFAULT_COLOR_OVERLAY_STATUS_BAR_BG = 1294082594;
    public static int DEFAULT_COLOR_OVERLAY_TITLE_TEXT = -1;
    public static int DEFAULT_COLOR_SUB_BG = -1;
    public static int DEFAULT_COLOR_SUB_BTN_TEXT = -16777216;
    public static int DEFAULT_COLOR_SUB_STATUS_BAR_BG = -16777216;
    public static int DEFAULT_COLOR_SUB_TITLE_TEXT = -16777216;
    private static final String TITLE_BAR_THEME_DEFAULT = "default";
    private static final String TITLE_BAR_THEME_LIGHT = "light";
    private static final String TRANSPARENT_ALWAYS = "always";
    private static final String TRANSPARENT_AUTO = "auto";
    public static final int TYPE_MAIN = 1;
    public static final int TYPE_OVERLAY = 3;
    public static final int TYPE_OVERLAY_MINE = 4;
    public static final int TYPE_SUB = 2;
    private boolean firstClick;
    private a left2Item;
    private a leftItem;
    private View lineView;
    private OnDoubleClickListener listener;
    private boolean preventTouch;
    private a right2Item;
    private a rightItem;
    protected LinearLayout titleContainer;
    private TextView titleTv;
    private int type;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnDoubleClickListener {
        void onDoubleClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a {
        private View a;

        public a(TitleBar titleBar, View view) {
            this.a = view;
        }

        public IconFontTextView b() {
            return (IconFontTextView) this.a.findViewById(R$id.titlebar_button);
        }

        public void c(int i) {
            if (this.a.getVisibility() == 8) {
                this.a.setVisibility(0);
            }
            this.a.findViewById(R$id.titlebar_button).setBackgroundResource(i);
        }

        public void d(int i) {
            if (this.a.getVisibility() == 8) {
                this.a.setVisibility(0);
            }
            this.a.findViewById(R$id.titlebar_button).setBackgroundResource(i);
        }

        public void e(Drawable drawable) {
            if (this.a.getVisibility() == 8) {
                this.a.setVisibility(0);
            }
            this.a.findViewById(R$id.titlebar_button).setBackground(drawable);
        }

        public void f(View.OnClickListener onClickListener) {
            this.a.setOnClickListener(onClickListener);
        }

        public void g(int i) {
            ((TextView) this.a.findViewById(R$id.titlebar_button)).setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
        }

        public void h(CharSequence charSequence) {
            if (this.a.getVisibility() == 8) {
                this.a.setVisibility(0);
            }
            ((TextView) this.a.findViewById(R$id.titlebar_button)).setText(charSequence);
        }

        public void i(int i) {
            ((TextView) this.a.findViewById(R$id.titlebar_button)).setTextColor(i);
        }

        public void j(int i) {
            ((TextView) this.a.findViewById(R$id.titlebar_button)).setTextSize(i);
        }

        public void k(int i, float f) {
            ((TextView) this.a.findViewById(R$id.titlebar_button)).setTextSize(i, f);
        }

        public void l(int i) {
            this.a.setVisibility(i);
        }

        public void m(Bitmap bitmap) {
            ((ImageView) this.a.findViewById(R$id.titlebar_image)).setImageBitmap(bitmap);
        }
    }

    public TitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void onTitleClick() {
        if (this.firstClick) {
            this.firstClick = false;
            postDelayed(new Runnable() { // from class: com.taomai.android.h5container.widget.TitleBar.1
                @Override // java.lang.Runnable
                public void run() {
                    TitleBar.this.firstClick = true;
                }
            }, 1000L);
            return;
        }
        onDoubleClick();
        this.firstClick = true;
    }

    public static void resetColor() {
        COLOR_MAIN_BG = DEFAULT_COLOR_MAIN_BG;
        COLOR_MAIN_TITLE_TEXT = DEFAULT_COLOR_MAIN_TITLE_TEXT;
        COLOR_MAIN_BTN_TEXT = DEFAULT_COLOR_MAIN_BTN_TEXT;
        COLOR_MAIN_STATUS_BAR_BG = DEFAULT_COLOR_MAIN_STATUS_BAR_BG;
        COLOR_SUB_BG = DEFAULT_COLOR_SUB_BG;
        COLOR_SUB_TITLE_TEXT = DEFAULT_COLOR_SUB_TITLE_TEXT;
        COLOR_SUB_BTN_TEXT = DEFAULT_COLOR_SUB_BTN_TEXT;
        COLOR_SUB_STATUS_BAR_BG = DEFAULT_COLOR_SUB_STATUS_BAR_BG;
        COLOR_OVERLAY_BG = DEFAULT_COLOR_OVERLAY_BG;
        COLOR_OVERLAY_TITLE_TEXT = DEFAULT_COLOR_OVERLAY_TITLE_TEXT;
        COLOR_OVERLAY_BTN_TEXT = DEFAULT_COLOR_OVERLAY_BTN_TEXT;
        COLOR_OVERLAY_STATUS_BAR_BG = DEFAULT_COLOR_OVERLAY_STATUS_BAR_BG;
    }

    private void setStatusBarUnion() {
        if (getContext() instanceof Activity) {
            pg2.c((Activity) getContext());
        }
    }

    private void setTypeInternal(int i) {
        this.type = i;
        if (i == 1) {
            setBackgroundColor(COLOR_MAIN_BG);
            this.titleTv.setTextColor(COLOR_MAIN_TITLE_TEXT);
            this.leftItem.i(COLOR_MAIN_BTN_TEXT);
            this.left2Item.i(COLOR_MAIN_BTN_TEXT);
            this.rightItem.i(COLOR_MAIN_BTN_TEXT);
            this.right2Item.i(COLOR_MAIN_BTN_TEXT);
        } else if (i == 2) {
            setBackgroundColor(COLOR_SUB_BG);
            this.titleTv.setTextColor(COLOR_SUB_TITLE_TEXT);
            this.leftItem.i(COLOR_SUB_BTN_TEXT);
            this.left2Item.i(COLOR_SUB_BTN_TEXT);
            this.rightItem.i(COLOR_SUB_BTN_TEXT);
            this.right2Item.i(COLOR_SUB_BTN_TEXT);
        } else if (i == 3) {
            setBackgroundColor(COLOR_OVERLAY_BG);
            setStatusBarColor(COLOR_OVERLAY_STATUS_BAR_BG);
            setStatusBarUnion();
            this.titleTv.setTextColor(COLOR_OVERLAY_TITLE_TEXT);
            this.leftItem.i(COLOR_OVERLAY_BTN_TEXT);
            this.left2Item.i(COLOR_OVERLAY_BTN_TEXT);
            this.rightItem.i(COLOR_OVERLAY_BTN_TEXT);
            this.right2Item.i(COLOR_OVERLAY_BTN_TEXT);
            this.lineView.setVisibility(4);
        } else if (i == 4) {
            setBackgroundColor(COLOR_OVERLAY_BG);
            this.titleTv.setTextColor(COLOR_SUB_TITLE_TEXT);
            this.leftItem.i(COLOR_SUB_BTN_TEXT);
            this.left2Item.i(COLOR_SUB_BTN_TEXT);
            this.rightItem.i(COLOR_SUB_BTN_TEXT);
            this.right2Item.i(COLOR_SUB_BTN_TEXT);
            this.lineView.setVisibility(4);
        }
    }

    public static void updateColor(int[] iArr) {
        if (iArr == null || iArr.length != 8) {
            return;
        }
        COLOR_MAIN_BG = iArr[0];
        COLOR_MAIN_TITLE_TEXT = iArr[1];
        COLOR_MAIN_BTN_TEXT = iArr[2];
        COLOR_MAIN_STATUS_BAR_BG = iArr[3];
        COLOR_SUB_BG = iArr[4];
        COLOR_SUB_TITLE_TEXT = iArr[5];
        COLOR_SUB_BTN_TEXT = iArr[6];
        COLOR_SUB_STATUS_BAR_BG = iArr[7];
    }

    protected void afterInflate() {
        setOrientation(1);
        this.titleContainer = (LinearLayout) findViewById(R$id.titlebar_title_container);
        this.titleTv = (TextView) findViewById(R$id.titlebar_title);
        this.leftItem = new a(this, findViewById(R$id.titlebar_left_btn));
        a aVar = new a(this, findViewById(R$id.titlebar_left_btn2));
        this.left2Item = aVar;
        aVar.l(8);
        a aVar2 = new a(this, findViewById(R$id.titlebar_right_btn));
        this.rightItem = aVar2;
        aVar2.l(8);
        a aVar3 = new a(this, findViewById(R$id.titlebar_right_btn2));
        this.right2Item = aVar3;
        aVar3.l(8);
        setBackgroundColor(COLOR_SUB_BG);
        this.titleTv.setTextColor(COLOR_SUB_TITLE_TEXT);
        this.leftItem.i(COLOR_SUB_BTN_TEXT);
        this.left2Item.i(COLOR_SUB_BTN_TEXT);
        this.rightItem.i(COLOR_SUB_BTN_TEXT);
        this.right2Item.i(COLOR_SUB_BTN_TEXT);
        this.titleTv.setOnClickListener(this);
        this.lineView = findViewById(R$id.line_view);
    }

    public View getLeft2Button() {
        return this.left2Item.a;
    }

    public IconFontTextView getLeft2ButtonView() {
        return this.left2Item.b();
    }

    public View getLeftButton() {
        return this.leftItem.a;
    }

    public IconFontTextView getLeftButtonView() {
        return this.leftItem.b();
    }

    public View getLineView() {
        return this.lineView;
    }

    public View getRight2Button() {
        return this.right2Item.a;
    }

    public IconFontTextView getRight2ButtonView() {
        return this.right2Item.b();
    }

    public View getRightButton() {
        return this.rightItem.a;
    }

    public IconFontTextView getRightButtonView() {
        return this.rightItem.b();
    }

    public TextView getTitleTextView() {
        return this.titleTv;
    }

    public View getTitleView() {
        return this.titleContainer;
    }

    public int getType() {
        return this.type;
    }

    public boolean isPreventTouch() {
        return this.preventTouch;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onTitleClick();
    }

    public void onDoubleClick() {
        OnDoubleClickListener onDoubleClickListener = this.listener;
        if (onDoubleClickListener != null) {
            onDoubleClickListener.onDoubleClick();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.preventTouch;
    }

    public void resetTextViewStyle() {
        if (this.titleTv != null) {
            setTypeInternal(this.type);
            this.titleTv.setTextSize(17.0f);
        }
    }

    public void setCustomTitle(View view) {
        this.titleContainer.removeView(this.titleTv);
        if (view != null) {
            this.titleContainer.addView(view, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public void setLeft2ButtonBackground(int i) {
        this.left2Item.c(i);
    }

    public void setLeft2ButtonImage(int i) {
        this.left2Item.d(i);
    }

    public void setLeft2ButtonListener(View.OnClickListener onClickListener) {
        this.left2Item.f(onClickListener);
    }

    public void setLeft2ButtonRightof(int i) {
        this.left2Item.g(i);
    }

    public void setLeft2ButtonText(CharSequence charSequence) {
        this.left2Item.h(charSequence);
    }

    public void setLeft2ButtonTextColor(int i) {
        this.left2Item.i(i);
    }

    public void setLeft2ButtonTextSize(int i) {
        this.left2Item.j(i);
    }

    public void setLeft2ButtonVisable(int i) {
        this.left2Item.l(i);
    }

    public void setLeftButtonBackground(int i) {
        this.leftItem.c(i);
    }

    public void setLeftButtonImage(int i) {
        this.leftItem.d(i);
    }

    public void setLeftButtonListener(View.OnClickListener onClickListener) {
        this.leftItem.f(onClickListener);
    }

    public void setLeftButtonRightof(int i) {
        this.leftItem.g(i);
    }

    public void setLeftButtonText(CharSequence charSequence) {
        this.leftItem.h(charSequence);
    }

    public void setLeftButtonTextColor(int i) {
        this.leftItem.i(i);
    }

    public void setLeftButtonTextSize(int i) {
        this.leftItem.j(i);
    }

    public void setLeftButtonVisable(int i) {
        this.leftItem.l(i);
    }

    public void setLineVisable(boolean z) {
        this.lineView.setVisibility(z ? 0 : 4);
    }

    public void setOnDoubleClickListener(OnDoubleClickListener onDoubleClickListener) {
        this.listener = onDoubleClickListener;
    }

    public void setPreventTouch(boolean z) {
        this.preventTouch = z;
        this.titleTv.setClickable(z);
        if (z || this.rightItem.a.hasOnClickListeners()) {
            this.rightItem.a.setClickable(true);
        } else {
            this.rightItem.a.setClickable(false);
        }
    }

    public void setRight2ButtonImage(int i) {
        this.right2Item.d(i);
    }

    public void setRight2ButtonListener(View.OnClickListener onClickListener) {
        this.right2Item.f(onClickListener);
    }

    public void setRight2ButtonRightof(int i) {
        this.right2Item.g(i);
    }

    public void setRight2ButtonText(CharSequence charSequence) {
        this.right2Item.h(charSequence);
    }

    public void setRight2ButtonTextColor(int i) {
        this.right2Item.i(i);
    }

    public void setRight2ButtonTextSize(int i) {
        this.right2Item.j(i);
    }

    public void setRight2ButtonVisable(int i) {
        this.right2Item.l(i);
    }

    public void setRight2Image(Bitmap bitmap) {
        this.right2Item.m(bitmap);
    }

    public void setRightButtonBackground(int i) {
        this.rightItem.c(i);
    }

    public void setRightButtonImage(int i) {
        this.rightItem.d(i);
    }

    public void setRightButtonListener(View.OnClickListener onClickListener) {
        this.rightItem.f(onClickListener);
    }

    public void setRightButtonRightof(int i) {
        this.rightItem.g(i);
    }

    public void setRightButtonText(CharSequence charSequence) {
        this.rightItem.h(charSequence);
    }

    public void setRightButtonTextColor(int i) {
        this.rightItem.i(i);
    }

    public void setRightButtonTextSize(int i) {
        this.rightItem.j(i);
    }

    public void setRightButtonVisable(int i) {
        this.rightItem.l(i);
    }

    public void setRightImage(Bitmap bitmap) {
        this.rightItem.m(bitmap);
    }

    public void setStatusBarColor(int i) {
        if (getContext() instanceof Activity) {
            pg2.a((Activity) getContext(), i);
        }
    }

    public void setTitle(String str) {
        this.titleTv.setText(str);
    }

    public void setTitleColor(int i) {
        this.titleTv.setTextColor(i);
    }

    public void setTitleTextSize(int i) {
        this.titleTv.setTextSize(i);
    }

    public void setType(int i) {
        if (this.type != i) {
            setTypeInternal(i);
        }
    }

    public void updateStyle() {
        setTypeInternal(this.type);
    }

    public TitleBar(Context context) {
        this(context, null, 0);
    }

    public void setLeftButtonTextSize(int i, float f) {
        this.leftItem.k(i, f);
    }

    public void setRightButtonImage(Drawable drawable) {
        this.rightItem.e(drawable);
    }

    public TitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.type = 2;
        this.firstClick = true;
        this.preventTouch = true;
        LayoutInflater.from(context).inflate(R$layout.view_taomai_h5_container_titlebar, (ViewGroup) this, true);
        afterInflate();
        setOnClickListener(this);
    }

    public void setCustomTitle(int i) {
        LayoutInflater.from(getContext()).inflate(i, this.titleContainer);
        this.titleContainer.removeView(this.titleTv);
    }
}
