package cn.cyj.factory_method;

import cn.cyj.factory_method.ad.AdService;
import cn.cyj.factory_method.ad.impl.AdMobAdService;
import cn.cyj.factory_method.ad.impl.GDTAdService;
import cn.cyj.factory_method.ad.impl.PangleAdService;
import cn.cyj.factory_method.ad.impl.UnityAdService;

public class AdFactory {

    public static AdService getAdService(int adType) {
        if (adType == 1) {
            return new AdMobAdService();
        } else if (adType == 2) {
            return new GDTAdService();
        } else if (adType == 3) {
            return new PangleAdService();
        } else {
            return new UnityAdService();
        }
    }
}
