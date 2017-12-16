package com.company.app.lib;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class GsonUtility {
  @NonNull
  public static Gson createDefaultGson() {
    return new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateAdapter()).create();
  }

  private static class GsonDateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    private static final DateFormat dateFormat;

    static {
      dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);

      dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public synchronized Date deserialize(
        JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
      try {
        if (jsonElement.isJsonPrimitive()) {
          JsonPrimitive primitive = jsonElement.getAsJsonPrimitive();
          if (primitive.isNumber()) {
            return new Date(primitive.getAsLong());
          } else if (primitive.isString()) {
            return dateFormat.parse(primitive.getAsString());
          }
        }
      } catch (ParseException e) {
        throw new JsonParseException(e);
      }

      return null;
    }

    @Override
    public synchronized JsonElement serialize(
        Date date, Type type, JsonSerializationContext jsonSerializationContext) {
      return new JsonPrimitive(date.getTime());
    }
  }
}