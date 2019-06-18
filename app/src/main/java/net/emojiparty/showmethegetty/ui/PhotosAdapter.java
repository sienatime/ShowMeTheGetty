package net.emojiparty.showmethegetty.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import net.emojiparty.showmethegetty.R;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {
  List<String> photos = new ArrayList<>();

  public void setPhotos(List<String> photos) {
    this.photos = photos;
    notifyDataSetChanged();
  }

  @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String url = photos.get(position);
    holder.setPhoto(url);
  }

  @Override public int getItemCount() {
    return photos.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      imageView = itemView.findViewById(R.id.business_photo);
    }

    public void setPhoto(String url) {
      Picasso.get().load(url).into(imageView);
    }
  }
}
