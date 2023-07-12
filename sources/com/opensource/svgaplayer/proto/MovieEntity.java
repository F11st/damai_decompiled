package com.opensource.svgaplayer.proto;

import com.youku.squareup.wire.FieldEncoding;
import com.youku.squareup.wire.Message;
import com.youku.squareup.wire.ProtoAdapter;
import com.youku.squareup.wire.ProtoReader;
import com.youku.squareup.wire.ProtoWriter;
import com.youku.squareup.wire.WireField;
import com.youku.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class MovieEntity extends Message<MovieEntity, a> {
    public static final ProtoAdapter<MovieEntity> ADAPTER = new b();
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.opensource.svgaplayer.proto.AudioEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<AudioEntity> audios;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, ByteString> images;
    @WireField(adapter = "com.opensource.svgaplayer.proto.MovieParams#ADAPTER", tag = 2)
    public final MovieParams params;
    @WireField(adapter = "com.opensource.svgaplayer.proto.SpriteEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<SpriteEntity> sprites;
    @WireField(adapter = "com.youku.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String version;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a extends Message.Builder<MovieEntity, a> {
        public String a;
        public MovieParams b;
        public Map<String, ByteString> c = Internal.newMutableMap();
        public List<SpriteEntity> d = Internal.newMutableList();
        public List<AudioEntity> e = Internal.newMutableList();

        @Override // com.youku.squareup.wire.Message.Builder
        /* renamed from: a */
        public MovieEntity build() {
            return new MovieEntity(this.a, this.b, this.c, this.d, this.e, super.buildUnknownFields());
        }

        public a b(MovieParams movieParams) {
            this.b = movieParams;
            return this;
        }

        public a c(String str) {
            this.a = str;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class b extends ProtoAdapter<MovieEntity> {
        private final ProtoAdapter<Map<String, ByteString>> a;

        b() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieEntity.class);
            this.a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: a */
        public MovieEntity decode(ProtoReader protoReader) throws IOException {
            a aVar = new a();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return aVar.build();
                } else if (nextTag == 1) {
                    aVar.c(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    aVar.b(MovieParams.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    aVar.c.putAll(this.a.decode(protoReader));
                } else if (nextTag == 4) {
                    aVar.d.add(SpriteEntity.ADAPTER.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    aVar.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    aVar.e.add(AudioEntity.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: b */
        public void encode(ProtoWriter protoWriter, MovieEntity movieEntity) throws IOException {
            String str = movieEntity.version;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, str);
            }
            MovieParams movieParams = movieEntity.params;
            if (movieParams != null) {
                MovieParams.ADAPTER.encodeWithTag(protoWriter, 2, movieParams);
            }
            this.a.encodeWithTag(protoWriter, 3, movieEntity.images);
            SpriteEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 4, movieEntity.sprites);
            AudioEntity.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, movieEntity.audios);
            protoWriter.writeBytes(movieEntity.unknownFields());
        }

        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: c */
        public int encodedSize(MovieEntity movieEntity) {
            String str = movieEntity.version;
            int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
            MovieParams movieParams = movieEntity.params;
            return encodedSizeWithTag + (movieParams != null ? MovieParams.ADAPTER.encodedSizeWithTag(2, movieParams) : 0) + this.a.encodedSizeWithTag(3, movieEntity.images) + SpriteEntity.ADAPTER.asRepeated().encodedSizeWithTag(4, movieEntity.sprites) + AudioEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, movieEntity.audios) + movieEntity.unknownFields().size();
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [com.opensource.svgaplayer.proto.MovieEntity$a, com.youku.squareup.wire.Message$Builder] */
        @Override // com.youku.squareup.wire.ProtoAdapter
        /* renamed from: d */
        public MovieEntity redact(MovieEntity movieEntity) {
            ?? newBuilder2 = movieEntity.newBuilder2();
            MovieParams movieParams = newBuilder2.b;
            if (movieParams != null) {
                newBuilder2.b = MovieParams.ADAPTER.redact(movieParams);
            }
            Internal.redactElements(newBuilder2.d, SpriteEntity.ADAPTER);
            Internal.redactElements(newBuilder2.e, AudioEntity.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2) {
        this(str, movieParams, map, list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MovieEntity) {
            MovieEntity movieEntity = (MovieEntity) obj;
            return unknownFields().equals(movieEntity.unknownFields()) && Internal.equals(this.version, movieEntity.version) && Internal.equals(this.params, movieEntity.params) && this.images.equals(movieEntity.images) && this.sprites.equals(movieEntity.sprites) && this.audios.equals(movieEntity.audios);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.version;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            MovieParams movieParams = this.params;
            int hashCode3 = ((((((hashCode2 + (movieParams != null ? movieParams.hashCode() : 0)) * 37) + this.images.hashCode()) * 37) + this.sprites.hashCode()) * 37) + this.audios.hashCode();
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i;
    }

    @Override // com.youku.squareup.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.params != null) {
            sb.append(", params=");
            sb.append(this.params);
        }
        if (!this.images.isEmpty()) {
            sb.append(", images=");
            sb.append(this.images);
        }
        if (!this.sprites.isEmpty()) {
            sb.append(", sprites=");
            sb.append(this.sprites);
        }
        if (!this.audios.isEmpty()) {
            sb.append(", audios=");
            sb.append(this.audios);
        }
        StringBuilder replace = sb.replace(0, 2, "MovieEntity{");
        replace.append('}');
        return replace.toString();
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = str;
        this.params = movieParams;
        this.images = Internal.immutableCopyOf("images", map);
        this.sprites = Internal.immutableCopyOf("sprites", list);
        this.audios = Internal.immutableCopyOf("audios", list2);
    }

    @Override // com.youku.squareup.wire.Message
    /* renamed from: newBuilder */
    public Message.Builder<MovieEntity, a> newBuilder2() {
        a aVar = new a();
        aVar.a = this.version;
        aVar.b = this.params;
        aVar.c = Internal.copyOf("images", this.images);
        aVar.d = Internal.copyOf("sprites", this.sprites);
        aVar.e = Internal.copyOf("audios", this.audios);
        aVar.addUnknownFields(unknownFields());
        return aVar;
    }
}
