package com.company.app.lib.github;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import org.apache.commons.lang3.StringUtils;

public class GitHubAuth {
  public static String CLIENT_SECRET;

  public static String CLIENT_ID;

  public static final String ACCESS_TOKEN_EXTRA = "GitHubAccessToken";

  private static GitHubAuthService gitHubAuthService =
      new Retrofit.Builder()
          .baseUrl("https://github.com/")
          .addConverterFactory(ScalarsConverterFactory.create())
          .build()
          .create(GitHubAuthService.class);

  public static String REDIRECT_URL;

  public static String[] SCOPE;

  public static void requestAccessToken(String code, Callback<String> callback) {
    String scope = null;

    if (SCOPE.length > 0) {
      scope = StringUtils.join(SCOPE, " ");
    }

    gitHubAuthService
        .postloginoauthaccesstoken(CLIENT_ID, CLIENT_SECRET, scope, code)
        .enqueue(callback);
  }

  private interface GitHubAuthService {
    @Headers({"Accept: application/json"})
    @POST("login/oauth/access_token")
    Call<String> postloginoauthaccesstoken(
        @Query("client_id") String clientId,
        @Query("client_secret") String clientSecret,
        @Query("scope") String scope,
        @Query("code") String code);
  }
}