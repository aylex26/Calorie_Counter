package com.example.caloriecounter;
import android.app.Application;
import com.backendless.Backendless;

public class MyApplication extends Application {
    public static final String APPLICATION_ID = "25507A17-CDB6-A281-FF2F-0C0402083E00";
    public static final String API_KEY = "1C477CA4-3ECC-5343-FF99-F9645E3F3B00";
    public static final String SERVER_URL = "https://api.backendless.com";

    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl(SERVER_URL);
        Backendless.initApp(getApplicationContext(),
                APPLICATION_ID,
                API_KEY);
    }
}