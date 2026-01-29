package pvt.code.practice.practical.scenarios;

import java.time.Instant;

public class RateLimiter {
    private final int maxRequests;
    private final long refillIntervalMillis;
    private int tokens;
    private long lastRefillTime;

    public RateLimiter(int maxRequests, long refillIntervalMillis) {
        this.maxRequests = maxRequests;
        this.refillIntervalMillis = refillIntervalMillis;
        this.tokens = maxRequests;
        this.lastRefillTime = Instant.now().toEpochMilli();
    }

    public synchronized boolean allowRequest(int reqId) {
        refillTokens(reqId);

        if (tokens > 0) {
            tokens--;
            System.out.println("Request " + reqId + " || Subtracting Tokens from bucket || UPDATED Value of tokens : " + tokens);
            return true;
        }
        return false;
    }

    private void refillTokens(int reqId) {
        long now = Instant.now().toEpochMilli();
        long elapsedTime = now - lastRefillTime;
        int tokensToAdd = (int) (elapsedTime / refillIntervalMillis);

        System.out.println("Request " + reqId + " || Value of now : " + now);
        System.out.println("Request " + reqId + " || Value of elapsedTime : " + elapsedTime);
        System.out.println("Request " + reqId + " || Value of tokensToAdd : " + tokensToAdd);

        if (tokensToAdd > 0) {
            tokens = Math.min(tokens + tokensToAdd, maxRequests);
            lastRefillTime = now;
            System.out.println("Request " + reqId + " || Adding Tokens to bucket || UPDATED Value of tokens : " + tokens);
            System.out.println("Request " + reqId + " || UPDATED Value of lastRefillTime : " + lastRefillTime);
        }
    }
}
