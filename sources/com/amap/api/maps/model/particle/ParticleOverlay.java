package com.amap.api.maps.model.particle;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ParticleOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ParticleOverlayOptions options;
    private IParticleLatyer overlayDelegate;

    public ParticleOverlay(IParticleLatyer iParticleLatyer) {
        this.overlayDelegate = iParticleLatyer;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.destroy();
            } else {
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.removeOverlay(this.overlayName);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getCurrentParticleNum() {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                return iParticleLatyer.getCurrentParticleNum();
            }
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.getCurrentParticleNum(this.overlayName);
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setDuration(long j) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setDuration(j);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setDuration(j);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLoop(boolean z) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setLoop(z);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setLoop(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxParticles(int i) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setMaxParticles(i);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setMaxParticles(i);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleEmission(ParticleEmissionModule particleEmissionModule) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setParticleEmission(particleEmissionModule);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setParticleEmissionModule(particleEmissionModule);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleLifeTime(long j) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setParticleLifeTime(j);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setParticleLifeTime(j);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleOverLifeModule(ParticleOverLifeModule particleOverLifeModule) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setParticleOverLifeModule(particleOverLifeModule);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setParticleOverLifeModule(particleOverLifeModule);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleShapeModule(ParticleShapeModule particleShapeModule) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setParticleShapeModule(particleShapeModule);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setParticleShapeModule(particleShapeModule);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setParticleStartSpeed(VelocityGenerate velocityGenerate) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setParticleStartSpeed(velocityGenerate);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setParticleStartSpeed(velocityGenerate);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartColor(ColorGenerate colorGenerate) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setStartColor(colorGenerate);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setParticleStartColor(colorGenerate);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStartParticleSize(int i, int i2) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setStartParticleSize(i, i2);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setStartParticleSize(i, i2);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            IParticleLatyer iParticleLatyer = this.overlayDelegate;
            if (iParticleLatyer != null) {
                iParticleLatyer.setVisible(z);
            } else {
                ParticleOverlayOptions particleOverlayOptions = this.options;
                if (particleOverlayOptions != null) {
                    particleOverlayOptions.setVisible(z);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ParticleOverlay(IGlOverlayLayer iGlOverlayLayer, ParticleOverlayOptions particleOverlayOptions) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = particleOverlayOptions;
        this.overlayName = "";
    }
}
