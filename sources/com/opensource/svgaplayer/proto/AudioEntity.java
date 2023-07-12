package com.opensource.svgaplayer.proto;

import com.youku.squareup.wire.FieldEncoding;
import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.ProtoReader;
import com.youku.squareup.wire.ProtoWriter;
import com.youku.squareup.wire.WireField;
import com.youku.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class AudioEntity extends Message<AudioEntity, C6110a> {
    public static final String DEFAULT_AUDIOKEY = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String audioKey;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer endFrame;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer startFrame;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer startTime;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer totalTime;
    public static final ProtoAdapter<AudioEntity> ADAPTER = new C6111b();
    public static final Integer DEFAULT_STARTFRAME = 0;
    public static final Integer DEFAULT_ENDFRAME = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_TOTALTIME = 0;

    /* compiled from: Taobao */
    /* renamed from: com.opensource.svgaplayer.proto.AudioEntity$a */
    /* loaded from: classes10.dex */
    public static final class C6110a extends Message.Builder<AudioEntity, C6110a> {
        public String a;
        public Integer b;
        public Integer c;
        public Integer d;
        public Integer e;

        public C6110a a(String str) {
            this.a = str;
            return this;
        }

        @Override // com.youku.squareup.wire.Message.Builder
        /* renamed from: b */
        public AudioEntity build() {
            return new AudioEntity(this.a, this.b, this.c, this.d, this.e, super.buildUnknownFields());
        }

        public C6110a c(Integer num) {
            this.c = num;
            return this;
        }

        public C6110a d(Integer num) {
            this.b = num;
            return this;
        }

        public C6110a e(Integer num) {
            this.d = num;
            return this;
        }

        public C6110a f(Integer num) {
            this.e = num;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.opensource.svgaplayer.proto.AudioEntity$b */
    /* loaded from: classes10.dex */
    private static final class C6111b extends ProtoAdapter<AudioEntity> {
        C6111b() {
            super(FieldEncoding.LENGTH_DELIMITED, AudioEntity.class);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public AudioEntity decode(ProtoReader protoReader) throws IOException {
            C6110a c6110a = new C6110a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return c6110a.build();
                } else if (nextTag == 1) {
                    c6110a.a(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    c6110a.d(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 3) {
                    c6110a.c(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 4) {
                    c6110a.e(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    c6110a.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    c6110a.f(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, AudioEntity audioEntity) throws IOException {
            String str = audioEntity.audioKey;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            Integer num = audioEntity.startFrame;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, num);
            }
            Integer num2 = audioEntity.endFrame;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, num2);
            }
            Integer num3 = audioEntity.startTime;
            if (num3 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, num3);
            }
            Integer num4 = audioEntity.totalTime;
            if (num4 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, num4);
            }
            protoWriter.writeBytes(audioEntity.unknownFields());
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(AudioEntity audioEntity) {
            String str = audioEntity.audioKey;
            int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
            Integer num = audioEntity.startFrame;
            int encodedSizeWithTag2 = encodedSizeWithTag + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, num) : 0);
            Integer num2 = audioEntity.endFrame;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num2) : 0);
            Integer num3 = audioEntity.startTime;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (num3 != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, num3) : 0);
            Integer num4 = audioEntity.totalTime;
            return encodedSizeWithTag4 + (num4 != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, num4) : 0) + audioEntity.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.opensource.svgaplayer.proto.AudioEntity$a, com.youku.squareup.wire.Message$Builder] */
        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public AudioEntity redact(AudioEntity audioEntity) {
            ?? newBuilder2 = audioEntity.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this(str, num, num2, num3, num4, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioEntity) {
            AudioEntity audioEntity = (AudioEntity) obj;
            return unknownFields().equals(audioEntity.unknownFields()) && Internal.equals(this.audioKey, audioEntity.audioKey) && Internal.equals(this.startFrame, audioEntity.startFrame) && Internal.equals(this.endFrame, audioEntity.endFrame) && Internal.equals(this.startTime, audioEntity.startTime) && Internal.equals(this.totalTime, audioEntity.totalTime);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.audioKey;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            Integer num = this.startFrame;
            int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.endFrame;
            int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
            Integer num3 = this.startTime;
            int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
            Integer num4 = this.totalTime;
            int hashCode6 = hashCode5 + (num4 != null ? num4.hashCode() : 0);
            this.hashCode = hashCode6;
            return hashCode6;
        }
        return i;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.audioKey != null) {
            sb.append(", audioKey=");
            sb.append(this.audioKey);
        }
        if (this.startFrame != null) {
            sb.append(", startFrame=");
            sb.append(this.startFrame);
        }
        if (this.endFrame != null) {
            sb.append(", endFrame=");
            sb.append(this.endFrame);
        }
        if (this.startTime != null) {
            sb.append(", startTime=");
            sb.append(this.startTime);
        }
        if (this.totalTime != null) {
            sb.append(", totalTime=");
            sb.append(this.totalTime);
        }
        StringBuilder replace = sb.replace(0, 2, "AudioEntity{");
        replace.append('}');
        return replace.toString();
    }

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.audioKey = str;
        this.startFrame = num;
        this.endFrame = num2;
        this.startTime = num3;
        this.totalTime = num4;
    }

    @Override // com.youku.squareup.wire.Message
    /* renamed from: newBuilder */
    public Message.Builder<AudioEntity, C6110a> newBuilder2() {
        C6110a c6110a = new C6110a();
        c6110a.a = this.audioKey;
        c6110a.b = this.startFrame;
        c6110a.c = this.endFrame;
        c6110a.d = this.startTime;
        c6110a.e = this.totalTime;
        c6110a.addUnknownFields(unknownFields());
        return c6110a;
    }
}
