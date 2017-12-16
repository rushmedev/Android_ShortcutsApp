package com.company.app.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ObscuredSharedPreferences implements SharedPreferences {
  protected Context context;

  protected static final String UTF8 = "utf-8";

  protected SharedPreferences delegate;

  private final char[] secret;

  public ObscuredSharedPreferences(char[] secret, Context context, SharedPreferences delegate) {
    this.secret = secret;

    this.delegate = delegate;

    this.context = context;
  }

  @Override
  public Set<String> getStringSet(String key, Set<String> defValues) {
    final Set<String> storedStringSet = delegate.getStringSet(key, null);

    if (storedStringSet != null) {
      Set<String> decryptedStringSet = new HashSet<>();
      for (String s : storedStringSet) {
        decryptedStringSet.add(decrypt(s));
      }
      return decryptedStringSet;
    } else {
      return null;
    }
  }

  @Override
  public void registerOnSharedPreferenceChangeListener(
      OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    delegate.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
  }

  @Override
  public int getInt(String key, int defValue) {
    final String v = delegate.getString(key, null);

    return v != null ? Integer.parseInt(decrypt(v)) : defValue;
  }

  @Override
  public float getFloat(String key, float defValue) {
    final String v = delegate.getString(key, null);

    return v != null ? Float.parseFloat(decrypt(v)) : defValue;
  }

  @Override
  public Map<String, ?> getAll() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getString(String key, String defValue) {
    final String v = delegate.getString(key, null);

    return v != null ? decrypt(v) : defValue;
  }

  protected String encrypt(String value) {
    try {
      final byte[] bytes = value != null ? value.getBytes(UTF8) : new byte[0];
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
      SecretKey key = keyFactory.generateSecret(new PBEKeySpec(secret));
      Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
      pbeCipher.init(
          Cipher.ENCRYPT_MODE,
          key,
          new PBEParameterSpec(
              Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)
                  .getBytes(UTF8),
              20));
      return new String(Base64.encode(pbeCipher.doFinal(bytes), Base64.NO_WRAP), UTF8);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Editor edit() {
    return new Editor();
  }

  @Override
  public void unregisterOnSharedPreferenceChangeListener(
      OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    delegate.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
  }

  @Override
  public boolean getBoolean(String key, boolean defValue) {
    final String v = delegate.getString(key, null);

    return v != null ? Boolean.parseBoolean(decrypt(v)) : defValue;
  }

  protected String decrypt(String value) {
    try {
      final byte[] bytes = value != null ? Base64.decode(value, Base64.DEFAULT) : new byte[0];
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
      SecretKey key = keyFactory.generateSecret(new PBEKeySpec(secret));
      Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
      pbeCipher.init(
          Cipher.DECRYPT_MODE,
          key,
          new PBEParameterSpec(
              Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)
                  .getBytes(UTF8),
              20));
      return new String(pbeCipher.doFinal(bytes), UTF8);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean contains(String s) {
    return delegate.contains(s);
  }

  @Override
  public long getLong(String key, long defValue) {
    final String v = delegate.getString(key, null);

    return v != null ? Long.parseLong(decrypt(v)) : defValue;
  }

  public class Editor implements SharedPreferences.Editor {
    protected SharedPreferences.Editor delegate;

    public Editor() {
      this.delegate = ObscuredSharedPreferences.this.delegate.edit();
    }

    @Override
    public Editor putInt(String key, int value) {
      delegate.putString(key, encrypt(Integer.toString(value)));

      return this;
    }

    @Override
    public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
      Set<String> encryptedSet = new HashSet<>();

      for (String s : values) {
        encryptedSet.add(encrypt(s));
      }

      delegate.putStringSet(key, encryptedSet);

      return this;
    }

    @Override
    public Editor remove(String s) {
      delegate.remove(s);

      return this;
    }

    @Override
    public Editor putFloat(String key, float value) {
      delegate.putString(key, encrypt(Float.toString(value)));

      return this;
    }

    @Override
    public Editor putLong(String key, long value) {
      delegate.putString(key, encrypt(Long.toString(value)));

      return this;
    }

    @Override
    public Editor putString(String key, String value) {
      delegate.putString(key, encrypt(value));

      return this;
    }

    @Override
    public boolean commit() {
      return delegate.commit();
    }

    @Override
    public Editor clear() {
      delegate.clear();

      return this;
    }

    @Override
    public void apply() {
      delegate.apply();
    }

    @Override
    public Editor putBoolean(String key, boolean value) {
      delegate.putString(key, encrypt(Boolean.toString(value)));

      return this;
    }
  }
}