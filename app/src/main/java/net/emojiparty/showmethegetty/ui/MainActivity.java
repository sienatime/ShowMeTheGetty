package net.emojiparty.showmethegetty.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import net.emojiparty.showmethegetty.R;
import net.emojiparty.showmethegetty.data.Business;
import net.emojiparty.showmethegetty.data.YelpRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
