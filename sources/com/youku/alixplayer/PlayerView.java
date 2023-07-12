package com.youku.alixplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PlayerView extends FrameLayout implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    private boolean mEnableAlphaRendering;
    private IAlixPlayer mPlayer;
    private ProportionRelation mProportionRelation;
    private AttributeSet mRecordedAttributeSet;
    private int mRecordedDefStyle;
    private IRenderDevice<View> mRenderDevice;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.alixplayer.PlayerView$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation;
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType;

        static {
            int[] iArr = new int[ProportionRelation.values().length];
            $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation = iArr;
            try {
                iArr[ProportionRelation.ASPECT_RATIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation[ProportionRelation.FILL_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation[ProportionRelation.ORIGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation[ProportionRelation.SCALE_TO_FIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[RenderDeviceType.values().length];
            $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType = iArr2;
            try {
                iArr2[RenderDeviceType.SURFACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType[RenderDeviceType.TEXTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType[RenderDeviceType.MOVEABLE_TEXTURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum ProportionRelation {
        ASPECT_RATIO,
        FILL_SCREEN,
        ORIGIN,
        SCALE_TO_FIT
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum RenderDeviceType {
        SURFACE,
        TEXTURE,
        MOVEABLE_TEXTURE
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class ViewRenderDevice implements IRenderDevice<View> {
        private View mView;

        public ViewRenderDevice(View view) {
            this.mView = view;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.youku.alixplayer.IRenderDevice
        public View getRenderer() {
            return this.mView;
        }
    }

    public PlayerView(Context context) {
        this(context, null);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnableAlphaRendering = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resizeLayout(int r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            com.youku.alixplayer.IRenderDevice<android.view.View> r0 = r4.mRenderDevice
            if (r0 == 0) goto L75
            java.lang.Object r0 = r0.getRenderer()
            if (r0 == 0) goto L75
            r0 = 0
            int[] r1 = com.youku.alixplayer.PlayerView.AnonymousClass3.$SwitchMap$com$youku$alixplayer$PlayerView$ProportionRelation
            com.youku.alixplayer.PlayerView$ProportionRelation r2 = r4.mProportionRelation
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            r3 = 17
            if (r1 == r2) goto L4c
            r2 = 2
            if (r1 == r2) goto L46
            r2 = 3
            if (r1 == r2) goto L40
            r2 = 4
            if (r1 == r2) goto L24
            goto L68
        L24:
            float r5 = (float) r5
            float r6 = (float) r6
            float r5 = r5 / r6
            float r6 = (float) r7
            float r0 = (float) r8
            float r1 = r6 / r0
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 <= 0) goto L38
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            float r0 = r0 * r5
            int r5 = (int) r0
            r6.<init>(r5, r8, r3)
            goto L5f
        L38:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            float r6 = r6 / r5
            int r5 = (int) r6
            r0.<init>(r7, r5, r3)
            goto L68
        L40:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r0.<init>(r5, r6, r3)
            goto L68
        L46:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r0.<init>(r7, r8)
            goto L68
        L4c:
            float r5 = (float) r5
            float r6 = (float) r6
            float r5 = r5 / r6
            float r6 = (float) r7
            float r0 = (float) r8
            float r1 = r6 / r0
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 >= 0) goto L61
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            float r0 = r0 * r5
            int r5 = (int) r0
            r6.<init>(r5, r8, r3)
        L5f:
            r0 = r6
            goto L68
        L61:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            float r6 = r6 / r5
            int r5 = (int) r6
            r0.<init>(r7, r5, r3)
        L68:
            if (r0 == 0) goto L75
            com.youku.alixplayer.IRenderDevice<android.view.View> r5 = r4.mRenderDevice
            java.lang.Object r5 = r5.getRenderer()
            android.view.View r5 = (android.view.View) r5
            r5.setLayoutParams(r0)
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.PlayerView.resizeLayout(int, int, int, int):void");
    }

    public IAlixPlayer getPlayer() {
        return this.mPlayer;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        IAlixPlayer iAlixPlayer;
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        if (!surface.isValid() || (iAlixPlayer = this.mPlayer) == null) {
            return;
        }
        iAlixPlayer.setDisplay(this.mSurface);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IAlixPlayer iAlixPlayer = this.mPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setDisplay(null);
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
            return false;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        IAlixPlayer iAlixPlayer;
        IAlixPlayer iAlixPlayer2 = this.mPlayer;
        if (iAlixPlayer2 != null) {
            iAlixPlayer2.setDisplay(null);
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
        Surface surface2 = new Surface(surfaceTexture);
        this.mSurface = surface2;
        if (!surface2.isValid() || (iAlixPlayer = this.mPlayer) == null) {
            return;
        }
        iAlixPlayer.setDisplay(this.mSurface);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IAlixPlayer iAlixPlayer = this.mPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setDisplay(null);
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
        }
        Surface surface2 = new Surface(surfaceTexture);
        this.mSurface = surface2;
        if (this.mPlayer == null || !surface2.isValid()) {
            return;
        }
        this.mPlayer.setDisplay(this.mSurface);
    }

    public void setPlayer(IAlixPlayer iAlixPlayer) {
        this.mPlayer = iAlixPlayer;
        if (iAlixPlayer != null) {
            Surface surface = this.mSurface;
            if (surface != null && surface.isValid()) {
                this.mPlayer.setDisplay(this.mSurface);
            }
            if (this.mRenderDevice != null) {
                this.mPlayer.addOnVideoSizeChangedListener(new OnVideoSizeChangedListener() { // from class: com.youku.alixplayer.PlayerView.1
                    @Override // com.youku.alixplayer.OnVideoSizeChangedListener
                    public void onVideoSizeChange(final int i, final int i2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.youku.alixplayer.PlayerView.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PlayerView playerView = PlayerView.this;
                                playerView.resizeLayout(i, i2, playerView.getWidth(), PlayerView.this.getHeight());
                            }
                        });
                    }
                });
            }
        }
    }

    public void setProportionRelation(ProportionRelation proportionRelation) {
        this.mProportionRelation = proportionRelation;
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setRenderDevice(com.youku.alixplayer.PlayerView.RenderDeviceType r9) {
        /*
            r8 = this;
            com.youku.alixplayer.IRenderDevice<android.view.View> r0 = r8.mRenderDevice
            if (r0 == 0) goto Ld
            java.lang.Object r0 = r0.getRenderer()
            android.view.View r0 = (android.view.View) r0
            r8.removeView(r0)
        Ld:
            int[] r0 = com.youku.alixplayer.PlayerView.AnonymousClass3.$SwitchMap$com$youku$alixplayer$PlayerView$RenderDeviceType
            int r1 = r9.ordinal()
            r1 = r0[r1]
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L35
            if (r1 == r3) goto L1f
            if (r1 == r2) goto L1f
            goto L56
        L1f:
            android.view.TextureView r1 = new android.view.TextureView
            android.content.Context r5 = r8.getContext()
            r1.<init>(r5)
            r5 = 0
            r1.setOpaque(r5)
            r1.setSurfaceTextureListener(r8)
            com.youku.alixplayer.PlayerView$ViewRenderDevice r5 = new com.youku.alixplayer.PlayerView$ViewRenderDevice
            r5.<init>(r1)
            goto L54
        L35:
            android.view.SurfaceView r1 = new android.view.SurfaceView
            android.content.Context r5 = r8.getContext()
            r1.<init>(r5)
            android.view.SurfaceHolder r5 = r1.getHolder()
            r8.mSurfaceHolder = r5
            r5.addCallback(r8)
            r1.setZOrderOnTop(r4)
            android.view.SurfaceHolder r5 = r8.mSurfaceHolder
            r5.setFormat(r4)
            com.youku.alixplayer.PlayerView$ViewRenderDevice r5 = new com.youku.alixplayer.PlayerView$ViewRenderDevice
            r5.<init>(r1)
        L54:
            r8.mRenderDevice = r5
        L56:
            com.youku.alixplayer.IRenderDevice<android.view.View> r1 = r8.mRenderDevice
            if (r1 == 0) goto Lb9
            java.lang.Object r1 = r1.getRenderer()
            android.view.View r1 = (android.view.View) r1
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r6 = 17
            r7 = -1
            r5.<init>(r7, r7, r6)
            r8.addView(r1, r5)
            com.youku.alixplayer.PlayerView$2 r1 = new com.youku.alixplayer.PlayerView$2
            r1.<init>()
            r8.addOnLayoutChangeListener(r1)
            int r9 = r9.ordinal()
            r9 = r0[r9]
            if (r9 == r4) goto L9a
            if (r9 == r3) goto L80
            if (r9 == r2) goto L80
            goto La4
        L80:
            com.youku.alixplayer.IRenderDevice<android.view.View> r9 = r8.mRenderDevice
            java.lang.Object r9 = r9.getRenderer()
            android.view.TextureView r9 = (android.view.TextureView) r9
            android.graphics.SurfaceTexture r0 = r9.getSurfaceTexture()
            if (r0 == 0) goto La4
            android.view.Surface r0 = new android.view.Surface
            android.graphics.SurfaceTexture r9 = r9.getSurfaceTexture()
            r0.<init>(r9)
            r8.mSurface = r0
            goto La4
        L9a:
            android.view.SurfaceHolder r9 = r8.mSurfaceHolder
            if (r9 == 0) goto La4
            android.view.Surface r9 = r9.getSurface()
            r8.mSurface = r9
        La4:
            com.youku.alixplayer.IAlixPlayer r9 = r8.mPlayer
            if (r9 == 0) goto Lb9
            android.view.Surface r9 = r8.mSurface
            if (r9 == 0) goto Lb9
            boolean r9 = r9.isValid()
            if (r9 == 0) goto Lb9
            com.youku.alixplayer.IAlixPlayer r9 = r8.mPlayer
            android.view.Surface r0 = r8.mSurface
            r9.setDisplay(r0)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.alixplayer.PlayerView.setRenderDevice(com.youku.alixplayer.PlayerView$RenderDeviceType):void");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mSurfaceHolder = surfaceHolder;
        Surface surface = surfaceHolder.getSurface();
        this.mSurface = surface;
        if (this.mPlayer == null || surface == null || !surface.isValid()) {
            return;
        }
        this.mPlayer.setDisplay(this.mSurface);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        Surface surface = surfaceHolder.getSurface();
        this.mSurface = surface;
        if (surface == null || !surface.isValid()) {
            return;
        }
        this.mPlayer.setDisplay(this.mSurface);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IAlixPlayer iAlixPlayer = this.mPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setDisplay(null);
        }
        if (surfaceHolder.getSurface() != null) {
            surfaceHolder.getSurface().release();
        }
        this.mSurfaceHolder = null;
        this.mSurface = null;
    }
}
