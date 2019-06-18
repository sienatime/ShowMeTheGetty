package net.emojiparty.showmethegetty.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import net.emojiparty.showmethegetty.BR;
import net.emojiparty.showmethegetty.R;

public class BusinessFragment extends Fragment {
  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    ViewDataBinding binding =
        DataBindingUtil.inflate(inflater, R.layout.fragment_business, container, false);
    View root = binding.getRoot();
    FragmentActivity activity = getActivity();
    binding.setLifecycleOwner(activity);

    ViewModel viewModel = ViewModelProviders.of(activity).get(BusinessViewModel.class);
    binding.setVariable(BR.viewModel, viewModel);

    return root;
  }
}
