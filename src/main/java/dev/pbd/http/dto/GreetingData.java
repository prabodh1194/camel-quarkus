package dev.pbd.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class GreetingData {
    @JsonProperty("val")
    int val;

    @JsonProperty("cnt")
    int cnt;

    Instant d;

    public GreetingData() {
        d = Instant.now();
    }

    @Override
    public String toString() {
        return "GreetingData{" +
                "val=" + val +
                ", cnt=" + cnt +
                ", d=" + d +
                '}';
    }
}
