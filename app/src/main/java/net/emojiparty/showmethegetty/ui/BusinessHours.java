package net.emojiparty.showmethegetty.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateUtils;
import java.util.Calendar;
import net.emojiparty.showmethegetty.R;
import net.emojiparty.showmethegetty.data.Business;

public class BusinessHours {
  public static String getBizHours(Context context, Business business) {
    if (business != null) {
      StringBuilder builder = new StringBuilder();
      Business.Hours hours = business.getHours().get(0);
      Business.Open[] openAndClosedDays = hours.openAndClosedDays();

      for (int i = 0; i < openAndClosedDays.length; i++) {
        Business.Open open = openAndClosedDays[i];
        String dayOfWeek = dayOfWeek(context.getResources(), i, context.getPackageName());

        if (open == null) {
          builder.append(context.getResources().getString(R.string.biz_hours_format_closed, dayOfWeek));
        } else {
          String timeRange = getTimeRange(context, open);
          builder.append(context.getResources().getString(R.string.biz_hours_format_open, dayOfWeek, timeRange));
        }

        builder.append("\n");
      }

      return builder.toString();
    }
    return "";
  }

  private static int getHour(String time) {
    String hour = time.substring(0, 2);
    return Integer.valueOf(hour);
  }

  private static int getMinutes(String time) {
    String minutes = time.substring(2, 4);
    return Integer.valueOf(minutes);
  }

  // time is a string like "1000" = 10:00 AM
  private static Calendar getCalendar(String time) {
    int hour = getHour(time);
    int minutes = getMinutes(time);
    return new Calendar.Builder().setTimeOfDay(hour, minutes, 0).build();
  }

  private static String dayOfWeek(Resources resources, int day, String packageName) {
    int id = resources.getIdentifier("day_" + day, "string", packageName);
    return resources.getString(id);
  }

  private static String getTimeRange(Context context, Business.Open open) {
    Calendar start = getCalendar(open.getStart());
    Calendar end = getCalendar(open.getEnd());
    return DateUtils.formatDateRange(context, start.getTimeInMillis(), end.getTimeInMillis(),
        DateUtils.FORMAT_SHOW_TIME);
  }
}
