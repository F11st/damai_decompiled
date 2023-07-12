package org.apache.commons.text.similarity;

import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LevenshteinResults {
    private final Integer deleteCount;
    private final Integer distance;
    private final Integer insertCount;
    private final Integer substituteCount;

    public LevenshteinResults(Integer num, Integer num2, Integer num3, Integer num4) {
        this.distance = num;
        this.insertCount = num2;
        this.deleteCount = num3;
        this.substituteCount = num4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LevenshteinResults levenshteinResults = (LevenshteinResults) obj;
        return Objects.equals(this.distance, levenshteinResults.distance) && Objects.equals(this.insertCount, levenshteinResults.insertCount) && Objects.equals(this.deleteCount, levenshteinResults.deleteCount) && Objects.equals(this.substituteCount, levenshteinResults.substituteCount);
    }

    public Integer getDeleteCount() {
        return this.deleteCount;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public Integer getInsertCount() {
        return this.insertCount;
    }

    public Integer getSubstituteCount() {
        return this.substituteCount;
    }

    public int hashCode() {
        return Objects.hash(this.distance, this.insertCount, this.deleteCount, this.substituteCount);
    }

    public String toString() {
        return "Distance: " + this.distance + ", Insert: " + this.insertCount + ", Delete: " + this.deleteCount + ", Substitute: " + this.substituteCount;
    }
}
