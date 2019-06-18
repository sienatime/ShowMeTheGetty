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

  public double getRating() {
    return rating;
  }

  public int getReviewCount() {
    return reviewCount;
  }

  public String getDisplayPhone() {
    return displayPhone;
  }

  public List<String> getPhotos() {
    return photos;
  }

  public Location getLocation() {
    return location;
  }

  public static class Location {
    private String address1;
    private String city;
    @SerializedName("zip_code") private String zipCode;
    private String country;
    private String state;
    @SerializedName("display_address") private List<String> displayAddress;

    public String getDisplayAddress() {
      if (displayAddress != null && displayAddress.size() > 0) {
        StringBuilder builder = new StringBuilder();
        for (String line : displayAddress) {
          builder.append(line);
          builder.append("\n");
        }
        return builder.toString();
      }
      return null;
    }
  }

  public List<Hours> getHours() {
    return hours;
  }

  public static class Hours {
    private List<Open> open;
    @SerializedName("is_open_now") boolean isOpenNow;

    // indexes with null are closed days
    public Open[] openAndClosedDays() {
      Open[] days = new Open[7]; // 7 days of the week
      for (Open open : open) {
        days[open.getDay()] = open;
      }
      return days;
    }
  }

  // day: From 0 to 6, representing day of the week from Monday to Sunday.
  public static class Open {
    private String start;
    private String end;
    private int day;

    public String getStart() {
      return start;
    }
    public String getEnd() {
      return end;
    }

    public int getDay() {
      return day;
    }
  }
}
