package com.youku.uplayer;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MediacodecWrap {
    private int audioFormatChannelCount;
    private int audioFormatSampleRate;
    private int configHeight;
    private int configWidth;
    private int dequeueOutputBufferFlags;
    private int dequeueOutputBufferOffset;
    private long dequeueOutputBufferPresentationTimeUs;
    private int dequeueOutputBufferSize;
    private int planeCount;
    private int[] rowStride;
    private int videoFormatColorFormat;
    private int videoFormatHeight;
    private int videoFormatMaxHeight;
    private int videoFormatMaxWidth;
    private int videoFormatWidth;
    private Surface videoSurface = null;
    private final String LogTag = "MediacodecWrap";
    private int createForVideo = 1;
    private boolean foundHwDecoder = false;
    private String hwDecoderName = null;
    private CodecState codecState = CodecState.Uninitialized;
    private FileOutputStream csd = null;
    private MediaCodec codec = null;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum CodecState {
        Uninitialized,
        Configured,
        Started,
        Stoped,
        Released
    }

    public MediacodecWrap() {
        Log.e("MediacodecWrap", "MediacodecWrap xxxx");
    }

    public static boolean hasHWDecoder(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        boolean z = false;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int i2 = 0;
                while (true) {
                    if (i2 >= supportedTypes.length) {
                        break;
                    } else if ((supportedTypes[i2].equalsIgnoreCase(str) || supportedTypes[i2].startsWith(str)) && codecInfoAt.getName().toUpperCase().startsWith("OMX.") && !codecInfoAt.getName().toUpperCase().startsWith("OMX.GOOGLE.")) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        return z;
    }

    public int configureAudio(String str, int i, int i2, int i3) {
        String str2;
        MediaCodec createDecoderByType;
        Log.d("MediacodecWrap", "configureAudio()");
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger("channel-count", i);
        mediaFormat.setInteger("sample-rate", i2);
        try {
            createDecoderByType = MediaCodec.createDecoderByType(str);
            this.codec = createDecoderByType;
            this.codecState = CodecState.Uninitialized;
        } catch (Exception e) {
            this.codec = null;
            str2 = "createDecoderByType exception:" + e;
        }
        try {
            createDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, i3);
            this.codecState = CodecState.Configured;
            this.createForVideo = 0;
            return 0;
        } catch (Exception unused) {
            str2 = "codec configure failed";
            Log.e("MediacodecWrap", str2);
            return -1;
        }
    }

    public int configureVideo(String str, byte[] bArr, String str2, int i, int i2, int i3, int i4, int i5, float f) {
        Log.d("MediacodecWrap", "configureVideo(), mime:" + str + ", Adaptive:" + i + ", width:" + i2 + ", height:" + i3 + ", preferColorFormat:" + i4 + ", frameRate:" + f + ", flags:" + i5 + ", containerInfo:" + str2);
        int i6 = i >> 4;
        MediaFormat mediaFormat = new MediaFormat();
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        mediaFormat.setString("mime", str);
        mediaFormat.setByteBuffer("csd-0", wrap);
        mediaFormat.setInteger("Adaptive", i);
        mediaFormat.setFloat("frame-rate", f);
        mediaFormat.setInteger("width", i2);
        mediaFormat.setInteger("height", i3);
        mediaFormat.setString("containerInfo", str2);
        if (i6 > 0) {
            mediaFormat.setInteger("max-input-size", i6);
        }
        this.configWidth = i2;
        this.configHeight = i3;
        if (this.foundHwDecoder) {
            try {
                this.codec = MediaCodec.createByCodecName(this.hwDecoderName);
            } catch (Exception unused) {
                Log.e("MediacodecWrap", "createByCodecName failed");
                this.codec = null;
                return -1;
            }
        } else {
            Log.w("MediacodecWrap", "not find hw decoer,will call createDecoderByType(), mime:" + str);
            try {
                this.codec = MediaCodec.createDecoderByType(str);
            } catch (Exception e) {
                this.codec = null;
                Log.e("MediacodecWrap", "createDecoderByType exception:" + e);
                return -1;
            }
        }
        this.codecState = CodecState.Uninitialized;
        try {
            this.codec.configure(mediaFormat, this.videoSurface, (MediaCrypto) null, i5);
            Surface surface = this.videoSurface;
            if (surface instanceof SurfaceWrap) {
                SurfaceWrap surfaceWrap = (SurfaceWrap) surface;
                surfaceWrap.SetWidth(this.configWidth);
                surfaceWrap.SetHeight(this.configHeight);
            }
            this.codecState = CodecState.Configured;
            this.createForVideo = 1;
            return 0;
        } catch (Exception e2) {
            Log.e("MediacodecWrap", "codec configure exception:" + e2);
            return -1;
        }
    }

    public int dequeueInputBuffer(long j) {
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecState != CodecState.Started) {
            Log.e("MediacodecWrap", "codec is null or not Started! dequeueInputBuffer failed!");
            return -1;
        }
        try {
            return mediaCodec.dequeueInputBuffer(j);
        } catch (Exception e) {
            Log.w("MediacodecWrap", "dequeueInputBuffer exception," + e);
            return -1;
        }
    }

    public int dequeueOutputBuffer(long j) {
        int i = -1;
        if (this.codec == null || this.codecState != CodecState.Started) {
            Log.e("MediacodecWrap", "codec is null or not Started! dequeueOutputBuffer failed!");
            return -1;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            i = this.codec.dequeueOutputBuffer(bufferInfo, j);
        } catch (Exception e) {
            Log.w("MediacodecWrap", "dequeueOutputBuffer Exception :" + e);
        }
        if (i >= 0) {
            this.dequeueOutputBufferOffset = bufferInfo.offset;
            this.dequeueOutputBufferSize = bufferInfo.size;
            this.dequeueOutputBufferPresentationTimeUs = bufferInfo.presentationTimeUs;
            this.dequeueOutputBufferFlags = bufferInfo.flags;
            return i;
        } else if (i == -2) {
            return -1012;
        } else {
            if (i == -3) {
                return -1014;
            }
            return i;
        }
    }

    public void dispose() {
        Log.d("MediacodecWrap", "dispose()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.codec.release();
            this.codecState = CodecState.Uninitialized;
        }
    }

    public int flush() {
        String str;
        CodecState codecState;
        Log.d("MediacodecWrap", "flush()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || (codecState = this.codecState) == CodecState.Uninitialized || codecState == CodecState.Released) {
            str = "codec is null or not Started! flush failed!";
        } else {
            try {
                mediaCodec.flush();
                return 0;
            } catch (Exception e) {
                str = "codec flush exception:" + e;
            }
        }
        Log.e("MediacodecWrap", str);
        return -1;
    }

    public boolean foundHwDecoder(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        Log.d("MediacodecWrap", "mime: " + str + ", Codec num: " + codecCount);
        if (codecCount < 1) {
            return false;
        }
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                Log.d("MediacodecWrap", "check decoder name: " + codecInfoAt.getName());
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int i2 = 0;
                while (true) {
                    if (i2 >= supportedTypes.length) {
                        break;
                    }
                    Log.d("MediacodecWrap", "decoder support type:" + supportedTypes[i2]);
                    if (supportedTypes[i2].equalsIgnoreCase(str) && codecInfoAt.getName().toUpperCase().startsWith("OMX.") && !codecInfoAt.getName().toUpperCase().startsWith("OMX.GOOGLE.")) {
                        this.foundHwDecoder = true;
                        this.hwDecoderName = codecInfoAt.getName();
                        Log.d("MediacodecWrap", "found available hwDecoder: " + this.hwDecoderName);
                        break;
                    }
                    i2++;
                }
                if (this.foundHwDecoder) {
                    break;
                }
            }
        }
        return this.foundHwDecoder;
    }

    public int getAudioFormatChannelCount() {
        return this.audioFormatChannelCount;
    }

    public int getAudioFormatSampleRate() {
        return this.audioFormatSampleRate;
    }

    public ByteBuffer[] getBufferPtr(int i) {
        Log.d("MediacodecWrap", "getBufferPtr()");
        if (this.codec == null) {
            return null;
        }
        return (ByteBuffer[]) new ArrayList().toArray();
    }

    public int getDdequeueOutputBufferFlags() {
        return this.dequeueOutputBufferFlags;
    }

    public int getDdequeueOutputBufferOffset() {
        return this.dequeueOutputBufferOffset;
    }

    public long getDdequeueOutputBufferPresentationTimeUs() {
        return this.dequeueOutputBufferPresentationTimeUs;
    }

    public int getDdequeueOutputBufferSize() {
        return this.dequeueOutputBufferSize;
    }

    public ByteBuffer getInputBuffer(int i) {
        Log.d("MediacodecWrap", "getInputBuffer()");
        return null;
    }

    public ByteBuffer[] getInputBuffers() {
        Log.d("MediacodecWrap", "getInputBuffers()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null) {
            return null;
        }
        try {
            return mediaCodec.getInputBuffers();
        } catch (Exception e) {
            Log.w("MediacodecWrap", "getInputBuffers Exception :" + e);
            return null;
        }
    }

    public String getName() {
        Log.d("MediacodecWrap", "getName()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null) {
            return null;
        }
        return mediaCodec.getName();
    }

    public ByteBuffer getOutputBuffer(int i) {
        Log.d("MediacodecWrap", "getOutputBuffer()");
        return null;
    }

    public ByteBuffer[] getOutputBuffers() {
        boolean z;
        Log.d("MediacodecWrap", "getOutputBuffers()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null) {
            return null;
        }
        mediaCodec.getOutputBuffers();
        try {
            ByteBuffer[] outputBuffers = this.codec.getOutputBuffers();
            int length = outputBuffers.length;
            Log.d("MediacodecWrap", "getOutputBuffers() buffer num:" + length + ", bytebufs:" + outputBuffers);
            for (int i = 0; i < length; i++) {
                if (outputBuffers[i] == null) {
                    Log.d("MediacodecWrap", "getOutputBuffers() bytebufs[" + i + "] is null!!!");
                } else if (outputBuffers[i].hasArray()) {
                }
                z = false;
                break;
            }
            z = true;
            if (!z) {
                Log.w("MediacodecWrap", "getOutputBuffers() can not access output buffer addr,we make fake one");
                int i2 = this.configWidth;
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * i2 * 3);
                outputBuffers = new ByteBuffer[length];
                for (int i3 = 0; i3 < length; i3++) {
                    outputBuffers[i3] = allocateDirect;
                }
            }
            return outputBuffers;
        } catch (Exception e) {
            Log.w("MediacodecWrap", "getOutputBuffers Exception :" + e);
            return null;
        }
    }

    public int getOutputFormat() {
        Log.d("MediacodecWrap", "getOutputFormat()");
        MediaCodec mediaCodec = this.codec;
        int i = -1;
        if (mediaCodec == null) {
            return -1;
        }
        try {
            MediaFormat outputFormat = mediaCodec.getOutputFormat();
            if (outputFormat != null) {
                if (this.createForVideo == 1) {
                    this.videoFormatWidth = outputFormat.getInteger("width");
                    this.videoFormatHeight = outputFormat.getInteger("height");
                    this.videoFormatColorFormat = outputFormat.getInteger("color-format");
                } else {
                    this.audioFormatChannelCount = outputFormat.getInteger("channel-count");
                    this.audioFormatSampleRate = outputFormat.getInteger("sample-rate");
                }
                i = 0;
            }
            Log.d("MediacodecWrap", "releaseOutputBuffer() leave, ret:" + i + ", videoFormatWidth:" + this.videoFormatWidth + ", videoFormatHeight:" + this.videoFormatHeight + ", videoFormatColorFormat:" + this.videoFormatColorFormat + ", videoFormatMaxWidth:" + this.videoFormatMaxWidth + ", videoFormatMaxHeight:" + this.videoFormatMaxHeight + ", audioFormatChannelCount:" + this.audioFormatChannelCount + ", audioFormatSampleRate:" + this.audioFormatSampleRate);
            return i;
        } catch (Exception e) {
            Log.w("MediacodecWrap", "getOutputFormat Exception :" + e);
            return -1;
        }
    }

    public int getVideoFormatColorFormat() {
        return this.videoFormatColorFormat;
    }

    public int getVideoFormatHeight() {
        return this.videoFormatHeight;
    }

    public int getVideoFormatMaxHeight() {
        return this.videoFormatMaxHeight;
    }

    public int getVideoFormatMaxWidth() {
        return this.videoFormatMaxWidth;
    }

    public int getVideoFormatWidth() {
        return this.videoFormatWidth;
    }

    public int queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecState != CodecState.Started) {
            Log.e("MediacodecWrap", "codec is null or not Started! queueInputBuffer failed!");
            return -1;
        }
        try {
            mediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            Log.w("MediacodecWrap", "queueInputBuffer exception," + e);
            return -1;
        }
    }

    public int release() {
        Log.d("MediacodecWrap", "release()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.codec = null;
            this.codecState = CodecState.Released;
            this.videoSurface = null;
            return 0;
        }
        return -1;
    }

    public int releaseOutputBuffer(int i) {
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecState != CodecState.Started) {
            Log.e("MediacodecWrap", "codec is null or not Started! releaseOutputBuffer failed!");
            return -1;
        }
        try {
            mediaCodec.releaseOutputBuffer(i, false);
            return 0;
        } catch (Exception e) {
            Log.w("MediacodecWrap", "releaseOutputBuffer Exception :" + e);
            return -1;
        }
    }

    public int renderOutputBufferAndRelease(int i) {
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecState != CodecState.Started) {
            Log.e("MediacodecWrap", "codec is null or not Started! renderOutputBufferAndRelease failed!");
            return -1;
        }
        try {
            mediaCodec.releaseOutputBuffer(i, true);
            return 0;
        } catch (Exception e) {
            Log.w("MediacodecWrap", "releaseOutputBuffer Exception :" + e);
            return -1;
        }
    }

    public void setParameters(Bundle bundle) {
    }

    public int setVideoSurface(Surface surface) {
        Log.d("MediacodecWrap", "setVideoSurface() surface:" + surface);
        this.videoSurface = surface;
        return 0;
    }

    public int setVideoSurfaceObj(Object obj) {
        Log.w("MediacodecWrap", "setVideoSurfaceObj() surfaceObj:" + obj);
        if ((obj instanceof SurfaceWrap) || (obj instanceof Surface)) {
            setVideoSurface((Surface) obj);
            return 0;
        }
        Log.w("MediacodecWrap", "setVideoSurfaceObj unsupport surfaceObj:" + obj);
        return 0;
    }

    public int start() {
        String str;
        CodecState codecState;
        Log.d("MediacodecWrap", "start()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || (codecState = this.codecState) == CodecState.Uninitialized || codecState == CodecState.Released) {
            str = "codec is null or not Configured! start failed!";
        } else {
            try {
                mediaCodec.start();
                this.codecState = CodecState.Started;
                return 0;
            } catch (Exception e) {
                str = "codec start exception:" + e;
            }
        }
        Log.e("MediacodecWrap", str);
        return -1;
    }

    public int stop() {
        String str;
        Log.d("MediacodecWrap", "stop()");
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecState != CodecState.Started) {
            str = "codec is null or not Started! stop failed!";
        } else {
            try {
                mediaCodec.stop();
                this.codecState = CodecState.Stoped;
                return 0;
            } catch (Exception e) {
                str = "codec stop exception:" + e;
            }
        }
        Log.e("MediacodecWrap", str);
        return -1;
    }
}
