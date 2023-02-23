package cn.cyj.factory_method.ad.impl;

import cn.cyj.factory_method.ad.AdService;

/**
 * Unity广告
 */
public class UnityAdService implements AdService {

    @Override
    public void load() {
        System.out.println("加载Unity广告");
    }

    @Override
    public void show() {
        System.out.println("播放Unity广告");
    }
}
