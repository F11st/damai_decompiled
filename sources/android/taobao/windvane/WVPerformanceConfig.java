package android.taobao.windvane;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPerformanceConfig {
    private String jsErrorRatio = "1.00";
    private boolean isOpenFSP = false;
    private boolean isOpenH5PP = true;
    private boolean isOpenUserPP = true;
    private boolean isOpenH5_2 = true;
    private String fSPFilterAnimation = "true";
    private boolean openHA = true;
    private boolean onlyBkpg = false;
    private boolean closeUCHA = false;
    private boolean filterIllegalUrl = true;

    public boolean closeUCHA() {
        return this.closeUCHA;
    }

    public String getJsErrorRatio() {
        return this.jsErrorRatio;
    }

    public String getfSPFilterAnimation() {
        return this.fSPFilterAnimation;
    }

    public boolean isFilterIllegalUrl() {
        return this.filterIllegalUrl;
    }

    public boolean isOnlyBkpg() {
        return this.onlyBkpg;
    }

    public boolean isOpenFSP() {
        return this.isOpenFSP;
    }

    public boolean isOpenH5PP() {
        return this.isOpenH5PP;
    }

    public boolean isOpenH5_2() {
        return this.isOpenH5_2;
    }

    public boolean isOpenHA() {
        return this.openHA;
    }

    public boolean isOpenUserPP() {
        return this.isOpenUserPP;
    }

    public void setCloseUCHA(boolean z) {
        this.closeUCHA = z;
    }

    public void setFilterIllegalUrl(boolean z) {
        this.filterIllegalUrl = z;
    }

    public void setJsErrorRatio(String str) {
        this.jsErrorRatio = str;
    }

    public void setOnlyBkpg(boolean z) {
        this.onlyBkpg = z;
    }

    public void setOpenFSP(boolean z) {
        this.isOpenFSP = z;
    }

    public void setOpenH5PP(boolean z) {
        this.isOpenH5PP = z;
    }

    public void setOpenH5_2(boolean z) {
        this.isOpenH5_2 = z;
    }

    public void setOpenHA(boolean z) {
        this.openHA = z;
    }

    public void setOpenUserPP(boolean z) {
        this.isOpenUserPP = z;
    }

    public void setfSPFilterAnimation(String str) {
        this.fSPFilterAnimation = str;
    }

    public String toString() {
        return "WVPerformanceConfig{jsErrorRatio='" + this.jsErrorRatio + "', isOpenFSP=" + this.isOpenFSP + ", isOpenH5PP=" + this.isOpenH5PP + ", isOpenUserPP=" + this.isOpenUserPP + ", isOpenH5_2=" + this.isOpenH5_2 + ", fSPFilterAnimation='" + this.fSPFilterAnimation + "', openHA=" + this.openHA + ", onlyBkpg=" + this.onlyBkpg + ", isFilterIllegalUrl=" + this.filterIllegalUrl + ", closeUCHA=" + this.closeUCHA + '}';
    }
}
