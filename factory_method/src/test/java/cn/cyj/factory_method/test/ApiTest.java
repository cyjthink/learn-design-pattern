package cn.cyj.factory_method.test;

import cn.cyj.factory_method.AdFactory;
import cn.cyj.factory_method.ad.AdService;
import org.junit.Test;

public class ApiTest {

    @Test 
    public void adServiceTest() {
        AdService adService = AdFactory.getAdService(1);
        adService.load();
        adService.show();
    }
}
