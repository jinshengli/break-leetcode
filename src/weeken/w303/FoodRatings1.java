package weeken.w303;


import java.util.*;

/**
 * 设计一个支持下述操作的食物评分系统：
 *
 * 修改 系统中列出的某种食物的评分。
 * 返回系统中某一类烹饪方式下评分最高的食物。
 * 实现 FoodRatings 类：
 *
 * FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
 * foods[i] 是第 i 种食物的名字。
 * cuisines[i] 是第 i 种食物的烹饪方式。
 * ratings[i] 是第 i 种食物的最初评分。
 * void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
 * String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
 * 注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
 *
 *  ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
 * [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
 * 输出
 * [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
 *
 *  food -》 rating
 *  food -> cuisiones
 *  cuisine -> rating 最高评分 有几个
 *          --》 <rating, <food,food>>
 *
 *
 */
class FoodRatings1 {
    HashMap<String, String> foodToCuisinesMap = new HashMap<>();
    HashMap<String, Integer> foodToRatingsMap = new HashMap<>();
    HashMap<String, TreeMap<Integer, TreeSet<String>>> cuisineToRatingMap = new HashMap<>();
    public FoodRatings1(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; ++i) {
            foodToCuisinesMap.put(foods[i], cuisines[i]);
            foodToRatingsMap.put(foods[i], ratings[i]);
            TreeMap<Integer, TreeSet<String>> orDefault = cuisineToRatingMap.getOrDefault(cuisines[i], new TreeMap<>((o1, o2) -> o2 - o1));
            TreeSet<String> defaultFoodSet = orDefault.getOrDefault(ratings[i], new TreeSet<>());
            defaultFoodSet.add(foods[i]);
            cuisineToRatingMap.put(cuisines[i], orDefault);
            orDefault.put(ratings[i], defaultFoodSet);
        }
    }

    public void changeRating(String food, int newRating) {
        Integer oldRating = foodToRatingsMap.get(food);
        if (oldRating == null) {
            return;
        }
        String cuisines = foodToCuisinesMap.get(food);
        foodToRatingsMap.put(food, newRating);
        TreeMap<Integer, TreeSet<String>> rateMap = cuisineToRatingMap.get(cuisines);

        TreeSet<String> foodSet = rateMap.get(oldRating);
        foodSet.remove(food);
        if (foodSet.isEmpty()) {
            rateMap.remove(oldRating);
        }

        TreeSet<String> orDefault = rateMap.getOrDefault(newRating, new TreeSet<>());
        orDefault.add(food);
        rateMap.put(newRating, orDefault);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> rateMap = cuisineToRatingMap.get(cuisine);
        return rateMap.firstEntry().getValue().first();
    }

    public static void main(String[] args) {
        String[] foods = new String[] {"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"};
        String[] cuisines = new String[]{"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"};
        int[] ratings = new int[]{2,6,18,6,5};
        FoodRatings1 test = new FoodRatings1(foods, cuisines, ratings);
        test.changeRating("qnvseohnoe", 11);

        String asn = test.highestRated("fajbervsj");
        System.out.println(asn);


        System.out.println("jmvfxjohq".compareTo("yhptazyko"));

    }

}