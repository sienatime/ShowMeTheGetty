package net.emojiparty.showmethegetty.data;

import retrofit2.Call;

public class YelpRepository {
  private static final String GETTY_CENTER_ID = "zRlDhJgcwXEphTUhMaCfyw";
  private YelpNetwork network;

  public YelpRepository() {
    this.network = new YelpNetwork();
  }

  public Call<Business> getGettyCenter() {
    return network.getBusiness(GETTY_CENTER_ID);
  }
}
