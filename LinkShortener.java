import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class LinkShortener {
    private static final String BASE62_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    private Map<String, String> urlMappings;

    public LinkShortener() {
        urlMappings = new HashMap<>();
    }

    // Method to generate a short URL
    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(BASE62_CHARS.length());
            shortUrl.append(BASE62_CHARS.charAt(index));
        }

        return shortUrl.toString();
    }

    // Method to shorten a long URL
    public String shortenUrl(String longUrl) {
        String shortUrl = generateShortUrl();
        urlMappings.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Method to expand a short URL
    public String expandUrl(String shortUrl) {
        return urlMappings.get(shortUrl);
    }

    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the long URL: ");
        String longUrl = scanner.nextLine();

        String shortUrl = linkShortener.shortenUrl(longUrl);

        System.out.println("Long URL: " + longUrl);
        System.out.println("Short URL: " + shortUrl);

        // Example: Expand the short URL
        System.out.print("Enter the short URL to expand: ");
        String inputShortUrl = scanner.nextLine();
        String expandedUrl = linkShortener.expandUrl(inputShortUrl);

        if (expandedUrl != null) {
            System.out.println("Expanded URL: " + expandedUrl);
        } else {
            System.out.println("Short URL not found in the mappings.");
        }
    }
}