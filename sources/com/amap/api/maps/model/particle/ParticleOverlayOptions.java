package com.amap.api.maps.model.particle;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ParticleOverlayOptions extends BaseOptions implements Parcelable, Cloneable {
    public static final Parcelable.Creator<ParticleOverlayOptions> CREATOR = new Parcelable.Creator<ParticleOverlayOptions>() { // from class: com.amap.api.maps.model.particle.ParticleOverlayOptions.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParticleOverlayOptions createFromParcel(Parcel parcel) {
            return new ParticleOverlayOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParticleOverlayOptions[] newArray(int i) {
            return new ParticleOverlayOptions[i];
        }
    };
    private BitmapDescriptor bitmapDescriptor;
    private String bitmapSymbol;
    private long duration;
    private boolean isParticleEmissionModuleUpdate;
    private boolean isParticleOverLifeModuleUpdate;
    private boolean isParticleShapeModuleUpdate;
    private boolean isStartColorUpdate;
    private boolean isStartSpeedUpdate;
    private boolean loop;
    private int maxParticles;
    private ParticleEmissionModule particleEmissionModule;
    private long particleLifeTime;
    private ParticleOverLifeModule particleOverLifeModule;
    private ParticleShapeModule particleShapeModule;
    private ColorGenerate startColor;
    private int startParticleH;
    private int startParticleW;
    private VelocityGenerate startSpeed;
    private final String type;
    private boolean visibile;
    private float zIndex;

    public ParticleOverlayOptions() {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        this.loop = true;
        this.duration = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.particleLifeTime = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.type = "ParticleOptions";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDuration() {
        return this.duration;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public int getMaxParticles() {
        return this.maxParticles;
    }

    public ParticleEmissionModule getParticleEmissionModule() {
        return this.particleEmissionModule;
    }

    public long getParticleLifeTime() {
        return this.particleLifeTime;
    }

    public ParticleOverLifeModule getParticleOverLifeModule() {
        return this.particleOverLifeModule;
    }

    public ParticleShapeModule getParticleShapeModule() {
        return this.particleShapeModule;
    }

    public ColorGenerate getParticleStartColor() {
        return this.startColor;
    }

    public VelocityGenerate getParticleStartSpeed() {
        return this.startSpeed;
    }

    public int getStartParticleW() {
        return this.startParticleW;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public int getstartParticleH() {
        return this.startParticleH;
    }

    public ParticleOverlayOptions icon(BitmapDescriptor bitmapDescriptor) {
        try {
            this.bitmapDescriptor = bitmapDescriptor;
            this.bitmapSymbol = bitmapDescriptor.getId();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public boolean isVisibile() {
        return this.visibile;
    }

    public ParticleOverlayOptions setDuration(long j) {
        this.duration = j;
        return this;
    }

    public ParticleOverlayOptions setLoop(boolean z) {
        this.loop = z;
        return this;
    }

    public ParticleOverlayOptions setMaxParticles(int i) {
        this.maxParticles = i;
        return this;
    }

    public ParticleOverlayOptions setParticleEmissionModule(ParticleEmissionModule particleEmissionModule) {
        this.particleEmissionModule = particleEmissionModule;
        this.isParticleEmissionModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleLifeTime(long j) {
        this.particleLifeTime = j;
        return this;
    }

    public ParticleOverlayOptions setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        this.particleOverLifeModule = particleOverLifeModule;
        this.isParticleOverLifeModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        this.particleShapeModule = particleShapeModule;
        this.isParticleShapeModuleUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleStartColor(ColorGenerate colorGenerate) {
        this.startColor = colorGenerate;
        this.isStartColorUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        this.startSpeed = velocityGenerate;
        this.isStartSpeedUpdate = true;
        return this;
    }

    public ParticleOverlayOptions setStartParticleSize(int i, int i2) {
        this.startParticleW = i;
        this.startParticleH = i2;
        return this;
    }

    public ParticleOverlayOptions setVisible(boolean z) {
        this.visibile = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.bitmapDescriptor, i);
        parcel.writeFloat(this.zIndex);
        parcel.writeInt(this.maxParticles);
        parcel.writeByte(this.loop ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.particleLifeTime);
        parcel.writeInt(this.startParticleW);
        parcel.writeInt(this.startParticleH);
        parcel.writeByte(this.visibile ? (byte) 1 : (byte) 0);
    }

    public ParticleOverlayOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    protected ParticleOverlayOptions(Parcel parcel) {
        this.zIndex = 1.0f;
        this.maxParticles = 100;
        this.loop = true;
        this.duration = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.particleLifeTime = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        this.startSpeed = null;
        this.startParticleW = 32;
        this.startParticleH = 32;
        this.visibile = true;
        this.isParticleEmissionModuleUpdate = false;
        this.isParticleShapeModuleUpdate = false;
        this.isStartSpeedUpdate = false;
        this.isStartColorUpdate = false;
        this.isParticleOverLifeModuleUpdate = false;
        this.type = "ParticleOptions";
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        this.bitmapDescriptor = bitmapDescriptor;
        this.bitmapSymbol = bitmapDescriptor.getId();
        this.zIndex = parcel.readFloat();
        this.maxParticles = parcel.readInt();
        this.loop = parcel.readByte() != 0;
        this.duration = parcel.readLong();
        this.particleLifeTime = parcel.readLong();
        this.startParticleW = parcel.readInt();
        this.startParticleH = parcel.readInt();
        this.visibile = parcel.readByte() != 0;
    }
}
