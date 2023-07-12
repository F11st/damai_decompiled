package com.taobao.update.result;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public enum BundleUpdateStep {
    STEP0("MtopRequest", "发送Mtop请求"),
    STEP1("Request", "发送http请求"),
    STEP2("DiskCheck", "磁盘空间检查"),
    STEP3("BundleDownload", "bundle下载"),
    STEP4("Renamer", "patch重命名"),
    STEP5("PatchMerge", "patchMerge"),
    STEP6("BundleInstall", "bundle安装"),
    STEP7("AllFinish", "动态部署成功"),
    STEP8("Reboot", "重启校验");
    
    private String desc;
    private String msg;
    private String step;
    private boolean success;

    BundleUpdateStep(String str, String str2) {
        this.step = str;
        this.desc = str2;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getStep() {
        return this.step;
    }

    public boolean isSuccess() {
        return false;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void success(boolean z) {
        this.success = z;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.step + ":" + this.desc + "->" + this.success + "->" + this.msg;
    }
}
