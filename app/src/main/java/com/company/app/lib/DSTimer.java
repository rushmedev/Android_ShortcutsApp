package com.company.app.lib;

import android.os.CountDownTimer;

public class DSTimer extends CountDownTimer {
  public long tickIntervalInMillis;

  public boolean repeating;

  public long intervalInMillis;

  private Protocol del;

  private static final int tickMultiplier = 10;

  private int subTickCount;

  public DSTimer(
      long countdownIntervalInMillis,
      long tickIntervalInMillis,
      boolean repeating,
      Protocol callback) {
    super(countdownIntervalInMillis, tickIntervalInMillis / tickMultiplier);

    this.intervalInMillis = countdownIntervalInMillis;

    this.tickIntervalInMillis = tickIntervalInMillis;

    this.repeating = repeating;

    this.del = callback;
  }

  @Override
  public void onFinish() {
    if (repeating) {
      subTickCount = 0;
      this.start();
    }

    this.del.didFinish(this);
  }

  @Override
  public void onTick(long millisUntilFinished) {
    subTickCount++;

    if (subTickCount == tickMultiplier) {
      this.del.didTick(this, millisUntilFinished);
      subTickCount = 0;
    }
  }

  public interface Protocol {
    void didTick(DSTimer timer, long timeUntilFinished);

    void didFinish(DSTimer timer);
  }
}