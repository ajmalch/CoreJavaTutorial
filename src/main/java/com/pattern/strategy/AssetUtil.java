package com.pattern.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by AjmalCholassery on 6/15/15.
 */
public class AssetUtil {

    public static int totalAssetValues(final List<Asset> assets, Predicate<Asset> assetSelector){
        return assets.stream().filter(assetSelector).mapToInt(Asset::getValue).sum();
    }

    static final List<Asset> assets= Arrays.asList(
            new Asset(1000, Asset.AssetType.BOND),
            new Asset(6730, Asset.AssetType.STOCK),
            new Asset(7843, Asset.AssetType.STOCK ),
            new Asset(1842, Asset.AssetType.STOCK ),
            new Asset(7843, Asset.AssetType.BOND )
    );

    public static void main(String[] args) {
        System.out.println("Total value of all Assets :" + totalAssetValues(assets,asset->true) );
        System.out.println("Total value of Bond Assets :" + totalAssetValues(assets,asset->asset.getType()==Asset.AssetType.BOND) );
        System.out.println("Total value of Stock Assets :" + totalAssetValues(assets,asset->asset.getType()==Asset.AssetType.STOCK) );
    }
}
