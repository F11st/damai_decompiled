package com.google.common.logging.nano;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.youku.danmaku.engine.BuildConfig;
import com.youku.uplayer.AliMediaPlayer;
import java.io.IOException;
import logs.proto.wireless.performance.mobile.nano.MemoryMetric$AndroidMemoryStats;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Vr$VREvent extends ExtendableMessageNano<Vr$VREvent> implements Cloneable {
    private HeadMount headMount = null;
    private Application application = null;
    private Long durationMs = null;
    private Application[] installedVrApplications = Application.emptyArray();
    private Cyclops cyclops = null;
    private QrCodeScan qrCodeScan = null;
    private String cohort = null;
    private Integer lifetimeCountBucket = null;
    private PerformanceStats performanceStats = null;
    private SensorStats sensorStats = null;
    private AudioStats audioStats = null;
    private EmbedVrWidget embedVrWidget = null;
    private VrCore vrCore = null;
    private EarthVr earthVr = null;
    private Launcher launcher = null;
    private Keyboard keyboard = null;
    private Renderer renderer = null;
    private Lullaby lullaby = null;
    private StreetView streetView = null;
    private Photos photos = null;
    private VrHome vrHome = null;
    private SdkConfigurationParams sdkConfiguration = null;
    private GConfigUpdate gConfigUpdate = null;
    private JumpInspector jumpInspector = null;
    public PhoneAlignment phoneAlignment = null;
    private VrStreaming vrStreaming = null;
    private Expeditions expeditions = null;
    private HeadTracking headTracking = null;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class EarthVr extends ExtendableMessageNano<EarthVr> implements Cloneable {
        private DoublePrecisionTransform startFromKeyholeTransform = null;
        private Transform startFromHeadTransform = null;
        private ControllerState[] controllerStates = ControllerState.emptyArray();
        private AppState appState = null;
        private View view = null;
        private Menu menu = null;
        private Preferences preferences = null;
        private Preferences preferencesDelta = null;
        private Tour tour = null;
        private Tutorial tutorial = null;
        private Actor[] actors = Actor.emptyArray();
        private Environment environment = null;
        private SplashScreen splashScreen = null;
        private Search search = null;
        private VrSdkError[] errors = VrSdkError.emptyArray();

        public EarthVr() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
            if (doublePrecisionTransform != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, doublePrecisionTransform);
            }
            Transform transform = this.startFromHeadTransform;
            if (transform != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, transform);
            }
            ControllerState[] controllerStateArr = this.controllerStates;
            int i = 0;
            if (controllerStateArr != null && controllerStateArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.controllerStates;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, messageNano);
                    }
                    i2++;
                }
            }
            AppState appState = this.appState;
            if (appState != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, appState);
            }
            View view = this.view;
            if (view != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, view);
            }
            Menu menu = this.menu;
            if (menu != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, menu);
            }
            Preferences preferences = this.preferences;
            if (preferences != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, preferences);
            }
            Tour tour = this.tour;
            if (tour != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, tour);
            }
            Tutorial tutorial = this.tutorial;
            if (tutorial != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, tutorial);
            }
            Actor[] actorArr = this.actors;
            if (actorArr != null && actorArr.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.actors;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, messageNano2);
                    }
                    i3++;
                }
            }
            Environment environment = this.environment;
            if (environment != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, environment);
            }
            SplashScreen splashScreen = this.splashScreen;
            if (splashScreen != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, splashScreen);
            }
            Search search = this.search;
            if (search != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, search);
            }
            Preferences preferences2 = this.preferencesDelta;
            if (preferences2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, preferences2);
            }
            VrSdkError[] vrSdkErrorArr = this.errors;
            if (vrSdkErrorArr != null && vrSdkErrorArr.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr3 = this.errors;
                    if (i >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i];
                    if (messageNano3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, messageNano3);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.startFromKeyholeTransform == null) {
                            this.startFromKeyholeTransform = new DoublePrecisionTransform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromKeyholeTransform);
                        break;
                    case 18:
                        if (this.startFromHeadTransform == null) {
                            this.startFromHeadTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromHeadTransform);
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        ControllerState[] controllerStateArr = this.controllerStates;
                        int length = controllerStateArr == null ? 0 : controllerStateArr.length;
                        int i = repeatedFieldArrayLength + length;
                        MessageNano[] messageNanoArr = new ControllerState[i];
                        if (length != 0) {
                            System.arraycopy(controllerStateArr, 0, messageNanoArr, 0, length);
                        }
                        while (length < i - 1) {
                            messageNanoArr[length] = new ControllerState();
                            codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        messageNanoArr[length] = new ControllerState();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        this.controllerStates = messageNanoArr;
                        break;
                    case 34:
                        if (this.appState == null) {
                            this.appState = new AppState();
                        }
                        codedInputByteBufferNano.readMessage(this.appState);
                        break;
                    case 42:
                        if (this.view == null) {
                            this.view = new View();
                        }
                        codedInputByteBufferNano.readMessage(this.view);
                        break;
                    case 50:
                        if (this.menu == null) {
                            this.menu = new Menu();
                        }
                        codedInputByteBufferNano.readMessage(this.menu);
                        break;
                    case 58:
                        if (this.preferences == null) {
                            this.preferences = new Preferences();
                        }
                        codedInputByteBufferNano.readMessage(this.preferences);
                        break;
                    case 66:
                        if (this.tour == null) {
                            this.tour = new Tour();
                        }
                        codedInputByteBufferNano.readMessage(this.tour);
                        break;
                    case 74:
                        if (this.tutorial == null) {
                            this.tutorial = new Tutorial();
                        }
                        codedInputByteBufferNano.readMessage(this.tutorial);
                        break;
                    case 82:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        Actor[] actorArr = this.actors;
                        int length2 = actorArr == null ? 0 : actorArr.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        MessageNano[] messageNanoArr2 = new Actor[i2];
                        if (length2 != 0) {
                            System.arraycopy(actorArr, 0, messageNanoArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            messageNanoArr2[length2] = new Actor();
                            codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        messageNanoArr2[length2] = new Actor();
                        codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                        this.actors = messageNanoArr2;
                        break;
                    case 90:
                        if (this.environment == null) {
                            this.environment = new Environment();
                        }
                        codedInputByteBufferNano.readMessage(this.environment);
                        break;
                    case 98:
                        if (this.splashScreen == null) {
                            this.splashScreen = new SplashScreen();
                        }
                        codedInputByteBufferNano.readMessage(this.splashScreen);
                        break;
                    case 106:
                        if (this.search == null) {
                            this.search = new Search();
                        }
                        codedInputByteBufferNano.readMessage(this.search);
                        break;
                    case 114:
                        if (this.preferencesDelta == null) {
                            this.preferencesDelta = new Preferences();
                        }
                        codedInputByteBufferNano.readMessage(this.preferencesDelta);
                        break;
                    case 122:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                        VrSdkError[] vrSdkErrorArr = this.errors;
                        int length3 = vrSdkErrorArr == null ? 0 : vrSdkErrorArr.length;
                        int i3 = repeatedFieldArrayLength3 + length3;
                        MessageNano[] messageNanoArr3 = new VrSdkError[i3];
                        if (length3 != 0) {
                            System.arraycopy(vrSdkErrorArr, 0, messageNanoArr3, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            messageNanoArr3[length3] = new VrSdkError();
                            codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        messageNanoArr3[length3] = new VrSdkError();
                        codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                        this.errors = messageNanoArr3;
                        break;
                    default:
                        if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
            if (doublePrecisionTransform != null) {
                codedOutputByteBufferNano.writeMessage(1, doublePrecisionTransform);
            }
            Transform transform = this.startFromHeadTransform;
            if (transform != null) {
                codedOutputByteBufferNano.writeMessage(2, transform);
            }
            ControllerState[] controllerStateArr = this.controllerStates;
            int i = 0;
            if (controllerStateArr != null && controllerStateArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.controllerStates;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(3, messageNano);
                    }
                    i2++;
                }
            }
            AppState appState = this.appState;
            if (appState != null) {
                codedOutputByteBufferNano.writeMessage(4, appState);
            }
            View view = this.view;
            if (view != null) {
                codedOutputByteBufferNano.writeMessage(5, view);
            }
            Menu menu = this.menu;
            if (menu != null) {
                codedOutputByteBufferNano.writeMessage(6, menu);
            }
            Preferences preferences = this.preferences;
            if (preferences != null) {
                codedOutputByteBufferNano.writeMessage(7, preferences);
            }
            Tour tour = this.tour;
            if (tour != null) {
                codedOutputByteBufferNano.writeMessage(8, tour);
            }
            Tutorial tutorial = this.tutorial;
            if (tutorial != null) {
                codedOutputByteBufferNano.writeMessage(9, tutorial);
            }
            Actor[] actorArr = this.actors;
            if (actorArr != null && actorArr.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.actors;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        codedOutputByteBufferNano.writeMessage(10, messageNano2);
                    }
                    i3++;
                }
            }
            Environment environment = this.environment;
            if (environment != null) {
                codedOutputByteBufferNano.writeMessage(11, environment);
            }
            SplashScreen splashScreen = this.splashScreen;
            if (splashScreen != null) {
                codedOutputByteBufferNano.writeMessage(12, splashScreen);
            }
            Search search = this.search;
            if (search != null) {
                codedOutputByteBufferNano.writeMessage(13, search);
            }
            Preferences preferences2 = this.preferencesDelta;
            if (preferences2 != null) {
                codedOutputByteBufferNano.writeMessage(14, preferences2);
            }
            VrSdkError[] vrSdkErrorArr = this.errors;
            if (vrSdkErrorArr != null && vrSdkErrorArr.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr3 = this.errors;
                    if (i >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i];
                    if (messageNano3 != null) {
                        codedOutputByteBufferNano.writeMessage(15, messageNano3);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Actor extends ExtendableMessageNano<Actor> implements Cloneable {
            private static volatile Actor[] _emptyArray;
            private Transform startFromHeadTransform = null;
            private ControllerState[] controllerStates = ControllerState.emptyArray();
            private Integer vrSdk = null;
            private Integer vrSystemType = null;

            public Actor() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static Actor[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Actor[0];
                        }
                    }
                }
                return _emptyArray;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Transform transform = this.startFromHeadTransform;
                if (transform != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, transform);
                }
                ControllerState[] controllerStateArr = this.controllerStates;
                if (controllerStateArr != null && controllerStateArr.length > 0) {
                    int i = 0;
                    while (true) {
                        MessageNano[] messageNanoArr = this.controllerStates;
                        if (i >= messageNanoArr.length) {
                            break;
                        }
                        MessageNano messageNano = messageNanoArr[i];
                        if (messageNano != null) {
                            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, messageNano);
                        }
                        i++;
                    }
                }
                Integer num = this.vrSdk;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num.intValue());
                }
                Integer num2 = this.vrSystemType;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 18) {
                        if (this.startFromHeadTransform == null) {
                            this.startFromHeadTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromHeadTransform);
                    } else if (readTag == 26) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        ControllerState[] controllerStateArr = this.controllerStates;
                        int length = controllerStateArr == null ? 0 : controllerStateArr.length;
                        int i = repeatedFieldArrayLength + length;
                        MessageNano[] messageNanoArr = new ControllerState[i];
                        if (length != 0) {
                            System.arraycopy(controllerStateArr, 0, messageNanoArr, 0, length);
                        }
                        while (length < i - 1) {
                            messageNanoArr[length] = new ControllerState();
                            codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        messageNanoArr[length] = new ControllerState();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        this.controllerStates = messageNanoArr;
                    } else if (readTag == 32) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.vrSdk = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 40) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.vrSystemType = Integer.valueOf(readInt322);
                        }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Transform transform = this.startFromHeadTransform;
                if (transform != null) {
                    codedOutputByteBufferNano.writeMessage(2, transform);
                }
                ControllerState[] controllerStateArr = this.controllerStates;
                if (controllerStateArr != null && controllerStateArr.length > 0) {
                    int i = 0;
                    while (true) {
                        MessageNano[] messageNanoArr = this.controllerStates;
                        if (i >= messageNanoArr.length) {
                            break;
                        }
                        MessageNano messageNano = messageNanoArr[i];
                        if (messageNano != null) {
                            codedOutputByteBufferNano.writeMessage(3, messageNano);
                        }
                        i++;
                    }
                }
                Integer num = this.vrSdk;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(4, num.intValue());
                }
                Integer num2 = this.vrSystemType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* compiled from: Taobao */
            /* loaded from: classes10.dex */
            public final class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
                private static volatile ControllerState[] _emptyArray;
                private Integer role = null;
                private Transform startFromControllerTransform = null;
                private Integer type = null;

                public ControllerState() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                public static ControllerState[] emptyArray() {
                    if (_emptyArray == null) {
                        synchronized (InternalNano.LAZY_INIT_LOCK) {
                            if (_emptyArray == null) {
                                _emptyArray = new ControllerState[0];
                            }
                        }
                    }
                    return _emptyArray;
                }

                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.role;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Transform transform = this.startFromControllerTransform;
                    if (transform != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, transform);
                    }
                    Integer num2 = this.type;
                    return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            } else {
                                this.role = Integer.valueOf(readInt32);
                            }
                        } else if (readTag == 18) {
                            if (this.startFromControllerTransform == null) {
                                this.startFromControllerTransform = new Transform();
                            }
                            codedInputByteBufferNano.readMessage(this.startFromControllerTransform);
                        } else if (readTag != 24) {
                            if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3 && readInt322 != 4) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            } else {
                                this.type = Integer.valueOf(readInt322);
                            }
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.role;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Transform transform = this.startFromControllerTransform;
                    if (transform != null) {
                        codedOutputByteBufferNano.writeMessage(2, transform);
                    }
                    Integer num2 = this.type;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* renamed from: clone */
                public final ControllerState m278clone() {
                    try {
                        ControllerState controllerState = (ControllerState) super.clone();
                        Transform transform = this.startFromControllerTransform;
                        if (transform != null) {
                            controllerState.startFromControllerTransform = transform.m446clone();
                        }
                        return controllerState;
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            /* renamed from: clone */
            public final Actor m275clone() {
                try {
                    Actor actor = (Actor) super.clone();
                    Transform transform = this.startFromHeadTransform;
                    if (transform != null) {
                        actor.startFromHeadTransform = transform.m446clone();
                    }
                    ControllerState[] controllerStateArr = this.controllerStates;
                    if (controllerStateArr != null && controllerStateArr.length > 0) {
                        actor.controllerStates = new ControllerState[controllerStateArr.length];
                        int i = 0;
                        while (true) {
                            ControllerState[] controllerStateArr2 = this.controllerStates;
                            if (i >= controllerStateArr2.length) {
                                break;
                            }
                            if (controllerStateArr2[i] != null) {
                                actor.controllerStates[i] = controllerStateArr2[i].m278clone();
                            }
                            i++;
                        }
                    }
                    return actor;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class AppState extends ExtendableMessageNano<AppState> implements Cloneable {
            private Long appModeId = null;

            public AppState() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Long l = this.appModeId;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(1, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 8) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.appModeId = Long.valueOf(codedInputByteBufferNano.readInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.appModeId;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final AppState m281clone() {
                try {
                    return (AppState) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class ControllerState extends ExtendableMessageNano<ControllerState> implements Cloneable {
            private static volatile ControllerState[] _emptyArray;
            private Integer role = null;
            private Transform startFromControllerTransform = null;

            public ControllerState() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static ControllerState[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ControllerState[0];
                        }
                    }
                }
                return _emptyArray;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.role;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Transform transform = this.startFromControllerTransform;
                return transform != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, transform) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.role = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 18) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.startFromControllerTransform == null) {
                            this.startFromControllerTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromControllerTransform);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.role;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Transform transform = this.startFromControllerTransform;
                if (transform != null) {
                    codedOutputByteBufferNano.writeMessage(2, transform);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final ControllerState m284clone() {
                try {
                    ControllerState controllerState = (ControllerState) super.clone();
                    Transform transform = this.startFromControllerTransform;
                    if (transform != null) {
                        controllerState.startFromControllerTransform = transform.m446clone();
                    }
                    return controllerState;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Environment extends ExtendableMessageNano<Environment> implements Cloneable {
            private Transform startFromEnvironmentTransform = null;

            public Environment() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Transform transform = this.startFromEnvironmentTransform;
                return transform != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, transform) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 10) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.startFromEnvironmentTransform == null) {
                            this.startFromEnvironmentTransform = new Transform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromEnvironmentTransform);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Transform transform = this.startFromEnvironmentTransform;
                if (transform != null) {
                    codedOutputByteBufferNano.writeMessage(1, transform);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Environment m287clone() {
                try {
                    Environment environment = (Environment) super.clone();
                    Transform transform = this.startFromEnvironmentTransform;
                    if (transform != null) {
                        environment.startFromEnvironmentTransform = transform.m446clone();
                    }
                    return environment;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Menu extends ExtendableMessageNano<Menu> implements Cloneable {
            private String categoryName = null;
            private Integer pageIndex = null;
            private String contentKey = null;
            private String contentName = null;

            public Menu() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.categoryName;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                Integer num = this.pageIndex;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
                }
                String str2 = this.contentKey;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str2);
                }
                String str3 = this.contentName;
                return str3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, str3) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.categoryName = codedInputByteBufferNano.readString();
                    } else if (readTag == 16) {
                        this.pageIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 26) {
                        this.contentKey = codedInputByteBufferNano.readString();
                    } else if (readTag != 34) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.contentName = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.categoryName;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                Integer num = this.pageIndex;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(2, num.intValue());
                }
                String str2 = this.contentKey;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(3, str2);
                }
                String str3 = this.contentName;
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(4, str3);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Menu m290clone() {
                try {
                    return (Menu) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Preferences extends ExtendableMessageNano<Preferences> implements Cloneable {
            private Integer labelsState = null;
            private Integer comfortModeState = null;
            private Integer startConfiguration = null;
            private Integer guestMode = null;
            private Integer humanScaleMode = null;

            public Preferences() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.labelsState;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.comfortModeState;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.startConfiguration;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                }
                Integer num4 = this.guestMode;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue());
                }
                Integer num5 = this.humanScaleMode;
                return num5 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, num5.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.labelsState = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.comfortModeState = Integer.valueOf(readInt322);
                        }
                    } else if (readTag == 24) {
                        int position3 = codedInputByteBufferNano.getPosition();
                        int readInt323 = codedInputByteBufferNano.readInt32();
                        if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position3);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.startConfiguration = Integer.valueOf(readInt323);
                        }
                    } else if (readTag == 32) {
                        int position4 = codedInputByteBufferNano.getPosition();
                        int readInt324 = codedInputByteBufferNano.readInt32();
                        if (readInt324 != 0 && readInt324 != 1 && readInt324 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position4);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.guestMode = Integer.valueOf(readInt324);
                        }
                    } else if (readTag != 40) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int position5 = codedInputByteBufferNano.getPosition();
                        int readInt325 = codedInputByteBufferNano.readInt32();
                        if (readInt325 != 0 && readInt325 != 1 && readInt325 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position5);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.humanScaleMode = Integer.valueOf(readInt325);
                        }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.labelsState;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.comfortModeState;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.startConfiguration;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                Integer num4 = this.guestMode;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num4.intValue());
                }
                Integer num5 = this.humanScaleMode;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num5.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Preferences m293clone() {
                try {
                    return (Preferences) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Search extends ExtendableMessageNano<Search> implements Cloneable {
            private String typedQuery = null;
            private String searchQuery = null;
            private Integer selectedEntityIndex = null;
            private View selectedEntityView = null;

            public Search() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.typedQuery;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.searchQuery;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
                }
                Integer num = this.selectedEntityIndex;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num.intValue());
                }
                View view = this.selectedEntityView;
                return view != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, view) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.typedQuery = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        this.searchQuery = codedInputByteBufferNano.readString();
                    } else if (readTag == 24) {
                        this.selectedEntityIndex = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag != 34) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.selectedEntityView == null) {
                            this.selectedEntityView = new View();
                        }
                        codedInputByteBufferNano.readMessage(this.selectedEntityView);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.typedQuery;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.searchQuery;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                Integer num = this.selectedEntityIndex;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(3, num.intValue());
                }
                View view = this.selectedEntityView;
                if (view != null) {
                    codedOutputByteBufferNano.writeMessage(4, view);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Search m296clone() {
                try {
                    Search search = (Search) super.clone();
                    View view = this.selectedEntityView;
                    if (view != null) {
                        search.selectedEntityView = view.m308clone();
                    }
                    return search;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class SplashScreen extends ExtendableMessageNano<SplashScreen> implements Cloneable {
            private Integer exitType = null;
            private Long numberOfViewPreloadsAttempted = null;
            private Long numberOfViewPreloadsSucceeded = null;
            private Long viewPreloadDurationMs = null;

            public SplashScreen() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.exitType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.numberOfViewPreloadsAttempted;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
                }
                Long l2 = this.numberOfViewPreloadsSucceeded;
                if (l2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, l2.longValue());
                }
                Long l3 = this.viewPreloadDurationMs;
                return l3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, l3.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.exitType = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.numberOfViewPreloadsAttempted = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 24) {
                        this.numberOfViewPreloadsSucceeded = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag != 32) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.viewPreloadDurationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.exitType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.numberOfViewPreloadsAttempted;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                Long l2 = this.numberOfViewPreloadsSucceeded;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeInt64(3, l2.longValue());
                }
                Long l3 = this.viewPreloadDurationMs;
                if (l3 != null) {
                    codedOutputByteBufferNano.writeInt64(4, l3.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final SplashScreen m299clone() {
                try {
                    return (SplashScreen) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Tour extends ExtendableMessageNano<Tour> implements Cloneable {
            private String name = null;
            private Long playbackMs = null;

            public Tour() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.name;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                Long l = this.playbackMs;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.name = codedInputByteBufferNano.readString();
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.playbackMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.name;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                Long l = this.playbackMs;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Tour m302clone() {
                try {
                    return (Tour) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Tutorial extends ExtendableMessageNano<Tutorial> implements Cloneable {
            private Integer stage = null;
            private String stageName = null;

            public Tutorial() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.stage;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                String str = this.stageName;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.stage = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag != 18) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.stageName = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.stage;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                String str = this.stageName;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Tutorial m305clone() {
                try {
                    return (Tutorial) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class View extends ExtendableMessageNano<View> implements Cloneable {
            private Integer mode = null;
            private DoublePrecisionTransform startFromKeyholeTransform = null;
            private Long simulationSecondsSinceEpoch = null;

            public View() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.mode;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                if (doublePrecisionTransform != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, doublePrecisionTransform);
                }
                Long l = this.simulationSecondsSinceEpoch;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.mode = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 18) {
                        if (this.startFromKeyholeTransform == null) {
                            this.startFromKeyholeTransform = new DoublePrecisionTransform();
                        }
                        codedInputByteBufferNano.readMessage(this.startFromKeyholeTransform);
                    } else if (readTag != 24) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.simulationSecondsSinceEpoch = Long.valueOf(codedInputByteBufferNano.readInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.mode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                if (doublePrecisionTransform != null) {
                    codedOutputByteBufferNano.writeMessage(2, doublePrecisionTransform);
                }
                Long l = this.simulationSecondsSinceEpoch;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(3, l.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final View m308clone() {
                try {
                    View view = (View) super.clone();
                    DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                    if (doublePrecisionTransform != null) {
                        view.startFromKeyholeTransform = doublePrecisionTransform.m269clone();
                    }
                    return view;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class VrSdkError extends ExtendableMessageNano<VrSdkError> implements Cloneable {
            private static volatile VrSdkError[] _emptyArray;
            private Integer shutdownReason = null;
            private Integer sdkErrorCode = null;
            private String sdkFunction = null;

            public VrSdkError() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static VrSdkError[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new VrSdkError[0];
                        }
                    }
                }
                return _emptyArray;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.shutdownReason;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.sdkErrorCode;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                String str = this.sdkFunction;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.shutdownReason = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.sdkErrorCode = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag != 26) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.sdkFunction = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.shutdownReason;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.sdkErrorCode;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                String str = this.sdkFunction;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final VrSdkError m311clone() {
                try {
                    return (VrSdkError) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final EarthVr m272clone() {
            try {
                EarthVr earthVr = (EarthVr) super.clone();
                DoublePrecisionTransform doublePrecisionTransform = this.startFromKeyholeTransform;
                if (doublePrecisionTransform != null) {
                    earthVr.startFromKeyholeTransform = doublePrecisionTransform.m269clone();
                }
                Transform transform = this.startFromHeadTransform;
                if (transform != null) {
                    earthVr.startFromHeadTransform = transform.m446clone();
                }
                ControllerState[] controllerStateArr = this.controllerStates;
                int i = 0;
                if (controllerStateArr != null && controllerStateArr.length > 0) {
                    earthVr.controllerStates = new ControllerState[controllerStateArr.length];
                    int i2 = 0;
                    while (true) {
                        ControllerState[] controllerStateArr2 = this.controllerStates;
                        if (i2 >= controllerStateArr2.length) {
                            break;
                        }
                        if (controllerStateArr2[i2] != null) {
                            earthVr.controllerStates[i2] = controllerStateArr2[i2].m284clone();
                        }
                        i2++;
                    }
                }
                AppState appState = this.appState;
                if (appState != null) {
                    earthVr.appState = appState.m281clone();
                }
                View view = this.view;
                if (view != null) {
                    earthVr.view = view.m308clone();
                }
                Menu menu = this.menu;
                if (menu != null) {
                    earthVr.menu = menu.m290clone();
                }
                Preferences preferences = this.preferences;
                if (preferences != null) {
                    earthVr.preferences = preferences.m293clone();
                }
                Preferences preferences2 = this.preferencesDelta;
                if (preferences2 != null) {
                    earthVr.preferencesDelta = preferences2.m293clone();
                }
                Tour tour = this.tour;
                if (tour != null) {
                    earthVr.tour = tour.m302clone();
                }
                Tutorial tutorial = this.tutorial;
                if (tutorial != null) {
                    earthVr.tutorial = tutorial.m305clone();
                }
                Actor[] actorArr = this.actors;
                if (actorArr != null && actorArr.length > 0) {
                    earthVr.actors = new Actor[actorArr.length];
                    int i3 = 0;
                    while (true) {
                        Actor[] actorArr2 = this.actors;
                        if (i3 >= actorArr2.length) {
                            break;
                        }
                        if (actorArr2[i3] != null) {
                            earthVr.actors[i3] = actorArr2[i3].m275clone();
                        }
                        i3++;
                    }
                }
                Environment environment = this.environment;
                if (environment != null) {
                    earthVr.environment = environment.m287clone();
                }
                SplashScreen splashScreen = this.splashScreen;
                if (splashScreen != null) {
                    earthVr.splashScreen = splashScreen.m299clone();
                }
                Search search = this.search;
                if (search != null) {
                    earthVr.search = search.m296clone();
                }
                VrSdkError[] vrSdkErrorArr = this.errors;
                if (vrSdkErrorArr != null && vrSdkErrorArr.length > 0) {
                    earthVr.errors = new VrSdkError[vrSdkErrorArr.length];
                    while (true) {
                        VrSdkError[] vrSdkErrorArr2 = this.errors;
                        if (i >= vrSdkErrorArr2.length) {
                            break;
                        }
                        if (vrSdkErrorArr2[i] != null) {
                            earthVr.errors[i] = vrSdkErrorArr2[i].m311clone();
                        }
                        i++;
                    }
                }
                return earthVr;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class VrCore extends ExtendableMessageNano<VrCore> implements Cloneable {
        private Integer errorCode = null;
        private Integer permission = null;
        private Application foregroundApplication = null;
        private Integer clientApiVersion = null;
        private Application previousForegroundApplication = null;
        private Controller controller = null;
        private DashboardEvent dashboardEvent = null;
        private Boolean isInDemoMode = null;
        private CaptureEvent captureEvent = null;

        public VrCore() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.errorCode;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.permission;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
            }
            Application application = this.foregroundApplication;
            if (application != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, application);
            }
            Integer num3 = this.clientApiVersion;
            if (num3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num3.intValue());
            }
            Application application2 = this.previousForegroundApplication;
            if (application2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, application2);
            }
            Controller controller = this.controller;
            if (controller != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, controller);
            }
            DashboardEvent dashboardEvent = this.dashboardEvent;
            if (dashboardEvent != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, dashboardEvent);
            }
            Boolean bool = this.isInDemoMode;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, bool.booleanValue());
            }
            CaptureEvent captureEvent = this.captureEvent;
            return captureEvent != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, captureEvent) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 301 && readInt32 != 510 && readInt32 != 520 && readInt32 != 401 && readInt32 != 402 && readInt32 != 501 && readInt32 != 502) {
                        switch (readInt32) {
                            case 101:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                            case 109:
                            case 110:
                            case 111:
                            case 112:
                            case 113:
                            case 114:
                            case 115:
                            case 116:
                            case 117:
                            case 118:
                            case 119:
                            case 120:
                            case 121:
                            case 122:
                            case 123:
                            case 124:
                            case 125:
                            case 126:
                            case 127:
                            case 128:
                            case SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR /* 129 */:
                                break;
                            default:
                                switch (readInt32) {
                                    case 151:
                                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_USING_FIXED_GEAR /* 152 */:
                                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_FIXED_GEAR_INDEX /* 153 */:
                                        break;
                                    default:
                                        switch (readInt32) {
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_LOADING_FACTOR_STEP /* 176 */:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD3_LOADING_FACTOR_STEP /* 177 */:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD /* 178 */:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_LOWSPEED_THRESHOLD /* 179 */:
                                            case 180:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DOWNLOAD_TIMEOUT_FACTOR /* 181 */:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_LOCAL_SOURCE /* 182 */:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_WIFI /* 183 */:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_IS_AudioMode /* 184 */:
                                            case 185:
                                            case AliMediaPlayer.UPLAYER_UPS_START_GEAR /* 186 */:
                                            case AliMediaPlayer.OPEN_RENDER_VV_BEGIN /* 187 */:
                                            case AliMediaPlayer.UPLAYER_PROPERTY_DRM_LICENSE_URI /* 188 */:
                                            case 189:
                                            case AliMediaPlayer.TYPE_SUBTITLE_LIB_PATH /* 190 */:
                                            case 191:
                                            case 192:
                                                break;
                                            default:
                                                switch (readInt32) {
                                                    case 201:
                                                    case 202:
                                                    case 203:
                                                        break;
                                                    default:
                                                        codedInputByteBufferNano.rewindToPosition(position);
                                                        storeUnknownField(codedInputByteBufferNano, readTag);
                                                        break;
                                                }
                                        }
                                }
                        }
                    }
                    this.errorCode = Integer.valueOf(readInt32);
                } else if (readTag == 16) {
                    int position2 = codedInputByteBufferNano.getPosition();
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    switch (readInt322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            this.permission = Integer.valueOf(readInt322);
                            continue;
                        default:
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            continue;
                    }
                } else if (readTag == 26) {
                    if (this.foregroundApplication == null) {
                        this.foregroundApplication = new Application();
                    }
                    codedInputByteBufferNano.readMessage(this.foregroundApplication);
                } else if (readTag == 32) {
                    this.clientApiVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 42) {
                    if (this.previousForegroundApplication == null) {
                        this.previousForegroundApplication = new Application();
                    }
                    codedInputByteBufferNano.readMessage(this.previousForegroundApplication);
                } else if (readTag == 50) {
                    if (this.controller == null) {
                        this.controller = new Controller();
                    }
                    codedInputByteBufferNano.readMessage(this.controller);
                } else if (readTag == 58) {
                    if (this.dashboardEvent == null) {
                        this.dashboardEvent = new DashboardEvent();
                    }
                    codedInputByteBufferNano.readMessage(this.dashboardEvent);
                } else if (readTag == 64) {
                    this.isInDemoMode = Boolean.valueOf(codedInputByteBufferNano.readBool());
                } else if (readTag != 74) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.captureEvent == null) {
                        this.captureEvent = new CaptureEvent();
                    }
                    codedInputByteBufferNano.readMessage(this.captureEvent);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.errorCode;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.permission;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            Application application = this.foregroundApplication;
            if (application != null) {
                codedOutputByteBufferNano.writeMessage(3, application);
            }
            Integer num3 = this.clientApiVersion;
            if (num3 != null) {
                codedOutputByteBufferNano.writeInt32(4, num3.intValue());
            }
            Application application2 = this.previousForegroundApplication;
            if (application2 != null) {
                codedOutputByteBufferNano.writeMessage(5, application2);
            }
            Controller controller = this.controller;
            if (controller != null) {
                codedOutputByteBufferNano.writeMessage(6, controller);
            }
            DashboardEvent dashboardEvent = this.dashboardEvent;
            if (dashboardEvent != null) {
                codedOutputByteBufferNano.writeMessage(7, dashboardEvent);
            }
            Boolean bool = this.isInDemoMode;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(8, bool.booleanValue());
            }
            CaptureEvent captureEvent = this.captureEvent;
            if (captureEvent != null) {
                codedOutputByteBufferNano.writeMessage(9, captureEvent);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class DashboardEvent extends ExtendableMessageNano<DashboardEvent> implements Cloneable {
            private Integer eventType = null;
            private Long clientTimestamp = null;
            private String sessionId = null;
            private Application worldApp = null;
            private MemoryMetric$AndroidMemoryStats worldAppMemoryStats = null;
            private DashboardDismissDetails dismissDetails = null;

            public DashboardEvent() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.eventType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.clientTimestamp;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
                }
                String str = this.sessionId;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
                }
                Application application = this.worldApp;
                if (application != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, application);
                }
                MemoryMetric$AndroidMemoryStats memoryMetric$AndroidMemoryStats = this.worldAppMemoryStats;
                if (memoryMetric$AndroidMemoryStats != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, memoryMetric$AndroidMemoryStats);
                }
                DashboardDismissDetails dashboardDismissDetails = this.dismissDetails;
                return dashboardDismissDetails != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, dashboardDismissDetails) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.eventType = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.clientTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 26) {
                        this.sessionId = codedInputByteBufferNano.readString();
                    } else if (readTag == 34) {
                        if (this.worldApp == null) {
                            this.worldApp = new Application();
                        }
                        codedInputByteBufferNano.readMessage(this.worldApp);
                    } else if (readTag == 42) {
                        if (this.worldAppMemoryStats == null) {
                            this.worldAppMemoryStats = new MemoryMetric$AndroidMemoryStats();
                        }
                        codedInputByteBufferNano.readMessage(this.worldAppMemoryStats);
                    } else if (readTag != 50) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.dismissDetails == null) {
                            this.dismissDetails = new DashboardDismissDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.dismissDetails);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.eventType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.clientTimestamp;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                String str = this.sessionId;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                Application application = this.worldApp;
                if (application != null) {
                    codedOutputByteBufferNano.writeMessage(4, application);
                }
                MemoryMetric$AndroidMemoryStats memoryMetric$AndroidMemoryStats = this.worldAppMemoryStats;
                if (memoryMetric$AndroidMemoryStats != null) {
                    codedOutputByteBufferNano.writeMessage(5, memoryMetric$AndroidMemoryStats);
                }
                DashboardDismissDetails dashboardDismissDetails = this.dismissDetails;
                if (dashboardDismissDetails != null) {
                    codedOutputByteBufferNano.writeMessage(6, dashboardDismissDetails);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* compiled from: Taobao */
            /* loaded from: classes10.dex */
            public final class DashboardDismissDetails extends ExtendableMessageNano<DashboardDismissDetails> implements Cloneable {
                private Integer dismissReason = null;
                private Boolean worldAppDied = null;

                public DashboardDismissDetails() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.dismissReason;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Boolean bool = this.worldAppDied;
                    return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            switch (readInt32) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    this.dismissReason = Integer.valueOf(readInt32);
                                    continue;
                                default:
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    continue;
                            }
                        } else if (readTag != 16) {
                            if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.worldAppDied = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.dismissReason;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Boolean bool = this.worldAppDied;
                    if (bool != null) {
                        codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* renamed from: clone */
                public final DashboardDismissDetails m464clone() {
                    try {
                        return (DashboardDismissDetails) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            /* renamed from: clone */
            public final DashboardEvent m461clone() {
                try {
                    DashboardEvent dashboardEvent = (DashboardEvent) super.clone();
                    Application application = this.worldApp;
                    if (application != null) {
                        dashboardEvent.worldApp = application.m248clone();
                    }
                    MemoryMetric$AndroidMemoryStats memoryMetric$AndroidMemoryStats = this.worldAppMemoryStats;
                    if (memoryMetric$AndroidMemoryStats != null) {
                        dashboardEvent.worldAppMemoryStats = memoryMetric$AndroidMemoryStats.m1287clone();
                    }
                    DashboardDismissDetails dashboardDismissDetails = this.dismissDetails;
                    if (dashboardDismissDetails != null) {
                        dashboardEvent.dismissDetails = dashboardDismissDetails.m464clone();
                    }
                    return dashboardEvent;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class CaptureEvent extends ExtendableMessageNano<CaptureEvent> implements Cloneable {
            private Boolean initiatedByController = null;

            public CaptureEvent() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Boolean bool = this.initiatedByController;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 8) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.initiatedByController = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Boolean bool = this.initiatedByController;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(1, bool.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final CaptureEvent m455clone() {
                try {
                    return (CaptureEvent) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Controller extends ExtendableMessageNano<Controller> implements Cloneable {
            private String manufacturer = null;
            private String model = null;
            private String firmware = null;
            private String availableFirmware = null;
            private String softwareRevision = null;
            private Boolean isConnected = null;
            private Integer batteryLevel = null;
            private String hardwareRevision = null;
            private Integer xRailCount = null;
            private Integer yRailCount = null;
            private Integer zRailCount = null;
            private Integer sampleCount = null;
            private Integer sensorType = null;
            private Integer axis = null;
            private Integer otaRetries = null;
            private Integer totalControllerLagCount = null;

            public Controller() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.manufacturer;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.model;
                if (str2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
                }
                String str3 = this.firmware;
                if (str3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str3);
                }
                String str4 = this.availableFirmware;
                if (str4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, str4);
                }
                String str5 = this.softwareRevision;
                if (str5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, str5);
                }
                Integer num = this.batteryLevel;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num.intValue());
                }
                String str6 = this.hardwareRevision;
                if (str6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str6);
                }
                Integer num2 = this.xRailCount;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num2.intValue());
                }
                Integer num3 = this.yRailCount;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, num3.intValue());
                }
                Integer num4 = this.zRailCount;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, num4.intValue());
                }
                Integer num5 = this.sampleCount;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, num5.intValue());
                }
                Integer num6 = this.sensorType;
                if (num6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, num6.intValue());
                }
                Integer num7 = this.axis;
                if (num7 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, num7.intValue());
                }
                Integer num8 = this.otaRetries;
                if (num8 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, num8.intValue());
                }
                Integer num9 = this.totalControllerLagCount;
                if (num9 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, num9.intValue());
                }
                Boolean bool = this.isConnected;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(16, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 10:
                            this.manufacturer = codedInputByteBufferNano.readString();
                            break;
                        case 18:
                            this.model = codedInputByteBufferNano.readString();
                            break;
                        case 26:
                            this.firmware = codedInputByteBufferNano.readString();
                            break;
                        case 34:
                            this.availableFirmware = codedInputByteBufferNano.readString();
                            break;
                        case 42:
                            this.softwareRevision = codedInputByteBufferNano.readString();
                            break;
                        case 48:
                            this.batteryLevel = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 58:
                            this.hardwareRevision = codedInputByteBufferNano.readString();
                            break;
                        case 64:
                            this.xRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 72:
                            this.yRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 80:
                            this.zRailCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 88:
                            this.sampleCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 96:
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.sensorType = Integer.valueOf(readInt32);
                                break;
                            }
                        case 104:
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.axis = Integer.valueOf(readInt322);
                                break;
                            }
                        case 112:
                            this.otaRetries = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 120:
                            this.totalControllerLagCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 128:
                            this.isConnected = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        default:
                            if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.manufacturer;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.model;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                String str3 = this.firmware;
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(3, str3);
                }
                String str4 = this.availableFirmware;
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(4, str4);
                }
                String str5 = this.softwareRevision;
                if (str5 != null) {
                    codedOutputByteBufferNano.writeString(5, str5);
                }
                Integer num = this.batteryLevel;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(6, num.intValue());
                }
                String str6 = this.hardwareRevision;
                if (str6 != null) {
                    codedOutputByteBufferNano.writeString(7, str6);
                }
                Integer num2 = this.xRailCount;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num2.intValue());
                }
                Integer num3 = this.yRailCount;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(9, num3.intValue());
                }
                Integer num4 = this.zRailCount;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(10, num4.intValue());
                }
                Integer num5 = this.sampleCount;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(11, num5.intValue());
                }
                Integer num6 = this.sensorType;
                if (num6 != null) {
                    codedOutputByteBufferNano.writeInt32(12, num6.intValue());
                }
                Integer num7 = this.axis;
                if (num7 != null) {
                    codedOutputByteBufferNano.writeInt32(13, num7.intValue());
                }
                Integer num8 = this.otaRetries;
                if (num8 != null) {
                    codedOutputByteBufferNano.writeInt32(14, num8.intValue());
                }
                Integer num9 = this.totalControllerLagCount;
                if (num9 != null) {
                    codedOutputByteBufferNano.writeInt32(15, num9.intValue());
                }
                Boolean bool = this.isConnected;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(16, bool.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Controller m458clone() {
                try {
                    return (Controller) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final VrCore m452clone() {
            try {
                VrCore vrCore = (VrCore) super.clone();
                Application application = this.foregroundApplication;
                if (application != null) {
                    vrCore.foregroundApplication = application.m248clone();
                }
                Application application2 = this.previousForegroundApplication;
                if (application2 != null) {
                    vrCore.previousForegroundApplication = application2.m248clone();
                }
                Controller controller = this.controller;
                if (controller != null) {
                    vrCore.controller = controller.m458clone();
                }
                DashboardEvent dashboardEvent = this.dashboardEvent;
                if (dashboardEvent != null) {
                    vrCore.dashboardEvent = dashboardEvent.m461clone();
                }
                CaptureEvent captureEvent = this.captureEvent;
                if (captureEvent != null) {
                    vrCore.captureEvent = captureEvent.m455clone();
                }
                return vrCore;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class VrHome extends ExtendableMessageNano<VrHome> implements Cloneable {
        private Setup setup = null;
        private GConfigUpdate gConfigUpdate = null;
        private GetViewerClick getViewerClick = null;
        private DialogAction dialogAction = null;

        public VrHome() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Setup setup = this.setup;
            if (setup != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, setup);
            }
            GConfigUpdate gConfigUpdate = this.gConfigUpdate;
            if (gConfigUpdate != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gConfigUpdate);
            }
            GetViewerClick getViewerClick = this.getViewerClick;
            if (getViewerClick != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, getViewerClick);
            }
            DialogAction dialogAction = this.dialogAction;
            return dialogAction != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, dialogAction) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.setup == null) {
                        this.setup = new Setup();
                    }
                    codedInputByteBufferNano.readMessage(this.setup);
                } else if (readTag == 18) {
                    if (this.gConfigUpdate == null) {
                        this.gConfigUpdate = new GConfigUpdate();
                    }
                    codedInputByteBufferNano.readMessage(this.gConfigUpdate);
                } else if (readTag == 26) {
                    if (this.getViewerClick == null) {
                        this.getViewerClick = new GetViewerClick();
                    }
                    codedInputByteBufferNano.readMessage(this.getViewerClick);
                } else if (readTag != 34) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.dialogAction == null) {
                        this.dialogAction = new DialogAction();
                    }
                    codedInputByteBufferNano.readMessage(this.dialogAction);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Setup setup = this.setup;
            if (setup != null) {
                codedOutputByteBufferNano.writeMessage(1, setup);
            }
            GConfigUpdate gConfigUpdate = this.gConfigUpdate;
            if (gConfigUpdate != null) {
                codedOutputByteBufferNano.writeMessage(2, gConfigUpdate);
            }
            GetViewerClick getViewerClick = this.getViewerClick;
            if (getViewerClick != null) {
                codedOutputByteBufferNano.writeMessage(3, getViewerClick);
            }
            DialogAction dialogAction = this.dialogAction;
            if (dialogAction != null) {
                codedOutputByteBufferNano.writeMessage(4, dialogAction);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Setup extends ExtendableMessageNano<Setup> implements Cloneable {
            private View view = null;
            private StepStateChange stepStateChange = null;

            public Setup() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                View view = this.view;
                if (view != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, view);
                }
                StepStateChange stepStateChange = this.stepStateChange;
                return stepStateChange != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, stepStateChange) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.view == null) {
                            this.view = new View();
                        }
                        codedInputByteBufferNano.readMessage(this.view);
                    } else if (readTag != 18) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.stepStateChange == null) {
                            this.stepStateChange = new StepStateChange();
                        }
                        codedInputByteBufferNano.readMessage(this.stepStateChange);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                View view = this.view;
                if (view != null) {
                    codedOutputByteBufferNano.writeMessage(1, view);
                }
                StepStateChange stepStateChange = this.stepStateChange;
                if (stepStateChange != null) {
                    codedOutputByteBufferNano.writeMessage(2, stepStateChange);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* compiled from: Taobao */
            /* loaded from: classes10.dex */
            public final class StepStateChange extends ExtendableMessageNano<StepStateChange> implements Cloneable {
                private Integer step = null;
                private Integer previousStepState = null;
                private Integer newStepState = null;

                public StepStateChange() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.step;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Integer num2 = this.previousStepState;
                    if (num2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                    }
                    Integer num3 = this.newStepState;
                    return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            switch (readInt32) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                    this.step = Integer.valueOf(readInt32);
                                    continue;
                                default:
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    continue;
                            }
                        } else if (readTag == 16) {
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3 && readInt322 != 4) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            } else {
                                this.previousStepState = Integer.valueOf(readInt322);
                            }
                        } else if (readTag != 24) {
                            if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int position3 = codedInputByteBufferNano.getPosition();
                            int readInt323 = codedInputByteBufferNano.readInt32();
                            if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2 && readInt323 != 3 && readInt323 != 4) {
                                codedInputByteBufferNano.rewindToPosition(position3);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                            } else {
                                this.newStepState = Integer.valueOf(readInt323);
                            }
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.step;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Integer num2 = this.previousStepState;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                    }
                    Integer num3 = this.newStepState;
                    if (num3 != null) {
                        codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* renamed from: clone */
                public final StepStateChange m479clone() {
                    try {
                        return (StepStateChange) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            /* compiled from: Taobao */
            /* loaded from: classes10.dex */
            public final class View extends ExtendableMessageNano<View> implements Cloneable {
                private Integer step = null;
                private Integer page = null;

                public View() {
                    this.unknownFieldData = null;
                    this.cachedSize = -1;
                }

                protected final int computeSerializedSize() {
                    int computeSerializedSize = super.computeSerializedSize();
                    Integer num = this.step;
                    if (num != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                    }
                    Integer num2 = this.page;
                    return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
                }

                public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                    while (true) {
                        int readTag = codedInputByteBufferNano.readTag();
                        if (readTag == 0) {
                            return this;
                        }
                        if (readTag == 8) {
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            switch (readInt32) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                    this.step = Integer.valueOf(readInt32);
                                    continue;
                                default:
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    storeUnknownField(codedInputByteBufferNano, readTag);
                                    continue;
                            }
                        } else if (readTag != 16) {
                            if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.page = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        }
                    }
                }

                public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                    Integer num = this.step;
                    if (num != null) {
                        codedOutputByteBufferNano.writeInt32(1, num.intValue());
                    }
                    Integer num2 = this.page;
                    if (num2 != null) {
                        codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                    }
                    super.writeTo(codedOutputByteBufferNano);
                }

                /* renamed from: clone */
                public final View m482clone() {
                    try {
                        return (View) super.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new AssertionError(e);
                    }
                }
            }

            /* renamed from: clone */
            public final Setup m476clone() {
                try {
                    Setup setup = (Setup) super.clone();
                    View view = this.view;
                    if (view != null) {
                        setup.view = view.m482clone();
                    }
                    StepStateChange stepStateChange = this.stepStateChange;
                    if (stepStateChange != null) {
                        setup.stepStateChange = stepStateChange.m479clone();
                    }
                    return setup;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class DialogAction extends ExtendableMessageNano<DialogAction> implements Cloneable {
            private Integer type = null;
            private Integer actionType = null;

            public DialogAction() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.actionType;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.type = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.actionType = Integer.valueOf(readInt322);
                        }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.actionType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final DialogAction m470clone() {
                try {
                    return (DialogAction) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class GetViewerClick extends ExtendableMessageNano<GetViewerClick> implements Cloneable {
            private String url = null;

            public GetViewerClick() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.url;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 10) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.url = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.url;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final GetViewerClick m473clone() {
                try {
                    return (GetViewerClick) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final VrHome m467clone() {
            try {
                VrHome vrHome = (VrHome) super.clone();
                Setup setup = this.setup;
                if (setup != null) {
                    vrHome.setup = setup.m476clone();
                }
                GConfigUpdate gConfigUpdate = this.gConfigUpdate;
                if (gConfigUpdate != null) {
                    vrHome.gConfigUpdate = gConfigUpdate.m326clone();
                }
                GetViewerClick getViewerClick = this.getViewerClick;
                if (getViewerClick != null) {
                    vrHome.getViewerClick = getViewerClick.m473clone();
                }
                DialogAction dialogAction = this.dialogAction;
                if (dialogAction != null) {
                    vrHome.dialogAction = dialogAction.m470clone();
                }
                return vrHome;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    public Vr$VREvent() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
    }

    protected final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        HeadMount headMount = this.headMount;
        if (headMount != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, headMount);
        }
        Application application = this.application;
        if (application != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, application);
        }
        Long l = this.durationMs;
        if (l != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, l.longValue());
        }
        Application[] applicationArr = this.installedVrApplications;
        if (applicationArr != null && applicationArr.length > 0) {
            int i = 0;
            while (true) {
                MessageNano[] messageNanoArr = this.installedVrApplications;
                if (i >= messageNanoArr.length) {
                    break;
                }
                MessageNano messageNano = messageNanoArr[i];
                if (messageNano != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, messageNano);
                }
                i++;
            }
        }
        Cyclops cyclops = this.cyclops;
        if (cyclops != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cyclops);
        }
        QrCodeScan qrCodeScan = this.qrCodeScan;
        if (qrCodeScan != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, qrCodeScan);
        }
        String str = this.cohort;
        if (str != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str);
        }
        Integer num = this.lifetimeCountBucket;
        if (num != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num.intValue());
        }
        PerformanceStats performanceStats = this.performanceStats;
        if (performanceStats != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, performanceStats);
        }
        SensorStats sensorStats = this.sensorStats;
        if (sensorStats != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, sensorStats);
        }
        AudioStats audioStats = this.audioStats;
        if (audioStats != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, audioStats);
        }
        EmbedVrWidget embedVrWidget = this.embedVrWidget;
        if (embedVrWidget != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, embedVrWidget);
        }
        VrCore vrCore = this.vrCore;
        if (vrCore != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, vrCore);
        }
        EarthVr earthVr = this.earthVr;
        if (earthVr != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, earthVr);
        }
        Launcher launcher = this.launcher;
        if (launcher != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, launcher);
        }
        Keyboard keyboard = this.keyboard;
        if (keyboard != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, keyboard);
        }
        Renderer renderer = this.renderer;
        if (renderer != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, renderer);
        }
        Lullaby lullaby = this.lullaby;
        if (lullaby != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, lullaby);
        }
        StreetView streetView = this.streetView;
        if (streetView != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, streetView);
        }
        Photos photos = this.photos;
        if (photos != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, photos);
        }
        VrHome vrHome = this.vrHome;
        if (vrHome != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, vrHome);
        }
        SdkConfigurationParams sdkConfigurationParams = this.sdkConfiguration;
        if (sdkConfigurationParams != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, sdkConfigurationParams);
        }
        GConfigUpdate gConfigUpdate = this.gConfigUpdate;
        if (gConfigUpdate != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, gConfigUpdate);
        }
        JumpInspector jumpInspector = this.jumpInspector;
        if (jumpInspector != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, jumpInspector);
        }
        PhoneAlignment phoneAlignment = this.phoneAlignment;
        if (phoneAlignment != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, phoneAlignment);
        }
        VrStreaming vrStreaming = this.vrStreaming;
        if (vrStreaming != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(26, vrStreaming);
        }
        Expeditions expeditions = this.expeditions;
        if (expeditions != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, expeditions);
        }
        HeadTracking headTracking = this.headTracking;
        return headTracking != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(28, headTracking) : computeSerializedSize;
    }

    public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.headMount == null) {
                        this.headMount = new HeadMount();
                    }
                    codedInputByteBufferNano.readMessage(this.headMount);
                    break;
                case 18:
                    if (this.application == null) {
                        this.application = new Application();
                    }
                    codedInputByteBufferNano.readMessage(this.application);
                    break;
                case 24:
                    this.durationMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    Application[] applicationArr = this.installedVrApplications;
                    int length = applicationArr == null ? 0 : applicationArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new Application[i];
                    if (length != 0) {
                        System.arraycopy(applicationArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new Application();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new Application();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.installedVrApplications = messageNanoArr;
                    break;
                case 42:
                    if (this.cyclops == null) {
                        this.cyclops = new Cyclops();
                    }
                    codedInputByteBufferNano.readMessage(this.cyclops);
                    break;
                case 50:
                    if (this.qrCodeScan == null) {
                        this.qrCodeScan = new QrCodeScan();
                    }
                    codedInputByteBufferNano.readMessage(this.qrCodeScan);
                    break;
                case 58:
                    this.cohort = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 11 && readInt32 != 21) {
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                break;
                            default:
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                        }
                    }
                    this.lifetimeCountBucket = Integer.valueOf(readInt32);
                    break;
                case 74:
                    if (this.performanceStats == null) {
                        this.performanceStats = new PerformanceStats();
                    }
                    codedInputByteBufferNano.readMessage(this.performanceStats);
                    break;
                case 82:
                    if (this.sensorStats == null) {
                        this.sensorStats = new SensorStats();
                    }
                    codedInputByteBufferNano.readMessage(this.sensorStats);
                    break;
                case 90:
                    if (this.audioStats == null) {
                        this.audioStats = new AudioStats();
                    }
                    codedInputByteBufferNano.readMessage(this.audioStats);
                    break;
                case 98:
                    if (this.embedVrWidget == null) {
                        this.embedVrWidget = new EmbedVrWidget();
                    }
                    codedInputByteBufferNano.readMessage(this.embedVrWidget);
                    break;
                case 106:
                    if (this.vrCore == null) {
                        this.vrCore = new VrCore();
                    }
                    codedInputByteBufferNano.readMessage(this.vrCore);
                    break;
                case 114:
                    if (this.earthVr == null) {
                        this.earthVr = new EarthVr();
                    }
                    codedInputByteBufferNano.readMessage(this.earthVr);
                    break;
                case 122:
                    if (this.launcher == null) {
                        this.launcher = new Launcher();
                    }
                    codedInputByteBufferNano.readMessage(this.launcher);
                    break;
                case 130:
                    if (this.keyboard == null) {
                        this.keyboard = new Keyboard();
                    }
                    codedInputByteBufferNano.readMessage(this.keyboard);
                    break;
                case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR /* 138 */:
                    if (this.renderer == null) {
                        this.renderer = new Renderer();
                    }
                    codedInputByteBufferNano.readMessage(this.renderer);
                    break;
                case 146:
                    if (this.lullaby == null) {
                        this.lullaby = new Lullaby();
                    }
                    codedInputByteBufferNano.readMessage(this.lullaby);
                    break;
                case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER /* 154 */:
                    if (this.streetView == null) {
                        this.streetView = new StreetView();
                    }
                    codedInputByteBufferNano.readMessage(this.streetView);
                    break;
                case 162:
                    if (this.photos == null) {
                        this.photos = new Photos();
                    }
                    codedInputByteBufferNano.readMessage(this.photos);
                    break;
                case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_NEXT_SEGMENT_SPEED_CALC_COUNT /* 170 */:
                    if (this.vrHome == null) {
                        this.vrHome = new VrHome();
                    }
                    codedInputByteBufferNano.readMessage(this.vrHome);
                    break;
                case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_JITTER_MONITOR_DURATION_THRESHOLD /* 178 */:
                    if (this.sdkConfiguration == null) {
                        this.sdkConfiguration = new SdkConfigurationParams();
                    }
                    codedInputByteBufferNano.readMessage(this.sdkConfiguration);
                    break;
                case AliMediaPlayer.UPLAYER_UPS_START_GEAR /* 186 */:
                    if (this.gConfigUpdate == null) {
                        this.gConfigUpdate = new GConfigUpdate();
                    }
                    codedInputByteBufferNano.readMessage(this.gConfigUpdate);
                    break;
                case 194:
                    if (this.jumpInspector == null) {
                        this.jumpInspector = new JumpInspector();
                    }
                    codedInputByteBufferNano.readMessage(this.jumpInspector);
                    break;
                case 202:
                    if (this.phoneAlignment == null) {
                        this.phoneAlignment = new PhoneAlignment();
                    }
                    codedInputByteBufferNano.readMessage(this.phoneAlignment);
                    break;
                case 210:
                    if (this.vrStreaming == null) {
                        this.vrStreaming = new VrStreaming();
                    }
                    codedInputByteBufferNano.readMessage(this.vrStreaming);
                    break;
                case BuildConfig.VERSION_CODE /* 218 */:
                    if (this.expeditions == null) {
                        this.expeditions = new Expeditions();
                    }
                    codedInputByteBufferNano.readMessage(this.expeditions);
                    break;
                case 226:
                    if (this.headTracking == null) {
                        this.headTracking = new HeadTracking();
                    }
                    codedInputByteBufferNano.readMessage(this.headTracking);
                    break;
                default:
                    if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        HeadMount headMount = this.headMount;
        if (headMount != null) {
            codedOutputByteBufferNano.writeMessage(1, headMount);
        }
        Application application = this.application;
        if (application != null) {
            codedOutputByteBufferNano.writeMessage(2, application);
        }
        Long l = this.durationMs;
        if (l != null) {
            codedOutputByteBufferNano.writeInt64(3, l.longValue());
        }
        Application[] applicationArr = this.installedVrApplications;
        if (applicationArr != null && applicationArr.length > 0) {
            int i = 0;
            while (true) {
                MessageNano[] messageNanoArr = this.installedVrApplications;
                if (i >= messageNanoArr.length) {
                    break;
                }
                MessageNano messageNano = messageNanoArr[i];
                if (messageNano != null) {
                    codedOutputByteBufferNano.writeMessage(4, messageNano);
                }
                i++;
            }
        }
        Cyclops cyclops = this.cyclops;
        if (cyclops != null) {
            codedOutputByteBufferNano.writeMessage(5, cyclops);
        }
        QrCodeScan qrCodeScan = this.qrCodeScan;
        if (qrCodeScan != null) {
            codedOutputByteBufferNano.writeMessage(6, qrCodeScan);
        }
        String str = this.cohort;
        if (str != null) {
            codedOutputByteBufferNano.writeString(7, str);
        }
        Integer num = this.lifetimeCountBucket;
        if (num != null) {
            codedOutputByteBufferNano.writeInt32(8, num.intValue());
        }
        PerformanceStats performanceStats = this.performanceStats;
        if (performanceStats != null) {
            codedOutputByteBufferNano.writeMessage(9, performanceStats);
        }
        SensorStats sensorStats = this.sensorStats;
        if (sensorStats != null) {
            codedOutputByteBufferNano.writeMessage(10, sensorStats);
        }
        AudioStats audioStats = this.audioStats;
        if (audioStats != null) {
            codedOutputByteBufferNano.writeMessage(11, audioStats);
        }
        EmbedVrWidget embedVrWidget = this.embedVrWidget;
        if (embedVrWidget != null) {
            codedOutputByteBufferNano.writeMessage(12, embedVrWidget);
        }
        VrCore vrCore = this.vrCore;
        if (vrCore != null) {
            codedOutputByteBufferNano.writeMessage(13, vrCore);
        }
        EarthVr earthVr = this.earthVr;
        if (earthVr != null) {
            codedOutputByteBufferNano.writeMessage(14, earthVr);
        }
        Launcher launcher = this.launcher;
        if (launcher != null) {
            codedOutputByteBufferNano.writeMessage(15, launcher);
        }
        Keyboard keyboard = this.keyboard;
        if (keyboard != null) {
            codedOutputByteBufferNano.writeMessage(16, keyboard);
        }
        Renderer renderer = this.renderer;
        if (renderer != null) {
            codedOutputByteBufferNano.writeMessage(17, renderer);
        }
        Lullaby lullaby = this.lullaby;
        if (lullaby != null) {
            codedOutputByteBufferNano.writeMessage(18, lullaby);
        }
        StreetView streetView = this.streetView;
        if (streetView != null) {
            codedOutputByteBufferNano.writeMessage(19, streetView);
        }
        Photos photos = this.photos;
        if (photos != null) {
            codedOutputByteBufferNano.writeMessage(20, photos);
        }
        VrHome vrHome = this.vrHome;
        if (vrHome != null) {
            codedOutputByteBufferNano.writeMessage(21, vrHome);
        }
        SdkConfigurationParams sdkConfigurationParams = this.sdkConfiguration;
        if (sdkConfigurationParams != null) {
            codedOutputByteBufferNano.writeMessage(22, sdkConfigurationParams);
        }
        GConfigUpdate gConfigUpdate = this.gConfigUpdate;
        if (gConfigUpdate != null) {
            codedOutputByteBufferNano.writeMessage(23, gConfigUpdate);
        }
        JumpInspector jumpInspector = this.jumpInspector;
        if (jumpInspector != null) {
            codedOutputByteBufferNano.writeMessage(24, jumpInspector);
        }
        PhoneAlignment phoneAlignment = this.phoneAlignment;
        if (phoneAlignment != null) {
            codedOutputByteBufferNano.writeMessage(25, phoneAlignment);
        }
        VrStreaming vrStreaming = this.vrStreaming;
        if (vrStreaming != null) {
            codedOutputByteBufferNano.writeMessage(26, vrStreaming);
        }
        Expeditions expeditions = this.expeditions;
        if (expeditions != null) {
            codedOutputByteBufferNano.writeMessage(27, expeditions);
        }
        HeadTracking headTracking = this.headTracking;
        if (headTracking != null) {
            codedOutputByteBufferNano.writeMessage(28, headTracking);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Cyclops extends ExtendableMessageNano<Cyclops> implements Cloneable {
        private Capture capture = null;
        private View view = null;
        private Share share = null;
        private ShareStart shareStart = null;

        public Cyclops() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Capture capture = this.capture;
            if (capture != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, capture);
            }
            View view = this.view;
            if (view != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, view);
            }
            Share share = this.share;
            if (share != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, share);
            }
            ShareStart shareStart = this.shareStart;
            return shareStart != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, shareStart) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.capture == null) {
                        this.capture = new Capture();
                    }
                    codedInputByteBufferNano.readMessage(this.capture);
                } else if (readTag == 18) {
                    if (this.view == null) {
                        this.view = new View();
                    }
                    codedInputByteBufferNano.readMessage(this.view);
                } else if (readTag == 26) {
                    if (this.share == null) {
                        this.share = new Share();
                    }
                    codedInputByteBufferNano.readMessage(this.share);
                } else if (readTag != 34) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.shareStart == null) {
                        this.shareStart = new ShareStart();
                    }
                    codedInputByteBufferNano.readMessage(this.shareStart);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Capture capture = this.capture;
            if (capture != null) {
                codedOutputByteBufferNano.writeMessage(1, capture);
            }
            View view = this.view;
            if (view != null) {
                codedOutputByteBufferNano.writeMessage(2, view);
            }
            Share share = this.share;
            if (share != null) {
                codedOutputByteBufferNano.writeMessage(3, share);
            }
            ShareStart shareStart = this.shareStart;
            if (shareStart != null) {
                codedOutputByteBufferNano.writeMessage(4, shareStart);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Capture extends ExtendableMessageNano<Capture> implements Cloneable {
            private Integer outcome = null;
            private Float angleDegrees = null;
            private Boolean withSound = null;
            private Boolean captureWarnings = null;
            private Long compositionTimeMs = null;
            private Long captureTimeMs = null;
            private Long processingTimeMs = null;

            public Capture() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.outcome;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Float f = this.angleDegrees;
                if (f != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f.floatValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool.booleanValue());
                }
                Boolean bool2 = this.captureWarnings;
                if (bool2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, bool2.booleanValue());
                }
                Long l = this.compositionTimeMs;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, l.longValue());
                }
                Long l2 = this.captureTimeMs;
                if (l2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, l2.longValue());
                }
                Long l3 = this.processingTimeMs;
                return l3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, l3.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.outcome = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 21) {
                        this.angleDegrees = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 24) {
                        this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 32) {
                        this.captureWarnings = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 40) {
                        this.compositionTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 48) {
                        this.captureTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag != 56) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.processingTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.outcome;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Float f = this.angleDegrees;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(2, f.floatValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(3, bool.booleanValue());
                }
                Boolean bool2 = this.captureWarnings;
                if (bool2 != null) {
                    codedOutputByteBufferNano.writeBool(4, bool2.booleanValue());
                }
                Long l = this.compositionTimeMs;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(5, l.longValue());
                }
                Long l2 = this.captureTimeMs;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeInt64(6, l2.longValue());
                }
                Long l3 = this.processingTimeMs;
                if (l3 != null) {
                    codedOutputByteBufferNano.writeInt64(7, l3.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Capture m257clone() {
                try {
                    return (Capture) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Share extends ExtendableMessageNano<Share> implements Cloneable {
            private Integer type = null;
            private Boolean withSound = null;
            private Integer numPhotos = null;

            public Share() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
                }
                Integer num2 = this.numPhotos;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.type = Integer.valueOf(readInt32);
                                continue;
                            default:
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                continue;
                        }
                    } else if (readTag == 16) {
                        this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag != 24) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.withSound;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                Integer num2 = this.numPhotos;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Share m260clone() {
                try {
                    return (Share) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class ShareStart extends ExtendableMessageNano<ShareStart> implements Cloneable {
            private Integer originScreen = null;
            private Integer numPhotos = null;

            public ShareStart() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.originScreen;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.numPhotos;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.originScreen = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.originScreen;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.numPhotos;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final ShareStart m263clone() {
                try {
                    return (ShareStart) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class View extends ExtendableMessageNano<View> implements Cloneable {
            private Integer orientation = null;
            private Boolean interaction = null;
            private Boolean withSound = null;
            private Integer numPanos = null;

            public View() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.orientation;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.interaction;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
                }
                Boolean bool2 = this.withSound;
                if (bool2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool2.booleanValue());
                }
                Integer num2 = this.numPanos;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.orientation = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.interaction = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag == 24) {
                        this.withSound = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag != 32) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.numPanos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.orientation;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.interaction;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                Boolean bool2 = this.withSound;
                if (bool2 != null) {
                    codedOutputByteBufferNano.writeBool(3, bool2.booleanValue());
                }
                Integer num2 = this.numPanos;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final View m266clone() {
                try {
                    return (View) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final Cyclops m254clone() {
            try {
                Cyclops cyclops = (Cyclops) super.clone();
                Capture capture = this.capture;
                if (capture != null) {
                    cyclops.capture = capture.m257clone();
                }
                View view = this.view;
                if (view != null) {
                    cyclops.view = view.m266clone();
                }
                Share share = this.share;
                if (share != null) {
                    cyclops.share = share.m260clone();
                }
                ShareStart shareStart = this.shareStart;
                if (shareStart != null) {
                    cyclops.shareStart = shareStart.m263clone();
                }
                return cyclops;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class EmbedVrWidget extends ExtendableMessageNano<EmbedVrWidget> implements Cloneable {
        private Integer viewMode = null;
        private Pano pano = null;
        private Video video = null;
        private String errorMsg = null;

        public EmbedVrWidget() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.viewMode;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Pano pano = this.pano;
            if (pano != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pano);
            }
            Video video = this.video;
            if (video != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, video);
            }
            String str = this.errorMsg;
            return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, str) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    } else {
                        this.viewMode = Integer.valueOf(readInt32);
                    }
                } else if (readTag == 18) {
                    if (this.pano == null) {
                        this.pano = new Pano();
                    }
                    codedInputByteBufferNano.readMessage(this.pano);
                } else if (readTag == 26) {
                    if (this.video == null) {
                        this.video = new Video();
                    }
                    codedInputByteBufferNano.readMessage(this.video);
                } else if (readTag != 34) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.errorMsg = codedInputByteBufferNano.readString();
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.viewMode;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Pano pano = this.pano;
            if (pano != null) {
                codedOutputByteBufferNano.writeMessage(2, pano);
            }
            Video video = this.video;
            if (video != null) {
                codedOutputByteBufferNano.writeMessage(3, video);
            }
            String str = this.errorMsg;
            if (str != null) {
                codedOutputByteBufferNano.writeString(4, str);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Pano extends ExtendableMessageNano<Pano> implements Cloneable {
            private Integer widthPixels = null;
            private Integer heightPixels = null;
            private Integer stereoFormat = null;

            public Pano() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.widthPixels;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag != 24) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.stereoFormat = Integer.valueOf(readInt32);
                        }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.widthPixels;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Pano m317clone() {
                try {
                    return (Pano) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Video extends ExtendableMessageNano<Video> implements Cloneable {
            private Integer widthPixels = null;
            private Integer heightPixels = null;
            private Integer stereoFormat = null;
            private Integer videoDurationMs = null;

            public Video() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.widthPixels;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                }
                Integer num4 = this.videoDurationMs;
                return num4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.widthPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.heightPixels = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.stereoFormat = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 32) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.videoDurationMs = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.widthPixels;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.heightPixels;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.stereoFormat;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                Integer num4 = this.videoDurationMs;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num4.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Video m320clone() {
                try {
                    return (Video) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final EmbedVrWidget m314clone() {
            try {
                EmbedVrWidget embedVrWidget = (EmbedVrWidget) super.clone();
                Pano pano = this.pano;
                if (pano != null) {
                    embedVrWidget.pano = pano.m317clone();
                }
                Video video = this.video;
                if (video != null) {
                    embedVrWidget.video = video.m320clone();
                }
                return embedVrWidget;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class GConfigUpdate extends ExtendableMessageNano<GConfigUpdate> implements Cloneable {
        private GConfigValue[] gConfigValue = GConfigValue.emptyArray();

        public GConfigUpdate() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            GConfigValue[] gConfigValueArr = this.gConfigValue;
            if (gConfigValueArr != null && gConfigValueArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.gConfigValue;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag != 10) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    GConfigValue[] gConfigValueArr = this.gConfigValue;
                    int length = gConfigValueArr == null ? 0 : gConfigValueArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new GConfigValue[i];
                    if (length != 0) {
                        System.arraycopy(gConfigValueArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new GConfigValue();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new GConfigValue();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.gConfigValue = messageNanoArr;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            GConfigValue[] gConfigValueArr = this.gConfigValue;
            if (gConfigValueArr != null && gConfigValueArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.gConfigValue;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(1, messageNano);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class GConfigValue extends ExtendableMessageNano<GConfigValue> implements Cloneable {
            private static volatile GConfigValue[] _emptyArray;
            private String gConfigKey = null;
            private String stringValue = null;

            public GConfigValue() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static GConfigValue[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new GConfigValue[0];
                        }
                    }
                }
                return _emptyArray;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.gConfigKey;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                String str2 = this.stringValue;
                return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str2) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.gConfigKey = codedInputByteBufferNano.readString();
                    } else if (readTag != 18) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.stringValue = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.gConfigKey;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                String str2 = this.stringValue;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final GConfigValue m329clone() {
                try {
                    return (GConfigValue) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final GConfigUpdate m326clone() {
            try {
                GConfigUpdate gConfigUpdate = (GConfigUpdate) super.clone();
                GConfigValue[] gConfigValueArr = this.gConfigValue;
                if (gConfigValueArr != null && gConfigValueArr.length > 0) {
                    gConfigUpdate.gConfigValue = new GConfigValue[gConfigValueArr.length];
                    int i = 0;
                    while (true) {
                        GConfigValue[] gConfigValueArr2 = this.gConfigValue;
                        if (i >= gConfigValueArr2.length) {
                            break;
                        }
                        if (gConfigValueArr2[i] != null) {
                            gConfigUpdate.gConfigValue[i] = gConfigValueArr2[i].m329clone();
                        }
                        i++;
                    }
                }
                return gConfigUpdate;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class JumpInspector extends ExtendableMessageNano<JumpInspector> implements Cloneable {
        private MediaDetails mediaDetails = null;
        private PlaybackDetails playbackDetails = null;
        private PickerDetails pickerEvent = null;

        public JumpInspector() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            MediaDetails mediaDetails = this.mediaDetails;
            if (mediaDetails != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, mediaDetails);
            }
            PlaybackDetails playbackDetails = this.playbackDetails;
            if (playbackDetails != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, playbackDetails);
            }
            PickerDetails pickerDetails = this.pickerEvent;
            return pickerDetails != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, pickerDetails) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.mediaDetails == null) {
                        this.mediaDetails = new MediaDetails();
                    }
                    codedInputByteBufferNano.readMessage(this.mediaDetails);
                } else if (readTag == 18) {
                    if (this.playbackDetails == null) {
                        this.playbackDetails = new PlaybackDetails();
                    }
                    codedInputByteBufferNano.readMessage(this.playbackDetails);
                } else if (readTag != 26) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.pickerEvent == null) {
                        this.pickerEvent = new PickerDetails();
                    }
                    codedInputByteBufferNano.readMessage(this.pickerEvent);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            MediaDetails mediaDetails = this.mediaDetails;
            if (mediaDetails != null) {
                codedOutputByteBufferNano.writeMessage(1, mediaDetails);
            }
            PlaybackDetails playbackDetails = this.playbackDetails;
            if (playbackDetails != null) {
                codedOutputByteBufferNano.writeMessage(2, playbackDetails);
            }
            PickerDetails pickerDetails = this.pickerEvent;
            if (pickerDetails != null) {
                codedOutputByteBufferNano.writeMessage(3, pickerDetails);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class AudioDetails extends ExtendableMessageNano<AudioDetails> implements Cloneable {
            private Long mediaLengthSeconds = null;
            private Integer sampleRate = null;
            private Integer audioBitRate = null;
            private Integer audioCodec = null;
            private Integer audioChannelCount = null;

            public AudioDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
                }
                Integer num2 = this.audioBitRate;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
                }
                Integer num3 = this.audioCodec;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num3.intValue());
                }
                Integer num4 = this.audioChannelCount;
                return num4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, num4.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.mediaLengthSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 16) {
                        this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        this.audioBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 32) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.audioCodec = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 40) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.audioChannelCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(2, num.intValue());
                }
                Integer num2 = this.audioBitRate;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                Integer num3 = this.audioCodec;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num3.intValue());
                }
                Integer num4 = this.audioChannelCount;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num4.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final AudioDetails m344clone() {
                try {
                    return (AudioDetails) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class ImageDetails extends ExtendableMessageNano<ImageDetails> implements Cloneable {
            private Resolution resolution = null;
            private Boolean usedMonoFilename = null;

            public ImageDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Resolution resolution = this.resolution;
                if (resolution != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, resolution);
                }
                Boolean bool = this.usedMonoFilename;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.resolution == null) {
                            this.resolution = new Resolution();
                        }
                        codedInputByteBufferNano.readMessage(this.resolution);
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.usedMonoFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Resolution resolution = this.resolution;
                if (resolution != null) {
                    codedOutputByteBufferNano.writeMessage(1, resolution);
                }
                Boolean bool = this.usedMonoFilename;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final ImageDetails m347clone() {
                try {
                    ImageDetails imageDetails = (ImageDetails) super.clone();
                    Resolution resolution = this.resolution;
                    if (resolution != null) {
                        imageDetails.resolution = resolution.m362clone();
                    }
                    return imageDetails;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class ImagePlaybackDetails extends ExtendableMessageNano<ImagePlaybackDetails> implements Cloneable {
            private Integer playbackMode = null;

            public ImagePlaybackDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.playbackMode;
                return num != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, num.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 8) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.playbackMode = Integer.valueOf(readInt32);
                        }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.playbackMode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final ImagePlaybackDetails m350clone() {
                try {
                    return (ImagePlaybackDetails) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class MediaDetails extends ExtendableMessageNano<MediaDetails> implements Cloneable {
            private String fileExtension = null;
            private VideoDetails videoDetails = null;
            private ImageDetails imageDetails = null;
            private AudioDetails audioDetails = null;

            public MediaDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.fileExtension;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
                }
                VideoDetails videoDetails = this.videoDetails;
                if (videoDetails != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, videoDetails);
                }
                ImageDetails imageDetails = this.imageDetails;
                if (imageDetails != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, imageDetails);
                }
                AudioDetails audioDetails = this.audioDetails;
                return audioDetails != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, audioDetails) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        this.fileExtension = codedInputByteBufferNano.readString();
                    } else if (readTag == 18) {
                        if (this.videoDetails == null) {
                            this.videoDetails = new VideoDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.videoDetails);
                    } else if (readTag == 26) {
                        if (this.imageDetails == null) {
                            this.imageDetails = new ImageDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.imageDetails);
                    } else if (readTag != 34) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.audioDetails == null) {
                            this.audioDetails = new AudioDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.audioDetails);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.fileExtension;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                VideoDetails videoDetails = this.videoDetails;
                if (videoDetails != null) {
                    codedOutputByteBufferNano.writeMessage(2, videoDetails);
                }
                ImageDetails imageDetails = this.imageDetails;
                if (imageDetails != null) {
                    codedOutputByteBufferNano.writeMessage(3, imageDetails);
                }
                AudioDetails audioDetails = this.audioDetails;
                if (audioDetails != null) {
                    codedOutputByteBufferNano.writeMessage(4, audioDetails);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final MediaDetails m353clone() {
                try {
                    MediaDetails mediaDetails = (MediaDetails) super.clone();
                    VideoDetails videoDetails = this.videoDetails;
                    if (videoDetails != null) {
                        mediaDetails.videoDetails = videoDetails.m368clone();
                    }
                    ImageDetails imageDetails = this.imageDetails;
                    if (imageDetails != null) {
                        mediaDetails.imageDetails = imageDetails.m347clone();
                    }
                    AudioDetails audioDetails = this.audioDetails;
                    if (audioDetails != null) {
                        mediaDetails.audioDetails = audioDetails.m344clone();
                    }
                    return mediaDetails;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class PickerDetails extends ExtendableMessageNano<PickerDetails> implements Cloneable {
            private Integer numberOfFiles = null;
            private Integer numberOfFolders = null;

            public PickerDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.numberOfFiles;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.numberOfFolders;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.numberOfFiles = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.numberOfFolders = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.numberOfFiles;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.numberOfFolders;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final PickerDetails m356clone() {
                try {
                    return (PickerDetails) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class PlaybackDetails extends ExtendableMessageNano<PlaybackDetails> implements Cloneable {
            private Integer playbackState = null;
            private Long playbackDurationSeconds = null;
            private Integer playbackEngine = null;
            private VideoPlaybackDetails videoPlayback = null;
            private ImagePlaybackDetails imagePlayback = null;

            public PlaybackDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.playbackState;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.playbackDurationSeconds;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
                }
                Integer num2 = this.playbackEngine;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
                }
                VideoPlaybackDetails videoPlaybackDetails = this.videoPlayback;
                if (videoPlaybackDetails != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, videoPlaybackDetails);
                }
                ImagePlaybackDetails imagePlaybackDetails = this.imagePlayback;
                return imagePlaybackDetails != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, imagePlaybackDetails) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.playbackState = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.playbackDurationSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag == 24) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.playbackEngine = Integer.valueOf(readInt322);
                        }
                    } else if (readTag == 34) {
                        if (this.videoPlayback == null) {
                            this.videoPlayback = new VideoPlaybackDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.videoPlayback);
                    } else if (readTag != 42) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.imagePlayback == null) {
                            this.imagePlayback = new ImagePlaybackDetails();
                        }
                        codedInputByteBufferNano.readMessage(this.imagePlayback);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.playbackState;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.playbackDurationSeconds;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                Integer num2 = this.playbackEngine;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                VideoPlaybackDetails videoPlaybackDetails = this.videoPlayback;
                if (videoPlaybackDetails != null) {
                    codedOutputByteBufferNano.writeMessage(4, videoPlaybackDetails);
                }
                ImagePlaybackDetails imagePlaybackDetails = this.imagePlayback;
                if (imagePlaybackDetails != null) {
                    codedOutputByteBufferNano.writeMessage(5, imagePlaybackDetails);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final PlaybackDetails m359clone() {
                try {
                    PlaybackDetails playbackDetails = (PlaybackDetails) super.clone();
                    VideoPlaybackDetails videoPlaybackDetails = this.videoPlayback;
                    if (videoPlaybackDetails != null) {
                        playbackDetails.videoPlayback = videoPlaybackDetails.m371clone();
                    }
                    ImagePlaybackDetails imagePlaybackDetails = this.imagePlayback;
                    if (imagePlaybackDetails != null) {
                        playbackDetails.imagePlayback = imagePlaybackDetails.m350clone();
                    }
                    return playbackDetails;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Resolution extends ExtendableMessageNano<Resolution> implements Cloneable {
            private Integer width = null;
            private Integer height = null;

            public Resolution() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.width;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.height;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.width = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.height = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.width;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.height;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Resolution m362clone() {
                try {
                    return (Resolution) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class SphericalMetadata extends ExtendableMessageNano<SphericalMetadata> implements Cloneable {
            private Integer metadataVersion = null;
            private Integer projectionType = null;
            private Integer meshCrc = null;

            public SphericalMetadata() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.metadataVersion;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.projectionType;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.meshCrc;
                return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.metadataVersion = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.projectionType = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 24) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.meshCrc = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.metadataVersion;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.projectionType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.meshCrc;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final SphericalMetadata m365clone() {
                try {
                    return (SphericalMetadata) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class VideoDetails extends ExtendableMessageNano<VideoDetails> implements Cloneable {
            private Long mediaLengthSeconds = null;
            private Resolution resolution = null;
            private Double framesPerSecond = null;
            private Integer sampleRate = null;
            private Integer videoBitRate = null;
            private Integer audioBitRate = null;
            private Integer videoCodec = null;
            private Integer audioCodec = null;
            private SphericalMetadata sphericalMetadata = null;
            private Integer audioChannelCount = null;
            private Boolean usedMonoFilename = null;
            private Boolean usedWalleFilename = null;
            private Boolean usedWallyFilename = null;

            public VideoDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Resolution resolution = this.resolution;
                if (resolution != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, resolution);
                }
                Double d = this.framesPerSecond;
                if (d != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, d.doubleValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num.intValue());
                }
                Integer num2 = this.videoBitRate;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num2.intValue());
                }
                Integer num3 = this.audioBitRate;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num3.intValue());
                }
                Integer num4 = this.videoCodec;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, num4.intValue());
                }
                Integer num5 = this.audioCodec;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num5.intValue());
                }
                SphericalMetadata sphericalMetadata = this.sphericalMetadata;
                if (sphericalMetadata != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, sphericalMetadata);
                }
                Integer num6 = this.audioChannelCount;
                if (num6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, num6.intValue());
                }
                Boolean bool = this.usedMonoFilename;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, bool.booleanValue());
                }
                Boolean bool2 = this.usedWalleFilename;
                if (bool2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, bool2.booleanValue());
                }
                Boolean bool3 = this.usedWallyFilename;
                return bool3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(13, bool3.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            this.mediaLengthSeconds = Long.valueOf(codedInputByteBufferNano.readInt64());
                            break;
                        case 18:
                            if (this.resolution == null) {
                                this.resolution = new Resolution();
                            }
                            codedInputByteBufferNano.readMessage(this.resolution);
                            break;
                        case 25:
                            this.framesPerSecond = Double.valueOf(codedInputByteBufferNano.readDouble());
                            break;
                        case 32:
                            this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 40:
                            this.videoBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 48:
                            this.audioBitRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 56:
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.videoCodec = Integer.valueOf(readInt32);
                                break;
                            }
                        case 64:
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3 && readInt322 != 4) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.audioCodec = Integer.valueOf(readInt322);
                                break;
                            }
                        case 74:
                            if (this.sphericalMetadata == null) {
                                this.sphericalMetadata = new SphericalMetadata();
                            }
                            codedInputByteBufferNano.readMessage(this.sphericalMetadata);
                            break;
                        case 80:
                            this.audioChannelCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 88:
                            this.usedMonoFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        case 96:
                            this.usedWalleFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        case 104:
                            this.usedWallyFilename = Boolean.valueOf(codedInputByteBufferNano.readBool());
                            break;
                        default:
                            if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.mediaLengthSeconds;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Resolution resolution = this.resolution;
                if (resolution != null) {
                    codedOutputByteBufferNano.writeMessage(2, resolution);
                }
                Double d = this.framesPerSecond;
                if (d != null) {
                    codedOutputByteBufferNano.writeDouble(3, d.doubleValue());
                }
                Integer num = this.sampleRate;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(4, num.intValue());
                }
                Integer num2 = this.videoBitRate;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num2.intValue());
                }
                Integer num3 = this.audioBitRate;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(6, num3.intValue());
                }
                Integer num4 = this.videoCodec;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(7, num4.intValue());
                }
                Integer num5 = this.audioCodec;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num5.intValue());
                }
                SphericalMetadata sphericalMetadata = this.sphericalMetadata;
                if (sphericalMetadata != null) {
                    codedOutputByteBufferNano.writeMessage(9, sphericalMetadata);
                }
                Integer num6 = this.audioChannelCount;
                if (num6 != null) {
                    codedOutputByteBufferNano.writeInt32(10, num6.intValue());
                }
                Boolean bool = this.usedMonoFilename;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(11, bool.booleanValue());
                }
                Boolean bool2 = this.usedWalleFilename;
                if (bool2 != null) {
                    codedOutputByteBufferNano.writeBool(12, bool2.booleanValue());
                }
                Boolean bool3 = this.usedWallyFilename;
                if (bool3 != null) {
                    codedOutputByteBufferNano.writeBool(13, bool3.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final VideoDetails m368clone() {
                try {
                    VideoDetails videoDetails = (VideoDetails) super.clone();
                    Resolution resolution = this.resolution;
                    if (resolution != null) {
                        videoDetails.resolution = resolution.m362clone();
                    }
                    SphericalMetadata sphericalMetadata = this.sphericalMetadata;
                    if (sphericalMetadata != null) {
                        videoDetails.sphericalMetadata = sphericalMetadata.m365clone();
                    }
                    return videoDetails;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class VideoPlaybackDetails extends ExtendableMessageNano<VideoPlaybackDetails> implements Cloneable {
            private Integer playbackMode = null;
            private Boolean usedExternalSync = null;
            private Integer droppedFramesCount = null;

            public VideoPlaybackDetails() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.playbackMode;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.usedExternalSync;
                if (bool != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue());
                }
                Integer num2 = this.droppedFramesCount;
                return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.playbackMode = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.usedExternalSync = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    } else if (readTag != 24) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.droppedFramesCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.playbackMode;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.usedExternalSync;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                Integer num2 = this.droppedFramesCount;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final VideoPlaybackDetails m371clone() {
                try {
                    return (VideoPlaybackDetails) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final JumpInspector m341clone() {
            try {
                JumpInspector jumpInspector = (JumpInspector) super.clone();
                MediaDetails mediaDetails = this.mediaDetails;
                if (mediaDetails != null) {
                    jumpInspector.mediaDetails = mediaDetails.m353clone();
                }
                PlaybackDetails playbackDetails = this.playbackDetails;
                if (playbackDetails != null) {
                    jumpInspector.playbackDetails = playbackDetails.m359clone();
                }
                PickerDetails pickerDetails = this.pickerEvent;
                if (pickerDetails != null) {
                    jumpInspector.pickerEvent = pickerDetails.m356clone();
                }
                return jumpInspector;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Keyboard extends ExtendableMessageNano<Keyboard> implements Cloneable {
        private KeyboardEvent[] keyboardEvents = KeyboardEvent.emptyArray();

        public Keyboard() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
            if (keyboardEventArr != null && keyboardEventArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.keyboardEvents;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
                    int length = keyboardEventArr == null ? 0 : keyboardEventArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new KeyboardEvent[i];
                    if (length != 0) {
                        System.arraycopy(keyboardEventArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new KeyboardEvent();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new KeyboardEvent();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.keyboardEvents = messageNanoArr;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
            if (keyboardEventArr != null && keyboardEventArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.keyboardEvents;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(2, messageNano);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class KeyboardEvent extends ExtendableMessageNano<KeyboardEvent> implements Cloneable {
            private static volatile KeyboardEvent[] _emptyArray;
            private Long clientTimestamp = null;
            private Integer eventType = null;
            private KeyboardTextEntry textEntry = null;
            private Application keyboardService = null;
            private String[] systemLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
            private String[] enabledLanguages = WireFormatNano.EMPTY_STRING_ARRAY;
            private String language = null;
            private Integer inputType = null;
            private String layout = null;
            private Integer suggestionCount = null;

            public KeyboardEvent() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static KeyboardEvent[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new KeyboardEvent[0];
                        }
                    }
                }
                return _emptyArray;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Long l = this.clientTimestamp;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Integer num = this.eventType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num.intValue());
                }
                KeyboardTextEntry keyboardTextEntry = this.textEntry;
                if (keyboardTextEntry != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, keyboardTextEntry);
                }
                Application application = this.keyboardService;
                if (application != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, application);
                }
                String[] strArr = this.systemLanguages;
                int i = 0;
                if (strArr != null && strArr.length > 0) {
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        String[] strArr2 = this.systemLanguages;
                        if (i2 >= strArr2.length) {
                            break;
                        }
                        String str = strArr2[i2];
                        if (str != null) {
                            i4++;
                            i3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                        }
                        i2++;
                    }
                    computeSerializedSize = computeSerializedSize + i3 + (i4 * 1);
                }
                String[] strArr3 = this.enabledLanguages;
                if (strArr3 != null && strArr3.length > 0) {
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        String[] strArr4 = this.enabledLanguages;
                        if (i >= strArr4.length) {
                            break;
                        }
                        String str2 = strArr4[i];
                        if (str2 != null) {
                            i6++;
                            i5 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                        }
                        i++;
                    }
                    computeSerializedSize = computeSerializedSize + i5 + (i6 * 1);
                }
                String str3 = this.language;
                if (str3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, str3);
                }
                Integer num2 = this.inputType;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, num2.intValue());
                }
                String str4 = this.layout;
                if (str4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, str4);
                }
                Integer num3 = this.suggestionCount;
                return num3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, num3.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            this.clientTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                            break;
                        case 16:
                            int position = codedInputByteBufferNano.getPosition();
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 != 1000 && readInt32 != 1001 && readInt32 != 2000) {
                                switch (readInt32) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                        break;
                                    default:
                                        switch (readInt32) {
                                            case 3000:
                                            case 3001:
                                            case 3002:
                                                break;
                                            default:
                                                codedInputByteBufferNano.rewindToPosition(position);
                                                storeUnknownField(codedInputByteBufferNano, readTag);
                                                break;
                                        }
                                }
                            }
                            this.eventType = Integer.valueOf(readInt32);
                            break;
                        case 26:
                            if (this.textEntry == null) {
                                this.textEntry = new KeyboardTextEntry();
                            }
                            codedInputByteBufferNano.readMessage(this.textEntry);
                            break;
                        case 34:
                            if (this.keyboardService == null) {
                                this.keyboardService = new Application();
                            }
                            codedInputByteBufferNano.readMessage(this.keyboardService);
                            break;
                        case 42:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                            String[] strArr = this.systemLanguages;
                            int length = strArr == null ? 0 : strArr.length;
                            int i = repeatedFieldArrayLength + length;
                            String[] strArr2 = new String[i];
                            if (length != 0) {
                                System.arraycopy(strArr, 0, strArr2, 0, length);
                            }
                            while (length < i - 1) {
                                strArr2[length] = codedInputByteBufferNano.readString();
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            strArr2[length] = codedInputByteBufferNano.readString();
                            this.systemLanguages = strArr2;
                            break;
                        case 50:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                            String[] strArr3 = this.enabledLanguages;
                            int length2 = strArr3 == null ? 0 : strArr3.length;
                            int i2 = repeatedFieldArrayLength2 + length2;
                            String[] strArr4 = new String[i2];
                            if (length2 != 0) {
                                System.arraycopy(strArr3, 0, strArr4, 0, length2);
                            }
                            while (length2 < i2 - 1) {
                                strArr4[length2] = codedInputByteBufferNano.readString();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            strArr4[length2] = codedInputByteBufferNano.readString();
                            this.enabledLanguages = strArr4;
                            break;
                        case 58:
                            this.language = codedInputByteBufferNano.readString();
                            break;
                        case 64:
                            int position2 = codedInputByteBufferNano.getPosition();
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 1) {
                                codedInputByteBufferNano.rewindToPosition(position2);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                break;
                            } else {
                                this.inputType = Integer.valueOf(readInt322);
                                break;
                            }
                        case 74:
                            this.layout = codedInputByteBufferNano.readString();
                            break;
                        case 80:
                            this.suggestionCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        default:
                            if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.clientTimestamp;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Integer num = this.eventType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(2, num.intValue());
                }
                KeyboardTextEntry keyboardTextEntry = this.textEntry;
                if (keyboardTextEntry != null) {
                    codedOutputByteBufferNano.writeMessage(3, keyboardTextEntry);
                }
                Application application = this.keyboardService;
                if (application != null) {
                    codedOutputByteBufferNano.writeMessage(4, application);
                }
                String[] strArr = this.systemLanguages;
                int i = 0;
                if (strArr != null && strArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr2 = this.systemLanguages;
                        if (i2 >= strArr2.length) {
                            break;
                        }
                        String str = strArr2[i2];
                        if (str != null) {
                            codedOutputByteBufferNano.writeString(5, str);
                        }
                        i2++;
                    }
                }
                String[] strArr3 = this.enabledLanguages;
                if (strArr3 != null && strArr3.length > 0) {
                    while (true) {
                        String[] strArr4 = this.enabledLanguages;
                        if (i >= strArr4.length) {
                            break;
                        }
                        String str2 = strArr4[i];
                        if (str2 != null) {
                            codedOutputByteBufferNano.writeString(6, str2);
                        }
                        i++;
                    }
                }
                String str3 = this.language;
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(7, str3);
                }
                Integer num2 = this.inputType;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num2.intValue());
                }
                String str4 = this.layout;
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(9, str4);
                }
                Integer num3 = this.suggestionCount;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(10, num3.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final KeyboardEvent m377clone() {
                try {
                    KeyboardEvent keyboardEvent = (KeyboardEvent) super.clone();
                    KeyboardTextEntry keyboardTextEntry = this.textEntry;
                    if (keyboardTextEntry != null) {
                        keyboardEvent.textEntry = keyboardTextEntry.m380clone();
                    }
                    Application application = this.keyboardService;
                    if (application != null) {
                        keyboardEvent.keyboardService = application.m248clone();
                    }
                    String[] strArr = this.systemLanguages;
                    if (strArr != null && strArr.length > 0) {
                        keyboardEvent.systemLanguages = (String[]) strArr.clone();
                    }
                    String[] strArr2 = this.enabledLanguages;
                    if (strArr2 != null && strArr2.length > 0) {
                        keyboardEvent.enabledLanguages = (String[]) strArr2.clone();
                    }
                    return keyboardEvent;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class KeyboardTextEntry extends ExtendableMessageNano<KeyboardTextEntry> implements Cloneable {
            private Integer type = null;
            private Integer length = null;
            private String layout = null;
            private String language = null;

            public KeyboardTextEntry() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.length;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                String str = this.layout;
                if (str != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
                }
                String str2 = this.language;
                return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, str2) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 4 && readInt32 != 5) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.type = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.length = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 26) {
                        this.layout = codedInputByteBufferNano.readString();
                    } else if (readTag != 34) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.language = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.length;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                String str = this.layout;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                String str2 = this.language;
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(4, str2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final KeyboardTextEntry m380clone() {
                try {
                    return (KeyboardTextEntry) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final Keyboard m374clone() {
            try {
                Keyboard keyboard = (Keyboard) super.clone();
                KeyboardEvent[] keyboardEventArr = this.keyboardEvents;
                if (keyboardEventArr != null && keyboardEventArr.length > 0) {
                    keyboard.keyboardEvents = new KeyboardEvent[keyboardEventArr.length];
                    int i = 0;
                    while (true) {
                        KeyboardEvent[] keyboardEventArr2 = this.keyboardEvents;
                        if (i >= keyboardEventArr2.length) {
                            break;
                        }
                        if (keyboardEventArr2[i] != null) {
                            keyboard.keyboardEvents[i] = keyboardEventArr2[i].m377clone();
                        }
                        i++;
                    }
                }
                return keyboard;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Lullaby extends ExtendableMessageNano<Lullaby> implements Cloneable {
        private Integer uiElement = null;
        private Integer index = null;
        private String contentId = null;
        private LoadTime loadTime = null;

        public Lullaby() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.uiElement;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.index;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
            }
            String str = this.contentId;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, str);
            }
            LoadTime loadTime = this.loadTime;
            return loadTime != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, loadTime) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        switch (readInt32) {
                            case 1000:
                            case 1001:
                            case 1002:
                            case 1003:
                            case 1004:
                            case 1005:
                            case 1006:
                            case 1007:
                                break;
                            default:
                                switch (readInt32) {
                                    case 2000:
                                    case 2001:
                                    case 2002:
                                    case 2003:
                                    case 2004:
                                    case 2005:
                                    case 2006:
                                    case 2007:
                                    case 2008:
                                    case 2009:
                                    case 2010:
                                    case 2011:
                                    case 2012:
                                    case 2013:
                                    case 2014:
                                    case 2015:
                                    case 2016:
                                    case 2017:
                                    case 2018:
                                    case 2019:
                                    case 2020:
                                    case 2021:
                                        break;
                                    default:
                                        switch (readInt32) {
                                            case 3000:
                                            case 3001:
                                            case 3002:
                                            case 3003:
                                            case 3004:
                                            case 3005:
                                            case 3006:
                                            case 3007:
                                            case 3008:
                                            case 3009:
                                            case 3010:
                                            case 3011:
                                            case 3012:
                                            case 3013:
                                            case 3014:
                                                break;
                                            default:
                                                codedInputByteBufferNano.rewindToPosition(position);
                                                storeUnknownField(codedInputByteBufferNano, readTag);
                                                break;
                                        }
                                }
                        }
                    }
                    this.uiElement = Integer.valueOf(readInt32);
                } else if (readTag == 16) {
                    this.index = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 26) {
                    this.contentId = codedInputByteBufferNano.readString();
                } else if (readTag != 34) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.loadTime == null) {
                        this.loadTime = new LoadTime();
                    }
                    codedInputByteBufferNano.readMessage(this.loadTime);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.uiElement;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.index;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            String str = this.contentId;
            if (str != null) {
                codedOutputByteBufferNano.writeString(3, str);
            }
            LoadTime loadTime = this.loadTime;
            if (loadTime != null) {
                codedOutputByteBufferNano.writeMessage(4, loadTime);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class LoadTime extends ExtendableMessageNano<LoadTime> implements Cloneable {
            private Integer assetType = null;
            private Long loadTimeMs = null;

            public LoadTime() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.assetType;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.loadTimeMs;
                return l != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, l.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        switch (readInt32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                this.assetType = Integer.valueOf(readInt32);
                                continue;
                            default:
                                codedInputByteBufferNano.rewindToPosition(position);
                                storeUnknownField(codedInputByteBufferNano, readTag);
                                continue;
                        }
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.loadTimeMs = Long.valueOf(codedInputByteBufferNano.readInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.assetType;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.loadTimeMs;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(2, l.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final LoadTime m389clone() {
                try {
                    return (LoadTime) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final Lullaby m386clone() {
            try {
                Lullaby lullaby = (Lullaby) super.clone();
                LoadTime loadTime = this.loadTime;
                if (loadTime != null) {
                    lullaby.loadTime = loadTime.m389clone();
                }
                return lullaby;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Photos extends ExtendableMessageNano<Photos> implements Cloneable {
        private Integer numPhotos = null;
        private OpenMedia openMedia = null;
        private WarmWelcome warmWelcome = null;

        public Photos() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.numPhotos;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            OpenMedia openMedia = this.openMedia;
            if (openMedia != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, openMedia);
            }
            WarmWelcome warmWelcome = this.warmWelcome;
            return warmWelcome != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, warmWelcome) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.numPhotos = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 18) {
                    if (this.openMedia == null) {
                        this.openMedia = new OpenMedia();
                    }
                    codedInputByteBufferNano.readMessage(this.openMedia);
                } else if (readTag != 26) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.warmWelcome == null) {
                        this.warmWelcome = new WarmWelcome();
                    }
                    codedInputByteBufferNano.readMessage(this.warmWelcome);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.numPhotos;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            OpenMedia openMedia = this.openMedia;
            if (openMedia != null) {
                codedOutputByteBufferNano.writeMessage(2, openMedia);
            }
            WarmWelcome warmWelcome = this.warmWelcome;
            if (warmWelcome != null) {
                codedOutputByteBufferNano.writeMessage(3, warmWelcome);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class OpenMedia extends ExtendableMessageNano<OpenMedia> implements Cloneable {
            private Integer type = null;
            private Integer source = null;
            private Boolean isSample = null;

            public OpenMedia() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.type;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.source;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Boolean bool = this.isSample;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.type = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        int position2 = codedInputByteBufferNano.getPosition();
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position2);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.source = Integer.valueOf(readInt322);
                        }
                    } else if (readTag != 24) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.isSample = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.type;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.source;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Boolean bool = this.isSample;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(3, bool.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final OpenMedia m401clone() {
                try {
                    return (OpenMedia) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class WarmWelcome extends ExtendableMessageNano<WarmWelcome> implements Cloneable {
            private Float exitProgress = null;

            public WarmWelcome() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Float f = this.exitProgress;
                return f != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 13) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.exitProgress = Float.valueOf(codedInputByteBufferNano.readFloat());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Float f = this.exitProgress;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(1, f.floatValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final WarmWelcome m404clone() {
                try {
                    return (WarmWelcome) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final Photos m398clone() {
            try {
                Photos photos = (Photos) super.clone();
                OpenMedia openMedia = this.openMedia;
                if (openMedia != null) {
                    photos.openMedia = openMedia.m401clone();
                }
                WarmWelcome warmWelcome = this.warmWelcome;
                if (warmWelcome != null) {
                    photos.warmWelcome = warmWelcome.m404clone();
                }
                return photos;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class SdkConfigurationParams extends ExtendableMessageNano<SdkConfigurationParams> implements Cloneable {
        private Boolean daydreamImageAlignmentEnabled = null;
        public Boolean useSystemClockForSensorTimestamps = null;
        public Boolean useMagnetometerInSensorFusion = null;
        public Boolean allowDynamicLibraryLoading = null;
        public Boolean cpuLateLatchingEnabled = null;
        public Integer daydreamImageAlignment = null;
        public AsyncReprojectionConfig asyncReprojectionConfig = null;
        public Boolean useOnlineMagnetometerCalibration = null;
        public Boolean useDeviceIdleDetection = null;
        private Boolean useStationaryBiasCorrection = null;
        public Boolean allowDynamicJavaLibraryLoading = null;
        public Boolean touchOverlayEnabled = null;
        public Boolean allowVrcoreHeadTracking = null;
        public Boolean allowVrcoreCompositing = null;
        private PerformanceOverlayInfo performanceOverlayInfo = null;
        public Boolean enableForcedTrackingCompat = null;

        public SdkConfigurationParams() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Boolean bool = this.daydreamImageAlignmentEnabled;
            if (bool != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, bool.booleanValue());
            }
            Boolean bool2 = this.useSystemClockForSensorTimestamps;
            if (bool2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, bool2.booleanValue());
            }
            Boolean bool3 = this.useMagnetometerInSensorFusion;
            if (bool3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, bool3.booleanValue());
            }
            Boolean bool4 = this.allowDynamicLibraryLoading;
            if (bool4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, bool4.booleanValue());
            }
            Boolean bool5 = this.cpuLateLatchingEnabled;
            if (bool5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, bool5.booleanValue());
            }
            Integer num = this.daydreamImageAlignment;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num.intValue());
            }
            AsyncReprojectionConfig asyncReprojectionConfig = this.asyncReprojectionConfig;
            if (asyncReprojectionConfig != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, asyncReprojectionConfig);
            }
            Boolean bool6 = this.useOnlineMagnetometerCalibration;
            if (bool6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, bool6.booleanValue());
            }
            Boolean bool7 = this.useDeviceIdleDetection;
            if (bool7 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, bool7.booleanValue());
            }
            Boolean bool8 = this.useStationaryBiasCorrection;
            if (bool8 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, bool8.booleanValue());
            }
            Boolean bool9 = this.allowDynamicJavaLibraryLoading;
            if (bool9 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, bool9.booleanValue());
            }
            Boolean bool10 = this.touchOverlayEnabled;
            if (bool10 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, bool10.booleanValue());
            }
            Boolean bool11 = this.allowVrcoreHeadTracking;
            if (bool11 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, bool11.booleanValue());
            }
            Boolean bool12 = this.allowVrcoreCompositing;
            if (bool12 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, bool12.booleanValue());
            }
            PerformanceOverlayInfo performanceOverlayInfo = this.performanceOverlayInfo;
            if (performanceOverlayInfo != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, performanceOverlayInfo);
            }
            Boolean bool13 = this.enableForcedTrackingCompat;
            return bool13 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(16, bool13.booleanValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        this.daydreamImageAlignmentEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 16:
                        this.useSystemClockForSensorTimestamps = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 24:
                        this.useMagnetometerInSensorFusion = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 32:
                        this.allowDynamicLibraryLoading = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 40:
                        this.cpuLateLatchingEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 48:
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            break;
                        } else {
                            this.daydreamImageAlignment = Integer.valueOf(readInt32);
                            break;
                        }
                    case 58:
                        if (this.asyncReprojectionConfig == null) {
                            this.asyncReprojectionConfig = new AsyncReprojectionConfig();
                        }
                        codedInputByteBufferNano.readMessage(this.asyncReprojectionConfig);
                        break;
                    case 64:
                        this.useOnlineMagnetometerCalibration = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 72:
                        this.useDeviceIdleDetection = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 80:
                        this.useStationaryBiasCorrection = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 88:
                        this.allowDynamicJavaLibraryLoading = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 96:
                        this.touchOverlayEnabled = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 104:
                        this.allowVrcoreHeadTracking = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 112:
                        this.allowVrcoreCompositing = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    case 122:
                        if (this.performanceOverlayInfo == null) {
                            this.performanceOverlayInfo = new PerformanceOverlayInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.performanceOverlayInfo);
                        break;
                    case 128:
                        this.enableForcedTrackingCompat = Boolean.valueOf(codedInputByteBufferNano.readBool());
                        break;
                    default:
                        if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Boolean bool = this.daydreamImageAlignmentEnabled;
            if (bool != null) {
                codedOutputByteBufferNano.writeBool(1, bool.booleanValue());
            }
            Boolean bool2 = this.useSystemClockForSensorTimestamps;
            if (bool2 != null) {
                codedOutputByteBufferNano.writeBool(2, bool2.booleanValue());
            }
            Boolean bool3 = this.useMagnetometerInSensorFusion;
            if (bool3 != null) {
                codedOutputByteBufferNano.writeBool(3, bool3.booleanValue());
            }
            Boolean bool4 = this.allowDynamicLibraryLoading;
            if (bool4 != null) {
                codedOutputByteBufferNano.writeBool(4, bool4.booleanValue());
            }
            Boolean bool5 = this.cpuLateLatchingEnabled;
            if (bool5 != null) {
                codedOutputByteBufferNano.writeBool(5, bool5.booleanValue());
            }
            Integer num = this.daydreamImageAlignment;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(6, num.intValue());
            }
            AsyncReprojectionConfig asyncReprojectionConfig = this.asyncReprojectionConfig;
            if (asyncReprojectionConfig != null) {
                codedOutputByteBufferNano.writeMessage(7, asyncReprojectionConfig);
            }
            Boolean bool6 = this.useOnlineMagnetometerCalibration;
            if (bool6 != null) {
                codedOutputByteBufferNano.writeBool(8, bool6.booleanValue());
            }
            Boolean bool7 = this.useDeviceIdleDetection;
            if (bool7 != null) {
                codedOutputByteBufferNano.writeBool(9, bool7.booleanValue());
            }
            Boolean bool8 = this.useStationaryBiasCorrection;
            if (bool8 != null) {
                codedOutputByteBufferNano.writeBool(10, bool8.booleanValue());
            }
            Boolean bool9 = this.allowDynamicJavaLibraryLoading;
            if (bool9 != null) {
                codedOutputByteBufferNano.writeBool(11, bool9.booleanValue());
            }
            Boolean bool10 = this.touchOverlayEnabled;
            if (bool10 != null) {
                codedOutputByteBufferNano.writeBool(12, bool10.booleanValue());
            }
            Boolean bool11 = this.allowVrcoreHeadTracking;
            if (bool11 != null) {
                codedOutputByteBufferNano.writeBool(13, bool11.booleanValue());
            }
            Boolean bool12 = this.allowVrcoreCompositing;
            if (bool12 != null) {
                codedOutputByteBufferNano.writeBool(14, bool12.booleanValue());
            }
            PerformanceOverlayInfo performanceOverlayInfo = this.performanceOverlayInfo;
            if (performanceOverlayInfo != null) {
                codedOutputByteBufferNano.writeMessage(15, performanceOverlayInfo);
            }
            Boolean bool13 = this.enableForcedTrackingCompat;
            if (bool13 != null) {
                codedOutputByteBufferNano.writeBool(16, bool13.booleanValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class AsyncReprojectionConfig extends ExtendableMessageNano<AsyncReprojectionConfig> implements Cloneable {
            public Long flags = null;
            private Long displayLatencyMicros = null;

            public AsyncReprojectionConfig() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Long l = this.flags;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, l.longValue());
                }
                Long l2 = this.displayLatencyMicros;
                return l2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, l2.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.flags = Long.valueOf(codedInputByteBufferNano.readInt64());
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.displayLatencyMicros = Long.valueOf(codedInputByteBufferNano.readInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Long l = this.flags;
                if (l != null) {
                    codedOutputByteBufferNano.writeInt64(1, l.longValue());
                }
                Long l2 = this.displayLatencyMicros;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeInt64(2, l2.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final AsyncReprojectionConfig m416clone() {
                try {
                    return (AsyncReprojectionConfig) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class PerformanceOverlayInfo extends ExtendableMessageNano<PerformanceOverlayInfo> implements Cloneable {
            private String version = null;

            public PerformanceOverlayInfo() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.version;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 10) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.version = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.version;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final PerformanceOverlayInfo m419clone() {
                try {
                    return (PerformanceOverlayInfo) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final SdkConfigurationParams m413clone() {
            try {
                SdkConfigurationParams sdkConfigurationParams = (SdkConfigurationParams) super.clone();
                AsyncReprojectionConfig asyncReprojectionConfig = this.asyncReprojectionConfig;
                if (asyncReprojectionConfig != null) {
                    sdkConfigurationParams.asyncReprojectionConfig = asyncReprojectionConfig.m416clone();
                }
                PerformanceOverlayInfo performanceOverlayInfo = this.performanceOverlayInfo;
                if (performanceOverlayInfo != null) {
                    sdkConfigurationParams.performanceOverlayInfo = performanceOverlayInfo.m419clone();
                }
                return sdkConfigurationParams;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class SensorStats extends ExtendableMessageNano<SensorStats> implements Cloneable {
        private GyroscopeStats gyroscopeStats = null;

        public SensorStats() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            GyroscopeStats gyroscopeStats = this.gyroscopeStats;
            return gyroscopeStats != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, gyroscopeStats) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag != 10) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.gyroscopeStats == null) {
                        this.gyroscopeStats = new GyroscopeStats();
                    }
                    codedInputByteBufferNano.readMessage(this.gyroscopeStats);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            GyroscopeStats gyroscopeStats = this.gyroscopeStats;
            if (gyroscopeStats != null) {
                codedOutputByteBufferNano.writeMessage(1, gyroscopeStats);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class GyroscopeStats extends ExtendableMessageNano<GyroscopeStats> implements Cloneable {
            private Vector3 bias = null;
            private Vector3 lowerBound = null;
            private Vector3 upperBound = null;
            private Vector3 standardDeviation = null;

            public GyroscopeStats() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Vector3 vector3 = this.bias;
                if (vector3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vector3);
                }
                Vector3 vector32 = this.lowerBound;
                if (vector32 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, vector32);
                }
                Vector3 vector33 = this.upperBound;
                if (vector33 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, vector33);
                }
                Vector3 vector34 = this.standardDeviation;
                return vector34 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, vector34) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 10) {
                        if (this.bias == null) {
                            this.bias = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.bias);
                    } else if (readTag == 18) {
                        if (this.lowerBound == null) {
                            this.lowerBound = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.lowerBound);
                    } else if (readTag == 26) {
                        if (this.upperBound == null) {
                            this.upperBound = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.upperBound);
                    } else if (readTag != 34) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.standardDeviation == null) {
                            this.standardDeviation = new Vector3();
                        }
                        codedInputByteBufferNano.readMessage(this.standardDeviation);
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Vector3 vector3 = this.bias;
                if (vector3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, vector3);
                }
                Vector3 vector32 = this.lowerBound;
                if (vector32 != null) {
                    codedOutputByteBufferNano.writeMessage(2, vector32);
                }
                Vector3 vector33 = this.upperBound;
                if (vector33 != null) {
                    codedOutputByteBufferNano.writeMessage(3, vector33);
                }
                Vector3 vector34 = this.standardDeviation;
                if (vector34 != null) {
                    codedOutputByteBufferNano.writeMessage(4, vector34);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final GyroscopeStats m425clone() {
                try {
                    GyroscopeStats gyroscopeStats = (GyroscopeStats) super.clone();
                    Vector3 vector3 = this.bias;
                    if (vector3 != null) {
                        gyroscopeStats.bias = vector3.m428clone();
                    }
                    Vector3 vector32 = this.lowerBound;
                    if (vector32 != null) {
                        gyroscopeStats.lowerBound = vector32.m428clone();
                    }
                    Vector3 vector33 = this.upperBound;
                    if (vector33 != null) {
                        gyroscopeStats.upperBound = vector33.m428clone();
                    }
                    Vector3 vector34 = this.standardDeviation;
                    if (vector34 != null) {
                        gyroscopeStats.standardDeviation = vector34.m428clone();
                    }
                    return gyroscopeStats;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Vector3 extends ExtendableMessageNano<Vector3> implements Cloneable {
            private Float x = null;
            private Float y = null;
            private Float z = null;

            public Vector3() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Float f = this.x;
                if (f != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue());
                }
                Float f2 = this.y;
                if (f2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f2.floatValue());
                }
                Float f3 = this.z;
                return f3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, f3.floatValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 13) {
                        this.x = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag == 21) {
                        this.y = Float.valueOf(codedInputByteBufferNano.readFloat());
                    } else if (readTag != 29) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.z = Float.valueOf(codedInputByteBufferNano.readFloat());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Float f = this.x;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(1, f.floatValue());
                }
                Float f2 = this.y;
                if (f2 != null) {
                    codedOutputByteBufferNano.writeFloat(2, f2.floatValue());
                }
                Float f3 = this.z;
                if (f3 != null) {
                    codedOutputByteBufferNano.writeFloat(3, f3.floatValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Vector3 m428clone() {
                try {
                    return (Vector3) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final SensorStats m422clone() {
            try {
                SensorStats sensorStats = (SensorStats) super.clone();
                GyroscopeStats gyroscopeStats = this.gyroscopeStats;
                if (gyroscopeStats != null) {
                    sensorStats.gyroscopeStats = gyroscopeStats.m425clone();
                }
                return sensorStats;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class StreetView extends ExtendableMessageNano<StreetView> implements Cloneable {
        private PanoSession panoSession = null;
        private TutorialSession tutorialSession = null;

        public StreetView() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            PanoSession panoSession = this.panoSession;
            if (panoSession != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, panoSession);
            }
            TutorialSession tutorialSession = this.tutorialSession;
            return tutorialSession != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, tutorialSession) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.panoSession == null) {
                        this.panoSession = new PanoSession();
                    }
                    codedInputByteBufferNano.readMessage(this.panoSession);
                } else if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.tutorialSession == null) {
                        this.tutorialSession = new TutorialSession();
                    }
                    codedInputByteBufferNano.readMessage(this.tutorialSession);
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            PanoSession panoSession = this.panoSession;
            if (panoSession != null) {
                codedOutputByteBufferNano.writeMessage(1, panoSession);
            }
            TutorialSession tutorialSession = this.tutorialSession;
            if (tutorialSession != null) {
                codedOutputByteBufferNano.writeMessage(2, tutorialSession);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class PanoSession extends ExtendableMessageNano<PanoSession> implements Cloneable {
            private Integer source = null;
            private Integer panosAvailable = null;
            private Integer panosViewed = null;
            private Integer nodesNavigated = null;
            private Integer nextClicks = null;
            private Integer prevClicks = null;
            private Integer playPauseClicks = null;
            private Integer infoClicks = null;

            public PanoSession() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.source;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Integer num2 = this.panosAvailable;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
                }
                Integer num3 = this.panosViewed;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
                }
                Integer num4 = this.nodesNavigated;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num4.intValue());
                }
                Integer num5 = this.nextClicks;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num5.intValue());
                }
                Integer num6 = this.prevClicks;
                if (num6 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num6.intValue());
                }
                Integer num7 = this.playPauseClicks;
                if (num7 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, num7.intValue());
                }
                Integer num8 = this.infoClicks;
                return num8 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, num8.intValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.source = Integer.valueOf(readInt32);
                        }
                    } else if (readTag == 16) {
                        this.panosAvailable = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 24) {
                        this.panosViewed = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 32) {
                        this.nodesNavigated = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 40) {
                        this.nextClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 48) {
                        this.prevClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 56) {
                        this.playPauseClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag != 64) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.infoClicks = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.source;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Integer num2 = this.panosAvailable;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(2, num2.intValue());
                }
                Integer num3 = this.panosViewed;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num3.intValue());
                }
                Integer num4 = this.nodesNavigated;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num4.intValue());
                }
                Integer num5 = this.nextClicks;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num5.intValue());
                }
                Integer num6 = this.prevClicks;
                if (num6 != null) {
                    codedOutputByteBufferNano.writeInt32(6, num6.intValue());
                }
                Integer num7 = this.playPauseClicks;
                if (num7 != null) {
                    codedOutputByteBufferNano.writeInt32(7, num7.intValue());
                }
                Integer num8 = this.infoClicks;
                if (num8 != null) {
                    codedOutputByteBufferNano.writeInt32(8, num8.intValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final PanoSession m434clone() {
                try {
                    return (PanoSession) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class TutorialSession extends ExtendableMessageNano<TutorialSession> implements Cloneable {
            private Integer tutorial = null;
            private Boolean completed = null;

            public TutorialSession() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.tutorial;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Boolean bool = this.completed;
                return bool != null ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, bool.booleanValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        int position = codedInputByteBufferNano.getPosition();
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                        } else {
                            this.tutorial = Integer.valueOf(readInt32);
                        }
                    } else if (readTag != 16) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.completed = Boolean.valueOf(codedInputByteBufferNano.readBool());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.tutorial;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Boolean bool = this.completed;
                if (bool != null) {
                    codedOutputByteBufferNano.writeBool(2, bool.booleanValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final TutorialSession m437clone() {
                try {
                    return (TutorialSession) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final StreetView m431clone() {
            try {
                StreetView streetView = (StreetView) super.clone();
                PanoSession panoSession = this.panoSession;
                if (panoSession != null) {
                    streetView.panoSession = panoSession.m434clone();
                }
                TutorialSession tutorialSession = this.tutorialSession;
                if (tutorialSession != null) {
                    streetView.tutorialSession = tutorialSession.m437clone();
                }
                return streetView;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class TimeSeriesData extends ExtendableMessageNano<TimeSeriesData> implements Cloneable {
        private Integer timeIntervalSeconds = null;
        private TimeIntervalData[] timeIntervalData = TimeIntervalData.emptyArray();

        public TimeSeriesData() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.timeIntervalSeconds;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
            if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.timeIntervalData;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.timeIntervalSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
                    int length = timeIntervalDataArr == null ? 0 : timeIntervalDataArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new TimeIntervalData[i];
                    if (length != 0) {
                        System.arraycopy(timeIntervalDataArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new TimeIntervalData();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new TimeIntervalData();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.timeIntervalData = messageNanoArr;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.timeIntervalSeconds;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
            if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.timeIntervalData;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(2, messageNano);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class TimeIntervalData extends ExtendableMessageNano<TimeIntervalData> implements Cloneable {
            private static volatile TimeIntervalData[] _emptyArray;
            private Integer intervalStartTimeSeconds = null;
            private Float skinTemperature = null;
            private Integer edsThreadFrameDropCount = null;
            private Integer batteryLevel = null;
            private Integer batteryLevelDelta = null;
            private Integer thermalWarningsShown = null;
            private float[] cpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
            private float[] gpuTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
            private float[] batteryTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;

            public TimeIntervalData() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static TimeIntervalData[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new TimeIntervalData[0];
                        }
                    }
                }
                return _emptyArray;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.intervalStartTimeSeconds;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Float f = this.skinTemperature;
                if (f != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f.floatValue());
                }
                Integer num2 = this.edsThreadFrameDropCount;
                if (num2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
                }
                Integer num3 = this.batteryLevel;
                if (num3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, num3.intValue());
                }
                Integer num4 = this.batteryLevelDelta;
                if (num4 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, num4.intValue());
                }
                Integer num5 = this.thermalWarningsShown;
                if (num5 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, num5.intValue());
                }
                float[] fArr = this.cpuTemperature;
                if (fArr != null && fArr.length > 0) {
                    computeSerializedSize = computeSerializedSize + (fArr.length * 4) + (fArr.length * 1);
                }
                float[] fArr2 = this.gpuTemperature;
                if (fArr2 != null && fArr2.length > 0) {
                    computeSerializedSize = computeSerializedSize + (fArr2.length * 4) + (fArr2.length * 1);
                }
                float[] fArr3 = this.batteryTemperature;
                return (fArr3 == null || fArr3.length <= 0) ? computeSerializedSize : computeSerializedSize + (fArr3.length * 4) + (fArr3.length * 1);
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    switch (readTag) {
                        case 0:
                            return this;
                        case 8:
                            this.intervalStartTimeSeconds = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 21:
                            this.skinTemperature = Float.valueOf(codedInputByteBufferNano.readFloat());
                            break;
                        case 24:
                            this.edsThreadFrameDropCount = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 32:
                            this.batteryLevel = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 40:
                            this.batteryLevelDelta = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 48:
                            this.thermalWarningsShown = Integer.valueOf(codedInputByteBufferNano.readInt32());
                            break;
                        case 58:
                            int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                            int i = readRawVarint32 / 4;
                            float[] fArr = this.cpuTemperature;
                            int length = fArr == null ? 0 : fArr.length;
                            int i2 = i + length;
                            float[] fArr2 = new float[i2];
                            if (length != 0) {
                                System.arraycopy(fArr, 0, fArr2, 0, length);
                            }
                            while (length < i2) {
                                fArr2[length] = codedInputByteBufferNano.readFloat();
                                length++;
                            }
                            this.cpuTemperature = fArr2;
                            codedInputByteBufferNano.popLimit(pushLimit);
                            break;
                        case 61:
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 61);
                            float[] fArr3 = this.cpuTemperature;
                            int length2 = fArr3 == null ? 0 : fArr3.length;
                            int i3 = repeatedFieldArrayLength + length2;
                            float[] fArr4 = new float[i3];
                            if (length2 != 0) {
                                System.arraycopy(fArr3, 0, fArr4, 0, length2);
                            }
                            while (length2 < i3 - 1) {
                                fArr4[length2] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length2++;
                            }
                            fArr4[length2] = codedInputByteBufferNano.readFloat();
                            this.cpuTemperature = fArr4;
                            break;
                        case 66:
                            int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                            int i4 = readRawVarint322 / 4;
                            float[] fArr5 = this.gpuTemperature;
                            int length3 = fArr5 == null ? 0 : fArr5.length;
                            int i5 = i4 + length3;
                            float[] fArr6 = new float[i5];
                            if (length3 != 0) {
                                System.arraycopy(fArr5, 0, fArr6, 0, length3);
                            }
                            while (length3 < i5) {
                                fArr6[length3] = codedInputByteBufferNano.readFloat();
                                length3++;
                            }
                            this.gpuTemperature = fArr6;
                            codedInputByteBufferNano.popLimit(pushLimit2);
                            break;
                        case 69:
                            int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 69);
                            float[] fArr7 = this.gpuTemperature;
                            int length4 = fArr7 == null ? 0 : fArr7.length;
                            int i6 = repeatedFieldArrayLength2 + length4;
                            float[] fArr8 = new float[i6];
                            if (length4 != 0) {
                                System.arraycopy(fArr7, 0, fArr8, 0, length4);
                            }
                            while (length4 < i6 - 1) {
                                fArr8[length4] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length4++;
                            }
                            fArr8[length4] = codedInputByteBufferNano.readFloat();
                            this.gpuTemperature = fArr8;
                            break;
                        case 74:
                            int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                            int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                            int i7 = readRawVarint323 / 4;
                            float[] fArr9 = this.batteryTemperature;
                            int length5 = fArr9 == null ? 0 : fArr9.length;
                            int i8 = i7 + length5;
                            float[] fArr10 = new float[i8];
                            if (length5 != 0) {
                                System.arraycopy(fArr9, 0, fArr10, 0, length5);
                            }
                            while (length5 < i8) {
                                fArr10[length5] = codedInputByteBufferNano.readFloat();
                                length5++;
                            }
                            this.batteryTemperature = fArr10;
                            codedInputByteBufferNano.popLimit(pushLimit3);
                            break;
                        case 77:
                            int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 77);
                            float[] fArr11 = this.batteryTemperature;
                            int length6 = fArr11 == null ? 0 : fArr11.length;
                            int i9 = repeatedFieldArrayLength3 + length6;
                            float[] fArr12 = new float[i9];
                            if (length6 != 0) {
                                System.arraycopy(fArr11, 0, fArr12, 0, length6);
                            }
                            while (length6 < i9 - 1) {
                                fArr12[length6] = codedInputByteBufferNano.readFloat();
                                codedInputByteBufferNano.readTag();
                                length6++;
                            }
                            fArr12[length6] = codedInputByteBufferNano.readFloat();
                            this.batteryTemperature = fArr12;
                            break;
                        default:
                            if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                                break;
                            } else {
                                return this;
                            }
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.intervalStartTimeSeconds;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Float f = this.skinTemperature;
                if (f != null) {
                    codedOutputByteBufferNano.writeFloat(2, f.floatValue());
                }
                Integer num2 = this.edsThreadFrameDropCount;
                if (num2 != null) {
                    codedOutputByteBufferNano.writeInt32(3, num2.intValue());
                }
                Integer num3 = this.batteryLevel;
                if (num3 != null) {
                    codedOutputByteBufferNano.writeInt32(4, num3.intValue());
                }
                Integer num4 = this.batteryLevelDelta;
                if (num4 != null) {
                    codedOutputByteBufferNano.writeInt32(5, num4.intValue());
                }
                Integer num5 = this.thermalWarningsShown;
                if (num5 != null) {
                    codedOutputByteBufferNano.writeInt32(6, num5.intValue());
                }
                float[] fArr = this.cpuTemperature;
                int i = 0;
                if (fArr != null && fArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        float[] fArr2 = this.cpuTemperature;
                        if (i2 >= fArr2.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloat(7, fArr2[i2]);
                        i2++;
                    }
                }
                float[] fArr3 = this.gpuTemperature;
                if (fArr3 != null && fArr3.length > 0) {
                    int i3 = 0;
                    while (true) {
                        float[] fArr4 = this.gpuTemperature;
                        if (i3 >= fArr4.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloat(8, fArr4[i3]);
                        i3++;
                    }
                }
                float[] fArr5 = this.batteryTemperature;
                if (fArr5 != null && fArr5.length > 0) {
                    while (true) {
                        float[] fArr6 = this.batteryTemperature;
                        if (i >= fArr6.length) {
                            break;
                        }
                        codedOutputByteBufferNano.writeFloat(9, fArr6[i]);
                        i++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final TimeIntervalData m443clone() {
                try {
                    TimeIntervalData timeIntervalData = (TimeIntervalData) super.clone();
                    float[] fArr = this.cpuTemperature;
                    if (fArr != null && fArr.length > 0) {
                        timeIntervalData.cpuTemperature = (float[]) fArr.clone();
                    }
                    float[] fArr2 = this.gpuTemperature;
                    if (fArr2 != null && fArr2.length > 0) {
                        timeIntervalData.gpuTemperature = (float[]) fArr2.clone();
                    }
                    float[] fArr3 = this.batteryTemperature;
                    if (fArr3 != null && fArr3.length > 0) {
                        timeIntervalData.batteryTemperature = (float[]) fArr3.clone();
                    }
                    return timeIntervalData;
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final TimeSeriesData m440clone() {
            try {
                TimeSeriesData timeSeriesData = (TimeSeriesData) super.clone();
                TimeIntervalData[] timeIntervalDataArr = this.timeIntervalData;
                if (timeIntervalDataArr != null && timeIntervalDataArr.length > 0) {
                    timeSeriesData.timeIntervalData = new TimeIntervalData[timeIntervalDataArr.length];
                    int i = 0;
                    while (true) {
                        TimeIntervalData[] timeIntervalDataArr2 = this.timeIntervalData;
                        if (i >= timeIntervalDataArr2.length) {
                            break;
                        }
                        if (timeIntervalDataArr2[i] != null) {
                            timeSeriesData.timeIntervalData[i] = timeIntervalDataArr2[i].m443clone();
                        }
                        i++;
                    }
                }
                return timeSeriesData;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class VrStreaming extends ExtendableMessageNano<VrStreaming> implements Cloneable {
        private SessionInfo sessionInfo = null;
        private Frame[] frame = Frame.emptyArray();

        public VrStreaming() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            SessionInfo sessionInfo = this.sessionInfo;
            if (sessionInfo != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sessionInfo);
            }
            Frame[] frameArr = this.frame;
            if (frameArr != null && frameArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frame;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, messageNano);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    if (this.sessionInfo == null) {
                        this.sessionInfo = new SessionInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.sessionInfo);
                } else if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    Frame[] frameArr = this.frame;
                    int length = frameArr == null ? 0 : frameArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new Frame[i];
                    if (length != 0) {
                        System.arraycopy(frameArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new Frame();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new Frame();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.frame = messageNanoArr;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            SessionInfo sessionInfo = this.sessionInfo;
            if (sessionInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, sessionInfo);
            }
            Frame[] frameArr = this.frame;
            if (frameArr != null && frameArr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frame;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(2, messageNano);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class Frame extends ExtendableMessageNano<Frame> implements Cloneable {
            private static volatile Frame[] _emptyArray;
            private Integer poseId = null;
            private Long poseSendTimeUsec = null;
            private Long framePresentTimeUsec = null;
            private Long decodeStartTimeUsec = null;
            private Long decodeEndTimeUsec = null;

            public Frame() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            public static Frame[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Frame[0];
                        }
                    }
                }
                return _emptyArray;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                Integer num = this.poseId;
                if (num != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
                }
                Long l = this.poseSendTimeUsec;
                if (l != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, l.longValue());
                }
                Long l2 = this.framePresentTimeUsec;
                if (l2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, l2.longValue());
                }
                Long l3 = this.decodeStartTimeUsec;
                if (l3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, l3.longValue());
                }
                Long l4 = this.decodeEndTimeUsec;
                return l4 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, l4.longValue()) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag == 8) {
                        this.poseId = Integer.valueOf(codedInputByteBufferNano.readInt32());
                    } else if (readTag == 16) {
                        this.poseSendTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    } else if (readTag == 24) {
                        this.framePresentTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    } else if (readTag == 32) {
                        this.decodeStartTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    } else if (readTag != 40) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.decodeEndTimeUsec = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                Integer num = this.poseId;
                if (num != null) {
                    codedOutputByteBufferNano.writeInt32(1, num.intValue());
                }
                Long l = this.poseSendTimeUsec;
                if (l != null) {
                    codedOutputByteBufferNano.writeUInt64(2, l.longValue());
                }
                Long l2 = this.framePresentTimeUsec;
                if (l2 != null) {
                    codedOutputByteBufferNano.writeUInt64(3, l2.longValue());
                }
                Long l3 = this.decodeStartTimeUsec;
                if (l3 != null) {
                    codedOutputByteBufferNano.writeUInt64(4, l3.longValue());
                }
                Long l4 = this.decodeEndTimeUsec;
                if (l4 != null) {
                    codedOutputByteBufferNano.writeUInt64(5, l4.longValue());
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final Frame m488clone() {
                try {
                    return (Frame) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public final class SessionInfo extends ExtendableMessageNano<SessionInfo> implements Cloneable {
            private String sessionId = null;

            public SessionInfo() {
                this.unknownFieldData = null;
                this.cachedSize = -1;
            }

            protected final int computeSerializedSize() {
                int computeSerializedSize = super.computeSerializedSize();
                String str = this.sessionId;
                return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
            }

            public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
                while (true) {
                    int readTag = codedInputByteBufferNano.readTag();
                    if (readTag == 0) {
                        return this;
                    }
                    if (readTag != 10) {
                        if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        this.sessionId = codedInputByteBufferNano.readString();
                    }
                }
            }

            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
                String str = this.sessionId;
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            /* renamed from: clone */
            public final SessionInfo m491clone() {
                try {
                    return (SessionInfo) super.clone();
                } catch (CloneNotSupportedException e) {
                    throw new AssertionError(e);
                }
            }
        }

        /* renamed from: clone */
        public final VrStreaming m485clone() {
            try {
                VrStreaming vrStreaming = (VrStreaming) super.clone();
                SessionInfo sessionInfo = this.sessionInfo;
                if (sessionInfo != null) {
                    vrStreaming.sessionInfo = sessionInfo.m491clone();
                }
                Frame[] frameArr = this.frame;
                if (frameArr != null && frameArr.length > 0) {
                    vrStreaming.frame = new Frame[frameArr.length];
                    int i = 0;
                    while (true) {
                        Frame[] frameArr2 = this.frame;
                        if (i >= frameArr2.length) {
                            break;
                        }
                        if (frameArr2[i] != null) {
                            vrStreaming.frame[i] = frameArr2[i].m488clone();
                        }
                        i++;
                    }
                }
                return vrStreaming;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Application extends ExtendableMessageNano<Application> implements Cloneable {
        private static volatile Application[] _emptyArray;
        private String packageName = null;
        private String name = null;
        private String version = null;

        public Application() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public static Application[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Application[0];
                    }
                }
            }
            return _emptyArray;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.packageName;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.name;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            String str3 = this.version;
            return str3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, str3) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.packageName = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag != 26) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.version = codedInputByteBufferNano.readString();
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.packageName;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.name;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            String str3 = this.version;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(3, str3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final Application m248clone() {
            try {
                return (Application) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class AudioStats extends ExtendableMessageNano<AudioStats> implements Cloneable {
        private Integer renderingMode = null;
        private Integer sampleRate = null;
        private Integer framesPerBuffer = null;
        private HistogramBucket[] renderingTimePerBufferMilliseconds = HistogramBucket.emptyArray();
        private HistogramBucket[] numberOfSimultaneousSoundObjects = HistogramBucket.emptyArray();
        private HistogramBucket[] numberOfSimultaneousSoundFields = HistogramBucket.emptyArray();
        private HistogramBucket[] cpuMeasurementsPercent = HistogramBucket.emptyArray();

        public AudioStats() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.renderingMode;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.sampleRate;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue());
            }
            Integer num3 = this.framesPerBuffer;
            if (num3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num3.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.renderingTimePerBufferMilliseconds;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, messageNano);
                    }
                    i2++;
                }
            }
            HistogramBucket[] histogramBucketArr2 = this.numberOfSimultaneousSoundObjects;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.numberOfSimultaneousSoundObjects;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundFields;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.numberOfSimultaneousSoundFields;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.cpuMeasurementsPercent;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr4 = this.cpuMeasurementsPercent;
                    if (i >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i];
                    if (messageNano4 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, messageNano4);
                    }
                    i++;
                }
            }
            return computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    } else {
                        this.renderingMode = Integer.valueOf(readInt32);
                    }
                } else if (readTag == 16) {
                    this.sampleRate = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 24) {
                    this.framesPerBuffer = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
                    int length = histogramBucketArr == null ? 0 : histogramBucketArr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new HistogramBucket[i];
                    if (length != 0) {
                        System.arraycopy(histogramBucketArr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.renderingTimePerBufferMilliseconds = messageNanoArr;
                } else if (readTag == 42) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    HistogramBucket[] histogramBucketArr2 = this.numberOfSimultaneousSoundObjects;
                    int length2 = histogramBucketArr2 == null ? 0 : histogramBucketArr2.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    MessageNano[] messageNanoArr2 = new HistogramBucket[i2];
                    if (length2 != 0) {
                        System.arraycopy(histogramBucketArr2, 0, messageNanoArr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        messageNanoArr2[length2] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    messageNanoArr2[length2] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                    this.numberOfSimultaneousSoundObjects = messageNanoArr2;
                } else if (readTag == 50) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundFields;
                    int length3 = histogramBucketArr3 == null ? 0 : histogramBucketArr3.length;
                    int i3 = repeatedFieldArrayLength3 + length3;
                    MessageNano[] messageNanoArr3 = new HistogramBucket[i3];
                    if (length3 != 0) {
                        System.arraycopy(histogramBucketArr3, 0, messageNanoArr3, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        messageNanoArr3[length3] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    messageNanoArr3[length3] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                    this.numberOfSimultaneousSoundFields = messageNanoArr3;
                } else if (readTag != 58) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    HistogramBucket[] histogramBucketArr4 = this.cpuMeasurementsPercent;
                    int length4 = histogramBucketArr4 == null ? 0 : histogramBucketArr4.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    MessageNano[] messageNanoArr4 = new HistogramBucket[i4];
                    if (length4 != 0) {
                        System.arraycopy(histogramBucketArr4, 0, messageNanoArr4, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        messageNanoArr4[length4] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    messageNanoArr4[length4] = new HistogramBucket();
                    codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                    this.cpuMeasurementsPercent = messageNanoArr4;
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.renderingMode;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.sampleRate;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            Integer num3 = this.framesPerBuffer;
            if (num3 != null) {
                codedOutputByteBufferNano.writeInt32(3, num3.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.renderingTimePerBufferMilliseconds;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(4, messageNano);
                    }
                    i2++;
                }
            }
            HistogramBucket[] histogramBucketArr2 = this.numberOfSimultaneousSoundObjects;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.numberOfSimultaneousSoundObjects;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundFields;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.numberOfSimultaneousSoundFields;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        codedOutputByteBufferNano.writeMessage(6, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.cpuMeasurementsPercent;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr4 = this.cpuMeasurementsPercent;
                    if (i >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i];
                    if (messageNano4 != null) {
                        codedOutputByteBufferNano.writeMessage(7, messageNano4);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final AudioStats m251clone() {
            try {
                AudioStats audioStats = (AudioStats) super.clone();
                HistogramBucket[] histogramBucketArr = this.renderingTimePerBufferMilliseconds;
                int i = 0;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    audioStats.renderingTimePerBufferMilliseconds = new HistogramBucket[histogramBucketArr.length];
                    int i2 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.renderingTimePerBufferMilliseconds;
                        if (i2 >= histogramBucketArr2.length) {
                            break;
                        }
                        if (histogramBucketArr2[i2] != null) {
                            audioStats.renderingTimePerBufferMilliseconds[i2] = histogramBucketArr2[i2].m338clone();
                        }
                        i2++;
                    }
                }
                HistogramBucket[] histogramBucketArr3 = this.numberOfSimultaneousSoundObjects;
                if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                    audioStats.numberOfSimultaneousSoundObjects = new HistogramBucket[histogramBucketArr3.length];
                    int i3 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr4 = this.numberOfSimultaneousSoundObjects;
                        if (i3 >= histogramBucketArr4.length) {
                            break;
                        }
                        if (histogramBucketArr4[i3] != null) {
                            audioStats.numberOfSimultaneousSoundObjects[i3] = histogramBucketArr4[i3].m338clone();
                        }
                        i3++;
                    }
                }
                HistogramBucket[] histogramBucketArr5 = this.numberOfSimultaneousSoundFields;
                if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                    audioStats.numberOfSimultaneousSoundFields = new HistogramBucket[histogramBucketArr5.length];
                    int i4 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr6 = this.numberOfSimultaneousSoundFields;
                        if (i4 >= histogramBucketArr6.length) {
                            break;
                        }
                        if (histogramBucketArr6[i4] != null) {
                            audioStats.numberOfSimultaneousSoundFields[i4] = histogramBucketArr6[i4].m338clone();
                        }
                        i4++;
                    }
                }
                HistogramBucket[] histogramBucketArr7 = this.cpuMeasurementsPercent;
                if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                    audioStats.cpuMeasurementsPercent = new HistogramBucket[histogramBucketArr7.length];
                    while (true) {
                        HistogramBucket[] histogramBucketArr8 = this.cpuMeasurementsPercent;
                        if (i >= histogramBucketArr8.length) {
                            break;
                        }
                        if (histogramBucketArr8[i] != null) {
                            audioStats.cpuMeasurementsPercent[i] = histogramBucketArr8[i].m338clone();
                        }
                        i++;
                    }
                }
                return audioStats;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class DoublePrecisionTransform extends ExtendableMessageNano<DoublePrecisionTransform> implements Cloneable {
        private Double translationX = null;
        private Double translationY = null;
        private Double translationZ = null;
        private Double rotationQx = null;
        private Double rotationQy = null;
        private Double rotationQz = null;
        private Double scale = null;

        public DoublePrecisionTransform() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Double d = this.translationX;
            if (d != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, d.doubleValue());
            }
            Double d2 = this.translationY;
            if (d2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, d2.doubleValue());
            }
            Double d3 = this.translationZ;
            if (d3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, d3.doubleValue());
            }
            Double d4 = this.rotationQx;
            if (d4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(4, d4.doubleValue());
            }
            Double d5 = this.rotationQy;
            if (d5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(5, d5.doubleValue());
            }
            Double d6 = this.rotationQz;
            if (d6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, d6.doubleValue());
            }
            Double d7 = this.scale;
            return d7 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(7, d7.doubleValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 9) {
                    this.translationX = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 17) {
                    this.translationY = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 25) {
                    this.translationZ = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 33) {
                    this.rotationQx = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 41) {
                    this.rotationQy = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag == 49) {
                    this.rotationQz = Double.valueOf(codedInputByteBufferNano.readDouble());
                } else if (readTag != 57) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.scale = Double.valueOf(codedInputByteBufferNano.readDouble());
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Double d = this.translationX;
            if (d != null) {
                codedOutputByteBufferNano.writeDouble(1, d.doubleValue());
            }
            Double d2 = this.translationY;
            if (d2 != null) {
                codedOutputByteBufferNano.writeDouble(2, d2.doubleValue());
            }
            Double d3 = this.translationZ;
            if (d3 != null) {
                codedOutputByteBufferNano.writeDouble(3, d3.doubleValue());
            }
            Double d4 = this.rotationQx;
            if (d4 != null) {
                codedOutputByteBufferNano.writeDouble(4, d4.doubleValue());
            }
            Double d5 = this.rotationQy;
            if (d5 != null) {
                codedOutputByteBufferNano.writeDouble(5, d5.doubleValue());
            }
            Double d6 = this.rotationQz;
            if (d6 != null) {
                codedOutputByteBufferNano.writeDouble(6, d6.doubleValue());
            }
            Double d7 = this.scale;
            if (d7 != null) {
                codedOutputByteBufferNano.writeDouble(7, d7.doubleValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final DoublePrecisionTransform m269clone() {
            try {
                return (DoublePrecisionTransform) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Expeditions extends ExtendableMessageNano<Expeditions> implements Cloneable {
        private String contentId = null;

        public Expeditions() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.contentId;
            return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, str) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag != 10) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.contentId = codedInputByteBufferNano.readString();
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.contentId;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final Expeditions m323clone() {
            try {
                return (Expeditions) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class HeadMount extends ExtendableMessageNano<HeadMount> implements Cloneable {
        private String vendor = null;
        private String model = null;

        public HeadMount() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.vendor;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.model;
            return str2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str2) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.vendor = codedInputByteBufferNano.readString();
                } else if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.model = codedInputByteBufferNano.readString();
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.vendor;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.model;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final HeadMount m332clone() {
            try {
                return (HeadMount) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class HeadTracking extends ExtendableMessageNano<HeadTracking> implements Cloneable {
        private Integer sixDofFallbackReason = null;
        private Long sixDofFallbackTimestamp = null;
        private Float floorHeight = null;
        private Long headTrackingTimestamp = null;

        public HeadTracking() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.sixDofFallbackReason;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Long l = this.sixDofFallbackTimestamp;
            if (l != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, l.longValue());
            }
            Float f = this.floorHeight;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, f.floatValue());
            }
            Long l2 = this.headTrackingTimestamp;
            return l2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, l2.longValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.sixDofFallbackReason = Integer.valueOf(readInt32);
                            continue;
                        default:
                            codedInputByteBufferNano.rewindToPosition(position);
                            storeUnknownField(codedInputByteBufferNano, readTag);
                            continue;
                    }
                } else if (readTag == 16) {
                    this.sixDofFallbackTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                } else if (readTag == 29) {
                    this.floorHeight = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag != 32) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.headTrackingTimestamp = Long.valueOf(codedInputByteBufferNano.readInt64());
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.sixDofFallbackReason;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Long l = this.sixDofFallbackTimestamp;
            if (l != null) {
                codedOutputByteBufferNano.writeInt64(2, l.longValue());
            }
            Float f = this.floorHeight;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(3, f.floatValue());
            }
            Long l2 = this.headTrackingTimestamp;
            if (l2 != null) {
                codedOutputByteBufferNano.writeInt64(4, l2.longValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final HeadTracking m335clone() {
            try {
                return (HeadTracking) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class HistogramBucket extends ExtendableMessageNano<HistogramBucket> implements Cloneable {
        private static volatile HistogramBucket[] _emptyArray;
        private Integer minimumValue = null;
        private Integer count = null;

        public HistogramBucket() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public static HistogramBucket[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new HistogramBucket[0];
                    }
                }
            }
            return _emptyArray;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.minimumValue;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            Integer num2 = this.count;
            return num2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, num2.intValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.minimumValue = Integer.valueOf(codedInputByteBufferNano.readInt32());
                } else if (readTag != 16) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.count = Integer.valueOf(codedInputByteBufferNano.readInt32());
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.minimumValue;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            Integer num2 = this.count;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(2, num2.intValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final HistogramBucket m338clone() {
            try {
                return (HistogramBucket) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Launcher extends ExtendableMessageNano<Launcher> implements Cloneable {
        private Integer navItem = null;

        public Launcher() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.navItem;
            return num != null ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, num.intValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag != 8) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 6 && readInt32 != 7 && readInt32 != 8) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    } else {
                        this.navItem = Integer.valueOf(readInt32);
                    }
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.navItem;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final Launcher m383clone() {
            try {
                return (Launcher) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class PerformanceStats extends ExtendableMessageNano<PerformanceStats> implements Cloneable {
        private Integer averageFps = null;
        private HistogramBucket[] frameTime = HistogramBucket.emptyArray();
        private Integer memoryConsumptionKilobytes = null;
        private Float throttleSkinTemperatureCelsius = null;
        private Float vrMaxSkinTemperatureCelsius = null;
        private Float shutdownSkinTemperatureCelsius = null;
        private TimeSeriesData timeSeriesData = null;
        private HistogramBucket[] appRenderTime = HistogramBucket.emptyArray();
        private HistogramBucket[] presentTime = HistogramBucket.emptyArray();
        private HistogramBucket[] totalRenderTime = HistogramBucket.emptyArray();
        private HistogramBucket[] postFrameTime = HistogramBucket.emptyArray();
        private HistogramBucket[] consecutiveDroppedFrames = HistogramBucket.emptyArray();
        private HistogramBucket[] scanlineRacingVsyncOvershootUs = HistogramBucket.emptyArray();
        private Integer thermalEventFlags = null;
        private float[] cpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] gpuThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] batteryThrottlingTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] cpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] gpuShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private float[] batteryShutdownTemperature = WireFormatNano.EMPTY_FLOAT_ARRAY;
        private Float averageAppFps = null;
        private Float edsFps = null;

        public PerformanceStats() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.averageFps;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.frameTime;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frameTime;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, messageNano);
                    }
                    i2++;
                }
            }
            Integer num2 = this.memoryConsumptionKilobytes;
            if (num2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, num2.intValue());
            }
            Float f = this.throttleSkinTemperatureCelsius;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, f.floatValue());
            }
            Float f2 = this.vrMaxSkinTemperatureCelsius;
            if (f2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, f2.floatValue());
            }
            Float f3 = this.shutdownSkinTemperatureCelsius;
            if (f3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, f3.floatValue());
            }
            TimeSeriesData timeSeriesData = this.timeSeriesData;
            if (timeSeriesData != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, timeSeriesData);
            }
            HistogramBucket[] histogramBucketArr2 = this.appRenderTime;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.appRenderTime;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.presentTime;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.presentTime;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.totalRenderTime;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                int i5 = 0;
                while (true) {
                    MessageNano[] messageNanoArr4 = this.totalRenderTime;
                    if (i5 >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i5];
                    if (messageNano4 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, messageNano4);
                    }
                    i5++;
                }
            }
            HistogramBucket[] histogramBucketArr5 = this.postFrameTime;
            if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                int i6 = 0;
                while (true) {
                    MessageNano[] messageNanoArr5 = this.postFrameTime;
                    if (i6 >= messageNanoArr5.length) {
                        break;
                    }
                    MessageNano messageNano5 = messageNanoArr5[i6];
                    if (messageNano5 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, messageNano5);
                    }
                    i6++;
                }
            }
            HistogramBucket[] histogramBucketArr6 = this.consecutiveDroppedFrames;
            if (histogramBucketArr6 != null && histogramBucketArr6.length > 0) {
                int i7 = 0;
                while (true) {
                    MessageNano[] messageNanoArr6 = this.consecutiveDroppedFrames;
                    if (i7 >= messageNanoArr6.length) {
                        break;
                    }
                    MessageNano messageNano6 = messageNanoArr6[i7];
                    if (messageNano6 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, messageNano6);
                    }
                    i7++;
                }
            }
            HistogramBucket[] histogramBucketArr7 = this.scanlineRacingVsyncOvershootUs;
            if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                while (true) {
                    MessageNano[] messageNanoArr7 = this.scanlineRacingVsyncOvershootUs;
                    if (i >= messageNanoArr7.length) {
                        break;
                    }
                    MessageNano messageNano7 = messageNanoArr7[i];
                    if (messageNano7 != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, messageNano7);
                    }
                    i++;
                }
            }
            Integer num3 = this.thermalEventFlags;
            if (num3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, num3.intValue());
            }
            float[] fArr = this.cpuThrottlingTemperature;
            if (fArr != null && fArr.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr.length * 4) + (fArr.length * 1);
            }
            float[] fArr2 = this.gpuThrottlingTemperature;
            if (fArr2 != null && fArr2.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr2.length * 4) + (fArr2.length * 2);
            }
            float[] fArr3 = this.batteryThrottlingTemperature;
            if (fArr3 != null && fArr3.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr3.length * 4) + (fArr3.length * 2);
            }
            float[] fArr4 = this.cpuShutdownTemperature;
            if (fArr4 != null && fArr4.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr4.length * 4) + (fArr4.length * 2);
            }
            float[] fArr5 = this.gpuShutdownTemperature;
            if (fArr5 != null && fArr5.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr5.length * 4) + (fArr5.length * 2);
            }
            float[] fArr6 = this.batteryShutdownTemperature;
            if (fArr6 != null && fArr6.length > 0) {
                computeSerializedSize = computeSerializedSize + (fArr6.length * 4) + (fArr6.length * 2);
            }
            Float f4 = this.averageAppFps;
            if (f4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(21, f4.floatValue());
            }
            Float f5 = this.edsFps;
            return f5 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(22, f5.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                switch (readTag) {
                    case 0:
                        return this;
                    case 8:
                        this.averageFps = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        HistogramBucket[] histogramBucketArr = this.frameTime;
                        int length = histogramBucketArr == null ? 0 : histogramBucketArr.length;
                        int i = repeatedFieldArrayLength + length;
                        MessageNano[] messageNanoArr = new HistogramBucket[i];
                        if (length != 0) {
                            System.arraycopy(histogramBucketArr, 0, messageNanoArr, 0, length);
                        }
                        while (length < i - 1) {
                            messageNanoArr[length] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        messageNanoArr[length] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        this.frameTime = messageNanoArr;
                        break;
                    case 24:
                        this.memoryConsumptionKilobytes = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 37:
                        this.throttleSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case 45:
                        this.vrMaxSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case 53:
                        this.shutdownSkinTemperatureCelsius = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case 58:
                        if (this.timeSeriesData == null) {
                            this.timeSeriesData = new TimeSeriesData();
                        }
                        codedInputByteBufferNano.readMessage(this.timeSeriesData);
                        break;
                    case 66:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        HistogramBucket[] histogramBucketArr2 = this.appRenderTime;
                        int length2 = histogramBucketArr2 == null ? 0 : histogramBucketArr2.length;
                        int i2 = repeatedFieldArrayLength2 + length2;
                        MessageNano[] messageNanoArr2 = new HistogramBucket[i2];
                        if (length2 != 0) {
                            System.arraycopy(histogramBucketArr2, 0, messageNanoArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            messageNanoArr2[length2] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        messageNanoArr2[length2] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr2[length2]);
                        this.appRenderTime = messageNanoArr2;
                        break;
                    case 74:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        HistogramBucket[] histogramBucketArr3 = this.presentTime;
                        int length3 = histogramBucketArr3 == null ? 0 : histogramBucketArr3.length;
                        int i3 = repeatedFieldArrayLength3 + length3;
                        MessageNano[] messageNanoArr3 = new HistogramBucket[i3];
                        if (length3 != 0) {
                            System.arraycopy(histogramBucketArr3, 0, messageNanoArr3, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            messageNanoArr3[length3] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        messageNanoArr3[length3] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr3[length3]);
                        this.presentTime = messageNanoArr3;
                        break;
                    case 82:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        HistogramBucket[] histogramBucketArr4 = this.totalRenderTime;
                        int length4 = histogramBucketArr4 == null ? 0 : histogramBucketArr4.length;
                        int i4 = repeatedFieldArrayLength4 + length4;
                        MessageNano[] messageNanoArr4 = new HistogramBucket[i4];
                        if (length4 != 0) {
                            System.arraycopy(histogramBucketArr4, 0, messageNanoArr4, 0, length4);
                        }
                        while (length4 < i4 - 1) {
                            messageNanoArr4[length4] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        messageNanoArr4[length4] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr4[length4]);
                        this.totalRenderTime = messageNanoArr4;
                        break;
                    case 90:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        HistogramBucket[] histogramBucketArr5 = this.postFrameTime;
                        int length5 = histogramBucketArr5 == null ? 0 : histogramBucketArr5.length;
                        int i5 = repeatedFieldArrayLength5 + length5;
                        MessageNano[] messageNanoArr5 = new HistogramBucket[i5];
                        if (length5 != 0) {
                            System.arraycopy(histogramBucketArr5, 0, messageNanoArr5, 0, length5);
                        }
                        while (length5 < i5 - 1) {
                            messageNanoArr5[length5] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr5[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        messageNanoArr5[length5] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr5[length5]);
                        this.postFrameTime = messageNanoArr5;
                        break;
                    case 98:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                        HistogramBucket[] histogramBucketArr6 = this.consecutiveDroppedFrames;
                        int length6 = histogramBucketArr6 == null ? 0 : histogramBucketArr6.length;
                        int i6 = repeatedFieldArrayLength6 + length6;
                        MessageNano[] messageNanoArr6 = new HistogramBucket[i6];
                        if (length6 != 0) {
                            System.arraycopy(histogramBucketArr6, 0, messageNanoArr6, 0, length6);
                        }
                        while (length6 < i6 - 1) {
                            messageNanoArr6[length6] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr6[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        messageNanoArr6[length6] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr6[length6]);
                        this.consecutiveDroppedFrames = messageNanoArr6;
                        break;
                    case 106:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        HistogramBucket[] histogramBucketArr7 = this.scanlineRacingVsyncOvershootUs;
                        int length7 = histogramBucketArr7 == null ? 0 : histogramBucketArr7.length;
                        int i7 = repeatedFieldArrayLength7 + length7;
                        MessageNano[] messageNanoArr7 = new HistogramBucket[i7];
                        if (length7 != 0) {
                            System.arraycopy(histogramBucketArr7, 0, messageNanoArr7, 0, length7);
                        }
                        while (length7 < i7 - 1) {
                            messageNanoArr7[length7] = new HistogramBucket();
                            codedInputByteBufferNano.readMessage(messageNanoArr7[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        messageNanoArr7[length7] = new HistogramBucket();
                        codedInputByteBufferNano.readMessage(messageNanoArr7[length7]);
                        this.scanlineRacingVsyncOvershootUs = messageNanoArr7;
                        break;
                    case 112:
                        this.thermalEventFlags = Integer.valueOf(codedInputByteBufferNano.readInt32());
                        break;
                    case 122:
                        int readRawVarint32 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit = codedInputByteBufferNano.pushLimit(readRawVarint32);
                        int i8 = readRawVarint32 / 4;
                        float[] fArr = this.cpuThrottlingTemperature;
                        int length8 = fArr == null ? 0 : fArr.length;
                        int i9 = i8 + length8;
                        float[] fArr2 = new float[i9];
                        if (length8 != 0) {
                            System.arraycopy(fArr, 0, fArr2, 0, length8);
                        }
                        while (length8 < i9) {
                            fArr2[length8] = codedInputByteBufferNano.readFloat();
                            length8++;
                        }
                        this.cpuThrottlingTemperature = fArr2;
                        codedInputByteBufferNano.popLimit(pushLimit);
                        break;
                    case 125:
                        int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 125);
                        float[] fArr3 = this.cpuThrottlingTemperature;
                        int length9 = fArr3 == null ? 0 : fArr3.length;
                        int i10 = repeatedFieldArrayLength8 + length9;
                        float[] fArr4 = new float[i10];
                        if (length9 != 0) {
                            System.arraycopy(fArr3, 0, fArr4, 0, length9);
                        }
                        while (length9 < i10 - 1) {
                            fArr4[length9] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length9++;
                        }
                        fArr4[length9] = codedInputByteBufferNano.readFloat();
                        this.cpuThrottlingTemperature = fArr4;
                        break;
                    case 130:
                        int readRawVarint322 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit2 = codedInputByteBufferNano.pushLimit(readRawVarint322);
                        int i11 = readRawVarint322 / 4;
                        float[] fArr5 = this.gpuThrottlingTemperature;
                        int length10 = fArr5 == null ? 0 : fArr5.length;
                        int i12 = i11 + length10;
                        float[] fArr6 = new float[i12];
                        if (length10 != 0) {
                            System.arraycopy(fArr5, 0, fArr6, 0, length10);
                        }
                        while (length10 < i12) {
                            fArr6[length10] = codedInputByteBufferNano.readFloat();
                            length10++;
                        }
                        this.gpuThrottlingTemperature = fArr6;
                        codedInputByteBufferNano.popLimit(pushLimit2);
                        break;
                    case 133:
                        int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 133);
                        float[] fArr7 = this.gpuThrottlingTemperature;
                        int length11 = fArr7 == null ? 0 : fArr7.length;
                        int i13 = repeatedFieldArrayLength9 + length11;
                        float[] fArr8 = new float[i13];
                        if (length11 != 0) {
                            System.arraycopy(fArr7, 0, fArr8, 0, length11);
                        }
                        while (length11 < i13 - 1) {
                            fArr8[length11] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length11++;
                        }
                        fArr8[length11] = codedInputByteBufferNano.readFloat();
                        this.gpuThrottlingTemperature = fArr8;
                        break;
                    case SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR /* 138 */:
                        int readRawVarint323 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit3 = codedInputByteBufferNano.pushLimit(readRawVarint323);
                        int i14 = readRawVarint323 / 4;
                        float[] fArr9 = this.batteryThrottlingTemperature;
                        int length12 = fArr9 == null ? 0 : fArr9.length;
                        int i15 = i14 + length12;
                        float[] fArr10 = new float[i15];
                        if (length12 != 0) {
                            System.arraycopy(fArr9, 0, fArr10, 0, length12);
                        }
                        while (length12 < i15) {
                            fArr10[length12] = codedInputByteBufferNano.readFloat();
                            length12++;
                        }
                        this.batteryThrottlingTemperature = fArr10;
                        codedInputByteBufferNano.popLimit(pushLimit3);
                        break;
                    case 141:
                        int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 141);
                        float[] fArr11 = this.batteryThrottlingTemperature;
                        int length13 = fArr11 == null ? 0 : fArr11.length;
                        int i16 = repeatedFieldArrayLength10 + length13;
                        float[] fArr12 = new float[i16];
                        if (length13 != 0) {
                            System.arraycopy(fArr11, 0, fArr12, 0, length13);
                        }
                        while (length13 < i16 - 1) {
                            fArr12[length13] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length13++;
                        }
                        fArr12[length13] = codedInputByteBufferNano.readFloat();
                        this.batteryThrottlingTemperature = fArr12;
                        break;
                    case 146:
                        int readRawVarint324 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit4 = codedInputByteBufferNano.pushLimit(readRawVarint324);
                        int i17 = readRawVarint324 / 4;
                        float[] fArr13 = this.cpuShutdownTemperature;
                        int length14 = fArr13 == null ? 0 : fArr13.length;
                        int i18 = i17 + length14;
                        float[] fArr14 = new float[i18];
                        if (length14 != 0) {
                            System.arraycopy(fArr13, 0, fArr14, 0, length14);
                        }
                        while (length14 < i18) {
                            fArr14[length14] = codedInputByteBufferNano.readFloat();
                            length14++;
                        }
                        this.cpuShutdownTemperature = fArr14;
                        codedInputByteBufferNano.popLimit(pushLimit4);
                        break;
                    case 149:
                        int repeatedFieldArrayLength11 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 149);
                        float[] fArr15 = this.cpuShutdownTemperature;
                        int length15 = fArr15 == null ? 0 : fArr15.length;
                        int i19 = repeatedFieldArrayLength11 + length15;
                        float[] fArr16 = new float[i19];
                        if (length15 != 0) {
                            System.arraycopy(fArr15, 0, fArr16, 0, length15);
                        }
                        while (length15 < i19 - 1) {
                            fArr16[length15] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length15++;
                        }
                        fArr16[length15] = codedInputByteBufferNano.readFloat();
                        this.cpuShutdownTemperature = fArr16;
                        break;
                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SD_UP_GEAR_NEED_BUFFER /* 154 */:
                        int readRawVarint325 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit5 = codedInputByteBufferNano.pushLimit(readRawVarint325);
                        int i20 = readRawVarint325 / 4;
                        float[] fArr17 = this.gpuShutdownTemperature;
                        int length16 = fArr17 == null ? 0 : fArr17.length;
                        int i21 = i20 + length16;
                        float[] fArr18 = new float[i21];
                        if (length16 != 0) {
                            System.arraycopy(fArr17, 0, fArr18, 0, length16);
                        }
                        while (length16 < i21) {
                            fArr18[length16] = codedInputByteBufferNano.readFloat();
                            length16++;
                        }
                        this.gpuShutdownTemperature = fArr18;
                        codedInputByteBufferNano.popLimit(pushLimit5);
                        break;
                    case 157:
                        int repeatedFieldArrayLength12 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 157);
                        float[] fArr19 = this.gpuShutdownTemperature;
                        int length17 = fArr19 == null ? 0 : fArr19.length;
                        int i22 = repeatedFieldArrayLength12 + length17;
                        float[] fArr20 = new float[i22];
                        if (length17 != 0) {
                            System.arraycopy(fArr19, 0, fArr20, 0, length17);
                        }
                        while (length17 < i22 - 1) {
                            fArr20[length17] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length17++;
                        }
                        fArr20[length17] = codedInputByteBufferNano.readFloat();
                        this.gpuShutdownTemperature = fArr20;
                        break;
                    case 162:
                        int readRawVarint326 = codedInputByteBufferNano.readRawVarint32();
                        int pushLimit6 = codedInputByteBufferNano.pushLimit(readRawVarint326);
                        int i23 = readRawVarint326 / 4;
                        float[] fArr21 = this.batteryShutdownTemperature;
                        int length18 = fArr21 == null ? 0 : fArr21.length;
                        int i24 = i23 + length18;
                        float[] fArr22 = new float[i24];
                        if (length18 != 0) {
                            System.arraycopy(fArr21, 0, fArr22, 0, length18);
                        }
                        while (length18 < i24) {
                            fArr22[length18] = codedInputByteBufferNano.readFloat();
                            length18++;
                        }
                        this.batteryShutdownTemperature = fArr22;
                        codedInputByteBufferNano.popLimit(pushLimit6);
                        break;
                    case 165:
                        int repeatedFieldArrayLength13 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 165);
                        float[] fArr23 = this.batteryShutdownTemperature;
                        int length19 = fArr23 == null ? 0 : fArr23.length;
                        int i25 = repeatedFieldArrayLength13 + length19;
                        float[] fArr24 = new float[i25];
                        if (length19 != 0) {
                            System.arraycopy(fArr23, 0, fArr24, 0, length19);
                        }
                        while (length19 < i25 - 1) {
                            fArr24[length19] = codedInputByteBufferNano.readFloat();
                            codedInputByteBufferNano.readTag();
                            length19++;
                        }
                        fArr24[length19] = codedInputByteBufferNano.readFloat();
                        this.batteryShutdownTemperature = fArr24;
                        break;
                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_SEEK_GEAR_INDEX /* 173 */:
                        this.averageAppFps = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    case AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DOWNLOAD_TIMEOUT_FACTOR /* 181 */:
                        this.edsFps = Float.valueOf(codedInputByteBufferNano.readFloat());
                        break;
                    default:
                        if (super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.averageFps;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            HistogramBucket[] histogramBucketArr = this.frameTime;
            int i = 0;
            if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.frameTime;
                    if (i2 >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i2];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(2, messageNano);
                    }
                    i2++;
                }
            }
            Integer num2 = this.memoryConsumptionKilobytes;
            if (num2 != null) {
                codedOutputByteBufferNano.writeInt32(3, num2.intValue());
            }
            Float f = this.throttleSkinTemperatureCelsius;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(4, f.floatValue());
            }
            Float f2 = this.vrMaxSkinTemperatureCelsius;
            if (f2 != null) {
                codedOutputByteBufferNano.writeFloat(5, f2.floatValue());
            }
            Float f3 = this.shutdownSkinTemperatureCelsius;
            if (f3 != null) {
                codedOutputByteBufferNano.writeFloat(6, f3.floatValue());
            }
            TimeSeriesData timeSeriesData = this.timeSeriesData;
            if (timeSeriesData != null) {
                codedOutputByteBufferNano.writeMessage(7, timeSeriesData);
            }
            HistogramBucket[] histogramBucketArr2 = this.appRenderTime;
            if (histogramBucketArr2 != null && histogramBucketArr2.length > 0) {
                int i3 = 0;
                while (true) {
                    MessageNano[] messageNanoArr2 = this.appRenderTime;
                    if (i3 >= messageNanoArr2.length) {
                        break;
                    }
                    MessageNano messageNano2 = messageNanoArr2[i3];
                    if (messageNano2 != null) {
                        codedOutputByteBufferNano.writeMessage(8, messageNano2);
                    }
                    i3++;
                }
            }
            HistogramBucket[] histogramBucketArr3 = this.presentTime;
            if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    MessageNano[] messageNanoArr3 = this.presentTime;
                    if (i4 >= messageNanoArr3.length) {
                        break;
                    }
                    MessageNano messageNano3 = messageNanoArr3[i4];
                    if (messageNano3 != null) {
                        codedOutputByteBufferNano.writeMessage(9, messageNano3);
                    }
                    i4++;
                }
            }
            HistogramBucket[] histogramBucketArr4 = this.totalRenderTime;
            if (histogramBucketArr4 != null && histogramBucketArr4.length > 0) {
                int i5 = 0;
                while (true) {
                    MessageNano[] messageNanoArr4 = this.totalRenderTime;
                    if (i5 >= messageNanoArr4.length) {
                        break;
                    }
                    MessageNano messageNano4 = messageNanoArr4[i5];
                    if (messageNano4 != null) {
                        codedOutputByteBufferNano.writeMessage(10, messageNano4);
                    }
                    i5++;
                }
            }
            HistogramBucket[] histogramBucketArr5 = this.postFrameTime;
            if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                int i6 = 0;
                while (true) {
                    MessageNano[] messageNanoArr5 = this.postFrameTime;
                    if (i6 >= messageNanoArr5.length) {
                        break;
                    }
                    MessageNano messageNano5 = messageNanoArr5[i6];
                    if (messageNano5 != null) {
                        codedOutputByteBufferNano.writeMessage(11, messageNano5);
                    }
                    i6++;
                }
            }
            HistogramBucket[] histogramBucketArr6 = this.consecutiveDroppedFrames;
            if (histogramBucketArr6 != null && histogramBucketArr6.length > 0) {
                int i7 = 0;
                while (true) {
                    MessageNano[] messageNanoArr6 = this.consecutiveDroppedFrames;
                    if (i7 >= messageNanoArr6.length) {
                        break;
                    }
                    MessageNano messageNano6 = messageNanoArr6[i7];
                    if (messageNano6 != null) {
                        codedOutputByteBufferNano.writeMessage(12, messageNano6);
                    }
                    i7++;
                }
            }
            HistogramBucket[] histogramBucketArr7 = this.scanlineRacingVsyncOvershootUs;
            if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                int i8 = 0;
                while (true) {
                    MessageNano[] messageNanoArr7 = this.scanlineRacingVsyncOvershootUs;
                    if (i8 >= messageNanoArr7.length) {
                        break;
                    }
                    MessageNano messageNano7 = messageNanoArr7[i8];
                    if (messageNano7 != null) {
                        codedOutputByteBufferNano.writeMessage(13, messageNano7);
                    }
                    i8++;
                }
            }
            Integer num3 = this.thermalEventFlags;
            if (num3 != null) {
                codedOutputByteBufferNano.writeInt32(14, num3.intValue());
            }
            float[] fArr = this.cpuThrottlingTemperature;
            if (fArr != null && fArr.length > 0) {
                int i9 = 0;
                while (true) {
                    float[] fArr2 = this.cpuThrottlingTemperature;
                    if (i9 >= fArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(15, fArr2[i9]);
                    i9++;
                }
            }
            float[] fArr3 = this.gpuThrottlingTemperature;
            if (fArr3 != null && fArr3.length > 0) {
                int i10 = 0;
                while (true) {
                    float[] fArr4 = this.gpuThrottlingTemperature;
                    if (i10 >= fArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(16, fArr4[i10]);
                    i10++;
                }
            }
            float[] fArr5 = this.batteryThrottlingTemperature;
            if (fArr5 != null && fArr5.length > 0) {
                int i11 = 0;
                while (true) {
                    float[] fArr6 = this.batteryThrottlingTemperature;
                    if (i11 >= fArr6.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(17, fArr6[i11]);
                    i11++;
                }
            }
            float[] fArr7 = this.cpuShutdownTemperature;
            if (fArr7 != null && fArr7.length > 0) {
                int i12 = 0;
                while (true) {
                    float[] fArr8 = this.cpuShutdownTemperature;
                    if (i12 >= fArr8.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(18, fArr8[i12]);
                    i12++;
                }
            }
            float[] fArr9 = this.gpuShutdownTemperature;
            if (fArr9 != null && fArr9.length > 0) {
                int i13 = 0;
                while (true) {
                    float[] fArr10 = this.gpuShutdownTemperature;
                    if (i13 >= fArr10.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(19, fArr10[i13]);
                    i13++;
                }
            }
            float[] fArr11 = this.batteryShutdownTemperature;
            if (fArr11 != null && fArr11.length > 0) {
                while (true) {
                    float[] fArr12 = this.batteryShutdownTemperature;
                    if (i >= fArr12.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeFloat(20, fArr12[i]);
                    i++;
                }
            }
            Float f4 = this.averageAppFps;
            if (f4 != null) {
                codedOutputByteBufferNano.writeFloat(21, f4.floatValue());
            }
            Float f5 = this.edsFps;
            if (f5 != null) {
                codedOutputByteBufferNano.writeFloat(22, f5.floatValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final PerformanceStats m392clone() {
            try {
                PerformanceStats performanceStats = (PerformanceStats) super.clone();
                HistogramBucket[] histogramBucketArr = this.frameTime;
                int i = 0;
                if (histogramBucketArr != null && histogramBucketArr.length > 0) {
                    performanceStats.frameTime = new HistogramBucket[histogramBucketArr.length];
                    int i2 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr2 = this.frameTime;
                        if (i2 >= histogramBucketArr2.length) {
                            break;
                        }
                        if (histogramBucketArr2[i2] != null) {
                            performanceStats.frameTime[i2] = histogramBucketArr2[i2].m338clone();
                        }
                        i2++;
                    }
                }
                TimeSeriesData timeSeriesData = this.timeSeriesData;
                if (timeSeriesData != null) {
                    performanceStats.timeSeriesData = timeSeriesData.m440clone();
                }
                HistogramBucket[] histogramBucketArr3 = this.appRenderTime;
                if (histogramBucketArr3 != null && histogramBucketArr3.length > 0) {
                    performanceStats.appRenderTime = new HistogramBucket[histogramBucketArr3.length];
                    int i3 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr4 = this.appRenderTime;
                        if (i3 >= histogramBucketArr4.length) {
                            break;
                        }
                        if (histogramBucketArr4[i3] != null) {
                            performanceStats.appRenderTime[i3] = histogramBucketArr4[i3].m338clone();
                        }
                        i3++;
                    }
                }
                HistogramBucket[] histogramBucketArr5 = this.presentTime;
                if (histogramBucketArr5 != null && histogramBucketArr5.length > 0) {
                    performanceStats.presentTime = new HistogramBucket[histogramBucketArr5.length];
                    int i4 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr6 = this.presentTime;
                        if (i4 >= histogramBucketArr6.length) {
                            break;
                        }
                        if (histogramBucketArr6[i4] != null) {
                            performanceStats.presentTime[i4] = histogramBucketArr6[i4].m338clone();
                        }
                        i4++;
                    }
                }
                HistogramBucket[] histogramBucketArr7 = this.totalRenderTime;
                if (histogramBucketArr7 != null && histogramBucketArr7.length > 0) {
                    performanceStats.totalRenderTime = new HistogramBucket[histogramBucketArr7.length];
                    int i5 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr8 = this.totalRenderTime;
                        if (i5 >= histogramBucketArr8.length) {
                            break;
                        }
                        if (histogramBucketArr8[i5] != null) {
                            performanceStats.totalRenderTime[i5] = histogramBucketArr8[i5].m338clone();
                        }
                        i5++;
                    }
                }
                HistogramBucket[] histogramBucketArr9 = this.postFrameTime;
                if (histogramBucketArr9 != null && histogramBucketArr9.length > 0) {
                    performanceStats.postFrameTime = new HistogramBucket[histogramBucketArr9.length];
                    int i6 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr10 = this.postFrameTime;
                        if (i6 >= histogramBucketArr10.length) {
                            break;
                        }
                        if (histogramBucketArr10[i6] != null) {
                            performanceStats.postFrameTime[i6] = histogramBucketArr10[i6].m338clone();
                        }
                        i6++;
                    }
                }
                HistogramBucket[] histogramBucketArr11 = this.consecutiveDroppedFrames;
                if (histogramBucketArr11 != null && histogramBucketArr11.length > 0) {
                    performanceStats.consecutiveDroppedFrames = new HistogramBucket[histogramBucketArr11.length];
                    int i7 = 0;
                    while (true) {
                        HistogramBucket[] histogramBucketArr12 = this.consecutiveDroppedFrames;
                        if (i7 >= histogramBucketArr12.length) {
                            break;
                        }
                        if (histogramBucketArr12[i7] != null) {
                            performanceStats.consecutiveDroppedFrames[i7] = histogramBucketArr12[i7].m338clone();
                        }
                        i7++;
                    }
                }
                HistogramBucket[] histogramBucketArr13 = this.scanlineRacingVsyncOvershootUs;
                if (histogramBucketArr13 != null && histogramBucketArr13.length > 0) {
                    performanceStats.scanlineRacingVsyncOvershootUs = new HistogramBucket[histogramBucketArr13.length];
                    while (true) {
                        HistogramBucket[] histogramBucketArr14 = this.scanlineRacingVsyncOvershootUs;
                        if (i >= histogramBucketArr14.length) {
                            break;
                        }
                        if (histogramBucketArr14[i] != null) {
                            performanceStats.scanlineRacingVsyncOvershootUs[i] = histogramBucketArr14[i].m338clone();
                        }
                        i++;
                    }
                }
                float[] fArr = this.cpuThrottlingTemperature;
                if (fArr != null && fArr.length > 0) {
                    performanceStats.cpuThrottlingTemperature = (float[]) fArr.clone();
                }
                float[] fArr2 = this.gpuThrottlingTemperature;
                if (fArr2 != null && fArr2.length > 0) {
                    performanceStats.gpuThrottlingTemperature = (float[]) fArr2.clone();
                }
                float[] fArr3 = this.batteryThrottlingTemperature;
                if (fArr3 != null && fArr3.length > 0) {
                    performanceStats.batteryThrottlingTemperature = (float[]) fArr3.clone();
                }
                float[] fArr4 = this.cpuShutdownTemperature;
                if (fArr4 != null && fArr4.length > 0) {
                    performanceStats.cpuShutdownTemperature = (float[]) fArr4.clone();
                }
                float[] fArr5 = this.gpuShutdownTemperature;
                if (fArr5 != null && fArr5.length > 0) {
                    performanceStats.gpuShutdownTemperature = (float[]) fArr5.clone();
                }
                float[] fArr6 = this.batteryShutdownTemperature;
                if (fArr6 != null && fArr6.length > 0) {
                    performanceStats.batteryShutdownTemperature = (float[]) fArr6.clone();
                }
                return performanceStats;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class PhoneAlignment extends ExtendableMessageNano<PhoneAlignment> implements Cloneable {
        public Vector2[] touchLocations = Vector2.emptyArray();
        public Vector2 lensOffset = null;
        public Float angleDegrees = null;

        public PhoneAlignment() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Vector2[] vector2Arr = this.touchLocations;
            if (vector2Arr != null && vector2Arr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.touchLocations;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, messageNano);
                    }
                    i++;
                }
            }
            Vector2 vector2 = this.lensOffset;
            if (vector2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, vector2);
            }
            Float f = this.angleDegrees;
            return f != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(3, f.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    Vector2[] vector2Arr = this.touchLocations;
                    int length = vector2Arr == null ? 0 : vector2Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    MessageNano[] messageNanoArr = new Vector2[i];
                    if (length != 0) {
                        System.arraycopy(vector2Arr, 0, messageNanoArr, 0, length);
                    }
                    while (length < i - 1) {
                        messageNanoArr[length] = new Vector2();
                        codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    messageNanoArr[length] = new Vector2();
                    codedInputByteBufferNano.readMessage(messageNanoArr[length]);
                    this.touchLocations = messageNanoArr;
                } else if (readTag == 18) {
                    if (this.lensOffset == null) {
                        this.lensOffset = new Vector2();
                    }
                    codedInputByteBufferNano.readMessage(this.lensOffset);
                } else if (readTag != 29) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.angleDegrees = Float.valueOf(codedInputByteBufferNano.readFloat());
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Vector2[] vector2Arr = this.touchLocations;
            if (vector2Arr != null && vector2Arr.length > 0) {
                int i = 0;
                while (true) {
                    MessageNano[] messageNanoArr = this.touchLocations;
                    if (i >= messageNanoArr.length) {
                        break;
                    }
                    MessageNano messageNano = messageNanoArr[i];
                    if (messageNano != null) {
                        codedOutputByteBufferNano.writeMessage(1, messageNano);
                    }
                    i++;
                }
            }
            Vector2 vector2 = this.lensOffset;
            if (vector2 != null) {
                codedOutputByteBufferNano.writeMessage(2, vector2);
            }
            Float f = this.angleDegrees;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(3, f.floatValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final PhoneAlignment m395clone() {
            try {
                PhoneAlignment phoneAlignment = (PhoneAlignment) super.clone();
                Vector2[] vector2Arr = this.touchLocations;
                if (vector2Arr != null && vector2Arr.length > 0) {
                    phoneAlignment.touchLocations = new Vector2[vector2Arr.length];
                    int i = 0;
                    while (true) {
                        Vector2[] vector2Arr2 = this.touchLocations;
                        if (i >= vector2Arr2.length) {
                            break;
                        }
                        if (vector2Arr2[i] != null) {
                            phoneAlignment.touchLocations[i] = vector2Arr2[i].m449clone();
                        }
                        i++;
                    }
                }
                Vector2 vector2 = this.lensOffset;
                if (vector2 != null) {
                    phoneAlignment.lensOffset = vector2.m449clone();
                }
                return phoneAlignment;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class QrCodeScan extends ExtendableMessageNano<QrCodeScan> implements Cloneable {
        private Integer status = null;
        private String headMountConfigUrl = null;

        public QrCodeScan() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Integer num = this.status;
            if (num != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, num.intValue());
            }
            String str = this.headMountConfigUrl;
            return str != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, str) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    int position = codedInputByteBufferNano.getPosition();
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        storeUnknownField(codedInputByteBufferNano, readTag);
                    } else {
                        this.status = Integer.valueOf(readInt32);
                    }
                } else if (readTag != 18) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.headMountConfigUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Integer num = this.status;
            if (num != null) {
                codedOutputByteBufferNano.writeInt32(1, num.intValue());
            }
            String str = this.headMountConfigUrl;
            if (str != null) {
                codedOutputByteBufferNano.writeString(2, str);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final QrCodeScan m407clone() {
            try {
                return (QrCodeScan) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Renderer extends ExtendableMessageNano<Renderer> implements Cloneable {
        private String glVendor = null;
        private String glRenderer = null;
        private String glVersion = null;

        public Renderer() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            String str = this.glVendor;
            if (str != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, str);
            }
            String str2 = this.glRenderer;
            if (str2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, str2);
            }
            String str3 = this.glVersion;
            return str3 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, str3) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 10) {
                    this.glVendor = codedInputByteBufferNano.readString();
                } else if (readTag == 18) {
                    this.glRenderer = codedInputByteBufferNano.readString();
                } else if (readTag != 26) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.glVersion = codedInputByteBufferNano.readString();
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            String str = this.glVendor;
            if (str != null) {
                codedOutputByteBufferNano.writeString(1, str);
            }
            String str2 = this.glRenderer;
            if (str2 != null) {
                codedOutputByteBufferNano.writeString(2, str2);
            }
            String str3 = this.glVersion;
            if (str3 != null) {
                codedOutputByteBufferNano.writeString(3, str3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final Renderer m410clone() {
            try {
                return (Renderer) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Transform extends ExtendableMessageNano<Transform> implements Cloneable {
        private Float translationX = null;
        private Float translationY = null;
        private Float translationZ = null;
        private Float rotationQx = null;
        private Float rotationQy = null;
        private Float rotationQz = null;
        private Float scale = null;

        public Transform() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Float f = this.translationX;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue());
            }
            Float f2 = this.translationY;
            if (f2 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, f2.floatValue());
            }
            Float f3 = this.translationZ;
            if (f3 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, f3.floatValue());
            }
            Float f4 = this.rotationQx;
            if (f4 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, f4.floatValue());
            }
            Float f5 = this.rotationQy;
            if (f5 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, f5.floatValue());
            }
            Float f6 = this.rotationQz;
            if (f6 != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(6, f6.floatValue());
            }
            Float f7 = this.scale;
            return f7 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(7, f7.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.translationX = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 21) {
                    this.translationY = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 29) {
                    this.translationZ = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 37) {
                    this.rotationQx = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 45) {
                    this.rotationQy = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag == 53) {
                    this.rotationQz = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag != 61) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.scale = Float.valueOf(codedInputByteBufferNano.readFloat());
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Float f = this.translationX;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(1, f.floatValue());
            }
            Float f2 = this.translationY;
            if (f2 != null) {
                codedOutputByteBufferNano.writeFloat(2, f2.floatValue());
            }
            Float f3 = this.translationZ;
            if (f3 != null) {
                codedOutputByteBufferNano.writeFloat(3, f3.floatValue());
            }
            Float f4 = this.rotationQx;
            if (f4 != null) {
                codedOutputByteBufferNano.writeFloat(4, f4.floatValue());
            }
            Float f5 = this.rotationQy;
            if (f5 != null) {
                codedOutputByteBufferNano.writeFloat(5, f5.floatValue());
            }
            Float f6 = this.rotationQz;
            if (f6 != null) {
                codedOutputByteBufferNano.writeFloat(6, f6.floatValue());
            }
            Float f7 = this.scale;
            if (f7 != null) {
                codedOutputByteBufferNano.writeFloat(7, f7.floatValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final Transform m446clone() {
            try {
                return (Transform) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class Vector2 extends ExtendableMessageNano<Vector2> implements Cloneable {
        private static volatile Vector2[] _emptyArray;
        public Float x = null;
        public Float y = null;

        public Vector2() {
            this.unknownFieldData = null;
            this.cachedSize = -1;
        }

        public static Vector2[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Vector2[0];
                    }
                }
            }
            return _emptyArray;
        }

        protected final int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            Float f = this.x;
            if (f != null) {
                computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, f.floatValue());
            }
            Float f2 = this.y;
            return f2 != null ? computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(2, f2.floatValue()) : computeSerializedSize;
        }

        public final /* synthetic */ MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 13) {
                    this.x = Float.valueOf(codedInputByteBufferNano.readFloat());
                } else if (readTag != 21) {
                    if (!super.storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.y = Float.valueOf(codedInputByteBufferNano.readFloat());
                }
            }
        }

        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Float f = this.x;
            if (f != null) {
                codedOutputByteBufferNano.writeFloat(1, f.floatValue());
            }
            Float f2 = this.y;
            if (f2 != null) {
                codedOutputByteBufferNano.writeFloat(2, f2.floatValue());
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        /* renamed from: clone */
        public final Vector2 m449clone() {
            try {
                return (Vector2) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clone */
    public Vr$VREvent m245clone() {
        try {
            Vr$VREvent vr$VREvent = (Vr$VREvent) super.clone();
            HeadMount headMount = this.headMount;
            if (headMount != null) {
                vr$VREvent.headMount = headMount.m332clone();
            }
            Application application = this.application;
            if (application != null) {
                vr$VREvent.application = application.m248clone();
            }
            Application[] applicationArr = this.installedVrApplications;
            if (applicationArr != null && applicationArr.length > 0) {
                vr$VREvent.installedVrApplications = new Application[applicationArr.length];
                int i = 0;
                while (true) {
                    Application[] applicationArr2 = this.installedVrApplications;
                    if (i >= applicationArr2.length) {
                        break;
                    }
                    if (applicationArr2[i] != null) {
                        vr$VREvent.installedVrApplications[i] = applicationArr2[i].m248clone();
                    }
                    i++;
                }
            }
            Cyclops cyclops = this.cyclops;
            if (cyclops != null) {
                vr$VREvent.cyclops = cyclops.m254clone();
            }
            QrCodeScan qrCodeScan = this.qrCodeScan;
            if (qrCodeScan != null) {
                vr$VREvent.qrCodeScan = qrCodeScan.m407clone();
            }
            PerformanceStats performanceStats = this.performanceStats;
            if (performanceStats != null) {
                vr$VREvent.performanceStats = performanceStats.m392clone();
            }
            SensorStats sensorStats = this.sensorStats;
            if (sensorStats != null) {
                vr$VREvent.sensorStats = sensorStats.m422clone();
            }
            AudioStats audioStats = this.audioStats;
            if (audioStats != null) {
                vr$VREvent.audioStats = audioStats.m251clone();
            }
            EmbedVrWidget embedVrWidget = this.embedVrWidget;
            if (embedVrWidget != null) {
                vr$VREvent.embedVrWidget = embedVrWidget.m314clone();
            }
            VrCore vrCore = this.vrCore;
            if (vrCore != null) {
                vr$VREvent.vrCore = vrCore.m452clone();
            }
            EarthVr earthVr = this.earthVr;
            if (earthVr != null) {
                vr$VREvent.earthVr = earthVr.m272clone();
            }
            Launcher launcher = this.launcher;
            if (launcher != null) {
                vr$VREvent.launcher = launcher.m383clone();
            }
            Keyboard keyboard = this.keyboard;
            if (keyboard != null) {
                vr$VREvent.keyboard = keyboard.m374clone();
            }
            Renderer renderer = this.renderer;
            if (renderer != null) {
                vr$VREvent.renderer = renderer.m410clone();
            }
            Lullaby lullaby = this.lullaby;
            if (lullaby != null) {
                vr$VREvent.lullaby = lullaby.m386clone();
            }
            StreetView streetView = this.streetView;
            if (streetView != null) {
                vr$VREvent.streetView = streetView.m431clone();
            }
            Photos photos = this.photos;
            if (photos != null) {
                vr$VREvent.photos = photos.m398clone();
            }
            VrHome vrHome = this.vrHome;
            if (vrHome != null) {
                vr$VREvent.vrHome = vrHome.m467clone();
            }
            SdkConfigurationParams sdkConfigurationParams = this.sdkConfiguration;
            if (sdkConfigurationParams != null) {
                vr$VREvent.sdkConfiguration = sdkConfigurationParams.m413clone();
            }
            GConfigUpdate gConfigUpdate = this.gConfigUpdate;
            if (gConfigUpdate != null) {
                vr$VREvent.gConfigUpdate = gConfigUpdate.m326clone();
            }
            JumpInspector jumpInspector = this.jumpInspector;
            if (jumpInspector != null) {
                vr$VREvent.jumpInspector = jumpInspector.m341clone();
            }
            PhoneAlignment phoneAlignment = this.phoneAlignment;
            if (phoneAlignment != null) {
                vr$VREvent.phoneAlignment = phoneAlignment.m395clone();
            }
            VrStreaming vrStreaming = this.vrStreaming;
            if (vrStreaming != null) {
                vr$VREvent.vrStreaming = vrStreaming.m485clone();
            }
            Expeditions expeditions = this.expeditions;
            if (expeditions != null) {
                vr$VREvent.expeditions = expeditions.m323clone();
            }
            HeadTracking headTracking = this.headTracking;
            if (headTracking != null) {
                vr$VREvent.headTracking = headTracking.m335clone();
            }
            return vr$VREvent;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
