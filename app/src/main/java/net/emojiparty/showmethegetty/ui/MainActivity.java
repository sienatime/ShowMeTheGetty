package net.emojiparty.showmethegetty.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import net.emojiparty.showmethegetty.R;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_container, new BusinessFragment())
        .commit();
  }
}
