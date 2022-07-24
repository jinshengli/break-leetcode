package weeken.w303;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class FoodRatings {

    static class Food {
        String food;
        String cuisine;
        int rating;
        public Food(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    HashMap<String, Food> foodMap = new HashMap<>();
    HashMap<String, TreeSet<Food>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; ++i) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            TreeSet<Food> orDefault = cuisineMap.getOrDefault(cuisines[i], new TreeSet<>(((o1, o2) -> {
                if (o1.rating == o2.rating) {
                    return o1.food.compareTo(o2.food);
                }
                return o2.rating - o1.rating;
            })));
            orDefault.add(food);
            cuisineMap.put(cuisines[i], orDefault);
        }
    }
    public void changeRating(String food, int newRating) {
        if (foodMap.containsKey(food)) {
            Food foodNode = foodMap.get(food);
            cuisineMap.get(foodNode.cuisine).remove(foodNode);
            foodMap.remove(food);
            Food food1 = new Food(foodNode.food, foodNode.cuisine, newRating);
            foodMap.put(food, food1);
            cuisineMap.get(food1.cuisine).add(food1);
        }
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().food;
    }

    public static void main(String[] args) {
//        String[] foods = new String[] {"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"};
//        String[] cuisines = new String[]{"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"};
//        int[] ratings = new int[]{2,6,1,6,5};
//        FoodRatings test = new FoodRatings(foods, cuisines, ratings);
//        test.changeRating("qnvseohnoe", 12);
//
//        String asn = test.highestRated("snaxol");
//        System.out.println(asn);
        TreeSet<Food> set = new TreeSet<>(((o1, o2) -> {
            if (o1.rating == o2.rating) {
                return o1.food.compareTo(o2.food);
            }
            return o2.rating - o1.rating;
        }));
        Food e = new Food("a1", "a", 1);
        Food e1 = new Food("a2", "a", 2);
        Food e2 = new Food("a3", "a", 3);
        Food e3 = new Food("a4", "a", 4);
        set.add(e);
        set.add(e1);
        set.add(e2);
        set.add(e3);

        // todo TreeSet 加入一个引用对象之后，你改变比较器中关联的对象。比较的大小顺序不会发生改变
        e1.rating = 100;

        // set.add(e1);

        System.out.println(set);
    }
}
