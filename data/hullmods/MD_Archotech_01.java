package data.hullmods;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.CombatEngineAPI;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;//船只尺寸 枚举类型 可能存在内部类
import com.fs.starfarer.api.combat.WeaponAPI.WeaponType;
import com.fs.starfarer.api.impl.campaign.ids.HullMods;
//import com.fs.starfarer.api.util.Misc;
//import com.fs.starfarer.api.util.IntervalUtil;

public class MD_Archotech_01 extends BaseHullMod {

    public MD_Archotech_01(){}

    protected static final  float n1 = 50;
    protected static final  float n2 = 100;
    protected static final  float n3 = -50;
    
    public static String MR_DATA_KEY = "core_reload_data_key";

    //protected static final float MD_WeapomRange = 100;//增加射程的数值

    //在船生成之前加上效果
    /*
        hullsize 四种船加上飞机
        stats   可变的船统计数据
        id  安装这个船插的那艘船
    
    */
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {

        /*能量武器的射程百分比增加25f的意思是增加25%，游戏计算正数buff是先加再乘积，负数buff是直接乘积，导致加的更多 减的更少
            stats.getEnergyWeaponRangeBonus().modifyPercent(id,25f);
            stats.getEnergyWeaponRangeBonus().modifyMult(id,1.25f); 直接乘积
            stats.getEnergyWeaponRangeBonus().modifyFlat(id,100f);数值加法，加100射程
            stats.getBallisticWeaponRangeBonus().modifyPercent(id,25f);实弹武器
        
            StatBonus类型的方法必须在船生成之前使用
            MutableStat类型的方法可以在两个里面用

            武器武器射程加500
            stats.getEnergyWeaponRangeBonus().modifyFlat(id,500f); //报错了float这个方法 新版改成了modifyFlat
            stats.getBallisticWeaponRangeBonus().modifyFlat(id,500f);
        */


        /*
            BeamWeapon 光束武器
            EnergyWeapon 能量
            BallisticWeapon 实弹
            MissileWeapon 导弹
        */

        /*武器射程+100% 改为增加固定数值
            stats.getEnergyWeaponRangeBonus().modifyPercent(id,n1);
            stats.getBallisticWeaponRangeBonus().modifyPercent(id,n1);
            stats.getMissileWeaponRangeBonus().modifyPercent(id,n1);
        */
        stats.getEnergyWeaponRangeBonus().modifyFlat(id,n2);//+300基础射程
        stats.getBallisticWeaponRangeBonus().modifyFlat(id,n2);
        stats.getMissileWeaponRangeBonus().modifyPercent(id,n2);//导弹+300%射程
        stats.getBeamWeaponRangeBonus().modifyFlat(id,n2);
        
        //增加伤害+100% 能量、光束、实弹、导弹
        stats.getEnergyWeaponDamageMult().modifyPercent(id,n2);
        stats.getBeamWeaponDamageMult().modifyPercent(id,n2);
        stats.getBallisticWeaponDamageMult().modifyPercent(id,n2);
        stats.getMissileWeaponDamageMult().modifyPercent(id,n2);

        //武器幅能消耗-50% 能量、光束、实弹、导弹
        stats.getEnergyWeaponFluxCostMod().modifyPercent(id,n3);
        //stats.getBeamWeaponFluxCostMod().modifyPercent(id,n3);
        stats.getBallisticWeaponFluxCostMod().modifyPercent(id,n3);
        stats.getMissileWeaponFluxCostMod().modifyPercent(id,n3);

        //实弹、能量、导弹武器弹夹容量
        stats.getBallisticAmmoBonus().modifyPercent(id, n2);
		stats.getEnergyAmmoBonus().modifyPercent(id, n2);
        stats.getMissileAmmoBonus().modifyPercent(id, n2);

        //弹丸飞行速度
        stats.getProjectileSpeedMult().modifyPercent(id,n1);

        //炮台转向速度
        stats.getWeaponTurnRateBonus().modifyPercent(id,n1);
        stats.getBeamWeaponTurnRateBonus().modifyPercent(id,n1);

        //导弹速度 加速度，转向速度 转向加速度
        stats.getMissileMaxSpeedBonus().modifyPercent(id,n1);
        stats.getMissileAccelerationBonus().modifyPercent(id,n1);
        stats.getMissileMaxTurnRateBonus().modifyPercent(id,n1);
        stats.getMissileTurnAccelerationBonus().modifyPercent(id,n1);


        stats.getArmorBonus().modifyPercent(id,n1);//装甲值
        stats.getHullBonus().modifyPercent(id,n1);//船体

        stats.getMaxSpeed().modifyFlat(id,n1);//最大速度加100
        stats.getAcceleration().modifyPercent(id,n1);//加速度翻倍
        stats.getDeceleration().modifyPercent(id,n1);//减速度翻倍
        stats.getMaxTurnRate().modifyPercent(id,n1);//转向

        stats.getFluxCapacity().modifyPercent(id,n2);//幅能容量
        stats.getFluxDissipation().modifyPercent(id,n2);//耗散

        //护盾四维
        stats.getShieldUpkeepMult().modifyPercent(id,n3);
        stats.getShieldAbsorptionMult().modifyPercent(id,n3);
        stats.getShieldTurnRateMult().modifyPercent(id,n1);
        stats.getShieldUnfoldRateMult().modifyPercent(id,n1);
        //相位
        stats.getPhaseCloakActivationCostBonus().modifyPercent(id,n3);
        stats.getPhaseCloakUpkeepCostBonus().modifyPercent(id,n3);

        //峰值时间 峰值损失
        stats.getPeakCRDuration().modifyPercent(id,n2);
        stats.getCRLossPerSecondPercent().modifyPercent(id,n3);

        /*  
            伤害
            public MutableStat getBeamWeaponDamageMult();
            public MutableStat getEnergyWeaponDamageMult();
            public MutableStat getBallisticWeaponDamageMult();
            public MutableStat getMissileWeaponDamageMult();
            
            开火的幅能消耗
            public StatBonus getEnergyWeaponFluxCostMod();
            public StatBonus getBallisticWeaponFluxCostMod();
            public StatBonus getMissileWeaponFluxCostMod();
            public MutableStat getBeamWeaponFluxCostMult();
            
            护盾 维持、吸收、转向、开机
            public MutableStat getShieldUpkeepMult();
            public MutableStat getShieldAbsorptionMult();
            public MutableStat getShieldTurnRateMult();
            public MutableStat getShieldUnfoldRateMult();
            
            未知
            public MutableStat getMissileRoFMult();
            public MutableStat getBallisticRoFMult();
            public MutableStat getEnergyRoFMult();
            
            相位 激活、维持
            public StatBonus getPhaseCloakActivationCostBonus();
            public StatBonus getPhaseCloakUpkeepCostBonus();

            射程
            public StatBonus getEnergyWeaponRangeBonus();
            public StatBonus getBallisticWeaponRangeBonus();
            public StatBonus getMissileWeaponRangeBonus();
            public StatBonus getBeamWeaponRangeBonus();

            导弹 最大速度、加速度、转向速度、转向加速度
            public StatBonus getMissileMaxSpeedBonus();
            public StatBonus getMissileAccelerationBonus();
            public StatBonus getMissileMaxTurnRateBonus();
            public StatBonus getMissileTurnAccelerationBonus();

            零幅能 加速、判定（原版是1，开了护盾就不算零幅能，估计要大于维持护盾的幅能数值才能在开盾时获得buff）
            public MutableStat getZeroFluxSpeedBoost();
            public MutableStat getZeroFluxMinimumFluxLevel();
        
        */

	}
}