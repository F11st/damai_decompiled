package com.alibaba.security.biometrics.service.model.result;

import com.alibaba.security.biometrics.service.model.detector.MineInfo;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABActionResult implements Serializable {
    private static final long serialVersionUID = 1;
    protected int at;
    protected long et;
    protected int td;
    protected int r = 0;
    protected int ec = -1;
    protected int ecpc = -1;
    protected int etcc = -1;
    protected String ecResult = "";
    protected List<ABImageResult> is = new ArrayList();
    protected List<MineInfo> ms = new ArrayList();
    protected long bt = System.currentTimeMillis();

    public void addImageResult(ABImageResult aBImageResult) {
        this.is.add(aBImageResult);
    }

    public void addMine(MineInfo mineInfo) {
        this.ms.add(mineInfo);
    }

    public int getAt() {
        return this.at;
    }

    public long getBt() {
        return this.bt;
    }

    public int getEc() {
        return this.ec;
    }

    public String getEcResult() {
        return this.ecResult;
    }

    public int getEcpc() {
        return this.ecpc;
    }

    public long getEt() {
        return this.et;
    }

    public int getEtcc() {
        return this.etcc;
    }

    public List<ABImageResult> getIs() {
        return this.is;
    }

    public List<MineInfo> getMs() {
        return this.ms;
    }

    public int getR() {
        return this.r;
    }

    public int getTd() {
        return this.td;
    }

    public void setAt(int i) {
        this.at = i;
    }

    public void setBt(long j) {
        this.bt = j;
    }

    public void setEc(int i) {
        this.ec = i;
    }

    public void setEcResult(String str) {
        this.ecResult = str;
    }

    public void setEcpc(int i) {
        this.ecpc = i;
    }

    public void setEt(long j) {
        this.et = j;
    }

    public void setEtcc(int i) {
        this.etcc = i;
    }

    public void setIs(List<ABImageResult> list) {
        this.is = list;
    }

    public void setMs(List<MineInfo> list) {
        this.ms = list;
    }

    public void setR(int i) {
        this.r = i;
    }

    public void setTd(int i) {
        this.td = i;
    }

    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS", Locale.getDefault());
        return "ActionResult{actionType=" + this.at + "(2:mouth,3:yaw,10:pitchdown,11:still,6:none), result=" + this.r + "(see LivnessResult.result/r),3d=" + this.td + ", beginttime=" + simpleDateFormat.format(new Date(this.bt)) + ", endtime=" + simpleDateFormat.format(new Date(this.et)) + ", images=" + this.is + ", mines=" + this.ms + ", ec=" + this.ec + ", ecpc=" + this.ecpc + ", etcc=" + this.etcc + "}";
    }
}
