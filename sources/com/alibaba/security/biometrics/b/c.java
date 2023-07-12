package com.alibaba.security.biometrics.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.biometrics.component.MediaSystemComponent;
import com.alibaba.wireless.security.SecExceptionCode;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class c implements a {
    private static final String h = "MediaService";
    protected MediaPlayer a;
    protected Context b;
    protected boolean c = false;
    protected AssetFileDescriptor d;
    protected int e;
    protected HandlerThread f;
    protected Handler g;
    private int i;
    private long j;

    public c(Context context) {
        this.b = context;
        HandlerThread handlerThread = new HandlerThread("face-sound-play-thread");
        this.f = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.f.getLooper());
        this.a = new MediaPlayer();
    }

    private static int c(MediaSystemComponent.AudioType audioType) {
        if (audioType == MediaSystemComponent.AudioType.POS_PITCH_UP) {
            return SecExceptionCode.SEC_ERROR_SAFETOKEN_INVALID_SEED;
        }
        if (audioType == MediaSystemComponent.AudioType.MOUTH) {
            return 1350;
        }
        if (audioType == MediaSystemComponent.AudioType.POS_YAW) {
            return 1600;
        }
        if (audioType == MediaSystemComponent.AudioType.BLINK) {
            return 1400;
        }
        MediaSystemComponent.AudioType audioType2 = MediaSystemComponent.AudioType.DING;
        return 200;
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final void a() {
        try {
            if (e()) {
                this.a.pause();
                this.a.stop();
            }
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
            }
        } catch (Throwable th) {
            com.alibaba.security.biometrics.c.b.a.b().a(th);
        }
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final void b() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setOnCompletionListener(null);
                this.a.reset();
                this.a.release();
                this.a = null;
            } catch (Throwable th) {
                com.alibaba.security.biometrics.c.b.a.b().a(th);
            }
        }
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final boolean d() {
        return this.c;
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final boolean e() {
        try {
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final long c() {
        long currentTimeMillis = (this.i + this.j) - System.currentTimeMillis();
        if (currentTimeMillis < 0 || currentTimeMillis > 3000) {
            return 0L;
        }
        return currentTimeMillis;
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final int a(final MediaSystemComponent.AudioType audioType) {
        if (this.c) {
            return 0;
        }
        long currentTimeMillis = (this.i + this.j) - System.currentTimeMillis();
        if (currentTimeMillis < 0 || currentTimeMillis > 3000) {
            currentTimeMillis = 0;
        }
        this.j = System.currentTimeMillis();
        this.i = c(audioType);
        if (currentTimeMillis > 0) {
            this.g.postDelayed(new Runnable() { // from class: com.alibaba.security.biometrics.b.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.b(audioType);
                }
            }, currentTimeMillis);
        } else {
            this.g.post(new Runnable() { // from class: com.alibaba.security.biometrics.b.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.b(audioType);
                }
            });
        }
        return (int) (this.i + currentTimeMillis);
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final int b(MediaSystemComponent.AudioType audioType) {
        try {
            if (this.c) {
                return 0;
            }
            this.i = c(audioType);
            int raw = audioType.getRaw(this.b);
            this.e = raw;
            if (raw == 0) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                b();
                this.a = MediaPlayer.create(this.b, this.e);
            }
            MediaPlayer mediaPlayer = this.a;
            if (mediaPlayer != null) {
                if (mediaPlayer.isPlaying()) {
                    this.a.pause();
                }
                this.a.reset();
                AssetFileDescriptor assetFileDescriptor = this.d;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                AssetFileDescriptor openRawResourceFd = this.b.getResources().openRawResourceFd(this.e);
                this.d = openRawResourceFd;
                this.a.setDataSource(openRawResourceFd.getFileDescriptor(), this.d.getStartOffset(), this.d.getLength());
                this.a.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.alibaba.security.biometrics.b.c.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                        try {
                            AssetFileDescriptor assetFileDescriptor2 = c.this.d;
                            if (assetFileDescriptor2 != null) {
                                assetFileDescriptor2.close();
                                c.this.d = null;
                            }
                        } catch (IOException unused) {
                            com.alibaba.security.common.c.a.b();
                        }
                    }
                });
                this.a.prepare();
                this.a.start();
                this.j = System.currentTimeMillis();
                this.i = this.a.getDuration();
            }
            return this.i;
        } catch (Throwable th) {
            com.alibaba.security.biometrics.c.b.a.b().a(th);
            return 0;
        }
    }

    @Override // com.alibaba.security.biometrics.b.a
    public final void a(boolean z) {
        this.c = z;
        if (z) {
            a();
        }
    }
}
