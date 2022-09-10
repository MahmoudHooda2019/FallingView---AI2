package com.aemo.fallingview;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.YailList;
import me.samlss.bling.Bling;
import me.samlss.bling.BlingListener;
import me.samlss.bling.BlingType;

public class FallingView extends AndroidNonvisibleComponent {


  private ComponentContainer container;
  private Activity activity;
  private Bling mBling;

  public FallingView(ComponentContainer container) {
    super(container.$form());
    this.container = container;
    activity = container.$context();
  }
  @SimpleFunction
  public void Initialized(int duration, int count,
                          int minRadius, int maxRadius,
                          boolean autoHide, YailList colors,
                          int minRotationSpeed, int maxRotationSpeed){

    String[] arry = colors.toStringArray();
    int[] c = new int[arry.length];
    for (int i=0;i<arry.length;i++){
      c[i] = Integer.parseInt(arry[i]);
    }

    mBling = new Bling.Builder((ViewGroup) activity.getWindow().getDecorView())
            .setDuration(duration)
            .setShapeCount(count)
            .setRadiusRange(minRadius,maxRadius)
            .setRotationRange(-3f,3f)
            .setAutoHide(autoHide)
            .setColors(c)
            .setSpeedRange(0.1f,0.5f)
            .setRotationSpeedRange(minRotationSpeed,maxRotationSpeed)
            .setInterpolator(new AccelerateDecelerateInterpolator())
            .setBlingListener(new BlingListener() {
              @Override
              public void onBegin() {
                OnBeginning();
              }

              @Override
              public void onEnd() {
                OnEnding();
              }
            })
            .build();
  }

  @SimpleEvent
  public void OnBeginning() {
    EventDispatcher.dispatchEvent(this,"OnBeginning");
  }

  @SimpleEvent
  public void OnEnding() {
    EventDispatcher.dispatchEvent(this,"OnEnding");
  }

  @SimpleFunction
  public void Show(int shapeType){
    mBling.show(shapeType);
  }
  @SimpleProperty
  public int CIRCLE(){
    return BlingType.CIRCLE;
  }
  @SimpleProperty
  public int RECTANGLE(){
    return BlingType.RECTANGLE;
  }
  @SimpleProperty
  public int TRIANGLE(){
    return BlingType.TRIANGLE;
  }
  @SimpleProperty
  public int STAR(){
    return BlingType.STAR;
  }
  @SimpleProperty
  public int MIXED() {
    return BlingType.MIXED;
  }

  @SimpleFunction
  public void Dismiss(){
    mBling.dismiss();
  }
  @SimpleFunction
  public boolean IsShowing(){
    return mBling.isShowing();
  }
  @SimpleFunction
  public void Release(){
    mBling.release();
  }










  }
