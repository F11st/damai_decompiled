package com.taobao.updatecenter.query;

import java.util.List;
import mtopsdk.mtop.domain.IMTOPDataObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MudpUpdateRequest implements IMTOPDataObject {
    public List<String> updateTypes;
    public String API_NAME = "mtop.client.mudp.update";
    public String VERSION = "1.0";
    public boolean NEED_ECODE = false;
    public boolean NEED_SESSION = true;
    public String model = null;
    public long netStatus = 0;
    public String locale = null;
    public String md5Sum = null;
    public String city = null;
    public long patchVersion = 0;
    public long dexpatchVersion = 0;
    public long apiLevel = 0;
    public String appVersion = null;
    public String brand = null;
    public String identifier = null;
    public String group = null;
}
