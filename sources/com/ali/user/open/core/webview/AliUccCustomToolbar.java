package com.ali.user.open.core.webview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import com.ali.user.open.core.R;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUccCustomToolbar extends Toolbar {
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;

    public AliUccCustomToolbar(Context context) {
        super(context);
        resolveAttribute(context, null, R.attr.toolbarStyle);
    }

    private void addCenterView(View view) {
        Toolbar.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (Toolbar.LayoutParams) layoutParams2;
        }
        addView(view, layoutParams);
    }

    private void resolveAttribute(Context context, AttributeSet attributeSet, int i) {
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.Toolbar, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        if (resourceId != 0) {
            setTitleTextAppearance(context2, resourceId);
        }
        int i2 = this.mTitleTextColor;
        if (i2 != 0) {
            setTitleTextColor(i2);
        }
        obtainStyledAttributes.recycle();
        post(new Runnable() { // from class: com.ali.user.open.core.webview.AliUccCustomToolbar.1
            @Override // java.lang.Runnable
            public void run() {
                if (AliUccCustomToolbar.this.getLayoutParams() instanceof Toolbar.LayoutParams) {
                    ((Toolbar.LayoutParams) AliUccCustomToolbar.this.getLayoutParams()).gravity = 17;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCenter(String str) {
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            if (obj != null && (obj instanceof View)) {
                View view = (View) obj;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ActionBar.LayoutParams) {
                    ((ActionBar.LayoutParams) layoutParams).gravity = 17;
                    view.setLayoutParams(layoutParams);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setGravityCenter() {
        post(new Runnable() { // from class: com.ali.user.open.core.webview.AliUccCustomToolbar.2
            @Override // java.lang.Runnable
            public void run() {
                AliUccCustomToolbar.this.setCenter("mNavButtonView");
                AliUccCustomToolbar.this.setCenter("mMenuView");
            }
        });
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(drawable);
        setGravityCenter();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                TextView textView = new TextView(context);
                this.mTitleTextView = textView;
                textView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mTitleTextAppearance;
                if (i != 0) {
                    this.mTitleTextView.setTextAppearance(context, i);
                }
                int i2 = this.mTitleTextColor;
                if (i2 != 0) {
                    this.mTitleTextView.setTextColor(i2);
                }
            }
            if (this.mTitleTextView.getParent() != this) {
                addCenterView(this.mTitleTextView);
            }
        } else {
            TextView textView2 = this.mTitleTextView;
            if (textView2 != null && textView2.getParent() == this) {
                removeView(this.mTitleTextView);
            }
        }
        TextView textView3 = this.mTitleTextView;
        if (textView3 != null) {
            textView3.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextAppearance(Context context, int i) {
        this.mTitleTextAppearance = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextColor(int i) {
        this.mTitleTextColor = i;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public Toolbar.LayoutParams generateDefaultLayoutParams() {
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public AliUccCustomToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        resolveAttribute(context, attributeSet, R.attr.toolbarStyle);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public Toolbar.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(getContext(), attributeSet);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public AliUccCustomToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        resolveAttribute(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public Toolbar.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Toolbar.LayoutParams layoutParams2;
        if (layoutParams instanceof Toolbar.LayoutParams) {
            layoutParams2 = new Toolbar.LayoutParams((Toolbar.LayoutParams) layoutParams);
        } else if (layoutParams instanceof ActionBar.LayoutParams) {
            layoutParams2 = new Toolbar.LayoutParams((ActionBar.LayoutParams) layoutParams);
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams2 = new Toolbar.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        } else {
            layoutParams2 = new Toolbar.LayoutParams(layoutParams);
        }
        layoutParams2.gravity = 17;
        return layoutParams2;
    }
}
