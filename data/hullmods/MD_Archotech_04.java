package data.hullmods;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;//船只尺寸 枚举类型 可能存在内部类
import com.fs.starfarer.api.impl.campaign.ids.HullMods;
import com.fs.starfarer.api.util.Misc;

public class MD_Archotech_04 extends BaseHullMod {

    public MD_Archotech_04(){}

    protected static final float num = -50;
    
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {

        
        stats.getFuelUseMod().modifyPercent(id,num);//燃料消耗
        stats.getSuppliesToRecover().modifyPercent(id,num);//恢复战备值的补给消耗
        stats.getSuppliesPerMonth().modifyPercent(id,num);//每月补给消耗
		
        stats.getMaxCombatReadiness().modifyPercent(id,-num);//战备值上限

	}

}
