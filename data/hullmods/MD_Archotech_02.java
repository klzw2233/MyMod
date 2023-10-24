package data.hullmods;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;//船只尺寸 枚举类型 可能存在内部类
import com.fs.starfarer.api.impl.campaign.ids.HullMods;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.util.Misc;

public class MD_Archotech_02 extends BaseHullMod {

    public MD_Archotech_02(){}

    protected static final float n1 = 10000;
    protected static final float n2 = -50;
    protected static final float n3 = 5000;
    
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {


        stats.getMaxBurnLevel().modifyFlat(id, 16f);//宇宙航行速度加16

        stats.getCargoMod().modifyFlat(id,n1);//载货
        stats.getFuelMod().modifyFlat(id,n1);//燃油
        stats.getMaxCrewMod().modifyFlat(id, n1);//载人

        //导入包不知道缺了哪一个
        //stats.getSurveyCostReductionId().modifyFlat(id, -12);//重型机械减少
        //stats.getSurveyCostReductionId().modifyFlat(id, -12);//重型机械减少

        //无法作用在船上
        //stats.getDynamic().getMod(Stats.SALVAGE_VALUE_MULT_MOD).modifyPercent(id, n1);//打捞+10000%

        stats.getSensorProfile().modifyPercent(id,n2);//被探测-50%，会和其他修正加算后再乘积
        //stats.getSensorStrength().modifyMult(id,10f);//探测范围x1000
        stats.getSensorStrength().modifyPercent(id,n1);
        
        //打捞起重机 5倍打捞 全部不包含稀有 包含稀有 战后打捞
        //stats.getDynamic().getMod(Stats.SALVAGE_VALUE_MULT_MOD).modifyFlat(id, n3);
        stats.getDynamic().getMod(Stats.SALVAGE_VALUE_MULT_FLEET_INCLUDES_RARE).modifyFlat(id, n3);
        //stats.getDynamic().getMod(Stats.BATTLE_SALVAGE_MULT_FLEET).modifyFlat(id, n3);
	}

}