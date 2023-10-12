package data.hullmods;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;//船只尺寸 枚举类型 可能存在内部类
import com.fs.starfarer.api.impl.campaign.ids.HullMods;//船体插件
import com.fs.starfarer.api.util.Misc;

//import com.fs.starfarer.api.Global; 读取set文件
//import com.fs.starfarer.api.loading.FighterWingSpecAPI; 飞机联队规格
//import com.fs.starfarer.api.combat.FighterLaunchBayAPI;  飞行甲板
//import com.fs.starfarer.api.combat.ReserveWingStats;//赶牛人的战术技能，后备部署,jb 访问不到？

public class MD_Archotech_03 extends BaseHullMod {

    public MD_Archotech_03(){}
    
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {



        //stats.getHangarSpaceMod().modifyFlat(id,2);//每个编队的数量+2 无效果
        stats.getFighterRefitTimeMult().modifyFlat(id, -10f);//战机重新制造出来（整备）时间，有用 但是这里不启用
        stats.getDamageToFighters().modifyPercent(id,-60f);//战机受到的伤害
        //stats.getDeployCost().modifyPercent(id,-50f);//战机损失带来的部署点数消耗

        stats.getFighterWingRange().modifyPercent(id,500f);//战机作战距离
        stats.getNumFighterBays().modifyFlat(id,4f);//机库甲板数量加4
        
	}
}