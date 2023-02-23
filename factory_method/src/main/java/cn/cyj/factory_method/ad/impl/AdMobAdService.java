package cn.cyj.factory_method.ad.impl;

import cn.cyj.factory_method.ad.AdService;

/**
 * AdMob广告
 */
public class AdMobAdService implements AdService {

    @Override
    public void load() {
        System.out.println("加载AdMob广告");
    }

    @Override
    public void show() {
        System.out.println("播放AdMob广告");
    }
}
