package net.emojiparty.showmethegetty.data;

import java.io.IOException;
import net.emojiparty.showmethegetty.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class YelpNetwork {
  private static final String API_KEY = BuildConfig.YELP_FUSION_API_KEY;
  private static final String URL = "https://api.yelp.com/";
  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String AUTHORIZATION_VALUE = "Bearer %s";
  private YelpService service;

  public YelpNetwork() {
    Retrofit retrofit = buildRetrofit();
    this.service = retrofit.create(YelpService.class);
  }

  public Call<Business> getBusiness(String id) {
    return service.getBusiness(id);
  }

  private OkHttpClient buildClient() {
    return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
      @Override public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request requestWithAuthHeader =
            request.newBuilder().addHeader(AUTHORIZATION_HEADER, authorizationValue()).build();
        return chain.proceed(requestWithAuthHeader);
      }
    }).build();
  }

  private String authorizationValue() {
    return String.format(AUTHORIZATION_VALUE, API_KEY);
  }

  private Retrofit buildRetrofit() {
    OkHttpClient client = buildClient();
    return new Retrofit.Builder()
        .baseUrl(URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  interface YelpService {
    @GET("/v3/businesses/{id}") Call<Business> getBusiness(@Path("id") String id);
  }
}
