package com.taobao.update.datasource.mtop;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UpdateRequest implements Serializable {
    public String API_NAME;
    public String betaSource;
    public String dexcode;
    public boolean isYunos;
    public List<String> updateTypes;
    public String VERSION = "1.0";
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = true;
    public int cpuArch = -1;
    public String model = null;
    public String locale = null;
    public String md5Sum = null;
    public String city = null;
    public long patchVersion = 0;
    public long dexpatchVersion = 0;
    public long apiLevel = 0;
    public String appVersion = null;
    public String brand = null;
    public String identifier = null;

    public UpdateRequest(boolean z) {
        this.API_NAME = "mtop.client.mudp.update";
        if (z) {
            this.API_NAME = "mtop.client.mudp.update.outer";
        }
    }
}
