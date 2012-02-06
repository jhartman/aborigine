//package com.linkedin.aborigine.impl;
//
//import com.google.common.base.Function;
//import com.linkedin.aborigine.api.ABTest;
//import com.linkedin.aborigine.api.DynamicConfigStore;
//import com.netflix.curator.framework.CuratorFramework;
//import com.netflix.curator.framework.recipes.cache.PathChildrenCache;
//import com.netflix.curator.framework.recipes.cache.PathChildrenCacheMode;
//import org.I0Itec.zkclient.IZkChildListener;
//import org.I0Itec.zkclient.IZkDataListener;
//import org.I0Itec.zkclient.ZkClient;
//
//import java.util.*;
//
//// TODO: Reader/writer locking
//public class ZookeeperConfigStore<ExperimentKeyType, ExperimentIdType> implements DynamicConfigStore<ExperimentKeyType, ExperimentIdType> {
//    public static final String DYNAMIC_CONFIG = "dynamic_config";
//    private final ABTest<ExperimentKeyType, ExperimentIdType> abTester;
//  private final CuratorFramework curator;
//  private final Function<ExperimentKeyType, String> keyToStringFn;
//
//  private final PathChildrenCache configCache;
//
////  private final Map<String, Map<String, String>> dataCache = new HashMap<String, Map<String, String>>();
////  private final Map<String, Set<String>> pathCache = new HashMap<String, Set<String>>();
//
//  public ZookeeperConfigStore(ABTest<ExperimentKeyType, ExperimentIdType> abTester, CuratorFramework curator, Function<ExperimentKeyType, String> keyToStringFn) {
//    this.abTester = abTester;
//    this.curator = curator;
//    this.keyToStringFn = keyToStringFn;
//    this.configCache = new PathChildrenCache(curator, DYNAMIC_CONFIG, PathChildrenCacheMode.CACHE_PATHS_ONLY);
//
//    configCache.start();
//  }
//
//  @Override
//  public String getConfig(ExperimentKeyType experimentKey, ExperimentIdType experimentId) {
//    final String keyString = keyToStringFn.apply(experimentKey);
//
//
//      final String experimentPath = DYNAMIC_CONFIG + "/" + keyString;
//      configCache.getCurrentData().
//
//
//
//
//      // TODO: for the first time, we need to go to sleep until the pathCache has been filled with this key
//      return null;
//    } else {
//      final Map<String, String> dataMap = dataCache.get(keyString);
//      final String treatment = abTester.getTreatment(experimentKey, experimentId);
//
//      if(dataMap == null) {
//        String dataPath = experimentPath + "/" + treatment;
//
//        zkClient.subscribeDataChanges(dataPath, new IZkDataListener() {
//          @Override
//          public void handleDataChange(final String dataPath, final Object data) throws Exception {
//            Map<String, String> dataMap = dataCache.get(keyString); // dataMap is shadowing
//            if(dataMap == null) {
//              dataMap = new HashMap<String, String>();
//              dataMap.put(treatment, data.toString());
//              dataCache.put(keyString, dataMap);
//            } else {
//              dataMap.put(treatment, data.toString());
//            }
//          }
//
//          @Override
//          public void handleDataDeleted(final String dataPath) throws Exception {
//            final Map<String, String> dataMap = dataCache.get(keyString); // dataMap is shadowing
//            if(dataMap == null) {
//              // no op
//            } else {
//              dataMap.remove(treatment);
//            }
//          }
//          // TODO: for the first time, we need to go to sleep until the dataCache has been filled with this key
//
//        });
//        return null;
//      } else {
//        return dataMap.get(treatment);
//      }
//    }
//  }
//
////  private static <K, V> V getOrUpdate(Map<K, V> map, K key, Function<K, V> valueBuilder) {
////    V oldValue = map.get(key);
////    if(oldValue == null) {
////      V newValue = valueBuilder.apply(key);
////      map.put(key, newValue);
////      return newValue;
////    } else {
////      return oldValue;
////    }
////  }
//}
