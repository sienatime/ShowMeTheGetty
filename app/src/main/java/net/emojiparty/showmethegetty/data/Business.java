package net.emojiparty.showmethegetty.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Business {
  private String id;
  private String name;
  @SerializedName("image_url") private String imageUrl;
  private String url;
  private String phone;
  @SerializedName("display_phone") private String displayPhone;
  @SerializedName("review_count") private int reviewCount;
  private double rating;
  private List<String> photos;
  private Location location;
  private List<Hours> hours;

  public String getName() {
    return name;
  }

  public static class Location {
    private String address1;
    private String city;
    @SerializedName("zip_code") private String zipCode;
    private String country;
    private String state;
  }

  public static class Hours {
    private List<Open> open;
    @SerializedName("is_open_now") boolean isOpenNow;
  }

  // day: From 0 to 6, representing day of the week from Monday to Sunday.
  public static class Open {
    private String start;
    private String end;
    private int day;
  }
}
