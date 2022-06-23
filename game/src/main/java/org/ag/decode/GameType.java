package org.ag.decode;

public class GameType {

     public static String GT_ALL = "ALL";
     public static String GT_RACE = "RACE";
     public static String GT_JACKPOT = "JACKPOT";
     public static String GT_EURO = "EURO";
     public static String GT_BRAND = "BRAND";
     public static String GT_BACCARAT = "BAC";
     public static String GT_LBACCARAT = "LBAC";
     public static String GT_TBACCARAT = "TBAC";
     public static String GT_TLBACCARAT3 = "TLBAC3";
     public static String GT_TLBACCARAT4 = "TLBAC4";
     public static String GT_TGBAC = "TGBAC";
     public static String GT_SAFE_BACCARAT = "SBAC";
     public static String GT_TIGER = "DT";
     public static String GT_DICE = "SHB";
     public static String GT_VIP_BACCARAT = "CBAC";
     public static String GT_DISH = "ROU";
     public static String GT_LINK = "LINK";
     public static String GT_TEB = "TEB";
     public static String GT_NN = "NN";
     public static String GT_BF = "BF";
     public static String GT_ZJH = "ZJH";
     public static String GT_BZMW = "BZMW";
     public static String GT_SHARK = "SHARK";
     public static String GT_FOREST = "FOREST";
     public static String GT_CSD = "CSD";
     public static String GT_REDBLACK = "REDBLACK";
     public static String GT_DYZG = "DYZG";
     public static String GT_DYTZ = "DYTZ";
     public static String GT_DYBR = "DYBR";
     public static String GT_DYDZ = "DYDZ";

    public static boolean isBAC(String gameType){
        return GT_BACCARAT.equals(gameType)
                || GT_VIP_BACCARAT.equals(gameType)
                || GT_SAFE_BACCARAT.equals(gameType)
                || GT_TBACCARAT.equals(gameType)
                || GT_LBACCARAT.equals(gameType)
                || GT_TLBACCARAT3.equals(gameType)
                || GT_TLBACCARAT4.equals(gameType)
                || GT_TGBAC.equals(gameType)
                || GT_LINK.equals(gameType);
    }
}
