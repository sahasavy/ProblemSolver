package pvt.code.practice.scenarios;
import java.util.Random;

/*
    We are building a movie application. But for that, we need to fetch details about movies from IMDB. But IMDB
    strictly enforces a maximum of 'n' requests within a second or charge heavily if limit is exceed.  So can you
    write an in-memory rate limiter to protect against overcharging?
 */
public class MovieApplication {
    private static final int MAX_REQUESTS_PER_SECOND = 5; // Adjust according to your needs
    private static final long REFILL_INTERVAL_MILLIS = 1000; // 1 second
    private static final Random random = new Random();

    private final RateLimiter rateLimiter;

    public MovieApplication() {
        this.rateLimiter = new RateLimiter(MAX_REQUESTS_PER_SECOND, REFILL_INTERVAL_MILLIS);
    }

    public void fetchMovieDetailsFromIMDB(int reqId) {
        if (rateLimiter.allowRequest(reqId)) {
            // Make HTTP request to fetch movie details from IMDB
            System.out.println("Fetching movie details from IMDB for Request " + reqId);
        } else {
            System.out.println("Request " + reqId + " rejected. Rate limit exceeded.");
        }
    }

    public static void main(String[] args) {
        MovieApplication app = new MovieApplication();
        System.out.println("============================================================================");
        System.out.println("Value of MAX_REQUESTS_PER_SECOND : " + MAX_REQUESTS_PER_SECOND);
        System.out.println("Value of REFILL_INTERVAL_MILLIS : " + REFILL_INTERVAL_MILLIS);

        // Simulate making requests to fetch movie details
        for (int reqId = 1; reqId <= 10; reqId++) {
            System.out.println("============================================================================");
            System.out.println("Started making Request " + reqId);
            app.fetchMovieDetailsFromIMDB(reqId);

            try {
                int randomDelay = random.nextInt(101) + 100; // Generate random value between 100ms and 200ms
                Thread.sleep(randomDelay); // Sleep for random delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("============================================================================");
    }
}
