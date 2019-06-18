package net.emojiparty.showmethegetty.ui;

import android.view.View;
import net.emojiparty.showmethegetty.data.Business;

public class BindingAdapter {
  @androidx.databinding.BindingAdapter("invisibleIfNull")
  public static void setVisibility(View view, Business business) {
    if (business == null) {
      view.setVisibility(View.INVISIBLE);
    } else {
      view.setVisibility(View.VISIBLE);
    }
  }
}
