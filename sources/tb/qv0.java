package tb;

import android.os.Build;
import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class qv0 implements CalScore {
    public String a;
    public float b;
    public float c;

    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        if (hardWareInfo == null) {
            return 0;
        }
        String str = hardWareInfo.h;
        this.a = str;
        this.b = hardWareInfo.g;
        this.c = hardWareInfo.k;
        if (str != null) {
            if (str.contains("Adreno")) {
                if (!this.a.contains("540") && !this.a.contains("530") && !this.a.contains("53") && !this.a.startsWith("Adreno (TM) 5") && !this.a.startsWith("Adreno (TM) 6")) {
                    if (!this.a.startsWith("Adreno 5") && !this.a.startsWith("Adreno 6")) {
                        if (!this.a.contains("430")) {
                            if (!this.a.contains("420") && !this.a.contains("418")) {
                                if (!this.a.contains("510") && !this.a.contains("506") && !this.a.contains("505")) {
                                    if (this.a.contains("330")) {
                                        if (this.b <= 2.3f) {
                                            return 5;
                                        }
                                    } else {
                                        if (!this.a.contains("405") && !this.a.contains("320")) {
                                            if (!this.a.contains("225") && !this.a.contains("305") && !this.a.contains("306") && !this.a.contains("308")) {
                                                if (!this.a.contains("220")) {
                                                    if (!this.a.contains("205") && !this.a.contains("203")) {
                                                        if (!this.a.contains("200")) {
                                                            if (!this.a.startsWith("Adreno 4")) {
                                                                if (!this.a.startsWith("Adreno 3")) {
                                                                    return 0;
                                                                }
                                                            }
                                                        }
                                                        return 1;
                                                    }
                                                    return 2;
                                                }
                                            }
                                        }
                                        return 5;
                                    }
                                }
                                return 6;
                            }
                            return 7;
                        }
                        return 8;
                    }
                } else if (this.b <= 2.0f && this.c <= 1.5f) {
                    return 9;
                }
                return 10;
            } else if (this.a.contains("Mali")) {
                Build.HARDWARE.toLowerCase();
                if (!this.a.contains("G71") && !this.a.contains("G72")) {
                    if (!this.a.contains("T880 MP") && !this.a.contains("T880")) {
                        if (!this.a.contains("T860")) {
                            if (!this.a.contains("T830") && !this.a.contains("T820")) {
                                if (!this.a.contains("400 MP")) {
                                    if (!this.a.contains("400") && !this.a.contains("450")) {
                                        if (!this.a.contains("T624") && !this.a.contains("T678")) {
                                            if (!this.a.contains("T628")) {
                                                if (!this.a.contains("T604")) {
                                                    if (!this.a.contains("T760") && !this.a.contains("T720")) {
                                                        return 0;
                                                    }
                                                }
                                            }
                                        }
                                        return 5;
                                    }
                                    return 2;
                                }
                                return 6;
                            }
                            return 7;
                        }
                        return 8;
                    }
                    return 9;
                }
                return 10;
            } else if (this.a.contains("PowerVR")) {
                if (!this.a.contains("SGX 530")) {
                    if (!this.a.contains("SGX 535") && !this.a.contains("SGX 531")) {
                        if (!this.a.contains("SGX 544") && !this.a.contains("SGX 543")) {
                            if (!this.a.contains("G6200") && !this.a.contains("6200") && !this.a.contains("G6400") && !this.a.contains("G6430") && !this.a.contains("G6") && !this.a.contains("6")) {
                                if (this.a.contains("6450") || this.a.contains("7")) {
                                    return 6;
                                }
                            }
                            return 5;
                        }
                    }
                    return 2;
                }
                return 1;
            } else {
                if (this.a.contains("NVIDIA")) {
                    float f = this.b;
                    if (f < 1.8f) {
                        if (f < 2.2f) {
                            if (f < 2.0f) {
                                return f >= 1.8f ? 4 : 3;
                            }
                            return 5;
                        }
                        return 6;
                    }
                } else if (!this.a.contains("Android Emulator")) {
                    return 0;
                }
                return 8;
            }
        }
        return 0;
    }
}
