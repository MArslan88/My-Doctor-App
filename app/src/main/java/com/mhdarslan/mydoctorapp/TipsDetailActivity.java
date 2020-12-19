package com.mhdarslan.mydoctorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TipsDetailActivity extends AppCompatActivity {

    private int positionTips;
    private TextView healthTipsHeadingTxt, tipsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_detail);

        // Title of the Activity
        getSupportActionBar().setTitle("Health Tips");

        // get Intent position data from the previous Activity
        Intent intent = getIntent();
        positionTips = intent.getIntExtra("position",0);

        // Initialization
        healthTipsHeadingTxt = findViewById(R.id.healthTipsHeadingTxt);
        tipsText = findViewById(R.id.tipsText);

        // Health Tips Array
        String[] tipsArr = {
                "•\tEat three healthy meals a day (breakfast, lunch, and dinner); it is important to remember that dinner does not have to be the largest meal.\n" +
                        "•\tThe bulk of food consumption should consist of healthy foods, such as fruits, vegetables, whole grains, and fat-free or low-fat milk products.\n" +
                        "•\tIncorporate lean meats, poultry, fish, beans, eggs, and nuts (with emphasis on beans and nuts) into a healthy diet.\n" +
                        "•\tChoose foods that are low in saturated fats, trans fats, cholesterol, salt (sodium), and added sugars; look at the labels because the first listed items on the labels comprise the highest concentrations of ingredients.\n" +
                        "•\tControl portion sizes; eat the smallest portion that can satisfy hunger and then stop eating.\n" +
                        "•\tHealthy snacks are OK in moderation and should consist of items like fruit, whole grains, or nuts to satisfy hunger and not cause excessive weight gain.\n" +
                        "•\tAvoid sodas and sugar-enhanced drinks because of the excessive calories in the sodas and sugar drinks; diet drinks may not be a good choice as they make some people hungrier and increase food consumption.\n" +
                        "•\tAvoid eating a large meal before sleeping to decrease gastro esophageal reflux and weight gain.\n" +
                        "•\tIf a person is angry or depressed, eating will not solve these situations and may make the underlying problems worse.\n" +
                        "•\tAvoid rewarding children with sugary snacks; such a pattern may become a lifelong habit for people.\n" +
                        "•\tAvoid heavy meals in the summer months, especially during hot days.\n" +
                        "•\tA vegetarian lifestyle has been promoted for a healthy lifestyle and weight loss; vegetarians should check with their physicians to be sure they are getting enough vitamins, minerals, and iron in their diet.\n" +
                        "•\tCooking foods (above 165 F) destroys most harmful bacteria and other pathogens; if you choose to eat uncooked foods like fruits or vegetables, they should be thoroughly washed with running treated (safe to drink) tap water right before eating.\n",

                "•\tPeople with diabetes should use the above tips and monitor their glucose levels as directed; try to keep the daily blood glucose levels as close to normal as possible.\n" +
                        "•\tPeople with unusual work schedules (night shifts, college students, military) should try to adhere to a breakfast, lunch, and dinner routine with minimal snacking.\n" +
                        "•\tPeople who prepare food should avoid using grease or frying foods in grease.\n" +
                        "•\tPeople trying to lose weight (body fat) should avoid all fatty and sugary foods and eat mainly vegetables, fruits, and nuts and markedly reduce his/her intake of meat and dairy products.\n" +
                        "•\tSeek medical advice early if you cannot control your weight, food intake, or if you have diabetes and cannot control your blood glucose levels.\n" +
                        "•\tExercise can be broken up into smaller 10-minute sessions\n" +
                        "•\tRegular exercise can help control body weight and in some people cause loss of fat\n",

                "•\tPhysical inactivity and lack of exercise are associated with heart disease and some cancers\n" +
                        "•\tPhysical inactivity and lack of exercise are associated with type II diabetes mellitus\n" +
                        "•\tPhysical inactivity and lack of exercise contribute to weight gain\n",

                "•\tGet enough sleep daily\n" +
                        "•\tDo some mind exercises (read, do a puzzle occasionally during the week).\n" +
                        "•\tHave a network of friends\n" +
                        "•\tSeek help and advice early if you feel depressed.\n",

                "•\tDriving while sleep-deprived\n" +
                        "•\tSmoking in bed\n" +
                        "•\tPossession of firearms and guns without proper training and storage\n",

                "•\tGreek Yogurt: Greek yogurt has almost twice as much protein as other yogurts, burn more calories digesting protein than carbs. Choose nonfat, low-fat, and low-sugar types.\n" +
                        "•\tQuinoa:  is a nutritional all-star that belongs in your weight loss plan. This whole grain has 8 grams of hunger-busting protein and 5 grams of fiber in one cup, and you'll also get iron, zinc, selenium, and vitamin E. Quinoa is as easy to cook as rice. For a quick dinner, mix in some vegetables, nuts, or lean protein.\n" +
                        "•\tCinnamon: stabilizing effect on blood sugar levels. This could curb your appetite, particularly in people with type 2 diabetes. Nearly everyone can benefit from cinnamon in its traditional role. Stir some into your coffee, tea, or yogurt to add sweetness without adding calories.\n" +
                        "•\tHot Peppers: Hot peppers have a flavorless chemical called capsaicin. It's more plentiful in habaneros, but jalapeños also have it\n" +
                        "•\tGreen Tea: weight loss by stimulating the body to burn fat.\n" +
                        "•\tGrapefruit: Grapefruit doesn't have any magical fat-burning properties, but it can help you feel full with fewer calories.\n" +
                        "•\tWatermelon: It's a good source of the antioxidant lycopene and gives you some vitamin A and C.\n" +
                        "•\tPears and Apples: are also high in water content. Eat them with the peels for extra fiber.\n" +
                        "•\tGrapes vs. Raisins: Compare 2 cups of grapes to 1/4 cup of raisins. Either choice has a little more than 100 calories, but you'll probably be more satisfied with the grapes.\n" +
                        "•\tBerries: are high in water and fiber, which can keep you full longer. They're also sweet.\n" +
                        "•\tRaw Vegetables: make an outstanding snack. They satisfy the desire to crunch, they're full of water to help you feel full, and they're low in calories.\n" +
                        "•\tSweet Potatoes: are packed with potassium, beta-carotene, vitamin C, and fiber. And save you loads of calories.\n" +
                        "•\tEggs: has only 75 calories, plus 7 grams of protein along with other vital nutrients.\n" +
                        "•\tCoffee: help you lose weight. Coffee does stimulate the metabolism.\n" +
                        "•\tOatmeal: has three things going for it: fiber-rich whole-grain oats, lots of water, and it's hot. \n" +
                        "•\tCrisp breads: offer a low-fat, fiber-packed alternative to traditional crackers, less belly fat \n" +
                        "•\tTabouli:  It's high in fiber and protein but low in fat and calories. That helps you fill up with a minimum of calories.\n" +
                        "•\tSoup: It's full of water, which fills you up with the fewest possible calories. It's hot, which prevents you from eating too much.\n" +
                        "•\tSalad: fill up before a meal is by eating salad. Lettuce has plenty of water content to take up space in the stomach. \n" +
                        "•\tSkim Milk: provides plenty of protein, calcium, and vitamin D with none of the fat found in whole milk.\n" +
                        "•\tFish: One of the best sources of protein is fish. Most fish is low in fat, and the exceptions usually have a good form of fat: omega-3 fatty acids. Omega-3s, which are found in salmon, herring, and other fatty fish, may help protect against heart disease and other chronic conditions.\n" +
                        "•\tBeans: are a vegetable, a protein, and a great source of fiber. You feel full for very few calories.\n"
        };

        healthTipsHeadingTxt.setText(HealthTipsActivity.headings[positionTips]);
        tipsText.setText(tipsArr[positionTips]);
    }
}