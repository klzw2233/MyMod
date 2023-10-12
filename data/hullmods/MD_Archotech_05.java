package data.hullmods;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;//船只尺寸 枚举类型 可能存在内部类
import com.fs.starfarer.api.impl.campaign.ids.HullMods;//船体插件
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.util.IntervalUtil;
import com.fs.starfarer.api.impl.hullmods.PeriodicMissileReload;
import com.fs.starfarer.api.impl.hullmods.PeriodicMissileReload.PeriodicMissileReloadData;

public class MD_Archotech_05 extends PeriodicMissileReload {
	
	public MD_Archotech_05() {}
	
	public static final float GROUND_BONUS = 2000;//地面支援2000点
	public static final float n1 = 50;//降低部署点 维护费 战备值上限
	
	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
		stats.getDynamic().getMod(Stats.FLEET_GROUND_SUPPORT).modifyFlat(id, GROUND_BONUS);
		//stats.getDynamic().getMod(Stats.FLEET_BOMBARD_COST_REDUCTION).modifyFlat(id, GROUND_BONUS);
		
		stats.getDynamic().getMod(Stats.DEPLOYMENT_POINTS_MOD).modifyMult(id, n1/100f);//部署点
		stats.getDynamic().getMod(Stats.DMOD_REDUCE_MAINTENANCE).modifyFlat(id, -n1);//维护费
	}
}