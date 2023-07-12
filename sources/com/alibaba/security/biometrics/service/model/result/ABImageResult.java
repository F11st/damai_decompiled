package com.alibaba.security.biometrics.service.model.result;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABImageResult implements Serializable {
    private static final long serialVersionUID = 1;
    protected float b;
    protected byte[] bf;
    protected String d;
    protected int dt;
    protected int[] fr;
    protected float gb;
    protected float[] landmarks;
    protected float mb;
    protected String p;
    protected float q;
    protected long t;

    public float getB() {
        return this.b;
    }

    public byte[] getBf() {
        return this.bf;
    }

    public String getD() {
        return this.d;
    }

    public int getDt() {
        return this.dt;
    }

    public int[] getFr() {
        return this.fr;
    }

    public float getGb() {
        return this.gb;
    }

    public float[] getLandmarks() {
        return this.landmarks;
    }

    public float getMb() {
        return this.mb;
    }

    public String getP() {
        return this.p;
    }

    public float getQ() {
        return this.q;
    }

    public long getT() {
        return this.t;
    }

    public void setB(float f) {
        this.b = f;
    }

    public void setBf(byte[] bArr) {
        this.bf = bArr;
    }

    public void setD(String str) {
        this.d = str;
    }

    public void setDt(int i) {
        this.dt = i;
    }

    public ABImageResult setFr(int[] iArr) {
        this.fr = iArr;
        return this;
    }

    public void setGb(float f) {
        this.gb = f;
    }

    public ABImageResult setLandmarks(float[] fArr) {
        this.landmarks = fArr;
        return this;
    }

    public void setMb(float f) {
        this.mb = f;
    }

    public void setP(String str) {
        this.p = str;
    }

    public void setQ(float f) {
        this.q = f;
    }

    public void setT(long j) {
        this.t = j;
    }

    public String toString() {
        return "ImageResult{q=" + this.q + ", p='" + this.p + "', gb=" + this.gb + ", mb=" + this.mb + ", b=" + this.b + ", t=" + this.t + '}';
    }
}
