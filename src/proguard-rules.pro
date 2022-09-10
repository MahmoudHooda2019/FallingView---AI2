# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.aemo.fallingview.FallingView {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/aemo/fallingview/repack'
-flattenpackagehierarchy
-dontpreverify
