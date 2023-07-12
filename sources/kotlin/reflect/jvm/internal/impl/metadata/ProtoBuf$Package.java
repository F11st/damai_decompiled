package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.c;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ProtoBuf$Package extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Package> implements ProtoBuf$PackageOrBuilder {
    public static Parser<ProtoBuf$Package> PARSER = new a();
    private static final ProtoBuf$Package defaultInstance;
    private int bitField0_;
    private List<ProtoBuf$Function> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Property> property_;
    private List<ProtoBuf$TypeAlias> typeAlias_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Package, Builder> implements ProtoBuf$PackageOrBuilder {
        private int bitField0_;
        private List<ProtoBuf$Function> function_ = Collections.emptyList();
        private List<ProtoBuf$Property> property_ = Collections.emptyList();
        private List<ProtoBuf$TypeAlias> typeAlias_ = Collections.emptyList();
        private ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        private ProtoBuf$VersionRequirementTable versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$11100() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureFunctionIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1;
            }
        }

        private void ensurePropertyIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureTypeAliasIsMutable() {
            if ((this.bitField0_ & 4) != 4) {
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Package buildPartial() {
            ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(this);
            int i = this.bitField0_;
            if ((i & 1) == 1) {
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -2;
            }
            protoBuf$Package.function_ = this.function_;
            if ((this.bitField0_ & 2) == 2) {
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -3;
            }
            protoBuf$Package.property_ = this.property_;
            if ((this.bitField0_ & 4) == 4) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -5;
            }
            protoBuf$Package.typeAlias_ = this.typeAlias_;
            int i2 = (i & 8) != 8 ? 0 : 1;
            protoBuf$Package.typeTable_ = this.typeTable_;
            if ((i & 16) == 16) {
                i2 |= 2;
            }
            protoBuf$Package.versionRequirementTable_ = this.versionRequirementTable_;
            protoBuf$Package.bitField0_ = i2;
            return protoBuf$Package;
        }

        public ProtoBuf$Function getFunction(int i) {
            return this.function_.get(i);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public ProtoBuf$Property getProperty(int i) {
            return this.property_.get(i);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public ProtoBuf$TypeAlias getTypeAlias(int i) {
            return this.typeAlias_.get(i);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public ProtoBuf$TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            for (int i = 0; i < getFunctionCount(); i++) {
                if (!getFunction(i).isInitialized()) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < getPropertyCount(); i2++) {
                if (!getProperty(i2).isInitialized()) {
                    return false;
                }
            }
            for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
                if (!getTypeAlias(i3).isInitialized()) {
                    return false;
                }
            }
            return (!hasTypeTable() || getTypeTable().isInitialized()) && extensionsAreInitialized();
        }

        public Builder mergeTypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.bitField0_ & 8) == 8 && this.typeTable_ != ProtoBuf$TypeTable.getDefaultInstance()) {
                this.typeTable_ = ProtoBuf$TypeTable.newBuilder(this.typeTable_).mergeFrom(protoBuf$TypeTable).buildPartial();
            } else {
                this.typeTable_ = protoBuf$TypeTable;
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder mergeVersionRequirementTable(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if ((this.bitField0_ & 16) == 16 && this.versionRequirementTable_ != ProtoBuf$VersionRequirementTable.getDefaultInstance()) {
                this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(protoBuf$VersionRequirementTable).buildPartial();
            } else {
                this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
            }
            this.bitField0_ |= 16;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Package build() {
            ProtoBuf$Package buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ProtoBuf$Package getDefaultInstanceForType() {
            return ProtoBuf$Package.getDefaultInstance();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Package protoBuf$Package) {
            if (protoBuf$Package == ProtoBuf$Package.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$Package.function_.isEmpty()) {
                if (this.function_.isEmpty()) {
                    this.function_ = protoBuf$Package.function_;
                    this.bitField0_ &= -2;
                } else {
                    ensureFunctionIsMutable();
                    this.function_.addAll(protoBuf$Package.function_);
                }
            }
            if (!protoBuf$Package.property_.isEmpty()) {
                if (this.property_.isEmpty()) {
                    this.property_ = protoBuf$Package.property_;
                    this.bitField0_ &= -3;
                } else {
                    ensurePropertyIsMutable();
                    this.property_.addAll(protoBuf$Package.property_);
                }
            }
            if (!protoBuf$Package.typeAlias_.isEmpty()) {
                if (this.typeAlias_.isEmpty()) {
                    this.typeAlias_ = protoBuf$Package.typeAlias_;
                    this.bitField0_ &= -5;
                } else {
                    ensureTypeAliasIsMutable();
                    this.typeAlias_.addAll(protoBuf$Package.typeAlias_);
                }
            }
            if (protoBuf$Package.hasTypeTable()) {
                mergeTypeTable(protoBuf$Package.getTypeTable());
            }
            if (protoBuf$Package.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(protoBuf$Package.getVersionRequirementTable());
            }
            mergeExtensionFields(protoBuf$Package);
            setUnknownFields(getUnknownFields().b(protoBuf$Package.unknownFields));
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.Builder mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream r3, kotlin.reflect.jvm.internal.impl.protobuf.c r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.Parser<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                if (r3 == 0) goto Le
                r2.mergeFrom(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.mergeFrom(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.Builder.mergeFrom(kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream, kotlin.reflect.jvm.internal.impl.protobuf.c):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$Builder");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.a<ProtoBuf$Package> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        /* renamed from: i */
        public ProtoBuf$Package parsePartialFrom(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
            return new ProtoBuf$Package(codedInputStream, cVar);
        }
    }

    static {
        ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(true);
        defaultInstance = protoBuf$Package;
        protoBuf$Package.initFields();
    }

    public static ProtoBuf$Package getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.access$11100();
    }

    public static ProtoBuf$Package parseFrom(InputStream inputStream, c cVar) throws IOException {
        return PARSER.parseFrom(inputStream, cVar);
    }

    public ProtoBuf$Function getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<ProtoBuf$Package> getParserForType() {
        return PARSER;
    }

    public ProtoBuf$Property getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.function_.size(); i3++) {
            i2 += CodedOutputStream.s(3, this.function_.get(i3));
        }
        for (int i4 = 0; i4 < this.property_.size(); i4++) {
            i2 += CodedOutputStream.s(4, this.property_.get(i4));
        }
        for (int i5 = 0; i5 < this.typeAlias_.size(); i5++) {
            i2 += CodedOutputStream.s(5, this.typeAlias_.get(i5));
        }
        if ((this.bitField0_ & 1) == 1) {
            i2 += CodedOutputStream.s(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i2 += CodedOutputStream.s(32, this.versionRequirementTable_);
        }
        int extensionsSerializedSize = i2 + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$TypeAlias getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        for (int i = 0; i < getFunctionCount(); i++) {
            if (!getFunction(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getPropertyCount(); i2++) {
            if (!getProperty(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
            if (!getTypeAlias(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else if (!extensionsAreInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        } else {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
        for (int i = 0; i < this.function_.size(); i++) {
            codedOutputStream.d0(3, this.function_.get(i));
        }
        for (int i2 = 0; i2 < this.property_.size(); i2++) {
            codedOutputStream.d0(4, this.property_.get(i2));
        }
        for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
            codedOutputStream.d0(5, this.typeAlias_.get(i3));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.d0(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.d0(32, this.versionRequirementTable_);
        }
        newExtensionWriter.a(200, codedOutputStream);
        codedOutputStream.i0(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Package protoBuf$Package) {
        return newBuilder().mergeFrom(protoBuf$Package);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Package getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$Package(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Package, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Package(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Package(CodedInputStream codedInputStream, c cVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.a n = ByteString.n();
        CodedOutputStream J = CodedOutputStream.J(n, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    try {
                        int K = codedInputStream.K();
                        if (K != 0) {
                            if (K == 26) {
                                if (!(z2 & true)) {
                                    this.function_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.function_.add(codedInputStream.u(ProtoBuf$Function.PARSER, cVar));
                            } else if (K == 34) {
                                if (!(z2 & true)) {
                                    this.property_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.property_.add(codedInputStream.u(ProtoBuf$Property.PARSER, cVar));
                            } else if (K != 42) {
                                if (K == 242) {
                                    ProtoBuf$TypeTable.Builder builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                    ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) codedInputStream.u(ProtoBuf$TypeTable.PARSER, cVar);
                                    this.typeTable_ = protoBuf$TypeTable;
                                    if (builder != null) {
                                        builder.mergeFrom(protoBuf$TypeTable);
                                        this.typeTable_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (K != 258) {
                                    if (!parseUnknownField(codedInputStream, J, cVar, K)) {
                                    }
                                } else {
                                    ProtoBuf$VersionRequirementTable.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                    ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = (ProtoBuf$VersionRequirementTable) codedInputStream.u(ProtoBuf$VersionRequirementTable.PARSER, cVar);
                                    this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(protoBuf$VersionRequirementTable);
                                        this.versionRequirementTable_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            } else {
                                if (!(z2 & true)) {
                                    this.typeAlias_ = new ArrayList();
                                    z2 |= true;
                                }
                                this.typeAlias_.add(codedInputStream.u(ProtoBuf$TypeAlias.PARSER, cVar));
                            }
                        }
                        z = true;
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z2 & true) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if (z2 & true) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if (z2 & true) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = n.f();
                    throw th2;
                }
                this.unknownFields = n.f();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if (z2 & true) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if (z2 & true) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = n.f();
            throw th3;
        }
        this.unknownFields = n.f();
        makeExtensionsImmutable();
    }
}
