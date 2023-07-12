package com.alibaba.security.biometrics.service.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.alibaba.security.biometrics.jni.YuvEngineWrap;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.a.C3847g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: Taobao */
@TargetApi(18)
/* loaded from: classes8.dex */
public class MediaCodeApi15CameraVideoRecorder extends BaseCameraVideoRecorder {
    private final MediaCodec.BufferInfo mBufferInfo;
    private int mColorFormat;
    private long mDuration;
    private long mLastTimeStamp;
    protected MediaCodec mMediaCodec;
    private final MediaCodecParameterStorage mMediaCodecParameterStorage;
    private MediaMuxerManager mOnVideoCodeCallback;
    private long mPresentationTimeUs;
    private long mStartTimeStamp;
    private volatile boolean mVEncoderEnd;
    private String mVerifyToken;
    private Thread mVideoEncoderThread;
    private final LinkedBlockingQueue<byte[]> mVideoQueue;
    private byte[] mYuvBuffer;
    private boolean videoEncoderLoop;

    public MediaCodeApi15CameraVideoRecorder(Context context) {
        super(context);
        this.mColorFormat = -1;
        this.mMediaCodecParameterStorage = new MediaCodecParameterStorage(context);
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.mVideoQueue = new LinkedBlockingQueue<>();
    }

    private void calculateTimeUs(MediaCodec.BufferInfo bufferInfo) {
        long j = bufferInfo.presentationTimeUs;
        this.mLastTimeStamp = j;
        long j2 = this.mStartTimeStamp;
        if (j2 == 0) {
            this.mStartTimeStamp = j;
        } else {
            this.mDuration = j - j2;
        }
    }

    private void encodeVideoData(byte[] bArr, int i, int i2) {
        try {
            int i3 = this.mColorFormat;
            if (i3 == 21) {
                YuvEngineWrap.getInstance().Nv21ToNv12(bArr, this.mYuvBuffer, this.mWidth, this.mHeight);
            } else if (i3 == 19) {
                YuvEngineWrap.getInstance().Nv21ToI420(bArr, this.mYuvBuffer, this.mWidth, this.mHeight);
            } else if (i3 == 39) {
                System.arraycopy(bArr, 0, this.mYuvBuffer, 0, ((this.mWidth * this.mHeight) * 3) / 2);
            } else if (i3 == 20) {
                YuvEngineWrap.getInstance().Nv21ToYv12(bArr, this.mYuvBuffer, this.mWidth, this.mHeight);
            }
            ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(this.mYuvBuffer);
                long currentTimeMillis = (System.currentTimeMillis() * 1000) - this.mPresentationTimeUs;
                if (this.mVEncoderEnd) {
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, this.mYuvBuffer.length, currentTimeMillis, 4);
                } else {
                    this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, this.mYuvBuffer.length, currentTimeMillis, 0);
                }
            }
            ByteBuffer[] outputBuffers = this.mMediaCodec.getOutputBuffers();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.mMediaCodec.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                if (this.mOnVideoCodeCallback != null && !this.mVEncoderEnd) {
                    this.mOnVideoCodeCallback.outMediaFormat(0, outputFormat);
                }
            }
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer2 == null) {
                    return;
                }
                MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                if ((bufferInfo.flags & 2) != 0) {
                    bufferInfo.size = 0;
                }
                if (bufferInfo.size != 0 && this.mOnVideoCodeCallback != null && !this.mVEncoderEnd) {
                    long j = this.mLastTimeStamp;
                    if (j > 0) {
                        MediaCodec.BufferInfo bufferInfo2 = this.mBufferInfo;
                        if (bufferInfo2.presentationTimeUs < j) {
                            bufferInfo2.presentationTimeUs = j + 10000;
                        }
                    }
                    calculateTimeUs(this.mBufferInfo);
                    byteBuffer2.position(this.mBufferInfo.offset);
                    MediaCodec.BufferInfo bufferInfo3 = this.mBufferInfo;
                    byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
                    this.mOnVideoCodeCallback.outputVideoFrame(0, byteBuffer2, this.mBufferInfo);
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
                if ((this.mBufferInfo.flags & 4) != 0) {
                    this.mVideoEncoderThread.interrupt();
                    this.videoEncoderLoop = false;
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean initMediaCodec(int i, int i2, int i3, int i4, String str) {
        try {
            String encoderName = this.mMediaCodecParameterStorage.getEncoderName();
            this.mColorFormat = this.mMediaCodecParameterStorage.getEncoderColorFormat();
            if (TextUtils.isEmpty(encoderName) || this.mColorFormat == -1) {
                MediaCodecInfo selectCodec = selectCodec("video/avc");
                if (selectCodec == null) {
                    return false;
                }
                String name = selectCodec.getName();
                this.mMediaCodecParameterStorage.saveEncodeName(name);
                List<Integer> selectColorFormat = selectColorFormat(selectCodec, "video/avc");
                int i5 = 0;
                while (true) {
                    if (i5 >= selectColorFormat.size()) {
                        break;
                    } else if (isRecognizedFormat(selectColorFormat.get(i5).intValue())) {
                        this.mColorFormat = selectColorFormat.get(i5).intValue();
                        break;
                    } else {
                        i5++;
                    }
                }
                int i6 = this.mColorFormat;
                if (i6 == -1) {
                    return false;
                }
                this.mMediaCodecParameterStorage.saveColorFormat(i6);
                encoderName = name;
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
            createVideoFormat.setInteger("bitrate-mode", 2);
            createVideoFormat.setInteger("bitrate", i * i2 * 3);
            createVideoFormat.setInteger("frame-rate", i3);
            createVideoFormat.setInteger("color-format", this.mColorFormat);
            createVideoFormat.setInteger("i-frame-interval", 1);
            createVideoFormat.setInteger("rotation-degrees", i4);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(encoderName);
            this.mMediaCodec = createByCodecName;
            createByCodecName.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mMediaCodec.start();
            this.mVEncoderEnd = false;
            this.mPresentationTimeUs = System.currentTimeMillis() * 1000;
            this.mYuvBuffer = new byte[((this.mWidth * this.mHeight) * 3) / 2];
            MediaMuxerManager mediaMuxerManager = new MediaMuxerManager(this.mContext);
            this.mOnVideoCodeCallback = mediaMuxerManager;
            mediaMuxerManager.init(this.mVideoSavePath, i4, str);
            Thread thread = new Thread("video_record_thread") { // from class: com.alibaba.security.biometrics.service.video.MediaCodeApi15CameraVideoRecorder.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (MediaCodeApi15CameraVideoRecorder.this.videoEncoderLoop && !Thread.interrupted()) {
                        try {
                            MediaCodeApi15CameraVideoRecorder.this.encodeVideoData((byte[]) MediaCodeApi15CameraVideoRecorder.this.mVideoQueue.take());
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
            };
            this.mVideoEncoderThread = thread;
            this.videoEncoderLoop = true;
            thread.start();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isRecognizedFormat(int i) {
        return i == 19 || i == 21;
    }

    private void putData(byte[] bArr) {
        try {
            LinkedBlockingQueue<byte[]> linkedBlockingQueue = this.mVideoQueue;
            if (linkedBlockingQueue != null) {
                linkedBlockingQueue.put(bArr);
            }
        } catch (InterruptedException unused) {
        }
    }

    private MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    private List<Integer> selectColorFormat(MediaCodecInfo mediaCodecInfo, String str) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i >= iArr.length) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(iArr[i]));
            i++;
        }
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected boolean canNewStream() {
        return false;
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected boolean doInit(int i, int i2, int i3, int i4, String str) {
        this.mVerifyToken = str;
        return initMediaCodec(i, i2, i3, i4, str);
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected void doRecord(byte[] bArr, int i, int i2) {
        if (this.mMediaCodec == null) {
            return;
        }
        putData(bArr);
    }

    @Override // com.alibaba.security.biometrics.service.video.BaseCameraVideoRecorder
    protected void doRelease(boolean z) {
        try {
            LinkedBlockingQueue<byte[]> linkedBlockingQueue = this.mVideoQueue;
            if (linkedBlockingQueue != null && !linkedBlockingQueue.isEmpty()) {
                C3800a.d("CameraVideoRecorder", "video record exception,mVideoQueue is not empty when stop recording");
                TrackLog recordException = TrackLog.recordException(this.mVideoQueue.isEmpty(), this.mVideoQueue.size());
                C3847g unused = C3847g.C3848a.a;
                C3847g.a(this.mVerifyToken, recordException);
            }
            this.mVEncoderEnd = true;
            this.videoEncoderLoop = false;
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mMediaCodec.release();
            }
            MediaMuxerManager mediaMuxerManager = this.mOnVideoCodeCallback;
            if (mediaMuxerManager != null) {
                mediaMuxerManager.stopMuxer();
                this.mOnVideoCodeCallback.release();
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encodeVideoData(byte[] bArr) {
        encodeVideoData(bArr, this.mWidth, this.mHeight);
    }
}
