package com.youku.media.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import java.nio.ByteBuffer;
import tb.jn1;

/* compiled from: Taobao */
@TargetApi(18)
/* loaded from: classes13.dex */
public class VideoSimpleDecoder {

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    private static class DecodeThread extends Thread {
        private volatile boolean mExtractFinish;
        private MediaExtractor mExtractor;
        private long mFirestFramePtsUs;
        private a mListener;
        private volatile boolean mLooping;
        private MediaCodec mMediaCodec;
        private volatile boolean mPause;
        private final Object mPauseLock;
        private volatile boolean mPauseSeek;
        private volatile boolean mSeek;
        private final Object mSeekLock;
        private volatile long mSeekTime;
        private volatile boolean mStart;
        private volatile boolean mWaiting;

        private DecodeThread(MediaExtractor mediaExtractor, MediaCodec mediaCodec) {
            this.mExtractor = mediaExtractor;
            this.mMediaCodec = mediaCodec;
            this.mPauseLock = new Object();
            this.mSeekLock = new Object();
        }

        private void onRun() {
            int dequeueInputBuffer;
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            this.mFirestFramePtsUs = -2147483648L;
            while (this.mStart) {
                synchronized (this.mPauseLock) {
                    if (this.mPause) {
                        try {
                            this.mPauseLock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (this.mSeekLock) {
                    if (this.mSeek) {
                        this.mFirestFramePtsUs = this.mSeekTime;
                        this.mExtractor.seekTo(this.mSeekTime, 0);
                        this.mMediaCodec.flush();
                        this.mSeek = false;
                        this.mExtractFinish = false;
                    }
                }
                if (!this.mExtractFinish && (dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(12000L)) >= 0) {
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    int readSampleData = this.mExtractor.readSampleData(byteBuffer, 0);
                    long sampleTime = this.mExtractor.getSampleTime();
                    if (com.youku.opengl.a.a.b) {
                        com.youku.opengl.a.a.b("VideoNormalDecoder", "presentationTime:[" + sampleTime + "] size:[" + readSampleData + jn1.ARRAY_END_STR);
                    }
                    if (readSampleData >= 0) {
                        this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, this.mExtractor.getSampleFlags() > 0 ? this.mExtractor.getSampleFlags() : 0);
                    }
                    this.mExtractFinish = !this.mExtractor.advance();
                    if (this.mExtractFinish) {
                        this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    }
                }
                int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 50000L);
                if (dequeueOutputBuffer >= 0) {
                    if ((bufferInfo.flags & 2) == 0) {
                        boolean z = bufferInfo.size != 0;
                        if (this.mFirestFramePtsUs == -2147483648L) {
                            this.mFirestFramePtsUs = bufferInfo.presentationTimeUs;
                        }
                        long j = bufferInfo.presentationTimeUs - this.mFirestFramePtsUs;
                        bufferInfo.presentationTimeUs = j;
                        a aVar = this.mListener;
                        if (aVar != null) {
                            aVar.a(j);
                            this.mListener.c(bufferInfo.presentationTimeUs);
                        }
                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z);
                        if (z) {
                            a aVar2 = this.mListener;
                            if (aVar2 != null) {
                                aVar2.d(bufferInfo.presentationTimeUs);
                            }
                            if (!this.mWaiting) {
                                a aVar3 = this.mListener;
                                if (aVar3 != null) {
                                    aVar3.b(bufferInfo.presentationTimeUs);
                                }
                            } else if (bufferInfo.presentationTimeUs >= this.mSeekTime && !this.mSeek) {
                                this.mWaiting = false;
                                a aVar4 = this.mListener;
                                if (aVar4 != null) {
                                    aVar4.b(bufferInfo.presentationTimeUs);
                                }
                                synchronized (this.mPauseLock) {
                                    if (this.mPauseSeek) {
                                        this.mPause = true;
                                        this.mPauseSeek = false;
                                    }
                                }
                            }
                        }
                        if ((bufferInfo.flags & 4) != 0) {
                            if (this.mLooping) {
                                this.mExtractFinish = false;
                                this.mFirestFramePtsUs = 0L;
                                this.mExtractor.seekTo(0L, 0);
                                this.mMediaCodec.flush();
                            } else {
                                a aVar5 = this.mListener;
                                if (aVar5 != null) {
                                    aVar5.a();
                                }
                            }
                        }
                    } else {
                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pauseDecode() {
            synchronized (this.mPauseLock) {
                this.mPause = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resumeDecode() {
            synchronized (this.mPauseLock) {
                if (this.mPause) {
                    this.mPause = false;
                    this.mPauseLock.notify();
                }
                if (this.mPauseSeek) {
                    this.mPauseSeek = false;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void seekTo(long j) {
            synchronized (this.mSeekLock) {
                this.mSeek = true;
                this.mSeekTime = j;
                this.mWaiting = true;
            }
            synchronized (this.mPauseLock) {
                if (this.mPause) {
                    this.mPause = false;
                    this.mPauseSeek = true;
                    this.mPauseLock.notify();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopDecode() {
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("VideoNormalDecoder", "Start to stop video decoding thread");
            }
            this.mStart = false;
            this.mWaiting = false;
            resumeDecode();
            interrupt();
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (com.youku.opengl.a.a.b) {
                com.youku.opengl.a.a.a("VideoNormalDecoder", "Video decoding thread stopping finish");
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                onRun();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void setListener(a aVar) {
            this.mListener = aVar;
        }

        public void setLooping(boolean z) {
            this.mLooping = z;
        }

        public void startDecode() {
            this.mStart = true;
            start();
        }
    }
}
