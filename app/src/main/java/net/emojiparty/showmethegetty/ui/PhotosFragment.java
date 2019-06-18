package net.emojiparty.showmethegetty.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import net.emojiparty.showmethegetty.R;
import net.emojiparty.showmethegetty.data.Business;

public class PhotosFragment extends Fragment {
  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_photos, container, false);
    RecyclerView recyclerView = view.findViewById(R.id.photos_recycler_view);
    final PhotosAdapter adapter = new PhotosAdapter();
    recyclerView.setAdapter(adapter);

    BusinessViewModel viewModel = ViewModelProviders.of(getActivity()).get(BusinessViewModel.class);
    viewModel.getBusiness().observe(getActivity(), new Observer<Business>() {
      @Override public void onChanged(Business business) {
        adapter.setPhotos(business.getPhotos());
      }
    });

    return view;
  }
}
