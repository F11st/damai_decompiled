package com.youku.android.player;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OprHwPlayer {
    private static final String TAG = "OPR_v2_OprHwPlayer";
    private static final boolean VERBOSE = false;
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
    private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    private AssetFileDescriptor mFileDesc;
    FrameCallback mFrameCallback;
    private volatile boolean mIsStopRequested;
    private boolean mLoop;
    private Surface mOutputSurface;
    private int mVideoHeight;
    private int mVideoWidth;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface FrameCallback {
        void loopReset();

        void postRender();

        void preRender(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class OprPlayTask implements Runnable {
        private static final int MSG_PLAY_STOPPED = 0;
        private boolean mDoLoop;
        private PlayerFeedback mFeedback;
        private OprHwPlayer mPlayer;
        private final Object mStopLock = new Object();
        private boolean mStopped = false;
        private LocalHandler mLocalHandler = new LocalHandler();

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        private static class LocalHandler extends Handler {
            private LocalHandler() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    ((PlayerFeedback) message.obj).playbackStopped();
                    return;
                }
                throw new RuntimeException("Unknown msg " + i);
            }
        }

        public OprPlayTask(OprHwPlayer oprHwPlayer, PlayerFeedback playerFeedback) {
            this.mPlayer = oprHwPlayer;
            this.mFeedback = playerFeedback;
        }

        public void execute() {
            this.mPlayer.setLoopMode(this.mDoLoop);
            OprHwPlayer.fixedThreadPool.execute(this);
        }

        public void requestStop() {
            this.mPlayer.requestStop();
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 24)
        public void run() {
            try {
                try {
                    this.mPlayer.play();
                    synchronized (this.mStopLock) {
                        this.mStopped = true;
                        this.mStopLock.notifyAll();
                    }
                    LocalHandler localHandler = this.mLocalHandler;
                    localHandler.sendMessage(localHandler.obtainMessage(0, this.mFeedback));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                synchronized (this.mStopLock) {
                    this.mStopped = true;
                    this.mStopLock.notifyAll();
                    LocalHandler localHandler2 = this.mLocalHandler;
                    localHandler2.sendMessage(localHandler2.obtainMessage(0, this.mFeedback));
                    throw th;
                }
            }
        }

        public void setLoopMode(boolean z) {
            this.mDoLoop = z;
        }

        public void waitForStop() {
            synchronized (this.mStopLock) {
                while (!this.mStopped) {
                    try {
                        this.mStopLock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface PlayerFeedback {
        void playbackStopped();
    }

    @RequiresApi(api = 24)
    public OprHwPlayer(AssetFileDescriptor assetFileDescriptor, FrameCallback frameCallback) {
        MediaExtractor mediaExtractor;
        this.mFileDesc = assetFileDescriptor;
        this.mFrameCallback = frameCallback;
        MediaExtractor mediaExtractor2 = null;
        try {
            mediaExtractor = new MediaExtractor();
        } catch (Throwable th) {
            th = th;
        }
        try {
            setDataSource(mediaExtractor, assetFileDescriptor);
            int selectTrack = selectTrack(mediaExtractor);
            if (selectTrack < 0) {
                throw new RuntimeException("No video track found in " + this.mFileDesc);
            }
            mediaExtractor.selectTrack(selectTrack);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectTrack);
            this.mVideoWidth = trackFormat.getInteger("width");
            this.mVideoHeight = trackFormat.getInteger("height");
            mediaExtractor.release();
        } catch (Throwable th2) {
            th = th2;
            mediaExtractor2 = mediaExtractor;
            if (mediaExtractor2 != null) {
                mediaExtractor2.release();
            }
            throw th;
        }
    }

    private void doExtract(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, FrameCallback frameCallback) {
        long j;
        String str;
        int dequeueOutputBuffer;
        boolean z;
        int dequeueInputBuffer;
        ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
        long j2 = -1;
        int i2 = 0;
        long j3 = -1;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (this.mIsStopRequested) {
                Log.d(TAG, "Stop requested");
                return;
            }
            if (z3 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                j = 10000;
                str = TAG;
            } else {
                if (j3 == j2) {
                    j3 = System.nanoTime();
                }
                long j4 = j3;
                int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], i2);
                if (readSampleData < 0) {
                    j = 10000;
                    str = TAG;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    j3 = j4;
                    z3 = true;
                } else {
                    j = 10000;
                    str = TAG;
                    if (mediaExtractor.getSampleTrackIndex() != i) {
                        Log.w(str, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                    }
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                    mediaExtractor.advance();
                    j3 = j4;
                }
            }
            if (!z2 && (dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, j)) != -1 && dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer == -2) {
                    mediaCodec.getOutputFormat();
                } else if (dequeueOutputBuffer < 0) {
                    throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                } else {
                    if (j3 != 0) {
                        long nanoTime = System.nanoTime();
                        Log.d(str, "startup lag " + ((nanoTime - j3) / 1000000.0d) + " ms");
                        j3 = 0L;
                    }
                    MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                    if ((bufferInfo.flags & 4) == 0) {
                        z = false;
                    } else if (this.mLoop) {
                        z = true;
                    } else {
                        z = false;
                        z2 = true;
                    }
                    boolean z4 = bufferInfo.size != 0;
                    if (z4 && frameCallback != null) {
                        frameCallback.preRender(bufferInfo.presentationTimeUs);
                    }
                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z4);
                    if (z4 && frameCallback != null) {
                        frameCallback.postRender();
                    }
                    if (z) {
                        Log.d(str, "Reached EOS, looping");
                        mediaExtractor.seekTo(0L, 2);
                        mediaCodec.flush();
                        frameCallback.loopReset();
                        z3 = false;
                    }
                }
            }
            j2 = -1;
            i2 = 0;
        }
    }

    private static int selectTrack(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
                return i;
            }
        }
        return -1;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    @RequiresApi(api = 24)
    public void play() {
        MediaCodec mediaCodec;
        Throwable th;
        MediaExtractor mediaExtractor;
        int selectTrack;
        try {
            mediaExtractor = new MediaExtractor();
            try {
                setDataSource(mediaExtractor, this.mFileDesc);
                selectTrack = selectTrack(mediaExtractor);
            } catch (Throwable th2) {
                mediaCodec = null;
                th = th2;
            }
        } catch (Throwable th3) {
            mediaCodec = null;
            th = th3;
            mediaExtractor = null;
        }
        if (selectTrack < 0) {
            throw new RuntimeException("No video track found in " + this.mFileDesc);
        }
        mediaExtractor.selectTrack(selectTrack);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectTrack);
        mediaCodec = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
        try {
            mediaCodec.configure(trackFormat, this.mOutputSurface, (MediaCrypto) null, 0);
            mediaCodec.start();
            doExtract(mediaExtractor, selectTrack, mediaCodec, this.mFrameCallback);
            mediaCodec.stop();
            mediaCodec.release();
        } catch (Throwable th4) {
            th = th4;
            try {
                th.printStackTrace();
            } finally {
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    mediaCodec.release();
                }
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            }
        }
    }

    public void requestStop() {
        this.mIsStopRequested = true;
    }

    @SuppressLint({"RestrictedApi"})
    public void setDataSource(MediaExtractor mediaExtractor, @NonNull AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor.getDeclaredLength() < 0) {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor());
        } else {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
        }
    }

    public void setLoopMode(boolean z) {
        this.mLoop = z;
    }

    public void setSurface(Surface surface) {
        this.mOutputSurface = surface;
    }
}
