package com.mikuac.shiro.common.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <p>NetUtils class.</p>
 *
 * @author zero
 * @version $Id: $Id
 */
public class NetUtils {

    private NetUtils() {
    }

    public static String asyncGet(String url) throws InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        CompletableFuture<String> result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body);
        return result.get();
    }

}
