package net.emojiparty.showmethegetty.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;
import net.emojiparty.showmethegetty.BR;
import net.emojiparty.showmethegetty.R;

public class MainActivity extends AppCompatActivity {
  private BusinessViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setLifecycleOwner(this);

    viewModel = ViewModelProviders.of(this).get(BusinessViewModel.class);
    binding.setVariable(BR.viewModel, viewModel);
  }
}
