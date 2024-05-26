# Add any ProGuard configurations specific to this
# extension here.

-keep public class me.aemo.fallingview.FallingView {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'me/aemo/fallingview/repack'
-flattenpackagehierarchy
-dontpreverify
