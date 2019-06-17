package net.emojiparty.showmethegetty.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import net.emojiparty.showmethegetty.data.Business;
import net.emojiparty.showmethegetty.data.YelpRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessViewModel extends ViewModel {
  private MutableLiveData<Business> business = new MutableLiveData<>();

  public MutableLiveData<Business> getBusiness() {
    if (business.getValue() == null) {
      new YelpRepository().getGettyCenter().enqueue(new Callback<Business>() {
        @Override public void onResponse(Call<Business> call, Response<Business> response) {
          business.setValue(response.body());
        }

        @Override public void onFailure(Call<Business> call, Throwable t) {
          // TODO do something on error
        }
      });
    }
    return business;
  }
}
