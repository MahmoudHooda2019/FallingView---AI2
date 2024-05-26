package me.aemo.fallingview;


import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;

import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.YailList;

import me.samlss.bling.Bling;
import me.samlss.bling.BlingListener;
import me.samlss.bling.BlingType;

public class FallingView extends AndroidNonvisibleComponent {

  private ComponentContainer container;
  private Bling bling;

  private int duration = 2500;
  private int shapeCount = 20;
  private float minRadius = 5;
  private float maxRadius = 10;
  private float minSpeed = 0.08f;
  private float maxSpeed = 0.3f;
  private float minRotation = 0;
  private float maxRotation = 360;
  private float minRotationSpeed = 0;
  private float maxRotationSpeed = 0;
  private boolean isAutoHide = true;
  private int[] colors = new int[]{
          Color.WHITE,
          Color.MAGENTA,
          Color.YELLOW,
          Color.RED,
          Color.BLUE,
          Color.GREEN,
          Color.CYAN
  };

  private int shapeType = BlingType.CIRCLE;

  public FallingView(ComponentContainer container) {
    super(container.$form());
    this.container = container;
  }

  @SimpleProperty
  public String CircleShape(){
    return "Circle";
  }
  @SimpleProperty
  public String RectangleShape(){
    return "Rectangle";
  }
  @SimpleProperty
  public String TriangleShape(){
    return "Triangle";
  }
  @SimpleProperty
  public String StarShape(){
    return "Star";
  }
  @SimpleProperty
  public String MixedShape(){
    return "Mixed";
  }

  @SimpleProperty
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_CHOICES,
  defaultValue = "Circle", editorArgs = {"Circle", "Rectangle", "Triangle", "Star", "Mixed"})
  public void ShapeType(String type){
    if ("Circle".equals(type)){
      shapeType = BlingType.CIRCLE;
    } else if ("Rectangle".equals(type)) {
      shapeType = BlingType.RECTANGLE;
    } else if ("Triangle".equals(type)) {
      shapeType = BlingType.TRIANGLE;
    } else if ("Star".equals(type)) {
      shapeType = BlingType.STAR;
    } else if ("Mixed".equals(type)) {
      shapeType = BlingType.MIXED;
    } else {
      shapeType = BlingType.CIRCLE;
    }
  }
  @SimpleProperty
  public String ShapeType(){
    if (shapeType == BlingType.CIRCLE){
      return "Circle";
    } else if (shapeType == BlingType.RECTANGLE) {
      return "Rectangle";
    } else if (shapeType == BlingType.TRIANGLE) {
      return "Triangle";
    } else if (shapeType == BlingType.STAR) {
      return "Star";
    } else if (shapeType == BlingType.MIXED) {
      return "Mixed";
    } else {
      return "Circle";
    }
  }




  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
          defaultValue = "2500")
  public void Duration(int duration){
    this.duration = duration;
  }
  @SimpleProperty
  public int Duration(){
    return duration;
  }


  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
          defaultValue = "20")
  public void ShapeCount(int shapeCount){
    this.shapeCount = shapeCount;
  }
  @SimpleProperty
  public int ShapeCount(){
    return shapeCount;
  }

  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_FLOAT,
          defaultValue = "5")
  public void MinRadius(float minRadius){
    this.minRadius = minRadius;
  }
  @SimpleProperty
  public float MinRadius(){
    return minRadius;
  }

  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_FLOAT,
          defaultValue = "10")
  public void MaxRadius(float maxRadius){
    this.maxRadius = maxRadius;
  }
  @SimpleProperty
  public float MaxRadius(){
    return maxRadius;
  }

  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_FLOAT,
          defaultValue = "0")
  public void MinRotationSpeed(float minRotationSpeed){
    this.minRotationSpeed = minRotationSpeed;
  }
  @SimpleProperty
  public float MinRotationSpeed(){
    return minRotationSpeed;
  }


  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_FLOAT,
          defaultValue = "0")
  public void MaxRotationSpeed(float maxRotationSpeed){
    this.maxRotationSpeed = maxRotationSpeed;
  }
  @SimpleProperty
  public float MaxRotationSpeed(){
    return maxRotationSpeed;
  }

  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
          defaultValue = "True")
  public void AutoHide(boolean isAutoHide){
    this.isAutoHide = isAutoHide;
  }
  @SimpleProperty
  public boolean AutoHide(){
    return isAutoHide;
  }

  @SimpleProperty
  public void Colors(YailList colors){
    String[] stringsArray = colors.toStringArray();
    int[] c = new int[stringsArray.length];
    for (int i = 0; i < stringsArray.length; i++){
      c[i] = Integer.parseInt(stringsArray[i]);
    }
    this.colors = c;
  }
  @SimpleProperty
  public YailList Colors(){
    String[] stringArray = new String[colors.length];
    for (int i = 0; i < colors.length; i++) {
      stringArray[i] = String.valueOf(colors[i]);
    }

    return YailList.makeList(stringArray);
  }


  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_FLOAT,
          defaultValue = "0.08")
  public void MinSpeed(float minSpeed){
    this.minSpeed = minSpeed;
  }
  @SimpleProperty
  public float MinSpeed(){
    return minSpeed;
  }

  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_FLOAT,
          defaultValue = "0.3")
  public void MaxSpeed(float maxSpeed){
    this.maxSpeed = maxSpeed;
  }
  @SimpleProperty
  public float MaxSpeed(){
    return maxSpeed;
  }


  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_FLOAT,
          defaultValue = "0")
  public void MinRotation(float minRotation){
    this.minRotation = minRotation;
  }
  @SimpleProperty
  public float MinRotation(){
    return minRotation;
  }

  @SimpleProperty
  @DesignerProperty(
          editorType = PropertyTypeConstants.PROPERTY_TYPE_FLOAT,
          defaultValue = "0")
  public void MaxRotation(float maxRotation){
    this.maxRotation = maxRotation;
  }
  @SimpleProperty
  public float MaxRotation(){
    return maxRotation;
  }


  @SimpleFunction
  public void Initialize(){
    bling = new Bling.Builder((Activity) container)
            .setDuration(duration)
            .setShapeCount(shapeCount)
            .setRadiusRange(minRadius, maxRadius)
            .setRotationSpeedRange(minRotationSpeed, maxRotationSpeed)
            .setAutoHide(isAutoHide)
            .setColors(colors)
            .setSpeedRange(minSpeed, maxSpeed)
            .setRotationRange(minRotation, maxRotation)
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
  @SimpleFunction
  public void InitializeFor(AndroidViewComponent view){
    ViewGroup vg = (ViewGroup) view.getView();
    bling = new Bling.Builder(vg)
            .setDuration(duration)
            .setShapeCount(shapeCount)
            .setRadiusRange(minRadius, maxRadius)
            .setRotationSpeedRange(minRotationSpeed, maxRotationSpeed)
            .setAutoHide(isAutoHide)
            .setColors(colors)
            .setSpeedRange(minSpeed, maxSpeed)
            .setRotationRange(minRotation, maxRotation)
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
  public boolean isShowing(){
    if (bling != null) {
      return bling.isShowing();
    } else {
      return false;
    }
  }


  @SimpleFunction
  public void Show(){
    if (bling != null) {
      bling.show(shapeType);
    }
  }
  @SimpleFunction
  public void ShowAsync(){
      new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
        @Override
        public void run() {
          Show();
        }
      }, 100);
  }

  @SimpleFunction
  public void Release(){
    if (bling != null){
      bling.release();
    }
  }
  @SimpleFunction
  public void Dismiss(){
    if (bling != null){
      bling.dismiss();
    }
  }












}
