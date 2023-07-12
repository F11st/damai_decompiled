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
public final class MovieParams extends Message<MovieParams, a> {
    public static final ProtoAdapter<MovieParams> ADAPTER = new b();
    public static final Integer DEFAULT_FPS;
    public static final Integer DEFAULT_FRAMES;
    public static final Float DEFAULT_VIEWBOXHEIGHT;
    public static final Float DEFAULT_VIEWBOXWIDTH;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer fps;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer frames;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float viewBoxHeight;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float viewBoxWidth;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a extends Message.Builder<MovieParams, a> {
        public Float a;
        public Float b;
        public Integer c;
        public Integer d;

        @Override // com.youku.squareup.wire.Message.Builder
        /* renamed from: a */
        public MovieParams build() {
            return new MovieParams(this.a, this.b, this.c, this.d, super.buildUnknownFields());
        }

        public a b(Integer num) {
            this.c = num;
            return this;
        }

        public a c(Integer num) {
            this.d = num;
            return this;
        }

        public a d(Float f) {
            this.b = f;
            return this;
        }

        public a e(Float f) {
            this.a = f;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class b extends ProtoAdapter<MovieParams> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieParams.class);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public MovieParams decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                } else if (nextTag == 1) {
                    aVar.e(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 2) {
                    aVar.d(ProtoAdapter.FLOAT.decode(protoReader));
                } else if (nextTag == 3) {
                    aVar.b(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    aVar.c(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, MovieParams movieParams) throws IOException {
            Float f = movieParams.viewBoxWidth;
            if (f != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 1, f);
            }
            Float f2 = movieParams.viewBoxHeight;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 2, f2);
            }
            Integer num = movieParams.fps;
            if (num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 3, num);
            }
            Integer num2 = movieParams.frames;
            if (num2 != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, num2);
            }
            protoWriter.writeBytes(movieParams.unknownFields());
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(MovieParams movieParams) {
            Float f = movieParams.viewBoxWidth;
            int encodedSizeWithTag = f != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f) : 0;
            Float f2 = movieParams.viewBoxHeight;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2) : 0);
            Integer num = movieParams.fps;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num) : 0);
            Integer num2 = movieParams.frames;
            return encodedSizeWithTag3 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, num2) : 0) + movieParams.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.opensource.svgaplayer.proto.MovieParams$a, com.youku.squareup.wire.Message$Builder] */
        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public MovieParams redact(MovieParams movieParams) {
            ?? newBuilder2 = movieParams.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_VIEWBOXWIDTH = valueOf;
        DEFAULT_VIEWBOXHEIGHT = valueOf;
        DEFAULT_FPS = 0;
        DEFAULT_FRAMES = 0;
    }

    public MovieParams(Float f, Float f2, Integer num, Integer num2) {
        this(f, f2, num, num2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MovieParams) {
            MovieParams movieParams = (MovieParams) obj;
            return unknownFields().equals(movieParams.unknownFields()) && Internal.equals(this.viewBoxWidth, movieParams.viewBoxWidth) && Internal.equals(this.viewBoxHeight, movieParams.viewBoxHeight) && Internal.equals(this.fps, movieParams.fps) && Internal.equals(this.frames, movieParams.frames);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Float f = this.viewBoxWidth;
            int hashCode2 = (hashCode + (f != null ? f.hashCode() : 0)) * 37;
            Float f2 = this.viewBoxHeight;
            int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
            Integer num = this.fps;
            int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.frames;
            int hashCode5 = hashCode4 + (num2 != null ? num2.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.viewBoxWidth != null) {
            sb.append(", viewBoxWidth=");
            sb.append(this.viewBoxWidth);
        }
        if (this.viewBoxHeight != null) {
            sb.append(", viewBoxHeight=");
            sb.append(this.viewBoxHeight);
        }
        if (this.fps != null) {
            sb.append(", fps=");
            sb.append(this.fps);
        }
        if (this.frames != null) {
            sb.append(", frames=");
            sb.append(this.frames);
        }
        StringBuilder replace = sb.replace(0, 2, "MovieParams{");
        replace.append('}');
        return replace.toString();
    }

    public MovieParams(Float f, Float f2, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.viewBoxWidth = f;
        this.viewBoxHeight = f2;
        this.fps = num;
        this.frames = num2;
    }

    @Override // com.youku.squareup.wire.Message
    /* renamed from: newBuilder */
    public Message.Builder<MovieParams, a> newBuilder2() {
        a aVar = new a();
        aVar.a = this.viewBoxWidth;
        aVar.b = this.viewBoxHeight;
        aVar.c = this.fps;
        aVar.d = this.frames;
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
