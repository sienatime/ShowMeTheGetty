package net.emojiparty.showmethegetty.ui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import net.emojiparty.showmethegetty.R;
import net.emojiparty.showmethegetty.data.Business;

public class MainActivity extends AppCompatActivity {
  private BusinessViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    viewModel = ViewModelProviders.of(this).get(BusinessViewModel.class);
    viewModel.getBusiness().observe(this, new Observer<Business>() {
      @Override public void onChanged(Business business) {
        TextView name = findViewById(R.id.biz_name);
        name.setText(business.getName());
      }
    });
  }
}
