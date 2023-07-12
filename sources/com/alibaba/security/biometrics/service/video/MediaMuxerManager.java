package com.alibaba.security.biometrics.service.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder;
import com.alibaba.security.common.c.a;
import com.alibaba.security.common.d.b;
import com.alibaba.security.common.track.a.a;
import com.alibaba.security.common.track.model.TrackLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
@TargetApi(18)
/* loaded from: classes8.dex */
public class MediaMuxerManager implements OnVideoCodeCallback {
    private static final String TAG = "MediaMuxerManager";
    private final Context mContext;
    private volatile boolean mIsMuxerStart;
    private MediaMuxer mMediaMuxer;
    private Thread mMuxerThread;
    private volatile boolean mThreadLoop;
    private int mVideoTrackIndex = -1;
    private final LinkedBlockingQueue<BaseCameraVideoRecorder.MuxerData> mMuxerDatas = new LinkedBlockingQueue<>();
    private final Object lock = new Object();

    public MediaMuxerManager(Context context) {
        this.mContext = context;
    }

    private void startMuxer() {
        if (this.mIsMuxerStart) {
            return;
        }
        synchronized (this.lock) {
            this.mMediaMuxer.start();
            this.mIsMuxerStart = true;
            this.lock.notify();
        }
    }

    public boolean init(String str, int i, final String str2) {
        try {
            MediaMuxer mediaMuxer = new MediaMuxer(str, 0);
            this.mMediaMuxer = mediaMuxer;
            mediaMuxer.setOrientationHint(i);
            Thread thread = new Thread("muxer_thread") { // from class: com.alibaba.security.biometrics.service.video.MediaMuxerManager.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    synchronized (MediaMuxerManager.this.lock) {
                        try {
                            MediaMuxerManager.this.lock.wait();
                        } catch (InterruptedException unused) {
                            a.b();
                        }
                    }
                    while (MediaMuxerManager.this.mThreadLoop && !Thread.interrupted()) {
                        try {
                            BaseCameraVideoRecorder.MuxerData muxerData = (BaseCameraVideoRecorder.MuxerData) MediaMuxerManager.this.mMuxerDatas.take();
                            MediaMuxerManager.this.mMediaMuxer.writeSampleData(MediaMuxerManager.this.mVideoTrackIndex, muxerData.byteBuf, muxerData.bufferInfo);
                        } catch (InterruptedException unused2) {
                        } catch (Exception e) {
                            TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(b.a(e));
                            createSdkExceptionLog.addTag10("Android");
                            createSdkExceptionLog.setVerifyToken(str2);
                            a.C0165a.a.a(createSdkExceptionLog);
                        }
                    }
                    MediaMuxerManager.this.mMuxerDatas.clear();
                    MediaMuxerManager.this.stopMuxer();
                }
            };
            this.mMuxerThread = thread;
            thread.start();
            this.mThreadLoop = true;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.alibaba.security.biometrics.service.video.OnVideoCodeCallback
    public void outMediaFormat(int i, MediaFormat mediaFormat) {
        MediaMuxer mediaMuxer = this.mMediaMuxer;
        if (mediaMuxer != null) {
            this.mVideoTrackIndex = mediaMuxer.addTrack(mediaFormat);
        }
        startMuxer();
    }

    @Override // com.alibaba.security.biometrics.service.video.OnVideoCodeCallback
    public void outputVideoFrame(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        try {
            this.mMuxerDatas.put(new BaseCameraVideoRecorder.MuxerData(i, byteBuffer, bufferInfo));
        } catch (InterruptedException unused) {
        }
    }

    public void release() {
        this.mThreadLoop = false;
        Thread thread = this.mMuxerThread;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public void stopMuxer() {
        if (this.mIsMuxerStart) {
            this.mMediaMuxer.stop();
            this.mMediaMuxer.release();
            this.mIsMuxerStart = false;
        }
    }
}
