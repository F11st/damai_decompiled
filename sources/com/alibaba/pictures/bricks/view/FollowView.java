package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$styleable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class FollowView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final View addView;
    @Nullable
    private Path clipPath;
    private final int followColor;
    @NotNull
    private final View innerView;
    private final boolean isShowPlugTag;
    @Nullable
    private Integer lastH;
    @Nullable
    private Integer lastW;
    @NotNull
    private final TextView textView;
    private final int unFollowColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FollowView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FollowView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ FollowView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        if (r1 != r4.intValue()) goto L13;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void dispatchDraw(@org.jetbrains.annotations.Nullable android.graphics.Canvas r9) {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.view.FollowView.$ipChange
            java.lang.String r1 = "1561117066"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r8
            r3 = 1
            r2[r3] = r9
            r0.ipc$dispatch(r1, r2)
            return
        L17:
            int r0 = r8.getHeight()     // Catch: java.lang.Exception -> L7c
            int r1 = r8.getWidth()     // Catch: java.lang.Exception -> L7c
            if (r0 <= 0) goto L52
            if (r1 <= 0) goto L52
            float r2 = (float) r0     // Catch: java.lang.Exception -> L7c
            r3 = 1073741824(0x40000000, float:2.0)
            float r3 = r2 / r3
            java.lang.Integer r4 = r8.lastH     // Catch: java.lang.Exception -> L7c
            if (r4 != 0) goto L2d
            goto L3e
        L2d:
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L7c
            if (r0 != r4) goto L3e
            java.lang.Integer r4 = r8.lastW     // Catch: java.lang.Exception -> L7c
            if (r4 != 0) goto L38
            goto L3e
        L38:
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L7c
            if (r1 == r4) goto L55
        L3e:
            android.graphics.Path r4 = new android.graphics.Path     // Catch: java.lang.Exception -> L7c
            r4.<init>()     // Catch: java.lang.Exception -> L7c
            android.graphics.RectF r5 = new android.graphics.RectF     // Catch: java.lang.Exception -> L7c
            float r6 = (float) r1     // Catch: java.lang.Exception -> L7c
            r7 = 0
            r5.<init>(r7, r7, r6, r2)     // Catch: java.lang.Exception -> L7c
            android.graphics.Path$Direction r2 = android.graphics.Path.Direction.CW     // Catch: java.lang.Exception -> L7c
            r4.addRoundRect(r5, r3, r3, r2)     // Catch: java.lang.Exception -> L7c
            r8.clipPath = r4     // Catch: java.lang.Exception -> L7c
            goto L55
        L52:
            r2 = 0
            r8.clipPath = r2     // Catch: java.lang.Exception -> L7c
        L55:
            android.graphics.Path r2 = r8.clipPath     // Catch: java.lang.Exception -> L7c
            if (r2 == 0) goto L63
            if (r9 == 0) goto L5e
            r9.save()     // Catch: java.lang.Exception -> L7c
        L5e:
            if (r9 == 0) goto L63
            r9.clipPath(r2)     // Catch: java.lang.Exception -> L7c
        L63:
            super.dispatchDraw(r9)     // Catch: java.lang.Exception -> L7c
            android.graphics.Path r2 = r8.clipPath     // Catch: java.lang.Exception -> L7c
            if (r2 == 0) goto L6f
            if (r9 == 0) goto L6f
            r9.restore()     // Catch: java.lang.Exception -> L7c
        L6f:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L7c
            r8.lastW = r9     // Catch: java.lang.Exception -> L7c
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L7c
            r8.lastH = r9     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r9 = move-exception
            r9.printStackTrace()
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.view.FollowView.dispatchDraw(android.graphics.Canvas):void");
    }

    public final void updateFollow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629063413")) {
            ipChange.ipc$dispatch("1629063413", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.innerView.setBackgroundResource(R$drawable.bricks_folllowed_btn_bg);
            this.textView.setText("已关注");
            this.textView.setTextColor(this.followColor);
            this.addView.setVisibility(8);
        } else {
            this.addView.setVisibility(this.isShowPlugTag ? 0 : 8);
            this.textView.setText("关注");
            this.textView.setTextColor(this.unFollowColor);
            this.innerView.setBackgroundResource(R$drawable.bricks_follow_btn_bg_v2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FollowView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FollowView);
        b41.h(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.FollowView)");
        this.followColor = obtainStyledAttributes.getColor(R$styleable.FollowView_follow_text_color, -1);
        this.unFollowColor = obtainStyledAttributes.getColor(R$styleable.FollowView_unfollow_text_color, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.FollowView_follow_text_size, 24);
        this.isShowPlugTag = obtainStyledAttributes.getBoolean(R$styleable.FollowView_is_show_plus_tag, true);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(R$layout.bricks_follow_inner_view, (ViewGroup) this, true);
        View findViewById = findViewById(R$id.id_follow_layout);
        b41.h(findViewById, "findViewById<View>(R.id.id_follow_layout)");
        this.innerView = findViewById;
        View findViewById2 = findViewById(R$id.id_follow_layout_add_tag);
        b41.h(findViewById2, "findViewById<View>(R.id.id_follow_layout_add_tag)");
        this.addView = findViewById2;
        View findViewById3 = findViewById(R$id.id_follow_layout_text);
        b41.h(findViewById3, "findViewById<TextView>(R.id.id_follow_layout_text)");
        TextView textView = (TextView) findViewById3;
        this.textView = textView;
        textView.setTextSize(0, dimensionPixelSize);
    }
}
