package com.taobao.android.dinamic.tempate;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DinamicTemplate implements Serializable {
    private String compilerVersion;
    private String interpreterVersion;
    public String name;
    public String templateUrl;
    public String version;

    public boolean checkValid() {
        return !TextUtils.isEmpty(this.name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DinamicTemplate dinamicTemplate = (DinamicTemplate) obj;
        String str = this.name;
        if (str == null ? dinamicTemplate.name == null : str.equals(dinamicTemplate.name)) {
            String str2 = this.version;
            String str3 = dinamicTemplate.version;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    public String getCompilerVersion() {
        return this.compilerVersion;
    }

    public String getInterpreterVersion() {
        return this.interpreterVersion;
    }

    public boolean isPreset() {
        return TextUtils.isEmpty(this.version);
    }

    public void setCompilerVersion(String str) {
        this.compilerVersion = str;
    }

    public void setInterpreterVersion(String str) {
        this.interpreterVersion = str;
    }

    public String toString() {
        return "name=" + this.name + "version=" + this.version + "templateUrl=" + this.templateUrl;
    }
}
