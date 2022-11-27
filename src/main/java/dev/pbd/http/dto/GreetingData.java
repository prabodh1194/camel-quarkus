package dev.pbd.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;

public class GreetingData implements Serializable {
    @JsonProperty("val")
    int val;

    @JsonProperty("cnt")
    int cnt;

    @JsonProperty("last")
    String d;

    public GreetingData() {
        d = Instant.now().toString();
    }

    @Override
    public String toString() {
        return "GreetingData{" +
                "val=" + val +
                ", cnt=" + cnt +
                ", d=" + d +
                "}\n";
    }
}
