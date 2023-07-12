package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.R$styleable;
import com.alient.oneservice.image.FailEvent;
import com.alient.oneservice.image.IImageFailListener;
import com.alient.oneservice.image.IImageSuccListener;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.alient.oneservice.image.SuccessEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMAvatar extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private ImageView avatarBorder;
    private ImageView avatarCrown;
    private ImageView avatarImage;
    private View avatarInnerBorder;
    private FrameLayout avatarLayout;
    private ImageView avatarPlaceHolder;
    private DMAvatarSize avatarSize;
    private ImageView avatarVTag;
    private ImageView avatarYYmemberTag;
    private OnImageLoadListener loadListener;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public enum DMAvatarSize {
        SIZE_20x20,
        SIZE_30x30,
        SIZE_33x33,
        SIZE_40x40,
        SIZE_50x50,
        SIZE_60x60,
        SIZE_80x80,
        SIZE_100x100
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnImageLoadListener {
        void onImageLoadFailure();

        void onImageLoadSuccess();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // com.alient.oneservice.image.IImageSuccListener
        public void onSuccess(SuccessEvent successEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1454199252")) {
                ipChange.ipc$dispatch("-1454199252", new Object[]{this, successEvent});
            } else {
                DMAvatar.this.avatarCrown.setImageDrawable(successEvent.drawable);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // com.alient.oneservice.image.IImageFailListener
        public void onFail(FailEvent failEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1054781201")) {
                ipChange.ipc$dispatch("-1054781201", new Object[]{this, failEvent});
            } else {
                DMAvatar.this.avatarCrown.setImageResource(R$drawable.bricks_uikit_crown_icon);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements IImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.alient.oneservice.image.IImageSuccListener
        public void onSuccess(SuccessEvent successEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1020470166")) {
                ipChange.ipc$dispatch("-1020470166", new Object[]{this, successEvent});
                return;
            }
            DMAvatar.this.avatarImage.setImageDrawable(successEvent.drawable);
            if (DMAvatar.this.loadListener != null) {
                DMAvatar.this.loadListener.onImageLoadSuccess();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements IImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // com.alient.oneservice.image.IImageFailListener
        public void onFail(FailEvent failEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "483558829")) {
                ipChange.ipc$dispatch("483558829", new Object[]{this, failEvent});
            } else if (DMAvatar.this.loadListener != null) {
                DMAvatar.this.loadListener.onImageLoadFailure();
            }
        }
    }

    public DMAvatar(@NonNull Context context) {
        this(context, null);
    }

    private void adaptiveViewParams(float f, int i, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1105697305")) {
            ipChange.ipc$dispatch("1105697305", new Object[]{this, Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10)});
            return;
        }
        if (this.avatarLayout != null) {
            s60 s60Var = s60.INSTANCE;
            int a2 = s60Var.a(getContext(), f4);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.avatarLayout.getLayoutParams();
            layoutParams.topMargin = a2;
            if (this.avatarYYmemberTag != null) {
                int a3 = s60Var.a(getContext(), f8);
                int a4 = s60Var.a(getContext(), f9);
                int a5 = s60Var.a(getContext(), f10);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.avatarYYmemberTag.getLayoutParams();
                layoutParams2.width = a3;
                layoutParams2.height = a4;
                layoutParams.bottomMargin = a5;
            }
        }
        if (this.avatarImage != null) {
            s60 s60Var2 = s60.INSTANCE;
            int a6 = s60Var2.a(getContext(), f);
            int a7 = s60Var2.a(getContext(), f);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.avatarImage.getLayoutParams();
            layoutParams3.width = a6;
            layoutParams3.height = a7;
            this.avatarImage.setLayoutParams(layoutParams3);
            this.avatarPlaceHolder.setLayoutParams(layoutParams3);
            this.avatarInnerBorder.setLayoutParams(layoutParams3);
        }
        if (this.avatarBorder != null) {
            s60 s60Var3 = s60.INSTANCE;
            float f11 = f + (i * 2);
            int a8 = s60Var3.a(getContext(), f11);
            int a9 = s60Var3.a(getContext(), f11);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.avatarBorder.getLayoutParams();
            layoutParams4.width = a8;
            layoutParams4.height = a9;
            this.avatarBorder.setLayoutParams(layoutParams4);
        }
        if (this.avatarCrown != null) {
            s60 s60Var4 = s60.INSTANCE;
            int a10 = s60Var4.a(getContext(), f2);
            int a11 = s60Var4.a(getContext(), f3);
            int a12 = s60Var4.a(getContext(), f5);
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.avatarCrown.getLayoutParams();
            layoutParams5.width = a10;
            layoutParams5.height = a11;
            layoutParams5.rightMargin = a12;
            this.avatarCrown.setLayoutParams(layoutParams5);
        }
        if (this.avatarVTag != null) {
            s60 s60Var5 = s60.INSTANCE;
            int a13 = s60Var5.a(getContext(), f6);
            int a14 = s60Var5.a(getContext(), f6);
            int a15 = s60Var5.a(getContext(), f7);
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.avatarVTag.getLayoutParams();
            layoutParams6.width = a13;
            layoutParams6.height = a14;
            layoutParams6.rightMargin = a15;
            this.avatarVTag.setLayoutParams(layoutParams6);
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1899214713")) {
            ipChange.ipc$dispatch("1899214713", new Object[]{this, context, attributeSet});
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DMAvatar);
        switch (obtainStyledAttributes.getInt(R$styleable.DMAvatar_avatarSize, 0)) {
            case 0:
                this.avatarSize = DMAvatarSize.SIZE_30x30;
                break;
            case 1:
                this.avatarSize = DMAvatarSize.SIZE_40x40;
                break;
            case 2:
                this.avatarSize = DMAvatarSize.SIZE_50x50;
                break;
            case 3:
                this.avatarSize = DMAvatarSize.SIZE_60x60;
                break;
            case 4:
                this.avatarSize = DMAvatarSize.SIZE_80x80;
                break;
            case 5:
                this.avatarSize = DMAvatarSize.SIZE_100x100;
                break;
            case 6:
                this.avatarSize = DMAvatarSize.SIZE_20x20;
                break;
        }
        obtainStyledAttributes.recycle();
    }

    private void initAvatarCrownIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1670726722")) {
            ipChange.ipc$dispatch("-1670726722", new Object[]{this});
        } else {
            ImageLoaderProviderProxy.getProxy().load("", new a(), new b());
        }
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237776584")) {
            ipChange.ipc$dispatch("-1237776584", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.bricks_uikit_damai_avatar, this);
        this.avatarLayout = (FrameLayout) findViewById(R$id.uikit_damai_avatar_layout);
        this.avatarBorder = (ImageView) findViewById(R$id.uikit_damai_avatar_border);
        this.avatarInnerBorder = findViewById(R$id.uikit_damai_avatar_inner_border);
        this.avatarPlaceHolder = (ImageView) findViewById(R$id.uikit_damai_avatar_placeholder);
        this.avatarImage = (ImageView) findViewById(R$id.uikit_damai_avatar_image);
        this.avatarCrown = (ImageView) findViewById(R$id.uikit_damai_avatar_crown);
        this.avatarVTag = (ImageView) findViewById(R$id.uikit_damai_avatar_v_tag);
        this.avatarYYmemberTag = (ImageView) findViewById(R$id.uikit_damai_avatar_yymember_tag);
        setAvatarSize(this.avatarSize);
        initAvatarCrownIcon();
    }

    public void setAvatar(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352777076")) {
            ipChange.ipc$dispatch("352777076", new Object[]{this, str});
        } else if (this.avatarImage == null) {
        } else {
            ImageLoaderProviderProxy.getProxy().load(str, new c(), new d());
        }
    }

    public void setAvatarBorderVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940243351")) {
            ipChange.ipc$dispatch("1940243351", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.avatarBorder;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public void setAvatarCrownVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073679212")) {
            ipChange.ipc$dispatch("1073679212", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.avatarCrown;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public void setAvatarPlaceholder(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1994174666")) {
            ipChange.ipc$dispatch("-1994174666", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.avatarPlaceHolder;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    public void setAvatarSize(DMAvatarSize dMAvatarSize) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782146503")) {
            ipChange.ipc$dispatch("-782146503", new Object[]{this, dMAvatarSize});
        } else if (DMAvatarSize.SIZE_20x20.equals(dMAvatarSize)) {
            adaptiveViewParams(20.0f, 2, 8.0f, 8.0f, 5.0f, 1.3f, 10.0f, 1.0f, 12.0f, 12.0f, 2.0f);
        } else if (DMAvatarSize.SIZE_30x30.equals(dMAvatarSize)) {
            adaptiveViewParams(30.0f, 2, 13.0f, 13.0f, 7.0f, 1.3f, 12.0f, 1.0f, 14.0f, 12.0f, 2.0f);
        } else if (DMAvatarSize.SIZE_33x33.equals(dMAvatarSize)) {
            adaptiveViewParams(33.0f, 2, 13.0f, 13.0f, 7.0f, 1.3f, 12.0f, 1.0f, 14.0f, 14.0f, 2.0f);
        } else if (DMAvatarSize.SIZE_40x40.equals(dMAvatarSize)) {
            adaptiveViewParams(40.0f, 2, 17.3f, 17.4f, 9.0f, 0.5f, 12.0f, 1.0f, 17.0f, 15.0f, 3.0f);
        } else if (DMAvatarSize.SIZE_50x50.equals(dMAvatarSize)) {
            adaptiveViewParams(50.0f, 3, 21.6f, 21.7f, 11.0f, 0.5f, 18.0f, 3.0f, 18.0f, 16.0f, 2.0f);
        } else if (DMAvatarSize.SIZE_60x60.equals(dMAvatarSize)) {
            adaptiveViewParams(60.0f, 3, 21.6f, 21.7f, 11.5f, 4.5f, 18.0f, 5.0f, 20.0f, 17.0f, 2.0f);
        } else if (DMAvatarSize.SIZE_80x80.equals(dMAvatarSize)) {
            adaptiveViewParams(80.0f, 4, 28.1f, 28.3f, 15.0f, 6.5f, 24.0f, 7.0f, 0.0f, 0.0f, 0.0f);
        } else if (DMAvatarSize.SIZE_100x100.equals(dMAvatarSize)) {
            adaptiveViewParams(100.0f, 4, 30.6f, 30.2f, 15.5f, 10.2f, 24.0f, 11.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void setAvatarVTagVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "518551407")) {
            ipChange.ipc$dispatch("518551407", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.avatarVTag;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public void setAvatarYYmemberTagVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1660685611")) {
            ipChange.ipc$dispatch("-1660685611", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.avatarYYmemberTag;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(i);
    }

    public void setOnImageLoadListener(OnImageLoadListener onImageLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1803581718")) {
            ipChange.ipc$dispatch("1803581718", new Object[]{this, onImageLoadListener});
        } else {
            this.loadListener = onImageLoadListener;
        }
    }

    public void setYYMemberTagView(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712675388")) {
            ipChange.ipc$dispatch("1712675388", new Object[]{this, Boolean.valueOf(z), str});
            return;
        }
        ImageView imageView = this.avatarYYmemberTag;
        if (imageView == null) {
            return;
        }
        if (!z) {
            if ("1".equals(str)) {
                if (this.avatarYYmemberTag.getVisibility() == 8) {
                    setAvatarYYmemberTagVisibility(0);
                }
                this.avatarYYmemberTag.setImageResource(R$drawable.bricks_dm_yy_member_icon);
            } else if ("2".equals(str)) {
                if (this.avatarYYmemberTag.getVisibility() == 8) {
                    setAvatarYYmemberTagVisibility(0);
                }
                this.avatarYYmemberTag.setImageResource(R$drawable.bricks_dm_gf_member_icon);
            } else if ("10".equals(str)) {
                if (this.avatarYYmemberTag.getVisibility() == 8) {
                    setAvatarYYmemberTagVisibility(0);
                }
                this.avatarYYmemberTag.setImageResource(R$drawable.bricks_dm_yy_black_member_icon);
            } else if (this.avatarYYmemberTag.getVisibility() == 0) {
                setAvatarYYmemberTagVisibility(8);
            }
        } else if (imageView.getVisibility() == 0) {
            setAvatarYYmemberTagVisibility(8);
        }
    }

    public DMAvatar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DMAvatar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttrs(context, attributeSet);
        initView(context);
    }

    public void setAvatar(@DrawableRes int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1199224857")) {
            ipChange.ipc$dispatch("1199224857", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ImageView imageView = this.avatarImage;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(i);
    }

    public void setAvatar(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340525756")) {
            ipChange.ipc$dispatch("-340525756", new Object[]{this, bitmap});
            return;
        }
        ImageView imageView = this.avatarImage;
        if (imageView == null || bitmap == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
    }
}
